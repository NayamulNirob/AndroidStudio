package com.nayamul.realestate.Domin;

import java.io.Serializable;

public class ItemsDomin implements Serializable {

    private String title;
    private String address;

    private String description;
    private int bed;

    private int bath;
    private int price;
    private String pic;
    private boolean wifi;


    public ItemsDomin(String title, String address, String description, int bed, int bath, int price, String pic, boolean wifi) {
        this.title = title;
        this.address = address;
        this.description = description;
        this.bed = bed;
        this.bath = bath;
        this.price = price;
        this.pic = pic;
        this.wifi = wifi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
