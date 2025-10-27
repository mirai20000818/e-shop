package custom.google.android.material.mng3;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.accessibility.InterfaceC0283d;

/* renamed from: b.e.a.a.b.c */
/* loaded from: classes.dex */
public class C1073c implements InterfaceC0283d {

    /* renamed from: a */
    public final /* synthetic */ CoordinatorLayout f5414a;

    /* renamed from: b */
    public final /* synthetic */ AppBarLayout f5415b;

    /* renamed from: c */
    public final /* synthetic */ View f5416c;

    /* renamed from: d */
    public final /* synthetic */ int f5417d;

    /* renamed from: e */
    public final /* synthetic */ AppBarLayout.BaseBehavior f5418e;

    public C1073c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        this.f5418e = baseBehavior;
        this.f5414a = coordinatorLayout;
        this.f5415b = appBarLayout;
        this.f5416c = view;
        this.f5417d = i;
    }

    @Override // p000a.p030h.p042i.p043e0.InterfaceC0283d
    /* renamed from: a */
    public boolean mo1223a(View view, InterfaceC0283d.a aVar) {
        this.f5418e.m6019a(this.f5414a, this.f5415b, this.f5416c, this.f5417d, new int[]{0, 0});
        return true;
    }
}
