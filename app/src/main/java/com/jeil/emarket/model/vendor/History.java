package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class History {

    @SerializedName("category")
    @Expose
    public String category;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("logged_at")
    @Expose
    public Date logged_at;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("user")
    @Expose
    public VendorUser user;

    public static class VendorUser {

        @SerializedName("avatar")
        @Expose
        public int avatar;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12439id;

        @SerializedName("userFullName")
        @Expose
        public String userFullName;

        @SerializedName("userName")
        @Expose
        public String userName;

        @SerializedName("userRole")
        @Expose
        public String userRole;
    }
}
