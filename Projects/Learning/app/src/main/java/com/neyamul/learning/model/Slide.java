package com.neyamul.learning.model;

public class Slide {

    private int Id;

    private String title;

    private String image;


    public Slide() {
    }

    public Slide(int id, String title, String image) {
        Id = id;
        this.title = title;
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
