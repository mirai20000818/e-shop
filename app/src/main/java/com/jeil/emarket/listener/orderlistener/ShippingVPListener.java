package com.jeil.emarket.listener.orderlistener;

import android.os.Handler;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.activities.account.ShippingActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.FragmentShippingList;

/* renamed from: b.f.a.a.a.v2 */

public class ShippingVPListener implements ViewPager.OnPageChangeListener {


    public final ShippingActivity f6352a;

    public ShippingVPListener(ShippingActivity shippingActivity) {
        this.f6352a = shippingActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.a.j2
            @Override // java.lang.Runnable
            public final void run() {
                ShippingVPListener.this.m4270c(i);
            }
        }, Status.time);
    }


    public  void m4270c(int i) {
        View findViewById;
        int i2;
        ((FragmentShippingList) this.f6352a.f11684J.f7130l.get(i)).m4888T0();
        if (i == 0) {
            findViewById = this.f6352a.findViewById(R.id.tv_timeline_track);
            i2 = 8;
        } else {
            if (((FragmentShippingList) this.f6352a.f11684J.f7130l.get(i)).f9138b0 == 0) {
                return;
            }
            findViewById = this.f6352a.findViewById(R.id.tv_timeline_track);
            i2 = 0;
        }
        findViewById.setVisibility(i2);
    }
}
