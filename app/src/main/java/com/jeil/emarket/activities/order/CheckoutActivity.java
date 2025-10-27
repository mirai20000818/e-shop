package com.jeil.emarket.activities.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.account.AddressActivity;
import com.jeil.emarket.activities.product.ShopActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Address;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.model.customer.CheckoutVendor;
import com.jeil.emarket.model.customer.PriceByCurrency;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.order.CheckoutVendorMainAdapter;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.components.pickerview.PickerViewObj;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.dialog.DialogAddress;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.LiveDataCollection;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.CheckoutVendorVM;


public class CheckoutActivity extends BaseActivity {

    
    public PickerObj3 f11749I;

   
    public boolean f11750J = false;

    
    public List<Float> f11751K = new ArrayList();

    /* renamed from: L */
    public List<Float> f11752L = new ArrayList();

    /* renamed from: M */
    public List<Float> f11753M = new ArrayList();

    /* renamed from: N */
    public CartProduct f11754N = new CartProduct();

    /* renamed from: O */
    public DialogAddress f11755O = null;

    /* renamed from: com.jeil.emarket.activities.order.CheckoutActivity$a */
    public class C3195a extends TypeToken<CartProduct> {
        public C3195a(CheckoutActivity checkoutActivity) {
        }
    }

    /* renamed from: com.jeil.emarket.activities.order.CheckoutActivity$b */
    public class C3196b extends TypeToken<Address> {
        public C3196b(CheckoutActivity checkoutActivity) {
        }
    }

    
    public static  void m6503b(Address address) {
        CheckoutVendorVM.f10395d.setValue(address);
        LiveDataCollection.addressMutableLiveData1 = new MutableLiveData<>();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        final MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById(R.id.mrl_delivery_time);
        ((CheckBox) findViewById(R.id.cb_set_delivery_time)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.a.e.s
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CheckoutActivity.this.m6509a(materialRippleLayout, compoundButton, z);
            }
        });
        materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckoutActivity.this.m6520f(view);
            }
        });
        ((MaterialRippleLayout) findViewById(R.id.mrl_delivery_time)).setRippleAlpha(7);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckoutActivity.this.m6521g(view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    
    public void m6504I() {
        findViewById(R.id.cal_address_list).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckoutActivity.this.m6518d(view);
            }
        });
        CheckoutVendorVM.f10395d.setValue( null);
        CheckoutVendorVM.f10395d.observe(this, new Observer() { // from class: b.f.a.a.e.y
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                CheckoutActivity.this.m6510a((Address) obj);
            }
        });
        if (UserVM.userMutableLiveData.getValue() != null && UserVM.userMutableLiveData.getValue().defaultAddressId > 0) {
            API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.y
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context) {
                    new API_PROVIDER(context, "get_address", new CheckoutVendorVM()).m5406a("e6/address");
                }
            });
            return;
        }
        Util.toast(this, getString(R.string.set_shipping_address), "error", 0, 0);
        findViewById(R.id.ll_shimmer_address).setVisibility(View.GONE);
        findViewById(R.id.ll_address).setVisibility(View.VISIBLE);
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
   
    public void m6505J() {
        CheckoutVendorVM.f10400i = new MutableLiveData<>();
        CheckoutVendorVM.f10405n = false;
        CheckoutVendorVM.f10400i.observe(this, new Observer() { // from class: b.f.a.a.e.o
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                CheckoutActivity.this.m6517b((List) obj);
            }
        });
        CheckoutVendorVM.f10397f.observe(this, new Observer() { // from class: b.f.a.a.e.n
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                CheckoutActivity.this.m6513a((Date) obj);
            }
        });
    }

    
    public void m6506K() {
        View findViewById = findViewById(R.id.header_border);
        m4293a((NestedScrollView) findViewById(R.id.nsv_main), (MaterialRippleLayout) null, mo4310w(), findViewById, findViewById(R.id.bottom_border), true);
    }


    public void m6507a(Bundle bundle) {
        if (bundle != null && bundle.containsKey("buyNow") && bundle.getBoolean("buyNow") && bundle.containsKey("cart")) {
            this.f11750J = true;
            this.f11754N = (CartProduct) new Gson().fromJson(bundle.getString("cart"), new C3195a(this).getType());
        }
    }


    public  void m6509a(MaterialRippleLayout materialRippleLayout, CompoundButton compoundButton, boolean z) {
        materialRippleLayout.setVisibility( z ? View.VISIBLE : View.GONE);
        findViewById(R.id.tv_delivery_time_desc).setVisibility( z ? View.VISIBLE : View.GONE);
    }


    public  void m6510a(final Address address) {
        java.lang.String str;
        java.lang.String str2 = "-";
        ((TextView) findViewById(R.id.tv_shipping_name)).setText(address != null ? address.name : "-");
        TextView textView = (TextView) findViewById(R.id.tv_shipping_address);
        if (address != null) {
            str = PickerViewObj.m4699b(address.address1, this) + " " + address.address2;
        } else {
            str = "-";
        }
        textView.setText(str);
        TextView textView2 = (TextView) findViewById(R.id.tv_shipping_location);
        if (address == null || address.location.isEmpty()) {
            textView2.setVisibility(View.GONE);
        } else {
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(address.location);
        }
        TextView textView3 = (TextView) findViewById(R.id.tv_shipping_phone);
        if (address != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(address.phone1);
            sb.append((address.phone1.isEmpty() || address.phone2.isEmpty()) ? "" : ", ");
            sb.append(address.phone2);
            str2 = sb.toString();
        }
        textView3.setText(str2);
        CheckoutVendorVM.f10400i.setValue( new ArrayList());
        CheckoutVendorVM.f10403l.setValue( 0);
        m6515a(true);
        if (address != null) {
            if (this.f11750J) {
                CartProduct cartProduct = this.f11754N;
                CheckoutVendorVM.f10404m = true;
                CheckoutVendorVM.f10405n = false;
                ArrayList arrayList = new ArrayList();
                arrayList.add(cartProduct);
                CheckoutVendorVM.m5586a(this, arrayList);
            } else {
                CheckoutVendorVM.f10404m = false;
                MutableLiveData<List<CartProduct>> mutableLiveData = CartProductVM.f10375d;
                if (mutableLiveData != null && mutableLiveData.getValue() != null) {
                    CheckoutVendorVM.m5586a(this, CartProductVM.f10375d.getValue());
                }
            }
        }
        if (address != null) {
            findViewById(R.id.ll_shimmer_address).setVisibility(View.GONE);
            findViewById(R.id.ll_address).setVisibility(View.VISIBLE);
        }
        findViewById(R.id.cal_address_edit).setVisibility(address != null ? View.VISIBLE : View.GONE);
        findViewById(R.id.cal_address_edit).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckoutActivity.this.m6511a(address, view);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.e.h0
            @Override // java.lang.Runnable
            public final void run() {
                CheckoutActivity.this.m6506K();
            }
        }, Status.time);
    }


    public  void m6511a(Address address, View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        this.f11755O = new DialogAddress(this, address);
        this.f11755O.show();
        findViewById(R.id.et_customer_note).clearFocus();
        this.f11755O.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.e.t
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                CheckoutActivity.this.m6516b(dialogInterface);
            }
        });
    }


    public  void m6513a(Date date) {
        if (date != null) {
            this.f11749I.m4714b(date);
            ((TextView) findViewById(R.id.tv_delivery_time)).setText(Util.m307b(date));
        }
    }


    public  void m6514a(Date date, View view) {
        CheckoutVendorVM.f10397f.setValue( date);
        ((TextView) findViewById(R.id.tv_delivery_time)).setText(Util.m307b(date));
    }


    public final void m6515a(boolean z) {
        if (z) {
            findViewById(R.id.et_customer_note).clearFocus();
            findViewById(R.id.ll_checkout_vendor).setVisibility(View.GONE);
            findViewById(R.id.ll_shimmer_vendor).setVisibility(View.VISIBLE);
            findViewById(R.id.ll_delivery_time).setVisibility(View.GONE);
            return;
        }
        findViewById(R.id.ll_checkout_vendor).setVisibility(View.VISIBLE);
        findViewById(R.id.ll_shimmer_vendor).setVisibility(View.GONE);
        findViewById(R.id.ll_customer_note).setVisibility(View.VISIBLE);
        findViewById(R.id.ll_delivery_time).setVisibility(View.VISIBLE);
    }

    
    public  void m6516b(DialogInterface dialogInterface) {
        this.f6496A = false;
        if (this.f11755O.f9077V.equals("update")) {
            LiveDataCollection.addressMutableLiveData1.observe(this, new Observer() { // from class: b.f.a.a.e.r
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    CheckoutActivity.m6503b((Address) obj);
                }
            });
        }
    }

    
    public  void m6517b(final List list) {
        int i;
        CheckoutVendor.Discounts.Fbts fbts;
        java.lang.String str;
        float f;
        float f2;
        CheckoutVendor.Discounts.Fbts fbts2;
        List<CheckoutVendor.Discounts.Fbt> list2;
        this.f11751K = new ArrayList();
        this.f11752L = new ArrayList();
        this.f11753M = new ArrayList();
        this.f11751K.clear();
        this.f11752L.clear();
        this.f11753M.clear();
        CheckoutVendorVM.f10401j.clear();
        if (list.size() <= 0) {
            if (CheckoutVendorVM.f10405n) {
                Util.toast(this, getString(R.string.cannot_checkout), "default", 0, 0);
                findViewById(R.id.ll_shimmer_vendor).setVisibility(View.GONE);
                findViewById(R.id.ll_customer_note).setVisibility(View.GONE);
                findViewById(R.id.sfl_price).setVisibility(View.GONE);
                findViewById(R.id.btn_next).setVisibility(View.GONE);
                findViewById(R.id.btn_shopping).setVisibility(View.VISIBLE);
                findViewById(R.id.btn_shopping).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CheckoutActivity.this.m6519e(view);
                    }
                });
                return;
            }
            return;
        }
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) findViewById(R.id.ll_checkout_vendor);
        linearLayoutCompat.removeAllViews();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            java.lang.String str2 = "error";
            if (i3 >= list.size()) {
                break;
            }
            final CheckoutVendor checkoutVendor = (CheckoutVendor) list.get(i3);
            List<CheckoutVendor.Product> list3 = checkoutVendor.products;
            for (CheckoutVendor.Product product : list3) {
                if (product.discountType != null) {
                    list3.remove(product);
                }
            }
            CheckoutVendor.Discounts discounts = checkoutVendor.discounts;
            boolean z = true;
            if (discounts != null && (fbts2 = discounts.fbts) != null && (list2 = fbts2.items) != null) {
                Iterator<CheckoutVendor.Discounts.Fbt> it = list2.iterator();
                while (it.hasNext()) {
                    CheckoutVendor.Discounts.Fbt next = it.next();
                    if (next.count > 0) {
                        CheckoutVendor.Product product2 = new CheckoutVendor.Product();
                        product2.discountType = "fbt";
                        product2.currency = "";
                        List<CheckoutVendor.Discounts.FbtProduct> list4 = next.products;
                        product2.products = list4;
                        product2.qty = next.count;
                        product2.canShipping = z;
                        Iterator<CheckoutVendor.Discounts.FbtProduct> it2 = list4.iterator();
                        float f3 = 0.0f;
                        float f4 = 0.0f;
                        while (it2.hasNext()) {
                            Iterator<CheckoutVendor.Discounts.Fbt> it3 = it;
                            CheckoutVendor.Discounts.FbtProduct next2 = it2.next();
                            Iterator<CheckoutVendor.Discounts.FbtProduct> it4 = it2;
                            f3 += next2.currency.equals("kpf") ? Math.max(next2.price, next2.salePrice) : 0.0f;
                            f4 += next2.currency.equals("kpw") ? Math.max(next2.price, next2.salePrice) : 0.0f;
                            it2 = it4;
                            it = it3;
                        }
                        Iterator<CheckoutVendor.Discounts.Fbt> it5 = it;
                        product2.priceKpf = f3;
                        PriceByCurrency priceByCurrency = next.total;
                        float f5 = priceByCurrency.kpf;
                        int i4 = next.count;
                        product2.discountPriceKpf = f5 / i4;
                        product2.priceKpw = f4;
                        product2.discountPriceKpw = priceByCurrency.kpw / i4;
                        list3.add(product2);
                        z = true;
                        it = it5;
                    }
                }
            }
            if (list3.size() > 0) {
                final View inflate = getLayoutInflater().inflate(R.layout.item_vendor_checkout, (ViewGroup) null);
                int i5 = 0;
                float f6 = 0.0f;
                float f7 = 0.0f;
                int i6 = i2;
                while (i5 < list3.size()) {
                    CheckoutVendor.Product product3 = (CheckoutVendor.Product) list3.get(i5);
                    if (product3.qty == 0) {
                        Util.toast(this, getString(R.string.check_qty), str2, 0, 0);
                        finish();
                    }
                    java.lang.String str3 = product3.discountType;
                    if (str3 == null || str3.isEmpty()) {
                        str = str2;
                    } else {
                        float f8 = product3.priceKpf;
                        int i7 = product3.qty;
                        str = str2;
                        f6 += f8 * i7;
                        f7 += product3.priceKpw * i7;
                    }
                    if (!product3.canShipping || checkoutVendor.shippingMethods.size() <= 0) {
                        product3.canShipping = false;
                        i6++;
                    } else {
                        if (product3.currency.equals("kpf")) {
                            f = 1.0f;
                            f2 = product3.salePrice * product3.qty * 1.0f;
                        } else {
                            f = 1.0f;
                            f2 = 0.0f;
                        }
                        f6 += f2;
                        f7 += product3.currency.equals("kpw") ? product3.salePrice * product3.qty * f : 0.0f;
                    }
                    i5++;
                    str2 = str;
                }
                PriceText priceText = (PriceText) inflate.findViewById(R.id.pt_kpf_order_total);
                PriceText priceText2 = (PriceText) inflate.findViewById(R.id.pt_kpw_order_total);
                priceText.setPrice(Util.m327c(f6));
                priceText2.f12264t = f6 > 0.0f;
                priceText2.setPrice(Util.m327c(f7));
                if (f6 <= 0.0f) {
                    priceText.setVisibility(View.GONE);
                } else if (f7 <= 0.0f) {
                    priceText2.setVisibility(View.GONE);
                }
                CheckoutVendor.Discounts discounts2 = checkoutVendor.discounts;
                if (discounts2 != null && (fbts = discounts2.fbts) != null) {
                    PriceByCurrency priceByCurrency2 = fbts.total;
                    float f9 = priceByCurrency2.kpf;
                    float f10 = priceByCurrency2.kpw;
                    if (f9 + f10 > 0.0f) {
                        f6 -= f9;
                        f7 -= f10;
                        View inflate2 = getLayoutInflater().inflate(R.layout.item_label_price_checkout, (ViewGroup) null);
                        ((TextView) inflate2.findViewById(R.id.tv_label)).setText(getResources().getString(R.string.fbt_discount));
                        PriceText priceText3 = (PriceText) inflate2.findViewById(R.id.pt_kpf_discount);
                        priceText3.setPrice(Util.m327c(-checkoutVendor.discounts.fbts.total.kpf));
                        PriceText priceText4 = (PriceText) inflate2.findViewById(R.id.pt_kpw_discount);
                        priceText4.setPrice(Util.m327c(-checkoutVendor.discounts.fbts.total.kpw));
                        ((LinearLayoutCompat) inflate.findViewById(R.id.ll_vendor_shipping)).addView(inflate2, 1);
                        PriceByCurrency priceByCurrency3 = checkoutVendor.discounts.fbts.total;
                        if (priceByCurrency3.kpf <= 0.0f) {
                            priceText3.setVisibility(View.GONE);
                        } else if (priceByCurrency3.kpw <= 0.0f) {
                            priceText4.setVisibility(View.GONE);
                        }
                    }
                }
                this.f11751K.add(Float.valueOf(f6));
                this.f11752L.add(Float.valueOf(f7));
                ((TextView) inflate.findViewById(R.id.tv_vendor_name)).setText(checkoutVendor.name);
                if (f6 + f7 == 0.0f || checkoutVendor.shippingMethods.size() == 0) {
                    CustomString.m3167a(inflate, R.id.ll_vendor_price, 8, R.id.tv_cannot_shipping, 0);
                    if (CheckoutVendorVM.f10395d.getValue() != null) {
                        ((TextView) inflate.findViewById(R.id.tv_cannot_shipping)).setText(PickerViewObj.m4699b(CheckoutVendorVM.f10395d.getValue().address1, this) + getResources().getString(R.string.cannot_shipping_vendor_to));
                    }
                } else {
                    CustomString.m3167a(inflate, R.id.ll_vendor_price, 0, R.id.tv_cannot_shipping, 8);
                }
                if (checkoutVendor.shippingMethods.size() > 0) {
                    this.f11753M.add(Float.valueOf(checkoutVendor.shippingMethods.get(0).price));
                    CheckoutVendorVM.f10401j.add(checkoutVendor.shippingMethods.get(0));
                    final MutableLiveData mutableLiveData = new MutableLiveData(checkoutVendor.shippingMethods.get(0));
                    new MutableLiveData(false).observe(this, new Observer() { // from class: b.f.a.a.e.m
                        @Override // p000a.p060o.InterfaceC0405p

                        public final void onChanged(Object obj) {
                           // r0.setValue((MutableLiveData) MutableLiveData.this.getValue());
                        }
                    });
                    final int i8 = i3;
                    mutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.e.x
                        @Override // p000a.p060o.InterfaceC0405p

                        public final void onChanged(Object obj) {
                            CheckoutActivity.this.m6508a(inflate, i8, checkoutVendor, list, (CheckoutVendor.ShippingMethod) obj);
                        }
                    });
                    inflate.findViewById(R.id.cal_shipping_method).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.e.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CheckoutActivity.this.m6512a(checkoutVendor, mutableLiveData, view);
                        }
                    });
                } else {
                    this.f11753M.add(Float.valueOf(0.0f));
                    CheckoutVendorVM.f10401j.add(new CheckoutVendor.ShippingMethod());
                    if (list.size() == this.f11751K.size()) {
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        for (int i9 = 0; i9 < list.size(); i9++) {
                            f11 += this.f11751K.get(i9).floatValue();
                            f12 += this.f11752L.get(i9).floatValue();
                        }
                        ((ShimmerFrameLayout) findViewById(R.id.sfl_price)).hideShimmer();
                        findViewById(R.id.ll_price).setVisibility(View.VISIBLE);
                        findViewById(R.id.vw_shimmer_order_total).setVisibility(View.GONE);
                        TextView textView = (TextView) findViewById(R.id.tv_order_total_label);
                        ((PriceText) findViewById(R.id.pt_kpf_price)).setPrice(Util.m327c(f11));
                        ((PriceText) findViewById(R.id.pt_kpw_price)).f12264t = f11 > 0.0f;
                        ((PriceText) findViewById(R.id.pt_kpw_price)).setPrice(Util.m327c(f12));
                        Util.setColor(this, textView, R.color.body);
                        findViewById(R.id.ll_price).setVisibility(View.VISIBLE);
                        i = 8;
                        findViewById(R.id.vw_shimmer_order_total).setVisibility(View.GONE);
                        if (f11 == 0.0f && f12 == 0.0f) {
                            findViewById(R.id.sfl_price).setVisibility(View.GONE);
                        }
                    } else {
                        i = 8;
                    }
                    CustomString.m3167a(inflate, R.id.ll_vendor_shipping, i, R.id.v_border, i);
                }
                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_cart_products);
                CheckoutVendorMainAdapter c1854w0 = new CheckoutVendorMainAdapter(this);
                c1854w0.f7497f = checkoutVendor.shippingMethods.size();
                recyclerView.setAdapter(c1854w0);
                recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
                c1854w0.arrayList = list3;
                c1854w0.notifyDataSetChanged();
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
                c0541a.setMargins(0, m4299b(5), 0, m4299b(5));
                linearLayoutCompat.addView(inflate, c0541a);
                i2 = i6;
            }
            i3++;
        }
        m6515a(false);
        if (i2 <= 0 || CheckoutVendorVM.f10395d.getValue() == null) {
            return;
        }
        Util.toast(this, i2 + getResources().getString(R.string.cannot_shipping_desc), "error", 0, 0);
    }

    
    public  void m6518d(View view) {
        Intent intent = new Intent(getApplicationContext(), AddressActivity.class);
        intent.putExtra("checkout", true);
        startActivityForResult(intent, 100);
    }

    
    public  void m6519e(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /* renamed from: f */
    public  void m6520f(View view) {
        this.f11749I.m4710a();
    }

    /* renamed from: g */
    public  void m6521g(View view) {
        CheckoutVendorVM.f10398g = ((EditText) findViewById(R.id.et_customer_note)).getText().toString();
        Iterator<Float> it = this.f11751K.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f += it.next().floatValue();
        }
        Iterator<Float> it2 = this.f11752L.iterator();
        while (it2.hasNext()) {
            f += it2.next().floatValue();
        }
        if (f == 0.0f) {
            Util.toast(this, getString(CheckoutVendorVM.f10395d.getValue() == null ? R.string.select_address : R.string.select_another_address), "error", 0, 0);
            findViewById(R.id.ll_delivery_time).setVisibility(View.GONE);
            findViewById(R.id.ll_customer_note).setVisibility(View.GONE);
        } else {
            if (!((CheckBox) findViewById(R.id.cb_set_delivery_time)).isChecked()) {
                CheckoutVendorVM.f10397f.setValue( null);
            }
            startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
        }
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        java.lang.String stringExtra;
        Address address;
        super.onActivityResult(i, i2, intent);
        if (i != 100 || i2 != -1 || intent == null || (stringExtra = intent.getStringExtra("address")) == null || stringExtra.isEmpty() || (address = (Address) new Gson().fromJson(stringExtra, new C3196b(this).getType())) == null) {
            return;
        }
        CheckoutVendorVM.f10395d.setValue(address);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_checkout);
        m4307e(R.string.checkout);
        m6507a(getIntent().getExtras());
        this.f11749I = new PickerObj3(this);
        this.f11749I.f8619c = new InterfaceC2115g() { // from class: b.f.a.a.e.p
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

            public final void mo4267a(Date date, View view) {
                CheckoutActivity.this.m6514a(date, view);
            }
        };
        m6505J();
        m6504I();
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }


    public  void m6508a(@SuppressLint({"InflateParams"}) View view, int i, CheckoutVendor checkoutVendor, List list, CheckoutVendor.ShippingMethod shippingMethod) {
        java.lang.String str;
        java.lang.String sb;
        ((ActionLink) view.findViewById(R.id.cal_shipping_method)).setText(shippingMethod.name);
        CheckoutVendorVM.f10401j.set(i, shippingMethod);
        this.f11753M.set(i, Float.valueOf(shippingMethod.price));
        view.findViewById(R.id.tv_shipping_urgent).setVisibility(View.GONE);
        PriceText priceText = (PriceText) view.findViewById(R.id.pt_shipping_price);
        TextView textView = (TextView) view.findViewById(R.id.tv_free_shipping);
        if (shippingMethod.name.equals(getResources().getString(R.string.discuss_shipping_method))) {
            priceText.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
            textView.setText(getResources().getString(R.string.unknown));
            textView.setTextColor(getResources().getColor(R.color.dark));
            this.f11753M.set(i, Float.valueOf(0.0f));
        } else if (shippingMethod.price == 0.0f) {
            priceText.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
            textView.setText(getResources().getString(R.string.free_shipping));
            textView.setTextColor(getResources().getColor(R.color.success));
        } else {
            priceText.setCurrency(checkoutVendor.shippingCurrency);
            priceText.setPrice(Util.m327c(shippingMethod.price));
            textView.setVisibility(View.GONE);
        }
        if (((LinearLayoutCompat) view.findViewById(R.id.llc_shipping_time)) != null) {
            if (shippingMethod.time == 0) {
                view.findViewById(R.id.llc_shipping_time).setVisibility(View.GONE);
            } else {
                this.f11749I.m4712a(new Date(new Date().getTime() + (shippingMethod.time * 60 * 60 * 1000)));
                view.findViewById(R.id.llc_shipping_time).setVisibility(View.VISIBLE);
                TextView textView2 = (TextView) view.findViewById(R.id.tv_shipping_price);
                int i2 = shippingMethod.time;
                if (i2 >= 24) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2 / 24);
                    sb2.append(getResources().getString(R.string.day_unit));
                    int i3 = i2 % 24;
                    if (i3 == 0) {
                        sb = "";
                    } else {
                        StringBuilder m3164a = CustomString.m3164a(" ", i3);
                        m3164a.append(getResources().getString(R.string.hour_unit));
                        sb = m3164a.toString();
                    }
                    sb2.append(sb);
                    str = sb2.toString();
                } else {
                    str = i2 + getResources().getString(R.string.hour_unit);
                }
                textView2.setText(str);
            }
        }
        boolean z = CheckoutVendorVM.f10397f.getValue() == null || CheckoutVendorVM.f10396e.getTime() == CheckoutVendorVM.f10397f.getValue().getTime();
        CheckoutVendorVM.f10396e = new Date();
        for (int i4 = 0; i4 < CheckoutVendorVM.f10401j.size(); i4++) {
            long time = new Date().getTime() + (CheckoutVendorVM.f10401j.get(i4).time * 3600000);
            if (time > CheckoutVendorVM.f10396e.getTime()) {
                CheckoutVendorVM.f10396e = new Date(time);
            }
        }
        if (CheckoutVendorVM.f10397f.getValue() == null || CheckoutVendorVM.f10396e.getTime() > CheckoutVendorVM.f10397f.getValue().getTime() || z) {
            CheckoutVendorVM.f10397f.setValue( CheckoutVendorVM.f10396e);
        }
        PriceText priceText2 = (PriceText) view.findViewById(R.id.pt_vendor_kpf_price);
        PriceText priceText3 = (PriceText) view.findViewById(R.id.pt_vendor_kpw_price);
        java.lang.String str2 = checkoutVendor.shippingCurrency;
        if (str2 == null || !str2.equals("kpf")) {
            priceText2.setPrice(Util.m327c(this.f11751K.get(i).floatValue()));
            priceText3.f12264t = this.f11751K.get(i).floatValue() > 0.0f;
            priceText3.setPrice(Util.m327c(this.f11752L.get(i).floatValue() + this.f11753M.get(i).floatValue()));
            if (this.f11752L.get(i).floatValue() + this.f11753M.get(i).floatValue() <= 0.0f) {
                priceText3.setVisibility(View.GONE);
            }
            if (this.f11751K.get(i).floatValue() <= 0.0f) {
                priceText2.setVisibility(View.GONE);
            }
        } else {
            priceText2.setPrice(Util.m327c(this.f11753M.get(i).floatValue() + this.f11751K.get(i).floatValue()));
            priceText3.f12264t = this.f11753M.get(i).floatValue() + this.f11751K.get(i).floatValue() > 0.0f;
            priceText3.setPrice(Util.m327c(this.f11752L.get(i).floatValue()));
            if (this.f11751K.get(i).floatValue() + this.f11753M.get(i).floatValue() <= 0.0f) {
                priceText2.setVisibility(View.GONE);
            }
            if (this.f11752L.get(i).floatValue() <= 0.0f) {
                priceText3.setVisibility(View.GONE);
            }
        }
        if (list.size() == this.f11751K.size()) {
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i5 = 0; i5 < list.size(); i5++) {
                float floatValue = this.f11751K.get(i5).floatValue() + f;
                float floatValue2 = this.f11752L.get(i5).floatValue() + f2;
                java.lang.String str3 = checkoutVendor.shippingCurrency;
                if (str3 == null || !str3.equals("kpw")) {
                    f2 = floatValue2;
                    f = this.f11753M.get(i5).floatValue() + floatValue;
                } else {
                    f2 = this.f11753M.get(i5).floatValue() + floatValue2;
                    f = floatValue;
                }
            }
            ((ShimmerFrameLayout) findViewById(R.id.sfl_price)).hideShimmer();
            findViewById(R.id.ll_price).setVisibility(View.VISIBLE);
            findViewById(R.id.vw_shimmer_order_total).setVisibility(View.GONE);
            TextView textView3 = (TextView) findViewById(R.id.tv_order_total_label);
            ((PriceText) findViewById(R.id.pt_kpf_price)).setPrice(Util.m327c(f));
            ((PriceText) findViewById(R.id.pt_kpw_price)).f12264t = f > 0.0f;
            ((PriceText) findViewById(R.id.pt_kpw_price)).setPrice(Util.m327c(f2));
            Util.setColor(this, textView3, R.color.body);
            findViewById(R.id.ll_price).setVisibility(View.VISIBLE);
            findViewById(R.id.vw_shimmer_order_total).setVisibility(View.GONE);
        }
    }


    public static  void m6501a(MutableLiveData mutableLiveData, CheckoutVendor checkoutVendor, BaseDialog2 baseDialog2, View view, int i) {
        mutableLiveData.setValue(checkoutVendor.shippingMethods.get(i));
        baseDialog2.startAni();
    }


    public  void m6512a(final CheckoutVendor checkoutVendor, final MutableLiveData mutableLiveData, View view) {
        java.lang.String[] strArr = new java.lang.String[checkoutVendor.shippingMethods.size()];
        for (int i = 0; i < checkoutVendor.shippingMethods.size(); i++) {
            strArr[i] = checkoutVendor.shippingMethods.get(i).name;
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, strArr, null, 80);
        baseDialog2.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.e.w
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                CheckoutActivity.m6501a(MutableLiveData.this, checkoutVendor, baseDialog2, view2, i2);
            }
        };
    }
}
