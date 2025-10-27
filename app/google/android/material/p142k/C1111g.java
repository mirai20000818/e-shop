package custom.google.android.material.p142k;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import androidx.core.view.C0271a;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: b.e.a.a.k.g */
/* loaded from: classes.dex */
public final class C1111g<S> extends AbstractC1127w<S> {

    /* renamed from: l0 */
    public static final Object f5619l0 = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: m0 */
    public static final Object f5620m0 = "NAVIGATION_PREV_TAG";

    /* renamed from: n0 */
    public static final Object f5621n0 = "NAVIGATION_NEXT_TAG";

    /* renamed from: o0 */
    public static final Object f5622o0 = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b0 */
    public int f5623b0;

    /* renamed from: c0 */
    public InterfaceC1108d<S> f5624c0;

    /* renamed from: d0 */
    public C1103a f5625d0;

    /* renamed from: e0 */
    public C1122r f5626e0;

    /* renamed from: f0 */
    public e f5627f0;

    /* renamed from: g0 */
    public C1107c f5628g0;

    /* renamed from: h0 */
    public RecyclerView f5629h0;

    /* renamed from: i0 */
    public RecyclerView f5630i0;

    /* renamed from: j0 */
    public View f5631j0;

    /* renamed from: k0 */
    public View f5632k0;

    /* renamed from: b.e.a.a.k.g$a */
    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ int f5633b;

        public a(int i) {
            this.f5633b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1111g.this.f5630i0.m2806j(this.f5633b);
        }
    }

    /* renamed from: b.e.a.a.k.g$b */
    public class b extends C0271a {
        public b(C1111g c1111g) {
            super(C0271a.f1758c);
        }

        @Override // p000a.p030h.p042i.C0271a
        /* renamed from: a */
        public void mo1151a(View view, AccessibilityNodeInfoCompat c0281b) {
            this.f1759a.onInitializeAccessibilityNodeInfo(view, c0281b.f1813a);
            c0281b.m1202a((Object) null);
        }
    }

    /* renamed from: b.e.a.a.k.g$c */
    public class c extends C1128x {

        /* renamed from: I */
        public final /* synthetic */ int f5635I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.f5635I = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        /* renamed from: a */
        public void mo2681a(RecyclerView.C0638z c0638z, int[] iArr) {
            if (this.f5635I == 0) {
                iArr[0] = C1111g.this.f5630i0.getWidth();
                iArr[1] = C1111g.this.f5630i0.getWidth();
            } else {
                iArr[0] = C1111g.this.f5630i0.getHeight();
                iArr[1] = C1111g.this.f5630i0.getHeight();
            }
        }
    }

    /* renamed from: b.e.a.a.k.g$d */
    public class d implements f {
        public d() {
        }
    }

    /* renamed from: b.e.a.a.k.g$e */
    public enum e {
        DAY,
        YEAR
    }

    /* renamed from: b.e.a.a.k.g$f */
    public interface f {
    }

    /* renamed from: b */
    public static int m3999b(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    /* renamed from: T0 */
    public C1103a m4000T0() {
        return this.f5625d0;
    }

    /* renamed from: U0 */
    public C1107c m4001U0() {
        return this.f5628g0;
    }

    /* renamed from: V0 */
    public C1122r m4002V0() {
        return this.f5626e0;
    }

    /* renamed from: W0 */
    public InterfaceC1108d<S> m4003W0() {
        return this.f5624c0;
    }

    /* renamed from: X0 */
    public LinearLayoutManager m4004X0() {
        return (LinearLayoutManager) this.f5630i0.getLayoutManager();
    }

    /* renamed from: Y0 */
    public void m4005Y0() {
        e eVar;
        e eVar2 = this.f5627f0;
        if (eVar2 == e.YEAR) {
            eVar = e.DAY;
        } else if (eVar2 != e.DAY) {
            return;
        } else {
            eVar = e.YEAR;
        }
        m4006a(eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x013d, code lost:
    
        r13 = new p000a.p067s.p068a.C0459r();
     */
    @Override // androidx.fragment.app.Fragment
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onCreateView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p142k.C1111g.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: a */
    public void mo1694a(Bundle bundle) {
        super.mo1694a(bundle);
        if (bundle == null) {
            bundle = m2553n();
        }
        this.f5623b0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f5624c0 = (InterfaceC1108d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f5625d0 = (C1103a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f5626e0 = (C1122r) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* renamed from: a */
    public void m4006a(e eVar) {
        this.f5627f0 = eVar;
        if (eVar == e.YEAR) {
            this.f5629h0.getLayoutManager().mo2703k(((C1106b0) this.f5629h0.getAdapter()).m3987f(this.f5626e0.f5683d));
            this.f5631j0.setVisibility(View.VISIBLE);
            this.f5632k0.setVisibility(View.GONE);
        } else if (eVar == e.DAY) {
            this.f5631j0.setVisibility(View.GONE);
            this.f5632k0.setVisibility(View.VISIBLE);
            m4007a(this.f5626e0);
        }
    }

    @Override // p078b.p126e.p127a.p128a.p142k.AbstractC1127w
    /* renamed from: a */
    public boolean mo4008a(AbstractC1126v<S> abstractC1126v) {
        return super.mo4008a(abstractC1126v);
    }

    /* renamed from: c */
    public final void m4009c(int i) {
        this.f5630i0.post(new a(i));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: c */
    public void mo1699c(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f5623b0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f5624c0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5625d0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f5626e0);
    }

    /* renamed from: a */
    public void m4007a(C1122r c1122r) {
        RecyclerView recyclerView;
        int i;
        C1125u c1125u = (C1125u) this.f5630i0.getAdapter();
        int m4026b = c1125u.f5697e.f5584b.m4026b(c1122r);
        int m4035a = m4026b - c1125u.m4035a(this.f5626e0);
        boolean z = Math.abs(m4035a) > 3;
        boolean z2 = m4035a > 0;
        this.f5626e0 = c1122r;
        if (!z || !z2) {
            if (z) {
                recyclerView = this.f5630i0;
                i = m4026b + 3;
            }
            m4009c(m4026b);
        }
        recyclerView = this.f5630i0;
        i = m4026b - 3;
        recyclerView.mo2803i(i);
        m4009c(m4026b);
    }
}
