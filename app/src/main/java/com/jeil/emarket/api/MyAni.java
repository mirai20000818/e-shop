package com.jeil.emarket.api;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: b.f.a.i.w */

public final class MyAni extends Animation {


    public final  View f10151b;


    public final  int f10152c;

    public MyAni(View view, int i) {
        this.f10151b = view;
        this.f10152c = i;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        this.f10151b.getLayoutParams().height = f == 1.0f ? -2 : (int) (this.f10152c * f);
        this.f10151b.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
