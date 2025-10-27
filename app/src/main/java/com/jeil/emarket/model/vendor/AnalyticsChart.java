package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AnalyticsChart {

    @SerializedName("data")
    @Expose
    public AnalyticsGraphItem data;

    @SerializedName("prevData")
    @Expose
    public AnalyticsGraphItem prevData;

    @SerializedName("stats")
    @Expose
    public StatusCount stats;

    public class StatusCount {
        public int cancelled;
        public int completed;
        public int orders;

        public StatusCount() {
        }
    }
}
