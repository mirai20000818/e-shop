package custom.google.android.material.p156y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: b.e.a.a.y.c */
/* loaded from: classes.dex */
public class C1198c extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ C1196a f6132a;

    public C1198c(C1196a c1196a) {
        this.f6132a = c1196a;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f6132a.f6166a.setEndIconVisible(false);
    }
}
