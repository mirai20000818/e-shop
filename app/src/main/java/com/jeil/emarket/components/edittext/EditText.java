package com.jeil.emarket.components.edittext;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;
import com.jeil.emarket.custom.font.FontManager;
import com.jeil.emarket.custom.Util;


public class EditText extends AppCompatEditText {

    /* renamed from: f */
    public float fontSize;

    /* renamed from: com.jeil.emarket.components.edittext.EditText$a */
    public class EditTextTW implements TextWatcher {


        public final  int maxLen;

        
        public final  String string;

        public EditTextTW(int i, String str) {
            this.maxLen = i;
            this.string = str;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            if (this.maxLen <= 0 || charSequence.length() < this.maxLen || this.string == null) {
                return;
            }
            Util.toast(EditText.this.getContext(), this.string, "error", 0, 0);
        }
    }

    public EditText(Context context) {
        super(context);
        init();
    }

    public EditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public EditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }


    public void init() {
        this.fontSize = Util.getFontSize();
        setTextSize(0, getTextSize());
        setTypeface(FontManager.getFont(getContext(), "font/cheonlima.ttf"));
    }


    public void setMaxLength(int i, String str) {
        super.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        super.addTextChangedListener(new EditTextTW(i, str));
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView
    public void setInputType(int i) {
        super.setInputType(i);
        init();
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f * this.fontSize);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f * this.fontSize);
    }
}
