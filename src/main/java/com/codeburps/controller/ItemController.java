package com.codeburps.controller;

import com.codeburps.dto.ItemDto;
import com.codeburps.model.Item;
import com.codeburps.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/")
    public Item addItem(@RequestBody ItemDto itemDto) {
        return itemRepository.save(new Item(itemDto.getName(), itemDto.getPrice(), itemDto.getAvailableQuantity()));
    }
}
