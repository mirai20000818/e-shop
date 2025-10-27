package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Help {

    @SerializedName("isLink")
    @Expose
    public boolean isLink;

    @SerializedName("text")
    @Expose
    public String text;
}
