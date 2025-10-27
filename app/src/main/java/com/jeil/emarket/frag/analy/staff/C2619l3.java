package com.jeil.emarket.frag.analy.staff;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.ModelCollection;

/* renamed from: b.f.a.g.d.b.l3 */

public class C2619l3 implements ViewPager.OnPageChangeListener {


    public final  C2624m3 f9875a;

    public C2619l3(C2624m3 c2624m3) {
        this.f9875a = c2624m3;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.j0
            @Override // java.lang.Runnable
            public final void run() {
                C2619l3.this.m5269c(i);
            }
        }, Status.time);
    }


    public  void m5269c(int i) {
        C2624m3 c2624m3 = this.f9875a;
        c2624m3.f9887d0 = i;
        ModelCollection.f10221l.setValue( ((C2629n3) c2624m3.f9885b0.f7130l.get(i)).f9901t0);
        ((C2629n3) this.f9875a.f9885b0.f7130l.get(i)).m5280a(((EditForm) this.f9875a.f9888e0.findViewById(R.id.cef_search)).getText(), false);
        ((C2629n3) this.f9875a.f9885b0.f7130l.get(i)).m4888T0();
        C2624m3 c2624m32 = this.f9875a;
        c2624m32.f9886c0 = ((C2629n3) c2624m32.f9885b0.f7130l.get(i)).f9901t0;
    }
}
