package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VendorCancelItem {

    @SerializedName("orderItemId")
    @Expose
    public int orderItemId;

    @SerializedName("quantity")
    @Expose
    public int quantity;
}
