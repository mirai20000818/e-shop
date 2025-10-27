package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.product.FBTEditActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.GradientScrollLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.FBT;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.b.k.k1 */

public class FBTAdapter extends BaseMainAdapter<FBT, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f7926f;

    /* renamed from: g */
    public final LayoutInflater f7927g;

    /* renamed from: h */
    public boolean f7928h;

    /* renamed from: b.f.a.b.k.k1$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final MaterialRippleLayout f7929t;

        /* renamed from: u */
        public final MaterialRippleLayout f7930u;

        /* renamed from: v */
        public final TextView f7931v;

        /* renamed from: w */
        public final TextView f7932w;

        /* renamed from: x */
        public final TextView f7933x;

        /* renamed from: y */
        public final GradientScrollLayout f7934y;

        public a(View view) {
            super(view);
            this.f7929t = (MaterialRippleLayout) view.findViewById(R.id.mrl_item);
            this.f7930u = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete);
            this.f7931v = (TextView) view.findViewById(R.id.tv_id);
            this.f7932w = (TextView) view.findViewById(R.id.tv_title);
            this.f7933x = (TextView) view.findViewById(R.id.tv_product_count);
            this.f7934y = (GradientScrollLayout) view.findViewById(R.id.gsl_items);
        }
    }

    /* renamed from: b.f.a.b.k.k1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public FBTAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f7928h = false;
        this.f7927g = LayoutInflater.from(activityC1391g1);
        this.f7926f = baseInterface2;
    }


    public  void m4550a(int i, FBT fbt, DialogError dialogError) {
        this.f7926f.mo4808a(i, java.lang.String.valueOf(fbt.f12436id), 1);
        dialogError.dismiss();
    }


    public  void m4551a(android.content.DialogInterface dialogInterface) {
        this.f7928h = false;
    }


    public  void m4552a(final FBT fbt, final int i, View view) {
        if (this.f7928h) {
            return;
        }
        this.f7928h = true;
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = java.lang.String.format(this.baseActivity.getResources().getString(R.string.delete_FBT_notice), fbt.name);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.k.m
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                FBTAdapter.this.m4550a(i, fbt, dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.l
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                FBTAdapter.this.m4551a(dialogInterface);
            }
        });
    }


    public  void m4553a(FBT fbt, View view) {
        ProductTotalVM.m5461a(this.baseActivity, fbt.f12436id);
        Intent intent = new Intent(this.baseActivity, FBTEditActivity.class);
        StringBuilder sb = new StringBuilder();
        CustomString.m3171a(this.baseActivity, R.string.collection_products, sb, "《");
        sb.append(fbt.name);
        sb.append("》");
        intent.putExtra("title", sb.toString());
        intent.putExtra("id", fbt.f12436id);
        intent.putExtra("page", "edit");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((FBT) this.arrayList.get(i)).type == null || !((FBT) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            final FBT fbt = (FBT) this.arrayList.get(i);
            aVar.f7929t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FBTAdapter.this.m4553a(fbt, view);
                }
            });
            aVar.f7930u.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FBTAdapter.this.m4552a(fbt, i, view);
                }
            });
            CustomString.m3174a(new StringBuilder(), fbt.f12436id, "", aVar.f7931v);
            aVar.f7932w.setText(fbt.name);
            aVar.f7933x.setText(Util.m217a(fbt.products.size()));
            aVar.f7934y.removeAllViews();
            for (int i2 = 0; i2 < fbt.products.size(); i2++) {
                LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.baseActivity);
                linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
                linearLayoutCompat.setGravity(1);
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                ((LinearLayout.LayoutParams) c0541a).rightMargin = Util.dp2px((Context) this.baseActivity, 3);
                ((LinearLayout.LayoutParams) c0541a).leftMargin = Util.dp2px((Context) this.baseActivity, 3);
                linearLayoutCompat.setLayoutParams(c0541a);
                ImageView appCompatImageView = new AppCompatImageView(this.baseActivity);
                LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this.baseActivity, 45), Util.dp2px((Context) this.baseActivity, 45));
                ((LinearLayout.LayoutParams) c0541a2).bottomMargin = Util.dp2px((Context) this.baseActivity, 4);
                appCompatImageView.setLayoutParams(c0541a2);
                appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(fbt.products.get(i2).image, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL))).into(appCompatImageView);
                TextView textView = new TextView(this.baseActivity);
                textView.setGravity(1);
                textView.setBackgroundResource(R.drawable.bd_grey_ellipse);
                textView.setBackgroundTintList(ColorStateList.valueOf(this.baseActivity.getResources().getColor(R.color.pink)));
                textView.setTextColor(this.baseActivity.getResources().getColor(R.color.white));
                textView.setTextSize(1, 9.0f);
                textView.setPadding(Util.dp2px((Context) this.baseActivity, 6), Util.dp2px((Context) this.baseActivity, 4), Util.dp2px((Context) this.baseActivity, 6), Util.dp2px((Context) this.baseActivity, 4));
                textView.setText("-" + fbt.products.get(i2).discount + "%");
                textView.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayoutCompat.addView(appCompatImageView);
                linearLayoutCompat.addView(textView);
                aVar.f7934y.m6824a(linearLayoutCompat);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7927g.inflate(R.layout.item_shimmer_fbt, viewGroup, false)) : new a(this.f7927g.inflate(R.layout.item_fbt, viewGroup, false));
    }
}
