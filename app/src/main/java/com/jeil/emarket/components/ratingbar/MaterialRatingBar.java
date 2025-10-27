package com.jeil.emarket.components.ratingbar;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatRatingBar;

import com.jeil.emarket.widget.drawable.LayerDrawableEx;


public class MaterialRatingBar extends AppCompatRatingBar {


    public final C3253a f12285c;


    public LayerDrawableEx f12286d;

    /* renamed from: com.jeil.emarket.components.ratingbar.MaterialRatingBar$a */
    public static class C3253a {

        
        public ColorStateList mrb_progressTint;


        public PorterDuff.Mode f12288b;


        public boolean f12289c;


        public boolean f12290d;


        public ColorStateList f12291e;

        /* renamed from: f */
        public PorterDuff.Mode f12292f;

        /* renamed from: g */
        public boolean f12293g;

        /* renamed from: h */
        public boolean f12294h;


        public ColorStateList f12295i;

       
        public PorterDuff.Mode f12296j;

        
        public boolean f12297k;

        /* renamed from: l */
        public boolean f12298l;
    }

    public MaterialRatingBar(Context context) {
        super(context);
        this.f12285c = new C3253a();
        m6962a((AttributeSet) null, 0);
    }

    public MaterialRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12285c = new C3253a();
        m6962a(attributeSet, 0);
    }

    public MaterialRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12285c = new C3253a();
        m6962a(attributeSet, i);
    }

    
    public static PorterDuff.Mode m6960a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @SuppressLint({"NewApi"})
    
    public final void m6961a() {
        if (getContext().getApplicationInfo().minSdkVersion >= 21) {
            return;
        }
        Log.w("MaterialRatingBar", "Non-support version of tint method called, this is error-prone and will crash below Lollipop if you are calling it as a method of RatingBar instead of MaterialRatingBar");
    }

    
    public final void m6962a(AttributeSet attributeSet, int i) {
//        MaterialRatingBar materialRatingBar = MaterialRatingBar.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MaterialRatingBar, i, 0);
//        if (materialRatingBar.m722f(5)) {
//            this.f12285c.f12287a = materialRatingBar.m710a(5);
//            this.f12285c.f12289c = true;
//        }
//        if (materialRatingBar.m722f(6)) {
//            this.f12285c.f12288b = m6960a(materialRatingBar.m717d(6, -1), (PorterDuff.Mode) null);
//            this.f12285c.f12290d = true;
//        }
//        if (materialRatingBar.m722f(7)) {
//            this.f12285c.f12291e = materialRatingBar.m710a(7);
//            this.f12285c.f12293g = true;
//        }
//        if (materialRatingBar.m722f(8)) {
//            this.f12285c.f12292f = m6960a(materialRatingBar.m717d(8, -1), (PorterDuff.Mode) null);
//            this.f12285c.f12294h = true;
//        }
//        if (materialRatingBar.m722f(3)) {
//            this.f12285c.f12295i = materialRatingBar.m710a(3);
//            this.f12285c.f12297k = true;
//        }
//        if (materialRatingBar.m722f(4)) {
//            this.f12285c.f12296j = m6960a(materialRatingBar.m717d(4, -1), (PorterDuff.Mode) null);
//            this.f12285c.f12298l = true;
//        }
//        boolean m712a = materialRatingBar.m712a(0, isIndicator());
//        materialRatingBar.f956b.recycle();
//        this.f12286d = new C2062b(getContext(), m712a, this.f12285c);
//        this.f12286d.m4656b(getNumStars());
//        setProgressDrawable(this.f12286d);
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getProgressBackgroundTintList() {
        m6961a();
        return this.f12285c.f12295i;
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getProgressBackgroundTintMode() {
        m6961a();
        return this.f12285c.f12296j;
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getProgressTintList() {
        m6961a();
        return this.f12285c.mrb_progressTint;
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getProgressTintMode() {
        m6961a();
        return this.f12285c.f12288b;
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getSecondaryProgressTintList() {
        m6961a();
        return this.f12285c.f12291e;
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getSecondaryProgressTintMode() {
        m6961a();
        return this.f12285c.f12292f;
    }

    @Override // p000a.p005b.p013e.C0125r, android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        Drawable drawable = this.f12286d.m4655a(R.id.progress).f8446g;
        setMeasuredDimension(View.resolveSizeAndState(Math.round(measuredHeight * (drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) * getNumStars()), i, 0), measuredHeight);
    }

    @Override // android.widget.RatingBar
    public void setNumStars(int i) {
        super.setNumStars(i);
        LayerDrawableEx layerDrawableEx = this.f12286d;
        if (layerDrawableEx != null) {
            layerDrawableEx.m4656b(i);
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressBackgroundTintList(ColorStateList colorStateList) {
        m6961a();
        C3253a c3253a = this.f12285c;
        c3253a.f12295i = colorStateList;
        c3253a.f12297k = true;
    }

    @Override // android.widget.ProgressBar
    public void setProgressBackgroundTintMode(PorterDuff.Mode mode) {
        m6961a();
        C3253a c3253a = this.f12285c;
        c3253a.f12296j = mode;
        c3253a.f12298l = true;
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        super.setProgressDrawable(drawable);
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintList(ColorStateList colorStateList) {
        m6961a();
        C3253a c3253a = this.f12285c;
        c3253a.mrb_progressTint = colorStateList;
        c3253a.f12289c = true;
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintMode(PorterDuff.Mode mode) {
        m6961a();
        C3253a c3253a = this.f12285c;
        c3253a.f12288b = mode;
        c3253a.f12290d = true;
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgressTintList(ColorStateList colorStateList) {
        m6961a();
        C3253a c3253a = this.f12285c;
        c3253a.f12291e = colorStateList;
        c3253a.f12293g = true;
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgressTintMode(PorterDuff.Mode mode) {
        m6961a();
        C3253a c3253a = this.f12285c;
        c3253a.f12292f = mode;
        c3253a.f12294h = true;
    }
}
