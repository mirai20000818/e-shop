package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Account {

    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("user")
    @Expose
    public User user;
}
