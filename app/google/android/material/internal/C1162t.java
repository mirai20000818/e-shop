package custom.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: b.e.a.a.p.t */
/* loaded from: classes.dex */
public class C1162t extends ImageButton {

    /* renamed from: b */
    public int f5925b;

    /* renamed from: a */
    public final void m4127a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f5925b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f5925b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        m4127a(i, true);
    }
}
