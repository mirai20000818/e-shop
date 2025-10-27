package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class VendorEditProduct {

    @SerializedName("change")
    @Expose
    public List<VendorEditVariation> change;

    @SerializedName("origin")
    @Expose
    public List<VendorEditVariation> origin;

    public static class VendorEditVariation {

        /* renamed from: id */
        @SerializedName("id")
        @Expose
        public int f12450id;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("regularPrice")
        @Expose
        public float regularPrice;

        @SerializedName("salePrice")
        @Expose
        public float salePrice;

        @SerializedName("sku")
        @Expose
        public String sku;

        @SerializedName("stock")
        @Expose
        public int stock;

        @SerializedName("stockThreshold")
        @Expose
        public int stockThreshold;
    }
}
