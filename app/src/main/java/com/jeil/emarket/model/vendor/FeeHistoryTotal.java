package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FeeHistoryTotal {

    @SerializedName("kpf")
    @Expose
    public float kpf;

    @SerializedName("kpw")
    @Expose
    public float kpw;
}
