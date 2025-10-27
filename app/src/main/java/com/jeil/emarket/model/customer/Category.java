package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class Category {

    @SerializedName("children")
    @Expose
    public List<Category> children;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12393id;

    @SerializedName("img")
    @Expose
    public String img;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("products_count")
    @Expose
    public int productsCount;

    @SerializedName("tree")
    @Expose
    public String tree;

    @SerializedName("type")
    @Expose
    public String type;
}
