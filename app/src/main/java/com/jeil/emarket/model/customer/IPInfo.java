package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class IPInfo {

    @SerializedName("crt")
    @Expose
    public String crt;

    @SerializedName("ip_cook")
    @Expose
    public String ipCook;

    @SerializedName("ip_http")
    @Expose
    public String ipHttp;

    @SerializedName("ip_https")
    @Expose
    public String ipHttps;
}
