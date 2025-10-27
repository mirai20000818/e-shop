package com.jeil.emarket.components.edittext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.Util;

import java.util.List;

import com.jeil.emarket.custom.font.FontManager;


public class AutoCompleteTextView extends CoordinatorLayout {

    
    public ImageView searchImg1;

    
    public ImageView searchImg2;

    
    public android.widget.AutoCompleteTextView autoCompleteTextView;

    
    public MaterialRippleLayout materialRippleLayout;

    
    public boolean aBoolean;

    public AutoCompleteTextView(Context context) {
        super(context);
        this.aBoolean = false;
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBoolean = false;
        init(context, attributeSet);
    }

    public AutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBoolean = false;
        init(context, attributeSet);
    }

    private void setRippleAttrs(MaterialRippleLayout materialRippleLayout) {
        materialRippleLayout.setRippleRoundedCorners(50);
        materialRippleLayout.setRippleColor(getResources().getColor(R.color.ripple_light));
        materialRippleLayout.setRippleHover(true);
        materialRippleLayout.setRippleOverlay(true);
        materialRippleLayout.setDefaultRippleAlpha(10);
    }

    
    public int dp2px(float f) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, f, getResources().getDisplayMetrics()));
    }

    
    public void init(Context context, AttributeSet attributeSet) {
        this.autoCompleteTextView = new android.widget.AutoCompleteTextView(context);
        this.autoCompleteTextView.setLayoutParams(new LayoutParams(-1, dp2px(40.0f)));
        this.autoCompleteTextView.setHintTextColor(getResources().getColor(R.color.light));
        this.autoCompleteTextView.setDropDownVerticalOffset(Util.dp2px(context, 0));
        this.autoCompleteTextView.setDropDownBackgroundResource(R.drawable.autocomplete_dropdown);
        this.autoCompleteTextView.clearFocus();
        if (Build.VERSION.SDK_INT >= 26) {
            this.autoCompleteTextView.setFocusedByDefault(false);
        }
        setTextColor(R.color.dark);
        this.materialRippleLayout = new MaterialRippleLayout(context);
        setRippleAttrs(this.materialRippleLayout);
        this.searchImg1 = new ImageView(context);
        this.searchImg2 = new ImageView(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoCompleteTextView);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoCompleteTextView_ac_drawable_size, (int) getResources().getDimension(R.dimen._17sdp)), obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoCompleteTextView_ac_drawable_size, (int) getResources().getDimension(R.dimen._17sdp)));
            layoutParams.gravity = 17;
            this.aBoolean = obtainStyledAttributes.getBoolean(R.styleable.AutoCompleteTextView_ac_drawable_start, false);
            this.autoCompleteTextView.setLayoutParams(new LayoutParams(-1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoCompleteTextView_ac_height, dp2px(38.0f))));
            this.searchImg2.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, getResources().getColor(R.color.light))));
            this.searchImg1.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, getResources().getColor(R.color.light))));
            this.searchImg1.setLayoutParams(layoutParams);
            this.searchImg2.setLayoutParams(layoutParams);
            MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(context);
            setRippleAttrs(materialRippleLayout);
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(dp2px(12.0f), dp2px(12.0f)));
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_close));
            if (obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, -1) != -1) {
                imageView.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, -1)));
            }
            materialRippleLayout.addView(imageView);
            LayoutParams layoutParams1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams1.gravity = 8388629;
            layoutParams1.setMargins(0, 0, dp2px(30.0f), 0);
            materialRippleLayout.setLayoutParams(layoutParams1);
            materialRippleLayout.setPadding(dp2px(11.0f), dp2px(11.0f), dp2px(11.0f), dp2px(11.0f));
            setEditTextBackground(obtainStyledAttributes.getDrawable(0) != null ? obtainStyledAttributes.getDrawable(0) : getResources().getDrawable(R.drawable.bg_input_border));
            int integer = obtainStyledAttributes.getInteger(R.styleable.AutoCompleteTextView_ac_length_limited, 100);
            if (integer > 0) {
                this.autoCompleteTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(integer)});
            }
            this.searchImg1.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));
            if (obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, -1) != -1) {
                this.searchImg1.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, -1)));
            }
            this.searchImg2.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));
            if (obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, -1) != -1) {
                this.searchImg2.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.AutoCompleteTextView_ac_drawable_color, -1)));
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoCompleteTextView_ac_drawable_padding, dp2px(5.0f));
            LayoutParams layoutParams2 = new LayoutParams(Util.dp2px(context, 35), Util.dp2px(context, 35));
            layoutParams2.gravity = 8388627;
            layoutParams2.setMargins(dimensionPixelSize, 0, 0, 0);
            this.materialRippleLayout.setLayoutParams(layoutParams2);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoCompleteTextView_ac_input_padding, dp2px(13.0f));
            if (this.aBoolean) {
                this.materialRippleLayout.addView(this.searchImg1);
                this.autoCompleteTextView.setPadding(dp2px(40.0f), 0, dimensionPixelSize2, 0);
            } else {
                layoutParams2.gravity = 8388629;
                layoutParams2.setMargins(0, 0, dimensionPixelSize, 0);
                this.materialRippleLayout.addView(this.searchImg2);
                this.autoCompleteTextView.setPadding(dimensionPixelSize2, 0, dp2px(40.0f), 0);
            }
            CharSequence text = obtainStyledAttributes.getText(R.styleable.AutoCompleteTextView_ac_placeholder);
            String str = (String) obtainStyledAttributes.getText(R.styleable.AutoCompleteTextView_ac_text);
            this.autoCompleteTextView.setHint(text);
            this.autoCompleteTextView.setHintTextColor(getResources().getColor(R.color.light));
            this.autoCompleteTextView.setText(str);
            this.autoCompleteTextView.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutoCompleteTextView_ac_text_size, getResources().getDimensionPixelSize(R.dimen.font_11_5)) * Util.getFontSize());
            this.autoCompleteTextView.setInputType(1);
            setThreshold(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.AutoCompleteTextView_ac_threshold, 1));
            setEnabled();
            addView(this.autoCompleteTextView);
            addView(this.materialRippleLayout);
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.d0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AutoCompleteTextView.this.setText(view);
                }
            });
        }
    }

    
    public void setAdapter(Context context, List<String> list) {
        this.autoCompleteTextView.setAdapter(new ArrayAdapter(context, R.layout.layout_autocomplete_item, R.id.tv_search_item, list));
    }

    
    public void setRippleLayoutVisibility(boolean z) {
        this.materialRippleLayout.setVisibility(z ? View.GONE : View.VISIBLE);
        this.autoCompleteTextView.setPadding(dp2px(13.0f), 0, dp2px(13.0f), 0);
    }

    
    public  void setText(View view) {
        this.autoCompleteTextView.setText("");
    }

    /* renamed from: g */
    public void setEnabled() {
        this.autoCompleteTextView.setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
        this.autoCompleteTextView.setEnabled(true);
        this.autoCompleteTextView.setClickable(false);
    }

    public String getText() {
        return this.autoCompleteTextView.getText().toString();
    }

    public void setEditTextBackground(Drawable drawable) {
        this.autoCompleteTextView.setBackground(drawable);
    }

    public void setIconDrawable(int i) {
        (this.aBoolean ? this.searchImg1 : this.searchImg2).setImageDrawable(getResources().getDrawable(i));
    }

    public void setIconOnClickListener(View.OnClickListener onClickListener) {
        (this.aBoolean ? this.searchImg1 : this.searchImg2).setOnClickListener(onClickListener);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.autoCompleteTextView.setOnEditorActionListener(onEditorActionListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.autoCompleteTextView.setOnItemClickListener(onItemClickListener);
    }

    public void setRippleColor(int i) {
        this.materialRippleLayout.setRippleColor(getResources().getColor(i));
    }

    public void setText(String str) {
        this.autoCompleteTextView.setText(str);
    }

    public void setTextColor(int i) {
        this.autoCompleteTextView.setTextColor(getResources().getColor(i));
    }

    public void setThreshold(int i) {
        this.autoCompleteTextView.setThreshold(i);
    }
}
