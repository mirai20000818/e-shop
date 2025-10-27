package com.jeil.emarket.adapters.shipping;

import android.text.Editable;
import android.text.TextWatcher;
import com.jeil.emarket.model.customer.Product;

/* renamed from: b.f.a.b.k.s1 */

public class TextWatcher2 implements TextWatcher {


    public final  ProductAdapter.a f8026b;

    
    public final  int f8027c;

    
    public final  ProductAdapter f8028d;

    public TextWatcher2(ProductAdapter c1970v1, ProductAdapter.a aVar, int i) {
        this.f8028d = c1970v1;
        this.f8026b = aVar;
        this.f8027c = i;
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
                this.f8026b.f8059C.setText(charSequence.toString());
            }
            float parseFloat = Float.parseFloat(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
            if (parseFloat == 0.0f) {
                parseFloat = ((Product) this.f8028d.arrayList.get(this.f8027c)).regularPrice;
            }
            ((Product) this.f8028d.arrayList.get(this.f8027c)).salePrice = parseFloat;
        } catch (Exception unused) {
            this.f8026b.f8059C.setText("");
            ((Product) this.f8028d.arrayList.get(this.f8027c)).salePrice = ((Product) this.f8028d.arrayList.get(this.f8027c)).regularPrice;
        }
    }
}
