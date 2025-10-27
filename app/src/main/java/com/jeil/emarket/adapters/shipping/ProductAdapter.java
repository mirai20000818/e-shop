package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.dialog.widget.popup.BubblePopup;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;
import com.jeil.emarket.widget.ProductAdapterLinearLayoutCompat;

import java.util.Map;

/* renamed from: b.f.a.b.k.v1 */

public class ProductAdapter extends BaseMainAdapter<Product, ProductAdapter.a> {

    /* renamed from: f */
    public ProductDetail f8056f;

    /* renamed from: b.f.a.b.k.v1$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f8057A;


        public final LinearLayoutCompat f8058B;


        public final EditForm f8059C;


        public final TextView f8060D;


        public final EditForm f8061E;

        /* renamed from: F */
        public final EditForm f8062F;

        /* renamed from: G */
        public final MaterialRippleLayout f8063G;

        /* renamed from: H */
        public final TextView f8064H;

        /* renamed from: t */
        public final LinearLayoutCompat f8065t;

        /* renamed from: u */
        public final LinearLayoutCompat f8066u;

        /* renamed from: v */
        public final TextView f8067v;

        /* renamed from: w */
        public final EditForm f8068w;

        /* renamed from: x */
        public final TextView f8069x;

        /* renamed from: y */
        public final LinearLayoutCompat f8070y;

        /* renamed from: z */
        public final EditForm f8071z;

        public a(View view) {
            super(view);
            this.f8065t = (LinearLayoutCompat) view.findViewById(R.id.ll_attributes);
            this.f8066u = (LinearLayoutCompat) view.findViewById(R.id.ll_product_brand_item);
            this.f8067v = (TextView) view.findViewById(R.id.tv_product_brand);
            this.f8068w = (EditForm) view.findViewById(R.id.ef_product_sku);
            this.f8069x = (TextView) view.findViewById(R.id.tv_product_id);
            this.f8070y = (LinearLayoutCompat) view.findViewById(R.id.ll_regular_back);
            this.f8071z = (EditForm) view.findViewById(R.id.ef_regular_price);
            this.f8057A = (TextView) view.findViewById(R.id.tv_regular_price_currency);
            this.f8058B = (LinearLayoutCompat) view.findViewById(R.id.ll_sale_back);
            this.f8059C = (EditForm) view.findViewById(R.id.ef_sale_price);
            this.f8060D = (TextView) view.findViewById(R.id.tv_sale_price_currency);
            this.f8061E = (EditForm) view.findViewById(R.id.ef_stock);
            this.f8062F = (EditForm) view.findViewById(R.id.ef_stock_threshold);
            this.f8063G = (MaterialRippleLayout) view.findViewById(R.id.mrl_stock_threshold);
            this.f8064H = (TextView) view.findViewById(R.id.tv_status);
        }
    }

    public ProductAdapter(BaseActivity activityC1391g1, ProductDetail productDetail) {
        super(activityC1391g1);
        this.f8056f = productDetail;
    }


    public final void m4556a(View view, int i) {
        TextView textView = new TextView(this.baseActivity);
        textView.setTextSize(1, 10.5f);
        textView.setTextColor(this.baseActivity.getResources().getColor(R.color.white));
        textView.setGravity(17);
        textView.setLineSpacing(Util.dp2px((Context) this.baseActivity, 6), 1.0f);
        textView.setPadding(Util.dp2px((Context) this.baseActivity, 8), Util.dp2px((Context) this.baseActivity, 8), Util.dp2px((Context) this.baseActivity, 8), Util.dp2px((Context) this.baseActivity, 8));
        textView.setText(this.baseActivity.getResources().getString(i));
        BubblePopup bubblePopup = new BubblePopup(this.baseActivity, textView);
        bubblePopup.m6907c(view);
        bubblePopup.m4596a(48);
        BubblePopup bubblePopup2 = bubblePopup;
        if (bubblePopup2.f12222A != null) {
            bubblePopup2.mo4597f();
        }
        bubblePopup2.show();
    }


    public  void m4557a(a aVar, View view) {
        m4556a((View) aVar.f8063G, R.string.stock_threshold_mean);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n", "DefaultLocale"})

    public void onBindViewHolder(a viewHolder, int i) {
        java.lang.String str;
        final a aVar = (a) viewHolder;
        Product product = (Product) this.arrayList.get(i);
        Context context = null;//aVar.f3933a.getContext();
        Map<java.lang.String, java.lang.String> map = product.customMatch;
        if (map != null && map.size() != 0) {
            Map<java.lang.String, java.lang.String> map2 = product.customMatch;
            for (java.lang.String str2 : map2.keySet()) {
                ProductAdapterLinearLayoutCompat productAdapterLinearLayoutCompat = new ProductAdapterLinearLayoutCompat(context);
                productAdapterLinearLayoutCompat.setLabelWidth(R.dimen._104sdp);
                productAdapterLinearLayoutCompat.setLabelText(str2 + ":");
                productAdapterLinearLayoutCompat.setMainText(map2.get(str2));
                aVar.f8065t.addView(productAdapterLinearLayoutCompat);
            }
        }
        Map<Integer, Integer> map3 = product.match;
        if (map3 != null && map3.size() != 0) {
            Map<Integer, Integer> map4 = product.match;
            for (Integer num : map4.keySet()) {
                for (int i2 = 0; i2 < product.variableAttributes.size(); i2++) {
                    if (product.variableAttributes.get(i2).f12409id == num.intValue()) {
                        for (int i3 = 0; i3 < product.variableAttributes.get(i2).items.size(); i3++) {
                            if (product.variableAttributes.get(i2).items.get(i3).f12410id == map4.get(num).intValue()) {
                                ProductAdapterLinearLayoutCompat productAdapterLinearLayoutCompat2 = new ProductAdapterLinearLayoutCompat(context);
                                productAdapterLinearLayoutCompat2.setLabelWidth(R.dimen._104sdp);
                                productAdapterLinearLayoutCompat2.setLabelText(product.variableAttributes.get(i2).name + ":");
                                productAdapterLinearLayoutCompat2.setMainText(product.variableAttributes.get(i2).items.get(i3).name);
                                aVar.f8065t.addView(productAdapterLinearLayoutCompat2);
                            }
                        }
                    }
                }
            }
        }
        java.lang.String str3 = product.brand;
        if (str3 == null || str3.isEmpty()) {
            aVar.f8066u.setVisibility(View.GONE);
        } else {
            aVar.f8066u.setVisibility(View.VISIBLE);
            aVar.f8067v.setText(product.brand);
        }
        CustomString.m3174a(new StringBuilder(), product.f12407id, "", aVar.f8069x);
        java.lang.String str4 = product.sku;
        if (str4 == null || str4.isEmpty()) {
            aVar.f8068w.setText("");
            ((Product) this.arrayList.get(i)).sku = "";
        } else {
            aVar.f8068w.setText(product.sku);
        }
        aVar.f8068w.setEditListener(new TextWatcher4(this, aVar, i));
        aVar.f8057A.setText(this.f8056f.data.currency.equals("kpf") ? "$" : this.baseActivity.getResources().getString(R.string.price_unit));
        aVar.f8071z.setText(product.regularPrice + "");
        aVar.f8071z.setTextColor(context.getResources().getIdentifier(this.f8056f.data.currency, "color", context.getPackageName()));
        if (this.f8056f.data.isFlashSale.booleanValue()) {
            aVar.f8070y.setVisibility(View.VISIBLE);
        } else {
            aVar.f8071z.setEditListener(new TextWatcher3(this, aVar, i));
            aVar.f8070y.setVisibility(View.GONE);
        }
        aVar.f8060D.setText(this.f8056f.data.currency.equals("kpf") ? "$" : this.baseActivity.getResources().getString(R.string.price_unit));
        aVar.f8059C.setText(product.salePrice == product.regularPrice ? "" : product.salePrice + "");
        aVar.f8059C.setTextColor(context.getResources().getIdentifier(this.f8056f.data.currency, "color", context.getPackageName()));
        if (this.f8056f.data.isFlashSale.booleanValue()) {
            aVar.f8058B.setVisibility(View.VISIBLE);
        } else {
            aVar.f8059C.setEditListener(new TextWatcher2(this, aVar, i));
            aVar.f8058B.setVisibility(View.GONE);
        }
        aVar.f8061E.setText(product.stock + "");
        aVar.f8061E.setInputType(2);
        aVar.f8061E.setEditListener(new TextWatcher1(this, aVar, i));
        aVar.f8062F.setText(product.stockThreshold + "");
        aVar.f8062F.setInputType(2);
        aVar.f8062F.setEditListener(new TextWatcherEx(this, aVar, i));
        aVar.f8063G.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductAdapter.this.m4557a(aVar, view);
            }
        });
        aVar.f8070y.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductAdapter.this.m4558b(aVar, view);
            }
        });
        aVar.f8058B.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductAdapter.this.m4559c(aVar, view);
            }
        });
        if (!this.f8056f.data.type.equals("variable") || (!(this.f8056f.data.status.equals("approved") || this.f8056f.data.status.equals("upending") || this.f8056f.data.status.equals("updating") || this.f8056f.data.status.equals("urejected")) || (str = product.status) == null || str.equals("approved"))) {
            aVar.f8064H.setVisibility(View.GONE);
        } else {
            aVar.f8064H.setVisibility(View.VISIBLE);
        }
    }


    public  void m4558b(a aVar, View view) {
        m4556a((View) aVar.f8070y, R.string.disable_notice_by_flash_sale);
    }


    public  void m4559c(a aVar, View view) {
        m4556a((View) aVar.f8058B, R.string.disable_notice_by_flash_sale);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(CustomString.m3150a(viewGroup, R.layout.item_product_edit, viewGroup, false));
    }
}
