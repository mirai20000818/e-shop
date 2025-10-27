package custom.google.android.material.internal;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.C0278d0;
import androidx.core.view.InterfaceC0297n;
import custom.google.android.material.p135e.C1092b;

/* renamed from: b.e.a.a.p.p */
/* loaded from: classes.dex */
public final class C1158p implements InterfaceC0297n {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC1160r f5919a;

    /* renamed from: b */
    public final /* synthetic */ C1161s f5920b;

    public C1158p(InterfaceC1160r interfaceC1160r, C1161s c1161s) {
        this.f5919a = interfaceC1160r;
        this.f5920b = c1161s;
    }

    @Override // p000a.p030h.p042i.InterfaceC0297n
    /* renamed from: a */
    public C0278d0 mo368a(View view, C0278d0 c0278d0) {
        boolean z;
        boolean z2;
        InterfaceC1160r interfaceC1160r = this.f5919a;
        C1161s c1161s = this.f5920b;
        int i = c1161s.f5921a;
        int i2 = c1161s.f5922b;
        int i3 = c1161s.f5923c;
        int i4 = c1161s.f5924d;
        C1092b c1092b = (C1092b) interfaceC1160r;
        c1092b.f5468b.f11283s = c0278d0.m1166e();
        boolean m340d = Util.m340d(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        z = c1092b.f5468b.f11278n;
        if (z) {
            c1092b.f5468b.f11282r = c0278d0.m1163b();
            paddingBottom = c1092b.f5468b.f11282r + i4;
        }
        if (c1092b.f5468b.f11279o) {
            paddingLeft = c0278d0.m1164c() + (m340d ? i3 : i);
        }
        if (c1092b.f5468b.f11280p) {
            if (!m340d) {
                i = i3;
            }
            paddingRight = c0278d0.m1165d() + i;
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        if (c1092b.f5467a) {
            c1092b.f5468b.f11276l = c0278d0.f1775a.mo1191e().f1639d;
        }
        z2 = c1092b.f5468b.f11278n;
        if (z2 || c1092b.f5467a) {
            c1092b.f5468b.m6088g(false);
        }
        return c0278d0;
    }
}
