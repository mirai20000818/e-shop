package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Attachment {

    @SerializedName("height")
    @Expose
    public int height;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12391id;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("width")
    @Expose
    public int width;
}
