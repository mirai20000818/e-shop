package com.jeil.emarket.frag.analy.analy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.activities.seller.AnalyticsActivity;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.model.vendor.ChartParam;

import androidx.lifecycle.ViewModelProvider;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.providers.AnalyticsProvider;

/* renamed from: b.f.a.g.d.a.o0 */

public class Fragment_analytics extends Fragment {

    /* renamed from: a0 */
    public BaseActivity f9705a0;

    /* renamed from: b0 */
    public ViewPager f9706b0;

    /* renamed from: c0 */
    public AnalyticsProvider f9707c0;

    /* renamed from: d0 */
    public View f9708d0;

    /* renamed from: e0 */
    public FragmentPagerAdaperEx f9709e0;

    /* renamed from: S0 */
    public void m5189S0() {
        this.f9707c0 = (AnalyticsProvider) new ViewModelProvider(this).get(AnalyticsProvider.class);
    }

    /* renamed from: T0 */
    public void m5190T0() {
        ChartParam getValue = this.f9707c0.f10525g.getValue();
        this.f9707c0.f10525g.setValue( getValue);
        this.f9707c0.f10526h.setValue( getValue);
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9708d0 = layoutInflater.inflate(R.layout.fragment_analytics, viewGroup, false);
        m5189S0();
        mo5191c(this.f9708d0);
        m5192d(this.f9708d0);
        ((BaseActivityForVendor) this.f9705a0).m4331a(R.id.navigation_home, this.f9708d0);
        return this.f9708d0;
    }

    
    public void mo5191c(View view) {
        this.f9709e0 = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        this.f9706b0 = (ViewPager) view.findViewById(R.id.vp_tabs);
        this.f9706b0.setAdapter(this.f9709e0);
        ((RecyclerTabLayout) view.findViewById(R.id.rtl_tabs)).setUpWithViewPager(this.f9706b0);
    }


    public void m5192d(View view) {
        ((AnalyticsActivity) getActivity()).setClickEvent(view);
    }
}
