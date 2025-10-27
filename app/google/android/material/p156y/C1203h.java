package custom.google.android.material.p156y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: b.e.a.a.y.h */
/* loaded from: classes.dex */
public class C1203h extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ C1202g f6165a;

    public C1203h(C1202g c1202g) {
        this.f6165a = c1202g;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C1202g c1202g = this.f6165a;
        c1202g.f6168c.setChecked(c1202g.f6144j);
        this.f6165a.f6150p.start();
    }
}
