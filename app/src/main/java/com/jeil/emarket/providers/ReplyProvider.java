package com.jeil.emarket.providers;

import android.annotation.SuppressLint;
import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.jeil.emarket.model.vendor.Reply;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.m.a0 */

public class ReplyProvider extends ViewModel implements BaseInterface {

    
    @SuppressLint({"StaticFieldLeak"})
    public MutableLiveData<Reply> replyMutableLiveData = new MutableLiveData<>();

    
    public MutableLiveData<Boolean> booleanMutableLiveData = new MutableLiveData<>();

    @SuppressLint({"DefaultLocale"})

    public void m5618a(final Context context, final int i) {
        this.booleanMutableLiveData = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.e
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReplyProvider.this.delete(context, i, context2);
            }
        });
    }

    @SuppressLint({"DefaultLocale"})

    public void m5619a(final Context context, final int i, int i2, java.lang.String str, java.lang.String str2) {
        this.booleanMutableLiveData = new MutableLiveData<>();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("productName", str);
            jSONObject.put("replyId", i2);
            jSONObject.put("reviewId", i);
            jSONObject.put("text", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.d
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReplyProvider.this.m5625b(context, i, jSONObject, context2);
            }
        });
    }


    public  void delete(Context context, int i, Context context2) {
        new API_PROVIDER(context, "delete_review", this).delete(java.lang.String.format("e7/reviews/reply/%d", Integer.valueOf(i)), (JSONObject) null);
    }

    @SuppressLint({"DefaultLocale"})

    public void add(final Context context, final int i, java.lang.String str, java.lang.String str2) {
        this.booleanMutableLiveData = new MutableLiveData<>();
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
            jSONObject.put("productName", str);
            jSONObject.put("text", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.c
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReplyProvider.this.add(context, i, jSONObject, context2);
            }
        });
    }


    public  void add(Context context, int i, JSONObject jSONObject, Context context2) {
        new API_PROVIDER(context, "add_reply", this).post(java.lang.String.format("e7/reviews/%d/reply", Integer.valueOf(i)), jSONObject);
    }

    
    public void m5623b(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.b
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReplyProvider.this.m5624b(context, i, context2);
            }
        });
    }

    
    public  void m5624b(Context context, int i, Context context2) {
        try {
            API_PROVIDER APIS = new API_PROVIDER(context, "get_review_info", this);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i);
            APIS.get("e7/reviews/" + i, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    
    public  void m5625b(Context context, int i, JSONObject jSONObject, Context context2) {
        new API_PROVIDER(context, "add_reply", this).put(java.lang.String.format("e7/reviews/%d/reply", Integer.valueOf(i)), jSONObject);
    }

    
    public MutableLiveData<Boolean> m5626c() {
        return this.booleanMutableLiveData;
    }

    
    public MutableLiveData<Reply> m5627d() {
        return this.replyMutableLiveData;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -2095212084) {
            if (hashCode != -95303572) {
                if (hashCode == 342176204 && str2.equals("add_reply")) {
                    c2 = 2;
                }
            } else if (str2.equals("delete_review")) {
                c2 = 1;
            }
        } else if (str2.equals("get_review_info")) {
            c2 = 0;
        }
        if (c2 != 0) {
            if (c2 != 1 && c2 != 2) {
                throw new IllegalStateException(CustomString.append("Unexpected value: ", str2));
            }
            this.booleanMutableLiveData.setValue( Boolean.valueOf(i == 200));
            return;
        }
        try {
            this.replyMutableLiveData.setValue( new Gson().fromJson(str, new TypeReply(this).getType()));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }
}
