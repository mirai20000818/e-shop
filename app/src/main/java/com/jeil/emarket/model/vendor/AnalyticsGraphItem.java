package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class AnalyticsGraphItem {

    @SerializedName("date")
    @Expose
    public List<String> date;

    @SerializedName("total")
    @Expose
    public float total;

    @SerializedName("value")
    @Expose
    public List<Float> value;
}
