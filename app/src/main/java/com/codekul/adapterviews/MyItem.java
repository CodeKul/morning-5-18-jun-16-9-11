package com.codekul.adapterviews;

/**
 * Created by aniruddha on 4/7/16.
 */
public class MyItem {

    private int imageId;
    private String text;

    public MyItem(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
