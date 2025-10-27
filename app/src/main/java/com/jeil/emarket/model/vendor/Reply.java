package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;


public class Reply {

    @SerializedName("customerAvatar")
    @Expose
    public int customerAvatar;

    @SerializedName("customerName")
    @Expose
    public String customerName;

    @SerializedName("orderItemCurrency")
    @Expose
    public String orderItemCurrency;

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

    @SerializedName("replyId")
    @Expose
    public int replyId;

    @SerializedName("replyStatus")
    @Expose
    public String replyStatus;

    @SerializedName("replyStatusText")
    @Expose
    public String replyStatusText;

    @SerializedName("replyText")
    @Expose
    public String replyText;

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

    @SerializedName("vendorName")
    @Expose
    public String vendorName;

    @SerializedName("votes")
    @Expose
    public int votes;
}
