package custom.google.android.material.p140j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: b.e.a.a.j.a */
/* loaded from: classes.dex */
public final class C1098a extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC1101d f5564a;

    public C1098a(InterfaceC1101d interfaceC1101d) {
        this.f5564a = interfaceC1101d;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f5564a.mo3970b();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f5564a.mo3968a();
    }
}
