package com.jeil.emarket.frag.analy.staff;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.SearchFragment;

/* renamed from: b.f.a.g.d.b.o3 */

public class C2634o3 implements ViewPager.OnPageChangeListener {


    public final  C2639p3 f9911a;

    public C2634o3(C2639p3 c2639p3) {
        this.f9911a = c2639p3;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.x0
            @Override // java.lang.Runnable
            public final void run() {
                C2634o3.this.m5291c(i);
            }
        }, Status.time);
    }


    public  void m5291c(int i) {
        this.f9911a.f9920d0.setValue( "");
        this.f9911a.f9921e0.setValue( "");
        this.f9911a.f9924h0.setValue( null);
        this.f9911a.f9925i0.setValue( null);
        ((SearchFragment) this.f9911a.f9918b0.f7130l.get(i)).m4888T0();
    }
}
