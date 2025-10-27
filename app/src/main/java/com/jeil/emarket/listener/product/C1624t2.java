package com.jeil.emarket.listener.product;

import android.animation.Animator;
import android.view.View;

import com.jeil.emarket.activities.seller.VendorOrderDetailActivity;

/* renamed from: b.f.a.a.i.t2 */

public class C1624t2 implements Animator.AnimatorListener {

    
    public final  View f6848a;

    public C1624t2(VendorOrderDetailActivity vendorOrderDetailActivity, View view) {
        this.f6848a = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f6848a.findViewById(R.id.ll_first_step).setVisibility(View.VISIBLE);
        this.f6848a.findViewById(R.id.ll_second_step).setVisibility(View.GONE);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
