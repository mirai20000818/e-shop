package com.jeil.emarket.widget.anidraw;

import android.content.Context;
import android.view.animation.Animation;
import androidx.appcompat.widget.AppCompatImageView;

/* renamed from: b.f.a.c.k0.e */

public class AppCompatImageViewEx extends AppCompatImageView {


    public Animation.AnimationListener f8453d;

    public AppCompatImageViewEx(Context context) {
        super(context);
    }


    public void m4658a(Animation.AnimationListener animationListener) {
        this.f8453d = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f8453d;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f8453d;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }
}
