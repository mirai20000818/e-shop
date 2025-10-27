package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class SaleProduct {

    @SerializedName("costPrice")
    @Expose
    public float costPrice;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("discountPercent")
    @Expose
    public float discountPercent;

    @SerializedName("discountPrice")
    @Expose
    public float discountPrice;

    @SerializedName("endDate")
    @Expose
    public Date endDate;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12443id;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("maxCostPrice")
    @Expose
    public float maxCostPrice;

    @SerializedName("minCostPrice")
    @Expose
    public float minCostPrice;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("productId")
    @Expose
    public int productId;

    @SerializedName("regularPrice")
    @Expose
    public float regularPrice;

    @SerializedName("salePrice")
    @Expose
    public float salePrice;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("startDate")
    @Expose
    public Date startDate;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("today")
    @Expose
    public Date today;

    @SerializedName("type")
    @Expose
    public String type;
}
