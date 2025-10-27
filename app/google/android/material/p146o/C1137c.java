package custom.google.android.material.p146o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: b.e.a.a.o.c */
/* loaded from: classes.dex */
public class C1137c extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ boolean f5722a;

    /* renamed from: b */
    public final /* synthetic */ C1138d.f f5723b;

    /* renamed from: c */
    public final /* synthetic */ C1138d f5724c;

    public C1137c(C1138d c1138d, boolean z, C1138d.f fVar) {
        this.f5724c = c1138d;
        this.f5722a = z;
        this.f5723b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C1138d c1138d = this.f5724c;
        c1138d.f5755t = 0;
        c1138d.f5749n = null;
        C1138d.f fVar = this.f5723b;
        if (fVar != null) {
            C1135a c1135a = (C1135a) fVar;
            c1135a.f5716a.mo3902b(c1135a.f5717b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f5724c.f5759x.m4127a(0, this.f5722a);
        C1138d c1138d = this.f5724c;
        c1138d.f5755t = 2;
        c1138d.f5749n = animator;
    }
}
