package custom.google.android.material.p142k;

import android.view.View;

/* renamed from: b.e.a.a.k.l */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1116l implements View.OnClickListener {

    /* renamed from: b */
    public final /* synthetic */ C1125u f5649b;

    /* renamed from: c */
    public final /* synthetic */ C1111g f5650c;

    public ViewOnClickListenerC1116l(C1111g c1111g, C1125u c1125u) {
        this.f5650c = c1111g;
        this.f5649b = c1125u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int m2658P = this.f5650c.m4004X0().m2658P() + 1;
        if (m2658P < this.f5650c.f5630i0.getAdapter().getItemCount()) {
            this.f5650c.m4007a(this.f5649b.m4036f(m2658P));
        }
    }
}
