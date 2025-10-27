package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;


public class ChartProduct {

    @SerializedName("categoryId")
    @Expose
    public int categoryId;

    @SerializedName("earning")
    @Expose
    public float earning;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12433id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderTotal")
    @Expose
    public SubOrder.TotalAmount orderTotal;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("sold")
    @Expose
    public int sold;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("views")
    @Expose
    public int views;
}
