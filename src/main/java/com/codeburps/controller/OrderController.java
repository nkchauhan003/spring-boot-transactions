package com.codeburps.controller;

import com.codeburps.dto.OrderDto;
import com.codeburps.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public void addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }
}
