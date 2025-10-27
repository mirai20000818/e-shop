package com.jeil.emarket.widget.pa;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/* renamed from: b.f.a.c.l0.a */

public class PagerAdapterEx extends PagerAdapter {


    public PagerAdapter f8511c;


    public boolean f8512d = true;

    public PagerAdapterEx(PagerAdapter pagerAdapter) {
        this.f8511c = pagerAdapter;
    }

    @Override // p000a.p075x.p076a.AbstractC0513a

    public int getCount() {
        int m4679e = m4679e();
        return this.f8512d ? m4679e + 2 : m4679e;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    //@Override // p000a.p075x.p076a.AbstractC0513a

    public Object isViewFromObject(ViewGroup viewGroup, int i) {
        PagerAdapter pagerAdapter = this.f8511c;
//        if (!(pagerAdapter instanceof AbstractC0347g0) && !(pagerAdapter instanceof FragmentResultOwner)) {
//            i = m4678b(i);
//        }
        return this.f8511c.isViewFromObject(viewGroup, i);
    }

    //@Override // p000a.p075x.p076a.AbstractC0513a

//    public void mo1659a(Parcelable parcelable, ClassLoader classLoader) {
//        this.f8511c.mo1659a(parcelable, classLoader);
//    }
//
//    @Override // p000a.p075x.p076a.AbstractC0513a
//
//    public void mo1660a(ViewGroup viewGroup) {
//        this.f8511c.mo1660a(viewGroup);
//    }
//
//    @Override // p000a.p075x.p076a.AbstractC0513a
//
//    public void mo1661a(ViewGroup viewGroup, int i, Object obj) {
//        PagerAdapter pagerAdapter = this.f8511c;
//        if (!(pagerAdapter instanceof AbstractC0347g0) && !(pagerAdapter instanceof FragmentResultOwner)) {
//            i = m4678b(i);
//        }
//        this.f8511c.mo1661a(viewGroup, i, obj);
//    }
//
//    @Override // p000a.p075x.p076a.AbstractC0513a
//
//    public boolean mo1662a(View view, Object obj) {
//        return this.f8511c.mo1662a(view, obj);
//    }
//

    public int m4678b(int i) {
        int m4679e = m4679e();
        if (m4679e == 0) {
            return 0;
        }
        if (!this.f8512d) {
            return i;
        }
        int i2 = (i - 1) % m4679e;
        return i2 < 0 ? i2 + m4679e : i2;
    }

//    @Override // p000a.p075x.p076a.AbstractC0513a
//
//    public void mo1663b(ViewGroup viewGroup) {
//        this.f8511c.mo1663b(viewGroup);
//    }
//
//    @Override // p000a.p075x.p076a.AbstractC0513a
//
//    public void mo1664b(ViewGroup viewGroup, int i, Object obj) {
//        this.f8511c.mo1664b(viewGroup, i, obj);
//    }
//
//    @Override // p000a.p075x.p076a.AbstractC0513a
//
//    public Parcelable mo1665d() {
//        return this.f8511c.mo1665d();
//    }

    
    public int m4679e() {
        return this.f8511c.getCount();
    }
}
