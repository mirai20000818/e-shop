package custom.google.android.material.p134d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: b.e.a.a.d.c */
/* loaded from: classes.dex */
public class C1087c extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ BottomAppBar f5453a;

    public C1087c(BottomAppBar bottomAppBar) {
        this.f5453a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar.m6044b(this.f5453a);
        BottomAppBar bottomAppBar = this.f5453a;
        bottomAppBar.f11222d0 = false;
        bottomAppBar.f11215T = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f5453a.m6058p();
    }
}
