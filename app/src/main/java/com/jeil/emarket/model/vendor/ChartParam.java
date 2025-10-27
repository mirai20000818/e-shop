package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ChartParam {

    @SerializedName("category")
    @Expose
    public String category;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("endDate")
    @Expose
    public String endDate;

    @SerializedName("filter")
    @Expose
    public String filter;

    @SerializedName("metric")
    @Expose
    public String metric;

    @SerializedName("period")
    @Expose
    public String period;

    @SerializedName("prevEndDate")
    @Expose
    public String prevEndDate;

    @SerializedName("prevStartDate")
    @Expose
    public String prevStartDate;

    @SerializedName("search")
    @Expose
    public String search;

    @SerializedName("selectedInterval")
    @Expose
    public String selectedInterval;

    @SerializedName("startDate")
    @Expose
    public String startDate;
}
