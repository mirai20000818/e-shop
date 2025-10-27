package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class ShopCategoryFilter {

    @SerializedName("attributes")
    @Expose
    public List<Attribute> attributes;

    @SerializedName("brands")
    @Expose
    public List<Brand> brands;

    @SerializedName("maxPrice")
    @Expose
    public float maxPrice;

    @SerializedName("vendors")
    @Expose
    public List<Vendor> vendors;

    public static class Attribute {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12420id;

        @SerializedName("items")
        @Expose
        public List<AttributeItem> items;

        @SerializedName("name")
        @Expose
        public String name;

        public static class AttributeItem {

            @SerializedName("color")
            @Expose
            public String color;

            /* renamed from: id */
            @SerializedName("id")
            @Expose
            public int f12421id;

            @SerializedName("image")
            @Expose
            public String image;

            @SerializedName("name")
            @Expose
            public String name;
        }
    }

    public static class Brand {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12422id;

        @SerializedName("image")
        @Expose
        public String image;

        @SerializedName("name")
        @Expose
        public String name;
    }

    public static class Vendor {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12423id;

        @SerializedName("name")
        @Expose
        public String name;
    }
}
