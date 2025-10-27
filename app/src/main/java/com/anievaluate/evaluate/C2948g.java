package com.anievaluate.evaluate;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.anievaluate.abstra.AbstractC2955c;
import com.anievaluate.ani.transAni.TransAni;
import com.jeil.emarket.custom.CustomString;

/* renamed from: b.g.a.g */
/* loaded from: classes.dex */
public final class C2948g extends C2952k {


    public static final Map<java.lang.String, AbstractC2955c> f10633E = new HashMap();

    /* renamed from: B */
    public Object f10634B;

    /* renamed from: C */
    public java.lang.String f10635C;

    /* renamed from: D */
    public AbstractC2955c f10636D;

    static {
        f10633E.put("alpha", C2949h.f10637a);
        f10633E.put("pivotX", C2949h.f10638b);
        f10633E.put("pivotY", C2949h.f10639c);
        f10633E.put("translationX", C2949h.f10640d);
        f10633E.put("translationY", C2949h.f10641e);
        f10633E.put("rotation", C2949h.f10642f);
        f10633E.put("rotationX", C2949h.f10643g);
        f10633E.put("rotationY", C2949h.f10644h);
        f10633E.put("scaleX", C2949h.f10645i);
        f10633E.put("scaleY", C2949h.f10646j);
        f10633E.put("scrollX", C2949h.f10647k);
        f10633E.put("scrollY", C2949h.f10648l);
        f10633E.put("x", C2949h.f10649m);
        f10633E.put("y", C2949h.f10650n);
    }

    public C2948g() {
    }

    public C2948g(Object obj, java.lang.String str) {
        this.f10634B = obj;
        C2950i[] c2950iArr = this.f10694r;
        if (c2950iArr != null) {
            C2950i c2950i = c2950iArr[0];
            java.lang.String str2 = c2950i.f10658b;
            c2950i.f10658b = str;
            this.f10695s.remove(str2);
            this.f10695s.put(str, c2950i);
        }
        this.f10635C = str;
        this.f10687k = false;
    }

    /* renamed from: a */
    public static C2948g m5805a(Object obj, java.lang.String str, float... fArr) {
        C2948g c2948g = new C2948g(obj, str);
        C2950i[] c2950iArr = c2948g.f10694r;
        if (c2950iArr == null || c2950iArr.length == 0) {
            AbstractC2955c abstractC2955c = c2948g.f10636D;
            if (abstractC2955c != null) {
                c2948g.m5823a(C2950i.m5812a((AbstractC2955c<?, Float>) abstractC2955c, fArr));
            } else {
                c2948g.m5823a(C2950i.m5813a(c2948g.f10635C, fArr));
            }
        } else if (fArr != null && fArr.length != 0) {
            if (c2950iArr.length == 0) {
                c2948g.m5823a(C2950i.m5813a("", fArr));
            } else {
                c2950iArr[0].mo5820a(fArr);
            }
            c2948g.f10687k = false;
        }
        return c2948g;
    }

    @Override // p078b.p268g.p269a.C2952k
    /* renamed from: a */
    public void mo5806a(float f) {
        super.mo5806a(f);
        int length = this.f10694r.length;
        for (int i = 0; i < length; i++) {
            this.f10694r[i].mo5819a(this.f10634B);
        }
    }

    @Override // p078b.p268g.p269a.C2952k
    /* renamed from: b */
    public void mo5808b() {
        if (this.f10687k) {
            return;
        }
        if (this.f10636D == null && TransAni.f10697r && (this.f10634B instanceof View) && f10633E.containsKey(this.f10635C)) {
            AbstractC2955c abstractC2955c = f10633E.get(this.f10635C);
            C2950i[] c2950iArr = this.f10694r;
            if (c2950iArr != null) {
                C2950i c2950i = c2950iArr[0];
                java.lang.String str = c2950i.f10658b;
                c2950i.f10659c = abstractC2955c;
                this.f10695s.remove(str);
                this.f10695s.put(this.f10635C, c2950i);
            }
            if (this.f10636D != null) {
                this.f10635C = abstractC2955c.f10696a;
            }
            this.f10636D = abstractC2955c;
            this.f10687k = false;
        }
        int length = this.f10694r.length;
        for (int i = 0; i < length; i++) {
            C2950i c2950i2 = this.f10694r[i];
            Object obj = this.f10634B;
            AbstractC2955c abstractC2955c2 = c2950i2.f10659c;
            if (abstractC2955c2 != null) {
                try {
                    abstractC2955c2.mo5810a(obj);
                    Iterator<AbstractC2946e> it = c2950i2.f10663g.f10631d.iterator();
                    while (it.hasNext()) {
                        AbstractC2946e next = it.next();
                        if (!next.m5804a()) {
                            next.mo5803a(c2950i2.f10659c.mo5810a(obj));
                        }
                    }
                } catch (ClassCastException unused) {
                    StringBuilder m3163a = CustomString.format("No such property (");
                    m3163a.append(c2950i2.f10659c.f10696a);
                    m3163a.append(") on target object ");
                    m3163a.append(obj);
                    m3163a.append(". Trying reflection instead");
                    m3163a.toString();
                    c2950i2.f10659c = null;
                }
            }
            Class<?> cls = obj.getClass();
            if (c2950i2.f10660d == null) {
                c2950i2.mo5818a((Class) cls);
            }
            Iterator<AbstractC2946e> it2 = c2950i2.f10663g.f10631d.iterator();
            while (it2.hasNext()) {
                AbstractC2946e next2 = it2.next();
                if (!next2.m5804a()) {
                    if (c2950i2.f10661e == null) {
                        c2950i2.f10661e = c2950i2.m5816a(cls, C2950i.f10657r, "get", null);
                    }
                    try {
                        next2.mo5803a(c2950i2.f10661e.invoke(obj, new Object[0]));
                    } catch (IllegalAccessException e2) {
                        e2.toString();
                    } catch (InvocationTargetException e3) {
                        e3.toString();
                    }
                }
            }
        }
        super.mo5808b();
    }

    /* renamed from: c */
    public void m5809c() {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f10681e = false;
        this.f10682f = 0;
        this.f10685i = 0;
        this.f10683g = false;
        C2952k.f10674v.get().add(this);
        long j = 0;
        if (this.f10689m == 0) {
            if (this.f10687k && this.f10685i != 0) {
                j = AnimationUtils.currentAnimationTimeMillis() - this.f10679c;
            }
            mo5808b();
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (this.f10685i != 1) {
                this.f10680d = j;
                this.f10685i = 2;
            }
            this.f10679c = currentAnimationTimeMillis - j;
            m5824a(currentAnimationTimeMillis);
            this.f10685i = 0;
            this.f10686j = true;
            ArrayList<AbstractC2942a.a> arrayList = this.f10619b;
            if (arrayList != null) {
                ArrayList arrayList2 = (ArrayList) arrayList.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((AbstractC2942a.a) arrayList2.get(i)).mo4316c(this);
                }
            }
        }
        C2952k.f fVar = C2952k.f10672t.get();
        if (fVar == null) {
            fVar = new C2952k.f(null);
            C2952k.f10672t.set(fVar);
        }
        fVar.sendEmptyMessage(0);
    }

    @Override // p078b.p268g.p269a.C2952k, p078b.p268g.p269a.AbstractC2942a
    /* renamed from: clone */
    public C2948g mo7450clone() {
        return (C2948g) super.mo7450clone();
    }

    @Override // p078b.p268g.p269a.C2952k
    public java.lang.String toString() {
        StringBuilder m3163a = CustomString.format("ObjectAnimator@");
        m3163a.append(Integer.toHexString(hashCode()));
        m3163a.append(", target ");
        m3163a.append(this.f10634B);
        java.lang.String sb = m3163a.toString();
        if (this.f10694r != null) {
            for (int i = 0; i < this.f10694r.length; i++) {
                StringBuilder m3177b = CustomString.m3177b(sb, "\n    ");
                m3177b.append(this.f10694r[i].toString());
                sb = m3177b.toString();
            }
        }
        return sb;
    }

    /* renamed from: b */
    public C2948g m5807b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(CustomString.m3154a("Animators cannot have negative duration: ", j));
        }
        this.f10688l = j;
        return this;
    }
}
