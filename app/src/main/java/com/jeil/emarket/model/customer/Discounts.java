package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class Discounts {

    @SerializedName("fbts")
    @Expose
    public Fbts fbts;

    public static class Fbt {

        @SerializedName("count")
        @Expose
        public int count;

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12399id;

        @SerializedName("products")
        @Expose
        public List<Integer> products;
    }

    public static class Fbts {

        @SerializedName("items")
        @Expose
        public List<Fbt> items;
    }
}
