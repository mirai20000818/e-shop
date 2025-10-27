package com.jeil.emarket.listener.loginlistener;

import android.animation.Animator;
import android.view.View;

import com.jeil.emarket.activities.auth.LoginActivity;

/* renamed from: b.f.a.a.b.f1 */

public class LoginAniListener1 implements Animator.AnimatorListener {


    public final  View f6394a;

    public LoginAniListener1(LoginActivity loginActivity, View view) {
        this.f6394a = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f6394a.findViewById(R.id.llc_first).setVisibility(View.GONE);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
