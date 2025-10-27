package com.jeil.emarket.frag.analy.analy.profits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.frag.analy.analy.Fragment_analytics;

/* renamed from: b.f.a.g.d.a.v0.c */

public class FragmentProfits extends Fragment_analytics {
    public FragmentProfits(BaseActivity activityC1391g1) {
        this.f9705a0 = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2521o0, androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        ((TextViewBold) this.f9708d0.findViewById(R.id.tv_header_title)).setText(R.string.analytics_profit);
        mo5191c(this.f9708d0);
        return this.f9708d0;
    }

    @Override // p078b.p159f.p160a.p231g.p243d.p244a.C2521o0
    
    public void mo5191c(View view) {
        super.mo5191c(view);
        this.f9709e0.addFragment(new FragmentAnalyProfits(view, this.f9707c0, this.f9705a0), getResources().getString(R.string.data_analytics));
        this.f9709e0.addFragment(new FragmentChartProfits(view, this.f9707c0, this.f9705a0), getResources().getString(R.string.profit_list));
        ((FragmentChartProfits) this.f9709e0.get(1)).m4888T0();
        this.f9709e0.notifyDataSetChanged();
        CustomString.m3172a(this.f9709e0, 1, this.f9706b0);
    }
}
