package com.jeil.emarket.adapters.shipping;

import android.text.Editable;
import android.text.TextWatcher;
import com.jeil.emarket.model.customer.Product;

/* renamed from: b.f.a.b.k.r1 */

public class TextWatcher3 implements TextWatcher {


    public final  ProductAdapter.a f8020b;


    public final  int f8021c;


    public final  ProductAdapter f8022d;

    public TextWatcher3(ProductAdapter c1970v1, ProductAdapter.a aVar, int i) {
        this.f8022d = c1970v1;
        this.f8020b = aVar;
        this.f8021c = i;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        try {
            if (charSequence.length() > 9) {
                charSequence = charSequence.subSequence(0, 9);
                this.f8020b.f8071z.setText(charSequence.toString());
            }
            ((Product) this.f8022d.arrayList.get(this.f8021c)).regularPrice = Float.parseFloat(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
        } catch (Exception unused) {
            this.f8020b.f8071z.setText("");
            ((Product) this.f8022d.arrayList.get(this.f8021c)).regularPrice = 0.0f;
        }
    }
}
