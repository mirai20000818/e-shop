package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.List;


public class DashboardSaleChart {

    @SerializedName("date")
    @Expose
    public List<String> date;

    @SerializedName("total")
    @Expose
    public SubOrder.TotalAmount total;

    @SerializedName("valueKpf")
    @Expose
    public List<Float> valueKpf;

    @SerializedName("valueKpw")
    @Expose
    public List<Float> valueKpw;
}
