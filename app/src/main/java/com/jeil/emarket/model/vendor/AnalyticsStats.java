package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;


public class AnalyticsStats {

    @SerializedName("avgOrderTotal")
    @Expose
    public float avgOrderTotal;

    @SerializedName("avgOrders")
    @Expose
    public float avgOrders;

    @SerializedName("avgOrdersTotal")
    @Expose
    public float avgOrdersTotal;

    @SerializedName("avgTotal")
    @Expose
    public float avgTotal;

    @SerializedName("cancelled")
    @Expose
    public int cancelled;

    @SerializedName("categories")
    @Expose
    public int categories;

    @SerializedName("completed")
    @Expose
    public int completed;

    @SerializedName("completedSaleTotal")
    @Expose
    public SubOrder.TotalAmount completedSaleTotal;

    @SerializedName("customers")
    @Expose
    public int customers;

    @SerializedName("desktopVisits")
    @Expose
    public int desktopVisits;

    @SerializedName("discount")
    @Expose
    public float discount;

    @SerializedName("exchanged")
    @Expose
    public int exchanged;

    @SerializedName("fee")
    @Expose
    public SubOrder.TotalAmount fee;

    @SerializedName("inStock")
    @Expose
    public float inStock;

    @SerializedName("mobileVisits")
    @Expose
    public int mobileVisits;

    @SerializedName("orderTotal")
    @Expose
    public float orderTotal;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("outOfStock")
    @Expose
    public float outOfStock;

    @SerializedName("products")
    @Expose
    public float products;

    @SerializedName("productsCount")
    @Expose
    public int productsCount;

    @SerializedName("productsSold")
    @Expose
    public float productsSold;

    @SerializedName("productsType")
    @Expose
    public int productsType;

    @SerializedName("profit")
    @Expose
    public float profit;

    @SerializedName("refund")
    @Expose
    public float refund;

    @SerializedName("returned")
    @Expose
    public int returned;

    @SerializedName("saleTotal")
    @Expose
    public SubOrder.TotalAmount saleTotal;

    @SerializedName("shipping")
    @Expose
    public float shipping;

    @SerializedName("sold")
    @Expose
    public int sold;

    @SerializedName("total")
    @Expose
    public float total;

    @SerializedName("users")
    @Expose
    public int users;
}
