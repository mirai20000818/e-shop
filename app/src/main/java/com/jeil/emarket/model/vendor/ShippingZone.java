package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class ShippingZone {

    @SerializedName("areas")
    @Expose
    public List<String> areas;

    @SerializedName("deliveryTime")
    @Expose
    public int deliveryTime;

    @SerializedName("enableUrgent")
    @Expose
    public boolean enableUrgent;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12446id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("price")
    @Expose
    public float price;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("urgentDeliveryTime")
    @Expose
    public int urgentDeliveryTime;

    @SerializedName("urgentPrice")
    @Expose
    public float urgentPrice;
}
