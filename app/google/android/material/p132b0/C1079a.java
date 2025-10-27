package custom.google.android.material.p132b0;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

/* renamed from: b.e.a.a.b0.a */
/* loaded from: classes.dex */
public class C1079a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ View f5444a;

    public C1079a(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f5444a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f5444a.invalidate();
    }
}
