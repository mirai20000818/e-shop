package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.ShopCategoryFilter;
import java.util.List;


public class ShopFilter {

    @SerializedName("attributes")
    @Expose
    public List<Attribute> attributes;

    @SerializedName("available_max_price")
    @Expose
    public float availableMaxPrice;

    @SerializedName("brand")
    @Expose
    public ShopCategoryFilter.Brand brand;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("is_discounted")
    @Expose
    public boolean isDiscounted;

    @SerializedName("is_featured")
    @Expose
    public boolean isFeatured;

    @SerializedName("is_in_stock")
    @Expose
    public boolean isInStock;

    @SerializedName("max_price")
    @Expose
    public float maxPrice;

    @SerializedName("min_price")
    @Expose
    public float minPrice;

    @SerializedName("vendor")
    @Expose
    public ShopCategoryFilter.Vendor vendor;

    public static class Attribute {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12424id;

        @SerializedName("item")
        @Expose
        public int item;

        @SerializedName("item_name")
        @Expose
        public String itemName;

        @SerializedName("name")
        @Expose
        public String name;
    }
}
