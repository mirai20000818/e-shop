package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class TicketUser {

    @SerializedName("avatar")
    @Expose
    public int avatar;

    @SerializedName("avgAmountKpf")
    @Expose
    public float avgAmountKpf;

    @SerializedName("avgAmountKpw")
    @Expose
    public float avgAmountKpw;

    @SerializedName("fullname")
    @Expose
    public String fullName;

    @SerializedName("loggedAt")
    @Expose
    public Date loggedAt;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("orderedAt")
    @Expose
    public Date orderedAt;

    @SerializedName("orders")
    @Expose
    public int orders;

    @SerializedName("ordersTotalKpf")
    @Expose
    public float ordersTotalKpf;

    @SerializedName("ordersTotalKpw")
    @Expose
    public float ordersTotalKpw;

    @SerializedName("shippingAddress")
    @Expose
    public String shippingAddress;
}
