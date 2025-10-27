package com.jeil.emarket.viewmodel;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Address;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.model.customer.CheckoutVendor;
import com.jeil.emarket.model.customer.Discounts;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.v2 */

public class CheckoutVendorVM extends ViewModel implements BaseInterface {

    
    public static int f10402k;

    
    public static MutableLiveData<Address> f10395d = new MutableLiveData<>();

    
    public static Date f10396e = new Date();

    /* renamed from: f */
    public static MutableLiveData<Date> f10397f = new MutableLiveData<>();

    /* renamed from: g */
    public static java.lang.String f10398g = "";

    /* renamed from: h */
    public static int f10399h = 0;

    
    public static MutableLiveData<List<CheckoutVendor>> f10400i = new MutableLiveData<>();

   
    public static List<CheckoutVendor.ShippingMethod> f10401j = new ArrayList();

    /* renamed from: l */
    public static MutableLiveData<Integer> f10403l = new MutableLiveData<>();

    /* renamed from: m */
    public static boolean f10404m = false;

    /* renamed from: n */
    public static boolean f10405n = false;

    /* renamed from: b.f.a.k.v2$a */
    public class a extends TypeToken<List<CheckoutVendor>> {
        public a(CheckoutVendorVM checkoutVendorVM) {
        }
    }

    /* renamed from: b.f.a.k.v2$b */
    public class b extends TypeToken<List<Address>> {
        public b(CheckoutVendorVM checkoutVendorVM) {
        }
    }

    
    public static  void m5585a(Context context, CheckoutVendor checkoutVendor, JSONObject jSONObject, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "create_order", new CheckoutVendorVM());
        f10402k = checkoutVendor.f12394id;
        APIS.post("e6/orders", jSONObject);
    }

    
    public static void m5586a(final Context context, List<CartProduct> list) {
        ArrayList arrayList = new ArrayList();
        Discounts discounts = new Discounts();
        discounts.fbts = new Discounts.Fbts();
        discounts.fbts.items = new ArrayList();
        for (CartProduct cartProduct : list) {
            if (cartProduct.checked) {
                java.lang.String str = cartProduct.discountType;
                if (str == null || str.isEmpty()) {
                    arrayList.add(cartProduct);
                } else if (cartProduct.discountType.equals("fbt")) {
                    Discounts.Fbt fbt = new Discounts.Fbt();
                    fbt.f12399id = cartProduct.discountId;
                    fbt.count = cartProduct.quantity;
                    fbt.products = new ArrayList();
                    Iterator<CartProduct> it = cartProduct.products.iterator();
                    while (it.hasNext()) {
                        fbt.products.add(Integer.valueOf(it.next().f12392id));
                    }
                    discounts.fbts.items.add(fbt);
                }
            }
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("address", f10395d.getValue() == null ? "" : f10395d.getValue().address1);
            jSONObject.put("cart", arrayList);
            jSONObject.put("discounts", discounts);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.a0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_checkout_content", new CheckoutVendorVM()).post("e6/checkout", jSONObject);
            }
        });
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        char c2;
        StringBuilder sb;
        java.lang.String str3;
        int i2;
        if (str == null || str.length() <= 0) {
            return;
        }
        int hashCode = str2.hashCode();
        int i3 = -1;
        boolean z = true;
        if (hashCode == -1071178741) {
            if (str2.equals("get_address")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode != -847958967) {
            if (hashCode == 1874714187 && str2.equals("create_order")) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (str2.equals("get_checkout_content")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            try {
                f10396e = new Date();
                f10397f.setValue( f10396e);
                f10398g = "";
                f10399h = 0;
                List<CheckoutVendor> list = (List) new Gson().fromJson(str, new a(this).getType());
                if (list.size() != 0) {
                    z = false;
                }
                f10405n = z;
                f10400i.setValue( list);
                if (f10404m) {
                    return;
                }
                List<CartProduct> getValue = CartProductVM.f10375d.getValue();
                ArrayList arrayList = new ArrayList();
                for (CheckoutVendor checkoutVendor : (List<CheckoutVendor>) Objects.requireNonNull(f10400i.getValue())) {
                    if (checkoutVendor.shippingMethods == null) {
                        checkoutVendor.shippingMethods = new ArrayList();
                    }
                    if (getValue != null) {
                        for (CheckoutVendor.Product product : checkoutVendor.products) {
                            for (CartProduct cartProduct : getValue) {
                                if (cartProduct.f12392id == product.f12397id) {
                                    cartProduct.stock = product.stock;
                                    cartProduct.priceKpf = cartProduct.currency.equals("kpf") ? product.salePrice : 0.0f;
                                    cartProduct.priceKpw = cartProduct.currency.equals("kpw") ? product.salePrice : 0.0f;
                                    cartProduct.quantity = product.qty;
                                    cartProduct.enableBackOrder = product.enableBackOrder;
                                    arrayList.add(cartProduct);
                                }
                            }
                        }
                        CheckoutVendor.Discounts discounts = checkoutVendor.discounts;
                        if (discounts != null && discounts.fbts != null && discounts.fbts.items != null) {
                            for (CartProduct cartProduct2 : getValue) {
                                if (cartProduct2.checked && cartProduct2.vendorId == checkoutVendor.f12394id && (str3 = cartProduct2.discountType) != null && str3.equals("fbt")) {
                                    arrayList.add(cartProduct2);
                                }
                            }
                        }
                    }
                    if (getValue != null) {
                        f10403l.setValue( Integer.valueOf(getValue.size() - arrayList.size()));
                    }
                }
                if (getValue != null) {
                    for (CartProduct cartProduct3 : getValue) {
                        if (!cartProduct3.checked) {
                            arrayList.add(cartProduct3);
                        }
                    }
                }
                CartProductVM.f10375d.setValue( arrayList);
                CartProductVM.m5574d();
                return;
            } catch (Exception e2) {
                sb = new StringBuilder();
            }
        } else {
            if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                try {
                    int i4 = new JSONObject(str).getInt("id");
                    if (i4 > 0) {
                        f10399h = i4;
                    }
                    if (f10402k > 0) {
                        Iterator it = ((List) Objects.requireNonNull(f10400i.getValue())).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CheckoutVendor checkoutVendor2 = (CheckoutVendor) it.next();
                            if (checkoutVendor2.f12394id == f10402k) {
                                List<CartProduct> getValue2 = CartProductVM.f10375d.getValue();
                                ArrayList arrayList2 = new ArrayList(f10400i.getValue());
                                int indexOf = arrayList2.indexOf(checkoutVendor2);
                                CheckoutVendor checkoutVendor3 = (CheckoutVendor) arrayList2.get(indexOf);
                                ArrayList arrayList3 = new ArrayList(checkoutVendor3.products);
                                for (CheckoutVendor.Product product2 : checkoutVendor3.products) {
                                    if (product2.canShipping) {
                                        arrayList3.remove(product2);
                                        if (!f10404m) {
                                            if (getValue2 != null) {
                                                i2 = 0;
                                                while (i2 < getValue2.size()) {
                                                    if (getValue2.get(i2).f12392id == product2.f12397id) {
                                                        break;
                                                    } else {
                                                        i2++;
                                                    }
                                                }
                                            }
                                            i2 = -1;
                                            if (i2 >= 0) {
                                                getValue2.remove(i2);
                                            }
                                        }
                                    }
                                }
                                if (getValue2 != null) {
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= getValue2.size()) {
                                            break;
                                        }
                                        if (getValue2.get(i5).discountType != null && !getValue2.get(i5).discountType.isEmpty() && getValue2.get(i5).vendorId == checkoutVendor3.f12394id) {
                                            i3 = i5;
                                            break;
                                        }
                                        i5++;
                                    }
                                }
                                if (i3 >= 0) {
                                    getValue2.remove(i3);
                                }
                                if (getValue2 != null) {
                                    for (CartProduct cartProduct4 : getValue2) {
                                        if (cartProduct4.vendorId == checkoutVendor3.f12394id) {
                                            cartProduct4.checked = true;
                                        }
                                    }
                                }
                                if (!f10404m) {
                                    CartProductVM.f10375d.setValue( getValue2);
                                    CartProductVM.m5574d();
                                }
                                checkoutVendor3.products.clear();
                                checkoutVendor3.products.addAll(arrayList3);
                                if (checkoutVendor3.products.size() > 0) {
                                    arrayList2.set(indexOf, checkoutVendor3);
                                } else {
                                    arrayList2.remove(indexOf);
                                }
                                if (f10401j.size() > indexOf) {
                                    f10401j.remove(indexOf);
                                }
                                f10400i.setValue( arrayList2);
                            }
                        }
                        f10402k = 0;
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e3);
                    MutableLiveData<List<CheckoutVendor>> mutableLiveData = f10400i;
                    mutableLiveData.setValue( mutableLiveData.getValue());
                    f10402k = 0;
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i6 = jSONObject.getInt("defaultId");
                for (Address address : (List<Address>) new Gson().fromJson(jSONObject.getString("rows"), new b(this).getType())) {
                    if (address.id == i6) {
                        f10395d.setValue(address);
                        return;
                    }
                }
                return;
            } catch (Exception e4) {
                sb = new StringBuilder();
            }
        }
        sb.append(str2);
        sb.append(": Gson Exception is ");
        sb.toString();
    }
}
