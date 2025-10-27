package custom.google.android.material.p134d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: b.e.a.a.d.a */
/* loaded from: classes.dex */
public class C1085a extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ BottomAppBar f5449a;

    public C1085a(BottomAppBar bottomAppBar) {
        this.f5449a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        BottomAppBar.m6044b(this.f5449a);
        this.f5449a.f11214S = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f5449a.m6058p();
    }
}
