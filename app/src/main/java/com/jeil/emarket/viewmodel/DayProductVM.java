package com.jeil.emarket.viewmodel;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.h3 */

public class DayProductVM extends ViewModel implements BaseInterface {


    public static MutableLiveData<List<Product>> f10255d = new MutableLiveData<>();


    public static MutableLiveData<List<Integer>> f10256e = new MutableLiveData<>();

    /* renamed from: f */
    public static List<Integer> f10257f = new ArrayList();

    /* renamed from: g */
    public static List<Integer> f10258g = new ArrayList();

    /* renamed from: b.f.a.k.h3$a */
    public static class a extends TypeToken<List<Integer>> {
    }


    /* renamed from: b.f.a.k.h3$c */
    public static class c extends TypeToken<List<Integer>> {
    }

    /* renamed from: b.f.a.k.h3$d */
    public class d extends TypeToken<List<Product>> {
        public d(DayProductVM dayProductVM) {
        }
    }


    public static void m5486a(Context context) {
        java.lang.String m4768a = DBManager.getDB().Delete("recentProducts");
        try {
            if (m4768a.isEmpty()) {
                f10256e.setValue( new ArrayList());
            } else {
                f10256e.setValue( new Gson().fromJson(m4768a, new a().getType()));
            }
            m5487a(context, (List<Integer>) Objects.requireNonNull(f10256e.getValue()));
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }


    public static void m5487a(final Context context, List<Integer> list) {
        if (list.size() == 0) {
            f10255d.setValue( new ArrayList());
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < list.size()) {
            sb.append(list.get(i));
            sb.append(i == list.size() + (-1) ? "" : ",");
            i++;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ids", sb.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.u1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_products", new DayProductVM()).get("e6/products", jSONObject);
            }
        });
    }


    public static void m5489c() {
        java.lang.String m4768a = DBManager.getDB().Delete("oneDayProducts");
        try {
            f10257f = !m4768a.isEmpty() ? (List) new Gson().fromJson(m4768a, new TypeToken<List<Integer>>(){}.getType()) : new ArrayList<>();
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }


    public static void m5490d() {
        java.lang.String m4768a = DBManager.getDB().Delete("oneDayVendors");
        try {
            f10258g = !m4768a.isEmpty() ? (List) new Gson().fromJson(m4768a, new c().getType()) : new ArrayList<>();
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }


    public static void m5491e() {
        try {
            DBManager.getDB().update("recentProducts", new Gson().toJson(f10256e.getValue()), 0);
        } catch (Exception unused) {
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_products")) {
            return;
        }
        try {
            f10255d.setValue( new Gson().fromJson(new JSONObject(str).getString("data"), new d(this).getType()));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }
}
