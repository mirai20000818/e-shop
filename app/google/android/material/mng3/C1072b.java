package custom.google.android.material.mng3;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: b.e.a.a.b.b */
/* loaded from: classes.dex */
public class C1072b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ CoordinatorLayout f5411a;

    /* renamed from: b */
    public final /* synthetic */ AppBarLayout f5412b;

    /* renamed from: c */
    public final /* synthetic */ AppBarLayout.BaseBehavior f5413c;

    public C1072b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f5413c = baseBehavior;
        this.f5411a = coordinatorLayout;
        this.f5412b = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f5413c.m3884c(this.f5411a, (CoordinatorLayout) this.f5412b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
