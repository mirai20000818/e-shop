package com.jeil.emarket.api;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: b.f.a.i.x */

public final class MyAni2 extends Animation {

    
    public final  View f10153b;

    
    public final  int f10154c;

    public MyAni2(View view, int i) {
        this.f10153b = view;
        this.f10154c = i;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        if (f == 1.0f) {
            this.f10153b.setVisibility(View.GONE);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f10153b.getLayoutParams();
        int i = this.f10154c;
        layoutParams.height = i - ((int) (i * f));
        this.f10153b.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
