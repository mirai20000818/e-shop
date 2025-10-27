package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class FBT {

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12436id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("products")
    @Expose
    public List<Product> products;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    public static class Product {

        @SerializedName("currency")
        @Expose
        public String currency;

        @SerializedName("discount")
        @Expose
        public float discount;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12437id;

        @SerializedName("image")
        @Expose
        public String image;

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

        @SerializedName("price")
        @Expose
        public float price;

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
}
