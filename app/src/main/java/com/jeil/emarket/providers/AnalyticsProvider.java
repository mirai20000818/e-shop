package com.jeil.emarket.providers;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.jeil.emarket.model.vendor.AnalyticsChart;
import com.jeil.emarket.model.vendor.AnalyticsOverviewData;
import com.jeil.emarket.model.vendor.AnalyticsStats;
import com.jeil.emarket.model.vendor.ChartParam;
import com.jeil.emarket.model.vendor.DashboardOrderChart;
import com.jeil.emarket.model.vendor.DashboardSaleChart;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.m.w */

public class AnalyticsProvider extends ViewModel implements BaseInterface {

    
    public MutableLiveData<DashboardSaleChart> f10522d = new MutableLiveData<>();

    
    public MutableLiveData<DashboardOrderChart> f10523e = new MutableLiveData<>();

    /* renamed from: f */
    public MutableLiveData<AnalyticsChart> f10524f = new MutableLiveData<>();

    /* renamed from: g */
    public MutableLiveData<ChartParam> f10525g = new MutableLiveData<>();

    /* renamed from: h */
    public MutableLiveData<ChartParam> f10526h = new MutableLiveData<>();

    
    public MutableLiveData<AnalyticsStats> f10527i = new MutableLiveData<>();

   
    public MutableLiveData<Integer> f10528j = new MutableLiveData<>();

    
    public MutableLiveData<AnalyticsOverviewData> f10529k = new MutableLiveData<>();

    /* renamed from: l */
    public MutableLiveData<Boolean> f10530l = new MutableLiveData<>();


    public void m5659a(Context context, java.lang.String str, java.lang.String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startDate", str);
            jSONObject.put("endDate", str2);
            jSONObject.put("metric", "overview");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(context, "get_analytics_overview_data", this).get("e7/stats/overview", jSONObject);
    }


    public void m5660a(Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        java.lang.String str9;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subMetric", str2);
            jSONObject.put("period", str3);
            jSONObject.put("prevStartDate", str6);
            jSONObject.put("prevEndDate", str7);
            jSONObject.put("startDate", str4);
            jSONObject.put("endDate", str5);
            if (str2.equals("saleTotal") && str8 != null && !str8.isEmpty()) {
                jSONObject.put("currency", str8);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER APIS = new API_PROVIDER(context, str, this);
        switch (str) {
            case "get_products_sold_graph":
                str9 = "e7/stats/graph/productsSold";
                break;
            case "get_order_total_graph":
                str9 = "e7/stats/graph/orderTotal";
                break;
            case "get_sale_total_graph":
                str9 = "e7/stats/graph/saleTotal";
                break;
            case "get_orders_graph":
                str9 = "e7/stats/graph/orders";
                break;
            case "get_profit_graph":
                str9 = "e7/stats/graph/profit";
                break;
            case "get_refund_graph":
                str9 = "e7/stats/graph/refund";
                break;
            case "get_discount_graph":
                str9 = "e7/stats/graph/discount";
                break;
            case "get_shipping_graph":
                str9 = "e7/stats/graph/shipping";
                break;
            case "get_fee_graph":
                str9 = "e7/stats/graph/fee";
                break;
            case "get_avg_total_graph":
                str9 = "e7/stats/graph/avgTotal";
                break;
            case "get_avg_products_graph":
                str9 = "e7/stats/graph/avgProducts";
                break;
            default:
                return;
        }
        APIS.get(str9, jSONObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -2068022322) {
            if (hashCode != -1732046606) {
                if (hashCode == -1492707916 && str2.equals("get_order_graph")) {
                    c2 = 1;
                }
            } else if (str2.equals("get_sales_graph")) {
                c2 = 0;
            }
        } else if (str2.equals("get_analytics_overview_data")) {
            c2 = 2;
        }
        if (c2 == 0) {
            try {
                this.f10522d.setValue( new Gson().fromJson(str, new TypeDashboardSaleChart(this).getType()));
                return;
            } catch (Exception e2) {
                CustomString.m3173a(str2, ": Gson Exception is ", e2);
                return;
            }
        }
        if (c2 == 1) {
            try {
                this.f10523e.setValue( new Gson().fromJson(str, new TypeDashboardOrderChart(this).getType()));
                return;
            } catch (Exception e3) {
                CustomString.m3173a(str2, ": Gson Exception is ", e3);
                return;
            }
        }
        if (c2 == 2) {
            try {
                this.f10529k.setValue( new Gson().fromJson(str, new TypeAnalyticsOverviewData(this).getType()));
                return;
            } catch (Exception e4) {
                CustomString.m3173a(str2, ": Gson Exception is ", e4);
                return;
            }
        }
        try {
            this.f10524f.setValue( new Gson().fromJson(str, new TypeAnalyticsChart(this).getType()));
        } catch (Exception e5) {
            this.f10530l.setValue( true);
            java.lang.String str3 = str2 + ": Gson Exception is";
            e5.getLocalizedMessage();
        }
    }

    
    public void m5661b(Context context, java.lang.String str, java.lang.String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startDate", str);
            jSONObject.put("endDate", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(context, "get_order_graph", this).get("e7/dashboard/orders", jSONObject);
    }

    
    public void m5662c(Context context, java.lang.String str, java.lang.String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startDate", str);
            jSONObject.put("endDate", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(context, "get_sales_graph", this).get("e7/dashboard/sales", jSONObject);
    }
}
