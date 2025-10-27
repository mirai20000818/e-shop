package com.jeil.emarket.activities.seller.refund;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Attachment;
import com.jeil.emarket.model.customer.RefundRequestProduct;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.ProductImgMainAdapter;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;


public class RefundDetailActivity extends BaseActivityForVendor implements BaseInterface {

    
    public MutableLiveData<RefundRequestProduct> f11919K = new MutableLiveData<>();

    /* renamed from: L */
    public int f11920L;

    /* renamed from: M */
    public java.lang.String f11921M;

    /* renamed from: N */
    public java.lang.String f11922N;

    /* renamed from: O */
    public DialogC2001j f11923O;

    /* renamed from: com.jeil.emarket.activities.seller.refund.RefundDetailActivity$a */
    public class C3226a extends TypeToken<RefundRequestProduct> {
        public C3226a(RefundDetailActivity refundDetailActivity) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.llc_select_box).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.w2.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.this.m6744t(view);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.w2.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.this.m6745u(view);
            }
        });
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.w2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.this.m6746v(view);
            }
        });
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: R */
    public void m6735R() {
        Util.setColor(this, (TextView) findViewById(R.id.tv_request_id_label), R.color.body);
        findViewById(R.id.iv_type_dot).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(BaseActivity.color)));
        Util.setColor(this, (TextView) findViewById(R.id.tv_request_id), R.color.dark);
        Util.setColor(this, (TextView) findViewById(R.id.tv_customer_name_label), R.color.body);
        Util.setColor(this, (TextView) findViewById(R.id.tv_customer_name), R.color.dark);
        Util.setColor(this, (TextView) findViewById(R.id.tv_order_id_label), R.color.body);
        Util.setColor(this, (TextView) findViewById(R.id.tv_order_id), R.color.dark);
        Util.setColor(this, (TextView) findViewById(R.id.tv_product_name_label), R.color.body);
        Util.setColor(this, (TextView) findViewById(R.id.tv_product_name), R.color.dark);
        Util.setColor(this, (TextView) findViewById(R.id.tv_product_sku_label), R.color.light);
        Util.setColor(this, (TextView) findViewById(R.id.tv_product_sku), R.color.light);
        Util.setColor(this, (TextView) findViewById(R.id.tv_product_id_label), R.color.light);
        Util.setColor(this, (TextView) findViewById(R.id.tv_product_id), R.color.light);
        Util.setColor(this, (TextView) findViewById(R.id.tv_refund_reason_label), R.color.body);
        Util.setColor(this, (TextView) findViewById(R.id.tv_refund_reason), R.color.dark);
        Util.setColor(this, (TextView) findViewById(R.id.tv_request_date_label), R.color.body);
        Util.setColor(this, (TextView) findViewById(R.id.tv_request_date), R.color.dark);
        Util.setColor(this, (TextView) findViewById(R.id.tv_request_status_label), R.color.body);
        ((ShimmerFrameLayout) findViewById(R.id.sfl_layout)).hideShimmer();
        findViewById(R.id.llc_select_box).setBackgroundResource(R.drawable.bg_input_border);
        findViewById(R.id.tv_request_status).setVisibility(View.VISIBLE);
        findViewById(R.id.iv_icon).setVisibility(View.VISIBLE);
    }


    public void m6736a(Bundle bundle) {
        this.f11920L = bundle.getInt("id");
        int i = this.f11920L;
        if (i > -1) {
            m6743k(i);
        }
    }


    public  void m6737a(RefundRequestProduct refundRequestProduct) {
        Resources resources;
        int i;
        m6735R();
        java.lang.String str = refundRequestProduct.type;
        this.f11921M = str;
        if (str.equals("exchange")) {
            findViewById(R.id.iv_type_dot).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(getResources().getIdentifier("requested", "color", getPackageName()))));
        }
        com.jeil.emarket.components.textview.TextView textView = (com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_request_id);
        StringBuilder sb = new StringBuilder();
        if (refundRequestProduct.type.equals("exchange")) {
            resources = getResources();
            i = R.string.exchange;
        } else {
            resources = getResources();
            i = R.string.returnProduct;
        }
        sb.append(resources.getString(i));
        sb.append(" (");
        sb.append(getResources().getString(R.string.no_comma));
        CustomString.m3174a(sb, refundRequestProduct.f12416id, ")", textView);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_customer_name)).setText(refundRequestProduct.customerFullname);
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_order_id)).setText(java.lang.String.valueOf(refundRequestProduct.displayOrderId));
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_product_name)).setText(refundRequestProduct.itemName + " × " + refundRequestProduct.quantity);
        java.lang.String str2 = refundRequestProduct.itemSku;
        int i2 = 0;
        if (str2 == null || str2.isEmpty()) {
            findViewById(R.id.llc_sku_item).setVisibility(View.GONE);
        } else {
            ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_product_sku)).setText(refundRequestProduct.itemSku);
            findViewById(R.id.llc_sku_item).setVisibility(View.VISIBLE);
        }
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_product_id)).setText(Util.m217a(refundRequestProduct.itemId));
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_request_date)).setText(Util.m307b(refundRequestProduct.updatedAt));
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_request_status)).setText(Util.m335d(this, refundRequestProduct.status));
        java.lang.String str3 = refundRequestProduct.refundText;
        if (str3 == null || str3.isEmpty()) {
            findViewById(R.id.llc_reason_wrapper).setVisibility(View.GONE);
        } else {
            ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_refund_reason)).setText(refundRequestProduct.refundText);
        }
        if (refundRequestProduct.status.equals("completed") || refundRequestProduct.status.equals("cancelled")) {
            findViewById(R.id.llc_select_box).setBackground(null);
            findViewById(R.id.llc_select_box).setPadding(0, 0, 0, 0);
            findViewById(R.id.llc_button_group).setVisibility(View.GONE);
            findViewById(R.id.iv_icon).setVisibility(View.GONE);
            ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_request_status)).setTextColor(getResources().getColor(R.color.dark));
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        if (refundRequestProduct.refundAttachments.size() > 0) {
            ProductImgMainAdapter c1775h = new ProductImgMainAdapter(this, 7.3f);
            recyclerView.setAdapter(c1775h);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            recyclerView.addItemDecoration(new ItemDecoration2(Util.dp2px((Context) this, 5), 0, false));
            for (Attachment attachment : refundRequestProduct.refundAttachments) {
                if (attachment.type.equals("image")) {
                    i2++;
                    c1775h.add(attachment.url);
                }
            }
            if (i2 != 0) {
                return;
            }
        }
        recyclerView.setVisibility(View.GONE);
    }


    public void m6738a(java.lang.String str, java.lang.String str2) {
        try {
            this.f11919K.setValue( new Gson().fromJson(str, new C3226a(this).getType()));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str2.equals("get_refund_detail")) {
            m6738a(str, str2);
        } else if (str2.equals("change_refund_status")) {
            this.f11923O.dismiss();
            this.f6496A = false;
            setResult(-1, new Intent(this, RefundRequestsActivity.class));
            finish();
        }
    }


    public  void m6739a(java.lang.String[] strArr, int i, DialogError dialogError) {
        this.f11922N = strArr[i];
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_request_status)).setText(Util.m335d(this, this.f11922N));
        dialogError.dismiss();
    }


    public  void m6740a(final java.lang.String[] strArr, BaseDialog2 baseDialog2, View view, final int i) {
        if (strArr[i].equals("completed")) {
            final DialogError dialogError = new DialogError(this);
            dialogError.f8246v = getResources().getString(R.string.complete_refund_request);
            dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
            dialogError.show();
            dialogError.m4585a(new DialogInterface() { // from class: b.f.a.a.i.w2.a
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

                public final void cancel() {
                    dialogError.dismiss();
                }
            }, new DialogInterface() { // from class: b.f.a.a.i.w2.e
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

                public final void cancel() {
                    RefundDetailActivity.this.m6739a(strArr, i, dialogError);
                }
            });
        } else {
            this.f11922N = strArr[i];
            ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_request_status)).setText(Util.m335d(this, this.f11922N));
        }
        baseDialog2.startAni();
    }


    public  void m6741b(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public void m6742b(java.lang.String str) {
        if (this.f11919K.getValue() != null && (str == null || str.equals(this.f11919K.getValue().status))) {
            Util.toast(this, getResources().getString(R.string.no_change), "error", 0, 0);
            this.f6496A = false;
            return;
        }
        this.f11923O = new DialogC2001j(this);
        this.f11923O.show();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f11920L);
            jSONObject.put("status", str);
            jSONObject.put("type", this.f11921M);
            java.lang.String jSONObject2 = jSONObject.toString();
            jSONObject.put("signData", Base64.encodeToString(Util.m347e(this, jSONObject2), 0));
            jSONObject.put("plainData", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER APIS = new API_PROVIDER(this, "change_refund_status", this);
        StringBuilder m3163a = CustomString.format("e7/refunds/");
        m3163a.append(this.f11920L);
        APIS.put(m3163a.toString(), jSONObject);
    }

    
    public void m6743k(int i) {
        new API_PROVIDER(this, "get_refund_detail", this).m5406a("e7/refunds/" + i);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_refund_detail);
        m4307e(R.string.refund_request_detail);
        m6736a((Bundle) Objects.requireNonNull(getIntent().getExtras()));
        this.f11919K.observe(this, new Observer() { // from class: b.f.a.a.i.w2.c
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                RefundDetailActivity.this.m6737a((RefundRequestProduct) obj);
            }
        });
        findViewById(R.id.header_border).setVisibility(View.GONE);
        mo4284G();
    }

    /* renamed from: t */
    public  void m6744t(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        final java.lang.String[] strArr = {"requested", "accepted", "shipping", "testing", "completed", "cancelled"};
        java.lang.String[] strArr2 = new java.lang.String[6];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = Util.getIdentifier(this, strArr[i], "");
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, strArr2, null, 80);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.i.w2.f
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                RefundDetailActivity.this.m6740a(strArr, baseDialog2, view2, i2);
            }
        };
        baseDialog2.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.w2.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                RefundDetailActivity.this.m6741b(dialogInterface);
            }
        });
    }

    /* renamed from: u */
    public  void m6745u(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        m6742b(this.f11922N);
    }

    /* renamed from: v */
    public  void m6746v(View view) {
        finish();
    }
}
