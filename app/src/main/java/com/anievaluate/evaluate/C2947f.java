package com.anievaluate.evaluate;

import android.view.animation.Interpolator;

import com.jeil.emarket.custom.CustomString;

import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: b.g.a.f */
/* loaded from: classes.dex */
public class C2947f {

    /* renamed from: a */
    public int f10628a;

    /* renamed from: b */
    public AbstractC2946e f10629b;

    /* renamed from: c */
    public Interpolator f10630c;

    /* renamed from: d */
    public ArrayList<AbstractC2946e> f10631d = new ArrayList<>();

    
    public InterfaceC2951j f10632e;

    public C2947f(AbstractC2946e... abstractC2946eArr) {
        this.f10628a = abstractC2946eArr.length;
        this.f10631d.addAll(Arrays.asList(abstractC2946eArr));
        this.f10631d.get(0);
        this.f10629b = this.f10631d.get(this.f10628a - 1);
        this.f10630c = this.f10629b.f10625c;
    }

    /* renamed from: a */
    public Object mo5799a(float f) {
        throw null;
    }

    public C2947f clone() {
        throw null;
    }

    public java.lang.String toString() {
        java.lang.String str = " ";
        for (int i = 0; i < this.f10628a; i++) {
            StringBuilder m3163a = CustomString.format(str);
            m3163a.append(Float.valueOf(((AbstractC2946e.a) this.f10631d.get(i)).f10627e));
            m3163a.append("  ");
            str = m3163a.toString();
        }
        return str;
    }
}
