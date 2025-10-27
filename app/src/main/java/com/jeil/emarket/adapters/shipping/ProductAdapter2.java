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
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.product.ProductChooseSaleActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.OrderItem;
import com.jeil.emarket.model.vendor.FBT;
import com.jeil.emarket.model.vendor.Product;

import java.util.ArrayList;


/* renamed from: b.f.a.b.k.p1 */

public class ProductAdapter2 extends BaseMainAdapter<Product, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f8001f;

    /* renamed from: b.f.a.b.k.p1$a */
    public static class a extends RecyclerView.ViewHolder {


        public final CheckBox f8002A;

        /* renamed from: t */
        public final MaterialRippleLayout f8003t;

        /* renamed from: u */
        public final AppCompatImageView f8004u;

        /* renamed from: v */
        public final TextView f8005v;

        /* renamed from: w */
        public final LinearLayoutCompat f8006w;

        /* renamed from: x */
        public final TextView f8007x;

        /* renamed from: y */
        public final TextView f8008y;

        /* renamed from: z */
        public final ProductPrice f8009z;

        public a(View view) {
            super(view);
            this.f8003t = (MaterialRippleLayout) view.findViewById(R.id.mrl_product_item);
            this.f8004u = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f8005v = (TextView) view.findViewById(R.id.tv_product_name);
            this.f8006w = (LinearLayoutCompat) view.findViewById(R.id.llc_product_sku_item);
            this.f8007x = (TextView) view.findViewById(R.id.tv_product_sku);
            this.f8008y = (TextView) view.findViewById(R.id.tv_product_id);
            this.f8009z = (ProductPrice) view.findViewById(R.id.pp_product_price);
            this.f8002A = (CheckBox) view.findViewById(R.id.cb_choose_sale);
        }
    }

    public ProductAdapter2(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f8001f = LayoutInflater.from(activityC1391g1);
    }


    public static  void m4555a(ProductChooseSaleActivity productChooseSaleActivity, Product product, View view) {
        if (productChooseSaleActivity.f11898N.contains(Integer.valueOf(product.productId))) {
            productChooseSaleActivity.f11898N.remove(Integer.valueOf(product.productId));
            ArrayList arrayList = new ArrayList(productChooseSaleActivity.f11896L);
            for (FBT.Product product2 : productChooseSaleActivity.f11896L) {
                if (product2.f12437id == product.productId) {
                    arrayList.remove(product2);
                }
            }
            productChooseSaleActivity.f11896L = arrayList;
            ArrayList arrayList2 = new ArrayList(productChooseSaleActivity.f11897M);
            for (OrderItem orderItem : productChooseSaleActivity.f11897M) {
                if (orderItem.f12404id == product.productId) {
                    arrayList2.remove(orderItem);
                }
            }
            productChooseSaleActivity.f11897M = arrayList2;
            return;
        }
        productChooseSaleActivity.f11898N.add(Integer.valueOf(product.productId));
        FBT.Product product3 = new FBT.Product();
        product3.f12437id = product.productId;
        product3.name = product.name;
        product3.price = product.regularPrice;
        product3.maxPrice = product.maxPrice;
        product3.minPrice = product.minPrice;
        product3.discount = 0.0f;
        product3.image = product.image.url;
        product3.sku = product.sku;
        product3.stock = product.stock;
        product3.currency = product.currency;
        productChooseSaleActivity.f11896L.add(product3);
        if (product.stock > 0) {
            OrderItem orderItem2 = new OrderItem();
            orderItem2.f12404id = product.productId;
            orderItem2.productParent = product.parent;
            orderItem2.stock = product.stock;
            orderItem2.name = product.name;
            orderItem2.productImg = product.image.url;
            orderItem2.curQty = 1;
            orderItem2.sku = product.sku;
            orderItem2.currency = product.currency;
            productChooseSaleActivity.f11897M.add(orderItem2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Product product = (Product) this.arrayList.get(i);
        if (recyclerViewViewHolder instanceof a) {
            final a aVar = (a) recyclerViewViewHolder;
            RequestManager m3287a = Glide.with((FragmentActivity) this.baseActivity);
            Product.Image image = product.image;
            ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, m3287a.load(image != null ? Util.m306b(image.url, "xs") : this.baseActivity.getResources().getDrawable(R.drawable.ic_placeholder)).diskCacheStrategy(DiskCacheStrategy.ALL))).into((ImageView) aVar.f8004u);
            aVar.f8005v.setText(product.name);
            java.lang.String str = product.sku;
            if (str == null || str.isEmpty()) {
                aVar.f8006w.setVisibility(View.GONE);
            } else {
                aVar.f8006w.setVisibility(View.VISIBLE);
                aVar.f8007x.setText(product.sku);
            }
            CustomString.m3174a(new StringBuilder(), product.productId, "", aVar.f8008y);
            aVar.f8009z.setHidePriceNumber(false);
            aVar.f8009z.setCurrency(product.currency);
            aVar.f8009z.m6941c(false);
            java.lang.String str2 = product.productType;
            if (str2 == null || !str2.equals("variable")) {
                float f = product.salePrice;
                if (f <= 0.0f || f == product.regularPrice) {
                    aVar.f8009z.setPtSalePrice(Util.m327c(product.regularPrice));
                } else {
                    aVar.f8009z.setPtSalePrice(Util.m327c(f));
                    aVar.f8009z.setRegularPrice(Util.m327c(product.regularPrice));
                }
            } else {
                aVar.f8009z.m6938a(Util.m327c(product.minPrice), Util.m327c(product.maxPrice));
                aVar.f8009z.m6939a(false);
            }
            BaseActivity activityC1391g1 = this.baseActivity;
            if (activityC1391g1 instanceof ProductChooseSaleActivity) {
                final ProductChooseSaleActivity productChooseSaleActivity = (ProductChooseSaleActivity) activityC1391g1;
                aVar.f8002A.setChecked(productChooseSaleActivity.f11898N.contains(Integer.valueOf(product.productId)));
                aVar.f8003t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                      //  ProductAdapter2.a.this.f8002A.performClick();
                    }
                });
                aVar.f8002A.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                     //   ProductAdapter2.m4555a(ProductChooseSaleActivity.this, product, view);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.f8001f.inflate(R.layout.item_choose_sale_product, viewGroup, false));
    }
}
