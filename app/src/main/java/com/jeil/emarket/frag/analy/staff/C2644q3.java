package com.jeil.emarket.frag.analy.staff;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.Status;

/* renamed from: b.f.a.g.d.b.q3 */

public class C2644q3 implements ViewPager.OnPageChangeListener {


    public final  C2649r3 f9933a;

    public C2644q3(C2649r3 c2649r3) {
        this.f9933a = c2649r3;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.h1
            @Override // java.lang.Runnable
            public final void run() {
                C2644q3.this.m5305c(i);
            }
        }, Status.time);
    }


    public  void m5305c(int i) {
        this.f9933a.f9948f0.setValue( "");
        C2649r3 c2649r3 = this.f9933a;
        c2649r3.f9950h0.setValue( c2649r3.f9952j0.get(0));
        C2649r3 c2649r32 = this.f9933a;
        c2649r32.f9949g0.setValue( c2649r32.f9954l0.get(0).categoryName);
        this.f9933a.f9951i0.setValue( false);
        ((C2654S3Base) this.f9933a.f9944b0.f7130l.get(i)).m4888T0();
    }
}
