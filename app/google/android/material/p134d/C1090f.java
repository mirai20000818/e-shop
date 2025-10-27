package custom.google.android.material.p134d;

import com.jeil.emarket.custom.CustomString;

import custom.google.android.material.p153v.C1180f;
import custom.google.android.material.p153v.C1187m;

/* renamed from: b.e.a.a.d.f */
/* loaded from: classes.dex */
public class C1090f extends C1180f implements Cloneable {

    /* renamed from: b */
    public float f5460b;

    /* renamed from: c */
    public float f5461c;

    /* renamed from: d */
    public float f5462d;

    /* renamed from: e */
    public float f5463e;

    /* renamed from: f */
    public float f5464f;

    /* renamed from: g */
    public float f5465g;

    /* renamed from: a */
    public void m3903a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f5463e = f;
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1180f
    /* renamed from: a */
    public void mo3904a(float f, float f2, float f3, C1187m c1187m) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12 = this.f5462d;
        if (f12 == 0.0f) {
            c1187m.m4195a(f, 0.0f);
            return;
        }
        float f13 = ((this.f5461c * 2.0f) + f12) / 2.0f;
        float f14 = f3 * this.f5460b;
        float f15 = f2 + this.f5464f;
        float m3148a = CustomString.m3148a(1.0f, f3, f13, this.f5463e * f3);
        if (m3148a / f13 >= 1.0f) {
            c1187m.m4195a(f, 0.0f);
            return;
        }
        float f16 = this.f5465g;
        float f17 = f16 * f3;
        boolean z = f16 == -1.0f || Math.abs((f16 * 2.0f) - f12) < 0.1f;
        if (z) {
            f4 = 0.0f;
            f5 = m3148a;
        } else {
            f4 = 1.75f;
            f5 = 0.0f;
        }
        float f18 = f13 + f14;
        float f19 = f5 + f14;
        float sqrt = (float) Math.sqrt((f18 * f18) - (f19 * f19));
        float f20 = f15 - sqrt;
        float f21 = f15 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f19));
        float f22 = (90.0f - degrees) + f4;
        c1187m.m4195a(f20, 0.0f);
        float f23 = f14 * 2.0f;
        c1187m.m4197a(f20 - f14, 0.0f, f20 + f14, f23, 270.0f, degrees);
        if (z) {
            f6 = f15 - f13;
            f7 = (-f13) - f5;
            f11 = 180.0f - f22;
            f8 = f13 - f5;
            f9 = f15 + f13;
            f10 = (f22 * 2.0f) - 180.0f;
        } else {
            float f24 = this.f5461c;
            float f25 = f17 * 2.0f;
            float f26 = f15 - f13;
            c1187m.m4197a(f26, -(f17 + f24), f26 + f24 + f25, f24 + f17, 180.0f - f22, ((f22 * 2.0f) - 180.0f) / 2.0f);
            float f27 = f15 + f13;
            float f28 = this.f5461c;
            c1187m.m4195a(f27 - ((f28 / 2.0f) + f17), f28 + f17);
            float f29 = this.f5461c;
            f6 = f27 - (f25 + f29);
            f7 = -(f17 + f29);
            f8 = f29 + f17;
            f9 = f27;
            f10 = f22 - 90.0f;
            f11 = 90.0f;
        }
        c1187m.m4197a(f6, f7, f9, f8, f11, f10);
        c1187m.m4197a(f21 - f14, 0.0f, f21 + f14, f23, 270.0f - degrees, degrees);
        c1187m.m4195a(f, 0.0f);
    }
}
