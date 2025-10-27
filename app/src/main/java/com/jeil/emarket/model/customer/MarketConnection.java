package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class MarketConnection {

    @SerializedName("agencyPhone")
    @Expose
    public List<String> agencyPhone;

    @SerializedName("commitPhone")
    @Expose
    public List<String> commitPhone;

    @SerializedName("cookPhone")
    @Expose
    public List<String> cookPhone;

    @SerializedName("servicePhone")
    @Expose
    public List<String> servicePhone;

    @SerializedName("techPhone")
    @Expose
    public List<String> techPhone;
}
