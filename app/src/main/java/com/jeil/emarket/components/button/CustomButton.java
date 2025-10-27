package com.jeil.emarket.components.button;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.jeil.emarket.custom.Util;
import com.google.android.material.button.MaterialButton;


import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.font.FontManager;


public class CustomButton extends MaterialButton implements View.OnTouchListener {

    /* renamed from: t */
    public boolean outline;

    /* renamed from: u */
    public int color;

    /* renamed from: v */
    public int corner_radius;

    /* renamed from: w */
    public int outline_width;

    /* renamed from: x */
    public Drawable f12182x;

    /* renamed from: y */
    public Drawable f12183y;

    /* renamed from: z */
    public float f12184z;

    public CustomButton(Context context) {
        super(context);
        m6891g();
        setOnTouchListener(this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public CustomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6891g();
        setStyle(context, attributeSet);
        setOnTouchListener(this);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public CustomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6891g();
        setStyle(context, attributeSet);
        setOnTouchListener(this);
    }


    public final LayerDrawable m6887a(int i, int i2, int i3, int i4) {
        float f = i;
        float[] fArr = {f, f, f, f, f, f, f, f};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i3);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setStrokeWidth(i4);
        shapeDrawable.getPaint().setAntiAlias(true);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable2.getPaint().setColor(i2);
        shapeDrawable2.getPaint().setAntiAlias(true);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable2, shapeDrawable});
        int i5 = i4 / 2;
        layerDrawable.setLayerInset(1, i5, getInsetTop() + i5, i5, getInsetBottom() + i5);
        layerDrawable.setLayerInset(0, 0, getInsetTop(), 0, getInsetBottom());
        return layerDrawable;
    }


    public final void setStyle(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Button);
        if (obtainStyledAttributes == null) {
            return;
        }
        for (int i = 0; i < obtainStyledAttributes.getIndexCount(); i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.color = obtainStyledAttributes.getColor(index, getResources().getColor(BaseActivity.color));
            } else if (index == 1) {
                this.corner_radius = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 3) {
                this.outline_width = obtainStyledAttributes.getDimensionPixelSize(index, 4);
            } else if (index == 2) {
                this.outline = obtainStyledAttributes.getBoolean(index, false);
            }
        }
        obtainStyledAttributes.recycle();
    }


    public final void m6889a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setBackground(drawable);
    }


    public final LayerDrawable m6890b(int i, int i2) {
        return m6887a(i, i2, 0, 0);
    }

    /* renamed from: g */
    public final void m6891g() {
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        this.color = resources.getColor(BaseActivity.color);
        this.corner_radius = 0;
        this.f12184z = Util.getFontSize();
        setTextSize(0, getTextSize());
        setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: h */
    public void m6892h() {
        int alpha = Color.alpha(this.color);
        float[] fArr = new float[3];
        Color.colorToHSV(this.color, fArr);
        if (isEnabled()) {
            Color.colorToHSV(this.color, fArr);
            int HSVToColor = Color.HSVToColor((alpha * 6) / 10, fArr);
            if (Color.alpha(this.color) == 0) {
                HSVToColor = getResources().getColor(R.color.ripple_light);
            }
            if (this.outline) {
                this.f12183y = m6887a(this.corner_radius, getResources().getColor(R.color.transparent), this.color, this.outline_width);
                this.f12182x = m6887a(this.corner_radius, getResources().getColor(R.color.ripple_light), this.color, this.outline_width);
            } else {
                this.f12183y = m6890b(this.corner_radius, this.color);
                this.f12182x = m6890b(this.corner_radius, HSVToColor);
                HSVToColor = this.color;
            }
            setSupportBackgroundTintList(ColorStateList.valueOf(HSVToColor));
        } else {
            Color.colorToHSV(this.color, fArr);
            int HSVToColor2 = Color.HSVToColor((alpha * 3) / 10, fArr);
            if (Color.alpha(this.color) == 0) {
                HSVToColor2 = getResources().getColor(R.color.ripple_light);
            }
            this.f12182x = m6890b(this.corner_radius, HSVToColor2);
            this.f12183y = m6890b(this.corner_radius, HSVToColor2);
        }
        m6889a(this.f12183y);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        m6892h();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Drawable drawable;
        int action = motionEvent.getAction();
        if (action == 0) {
            drawable = this.f12182x;
        } else {
            if (action != 1 && action != 3 && action != 4) {
                return false;
            }
            drawable = this.f12183y;
        }
        m6889a(drawable);
        return false;
    }

    public void setButtonColor(int i) {
        this.color = i;
        m6892h();
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setCornerRadius(int i) {
        this.corner_radius = i;
        m6892h();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        m6892h();
    }

    public void setCorner_radius(boolean z) {
        this.outline = z;
        m6892h();
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f * this.f12184z);
    }

    @Override // p000a.p005b.p013e.C0100f, android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f * this.f12184z);
    }

    public void setmOutlineWidth(int i) {
        this.outline_width = i;
        m6892h();
    }
}
