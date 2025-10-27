package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.List;


public class AnalyticsOverviewData {

    @SerializedName("date")
    @Expose
    public List<String> date;

    @SerializedName("stats")
    @Expose
    public StatsData stats;

    @SerializedName("total")
    @Expose
    public SubOrder.TotalAmount total;

    @SerializedName("valueKpf")
    @Expose
    public List<Float> valueKpf;

    @SerializedName("valueKpw")
    @Expose
    public List<Float> valueKpw;

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
