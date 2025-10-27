package custom.google.android.material.p132b0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;
import custom.google.android.material.p140j.InterfaceC1101d;

/* renamed from: b.e.a.a.b0.b */
/* loaded from: classes.dex */
public class C1080b extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ InterfaceC1101d f5445a;

    /* renamed from: b */
    public final /* synthetic */ Drawable f5446b;

    public C1080b(FabTransformationBehavior fabTransformationBehavior, InterfaceC1101d interfaceC1101d, Drawable drawable) {
        this.f5445a = interfaceC1101d;
        this.f5446b = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f5445a.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f5445a.setCircularRevealOverlayDrawable(this.f5446b);
    }
}
