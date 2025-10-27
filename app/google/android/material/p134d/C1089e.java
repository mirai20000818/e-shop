package custom.google.android.material.p134d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* renamed from: b.e.a.a.d.e */
/* loaded from: classes.dex */
public class C1089e extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ BottomAppBar f5459a;

    public C1089e(BottomAppBar bottomAppBar) {
        this.f5459a = bottomAppBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        float fabTranslationX;
        this.f5459a.f11228j0.onAnimationStart(animator);
        FloatingActionButton m6059q = this.f5459a.m6059q();
        if (m6059q != null) {
            fabTranslationX = this.f5459a.getFabTranslationX();
            m6059q.setTranslationX(fabTranslationX);
        }
    }
}
