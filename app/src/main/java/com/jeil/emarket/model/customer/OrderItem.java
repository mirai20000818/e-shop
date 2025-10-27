package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.CheckoutVendor;
import java.util.Date;
import java.util.List;


public class OrderItem {

    @SerializedName("amount")
    @Expose
    public float amount;

    @SerializedName("cancelItems")
    @Expose
    public int cancelItems;

    @SerializedName("cancelList")
    @Expose
    public List<SubItem> cancelList;

    @SerializedName("cancelQty")
    @Expose
    public int cancelQty;

    @SerializedName("createdAt")
    @Expose
    public Date createdAt;

    @SerializedName("curQty")
    @Expose
    public int curQty;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("discountType")
    @Expose
    public String discountType;

    @SerializedName("fee")
    @Expose
    public float fee;

    @SerializedName("guaranteeDays")
    @Expose
    public int guaranteeDays;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12404id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("preOrder")
    @Expose
    public int preOrder;

    @SerializedName("priceKpf")
    @Expose
    public float priceKpf;

    @SerializedName("priceKpw")
    @Expose
    public float priceKpw;

    @SerializedName("productId")
    @Expose
    public int productId;

    @SerializedName("productImg")
    @Expose
    public String productImg;

    @SerializedName("productParent")
    @Expose
    public int productParent;

    @SerializedName("products")
    @Expose
    public List<CheckoutVendor.Discounts.FbtProduct> products;

    @SerializedName("quantity")
    @Expose
    public int quantity;

    @SerializedName("reason")
    @Expose
    public String reason;

    @SerializedName("refundItems")
    @Expose
    public int refundItems;

    @SerializedName("refundList")
    @Expose
    public List<SubItem> refundList;

    @SerializedName("regularPrice")
    @Expose
    public float regularPrice;

    @SerializedName("review")
    @Expose
    public Review review;

    @SerializedName("salePrice")
    @Expose
    public float salePrice;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("subtotal")
    @Expose
    public float subtotal;

    @SerializedName("total")
    @Expose
    public float total;

    @SerializedName("type")
    @Expose
    public String type;

    public static class Review {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12405id;

        @SerializedName("rating")
        @Expose
        public float rating;

        @SerializedName("review")
        @Expose
        public String review;
    }

    public static class SubItem {

        @SerializedName("amount")
        @Expose
        public float amount;

        @SerializedName("cancelItem")
        @Expose
        public SubItem cancelItem;

        @SerializedName("createdAt")
        @Expose
        public Date createdAt;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12406id;

        @SerializedName("orderItemId")
        @Expose
        public int orderItemId;

        @SerializedName("productId")
        @Expose
        public int productId;

        @SerializedName("quantity")
        @Expose
        public int quantity;

        @SerializedName("reason")
        @Expose
        public String reason;

        @SerializedName("type")
        @Expose
        public String type;
    }
}
