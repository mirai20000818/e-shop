package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RoleData {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("permissions")
    @Expose
    public Permission permissions;

    @SerializedName("slug")
    @Expose
    public String slug;

    public static class Permission {

        @SerializedName("analytics")
        @Expose
        public String analytics;

        @SerializedName("dashboard")
        @Expose
        public String dashboard;

        @SerializedName("file")
        @Expose
        public String file;

        @SerializedName("finance")
        @Expose
        public String finance;

        @SerializedName("logs")
        @Expose
        public String logs;

        @SerializedName("notice")
        @Expose
        public String notice;

        @SerializedName("orders")
        @Expose
        public String orders;

        @SerializedName("products")
        @Expose
        public String products;

        @SerializedName("reviews")
        @Expose
        public String reviews;

        @SerializedName("sale")
        @Expose
        public String sale;

        @SerializedName("setting")
        @Expose
        public String setting;

        @SerializedName("shipping")
        @Expose
        public String shipping;

        @SerializedName("staffs")
        @Expose
        public String staffs;
    }
}
