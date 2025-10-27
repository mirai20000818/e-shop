package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.Date;


public class ChartOrder {

    @SerializedName("createdAt")
    @Expose
    public Date createdAt;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("customer")
    @Expose
    public String customer;

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12432id;

    @SerializedName("productName")
    @Expose
    public String productName;

    @SerializedName("productsCount")
    @Expose
    public int productsCount;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("total")
    @Expose
    public SubOrder.TotalAmount total;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("typesCount")
    @Expose
    public int typesCount;
}
