package com.homework.supplychainmgmt.model;

import lombok.Data;

@Data
public class Address {

    private int id;
    private String street;
    private String city;
    private String country;
    private String phoneNumber;
}
