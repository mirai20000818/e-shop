package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VendorPointCount {

    @SerializedName("marketPoint")
    @Expose
    public MarketPoint marketPoint;

    @SerializedName("status")
    @Expose
    public Status status;

    @SerializedName("vendorDeliveryPoint")
    @Expose
    public float vendorDeliveryPoint;

    @SerializedName("vendorPoint")
    @Expose
    public float vendorPoint;

    @SerializedName("vendorServicePoint")
    @Expose
    public float vendorServicePoint;

    @SerializedName("vendorSupportPoint")
    @Expose
    public float vendorSupportPoint;

    public static class MarketPoint {

        @SerializedName("delivery")
        @Expose
        public String delivery;

        @SerializedName("service")
        @Expose
        public String service;

        @SerializedName("support")
        @Expose
        public String support;
    }

    public static class Status {

        @SerializedName("all")
        @Expose
        public int all;

        @SerializedName("approved")
        @Expose
        public int approved;

        @SerializedName("pending")
        @Expose
        public int pending;

        @SerializedName("rejected")
        @Expose
        public int rejected;
    }
}
