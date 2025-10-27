package com.jeil.emarket.components.edittext;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.Util;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import com.jeil.emarket.custom.font.FontManager;


public class EditForm extends CoordinatorLayout {

    
    public ImageView imageView;

    
    public Drawable drawable;

    
    public ImageView eyeImg;

    
    public Drawable f12247D;

    
    public TextInputEditText editText;

    /* renamed from: F */
    public MaterialRippleLayout materialRippleLayout;

    /* renamed from: G */
    public boolean editable;

    /* renamed from: H */
    public ObjectAnimator f12251H;

    
    public float fontSize;

    /* renamed from: com.jeil.emarket.components.edittext.EditForm$a */
    public class TextChangedListen implements TextWatcher {

        
        public final  MaterialRippleLayout rippleLayout;

        public TextChangedListen(MaterialRippleLayout materialRippleLayout) {
            this.rippleLayout = materialRippleLayout;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            EditForm editForm;
            boolean z;
            if (charSequence.toString().isEmpty()) {
                EditForm editForm2 = EditForm.this;
                if (editForm2.editable) {
                    editForm2.removeView(this.rippleLayout);
                    editForm = EditForm.this;
                    z = false;
                    editForm.editable = z;
                }
            }
            if (charSequence.toString().isEmpty()) {
                return;
            }
            EditForm editForm3 = EditForm.this;
            if (editForm3.editable) {
                return;
            }
            editForm3.addView(this.rippleLayout);
            editForm = EditForm.this;
            z = true;
            editForm.editable = z;
        }
    }

    public EditForm(Context context) {
        super(context);
        this.editable = false;
    }

    public EditForm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.editable = false;
        init(context, attributeSet);
    }

    public EditForm(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.editable = false;
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

    @SuppressLint({"UseCompatLoadingForDrawables", "ResourceType"})
    
    public void init(Context context, AttributeSet attributeSet) {
        TextInputEditText textInputEditText;
        this.editText = new TextInputEditText(context);
        this.editText.setLayoutParams(new LayoutParams(-1, dp2px(40.0f)));
        this.editText.setHintTextColor(getResources().getColor(R.color.light));
        setTextColor(R.color.dark);
        this.materialRippleLayout = new MaterialRippleLayout(context);
        setRippleAttrs(this.materialRippleLayout);
        this.imageView = new ImageView(context);
        this.eyeImg = new ImageView(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditForm);
            boolean z = obtainStyledAttributes.getBoolean(13, false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(obtainStyledAttributes.getDimensionPixelSize(4, (int) getResources().getDimension(R.dimen._17sdp)), obtainStyledAttributes.getDimensionPixelSize(4, (int) getResources().getDimension(R.dimen._17sdp)));
            layoutParams.gravity = 17;
            this.editText.setLayoutParams(new LayoutParams(-1, obtainStyledAttributes.getDimensionPixelSize(8, dp2px(38.0f))));
            this.eyeImg.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(1, getResources().getColor(R.color.light))));
            this.imageView.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(1, getResources().getColor(R.color.light))));
            this.imageView.setLayoutParams(layoutParams);
            this.eyeImg.setLayoutParams(layoutParams);
            MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(context);
            setRippleAttrs(materialRippleLayout);
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(dp2px(12.0f), dp2px(12.0f)));
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_close));
            if (obtainStyledAttributes.getColor(1, -1) != -1) {
                imageView.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(1, -1)));
            }
            materialRippleLayout.addView(imageView);
            LayoutParams layoutParams1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            //layoutParams1.gravity = 8388629;
            layoutParams1.gravity = Gravity.CENTER | Gravity.FILL;
            layoutParams1.setMargins(0, 0, dp2px(30.0f), 0);
            materialRippleLayout.setLayoutParams(layoutParams1);
            materialRippleLayout.setPadding(dp2px(11.0f), dp2px(11.0f), dp2px(11.0f), dp2px(11.0f));
            setEditTextBackground(obtainStyledAttributes.getDrawable(0) != null ? obtainStyledAttributes.getDrawable(0) : getResources().getDrawable(R.drawable.bg_input_border));
            int integer = obtainStyledAttributes.getInteger(10, 100);
            if (integer > 0) {
                this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(integer)});
            }
            this.drawable = obtainStyledAttributes.getDrawable(5);
            this.imageView.setImageDrawable(this.drawable);
            if (obtainStyledAttributes.getColor(1, -1) != -1) {
                this.imageView.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(1, -1)));
            }
            this.f12247D = obtainStyledAttributes.getDrawable(2);
            this.eyeImg.setImageDrawable(this.f12247D);
            if (obtainStyledAttributes.getColor(1, -1) != -1) {
                this.eyeImg.setImageTintList(ColorStateList.valueOf(obtainStyledAttributes.getColor(1, -1)));
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, dp2px(5.0f));
            LayoutParams layoutParams2 = new LayoutParams(Util.dp2px(context, 35), Util.dp2px(context, 35));
            layoutParams2.gravity = 8388627;
            layoutParams2.setMargins(dimensionPixelSize, 0, 0, 0);
            this.materialRippleLayout.setLayoutParams(layoutParams2);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(9, dp2px(13.0f));
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(6, dp2px(35.0f));
            if (this.drawable != null) {
                this.materialRippleLayout.addView(this.imageView);
                this.editText.setPadding(dp2px(40.0f), 0, dimensionPixelSize2, 0);
            } else {
                if (this.f12247D != null) {
                    layoutParams2.gravity = 8388629;
                    layoutParams2.setMargins(0, 0, dimensionPixelSize, 0);
                    this.materialRippleLayout.addView(this.eyeImg);
                    textInputEditText = this.editText;
                    if (z) {
                        dimensionPixelSize3 = dp2px(65.0f);
                    }
                } else {
                    textInputEditText = this.editText;
                }
                textInputEditText.setPadding(dimensionPixelSize2, 0, dimensionPixelSize3, 0);
            }
            CharSequence text = obtainStyledAttributes.getText(11);
            String str = (String) obtainStyledAttributes.getText(14);
            this.editText.setHint(text);
            this.editText.setHintTextColor(getResources().getColor(R.color.white_bg));
            this.editText.setText(str);
            this.fontSize = Util.getFontSize();
            this.editText.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(15, getResources().getDimensionPixelSize(R.dimen.font_11_5)) * this.fontSize);
            this.editText.setInputType(obtainStyledAttributes.getInt(16, 1));
            init();
            this.editText.setFocusable(obtainStyledAttributes.getBoolean(7, true));
            addView(this.editText);
            if (this.drawable != null || this.f12247D != null) {
                addView(this.materialRippleLayout);
                if (z) {
                    this.editText.addTextChangedListener(new TextChangedListen(materialRippleLayout));
                }
            }
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.d0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditForm.this.setEmpty(view);
                }
            });
        }
    }

    
    public  void setEmpty(View view) {
        this.editText.setText("");
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: g */
    public void showeye() {
        this.eyeImg.setImageDrawable(getResources().getDrawable(this.editText.getInputType() == 129 ? R.drawable.ic_eye_slash : R.drawable.ic_eye));
        TextInputEditText textInputEditText = this.editText;
        textInputEditText.setInputType(textInputEditText.getInputType() == 129 ? 1 : 129);
        init();
    }

    public String getText() {
        return ((Editable) Objects.requireNonNull(this.editText.getText())).toString();
    }

    /* renamed from: h */
    public void init() {
        this.editText.setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
        this.editText.setEnabled(true);
        this.editText.setClickable(false);
    }

    
    public void hide() {
        this.materialRippleLayout.setVisibility(View.GONE);
    }

   
    public void unFocusable() {
        this.editText.setFocusable(false);
    }

    public void setEditListener(TextWatcher textWatcher) {
        this.editText.addTextChangedListener(textWatcher);
    }

    public void setEditTextBackground(Drawable drawable) {
        this.editText.setBackground(drawable);
    }

    public void setEnable(boolean z) {
        this.editText.setEnabled(z);
    }

    public void setHintText(String str) {
        this.editText.setHint(str);
    }

    public void setIconOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        if (this.drawable != null) {
            imageView = this.imageView;
        } else if (this.f12247D == null) {
            return;
        } else {
            imageView = this.eyeImg;
        }
        imageView.setOnClickListener(onClickListener);
    }


    public void setInputType(int i) {
        this.editText.setInputType(i);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.editText.setOnEditorActionListener(onEditorActionListener);
    }

    public void setPlaceHolder(String str) {
        this.editText.setHint(str);
    }

    public void setRippleColor(int i) {
        this.materialRippleLayout.setRippleColor(getResources().getColor(i));
    }

    public void setText(String str) {
        this.editText.setText(str);
    }

    public void setTextColor(int i) {
        this.editText.setTextColor(getResources().getColor(i));
    }
}
