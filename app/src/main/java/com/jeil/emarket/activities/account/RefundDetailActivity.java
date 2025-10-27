package com.jeil.emarket.activities.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.QuantityInput;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.RefundProduct;
import java.util.Objects;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.providers.RefundProvider;


public class RefundDetailActivity extends BaseActivity {


    public String f11678I = "exchange";

   
    public int f11679J;



    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.this.m6367f(view);
            }
        });
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.this.m6368g(view);
            }
        });
    }


    public  void m6361I() {
        Intent intent = new Intent(getApplicationContext(), RefundProductsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @SuppressLint({"SetTextI18n"})
    
    public void m6362a(Bundle bundle) {
        RefundProduct refundProduct;
        RequestBuilder<Drawable> m3325d;
        View findViewById;
        String str;
        String string = bundle.getString("refundProduct");
        RefundProduct refundProduct2 = new RefundProduct();
        try {
            refundProduct = (RefundProduct) new Gson().fromJson(string, new TypeToken<RefundProduct>(){}.getType());
        } catch (Exception e2) {
            e2.getLocalizedMessage();
            refundProduct = refundProduct2;
        }
        if (refundProduct != null) {
            this.f11679J = refundProduct.orderItemId;
        }
        if (refundProduct == null || (str = refundProduct.productImg) == null || str.isEmpty()) {
            m3325d = Glide.with((FragmentActivity) this).load(getResources().getDrawable(R.drawable.ic_placeholder));
        } else {
            String m306b = Util.m306b(refundProduct.productImg, "xl");
            m3325d = (RequestBuilder) Glide.with((FragmentActivity) this).load(m306b).diskCacheStrategy(m306b.startsWith("file://") ? DiskCacheStrategy.DATA : DiskCacheStrategy.ALL);
        }
        m3325d.into((ImageView) findViewById(R.id.iv_product_img));
        ((TextView) findViewById(R.id.tv_product_name)).setText(((RefundProduct) Objects.requireNonNull(refundProduct)).productName);
        ((TextView) findViewById(R.id.tv_vendor_name)).setText(refundProduct.vendor);
        ((TextViewBold) findViewById(R.id.tv_order_number)).setText(refundProduct.displayOrderId + " (" + getResources().getString(R.string.refund_available_count) + " " + refundProduct.quantity + ")");
        ((QuantityInput) findViewById(R.id.cqi_quantity)).setMax(refundProduct.quantity);
        if (refundProduct.supportRefund.equals("all")) {
            ((ButtonToggle) findViewById(R.id.tv_refund_exchange)).m6896d();
        } else {
            if (refundProduct.supportRefund.equals("return")) {
                findViewById(R.id.tv_refund_exchange).setVisibility(View.GONE);
                findViewById = findViewById(R.id.tv_refund_return);
            } else {
                findViewById(R.id.tv_refund_return).setVisibility(View.GONE);
                findViewById = findViewById(R.id.tv_refund_exchange);
            }
            ((ButtonToggle) findViewById).m6896d();
            this.f11678I = refundProduct.supportRefund;
        }
        final EditText editText = (EditText) findViewById(R.id.tv_refund_reason);
        if (editText != null) {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.a.c2
                @Override // java.lang.Runnable
                public final void run() {
                    editText.setVisibility(View.VISIBLE);
                }
            }, Status.time);
        }
    }

    
    public  void m6363a(DialogC2001j dialogC2001j, Boolean bool) {
        dialogC2001j.dismiss();
        this.f6496A = false;
        if (bool.booleanValue()) {
            setResult(-1, new Intent(getApplicationContext(), RefundProductsActivity.class));
            finish();
        }
    }


    public final void m6364b(String str) {
        this.f11678I = str;
        if (str.equals("exchange")) {
            ((ButtonToggle) findViewById(R.id.tv_refund_exchange)).m6896d();
            ((ButtonToggle) findViewById(R.id.tv_refund_return)).m6897e();
        } else {
            ((ButtonToggle) findViewById(R.id.tv_refund_exchange)).m6897e();
            ((ButtonToggle) findViewById(R.id.tv_refund_return)).m6896d();
        }
    }


    public  void m6365d(View view) {
        m6364b("exchange");
    }


    public  void m6366e(View view) {
        m6364b("return");
    }

    /* renamed from: f */
    public  void m6367f(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        int qty = ((QuantityInput) findViewById(R.id.cqi_quantity)).getQty();
        String charSequence = ((TextView) findViewById(R.id.tv_refund_reason)).getText().toString();
        if (charSequence.isEmpty()) {
            Util.toast(this, getResources().getString(R.string.input_refund_reason), "error", 0, 0);
            return;
        }
        new RefundProvider().m5664a(this, this.f11678I, this.f11679J, qty, charSequence);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        RefundProvider.f10534d.observe(this, new Observer() { // from class: b.f.a.a.a.f2
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                RefundDetailActivity.this.m6363a(dialogC2001j, (Boolean) obj);
            }
        });
    }

    /* renamed from: g */
    public  void m6368g(View view) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.a.e2
            @Override // java.lang.Runnable
            public final void run() {
                RefundDetailActivity.this.m6361I();
            }
        }, 200L);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_refund_detail);
        m4307e(R.string.left_refund_request);
        m6362a((Bundle) Objects.requireNonNull(getIntent().getExtras()));
        ((ButtonToggle) findViewById(R.id.tv_refund_exchange)).setButtonClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.this.m6365d(view);
            }
        });
        ((ButtonToggle) findViewById(R.id.tv_refund_return)).setButtonClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundDetailActivity.this.m6366e(view);
            }
        });
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
