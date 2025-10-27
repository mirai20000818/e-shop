package com.jeil.emarket.adapters.shipping;

import android.text.Editable;
import android.text.TextWatcher;
import com.jeil.emarket.model.customer.Product;

/* renamed from: b.f.a.b.k.q1 */

public class TextWatcher4 implements TextWatcher {


    public final  ProductAdapter.a f8014b;

    
    public final  int f8015c;

    
    public final  ProductAdapter f8016d;

    public TextWatcher4(ProductAdapter c1970v1, ProductAdapter.a aVar, int i) {
        this.f8016d = c1970v1;
        this.f8014b = aVar;
        this.f8015c = i;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 30) {
            charSequence = charSequence.subSequence(0, 30);
            this.f8014b.f8068w.setText(charSequence.toString());
        }
        ((Product) this.f8016d.arrayList.get(this.f8015c)).sku = charSequence.toString();
    }
}
