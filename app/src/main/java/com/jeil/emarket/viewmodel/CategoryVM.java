package com.jeil.emarket.viewmodel;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Category;
import java.util.List;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.u2 */

public class CategoryVM extends ViewModel implements BaseInterface {


    public static MutableLiveData<List<Category>> listMutableLiveData = new MutableLiveData<>();


    public static MutableLiveData<Integer> f10387e = new MutableLiveData<>(0);

    /* renamed from: f */
    public static MutableLiveData<Boolean> f10388f = new MutableLiveData<>();

    /* renamed from: b.f.a.k.u2$a */
    public static class a extends TypeToken<List<Category>> {
    }

    public CategoryVM() {
        f10388f.setValue( true);
    }


    public static void m5580a(int i) {
        f10387e.setValue( Integer.valueOf(i));
    }


    public static void m5582a(final Context context, boolean z) {
        if (listMutableLiveData.getValue() == null || z) {
            listMutableLiveData = new MutableLiveData<>();
            String m4768a = DBManager.getDB().Delete("categories");
            if (m4768a.isEmpty() || z) {
                API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.x
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context2) {
                        new API_PROVIDER(context, "get_categories", new CategoryVM()).m5406a("e6/categories");
                    }
                });
            } else {
                m5583a(m4768a, 400, true);
            }
        }
    }


    public static void m5583a(String str, int i, boolean z) {
        try {
            listMutableLiveData.setValue( new Gson().fromJson(str, new a().getType()));
            if (z || i != 200) {
                return;
            }
            DBManager.getDB().update("categories", str, 7200000);
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(String str, String str2, int i, Context context) {
        if (!str2.equals("get_categories") || str == null || str.length() <= 0) {
            return;
        }
        m5583a(str, i, false);
    }
}
