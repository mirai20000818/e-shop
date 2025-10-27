package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;


public class RefundRequestProduct {

    @SerializedName("customerFullname")
    @Expose
    public String customerFullname;

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12416id;

    @SerializedName("item")
    @Expose
    public Product item;

    @SerializedName("itemId")
    @Expose
    public int itemId;

    @SerializedName("itemName")
    @Expose
    public String itemName;

    @SerializedName("itemSku")
    @Expose
    public String itemSku;

    @SerializedName("modifiedDate")
    @Expose
    public Date modifiedDate;

    @SerializedName("orderId")
    @Expose
    public int orderId;

    @SerializedName("productImg")
    @Expose
    public String productImg;

    @SerializedName("productName")
    @Expose
    public String productName;

    @SerializedName("quantity")
    @Expose
    public int quantity;

    @SerializedName("reason")
    @Expose
    public Reason reason;

    @SerializedName("refundAttachments")
    @Expose
    public List<Attachment> refundAttachments;

    @SerializedName("refundText")
    @Expose
    public String refundText;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("updatedAt")
    @Expose
    public Date updatedAt;

    @SerializedName("vendor")
    @Expose
    public String vendor;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    public class Product {

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("productId")
        @Expose
        public int productId;

        @SerializedName("quantity")
        @Expose
        public int quantity;

        @SerializedName("sku")
        @Expose
        public String sku;

        public Product() {
        }
    }

    public class Reason {

        @SerializedName("attachments")
        @Expose
        public List<Attachment> attachments;

        @SerializedName("text")
        @Expose
        public String text;

        public Reason() {
        }
    }
}
