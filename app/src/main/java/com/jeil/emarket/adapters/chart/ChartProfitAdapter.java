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
import com.jeil.emarket.model.customer.SubOrder;
import com.jeil.emarket.model.vendor.ChartProfit;
import com.jeil.emarket.viewmodel.VendorListVM;

import java.util.Date;

/* renamed from: b.f.a.b.d.g */

public class ChartProfitAdapter extends BaseMainAdapter<ChartProfit, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7200f;

    /* renamed from: b.f.a.b.d.g$a */
    public static class a extends RecyclerView.ViewHolder {


        public final PriceText f7201A;


        public final PriceText f7202B;

        /* renamed from: t */
        public final TextView f7203t;

        /* renamed from: u */
        public final TextView f7204u;

        /* renamed from: v */
        public final LinearLayoutCompat f7205v;

        /* renamed from: w */
        public final LinearLayoutCompat f7206w;

        /* renamed from: x */
        public final PriceText f7207x;

        /* renamed from: y */
        public final PriceText f7208y;

        /* renamed from: z */
        public final PriceText f7209z;
        private final Activity f3933a = null;
        public a(View view) {
            super(view);
            this.f7203t = (TextView) this.f3933a.findViewById(R.id.tv_date);
            this.f7204u = (TextView) this.f3933a.findViewById(R.id.tv_orders);
            this.f7205v = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpf);
            this.f7206w = (LinearLayoutCompat) this.f3933a.findViewById(R.id.ll_kpw);
            this.f7207x = (PriceText) this.f3933a.findViewById(R.id.pt_kpf_sale_total);
            this.f7208y = (PriceText) this.f3933a.findViewById(R.id.pt_kpw_sale_total);
            this.f7209z = (PriceText) this.f3933a.findViewById(R.id.pt_shipping_price);
            this.f7201A = (PriceText) this.f3933a.findViewById(R.id.pt_kpf_fee);
            this.f7202B = (PriceText) this.f3933a.findViewById(R.id.pt_kpw_fee);
        }
    }

    /* renamed from: b.f.a.b.d.g$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public ChartProfitAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7200f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((ChartProfit) this.arrayList.get(i)).type == null || !((ChartProfit) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        ChartProfit chartProfit = (ChartProfit) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            TextView textView = aVar.f7203t;
            Date date = chartProfit.date;
            textView.setText(date != null ? Util.date2Str(date) : "");
            aVar.f7207x.setHidePriceNumber(false);
            aVar.f7208y.setHidePriceNumber(false);
            if (chartProfit.total.kpf > 0.0f) {
                aVar.f7205v.setVisibility(View.VISIBLE);
                aVar.f7207x.setPrice(Util.m303b(chartProfit.total.kpf));
            } else {
                aVar.f7205v.setVisibility(View.GONE);
            }
            if (chartProfit.total.kpw > 0.0f) {
                aVar.f7206w.setVisibility(View.VISIBLE);
                aVar.f7208y.setPrice(Util.m303b(chartProfit.total.kpw));
            } else {
                aVar.f7206w.setVisibility(View.GONE);
            }
            TextView textView2 = aVar.f7204u;
            StringBuilder sb = new StringBuilder();
            sb.append(Util.m218a(chartProfit.orders, false));
            CustomString.m3170a(this.baseActivity, R.string.count_unit, sb, textView2);
            aVar.f7209z.setCurrency(VendorListVM.f10363d.getValue() != null ? VendorListVM.f10363d.getValue().shippingCurrency : "kpw");
            aVar.f7209z.setHidePriceNumber(false);
            aVar.f7209z.setPrice(Util.m303b(chartProfit.shipping));
            aVar.f7201A.setHidePriceNumber(false);
            aVar.f7202B.setHidePriceNumber(false);
            SubOrder.TotalAmount totalAmount = chartProfit.fee;
            if (totalAmount.kpf > 0.0f && totalAmount.kpw > 0.0f) {
                aVar.f7202B.f12264t = true;
            }
            if (chartProfit.fee.kpf > 0.0f) {
                aVar.f7201A.setVisibility(View.VISIBLE);
                aVar.f7201A.setPrice(Util.m303b(chartProfit.fee.kpf));
            } else {
                aVar.f7201A.setVisibility(View.GONE);
            }
            if (chartProfit.fee.kpw > 0.0f) {
                aVar.f7202B.setVisibility(View.VISIBLE);
                aVar.f7202B.setPrice(Util.m303b(chartProfit.fee.kpw));
            } else {
                aVar.f7202B.setVisibility(View.GONE);
            }
            SubOrder.TotalAmount totalAmount2 = chartProfit.fee;
            if (totalAmount2.kpf == 0.0f && totalAmount2.kpw == 0.0f) {
                aVar.f7201A.setVisibility(View.VISIBLE);
                aVar.f7201A.setPrice("0");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7200f.inflate(R.layout.item_chart_profit_shimmer, viewGroup, false)) : new a(this.f7200f.inflate(R.layout.item_chart_profit, viewGroup, false));
    }
}
