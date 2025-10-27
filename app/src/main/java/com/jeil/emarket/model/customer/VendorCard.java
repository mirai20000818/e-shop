package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VendorCard {

    @SerializedName("cardUrl")
    @Expose
    public String cardUrl;

    @SerializedName("logoUrl")
    @Expose
    public String logoUrl;

    @SerializedName("point")
    @Expose
    public int point;
}
