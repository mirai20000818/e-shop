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



public class ActionLink extends MaterialRippleLayout {

    /* renamed from: G */
    public TextView f11964G;

    /* renamed from: H */
    public ImageView f11965H;

    public ActionLink(Context context) {
        super(context);
    }

    public ActionLink(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6811a(context, attributeSet);
    }

    public ActionLink(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6811a(context, attributeSet);
    }

    
    public void m6810a(int i, float f) {
        this.f11964G.setTextSize(i, f);
    }

    
    public void m6811a(Context context, AttributeSet attributeSet) {
        View view;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionLink);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionLink_al_ripple_radius, false)) {
            setRippleRoundedCorners(50);
        }
        setRippleColor(getResources().getColor(R.color.ripple_light));
        setRippleHover(true);
        setRippleOverlay(true);
        setDefaultRippleAlpha(10);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        linearLayoutCompat.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f11964G = new TextView(context);
        this.f11964G.setText(obtainStyledAttributes.getText(R.styleable.ActionLink_al_text));
        this.f11964G.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.f11964G.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionLink_al_text_size, 0));
        this.f11964G.setTextColor(obtainStyledAttributes.getColor(R.styleable.ActionLink_al_text_color, context.getResources().getColor(R.color.dark)));
        setDefaultRippleAlpha((int) (obtainStyledAttributes.getFloat(R.styleable.ActionLink_al_rippleAlpha, 0.25f) * 100.0f));
        this.f11965H = new ImageView(context);
        this.f11965H.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ActionLink_al_drawable));
        if (obtainStyledAttributes.getColor(R.styleable.ActionLink_al_drawable_color, -1) != -1) {
            this.f11965H.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.ActionLink_al_drawable_color, -1)));
        }
        this.f11965H.setLayoutParams(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionLink_al_drawable_size, -1) == -1 ? new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) : new LinearLayoutCompat.LayoutParams(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionLink_al_drawable_size, -1), obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionLink_al_drawable_size, -1)));
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionLink_al_drawable_start, false)) {
            this.f11965H.setPadding(0, 0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionLink_al_distance, 0), 0);
            linearLayoutCompat.addView(this.f11965H);
            view = this.f11964G;
        } else {
            this.f11965H.setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), 0, 0, 0);
            linearLayoutCompat.addView(this.f11964G);
            view = this.f11965H;
        }
        linearLayoutCompat.addView(view);
        linearLayoutCompat.setGravity(17);
        addView(linearLayoutCompat);
    }

    public void setDistance(int i) {
        this.f11965H.setPadding(i, 0, 0, 0);
    }

    public void setIconOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f11965H;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setImageFlip(float f) {
        ImageView imageView = this.f11965H;
        if (imageView != null) {
            imageView.setRotation(f);
            ImageView imageView2 = this.f11965H;
            imageView2.setPadding(imageView2.getPaddingRight(), this.f11965H.getPaddingTop(), this.f11965H.getPaddingLeft(), this.f11965H.getPaddingBottom());
        }
    }

    public void setImageSize(int i) {
        this.f11965H.setLayoutParams(new LinearLayoutCompat.LayoutParams(i, i));
    }

    public void setImageViewColor(int i) {
        ImageView imageView = this.f11965H;
        if (imageView != null) {
            imageView.setImageTintList(ColorStateList.valueOf(getResources().getColor(i)));
        }
    }

    public void setText(String str) {
        this.f11964G.setText(str);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setmImageSize(int i) {
        if (this.f11965H != null) {
            this.f11965H.setLayoutParams(new LinearLayoutCompat.LayoutParams(Util.dp2px(getContext(), i), Util.dp2px(getContext(), i)));
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setmImageView(int i) {
        ImageView imageView = this.f11965H;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setmTextView(String str) {
        TextView textView = this.f11964G;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setmTextViewColor(int i) {
        if (i != 0) {
            this.f11964G.setTextColor(getContext().getResources().getColor(i));
        } else {
            this.f11964G.setTextColor(getContext().getResources().getColor(R.color.dark));
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setvImageView(int i) {
        if (i != 0) {
            this.f11965H.setImageResource(i);
        } else {
            this.f11965H.setImageResource(R.drawable.ic_arrow_down);
        }
    }

    public void setvImageViewColor(int i) {
        if (i != 0) {
            this.f11965H.setImageTintList(ColorStateList.valueOf(getContext().getResources().getColor(i)));
        } else {
            this.f11965H.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark)));
        }
    }
}
