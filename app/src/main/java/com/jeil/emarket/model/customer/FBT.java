package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class FBT {

    @SerializedName("discount")
    @Expose
    public float discount;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12400id;

    @SerializedName("oldTotal")
    @Expose
    public Price oldTotal;

    @SerializedName("products")
    @Expose
    public List<Product> products;

    @SerializedName("total")
    @Expose
    public Price total;

    @SerializedName("type")
    @Expose
    public String type;

    public static class Price {

        @SerializedName("kpf")
        @Expose
        public float kpf;

        @SerializedName("kpw")
        @Expose
        public float kpw;
    }

    public static class Product {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12401id;

        @SerializedName("image")
        @Expose
        public String image;
    }
}
