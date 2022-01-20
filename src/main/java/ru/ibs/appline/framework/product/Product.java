package ru.ibs.appline.framework.product;

import java.util.ArrayList;

public class Product {
    String name;
    int price;
    String warranty;

    public static ArrayList<Product> list = new ArrayList<>();

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.warranty = "Гарантия отсутсвует";
    }

    public Product(String name, int price, String warranty) {
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    public String getWarranty() {
        return warranty;
    }
}
