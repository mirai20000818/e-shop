package com.jeil.emarket.adapters.chart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.ChartOrder;


/* renamed from: b.f.a.b.d.e */

public class ChartOrderAdapter extends BaseMainAdapter<ChartOrder, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7181f;

    /* renamed from: b.f.a.b.d.e$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f7182A;

        /* renamed from: t */
        public final TextView f7183t;

        /* renamed from: u */
        public final TextView f7184u;

        /* renamed from: v */
        public final TextView f7185v;

        /* renamed from: w */
        public final TextView f7186w;

        /* renamed from: x */
        public final PriceText f7187x;

        /* renamed from: y */
        public final PriceText f7188y;

        /* renamed from: z */
        public final TextView f7189z;
        private final Activity f3933a = null;
        public a(View view) {
            super(view);
            this.f7183t = (TextView) this.f3933a.findViewById(R.id.tv_order_id);
            this.f7184u = (TextView) this.f3933a.findViewById(R.id.tv_requested_at);
            this.f7185v = (TextView) this.f3933a.findViewById(R.id.tv_customer);
            this.f7187x = (PriceText) this.f3933a.findViewById(R.id.pt_kpf_sale_total);
            this.f7188y = (PriceText) this.f3933a.findViewById(R.id.pt_kpw_sale_total);
            this.f7189z = (TextView) this.f3933a.findViewById(R.id.tv_order_product_count);
            this.f7182A = (TextView) this.f3933a.findViewById(R.id.tv_product_name);
            this.f7186w = (TextView) this.f3933a.findViewById(R.id.tv_status);
        }
    }

    /* renamed from: b.f.a.b.d.e$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public ChartOrderAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7181f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((ChartOrder) this.arrayList.get(i)).type == null || !((ChartOrder) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        java.lang.String str;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        ChartOrder chartOrder = (ChartOrder) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.f7183t.setText(chartOrder.displayOrderId + "");
            aVar.f7184u.setText(Util.m307b(chartOrder.createdAt));
            aVar.f7185v.setText(chartOrder.customer);
            aVar.f7187x.setHidePriceNumber(false);
            aVar.f7188y.setHidePriceNumber(false);
            SubOrder.TotalAmount totalAmount = chartOrder.total;
            if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
                aVar.f7188y.f12264t = true;
            }
            if (chartOrder.total.kpf > 0.0f) {
                aVar.f7187x.setVisibility(View.VISIBLE);
                aVar.f7187x.setPrice(Util.m303b(chartOrder.total.kpf));
            } else {
                aVar.f7187x.setVisibility(View.GONE);
            }
            if (chartOrder.total.kpw > 0.0f) {
                aVar.f7188y.setVisibility(View.VISIBLE);
                aVar.f7188y.setPrice(Util.m303b(chartOrder.total.kpw));
            } else {
                aVar.f7188y.setVisibility(View.GONE);
            }
            SubOrder.TotalAmount totalAmount2 = chartOrder.total;
            if (totalAmount2.kpf == 0.0f && totalAmount2.kpw == 0.0f) {
                aVar.f7187x.setVisibility(View.VISIBLE);
                aVar.f7187x.setPrice("0");
            }
            TextView textView = aVar.f7189z;
            StringBuilder m3163a = CustomString.format(" (");
            m3163a.append(chartOrder.productsCount);
            m3163a.append(this.baseActivity.getResources().getString(R.string.count_product));
            m3163a.append(")");
            textView.setText(m3163a.toString());
            TextView textView2 = aVar.f7182A;
            if (chartOrder.typesCount > 1) {
                str = chartOrder.productName + java.lang.String.format(this.baseActivity.getResources().getString(R.string.and_count_types), Integer.valueOf(chartOrder.typesCount - 1));
            } else {
                str = chartOrder.productName;
            }
            textView2.setText(str);
            aVar.f7186w.setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), chartOrder.status.equals("readyToShip") ? "shipping" : chartOrder.status, "color", this.baseActivity.getResources()));
            aVar.f7186w.setText(Util.m335d(this.baseActivity, chartOrder.status));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7181f.inflate(R.layout.item_chart_order_shimmer, viewGroup, false)) : new a(this.f7181f.inflate(R.layout.item_chart_order, viewGroup, false));
    }
}
