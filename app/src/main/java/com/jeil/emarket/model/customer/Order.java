package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class Order {

    @SerializedName("orderCreatedAt")
    @Expose
    public Date orderCreatedAt;

    @SerializedName("orderId")
    @Expose
    public int orderId;

    @SerializedName("orderProductCount")
    @Expose
    public int orderProductCount;

    @SerializedName("orderStatus")
    @Expose
    public String orderStatus;

    @SerializedName("orderTotalKpf")
    @Expose
    public float orderTotalKpf;

    @SerializedName("orderTotalKpw")
    @Expose
    public float orderTotalKpw;

    @SerializedName("orderTotalOldKpf")
    @Expose
    public float orderTotalOldKpf;

    @SerializedName("orderTotalOldKpw")
    @Expose
    public float orderTotalOldKpw;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("shippingPrice")
    @Expose
    public float shippingPrice;

    @SerializedName("type")
    @Expose
    public String type;
}
