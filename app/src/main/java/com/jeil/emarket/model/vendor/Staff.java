package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class Staff {

    @SerializedName("address1")
    @Expose
    public String address1;

    @SerializedName("address2")
    @Expose
    public String address2;

    @SerializedName("channel")
    @Expose
    public String channel;

    @SerializedName("deliveries")
    @Expose
    public int deliveries;

    @SerializedName("fullname")
    @Expose
    public String fullName;

    @SerializedName("goodDeliveries")
    @Expose
    public int goodDeliveries;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12447id;

    @SerializedName("location")
    @Expose
    public String location;

    @SerializedName("loggedAt")
    @Expose
    public Date loggedAt;

    @SerializedName("mask")
    @Expose
    public int mask;

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

    @SerializedName("type")
    @Expose
    public String type;
}
