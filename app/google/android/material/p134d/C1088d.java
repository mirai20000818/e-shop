package custom.google.android.material.p134d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: b.e.a.a.d.d */
/* loaded from: classes.dex */
public class C1088d extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f5454a;

    /* renamed from: b */
    public final /* synthetic */ ActionMenuView f5455b;

    /* renamed from: c */
    public final /* synthetic */ int f5456c;

    /* renamed from: d */
    public final /* synthetic */ boolean f5457d;

    /* renamed from: e */
    public final /* synthetic */ BottomAppBar f5458e;

    public C1088d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.f5458e = bottomAppBar;
        this.f5455b = actionMenuView;
        this.f5456c = i;
        this.f5457d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f5454a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f5454a) {
            return;
        }
        boolean z = this.f5458e.f11221c0 != 0;
        BottomAppBar bottomAppBar = this.f5458e;
        bottomAppBar.m6056e(bottomAppBar.f11221c0);
        this.f5458e.m6051a(this.f5455b, this.f5456c, this.f5457d, z);
    }
}
