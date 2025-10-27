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
import androidx.recyclerview.widget.RecyclerView;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.google.android.material.animation.AnimationUtils;


public class BottomViewBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    
    public int f11947a;


    public int f11948b;


    public boolean f11949c;


    public ViewPropertyAnimator f11950d;


    public int f11951e;

    /* renamed from: com.jeil.emarket.behaviors.BottomViewBehavior$a */
    public class C3229a extends AnimatorListenerAdapter {
        public C3229a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomViewBehavior.this.f11950d = null;
        }
    }

    public BottomViewBehavior() {
        this.f11947a = 1;
        this.f11948b = 0;
        this.f11949c = false;
        this.f11951e = Integer.MAX_VALUE;
    }

    public BottomViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11947a = 1;
        this.f11948b = 0;
        this.f11949c = false;
        this.f11951e = Integer.MAX_VALUE;
    }

    
    public void m6797a(View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
        }
        int i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i4 = this.f11948b;
        if (i4 <= ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
            i4 = 0;
        }
        layoutParams.setMargins(i, i2, i3, i4 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    
    public final void m6798a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f11950d = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new C3229a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000f, code lost:
    
        if ((r3 instanceof androidx.core.widget.NestedScrollView) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
    
        if ((r3 instanceof androidx.core.widget.NestedScrollView) == false) goto L17;
     */

    //@Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c
    
    public boolean mo2389a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f11948b = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) v.getLayoutParams())).topMargin;
        if (!this.f11949c) {
            this.f11949c = true;
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
            m6801d(v);
        } else if (this.f11951e < i2 - 200) {
            m6802e(v);
        }
        this.f11951e = rect.bottom;
        return false;
    }


    public void m6799b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, (this.f11948b > layoutParams.bottomMargin ? this.f11948b : 0) + layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r3 != null) goto L42;
     */
   // @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo2400b(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, android.view.View r6, int r7, int r8) {
        /*
            r2 = this;
            boolean r3 = p078b.p159f.p160a.p228d.C2157b.f8836d
            r4 = 1
            r5 = 0
            if (r3 != 0) goto La
            boolean r3 = r6 instanceof androidx.core.widget.NestedScrollView
            if (r3 == 0) goto L98
        La:
            boolean r3 = r6 instanceof androidx.core.widget.NestedScrollView
            r8 = 2131231840(0x7f080460, float:1.8079772E38)
            if (r3 == 0) goto L3c
            r3 = r6
            androidx.core.widget.NestedScrollView r3 = (androidx.core.widget.NestedScrollView) r3
            android.view.View r3 = r3.getChildAt(r5)
            if (r3 == 0) goto L25
            int r0 = r3.getPaddingBottom()
            if (r0 != 0) goto L25
            int r0 = r2.f11948b
            r3.setPadding(r5, r5, r5, r0)
        L25:
            android.view.ViewParent r3 = r6.getParent()
            boolean r3 = r3 instanceof android.widget.FrameLayout
            if (r3 == 0) goto L98
            android.view.ViewParent r3 = r6.getParent()
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            android.view.View r3 = r3.findViewById(r8)
            com.balysv.materialripple.MaterialRippleLayout r3 = (com.balysv.materialripple.MaterialRippleLayout) r3
            if (r3 == 0) goto L98
            goto L95
        L3c:
            boolean r3 = r6 instanceof com.jeil.emarket.components.xrecyclerview.XRecyclerView
            if (r3 == 0) goto L98
            r3 = r6
            com.jeil.emarket.components.xrecyclerview.XRecyclerView r3 = (com.jeil.emarket.components.xrecyclerview.XRecyclerView) r3
            com.jeil.emarket.components.xrecyclerview.XRecyclerView$e r0 = r3.f12364O0
            int r1 = r0.getItemCount()
            int r1 = r1 - r4
            int r0 = r0.getItemCount(r1)
            r1 = 9999(0x270f, float:1.4012E-41)
            if (r0 != r1) goto L5a
            android.view.View r1 = r3.f12362M0
            if (r1 == 0) goto L5a
            r2.m6800c(r1)
            goto L73
        L5a:
            r1 = 10001(0x2711, float:1.4014E-41)
            if (r0 != r1) goto L6a
            boolean r0 = r3.f12374Y0
            if (r0 == 0) goto L6a
            android.view.View r0 = r3.f12361L0
            if (r0 == 0) goto L6a
            r2.m6800c(r0)
            goto L73
        L6a:
            boolean r0 = r3.f12374Y0
            if (r0 != 0) goto L73
            android.view.View r3 = r3.f12361L0
            r2.m6800c(r3)
        L73:
            android.view.ViewParent r3 = r6.getParent()
            boolean r3 = r3 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r3 == 0) goto L98
            android.view.ViewParent r3 = r6.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r3 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r3
            android.view.View r3 = r3.findViewById(r8)
            com.balysv.materialripple.MaterialRippleLayout r3 = (com.balysv.materialripple.MaterialRippleLayout) r3
            if (r3 == 0) goto L98
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            boolean r6 = r6 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.C0575f
            if (r6 == 0) goto L95
            r2.m6797a(r3)
            goto L98
        L95:
            r2.m6799b(r3)
        L98:
            r3 = 2
            if (r7 != r3) goto L9c
            goto L9d
        L9c:
            r4 = 0
        L9d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.behaviors.BottomViewBehavior.mo2400b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int):boolean");
    }


    public void m6800c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RecyclerView.LayoutParams(-1, -2);
        }
        int i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int i4 = this.f11948b;
        if (i4 <= ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
            i4 = 0;
        }
        layoutParams.setMargins(i, i2, i3, i4 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        view.setLayoutParams(layoutParams);
    }


    @SuppressLint("RestrictedApi")
    public void m6801d(V v) {
        if (this.f11947a == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11950d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f11947a = 1;
        m6798a( v, this.f11948b, 175L, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    }


    @SuppressLint("RestrictedApi")
    public void m6802e(V v) {
        if (this.f11947a == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f11950d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f11947a = 2;
        m6798a(v, 0, 225L, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }
}
