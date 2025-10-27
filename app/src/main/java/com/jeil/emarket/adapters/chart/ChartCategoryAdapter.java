package com.jeil.emarket.adapters.chart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.ChartCategory;


/* renamed from: b.f.a.b.d.c */

public class ChartCategoryAdapter extends BaseMainAdapter<ChartCategory, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7163f;

    /* renamed from: b.f.a.b.d.c$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f7164t;

        /* renamed from: u */
        public final LinearLayoutCompat f7165u;

        /* renamed from: v */
        public final LinearLayoutCompat f7166v;

        /* renamed from: w */
        public final PriceText f7167w;

        /* renamed from: x */
        public final PriceText f7168x;

        /* renamed from: y */
        public final TextView f7169y;

        /* renamed from: z */
        public final TextView f7170z;
        private final Activity f3933a = null;

        public a(View view) {
            super(view);
            this.f7164t = (TextView) this.f3933a.findViewById(R.id.tv_category_name);
            this.f7165u = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpf);
            this.f7166v = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpw);
            this.f7167w = (PriceText) this.f3933a.findViewById(R.id.pt_kpf_sale_total);
            this.f7168x = (PriceText) this.f3933a.findViewById(R.id.pt_kpw_sale_total);
            this.f7169y = (TextView) this.f3933a.findViewById(R.id.tv_products_sold);
            this.f7170z = (TextView) this.f3933a.findViewById(R.id.tv_products);
        }
    }

    /* renamed from: b.f.a.b.d.c$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public ChartCategoryAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7163f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((ChartCategory) this.arrayList.get(i)).type == null || !((ChartCategory) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        ChartCategory chartCategory = (ChartCategory) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.f7164t.setText(Util.m328c(chartCategory.categoryId));
            aVar.f7167w.setHidePriceNumber(false);
            aVar.f7168x.setHidePriceNumber(false);
            if (chartCategory.orderTotal.kpf > 0.0f) {
                aVar.f7165u.setVisibility(View.VISIBLE);
                aVar.f7167w.setPrice(Util.m303b(chartCategory.orderTotal.kpf));
            } else {
                aVar.f7165u.setVisibility(View.GONE);
            }
            if (chartCategory.orderTotal.kpw > 0.0f) {
                aVar.f7166v.setVisibility(View.VISIBLE);
                aVar.f7168x.setPrice(Util.m303b(chartCategory.orderTotal.kpw));
            } else {
                aVar.f7166v.setVisibility(View.GONE);
            }
            TextView textView = aVar.f7169y;
            StringBuilder sb = new StringBuilder();
            sb.append(Util.m218a(chartCategory.productsSold, false));
            CustomString.m3171a(this.baseActivity, R.string.count_unit, sb, " (");
            CustomString.m3171a(this.baseActivity, R.string.cancelled_count_comma, sb, " ");
            sb.append(Util.m218a(chartCategory.countCancelled, false));
            sb.append(this.baseActivity.getResources().getString(R.string.count_unit));
            sb.append(")");
            textView.setText(sb.toString());
            TextView textView2 = aVar.f7170z;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Util.m218a(chartCategory.products, false));
            CustomString.m3170a(this.baseActivity, R.string.count_unit, sb2, textView2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7163f.inflate(R.layout.item_chart_category_shimmer, viewGroup, false)) : new a(this.f7163f.inflate(R.layout.item_chart_category, viewGroup, false));
    }
}
