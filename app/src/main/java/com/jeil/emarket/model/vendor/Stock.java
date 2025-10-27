package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Stock {

    @SerializedName("categoryId")
    @Expose
    public int categoryId;

    @SerializedName("categoryName")
    @Expose
    public String categoryName;

    @SerializedName("editSku")
    @Expose
    public String editSku;

    @SerializedName("editStock")
    @Expose
    public String editStock;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12448id;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("parent")
    @Expose
    public String parent;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("stockMode")
    @Expose
    public String stockMode;

    @SerializedName("type")
    @Expose
    public String type;
}
