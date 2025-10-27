package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;


public class ChartCategory {

    @SerializedName("categoryId")
    @Expose
    public int categoryId;

    @SerializedName("countCancelled")
    @Expose
    public int countCancelled;

    @SerializedName("orderTotal")
    @Expose
    public SubOrder.TotalAmount orderTotal;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("products")
    @Expose
    public int products;

    @SerializedName("productsSold")
    @Expose
    public int productsSold;

    @SerializedName("type")
    @Expose
    public String type;
}
