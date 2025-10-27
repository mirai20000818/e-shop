package com.jeil.emarket.adapters.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.jeil.emarket.activities.baseactivity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.b.b.d */

public abstract class PagerRecycler<T> extends PagerAdapter {


    public final BaseActivity f7124c;


    public List<T> f7125d = new ArrayList();

    public PagerRecycler(BaseActivity activityC1391g1) {
        this.f7124c = activityC1391g1;
    }

    @Override // p000a.p075x.p076a.AbstractC0513a

    public int getCount() {
        return this.f7125d.size();
    }

    //@Override // p000a.p075x.p076a.AbstractC0513a

    public int mo2186a(Object obj) {
        return -2;
    }

    //@Override // p000a.p075x.p076a.AbstractC0513a

    public void mo1661a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

   // @Override // p000a.p075x.p076a.AbstractC0513a

    public boolean mo1662a(View view, Object obj) {
        return view == obj;
    }
}
