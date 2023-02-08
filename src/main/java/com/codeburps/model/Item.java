package com.codeburps.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CB_ITEM")
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int itemId;

    @Column(name = "NAME")
    private int name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "AVAILABLE_QUANTITY")
    private int availableQuantity;
}
