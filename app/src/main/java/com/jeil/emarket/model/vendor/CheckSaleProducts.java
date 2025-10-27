package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class CheckSaleProducts {

    @SerializedName("alreadySaleFailed")
    @Expose
    public int[] alreadySaleFailed;

    @SerializedName("discountFailed")
    @Expose
    public int[] discountFailed;

    @SerializedName("existFailed")
    @Expose
    public String[] existFailed;

    @SerializedName("priceFailed")
    @Expose
    public String[] priceFailed;

    @SerializedName("products")
    @Expose
    public List<SaleProduct> products;

    @SerializedName("stockFailed")
    @Expose
    public String[] stockFailed;

    @SerializedName("success")
    @Expose
    public int[] success;
}
