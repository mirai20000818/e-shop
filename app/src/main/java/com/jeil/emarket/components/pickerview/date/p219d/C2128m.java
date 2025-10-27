package com.jeil.emarket.components.pickerview.date.p219d;

import android.view.View;

import com.jeil.emarket.components.address.wheel.view.WheelView;
import java.util.List;
import com.jeil.emarket.components.pickerview.date.p216a.C2106a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2112d;
import com.jeil.emarket.components.pickerview.p220l.p223c.InterfaceC2134b;

/* renamed from: b.f.a.c.w.k.d.m */

public class C2128m<T> {


    public final WheelView f8708a;


    public final WheelView f8709b;


    public final WheelView f8710c;


    public final boolean f8711d;

    
    public List<T> f8712e;

    /* renamed from: f */
    public List<List<T>> f8713f;

    /* renamed from: g */
    public List<List<List<T>>> f8714g;

    /* renamed from: h */
    public boolean f8715h = true;

    
    public InterfaceC2134b f8716i;

   
    public InterfaceC2112d f8717j;

    public C2128m(View view, boolean z) {
        this.f8711d = z;
        this.f8708a = (WheelView) view.findViewById(R.id.options1);
        this.f8709b = (WheelView) view.findViewById(R.id.options2);
        this.f8710c = (WheelView) view.findViewById(R.id.options3);
    }


    public void m4732a(int i, int i2, int i3) {
        if (!this.f8715h) {
            this.f8708a.setCurrentItem(i);
            this.f8709b.setCurrentItem(i2);
            this.f8710c.setCurrentItem(i3);
            return;
        }
        if (this.f8712e != null) {
            this.f8708a.setCurrentItem(i);
        }
        List<List<T>> list = this.f8713f;
        if (list != null) {
            this.f8709b.setAdapter(new C2106a(list.get(i)));
            this.f8709b.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.f8714g;
        if (list2 != null) {
            this.f8710c.setAdapter(new C2106a(list2.get(i).get(i2)));
            this.f8710c.setCurrentItem(i3);
        }
    }


    public void m4733a(InterfaceC2112d interfaceC2112d) {
    }
}
