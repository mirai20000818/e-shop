package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class Product {

    @SerializedName("categoryId")
    @Expose
    public int categoryId;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("image")
    @Expose
    public Image image;

    @SerializedName("isFeatured")
    @Expose
    public boolean isFeatured;

    @SerializedName("isSelected")
    @Expose
    public boolean isSelected;

    @SerializedName("maxPrice")
    @Expose
    public float maxPrice;

    @SerializedName("minPrice")
    @Expose
    public float minPrice;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("parent")
    @Expose
    public int parent;

    @SerializedName("productId")
    @Expose
    public int productId;

    @SerializedName("productType")
    @Expose
    public String productType;

    @SerializedName("publishStatus")
    @Expose
    public String publishStatus;

    @SerializedName("regularPrice")
    @Expose
    public float regularPrice;

    @SerializedName("salePrice")
    @Expose
    public float salePrice;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("thirdCategory")
    @Expose
    public String thirdCategory;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("updatedAt")
    @Expose
    public Date updatedAt;

    public static class Image {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12441id;

        @SerializedName("url")
        @Expose
        public String url;
    }
}
