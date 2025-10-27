package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.List;


public class DashboardOrderChart {

    @SerializedName("cancelled")
    @Expose
    public List<Float> cancelled;

    @SerializedName("completed")
    @Expose
    public List<Float> completed;

    @SerializedName("date")
    @Expose
    public List<String> date;

    @SerializedName("limit")
    @Expose
    public int limit;

    @SerializedName("stats")
    @Expose
    public StatsData stats;

    @SerializedName("total")
    @Expose
    public List<Float> total;

    public static class StatsData {

        @SerializedName("cancelled")
        @Expose
        public Data cancelled;

        @SerializedName("completed")
        @Expose
        public Data completed;

        @SerializedName("requested")
        @Expose
        public Data requested;

        @SerializedName("urgent")
        @Expose
        public int urgent;

        public static class Data {

            @SerializedName("count")
            @Expose
            public int count;

            @SerializedName("products")
            @Expose
            public int products;

            @SerializedName("total")
            @Expose
            public SubOrder.TotalAmount total;
        }
    }
}
