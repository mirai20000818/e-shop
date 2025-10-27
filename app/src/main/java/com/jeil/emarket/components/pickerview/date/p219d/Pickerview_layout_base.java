package com.jeil.emarket.components.pickerview.date.p219d;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.custom.Util;

/* renamed from: b.f.a.c.w.k.d.g */

public class Pickerview_layout_base {

    
    public ViewGroup f8693b;

    
    public C2108a f8694c;

    
    public int f8695d = 80;

    
    public View f8696e;

    /* renamed from: f */
    public Context f8697f;

    /* renamed from: g */
    public ViewGroup f8698g;

    /* renamed from: h */
    public Animation f8699h;

    
    public Animation f8700i;

   
    public Dialog f8701j;

    public Pickerview_layout_base(Context context) {
        this.f8697f = context;
    }


    public View m4720a(int i) {
        return this.f8693b.findViewById(i);
    }


    public void m4721a() {
        Dialog dialog = this.f8701j;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f8693b.startAnimation(this.f8699h);
    }

    
    public void m4722b() {
        this.f8700i = AnimationUtils.loadAnimation(this.f8697f, Util.m168a(this.f8695d, true));
        this.f8699h = AnimationUtils.loadAnimation(this.f8697f, Util.m168a(this.f8695d, false));
    }

    @SuppressLint({"InflateParams"})
    
    public void m4723c() {
        this.f8697f.getResources().getDisplayMetrics();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.f8698g = (ViewGroup) LayoutInflater.from(this.f8697f).inflate(R.layout.pickerview_layout_base, (ViewGroup) null, false);
        this.f8698g.removeViewAt(0);
        this.f8698g.setBackgroundColor(0);
        this.f8693b = (ViewGroup) this.f8698g.findViewById(R.id.content_container);
        this.f8693b.setLayoutParams(layoutParams);
        this.f8693b.setPadding(Util.dp2px(this.f8697f, 10), Util.dp2px(this.f8697f, 15), Util.dp2px(this.f8697f, 10), Util.dp2px(this.f8697f, 10));
        if (this.f8698g != null) {
            this.f8701j = new Dialog(this.f8697f, R.style.picker_view_dialog);
            this.f8701j.setContentView(this.f8698g);
            this.f8701j.setCancelable(this.f8694c.f8646W);
            if (this.f8701j.getWindow() != null) {
                this.f8701j.getWindow().getDecorView().bringToFront();
            }
            Window window = this.f8701j.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_slide_anim);
                window.setGravity(80);
            }
        }
    }

    
    public void m4724d() {
        Dialog dialog = this.f8701j;
        if (dialog != null && dialog.getWindow() != null) {
            this.f8701j.getWindow().getDecorView().bringToFront();
            this.f8701j.show();
        }
        this.f8693b.startAnimation(this.f8700i);
    }
}
