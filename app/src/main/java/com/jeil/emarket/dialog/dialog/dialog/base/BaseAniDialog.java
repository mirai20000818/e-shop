package com.jeil.emarket.dialog.dialog.dialog.base;

import android.content.Context;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import java.util.Objects;

/* renamed from: b.f.a.c.c0.c.l.h */

public abstract class BaseAniDialog<T extends BaseAniDialog<T>> extends DialogBaseAni<T> {

    /* renamed from: o */
    public Animation f8265o;

    /* renamed from: p */
    public Animation f8266p;

    /* renamed from: q */
    public long f8267q;

    /* renamed from: r */
    public boolean f8268r;

    /* renamed from: s */
    public boolean f8269s;

    /* renamed from: t */
    public int f8270t;

    /* renamed from: u */
    public int f8271u;

    /* renamed from: v */
    public int f8272v;

    /* renamed from: w */
    public int f8273w;

    /* renamed from: x */
    public int f8274x;

    /* renamed from: b.f.a.c.c0.c.l.h$a */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BaseAniDialog.this.f8268r = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            BaseAniDialog.this.f8268r = true;
        }
    }

    /* renamed from: b.f.a.c.c0.c.l.h$b */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BaseAniDialog baseAniDialog = BaseAniDialog.this;
            baseAniDialog.f8269s = false;
            baseAniDialog.m4595e();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            BaseAniDialog.this.f8269s = true;
        }
    }

    public BaseAniDialog(Context context, int i) {
        super(context);
        TranslateAnimation translateAnimation;
        this.f8267q = 200L;
        this.f8274x = i;
        if (i == 80) {
            this.f8265o = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        } else {
            if (i != 8388613) {
                return;
            }
            this.f8265o = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        }
        this.f8266p = translateAnimation;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public void startAni() {
        Animation animation = this.f8266p;
        if (animation == null) {
            m4595e();
            return;
        }
        animation.setDuration(this.f8267q);
        this.f8266p.setAnimationListener(new b());
        this.f8261l.startAnimation(this.f8266p);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4594d() {
        Animation animation = this.f8265o;
        if (animation != null) {
            animation.setDuration(this.f8267q);
            this.f8265o.setAnimationListener(new a());
            this.f8261l.startAnimation(this.f8265o);
        }
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        startAni();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f8269s || this.f8268r) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mo4594d();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.f8269s || this.f8268r) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.f8259j.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f8259j.setGravity(this.f8274x);
        ((Window) Objects.requireNonNull(getWindow())).setGravity(this.f8274x);
        this.f8259j.setPadding(this.f8270t, this.f8271u, this.f8272v, this.f8273w);
    }
}
