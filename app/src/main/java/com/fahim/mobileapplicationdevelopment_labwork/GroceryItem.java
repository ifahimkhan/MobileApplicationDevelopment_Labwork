package com.fahim.mobileapplicationdevelopment_labwork;

public class GroceryItem {
    private String name;
    private int images;

    public GroceryItem(String name, int images) {
        this.name = name;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public int getImages() {
        return images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
