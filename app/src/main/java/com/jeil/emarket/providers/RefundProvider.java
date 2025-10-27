package com.jeil.emarket.providers;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.m.y */

public class RefundProvider extends ViewModel implements BaseInterface {


    public static MutableLiveData<Boolean> f10534d = new MutableLiveData<>();


    public void m5664a(final Context context, String str, int i, int i2, String str2) {
        final JSONObject jSONObject = new JSONObject();
        f10534d = new MutableLiveData<>();
        try {
            jSONObject.put("type", str);
            jSONObject.put("orderItemId", String.valueOf(i));
            jSONObject.put("quantity", String.valueOf(i2));
            jSONObject.put("reason", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.a
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                RefundProvider.this.m5665a(context, jSONObject, context2);
            }
        });
    }


    public  void m5665a(Context context, JSONObject jSONObject, Context context2) {
        new API_PROVIDER(context, "create_refund", this).post("e6/refund", jSONObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(String str, String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("create_refund")) {
            return;
        }
        f10534d.setValue( Boolean.valueOf(i == 200));
    }
}
