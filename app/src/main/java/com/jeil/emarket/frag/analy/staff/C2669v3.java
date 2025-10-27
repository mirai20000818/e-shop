package com.jeil.emarket.frag.analy.staff;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.Status;

/* renamed from: b.f.a.g.d.b.v3 */

public class C2669v3 implements ViewPager.OnPageChangeListener {


    public final  FragmentVendorListPage f10008a;

    public C2669v3(FragmentVendorListPage fragmentVendorListPage) {
        this.f10008a = fragmentVendorListPage;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        this.f10008a.f10021f0.setValue( "");
        this.f10008a.f10022g0.setValue( "");
        this.f10008a.f10023h0.setValue( null);
        this.f10008a.f10027l0.setValue( null);
        this.f10008a.f10025j0.setValue( null);
        this.f10008a.f10026k0.setValue( null);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.c2
            @Override // java.lang.Runnable
            public final void run() {
                C2669v3.this.m5340c(i);
            }
        }, Status.time);
    }

    
    public  void m5340c(int i) {
        ((C2664u3) this.f10008a.f10017b0.f7130l.get(i)).m4888T0();
    }
}
