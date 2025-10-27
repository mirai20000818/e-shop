package custom.google.android.material.p153v;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: b.e.a.a.v.i */
/* loaded from: classes.dex */
public final class C1183i implements InterfaceC1177c {

    /* renamed from: a */
    public final float f6035a;

    public C1183i(float f) {
        this.f6035a = f;
    }

    @Override // p078b.p126e.p127a.p128a.p153v.InterfaceC1177c
    /* renamed from: a */
    public float mo4144a(RectF rectF) {
        return rectF.height() * this.f6035a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1183i) && this.f6035a == ((C1183i) obj).f6035a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f6035a)});
    }
}
