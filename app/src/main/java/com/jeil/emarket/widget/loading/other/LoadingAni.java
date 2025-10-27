package com.jeil.emarket.widget.loading.other;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: b.f.a.c.g0.b.b */

public class LoadingAni implements ValueAnimator.AnimatorUpdateListener {


    public final  int f8323a;


    public final  LodingObj f8324b;

    public LoadingAni(LodingObj lodingObj, int i) {
        this.f8324b = lodingObj;
        this.f8323a = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8324b.f8325c[this.f8323a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f8324b.f8327a;
        if (view != null) {
            view.postInvalidate();
        }
    }
}
