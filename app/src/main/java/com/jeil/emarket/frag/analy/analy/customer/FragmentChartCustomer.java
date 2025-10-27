package com.jeil.emarket.frag.analy.analy.customer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.analy.analy.FragmentChart;
import com.jeil.emarket.model.vendor.AnalyticsStats;
import com.jeil.emarket.providers.AnalyticsProvider;

/* renamed from: b.f.a.g.d.a.s0.c */

public class FragmentChartCustomer extends FragmentChart {
    public FragmentChartCustomer(View view, AnalyticsProvider analyticsProvider, BaseActivity activityC1391g1) {
        this.f9692p0 = analyticsProvider;
        this.f9694r0 = view;
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k, androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_analytics_customer, viewGroup, false);
        m5179l(inflate);
        m5180m(inflate);
        super.mo5177e(inflate, "customer");
        this.f9692p0.f10527i.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.s0.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentChartCustomer.this.m5210a(inflate, (AnalyticsStats) obj);
            }
        });
        m5149a(inflate, this.f9692p0, this.f9694r0);
        return inflate;
    }


    public  void m5210a(View view, AnalyticsStats analyticsStats) {
        ((TextView) view.findViewById(R.id.tv_stats_orders)).setText(Util.m218a(analyticsStats.orders, true) + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_stats_guests)).setText(Util.m218a((float) analyticsStats.users, false) + getResources().getString(R.string.person_unit));
        ((TextView) view.findViewById(R.id.tv_stats_avg_orders)).setText(Util.m218a(analyticsStats.avgOrders, true) + getResources().getString(R.string.count_unit));
        mo5167b(view, "customer");
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0
    
    public void mo5167b(View view, String str) {
        super.mo5167b(view, "customer");
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0
    
    public void mo5177e(View view, String str) {
        super.mo5177e(view, "customer");
    }
}
