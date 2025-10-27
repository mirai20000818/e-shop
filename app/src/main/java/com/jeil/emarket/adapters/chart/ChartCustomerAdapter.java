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
import com.jeil.emarket.components.pickerview.PickerViewObj;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.ChartCustomer;

/* renamed from: b.f.a.b.d.d */

public class ChartCustomerAdapter extends BaseMainAdapter<ChartCustomer, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7171f;

    /* renamed from: b.f.a.b.d.d$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f7172A;

        
        public final TextView f7173B;

        /* renamed from: t */
        public final TextView f7174t;

        /* renamed from: u */
        public final LinearLayoutCompat f7175u;

        /* renamed from: v */
        public final LinearLayoutCompat f7176v;

        /* renamed from: w */
        public final PriceText f7177w;

        /* renamed from: x */
        public final PriceText f7178x;

        /* renamed from: y */
        public final TextView f7179y;

        /* renamed from: z */
        public final TextView f7180z;
        private final Activity f3933a = null;
        public a(View view) {
            super(view);
            this.f7174t = (TextView) this.f3933a.findViewById(R.id.tv_customer_name);
            this.f7175u = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpf);
            this.f7176v = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpw);
            this.f7177w = (PriceText) this.f3933a.findViewById(R.id.pt_kpf_sale_total);
            this.f7178x = (PriceText) this.f3933a.findViewById(R.id.pt_kpw_sale_total);
            this.f7179y = (TextView) this.f3933a.findViewById(R.id.tv_orders);
            this.f7180z = (TextView) this.f3933a.findViewById(R.id.tv_logged_at);
            this.f7172A = (TextView) this.f3933a.findViewById(R.id.tv_ordered_at);
            this.f7173B = (TextView) this.f3933a.findViewById(R.id.tv_address);
        }
    }

    /* renamed from: b.f.a.b.d.d$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public ChartCustomerAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7171f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((ChartCustomer) this.arrayList.get(i)).type == null || !((ChartCustomer) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        ChartCustomer chartCustomer = (ChartCustomer) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.f7174t.setText(chartCustomer.name);
            aVar.f7177w.setHidePriceNumber(false);
            aVar.f7178x.setHidePriceNumber(false);
            if (chartCustomer.ordersTotal.kpf > 0.0f) {
                aVar.f7175u.setVisibility(View.VISIBLE);
                aVar.f7177w.setPrice(Util.m303b(chartCustomer.ordersTotal.kpf));
            } else {
                aVar.f7175u.setVisibility(View.GONE);
            }
            if (chartCustomer.ordersTotal.kpw > 0.0f) {
                aVar.f7176v.setVisibility(View.VISIBLE);
                aVar.f7178x.setPrice(Util.m303b(chartCustomer.ordersTotal.kpw));
            } else {
                aVar.f7176v.setVisibility(View.GONE);
            }
            TextView textView = aVar.f7179y;
            StringBuilder sb = new StringBuilder();
            sb.append(Util.m218a(chartCustomer.orders, false));
            CustomString.m3170a(this.baseActivity, R.string.count_unit, sb, textView);
            aVar.f7180z.setText(Util.m307b(chartCustomer.loggedAt));
            aVar.f7172A.setText(Util.m307b(chartCustomer.orderedAt));
            aVar.f7173B.setText(PickerViewObj.m4699b(chartCustomer.shippingAddress, this.baseActivity));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7171f.inflate(R.layout.item_chart_customer_shimmer, viewGroup, false)) : new a(this.f7171f.inflate(R.layout.item_chart_customer, viewGroup, false));
    }
}
