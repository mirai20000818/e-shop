package custom.google.android.material.p153v;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: b.e.a.a.v.b */
/* loaded from: classes.dex */
public final class C1176b implements InterfaceC1177c {

    /* renamed from: a */
    public final InterfaceC1177c f5984a;

    /* renamed from: b */
    public final float f5985b;

    public C1176b(float f, InterfaceC1177c interfaceC1177c) {
        while (interfaceC1177c instanceof C1176b) {
            interfaceC1177c = ((C1176b) interfaceC1177c).f5984a;
            f += ((C1176b) interfaceC1177c).f5985b;
        }
        this.f5984a = interfaceC1177c;
        this.f5985b = f;
    }

    @Override // p078b.p126e.p127a.p128a.p153v.InterfaceC1177c
    /* renamed from: a */
    public float mo4144a(RectF rectF) {
        return Math.max(0.0f, this.f5984a.mo4144a(rectF) + this.f5985b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1176b)) {
            return false;
        }
        C1176b c1176b = (C1176b) obj;
        return this.f5984a.equals(c1176b.f5984a) && this.f5985b == c1176b.f5985b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5984a, Float.valueOf(this.f5985b)});
    }
}
