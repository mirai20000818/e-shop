package com.jeil.emarket.frag.analy.analy.brand;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.ChartLineView;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.analy.analy.FragmentChart;
import com.jeil.emarket.model.vendor.AnalyticsStats;
import com.jeil.emarket.providers.AnalyticsProvider;

/* renamed from: b.f.a.g.d.a.q0.b */

public class FragmentAnalyticsBrand extends FragmentChart {
    public FragmentAnalyticsBrand(View view, AnalyticsProvider analyticsProvider, BaseActivity activityC1391g1) {
        this.f9692p0 = analyticsProvider;
        this.f9694r0 = view;
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k, androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_analytics_brand, viewGroup, false);
        this.f9684F0 = (ChartLineView) inflate.findViewById(R.id.line_view);
        m5153a(inflate, "chart");
        m5175d(inflate, "productsSold");
        m5148a(inflate, this.f9692p0);
        this.f9692p0.f10527i.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.q0.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentAnalyticsBrand.this.m5207a(inflate, (AnalyticsStats) obj);
            }
        });
        m5186s(inflate);
        m5149a(inflate, this.f9692p0, this.f9694r0);
        m5157a(this.baseActivity, this.f9692p0);
        return inflate;
    }


    public  void m5207a(View view, AnalyticsStats analyticsStats) {
        ((TextView) view.findViewById(R.id.tv_stats_orders)).setText(Util.m218a(analyticsStats.orders, false) + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_stats_products)).setText(Util.m218a(analyticsStats.products, false) + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_stats_products_sold)).setText(Util.m218a(analyticsStats.productsSold, false) + getResources().getString(R.string.count_unit));
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0
    
    public void mo5167b(View view, String str) {
        super.mo5167b(view, "brand");
        m5156a(view, new int[]{R.id.cbt_sale_total, R.id.cbt_orders, R.id.cbt_products_sold}, (Boolean) true);
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0
    
    public void mo5177e(View view, String str) {
        super.mo5177e(view, "brand");
        m5156a(view, new int[]{R.id.cbt_sale_total, R.id.cbt_orders, R.id.cbt_products_sold}, (Boolean) false);
    }
}
