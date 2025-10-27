package com.jeil.emarket.adapters.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.QuantityInput;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.ProductTotalVM;
import com.jeil.emarket.widget.ViewOnTouchListenerC2092s;

import java.util.List;

/* renamed from: b.f.a.b.g.u0 */

public class CartProductRecylcer extends BaseMainAdapter<CartProduct, RecyclerView.ViewHolder> {

    /* renamed from: b.f.a.b.g.u0$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final RecyclerView f7482t;

        /* renamed from: u */
        public final QuantityInput f7483u;

        /* renamed from: v */
        public final ProductPrice f7484v;

        /* renamed from: w */
        public final ProductPrice f7485w;

        /* renamed from: x */
        public final CheckBox f7486x;

        public a(View view) {
            super(view);
            this.f7482t = (RecyclerView) view.findViewById(R.id.rv_cart_products);
            this.f7483u = (QuantityInput) view.findViewById(R.id.cqi_quantity);
            this.f7484v = (ProductPrice) view.findViewById(R.id.pp_kpf_price);
            this.f7485w = (ProductPrice) view.findViewById(R.id.pp_kpw_price);
            this.f7486x = (CheckBox) view.findViewById(R.id.cb_product);
        }
    }

    /* renamed from: b.f.a.b.g.u0$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final AppCompatImageView f7487t;

        /* renamed from: u */
        public final MaterialRippleLayout f7488u;

        /* renamed from: v */
        public final TextView f7489v;

        /* renamed from: w */
        public final QuantityInput f7490w;

        /* renamed from: x */
        public final PriceText f7491x;

        /* renamed from: y */
        public final CheckBox f7492y;

        public b(View view) {
            super(view);
            this.f7487t = (AppCompatImageView) view.findViewById(R.id.iv_product_img);
            this.f7488u = (MaterialRippleLayout) view.findViewById(R.id.mrl_img);
            this.f7489v = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7490w = (QuantityInput) view.findViewById(R.id.cqi_quantity);
            this.f7491x = (PriceText) view.findViewById(R.id.pt_price);
            this.f7492y = (CheckBox) view.findViewById(R.id.cb_product);
        }
    }

    public CartProductRecylcer(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    
    public  void m4463a(final int i, int i2) {
        if (i2 == ((CartProduct) this.arrayList.get(i)).quantity) {
            return;
        }
        ((CartProduct) this.arrayList.get(i)).quantity = i2;
        new Handler().post(new Runnable() { // from class: b.f.a.b.g.l
            @Override // java.lang.Runnable
            public final void run() {
                CartProductRecylcer.this.m4469f(i);
            }
        });
    }

    
    public  void m4464a(int i, Context context) {
        BaseActivity activityC1391g1;
        int i2;
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), ProductActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        if (((CartProduct) this.arrayList.get(i)).parentId > 0) {
            intent.putExtra("id", ((CartProduct) this.arrayList.get(i)).parentId);
            activityC1391g1 = this.baseActivity;
            i2 = ((CartProduct) this.arrayList.get(i)).parentId;
        } else {
            intent.putExtra("id", ((CartProduct) this.arrayList.get(i)).f12392id);
            activityC1391g1 = this.baseActivity;
            i2 = ((CartProduct) this.arrayList.get(i)).f12392id;
        }
        ProductTotalVM.m5467b(activityC1391g1, i2);
        this.baseActivity.startActivity(intent);
    }

    
    public  void m4465a(final int i, View view) {
        API_PROVIDER.checkInternet(this.baseActivity, new InterfaceContext() { // from class: b.f.a.b.g.d
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context) {
                CartProductRecylcer.this.m4464a(i, context);
            }
        });
    }

    
    public  void m4466a(int i, CompoundButton compoundButton, boolean z) {
        if (z == ((CartProduct) this.arrayList.get(i)).checked) {
            return;
        }
        final CartProduct cartProduct = (CartProduct) this.arrayList.get(i);
        cartProduct.checked = z;
        new Handler().post(new Runnable() { // from class: b.f.a.b.g.e
            @Override // java.lang.Runnable
            public final void run() {
                //CartProductVM.m5570a(CartProduct.this);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((CartProduct) this.arrayList.get(i)).discountType == null || ((CartProduct) this.arrayList.get(i)).discountType.isEmpty()) ? 2 : 1;
    }

    
    public  void m4467b(final int i, int i2) {
        if (i2 == ((CartProduct) this.arrayList.get(i)).quantity) {
            return;
        }
        ((CartProduct) this.arrayList.get(i)).quantity = i2;
        new Handler().post(new Runnable() { // from class: b.f.a.b.g.h
            @Override // java.lang.Runnable
            public final void run() {
                CartProductRecylcer.this.m4470g(i);
            }
        });
    }

    
    public  void m4468b(int i, CompoundButton compoundButton, boolean z) {
        if (z == ((CartProduct) this.arrayList.get(i)).checked) {
            return;
        }
        final CartProduct cartProduct = (CartProduct) this.arrayList.get(i);
        cartProduct.checked = z;
        new Handler().post(new Runnable() { // from class: b.f.a.b.g.c
            @Override // java.lang.Runnable
            public final void run() {
                //CartProductVM.m5570a(CartProduct.this);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"ClickableViewAccessibility"})
    
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        ProductPrice productPrice;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        if (recyclerViewViewHolder instanceof b) {
            b bVar = (b) recyclerViewViewHolder;
            bVar.f7487t.getLayoutParams().width = BaseActivity.anInt / 6;
            bVar.f7487t.getLayoutParams().height = BaseActivity.anInt / 6;
            Glide.with((FragmentActivity) this.baseActivity).load(Util.m306b(((CartProduct) this.arrayList.get(i)).image, "xs")).into((ImageView) bVar.f7487t);
            bVar.f7489v.setText(((CartProduct) this.arrayList.get(i)).name);
            bVar.f7489v.measure(-1, -2);
            bVar.f7491x.setCurrency(((CartProduct) this.arrayList.get(i)).currency);
            bVar.f7491x.setPrice(Util.m327c(((CartProduct) this.arrayList.get(i)).currency.equals("kpf") ? ((CartProduct) this.arrayList.get(i)).priceKpf : ((CartProduct) this.arrayList.get(i)).priceKpw));
            if (((CartProduct) this.arrayList.get(i)).stock > 0 || ((CartProduct) this.arrayList.get(i)).enableBackOrder) {
                bVar.f7490w.setQty(((CartProduct) this.arrayList.get(i)).quantity);
                if (!((CartProduct) this.arrayList.get(i)).enableBackOrder) {
                    bVar.f7490w.setMax(((CartProduct) this.arrayList.get(i)).stock);
                }
                bVar.f7490w.setOnQtyChangeListener(new QuantityInput.InterfaceC3234a() { // from class: b.f.a.b.g.j
                    @Override // com.jeil.emarket.components.QuantityInput.InterfaceC3234a
                    
                    public final void mo4460a(int i2) {
                        CartProductRecylcer.this.m4463a(i, i2);
                    }
                });
            }
            bVar.f7492y.setVisibility(View.VISIBLE);
            bVar.f7492y.setCheckedImmediately(true ^ ((CartProduct) this.arrayList.get(i)).checked);
            bVar.f7492y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.b.g.f
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    CartProductRecylcer.this.m4466a(i, compoundButton, z);
                }
            });
            bVar.f7488u.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.g.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CartProductRecylcer.this.m4465a(i, view);
                }
            });
            return;
        }
        if (recyclerViewViewHolder instanceof a) {
            a aVar = (a) recyclerViewViewHolder;
            if (((CartProduct) this.arrayList.get(i)).stock > 0 || ((CartProduct) this.arrayList.get(i)).enableBackOrder) {
                aVar.f7483u.setQty(((CartProduct) this.arrayList.get(i)).quantity);
                if (!((CartProduct) this.arrayList.get(i)).enableBackOrder) {
                    aVar.f7483u.setMax(((CartProduct) this.arrayList.get(i)).stock);
                }
                aVar.f7483u.setOnQtyChangeListener(new QuantityInput.InterfaceC3234a() { // from class: b.f.a.b.g.i
                    @Override // com.jeil.emarket.components.QuantityInput.InterfaceC3234a
                    
                    public final void mo4460a(int i2) {
                        CartProductRecylcer.this.m4467b(i, i2);
                    }
                });
            }
            aVar.f7484v.m6941c(false);
            aVar.f7484v.setTextSize(14);
            aVar.f7484v.setPtSalePrice(Util.m327c(((CartProduct) this.arrayList.get(i)).priceKpf));
            aVar.f7484v.setRegularPrice(Util.m327c(((CartProduct) this.arrayList.get(i)).discountPriceKpf));
            aVar.f7485w.m6941c(false);
            aVar.f7485w.setTextSize(14);
            aVar.f7485w.setPtSalePrice(Util.m327c(((CartProduct) this.arrayList.get(i)).priceKpw));
            aVar.f7485w.setRegularPrice(Util.m327c(((CartProduct) this.arrayList.get(i)).discountPriceKpw));
            if (((CartProduct) this.arrayList.get(i)).priceKpf + ((CartProduct) this.arrayList.get(i)).discountPriceKpf != 0.0f) {
                if (((CartProduct) this.arrayList.get(i)).priceKpw + ((CartProduct) this.arrayList.get(i)).discountPriceKpw == 0.0f) {
                    productPrice = aVar.f7485w;
                }
                aVar.f7486x.setVisibility(View.VISIBLE);
                aVar.f7486x.setCheckedImmediately(!((CartProduct) this.arrayList.get(i)).checked);
                aVar.f7486x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.b.g.g
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        CartProductRecylcer.this.m4468b(i, compoundButton, z);
                    }
                });
                CartProductAdapter c1844r0 = new CartProductAdapter(this.baseActivity);
                aVar.f7482t.setAdapter(c1844r0);
                //aVar.f7482t.setLayoutManager(new LinearLayoutManager(this, this.baseActivity, 1, false));
                ViewOnTouchListenerC2092s.c cVar = new ViewOnTouchListenerC2092s.c(aVar.f7482t, new ViewTouch(this, i));
                cVar.f8590d = false;
                //cVar.f8591e = aVar.f3933a;
                aVar.f7482t.setOnTouchListener(new ViewOnTouchListenerC2092s(cVar));
                c1844r0.addAll((List) ((CartProduct) this.arrayList.get(i)).products);
            }
            productPrice = aVar.f7484v;
            productPrice.setVisibility(View.GONE);
            aVar.f7486x.setVisibility(View.VISIBLE);
            aVar.f7486x.setCheckedImmediately(!((CartProduct) this.arrayList.get(i)).checked);
            aVar.f7486x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.b.g.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    CartProductRecylcer.this.m4468b(i, compoundButton, z);
                }
            });
            CartProductAdapter c1844r02 = new CartProductAdapter(this.baseActivity);
            aVar.f7482t.setAdapter(c1844r02);
            //aVar.f7482t.setLayoutManager(new LinearLayoutManager(this, this.baseActivity, 1, false));
            ViewOnTouchListenerC2092s.c cVar2 = new ViewOnTouchListenerC2092s.c(aVar.f7482t, new ViewTouch(this, i));
            cVar2.f8590d = false;
            // cVar2.f8591e = aVar.f3933a;
            aVar.f7482t.setOnTouchListener(new ViewOnTouchListenerC2092s(cVar2));
            c1844r02.addAll((List) ((CartProduct) this.arrayList.get(i)).products);
        }
    }

    /* renamed from: f */
    public  void m4469f(int i) {
        CartProductVM.m5570a((CartProduct) this.arrayList.get(i));
    }

    /* renamed from: g */
    public  void m4470g(int i) {
        CartProductVM.m5570a((CartProduct) this.arrayList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return i == 1 ? new a(from.inflate(R.layout.item_cart_discount, viewGroup, false)) : new b(from.inflate(R.layout.item_product_cart, viewGroup, false));
    }
}
