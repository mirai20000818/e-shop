package custom.google.android.material.p153v;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: b.e.a.a.v.a */
/* loaded from: classes.dex */
public final class C1175a implements InterfaceC1177c {

    /* renamed from: a */
    public final float f5983a;

    public C1175a(float f) {
        this.f5983a = f;
    }

    @Override // p078b.p126e.p127a.p128a.p153v.InterfaceC1177c
    /* renamed from: a */
    public float mo4144a(RectF rectF) {
        return this.f5983a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1175a) && this.f5983a == ((C1175a) obj).f5983a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5983a)});
    }
}
