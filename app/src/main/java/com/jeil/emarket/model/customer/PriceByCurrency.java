package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PriceByCurrency {

    @SerializedName("kpf")
    @Expose
    public float kpf;

    @SerializedName("kpw")
    @Expose
    public float kpw;
}
