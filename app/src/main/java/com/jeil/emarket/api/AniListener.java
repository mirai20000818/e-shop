package com.jeil.emarket.api;

import android.view.animation.Animation;

/* renamed from: b.f.a.i.v */

public final class AniListener implements Animation.AnimationListener {

    
    public final  Interface3 f10150a;

    public AniListener(Interface3 interface3) {
        this.f10150a = interface3;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f10150a.mo4432a();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
