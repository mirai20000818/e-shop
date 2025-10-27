package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.vendor.SaleReport;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;


/* renamed from: b.f.a.b.k.z1 */

public class SaleReportAdapter extends BaseMainAdapter<SaleReport, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f8140f;

    /* renamed from: b.f.a.b.k.z1$a */
    public static class a extends RecyclerView.ViewHolder {

        
        public final LinearLayoutCompat f8141A;

        
        public final PriceText f8142B;

        
        public final PriceText f8143C;

        /* renamed from: t */
        public final AppCompatImageView f8144t;

        /* renamed from: u */
        public final TextView f8145u;

        /* renamed from: v */
        public final LinearLayoutCompat f8146v;

        /* renamed from: w */
        public final TextView f8147w;

        /* renamed from: x */
        public final TextView f8148x;

        /* renamed from: y */
        public final TextView f8149y;

        /* renamed from: z */
        public final LinearLayoutCompat f8150z;

        public a(View view) {
            super(view);
            this.f8144t = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f8145u = (TextView) view.findViewById(R.id.tv_product_name);
            this.f8146v = (LinearLayoutCompat) view.findViewById(R.id.llc_product_sku_item);
            this.f8147w = (TextView) view.findViewById(R.id.tv_product_sku);
            this.f8148x = (TextView) view.findViewById(R.id.tv_product_id);
            this.f8149y = (TextView) view.findViewById(R.id.tv_product_qty);
            this.f8150z = (LinearLayoutCompat) view.findViewById(R.id.ll_kpf);
            this.f8141A = (LinearLayoutCompat) view.findViewById(R.id.ll_kpw);
            this.f8142B = (PriceText) view.findViewById(R.id.pt_kpf_sold_total);
            this.f8143C = (PriceText) view.findViewById(R.id.pt_kpw_sold_total);
        }
    }

    /* renamed from: b.f.a.b.k.z1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public SaleReportAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f8140f = LayoutInflater.from(activityC1391g1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((SaleReport) this.arrayList.get(i)).type == null || !((SaleReport) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        PriceText priceText;
        float f;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        SaleReport saleReport = (SaleReport) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(saleReport.image, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL))).into((ImageView) aVar.f8144t);
            aVar.f8145u.setText(saleReport.name);
            if (saleReport.sku.isEmpty()) {
                aVar.f8146v.setVisibility(View.GONE);
            } else {
                aVar.f8146v.setVisibility(View.VISIBLE);
                aVar.f8147w.setText(saleReport.sku);
            }
            aVar.f8148x.setText(Util.m217a(saleReport.f12445id));
            TextView textView = aVar.f8149y;
            StringBuilder sb = new StringBuilder();
            sb.append(Util.m217a(saleReport.sold));
            CustomString.m3170a(this.baseActivity, R.string.count_unit, sb, textView);
            if (saleReport.orderTotal.kpf > 0.0f) {
                aVar.f8150z.setVisibility(View.VISIBLE);
                aVar.f8141A.setVisibility(View.GONE);
                priceText = aVar.f8142B;
                f = saleReport.orderTotal.kpf;
            } else {
                aVar.f8150z.setVisibility(View.GONE);
                aVar.f8141A.setVisibility(View.VISIBLE);
                priceText = aVar.f8143C;
                f = saleReport.orderTotal.kpw;
            }
            priceText.setPrice(Util.m327c(f));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f8140f.inflate(R.layout.item_shimmer_sale_report, viewGroup, false)) : new a(this.f8140f.inflate(R.layout.item_sale_report, viewGroup, false));
    }
}
