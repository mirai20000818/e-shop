package custom.google.android.material.p135e;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import custom.google.android.material.p153v.C1181g;

/* renamed from: b.e.a.a.e.a */
/* loaded from: classes.dex */
public class C1091a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ BottomSheetBehavior f5466a;

    public C1091a(BottomSheetBehavior bottomSheetBehavior) {
        this.f5466a = bottomSheetBehavior;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        C1181g c1181g = this.f5466a.f11274j;
        if (c1181g != null) {
            c1181g.m4162b(floatValue);
        }
    }
}
