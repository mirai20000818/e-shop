package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.History;

/* renamed from: b.f.a.b.k.o1 */

public class HistoryAdapter extends BaseMainAdapter<History, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7982f;

    /* renamed from: g */
    public int f7983g;

    /* renamed from: h */
    public boolean f7984h;

    /* renamed from: b.f.a.b.k.o1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final LinearLayoutCompat f7985t;

        /* renamed from: u */
        public final TextView f7986u;

        /* renamed from: v */
        public final TextView f7987v;

        /* renamed from: w */
        public final TextView f7988w;

        /* renamed from: x */
        public final TextView f7989x;

        /* renamed from: y */
        public final View f7990y;

        public a(View view) {
            super(view);
            this.f7985t = (LinearLayoutCompat) view.findViewById(R.id.ll_note_item);
            this.f7986u = (TextView) view.findViewById(R.id.tv_order_note_date);
            this.f7987v = (TextView) view.findViewById(R.id.tv_order_note_day);
            this.f7988w = (TextView) view.findViewById(R.id.tv_order_note_info);
            this.f7989x = (TextView) view.findViewById(R.id.tv_order_deliverer);
            this.f7990y = view.findViewById(R.id.v_note_border);
        }
    }

    /* renamed from: b.f.a.b.k.o1$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final View f7991t;

        /* renamed from: u */
        public final LinearLayoutCompat f7992u;

        public b(View view) {
            super(view);
            this.f7991t = view.findViewById(R.id.v_shimmer_note_border);
            this.f7992u = (LinearLayoutCompat) view.findViewById(R.id.llc_shimmer_note_item);
        }
    }

    public HistoryAdapter(BaseActivity activityC1391g1, int i, boolean z) {
        super(activityC1391g1);
        this.f7983g = i;
        this.f7984h = z;
        this.f7982f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((History) this.arrayList.get(i)).type == null || !((History) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "StringFormatMatches"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int m170a;
        int m170a2;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        History history = (History) this.arrayList.get(i);
        if (!(recyclerViewViewHolder instanceof a)) {
            if (recyclerViewViewHolder instanceof b) {
                b bVar = (b) recyclerViewViewHolder;
                if (i != getItemCount() - 1 || this.f7983g > Status.f8820k) {
                    return;
                }
                bVar.f7991t.setVisibility(View.GONE);
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
                c0541a.setMargins(0, Util.dp2px((Context) this.baseActivity, 9), 0, Util.dp2px((Context) this.baseActivity, 3));
                bVar.f7992u.setLayoutParams(c0541a);
                return;
            }
            return;
        }
        a aVar = (a) recyclerViewViewHolder;
        aVar.f7986u.setVisibility(View.GONE);
        aVar.f7989x.setVisibility(View.GONE);
        if (history.logged_at != null) {
            TextView textView = aVar.f7987v;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7984h ? i + 1 + Status.f8820k : i + 1);
            sb.append(". ");
            sb.append(Util.m307b(history.logged_at));
            textView.setText(sb.toString());
        }
        aVar.f7988w.setText(Html.fromHtml(history.description));
        LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
        if (i != getItemCount() - 1 || this.f7983g > Status.f8820k) {
            aVar.f7990y.setVisibility(View.VISIBLE);
            m170a = Util.dp2px((Context) this.baseActivity, 9);
            m170a2 = Util.dp2px((Context) this.baseActivity, 9);
        } else {
            aVar.f7990y.setVisibility(View.GONE);
            m170a = Util.dp2px((Context) this.baseActivity, 9);
            m170a2 = Util.dp2px((Context) this.baseActivity, 3);
        }
        c0541a2.setMargins(0, m170a, 0, m170a2);
        aVar.f7985t.setLayoutParams(c0541a2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7982f.inflate(R.layout.item_shimmer_order_note, viewGroup, false)) : new a(this.f7982f.inflate(R.layout.item_order_note, viewGroup, false));
    }
}
