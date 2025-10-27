package com.jeil.emarket.frag.main.bottom;

import android.os.Handler;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.good.FragmentSalesProduct;

/* renamed from: b.f.a.g.b.b.u0 */

public class DealVPListener implements ViewPager.OnPageChangeListener {


    public final  View f9359a;

    
    public final FragmentDeals f9360b;

    public DealVPListener(FragmentDeals fragmentDeals, View view) {
        this.f9360b = fragmentDeals;
        this.f9359a = view;
    }


    public static  void m4981a(FragmentSalesProduct fragmentSalesProduct, View view) {
        fragmentSalesProduct.m4888T0();
        fragmentSalesProduct.m5075k(view.findViewById(R.id.mrl_header_filter));
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageScrollStateChanged(int i) {
        FragmentDeals fragmentDeals = this.f9360b;
        fragmentDeals.f9365d0 = i;
        final FragmentSalesProduct fragmentSalesProduct = (FragmentSalesProduct) fragmentDeals.f9362a0.f7130l.get(i);
        Handler handler = new Handler();
        final View view = this.f9359a;
        handler.postDelayed(new Runnable() { // from class: b.f.a.g.b.b.g
            @Override // java.lang.Runnable
            public final void run() {
                DealVPListener.m4981a(FragmentSalesProduct.this, view);
            }
        }, Status.time);
    }
}
