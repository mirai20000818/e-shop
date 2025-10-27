package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.CheckoutVendor;
import com.jeil.emarket.model.customer.OrderItem;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.Date;
import java.util.List;


public class OrderDetail {

    @SerializedName("cancelAmount")
    @Expose
    public SubOrder.TotalAmount cancelAmount;

    @SerializedName("completedAt")
    @Expose
    public Date completedAt;

    @SerializedName("costAmount")
    @Expose
    public float costAmount;

    @SerializedName("createdAt")
    @Expose
    public Date createdAt;

    @SerializedName("customerAvatar")
    @Expose
    public int customerAvatar;

    @SerializedName("customerFullname")
    @Expose
    public String customerFullname;

    @SerializedName("customerId")
    @Expose
    public int customerId;

    @SerializedName("customerName")
    @Expose
    public String customerName;

    @SerializedName("delivererId")
    @Expose
    public int delivererId;

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

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    @SerializedName("fbts")
    @Expose
    public List<CheckoutVendor.Discounts.Fbt> fbts;

    @SerializedName("fee")
    @Expose
    public float fee;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12440id;

    @SerializedName("itemAmount")
    @Expose
    public SubOrder.TotalAmount itemAmount;

    @SerializedName("items")
    @Expose
    public List<OrderItem> items;

    @SerializedName("logs")
    @Expose
    public List<History> logs;

    @SerializedName("nextId")
    @Expose
    public int nextId;

    @SerializedName("orderCoupon")
    @Expose
    public List<OrderCoupon> orderCoupon;

    @SerializedName("paidAt")
    @Expose
    public Date paidAt;

    @SerializedName("parentId")
    @Expose
    public int parentId;

    @SerializedName("payAmount")
    @Expose
    public float payAmount;

    @SerializedName("payCurrency")
    @Expose
    public String payCurrency;

    @SerializedName("paymentMethod")
    @Expose
    public String paymentMethod;

    @SerializedName("platform")
    @Expose
    public String platform;

    @SerializedName("prevId")
    @Expose
    public int prevId;

    @SerializedName("realItems")
    @Expose
    public List<OrderItem> realItems;

    @SerializedName("reason")
    @Expose
    public String reason;

    @SerializedName("refundAmount")
    @Expose
    public SubOrder.TotalAmount refundAmount;

    @SerializedName("shipping")
    @Expose
    public ShippingInfo shipping;

    @SerializedName("shippingAmount")
    @Expose
    public float shippingAmount;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("shippingMethod")
    @Expose
    public String shippingMethod;

    @SerializedName("shippingStatus")
    @Expose
    public int shippingStatus;

    @SerializedName("shippingUrgent")
    @Expose
    public boolean shippingUrgent;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("ticket")
    @Expose
    public String ticket;

    @SerializedName("totalAmount")
    @Expose
    public SubOrder.TotalAmount totalAmount;

    public class OrderCoupon {

        @SerializedName("discounted")
        @Expose
        public SubOrder.TotalAmount discounted;

        @SerializedName("display")
        @Expose
        public String display;

        public OrderCoupon() {
        }
    }
}
