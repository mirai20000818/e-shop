package custom.google.android.material.p142k;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.p068a.C0453l;

/* renamed from: b.e.a.a.k.x */
/* loaded from: classes.dex */
public class C1128x extends LinearLayoutManager {

    /* renamed from: b.e.a.a.k.x$a */
    public class a extends C0453l {
        public a(C1128x c1128x, Context context) {
            super(context);
        }

        @Override // p000a.p067s.p068a.C0453l
        /* renamed from: a */
        public float mo1987a(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public C1128x(Context context, int i, boolean z) {
        super(i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /* renamed from: a */
    public void mo2682a(RecyclerView recyclerView, RecyclerView.C0638z c0638z, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.f4008a = i;
        m2944b(aVar);
    }
}
