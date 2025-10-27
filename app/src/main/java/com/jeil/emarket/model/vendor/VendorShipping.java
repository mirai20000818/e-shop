package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;


public class VendorShipping {

    @SerializedName("completedAt")
    @Expose
    public Date completedAt;

    @SerializedName("deliveryTime")
    @Expose
    public Date deliveryTime;

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    @SerializedName("district")
    @Expose
    public String district;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12453id;

    @SerializedName("items")
    @Expose
    public List<VendorProduct> items;

    @SerializedName("method")
    @Expose
    public String method;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("vendorName")
    @Expose
    public String vendorName;

    public static class VendorProduct {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12454id;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("quantity")
        @Expose
        public int quantity;

        @SerializedName("sku")
        @Expose
        public String sku;
    }
}
