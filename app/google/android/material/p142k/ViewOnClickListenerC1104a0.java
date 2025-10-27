package custom.google.android.material.p142k;

import android.view.View;

/* renamed from: b.e.a.a.k.a0 */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1104a0 implements View.OnClickListener {

    /* renamed from: b */
    public final /* synthetic */ int f5596b;

    /* renamed from: c */
    public final /* synthetic */ C1106b0 f5597c;

    public ViewOnClickListenerC1104a0(C1106b0 c1106b0, int i) {
        this.f5597c = c1106b0;
        this.f5596b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1122r m4021a = C1122r.m4021a(this.f5596b, this.f5597c.f5604d.m4002V0().f5682c);
        C1103a m4000T0 = this.f5597c.f5604d.m4000T0();
        if (m4021a.compareTo(m4000T0.f5584b) < 0) {
            m4021a = m4000T0.f5584b;
        } else if (m4021a.compareTo(m4000T0.f5585c) > 0) {
            m4021a = m4000T0.f5585c;
        }
        this.f5597c.f5604d.m4007a(m4021a);
        this.f5597c.f5604d.m4006a(C1111g.e.DAY);
    }
}
