package custom.google.android.material.p133c;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.InterfaceC0283d;

/* renamed from: b.e.a.a.c.a */
/* loaded from: classes.dex */
public class C1084a implements InterfaceC0283d {

    /* renamed from: a */
    public final /* synthetic */ SwipeDismissBehavior f5448a;

    public C1084a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f5448a = swipeDismissBehavior;
    }

    @Override // p000a.p030h.p042i.p043e0.InterfaceC0283d
    /* renamed from: a */
    public boolean mo1223a(View view, InterfaceC0283d.a aVar) {
        boolean z = false;
        if (!this.f5448a.mo6038a(view)) {
            return false;
        }
        boolean z2 = ViewCompat.m1310m(view) == 1;
        if ((this.f5448a.f11201f == 0 && z2) || (this.f5448a.f11201f == 1 && !z2)) {
            z = true;
        }
        int width = view.getWidth();
        if (z) {
            width = -width;
        }
        ViewCompat.m1297d(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.InterfaceC3021b interfaceC3021b = this.f5448a.f11197b;
        if (interfaceC3021b != null) {
            interfaceC3021b.m6041a(view);
        }
        return true;
    }
}
