package com.jeil.emarket.viewmodel;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.w2 */

public class DelivererVM extends ViewModel implements BaseInterface {

    
    public static MutableLiveData<Integer> f10411d = new MutableLiveData<>();

    
    public static MutableLiveData<Integer> f10412e = new MutableLiveData<>();

    /* renamed from: f */
    public static MutableLiveData<Integer> f10413f = new MutableLiveData<>();

    /* renamed from: b.f.a.k.w2$a */
    public class a extends TypeToken<Integer> {
        public a(DelivererVM delivererVM) {
        }
    }


    public static void m5588a(final Context context, final int i) {
        f10412e = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.b0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "delete_deliverer", new DelivererVM()).delete("e7/deliverers/" + i, (JSONObject) null);
            }
        });
    }


    public static void m5590a(final Context context, final int i, final JSONObject jSONObject) {
        f10412e = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.f0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "update_deliverer", new DelivererVM()).put("e7/deliverers/" + i, jSONObject);
            }
        });
    }


    public static void m5592a(final Context context, final JSONObject jSONObject) {
        f10412e = new MutableLiveData<>();
        f10413f = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.e0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "add_deliverer", new DelivererVM()).post("e7/deliverers", jSONObject);
            }
        });
    }

    
    public static void m5594b(final Context context, final int i) {
        f10411d = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.d0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "delete_staff", new DelivererVM()).delete("e7/employees/" + i, (JSONObject) null);
            }
        });
    }

    
    public static void m5596b(final Context context, final int i, final JSONObject jSONObject) {
        f10411d = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.g0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "update_staff", new DelivererVM()).put("e7/employees/" + i, jSONObject);
            }
        });
    }

    
    public static void m5598b(final Context context, final JSONObject jSONObject) {
        f10411d = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.c0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "add_staff", new DelivererVM()).post("e7/employees", jSONObject);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(String str, String str2, int i, Context context) {
        MutableLiveData<Integer> mutableLiveData;
        if (str == null || str.length() <= 0) {
            return;
        }
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -950597890:
                if (str2.equals("delete_deliverer")) {
                    c2 = 4;
                    break;
                }
                break;
            case -713429860:
                if (str2.equals("update_deliverer")) {
                    c2 = 3;
                    break;
                }
                break;
            case -597564438:
                if (str2.equals("update_staff")) {
                    c2 = 1;
                    break;
                }
                break;
            case -417366196:
                if (str2.equals("delete_staff")) {
                    c2 = 2;
                    break;
                }
                break;
            case 343531970:
                if (str2.equals("add_staff")) {
                    c2 = 0;
                    break;
                }
                break;
            case 590298740:
                if (str2.equals("add_deliverer")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2) {
            mutableLiveData = f10411d;
        } else {
            if (c2 != 3 && c2 != 4) {
                if (c2 != 5) {
                    return;
                }
                try {
                    f10413f.setValue( new Gson().fromJson(new JSONObject(str).getString("id"), new a(this).getType()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            mutableLiveData = f10412e;
        }
        mutableLiveData.setValue( Integer.valueOf(i));
    }
}
