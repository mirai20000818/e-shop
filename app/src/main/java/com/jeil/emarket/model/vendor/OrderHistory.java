package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OrderHistory {

    @SerializedName("orders")
    @Expose
    public Orders orders;

    @SerializedName("refunds")
    @Expose
    public Refunds refunds;

    @SerializedName("tickets")
    @Expose
    public int tickets;

    public static class Orders {

        @SerializedName("accepted")
        @Expose
        public int accepted;

        @SerializedName("requested")
        @Expose
        public int requested;

        @SerializedName("shipping")
        @Expose
        public int shipping;
    }

    public static class Refunds {

        @SerializedName("accepted")
        @Expose
        public int accepted;

        @SerializedName("requested")
        @Expose
        public int requested;

        @SerializedName("shipping")
        @Expose
        public int shipping;

        @SerializedName("testing")
        @Expose
        public int testing;
    }
}
