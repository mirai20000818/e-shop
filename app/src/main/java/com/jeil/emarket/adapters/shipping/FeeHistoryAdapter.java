package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.FeeHistory;


/* renamed from: b.f.a.b.k.n1 */

public class FeeHistoryAdapter extends BaseMainAdapter<FeeHistory, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7971f;

    /* renamed from: b.f.a.b.k.n1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f7972t;

        /* renamed from: u */
        public final TextView f7973u;

        /* renamed from: v */
        public final TextView f7974v;

        /* renamed from: w */
        public final PriceText f7975w;

        /* renamed from: x */
        public final PriceText f7976x;

        public a(View view) {
            super(view);
            this.f7972t = (TextView) view.findViewById(R.id.tv_fee_id);
            this.f7973u = (TextView) view.findViewById(R.id.tv_fee_created_at);
            this.f7974v = (TextView) view.findViewById(R.id.tv_extra);
            this.f7975w = (PriceText) view.findViewById(R.id.pt_kpf_fee_amount);
            this.f7976x = (PriceText) view.findViewById(R.id.pt_kpw_fee_amount);
        }
    }

    /* renamed from: b.f.a.b.k.n1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public FeeHistoryAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7971f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((FeeHistory) this.arrayList.get(i)).type == null || !((FeeHistory) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        FeeHistory feeHistory = (FeeHistory) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.f7972t.setText(Util.m217a(feeHistory.f12438id));
            aVar.f7973u.setText(Util.m307b(feeHistory.createdAt));
            aVar.f7975w.setHidePriceNumber(false);
            aVar.f7976x.setHidePriceNumber(false);
            aVar.f7976x.f12264t = feeHistory.amountKpf > 0.0f && feeHistory.amountKpw > 0.0f;
            float f = feeHistory.amountKpf;
            if (f > 0.0f) {
                aVar.f7975w.setPrice(Util.m327c(f));
                aVar.f7975w.setVisibility(View.VISIBLE);
            } else {
                aVar.f7975w.setVisibility(View.GONE);
            }
            float f2 = feeHistory.amountKpw;
            if (f2 > 0.0f) {
                aVar.f7976x.setPrice(Util.m327c(f2));
                aVar.f7976x.setVisibility(View.VISIBLE);
            } else {
                aVar.f7976x.setVisibility(View.GONE);
            }
            aVar.f7974v.setText(feeHistory.description);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7971f.inflate(R.layout.item_shimmer_fee_history, viewGroup, false)) : new a(this.f7971f.inflate(R.layout.item_fee_history, viewGroup, false));
    }
}
