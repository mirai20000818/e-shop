package com.jeil.emarket.frag.analy.analy.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.chart.ChartProductAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.analy.analy.FragmentChart;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceVoid;
import com.jeil.emarket.model.vendor.AnalyticsStats;
import com.jeil.emarket.model.vendor.ChartProduct;
import com.jeil.emarket.providers.AnalyticsProvider;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.d.a.u0.d */

public class FragmentChartProduct extends FragmentChart implements BaseInterface, InterfaceVoid {

    /* renamed from: M0 */
    public ChartProductAdapter f9744M0;


    /* renamed from: b.f.a.g.d.a.u0.d$b */
    public class b extends TypeToken<AnalyticsStats> {
        public b(FragmentChartProduct fragmentChartProduct) {
        }
    }

    public FragmentChartProduct(View view, AnalyticsProvider analyticsProvider, BaseActivity activityC1391g1) {
        this.f9694r0 = view;
        this.f9692p0 = analyticsProvider;
        this.baseActivity = activityC1391g1;
        this.f9697u0 = this;
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0, p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            this.f9744M0 = new ChartProductAdapter(this.baseActivity);
            this.xRecyclerView.setAdapter(this.f9744M0);
            m5172c(this.xRecyclerView.arrayList.get(0), this.baseActivity.getResources().getString(R.string.input_product_related));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        try {
            this.jsonObject.put("filter", this.f9696t0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_chart_products", this).get("e7/stats/products", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: W0 */
    public void mo4891W0() {
        super.mo4891W0();
        if (SimpleVM.f8836d || this.f9148l0) {
            //this.xRecyclerView.m2806j(0);
        } else {
            this.f9137a0 = 0;
        }
        if (this.f9689K0) {
            ArrayList arrayList = new ArrayList();
            ChartProduct chartProduct = new ChartProduct();
            chartProduct.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(chartProduct);
            }
            ChartProductAdapter c1787f = this.f9744M0;
            c1787f.arrayList = arrayList;
            c1787f.notifyDataSetChanged();
        } else {
            ChartProductAdapter c1787f2 = this.f9744M0;
            c1787f2.arrayList = new ArrayList();
            c1787f2.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        this.jsonObject = new JSONObject();
        if (this.f9696t0.isNull("startDate")) {
            return;
        }
        try {
            this.jsonObject.put("filter", this.f9696t0.toString());
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("page", this.f9137a0 + 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_chart_products", this).get("e7/stats/products", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    @SuppressLint({"SetTextI18n"})

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_chart_products")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new TypeToken<List<ChartProduct>>(){}.getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            this.f9692p0.f10528j.setValue( Integer.valueOf(this.f9138b0));
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9744M0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9744M0.addAll(list);
                } else {
                    this.f9744M0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
            }
            if (this.xRecyclerView.view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) this.xRecyclerView.view).setState(2);
            }
            this.f9692p0.f10527i.setValue( new Gson().fromJson(jSONObject.getString("stats"), new b(this).getType()));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_failed, "error");
            this.baseActivity.finish();
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2707a
    /* renamed from: f */
    public void mo5208f() {
        mo4891W0();
    }
}
