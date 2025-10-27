package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.Ticket;
import java.util.Date;


public class User {

    @SerializedName("avatar")
    @Expose
    public int avatar;

    @SerializedName("birthday")
    @Expose
    public Date birthday;

    @SerializedName("cid")
    @Expose
    public String cid;

    @SerializedName("defaultAddressId")
    @Expose
    public int defaultAddressId;

    @SerializedName("delivererId")
    @Expose
    public int delivererId;

    @SerializedName("dname")
    @Expose
    public String desktopName;

    @SerializedName("fullname")
    @Expose
    public String fullName;

    @SerializedName("gender")
    @Expose
    public String gender;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12429id;

    @SerializedName("isMerged")
    @Expose
    public Boolean isMerged;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("password")
    @Expose
    public String password;

    @SerializedName("role")
    @Expose
    public String role;

    @SerializedName("vendor")
    @Expose
    public Ticket.ReceiverVendor vendor;
}
