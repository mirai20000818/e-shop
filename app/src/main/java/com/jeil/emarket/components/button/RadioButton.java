package com.jeil.emarket.components.button;

import android.content.Context;
import android.util.AttributeSet;

import com.jeil.emarket.custom.font.FontManager;
import com.jeil.emarket.custom.Util;
import com.google.android.material.radiobutton.MaterialRadioButton;


public class RadioButton extends MaterialRadioButton {

    
    public float fontsize;

    public RadioButton(Context context) {
        super(context);
        setFont();
    }

    public RadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFont();
    }

    public RadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFont();
    }


    public void setFont() {
        this.fontsize = Util.getFontSize();
        setTextSize(0, getTextSize());
        setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f * this.fontsize);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f * this.fontsize);
    }
}
