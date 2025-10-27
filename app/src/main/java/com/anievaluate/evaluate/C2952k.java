package com.anievaluate.evaluate;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import com.jeil.emarket.custom.CustomString;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: b.g.a.k */
/* loaded from: classes.dex */
public class C2952k extends AbstractC2942a {

    /* renamed from: c */
    public long f10679c;

    /* renamed from: h */
    public long f10684h;

    /* renamed from: r */
    public C2950i[] f10694r;

    /* renamed from: s */
    public HashMap<java.lang.String, C2950i> f10695s;

    /* renamed from: t */
    public static ThreadLocal<f> f10672t = new ThreadLocal<>();

    /* renamed from: u */
    public static final ThreadLocal<ArrayList<C2952k>> f10673u = new a();

    /* renamed from: v */
    public static final ThreadLocal<ArrayList<C2952k>> f10674v = new b();

    /* renamed from: w */
    public static final ThreadLocal<ArrayList<C2952k>> f10675w = new c();

    /* renamed from: x */
    public static final ThreadLocal<ArrayList<C2952k>> f10676x = new d();

    /* renamed from: y */
    public static final ThreadLocal<ArrayList<C2952k>> f10677y = new e();

    /* renamed from: z */
    public static final Interpolator f10678z = new AccelerateDecelerateInterpolator();

    /* renamed from: A */
    public static long f10671A = 10;

    /* renamed from: d */
    public long f10680d = -1;

    
    public boolean f10681e = false;

    /* renamed from: f */
    public int f10682f = 0;

    /* renamed from: g */
    public boolean f10683g = false;

    
    public int f10685i = 0;

   
    public boolean f10686j = false;

    
    public boolean f10687k = false;

    /* renamed from: l */
    public long f10688l = 300;

    /* renamed from: m */
    public long f10689m = 0;

    /* renamed from: n */
    public int f10690n = 0;

    /* renamed from: o */
    public int f10691o = 1;

    /* renamed from: p */
    public Interpolator f10692p = f10678z;

    /* renamed from: q */
    public ArrayList<g> f10693q = null;

    /* renamed from: b.g.a.k$a */
    public static class a extends ThreadLocal<ArrayList<C2952k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<C2952k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* renamed from: b.g.a.k$b */
    public static class b extends ThreadLocal<ArrayList<C2952k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<C2952k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* renamed from: b.g.a.k$c */
    public static class c extends ThreadLocal<ArrayList<C2952k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<C2952k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* renamed from: b.g.a.k$d */
    public static class d extends ThreadLocal<ArrayList<C2952k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<C2952k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* renamed from: b.g.a.k$e */
    public static class e extends ThreadLocal<ArrayList<C2952k>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<C2952k> initialValue() {
            return new ArrayList<>();
        }
    }

    /* renamed from: b.g.a.k$f */
    public static class f extends Handler {
        public f() {
        }

        public /* synthetic */ f(a aVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a9 A[SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r18) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p078b.p268g.p269a.C2952k.f.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: b.g.a.k$g */
    public interface g {
        /* renamed from: a */
        void m5825a(C2952k c2952k);
    }

    /* renamed from: a */
    public static /* synthetic */ void m5821a(C2952k c2952k) {
        ArrayList<AbstractC2942a.a> arrayList;
        c2952k.mo5808b();
        f10673u.get().add(c2952k);
        if (c2952k.f10689m <= 0 || (arrayList = c2952k.f10619b) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC2942a.a) arrayList2.get(i)).mo4316c(c2952k);
        }
    }

    /* renamed from: a */
    public final void m5822a() {
        ArrayList<AbstractC2942a.a> arrayList;
        f10673u.get().remove(this);
        f10674v.get().remove(this);
        f10675w.get().remove(this);
        this.f10685i = 0;
        if (this.f10686j && (arrayList = this.f10619b) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ((AbstractC2942a.a) arrayList2.get(i)).mo4314a(this);
            }
        }
        this.f10686j = false;
    }

    /* renamed from: a */
    public void mo5806a(float f2) {
        float interpolation = this.f10692p.getInterpolation(f2);
        int length = this.f10694r.length;
        for (int i = 0; i < length; i++) {
            this.f10694r[i].mo5817a(interpolation);
        }
        ArrayList<g> arrayList = this.f10693q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f10693q.get(i2).m5825a(this);
            }
        }
    }

    /* renamed from: a */
    public boolean m5824a(long j) {
        if (this.f10685i == 0) {
            this.f10685i = 1;
            long j2 = this.f10680d;
            if (j2 < 0) {
                this.f10679c = j;
            } else {
                this.f10679c = j - j2;
                this.f10680d = -1L;
            }
        }
        int i = this.f10685i;
        boolean z = false;
        if (i == 1 || i == 2) {
            long j3 = this.f10688l;
            float f2 = j3 > 0 ? (j - this.f10679c) / j3 : 1.0f;
            if (f2 >= 1.0f) {
                int i2 = this.f10682f;
                int i3 = this.f10690n;
                if (i2 < i3 || i3 == -1) {
                    ArrayList<AbstractC2942a.a> arrayList = this.f10619b;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            this.f10619b.get(i4).mo4315b(this);
                        }
                    }
                    if (this.f10691o == 2) {
                        this.f10681e = !this.f10681e;
                    }
                    this.f10682f += (int) f2;
                    f2 %= 1.0f;
                    this.f10679c += this.f10688l;
                } else {
                    f2 = Math.min(f2, 1.0f);
                    z = true;
                }
            }
            if (this.f10681e) {
                f2 = 1.0f - f2;
            }
            mo5806a(f2);
        }
        return z;
    }

    /* renamed from: b */
    public void mo5808b() {
        if (this.f10687k) {
            return;
        }
        int length = this.f10694r.length;
        for (int i = 0; i < length; i++) {
            C2950i c2950i = this.f10694r[i];
            if (c2950i.f10666j == null) {
                Class cls = c2950i.f10662f;
                c2950i.f10666j = cls == Integer.class ? C2950i.f10651l : cls == Float.class ? C2950i.f10652m : null;
            }
            InterfaceC2951j interfaceC2951j = c2950i.f10666j;
            if (interfaceC2951j != null) {
                c2950i.f10663g.f10632e = interfaceC2951j;
            }
        }
        this.f10687k = true;
    }

    @Override // p078b.p268g.p269a.AbstractC2942a
    /* renamed from: clone */
    public C2952k mo7450clone() {
        C2952k c2952k = (C2952k) super.mo7450clone();
        ArrayList<g> arrayList = this.f10693q;
        if (arrayList != null) {
            c2952k.f10693q = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                c2952k.f10693q.add(arrayList.get(i));
            }
        }
        c2952k.f10680d = -1L;
        c2952k.f10681e = false;
        c2952k.f10682f = 0;
        c2952k.f10687k = false;
        c2952k.f10685i = 0;
        c2952k.f10683g = false;
        C2950i[] c2950iArr = this.f10694r;
        if (c2950iArr != null) {
            int length = c2950iArr.length;
            c2952k.f10694r = new C2950i[length];
            c2952k.f10695s = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                C2950i mo7453clone = c2950iArr[i2];
                c2952k.f10694r[i2] = mo7453clone;
                c2952k.f10695s.put(mo7453clone.f10658b, mo7453clone);
            }
        }
        return c2952k;
    }

    public java.lang.String toString() {
        StringBuilder m3163a = CustomString.format("ValueAnimator@");
        m3163a.append(Integer.toHexString(hashCode()));
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

    /* renamed from: a */
    public void m5823a(C2950i... c2950iArr) {
        int length = c2950iArr.length;
        this.f10694r = c2950iArr;
        this.f10695s = new HashMap<>(length);
        for (C2950i c2950i : c2950iArr) {
            this.f10695s.put(c2950i.f10658b, c2950i);
        }
        this.f10687k = false;
    }
}
