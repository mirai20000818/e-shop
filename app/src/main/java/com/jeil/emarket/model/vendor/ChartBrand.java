package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ChartBrand {

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12430id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderTotal")
    @Expose
    public float orderTotal;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("products")
    @Expose
    public int products;

    @SerializedName("productsSold")
    @Expose
    public int productsSold;
}
