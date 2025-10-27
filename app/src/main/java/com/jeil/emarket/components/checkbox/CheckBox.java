package com.jeil.emarket.components.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;

import com.jeil.emarket.widget.check.CheckBoxDrawable;
import com.jeil.emarket.custom.font.FontManager;
import com.jeil.emarket.custom.Util;


public class CheckBox extends CompoundButton {

    
    public Context f12219b;

    
    public CheckBoxDrawable checkBoxDrawable;

    
    public float f12221d;

    public CheckBox(Context context) {
        super(context);
        m6905a(context, null);
    }

    public CheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6905a(context, attributeSet);
    }

    public CheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6905a(context, attributeSet);
    }

    
    public void m6904a(int i, int i2, int i3, int i4) {
        if (this.checkBoxDrawable != null) {
            m6906a(this.f12219b, null, i, i2, i3, i4);
        }
    }

    
    public void m6905a(Context context, AttributeSet attributeSet) {
        this.f12219b = context;
        setClickable(true);
        this.checkBoxDrawable = new CheckBoxDrawable.SetStyle(context, attributeSet).m4574a();
        this.checkBoxDrawable.f8182y = isInEditMode();
        CheckBoxDrawable checkBoxDrawable = this.checkBoxDrawable;
        checkBoxDrawable.f8183z = true;
        setButtonDrawable(checkBoxDrawable);
        this.f12221d = Util.getFontSize();
        setTextSize(0, getTextSize());
        setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            setCheckedImmediately(!isChecked());
        }
        return onTouchEvent;
    }

    public void setCheckedImmediately(boolean z) {
        setChecked(!z);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f * this.f12221d);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f * this.f12221d);
    }

    
    public void m6906a(Context context, AttributeSet attributeSet, int i, int i2, int i3, int i4) {
        this.f12219b = context;
        setClickable(true);
        CheckBoxDrawable.SetStyle setStyleVar = new CheckBoxDrawable.SetStyle(context, attributeSet);
        setStyleVar.f8186c = i;
        setStyleVar.f8187d = i2;
        setStyleVar.f8190g = i3;
        setStyleVar.f8185b = i4;
        this.checkBoxDrawable = setStyleVar.m4574a();
        this.checkBoxDrawable.f8182y = isInEditMode();
        CheckBoxDrawable checkBoxDrawable = this.checkBoxDrawable;
        checkBoxDrawable.f8183z = true;
        setButtonDrawable(checkBoxDrawable);
        this.f12221d = Util.getFontSize();
        setTextSize(0, getTextSize());
        setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
    }
}
