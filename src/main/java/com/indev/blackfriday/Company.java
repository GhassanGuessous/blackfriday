package com.indev.blackfriday;

import java.util.ArrayList;

public class Company {

    private int totalAssets = 0;
    private int stock = 0;
    private static final int SELL_UNIT = 5;
    private static final float NORMAL_MARGIN = 0.2f;

    /**private Stock stock;

    private void init(){
        stock = new Stock(new ArrayList<Product>());
    }**/

    public float sells(String productName) {
        ProductEnum  product = ProductEnum.getProduct(productName);

        int pureSellPrice = product.getPrice() * SELL_UNIT;
        float margin = pureSellPrice * NORMAL_MARGIN;
        int sellPrice = (int) (pureSellPrice + margin);

        stock -= SELL_UNIT;
        totalAssets -= pureSellPrice;
        totalAssets += sellPrice;

        return sellPrice;
    }

    public void stock(int quantite, String name, int price) {
        /**if(stock == null)
            init();
        for (int j = 0; j < qte; j++) {
            Product product = new Product(name, price);
            stock.getProducts().add(product);
        }*/
        this.stock = quantite;
        totalAssets += price * quantite;
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {
        /**int total = 0;
        for (Product p: this.stock.getProducts()
             ) {
           total += p.getPrice();
        }
        totalAssets = total;**/
        return totalAssets;
    }

    public Company blackFriday() {
        return this;
    }
}
