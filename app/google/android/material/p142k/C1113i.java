package custom.google.android.material.p142k;

import android.view.View;
import com.google.android.material.R$string;
import androidx.core.view.C0271a;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: b.e.a.a.k.i */
/* loaded from: classes.dex */
public class C1113i extends C0271a {

    /* renamed from: d */
    public final /* synthetic */ C1111g f5644d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1113i(C1111g c1111g) {
        super(C0271a.f1758c);
        this.f5644d = c1111g;
    }

    @Override // p000a.p030h.p042i.C0271a
    /* renamed from: a */
    public void mo1151a(View view, AccessibilityNodeInfoCompat c0281b) {
        C1111g c1111g;
        int i;
        this.f1759a.onInitializeAccessibilityNodeInfo(view, c0281b.f1813a);
        if (this.f5644d.f5632k0.getVisibility() == 0) {
            c1111g = this.f5644d;
            i = R$string.mtrl_picker_toggle_to_year_selection;
        } else {
            c1111g = this.f5644d;
            i = R$string.mtrl_picker_toggle_to_day_selection;
        }
        c0281b.m1201a((CharSequence) c1111g.m2498a(i));
    }
}
