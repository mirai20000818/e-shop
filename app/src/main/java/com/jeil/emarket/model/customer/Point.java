package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class Point {

    @SerializedName("approvedCode")
    @Expose
    public String approvedCode;

    @SerializedName("avatar")
    @Expose
    public int avatar;

    @SerializedName("canEdit")
    @Expose
    public Boolean canEdit;

    @SerializedName("customerAvatar")
    @Expose
    public int customerAvatar;

    @SerializedName("customerFullname")
    @Expose
    public String customerFullname;

    @SerializedName("customerId")
    @Expose
    public int customerId;

    @SerializedName("date")
    @Expose
    public Date date;

    @SerializedName("delivery")
    @Expose
    public int delivery;

    @SerializedName("displayOrderId")
    @Expose
    public String displayOrderId;

    @SerializedName("logo")
    @Expose
    public String logo;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderId")
    @Expose
    public int orderId;

    @SerializedName("point")
    @Expose
    public int point;

    @SerializedName("pointDate")
    @Expose
    public Date pointDate;

    @SerializedName("pointId")
    @Expose
    public int pointId;

    @SerializedName("rejectedReason")
    @Expose
    public String rejectedReason;

    @SerializedName("service")
    @Expose
    public int service;

    @SerializedName("servicePoint")
    @Expose
    public int servicePoint;

    @SerializedName("shippingPoint")
    @Expose
    public int shippingPoint;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("support")
    @Expose
    public int support;

    @SerializedName("supportPoint")
    @Expose
    public int supportPoint;

    @SerializedName("text")
    @Expose
    public String text;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("vendorCard")
    @Expose
    public String vendorCard;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    @SerializedName("vendorName")
    @Expose
    public String vendorName;

    @SerializedName("votes")
    @Expose
    public int votes;
}
