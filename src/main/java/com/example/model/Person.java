package com.example.model;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
    private Address address;

    // Constructor, getters, and setters
}
