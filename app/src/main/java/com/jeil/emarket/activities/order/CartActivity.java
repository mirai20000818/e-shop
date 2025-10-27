package com.jeil.emarket.activities.order;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.auth.LoginActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.order.CartProductRecylcer;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.listener.cart.CartProductListener;
import com.jeil.emarket.listener.cart.DialogErrorInter;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.widget.ViewOnTouchListenerC2092s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CartActivity extends BaseActivity {

    
    public boolean f11748I = true;

    
    public static  void m6489a(List list, List list2, CompoundButton compoundButton, boolean z) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CartProduct cartProduct = (CartProduct) it.next();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                CartProduct cartProduct2 = (CartProduct) it2.next();
                if (cartProduct2.f12392id == cartProduct.f12392id) {
                    cartProduct2.checked = z;
                }
            }
        }
        CartProductVM.f10375d.setValue(list2);
        CartProductVM.m5574d();
    }

    
    public static  void m6490b(CompoundButton compoundButton, boolean z) {
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.cal_empty).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CartActivity.this.m6499d(view);
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CartActivity.this.m6500e(view);
            }
        });
    }

    @SuppressLint({"SetTextI18n", "InflateParams", "ClickableViewAccessibility"})
    
    public void m6491I() {
        CartProductVM.f10375d.observe(this, new Observer() { // from class: b.f.a.a.e.f
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                CartActivity.this.m6498b((List) obj);
            }
        });
    }

   
    public void m6492J() {
        View findViewById = findViewById(R.id.header_border);
        m4293a((NestedScrollView) findViewById(R.id.nsv_main), (MaterialRippleLayout) null, mo4310w(), findViewById, findViewById(R.id.bottom_border), true);
    }

    
    public void m6493K() {
        final View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_payment_agree, (ViewGroup) null);
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, new java.lang.String[0], inflate, 80);
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_ok);
        if (customButton != null) {
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CartActivity.this.m6494a(inflate, baseDialog2, view);
                }
            });
        }
        baseDialog2.show();
    }

    
    public  void m6497a(List list, CartProduct cartProduct, DialogError dialogError) {
        ArrayList arrayList = new ArrayList(list);
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (cartProduct.vendorId == ((CartProduct) arrayList.get(i)).vendorId) {
                arrayList.remove(i);
            } else {
                i++;
            }
        }
        CartProductVM.f10375d.setValue(arrayList);
        CartProductVM.m5574d();
        Util.toast(this, getString(R.string.delete_cart_products), "default", 0, 0);
        dialogError.dismiss();
    }

    
    public  void m6498b(final List list) {
        ArrayList arrayList;
        boolean z;
        CartProductRecylcer c1850u0;
        ArrayList arrayList2;
        int i = 0;
        if (list.size() > 0) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) findViewById(R.id.ll_cart_vendor);
            ArrayList arrayList3 = new ArrayList(list);
            ArrayList arrayList4 = new ArrayList();
            int i2 = 0;
            float f = 0.0f;
            float f2 = 0.0f;
            while (arrayList3.size() > 0) {
                final ArrayList arrayList5 = new ArrayList();
                final CartProduct cartProduct = (CartProduct) arrayList3.get(i);
                arrayList4.add(Integer.valueOf(cartProduct.vendorId));
                int size = arrayList3.size();
                int i3 = 0;
                boolean z2 = true;
                float f3 = 0.0f;
                float f4 = 0.0f;
                boolean z3 = true;
                while (i3 < size) {
                    int i4 = size;
                    ArrayList arrayList6 = arrayList4;
                    if (cartProduct.vendorId == ((CartProduct) arrayList3.get(i)).vendorId) {
                        CartProduct cartProduct2 = (CartProduct) arrayList3.remove(i);
                        if (cartProduct2.checked) {
                            float f5 = cartProduct2.priceKpw;
                            arrayList2 = arrayList3;
                            float f6 = cartProduct2.quantity;
                            f4 = (f5 * f6) + f4;
                            f3 += cartProduct2.priceKpf * f6;
                            java.lang.String str = cartProduct2.discountType;
                            if (str == null || str.isEmpty()) {
                                i2 += cartProduct2.quantity;
                            } else {
                                List<CartProduct> list2 = cartProduct2.products;
                                if (list2 != null) {
                                    i2 = (list2.size() * cartProduct2.quantity) + i2;
                                }
                            }
                            z3 = false;
                        } else {
                            arrayList2 = arrayList3;
                            z2 = false;
                        }
                        arrayList5.add(cartProduct2);
                    } else {
                        arrayList2 = arrayList3;
                        i++;
                    }
                    i3++;
                    size = i4;
                    arrayList3 = arrayList2;
                    arrayList4 = arrayList6;
                }
                ArrayList arrayList7 = arrayList3;
                ArrayList arrayList8 = arrayList4;
                StringBuilder m3163a = CustomString.format("vendor-");
                m3163a.append(cartProduct.vendorId);
                View findViewWithTag = linearLayoutCompat.findViewWithTag(m3163a.toString());
                if (findViewWithTag == null) {
                    findViewWithTag = getLayoutInflater().inflate(R.layout.item_vendor_cart, (ViewGroup) null);
                    z = false;
                } else {
                    z = true;
                }
                ((TextView) findViewWithTag.findViewById(R.id.tv_vendor_name)).setText(cartProduct.vendorName);
                PriceText priceText = (PriceText) findViewWithTag.findViewById(R.id.pt_total_kpf);
                PriceText priceText2 = (PriceText) findViewWithTag.findViewById(R.id.pt_total_kpw);
                priceText.setPrice(Util.m327c(f3));
                priceText2.f12264t = f3 > 0.0f;
                priceText2.setPrice(Util.m327c(f4));
                if (f3 <= 0.0f) {
                    priceText.setVisibility(View.GONE);
                }
                if (f4 <= 0.0f) {
                    priceText2.setVisibility(View.GONE);
                }
                CheckBox checkBox = (CheckBox) findViewWithTag.findViewById(R.id.cb_vendor);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.a.e.a
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        CartActivity.m6490b(compoundButton, z4);
                    }
                });
                checkBox.setChecked(z2);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.a.e.c
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        CartActivity.m6489a(arrayList5, list, compoundButton, z4);
                    }
                });
                RecyclerView recyclerView = (RecyclerView) findViewWithTag.findViewById(R.id.rv_cart_products);
                if (!z) {
                    CartProductRecylcer c1850u02 = new CartProductRecylcer(this);
                    recyclerView.setAdapter(c1850u02);
                    //recyclerView.setLayoutManager(new LinearLayoutManager(this, this, 1, false));
                    c1850u02.arrayList = arrayList5;
                    c1850u02.notifyDataSetChanged();
                    ViewOnTouchListenerC2092s.c cVar = new ViewOnTouchListenerC2092s.c(recyclerView, new CartProductListener(this, recyclerView, c1850u02));
                    cVar.f8590d = false;
                    recyclerView.setOnTouchListener(new ViewOnTouchListenerC2092s(cVar));
                    LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
                    c0541a.setMargins(0, m4299b(4), 0, m4299b(4));
                    findViewWithTag.setTag("vendor-" + cartProduct.vendorId);
                    linearLayoutCompat.addView(findViewWithTag, c0541a);
                } else if ((this.f11748I || z2 || z3) && (c1850u0 = (CartProductRecylcer) recyclerView.getAdapter()) != null) {
                    c1850u0.arrayList = arrayList5;
                    c1850u0.notifyDataSetChanged();
                }
                ((ActionLink) findViewWithTag.findViewById(R.id.cal_delete)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CartActivity.this.m6496a(list, cartProduct, view);
                    }
                });
                f += f3;
                f2 += f4;
                i = 0;
                arrayList3 = arrayList7;
                arrayList4 = arrayList8;
            }
            ArrayList arrayList9 = arrayList4;
            int i5 = 0;
            while (i5 < linearLayoutCompat.getChildCount()) {
                java.lang.String str2 = (java.lang.String) linearLayoutCompat.getChildAt(i5).getTag();
                try {
                } catch (Exception unused) {
                    arrayList = arrayList9;
                }
                if (str2.startsWith("vendor-")) {
                    arrayList = arrayList9;
                    try {
                    } catch (Exception unused2) {
                        linearLayoutCompat.removeViewAt(i5);
                        i5++;
                        arrayList9 = arrayList;
                    }
                    if (arrayList.contains(Integer.valueOf(Integer.parseInt(str2.substring(7))))) {
                        i5++;
                        arrayList9 = arrayList;
                    }
                } else {
                    arrayList = arrayList9;
                }
                linearLayoutCompat.removeViewAt(i5);
                i5++;
                arrayList9 = arrayList;
            }
            ((TextView) findViewById(R.id.tv_cart_total_qty)).setText(getResources().getString(R.string.total) + " " + Util.m217a(i2) + getResources().getString(R.string.cart_total_count));
            ((PriceText) findViewById(R.id.pt_kpf_price)).setPrice(Util.m327c(f));
            ((PriceText) findViewById(R.id.pt_kpw_price)).f12264t = f > 0.0f;
            ((PriceText) findViewById(R.id.pt_kpw_price)).setPrice(Util.m327c(f2));
        } else {
            findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);
            findViewById(R.id.ll_content).setVisibility(View.GONE);
            findViewById(R.id.ll_cart_total).setVisibility(View.GONE);
            findViewById(R.id.empty).setVisibility(View.VISIBLE);
            findViewById(R.id.empty).setPadding(0, (((BaseActivity.anInt1 / 2) - findViewById(R.id.ll_header_tabs).getMeasuredHeight()) - BaseActivity.anInt2) / 2, 0, (((BaseActivity.anInt1 / 2) - findViewById(R.id.ll_header_tabs).getMeasuredHeight()) - BaseActivity.anInt2) / 2);
        }
        if (this.f11748I) {
            this.f11748I = false;
        }
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.e.z
            @Override // java.lang.Runnable
            public final void run() {
                CartActivity.this.m6492J();
            }
        }, Status.time);
    }

    
    public  void m6499d(View view) {
        final DialogError dialogError = new DialogError(this);
        dialogError.f8246v = getResources().getString(R.string.delete_cart_products_confirm);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.f8254e = 0.8f;
        dialogError.show();
        dialogError.m4585a(new DialogErrorInter(dialogError), new DialogInterface() { // from class: b.f.a.a.e.e
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
            
            public final void cancel() {
                CartActivity.this.m6495a(dialogError);
            }
        });
    }

    
    public  void m6500e(View view) {
        boolean z;
        List<CartProduct> getValue = CartProductVM.f10375d.getValue();
        if (getValue != null) {
            Iterator<CartProduct> it = getValue.iterator();
            while (it.hasNext()) {
                if (it.next().checked) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            Util.toast(this, getString(R.string.select_products), "error", 0, 0);
        } else if (UserVM.userMutableLiveData.getValue() == null) {
            startActivityForResult(new Intent(getApplicationContext(), LoginActivity.class), 100);
        } else {
            m6493K();
        }
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            m6493K();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cart);
        m4307e(R.string.cart);
        m6491I();
        addBottomNav(0);
        mo4284G();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f11748I = true;
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }

    
    public  void m6496a(final List list, final CartProduct cartProduct, View view) {
        final DialogError dialogError = new DialogError(this);
        dialogError.f8246v = getResources().getString(R.string.delete_cart_vendor_products_confirm);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.f8254e = 0.8f;
        dialogError.show();
        dialogError.m4585a(new DialogErrorInter(dialogError), new DialogInterface() { // from class: b.f.a.a.e.d
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a
            
            public final void cancel() {
                CartActivity.this.m6497a(list, cartProduct, dialogError);
            }
        });
    }

    
    public  void m6495a(DialogError dialogError) {
        CartProductVM.f10375d.setValue( new ArrayList());
        CartProductVM.m5574d();
        Util.toast(this, getString(R.string.delete_cart_products), "default", 0, 0);
        dialogError.dismiss();
    }

    
    public  void m6494a(@SuppressLint({"InflateParams"}) View view, BaseDialog2 baseDialog2, View view2) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_agree);
        if (checkBox != null && checkBox.isChecked()) {
            startActivity(new Intent(getApplicationContext(), CheckoutActivity.class));
            baseDialog2.startAni();
        } else {
            Util.toast(this, getString(R.string.agree_notice), "error", 0, 0);
        }
    }
}
