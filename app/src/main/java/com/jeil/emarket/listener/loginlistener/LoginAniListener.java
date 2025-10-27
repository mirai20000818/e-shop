package com.jeil.emarket.listener.loginlistener;

import android.animation.Animator;
import android.view.View;

import com.jeil.emarket.activities.auth.LoginActivity;

/* renamed from: b.f.a.a.b.e1 */

public class LoginAniListener implements Animator.AnimatorListener {

    
    public final  View m_view;

    public LoginAniListener(LoginActivity loginActivity, View view) {
        this.m_view = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.m_view.findViewById(R.id.llc_first).setVisibility(View.VISIBLE);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
