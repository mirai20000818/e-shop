package com.jeil.emarket.widget.anidraw;

import android.view.animation.Interpolator;

/* renamed from: b.f.a.c.k0.f */

public class InterpolatorC2071f implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f < 0.25f) {
            return (((float) Math.pow(f - 0.125d, 2.0d)) * (-38.4f)) + 0.6f;
        }
        double d2 = f;
        if (d2 < 0.5d || d2 >= 0.75d) {
            return 0.0f;
        }
        return (((float) Math.pow(d2 - 0.625d, 2.0d)) * (-19.2f)) + 0.3f;
    }
}
