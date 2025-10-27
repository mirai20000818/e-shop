package com.jeil.emarket.adapters.shipping;

import android.text.Editable;
import android.text.TextWatcher;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.FBT;

/* renamed from: b.f.a.b.k.l1 */

public class FBTProductTextWatcher implements TextWatcher {

    
    public final  FBTProductAdapter.a f7939b;

    
    public final  int f7940c;

    
    public final  FBT.Product f7941d;

    
    public final  FBTProductAdapter f7942e;

    public FBTProductTextWatcher(FBTProductAdapter c1943m1, FBTProductAdapter.a aVar, int i, FBT.Product product) {
        this.f7942e = c1943m1;
        this.f7939b = aVar;
        this.f7940c = i;
        this.f7941d = product;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        float f;
        try {
            f = Float.parseFloat(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
        } catch (Exception unused) {
            this.f7939b.f7953A.setText("");
            f = 0.0f;
        }
        if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
            if (f == 0.0f) {
                this.f7939b.f7953A.setText("");
            } else {
                this.f7939b.f7953A.setText(f + "");
            }
        }
        float f2 = 99.0f;
        if (f > 99.0f) {
            this.f7939b.f7953A.setText("99");
        } else {
            f2 = f;
        }
        ((FBT.Product) this.f7942e.arrayList.get(this.f7940c)).discount = f2;
        FBT.Product product = this.f7941d;
        if (product.maxPrice <= 0.0f) {
            this.f7939b.f7955C.setPtSalePrice(Util.m327c(((100.0f - f2) * product.price) / 100.0f));
            return;
        }
        float f3 = 100.0f - f2;
        this.f7939b.f7955C.m6938a(Util.m327c((product.minPrice * f3) / 100.0f), Util.m327c((this.f7941d.maxPrice * f3) / 100.0f));
        this.f7939b.f7955C.m6939a(false);
    }
}
