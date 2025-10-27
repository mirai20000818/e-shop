package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RefundProduct {

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12415id;

    @SerializedName("orderItemId")
    @Expose
    public int orderItemId;

    @SerializedName("productId")
    @Expose
    public int productId;

    @SerializedName("productImg")
    @Expose
    public String productImg;

    @SerializedName("productName")
    @Expose
    public String productName;

    @SerializedName("quantity")
    @Expose
    public int quantity;

    @SerializedName("supportRefund")
    @Expose
    public String supportRefund;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("vendor")
    @Expose
    public String vendor;
}
