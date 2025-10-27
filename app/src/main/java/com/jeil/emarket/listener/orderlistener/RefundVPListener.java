package com.jeil.emarket.listener.orderlistener;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.jeil.emarket.activities.account.RefundRequestsActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.FragmentRefundRequestList;

/* renamed from: b.f.a.a.a.u2 */

public class RefundVPListener implements ViewPager.OnPageChangeListener {


    public final RefundRequestsActivity f6348a;

    public RefundVPListener(RefundRequestsActivity refundRequestsActivity) {
        this.f6348a = refundRequestsActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.a.h2
            @Override // java.lang.Runnable
            public final void run() {
                RefundVPListener.this.m4269c(i);
            }
        }, Status.time);
    }

    
    public  void m4269c(int i) {
        ((FragmentRefundRequestList) this.f6348a.f11682J.f7130l.get(i)).m4888T0();
    }
}
