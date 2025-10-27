package com.jeil.emarket.viewmodel;

import android.content.Context;

import com.jeil.emarket.custom.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Home;
import com.jeil.emarket.model.customer.Newsletter;
import com.jeil.emarket.model.customer.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.custom.db.SQLHelper;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.x2 */

public class BottomVM extends ViewModel implements BaseInterface {


    public static MutableLiveData<Home> homeMutableLiveData = new MutableLiveData<>();


    public static MutableLiveData<List<Product>> f10420e = new MutableLiveData<>();

    /* renamed from: f */
    public static MutableLiveData<List<Product>> f10421f = new MutableLiveData<>();

    /* renamed from: g */
    public static MutableLiveData<List<Product>> f10422g = new MutableLiveData<>();

    /* renamed from: h */
    public static MutableLiveData<List<Newsletter>> newsletterListLiveData = new MutableLiveData<>();


    public static boolean f10424i = false;

   
    public static boolean f10425j = false;


    public static boolean f10426k = false;

    /* renamed from: l */
    public static boolean f10427l = false;

    /* renamed from: m */
    public static MutableLiveData<Integer> f10428m = new MutableLiveData<>();

    /* renamed from: b.f.a.k.x2$a */
    public static class a extends TypeToken<Home> {
    }

    /* renamed from: b.f.a.k.x2$b */
    public static class b extends TypeToken<List<Product>> {
    }

    /* renamed from: b.f.a.k.x2$c */
    public static class c extends TypeToken<List<Product>> {
    }

    /* renamed from: b.f.a.k.x2$d */
    public static class d extends TypeToken<List<Newsletter>> {
    }


    public static  int m5600a(Newsletter newsletter, Newsletter newsletter2) {
        if (newsletter.startDate.getTime() < newsletter2.startDate.getTime()) {
            return 1;
        }
        if (newsletter.startDate.getTime() > newsletter2.startDate.getTime()) {
            return -1;
        }
        return newsletter2.priority - newsletter.priority;
    }


    public static void m5603a(final Context context, boolean z) {
        if ((newsletterListLiveData.getValue() == null || z) && !f10427l) {
            f10427l = true;
            API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.l0
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context2) {
                    new API_PROVIDER(context, "get_news", new BottomVM()).m5406a("e6/news");
                }
            });
        }
    }


    public static void m5604a(String str, int i, boolean z) {
        homeMutableLiveData.setValue( new Gson().fromJson(str, new a().getType()));
        if (!z && i == 200) {
            DBManager.getDB().update("home", str, 7200000);
        }
        f10424i = false;
        if (homeMutableLiveData.getValue() != null && homeMutableLiveData.getValue().avatarCount > 0) {
            Status.f8819j = homeMutableLiveData.getValue().avatarCount;
        }
        if (homeMutableLiveData.getValue() != null && homeMutableLiveData.getValue().lowStockLimit > 0) {
            Status.f8815f = homeMutableLiveData.getValue().lowStockLimit;
        }
        if (homeMutableLiveData.getValue() != null) {
            Status.f8832w = false;
        }
    }


    public static void m5607b(final Context context, boolean z) {
        InterfaceContext interfaceContext;
        if ((homeMutableLiveData.getValue() == null || z) && !f10424i) {
            f10424i = true;
            if (DBManager.context == null) {
                DBManager.context = context;
            }
            if (SQLHelper.f8844c == null) {
                SQLHelper.f8844c = context;
            }
            String m4768a = DBManager.getDB().Delete("home");
            if (m4768a.isEmpty() || z) {
                interfaceContext = new InterfaceContext() { // from class: b.f.a.k.o0
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context2) {
                        BottomVM.m5610c(context, context2);
                    }
                };
            } else {
                try {
                    m5604a(m4768a, 400, true);
                    return;
                } catch (Exception unused) {
                    interfaceContext = new InterfaceContext() { // from class: b.f.a.k.m0
                        @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                        public final void mo4271a(Context context2) {
                            BottomVM.m5605b(context, context2);
                        }
                    };
                }
            }
            API_PROVIDER.checkInternet(context, interfaceContext);
        }
    }


    public static void m5608b(String str) {
        List<Newsletter> list = (List) new Gson().fromJson(str, new d().getType());
        if (list != null && list.size() > 0) {
            Iterator<Newsletter> it = list.iterator();
            while (it.hasNext()) {
                it.next().priority = (int) (Math.random() );
            }
            Collections.sort(list, new Comparator() { // from class: b.f.a.k.n0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return BottomVM.m5600a((Newsletter) obj, (Newsletter) obj2);
                }
            });
        }
        newsletterListLiveData.setValue( list);
        f10427l = false;
    }


    public static void m5609b(String str, int i, boolean z) throws JSONException {
        MutableLiveData<List<Product>> mutableLiveData;
        ArrayList arrayList;
        List<Product> list = (List) new Gson().fromJson(new JSONObject(str).getString("data"), new b().getType());
        if (list == null) {
            f10420e.setValue( new ArrayList());
            mutableLiveData = f10422g;
            arrayList = new ArrayList();
        } else {
            if (list.size() > 10) {
                f10420e.setValue( list.subList(0, 10));
                f10422g.setValue( list.subList(10, list.size()));
                if (!z && i == 200) {
                    DBManager.getDB().update("homeFeatured", str, 7200000);
                }
                f10425j = false;
            }
            f10420e.setValue( list);
            mutableLiveData = f10422g;
            arrayList = new ArrayList();
        }
        mutableLiveData.setValue( arrayList);
        if (!z) {
            DBManager.getDB().update("homeFeatured", str, 7200000);
        }
        f10425j = false;
    }


    public static void m5611c(final Context context, boolean z) {
        InterfaceContext interfaceContext;
        if ((f10420e.getValue() == null || z) && !f10425j) {
            f10425j = true;
            String m4768a = DBManager.getDB().Delete("homeFeatured");
            if (m4768a.isEmpty() || z) {
                interfaceContext = new InterfaceContext() { // from class: b.f.a.k.k0
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context2) {
                        new API_PROVIDER(context, "get_monthly_products", new BottomVM()).m5406a("e6/home/featured");
                    }
                };
            } else {
                try {
                    m5609b(m4768a, 400, true);
                    return;
                } catch (Exception unused) {
                    interfaceContext = new InterfaceContext() { // from class: b.f.a.k.i0
                        @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                        public final void mo4271a(Context context2) {
                            new API_PROVIDER(context, "get_monthly_products", new BottomVM()).m5406a("e6/home/featured");
                        }
                    };
                }
            }
            API_PROVIDER.checkInternet(context, interfaceContext);
        }
    }


    public static void m5612c(String str, int i, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        f10421f.setValue( new Gson().fromJson(jSONObject.getString("data"), new c().getType()));
        f10428m.setValue( Integer.valueOf(jSONObject.getInt("total")));
        if (!z && i == 200) {
            DBManager.getDB().update("newProducts", str, 7200000);
        }
        f10426k = false;
    }


    public static void m5614d(final Context context, boolean z) {
        InterfaceContext interfaceContext;
        if ((f10421f.getValue() == null || z) && !f10426k) {
            f10426k = true;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("perPage", 10);
                jSONObject.put("withoutIDSort", true);
                jSONObject.put("new_products", true);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String m4768a = DBManager.getDB().Delete("newProducts");
            if (m4768a.isEmpty() || z) {
                interfaceContext = new InterfaceContext() { // from class: b.f.a.k.j0
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context2) {
                        new API_PROVIDER(context, "get_new_products", new BottomVM()).get("e6/products", jSONObject);
                    }
                };
            } else {
                try {
                    m5612c(m4768a, 400, true);
                    return;
                } catch (Exception unused) {
                    interfaceContext = new InterfaceContext() { // from class: b.f.a.k.h0
                        @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                        public final void mo4271a(Context context2) {
                            new API_PROVIDER(context, "get_new_products", new BottomVM()).get("e6/products", jSONObject);
                        }
                    };
                }
            }
            API_PROVIDER.checkInternet(context, interfaceContext);
        }
    }


    public static  void m5605b(Context context, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "get_home_data", new BottomVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("views", true);
            jSONObject.put("version", "1.1.0");
            jSONObject.put("zipFile", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        APIS.get("e6/home", jSONObject);
    }


    public static  void m5610c(Context context, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "get_home_data", new BottomVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("views", true);
            jSONObject.put("version", "1.1.0");
            jSONObject.put("zipFile", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        APIS.get("e6/home", jSONObject);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(String str, String str2, int i, Context context) {
        if (str == null || str.isEmpty()) {
            return;
        }
        char c2 = 65535;
        try {
            switch (str2.hashCode()) {
                case -1662403231:
                    if (str2.equals("get_home_data")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1437476065:
                    if (str2.equals("get_monthly_products")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1956914028:
                    if (str2.equals("get_new_products")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1976490524:
                    if (str2.equals("get_news")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                m5604a(str, i, false);
                return;
            }
            if (c2 == 1) {
                m5609b(str, i, false);
            } else if (c2 == 2) {
                m5612c(str, i, false);
            } else {
                if (c2 != 3) {
                    return;
                }
                m5608b(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Util.toast(context, context.getString(R.string.server_failed), "error", 0, 0);
        }
    }
}
