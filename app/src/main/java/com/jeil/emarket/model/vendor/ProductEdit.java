package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.Product;
import java.util.List;


public class ProductEdit {

    @SerializedName("costPrice")
    @Expose
    public float costPrice;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12442id;

    @SerializedName("isFeatured")
    @Expose
    public boolean isFeatured;

    @SerializedName("regularPrice")
    @Expose
    public float regularPrice;

    @SerializedName("salePrice")
    @Expose
    public float salePrice;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("variations")
    @Expose
    public List<Product.VariableProduct> variations;
}
