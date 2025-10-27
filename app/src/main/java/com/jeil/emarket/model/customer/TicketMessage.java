package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class TicketMessage {

    @SerializedName("agent")
    @Expose
    public User agent;

    @SerializedName("createdAt")
    @Expose
    public Date createdAt;

    @SerializedName("createdBy")
    @Expose
    public String createdBy;

    @SerializedName("isResolved")
    @Expose
    public boolean isResolved;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("ticketId")
    @Expose
    public String ticketId;
}
