package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class Home {

    @SerializedName("apk")
    @Expose
    public Apk apk;

    @SerializedName("avatarCount")
    @Expose
    public int avatarCount;

    @SerializedName("enableSocket")
    @Expose
    public boolean enableSocket;

    @SerializedName("featuredBanners")
    @Expose
    public List<Banner> featuredBanners;

    @SerializedName("introductions")
    @Expose
    public Introduction introductions;

    @SerializedName("lowStockLimit")
    @Expose
    public int lowStockLimit;

    @SerializedName("midBanners")
    @Expose
    public List<Banner> midBanners;

    @SerializedName("search")
    @Expose
    public List<String> search;

    @SerializedName("topBanners")
    @Expose
    public List<Banner> topBanners;

    @SerializedName("topSearchTerms")
    @Expose
    public List<String> topSearchTerms;

    public static class Apk {

        @SerializedName("file")
        @Expose
        public String file;

        @SerializedName("isDownload")
        @Expose
        public boolean isDownload;

        @SerializedName("message")
        @Expose
        public String[] message;

        @SerializedName("size")
        @Expose
        public int size;

        @SerializedName("version")
        @Expose
        public String version;
    }

    public static class Banner {

        @SerializedName("link")
        @Expose
        public String link;

        @SerializedName("priority")
        @Expose
        public int priority;

        @SerializedName("url")
        @Expose
        public String url;
    }

    public static class Introduction {

        @SerializedName("cookSiteBanner")
        @Expose
        public String cookSiteBanner;

        @SerializedName("cookSitePackage")
        @Expose
        public String cookSitePackage;

        @SerializedName("cookSiteUrl")
        @Expose
        public String cookSiteUrl;

        @SerializedName("newProduct")
        @Expose
        public String newProduct;

        @SerializedName("service")
        @Expose
        public String service;

        @SerializedName("vendorCount")
        @Expose
        public int vendorCount;

        @SerializedName("vendors")
        @Expose
        public String vendors;
    }
}
