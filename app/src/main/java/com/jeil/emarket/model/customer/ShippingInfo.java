package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShippingInfo {

    @SerializedName("address1")
    @Expose
    public String address1;

    @SerializedName("address2")
    @Expose
    public String address2;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12419id;

    @SerializedName("location")
    @Expose
    public String location;

    @SerializedName("method")
    @Expose
    public String method;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("note")
    @Expose
    public String note;

    @SerializedName("phone1")
    @Expose
    public String phone1;

    @SerializedName("phone2")
    @Expose
    public String phone2;

    @SerializedName("role")
    @Expose
    public String role;

    @SerializedName("urgent")
    @Expose
    public Boolean urgent;
}
