package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.vendor.Vendor;
import java.util.Date;


public class Ticket {

    @SerializedName("_id")
    @Expose
    public String _id;

    @SerializedName("agent")
    @Expose
    public User agent;

    @SerializedName("categoryId")
    @Expose
    public String categoryId;

    @SerializedName("createdAt")
    @Expose
    public Date createdAt;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("objectId")
    @Expose
    public int objectId;

    @SerializedName("read")
    @Expose
    public int read;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("updatedAt")
    @Expose
    public Date updatedAt;

    @SerializedName("user")
    @Expose
    public User user;

    @SerializedName("vendor")
    @Expose
    public Vendor vendor;

    public static class Receiver {

        /* renamed from: id */
        public int f12427id;
        public String type;

        public Receiver(int i, String str) {
            this.f12427id = i;
            this.type = str;
        }
    }

    public static class ReceiverVendor {

        /* renamed from: id */
        public int f12428id;
        public String name;

        public ReceiverVendor() {
        }

        public ReceiverVendor(int i, String str) {
            this.f12428id = i;
            this.name = str;
        }
    }
}
