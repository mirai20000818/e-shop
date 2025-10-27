package com.jeil.emarket.components.textview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;
import com.jeil.emarket.custom.font.FontManager;


public class TextViewBold extends AppCompatTextView {

    /* renamed from: g */
    public boolean f12324g;

    /* renamed from: h */
    public float f12325h;

    public TextViewBold(Context context) {
        super(context);
        this.f12324g = false;
        this.f12325h = 1.5f;
        m6977d();
    }

    public TextViewBold(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12324g = false;
        this.f12325h = 1.5f;
        m6977d();
    }

    public TextViewBold(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12324g = false;
        this.f12325h = 1.5f;
        m6977d();
    }

    
    public void m6977d() {
        this.f12325h = Util.m288b();
        setTextSize(0, getTextSize());
        setTypeface(FontManager.getFont(getContext(), "font/Taekwon.ttf"));
        setLetterSpacing(-0.06f);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f12324g;
    }

    @Override // p000a.p005b.p013e.C0086a0, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f * this.f12325h);
    }

    @Override // p000a.p005b.p013e.C0086a0, android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f * this.f12325h);
    }
}
