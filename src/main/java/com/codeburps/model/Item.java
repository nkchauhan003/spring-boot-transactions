package com.codeburps.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CB_ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int itemId;

    @Column(name = "NAME")
    private int name;

    @Column(name = "QUANTITY")
    private int quantity;
}
