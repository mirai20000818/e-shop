package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Address {

    @SerializedName("label")
    @Expose
    public String label;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("status")
    @Expose
    public int status;

    public Address(String str, String str2, int i) {
        this.name = str;
        this.label = str2;
        this.status = i;
    }
}
