package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Avatar {

    @SerializedName("cur")
    @Expose
    public boolean cur;

    @SerializedName("url")
    @Expose
    public String url;
}
