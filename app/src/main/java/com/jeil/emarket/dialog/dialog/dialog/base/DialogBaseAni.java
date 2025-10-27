package com.jeil.emarket.dialog.dialog.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import java.util.Objects;

/* renamed from: b.f.a.c.c0.c.l.g */

public abstract class DialogBaseAni<T extends DialogBaseAni<T>> extends Dialog {


    public Context f8251b;


    public DisplayMetrics f8252c;


    public boolean f8253d;


    public float f8254e;

    /* renamed from: f */
    public float f8255f;

    /* renamed from: g */
    public float f8256g;

    /* renamed from: h */
    public boolean f8257h;


    public boolean f8258i;

   
    public LinearLayoutCompat f8259j;


    public FrameLayout f8260k;

    /* renamed from: l */
    public LinearLayoutCompat f8261l;

    /* renamed from: m */
    public View f8262m;

    /* renamed from: n */
    public View f8263n;

    /* renamed from: b.f.a.c.c0.c.l.g$a */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            DialogBaseAni.this.m4595e();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public DialogBaseAni(Context context) {
        super(context);
        this.f8254e = 1.0f;
        this.f8257h = false;
        this.f8263n = null;
        requestWindowFeature(1);
        ((Window) Objects.requireNonNull(getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        getWindow().addFlags(2);
        this.f8251b = context;
        this.f8253d = true;
        super.setCanceledOnTouchOutside(true);
    }


    public static  void m4589b(View view) {
    }


    public int m4590a(float f) {
        return (int) ((f * this.f8251b.getResources().getDisplayMetrics().density) + 0.5f);
    }


    public void startAni() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(350L);
        alphaAnimation.setAnimationListener(new a());
        if (this.f8257h) {
            this.f8260k.startAnimation(alphaAnimation);
        } else {
            this.f8259j.startAnimation(alphaAnimation);
        }
    }


    public  void m4592a(View view) {
        if (this.f8253d) {
            dismiss();
        }
    }


    public void m4593a(boolean z) {
        if (z) {
            ((Window) Objects.requireNonNull(getWindow())).addFlags(2);
        } else {
            ((Window) Objects.requireNonNull(getWindow())).clearFlags(2);
        }
    }


    public abstract View mo4576b();


    public abstract void mo4577c();


    public void mo4594d() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(350L);
        if (this.f8257h) {
            this.f8260k.startAnimation(alphaAnimation);
        } else {
            this.f8259j.startAnimation(alphaAnimation);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f8251b != null) {
            startAni();
        } else {
            super.dismiss();
        }
    }


    public void m4595e() {
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mo4577c();
        float f = this.f8254e;
        int i = f == 0.0f ? -2 : (int) (this.f8252c.widthPixels * f);
        float f2 = this.f8255f;
        this.f8261l.setLayoutParams(new LinearLayoutCompat.LayoutParams(i, f2 != 0.0f ? f2 == 1.0f ? -1 : (int) (this.f8256g * f2) : -2));
        mo4594d();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        this.f8253d = z;
        super.setCanceledOnTouchOutside(z);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f8251b != null) {
            super.show();
        }
    }
}
