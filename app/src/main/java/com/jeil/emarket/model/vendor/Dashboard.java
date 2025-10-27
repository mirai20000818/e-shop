package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;


public class Dashboard {

    @SerializedName("tickets")
    @Expose
    public Ticket tickets;

    @SerializedName("vendorInfo")
    @Expose
    public VendorInfo vendorInfo;

    public static class Ticket {

        @SerializedName("pending")
        @Expose
        public int pending;

        @SerializedName("rows")
        @Expose
        public List<TicketItem> rows;

        @SerializedName("total")
        @Expose
        public int total;

        public static class TicketItem {

            @SerializedName("avatar")
            @Expose
            public int avatar;

            @SerializedName("categoryId")
            @Expose
            public String categoryId;

            @SerializedName("fullname")
            @Expose
            public String fullname;

            /* renamed from: id */
            @SerializedName("id")
            @Expose
            public String f12435id;

            @SerializedName("isMarket")
            @Expose
            public Boolean isMarket;

            @SerializedName("message")
            @Expose
            public String message;

            @SerializedName("name")
            @Expose
            public String name;

            @SerializedName("status")
            @Expose
            public String status;

            @SerializedName("title")
            @Expose
            public String title;

            @SerializedName("updatedAt")
            @Expose
            public Date updatedAt;
        }
    }

    public static class VendorInfo {

        @SerializedName("desktopViews")
        @Expose
        public int desktopViews;

        @SerializedName("lowStockProducts")
        @Expose
        public int lowStockProducts;

        @SerializedName("mobileViews")
        @Expose
        public int mobileViews;

        @SerializedName("noStockProducts")
        @Expose
        public int noStockProducts;

        @SerializedName("notRegisteredProducts")
        @Expose
        public int notRegisteredProducts;

        @SerializedName("registeredProducts")
        @Expose
        public int registeredProducts;
    }
}
