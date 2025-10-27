package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SaleProductUpdate {

    @SerializedName("discountPercent")
    @Expose
    public float discountPercent;

    @SerializedName("discountPrice")
    @Expose
    public float discountPrice;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12444id;

    @SerializedName("productId")
    @Expose
    public int productId;
}
