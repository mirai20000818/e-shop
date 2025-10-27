package com.jeil.emarket.frag.main.good;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.google.gson.Gson;
import com.jeil.emarket.activities.auth.LoginActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.order.CheckoutActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.activities.vendor.VendorActivity;
import com.jeil.emarket.adapters.fbt.ProductAdapter;
import com.jeil.emarket.components.QuantityInput;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.dialog.widget.popup.BubblePopup;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.viewpager.LoopViewPager;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.ImageDialog3;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.interf.InterfaceVariableProduct;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;
import com.jeil.emarket.providers.ProductsProvider;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.ProductTotalVM;
import com.jeil.emarket.viewmodel.ProductVendorVM;
import com.jeil.emarket.viewmodel.UserVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.g.b.c.m0 */

public class ReminderFragment extends Fragment implements InterfaceVariableProduct {

    /* renamed from: a0 */
    public ProductsProvider f9429a0;

    /* renamed from: b0 */
    public int f9430b0;

    /* renamed from: c0 */
    public ProductActivity f9431c0;

    /* renamed from: d0 */
    public ProductDetail f9432d0;

    /* renamed from: e0 */
    public ImageDialog3 f9433e0;

    /* renamed from: f0 */
    public View f9434f0;

    /* renamed from: g0 */
    public java.lang.String f9435g0;

    /* renamed from: h0 */
    public BubblePopup f9436h0;

    /* renamed from: i0 */
    public int f9437i0 = 86400000;

    /* renamed from: j0 */
    public int f9438j0 = 3600000;

    /* renamed from: k0 */
    public int f9439k0 = 60000;

    /* renamed from: l0 */
    public int f9440l0 = 1000;

    /* renamed from: m0 */
    public CountDownTimer f9441m0;

    public ReminderFragment(ProductActivity productActivity, int i, boolean z) {
        this.f9431c0 = productActivity;
        this.f9430b0 = i;
    }

    /* renamed from: S0 */
    public  void m5036S0() {
        this.f9436h0.findViewById(R.id.iv_refresh).setVisibility(View.GONE);
        this.f9436h0.findViewById(R.id.tl_price_no).setVisibility(View.VISIBLE);
    }

    /* renamed from: T0 */
    public  void m5037T0() {
        this.f9436h0.dismiss();
        Util.toast(this.f9431c0, R.string.server_failed, "error");
        this.f9436h0 = null;
    }

    /* renamed from: U0 */
    public void m5038U0() {
        this.f9429a0 = (ProductsProvider) new ViewModelProvider(this).get(ProductsProvider.class);
        this.f9429a0.f10531d.setValue( Integer.valueOf(this.f9430b0));
        this.f9429a0.m5663a(this.f9431c0, this.f9430b0, false);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.c.k0
            @Override // java.lang.Runnable
            public final void run() {
                ReminderFragment.this.m5039V0();
            }
        }, Status.time);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: V0 */
    public void m5039V0() {
        ProductTotalVM.f10237e.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.c.l
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ReminderFragment.this.m5050a((ProductDetail) obj);
            }
        });
        this.f9429a0.f10533f.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.c.i
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ReminderFragment.this.m5055b((List) obj);
            }
        });
        ProductVendorVM.f10376d.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.c.h
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ReminderFragment.this.m5057c((List) obj);
            }
        });
        this.f9431c0.findViewById(R.id.mrl_add_to_wishlist).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReminderFragment.this.m5056c(view);
            }
        });
        this.f9434f0.findViewById(R.id.mrl_vendor_link).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReminderFragment.this.m5058d(view);
            }
        });
    }

    /* renamed from: W0 */
    public void m5040W0() {
        ProductActivity productActivity = this.f9431c0;
        if (productActivity != null) {
            View findViewById = productActivity.findViewById(R.id.header_border);
            View mo4310w = this.f9431c0.mo4310w();
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) this.f9434f0.findViewById(R.id.mrl_scroll_top);
            if (materialRippleLayout != null) {
                this.f9431c0.m4293a((NestedScrollView) this.f9434f0.findViewById(R.id.nsv_main), materialRippleLayout, mo4310w, findViewById, this.f9431c0.findViewById(R.id.bottom_border), true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9434f0 = layoutInflater.inflate(R.layout.fragment_product_description, viewGroup, false);
        m5038U0();
        this.f9434f0.findViewById(R.id.vp_images).getLayoutParams().height = BaseActivity.anInt - (BaseActivity.anInt2 * 4);
        this.f9434f0.findViewById(R.id.vp_shimmer_images).getLayoutParams().height = BaseActivity.anInt - (BaseActivity.anInt2 * 4);
        final NestedScrollView nestedScrollView = (NestedScrollView) this.f9434f0.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            BaseActivity activityC1391g1 = (BaseActivity) getActivity();
            activityC1391g1.m4286a((View) nestedScrollView, activityC1391g1, (View) null, false).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    nestedScrollView.smoothScrollBy(0, 0, 300);
                }
            });
        }
        m5040W0();
        return this.f9434f0;
    }

    @SuppressLint({"SetTextI18n", "StringFormatMatches", "RestrictedApi"})

    public void m5043a(int i, boolean z, java.lang.String str) {
        Resources resources;
        int i2 = 0;
        QuantityInput quantityInput = (QuantityInput) this.f9434f0.findViewById(R.id.cqi_quantity);
        if (quantityInput == null) {
            return;
        }
        if (i == 0 || (str != null && str.equals("variable"))) {
            quantityInput.setDisable("plus");
            quantityInput.setDisable("minus");
        } else if (str == null) {
            quantityInput.setEnable("plus");
            quantityInput.setEnable("minus");
        }
        if (z) {
            quantityInput.setQty(quantityInput.getQty());
        } else {
            quantityInput.setMax(i);
        }
        TextView textView = (TextView) this.f9434f0.findViewById(R.id.tv_stock);
        if (str == null || !str.equals("variable")) {
            if (i <= 0) {
                textView.setText(R.string.empty_stock);
                textView.setTextColor(this.f9431c0.getResources().getColor(R.color.danger));
                resources = this.f9431c0.getResources();
                i2 = R.drawable.ic_close_sm;
            } else if (i <= Status.f8815f) {
                textView.setText(i + this.f9431c0.getResources().getString(R.string.left_count));
                textView.setTextColor(this.f9431c0.getResources().getColor(R.color.danger));
            } else {
                textView.setText(R.string.in_stock);
                textView.setTextColor(this.f9431c0.getResources().getColor(R.color.success));
                resources = this.f9431c0.getResources();
                i2 = R.drawable.ic_check_lg;
            }
            //textView.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(BaseActivity.anInt2 / 2);
            return;
        }
        textView.setText("");
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }


    public  void m5045a(ImageView imageView) {
        this.f9433e0.m4882a(0);
        ImageDialog3 dialogC2269y2 = this.f9433e0;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }


    public  void m5046a(MaterialRippleLayout materialRippleLayout, ProductDetail productDetail, View view) {
        boolean z;
        int i;
        Handler handler;
        Runnable runnable;
        if (this.f9436h0 == null) {
            BubblePopup bubblePopup = new BubblePopup(getContext(), View.inflate(getContext(), R.layout.dialog_price_number, null));
            bubblePopup.m6907c(materialRippleLayout);
            bubblePopup.m4596a(80);
            this.f9436h0 = bubblePopup;
            z = true;
        } else {
            z = false;
        }
        BubblePopup bubblePopup2 = this.f9436h0;
        if (bubblePopup2.f12222A != null) {
            bubblePopup2.mo4597f();
        }
        this.f9436h0.show();
        if (z) {
            java.lang.String str = productDetail.data.priceNo;
            if (str == null || str.isEmpty()) {
                i = 0;
            } else {
                ((TextView) this.f9436h0.findViewById(R.id.tv_price_no)).setText(productDetail.data.priceNo);
                i = 1;
            }
            java.lang.String str2 = productDetail.data.priceApprovedNo;
            if (str2 != null && !str2.isEmpty()) {
                i++;
                ((TextView) this.f9436h0.findViewById(R.id.tv_price_approved_no)).setText(productDetail.data.priceApprovedNo);
            }
            if (productDetail.data.priceApprovedAt != null) {
                i++;
                ((TextView) this.f9436h0.findViewById(R.id.tv_price_approved_at)).setText(Util.date2Str(productDetail.data.priceApprovedAt));
            }
            this.f9436h0.findViewById(R.id.tl_price_no).setVisibility(View.GONE);
            this.f9436h0.findViewById(R.id.iv_refresh).setVisibility(View.VISIBLE);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f9436h0.findViewById(R.id.iv_refresh), "rotation", 0.0f, 180.0f, 360.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.start();
            if (i > 1) {
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.g.b.c.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReminderFragment.this.m5036S0();
                    }
                };
            } else {
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.g.b.c.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReminderFragment.this.m5037T0();
                    }
                };
            }
            handler.postDelayed(runnable, 2000L);
        }
    }


    public void m5047a(final CartProduct cartProduct) {
        final View inflate = LayoutInflater.from(this.f9431c0).inflate(R.layout.dialog_payment_agree, (ViewGroup) null);
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.f9431c0, inflate);
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_ok);
        if (customButton != null) {
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReminderFragment.this.m5044a(inflate, cartProduct, baseDialog2, view);
                }
            });
        }
        baseDialog2.show();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2713g
    @SuppressLint({"SetTextI18n"})

    public void mo4598a(Product.VariableProduct variableProduct) {
        if (variableProduct != null) {
            java.lang.String str = variableProduct.product.image;
            if (str != null && !str.isEmpty()) {
                LoopViewPager loopViewPager = (LoopViewPager) this.f9434f0.findViewById(R.id.vp_images);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f9432d0.data.image);
                for (Product.VariableProduct variableProduct2 : this.f9432d0.data.variableProducts) {
                    java.lang.String str2 = variableProduct2.product.image;
                    if (str2 != null && !str2.isEmpty()) {
                        if (!arrayList.contains(variableProduct2.product.image)) {
                            arrayList.add(variableProduct2.product.image);
                        }
                        if (variableProduct2.equals(variableProduct)) {
                            loopViewPager.setCurrentItem(arrayList.contains(variableProduct2.product.image) ? arrayList.indexOf(variableProduct2.product.image) : 0);
                        }
                    }
                }
            }
            TextView textView = (TextView) this.f9434f0.findViewById(R.id.tv_discount_label);
            StringBuilder sb = new StringBuilder();
            Product product = variableProduct.product;
            float f = product.salePrice;
            float f2 = product.regularPrice;
            sb.append(java.lang.String.format("%.1f", Float.valueOf(((f - f2) * 100.0f) / f2)));
            sb.append("%");
            java.lang.String sb2 = sb.toString();
            Product product2 = variableProduct.product;
            float f3 = product2.salePrice;
            boolean z = f3 > 0.0f && f3 < product2.regularPrice;
            TextView textView2 = (TextView) this.f9434f0.findViewById(R.id.tv_title);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(z ? CustomString.append(sb2, "   ") : "");
            java.lang.String str3 = variableProduct.product.name;
            if (str3 == null) {
                str3 = "";
            }
            sb3.append((Object) Html.fromHtml(str3));
            textView2.setText(sb3.toString());
            textView.setText(sb2);
            textView.setVisibility(z ? View.VISIBLE : View.GONE);
            ProductPrice productPrice = (ProductPrice) this.f9431c0.findViewById(R.id.pp_top_product_price);
            productPrice.m6941c(false);
            productPrice.setCurrency(this.f9432d0.data.currency);
            productPrice.setTextSize(18);
            productPrice.setRegularPriceSize(17);
            Product product3 = variableProduct.product;
            float f4 = product3.salePrice;
            if (f4 > 0.0f) {
                productPrice.setPtSalePrice(Util.m327c(f4));
                Product product4 = variableProduct.product;
                float f5 = product4.regularPrice;
                if (f5 <= 0.0f || f5 == product4.salePrice) {
                    productPrice.m6939a(false);
                } else {
                    productPrice.setRegularPrice(Util.m327c(f5));
                }
            } else {
                productPrice.setPtSalePrice(Util.m327c(product3.regularPrice));
            }
            Product product5 = variableProduct.product;
            m5043a(product5.stock, product5.enableBackOrder, (java.lang.String) null);
            m5053b(variableProduct);
            return;
        }
        TextView textView3 = (TextView) this.f9434f0.findViewById(R.id.tv_discount_label);
        StringBuilder sb4 = new StringBuilder();
        Product product6 = this.f9432d0.data;
        float f6 = product6.salePrice;
        float f7 = product6.regularPrice;
        sb4.append(java.lang.String.format("%.1f", Float.valueOf(((f6 - f7) * 100.0f) / f7)));
        sb4.append("%");
        java.lang.String sb5 = sb4.toString();
        Product product7 = this.f9432d0.data;
        float f8 = product7.salePrice;
        boolean z2 = f8 > 0.0f && f8 < product7.regularPrice;
        if (this.f9432d0.data.type.equals("variable")) {
            java.lang.String m327c = Util.m327c(this.f9432d0.data.minPrice);
            java.lang.String m327c2 = Util.m327c(this.f9432d0.data.maxPrice);
            java.lang.String m327c3 = Util.m327c(this.f9432d0.data.maxRegularPrice);
            if (!m327c3.isEmpty() && m327c.equals(m327c2) && !m327c.equals(m327c3)) {
                StringBuilder sb6 = new StringBuilder();
                Product product8 = this.f9432d0.data;
                float f9 = product8.minPrice;
                float f10 = product8.maxRegularPrice;
                sb6.append(java.lang.String.format("%.1f", Float.valueOf(((f9 - f10) * 100.0f) / f10)));
                sb6.append("%");
                sb5 = sb6.toString();
                Product product9 = this.f9432d0.data;
                float f11 = product9.minPrice;
                z2 = f11 > 0.0f && f11 < product9.maxRegularPrice;
            }
        }
        TextView textView4 = (TextView) this.f9434f0.findViewById(R.id.tv_title);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(z2 ? CustomString.append(sb5, "   ") : "");
        java.lang.String str4 = this.f9432d0.data.name;
        if (str4 == null) {
            str4 = "";
        }
        sb7.append((Object) Html.fromHtml(str4));
        textView4.setText(sb7.toString());
        textView3.setText(sb5);
        textView3.setVisibility(z2 ? View.VISIBLE : View.GONE);
        LoopViewPager loopViewPager2 = (LoopViewPager) this.f9434f0.findViewById(R.id.vp_images);
        if (loopViewPager2 != null) {
            loopViewPager2.setCurrentItem(0);
        }
        ProductPrice productPrice2 = (ProductPrice) this.f9431c0.findViewById(R.id.pp_top_product_price);
        productPrice2.setCurrency(this.f9432d0.data.currency);
        if (this.f9432d0.data.type.equals("variable")) {
            java.lang.String m327c4 = Util.m327c(this.f9432d0.data.minPrice);
            java.lang.String m327c5 = Util.m327c(this.f9432d0.data.maxPrice);
            java.lang.String m327c6 = Util.m327c(this.f9432d0.data.maxRegularPrice);
            if (m327c6.isEmpty() || !m327c4.equals(m327c5) || m327c4.equals(m327c6)) {
                productPrice2.m6938a(m327c4, m327c5);
            } else {
                productPrice2.setPtSalePrice(m327c4);
                productPrice2.setRegularPrice(m327c6);
            }
        } else {
            Product product10 = this.f9432d0.data;
            float f12 = product10.salePrice;
            if (f12 > 0.0f) {
                productPrice2.setPtSalePrice(Util.m327c(f12));
                Product product11 = this.f9432d0.data;
                float f13 = product11.regularPrice;
                if (f13 <= 0.0f || f13 == product11.salePrice) {
                    productPrice2.m6939a(false);
                } else {
                    productPrice2.setRegularPrice(Util.m327c(f13));
                }
            } else {
                productPrice2.setPtSalePrice(Util.m327c(product10.regularPrice));
            }
        }
        Product product12 = this.f9432d0.data;
        m5043a(product12.stock, product12.enableBackOrder, product12.type);
        m5053b((Product.VariableProduct) null);
    }


    public  void m5048a(Product.VariableProduct variableProduct, View view) {
        m5049a(variableProduct, false);
    }


    public void m5049a(Product.VariableProduct variableProduct, boolean z) {
        float f;
        float f2;
        ProductDetail productDetail = this.f9432d0;
        if (productDetail == null) {
            return;
        }
        float f3 = 0.0f;
        if (variableProduct == null) {
            if (productDetail.data.type.equals("variable")) {
                Util.toast(this.f9431c0, R.string.select_attribute, "error");
                return;
            }
            Product product = this.f9432d0.data;
            if (product.stock <= 0 && !product.enableBackOrder) {
                Util.toast(this.f9431c0, R.string.empty_stock_notice, "error");
                return;
            }
            int qty = ((QuantityInput) this.f9434f0.findViewById(R.id.cqi_quantity)).getQty();
            if (qty <= 0) {
                Util.m329c(this.f9431c0, R.string.select_stock);
                return;
            }
            CartProduct cartProduct = new CartProduct();
            Product product2 = this.f9432d0.data;
            cartProduct.f12392id = product2.f12407id;
            cartProduct.name = product2.name;
            cartProduct.image = product2.image;
            if (product2.currency.equals("kpf")) {
                Product product3 = this.f9432d0.data;
                float f4 = product3.salePrice;
                f2 = f4 > 0.0f ? f4 : product3.regularPrice;
            } else {
                f2 = 0.0f;
            }
            cartProduct.priceKpf = f2;
            if (this.f9432d0.data.currency.equals("kpw")) {
                Product product4 = this.f9432d0.data;
                float f5 = product4.salePrice;
                f3 = f5 > 0.0f ? f5 : product4.regularPrice;
            }
            cartProduct.priceKpw = f3;
            ProductDetail productDetail2 = this.f9432d0;
            Product product5 = productDetail2.data;
            cartProduct.enableBackOrder = product5.enableBackOrder;
            cartProduct.quantity = qty;
            cartProduct.currency = product5.currency;
            cartProduct.stock = product5.stock;
            ProductDetail.VendorInfo vendorInfo = productDetail2.vendorInfo;
            cartProduct.vendorId = vendorInfo.f12414id;
            cartProduct.vendorName = vendorInfo.name;
            cartProduct.discountRules = new ArrayList(product5.discountRules);
            cartProduct.checked = true;
            if (z) {
                m5047a(cartProduct);
                return;
            } else {
                CartProductVM.m5571a(cartProduct, this.f9431c0);
                return;
            }
        }
        Product product6 = variableProduct.product;
        if (product6.stock <= 0 && !product6.enableBackOrder) {
            Util.toast(this.f9431c0, R.string.empty_stock_notice, "error");
            return;
        }
        int qty2 = ((QuantityInput) this.f9434f0.findViewById(R.id.cqi_quantity)).getQty();
        if (qty2 <= 0) {
            Util.m329c(this.f9431c0, R.string.select_stock);
            return;
        }
        CartProduct cartProduct2 = new CartProduct();
        Product product7 = variableProduct.product;
        cartProduct2.f12392id = product7.f12407id;
        Product product8 = this.f9432d0.data;
        cartProduct2.parentId = product8.f12407id;
        cartProduct2.name = product7.name;
        cartProduct2.image = product7.image;
        if (product8.currency.equals("kpf")) {
            Product product9 = variableProduct.product;
            float f6 = product9.salePrice;
            f = f6 > 0.0f ? f6 : product9.regularPrice;
        } else {
            f = 0.0f;
        }
        cartProduct2.priceKpf = f;
        if (this.f9432d0.data.currency.equals("kpw")) {
            Product product10 = variableProduct.product;
            float f7 = product10.salePrice;
            f3 = f7 > 0.0f ? f7 : product10.regularPrice;
        }
        cartProduct2.priceKpw = f3;
        cartProduct2.quantity = qty2;
        Product product11 = variableProduct.product;
        cartProduct2.enableBackOrder = product11.enableBackOrder;
        cartProduct2.currency = this.f9432d0.data.currency;
        cartProduct2.stock = product11.stock;
        cartProduct2.discountRules = new ArrayList();
        List<Product.DiscountRule> list = variableProduct.product.discountRules;
        if (list != null) {
            cartProduct2.discountRules.addAll(list);
        }
        ProductDetail.VendorInfo vendorInfo2 = this.f9432d0.vendorInfo;
        cartProduct2.vendorId = vendorInfo2.f12414id;
        cartProduct2.vendorName = vendorInfo2.name;
        cartProduct2.checked = true;
        if (z) {
            m5047a(cartProduct2);
        } else {
            CartProductVM.m5571a(cartProduct2, this.f9431c0);
        }
    }


    public  void m5051a(List list) {
        m5041a(R.id.tv_related_products, R.id.rv_related_products, (List<Product>) list);
    }

    
    public  void m5052b(int i, ImageView imageView) {
        this.f9433e0.m4882a(i);
        ImageDialog3 dialogC2269y2 = this.f9433e0;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }

    
    public void m5053b(final Product.VariableProduct variableProduct) {
        this.f9431c0.findViewById(R.id.cb_cart).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReminderFragment.this.m5048a(variableProduct, view);
            }
        });
        this.f9431c0.findViewById(R.id.cb_buy_now).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReminderFragment.this.m5054b(variableProduct, view);
            }
        });
    }

    
    public  void m5054b(Product.VariableProduct variableProduct, View view) {
        if (UserVM.userMutableLiveData.getValue() != null) {
            m5049a(variableProduct, true);
        } else {
            ProductActivity productActivity = this.f9431c0;
            productActivity.startActivity(new Intent(productActivity.getApplicationContext(), LoginActivity.class));
        }
    }

    
    public  void m5055b(List list) {
        if (list.size() > 0) {
            m5041a(R.id.tv_bought_products, R.id.rv_bought_products, (List<Product>) list);
            this.f9434f0.findViewById(R.id.tv_bought_products).setVisibility(View.VISIBLE);
            this.f9434f0.findViewById(R.id.rv_bought_products).setVisibility(View.VISIBLE);
        }
    }

    
    public  void m5057c(List list) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.f9431c0.findViewById(R.id.iv_wishlist_product);
        int i = this.f9430b0;
        MutableLiveData<List<Integer>> mutableLiveData = ProductVendorVM.f10376d;
        appCompatImageView.setImageResource(mutableLiveData != null && mutableLiveData.getValue() != null && ProductVendorVM.f10376d.getValue().contains(Integer.valueOf(i)) ? R.drawable.ic_wishlist_full : R.drawable.ic_wishlist_empty);
    }

    
    public  void m5058d(View view) {
        Intent intent = new Intent(this.f9431c0.getApplicationContext(), VendorActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id", ((ProductDetail) Objects.requireNonNull(ProductTotalVM.f10237e.getValue())).vendorInfo.f12414id);
        startActivity(intent, (Bundle) null);
    }


    public  void m5042a(int i, ImageView imageView) {
        this.f9433e0.m4882a(i);
        ImageDialog3 dialogC2269y2 = this.f9433e0;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }

    
    public  void m5056c(View view) {
        ProductVendorVM.m5575a(this.f9430b0, ((ProductDetail) Objects.requireNonNull(ProductTotalVM.f10237e.getValue())).data);
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0715, code lost:
    
        r1 = r2;
        r3 = r6;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m5050a(final com.jeil.emarket.model.customer.ProductDetail r18) {
        /*
            Method dump skipped, instructions count: 1896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p231g.p233b.p236c.C2417m0.m5050a(com.jeil.emarket.model.customer.ProductDetail):void");
    }


    public  void m5044a(@SuppressLint({"InflateParams"}) View view, CartProduct cartProduct, BaseDialog2 baseDialog2, View view2) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_agree);
        if (checkBox != null && checkBox.isChecked()) {
            Intent intent = new Intent(this.f9431c0.getApplicationContext(), CheckoutActivity.class);
            intent.putExtra("buyNow", true);
            intent.putExtra("cart", new Gson().toJson(cartProduct));
            startActivity(intent, (Bundle) null);
            baseDialog2.startAni();
            return;
        }
        Util.toast(this.f9431c0, R.string.agree_notice, "error");
    }

    /* JADX WARN: Multi-variable type inference failed */

    public void m5041a(int i, int i2, List<Product> list) {
        Util.setColor(this.f9431c0, (android.widget.TextView) this.f9434f0.findViewById(i), R.color.dark);
        if (list.isEmpty()) {
            this.f9434f0.findViewById(i).setVisibility(View.GONE);
            this.f9434f0.findViewById(i2).setVisibility(View.GONE);
            return;
        }
        this.f9434f0.findViewById(i).setVisibility(View.VISIBLE);
        this.f9434f0.findViewById(i2).setVisibility(View.VISIBLE);
        RecyclerView recyclerView = (RecyclerView) this.f9434f0.findViewById(i2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),  RecyclerView.HORIZONTAL, false);
        ProductAdapter c1879s = new ProductAdapter(this.f9431c0, "mini");
        c1879s.arrayList = list;
        c1879s.notifyDataSetChanged();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(c1879s);
    }
}
