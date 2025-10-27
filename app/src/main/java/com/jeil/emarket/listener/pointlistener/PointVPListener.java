package com.jeil.emarket.listener.pointlistener;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.jeil.emarket.activities.point.PointActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.SearchFragment;

/* renamed from: b.f.a.a.f.w */

public class PointVPListener implements ViewPager.OnPageChangeListener {


    public final PointActivity f6690a;

    public PointVPListener(PointActivity pointActivity) {
        this.f6690a = pointActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.f.b
            @Override // java.lang.Runnable
            public final void run() {
                PointVPListener.this.m4367c(i);
            }
        }, Status.time);
    }


    public  void m4367c(int i) {
        ((SearchFragment) this.f6690a.f11758J.f7130l.get(i)).m4888T0();
    }
}
