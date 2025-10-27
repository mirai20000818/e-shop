package com.jeil.emarket.model.vendor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class VendorInfo {

    @SerializedName("level")
    @Expose
    public List<VendorLevel> level;

    @SerializedName("vendor")
    @Expose
    public Vendor vendor;
}
