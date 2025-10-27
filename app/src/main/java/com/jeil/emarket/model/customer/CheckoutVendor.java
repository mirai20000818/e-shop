package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class CheckoutVendor {

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("discounts")
    @Expose
    public Discounts discounts;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12394id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("products")
    @Expose
    public List<Product> products;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("shippingMethods")
    @Expose
    public List<ShippingMethod> shippingMethods;

    public static class Discounts {

        @SerializedName("fbts")
        @Expose
        public Fbts fbts;

        public static class Fbt {

            @SerializedName("count")
            @Expose
            public int count;

            /* renamed from: id */
            @SerializedName("id")
            @Expose
            public int f12395id;

            @SerializedName("products")
            @Expose
            public List<FbtProduct> products;

            @SerializedName("total")
            @Expose
            public PriceByCurrency total;
        }

        public static class FbtProduct {

            @SerializedName("currency")
            @Expose
            public String currency;

            @SerializedName("discount")
            @Expose
            public float discount;

            /* renamed from: id */
            @SerializedName("id")
            @Expose
            public int f12396id;

            @SerializedName("image")
            @Expose
            public String image;

            @SerializedName("name")
            @Expose
            public String name;

            @SerializedName("parent")
            @Expose
            public int parent;

            @SerializedName("price")
            @Expose
            public float price;

            @SerializedName("productId")
            @Expose
            public int productId;

            @SerializedName("productImg")
            @Expose
            public String productImg;

            @SerializedName("regularPrice")
            @Expose
            public float regularPrice;

            @SerializedName("salePrice")
            @Expose
            public float salePrice;
        }

        public static class Fbts {

            @SerializedName("items")
            @Expose
            public List<Fbt> items;

            @SerializedName("total")
            @Expose
            public PriceByCurrency total;
        }
    }

    public static class Product {

        @SerializedName("canShipping")
        @Expose
        public boolean canShipping;

        @SerializedName("currency")
        @Expose
        public String currency;

        @SerializedName("discountPriceKpf")
        @Expose
        public float discountPriceKpf;

        @SerializedName("discountPriceKpw")
        @Expose
        public float discountPriceKpw;

        @SerializedName("discountRate")
        @Expose
        public float discountRate;

        @SerializedName("discountType")
        @Expose
        public String discountType;

        @SerializedName("enableBackOrder")
        @Expose
        public boolean enableBackOrder;

        @SerializedName("guaranteeDays")
        @Expose
        public int guaranteeDays;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12397id;

        @SerializedName("image")
        @Expose
        public String image;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("parent")
        @Expose
        public int parent;

        @SerializedName("priceKpf")
        @Expose
        public float priceKpf;

        @SerializedName("priceKpw")
        @Expose
        public float priceKpw;

        @SerializedName("products")
        @Expose
        public List<Discounts.FbtProduct> products;

        @SerializedName("qty")
        @Expose
        public int qty;

        @SerializedName("regularPrice")
        @Expose
        public float regularPrice;

        @SerializedName("salePrice")
        @Expose
        public float salePrice;

        @SerializedName("stock")
        @Expose
        public int stock;
    }

    public static class ShippingMethod {

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("price")
        @Expose
        public float price;

        @SerializedName("time")
        @Expose
        public int time;

        @SerializedName("value")
        @Expose
        public String value;
    }
}
