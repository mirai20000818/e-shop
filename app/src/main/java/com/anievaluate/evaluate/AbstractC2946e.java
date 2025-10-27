package com.anievaluate.evaluate;

import android.view.animation.Interpolator;

/* renamed from: b.g.a.e */
/* loaded from: classes.dex */
public abstract class AbstractC2946e implements Cloneable {

    /* renamed from: b */
    public float f10624b;

    /* renamed from: c */
    public Interpolator f10625c = null;

    /* renamed from: d */
    public boolean f10626d = false;

    /* renamed from: b.g.a.e$a */
    public static class a extends AbstractC2946e {


        public float f10627e;

        public a(float f) {
            this.f10624b = f;
            Class cls = Float.TYPE;
        }

        public a(float f, float f2) {
            this.f10624b = f;
            this.f10627e = f2;
            Class cls = Float.TYPE;
            this.f10626d = true;
        }

        @Override // p078b.p268g.p269a.AbstractC2946e
        /* renamed from: a */
        public void mo5803a(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f10627e = ((Float) obj).floatValue();
            this.f10626d = true;
        }


    }

    /* renamed from: a */
    public static AbstractC2946e m5801a(float f) {
        return new a(f);
    }

    /* renamed from: a */
    public static AbstractC2946e m5802a(float f, float f2) {
        return new a(f, f2);
    }

    /* renamed from: a */
    public abstract void mo5803a(Object obj);

    /* renamed from: a */
    public boolean m5804a() {
        return this.f10626d;
    }


}
