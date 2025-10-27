package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ProductDetail {

    @SerializedName("categoryPhone")
    @Expose
    public List<CategoryPhone> categoryPhone;

    @SerializedName("contactPhone")
    @Expose
    public String contactPhone;

    @SerializedName("data")
    @Expose
    public Product data;

    @SerializedName("faqsTotalCount")
    @Expose
    public int faqsTotalCount;

    @SerializedName("fbts")
    @Expose
    public List<Fbt> fbts;

    @SerializedName("vendorInfo")
    @Expose
    public VendorInfo vendorInfo;

    public static class CategoryPhone {

        @SerializedName("name")
        @Expose
        public List<String> name;

        @SerializedName("value")
        @Expose
        public List<String> value;
    }

    public class Fbt {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12412id;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("products")
        @Expose
        public List<Product> products;

        public class Product {

            @SerializedName("cartProduct")
            @Expose
            public com.jeil.emarket.model.customer.Product.VariableProduct cartProduct;

            @SerializedName("currency")
            @Expose
            public String currency;

            @SerializedName("customAttributes")
            @Expose
            public List<com.jeil.emarket.model.customer.Product.CustomAttribute> customAttributes;

            @SerializedName("discount")
            @Expose
            public float discount;

            /* renamed from: id */
            @SerializedName("id")
            @Expose
            public int f12413id;

            @SerializedName("image")
            @Expose
            public String image;

            @SerializedName("isChecked")
            @Expose
            public boolean isChecked;

            @SerializedName("name")
            @Expose
            public String name;

            @SerializedName("minPrice")
            @Expose
            public float price;

            @SerializedName("sku")
            @Expose
            public String sku;

            @SerializedName("stock")
            @Expose
            public int stock;

            @SerializedName("variableAttributes")
            @Expose
            public List<com.jeil.emarket.model.customer.Product.VariableAttribute> variableAttributes;

            @SerializedName("variableProducts")
            @Expose
            public List<com.jeil.emarket.model.customer.Product.VariableProduct> variableProducts;

            public Product() {
            }
        }

        public Fbt() {
        }
    }

    public static class VendorInfo {

        @SerializedName("createdAt")
        @Expose
        public String createdAt;

        @SerializedName("delivery")
        @Expose
        public Float delivery;

        @SerializedName("enableTicket")
        @Expose
        public boolean enableTicket;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12414id;

        @SerializedName("level")
        @Expose
        public int level;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("phone")
        @Expose
        public String phone;

        @SerializedName("phone1")
        @Expose
        public String phone1;

        @SerializedName("phone2")
        @Expose
        public String phone2;

        @SerializedName("refundService")
        @Expose
        public String refundService;

        @SerializedName("service")
        @Expose
        public Float service;

        @SerializedName("support")
        @Expose
        public Float support;
    }
}
