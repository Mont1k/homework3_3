package com.example.homework3_3;


public class Item {
    private final String text;
    private final String imageResId;

    public Item(String text, String imageResId) {
        this.text = text;
        this.imageResId = imageResId;

    }

    public String getText() {
        return text;
    }

    public String getImageResId() {
        return imageResId;
    }
}