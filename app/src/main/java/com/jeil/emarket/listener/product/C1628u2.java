package com.jeil.emarket.listener.product;

import android.animation.Animator;
import android.view.View;

import com.jeil.emarket.activities.seller.VendorOrderDetailActivity;

/* renamed from: b.f.a.a.i.u2 */

public class C1628u2 implements Animator.AnimatorListener {


    public final  View f6854a;

    public C1628u2(VendorOrderDetailActivity vendorOrderDetailActivity, View view) {
        this.f6854a = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f6854a.findViewById(R.id.ll_first_step).setVisibility(View.GONE);
        this.f6854a.findViewById(R.id.ll_second_step).setVisibility(View.VISIBLE);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
