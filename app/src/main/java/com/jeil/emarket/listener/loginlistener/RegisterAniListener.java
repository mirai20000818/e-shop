package com.jeil.emarket.listener.loginlistener;

import android.animation.Animator;
import android.view.View;

import com.jeil.emarket.activities.auth.RegisterActivity;

/* renamed from: b.f.a.a.b.g1 */

public class RegisterAniListener implements Animator.AnimatorListener {


    public final  View f6400a;

    public RegisterAniListener(RegisterActivity registerActivity, View view) {
        this.f6400a = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f6400a.findViewById(R.id.llc_first).setVisibility(View.VISIBLE);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
