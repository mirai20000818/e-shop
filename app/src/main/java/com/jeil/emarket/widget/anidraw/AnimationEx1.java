package com.jeil.emarket.widget.anidraw;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout;

/* renamed from: b.f.a.c.k0.j */

public class AnimationEx1 extends Animation {


    public final  WaveSwipeRefreshLayout f8486b;

    public AnimationEx1(WaveSwipeRefreshLayout waveSwipeRefreshLayout) {
        this.f8486b = waveSwipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        WaveSwipeRefreshLayout.C3257d c3257d = this.f8486b.f12304g;
        float f2 = 1.0f - f;
        c3257d.setScaleX(f2);
        c3257d.setScaleY(f2);
    }
}
