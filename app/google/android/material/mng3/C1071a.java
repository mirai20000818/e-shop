package custom.google.android.material.mng3;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;
import custom.google.android.material.p153v.C1181g;

/* renamed from: b.e.a.a.b.a */
/* loaded from: classes.dex */
public class C1071a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ C1181g f5410a;

    public C1071a(AppBarLayout appBarLayout, C1181g c1181g) {
        this.f5410a = c1181g;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f5410a.m4152a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
