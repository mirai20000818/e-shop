package com.jeil.emarket.components.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import java.util.regex.Pattern;


public class EditPhone extends EditForm {

    /* renamed from: com.jeil.emarket.components.edittext.EditPhone$a */
    public class PhoneTW implements TextWatcher {
        public boolean isUpdating = false;
        public PhoneTW() {
        }
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            if (this.isUpdating) {
                this.isUpdating = false;
                return;
            }
            this.isUpdating = true;
            String formattedPhoneNumber = EditPhone.this.formatPhoneNumber(charSequence.toString());
            EditPhone.this.editText.setText(formattedPhoneNumber);
            EditPhone.this.editText.setSelection(Math.max(Math.min(((start + (count > before ? count - before : 0)) + EditPhone.this.countHyphens(formattedPhoneNumber)) - EditPhone.this.countHyphens(charSequence.toString()), formattedPhoneNumber.length()), 0));
        }
    }

    public EditPhone(Context context) {
        super(context);
    }

    public EditPhone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }
    public EditPhone(Context context, AttributeSet attributeSet, int i) {
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
    @Override // com.jeil.emarket.components.edittext.EditForm
    public void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        this.editText.setInputType(2);
        this.editText.addTextChangedListener(new PhoneTW());
    }

    public final java.lang.String formatPhoneNumber(java.lang.String str) {
        return str;
    }
    public boolean m6929c(String str) {
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
