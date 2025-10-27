package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.OrderDetail;
import java.util.Date;
import java.util.List;


public class VendorOrder {

    @SerializedName("cancelledReason")
    @Expose
    public List<CancelledReason> cancelledReason;

    @SerializedName("completedAt")
    @Expose
    public Date completedAt;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("customerFullname")
    @Expose
    public String customerFullname;

    @SerializedName("customerId")
    @Expose
    public int customerId;

    @SerializedName("date")
    @Expose
    public Date date;

    @SerializedName("delivererId")
    @Expose
    public int delivererId;

    @SerializedName("deliveryTime")
    @Expose
    public Date deliveryTime;

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12451id;

    @SerializedName("items")
    @Expose
    public List<OrderProduct> items;

    @SerializedName("orderCoupon")
    @Expose
    public List<OrderDetail.OrderCoupon> orderCoupon;

    @SerializedName("payAmount")
    @Expose
    public int payAmount;

    @SerializedName("payCurrency")
    @Expose
    public String payCurrency;

    @SerializedName("paymentMethod")
    @Expose
    public String paymentMethod;

    @SerializedName("platform")
    @Expose
    public String platform;

    @SerializedName("shipping")
    @Expose
    public ShippingInfo shipping;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("shippingMethod")
    @Expose
    public String shippingMethod;

    @SerializedName("shippingPrice")
    @Expose
    public float shippingPrice;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("timeOff")
    @Expose
    public boolean timeOff;

    @SerializedName("totalAmount")
    @Expose
    public float totalAmount;

    @SerializedName("totalV")
    @Expose
    public OrderPrice totalV;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("updatedAt")
    @Expose
    public Date updatedAt;

    @SerializedName("vendorName")
    @Expose
    public String vendorName;

    public static class CancelledReason {

        @SerializedName("custom")
        @Expose
        public String custom;

        @SerializedName("vendorName")
        @Expose
        public String vendorName;
    }

    public static class OrderPrice {

        @SerializedName("amount")
        @Expose
        public SubOrder.TotalAmount amount;

        @SerializedName("oldAmount")
        @Expose
        public SubOrder.TotalAmount oldAmount;
    }

    public static class OrderProduct {

        @SerializedName("cancelItems")
        @Expose
        public int cancelItems;

        @SerializedName("currency")
        @Expose
        public String currency;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12452id;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("price")
        @Expose
        public float price;

        @SerializedName("quantity")
        @Expose
        public int quantity;

        @SerializedName("refundItems")
        @Expose
        public int refundItems;

        @SerializedName("sku")
        @Expose
        public String sku;
    }
}
