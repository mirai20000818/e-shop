package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;


public class Review {

    @SerializedName("approvedCode")
    @Expose
    public String approvedCode;

    @SerializedName("attachments")
    @Expose
    public List<Image> attachments;

    @SerializedName("avatar")
    @Expose
    public int avatar;

    @SerializedName("canEdit")
    @Expose
    public Boolean canEdit;

    @SerializedName("customer")
    @Expose
    public String customer;

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

    @SerializedName("orderItemCurrency")
    @Expose
    public String orderItemCurrency;

    @SerializedName("orderItemId")
    @Expose
    public int orderItemId;

    @SerializedName("orderItemQuantity")
    @Expose
    public int orderItemQuantity;

    @SerializedName("orderItemTotal")
    @Expose
    public float orderItemTotal;

    @SerializedName("productId")
    @Expose
    public int productId;

    @SerializedName("productImage")
    @Expose
    public String productImage;

    @SerializedName("productName")
    @Expose
    public String productName;

    @SerializedName("rating")
    @Expose
    public int rating;

    @SerializedName("rejectedReason")
    @Expose
    public String rejectedReason;

    @SerializedName("replyAt")
    @Expose
    public Date replyAt;

    @SerializedName("replyStatus")
    @Expose
    public String replyStatus;

    @SerializedName("replyText")
    @Expose
    public String replyText;

    @SerializedName("reviewAttachments")
    @Expose
    public List<Image> reviewAttachments;

    @SerializedName("reviewDate")
    @Expose
    public Date reviewDate;

    @SerializedName("reviewId")
    @Expose
    public int reviewId;

    @SerializedName("reviewRating")
    @Expose
    public int reviewRating;

    @SerializedName("reviewText")
    @Expose
    public String reviewText;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("text")
    @Expose
    public String text;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    @SerializedName("vendorName")
    @Expose
    public String vendorName;

    @SerializedName("votes")
    @Expose
    public int votes;

    public static class Image {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12417id;

        @SerializedName("url")
        @Expose
        public String url;
    }
}
