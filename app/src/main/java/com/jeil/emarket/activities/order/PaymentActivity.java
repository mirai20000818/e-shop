package com.jeil.emarket.activities.order;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.CheckoutVendor;
import com.jeil.emarket.model.customer.CreateOrder;
import com.jeil.emarket.model.customer.Discounts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.order.OrderPayMainAdapter;
import com.jeil.emarket.dialog.DialogPayment;
import com.jeil.emarket.viewmodel.CheckoutVendorVM;


public class PaymentActivity extends BaseActivity {

    
    public boolean f11756I = false;

    
    public void m6522I() {
        Intent intent;
        if (CheckoutVendorVM.f10399h > 0) {
            intent = new Intent(getApplicationContext(), SuccessActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("orderVendorId", CheckoutVendorVM.f10399h);
        } else {
            intent = new Intent(getApplicationContext(), CartActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        startActivity(intent);
    }

    @SuppressLint({"SetTextI18n"})
   
    public void m6523J() {
        CheckoutVendorVM.f10400i.observe(this, new Observer() { // from class: b.f.a.a.e.d0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PaymentActivity.this.m6526b((List) obj);
            }
        });
    }


    public  void m6524a(CheckoutVendor checkoutVendor, int i, float f, float f2, OrderPayMainAdapter c1809c1, float f3, View view) {
        List<CheckoutVendor.ShippingMethod> list;
        CheckoutVendor.Discounts.Fbts fbts;
        if (CheckoutVendorVM.f10402k > 0 || (list = CheckoutVendorVM.f10401j) != null || list.size() == 0) {
            Util.toast(this, getString(R.string.paying_another_vendor), "default", 0, 0);
            return;
        }
        if (this.f11756I) {
            return;
        }
        this.f11756I = true;
        CreateOrder createOrder = new CreateOrder();
        createOrder.vendorId = checkoutVendor.f12394id;
        createOrder.shipping = new CreateOrder.Shipping();
        if (((List) Objects.requireNonNull(CheckoutVendorVM.f10400i.getValue())).size() == CheckoutVendorVM.f10401j.size()) {
            createOrder.shipping.methodName = CheckoutVendorVM.f10401j.get(i).name;
        }
        createOrder.shipping.price = CheckoutVendorVM.f10401j.get(i).price;
        createOrder.shipping.method = CheckoutVendorVM.f10401j.get(i).value;
        createOrder.deliveryTime = CheckoutVendorVM.f10397f.getValue();
        createOrder.discounts = new Discounts();
        createOrder.discounts.fbts = new Discounts.Fbts();
        createOrder.discounts.fbts.items = new ArrayList();
        CheckoutVendor.Discounts discounts = checkoutVendor.discounts;
        if (discounts != null && (fbts = discounts.fbts) != null) {
            for (CheckoutVendor.Discounts.Fbt fbt : fbts.items) {
                Discounts.Fbt fbt2 = new Discounts.Fbt();
                fbt2.f12399id = fbt.f12395id;
                fbt2.count = fbt.count;
                fbt2.products = new ArrayList();
                Iterator<CheckoutVendor.Discounts.FbtProduct> it = fbt.products.iterator();
                while (it.hasNext()) {
                    fbt2.products.add(Integer.valueOf(it.next().f12396id));
                }
                createOrder.discounts.fbts.items.add(fbt2);
            }
        }
        createOrder.items = new ArrayList();
        for (CheckoutVendor.Product product : checkoutVendor.products) {
            String str = product.discountType;
            if (str == null || str.isEmpty()) {
                CreateOrder.OrderItem orderItem = new CreateOrder.OrderItem();
                orderItem.f12398id = product.f12397id;
                orderItem.qty = product.qty;
                createOrder.items.add(orderItem);
            }
        }
        String str2 = checkoutVendor.shippingCurrency;
        createOrder.shippingCurrency = str2;
        DialogPayment dialogPayment = new DialogPayment(this, i, checkoutVendor.name, f, f2, createOrder, c1809c1.f7293f, f3, str2);
        dialogPayment.show();
        dialogPayment.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.e.c0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PaymentActivity.this.m6525b(dialogInterface);
            }
        });
    }


    public  void m6525b(DialogInterface dialogInterface) {
        this.f11756I = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        if (r6 <= 0.0f) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011b, code lost:
    
        if (r5 <= 0.0f) goto L38;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m6526b(java.util.List r18) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.activities.order.PaymentActivity.m6526b(java.util.List):void");
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_payment);
        m4307e(R.string.checkout);
        m6523J();
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
