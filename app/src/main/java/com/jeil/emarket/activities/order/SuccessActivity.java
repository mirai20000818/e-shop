package com.jeil.emarket.activities.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.account.OrderDetailActivity;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.OrderDetail;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.viewmodel.ModelCollection;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.CheckoutVendorVM;


public class SuccessActivity extends BaseActivity {
    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_back).setPadding(Util.dp2px((Context) this, 6), Util.dp2px((Context) this, 8), Util.dp2px((Context) this, 6), Util.dp2px((Context) this, 8));
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R.id.iv_header_back);
        appCompatImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_home));
        appCompatImageView.setBackground(null);
        appCompatImageView.setLayoutParams(new FrameLayout.LayoutParams(Util.dp2px((Context) this, 31), Util.dp2px((Context) this, 31)));
        CustomButton customButton = (CustomButton) findViewById(R.id.cb_ok);
        customButton.setText(R.string.view_order_detail);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuccessActivity.this.m6529d(view);
            }
        });
        CustomButton customButton2 = (CustomButton) findViewById(R.id.cb_cancel);
        customButton2.setText(R.string.go_to_home);
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuccessActivity.this.m6530e(view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    
    public void m6527I() {
        ModelCollection.m5436b(this, ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getInt("orderVendorId"));
        UserVM.m5539b((BaseActivity) this, true);
        ModelCollection.f10214e.observe(this, new Observer() { // from class: b.f.a.a.e.f0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SuccessActivity.this.m6528a((OrderDetail) obj);
            }
        });
    }


    public  void m6528a(OrderDetail orderDetail) {
        List<SubOrder> list;
        java.lang.String str;
        java.lang.String str2;
        if (orderDetail == null || (list = orderDetail.vendors) == null || list.size() <= 0) {
            return;
        }
        if (orderDetail.shipping != null) {
            Util.setColor(this, (TextView) findViewById(R.id.ctv_success_notice), R.color.dark);
            Util.setColor(this, (TextView) findViewById(R.id.tv_notice), R.color.body);
            findViewById(R.id.v_shimmer_success_icon).setVisibility(View.GONE);
            findViewById(R.id.llc_success_icon).setVisibility(View.VISIBLE);
            com.jeil.emarket.components.textview.TextView textView = (com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_name);
            textView.setText(orderDetail.shipping.name);
            Util.setColor(this, textView, R.color.dark);
            Util.setColor(this, (TextView) findViewById(R.id.tv_shipping_name_label), R.color.body);
            com.jeil.emarket.components.textview.TextView textView2 = (com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_address);
            Util.setColor(this, (TextView) findViewById(R.id.tv_shipping_address_label), R.color.body);
            com.jeil.emarket.components.textview.TextView textView3 = (com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_location);
            java.lang.String str3 = orderDetail.shipping.location;
            if (str3 == null || str3.isEmpty()) {
                textView3.setVisibility(View.GONE);
            } else {
                textView3.setText(orderDetail.shipping.location);
                Util.setColor(this, textView3, R.color.dark);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(orderDetail.shipping.address1);
            java.lang.String str4 = orderDetail.shipping.address2;
            java.lang.String str5 = "";
            if (str4 == null || str4.isEmpty()) {
                str = "";
            } else {
                StringBuilder m3163a = CustomString.format(" ");
                m3163a.append(orderDetail.shipping.address2);
                str = m3163a.toString();
            }
            CustomString.m3175a(sb, str, textView2);
            Util.setColor(this, textView2, R.color.dark);
            com.jeil.emarket.components.textview.TextView textView4 = (com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_phone);
            java.lang.String str6 = orderDetail.shipping.phone1;
            if (str6 == null || str6.isEmpty()) {
                str2 = "";
            } else {
                StringBuilder m3163a2 = CustomString.format("");
                m3163a2.append(orderDetail.shipping.phone1);
                str2 = m3163a2.toString();
            }
            java.lang.String str7 = orderDetail.shipping.phone2;
            if (str7 != null && !str7.isEmpty()) {
                StringBuilder m3163a3 = CustomString.format(str2);
                java.lang.String str8 = orderDetail.shipping.phone1;
                if (str8 != null && !str8.isEmpty()) {
                    str5 = ", ";
                }
                m3163a3.append(str5);
                m3163a3.append(orderDetail.shipping.phone2);
                str2 = m3163a3.toString();
            }
            Util.setColor(this, textView4, R.color.dark);
            Util.setColor(this, (TextView) findViewById(R.id.tv_shipping_phone_label), R.color.body);
            if (str2.isEmpty()) {
                findViewById(R.id.llc_phone_item).setVisibility(View.GONE);
            } else {
                findViewById(R.id.llc_phone_item).setVisibility(View.VISIBLE);
                textView4.setText(str2);
            }
        }
        MutableLiveData<Date> mutableLiveData = CheckoutVendorVM.f10397f;
        if (mutableLiveData == null || mutableLiveData.getValue() == null) {
            findViewById(R.id.ll_delivery_time).setVisibility(View.GONE);
        } else {
            com.jeil.emarket.components.textview.TextView textView5 = (com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_delivery_time);
            textView5.setText(Util.m307b(CheckoutVendorVM.f10397f.getValue()));
            Util.setColor(this, textView5, R.color.dark);
            Util.setColor(this, (TextView) findViewById(R.id.tv_delivery_time_label), R.color.body);
        }
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) findViewById(R.id.ll_customer_note);
        java.lang.String str9 = CheckoutVendorVM.f10398g;
        if (str9 == null || str9.isEmpty()) {
            linearLayoutCompat.setVisibility(View.GONE);
        } else {
            linearLayoutCompat.setVisibility(View.VISIBLE);
            ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_customer_note)).setText(CheckoutVendorVM.f10398g);
            Util.setColor(this, (TextView) findViewById(R.id.tv_customer_note), R.color.dark);
            Util.setColor(this, (TextView) findViewById(R.id.tv_customer_note_label), R.color.body);
        }
        Util.setColor(this, (TextView) findViewById(R.id.tv_order_total_label), R.color.body);
        findViewById(R.id.ll_price).setVisibility(View.VISIBLE);
        findViewById(R.id.vw_shimmer_order_total).setVisibility(View.GONE);
        PriceText priceText = (PriceText) findViewById(R.id.pt_kpf_price);
        if (orderDetail.totalAmount.kpf > 0.0f) {
            priceText.setVisibility(View.VISIBLE);
            priceText.setPrice(Util.m327c(orderDetail.totalAmount.kpf));
        } else {
            priceText.setVisibility(View.GONE);
        }
        PriceText priceText2 = (PriceText) findViewById(R.id.pt_kpw_price);
        if (orderDetail.totalAmount.kpw > 0.0f) {
            priceText2.setVisibility(View.VISIBLE);
            priceText2.f12264t = orderDetail.totalAmount.kpf > 0.0f;
            priceText2.setPrice(Util.m327c(orderDetail.totalAmount.kpw));
        } else {
            priceText2.setVisibility(View.GONE);
        }
        ((ShimmerFrameLayout) findViewById(R.id.sfl_layout)).hideShimmer();
    }


    public  void m6529d(View view) {
        ModelCollection.m5436b(this, CheckoutVendorVM.f10399h);
        Intent intent = new Intent(getApplicationContext(), OrderDetailActivity.class);
        intent.putExtra("orderVendorId", CheckoutVendorVM.f10399h);
        intent.putExtra("page", "toHome");
        startActivity(intent);
        finish();
    }


    public  void m6530e(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (m4309v()) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_success);
        m4307e(R.string.order);
        m6527I();
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
