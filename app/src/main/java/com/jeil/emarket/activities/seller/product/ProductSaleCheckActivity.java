package com.jeil.emarket.activities.seller.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.CheckSaleProducts;
import com.jeil.emarket.model.vendor.SaleProduct;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.viewmodel.ProductTotalVM;


public class ProductSaleCheckActivity extends BaseActivityForVendor {

    
    public CheckSaleProducts f11907K;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        View findViewById = findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.VISIBLE);
                materialRippleLayout2.setVisibility(View.GONE);
            }
        }
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductSaleCheckActivity.this.m6728t(view);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductSaleCheckActivity.this.m6729u(view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})

    public void m6726a(CheckSaleProducts checkSaleProducts) {
        if (checkSaleProducts != null) {
            this.f11907K = checkSaleProducts;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) findViewById(R.id.llc_check_sale_products);
            linearLayoutCompat.removeAllViews();
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a.setMargins(0, 0, 0, Util.dp2px((Context) this, 8));
            List<SaleProduct> list = checkSaleProducts.products;
            if (list == null || list.size() == 0) {
                findViewById(R.id.cb_ok).setEnabled(false);
            } else {
                findViewById(R.id.cb_ok).setEnabled(true);
                for (int i = 0; i < checkSaleProducts.products.size(); i++) {
                    View inflate = View.inflate(this, R.layout.item_sale_product, null);
                    inflate.setLayoutParams(c0541a);
                    SaleProduct saleProduct = checkSaleProducts.products.get(i);
                    inflate.findViewById(R.id.ll_cost).setVisibility(View.GONE);
                    Glide.with((FragmentActivity) this).load(Util.m306b(saleProduct.image, "xs")).diskCacheStrategy(DiskCacheStrategy.ALL).load(getResources().getDrawable(R.drawable.ic_placeholder)).into((ImageView) inflate.findViewById(R.id.iv_product_img));
                    ((TextView) inflate.findViewById(R.id.tv_product_name)).setText(saleProduct.name);
                    java.lang.String str = saleProduct.sku;
                    if (str == null || str.isEmpty()) {
                        inflate.findViewById(R.id.llc_product_sku_item).setVisibility(View.GONE);
                    } else {
                        inflate.findViewById(R.id.llc_product_sku_item).setVisibility(View.VISIBLE);
                        ((TextView) inflate.findViewById(R.id.tv_product_sku)).setText(saleProduct.sku);
                    }
                    ((TextView) inflate.findViewById(R.id.tv_product_id)).setText(Util.m217a(saleProduct.productId));
                    ((ProductPrice) inflate.findViewById(R.id.pp_product_price)).setCurrency(saleProduct.currency);
                    ((ProductPrice) inflate.findViewById(R.id.pp_product_price)).m6941c(false);
                    ((ProductPrice) inflate.findViewById(R.id.pp_product_price)).setHidePriceNumber(false);
                    float f = saleProduct.salePrice;
                    if (f <= 0.0f || f == saleProduct.regularPrice) {
                        ((ProductPrice) inflate.findViewById(R.id.pp_product_price)).setPtSalePrice(Util.m327c(saleProduct.regularPrice));
                    } else {
                        ((ProductPrice) inflate.findViewById(R.id.pp_product_price)).setPtSalePrice(Util.m327c(saleProduct.salePrice));
                        ((ProductPrice) inflate.findViewById(R.id.pp_product_price)).setRegularPrice(Util.m327c(saleProduct.regularPrice));
                    }
                    ((PriceText) inflate.findViewById(R.id.tv_sale_price)).setCurrency(saleProduct.currency);
                    ((PriceText) inflate.findViewById(R.id.tv_sale_price)).setPrice(Util.m327c(saleProduct.discountPrice));
                    TextView textView = (TextView) inflate.findViewById(R.id.tv_discount_percent);
                    StringBuilder m3163a = CustomString.format("( -");
                    m3163a.append(saleProduct.discountPercent);
                    m3163a.append("% )");
                    textView.setText(m3163a.toString());
                    TextView textView2 = (TextView) inflate.findViewById(R.id.tv_sale_period);
                    StringBuilder sb = new StringBuilder();
                    sb.append(ProductTotalVM.f10241i.getValue());
                    sb.append(" ~ ");
                    CustomString.m3175a(sb, ProductTotalVM.f10242j.getValue(), textView2);
                    if (saleProduct.stock == 0) {
                        CustomString.m3167a(inflate, R.id.tv_out_of_stock, 0, R.id.tv_stock, 8);
                    } else {
                        CustomString.m3167a(inflate, R.id.tv_out_of_stock, 8, R.id.tv_stock, 0);
                        ((TextView) inflate.findViewById(R.id.tv_stock)).setText(saleProduct.stock + getResources().getString(R.string.count_unit));
                        if (saleProduct.stock < 0) {
                            ((TextView) inflate.findViewById(R.id.tv_stock)).setTextColor(getResources().getColor(R.color.danger));
                        }
                    }
                    inflate.findViewById(R.id.llc_action).setVisibility(View.GONE);
                    linearLayoutCompat.addView(inflate);
                }
            }
            int[] iArr = checkSaleProducts.alreadySaleFailed;
            if (iArr != null && iArr.length != 0) {
                for (int i2 = 0; i2 < checkSaleProducts.alreadySaleFailed.length; i2++) {
                    View inflate2 = View.inflate(this, R.layout.item_fail_sale_product, null);
                    inflate2.setLayoutParams(c0541a);
                    ((TextView) inflate2.findViewById(R.id.tv_product_id)).setText(Util.m217a(checkSaleProducts.alreadySaleFailed[i2]));
                    ((TextView) inflate2.findViewById(R.id.tv_reason)).setText(R.string.already_sale_failed_products);
                    linearLayoutCompat.addView(inflate2);
                }
            }
            java.lang.String[] strArr = checkSaleProducts.existFailed;
            if (strArr != null && strArr.length != 0) {
                for (int i3 = 0; i3 < checkSaleProducts.existFailed.length; i3++) {
                    View inflate3 = View.inflate(this, R.layout.item_fail_sale_product, null);
                    inflate3.setLayoutParams(c0541a);
                    ((TextView) inflate3.findViewById(R.id.tv_product_id)).setText(checkSaleProducts.existFailed[i3]);
                    ((TextView) inflate3.findViewById(R.id.tv_reason)).setText(R.string.exist_failed_products);
                    linearLayoutCompat.addView(inflate3);
                }
            }
            java.lang.String[] strArr2 = checkSaleProducts.priceFailed;
            if (strArr2 != null && strArr2.length != 0) {
                for (int i4 = 0; i4 < checkSaleProducts.priceFailed.length; i4++) {
                    View inflate4 = View.inflate(this, R.layout.item_fail_sale_product, null);
                    inflate4.setLayoutParams(c0541a);
                    ((TextView) inflate4.findViewById(R.id.tv_product_id)).setText(checkSaleProducts.priceFailed[i4]);
                    ((TextView) inflate4.findViewById(R.id.tv_reason)).setText(R.string.price_failed_products);
                    linearLayoutCompat.addView(inflate4);
                }
            }
            java.lang.String[] strArr3 = checkSaleProducts.stockFailed;
            if (strArr3 != null && strArr3.length != 0) {
                for (int i5 = 0; i5 < checkSaleProducts.stockFailed.length; i5++) {
                    View inflate5 = View.inflate(this, R.layout.item_fail_sale_product, null);
                    inflate5.setLayoutParams(c0541a);
                    ((TextView) inflate5.findViewById(R.id.tv_product_id)).setText(checkSaleProducts.stockFailed[i5]);
                    ((TextView) inflate5.findViewById(R.id.tv_reason)).setText(R.string.stock_failed_products);
                    linearLayoutCompat.addView(inflate5);
                }
            }
            int[] iArr2 = checkSaleProducts.discountFailed;
            if (iArr2 == null || iArr2.length == 0) {
                return;
            }
            for (int i6 = 0; i6 < checkSaleProducts.discountFailed.length; i6++) {
                View inflate6 = View.inflate(this, R.layout.item_fail_sale_product, null);
                inflate6.setLayoutParams(c0541a);
                ((TextView) inflate6.findViewById(R.id.tv_product_id)).setText(Util.m217a(checkSaleProducts.discountFailed[i6]));
                ((TextView) inflate6.findViewById(R.id.tv_reason)).setText(R.string.discount_failed_products);
                linearLayoutCompat.addView(inflate6);
            }
        }
    }


    public  void m6727b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            Intent intent = new Intent(getApplicationContext(), ProductSaleActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_check_sale_products);
        m4307e(R.string.add_sale_product);
        ProductTotalVM.f10243k.observe(this, new Observer() { // from class: b.f.a.a.i.v2.f0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProductSaleCheckActivity.this.m6726a((CheckSaleProducts) obj);
            }
        });
        addBottomNav(0);
        mo4284G();
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    /* renamed from: t */
    public  void m6728t(View view) {
        onBackPressed();
    }

    /* renamed from: u */
    public  void m6729u(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ids", this.f11907K.success);
            jSONObject.put("discount", this.f11907K.products.get(0).discountPercent);
            jSONObject.put("startDate", ProductTotalVM.f10241i.getValue());
            jSONObject.put("endDate", ProductTotalVM.f10242j.getValue());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ProductTotalVM.m5471b(this, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        ProductTotalVM.f10240h.observe(this, new Observer() { // from class: b.f.a.a.i.v2.z
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProductSaleCheckActivity.this.m6727b(dialogC2001j, (Integer) obj);
            }
        });
    }
}
