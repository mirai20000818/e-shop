package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VendorReviewCount {

    @SerializedName("status")
    @Expose
    public Status status;

    @SerializedName("totalAvgRating")
    @Expose
    public float totalAvgRating;

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

        @SerializedName("replyPending")
        @Expose
        public int replyPending;

        @SerializedName("replyRejected")
        @Expose
        public int replyRejected;
    }
}
