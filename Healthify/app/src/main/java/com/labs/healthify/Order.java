package com.labs.healthify;

public class Order {
    private String username;
    private String name;
    private String address;
    private String connum;
    private int pin;
    private String date;
    private String time;
    private float amount;
    private String otype;

    public Order(String username, String name, String address, String connum, int pin, String date, String time, float amount, String otype) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.connum = connum;
        this.pin = pin;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.otype = otype;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getConnum() { return connum; }
    public int getPin() { return pin; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public float getAmount() { return amount; }
    public String getOtype() { return otype; }
}
