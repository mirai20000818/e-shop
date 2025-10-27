package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class FeeHistory {

    @SerializedName("amountKpf")
    @Expose
    public float amountKpf;

    @SerializedName("amountKpw")
    @Expose
    public float amountKpw;

    @SerializedName("createdAt")
    @Expose
    public Date createdAt;

    @SerializedName("description")
    @Expose
    public String description;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12438id;

    @SerializedName("type")
    @Expose
    public String type;
}
