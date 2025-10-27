package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jeil.emarket.model.customer.Faq;
import java.util.List;


public class VendorBusinessInfo {

    @SerializedName("categories")
    @Expose
    public List<Integer> categories;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("enableShippingPrice")
    @Expose
    public Boolean enableShippingPrice;

    @SerializedName("enableTicket")
    @Expose
    public Boolean enableTicket;

    @SerializedName("faq")
    @Expose
    public List<Faq> faq;

    @SerializedName("payType")
    @Expose
    public List<String> payType;

    @SerializedName("refundService")
    @Expose
    public String refundService;
}
