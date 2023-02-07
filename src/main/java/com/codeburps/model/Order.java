package com.codeburps.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CB_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    // One to many unidirectional mapping
    // Default fetch type for OneToMany: LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ORDER_ITEMS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private Set<Item> items;

    @Column(name = "VALUE")
    private double value;
}
