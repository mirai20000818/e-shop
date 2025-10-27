package custom.google.android.material.p146o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: b.e.a.a.o.b */
/* loaded from: classes.dex */
public class C1136b extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f5718a;

    /* renamed from: b */
    public final /* synthetic */ boolean f5719b;

    /* renamed from: c */
    public final /* synthetic */ C1138d.f f5720c;

    /* renamed from: d */
    public final /* synthetic */ C1138d f5721d;

    public C1136b(C1138d c1138d, boolean z, C1138d.f fVar) {
        this.f5721d = c1138d;
        this.f5719b = z;
        this.f5720c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f5718a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C1138d c1138d = this.f5721d;
        c1138d.f5755t = 0;
        c1138d.f5749n = null;
        if (this.f5718a) {
            return;
        }
        c1138d.f5759x.m4127a(this.f5719b ? 8 : 4, this.f5719b);
        C1138d.f fVar = this.f5720c;
        if (fVar != null) {
            C1135a c1135a = (C1135a) fVar;
            c1135a.f5716a.mo3901a(c1135a.f5717b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f5721d.f5759x.m4127a(0, this.f5719b);
        C1138d c1138d = this.f5721d;
        c1138d.f5755t = 1;
        c1138d.f5749n = animator;
        this.f5718a = false;
    }
}
