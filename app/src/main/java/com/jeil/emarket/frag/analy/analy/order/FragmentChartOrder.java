package com.jeil.emarket.frag.analy.analy.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.chart.ChartOrderAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.analy.analy.FragmentChart;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceVoid;
import com.jeil.emarket.model.vendor.AnalyticsStats;
import com.jeil.emarket.model.vendor.ChartOrder;
import com.jeil.emarket.providers.AnalyticsProvider;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.d.a.t0.d */

public class FragmentChartOrder extends FragmentChart implements BaseInterface, InterfaceVoid {

    /* renamed from: M0 */
    public ChartOrderAdapter f9740M0;

    /* renamed from: b.f.a.g.d.a.t0.d$a */
    public class a extends TypeToken<List<ChartOrder>> {
        public a(FragmentChartOrder fragmentChartOrder) {
        }
    }

    /* renamed from: b.f.a.g.d.a.t0.d$b */
    public class b extends TypeToken<AnalyticsStats> {
        public b(FragmentChartOrder fragmentChartOrder) {
        }
    }

    public FragmentChartOrder(View view, AnalyticsProvider analyticsProvider, BaseActivity activityC1391g1) {
        this.f9694r0 = view;
        this.baseActivity = activityC1391g1;
        this.f9692p0 = analyticsProvider;
        this.f9697u0 = this;
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0, p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            this.f9740M0 = new ChartOrderAdapter(this.baseActivity);
            this.xRecyclerView.setAdapter(this.f9740M0);
            m5172c(this.xRecyclerView.arrayList.get(0), this.baseActivity.getResources().getString(R.string.input_order_customer_id));
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
        new API_PROVIDER(getContext(), "get_chart_orders", this).get("e7/stats/orders", this.jsonObject);
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
            ChartOrder chartOrder = new ChartOrder();
            chartOrder.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(chartOrder);
            }
            ChartOrderAdapter c1786e = this.f9740M0;
            c1786e.arrayList = arrayList;
            c1786e.notifyDataSetChanged();
        } else {
            ChartOrderAdapter c1786e2 = this.f9740M0;
            c1786e2.arrayList = new ArrayList();
            c1786e2.notifyDataSetChanged();
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
        new API_PROVIDER(getContext(), "get_chart_orders", this).get("e7/stats/orders", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    @SuppressLint({"SetTextI18n"})

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_chart_orders")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            this.f9692p0.f10528j.setValue( Integer.valueOf(this.f9138b0));
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9740M0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9740M0.addAll(list);
                } else {
                    this.f9740M0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
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
