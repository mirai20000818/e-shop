package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.refund.RefundDetailActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.RefundRequestProduct;


/* renamed from: b.f.a.b.k.x1 */

public class RefundRequestProductAdapter extends BaseMainAdapter<RefundRequestProduct, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f8101f;

    /* renamed from: b.f.a.b.k.x1$a */
    public static class a extends RecyclerView.ViewHolder {


        public final MaterialRippleLayout f8102A;

        /* renamed from: t */
        public final TextView f8103t;

        /* renamed from: u */
        public final TextView f8104u;

        /* renamed from: v */
        public final TextView f8105v;

        /* renamed from: w */
        public final TextView f8106w;

        /* renamed from: x */
        public final TextView f8107x;

        /* renamed from: y */
        public final LinearLayoutCompat f8108y;

        /* renamed from: z */
        public final TextView f8109z;
        private final Activity f3933a = null;

        public a(View view) {
            super(view);
            this.f8103t = (TextView) view.findViewById(R.id.iv_type_dot);
            this.f8105v = (TextView) this.f3933a.findViewById(R.id.tv_request_id);
            this.f8104u = (TextView) this.f3933a.findViewById(R.id.tv_product_name);
            this.f8106w = (TextView) this.f3933a.findViewById(R.id.tv_status_badge);
            this.f8107x = (TextView) this.f3933a.findViewById(R.id.tv_product_sku);
            this.f8108y = (LinearLayoutCompat) this.f3933a.findViewById(R.id.llc_sku_item);
            this.f8109z = (TextView) this.f3933a.findViewById(R.id.tv_product_id);
            this.f8102A = (MaterialRippleLayout) this.f3933a.findViewById(R.id.mrl_action);
        }
    }

    /* renamed from: b.f.a.b.k.x1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public RefundRequestProductAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f8101f = LayoutInflater.from(activityC1391g1);
    }


    public  void m4564a(int i, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), RefundDetailActivity.class);
        intent.putExtra("id", ((RefundRequestProduct) this.arrayList.get(i)).f12416id);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((RefundRequestProduct) this.arrayList.get(i)).type == null || !((RefundRequestProduct) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        Resources resources;
        int i2;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            if (((RefundRequestProduct) this.arrayList.get(i)).type.equals("exchange")) {
                aVar.f8103t.setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), "requested", "color", this.baseActivity.getResources()));
            }
            TextView textView = aVar.f8105v;
            StringBuilder sb = new StringBuilder();
            if (((RefundRequestProduct) this.arrayList.get(i)).type.equals("exchange")) {
                resources = this.baseActivity.getResources();
                i2 = R.string.exchange;
            } else {
                resources = this.baseActivity.getResources();
                i2 = R.string.returnProduct;
            }
            sb.append(resources.getString(i2));
            sb.append(" (");
            sb.append(this.baseActivity.getResources().getString(R.string.no_comma));
            CustomString.m3174a(sb, ((RefundRequestProduct) this.arrayList.get(i)).f12416id, ")", textView);
            aVar.f8104u.setText(((RefundRequestProduct) this.arrayList.get(i)).item.name + " × " + ((RefundRequestProduct) this.arrayList.get(i)).item.quantity);
            if (((RefundRequestProduct) this.arrayList.get(i)).item.sku == null || ((RefundRequestProduct) this.arrayList.get(i)).item.sku.isEmpty()) {
                aVar.f8108y.setVisibility(View.GONE);
            } else {
                aVar.f8107x.setText(((RefundRequestProduct) this.arrayList.get(i)).item.sku);
                aVar.f8108y.setVisibility(View.VISIBLE);
            }
            aVar.f8109z.setText(Util.m217a(((RefundRequestProduct) this.arrayList.get(i)).item.productId));
            aVar.f8106w.setText(Util.m335d(this.baseActivity, ((RefundRequestProduct) this.arrayList.get(i)).status));
            aVar.f8106w.setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), ((RefundRequestProduct) this.arrayList.get(i)).status, "color", this.baseActivity.getResources()));
            if (((RefundRequestProduct) this.arrayList.get(i)).status.equals("testing")) {
                aVar.f8106w.setVisibility(View.GONE);
            }
            aVar.f8102A.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RefundRequestProductAdapter.this.m4564a(i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f8101f.inflate(R.layout.item_shimmer_vendor_refund, viewGroup, false)) : new a(this.f8101f.inflate(R.layout.item_vendor_refund, viewGroup, false));
    }
}
