package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.Home;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Product {

    @SerializedName("approvedCode")
    @Expose
    public String approvedCode;

    @SerializedName("attributes")
    @Expose
    public List<Attribute> attributes;

    @SerializedName("brand")
    @Expose
    public String brand;

    @SerializedName("category")
    @Expose
    public int category;

    @SerializedName("categoryName")
    @Expose
    public String categoryName;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("customAttributes")
    @Expose
    public List<CustomAttribute> customAttributes;

    @SerializedName("customMatch")
    @Expose
    public Map<String, String> customMatch;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("discountPercent")
    @Expose
    public String discountPercent;

    @SerializedName("discountRate")
    @Expose
    public String discountRate;

    @SerializedName("discountRules")
    @Expose
    public List<DiscountRule> discountRules;

    @SerializedName("editableAttributes")
    @Expose
    public List<EditableAttribute> editableAttributes;

    @SerializedName("enableBackorder")
    @Expose
    public boolean enableBackOrder;

    @SerializedName("endDate")
    @Expose
    public Date endDate;

    @SerializedName("featuredBanner")
    @Expose
    public Home.Banner featuredBanner;

    @SerializedName("guaranteeDays")
    @Expose
    public int guaranteeDays;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12407id;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("images")
    @Expose
    public List<String> images;

    @SerializedName("isBadgeShow")
    @Expose
    public boolean isBadgeShow;

    @SerializedName("isFeatured")
    @Expose
    public String isFeatured;

    @SerializedName("isFlashSale")
    @Expose
    public Boolean isFlashSale;

    @SerializedName("isNewProducts")
    @Expose
    public boolean isNewProducts;

    @SerializedName("match")
    @Expose
    public Map<Integer, Integer> match;

    @SerializedName("maxPrice")
    @Expose
    public float maxPrice;

    @SerializedName("maxRegularPrice")
    @Expose
    public float maxRegularPrice;

    @SerializedName("minPrice")
    @Expose
    public float minPrice;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("priceApprovedAt")
    @Expose
    public Date priceApprovedAt;

    @SerializedName("priceApprovedNo")
    @Expose
    public String priceApprovedNo;

    @SerializedName("priceNo")
    @Expose
    public String priceNo;

    @SerializedName("rank")
    @Expose
    public int rank;

    @SerializedName("ratingAvg")
    @Expose
    public float ratingAvg;

    @SerializedName("ratingCount")
    @Expose
    public int ratingCount;

    @SerializedName("regularPrice")
    @Expose
    public float regularPrice;

    @SerializedName("respondTime")
    @Expose
    public long respondTime;

    @SerializedName("salePrice")
    @Expose
    public float salePrice;

    @SerializedName("shippingZones")
    @Expose
    public List<String> shippingZones;

    @SerializedName("sku")
    @Expose
    public String sku;

    @SerializedName("startDate")
    @Expose
    public Date startDate;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("stock")
    @Expose
    public int stock;

    @SerializedName("stockThreshold")
    @Expose
    public int stockThreshold;

    @SerializedName("today")
    @Expose
    public Date today;

    @SerializedName("total")
    @Expose
    public float total;

    @SerializedName("tree")
    @Expose
    public String tree;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("variableAttributes")
    @Expose
    public List<VariableAttribute> variableAttributes;

    @SerializedName("variableProducts")
    @Expose
    public List<VariableProduct> variableProducts;

    @SerializedName("vendorId")
    @Expose
    public int vendorId;

    @SerializedName("vendorName")
    @Expose
    public String vendorName;

    @SerializedName("vendorProducts")
    @Expose
    public List<Product> vendorProducts;

    @SerializedName("weight")
    @Expose
    public float weight;

    public static class Attribute {

        @SerializedName("items")
        @Expose
        public List<String> items;

        @SerializedName("name")
        @Expose
        public String name;
    }

    public static class CustomAttribute {

        @SerializedName("isVariable")
        @Expose
        public boolean isVariable;

        @SerializedName("items")
        @Expose
        public List<Item> items;

        @SerializedName("name")
        @Expose
        public String name;

        public static class Item {

            @SerializedName("name")
            @Expose
            public String name;
        }
    }

    public static class DiscountRule {

        @SerializedName("discountPercent")
        @Expose
        public String discountPercent;

        @SerializedName("maxAmount")
        @Expose
        public String maxAmount;

        @SerializedName("minAmount")
        @Expose
        public String minAmount;
    }

    public static class EditableAttribute {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12408id;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("type")
        @Expose
        public String type;

        @SerializedName("unit")
        @Expose
        public String unit;

        @SerializedName("value")
        @Expose
        public List<String> value;
    }

    public static class VariableAttribute {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12409id;

        @SerializedName("items")
        @Expose
        public List<Item> items;

        @SerializedName("name")
        @Expose
        public String name;

        public static class Item {

            @SerializedName("color")
            @Expose
            public String color;

            /* renamed from: id */
            @SerializedName("id")
            @Expose
            public int f12410id;

            @SerializedName("image")
            @Expose
            public String image;

            @SerializedName("name")
            @Expose
            public String name;
        }
    }

    public static class VariableProduct {

        @SerializedName("attributes")
        @Expose
        public List<Attribute> attributes;

        @SerializedName("customAttributes")
        @Expose
        public List<CustomVariation> customAttributes;

        @SerializedName("customMatch")
        @Expose
        public Map<String, String> customMatch;

        @SerializedName("match")
        @Expose
        public Map<Integer, Integer> match;

        @SerializedName("product")
        @Expose
        public Product product;

        public static class Attribute {

            /* renamed from: id */
            @SerializedName("id")
            @Expose
            public String f12411id;

            @SerializedName("item")
            @Expose
            public String item;
        }

        public static class CustomVariation {

            @SerializedName("id")
            @Expose
            public String attribute;

            @SerializedName("name")
            @Expose
            public String item;
        }
    }
}
