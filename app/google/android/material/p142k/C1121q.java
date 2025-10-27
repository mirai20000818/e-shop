package custom.google.android.material.p142k;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* renamed from: b.e.a.a.k.q */
/* loaded from: classes.dex */
public final class C1121q<S> extends AbstractC1127w<S> {

    /* renamed from: b0 */
    public int f5677b0;

    /* renamed from: c0 */
    public InterfaceC1108d<S> f5678c0;

    /* renamed from: d0 */
    public C1103a f5679d0;

    /* renamed from: b.e.a.a.k.q$a */
    public class a extends AbstractC1126v<S> {
        public a() {
        }

        @Override // p078b.p126e.p127a.p128a.p142k.AbstractC1126v
        /* renamed from: a */
        public void mo4019a(S s) {
            Iterator<AbstractC1126v<S>> it = C1121q.this.f5703a0.iterator();
            while (it.hasNext()) {
                it.next().mo4019a(s);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: a */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f5678c0.m3988a(layoutInflater.cloneInContext(new ContextThemeWrapper(m2557p(), this.f5677b0)), viewGroup, bundle, this.f5679d0, new a());
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: a */
    public void mo1694a(Bundle bundle) {
        super.mo1694a(bundle);
        if (bundle == null) {
            bundle = m2553n();
        }
        this.f5677b0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f5678c0 = (InterfaceC1108d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f5679d0 = (C1103a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: c */
    public void mo1699c(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f5677b0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f5678c0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5679d0);
    }
}
