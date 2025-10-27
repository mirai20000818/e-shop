package com.jeil.emarket.listener.product.refund;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.jeil.emarket.activities.seller.refund.RefundRequestsActivity;

import org.json.JSONException;

import com.jeil.emarket.frag.analy.staff.C2659t3;

/* renamed from: b.f.a.a.i.w2.l */

public class RefundRequestsViewPager implements ViewPager.OnPageChangeListener {

    
    public final RefundRequestsActivity f6937a;

    public RefundRequestsViewPager(RefundRequestsActivity refundRequestsActivity) {
        this.f6937a = refundRequestsActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageScrollStateChanged(final int i) {
        RefundRequestsActivity refundRequestsActivity = this.f6937a;
        refundRequestsActivity.f11926M = i;
        ((C2659t3) refundRequestsActivity.f11925L.f7130l.get(i)).f9982r0.setValue( "");
        ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).f9983s0 = "";
        ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).f9984t0.setValue( "");
        ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).f9986v0 = null;
        ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).f9987w0 = null;
        ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).f9988x0.setValue( null);
        ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).f9989y0.setValue( null);
        try {
            ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).f9980p0.put("search", "");
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.i.w2.i
                @Override // java.lang.Runnable
                public final void run() {
                    RefundRequestsViewPager.this.m4372c(i);
                }
            }, 0L);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    
    public  void m4372c(int i) {
        ((C2659t3) this.f6937a.f11925L.f7130l.get(i)).m4888T0();
    }
}
