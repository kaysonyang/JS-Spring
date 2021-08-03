package com.kaysom.test.bean;

import lombok.ToString;

@ToString
public class ProductService {

    private String name;

    public ProductService() {
    }

    public ProductService(String name) {
        this.name = name;
    }

    public String getProductName() {
        String item = "water";
        return item;
    }
}
