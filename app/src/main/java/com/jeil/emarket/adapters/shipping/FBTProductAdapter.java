package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.FBT;

/* renamed from: b.f.a.b.k.m1 */

public class FBTProductAdapter extends BaseMainAdapter<FBT.Product, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7950f;

    /* renamed from: g */
    public final LayoutInflater f7951g;

    /* renamed from: h */
    public java.lang.String f7952h;

    /* renamed from: b.f.a.b.k.m1$a */
    public static class a extends RecyclerView.ViewHolder {

        
        public final EditForm f7953A;


        public final ProductPrice f7954B;


        public final ProductPrice f7955C;


        public final MaterialRippleLayout f7956D;

        /* renamed from: t */
        public final AppCompatImageView f7957t;

        /* renamed from: u */
        public final LinearLayoutCompat f7958u;

        /* renamed from: v */
        public final LinearLayoutCompat f7959v;

        /* renamed from: w */
        public final TextView f7960w;

        /* renamed from: x */
        public final TextView f7961x;

        /* renamed from: y */
        public final TextView f7962y;

        /* renamed from: z */
        public final TextView f7963z;

        public a(View view) {
            super(view);
            this.f7957t = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f7958u = (LinearLayoutCompat) view.findViewById(R.id.llc_product_sku_item);
            this.f7959v = (LinearLayoutCompat) view.findViewById(R.id.ll_stock);
            this.f7960w = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7961x = (TextView) view.findViewById(R.id.tv_product_sku);
            this.f7962y = (TextView) view.findViewById(R.id.tv_product_id);
            this.f7963z = (TextView) view.findViewById(R.id.tv_stock);
            this.f7953A = (EditForm) view.findViewById(R.id.ef_discount_percent);
            this.f7954B = (ProductPrice) view.findViewById(R.id.pp_variable_price);
            this.f7955C = (ProductPrice) view.findViewById(R.id.pp_variable_sale_price);
            this.f7956D = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete);
        }
    }

    /* renamed from: b.f.a.b.k.m1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public FBTProductAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2, java.lang.String str) {
        super(activityC1391g1);
        this.f7951g = LayoutInflater.from(activityC1391g1);
        this.f7950f = baseInterface2;
        this.f7952h = str;
    }

    
    public  void m4554a(int i, FBT.Product product, View view) {
        this.f7950f.mo4808a(i, java.lang.String.valueOf(product.f12437id), !this.f7952h.equals("products") ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((FBT.Product) this.arrayList.get(i)).type == null || !((FBT.Product) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            final FBT.Product product = (FBT.Product) this.arrayList.get(i);
            ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(product.image, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL))).into((ImageView) aVar.f7957t);
            aVar.f7960w.setText(product.name);
            CustomString.m3174a(new StringBuilder(), product.f12437id, "", aVar.f7962y);
            if (product.sku.isEmpty()) {
                aVar.f7958u.setVisibility(View.GONE);
            } else {
                aVar.f7958u.setVisibility(View.VISIBLE);
                aVar.f7961x.setText(product.sku);
            }
            if (this.f7952h.equals("products")) {
                aVar.f7959v.setVisibility(View.VISIBLE);
                TextView textView = aVar.f7963z;
                StringBuilder sb = new StringBuilder();
                sb.append(product.stock);
                CustomString.m3170a(this.baseActivity, R.string.count_unit, sb, textView);
            } else {
                aVar.f7959v.setVisibility(View.GONE);
            }
            aVar.f7954B.setCurrency(product.currency);
            if (product.maxPrice > 0.0f) {
                aVar.f7954B.m6938a(Util.m327c(product.minPrice), Util.m327c(product.maxPrice));
                aVar.f7954B.m6939a(false);
            } else {
                aVar.f7954B.setPtSalePrice(Util.m327c(product.price));
            }
            aVar.f7955C.setCurrency(product.currency);
            if (product.maxPrice > 0.0f) {
                aVar.f7955C.m6938a(Util.m327c(((100.0f - product.discount) * product.minPrice) / 100.0f), Util.m327c(((100.0f - product.discount) * product.maxPrice) / 100.0f));
                aVar.f7955C.m6939a(false);
            } else {
                aVar.f7955C.setPtSalePrice(Util.m327c(((100.0f - product.discount) * product.price) / 100.0f));
            }
            aVar.f7953A.setText(product.discount + "");
            aVar.f7953A.setEditListener(new FBTProductTextWatcher(this, aVar, i, product));
            aVar.f7956D.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FBTProductAdapter.this.m4554a(i, product, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7951g.inflate(R.layout.item_shimmer_fbt_detail, viewGroup, false)) : new a(this.f7951g.inflate(R.layout.item_fbt_detail, viewGroup, false));
    }
}
