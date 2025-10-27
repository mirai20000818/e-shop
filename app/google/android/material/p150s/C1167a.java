package custom.google.android.material.p150s;

import android.graphics.Typeface;
import custom.google.android.material.internal.C1143a;
import custom.google.android.material.internal.C1144b;

/* renamed from: b.e.a.a.s.a */
/* loaded from: classes.dex */
public final class C1167a extends AbstractC1170d {

    /* renamed from: a */
    public final Typeface f5943a;

    /* renamed from: b */
    public final a f5944b;

    /* renamed from: c */
    public boolean f5945c;

    /* renamed from: b.e.a.a.s.a$a */
    public interface a {
    }

    public C1167a(a aVar, Typeface typeface) {
        this.f5943a = typeface;
        this.f5944b = aVar;
    }

    @Override // p078b.p126e.p127a.p128a.p150s.AbstractC1170d
    /* renamed from: a */
    public void mo4120a(int i) {
        Typeface typeface = this.f5943a;
        if (this.f5945c) {
            return;
        }
        C1144b c1144b = ((C1143a) this.f5944b).f5772a;
        if (c1144b.m4083a(typeface)) {
            c1144b.m4095g();
        }
    }

    @Override // p078b.p126e.p127a.p128a.p150s.AbstractC1170d
    /* renamed from: a */
    public void mo4121a(Typeface typeface, boolean z) {
        if (this.f5945c) {
            return;
        }
        C1144b c1144b = ((C1143a) this.f5944b).f5772a;
        if (c1144b.m4083a(typeface)) {
            c1144b.m4095g();
        }
    }
}
