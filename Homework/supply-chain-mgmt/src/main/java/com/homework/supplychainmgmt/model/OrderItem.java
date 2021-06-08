package com.homework.supplychainmgmt.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orderitems")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderId;
    private int itemId;
    private int quantity;
}
