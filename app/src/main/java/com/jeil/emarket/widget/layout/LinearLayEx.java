package com.jeil.emarket.widget.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.components.GradientScrollLayout;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.InterfaceVariableProduct;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.ProductTotalVM;
import com.jeil.emarket.widget.layout2.LinearLayoutCompat2;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* renamed from: b.f.a.c.e0.d */

public class LinearLayEx extends LinearLayoutCompat {

    /* renamed from: q */
    public BaseActivity f8295q;

    /* renamed from: r */
    public LinearLayoutCompat f8296r;

    /* renamed from: s */
    public LinearLayoutCompat f8297s;

    /* renamed from: t */
    public CustomButton f8298t;

    /* renamed from: u */
    public float f8299u;

    /* renamed from: v */
    public float f8300v;

    /* renamed from: w */
    public float f8301w;

    /* renamed from: x */
    public float f8302x;

    /* renamed from: y */
    public ProductPrice f8303y;

    /* renamed from: z */
    public ProductPrice f8304z;

    public LinearLayEx(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f8299u = 0.0f;
        this.f8300v = 0.0f;
        this.f8301w = 0.0f;
        this.f8302x = 0.0f;
        this.f8295q = activityC1391g1;
        m4604h();
    }

    
    public  void m4599a(ProductDetail.Fbt.Product product, View view) {
        Intent intent = new Intent(this.f8295q, ProductActivity.class);
        intent.putExtra("id", product.f12413id);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ProductTotalVM.m5467b(this.f8295q, product.f12413id);
        this.f8295q.startActivity(intent);
    }

    
    public  void m4600a(ProductDetail.Fbt.Product product, Product.VariableProduct variableProduct) {
        product.cartProduct = variableProduct;
        CustomButton customButton = this.f8298t;
        if (variableProduct != null) {
            customButton.setEnabled(true);
            this.f8298t.setAlpha(1.0f);
        } else {
            customButton.setEnabled(false);
            this.f8298t.setAlpha(0.9f);
            Util.toast(this.f8295q, R.string.cannot_cart, "error");
        }
    }

    
    public void m4601a(ProductDetail.Fbt fbt, final ProductDetail.Fbt.Product product, int i, boolean z) {
        LinearLayoutCompat.LayoutParams c0541a;
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f8295q);
        linearLayoutCompat.setGravity(16);
        if (i != 0) {
            TextView textView = new TextView(this.f8295q);
            textView.setText("+");
            textView.setTextSize(1, 20.0f);
            int i2 = BaseActivity.anInt2;
            textView.setPadding(i2, 0, i2, 0);
            linearLayoutCompat.addView(textView);
        }
        MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this.f8295q);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this.f8295q);
        materialRippleLayout.addView(appCompatImageView, new FrameLayout.LayoutParams(-1, -1));
        if (i == 0) {
            c0541a = new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this.f8295q, 70), Util.dp2px((Context) this.f8295q, 70));
            c0541a.setMargins(BaseActivity.anInt2 * 2, 0, 0, 0);
        } else if (i == fbt.products.size()) {
            c0541a = new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this.f8295q, 70), Util.dp2px((Context) this.f8295q, 70));
            c0541a.setMargins(0, 0, BaseActivity.anInt2 * 2, 0);
        } else {
            c0541a = new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this.f8295q, 70), Util.dp2px((Context) this.f8295q, 70));
        }
        linearLayoutCompat.addView(materialRippleLayout, c0541a);
        appCompatImageView.setTag(Integer.valueOf(R.id.iv_product_img));
        ((RequestBuilder) CustomString.m3152a(this.f8295q, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.f8295q).load(Util.m306b(product.image, "mdm")).diskCacheStrategy(DiskCacheStrategy.ALL))).into((ImageView) appCompatImageView);
        if (z) {
            materialRippleLayout.setEnabled(false);
        } else {
            materialRippleLayout.setRippleOverlay(true);
            materialRippleLayout.setDefaultRippleAlpha(20);
        }
        appCompatImageView.setBackgroundResource(R.drawable.bd_rect_thin);
        int m170a = Util.dp2px((Context) this.f8295q, 1);
        appCompatImageView.setPadding(m170a, m170a, m170a, m170a);
        if (!z) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.e0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LinearLayEx.this.m4599a(product, view);
                }
            });
        }
        this.f8296r.addView(linearLayoutCompat);
        LinearLayoutCompat linearLayoutCompat2 = new LinearLayoutCompat(this.f8295q);
        LinearLayoutCompat linearLayoutCompat3 = new LinearLayoutCompat(this.f8295q);
        LinearLayoutCompat2 c2057o = new LinearLayoutCompat2(this.f8295q);
        CheckBox checkBox = new CheckBox(this.f8295q);
        ProductPrice productPrice = new ProductPrice(this.f8295q, null);
        linearLayoutCompat2.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat2.addView(linearLayoutCompat3);
        linearLayoutCompat2.addView(c2057o, new LinearLayoutCompat.LayoutParams(-1, -2));
        checkBox.m6904a(Util.dp2px((Context) this.f8295q, 20), Util.dp2px((Context) this.f8295q, 20), Util.dp2px((Context) this.f8295q, 16), Util.dp2px((Context) this.f8295q, 1));
        linearLayoutCompat3.setGravity(16);
        linearLayoutCompat3.setOrientation(LinearLayoutCompat.HORIZONTAL);
        int i3 = BaseActivity.anInt2;
        linearLayoutCompat3.setPadding(0, i3 / 2, 0, i3 / 2);
        checkBox.setText(product.name);
        checkBox.setTextSize(1, 12.0f);
        checkBox.setTextColor(this.f8295q.getResources().getColor(R.color.dark));
        checkBox.setSingleLine(true);
        checkBox.setEllipsize(TextUtils.TruncateAt.END);
        checkBox.setTag(Integer.valueOf(R.id.tv_product_name));
        checkBox.setGravity(16);
        int i4 = BaseActivity.anInt2;
        checkBox.setPadding((i4 * 3) / 4, i4 / 2, i4, i4 / 2);
        productPrice.m6941c(false);
        productPrice.setGravity(16);
        productPrice.setTextSize(14);
        productPrice.setRegularPriceSize(14);
        productPrice.setCurrency(product.currency);
        productPrice.setPtSalePrice(Util.m327c(((100.0f - product.discount) * product.price) / 100.0f));
        if (product.discount > 0.0f) {
            productPrice.setRegularPrice(Util.m327c(product.price));
        }
        productPrice.setGravity(16);
        productPrice.setTag(Integer.valueOf(R.id.pp_product_price));
        int m170a2 = Util.dp2px((Context) this.f8295q, 24);
        int i5 = BaseActivity.anInt2;
        c2057o.setPadding(m170a2, i5 / 2, i5 / 2, i5);
        checkBox.measure(-2, -2);
        checkBox.setChecked(true);
        product.isChecked = true;
        checkBox.setEnabled(false);
        List<Product.VariableProduct> list = product.variableProducts;
        if (list == null || list.size() <= 0) {
            c2057o.setVisibility(View.GONE);
        } else {
            c2057o.m4641a(new InterfaceVariableProduct() { // from class: b.f.a.c.e0.b
                @Override // p078b.p159f.p160a.p253h.InterfaceC2713g
                
                public final void mo4598a(Product.VariableProduct variableProduct) {
                    LinearLayEx.this.m4600a(product, variableProduct);
                }
            });
            c2057o.m4646a(product.variableAttributes, product.customAttributes, product.variableProducts, this.f8295q);
        }
        linearLayoutCompat3.addView(checkBox, new LinearLayoutCompat.LayoutParams(-2, -2, 1.0f));
        linearLayoutCompat3.addView(productPrice, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.f8297s.addView(linearLayoutCompat2, new LinearLayoutCompat.LayoutParams(-1, -2));
        java.lang.String str = product.currency;
        if (str == null) {
            str = "kpf";
        }
        product.currency = str;
        this.f8299u += product.currency.equals("kpf") ? product.price : 0.0f;
        this.f8300v += product.currency.equals("kpw") ? product.price : 0.0f;
        this.f8301w += product.currency.equals("kpf") ? ((100.0f - product.discount) * product.price) / 100.0f : 0.0f;
        this.f8302x += product.currency.equals("kpw") ? ((100.0f - product.discount) * product.price) / 100.0f : 0.0f;
    }

    
    public void m4602a(final ProductDetail.Fbt fbt, final ProductDetail productDetail) {
        List<ProductDetail.Fbt.Product> list = fbt.products;
        if (list == null || list.size() == 0) {
            setVisibility(View.GONE);
            return;
        }
        for (int i = 0; i < fbt.products.size(); i++) {
            ProductDetail.Fbt.Product product = fbt.products.get(i);
            m4601a(fbt, product, i, product.f12413id == productDetail.data.f12407id);
        }
        this.f8303y.setPtSalePrice(Util.m327c(this.f8301w));
        this.f8303y.setRegularPrice(Util.m327c(this.f8299u));
        this.f8304z.setPtSalePrice(Util.m327c(this.f8302x));
        this.f8304z.setRegularPrice(Util.m327c(this.f8300v));
        if (this.f8299u + this.f8301w <= 0.0f) {
            this.f8303y.setVisibility(View.GONE);
        }
        if (this.f8300v + this.f8302x <= 0.0f) {
            this.f8304z.setVisibility(View.GONE);
        }
        this.f8298t.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.e0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinearLayEx.this.m4603a(fbt, productDetail, view);
            }
        });
    }

    
    public  void m4603a(ProductDetail.Fbt fbt, ProductDetail productDetail, View view) {
        int i;
        CartProduct cartProduct = new CartProduct();
        ArrayList arrayList = new ArrayList();
        int i2 = Integer.MAX_VALUE;
        for (ProductDetail.Fbt.Product product : fbt.products) {
            if (product.isChecked) {
                if (product.cartProduct == null) {
                    CartProduct cartProduct2 = new CartProduct();
                    cartProduct2.f12392id = product.f12413id;
                    cartProduct2.name = product.name;
                    cartProduct2.image = product.image;
                    cartProduct2.currency = product.currency;
                    cartProduct2.priceKpf = cartProduct2.currency.equals("kpf") ? ((100.0f - product.discount) * product.price) / 100.0f : 0.0f;
                    cartProduct2.priceKpw = cartProduct2.currency.equals("kpw") ? ((100.0f - product.discount) * product.price) / 100.0f : 0.0f;
                    cartProduct2.quantity = 1;
                    cartProduct2.stock = product.stock;
                    ProductDetail.VendorInfo vendorInfo = productDetail.vendorInfo;
                    cartProduct2.vendorId = vendorInfo.f12414id;
                    cartProduct2.vendorName = vendorInfo.name;
                    cartProduct2.discountPriceKpf = cartProduct2.currency.equals("kpf") ? (product.price * product.discount) / 100.0f : 0.0f;
                    cartProduct2.discountPriceKpw = cartProduct2.currency.equals("kpw") ? (product.price * product.discount) / 100.0f : 0.0f;
                    StringBuilder sb = new StringBuilder();
                    sb.append(cartProduct.discountProducts);
                    cartProduct.discountProducts = CustomString.m3159a(sb, product.f12413id, ",");
                    arrayList.add(cartProduct2);
                    i = product.stock;
                    if (i < i2) {
                        i2 = i;
                    }
                } else {
                    CartProduct cartProduct3 = new CartProduct();
                    Product product2 = product.cartProduct.product;
                    cartProduct3.f12392id = product2.f12407id;
                    cartProduct3.name = product2.name;
                    cartProduct3.image = product2.image;
                    cartProduct3.currency = product.currency;
                    cartProduct3.priceKpf = cartProduct3.currency.equals("kpf") ? ((100.0f - product.discount) * product2.salePrice) / 100.0f : 0.0f;
                    cartProduct3.priceKpw = cartProduct3.currency.equals("kpw") ? ((100.0f - product.discount) * product2.salePrice) / 100.0f : 0.0f;
                    cartProduct3.quantity = 1;
                    cartProduct3.stock = product2.stock;
                    ProductDetail.VendorInfo vendorInfo2 = productDetail.vendorInfo;
                    cartProduct3.vendorId = vendorInfo2.f12414id;
                    cartProduct3.vendorName = vendorInfo2.name;
                    cartProduct3.discountPriceKpf = cartProduct3.currency.equals("kpf") ? (product2.salePrice * product.discount) / 100.0f : 0.0f;
                    cartProduct3.discountPriceKpw = cartProduct3.currency.equals("kpw") ? (product2.salePrice * product.discount) / 100.0f : 0.0f;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cartProduct.discountProducts);
                    cartProduct.discountProducts = CustomString.m3159a(sb2, product2.f12407id, ",");
                    arrayList.add(cartProduct3);
                    i = product2.stock;
                    if (i < i2) {
                        i2 = i;
                    }
                }
            }
        }
        int i3 = fbt.f12412id;
        cartProduct.f12392id = i3;
        cartProduct.discountType = "fbt";
        cartProduct.discountId = i3;
        cartProduct.stock = i2;
        cartProduct.products = arrayList;
        ProductDetail.VendorInfo vendorInfo3 = productDetail.vendorInfo;
        cartProduct.vendorId = vendorInfo3.f12414id;
        cartProduct.vendorName = vendorInfo3.name;
        cartProduct.priceKpf = this.f8301w;
        cartProduct.priceKpw = this.f8302x;
        cartProduct.discountPriceKpf = this.f8299u;
        cartProduct.discountPriceKpw = this.f8300v;
        cartProduct.quantity = 1;
        cartProduct.checked = true;
        BaseActivity activityC1391g1 = this.f8295q;
        if (i2 <= 0) {
            Util.m329c(activityC1391g1, R.string.cannot_add_to_cart);
        } else {
            CartProductVM.m5571a(cartProduct, activityC1391g1);
        }
    }

    /* renamed from: h */
    public void m4604h() {
        setBackgroundResource(R.drawable.bg_box);
        setOrientation(LinearLayoutCompat.VERTICAL);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f8295q);
        AppCompatImageView appCompatImageView = new AppCompatImageView(this.f8295q);
        TextView textView = new TextView(this.f8295q);
        TextView textView2 = new TextView(this.f8295q);
        appCompatImageView.setImageResource(R.drawable.ic_discount_percent);
        textView.setText(R.string.fbt_title);
        textView.setTextColor(getResources().getColor(R.color.dark));
        textView.setTextSize(1, 16.0f);
        textView2.setTextSize(1, 12.0f);
        textView.setPadding(BaseActivity.anInt2, 0, 0, 0);
        int i = BaseActivity.anInt2;
        linearLayoutCompat.setPadding(i * 2, i * 3, i * 2, i * 2);
        linearLayoutCompat.setGravity(16);
        linearLayoutCompat.addView(appCompatImageView, new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this.f8295q, 16), Util.dp2px((Context) this.f8295q, 16)));
        linearLayoutCompat.addView(textView, new LinearLayoutCompat.LayoutParams(-2, -2, 1.0f));
        linearLayoutCompat.addView(textView2);
        addView(linearLayoutCompat, new LinearLayoutCompat.LayoutParams(-1, -2));
        GradientScrollLayout gradientScrollLayout = new GradientScrollLayout(this.f8295q);
        this.f8296r = new LinearLayoutCompat(this.f8295q);
        this.f8296r.setGravity(16);
        gradientScrollLayout.m6824a(this.f8296r);
        addView(gradientScrollLayout, new LinearLayoutCompat.LayoutParams(-1, -2));
        LinearLayoutCompat linearLayoutCompat2 = new LinearLayoutCompat(this.f8295q);
        LinearLayoutCompat linearLayoutCompat3 = new LinearLayoutCompat(this.f8295q);
        TextView textView3 = new TextView(this.f8295q);
        this.f8303y = new ProductPrice(this.f8295q, null);
        this.f8304z = new ProductPrice(this.f8295q, null);
        this.f8298t = new CustomButton(this.f8295q);
        LinearLayoutCompat linearLayoutCompat4 = new LinearLayoutCompat(this.f8295q);
        textView3.setText("=");
        textView3.setTextSize(1, 20.0f);
        textView3.setPadding(0, 0, (BaseActivity.anInt2 * 3) / 2, 0);
        this.f8303y.m6941c(false);
        this.f8303y.setGravity(16);
        this.f8303y.setTextSize(18);
        this.f8303y.setRegularPriceSize(18);
        this.f8303y.setCurrency("kpf");
        this.f8304z.m6941c(false);
        this.f8304z.setGravity(16);
        this.f8304z.setTextSize(18);
        this.f8304z.setRegularPriceSize(18);
        this.f8304z.setCurrency("kpw");
        this.f8298t.setText(R.string.add_to_cart);
        this.f8298t.setIconSize(getResources().getDimensionPixelSize(R.dimen._18sdp));
        this.f8298t.setTextSize(1, 12.5f);
        this.f8298t.setIconPadding(getResources().getDimensionPixelSize(R.dimen._5sdp));
        this.f8298t.setIcon(this.f8295q.getResources().getDrawable(R.drawable.ic_cart));
        this.f8298t.setCornerRadius(getResources().getDimensionPixelSize(R.dimen._30sdp));
        this.f8298t.setButtonColor(this.f8295q.getResources().getColor(R.color.dark));
        linearLayoutCompat3.addView(textView3);
        linearLayoutCompat3.addView(linearLayoutCompat2, new LinearLayoutCompat.LayoutParams(-2, -2, 1.0f));
        linearLayoutCompat3.setGravity(16);
        linearLayoutCompat2.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat2.addView(linearLayoutCompat4);
        linearLayoutCompat2.addView(this.f8298t, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayoutCompat4.addView(this.f8303y);
        linearLayoutCompat4.addView(this.f8304z);
        linearLayoutCompat4.setOrientation(LinearLayoutCompat.VERTICAL);
        addView(linearLayoutCompat3, new LinearLayoutCompat.LayoutParams(-1, -2));
        int i2 = BaseActivity.anInt2;
        linearLayoutCompat3.setPadding(i2 * 2, i2, i2 * 2, i2 * 2);
        View view = new View(this.f8295q);
        view.setBackgroundResource(R.drawable.bg_dotted_line);
        view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        addView(view, new LinearLayoutCompat.LayoutParams(-1, Util.dp2px((Context) this.f8295q, 2)));
        LinearLayoutCompat linearLayoutCompat5 = new LinearLayoutCompat(this.f8295q);
        this.f8297s = new LinearLayoutCompat(this.f8295q);
        linearLayoutCompat5.setOrientation(LinearLayoutCompat.VERTICAL);
        int i3 = BaseActivity.anInt2;
        linearLayoutCompat5.setPadding(i3, i3 / 2, 0, (i3 * 3) / 2);
        this.f8297s.setOrientation(LinearLayoutCompat.VERTICAL);
        LinearLayoutCompat linearLayoutCompat6 = this.f8297s;
        int i4 = BaseActivity.anInt2;
        linearLayoutCompat6.setPadding(i4, i4, i4, 0);
        linearLayoutCompat5.addView(this.f8297s);
        addView(linearLayoutCompat5, new LinearLayoutCompat.LayoutParams(-1, -2));
    }
}
