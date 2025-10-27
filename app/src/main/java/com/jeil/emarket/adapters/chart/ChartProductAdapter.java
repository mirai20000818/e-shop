package com.jeil.emarket.adapters.chart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
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
import com.jeil.emarket.model.vendor.ChartProduct;


/* renamed from: b.f.a.b.d.f */

public class ChartProductAdapter extends BaseMainAdapter<ChartProduct, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7190f;

    /* renamed from: b.f.a.b.d.f$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f7191A;


        public final TextView f7192B;

        /* renamed from: t */
        public final TextView f7193t;

        /* renamed from: u */
        public final TextView f7194u;

        /* renamed from: v */
        public final TextView f7195v;

        /* renamed from: w */
        public final LinearLayoutCompat f7196w;

        /* renamed from: x */
        public final LinearLayoutCompat f7197x;

        /* renamed from: y */
        public final PriceText f7198y;

        /* renamed from: z */
        public final PriceText f7199z;
        private final Activity f3933a = null;
        public a(View view) {
            super(view);
            this.f7193t = (TextView) this.f3933a.findViewById(R.id.tv_product_id);
            this.f7194u = (TextView) this.f3933a.findViewById(R.id.tv_product_name);
            this.f7195v = (TextView) this.f3933a.findViewById(R.id.tv_views_count);
            this.f7196w = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpf);
            this.f7197x = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpw);
            this.f7198y = (PriceText) this.f3933a.findViewById(R.id.pt_kpf_sale_total);
            this.f7199z = (PriceText) this.f3933a.findViewById(R.id.pt_kpw_sale_total);
            this.f7191A = (TextView) this.f3933a.findViewById(R.id.tv_stock);
            this.f7192B = (TextView) this.f3933a.findViewById(R.id.tv_category_name);
        }
    }

    /* renamed from: b.f.a.b.d.f$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public ChartProductAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7190f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((ChartProduct) this.arrayList.get(i)).type == null || !((ChartProduct) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        java.lang.String m217a;
        TextView textView;
        Resources resources;
        int i2;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        ChartProduct chartProduct = (ChartProduct) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            TextView textView2 = aVar.f7193t;
            java.lang.String str = chartProduct.sku;
            if (str == null || str.equals("")) {
                m217a = Util.m217a(chartProduct.f12433id);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(Util.m217a(chartProduct.f12433id));
                sb.append(" (");
                CustomString.m3171a(this.baseActivity, R.string.product_sku_comma, sb, " ");
                m217a = CustomString.m3160a(sb, chartProduct.sku, ")");
            }
            textView2.setText(m217a);
            aVar.f7194u.setText(chartProduct.name);
            TextView textView3 = aVar.f7195v;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Util.m218a(chartProduct.views, false));
            CustomString.m3171a(this.baseActivity, R.string.person_unit, sb2, " (");
            CustomString.m3171a(this.baseActivity, R.string.sold_amount_comma, sb2, " ");
            sb2.append(chartProduct.sold);
            sb2.append(this.baseActivity.getResources().getString(R.string.count_unit));
            sb2.append(")");
            textView3.setText(sb2.toString());
            aVar.f7192B.setText(Util.m328c(chartProduct.categoryId));
            aVar.f7198y.setHidePriceNumber(false);
            aVar.f7199z.setHidePriceNumber(false);
            if (chartProduct.orderTotal.kpf > 0.0f) {
                aVar.f7196w.setVisibility(View.VISIBLE);
                aVar.f7198y.setPrice(Util.m303b(chartProduct.orderTotal.kpf));
            } else {
                aVar.f7196w.setVisibility(View.GONE);
            }
            if (chartProduct.orderTotal.kpw > 0.0f) {
                aVar.f7197x.setVisibility(View.VISIBLE);
                aVar.f7199z.setPrice(Util.m303b(chartProduct.orderTotal.kpw));
            } else {
                aVar.f7197x.setVisibility(View.GONE);
            }
            if (chartProduct.stock == 0) {
                TextView textView4 = aVar.f7191A;
                StringBuilder sb3 = new StringBuilder();
                CustomString.m3171a(this.baseActivity, R.string.empty_stock, sb3, " (");
                CustomString.m3171a(this.baseActivity, R.string.order_count_comma, sb3, " ");
                sb3.append(Util.m218a(chartProduct.orders, false));
                sb3.append(this.baseActivity.getResources().getString(R.string.count_unit));
                sb3.append(")");
                textView4.setText(sb3.toString());
                textView = aVar.f7191A;
                resources = this.baseActivity.getResources();
                i2 = R.color.pink;
            } else {
                TextView textView5 = aVar.f7191A;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(Util.m218a(chartProduct.stock, false));
                CustomString.m3171a(this.baseActivity, R.string.count_unit, sb4, " (");
                CustomString.m3171a(this.baseActivity, R.string.order_count_comma, sb4, " ");
                sb4.append(Util.m218a(chartProduct.orders, false));
                sb4.append(this.baseActivity.getResources().getString(R.string.count_unit));
                sb4.append(")");
                textView5.setText(sb4.toString());
                textView = aVar.f7191A;
                resources = this.baseActivity.getResources();
                i2 = R.color.dark;
            }
            textView.setTextColor(resources.getColor(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7190f.inflate(R.layout.item_chart_product_shimmer, viewGroup, false)) : new a(this.f7190f.inflate(R.layout.item_chart_product, viewGroup, false));
    }
}
