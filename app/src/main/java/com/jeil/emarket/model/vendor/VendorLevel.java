package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VendorLevel {

    @SerializedName("discountRate")
    @Expose
    public int discountRate;

    @SerializedName("maxMediaLimit")
    @Expose
    public int maxMediaLimit;

    @SerializedName("maxPublishCount")
    @Expose
    public int maxPublishCount;

    @SerializedName("monthlyFee")
    @Expose
    public int monthlyFee;
}
