package com.jeil.emarket.listener.wish;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.jeil.emarket.activities.product.WishlistActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.base.BaseFragment;

/* renamed from: b.f.a.a.g.m */

public class WishlistVPListener implements ViewPager.OnPageChangeListener {


    public final WishlistActivity f6712a;

    public WishlistVPListener(WishlistActivity wishlistActivity) {
        this.f6712a = wishlistActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.g
            @Override // java.lang.Runnable
            public final void run() {
                WishlistVPListener.this.m4368c(i);
            }
        }, Status.time);
    }

    
    public  void m4368c(int i) {
        ((BaseFragment) this.f6712a.fragmentPagerAdaperEx.f7130l.get(i)).m4888T0();
    }
}
