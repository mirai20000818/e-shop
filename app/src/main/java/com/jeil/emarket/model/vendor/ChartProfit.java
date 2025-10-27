package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.Date;


public class ChartProfit {

    @SerializedName("date")
    @Expose
    public Date date;

    @SerializedName("discount")
    @Expose
    public float discount;

    @SerializedName("fee")
    @Expose
    public SubOrder.TotalAmount fee;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("refund")
    @Expose
    public float refund;

    @SerializedName("returned")
    @Expose
    public float returned;

    @SerializedName("shipping")
    @Expose
    public float shipping;

    @SerializedName("total")
    @Expose
    public SubOrder.TotalAmount total;

    @SerializedName("type")
    @Expose
    public String type;
}
