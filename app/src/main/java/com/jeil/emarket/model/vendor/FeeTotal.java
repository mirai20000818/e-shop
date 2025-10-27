package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FeeTotal {

    @SerializedName("kpfTotal")
    @Expose
    public float kpfTotal;

    @SerializedName("kpwTotal")
    @Expose
    public float kpwTotal;
}
