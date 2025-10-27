package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.Date;


public class ChartCustomer {

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12431id;

    @SerializedName("loggedAt")
    @Expose
    public Date loggedAt;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderTotal")
    @Expose
    public float orderTotal;

    @SerializedName("orderedAt")
    @Expose
    public Date orderedAt;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("ordersTotal")
    @Expose
    public SubOrder.TotalAmount ordersTotal;

    @SerializedName("shippingAddress")
    @Expose
    public String shippingAddress;

    @SerializedName("type")
    @Expose
    public String type;
}
