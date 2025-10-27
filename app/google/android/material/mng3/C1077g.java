package custom.google.android.material.mng3;

import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: b.e.a.a.b.g */
/* loaded from: classes.dex */
public class C1077g {

    /* renamed from: a */
    public final View f5436a;

    /* renamed from: b */
    public int f5437b;

    /* renamed from: c */
    public int f5438c;

    /* renamed from: d */
    public int f5439d;

    /* renamed from: e */
    public int f5440e;

    /* renamed from: f */
    public boolean f5441f = true;

    /* renamed from: g */
    public boolean f5442g = true;

    public C1077g(View view) {
        this.f5436a = view;
    }

    /* renamed from: a */
    public void m3898a() {
        View view = this.f5436a;
        ViewCompat.m1299e(view, this.f5439d - (view.getTop() - this.f5437b));
        View view2 = this.f5436a;
        ViewCompat.m1297d(view2, this.f5440e - (view2.getLeft() - this.f5438c));
    }
}
