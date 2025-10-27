package com.jeil.emarket.adapters.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.QuantityInput;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.CheckoutVendor;

import java.util.List;


/* renamed from: b.f.a.b.g.w0 */

public class CheckoutVendorMainAdapter extends BaseMainAdapter<CheckoutVendor.Product, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public int f7497f;

    /* renamed from: b.f.a.b.g.w0$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final RecyclerView f7498t;

        /* renamed from: u */
        public final QuantityInput f7499u;

        /* renamed from: v */
        public final TextView f7500v;

        /* renamed from: w */
        public final ProductPrice f7501w;

        /* renamed from: x */
        public final ProductPrice f7502x;

        /* renamed from: y */
        public final CheckBox f7503y;

        /* renamed from: z */
        public final LinearLayoutCompat f7504z;

        public a(View view) {
            super(view);
            this.f7498t = (RecyclerView) view.findViewById(R.id.rv_cart_products);
            this.f7499u = (QuantityInput) view.findViewById(R.id.cqi_quantity);
            this.f7500v = (TextView) view.findViewById(R.id.tv_quantity);
            this.f7501w = (ProductPrice) view.findViewById(R.id.pp_kpf_price);
            this.f7502x = (ProductPrice) view.findViewById(R.id.pp_kpw_price);
            this.f7503y = (CheckBox) view.findViewById(R.id.cb_product);
            this.f7504z = (LinearLayoutCompat) view.findViewById(R.id.ll_price);
        }
    }

    /* renamed from: b.f.a.b.g.w0$b */
    public static class b extends RecyclerView.ViewHolder {

        
        public final TextView f7505A;

        
        public final LinearLayoutCompat f7506B;

        /* renamed from: t */
        public final AppCompatImageView f7507t;

        /* renamed from: u */
        public final MaterialRippleLayout f7508u;

        /* renamed from: v */
        public final TextView f7509v;

        /* renamed from: w */
        public final QuantityInput f7510w;

        /* renamed from: x */
        public final PriceText f7511x;

        /* renamed from: y */
        public final TextView f7512y;

        /* renamed from: z */
        public final TextView f7513z;

        public b(View view) {
            super(view);
            this.f7507t = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f7508u = (MaterialRippleLayout) view.findViewById(R.id.mrl_img);
            this.f7509v = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7510w = (QuantityInput) view.findViewById(R.id.cqi_quantity);
            this.f7511x = (PriceText) view.findViewById(R.id.pt_price);
            this.f7512y = (TextView) view.findViewById(R.id.tv_quantity);
            this.f7513z = (TextView) view.findViewById(R.id.tv_cannot_shipping);
            this.f7505A = (TextView) view.findViewById(R.id.tv_discount_notice);
            this.f7506B = (LinearLayoutCompat) view.findViewById(R.id.ll_discount);
        }
    }

    public CheckoutVendorMainAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7497f = 0;
    }

    
    public  void m4471a(int i, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), ProductActivity.class);
        intent.putExtra("id", ((CheckoutVendor.Product) this.arrayList.get(i)).parent > 0 ? ((CheckoutVendor.Product) this.arrayList.get(i)).parent : ((CheckoutVendor.Product) this.arrayList.get(i)).f12397id);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.baseActivity.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((CheckoutVendor.Product) this.arrayList.get(i)).discountType == null || ((CheckoutVendor.Product) this.arrayList.get(i)).discountType.isEmpty()) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        ProductPrice productPrice;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof b) {
            b bVar = (b) recyclerViewViewHolder;
            bVar.f7507t.getLayoutParams().width = (BaseActivity.anInt * 6) / 36;
            bVar.f7507t.getLayoutParams().height = (BaseActivity.anInt * 6) / 36;
            Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(((CheckoutVendor.Product) this.arrayList.get(i)).image, "xs")).into((ImageView) bVar.f7507t);
            bVar.f7509v.setText(((CheckoutVendor.Product) this.arrayList.get(i)).name);
            bVar.f7505A.setVisibility(View.GONE);
            bVar.f7506B.setVisibility(View.GONE);
            bVar.f7511x.setCurrency(((CheckoutVendor.Product) this.arrayList.get(i)).currency);
            bVar.f7511x.setPrice(Util.m327c(((CheckoutVendor.Product) this.arrayList.get(i)).salePrice * ((CheckoutVendor.Product) this.arrayList.get(i)).qty));
            bVar.f7510w.setVisibility(View.GONE);
            bVar.f7512y.setVisibility(View.VISIBLE);
            if (((CheckoutVendor.Product) this.arrayList.get(i)).stock > 0 || ((CheckoutVendor.Product) this.arrayList.get(i)).enableBackOrder) {
                TextView textView = bVar.f7512y;
                StringBuilder sb = new StringBuilder();
                CustomString.m3171a(this.baseActivity, R.string.stock, sb, " ");
                sb.append(((CheckoutVendor.Product) this.arrayList.get(i)).qty);
                CustomString.m3170a(this.baseActivity, R.string.count, sb, textView);
            } else {
                bVar.f7512y.setText(R.string.empty_stock);
            }
            bVar.f7508u.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckoutVendorMainAdapter.this.m4471a(i, view);
                }
            });
            if (((CheckoutVendor.Product) this.arrayList.get(i)).canShipping || this.f7497f > 0) {
                bVar.f7513z.setVisibility(View.GONE);
                return;
            } else {
                bVar.f7513z.setVisibility(View.VISIBLE);
                return;
            }
        }
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.f7500v.setVisibility(View.VISIBLE);
            aVar.f7499u.setVisibility(View.GONE);
            if (((CheckoutVendor.Product) this.arrayList.get(i)).stock > 0 || ((CheckoutVendor.Product) this.arrayList.get(i)).qty > 0 || ((CheckoutVendor.Product) this.arrayList.get(i)).enableBackOrder) {
                TextView textView2 = aVar.f7500v;
                StringBuilder sb2 = new StringBuilder();
                CustomString.m3171a(this.baseActivity, R.string.stock, sb2, " ");
                sb2.append(((CheckoutVendor.Product) this.arrayList.get(i)).qty);
                CustomString.m3170a(this.baseActivity, R.string.count, sb2, textView2);
            } else {
                aVar.f7500v.setText(R.string.empty_stock);
            }
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams) c0541a).leftMargin = Util.dp2px((Context) this.baseActivity, 90);
            ((LinearLayout.LayoutParams) c0541a).rightMargin = Util.dp2px((Context) this.baseActivity, 13);
            ((LinearLayout.LayoutParams) c0541a).bottomMargin = Util.dp2px((Context) this.baseActivity, 15);
            aVar.f7504z.setLayoutParams(c0541a);
            aVar.f7501w.m6941c(false);
            aVar.f7501w.setTextSize(14);
            aVar.f7501w.setPtSalePrice(Util.m327c(((CheckoutVendor.Product) this.arrayList.get(i)).priceKpf - ((CheckoutVendor.Product) this.arrayList.get(i)).discountPriceKpf));
            aVar.f7502x.m6941c(false);
            aVar.f7502x.setTextSize(14);
            aVar.f7502x.setPtSalePrice(Util.m327c(((CheckoutVendor.Product) this.arrayList.get(i)).priceKpw - ((CheckoutVendor.Product) this.arrayList.get(i)).discountPriceKpw));
            if (((CheckoutVendor.Product) this.arrayList.get(i)).priceKpf > ((CheckoutVendor.Product) this.arrayList.get(i)).discountPriceKpf) {
                if (((CheckoutVendor.Product) this.arrayList.get(i)).priceKpw <= ((CheckoutVendor.Product) this.arrayList.get(i)).discountPriceKpw) {
                    productPrice = aVar.f7502x;
                }
                aVar.f7503y.setVisibility(View.GONE);
                CheckoutVendorAdapter c1856x0 = new CheckoutVendorAdapter(this.baseActivity);
                aVar.f7498t.setAdapter(c1856x0);
                //aVar.f7498t.setLayoutManager(new C1852v0(this, this.baseActivity, 1, false));
                c1856x0.addAll((List) ((CheckoutVendor.Product) this.arrayList.get(i)).products);
            }
            productPrice = aVar.f7501w;
            productPrice.setVisibility(View.GONE);
            aVar.f7503y.setVisibility(View.GONE);
            CheckoutVendorAdapter c1856x02 = new CheckoutVendorAdapter(this.baseActivity);
            aVar.f7498t.setAdapter(c1856x02);
            //aVar.f7498t.setLayoutManager(new C1852v0(this, this.baseActivity, 1, false));
            c1856x02.addAll((List) ((CheckoutVendor.Product) this.arrayList.get(i)).products);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return i == 1 ? new a(from.inflate(R.layout.item_cart_discount, viewGroup, false)) : new b(from.inflate(R.layout.item_product_cart, viewGroup, false));
    }
}
