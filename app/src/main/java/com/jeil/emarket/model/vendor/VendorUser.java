package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VendorUser {

    @SerializedName("expiresIn")
    @Expose
    public String expiresIn;

    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("user")
    @Expose
    public User user;

    public class User {

        @SerializedName("avatar")
        @Expose
        public int avatar;

        @SerializedName("birthday")
        @Expose
        public String birthday;

        @SerializedName("delivererId")
        @Expose
        public int delivererId;

        @SerializedName("fullname")
        @Expose
        public String fullname;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12455id;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("phone1")
        @Expose
        public String phone1;

        @SerializedName("phone2")
        @Expose
        public String phone2;

        @SerializedName("role")
        @Expose
        public String role;

        @SerializedName("vendor")
        @Expose
        public Vendor vendor;

        public User() {
        }
    }

    public static class Vendor {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12456id;

        @SerializedName("name")
        @Expose
        public String name;
    }
}
