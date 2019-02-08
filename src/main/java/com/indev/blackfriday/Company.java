package com.indev.blackfriday;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private Stock stock = new Stock(new ArrayList<Product>());

    public float sells(String capsule) {
        return 0;
    }

    public void stock(int price, String name, int qte) {
        for (int j = 0; j < qte; j++) {
            Product product = new Product(name, price);
            stock.getProducts().add(product);
        }
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {
        int total = 0;
        for (Product p: this.stock.getProducts()
             ) {
           total += p.getPrice();
        }
        return total;
    }

    public Company blackFriday() {
        return this;
    }
}
