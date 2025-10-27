package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class Newsletter {

    @SerializedName("allow")
    @Expose
    public boolean allow;

    @SerializedName("approvedCode")
    @Expose
    public String approvedCode;

    @SerializedName("content")
    @Expose
    public String content;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12403id;

    @SerializedName("initialHeight")
    @Expose
    public int initialHeight;

    @SerializedName("link")
    @Expose
    public String link;

    @SerializedName("priority")
    @Expose
    public int priority;

    @SerializedName("startDate")
    @Expose
    public Date startDate;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("url")
    @Expose
    public String url;
}
