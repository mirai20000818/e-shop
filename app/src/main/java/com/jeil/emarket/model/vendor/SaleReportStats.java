package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;


public class SaleReportStats {

    @SerializedName("orderTotal")
    @Expose
    public SubOrder.TotalAmount orderTotal;

    @SerializedName("productsSold")
    @Expose
    public int productsSold;
}
