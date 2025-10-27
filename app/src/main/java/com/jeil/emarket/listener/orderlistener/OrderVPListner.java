package com.jeil.emarket.listener.orderlistener;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.jeil.emarket.activities.account.OrderActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.SearchFragment2;

public class OrderVPListner implements ViewPager.OnPageChangeListener {
    public final OrderActivity orderComponentActivity;

    public OrderVPListner(OrderActivity orderActivity) {
        this.orderComponentActivity = orderActivity;
    }

    @Override
    public void onPageSelected(int i) {
    }

    @Override
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override
    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() {
            @Override // java.lang.Runnable
            public final void run() {
                OrderVPListner.this.m4268c(i);
            }
        }, Status.time);
    }
    public  void m4268c(int i) {
        ((SearchFragment2) this.orderComponentActivity.fragmentPagerAdaperEx.f7130l.get(i)).m4888T0();
    }
}
