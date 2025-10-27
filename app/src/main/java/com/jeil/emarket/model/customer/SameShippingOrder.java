package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class SameShippingOrder {

    @SerializedName("deliveryTime")
    @Expose
    public Date deliveryTime;

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12418id;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("shippingPrice")
    @Expose
    public float shippingPrice;

    @SerializedName("status")
    @Expose
    public String status;
}
