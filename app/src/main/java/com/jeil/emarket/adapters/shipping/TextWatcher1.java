package com.jeil.emarket.adapters.shipping;

import android.text.Editable;
import android.text.TextWatcher;
import com.jeil.emarket.model.customer.Product;

/* renamed from: b.f.a.b.k.t1 */

public class TextWatcher1 implements TextWatcher {


    public final  ProductAdapter.a f8036b;


    public final  int f8037c;


    public final  ProductAdapter f8038d;

    public TextWatcher1(ProductAdapter c1970v1, ProductAdapter.a aVar, int i) {
        this.f8038d = c1970v1;
        this.f8036b = aVar;
        this.f8037c = i;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        try {
            if (charSequence.length() > 8) {
                charSequence = charSequence.subSequence(0, 8).toString();
                this.f8036b.f8061E.setText(charSequence.toString());
            }
            Product product = (Product) this.f8038d.arrayList.get(this.f8037c);
            if (!charSequence.toString().isEmpty() && !charSequence.toString().equals("-")) {
                str = charSequence.toString();
                product.stock = Integer.parseInt(str);
            }
            str = "0";
            product.stock = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            ((Product) this.f8038d.arrayList.get(this.f8037c)).stock = 0;
            this.f8036b.f8061E.setText("");
        }
    }
}
