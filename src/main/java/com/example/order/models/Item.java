package com.example.order.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    public String itemId;
    public String name;

    @JsonProperty("quantity")  // 🛠 Match JSON field
    public int qty;

    public double price;

    public Item() {}

    public Item(String itemId, String name, int qty, double price) {
        this.itemId = itemId;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}
