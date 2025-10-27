package com.jeil.emarket.adapters.fbt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.GradientScrollLayout;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.FBT;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.b.h.n */

public class FBTAdapter extends BaseMainAdapter<FBT, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public int f7572f;

    /* renamed from: b.f.a.b.h.n$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public GradientScrollLayout f7573t;

        /* renamed from: u */
        public ProductPrice f7574u;

        /* renamed from: v */
        public ProductPrice f7575v;

        /* renamed from: w */
        public TextView f7576w;

        public a(View view) {
            super(view);
            this.f7576w = (TextView) view.findViewById(R.id.tv_discount_label);
            this.f7573t = (GradientScrollLayout) view.findViewById(R.id.gsl_products);
            this.f7574u = (ProductPrice) view.findViewById(R.id.pp_price_kpf);
            this.f7575v = (ProductPrice) view.findViewById(R.id.pp_price_kpw);
        }
    }

    /* renamed from: b.f.a.b.h.n$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public FBTAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.baseActivity = activityC1391g1;
    }


    public  void m4481a(FBT.Product product, View view) {
        Intent intent = new Intent(this.baseActivity, ProductActivity.class);
        intent.putExtra("id", product.f12401id);
        ProductTotalVM.m5467b(this.baseActivity, product.f12401id);
        this.baseActivity.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((FBT) this.arrayList.get(i)).type == null || !((FBT) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        FBT fbt = (FBT) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            TextView textView = aVar.f7576w;
            if (fbt.discount > 0.0f) {
                StringBuilder m3163a = CustomString.format("-");
                m3163a.append(java.lang.String.format("%.1f", Float.valueOf(fbt.discount)));
                m3163a.append("%");
                textView.setText(m3163a.toString());
                textView.setVisibility(View.VISIBLE);
            } else {
                textView.setVisibility(View.GONE);
            }
            aVar.f7574u.setVisibility(View.GONE);
            aVar.f7575v.setVisibility(View.GONE);
            if (fbt.total.kpf > 0.0f) {
                aVar.f7574u.setVisibility(View.VISIBLE);
                aVar.f7574u.setPtSalePrice(Util.m304b(fbt.total.kpf, true));
                float f = fbt.oldTotal.kpf;
                if (f > 0.0f && f > fbt.total.kpf) {
                    aVar.f7574u.setRegularPrice(Util.m304b(f, true));
                }
                aVar.f7574u.setPadding(0, 1, 0, 1);
            }
            if (fbt.total.kpw > 0.0f) {
                aVar.f7575v.setVisibility(View.VISIBLE);
                aVar.f7575v.setPtSalePrice(Util.m304b(fbt.total.kpw, true));
                float f2 = fbt.oldTotal.kpw;
                if (f2 > 0.0f && f2 > fbt.total.kpw) {
                    aVar.f7575v.setRegularPrice(Util.m304b(f2, true));
                }
                aVar.f7575v.setPadding(0, 1, 0, 1);
            }
            GradientScrollLayout gradientScrollLayout = aVar.f7573t;
            gradientScrollLayout.removeAllViews();
            for (int i2 = 0; i2 < fbt.products.size(); i2++) {
                final FBT.Product product = fbt.products.get(i2);
                if (i2 != 0) {
                    TextView textView2 = new TextView(this.baseActivity);
                    textView2.setText("+");
                    textView2.setTextSize(1, 18.0f);
                    textView2.setPadding(0, 0, Util.dp2px(textView2.getContext(), 5), 0);
                    textView2.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    textView2.setGravity(16);
                    gradientScrollLayout.m6824a(textView2);
                }
                MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this.baseActivity);
                AppCompatImageView appCompatImageView = new AppCompatImageView(this.baseActivity);
                materialRippleLayout.addView(appCompatImageView);
                appCompatImageView.setTag(Integer.valueOf(R.id.iv_product_img));
                ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(product.image, "mdm")).diskCacheStrategy(DiskCacheStrategy.ALL))).into((ImageView) appCompatImageView);
                materialRippleLayout.setRippleOverlay(true);
                materialRippleLayout.setDefaultRippleAlpha(20);
                materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.h.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FBTAdapter.this.m4481a(product, view);
                    }
                });
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this.baseActivity, 70), Util.dp2px((Context) this.baseActivity, 70));
                materialRippleLayout.setLayoutParams(c0541a);
                c0541a.setMargins(0, 0, Util.dp2px(this.baseActivity.getBaseContext(), 5), 0);
                materialRippleLayout.setPadding(Util.dp2px(materialRippleLayout.getContext(), 2), Util.dp2px(materialRippleLayout.getContext(), 2), Util.dp2px(materialRippleLayout.getContext(), 2), Util.dp2px(materialRippleLayout.getContext(), 2));
                materialRippleLayout.setBackgroundResource(R.drawable.bd_rect);
                materialRippleLayout.setRippleRoundedCorners(Util.dp2px((Context) this.baseActivity, 3));
                gradientScrollLayout.m6824a(materialRippleLayout);
            }
            if (fbt.products.size() < 3) {
                gradientScrollLayout.getRightLayout().setVisibility(View.GONE);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return i == 1 ? new b(from.inflate(R.layout.item_shimmer_fbt_collection, viewGroup, false)) : new a(from.inflate(R.layout.item_fbt_collection, viewGroup, false));
    }
}
