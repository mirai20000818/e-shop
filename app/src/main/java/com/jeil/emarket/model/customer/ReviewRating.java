package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ReviewRating {

    @SerializedName("ratingAvg")
    @Expose
    public float ratingAvg;

    @SerializedName("ratingCount")
    @Expose
    public int ratingCount;

    @SerializedName("reviewsCount")
    @Expose
    public int[] reviewsCount;
}
