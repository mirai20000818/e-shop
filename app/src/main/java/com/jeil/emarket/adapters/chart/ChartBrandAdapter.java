package com.jeil.emarket.adapters.chart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.ChartBrand;

/* renamed from: b.f.a.b.d.b */

public class ChartBrandAdapter extends BaseMainAdapter<ChartBrand, ChartBrandAdapter.a> {

    /* renamed from: b.f.a.b.d.b$a */
    public static class a extends RecyclerView.ViewHolder {


        private final Activity f3933a = null;
        public Boolean f7155A;

        /* renamed from: t */
        public final TextView f7156t;

        /* renamed from: u */
        public final TextView f7157u;

        /* renamed from: v */
        public final TextView f7158v;

        /* renamed from: w */
        public final TextView f7159w;

        /* renamed from: x */
        public final TextView f7160x;

        /* renamed from: y */
        public final MaterialRippleLayout f7161y;

        /* renamed from: z */
        public final LinearLayoutCompat f7162z;

        public a(View view) {
            super(view);
            this.f7155A = false;
            this.f7156t = (TextView) this.f3933a.findViewById(R.id.tv_brand_name);
            this.f7157u = (TextView) this.f3933a.findViewById(R.id.tv_sale_total);
            this.f7158v = (TextView) this.f3933a.findViewById(R.id.tv_products_sold);
            this.f7159w = (TextView) this.f3933a.findViewById(R.id.tv_products);
            this.f7160x = (TextView) this.f3933a.findViewById(R.id.tv_orders);
            this.f7161y = (MaterialRippleLayout) this.f3933a.findViewById(R.id.mrl_item_title);
            this.f7162z = (LinearLayoutCompat) this.f3933a.findViewById(R.id.llc_expand_content);
        }
    }

    public ChartBrandAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    
    public static  void m4429a(a aVar, View view) {
        aVar.f7155A = Boolean.valueOf(!aVar.f7155A.booleanValue());
        boolean booleanValue = aVar.f7155A.booleanValue();
        LinearLayoutCompat linearLayoutCompat = aVar.f7162z;
        if (booleanValue) {
            //Util.m313b((View) linearLayoutCompat);
        } else {
            Util.m243a((View) linearLayoutCompat);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(a viewHolder, int i) {
        final a aVar = (a) viewHolder;
        aVar.f7156t.setText(((ChartBrand) this.arrayList.get(i)).name);
        aVar.f7157u.setText(Util.m303b(((ChartBrand) this.arrayList.get(i)).orderTotal));
        TextView textView = aVar.f7158v;
        StringBuilder sb = new StringBuilder();
        sb.append(Util.m218a(((ChartBrand) this.arrayList.get(i)).productsSold, false));
        CustomString.m3170a(this.baseActivity, R.string.count_unit, sb, textView);
        TextView textView2 = aVar.f7159w;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Util.m218a(((ChartBrand) this.arrayList.get(i)).products, false));
        CustomString.m3170a(this.baseActivity, R.string.count_unit, sb2, textView2);
        TextView textView3 = aVar.f7160x;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(Util.m218a(((ChartBrand) this.arrayList.get(i)).orders, false));
        CustomString.m3170a(this.baseActivity, R.string.count_unit, sb3, textView3);
        if (i == 0) {
           // Util.m313b((View) aVar.f7162z);
            aVar.f7155A = true;
        } else {
            Util.m243a((View) aVar.f7162z);
        }
        aVar.f7161y.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.d.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                //ChartBrandAdapter.m4429a(ChartBrandAdapter.a.this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(CustomString.m3150a(viewGroup, R.layout.item_chart_brand, viewGroup, false));
    }
}
