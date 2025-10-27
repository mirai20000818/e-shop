package com.jeil.emarket.adapters.shipping;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.vendor.VendorActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.vendor.VendorLevel;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.viewmodel.ProductVendorVM;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.b.k.c2 */

public class VendorAdapter extends BaseMainAdapter<Vendor, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7824f;

    /* renamed from: b.f.a.b.k.c2$a */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* renamed from: b.f.a.b.k.c2$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ImageView f7825t;

        /* renamed from: u */
        public final TextView f7826u;

        /* renamed from: v */
        public final TextView f7827v;

        /* renamed from: w */
        public final TextView f7828w;

        /* renamed from: x */
        public final VendorLevel f7829x;

        /* renamed from: y */
        public final ImageView f7830y;

        /* renamed from: z */
        public final MaterialRippleLayout f7831z;

        public b(View view) {
            super(view);
            this.f7826u = (TextView) view.findViewById(R.id.tv_vendor_name);
            this.f7825t = (ImageView) view.findViewById(R.id.iv_vendor_card);
            this.f7827v = (TextView) view.findViewById(R.id.tv_enter_years);
            this.f7828w = (TextView) view.findViewById(R.id.tv_products_count);
            this.f7829x = (VendorLevel) view.findViewById(R.id.vl_vendor_level);
            this.f7830y = (ImageView) view.findViewById(R.id.iv_wishlist);
            this.f7831z = (MaterialRippleLayout) view.findViewById(R.id.mrl_vendor_item);
        }
    }

    public VendorAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7824f = LayoutInflater.from(activityC1391g1);
    }


    public static  void m4532a(b bVar, Vendor vendor, List list) {
        if (list != null) {
            ((AppCompatImageView) bVar.f7830y.findViewById(R.id.iv_wishlist)).setImageResource(ProductVendorVM.m5577a(vendor.f12449id) ? R.drawable.ic_wishlist_full : R.drawable.ic_wishlist_empty);
        }
    }


    public  void m4533a(Vendor vendor, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), VendorActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id", vendor.f12449id);
        this.baseActivity.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((Vendor) this.arrayList.get(i)).type == null || !((Vendor) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof b) {
            final Vendor vendor = (Vendor) this.arrayList.get(i);
            final b bVar = (b) recyclerViewViewHolder;
            //((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.vendor, Glide.with((FragmentActivity) this.baseActivity).load(Util.m345e(vendor.card)).diskCacheStrategy(DiskCacheStrategy.ALL).m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) this.baseActivity, 5)), true))).into(bVar.f7825t);
            bVar.f7826u.setText(vendor.name);
            if (vendor.approvedAt != null) {
                Date date = null;
                try {
                    date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(vendor.approvedAt);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                //bVar.f7827v.setText(Util.m220a((Context) this.baseActivity, date));
            }
            bVar.f7828w.setText(java.lang.String.valueOf(vendor.productsCount));
            bVar.f7829x.setMedalSize(Util.dp2px((Context) this.baseActivity, 15));
            bVar.f7829x.m6978a(vendor.point, this.baseActivity);
            bVar.f7830y.setImageResource(ProductVendorVM.m5577a(vendor.f12449id) ? R.drawable.ic_wishlist_full : R.drawable.ic_wishlist_empty);
            bVar.f7830y.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
//                    Vendor vendor2 = Vendor.this;
//                    ProductVendorVM.m5576a(vendor2.f12449id, vendor2);
                }
            });
            ProductVendorVM.f10377e.observe(this.baseActivity, new Observer() { // from class: b.f.a.b.k.z0
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                   // VendorAdapter.m4532a(VendorAdapter.b.this, vendor, (List) obj);
                }
            });
            bVar.f7831z.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VendorAdapter.this.m4533a(vendor, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new a(this.f7824f.inflate(R.layout.item_shimmer_vendor_list, viewGroup, false)) : new b(this.f7824f.inflate(R.layout.item_vendor_list, viewGroup, false));
    }
}
