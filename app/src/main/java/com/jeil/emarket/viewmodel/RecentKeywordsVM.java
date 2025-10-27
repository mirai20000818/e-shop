package com.jeil.emarket.viewmodel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.custom.db.DBManager;

/* renamed from: b.f.a.k.i3 */

public class RecentKeywordsVM extends ViewModel {

    
    public static MutableLiveData<List<String>> f10264d = new MutableLiveData<>();

    /* renamed from: b.f.a.k.i3$a */
    public static class a extends TypeToken<List<String>> {
    }


    public static void m5492a(List<String> list) {
        f10264d.setValue( list);
        try {
            DBManager.getDB().update("recentKeywords", new Gson().toJson(list), 0);
        } catch (Exception unused) {
        }
    }

    
    public static void m5493c() {
        String m4768a = DBManager.getDB().Delete("recentKeywords");
        try {
            if (m4768a.isEmpty()) {
                return;
            }
            f10264d.setValue( new Gson().fromJson(m4768a, new a().getType()));
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }
}
