package com.jeil.emarket.adapters.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.account.ShippingDetailActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.VendorShipping;

import java.util.Date;


/* renamed from: b.f.a.b.g.d1 */

public class VendorShippingAdapter extends BaseMainAdapter<VendorShipping, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public java.lang.String f7299f;

    /* renamed from: g */
    public final LayoutInflater f7300g;

    /* renamed from: b.f.a.b.g.d1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final LinearLayoutCompat f7301t;

        public a(View view) {
            super(view);
            this.f7301t = (LinearLayoutCompat) view.findViewById(R.id.llc_shipping_item);
        }
    }

    /* renamed from: b.f.a.b.g.d1$b */
    public static class b extends RecyclerView.ViewHolder {


        public final FrameLayout f7302A;


        public final LinearLayoutCompat f7303B;

        /* renamed from: t */
        public final MaterialRippleLayout f7304t;

        /* renamed from: u */
        public final TextView f7305u;

        /* renamed from: v */
        public final TextView f7306v;

        /* renamed from: w */
        public final TextView f7307w;

        /* renamed from: x */
        public final LinearLayoutCompat f7308x;

        /* renamed from: y */
        public final TextView f7309y;

        /* renamed from: z */
        public final TextView f7310z;

        public b(View view) {
            super(view);
            this.f7306v = (TextView) view.findViewById(R.id.ctv_shipping_address);
            this.f7307w = (TextView) view.findViewById(R.id.ctv_shipping_expected_at);
            this.f7305u = (TextView) view.findViewById(R.id.ctv_order_id);
            this.f7309y = (TextView) view.findViewById(R.id.ctv_completed_at);
            this.f7303B = (LinearLayoutCompat) view.findViewById(R.id.llc_track_dot);
            this.f7310z = (TextView) view.findViewById(R.id.tv_track_circle);
            this.f7304t = (MaterialRippleLayout) view.findViewById(R.id.mrl_item);
            this.f7308x = (LinearLayoutCompat) view.findViewById(R.id.llc_shipping_products);
            this.f7302A = (FrameLayout) view.findViewById(R.id.fl_content_wrapper);
        }
    }

    public VendorShippingAdapter(BaseActivity activityC1391g1, java.lang.String str) {
        super(activityC1391g1);
        this.f7299f = str;
        this.f7300g = LayoutInflater.from(activityC1391g1);
    }


    public  void m4441a(int i, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), ShippingDetailActivity.class);
        intent.putExtra("id", ((VendorShipping) this.arrayList.get(i)).f12453id);
        this.baseActivity.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((VendorShipping) this.arrayList.get(i)).type == null || !((VendorShipping) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "ResourceType"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        int i2;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        VendorShipping vendorShipping = (VendorShipping) this.arrayList.get(i);
        int i3 = -1;
        int i4 = -2;
        if (!(recyclerViewViewHolder instanceof b)) {
            if (recyclerViewViewHolder instanceof a) {
                a aVar = (a) recyclerViewViewHolder;
                if (this.f7299f.equals("completed")) {
                    LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
                    c0541a.setMargins(Util.dp2px((Context) this.baseActivity, 10), i == 0 ? Util.dp2px((Context) this.baseActivity, 10) : 0, Util.dp2px((Context) this.baseActivity, 10), Util.dp2px((Context) this.baseActivity, 10));
                    aVar.f7301t.setLayoutParams(c0541a);
                    return;
                }
                return;
            }
            return;
        }
        b bVar = (b) recyclerViewViewHolder;
        TextView textView = bVar.f7306v;
        StringBuilder sb = new StringBuilder();
        sb.append(vendorShipping.vendorName);
        sb.append(" -> ");
        CustomString.m3175a(sb, vendorShipping.district, textView);
        int i5 = 8;
        if (this.f7299f.equals("shipping")) {
            TextView textView2 = bVar.f7307w;
            StringBuilder sb2 = new StringBuilder();
            CustomString.m3171a(this.baseActivity, R.string.shipping_expected_at, sb2, " ");
            sb2.append(Util.m307b(vendorShipping.deliveryTime));
            textView2.setText(sb2.toString());
        } else {
            TextView textView3 = bVar.f7309y;
            Date date = vendorShipping.completedAt;
            long time = (new Date().getTime() - date.getTime()) / 1000;
            java.lang.String format = new java.text.SimpleDateFormat("hh:mm:ss").format(date);
            long j = 86400;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.baseActivity.getResources().getString(time < j ? R.string.today : R.string.yesterday));
            sb3.append(" ");
            sb3.append(format);
            textView3.setText(sb3.toString());
            CustomString.m3175a(CustomString.format("#"), vendorShipping.displayOrderId, bVar.f7305u);
            if (i == 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, Util.dp2px((Context) this.baseActivity, 13), 0, 0);
                bVar.f7302A.setLayoutParams(layoutParams);
                bVar.f7303B.setVisibility(View.GONE);
                bVar.f7310z.setVisibility(View.VISIBLE);
            }
        }
        bVar.f7308x.removeAllViews();
        int i6 = 0;
        while (i6 < vendorShipping.items.size()) {
            TextView textView4 = new TextView(this.baseActivity);
            LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(i3, i4);
            textView4.setText(vendorShipping.items.get(i6).name + " × " + vendorShipping.items.get(i6).quantity);
            textView4.setTextColor(this.baseActivity.getResources().getColor(R.color.dark));
            textView4.setTextSize(1, 12.5f);
            textView4.setLineHeight(Util.dp2px((Context) this.baseActivity, 20));
            if (this.f7299f.equals("shipping")) {
               // c0541a2.setMargins(r7, r7, r7, Util.dp2px((Context) this.baseActivity, i5));
                textView4.setLayoutParams(c0541a2);
                bVar.f7308x.addView(textView4);
            } else {
                LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.baseActivity);
                LinearLayoutCompat.LayoutParams c0541a3 = new LinearLayoutCompat.LayoutParams(i3, i4);
                //c0541a3.setMargins(r7, r7, r7, Util.dp2px((Context) this.baseActivity, i5));
                linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
                linearLayoutCompat.setLayoutParams(c0541a3);
                linearLayoutCompat.addView(textView4);
                if (vendorShipping.items.get(i6).sku != null && !vendorShipping.items.get(i6).sku.isEmpty()) {
                    TextView textView5 = new TextView(this.baseActivity);
                    //c0541a2.setMargins(r7, Util.dp2px((Context) this.baseActivity, 6), r7, r7);
                    textView5.setLayoutParams(c0541a2);
                    StringBuilder sb4 = new StringBuilder();
                    CustomString.m3171a(this.baseActivity, R.string.product_sku_comma, sb4, " ");
                    CustomString.m3175a(sb4, vendorShipping.items.get(i6).sku, textView5);
                    textView5.setTextColor(this.baseActivity.getResources().getColor(R.color.light));
                    textView5.setTextSize(1, 12.5f);
                    textView5.setLineHeight(Util.dp2px((Context) this.baseActivity, 20));
                    linearLayoutCompat.addView(textView5);
                }
                if (vendorShipping.items.get(i6).f12454id != 0) {
                    TextView textView6 = new TextView(this.baseActivity);
                    i2 = 0;
                    c0541a2.setMargins(0, Util.dp2px((Context) this.baseActivity, 6), 0, 0);
                    textView6.setLayoutParams(c0541a2);
                    StringBuilder sb5 = new StringBuilder();
                    CustomString.m3171a(this.baseActivity, R.string.product_id_comma, sb5, " ");
                    sb5.append(vendorShipping.items.get(i6).f12454id);
                    textView6.setText(sb5.toString());
                    textView6.setTextColor(this.baseActivity.getResources().getColor(R.color.light));
                    textView6.setTextSize(1, 12.5f);
                    textView6.setLineHeight(Util.dp2px((Context) this.baseActivity, 20));
                    linearLayoutCompat.addView(textView6);
                } else {
                    i2 = 0;
                }
                bVar.f7308x.addView(linearLayoutCompat);
                //r7 = i2;
            }
            i6++;
            i3 = -1;
            i4 = -2;
            i5 = 8;
        }
        if (this.f7299f.equals("shipping")) {
            bVar.f7304t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VendorShippingAdapter.this.m4441a(i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new a(this.f7300g.inflate(R.layout.item_shimmer_shipping, viewGroup, false));
        }
        return new b(this.f7300g.inflate(this.f7299f.equals("shipping") ? R.layout.item_shipping : R.layout.item_shipping_completed, viewGroup, false));
    }
}
