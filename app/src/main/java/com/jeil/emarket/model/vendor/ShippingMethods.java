package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class ShippingMethods {

    @SerializedName("areas")
    @Expose
    public List areas;

    @SerializedName("setting")
    @Expose
    public SettingInfo setting;

    public static class SettingInfo {

        @SerializedName("enableDiscuss")
        @Expose
        public boolean enableDiscuss;

        @SerializedName("enableUrgent")
        @Expose
        public boolean enableUrgent;

        @SerializedName("price")
        @Expose
        public float price;

        @SerializedName("shippingCurrency")
        @Expose
        public String shippingCurrency;

        @SerializedName("time")
        @Expose
        public int time;

        @SerializedName("urgentPrice")
        @Expose
        public float urgentPrice;

        @SerializedName("urgentTime")
        @Expose
        public int urgentTime;
    }
}
