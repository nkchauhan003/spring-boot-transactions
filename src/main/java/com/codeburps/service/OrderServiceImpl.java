package com.codeburps.service;

import com.codeburps.dto.ItemDto;
import com.codeburps.dto.OrderDto;
import com.codeburps.exception.InsufficientFundException;
import com.codeburps.exception.ItemNotAvailableException;
import com.codeburps.exception.UserNotFoundException;
import com.codeburps.model.Item;
import com.codeburps.model.Order;
import com.codeburps.repository.ItemRepository;
import com.codeburps.repository.OrderRepository;
import com.codeburps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void addOrder(OrderDto order) {
        var orderItems = order.getItems();
        var orderItemsIds = orderItems.stream().map(ItemDto::getItemId).collect(Collectors.toSet());

        // get order items from db
        var dbItems = itemRepository.findByIdIn(orderItemsIds);
        var dbItemsMap = dbItems.stream().collect(
                Collectors.toMap(Item::getItemId, item -> item));

        // check if items are available and calculate order value
        double orderValue = 0;
        for (var orderItem : orderItems) {
            var dbItem = dbItemsMap.get(orderItem.getItemId());
            if (dbItem == null && dbItem.getAvailableQuantity() < orderItem.getQuantity())
                throw new ItemNotAvailableException(dbItem.getItemId());
            orderValue += orderItem.getQuantity() * dbItem.getPrice();

            // update available items
            itemRepository.updateAvailableQuantity(
                    dbItem.getItemId(), dbItem.getAvailableQuantity() - orderItem.getQuantity());
        }

        // get user details from db
        var user = userRepository.findById(order.getUserId()).orElseThrow(
                () -> new UserNotFoundException(order.getUserId()));

        // check if user has required credit in its wallet
        if (user.getWalletAmount() < orderValue)
            throw new InsufficientFundException();

        // deduct payment
        userRepository.updateWalletAmount(user.getUserId(), user.getWalletAmount() - orderValue);

        // place order
        orderRepository.save(new Order(user, dbItems, orderValue));
    }
}
