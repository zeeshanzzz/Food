package com.example.khan.food.Model;

public class Category {
    private String Name;
    private  String Image;

    public Category() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image_url) {
        Image = image_url;
    }
}
