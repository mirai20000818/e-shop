package com.jeil.emarket.adapters.order;

import android.view.View;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.widget.ViewOnTouchListenerC2092s;
import com.jeil.emarket.viewmodel.CartProductVM;

/* renamed from: b.f.a.b.g.t0 */

public class ViewTouch implements ViewOnTouchListenerC2092s.d {


    public final  int f7479a;


    public final  CartProductRecylcer f7480b;

    public ViewTouch(CartProductRecylcer c1850u0, int i) {
        this.f7480b = c1850u0;
        this.f7479a = i;
    }

    @Override // p078b.p159f.p160a.p190c.ViewOnTouchListenerC2092s.d

    public void mo4365a(View view) {
        CartProductVM.m5572a((CartProduct) this.f7480b.arrayList.get(this.f7479a), false);
    }

    @Override // p078b.p159f.p160a.p190c.ViewOnTouchListenerC2092s.d

    public boolean mo4366a(int i) {
        return true;
    }
}
