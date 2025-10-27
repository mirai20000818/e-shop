package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Faq {

    @SerializedName("answer")
    @Expose
    public String answer;

    @SerializedName("question")
    @Expose
    public String question;

    @SerializedName("type")
    @Expose
    public String type;
}
