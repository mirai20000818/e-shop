package com.jeil.emarket.components.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import java.util.regex.Pattern;


public class AutoCompleteEditPhone extends AutoCompleteTextView {

    /* renamed from: com.jeil.emarket.components.edittext.AutoCompleteEditPhone$a */
    public class AutoCompleteEditPhoneTW implements TextWatcher {

        
        public boolean f12237b;

        public AutoCompleteEditPhoneTW() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            if (this.f12237b) {
                this.f12237b = false;
                return;
            }
            this.f12237b = true;
            String string = AutoCompleteEditPhone.this.formatString(charSequence.toString());
            AutoCompleteEditPhone.this.autoCompleteTextView.setText(string);
            AutoCompleteEditPhone.this.autoCompleteTextView.setSelection(Math.max(Math.min(((start + (count > before ? count - before : 0)) + AutoCompleteEditPhone.this.countHyphens(string)) - AutoCompleteEditPhone.this.countHyphens(charSequence.toString()), string.length()), 0));
        }
    }

    public AutoCompleteEditPhone(Context context) {
        super(context);
    }

    public AutoCompleteEditPhone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public AutoCompleteEditPhone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    
    public final int countHyphens(String str) {
        int i = 0;
        while (Pattern.compile("-").matcher(str).find()) {
            i++;
        }
        return i;
    }

    @Override // com.jeil.emarket.components.edittext.AutoCompleteTextView
    
    public void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        this.autoCompleteTextView.setInputType(2);
        setRippleLayoutVisibility(true);
        this.autoCompleteTextView.addTextChangedListener(new AutoCompleteEditPhoneTW());
    }


    public final java.lang.String formatString(java.lang.String str) {
        return  str;
    }

    
    public boolean isFull(String str) {
        if (str.length() <= 0) {
            return false;
        }
        String replace = str.replace("-", "");
        if (replace.startsWith("0") && replace.length() == 9) {
            return true;
        }
        return replace.startsWith("1") && replace.length() == 10;
    }
}
