package com.jeil.emarket.adapters.refund;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.jeil.emarket.activities.account.RefundDetailActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.RefundProduct;


/* renamed from: b.f.a.b.a.w */

public class RefundProductAdapter extends BaseMainAdapter<RefundProduct, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f7098f;

    /* renamed from: b.f.a.b.a.w$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ImageView f7099t;

        /* renamed from: u */
        public final TextView f7100u;

        /* renamed from: v */
        public final TextViewBold f7101v;

        /* renamed from: w */
        public final TextView f7102w;

        /* renamed from: x */
        public final MaterialRippleLayout f7103x;
        private final Activity f3933a = null;

        public a(View view) {
            super(view);
            this.f7099t = (ImageView) view.findViewById(R.id.iv_product_img);
            this.f7100u = (TextView) this.f3933a.findViewById(R.id.tv_product_name);
            this.f7101v = (TextViewBold) this.f3933a.findViewById(R.id.tv_order_number);
            this.f7102w = (TextView) this.f3933a.findViewById(R.id.tv_vendor_name);
            this.f7103x = (MaterialRippleLayout) this.f3933a.findViewById(R.id.mrl_refund_product);
        }
    }

    /* renamed from: b.f.a.b.a.w$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public RefundProductAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f7098f = LayoutInflater.from(activityC1391g1);
    }


    public  void m4406a(int i, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), RefundDetailActivity.class);
        intent.putExtra("refundProduct", new Gson().toJson(this.arrayList.get(i)));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((RefundProduct) this.arrayList.get(i)).type == null || !((RefundProduct) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            aVar.f7100u.setText(((RefundProduct) this.arrayList.get(i)).productName);
            aVar.f7101v.setText(String.valueOf(((RefundProduct) this.arrayList.get(i)).displayOrderId));
            aVar.f7102w.setText(((RefundProduct) this.arrayList.get(i)).vendor);
            ((((RefundProduct) this.arrayList.get(i)).productImg == null || ((RefundProduct) this.arrayList.get(i)).productImg.isEmpty()) ? Glide.with((FragmentActivity) this.baseActivity).load(this.baseActivity.getResources().getDrawable(R.drawable.ic_placeholder)) : (RequestBuilder) Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(((RefundProduct) this.arrayList.get(i)).productImg, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL)).into(aVar.f7099t);
            aVar.f7103x.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.a.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RefundProductAdapter.this.m4406a(i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7098f.inflate(R.layout.item_shimmer_product_refundable, viewGroup, false)) : new a(this.f7098f.inflate(R.layout.item_product_refundable, viewGroup, false));
    }
}
