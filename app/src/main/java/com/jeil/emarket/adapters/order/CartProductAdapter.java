package com.jeil.emarket.adapters.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.b.g.r0 */

public class CartProductAdapter extends BaseMainAdapter<CartProduct, CartProductAdapter.a> {

    /* renamed from: b.f.a.b.g.r0$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final AppCompatImageView f7469t;

        /* renamed from: u */
        public final MaterialRippleLayout f7470u;

        /* renamed from: v */
        public final TextView f7471v;

        /* renamed from: w */
        public final PriceText f7472w;

        /* renamed from: x */
        public final TextView f7473x;

        public a(View view) {
            super(view);
            this.f7469t = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f7470u = (MaterialRippleLayout) view.findViewById(R.id.mrl_img);
            this.f7471v = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7473x = (TextView) view.findViewById(R.id.tv_discount);
            this.f7472w = (PriceText) view.findViewById(R.id.pt_price);
        }
    }

    public CartProductAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    
    public  void m4461a(CartProduct cartProduct, Context context) {
        BaseActivity activityC1391g1;
        int i;
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), ProductActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        int i2 = cartProduct.parentId;
        if (i2 > 0) {
            intent.putExtra("id", i2);
            activityC1391g1 = this.baseActivity;
            i = cartProduct.parentId;
        } else {
            intent.putExtra("id", cartProduct.f12392id);
            activityC1391g1 = this.baseActivity;
            i = cartProduct.f12392id;
        }
        ProductTotalVM.m5467b(activityC1391g1, i);
        this.baseActivity.startActivity(intent);
    }

    
    public  void m4462a(final CartProduct cartProduct, View view) {
        API_PROVIDER.checkInternet(this.baseActivity, new InterfaceContext() { // from class: b.f.a.b.g.a
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context) {
                CartProductAdapter.this.m4461a(cartProduct, context);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(a viewHolder, int i) {
        float f;
        float f2;
        a aVar = (a) viewHolder;
        final CartProduct cartProduct = (CartProduct) this.arrayList.get(i);
        aVar.f7469t.getLayoutParams().width = BaseActivity.anInt / 6;
        aVar.f7469t.getLayoutParams().height = BaseActivity.anInt / 6;
        Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(cartProduct.image, "xs")).into((ImageView) aVar.f7469t);
        aVar.f7471v.setText(cartProduct.name);
        aVar.f7471v.measure(-1, -2);
        aVar.f7472w.setCurrency(cartProduct.currency);
        PriceText priceText = aVar.f7472w;
        if (cartProduct.currency.equals("kpf")) {
            f = cartProduct.priceKpf;
            f2 = cartProduct.discountPriceKpf;
        } else {
            f = cartProduct.priceKpw;
            f2 = cartProduct.discountPriceKpw;
        }
        priceText.setPrice(Util.m327c(f + f2));
        if (cartProduct.discountPriceKpf + cartProduct.discountPriceKpw > 0.0f) {
            TextView textView = aVar.f7473x;
            StringBuilder sb = new StringBuilder();
            CustomString.m3171a(this.baseActivity, R.string.order_discount_comma, sb, " ");
            sb.append(Util.m304b(cartProduct.currency.equals("kpf") ? cartProduct.discountPriceKpf : cartProduct.discountPriceKpw, true));
            CustomString.m3175a(sb, cartProduct.currency.equals("kpf") ? "" : this.baseActivity.getResources().getString(R.string.won), textView);
        } else {
            aVar.f7473x.setVisibility(View.GONE);
        }
        aVar.f7470u.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CartProductAdapter.this.m4462a(cartProduct, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(CustomString.m3150a(viewGroup, R.layout.item_product_cart_discount, viewGroup, false));
    }
}
