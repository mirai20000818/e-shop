package com.jeil.emarket.viewmodel;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Address;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.s2 */

public class LiveDataCollection extends ViewModel implements BaseInterface {

    /* renamed from: f */
    public static Address address;

    
    public static MutableLiveData<List<Address>> listMutableLiveData = new MutableLiveData<>();

    
    public static MutableLiveData<Integer> idLiveData = new MutableLiveData<>();

    /* renamed from: g */
    public static MutableLiveData<Address> addressMutableLiveData = new MutableLiveData<>();

    /* renamed from: h */
    public static MutableLiveData<Address> addressMutableLiveData1 = new MutableLiveData<>();

    
    public static MutableLiveData<Integer> integerMutableLiveData1 = new MutableLiveData<>();

   
    public static int anInt = -1;




    public static void m5547a(final Context context, final int i) {
        integerMutableLiveData1 = new MutableLiveData<>();
        List<Address> getValue = listMutableLiveData.getValue();
        anInt = i;
        if (getValue == null || getValue.size() == 0) {
            return;
        }
        if (getValue.size() == 1) {
            idLiveData.setValue((-1));
        } else if (idLiveData.getValue() != null && idLiveData.getValue().intValue() == i) {
            idLiveData.setValue(Integer.valueOf(getValue.get(getValue.get(0).id != i ? 0 : 1).id));
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", java.lang.String.valueOf(i));
            jSONObject.put("defaultId", idLiveData.getValue());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.t
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "delete_address", new LiveDataCollection()).delete("e6/address/" + i, jSONObject);
            }
        });
    }


    public static void m5550a(final Context context, Address address) {
        integerMutableLiveData1 = new MutableLiveData<>();
        LiveDataCollection.address = address;
        if (listMutableLiveData.getValue() == null || listMutableLiveData.getValue().size() == 0) {
            LiveDataCollection.address.isDefault = true;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", LiveDataCollection.address.name);
            jSONObject.put("address1", LiveDataCollection.address.address1);
            jSONObject.put("address2", LiveDataCollection.address.address2);
            jSONObject.put("location", LiveDataCollection.address.location);
            jSONObject.put("phone1", LiveDataCollection.address.phone1);
            jSONObject.put("phone2", LiveDataCollection.address.phone2);
            jSONObject.put("isDefault", LiveDataCollection.address.isDefault);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.w
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "add_address", new LiveDataCollection()).post("e6/address", jSONObject);
            }
        });
    }

    
    public static void m5554b(final Context context, final Address address) {
        integerMutableLiveData1 = new MutableLiveData<>();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", java.lang.String.valueOf(address.id));
            jSONObject.put("name", address.name);
            jSONObject.put("address1", address.address1);
            jSONObject.put("address2", address.address2);
            jSONObject.put("location", address.location);
            jSONObject.put("phone1", address.phone1);
            jSONObject.put("phone2", address.phone2);
            jSONObject.put("isDefault", address.isDefault ? "1" : "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LiveDataCollection.address = address;
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.s
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                LiveDataCollection.m5551a(context, address, jSONObject, context2);
            }
        });
    }

    
    public static MutableLiveData<List<Address>> getAddress() {
        return listMutableLiveData;
    }


    public void m5556a(int i) {
        anInt = -1;
        integerMutableLiveData1.setValue( Integer.valueOf(i));
    }


    public void m5557a(java.lang.String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            address.id = ((Integer) new Gson().fromJson(jSONObject.getString("id"), new TypeToken<Integer>(){}.getType())).intValue();
            if (address.isDefault) {
                idLiveData.setValue(Integer.valueOf(address.id));
            }
            addressMutableLiveData.setValue(address);
            integerMutableLiveData1.setValue( Integer.valueOf(i));
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
    }


    public void m5558a(java.lang.String str, java.lang.String str2) {
        MutableLiveData<Integer> mutableLiveData;
        try {
            JSONObject jSONObject = new JSONObject(str);
            java.lang.String string = jSONObject.getString("defaultId");
            if (!string.equals("null")) {
                try {
                    idLiveData.setValue(Integer.valueOf(Integer.parseInt(string)));
                } catch (Exception unused) {
                    mutableLiveData = idLiveData;
                }
                listMutableLiveData.setValue( new Gson().fromJson(jSONObject.getString("rows"), new TypeToken<List<Address>>(){}.getType()));
            }
            mutableLiveData = idLiveData;
            mutableLiveData.setValue( (-1));
            listMutableLiveData.setValue(new Gson().fromJson(jSONObject.getString("rows"), new TypeToken<List<Address>>(){}.getType()));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        char c2;
        switch (str2.hashCode()) {
            case -1071178741:
                if (str2.equals("get_address")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -907088544:
                if (str2.equals("delete_address")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 171608662:
                if (str2.equals("add_address")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1086879428:
                if (str2.equals("put_address")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 2016060030:
                if (str2.equals("update_address")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            m5558a(str, str2);
            return;
        }
        if (c2 == 1) {
            m5557a(str, i);
            return;
        }
        if (c2 == 2) {
            m5556a(i);
        } else if (c2 == 3 || c2 == 4) {
            m5559b(str2, i);
        }
    }

    
    public void m5559b(java.lang.String str, int i) {
        try {
            addressMutableLiveData1.setValue(address);
            integerMutableLiveData1.setValue( Integer.valueOf(i));
        } catch (Exception e2) {
            CustomString.m3173a(str, ": Gson Exception is ", e2);
        }
    }


    public static  void m5551a(Context context, Address address, JSONObject jSONObject, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "update_address", new LiveDataCollection());
        StringBuilder m3163a = CustomString.format("e6/address/");
        m3163a.append(address.id);
        APIS.put(m3163a.toString(), jSONObject);
    }
}
