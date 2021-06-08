package com.homework.supplychainmgmt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int clientId;
    private int manufacturerId;
    private int addressId;
    private String status;



}
