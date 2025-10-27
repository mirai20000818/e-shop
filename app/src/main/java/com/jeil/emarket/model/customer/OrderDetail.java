package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;


public class OrderDetail {

    @SerializedName("deliveryTime")
    @Expose
    public Date deliveryTime;

    @SerializedName("orderCreatedAt")
    @Expose
    public Date orderCreatedAt;

    @SerializedName("orderNotes")
    @Expose
    public List<OrderNote> orderNotes;

    @SerializedName("orderProductCount")
    @Expose
    public int orderProductCount;

    @SerializedName("orderStatus")
    @Expose
    public String orderStatus;

    @SerializedName("reasons")
    @Expose
    public List<String> reasons;

    @SerializedName("shipping")
    @Expose
    public ShippingInfo shipping;

    @SerializedName("totalAmount")
    @Expose
    public OrderTotalAmount totalAmount;

    @SerializedName("vendors")
    @Expose
    public List<SubOrder> vendors;

    public class OrderTotalAmount {

        @SerializedName("kpf")
        @Expose
        public float kpf;

        @SerializedName("kpw")
        @Expose
        public float kpw;

        @SerializedName("oldKpf")
        @Expose
        public float oldKpf;

        @SerializedName("oldKpw")
        @Expose
        public float oldKpw;

        public OrderTotalAmount() {
        }
    }
}
