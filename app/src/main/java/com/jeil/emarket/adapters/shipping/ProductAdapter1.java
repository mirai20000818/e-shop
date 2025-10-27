package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.VendorProductEditActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.frag.analy.staff.C2649r3;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.Product;
import com.jeil.emarket.viewmodel.ProductTotalVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/* renamed from: b.f.a.b.k.d2 */

public class ProductAdapter1 extends BaseMainAdapter<Product, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7841f;

    /* renamed from: g */
    public C2649r3 f7842g;

    /* renamed from: h */
    public final LayoutInflater f7843h;

    
    public java.lang.String f7844i;

    /* renamed from: b.f.a.b.k.d2$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f7845A;


        public final TextView f7846B;


        public final MaterialRippleLayout f7847C;


        public final MaterialRippleLayout f7848D;

        
        public final LinearLayoutCompat f7849E;

        /* renamed from: F */
        public final LinearLayoutCompat f7850F;

        /* renamed from: t */
        public final MaterialRippleLayout f7851t;

        /* renamed from: u */
        public final AppCompatImageView f7852u;

        /* renamed from: v */
        public final TextView f7853v;

        /* renamed from: w */
        public final LinearLayoutCompat f7854w;

        /* renamed from: x */
        public final TextView f7855x;

        /* renamed from: y */
        public final TextView f7856y;

        /* renamed from: z */
        public final ProductPrice f7857z;

        public a(View view) {
            super(view);
            this.f7851t = (MaterialRippleLayout) view.findViewById(R.id.mrl_product_item);
            this.f7852u = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f7853v = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7854w = (LinearLayoutCompat) view.findViewById(R.id.llc_product_sku_item);
            this.f7855x = (TextView) view.findViewById(R.id.tv_product_sku);
            this.f7856y = (TextView) view.findViewById(R.id.tv_product_id);
            this.f7857z = (ProductPrice) view.findViewById(R.id.pp_product_price);
            this.f7845A = (TextView) view.findViewById(R.id.tv_out_of_stock);
            this.f7846B = (TextView) view.findViewById(R.id.tv_product_stock);
            this.f7847C = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete);
            this.f7848D = (MaterialRippleLayout) view.findViewById(R.id.mrl_restore);
            this.f7849E = (LinearLayoutCompat) view.findViewById(R.id.ll_trash_action);
            this.f7850F = (LinearLayoutCompat) view.findViewById(R.id.ll_trash_shimmer_action);
        }
    }

    /* renamed from: b.f.a.b.k.d2$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public ProductAdapter1(BaseActivity activityC1391g1, C2649r3 c2649r3, java.lang.String str, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7842g = c2649r3;
        this.f7843h = LayoutInflater.from(activityC1391g1);
        this.f7844i = str;
        this.f7841f = baseInterface2;
    }


    public  void m4534a(DialogC2001j dialogC2001j, int i, Product product, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            this.f7841f.mo4808a(i, java.lang.String.valueOf(product.productId), 1);
        }
    }


    public  void m4535a(final Product product, final int i, View view) {
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = java.lang.String.format(this.baseActivity.getResources().getString(R.string.delete_product_warning), product.name);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.k.d1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                ProductAdapter1.this.m4537a(product, dialogError, i);
            }
        });
    }


    public  void m4536a(Product product, View view) {
        Intent intent = new Intent(this.baseActivity, VendorProductEditActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("productId", product.productId);
        intent.putExtra("status", this.f7844i);
        this.f7842g.startActivityForResult(intent, 100);
    }


    public  void m4537a(final Product product, DialogError dialogError, final int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("productIds", product.productId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ProductTotalVM.m5475c(this.baseActivity, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        dialogError.dismiss();
        ProductTotalVM.f10239g.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.f1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProductAdapter1.this.m4534a(dialogC2001j, i, product, (Integer) obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((Product) this.arrayList.get(i)).type == null || !((Product) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }


    public  void m4538b(DialogC2001j dialogC2001j, int i, Product product, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            this.f7841f.mo4808a(i, java.lang.String.valueOf(product.productId), 1);
        }
    }


    public  void m4539b(final Product product, final int i, View view) {
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = java.lang.String.format(this.baseActivity.getResources().getString(R.string.restore_product_warning), product.name);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.k.h1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                ProductAdapter1.this.m4540b(product, dialogError, i);
            }
        });
    }


    public  void m4540b(final Product product, DialogError dialogError, final int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(product.productId));
            jSONObject.put("productIds", arrayList);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ProductTotalVM.m5479e(this.baseActivity, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.baseActivity);
        dialogC2001j.show();
        dialogError.dismiss();
        ProductTotalVM.f10239g.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.i1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProductAdapter1.this.m4538b(dialogC2001j, i, product, (Integer) obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Product product = (Product) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            RequestManager m3287a = Glide.with((FragmentActivity) this.baseActivity);
            Product.Image image = product.image;
            ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, m3287a.load(image != null ? Util.m306b(image.url, "xs") : this.baseActivity.getResources().getDrawable(R.drawable.ic_placeholder)).diskCacheStrategy(DiskCacheStrategy.ALL))).into((ImageView) aVar.f7852u);
            aVar.f7853v.setText(product.name);
            java.lang.String str = product.sku;
            if (str == null || str.isEmpty()) {
                aVar.f7854w.setVisibility(View.GONE);
            } else {
                aVar.f7854w.setVisibility(View.VISIBLE);
                aVar.f7855x.setText(product.sku);
            }
            CustomString.m3174a(new StringBuilder(), product.productId, "", aVar.f7856y);
            aVar.f7857z.setCurrency(product.currency);
            aVar.f7857z.m6941c(false);
            if (product.type.equals("variable")) {
                aVar.f7857z.m6938a(Util.m327c(product.minPrice), Util.m327c(product.maxPrice));
            } else {
                float f = product.salePrice;
                if (f <= 0.0f || f == product.regularPrice) {
                    aVar.f7857z.setPtSalePrice(Util.m327c(product.regularPrice));
                } else {
                    aVar.f7857z.setPtSalePrice(Util.m327c(f));
                    aVar.f7857z.setRegularPriceSize(13);
                    aVar.f7857z.setRegularPrice(Util.m327c(product.regularPrice));
                }
            }
            int i2 = product.stock;
            if (i2 > 0) {
                aVar.f7846B.setVisibility(View.VISIBLE);
                aVar.f7845A.setVisibility(View.GONE);
                TextView textView = aVar.f7846B;
                StringBuilder sb = new StringBuilder();
                CustomString.m3171a(this.baseActivity, R.string.stock, sb, ": ");
                sb.append(product.stock);
                CustomString.m3170a(this.baseActivity, R.string.count, sb, textView);
            } else if (i2 == 0) {
                aVar.f7846B.setVisibility(View.GONE);
                aVar.f7845A.setVisibility(View.VISIBLE);
            } else {
                aVar.f7846B.setVisibility(View.VISIBLE);
                aVar.f7845A.setVisibility(View.GONE);
                TextView textView2 = aVar.f7846B;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(product.stock);
                CustomString.m3170a(this.baseActivity, R.string.count, sb2, textView2);
                aVar.f7846B.setTextColor(this.baseActivity.getResources().getColor(R.color.danger));
            }
            aVar.f7851t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.c1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProductAdapter1.this.m4536a(product, view);
                }
            });
            if (!this.f7844i.equals("trash")) {
                aVar.f7849E.setVisibility(View.GONE);
                aVar.f7850F.setVisibility(View.GONE);
            } else {
                aVar.f7849E.setVisibility(View.VISIBLE);
                aVar.f7850F.setVisibility(View.VISIBLE);
                aVar.f7847C.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.e1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProductAdapter1.this.m4535a(product, i, view);
                    }
                });
                aVar.f7848D.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.g1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProductAdapter1.this.m4539b(product, i, view);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7843h.inflate(R.layout.item_shimmer_vendor_product, viewGroup, false)) : new a(this.f7843h.inflate(R.layout.item_vendor_product, viewGroup, false));
    }
}
