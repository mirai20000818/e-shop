package com.jeil.emarket.components.progress.main;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.jeil.emarket.widget.ViewGroupEx;
import com.jeil.emarket.widget.loading.LoadingIndicatorView;

/* renamed from: b.f.a.c.m0.b.e */

public class LinearLayoutEx extends LinearLayout {


    public int f8527b;


    public LinearLayoutCompat f8528c;

    
    public ViewGroupEx f8529d;

    
    public int f8530e;

    /* renamed from: f */
    public Animation f8531f;

    /* renamed from: g */
    public Animation f8532g;

    /* renamed from: h */
    public LoadingIndicatorView f8533h;

    
    public int f8534i;

   
    public int f8535j;

    
    public int f8536k;

    /* renamed from: l */
    public int f8537l;

    public LinearLayoutEx(Context context) {
        super(context);
        this.f8530e = 0;
        this.f8534i = -4868683;
        this.f8535j = 200;
        this.f8536k = 500;
        this.f8537l = 300;
        this.f8528c = new LinearLayoutCompat(getContext());
        addView(this.f8528c, new LinearLayout.LayoutParams(-1, 0));
        this.f8529d = new ViewGroupEx(getContext());
        this.f8528c.addView(this.f8529d);
        this.f8528c.setGravity(17);
        measure(-1, -2);
        this.f8527b = getMeasuredHeight();
    }


    public void m4682a() {
        this.f8529d = null;
        LoadingIndicatorView loadingIndicatorView = this.f8533h;
        if (loadingIndicatorView != null) {
            loadingIndicatorView.m4609c();
            this.f8533h = null;
        }
        Animation animation = this.f8531f;
        if (animation != null) {
            animation.cancel();
            this.f8531f = null;
        }
        Animation animation2 = this.f8532g;
        if (animation2 != null) {
            animation2.cancel();
            this.f8532g = null;
        }
    }


    public void m4683a(float f) {
        if (getVisibleHeight() > 0 || f > 0.0f) {
            setVisibleHeight(getVisibleHeight() + ((int) f));
            if (this.f8530e <= 1) {
                if (getVisibleHeight() > this.f8527b) {
                    setState(1);
                } else {
                    setState(0);
                }
            }
        }
    }


    public final void m4684a(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(getVisibleHeight(), i);
        ofInt.setDuration(this.f8537l).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.f.a.c.m0.b.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayoutEx.this.m4685a(valueAnimator);
            }
        });
        ofInt.start();
    }


    public  void m4685a(ValueAnimator valueAnimator) {
        setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }


    public  void m4686b() {
        setState(0);
    }


    public void m4687c() {
        setState(3);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.c.m0.b.c
            @Override // java.lang.Runnable
            public final void run() {
                LinearLayoutEx.this.m4689e();
            }
        }, this.f8535j);
    }

    
    public boolean m4688d() {
        boolean z;
        if (getVisibleHeight() <= this.f8527b || this.f8530e >= 2) {
            z = false;
        } else {
            setState(2);
            z = true;
        }
        if (this.f8530e == 2) {
            m4684a(this.f8527b);
        } else {
            m4684a(0);
        }
        return z;
    }

    
    public void m4689e() {
        m4684a(0);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.c.m0.b.a
            @Override // java.lang.Runnable
            public final void run() {
                LinearLayoutEx.this.m4686b();
            }
        }, this.f8536k);
    }

    public int getState() {
        return this.f8530e;
    }

    public int getVisibleHeight() {
        return ((LinearLayout.LayoutParams) this.f8528c.getLayoutParams()).height;
    }

    public void setProgressStyle(int i) {
        ViewGroupEx viewGroupEx;
        View view;
        if (i == -1) {
            viewGroupEx = this.f8529d;
            if (viewGroupEx == null) {
                return;
            } else {
                view = new ProgressBar(getContext(), null, R.attr.progressBarStyle);
            }
        } else {
            this.f8533h = new LoadingIndicatorView(getContext());
            this.f8533h.setIndicatorColor(this.f8534i);
            viewGroupEx = this.f8529d;
            view = this.f8533h;
        }
        viewGroupEx.setView(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:
    
        if (r0 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setState(int r3) {
        /*
            r2 = this;
            int r0 = r2.f8530e
            if (r3 != r0) goto L5
            return
        L5:
            r0 = 2
            r1 = 0
            if (r3 != r0) goto L16
            b.f.a.c.v r0 = r2.f8529d
            if (r0 == 0) goto L10
            r0.setVisibility(r1)
        L10:
            int r0 = r2.f8527b
            r2.m4684a(r0)
            goto L26
        L16:
            r0 = 3
            if (r3 != r0) goto L1f
            b.f.a.c.v r0 = r2.f8529d
            if (r0 == 0) goto L1f
            r1 = 4
            goto L23
        L1f:
            b.f.a.c.v r0 = r2.f8529d
            if (r0 == 0) goto L26
        L23:
            r0.setVisibility(r1)
        L26:
            r2.f8530e = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p190c.p211m0.p213b.C2085e.setState(int):void");
    }

    public void setVisibleHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8528c.getLayoutParams();
        layoutParams.height = i;
        this.f8528c.setLayoutParams(layoutParams);
    }
}
