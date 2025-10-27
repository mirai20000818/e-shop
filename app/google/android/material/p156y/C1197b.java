package custom.google.android.material.p156y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: b.e.a.a.y.b */
/* loaded from: classes.dex */
public class C1197b extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ C1196a f6131a;

    public C1197b(C1196a c1196a) {
        this.f6131a = c1196a;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f6131a.f6166a.setEndIconVisible(true);
    }
}
