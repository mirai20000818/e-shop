package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class MergeRequests {

    @SerializedName("desktop")
    @Expose
    public AccountMerge desktop;

    @SerializedName("mobile")
    @Expose
    public AccountMerge mobile;

    @SerializedName("received")
    @Expose
    public AccountMerge received;

    public static class AccountMerge {

        @SerializedName("createdAt")
        @Expose
        public Date createdAt;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12402id;

        @SerializedName("sourceUser")
        @Expose
        public String sourceUser;

        @SerializedName("targetChannel")
        @Expose
        public String targetChannel;

        @SerializedName("targetUser")
        @Expose
        public String targetUser;
    }
}
