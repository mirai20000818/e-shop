package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.Product;
import java.util.List;


public class CartProduct {

    @SerializedName("checked")
    @Expose
    public boolean checked;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("discountId")
    @Expose
    public int discountId;

    @SerializedName("discountPriceKpf")
    @Expose
    public float discountPriceKpf;

    @SerializedName("discountPriceKpw")
    @Expose
    public float discountPriceKpw;

    @SerializedName("discountProducts")
    @Expose
    public String discountProducts;

    @SerializedName("discountRules")
    @Expose
    public List<Product.DiscountRule> discountRules;

    @SerializedName("discountType")
    @Expose
    public String discountType;

    @SerializedName("enableBackOrder")
    @Expose
    public boolean enableBackOrder;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12392id;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("parentId")
    @Expose
    public int parentId;

    @SerializedName("priceKpf")
    @Expose
    public float priceKpf;

    @SerializedName("priceKpw")
    @Expose
    public float priceKpw;

    @SerializedName("products")
    @Expose
    public List<CartProduct> products;

    @SerializedName("quantity")
    @Expose
    public int quantity;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    @SerializedName("vendorName")
    @Expose
    public String vendorName;
}
