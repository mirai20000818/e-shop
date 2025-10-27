package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.CheckoutVendor;
import java.util.Date;
import java.util.List;


public class SubOrder {

    @SerializedName("canLeaveReview")
    @Expose
    public Boolean canLeaveReview;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("delivery")
    @Expose
    public DeliveryInfo delivery;

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    @SerializedName("enableTicket")
    @Expose
    public Boolean enableTicket;

    @SerializedName("fbts")
    @Expose
    public List<CheckoutVendor.Discounts.Fbt> fbts;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12425id;

    @SerializedName("itemAmount")
    @Expose
    public PriceByCurrency itemAmount;

    @SerializedName("items")
    @Expose
    public List<OrderItem> items;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderCoupon")
    @Expose
    public List<OrderCoupon> orderCoupon;

    @SerializedName("orderId")
    @Expose
    public int orderId;

    @SerializedName("orderStatus")
    @Expose
    public String orderStatus;

    @SerializedName("payAmount")
    @Expose
    public float payAmount;

    @SerializedName("payCurrency")
    @Expose
    public String payCurrency;

    @SerializedName("paymentMethod")
    @Expose
    public String paymentMethod;

    @SerializedName("point")
    @Expose
    public VendorPoint point;

    @SerializedName("shipping")
    @Expose
    public Shipping shipping;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("ticket")
    @Expose
    public String ticket;

    @SerializedName("totalAmount")
    @Expose
    public PriceByCurrency totalAmount;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    public static class DeliveryInfo {

        @SerializedName("delivererName")
        @Expose
        public String delivererName;

        @SerializedName("delivererPhone1")
        @Expose
        public String delivererPhone1;

        @SerializedName("delivererPhone2")
        @Expose
        public String delivererPhone2;

        @SerializedName("deliveryTime")
        @Expose
        public Date deliveryTime;
    }

    public static class OrderCoupon {

        @SerializedName("discounted")
        @Expose
        public PriceByCurrency discounted;

        @SerializedName("display")
        @Expose
        public String display;
    }

    public static class Shipping {

        @SerializedName("method")
        @Expose
        public String method;

        @SerializedName("price")
        @Expose
        public float price;

        @SerializedName("status")
        @Expose
        public int status;
    }

    public static class TotalAmount {

        @SerializedName("kpf")
        @Expose
        public float kpf;

        @SerializedName("kpw")
        @Expose
        public float kpw;
    }

    public static class VendorPoint {

        @SerializedName("delivery")
        @Expose
        public float delivery;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12426id;

        @SerializedName("service")
        @Expose
        public float service;

        @SerializedName("support")
        @Expose
        public float support;

        @SerializedName("vendorId")
        @Expose
        public int vendorId;
    }
}
