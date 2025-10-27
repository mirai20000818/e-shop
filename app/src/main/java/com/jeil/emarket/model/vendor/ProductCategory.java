package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductCategory {

    @SerializedName("categoryId")
    @Expose
    public int categoryId;

    @SerializedName("categoryName")
    @Expose
    public String categoryName;
}
