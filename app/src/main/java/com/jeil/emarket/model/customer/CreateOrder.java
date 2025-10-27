package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;


public class CreateOrder {

    @SerializedName("deliveryTime")
    @Expose
    public Date deliveryTime;

    @SerializedName("discounts")
    @Expose
    public Discounts discounts;

    @SerializedName("items")
    @Expose
    public List<OrderItem> items;

    @SerializedName("shipping")
    @Expose
    public Shipping shipping;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    public static class OrderItem {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12398id;

        @SerializedName("qty")
        @Expose
        public int qty;
    }

    public static class Shipping {

        @SerializedName("method")
        @Expose
        public String method;

        @SerializedName("methodName")
        @Expose
        public String methodName;

        @SerializedName("price")
        @Expose
        public float price;
    }
}
