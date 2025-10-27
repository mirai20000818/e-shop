package com.jeil.emarket.frag.analy.analy.profits;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.ChartLineView;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.analy.analy.FragmentChart;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.AnalyticsStats;
import com.jeil.emarket.model.vendor.ChartParam;
import com.jeil.emarket.providers.AnalyticsProvider;
import com.jeil.emarket.viewmodel.VendorListVM;

import java.util.Objects;

/* renamed from: b.f.a.g.d.a.v0.b */

public class FragmentAnalyProfits extends FragmentChart {
    public FragmentAnalyProfits(View view, AnalyticsProvider analyticsProvider, BaseActivity activityC1391g1) {
        this.f9692p0 = analyticsProvider;
        this.f9694r0 = view;
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k, androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_analytics_profit, viewGroup, false);
        this.f9684F0 = (ChartLineView) inflate.findViewById(R.id.line_view);
        m5153a(inflate, "chart");
        m5175d(inflate, "saleTotal");
        m5148a(inflate, this.f9692p0);
        this.f9692p0.f10527i.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.v0.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentAnalyProfits.this.m5213a(inflate, (AnalyticsStats) obj);
            }
        });
        m5186s(inflate);
        m5149a(inflate, this.f9692p0, this.f9694r0);
        m5157a(this.baseActivity, this.f9692p0);
        return inflate;
    }


    public  void m5213a(View view, AnalyticsStats analyticsStats) {
        ((TextView) view.findViewById(R.id.tv_stats_days)).setText(Util.m218a(Util.m179a(((ChartParam) Objects.requireNonNull(this.f9692p0.f10525g.getValue())).startDate, this.f9692p0.f10525g.getValue().endDate), false) + getResources().getString(R.string.day_unit));
        ((TextView) view.findViewById(R.id.tv_stats_orders)).setText(Util.m218a((float) analyticsStats.orders, false) + getResources().getString(R.string.count_unit));
        PriceText priceText = (PriceText) view.findViewById(R.id.pt_stats_kpf_sale_total);
        PriceText priceText2 = (PriceText) view.findViewById(R.id.pt_stats_kpw_sale_total);
        priceText.setHidePriceNumber(false);
        priceText2.setHidePriceNumber(false);
        SubOrder.TotalAmount totalAmount = analyticsStats.saleTotal;
        if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
            priceText2.f12264t = true;
        }
        if (analyticsStats.saleTotal.kpf > 0.0f) {
            priceText.setVisibility(View.VISIBLE);
            priceText.setPrice(Util.m303b(analyticsStats.saleTotal.kpf));
        } else {
            priceText.setVisibility(View.GONE);
        }
        if (analyticsStats.saleTotal.kpw > 0.0f) {
            priceText2.setVisibility(View.VISIBLE);
            priceText2.setPrice(Util.m303b(analyticsStats.saleTotal.kpw));
        } else {
            priceText2.setVisibility(View.GONE);
        }
        SubOrder.TotalAmount totalAmount2 = analyticsStats.saleTotal;
        if (totalAmount2.kpf == 0.0f && totalAmount2.kpw == 0.0f) {
            priceText.setVisibility(View.VISIBLE);
            priceText.setPrice("0");
        }
        ((PriceText) view.findViewById(R.id.pt_stats_shipping)).setCurrency(VendorListVM.f10363d.getValue() != null ? VendorListVM.f10363d.getValue().shippingCurrency : "kpw");
        ((PriceText) view.findViewById(R.id.pt_stats_shipping)).setHidePriceNumber(false);
        ((PriceText) view.findViewById(R.id.pt_stats_shipping)).setPrice(Util.m303b(analyticsStats.shipping));
        PriceText priceText3 = (PriceText) view.findViewById(R.id.pt_kpf_stats_fee);
        PriceText priceText4 = (PriceText) view.findViewById(R.id.pt_kpw_stats_fee);
        priceText3.setHidePriceNumber(false);
        priceText4.setHidePriceNumber(false);
        SubOrder.TotalAmount totalAmount3 = analyticsStats.fee;
        if (totalAmount3.kpf > 0.0f && totalAmount3.kpw > 0.0f) {
            priceText4.f12264t = true;
        }
        if (analyticsStats.fee.kpf > 0.0f) {
            priceText3.setVisibility(View.VISIBLE);
            priceText3.setPrice(Util.m303b(analyticsStats.fee.kpf));
        } else {
            priceText3.setVisibility(View.GONE);
        }
        if (analyticsStats.fee.kpw > 0.0f) {
            priceText4.setVisibility(View.VISIBLE);
            priceText4.setPrice(Util.m303b(analyticsStats.fee.kpw));
        } else {
            priceText4.setVisibility(View.GONE);
        }
        SubOrder.TotalAmount totalAmount4 = analyticsStats.fee;
        if (totalAmount4.kpf == 0.0f && totalAmount4.kpw == 0.0f) {
            priceText3.setVisibility(View.VISIBLE);
            priceText3.setPrice("0");
        }
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0
    
    public void mo5167b(View view, String str) {
        super.mo5167b(view, "profit");
        m5156a(view, new int[]{R.id.cbt_sale_total, R.id.cbt_shipping}, (Boolean) true);
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0

    public void mo5177e(View view, String str) {
        super.mo5177e(view, "profit");
        m5156a(view, new int[]{R.id.cbt_sale_total, R.id.cbt_shipping}, (Boolean) false);
    }
}
