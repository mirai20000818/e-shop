package com.jeil.emarket.viewmodel;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.vendor.Dashboard;
import com.jeil.emarket.model.vendor.Product;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.model.vendor.VendorBusinessInfo;
import com.jeil.emarket.model.vendor.VendorInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.s3 */

public class VendorListVM extends ViewModel implements BaseInterface {

    
    public static MutableLiveData<Vendor> f10363d = new MutableLiveData<>();

    
    public static MutableLiveData<Dashboard> f10364e = new MutableLiveData<>();

    /* renamed from: f */
    public static MutableLiveData<List<Vendor>> f10365f = new MutableLiveData<>();

    /* renamed from: g */
    public static MutableLiveData<Integer> f10366g = new MutableLiveData<>();

    /* renamed from: h */
    public static MutableLiveData<List<Product>> f10367h = new MutableLiveData<>();

    
    public static MutableLiveData<List<Product>> f10368i = new MutableLiveData<>();

    /* renamed from: b.f.a.k.s3$a */
    public static class a extends TypeToken<List<Product>> {
    }

    /* renamed from: b.f.a.k.s3$b */
    public static class b extends TypeToken<List<Product>> {
    }


    public static void m5560a(final Context context) {
        f10367h = new MutableLiveData<>();
        java.lang.String m4768a = DBManager.getDB().Delete("vendorProducts");
        if (m4768a.isEmpty()) {
            API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.i2
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context2) {
                    new API_PROVIDER(context, "get_vendor_all_products", new VendorListVM()).m5406a("e7/products/all");
                }
            });
        } else {
            m5564a(m4768a, "get_vendor_all_products", 400, true);
        }
    }


    public static void m5564a(java.lang.String str, java.lang.String str2, int i, boolean z) {
        if (!z && i == 200) {
            try {
                DBManager.getDB().update("vendorProducts", str, 7200000);
            } catch (Exception e2) {
                CustomString.m3173a(str2, ": Gson Exception is ", e2);
                return;
            }
        }
        f10367h.setValue( new Gson().fromJson(str, new a().getType()));
        if (f10367h.getValue() == null || f10367h.getValue().size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < f10367h.getValue().size(); i2++) {
            f10367h.getValue().get(i2).isSelected = false;
        }
    }


    public static void m5565b(final Context context) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.g2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_dashboard_data", new VendorListVM()).m5406a("e7/dashboard");
            }
        });
    }


    public static void m5567b(java.lang.String str, java.lang.String str2, int i, boolean z) {
        if (!z && i == 200) {
            try {
                DBManager.getDB().update("vendorVariableProducts", str, 7200000);
            } catch (Exception e2) {
                CustomString.m3173a(str2, ": Gson Exception is ", e2);
                return;
            }
        }
        f10368i.setValue( new Gson().fromJson(str, new b().getType()));
        if (f10368i.getValue() == null || f10368i.getValue().size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < f10368i.getValue().size(); i2++) {
            f10368i.getValue().get(i2).isSelected = false;
        }
    }


    public static void m5568c(final Context context) {
        f10363d = new MutableLiveData<>();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("withLevel", "true");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.h2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_vendor_data", new VendorListVM()).get("e7/vendor", jSONObject);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1698548017:
                if (str2.equals("update_vendor_info")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1617229720:
                if (str2.equals("get_vendors_name")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1018733253:
                if (str2.equals("get_vendor_all_variable_products")) {
                    c2 = 4;
                    break;
                }
                break;
            case 899329240:
                if (str2.equals("get_vendor_data")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1476558192:
                if (str2.equals("get_vendor_all_products")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1827259006:
                if (str2.equals("get_dashboard_data")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            try {
                f10364e.setValue( new Gson().fromJson(str, new  TypeToken<Dashboard>(){}.getType()));
                return;
            } catch (Exception e2) {
                CustomString.m3173a(str2, ": Gson Exception is ", e2);
                return;
            }
        }
        if (c2 == 1) {
            try {
                VendorInfo vendorInfo = (VendorInfo) new Gson().fromJson(str, new TypeToken<VendorInfo>(){}.getType());
                if (vendorInfo.vendor != null) {
                    f10363d.setValue( vendorInfo.vendor);
                    return;
                }
                return;
            } catch (Exception e3) {
                CustomString.m3173a(str2, ": Gson Exception is ", e3);
                return;
            }
        }
        if (c2 == 2) {
            try {
                f10365f.setValue( new Gson().fromJson(str, new TypeToken<List<Vendor>>(){}.getType()));
                return;
            } catch (Exception e4) {
                CustomString.m3173a(str2, ": Gson Exception is ", e4);
                return;
            }
        }
        if (c2 == 3) {
            m5564a(str, str2, i, false);
        } else if (c2 == 4) {
            m5567b(str, str2, i, false);
        } else {
            if (c2 != 5) {
                return;
            }
            f10366g.setValue( Integer.valueOf(i));
        }
    }


    public static void m5562a(Context context, VendorBusinessInfo vendorBusinessInfo) {
        f10366g = new MutableLiveData<>();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vendor", new Gson().toJson(vendorBusinessInfo));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(context, "update_vendor_info", new VendorListVM()).put("e7/vendor/business", jSONObject);
    }
}
