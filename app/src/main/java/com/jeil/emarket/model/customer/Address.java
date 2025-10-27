package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Address {

    @SerializedName("address1")
    @Expose
    public String address1;

    @SerializedName("address2")
    @Expose
    public String address2;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("isDefault")
    @Expose
    public boolean isDefault;

    @SerializedName("location")
    @Expose
    public String location;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("phone1")
    @Expose
    public String phone1;

    @SerializedName("phone2")
    @Expose
    public String phone2;

    @SerializedName("type")
    @Expose
    public String type;
}
