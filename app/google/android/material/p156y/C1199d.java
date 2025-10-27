package custom.google.android.material.p156y;

import android.animation.ValueAnimator;

/* renamed from: b.e.a.a.y.d */
/* loaded from: classes.dex */
public class C1199d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ C1196a f6133a;

    public C1199d(C1196a c1196a) {
        this.f6133a = c1196a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f6133a.f6168c.setScaleX(floatValue);
        this.f6133a.f6168c.setScaleY(floatValue);
    }
}
