package com.anievaluate.evaluate;

import android.view.animation.Interpolator;

import com.jeil.emarket.custom.CustomString;

/* renamed from: b.g.a.c */
/* loaded from: classes.dex */
public class C2944c extends C2947f {

    /* renamed from: f */
    public float f10620f;

    /* renamed from: g */
    public float f10621g;

    /* renamed from: h */
    public float f10622h;

    
    public boolean f10623i;

    public C2944c(AbstractC2946e.a... aVarArr) {
        super(aVarArr);
        this.f10623i = true;
    }

    @Override // p078b.p268g.p269a.C2947f
    /* renamed from: a */
    public Object mo5799a(float f) {
        return Float.valueOf(m5800b(f));
    }

    /* renamed from: b */
    public float m5800b(float f) {
        int i = this.f10628a;
        if (i == 2) {
            if (this.f10623i) {
                this.f10623i = false;
                this.f10620f = ((AbstractC2946e.a) this.f10631d.get(0)).f10627e;
                this.f10621g = ((AbstractC2946e.a) this.f10631d.get(1)).f10627e;
                this.f10622h = this.f10621g - this.f10620f;
            }
            Interpolator interpolator = this.f10630c;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            InterfaceC2951j interfaceC2951j = this.f10632e;
            if (interfaceC2951j == null) {
                return (f * this.f10622h) + this.f10620f;
            }
            return ((Number) interfaceC2951j.evaluate(f, Float.valueOf(this.f10620f), Float.valueOf(this.f10621g))).floatValue();
        }
        if (f <= 0.0f) {
            AbstractC2946e.a aVar = (AbstractC2946e.a) this.f10631d.get(0);
            AbstractC2946e.a aVar2 = (AbstractC2946e.a) this.f10631d.get(1);
            float f2 = aVar.f10627e;
            float f3 = aVar2.f10627e;
            float f4 = aVar.f10624b;
            float f5 = aVar2.f10624b;
            Interpolator interpolator2 = aVar2.f10625c;
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float f6 = (f - f4) / (f5 - f4);
            InterfaceC2951j interfaceC2951j2 = this.f10632e;
            return interfaceC2951j2 == null ? CustomString.m3148a(f3, f2, f6, f2) : ((Number) interfaceC2951j2.evaluate(f6, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
        }
        if (f >= 1.0f) {
            AbstractC2946e.a aVar3 = (AbstractC2946e.a) this.f10631d.get(i - 2);
            AbstractC2946e.a aVar4 = (AbstractC2946e.a) this.f10631d.get(this.f10628a - 1);
            float f7 = aVar3.f10627e;
            float f8 = aVar4.f10627e;
            float f9 = aVar3.f10624b;
            float f10 = aVar4.f10624b;
            Interpolator interpolator3 = aVar4.f10625c;
            if (interpolator3 != null) {
                f = interpolator3.getInterpolation(f);
            }
            float f11 = (f - f9) / (f10 - f9);
            InterfaceC2951j interfaceC2951j3 = this.f10632e;
            return interfaceC2951j3 == null ? CustomString.m3148a(f8, f7, f11, f7) : ((Number) interfaceC2951j3.evaluate(f11, Float.valueOf(f7), Float.valueOf(f8))).floatValue();
        }
        AbstractC2946e.a aVar5 = (AbstractC2946e.a) this.f10631d.get(0);
        int i2 = 1;
        while (true) {
            int i3 = this.f10628a;
            if (i2 >= i3) {
                return Float.valueOf(((AbstractC2946e.a) this.f10631d.get(i3 - 1)).f10627e).floatValue();
            }
            AbstractC2946e.a aVar6 = (AbstractC2946e.a) this.f10631d.get(i2);
            if (f < aVar6.f10624b) {
                Interpolator interpolator4 = aVar6.f10625c;
                if (interpolator4 != null) {
                    f = interpolator4.getInterpolation(f);
                }
                float f12 = aVar5.f10624b;
                float f13 = (f - f12) / (aVar6.f10624b - f12);
                float f14 = aVar5.f10627e;
                float f15 = aVar6.f10627e;
                InterfaceC2951j interfaceC2951j4 = this.f10632e;
                return interfaceC2951j4 == null ? CustomString.m3148a(f15, f14, f13, f14) : ((Number) interfaceC2951j4.evaluate(f13, Float.valueOf(f14), Float.valueOf(f15))).floatValue();
            }
            i2++;
            aVar5 = aVar6;
        }
    }


}
