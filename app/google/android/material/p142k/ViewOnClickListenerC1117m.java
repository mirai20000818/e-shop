package custom.google.android.material.p142k;

import android.view.View;

/* renamed from: b.e.a.a.k.m */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1117m implements View.OnClickListener {

    /* renamed from: b */
    public final /* synthetic */ C1125u f5651b;

    /* renamed from: c */
    public final /* synthetic */ C1111g f5652c;

    public ViewOnClickListenerC1117m(C1111g c1111g, C1125u c1125u) {
        this.f5652c = c1111g;
        this.f5651b = c1125u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int m2660R = this.f5652c.m4004X0().m2660R() - 1;
        if (m2660R >= 0) {
            this.f5652c.m4007a(this.f5651b.m4036f(m2660R));
        }
    }
}
