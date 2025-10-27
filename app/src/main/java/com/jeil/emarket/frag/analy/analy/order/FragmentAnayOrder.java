package com.jeil.emarket.frag.analy.analy.order;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.ChartLineView;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.analy.analy.FragmentChart;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.AnalyticsStats;
import com.jeil.emarket.providers.AnalyticsProvider;

/* renamed from: b.f.a.g.d.a.t0.b */

public class FragmentAnayOrder extends FragmentChart {
    public FragmentAnayOrder(View view, AnalyticsProvider analyticsProvider, BaseActivity activityC1391g1) {
        this.f9692p0 = analyticsProvider;
        this.f9694r0 = view;
        this.baseActivity = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k, androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_analytics_order, viewGroup, false);
        this.f9684F0 = (ChartLineView) inflate.findViewById(R.id.line_view);
        m5153a(inflate, "chart");
        m5175d(inflate, "orders");
        m5148a(inflate, this.f9692p0);
        this.f9692p0.f10527i.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.a.t0.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentAnayOrder.this.m5211a(inflate, (AnalyticsStats) obj);
            }
        });
        m5186s(inflate);
        m5149a(inflate, this.f9692p0, this.f9694r0);
        m5157a(this.baseActivity, this.f9692p0);
        return inflate;
    }


    public  void m5211a(View view, AnalyticsStats analyticsStats) {
        ((TextView) view.findViewById(R.id.tv_stats_customers)).setText(Util.m218a(analyticsStats.customers, false) + getResources().getString(R.string.person_unit));
        ((TextView) view.findViewById(R.id.tv_stats_products_sold)).setText(Util.m218a((float) analyticsStats.productsCount, false) + getResources().getString(R.string.count_unit));
        PriceText priceText = (PriceText) view.findViewById(R.id.pt_stats_kpf_sale_total);
        PriceText priceText2 = (PriceText) view.findViewById(R.id.pt_stats_kpw_sale_total);
        priceText.setHidePriceNumber(false);
        priceText2.setHidePriceNumber(false);
        SubOrder.TotalAmount totalAmount = analyticsStats.completedSaleTotal;
        if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
            priceText2.f12264t = true;
        }
        if (analyticsStats.completedSaleTotal.kpf > 0.0f) {
            priceText.setVisibility(View.VISIBLE);
            priceText.setPrice(Util.m303b(analyticsStats.completedSaleTotal.kpf));
        } else {
            priceText.setVisibility(View.GONE);
        }
        if (analyticsStats.completedSaleTotal.kpw > 0.0f) {
            priceText2.setVisibility(View.VISIBLE);
            priceText2.setPrice(Util.m303b(analyticsStats.completedSaleTotal.kpw));
        } else {
            priceText2.setVisibility(View.GONE);
        }
        SubOrder.TotalAmount totalAmount2 = analyticsStats.completedSaleTotal;
        if (totalAmount2.kpf == 0.0f && totalAmount2.kpw == 0.0f) {
            priceText.setVisibility(View.VISIBLE);
            priceText.setPrice("0");
        }
        PriceText priceText3 = (PriceText) view.findViewById(R.id.pt_kpf_stats_flow);
        PriceText priceText4 = (PriceText) view.findViewById(R.id.pt_kpw_stats_flow);
        priceText3.setHidePriceNumber(false);
        priceText4.setHidePriceNumber(false);
        SubOrder.TotalAmount totalAmount3 = analyticsStats.saleTotal;
        if (totalAmount3.kpf > 0.0f && totalAmount3.kpw > 0.0f) {
            priceText4.f12264t = true;
        }
        if (analyticsStats.saleTotal.kpf > 0.0f) {
            priceText3.setVisibility(View.VISIBLE);
            priceText3.setPrice(Util.m303b(analyticsStats.saleTotal.kpf));
        } else {
            priceText3.setVisibility(View.GONE);
        }
        if (analyticsStats.saleTotal.kpw > 0.0f) {
            priceText4.setVisibility(View.VISIBLE);
            priceText4.setPrice(Util.m303b(analyticsStats.saleTotal.kpw));
        } else {
            priceText4.setVisibility(View.GONE);
        }
        SubOrder.TotalAmount totalAmount4 = analyticsStats.saleTotal;
        if (totalAmount4.kpf == 0.0f && totalAmount4.kpw == 0.0f) {
            priceText3.setVisibility(View.VISIBLE);
            priceText3.setPrice("0");
        }
        ((TextView) view.findViewById(R.id.tv_stats_orders)).setText(Util.m218a(analyticsStats.orders, false) + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_stats_completed_orders)).setText(Util.m218a((float) analyticsStats.completed, false) + getResources().getString(R.string.count_unit));
        ((TextView) view.findViewById(R.id.tv_stats_cancelled_orders)).setText(Util.m218a((float) analyticsStats.cancelled, false) + getResources().getString(R.string.count_unit));
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0
    
    public void mo5167b(View view, String str) {
        super.mo5167b(view, "order");
        m5156a(view, new int[]{R.id.cbt_sale_total, R.id.cbt_orders}, (Boolean) true);
        ((ButtonToggle) view.findViewById(R.id.cbt_sale_total)).setText(getResources().getString(R.string.flow_price));
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2519n0
    
    public void mo5177e(View view, String str) {
        super.mo5177e(view, "order");
        m5156a(view, new int[]{R.id.cbt_sale_total, R.id.cbt_orders}, (Boolean) false);
        ((ButtonToggle) view.findViewById(R.id.cbt_sale_total)).setText(getResources().getString(R.string.flow_price));
    }
}
