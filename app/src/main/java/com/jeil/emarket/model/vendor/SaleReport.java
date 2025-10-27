package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;


public class SaleReport {

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12445id;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderTotal")
    @Expose
    public SubOrder.TotalAmount orderTotal;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("sold")
    @Expose
    public int sold;

    @SerializedName("type")
    @Expose
    public String type;
}
