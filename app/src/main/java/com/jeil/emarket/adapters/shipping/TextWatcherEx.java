package com.jeil.emarket.adapters.shipping;

import android.text.Editable;
import android.text.TextWatcher;
import com.jeil.emarket.model.customer.Product;

/* renamed from: b.f.a.b.k.u1 */

public class TextWatcherEx implements TextWatcher {

    
    public final  ProductAdapter.a f8049b;

    
    public final  int f8050c;

    
    public final  ProductAdapter f8051d;

    public TextWatcherEx(ProductAdapter c1970v1, ProductAdapter.a aVar, int i) {
        this.f8051d = c1970v1;
        this.f8049b = aVar;
        this.f8050c = i;
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
                this.f8049b.f8062F.setText(charSequence.toString());
            }
            Product product = (Product) this.f8051d.arrayList.get(this.f8050c);
            if (!charSequence.toString().isEmpty() && !charSequence.toString().equals("-")) {
                str = charSequence.toString();
                product.stockThreshold = Integer.parseInt(str);
            }
            str = "0";
            product.stockThreshold = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            ((Product) this.f8051d.arrayList.get(this.f8050c)).stockThreshold = 0;
            this.f8049b.f8062F.setText("");
        }
    }
}
