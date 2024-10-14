package com.neyamul.healthcare;

public class CartItem {
    private String username;
    private String product;
    private float price;
    private String otype;

    public CartItem(String username, String product, float price, String otype) {
        this.username = username;
        this.product = product;
        this.price = price;
        this.otype = otype;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public String getProduct() { return product; }
    public float getPrice() { return price; }
    public String getOtype() { return otype; }
}
