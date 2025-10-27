package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OrderStatus {

    @SerializedName("count")
    @Expose
    public int count;

    @SerializedName("status")
    @Expose
    public String status;
}
