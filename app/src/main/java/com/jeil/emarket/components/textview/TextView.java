package com.jeil.emarket.components.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;
import com.jeil.emarket.custom.font.FontManager;
import com.jeil.emarket.custom.Util;

public class TextView extends AppCompatTextView {

    /* renamed from: g */
    public boolean f12322g;

    /* renamed from: h */
    public float textSize;

    public TextView(Context context) {
        super(context);
        this.f12322g = false;
        m6976d();
    }

    public TextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12322g = false;
        m6976d();
    }

    public TextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12322g = false;
        m6976d();
    }


    public ColorStateList m6975a(int i, int i2) {
        return new ColorStateList(new int[][]{android.widget.TextView.SELECTED_STATE_SET, android.widget.TextView.EMPTY_STATE_SET}, new int[]{i2, i});
    }


    public void m6976d() {
        this.textSize = Util.getFontSize();
        setTextSize(0, getTextSize());
        setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f12322g;
    }

    @Override // p000a.p005b.p013e.C0086a0, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        getLineSpacingExtra();
        getLineCount();
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f * this.textSize);
    }

    @Override // p000a.p005b.p013e.C0086a0, android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f * this.textSize);
    }
}
