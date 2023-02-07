package com.codeburps.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CB_PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private int paymentId;

    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "AMOUNT")
    private int amount;
}
