package com.jeil.emarket.widget.anidraw;

import android.view.animation.Animation;

/* renamed from: b.f.a.c.k0.i */

public class AnimationAnimationListener implements Animation.AnimationListener {

    
    public final  DrawableEx.c f8484a;

    
    public final  DrawableEx f8485b;

    public AnimationAnimationListener(DrawableEx drawableEx, DrawableEx.c cVar) {
        this.f8485b = drawableEx;
        this.f8484a = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        DrawableEx.c cVar = this.f8484a;
        cVar.f8471e = cVar.f8470d;
        float f = cVar.f8472f;
        cVar.f8473g = f;
        cVar.f8475i = cVar.f8474h;
        cVar.f8470d = f;
        cVar.m4660a();
        DrawableEx drawableEx = this.f8485b;
        if (drawableEx.f8459d) {
            drawableEx.f8459d = false;
            animation.setDuration(1333L);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
