package com.jeil.emarket.behaviors;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.animation.AnimationUtils;
import com.jeil.emarket.activities.baseactivity.BaseActivity;


public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {


    public int f11953a;


    public int f11954b;

    
    public boolean f11955c;

    
    public ViewPropertyAnimator f11956d;

    
    public int f11957e;

    /* renamed from: com.jeil.emarket.behaviors.HideBottomViewOnScrollBehavior$a */
    public class C3230a extends AnimatorListenerAdapter {
        public C3230a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f11956d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f11953a = 1;
        this.f11954b = 0;
        this.f11955c = false;
        this.f11957e = Integer.MAX_VALUE;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11953a = 1;
        this.f11954b = 0;
        this.f11955c = false;
        this.f11957e = Integer.MAX_VALUE;
        this.f11954b = context.getResources().getDimensionPixelSize(R.dimen.bottom_height);
    }


    public void m6803a(View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
        }
        int i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i4 = this.f11954b;
        if (i4 <= ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
            i4 = 0;
        }
        layoutParams.setMargins(i, i2, i3, i4 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        view.setLayoutParams(layoutParams);
    }


    public final void m6804a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f11956d = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new C3230a());
    }

    //@Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c

    public void mo2385a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0 || i4 > 0) {
            v.setVisibility(View.VISIBLE);
            m6807d(v);
        } else if (i2 < 0 || i4 < 0) {
            m6806c(v);
        }
    }

    //@Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c

    public boolean mo2389a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f11954b = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) v.getLayoutParams())).topMargin;
        if (!this.f11955c) {
            this.f11955c = true;
            v.animate().translationY(this.f11954b).setDuration(0L);
            return false;
        }
        Context context = coordinatorLayout.getContext();
        if (!(context instanceof Activity)) {
            return false;
        }
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = BaseActivity.anInt1;
        if (i2 - 200 > rect.bottom) {
            m6806c(v);
        } else if (this.f11957e < i2 - 200) {
            m6807d(v);
        }
        this.f11957e = rect.bottom;
        return false;
    }


    public void m6805b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, (this.f11954b > layoutParams.bottomMargin ? this.f11954b : 0) + layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        if (r6 != null) goto L32;
     */
    //@Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo2400b(androidx.coordinatorlayout.widget.CoordinatorLayout r6, V r7, android.view.View r8, android.view.View r9, int r10, int r11) {
        /*
            r5 = this;
            boolean r6 = r7 instanceof com.balysv.materialripple.MaterialRippleLayout
            r7 = 0
            r8 = 2
            if (r6 != 0) goto L96
            boolean r6 = r9 instanceof androidx.core.widget.NestedScrollView
            r11 = 2131231840(0x7f080460, float:1.8079772E38)
            if (r6 == 0) goto L4c
            r6 = r9
            androidx.core.widget.NestedScrollView r6 = (androidx.core.widget.NestedScrollView) r6
            android.view.View r6 = r6.getChildAt(r7)
            if (r6 == 0) goto L35
            int r0 = r6.getPaddingBottom()
            int r1 = r5.f11954b
            int r1 = r1 / r8
            if (r0 >= r1) goto L35
            int r0 = r6.getPaddingLeft()
            int r1 = r6.getPaddingTop()
            int r2 = r6.getPaddingRight()
            int r3 = r5.f11954b
            int r4 = r6.getPaddingBottom()
            int r4 = r4 + r3
            r6.setPadding(r0, r1, r2, r4)
        L35:
            android.view.ViewParent r6 = r9.getParent()
            boolean r6 = r6 instanceof android.widget.FrameLayout
            if (r6 == 0) goto L96
            android.view.ViewParent r6 = r9.getParent()
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            android.view.View r6 = r6.findViewById(r11)
            com.balysv.materialripple.MaterialRippleLayout r6 = (com.balysv.materialripple.MaterialRippleLayout) r6
            if (r6 == 0) goto L96
            goto L93
        L4c:
            boolean r6 = r9 instanceof com.jeil.emarket.components.xrecyclerview.XRecyclerView
            if (r6 == 0) goto L96
            r6 = r9
            com.jeil.emarket.components.xrecyclerview.XRecyclerView r6 = (com.jeil.emarket.components.xrecyclerview.XRecyclerView) r6
            int r0 = r5.f11954b
            r6.setFooterHeight(r0)
            android.view.View r0 = r6.f12361L0
            if (r0 == 0) goto L71
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto L71
            boolean r0 = r6.f12377b1
            if (r0 != 0) goto L71
            android.view.View r6 = r6.f12361L0
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            int r9 = r5.f11954b
            r6.height = r9
            goto L96
        L71:
            android.view.ViewParent r6 = r9.getParent()
            boolean r6 = r6 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r6 == 0) goto L96
            android.view.ViewParent r6 = r9.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r6
            android.view.View r6 = r6.findViewById(r11)
            com.balysv.materialripple.MaterialRippleLayout r6 = (com.balysv.materialripple.MaterialRippleLayout) r6
            if (r6 == 0) goto L96
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            boolean r9 = r9 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.C0575f
            if (r9 == 0) goto L93
            r5.m6803a(r6)
            goto L96
        L93:
            r5.m6805b(r6)
        L96:
            if (r10 != r8) goto L99
            r7 = 1
        L99:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.behaviors.HideBottomViewOnScrollBehavior.mo2400b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int):boolean");
    }

    
    @SuppressLint("RestrictedApi")
    public void m6806c(V v) {
        if (this.f11953a == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11956d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f11953a = 1;
        m6804a( v, this.f11954b, 175L, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    }

    
    @SuppressLint("RestrictedApi")
    public void m6807d(V v) {
        if (this.f11953a == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11956d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f11953a = 2;
        m6804a(v, 0, 225L, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }
}
