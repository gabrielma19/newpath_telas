package com.example.user.newpath.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jussi on 10/4/17.
 */

public class Products {

    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("name")
    private String name;
    @SerializedName("score")
    private int score;

    public Products() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
