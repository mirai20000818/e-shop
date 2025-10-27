package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PasswordFaq {

    @SerializedName("answer")
    @Expose
    public String answer;

    @SerializedName("questionId")
    @Expose
    public int questionId;
}
