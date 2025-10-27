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
import com.bumptech.glide.RequestManager;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.model.customer.CheckoutVendor;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.b.g.x0 */

public class CheckoutVendorAdapter extends BaseMainAdapter<CheckoutVendor.Discounts.FbtProduct, CheckoutVendorAdapter.a> {

    /* renamed from: b.f.a.b.g.x0$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final AppCompatImageView f7516t;

        /* renamed from: u */
        public final MaterialRippleLayout f7517u;

        /* renamed from: v */
        public final TextView f7518v;

        /* renamed from: w */
        public final PriceText f7519w;

        /* renamed from: x */
        public final TextView f7520x;

        public a(View view) {
            super(view);
            this.f7516t = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f7517u = (MaterialRippleLayout) view.findViewById(R.id.mrl_img);
            this.f7518v = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7520x = (TextView) view.findViewById(R.id.tv_discount);
            this.f7519w = (PriceText) view.findViewById(R.id.pt_price);
        }
    }

    public CheckoutVendorAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    
    public  void m4472a(CheckoutVendor.Discounts.FbtProduct fbtProduct, Context context) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), ProductActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        int i = fbtProduct.parent;
        int i2 = fbtProduct.productId;
        if (i + i2 > 0) {
            intent.putExtra("id", i + i2);
            ProductTotalVM.m5467b(this.baseActivity, fbtProduct.parent + fbtProduct.productId);
        } else {
            intent.putExtra("id", fbtProduct.f12396id);
            ProductTotalVM.m5467b(this.baseActivity, fbtProduct.f12396id);
        }
        this.baseActivity.startActivity(intent);
    }

    
    public  void m4473a(final CheckoutVendor.Discounts.FbtProduct fbtProduct, View view) {
        API_PROVIDER.checkInternet(this.baseActivity, new InterfaceContext() { // from class: b.f.a.b.g.o
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context) {
                CheckoutVendorAdapter.this.m4472a(fbtProduct, context);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(a viewHolder, int i) {
        a aVar = (a) viewHolder;
        final CheckoutVendor.Discounts.FbtProduct fbtProduct = (CheckoutVendor.Discounts.FbtProduct) this.arrayList.get(i);
        aVar.f7516t.getLayoutParams().width = BaseActivity.anInt / 6;
        aVar.f7516t.getLayoutParams().height = BaseActivity.anInt / 6;
        RequestManager m3287a = Glide.with((FragmentActivity) this.baseActivity);
        StringBuilder sb = new StringBuilder();
        java.lang.String str = fbtProduct.image;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        java.lang.String str2 = fbtProduct.productImg;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        m3287a.load(Util.m306b(sb.toString(), "xs")).into((ImageView) aVar.f7516t);
        aVar.f7518v.setText(fbtProduct.name);
        aVar.f7518v.measure(-1, -2);
        aVar.f7519w.setCurrency(fbtProduct.currency);
        aVar.f7519w.setPrice(Util.m327c(Math.max(fbtProduct.price, fbtProduct.salePrice)));
        if (fbtProduct.discount > 0.0f) {
            TextView textView = aVar.f7520x;
            StringBuilder sb2 = new StringBuilder();
            CustomString.m3171a(this.baseActivity, R.string.order_discount_comma, sb2, " ");
            sb2.append(Util.m304b((fbtProduct.price * fbtProduct.discount) / 100.0f, true));
            CustomString.m3175a(sb2, fbtProduct.currency.equals("kpf") ? "" : this.baseActivity.getResources().getString(R.string.won), textView);
        } else {
            aVar.f7520x.setVisibility(View.GONE);
        }
        aVar.f7517u.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckoutVendorAdapter.this.m4473a(fbtProduct, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(CustomString.m3150a(viewGroup, R.layout.item_product_cart_discount, viewGroup, false));
    }
}
