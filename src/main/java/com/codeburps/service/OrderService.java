package com.codeburps.service;

import com.codeburps.dto.OrderDto;
import com.codeburps.model.Order;

public interface OrderService {
    void addOrder(OrderDto order);
}
