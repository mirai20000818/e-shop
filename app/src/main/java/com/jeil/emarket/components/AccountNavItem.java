package com.jeil.emarket.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.components.textview.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.jeil.emarket.activities.baseactivity.BaseActivity;


public class AccountNavItem extends FrameLayout {


    public AppCompatTextView f11959b;


    public View f11960c;


    public ImageView f11961d;

    
    public ImageView f11962e;

    /* renamed from: f */
    public MaterialRippleLayout f11963f;

    @SuppressLint({"ResourceAsColor"})
    public AccountNavItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPadding(0, 0, 0, 0);
        this.f11963f = new MaterialRippleLayout(context);
        this.f11963f.setRippleColor(context.getResources().getColor(R.color.ripple_dark));
        this.f11963f.setRippleHover(true);
        this.f11963f.setDefaultRippleAlpha(10);
        this.f11963f.setRippleRoundedCorners((int) context.getResources().getDimension(R.dimen._30sdp));
        this.f11963f.setPadding(Util.dp2px(context, 16), BaseActivity.anInt2 / 2, Util.dp2px(context, 13), BaseActivity.anInt2 / 2);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.HORIZONTAL);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -1));
        linearLayoutCompat.setPadding(0, 0, 0, BaseActivity.anInt2 / 8);
        this.f11961d = new ImageView(context);
        this.f11961d.setBackgroundResource(R.drawable.bg_grey_circle_box);
        this.f11961d.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.light_bg)));
        this.f11961d.setImageResource(R.drawable.ic_recycle);
        this.f11961d.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.dark)));
        ImageView imageView = this.f11961d;
        int i = BaseActivity.anInt2;
        imageView.setPadding(i, i, i, i);
        this.f11961d.setLayoutParams(new LinearLayoutCompat.LayoutParams(Util.dp2px(context, 32), Util.dp2px(context, 32)));
        this.f11959b = new TextView(context);
        this.f11959b.setPadding(BaseActivity.anInt2, 0, 0, 0);
        this.f11959b.setLayoutParams(new LinearLayoutCompat.LayoutParams(0, -2, 1.0f));
        this.f11959b.setTextSize(1, 12.5f);
        this.f11959b.setTextColor(context.getResources().getColor(R.color.dark));
        this.f11962e = new ImageView(context);
        this.f11962e.setLayoutParams(new LinearLayoutCompat.LayoutParams(Util.dp2px(context, 14), Util.dp2px(context, 14)));
        this.f11962e.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark)));
        setStyle(context, attributeSet);
        linearLayoutCompat.addView(this.f11961d);
        linearLayoutCompat.addView(this.f11959b);
        linearLayoutCompat.addView(this.f11962e);
        this.f11963f.addView(linearLayoutCompat);
        addView(this.f11963f, new FrameLayout.LayoutParams(-1, -2));
        this.f11960c = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Util.dp2px(context, 9), Util.dp2px(context, 9));
        layoutParams.leftMargin = Util.dp2px(context, 39);
        layoutParams.topMargin = Util.dp2px(context, 5);
        layoutParams.gravity = 8388611;
        this.f11960c.setLayoutParams(layoutParams);
        this.f11960c.setBackgroundResource(R.drawable.bg_cart_badge);
        this.f11960c.setVisibility(View.GONE);
        addView(this.f11960c);
    }

    @SuppressLint({"ResourceType"})

    public void setStyle(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AccountNavItem);
            this.f11961d.setImageResource(obtainStyledAttributes.getResourceId(1, 0));
            this.f11961d.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.body)));
            this.f11961d.setRotation(obtainStyledAttributes.getFloat(2, 0.0f));
            this.f11959b.setText(obtainStyledAttributes.getText(5));
            if (obtainStyledAttributes.getBoolean(3, true)) {
                int m169a = Util.dp2px(context, 9.0f);
                this.f11961d.setPadding(m169a, m169a, m169a, m169a);
                this.f11961d.setLayoutParams(new LinearLayoutCompat.LayoutParams(Util.dp2px(context, 33), Util.dp2px(context, 33)));
                this.f11959b.setTextSize(1, 12.5f);
            }
            if (!Boolean.parseBoolean(obtainStyledAttributes.getString(0))) {
                this.f11962e.setImageResource(R.drawable.ic_angle_right);
            }
            if (obtainStyledAttributes.getBoolean(4, false)) {
                this.f11963f.setPadding(Util.dp2px(context, 16), BaseActivity.anInt2, Util.dp2px(context, 13), BaseActivity.anInt2);
            }
            this.f11963f.setRippleColor(context.getResources().getColor(R.color.ripple_dark));
            this.f11963f.setRippleHover(true);
            this.f11963f.setDefaultRippleAlpha(10);
            this.f11963f.setRippleRoundedCorners((int) context.getResources().getDimension(R.dimen._30sdp));
            obtainStyledAttributes.recycle();
        }
    }


    public void m6809a(boolean z) {
        this.f11960c.setVisibility(z ? View.VISIBLE : View.GONE);
    }

    public void setDrawableStart(int i) {
        this.f11961d.setImageResource(i);
    }

    public void setDrawableStartColor(ColorStateList colorStateList) {
        this.f11961d.setImageTintList(colorStateList);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11963f.setOnClickListener(onClickListener);
    }

    public void setText(int i) {
        this.f11959b.setText(getResources().getString(i));
    }
}
