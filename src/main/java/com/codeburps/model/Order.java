package com.codeburps.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Set;

public class Order {
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    private Set<Item> items;
    private double value;
}
