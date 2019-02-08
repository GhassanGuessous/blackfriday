package com.indev.blackfriday;

import java.util.List;

public class Stock {

    private List<Product> products;

    public Stock(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
