package com.jeil.emarket.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import com.jeil.emarket.components.pickerview.p220l.p222b.InterfaceC2132a;


public class AddressData implements InterfaceC2132a {

    @SerializedName("cities")
    @Expose
    public List<City> cities;

    @SerializedName("label")
    @Expose
    public String label;

    @SerializedName("name")
    @Expose
    public String name;

    public static class City {

        @SerializedName("dongs")
        @Expose
        public List<Dong> dongs;

        @SerializedName("label")
        @Expose
        public String label;

        @SerializedName("name")
        @Expose
        public String name;

        public static class Dong {

            @SerializedName("label")
            @Expose
            public String label;

            @SerializedName("name")
            @Expose
            public String name;
        }
    }

    @Override // p078b.p159f.p160a.p190c.p214w.p220l.p222b.InterfaceC2132a
    public String getPickerViewText() {
        return this.label;
    }
}
