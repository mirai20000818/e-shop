package com.jeil.emarket.components.button;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Util;


import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.font.FontManager;

public class ButtonToggle extends MaterialRippleLayout {

    /* renamed from: G */
    public boolean f12185G;

    /* renamed from: H */
    public int f12186H;

    
    public int f12187I;

   
    public Drawable f12188J;

    
    public TextView f12189K;

    public ButtonToggle(Context context) {
        super(context);
        this.f12185G = false;
        setStyle(context, (AttributeSet) null);
    }

    public ButtonToggle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12185G = false;
        setStyle(context, attributeSet);
    }

    public ButtonToggle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12185G = false;
        setStyle(context, attributeSet);
    }

    
    public void m6893a(int i, float f) {
        this.f12189K.setTextSize(i, f);
    }

    
    public void m6894a(int i, int i2, int i3, int i4) {
        TextView textView = this.f12189K;
        if (textView != null) {
            textView.setPadding(i, i2, i3, i4);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility", "UseCompatTextViewDrawableApis"})
    
    public void setStyle(Context context, AttributeSet attributeSet) {
        this.f12188J = getResources().getDrawable(R.drawable.bd_white_ellipse);
        this.f12186H = R.drawable.bg_attribute_selected;
        this.f12187I = getResources().getColor(R.color.white);
        this.f12189K = new TextView(context);
        setRippleRoundedCorners(50);
        setRippleColor(getResources().getColor(R.color.ripple_light));
        setRippleHover(true);
        setRippleOverlay(true);
        setDefaultRippleAlpha(10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonToggle);
        this.f12189K.setText(obtainStyledAttributes.getString(R.styleable.ButtonToggle_bt_text));
        this.f12189K.setTextSize(0, obtainStyledAttributes.getDimension(R.styleable.ButtonToggle_bt_text_size, getResources().getDimension(R.dimen.font_12)));
        this.f12189K.setTextColor(obtainStyledAttributes.getColor(R.styleable.ButtonToggle_bt_text_color, getResources().getColor(R.color.dark)));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ButtonToggle_bt_drawable_image);
        if (drawable != null) {
            this.f12189K.setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getBoolean(R.styleable.ButtonToggle_bt_drawable_start, false) ? obtainStyledAttributes.getDrawable(R.styleable.ButtonToggle_bt_drawable_image) :
                    null, (Drawable) null, !obtainStyledAttributes.getBoolean(R.styleable.ButtonToggle_bt_drawable_start, false) ? obtainStyledAttributes.getDrawable(R.styleable.ButtonToggle_bt_drawable_image) : null, (Drawable) null);
            this.f12189K.setCompoundDrawablePadding(Util.dp2px(context, 5));

        }
        @SuppressLint("ResourceAsColor") int color = obtainStyledAttributes.getColor(R.styleable.ButtonToggle_bt_drawable_color, R.color.dark);
        if (color != 0 && Build.VERSION.SDK_INT >= 23) {
            this.f12189K.setCompoundDrawableTintList(ColorStateList.valueOf(color));
        }
        this.f12189K.setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
        this.f12189K.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.f12189K.setPadding(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ButtonToggle_bt_padding_horizontal, Util.dp2px(context, 15)), obtainStyledAttributes.getDimensionPixelSize(R.styleable.ButtonToggle_bt_padding_vertical, Util.dp2px(context, 7)), obtainStyledAttributes.getDimensionPixelSize(R.styleable.ButtonToggle_bt_padding_horizontal, Util.dp2px(context, drawable != null ? 13 : 15)), obtainStyledAttributes.getDimensionPixelSize(R.styleable.ButtonToggle_bt_padding_vertical, Util.dp2px(context, 7)));
        if (obtainStyledAttributes.getDrawable(R.styleable.ButtonToggle_bt_unActive_bg) != null) {
            this.f12188J = obtainStyledAttributes.getDrawable(R.styleable.ButtonToggle_bt_unActive_bg);
        }
        if (obtainStyledAttributes.getDrawable(0) != null) {
            this.f12186H = obtainStyledAttributes.getResourceId(0, R.drawable.bg_attribute_selected);
            this.f12187I = obtainStyledAttributes.getColor(R.styleable.ButtonToggle_bt_text_active_color, getResources().getColor(BaseActivity.anInt2));
        }
        this.f12189K.setBackground(this.f12188J);
        addView(this.f12189K);
        obtainStyledAttributes.recycle();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    
    public void m6896d() {
        this.f12185G = true;
        this.f12189K.setBackgroundResource(this.f12186H);
        this.f12189K.setTextColor(this.f12187I);
        for (Drawable drawable : this.f12189K.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "RestrictedApi"})
    
    public void m6897e() {
        this.f12185G = false;
        this.f12189K.setBackground(this.f12188J);
        this.f12189K.setTextColor(getResources().getColor(R.color.dark));
        for (Drawable drawable : this.f12189K.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(getResources().getColor(R.color.dark), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    public String getText() {
        return this.f12189K.getText().toString();
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setText(CharSequence charSequence) {
        this.f12189K.setText(charSequence);
    }

    public void setTextColor(int i) {
        this.f12189K.setTextColor(i);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setUnActiveBg(int i) {
        this.f12188J = getResources().getDrawable(i);
    }
}
