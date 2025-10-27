package com.jeil.emarket.listener.cart;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.order.CartActivity;
import com.jeil.emarket.adapters.order.CartProductRecylcer;
import com.jeil.emarket.widget.ViewOnTouchListenerC2092s;

/* renamed from: b.f.a.a.e.j0 */

public class CartProductListener implements ViewOnTouchListenerC2092s.d {


    public final  RecyclerView f6635a;


    public final  CartProductRecylcer f6636b;

    public CartProductListener(CartActivity cartActivity, RecyclerView recyclerView, CartProductRecylcer c1850u0) {
        this.f6635a = recyclerView;
        this.f6636b = c1850u0;
    }

    @Override // p078b.p159f.p160a.p190c.ViewOnTouchListenerC2092s.d

    public void mo4365a(View view) {
//        int m2793g = this.f6635a.m2793g(view);
//        CartProductRecylcer c1850u0 = this.f6636b;
//        CartProduct cartProduct = (CartProduct) c1850u0.arrayList.remove(m2793g);
//        c1850u0.notifyDataSetChanged();
//        CartProductVM.m5572a(cartProduct, false);
    }

    @Override // p078b.p159f.p160a.p190c.ViewOnTouchListenerC2092s.d

    public boolean mo4366a(int i) {
        return true;
    }
}
