package com.jeil.emarket.frag.analy.analy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.ChartLineView;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.InterfaceVoid;
import com.jeil.emarket.model.vendor.AnalyticsChart;
import com.jeil.emarket.model.vendor.ChartParam;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.providers.AnalyticsProvider;
import com.jeil.emarket.viewmodel.VendorListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: b.f.a.g.d.a.n0 */

public class FragmentChart extends BaseFragment {

    /* renamed from: F0 */
    public ChartLineView f9684F0;

    /* renamed from: p0 */
    public AnalyticsProvider f9692p0;

    /* renamed from: q0 */
    public View f9693q0;

    /* renamed from: r0 */
    public View f9694r0;

    /* renamed from: s0 */
    public View f9695s0;

    /* renamed from: u0 */
    public InterfaceVoid f9697u0;

    /* renamed from: v0 */
    public Calendar f9698v0;

    /* renamed from: w0 */
    public Calendar f9699w0;

    /* renamed from: o0 */
    public java.lang.String f9691o0 = "";

    /* renamed from: t0 */
    public JSONObject f9696t0 = new JSONObject();

    /* renamed from: x0 */
    public java.lang.String f9700x0 = "";

    /* renamed from: y0 */
    public java.lang.String f9701y0 = "";

    /* renamed from: z0 */
    public java.lang.String f9702z0 = "";

    /* renamed from: A0 */
    public java.lang.String f9679A0 = "";

    /* renamed from: B0 */
    public java.lang.String f9680B0 = "";

    /* renamed from: C0 */
    public java.lang.String f9681C0 = "";

    /* renamed from: D0 */
    public int f9682D0 = 0;

    /* renamed from: E0 */
    public ChartParam f9683E0 = new ChartParam();

    /* renamed from: G0 */
    public MutableLiveData<java.lang.String> f9685G0 = new MutableLiveData<>();

    /* renamed from: H0 */
    public ArrayList<ArrayList<Float>> f9686H0 = new ArrayList<>();

    /* renamed from: I0 */
    public ArrayList<Float> f9687I0 = new ArrayList<>();

    /* renamed from: J0 */
    public ArrayList<Float> f9688J0 = new ArrayList<>();

    /* renamed from: K0 */
    public boolean f9689K0 = true;

    /* renamed from: L0 */
    public int f9690L0 = 450;

    public FragmentChart() {
        m5144Z0();
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"SetTextI18n"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f9689K0;
            xRecyclerView.f12377b1 = true;
            final View inflate = getLayoutInflater().inflate(R.layout.layout_date_picker, (ViewGroup) null);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
            int i = BaseActivity.anInt2;
            c0541a.setMargins(i, 0, i, 0);
            inflate.setLayoutParams(c0541a);
            m5153a(inflate, "table");
            m5185r(inflate);
            m5160a(this.f9692p0);
            inflate.findViewById(R.id.ll_unit_selector).setVisibility(View.GONE);
            ((ActionLink) inflate.findViewById(R.id.cal_chart_interval)).setText(this.f9683E0.selectedInterval);
            this.f9692p0.f10526h.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.u
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    ((ActionLink) inflate.findViewById(R.id.cal_chart_interval)).setText(((ChartParam) obj).selectedInterval);
                }
            });
            this.xRecyclerView.addView(inflate);
            View inflate2 = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate2.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_chart_pie);
            ((TextView) inflate2.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
            this.xRecyclerView.setEmptyView(inflate2);
            this.xRecyclerView.header = ((int) getResources().getDimension(R.dimen.main_header_height)) + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    /* renamed from: Z0 */
    public void m5144Z0() {
        this.f9698v0 = Calendar.getInstance();
        this.f9699w0 = Calendar.getInstance();
        this.f9698v0.add(5, -29);
        this.f9683E0.startDate = Util.date2Str(this.f9698v0.getTime());
        this.f9683E0.endDate = Util.date2Str(this.f9699w0.getTime());
        ChartParam chartParam = this.f9683E0;
        chartParam.search = "";
        chartParam.period = "day";
        this.f9682D0 = 1;
        try {
            this.f9696t0.put("startDate", chartParam.startDate);
            this.f9696t0.put("endDate", this.f9683E0.endDate);
            this.f9696t0.put("withStats", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public  void m5145a(View view, View view2) {
        m5175d(view, "saleTotal");
    }


    public  void m5146a(View view, View view2, Integer num) {
        if (num.intValue() != 0) {
            m5178k(view);
        } else {
            m5187t(view);
            m5185r(view2);
        }
    }


    public  void m5147a(View view, CompoundButton compoundButton, boolean z) {
        m5184q(view);
    }


    public void m5148a(final View view, final AnalyticsProvider analyticsProvider) {
        m5151a(view, this.f9684F0, analyticsProvider);
        this.f9683E0.metric = this.f9685G0.getValue();
        if (VendorListVM.f10363d.getValue() != null && VendorListVM.f10363d.getValue().currency.equals("kpwf")) {
            this.f9683E0.currency = "kpf";
        }
        analyticsProvider.f10525g.setValue( this.f9683E0);
        analyticsProvider.f10525g.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.h
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentChart.this.m5150a(view, analyticsProvider, (ChartParam) obj);
            }
        });
    }


    public void m5149a(final View view, AnalyticsProvider analyticsProvider, final View view2) {
        this.f9695s0 = view.findViewById(R.id.empty);
        this.f9695s0.setLayoutParams(new FrameLayout.LayoutParams(-1, Util.dp2px((Context) this.baseActivity, this.f9690L0)));
        ((TextView) this.f9695s0.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
        ((AppCompatImageView) this.f9695s0.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_chart_pie);
        analyticsProvider.f10528j.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.i
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentChart.this.m5146a(view2, view, (Integer) obj);
            }
        });
    }


    public  void m5150a(View view, AnalyticsProvider analyticsProvider, ChartParam chartParam) {
        if (chartParam.startDate.equals(this.f9700x0) && chartParam.endDate.equals(this.f9701y0) && chartParam.period.equals(this.f9702z0) && chartParam.metric.equals(this.f9679A0) && chartParam.currency.equals(this.f9681C0)) {
            return;
        }
        mo5177e(this.f9694r0, "");
        ((ActionLink) view.findViewById(R.id.cal_chart_interval)).setText(chartParam.selectedInterval);
        analyticsProvider.m5660a(this.baseActivity, this.f9691o0, chartParam.metric, chartParam.period, chartParam.startDate, chartParam.endDate, chartParam.prevStartDate, chartParam.prevEndDate, chartParam.currency);
        this.f9700x0 = chartParam.startDate;
        java.lang.String str = chartParam.endDate;
        this.f9701y0 = str;
        this.f9702z0 = chartParam.period;
        this.f9679A0 = chartParam.metric;
        this.f9681C0 = chartParam.currency;
        long time = Util.m359i(str).getTime() - Util.m359i(chartParam.startDate).getTime();
        View findViewById = view.findViewById(R.id.cal_chart_unit);
        if (time < 86400000) {
            findViewById.setVisibility(View.GONE);
        } else {
            findViewById.setVisibility(View.VISIBLE);
        }
        if (!chartParam.metric.equals("saleTotal") || chartParam.currency == null) {
            view.findViewById(R.id.cal_currency).setVisibility(View.GONE);
        } else {
            view.findViewById(R.id.cal_currency).setVisibility(View.VISIBLE);
            ((ActionLink) view.findViewById(R.id.cal_currency)).setText(Util.getIdentifier(this.baseActivity, chartParam.currency, getResources().getString(R.string.kpf)));
        }
    }

    @SuppressLint({"SetTextI18n"})

    public void m5151a(final View view, final ChartLineView chartLineView, final AnalyticsProvider analyticsProvider) {
        chartLineView.setColorArray(new int[]{getResources().getColor(R.color.chart_secondary), getResources().getColor(R.color.chart_primary)});
        chartLineView.m6816c();
        chartLineView.setShowPopup(3);
        analyticsProvider.f10524f.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.q
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentChart.this.m5161a(chartLineView, view, analyticsProvider, (AnalyticsChart) obj);
            }
        });
    }


    public  void m5152a(View view, Integer num) {
        if (num.intValue() != 0) {
            mo5167b(view, "");
        }
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})

    public void m5153a(final View view, final java.lang.String str) {
        this.f9683E0.selectedInterval = getContext().getResources().getString(R.string.recent_one_month);
        java.lang.String[] m287a = Util.m287a(this.f9698v0.getTime(), new Date());
        if (m287a.length > 1) {
            ChartParam chartParam = this.f9683E0;
            chartParam.prevStartDate = m287a[0];
            chartParam.prevEndDate = m287a[1];
        }
        view.findViewById(R.id.cal_chart_interval).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentChart.this.m5154a(view, str, view2);
            }
        });
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m5156a(View view, int[] iArr, Boolean bool) {
        for (int i : iArr) {
            view.findViewById(i).setVisibility(bool.booleanValue() ? View.VISIBLE : View.GONE);
        }
        ((ButtonToggle) view.findViewById(R.id.cbt_orders)).setText(getResources().getString(R.string.order));
    }


    public void m5157a(final BaseActivity activityC1391g1, AnalyticsProvider analyticsProvider) {
        analyticsProvider.f10530l.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.d
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentChart.this.m5158a(activityC1391g1, (Boolean) obj);
            }
        });
    }


    public  void m5158a(BaseActivity activityC1391g1, Boolean bool) {
        if (bool.booleanValue()) {
            Util.toast(activityC1391g1, activityC1391g1.getString(R.string.server_failed), "error", 0, 0);
            startActivity(new Intent(activityC1391g1, MainActivityForVendor.class));
            activityC1391g1.finish();
        }
    }


    public void m5160a(AnalyticsProvider analyticsProvider) {
        analyticsProvider.f10526h.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.z
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentChart.this.m5162a((ChartParam) obj);
            }
        });
    }


    public  void m5161a(ChartLineView chartLineView, final View view, AnalyticsProvider analyticsProvider, AnalyticsChart analyticsChart) {
        java.lang.String string;
        ArrayList arrayList;
        Float valueOf;
        ArrayList<java.lang.String> arrayList2 = new ArrayList<>();
        this.f9687I0.clear();
        this.f9688J0.clear();
        this.f9686H0.clear();
        for (int i = 0; i < analyticsChart.data.date.size(); i++) {
            arrayList2.add(analyticsChart.data.date.get(i).length() > 5 ? analyticsChart.data.date.get(i).substring(5) : analyticsChart.data.date.get(i));
            this.f9687I0.add(analyticsChart.data.value.get(i));
            if (i < analyticsChart.prevData.value.size()) {
                arrayList = this.f9688J0;
                valueOf = analyticsChart.prevData.value.get(i);
            } else {
                arrayList = this.f9688J0;
                valueOf = Float.valueOf(0.0f);
            }
            arrayList.add(valueOf);
        }
        this.f9686H0.add(this.f9688J0);
        this.f9686H0.add(this.f9687I0);
        if (this.f9683E0.metric.equals("productsSold") || this.f9683E0.metric.equals("orders")) {
            string = getResources().getString(R.string.count_unit);
        } else {
            string = getResources().getString(R.string.won);
            MutableLiveData<Vendor> mutableLiveData = VendorListVM.f10363d;
            if (mutableLiveData != null && mutableLiveData.getValue() != null && VendorListVM.f10363d.getValue().currency != null && VendorListVM.f10363d.getValue().currency.equals("kpf")) {
                string = "";
            }
        }
        chartLineView.setGraphUnit(string);
        chartLineView.setBottomTextList(arrayList2);
        chartLineView.setFloatDataList(this.f9686H0);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.a.p
            @Override // java.lang.Runnable
            public final void run() {
                ((HorizontalScrollView) view.findViewById(R.id.hsv_chart)).fullScroll(66);
            }
        }, Status.f8814e);
        ((TextView) view.findViewById(R.id.tv_current_period)).setText(analyticsProvider.f10525g.getValue().startDate + " ~ " + analyticsProvider.f10525g.getValue().endDate);
        TextView textView = (TextView) view.findViewById(R.id.tv_prev_period);
        StringBuilder sb = new StringBuilder();
        sb.append(analyticsProvider.f10525g.getValue().prevStartDate);
        sb.append(" ~ ");
        CustomString.m3175a(sb, analyticsProvider.f10525g.getValue().prevEndDate, textView);
        BaseActivity activityC1391g1 = this.baseActivity;
        StringBuilder m3163a = CustomString.format("per_");
        m3163a.append(analyticsProvider.f10525g.getValue().period);
        ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setText(Util.getIdentifier(activityC1391g1, m3163a.toString(), ""));
        if (this.f9683E0.metric.equals("saleTotal") && analyticsProvider.f10525g.getValue().currency != null) {
            ((ActionLink) view.findViewById(R.id.cal_currency)).setText(Util.getIdentifier(this.baseActivity, analyticsProvider.f10525g.getValue().currency, getResources().getString(R.string.kpf)));
        }
        analyticsProvider.f10528j.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.c
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentChart.this.m5152a(view, (Integer) obj);
            }
        });
    }


    public  void m5162a(ChartParam chartParam) {
        if (this.f9700x0.equals(chartParam.startDate) && this.f9701y0.equals(chartParam.endDate) && this.f9680B0.equals(chartParam.search)) {
            return;
        }
        try {
            this.f9696t0.put("startDate", chartParam.startDate);
            this.f9696t0.put("endDate", chartParam.endDate);
            this.f9696t0.put("search", chartParam.search);
            this.f9696t0.put("withStats", true);
            if (this.f9697u0 != null) {
                this.f9697u0.mo5208f();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9700x0 = chartParam.startDate;
        this.f9701y0 = chartParam.endDate;
    }


    public  boolean m5164a(View view, android.widget.TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        this.f9683E0.search = ((EditForm) view.findViewById(R.id.cef_analytics_search)).getText();
        this.f9692p0.f10526h.setValue( this.f9683E0);
        return true;
    }


    public  void m5165b(View view, View view2) {
        m5175d(view, "orders");
    }


    public  void m5166b(View view, CompoundButton compoundButton, boolean z) {
        m5184q(view);
    }


    public void mo5167b(View view, java.lang.String str) {
        int i;
        m5185r(view);
        char c2 = 65535;
        if (!str.equals("customer")) {
            view.findViewById(R.id.hsv_chart).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a.setMargins(0, Util.dp2px((Context) this.baseActivity, -10), 0, Util.dp2px((Context) this.baseActivity, 12));
            view.findViewById(R.id.hsv_chart).setLayoutParams(c0541a);
            view.findViewById(R.id.line_view).setAlpha(1.0f);
            CustomString.m3167a(view, R.id.tv_shimmer_1, 8, R.id.tv_shimmer_2, 8);
            CustomString.m3167a(view, R.id.tv_current_interval, 8, R.id.tv_prev_interval, 8);
            CustomString.m3167a(view, R.id.ccb_current_interval, 0, R.id.ccb_prev_interval, 0);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_current_period_label), R.color.body);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_current_period), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_prev_period_label), R.color.body);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_prev_period), R.color.dark);
            ((ShimmerFrameLayout) view.findViewById(R.id.sfl_analytics_chart)).hideShimmer();
        }
        if (str.equals("product") || str.equals("category")) {
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_graph_title), R.color.dark);
        } else {
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_data_analytics_title), R.color.dark);
            ((ShimmerFrameLayout) view.findViewById(R.id.sfl_data_analytics)).hideShimmer();
        }
        if (view.findViewById(R.id.tv_stats_orders) != null) {
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_orders), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_orders_label), R.color.body);
        }
        if (view.findViewById(R.id.tv_products_sold) != null) {
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_products_sold), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_products_sold_label), R.color.body);
        }
        if (view.findViewById(R.id.tv_stats_sale_total) != null) {
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_sale_total_label), R.color.body);
            view.findViewById(R.id.tv_stats_sale_total).setVisibility(View.GONE);
            view.findViewById(R.id.pt_stats_kpf_sale_total).setVisibility(View.VISIBLE);
            view.findViewById(R.id.pt_stats_kpw_sale_total).setVisibility(View.VISIBLE);
        }
        int hashCode = str.hashCode();
        if (hashCode != -979812796) {
            if (hashCode != 106006350) {
                if (hashCode == 606175198 && str.equals("customer")) {
                    c2 = 2;
                }
            } else if (str.equals("order")) {
                c2 = 0;
            }
        } else if (str.equals("profit")) {
            c2 = 1;
        }
        if (c2 == 0) {
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_completed_orders), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_completed_orders_label), R.color.body);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_cancelled_orders), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_cancelled_orders_label), R.color.body);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_products_sold), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_products_sold_label), R.color.body);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_customers), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_customers_label), R.color.body);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_flow_label), R.color.body);
            view.findViewById(R.id.tv_stats_flow).setVisibility(View.GONE);
            view.findViewById(R.id.pt_kpf_stats_flow).setVisibility(View.VISIBLE);
            i = R.id.pt_kpw_stats_flow;
        } else {
            if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_guests), R.color.dark);
                Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_guests_label), R.color.body);
                Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_avg_orders), R.color.dark);
                Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_avg_orders_label), R.color.body);
                return;
            }
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_days), R.color.dark);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_days_label), R.color.body);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_shipping_label), R.color.body);
            view.findViewById(R.id.tv_stats_shipping).setVisibility(View.GONE);
            view.findViewById(R.id.pt_stats_shipping).setVisibility(View.VISIBLE);
            Util.setColor(this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_fee_label), R.color.body);
            view.findViewById(R.id.tv_stats_fee).setVisibility(View.GONE);
            view.findViewById(R.id.pt_kpf_stats_fee).setVisibility(View.VISIBLE);
            i = R.id.pt_kpw_stats_fee;
        }
        view.findViewById(i).setVisibility(View.VISIBLE);
    }


    public  void m5168b(BaseDialog2 baseDialog2, View view, int i) {
        this.f9683E0 = this.f9692p0.f10525g.getValue();
        this.f9683E0.currency = i == 0 ? "kpf" : "kpw";
        this.f9692p0.f10525g.setValue( this.f9683E0);
        baseDialog2.startAni();
    }


    public  void m5171c(View view, View view2) {
        m5175d(view, "productsSold");
    }


    public void m5172c(final View view, java.lang.String str) {
        if (view != null) {
            view.findViewById(R.id.cef_analytics_search).setVisibility(View.VISIBLE);
            ((EditForm) view.findViewById(R.id.cef_analytics_search)).setPlaceHolder(str);
            ((EditForm) view.findViewById(R.id.cef_analytics_search)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentChart.this.m5176e(view, view2);
                }
            });
            ((EditForm) view.findViewById(R.id.cef_analytics_search)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.d.a.k
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(android.widget.TextView textView, int i, KeyEvent keyEvent) {
                    return FragmentChart.this.m5164a(view, textView, i, keyEvent);
                }
            });
        }
    }


    public  void m5173c(BaseDialog2 baseDialog2, View view, int i) {
        mo5177e(this.f9694r0, "customer");
        if (i != 9) {
            Date[] m341d = Util.m341d(i);
            this.f9683E0.startDate = m341d[0] != null ? Util.date2Str(m341d[0]) : "";
            this.f9683E0.endDate = m341d[0] != null ? Util.date2Str(m341d[1]) : "";
            ChartParam chartParam = this.f9683E0;
            chartParam.selectedInterval = Status.day_filter[i];
            this.f9692p0.f10526h.setValue( chartParam);
        } else {
            Picker4 picker4 = new Picker4(this.baseActivity);
            if (this.f9692p0.f10526h.getValue() != null) {
                this.f9698v0.setTime(Util.m359i(this.f9692p0.f10526h.getValue().startDate));
                this.f9699w0.setTime(Util.m359i(this.f9692p0.f10526h.getValue().endDate));
                Calendar calendar = this.f9698v0;
                Calendar calendar2 = this.f9699w0;
                ViewOnClickListenerC2123h viewOnClickListenerC2123h = picker4.f8615b;
                C2108a c2108a = viewOnClickListenerC2123h.f8694c;
                c2108a.f8669s = calendar;
                c2108a.f8670t = calendar2;
                viewOnClickListenerC2123h.m4728f();
            }
            picker4.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.a.y
                @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

                public final void mo4696a(Date date, Date date2, View view2) {
                    FragmentChart.this.m5163a(date, date2, view2);
                }
            };
            picker4.m4704a();
        }
        baseDialog2.startAni();
    }


    public  void m5174d(View view, View view2) {
        m5175d(view, "shipping");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m5175d(View view, java.lang.String str) {
        char c2;
        java.lang.String str2;
        this.f9685G0.setValue(str);
        this.f9683E0.metric = str;
        switch (str.hashCode()) {
            case -1008770331:
                if (str.equals("orders")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -934813832:
                if (str.equals("refund")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -516235858:
                if (str.equals("shipping")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 101254:
                if (str.equals("fee")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 746112150:
                if (str.equals("orderTotal")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1032054872:
                if (str.equals("productsSold")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1929929618:
                if (str.equals("avgTotal")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1947254358:
                if (str.equals("avgProducts")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                str2 = "get_orders_graph";
                break;
            case 1:
                str2 = "get_products_sold_graph";
                break;
            case 2:
                str2 = "get_shipping_graph";
                break;
            case 3:
                str2 = "get_avg_total_graph";
                break;
            case 4:
                str2 = "get_avg_products_graph";
                break;
            case 5:
                str2 = "get_refund_graph";
                break;
            case 6:
                str2 = "get_fee_graph";
                break;
            case 7:
                str2 = "get_order_total_graph";
                break;
            default:
                str2 = "get_sale_total_graph";
                break;
        }
        this.f9691o0 = str2;
        this.f9692p0.f10525g.setValue( this.f9683E0);
        HashMap hashMap = new HashMap();
        hashMap.put("productsSold", view.findViewById(R.id.cbt_products_sold));
        hashMap.put("saleTotal", view.findViewById(R.id.cbt_sale_total));
        hashMap.put("orders", view.findViewById(R.id.cbt_orders));
        hashMap.put("shipping", view.findViewById(R.id.cbt_shipping));
        Object[] array = hashMap.keySet().toArray();
        for (int i = 0; i < hashMap.size(); i++) {
            if (array != null && array[i] != null && hashMap.get(array[i].toString()) != null) {
                if (!array[i].toString().equals(str) || hashMap.get(array[i].toString()) == null) {
                    ((ButtonToggle) Objects.requireNonNull(hashMap.get(array[i].toString()))).m6897e();
                } else {
                    ((ButtonToggle) Objects.requireNonNull(hashMap.get(array[i].toString()))).m6896d();
                }
            }
        }
    }


    public  void m5176e(View view, View view2) {
        this.f9683E0.search = ((EditForm) view.findViewById(R.id.cef_analytics_search)).getText();
        this.f9692p0.f10526h.setValue( this.f9683E0);
    }


    public void mo5177e(View view, java.lang.String str) {
        BaseActivity activityC1391g1;
        int i;
        char c2;
        int i2;
        m5178k(view);
        if (!str.equals("customer")) {
            ((ShimmerFrameLayout) view.findViewById(R.id.sfl_analytics_chart)).showShimmer(true);
            view.findViewById(R.id.hsv_chart).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey_bg)));
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, Util.dp2px((Context) this.baseActivity, 210));
            c0541a.setMargins(Util.dp2px((Context) this.baseActivity, 16), Util.dp2px((Context) this.baseActivity, 10), Util.dp2px((Context) this.baseActivity, 16), Util.dp2px((Context) this.baseActivity, 12));
            view.findViewById(R.id.hsv_chart).setLayoutParams(c0541a);
            view.findViewById(R.id.line_view).setAlpha(0.0f);
            if (str.equals("product") || str.equals("category")) {
                CustomString.m3167a(view, R.id.tv_shimmer_1, 8, R.id.tv_shimmer_2, 8);
            } else {
                CustomString.m3167a(view, R.id.tv_shimmer_1, 0, R.id.tv_shimmer_2, 0);
            }
            CustomString.m3167a(view, R.id.tv_current_interval, 0, R.id.tv_prev_interval, 0);
            CustomString.m3167a(view, R.id.ccb_current_interval, 8, R.id.ccb_prev_interval, 8);
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_current_period_label));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_current_period));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_prev_period_label));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_prev_period));
        }
        if (str.equals("product") || str.equals("category")) {
            activityC1391g1 = this.baseActivity;
            i = R.id.tv_graph_title;
        } else {
            ((ShimmerFrameLayout) view.findViewById(R.id.sfl_data_analytics)).showShimmer(true);
            activityC1391g1 = this.baseActivity;
            i = R.id.tv_data_analytics_title;
        }
        Util.setColor((Context) activityC1391g1, (android.widget.TextView) view.findViewById(i));
        if (view.findViewById(R.id.tv_stats_orders) != null) {
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_orders));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_orders_label));
        }
        if (view.findViewById(R.id.tv_stats_sale_total) != null) {
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_sale_total_label));
            view.findViewById(R.id.tv_stats_sale_total).setVisibility(View.VISIBLE);
            view.findViewById(R.id.pt_stats_kpf_sale_total).setVisibility(View.GONE);
            view.findViewById(R.id.pt_stats_kpw_sale_total).setVisibility(View.GONE);
        }
        if (view.findViewById(R.id.tv_products_sold) != null) {
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_products_sold));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_products_sold_label));
        }
        ActionLink actionLink = (ActionLink) view.findViewById(R.id.cal_currency);
        if (actionLink != null) {
            actionLink.setVisibility(View.GONE);
        }
        int hashCode = str.hashCode();
        if (hashCode == -979812796) {
            if (str.equals("profit")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode != 106006350) {
            if (hashCode == 606175198 && str.equals("customer")) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (str.equals("order")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_completed_orders));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_completed_orders_label));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_cancelled_orders));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_cancelled_orders_label));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_products_sold));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_products_sold_label));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_customers));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_customers_label));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_flow_label));
            view.findViewById(R.id.tv_stats_flow).setVisibility(View.VISIBLE);
            view.findViewById(R.id.pt_kpf_stats_flow).setVisibility(View.GONE);
            i2 = R.id.pt_kpw_stats_flow;
        } else {
            if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_guests));
                Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_guests_label));
                Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_avg_orders));
                Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_avg_orders_label));
                return;
            }
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_days));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_days_label));
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_shipping_label));
            view.findViewById(R.id.tv_stats_shipping).setVisibility(View.VISIBLE);
            view.findViewById(R.id.pt_stats_shipping).setVisibility(View.GONE);
            Util.setColor((Context) this.baseActivity, (android.widget.TextView) view.findViewById(R.id.tv_stats_fee_label));
            view.findViewById(R.id.tv_stats_fee).setVisibility(View.VISIBLE);
            view.findViewById(R.id.pt_kpf_stats_fee).setVisibility(View.GONE);
            i2 = R.id.pt_kpw_stats_fee;
        }
        view.findViewById(i2).setVisibility(View.GONE);
    }

    
    public void m5178k(View view) {
        if (view.findViewById(R.id.llc_analytics_chart) != null) {
            view.findViewById(R.id.llc_analytics_chart).setVisibility(View.VISIBLE);
        }
        if (view.findViewById(R.id.llc_data_analytics) != null) {
            view.findViewById(R.id.llc_data_analytics).setVisibility(View.VISIBLE);
        }
        View view2 = this.f9695s0;
        if (view2 != null) {
            view2.setVisibility(View.GONE);
        } else {
            view.findViewById(R.id.empty).setVisibility(View.GONE);
        }
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    /* renamed from: l */
    public void m5179l(View view) {
        ((ActionLink) view.findViewById(R.id.cal_chart_interval)).setText(getContext().getResources().getString(R.string.recent_one_month));
        view.findViewById(R.id.ll_unit_selector).setVisibility(View.GONE);
        view.findViewById(R.id.cal_chart_interval).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentChart.this.m5181n(view2);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: m */
    public void m5180m(final View view) {
        this.f9692p0.f10526h.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.b
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ((ActionLink) view.findViewById(R.id.cal_chart_interval)).setText(((ChartParam) obj).selectedInterval);
            }
        });
    }

    /* renamed from: n */
    public  void m5181n(View view) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, Status.day_filter);
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.a.o
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                FragmentChart.this.m5173c(baseDialog2, view2, i);
            }
        };
    }

    /* renamed from: o */
    public  void m5182o(View view) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, new java.lang.String[]{getResources().getString(R.string.per_day), getResources().getString(R.string.per_week), getResources().getString(R.string.per_month)});
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.a.w
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                FragmentChart.this.m5159a(baseDialog2, view2, i);
            }
        };
    }

    /* renamed from: p */
    public  void m5183p(View view) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, new java.lang.String[]{getResources().getString(R.string.kpf), getResources().getString(R.string.kpw)});
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.a.v
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                FragmentChart.this.m5168b(baseDialog2, view2, i);
            }
        };
    }

    /* renamed from: q */
    public final void m5184q(View view) {
        ChartLineView chartLineView = this.f9684F0;
        int[] iArr = new int[2];
        iArr[0] = ((CheckBox) view.findViewById(R.id.ccb_prev_interval)).isChecked() ? getResources().getColor(R.color.chart_secondary) : 0;
        iArr[1] = ((CheckBox) view.findViewById(R.id.ccb_current_interval)).isChecked() ? getResources().getColor(R.color.chart_primary) : 0;
        chartLineView.setColorArray(iArr);
        this.f9684F0.m6815b();
        this.f9684F0.setFloatDataList(this.f9686H0);
    }

    /* renamed from: r */
    public void m5185r(View view) {
        view.findViewById(R.id.ll_unit_selector).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setmTextViewColor(BaseActivity.color);
        ((ActionLink) view.findViewById(R.id.cal_chart_unit)).setImageViewColor(BaseActivity.color);
        view.findViewById(R.id.cal_chart_unit).setPadding(Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 5), Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 6));
        view.findViewById(R.id.ll_unit_selector).setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.findViewById(R.id.ll_chart_interval).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        view.findViewById(R.id.cal_chart_interval).setPadding(Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 5), Util.dp2px(getContext(), 10), Util.dp2px(getContext(), 6));
        ((ActionLink) view.findViewById(R.id.cal_chart_interval)).setmTextViewColor(BaseActivity.color);
        ((ActionLink) view.findViewById(R.id.cal_chart_interval)).setImageViewColor(BaseActivity.color);
        view.findViewById(R.id.ll_chart_interval).setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ((ShimmerFrameLayout) view.findViewById(R.id.sfl_date_picker)).hideShimmer();
    }

    /* renamed from: s */
    public void m5186s(final View view) {
        ((CheckBox) view.findViewById(R.id.ccb_current_interval)).setChecked(true);
        ((CheckBox) view.findViewById(R.id.ccb_prev_interval)).setChecked(true);
        ((CheckBox) view.findViewById(R.id.ccb_current_interval)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.a.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FragmentChart.this.m5147a(view, compoundButton, z);
            }
        });
        ((CheckBox) view.findViewById(R.id.ccb_prev_interval)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.g.d.a.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FragmentChart.this.m5166b(view, compoundButton, z);
            }
        });
        if (view.findViewById(R.id.cbt_sale_total) != null) {
            view.findViewById(R.id.cbt_sale_total).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentChart.this.m5145a(view, view2);
                }
            });
        }
        if (view.findViewById(R.id.cbt_orders) != null) {
            view.findViewById(R.id.cbt_orders).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentChart.this.m5165b(view, view2);
                }
            });
        }
        if (view.findViewById(R.id.cbt_products_sold) != null) {
            view.findViewById(R.id.cbt_products_sold).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentChart.this.m5171c(view, view2);
                }
            });
        }
        if (view.findViewById(R.id.cbt_shipping) != null) {
            view.findViewById(R.id.cbt_shipping).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentChart.this.m5174d(view, view2);
                }
            });
        }
        view.findViewById(R.id.cal_chart_unit).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentChart.this.m5182o(view2);
            }
        });
        view.findViewById(R.id.cal_currency).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.a.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentChart.this.m5183p(view2);
            }
        });
    }

    /* renamed from: t */
    public void m5187t(View view) {
        if (view.findViewById(R.id.llc_analytics_chart) != null) {
            view.findViewById(R.id.llc_analytics_chart).setVisibility(View.GONE);
        }
        if (view.findViewById(R.id.llc_data_analytics) != null) {
            view.findViewById(R.id.llc_data_analytics).setVisibility(View.GONE);
        }
        this.f9695s0.setVisibility(View.VISIBLE);
    }

    /* renamed from: u */
    public void m5188u(View view) {
        CustomString.m3167a(view, R.id.tv_graph_title, 0, R.id.ll_products_sold, 0);
    }


    public  void m5170b(Date date, Date date2, View view) {
        java.lang.String string;
        java.lang.String str;
        if (Util.m179a(Util.date2Str(date), Util.date2Str(date2)) / 31 >= this.f9682D0) {
            date2 = new Date(date.getYear(), date.getMonth() + this.f9682D0, date.getDate());
            java.lang.String str2 = this.f9683E0.period;
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 3645428) {
//                if (hashCode == 104080000 && str2.equals(TypeAdapters.C316026.MONTH)) {
//                    c2 = 1;
//                }
            } else if (str2.equals("week")) {
                c2 = 0;
            }
            if (c2 == 0) {
                string = getResources().getString(R.string.per_week);
                str = 12 + getResources().getString(R.string.week_unit);
            } else if (c2 != 1) {
                java.lang.String string2 = getResources().getString(R.string.per_day);
                string = string2;
                str = 1 + getResources().getString(R.string.month_unit);
            } else {
                string = getResources().getString(R.string.per_month);
                str = 12 + getResources().getString(R.string.month_unit);
            }
            Util.toast(this.baseActivity, java.lang.String.format(getResources().getString(R.string.duration_overflow), string, str), "error", 0, 0);
        }
        this.f9683E0.startDate = Util.date2Str(date);
        this.f9683E0.endDate = Util.date2Str(date2);
        this.f9683E0.selectedInterval = this.f9683E0.startDate + " ~ " + this.f9683E0.endDate;
        this.f9692p0.f10526h.setValue( this.f9683E0);
        java.lang.String[] m287a = Util.m287a(date, date2);
        if (this.f9692p0.f10525g.getValue() == null) {
            mo5177e(this.f9694r0, "customer");
            return;
        }
        if (m287a.length > 1) {
            ChartParam chartParam = this.f9683E0;
            chartParam.prevStartDate = m287a[0];
            chartParam.prevEndDate = m287a[1];
            chartParam.metric = ((ChartParam) Objects.requireNonNull(this.f9692p0.f10525g.getValue())).metric;
            this.f9692p0.f10525g.setValue( this.f9683E0);
        }
    }


    public  void m5154a(final View view, final java.lang.String str, View view2) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, Status.day_filter);
        baseDialog2.show();
        baseDialog2.f8255f = 0.48f;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.a.r
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view3, int i) {
                FragmentChart.this.m5155a(view, str, baseDialog2, view3, i);
            }
        };
    }


    public void m5169b(java.lang.String str) {
        int i = 0;
        if (str.equals("table") && this.f9692p0.f10525g.getValue() != null) {
            java.lang.String str2 = this.f9692p0.f10525g.getValue().period;
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 99228) {
                if (hashCode != 3645428) {
//                    if (hashCode == 104080000 && str2.equals(TypeAdapters.C316026.MONTH)) {
//                        c2 = 2;
//                    }
                } else if (str2.equals("week")) {
                    c2 = 1;
                }
            } else if (str2.equals("day")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    i = c2 == 2 ? 12 : 3;
                }
                this.f9682D0 = i;
            } else {
                this.f9682D0 = 1;
            }
        }
        Picker4 picker4 = new Picker4(this.baseActivity, this.f9682D0);
        if (this.f9692p0.f10525g.getValue() != null) {
            this.f9698v0.setTime(Util.m359i(this.f9692p0.f10525g.getValue().startDate));
            this.f9699w0.setTime(Util.m359i(this.f9692p0.f10525g.getValue().endDate));
            Calendar calendar = this.f9698v0;
            Calendar calendar2 = this.f9699w0;
            ViewOnClickListenerC2123h viewOnClickListenerC2123h = picker4.f8615b;
            C2108a c2108a = viewOnClickListenerC2123h.f8694c;
            c2108a.f8669s = calendar;
            c2108a.f8670t = calendar2;
            viewOnClickListenerC2123h.m4728f();
        }
        picker4.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.a.s
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date, Date date2, View view) {
                FragmentChart.this.m5170b(date, date2, view);
            }
        };
        picker4.m4704a();
    }


    public  void m5155a(View view, java.lang.String str, BaseDialog2 baseDialog2, View view2, int i) {
        if (i != 9) {
            Date[] m341d = Util.m341d(i);
            this.f9683E0.startDate = m341d[0] != null ? Util.date2Str(m341d[0]) : "";
            this.f9683E0.endDate = m341d[0] != null ? Util.date2Str(m341d[1]) : "";
            ChartParam chartParam = this.f9683E0;
            chartParam.selectedInterval = Status.day_filter[i];
//            if (i == 8) {
//                chartParam.period = TypeAdapters.C316026.MONTH;
//            }
            this.f9692p0.f10526h.setValue( this.f9683E0);
            java.lang.String[] m287a = Util.m287a(Util.m359i(this.f9683E0.startDate), Util.m359i(this.f9683E0.endDate));
            if (this.f9692p0.f10525g.getValue() == null) {
                mo5177e(this.f9694r0, "customer");
            } else if (m287a.length > 1) {
                ChartParam chartParam2 = this.f9683E0;
                chartParam2.prevStartDate = m287a[0];
                chartParam2.prevEndDate = m287a[1];
                chartParam2.metric = ((ChartParam) Objects.requireNonNull(this.f9692p0.f10525g.getValue())).metric;
                this.f9692p0.f10525g.setValue( this.f9683E0);
            }
        } else {
            m5169b(str);
        }
        baseDialog2.startAni();
    }


    public  void m5159a(BaseDialog2 baseDialog2, View view, int i) {
        java.lang.String string;
        java.lang.String str;
        this.f9683E0 = this.f9692p0.f10525g.getValue();
        if (i == 0) {
            this.f9683E0.period = "day";
            this.f9682D0 = 1;
        } else if (i == 1) {
            this.f9683E0.period = "week";
            this.f9682D0 = 3;
        } else if (i == 2) {
            //this.f9683E0.period = TypeAdapters.C316026.MONTH;
            this.f9682D0 = 12;
        }
        if (!this.f9683E0.period.equals(this.f9702z0)) {
            ChartParam chartParam = this.f9683E0;
            int m179a = Util.m179a(chartParam.startDate, chartParam.endDate) / 31;
            Date m359i = Util.m359i(this.f9683E0.startDate);
            Util.m359i(this.f9683E0.endDate);
            if (m179a >= this.f9682D0) {
                Date date = new Date(m359i.getYear(), m359i.getMonth() + this.f9682D0, m359i.getDate());
                java.lang.String str2 = this.f9683E0.period;
                char c2 = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 3645428) {
//                    if (hashCode == 104080000 && str2.equals(TypeAdapters.C316026.MONTH)) {
//                        c2 = 1;
//                    }
                } else if (str2.equals("week")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    Resources m2475L = getResources();
                    if (c2 != 1) {
                        string = m2475L.getString(R.string.per_day);
                        str = 1 + getResources().getString(R.string.month_unit);
                    } else {
                        string = m2475L.getString(R.string.per_month);
                        str = 12 + getResources().getString(R.string.month_unit);
                    }
                } else {
                    string = getResources().getString(R.string.per_week);
                    str = 12 + getResources().getString(R.string.week_unit);
                }
                this.f9683E0.selectedInterval = Util.date2Str(m359i) + "~" + Util.date2Str(date);
                Util.toast(this.baseActivity, java.lang.String.format(getResources().getString(R.string.duration_overflow), string, str), "error", 0, 0);
                this.f9683E0.startDate = Util.date2Str(m359i);
                this.f9683E0.endDate = Util.date2Str(date);
                this.f9692p0.f10526h.setValue( this.f9683E0);
                this.f9683E0.prevStartDate = Util.m287a(this.f9698v0.getTime(), new Date())[0];
                this.f9683E0.prevEndDate = Util.m287a(this.f9698v0.getTime(), new Date())[1];
            }
            this.f9692p0.f10525g.setValue( this.f9683E0);
        }
        baseDialog2.startAni();
    }


    public  void m5163a(Date date, Date date2, View view) {
        if (Util.m179a(Util.date2Str(date), Util.date2Str(date2)) / 31 >= 12) {
            date2 = new Date(date.getYear(), date.getMonth() + 12, date.getDate());
            Util.toast(this.baseActivity, getResources().getString(R.string.max_one_year_visible), "error", 0, 0);
        }
        this.f9683E0.startDate = Util.date2Str(date);
        this.f9683E0.endDate = Util.date2Str(date2);
        this.f9683E0.selectedInterval = this.f9683E0.startDate + " ~ " + this.f9683E0.endDate;
        this.f9692p0.f10526h.setValue( this.f9683E0);
    }
}
