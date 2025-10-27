package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TicketCategory {

    @SerializedName("_id")
    @Expose
    public String _id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("type")
    @Expose
    public String type;
}
