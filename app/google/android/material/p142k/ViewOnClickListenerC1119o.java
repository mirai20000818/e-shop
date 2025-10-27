package custom.google.android.material.p142k;

import android.view.View;

/* renamed from: b.e.a.a.k.o */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1119o implements View.OnClickListener {

    /* renamed from: b */
    public final /* synthetic */ C1118n f5676b;

    public ViewOnClickListenerC1119o(C1118n c1118n) {
        this.f5676b = c1118n;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1118n c1118n = this.f5676b;
        c1118n.f5662G0.setEnabled(c1118n.f5668v0.m3994c());
        this.f5676b.f5660E0.toggle();
        C1118n c1118n2 = this.f5676b;
        c1118n2.m4017a(c1118n2.f5660E0);
        this.f5676b.m4016Z0();
    }
}
