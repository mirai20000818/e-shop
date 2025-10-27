package com.jeil.emarket.widget.loading.other;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: b.f.a.c.g0.b.c */

public class LodingObj extends Loading {


    public float[] f8325c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    
    public int[] f8326d = {255, 255, 255, 255, 255, 255, 255, 255};


    public  void m4610a(int i, ValueAnimator valueAnimator) {
        this.f8326d[i] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        View view = this.f8327a;
        if (view != null) {
            view.postInvalidate();
        }
    }
}
