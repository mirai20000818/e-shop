package com.jeil.emarket.components.pickerview.date.p219d;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.jeil.emarket.components.address.wheel.view.WheelView;
import com.jeil.emarket.components.button.CustomButton;

import java.util.List;
import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2109a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2112d;

/* renamed from: b.f.a.c.w.k.d.i */

public class ViewOnClickListenerC2124i<T> extends Pickerview_layout_base implements View.OnClickListener {

    
    public C2128m<T> f8704k;

    public ViewOnClickListenerC2124i(C2108a c2108a) {
        super(c2108a.f8635L);
        this.f8694c = c2108a;
        Context context = c2108a.f8635L;
        m4723c();
        m4722b();
        InterfaceC2109a interfaceC2109a = this.f8694c.f8657g;
        LayoutInflater from = LayoutInflater.from(context);
        if (interfaceC2109a == null) {
            from.inflate(this.f8694c.f8633J, this.f8693b);
            CustomButton customButton = (CustomButton) m4720a(R.id.cb_ok);
            CustomButton customButton2 = (CustomButton) m4720a(R.id.cb_cancel);
            customButton.setTag("submit");
            customButton2.setTag("cancel");
            customButton.setOnClickListener(this);
            customButton2.setOnClickListener(this);
        } else {
            interfaceC2109a.m4716a(from.inflate(this.f8694c.f8633J, this.f8693b));
        }
        LinearLayout linearLayout = (LinearLayout) m4720a(R.id.optionspicker);
        linearLayout.setBackgroundColor(this.f8694c.f8640Q);
        this.f8704k = new C2128m<>(linearLayout, this.f8694c.f8666p);
        InterfaceC2112d interfaceC2112d = this.f8694c.f8656f;
        if (interfaceC2112d != null) {
            this.f8704k.m4733a(interfaceC2112d);
        }
        C2128m<T> c2128m = this.f8704k;
        float f = this.f8694c.f8641R;
        c2128m.f8708a.setTextSize(f);
        c2128m.f8709b.setTextSize(f);
        c2128m.f8710c.setTextSize(f);
        C2128m<T> c2128m2 = this.f8704k;
        int i = this.f8694c.f8649Z;
        c2128m2.f8708a.setItemsVisibleCount(i);
        c2128m2.f8709b.setItemsVisibleCount(i);
        c2128m2.f8710c.setItemsVisibleCount(i);
        C2128m<T> c2128m3 = this.f8704k;
        boolean z = this.f8694c.f8651a0;
        c2128m3.f8708a.setAlphaGradient(z);
        c2128m3.f8709b.setAlphaGradient(z);
        c2128m3.f8710c.setAlphaGradient(z);
        C2128m<T> c2128m4 = this.f8704k;
        C2108a c2108a2 = this.f8694c;
        boolean z2 = c2108a2.f8663m;
        boolean z3 = c2108a2.f8664n;
        boolean z4 = c2108a2.f8665o;
        c2128m4.f8708a.setCyclic(z2);
        c2128m4.f8709b.setCyclic(z3);
        c2128m4.f8710c.setCyclic(z4);
        C2128m<T> c2128m5 = this.f8704k;
        Typeface typeface = this.f8694c.f8647X;
        c2128m5.f8708a.setTypeface(typeface);
        c2128m5.f8709b.setTypeface(typeface);
        c2128m5.f8710c.setTypeface(typeface);
        C2128m<T> c2128m6 = this.f8704k;
        int i2 = this.f8694c.f8644U;
        c2128m6.f8708a.setDividerColor(i2);
        c2128m6.f8709b.setDividerColor(i2);
        c2128m6.f8710c.setDividerColor(i2);
        C2128m<T> c2128m7 = this.f8704k;
        WheelView.EnumC3242c enumC3242c = this.f8694c.f8648Y;
        c2128m7.f8708a.setDividerType(enumC3242c);
        c2128m7.f8709b.setDividerType(enumC3242c);
        c2128m7.f8710c.setDividerType(enumC3242c);
        C2128m<T> c2128m8 = this.f8704k;
        float f2 = this.f8694c.f8645V;
        c2128m8.f8708a.setLineSpacingMultiplier(f2);
        c2128m8.f8709b.setLineSpacingMultiplier(f2);
        c2128m8.f8710c.setLineSpacingMultiplier(f2);
        C2128m<T> c2128m9 = this.f8704k;
        int i3 = this.f8694c.f8642S;
        c2128m9.f8708a.setTextColorOut(i3);
        c2128m9.f8709b.setTextColorOut(i3);
        c2128m9.f8710c.setTextColorOut(i3);
        C2128m<T> c2128m10 = this.f8704k;
        int i4 = this.f8694c.f8643T;
        c2128m10.f8708a.setTextColorCenter(i4);
        c2128m10.f8709b.setTextColorCenter(i4);
        c2128m10.f8710c.setTextColorCenter(i4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            if (this.f8694c.f8650a != null) {
                C2128m<T> c2128m = this.f8704k;
                int[] iArr = new int[3];
                iArr[0] = c2128m.f8708a.getCurrentItem();
                List<List<T>> list = c2128m.f8713f;
                if (list == null || list.size() <= 0) {
                    iArr[1] = c2128m.f8709b.getCurrentItem();
                } else {
                    iArr[1] = c2128m.f8709b.getCurrentItem() > c2128m.f8713f.get(iArr[0]).size() - 1 ? 0 : c2128m.f8709b.getCurrentItem();
                }
                List<List<List<T>>> list2 = c2128m.f8714g;
                if (list2 == null || list2.size() <= 0) {
                    iArr[2] = c2128m.f8710c.getCurrentItem();
                } else {
                    iArr[2] = c2128m.f8710c.getCurrentItem() > c2128m.f8714g.get(iArr[0]).get(iArr[1]).size() - 1 ? 0 : c2128m.f8710c.getCurrentItem();
                }
                this.f8694c.f8650a.mo4695a(iArr[0], iArr[1], iArr[2], this.f8696e);
            }
        } else {
            if (!str.equals("cancel")) {
                return;
            }
            View.OnClickListener onClickListener = this.f8694c.f8654d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
        m4721a();
    }
}
