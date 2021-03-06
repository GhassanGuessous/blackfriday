package com.indev.blackfriday;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private int totalAssets = 0;
    private int stock = 0;
    private boolean blackFriday = false;
    private String salesHistory = "";
    private int quantiteSold = 0;

    private static final int SELL_UNIT = 5;
    private static final float NORMAL_MARGIN = 0.2f;
    private static final int BLACK_FRIDAY_SELL_UNIT = 10;
    private static final float BLACK_FRIDAY_MARGIN = 0.1f;

    /**private Stock stock;

    private void init(){
        stock = new Stock(new ArrayList<Product>());
    }**/

    public float sells(String productName) {
        ProductEnum  product = ProductEnum.getProduct(productName);
        System.out.println(blackFriday ? "B" + BLACK_FRIDAY_MARGIN : "N" + NORMAL_MARGIN);
        int pureSellPrice = product.getPrice() * SELL_UNIT;
        float margin = pureSellPrice * NORMAL_MARGIN;
        int sellPrice = (int) (pureSellPrice + margin);
        quantiteSold += 5;
        salesHistory = quantiteSold + ":capsules";
        editSalesRevenue((int) margin);

        return sellPrice;
    }

    public void editSalesRevenue(int margin){
        stock -= SELL_UNIT;
        totalAssets += margin;
    }

    public void stock(int quantite, String name, int price) {
        /**if(stock == null)
            init();
        for (int j = 0; j < qte; j++) {
            Product product = new Product(name, price);
            stock.getProducts().add(product);
        }*/
        stock = quantite;
        totalAssets += price * quantite;
        System.out.println("totalAssets " + totalAssets);
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
        blackFriday = true;
        return this;
    }

    public Object salesHistory() {
        return salesHistory;
    }
}
