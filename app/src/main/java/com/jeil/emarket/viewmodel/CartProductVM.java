package com.jeil.emarket.viewmodel;

import com.jeil.emarket.custom.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.CartProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.db.DBManager;

/* renamed from: b.f.a.k.t2 */

public class CartProductVM extends ViewModel {


    public static MutableLiveData<List<CartProduct>> f10375d = new MutableLiveData<>();

    /* renamed from: b.f.a.k.t2$a */
    public static class a extends TypeToken<List<CartProduct>> {
    }

    
    public static void m5570a(CartProduct cartProduct) {
        CartProduct cartProduct2;
        List<CartProduct> getValue = f10375d.getValue();
        boolean z = false;
        if (getValue != null && getValue.size() > 0) {
            for (int i = 0; i < getValue.size(); i++) {
                int i2 = getValue.get(i).f12392id;
                int i3 = cartProduct.f12392id;
                if ((i2 == i3 && i3 > 0) || (Objects.equals(getValue.get(i).products, cartProduct.products) && cartProduct.f12392id == 0)) {
                    int i4 = cartProduct.quantity;
                    getValue.set(i, cartProduct);
                    if (cartProduct.enableBackOrder) {
                        cartProduct2 = getValue.get(i);
                    } else {
                        cartProduct2 = getValue.get(i);
                        i4 = Math.min(i4, cartProduct.stock);
                    }
                    cartProduct2.quantity = i4;
                    getValue.get(i).checked = cartProduct.checked;
                    f10375d.setValue( getValue);
                    z = true;
                }
            }
        }
        if (!z && getValue != null) {
            getValue.add(cartProduct);
            f10375d.setValue( getValue);
        }
        m5574d();
    }

    
    public static void m5571a(CartProduct cartProduct, BaseActivity activityC1391g1) {
        boolean z;
        if (cartProduct.priceKpf + cartProduct.priceKpw <= 0.0f) {
            Util.toast(activityC1391g1, activityC1391g1.getString(R.string.cannot_add_to_cart_price), "error", R.drawable.ic_check_circle, 0);
            return;
        }
        List<CartProduct> getValue = f10375d.getValue();
        if (getValue != null && getValue.size() > 0) {
            for (int i = 0; i < getValue.size(); i++) {
                if (getValue.get(i).f12392id == cartProduct.f12392id && (getValue.get(i).discountType == null || (getValue.get(i).discountType.equals(cartProduct.discountType) && getValue.get(i).discountProducts.equals(cartProduct.discountProducts)))) {
                    int i2 = getValue.get(i).quantity + cartProduct.quantity;
                    getValue.set(i, cartProduct);
                    boolean z2 = cartProduct.enableBackOrder;
                    CartProduct cartProduct2 = getValue.get(i);
                    if (z2) {
                        cartProduct2.quantity = i2;
                    } else {
                        cartProduct2.quantity = Math.min(i2, cartProduct.stock);
                    }
                    f10375d.setValue( getValue);
                    if (i2 > cartProduct.stock) {
                        Util.toast(activityC1391g1, activityC1391g1.getString(R.string.cannot_add_to_cart), "error", 0, 0);
                    } else {
                        Util.toast(activityC1391g1, activityC1391g1.getString(R.string.added_to_cart), "success", R.drawable.ic_check_circle, 0);
                    }
                    z = true;
                    if (!z && getValue != null) {
                        getValue.add(cartProduct);
                        f10375d.setValue( getValue);
                        Util.toast(activityC1391g1, activityC1391g1.getString(R.string.added_to_cart), "success", R.drawable.ic_check_circle, 0);
                    }
                    m5574d();
                }
            }
        }
        z = false;
        if (!z) {
            getValue.add(cartProduct);
            f10375d.setValue( getValue);
            Util.toast(activityC1391g1, activityC1391g1.getString(R.string.added_to_cart), "success", R.drawable.ic_check_circle, 0);
        }
        m5574d();
    }

    
    public static void m5572a(CartProduct cartProduct, boolean z) {
        List<CartProduct> getValue = f10375d.getValue();
        if (getValue != null && getValue.size() > 0) {
            int i = 0;
            while (i < getValue.size()) {
                if (getValue.get(i).f12392id == cartProduct.f12392id) {
                    getValue.remove(i);
                    if (!z) {
                        f10375d.setValue( getValue);
                    }
                    i = getValue.size();
                }
                i++;
            }
        }
        m5574d();
    }


    public static void m5573c() {
        if (f10375d.getValue() == null) {
            f10375d = new MutableLiveData<>();
            String m4768a = DBManager.getDB().Delete("cart");
            if (m4768a.isEmpty()) {
                f10375d.setValue( new ArrayList());
                return;
            }
            try {
                f10375d.setValue( new Gson().fromJson(m4768a, new a().getType()));
            } catch (Exception e2) {
                e2.getLocalizedMessage();
            }
        }
    }


    public static void m5574d() {
        DBManager.getDB().update("cart", new Gson().toJson(f10375d.getValue()), 0);
    }
}
