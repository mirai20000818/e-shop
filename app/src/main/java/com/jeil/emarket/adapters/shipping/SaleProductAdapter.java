package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
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
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.DialogChangeDiscount;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.vendor.SaleProduct;
import com.jeil.emarket.model.vendor.SaleProductUpdate;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.b.k.w1 */

public class SaleProductAdapter extends BaseMainAdapter<SaleProduct, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final BaseInterface2 f8078f;

    /* renamed from: g */
    public final LayoutInflater f8079g;

    /* renamed from: h */
    public boolean f8080h;

    /* renamed from: b.f.a.b.k.w1$a */
    public static class a extends RecyclerView.ViewHolder {


        public final PriceText f8081A;


        public final TextView f8082B;


        public final TextView f8083C;


        public final TextView f8084D;


        public final TextView f8085E;

        /* renamed from: F */
        public final MaterialRippleLayout f8086F;

        /* renamed from: G */
        public final MaterialRippleLayout f8087G;

        /* renamed from: H */
        public final LinearLayoutCompat f8088H;

        /* renamed from: t */
        public final AppCompatImageView f8089t;

        /* renamed from: u */
        public final TextView f8090u;

        /* renamed from: v */
        public final LinearLayoutCompat f8091v;

        /* renamed from: w */
        public final TextView f8092w;

        /* renamed from: x */
        public final TextView f8093x;

        /* renamed from: y */
        public final ProductPrice f8094y;

        /* renamed from: z */
        public final ProductPrice f8095z;

        public a(View view) {
            super(view);
            this.f8089t = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f8090u = (TextView) view.findViewById(R.id.tv_product_name);
            this.f8091v = (LinearLayoutCompat) view.findViewById(R.id.llc_product_sku_item);
            this.f8092w = (TextView) view.findViewById(R.id.tv_product_sku);
            this.f8093x = (TextView) view.findViewById(R.id.tv_product_id);
            this.f8094y = (ProductPrice) view.findViewById(R.id.pp_product_price);
            this.f8095z = (ProductPrice) view.findViewById(R.id.pp_cost_price);
            this.f8081A = (PriceText) view.findViewById(R.id.tv_sale_price);
            this.f8082B = (TextView) view.findViewById(R.id.tv_discount_percent);
            this.f8083C = (TextView) view.findViewById(R.id.tv_sale_period);
            this.f8084D = (TextView) view.findViewById(R.id.tv_out_of_stock);
            this.f8085E = (TextView) view.findViewById(R.id.tv_stock);
            this.f8086F = (MaterialRippleLayout) view.findViewById(R.id.mrl_edit_discount_percent);
            this.f8087G = (MaterialRippleLayout) view.findViewById(R.id.mrl_delete);
            this.f8088H = (LinearLayoutCompat) view.findViewById(R.id.llc_action);
        }
    }

    /* renamed from: b.f.a.b.k.w1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public SaleProductAdapter(BaseActivity activityC1391g1, BaseInterface2 baseInterface2) {
        super(activityC1391g1);
        this.f8080h = false;
        this.f8079g = LayoutInflater.from(activityC1391g1);
        this.f8078f = baseInterface2;
    }


    public  void m4560a(int i, android.content.DialogInterface dialogInterface) {
        this.f8080h = false;
        if (ProductTotalVM.f10240h.getValue() == null || ProductTotalVM.f10240h.getValue().intValue() != 200) {
            return;
        }
        this.f8078f.mo4808a(i, "refresh", 1);
    }


    public  void m4561a(DialogError dialogError, int i, SaleProduct saleProduct) {
        dialogError.dismiss();
        this.f8078f.mo4808a(i, java.lang.String.valueOf(saleProduct.productId), 1);
    }


    public  void m4562a(SaleProduct saleProduct, final int i, View view) {
        SaleProductUpdate saleProductUpdate = new SaleProductUpdate();
        saleProductUpdate.f12444id = saleProduct.f12443id;
        saleProductUpdate.productId = saleProduct.productId;
        saleProductUpdate.discountPercent = saleProduct.discountPercent;
        saleProductUpdate.discountPrice = saleProduct.discountPrice;
        DialogChangeDiscount dialogChangeDiscount = new DialogChangeDiscount(this.baseActivity, saleProductUpdate, saleProduct.currency, saleProduct.regularPrice);
        if (!this.f8080h) {
            this.f8080h = true;
            dialogChangeDiscount.show();
        }
        dialogChangeDiscount.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.b.k.w
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                SaleProductAdapter.this.m4560a(i, dialogInterface);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((SaleProduct) this.arrayList.get(i)).type == null || !((SaleProduct) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }


    public  void m4563b(final SaleProduct saleProduct, final int i, View view) {
        if (saleProduct.endDate.getTime() + 86400000 <= saleProduct.today.getTime()) {
            this.f8078f.mo4808a(i, java.lang.String.valueOf(saleProduct.productId), 1);
            return;
        }
        final DialogError dialogError = new DialogError(this.baseActivity);
        dialogError.f8246v = this.baseActivity.getResources().getString(R.string.delete_sale_product_warning_notice);
        dialogError.m4584a(this.baseActivity.getResources().getString(R.string.cancel), this.baseActivity.getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a( new DialogInterface() { // from class: b.f.a.b.k.x
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                SaleProductAdapter.this.m4561a(dialogError, i, saleProduct);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            final SaleProduct saleProduct = (SaleProduct) this.arrayList.get(i);
            ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(saleProduct.image, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL))).into((ImageView) aVar.f8089t);
            aVar.f8090u.setText(saleProduct.name);
            java.lang.String str = saleProduct.sku;
            if (str == null || str.isEmpty()) {
                aVar.f8091v.setVisibility(View.GONE);
            } else {
                aVar.f8092w.setText(saleProduct.sku);
            }
            CustomString.m3174a(new StringBuilder(), saleProduct.productId, "", aVar.f8093x);
            aVar.f8095z.setHidePriceNumber(false);
            aVar.f8095z.setCurrency(saleProduct.currency);
            if (saleProduct.type.equals("simple") || (saleProduct.type.equals("variable") && saleProduct.maxCostPrice == saleProduct.minCostPrice)) {
                aVar.f8095z.setPtSalePrice(Util.m327c(saleProduct.type.equals("simple") ? saleProduct.costPrice : saleProduct.minCostPrice));
                aVar.f8095z.m6939a(false);
            } else {
                aVar.f8095z.m6938a(Util.m327c(saleProduct.minCostPrice), Util.m327c(saleProduct.maxCostPrice));
            }
            aVar.f8094y.setCurrency(saleProduct.currency);
            aVar.f8094y.m6941c(false);
            float f = saleProduct.salePrice;
            if (f <= 0.0f || f == saleProduct.regularPrice) {
                aVar.f8094y.setPtSalePrice(Util.m327c(saleProduct.regularPrice));
            } else {
                aVar.f8094y.setPtSalePrice(Util.m327c(f));
                aVar.f8094y.setRegularPriceSize(13);
                aVar.f8094y.setRegularPrice(Util.m327c(saleProduct.regularPrice));
            }
            aVar.f8081A.setCurrency(saleProduct.currency);
            aVar.f8081A.setPrice(Util.m327c(saleProduct.discountPrice));
            TextView textView = aVar.f8082B;
            StringBuilder m3163a = CustomString.format("( -");
            m3163a.append(saleProduct.discountPercent);
            m3163a.append("% )");
            textView.setText(m3163a.toString());
            aVar.f8083C.setText(Util.date2Str(saleProduct.startDate) + " ~ " + Util.date2Str(saleProduct.endDate));
            if (saleProduct.stock == 0) {
                aVar.f8084D.setVisibility(View.VISIBLE);
                aVar.f8085E.setVisibility(View.GONE);
            } else {
                aVar.f8084D.setVisibility(View.GONE);
                aVar.f8085E.setVisibility(View.VISIBLE);
                TextView textView2 = aVar.f8085E;
                StringBuilder sb = new StringBuilder();
                sb.append(saleProduct.stock);
                CustomString.m3170a(this.baseActivity, R.string.count_unit, sb, textView2);
                if (saleProduct.stock < 0) {
                    aVar.f8085E.setTextColor(this.baseActivity.getResources().getColor(R.color.danger));
                }
            }
            aVar.f8088H.setVisibility(saleProduct.endDate.getTime() + 86400000 > saleProduct.today.getTime() ? View.VISIBLE : View.GONE);
            aVar.f8086F.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SaleProductAdapter.this.m4562a(saleProduct, i, view);
                }
            });
            aVar.f8087G.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SaleProductAdapter.this.m4563b(saleProduct, i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f8079g.inflate(R.layout.item_shimmer_sale_product, viewGroup, false)) : new a(this.f8079g.inflate(R.layout.item_sale_product, viewGroup, false));
    }
}
