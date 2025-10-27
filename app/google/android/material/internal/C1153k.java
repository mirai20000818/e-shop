package custom.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* renamed from: b.e.a.a.p.k */
/* loaded from: classes.dex */
public final class C1153k {

    /* renamed from: a */
    public final ArrayList<b> f5886a = new ArrayList<>();

    /* renamed from: b */
    public b f5887b = null;

    /* renamed from: c */
    public ValueAnimator f5888c = null;

    /* renamed from: d */
    public final Animator.AnimatorListener f5889d = new a();

    /* renamed from: b.e.a.a.p.k$a */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1153k c1153k = C1153k.this;
            if (c1153k.f5888c == animator) {
                c1153k.f5888c = null;
            }
        }
    }

    /* renamed from: b.e.a.a.p.k$b */
    public static class b {

        /* renamed from: a */
        public final int[] f5891a;

        /* renamed from: b */
        public final ValueAnimator f5892b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f5891a = iArr;
            this.f5892b = valueAnimator;
        }
    }

    /* renamed from: a */
    public void m4117a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f5889d);
        this.f5886a.add(bVar);
    }
}
