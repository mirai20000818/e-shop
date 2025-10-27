package com.jeil.emarket.viewmodel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.vendor.Vendor;
import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.custom.db.DBManager;

/* renamed from: b.f.a.k.t3 */

public class ProductVendorVM extends ViewModel {

    /* renamed from: f */
    public static Product f10378f;

    /* renamed from: h */
    public static Vendor f10380h;


    public static MutableLiveData<List<Integer>> f10376d = new MutableLiveData<>();

    
    public static MutableLiveData<List<Integer>> f10377e = new MutableLiveData<>();

    /* renamed from: g */
    public static int f10379g = 0;

    
    public static int f10381i = 0;

    /* renamed from: b.f.a.k.t3$a */
    public static class a extends TypeToken<List<Integer>> {
    }

    /* renamed from: b.f.a.k.t3$b */
    public static class b extends TypeToken<List<Integer>> {
    }


    public static void m5575a(int i, Product product) {
        List<Integer> getValue = f10376d.getValue();
        if (getValue == null || getValue.size() == 0) {
            getValue = new ArrayList<>();
            getValue.add(0, Integer.valueOf(i));
        } else {
            boolean contains = getValue.contains(Integer.valueOf(i));
            Integer valueOf = Integer.valueOf(i);
            if (contains) {
                int indexOf = getValue.indexOf(valueOf);
                getValue.remove(indexOf);
                f10379g = indexOf;
            } else {
                getValue.add(0, valueOf);
            }
            f10378f = product;
        }
        f10376d.setValue( getValue);
        m5578b("wishlistProduct");
    }


    public static void m5576a(int i, Vendor vendor) {
        List<Integer> getValue = f10377e.getValue();
        if (getValue == null || getValue.size() == 0) {
            getValue = new ArrayList<>();
            getValue.add(0, Integer.valueOf(i));
        } else {
            boolean contains = getValue.contains(Integer.valueOf(i));
            Integer valueOf = Integer.valueOf(i);
            if (contains) {
                int indexOf = getValue.indexOf(valueOf);
                getValue.remove(indexOf);
                f10381i = indexOf;
            } else {
                getValue.add(0, valueOf);
            }
            f10380h = vendor;
        }
        f10377e.setValue( getValue);
        m5578b("wishlistVendor");
    }


    public static boolean m5577a(int i) {
        MutableLiveData<List<Integer>> mutableLiveData = f10377e;
        return (mutableLiveData == null || mutableLiveData.getValue() == null || !f10377e.getValue().contains(Integer.valueOf(i))) ? false : true;
    }


    public static void m5578b(String str) {
        DBManager m4767c;
        String json;
        String str2 = "wishlistProduct";
        try {
            if (str.equals("wishlistProduct")) {
                m4767c = DBManager.getDB();
                json = new Gson().toJson(f10376d.getValue());
            } else {
                m4767c = DBManager.getDB();
                str2 = "wishlistVendor";
                json = new Gson().toJson(f10377e.getValue());
            }
            m4767c.update(str2, json, 0);
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }


    public static void m5579c() {
        try {
            if (f10376d.getValue() == null || f10377e.getValue() == null) {
                f10376d = new MutableLiveData<>();
                String m4768a = DBManager.getDB().Delete("wishlistProduct");
                if (m4768a.isEmpty()) {
                    f10376d.setValue( new ArrayList());
                } else {
                    f10376d.setValue( new Gson().fromJson(m4768a, new a().getType()));
                }
                f10377e = new MutableLiveData<>();
                String m4768a2 = DBManager.getDB().Delete("wishlistVendor");
                if (m4768a2.isEmpty()) {
                    f10377e.setValue( new ArrayList());
                } else {
                    f10377e.setValue( new Gson().fromJson(m4768a2, new b().getType()));
                }
            }
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }
}
