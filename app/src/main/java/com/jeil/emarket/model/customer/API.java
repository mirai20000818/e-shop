package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;


public class API {

    @SerializedName("method")
    @Expose
    public String method;

    @SerializedName("param")
    @Expose
    public JSONObject param;

    @SerializedName("url")
    @Expose
    public String url;
}
