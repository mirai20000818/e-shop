package com.jeil.emarket.listener.loginlistener;

import android.animation.Animator;
import android.view.View;

import com.jeil.emarket.activities.auth.RegisterActivity;

/* renamed from: b.f.a.a.b.h1 */

public class RegisterAniListener1 implements Animator.AnimatorListener {


    public final  View f6403a;

    public RegisterAniListener1(RegisterActivity registerActivity, View view) {
        this.f6403a = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f6403a.findViewById(R.id.llc_first).setVisibility(View.GONE);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
