package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ChartStock {

    @SerializedName("categoryId")
    @Expose
    public int categoryId;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12434id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderTotal")
    @Expose
    public float orderTotal;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("productsSold")
    @Expose
    public int productsSold;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("type")
    @Expose
    public String type;
}
