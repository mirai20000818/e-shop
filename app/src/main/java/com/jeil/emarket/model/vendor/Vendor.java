package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.Faq;
import java.util.Date;
import java.util.List;


public class Vendor {

    @SerializedName("approvedAt")
    @Expose
    public String approvedAt;

    @SerializedName("avgDeliveryPoint")
    @Expose
    public Float avgDeliveryPoint;

    @SerializedName("avgServicePoint")
    @Expose
    public Float avgServicePoint;

    @SerializedName("avgSupportPoint")
    @Expose
    public Float avgSupportPoint;

    @SerializedName("card")
    @Expose
    public String card;

    @SerializedName("categories")
    @Expose
    public int[] categories;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("deliveryPoint")
    @Expose
    public Float deliveryPoint;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("enableTicket")
    @Expose
    public Boolean enableTicket;

    @SerializedName("endDate")
    @Expose
    public Date endDate;

    @SerializedName("faq")
    @Expose
    public List<Faq> faq;

    @SerializedName("feeExpiredDate")
    @Expose
    public Date feeExpiredDate;

    @SerializedName("hideName")
    @Expose
    public boolean hideName;

    /* renamed from: id */
    @SerializedName("id")
    @Expose
    public int f12449id;

    @SerializedName("level")
    @Expose
    public int level;

    @SerializedName("logo")
    @Expose
    public String logo;

    @SerializedName("maxMediaCount")
    @Expose
    public int maxMediaCount;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("payType")
    @Expose
    public List<String> payType;

    @SerializedName("point")
    @Expose
    public int point;

    @SerializedName("productsCount")
    @Expose
    public int productsCount;

    @SerializedName("refundService")
    @Expose
    public String refundService;

    @SerializedName("servicePoint")
    @Expose
    public Float servicePoint;

    @SerializedName("shippingAreas")
    @Expose
    public List<String> shippingAreas;

    @SerializedName("shippingCurrency")
    @Expose
    public String shippingCurrency;

    @SerializedName("shippingSettings")
    @Expose
    public String shippingSettings;

    @SerializedName("startDate")
    @Expose
    public Date startDate;

    @SerializedName("stockThreshold")
    @Expose
    public int stockThreshold;

    @SerializedName("supportPoint")
    @Expose
    public Float supportPoint;

    @SerializedName("type")
    @Expose
    public String type;

    public static class Advanced {
        public String name;
        public String value;

        public Advanced(String str, String str2) {
            this.name = str;
            this.value = str2;
        }
    }
}
