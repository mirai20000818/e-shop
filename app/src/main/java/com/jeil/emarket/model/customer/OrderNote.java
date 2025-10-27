package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class OrderNote {

    @SerializedName("custom")
    @Expose
    public String custom;

    @SerializedName("date")
    @Expose
    public Date date;

    @SerializedName("orderId")
    @Expose
    public int orderId;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("vendor")
    @Expose
    public String vendor;
}
