package com.indev.blackfriday;

public enum ProductEnum {

    CAPSULE("capsule", 2),
    MACHINE("machine", 100);

    private String name;
    private int price;

    ProductEnum(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static ProductEnum getProduct(String name){
        switch(name){
            case "capsule": return CAPSULE;
            case "machine": return MACHINE;
            default: return null;
        }
    }

    public int getPrice() {
        return price;
    }
}
