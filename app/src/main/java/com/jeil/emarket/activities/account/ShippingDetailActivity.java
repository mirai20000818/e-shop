package com.jeil.emarket.activities.account;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.model.vendor.VendorOrder;
import java.util.Objects;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;


public class ShippingDetailActivity extends BaseActivity implements BaseInterface {

    
    public MutableLiveData<VendorOrder> f11685I = new MutableLiveData<>();

    /* renamed from: com.jeil.emarket.activities.account.ShippingDetailActivity$a */
    public class C3189a extends TypeToken<VendorOrder> {
        public C3189a(ShippingDetailActivity shippingDetailActivity) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_phone).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShippingDetailActivity.this.m6378d(view);
            }
        });
        findViewById(R.id.mrl_message).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShippingDetailActivity.this.m6379e(view);
            }
        });
    }


    public void m6373a(Bundle bundle) {
        int i = bundle.getInt("id");
        if (i > -1) {
            m6377b(java.lang.String.valueOf(i));
            m6380g(i);
        }
    }


    public  void m6374a(final VendorOrder vendorOrder) {
        Util.setColor(this, (TextView) findViewById(R.id.tv_expected_at_label), R.color.light);
        Util.setColor(this, (TextView) findViewById(R.id.tv_expected_at), R.color.light);
        int i = 8;
        findViewById(R.id.nsv_shimmer_main).setVisibility(View.GONE);
        int i2 = 0;
        findViewById(R.id.nsv_main).setVisibility(View.VISIBLE);
        ((ShimmerFrameLayout) findViewById(R.id.sfl_arrived_at)).hideShimmer();
        findViewById(R.id.shl_phone).setVisibility(View.GONE);
        findViewById(R.id.mrl_phone_number).setVisibility(View.VISIBLE);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_expected_at)).setText(Util.m307b(vendorOrder.deliveryTime));
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_total_amount)).setText(Util.m218a(vendorOrder.totalAmount, true));
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_total_amount)).setTextColor(getResources().getColor(vendorOrder.currency.equals("kpf") ? R.color.kpf : R.color.kpw));
        com.jeil.emarket.components.textview.TextView textView = (com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_payment_method);
        java.lang.String str = vendorOrder.paymentMethod;
        textView.setText(str != null ? Util.getIdentifier(this, str, "") : getResources().getString(R.string.cod));
        findViewById(R.id.ctv_price_unit).setVisibility(vendorOrder.currency.equals("kpf") ? View.GONE : View.VISIBLE);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_vendor_name)).setText(vendorOrder.vendorName);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_method)).setText(vendorOrder.shippingMethod);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_phone)).setText(vendorOrder.shipping.phone1);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_connect_address)).setText(vendorOrder.shipping.address1 + " " + vendorOrder.shipping.address2 + " " + vendorOrder.shipping.location);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_connector_name)).setText(vendorOrder.shipping.name);
        java.lang.String str2 = vendorOrder.shipping.note;
        if (str2 == null || str2.isEmpty()) {
            findViewById(R.id.llc_note_wrapper).setVisibility(View.GONE);
        } else {
            ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_order_note)).setText(vendorOrder.shipping.note);
        }
        ((LinearLayoutCompat) findViewById(R.id.llc_shipping_products)).removeAllViews();
        int i3 = 0;
        while (i3 < vendorOrder.items.size()) {
            LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a.setMargins(i2, i2, i2, Util.dp2px((Context) this, 7));
            linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
            linearLayoutCompat.setLayoutParams(c0541a);
            com.jeil.emarket.components.textview.TextView textView2 = new com.jeil.emarket.components.textview.TextView(this);
            com.jeil.emarket.components.textview.TextView textView3 = new com.jeil.emarket.components.textview.TextView(this);
            com.jeil.emarket.components.textview.TextView textView4 = new com.jeil.emarket.components.textview.TextView(this);
            LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a2.setMargins(i2, i2, i2, Util.dp2px((Context) this, i));
            textView2.setLayoutParams(c0541a2);
            textView2.setText(vendorOrder.items.get(i3).name + " × " + vendorOrder.items.get(i3).quantity);
            textView2.setTextColor(getResources().getColor(R.color.dark));
            textView2.setTextSize(1, 12.5f);
            textView2.setLineHeight(Util.dp2px((Context) this, 20));
            linearLayoutCompat.addView(textView2);
            if (vendorOrder.items.get(i3).sku != null && !vendorOrder.items.get(i3).sku.isEmpty()) {
                textView3.setLayoutParams(c0541a2);
                textView3.setText(getResources().getString(R.string.product_sku_comma) + " " + vendorOrder.items.get(i3).sku);
                textView3.setTextColor(getResources().getColor(R.color.light));
                textView3.setTextSize(1, 12.5f);
                textView3.setLineHeight(Util.dp2px((Context) this, 20));
                linearLayoutCompat.addView(textView3);
            }
            textView4.setLayoutParams(c0541a2);
            textView4.setText(getResources().getString(R.string.product_id_comma) + " " + vendorOrder.items.get(i3).f12452id);
            textView4.setTextColor(getResources().getColor(R.color.light));
            textView4.setTextSize(1, 12.5f);
            textView4.setLineHeight(Util.dp2px((Context) this, 20));
            linearLayoutCompat.addView(textView4);
            ((LinearLayoutCompat) findViewById(R.id.llc_shipping_products)).addView(linearLayoutCompat);
            i3++;
            i = 8;
            i2 = 0;
        }
        java.lang.String str3 = vendorOrder.shipping.phone2;
        if (str3 == null || str3.isEmpty()) {
            findViewById(R.id.iv_angle_down).setVisibility(View.GONE);
        } else {
            findViewById(R.id.llc_phone_number).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.n2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShippingDetailActivity.this.m6375a(vendorOrder, view);
                }
            });
        }
    }


    public  void m6376a(java.lang.String[] strArr, BaseDialog2 baseDialog2, View view, int i) {
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_phone)).setText(strArr[i]);
        baseDialog2.startAni();
    }

    @SuppressLint({"SetTextI18n"})

    public void m6377b(java.lang.String str) {
        ((TextViewBold) findViewById(R.id.tv_order_number)).setText(getResources().getString(R.string.order) + " " + str);
    }


    public  void m6378d(View view) {
        try {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:" + ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_phone)).getText().toString()));
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }


    public  void m6379e(View view) {
        StringBuilder m3163a = CustomString.format("sms:");
        m3163a.append(((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_shipping_phone)).getText().toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(m3163a.toString()));
        intent.putExtra("sms_body", getResources().getString(R.string.shipping_arrived));
        startActivity(intent);
    }

    /* renamed from: g */
    public void m6380g(int i) {
        new API_PROVIDER(this, "get_order_detail", this).m5406a("e6/deliveries/" + i);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_shipping_detail);
        m6373a((Bundle) Objects.requireNonNull(getIntent().getExtras()));
        this.f11685I.observe(this, new Observer() { // from class: b.f.a.a.a.o2
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ShippingDetailActivity.this.m6374a((VendorOrder) obj);
            }
        });
        mo4284G();
    }


    public  void m6375a(VendorOrder vendorOrder, View view) {
        ShippingInfo shippingInfo = vendorOrder.shipping;
        final java.lang.String[] strArr = {shippingInfo.phone1, shippingInfo.phone2};
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, strArr, null, 80);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.a.m2
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                ShippingDetailActivity.this.m6376a(strArr, baseDialog2, view2, i);
            }
        };
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_order_detail")) {
            return;
        }
        try {
            this.f11685I.setValue( new Gson().fromJson(str, new C3189a(this).getType()));
        } catch (Exception e2) {
            java.lang.String str3 = str2 + ": Gson Exception is ";
            e2.getLocalizedMessage();
            Util.toast(this, getString(R.string.server_failed), "error", 0, 0);
            finish();
        }
    }
}
