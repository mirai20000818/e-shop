package custom.google.android.material.p132b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.transformation.FabTransformationBehavior;
import custom.google.android.material.p140j.InterfaceC1101d;

/* renamed from: b.e.a.a.b0.c */
/* loaded from: classes.dex */
public class C1081c extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC1101d f5447a;

    public C1081c(FabTransformationBehavior fabTransformationBehavior, InterfaceC1101d interfaceC1101d) {
        this.f5447a = interfaceC1101d;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        InterfaceC1101d.e revealInfo = this.f5447a.getRevealInfo();
        revealInfo.f5582c = Float.MAX_VALUE;
        this.f5447a.setRevealInfo(revealInfo);
    }
}
