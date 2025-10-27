package com.jeil.emarket.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Base64;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Account;
import com.jeil.emarket.model.customer.MarketConnection;
import com.jeil.emarket.model.customer.MergeRequests;
import com.jeil.emarket.model.customer.OrderStatus;
import com.jeil.emarket.model.customer.PasswordFaq;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.model.vendor.VendorUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.r2 */

public class UserVM extends ViewModel implements BaseInterface {


    public static SharedPreferences sharedPreferences;


    public static MutableLiveData<Boolean> booleanMutableLiveData = new MutableLiveData<>(false);

    /* renamed from: f */
    public static MutableLiveData<java.lang.String> stringMutableLiveData = new MutableLiveData<>();

    /* renamed from: g */
    public static MutableLiveData<java.lang.String> stringMutableLiveData1 = new MutableLiveData<>();

    /* renamed from: h */
    public static MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    
    public static MutableLiveData<VendorUser> vendorUserMutableLiveData = new MutableLiveData<>();

   
    public static MutableLiveData<java.lang.String> stringMutableLiveData2 = new MutableLiveData<>();

    
    public static MutableLiveData<java.lang.String> stringMutableLiveData3 = new MutableLiveData<>();

    /* renamed from: l */
    public static MutableLiveData<Integer> integerMutableLiveData = new MutableLiveData<>();

    /* renamed from: m */
    public static MutableLiveData<MergeRequests> mergeRequestsMutableLiveData = new MutableLiveData<>();

    /* renamed from: n */
    public static int f10337n = -1;

    /* renamed from: o */
    public static MergeRequests.AccountMerge accountMerge = null;

    /* renamed from: p */
    public static MutableLiveData<List<OrderStatus>> listMutableLiveData = new MutableLiveData<>();

    /* renamed from: q */
    public static boolean f10340q = false;

    /* renamed from: r */
    public static MutableLiveData<List<java.lang.String>> f10341r = new MutableLiveData<>();

    /* renamed from: s */
    public static MutableLiveData<Integer> f10342s = new MutableLiveData<>();

    /* renamed from: t */
    public static MutableLiveData<List<PasswordFaq>> f10343t = new MutableLiveData<>();

    /* renamed from: u */
    public static MutableLiveData<java.lang.String> f10344u = new MutableLiveData<>();

    /* renamed from: v */
    public static MutableLiveData<MarketConnection> marketConnection = new MutableLiveData<>();

    /* renamed from: w */
    public static boolean isConnected = false;

    /* renamed from: x */
    public static boolean f10347x = false;

    /* renamed from: y */
    public static MutableLiveData<Integer> f10348y = new MutableLiveData<>();


    public static void login(Context context) {
        java.lang.String str = "";
        if (sharedPreferences.getBoolean("auto_login", false)) {
            API_PROVIDER APIS = new API_PROVIDER(context, "check_user_info", new UserVM());
            JSONObject jSONObject = new JSONObject();
            try {
                java.lang.String encodeToString = Base64.encodeToString(((java.lang.String) Objects.requireNonNull(sharedPreferences.getString("save_password", ""))).getBytes(), 0);
                jSONObject.put("username", sharedPreferences.getString("saved_username", ""));
                if (!f10340q) {
                    str = encodeToString;
                }
                jSONObject.put("password", str);
                APIS.post("e6/auth/login", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }


    public static void m5515a(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.f
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                UserVM.m5516a(context, i, context2);
            }
        });
    }


    public static void m5519a(final Context context, final java.lang.String str) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.o
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                UserVM.m5520a(context, str, context2);
            }
        });
    }


    public static void m5521a(final Context context, final java.lang.String str, final java.lang.String str2) {
        integerMutableLiveData = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.d
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                UserVM.m5522a(context, str, str2, context2);
            }
        });
    }


    public static void m5523a(final Context context, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5, final int[] iArr, final java.lang.String[] strArr) {
        booleanMutableLiveData = new MutableLiveData<>();
        f10348y = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.g
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                UserVM.m5524a(context, str, str2, str3, str4, str5, iArr, strArr, context2);
            }
        });
    }


    public static void m5526a(final Context context, final java.lang.String str, final java.lang.String str2, final boolean z) {
        f10342s = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.b
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                UserVM.m5527a(context, str2, str, z, context2);
            }
        });
    }


    public static void m5528a(final Context context, final JSONObject jSONObject) {
        f10342s = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.l
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "change_cid", new UserVM()).put("e6/auth/cid", jSONObject);
            }
        });
    }


    public static void connect(final Context context) {
        if (isConnected) {
            return;
        }
        marketConnection = new MutableLiveData<>();
        isConnected = true;
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.n
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_market_connection_info", new UserVM()).m5406a("e6/options/connection");
            }
        });
    }


    public static void m5537b(final Context context, final java.lang.String str, final java.lang.String str2) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.m
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                UserVM.m5543c(context, str, str2, context2);
            }
        });
    }


    public static void m5539b(final BaseActivity activityC1391g1, boolean z) {
        java.lang.String m4768a = DBManager.getDB().Delete("order_history");
        if (m4768a.isEmpty() || z) {
            API_PROVIDER.checkInternet(activityC1391g1, new InterfaceContext() { // from class: b.f.a.k.r
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context) {
                    new API_PROVIDER(activityC1391g1, "get_order_history", new UserVM()).m5406a("e6/orders/stats");
                }
            });
        } else {
            m5532a(m4768a, "get_order_history", 400, true);
        }
    }


    public static void m5541c(final Context context) {
        f10343t = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.q
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_registered_faq_info", new UserVM()).m5406a("e6/auth/faq");
            }
        });
    }


    public static  void m5542c(Context context, Context context2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("username", stringMutableLiveData1.getValue());
            new API_PROVIDER(context, "get_merge_requests", new UserVM()).get("e6/auth/merge", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static void m5544d(final Context context) {
        f10342s = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.i
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_user_name", new UserVM()).get("e6/auth/username", new JSONObject());
            }
        });
    }


    public static void m5531a(BaseActivity activityC1391g1, boolean z) {
        if (z || stringMutableLiveData.getValue() == null || stringMutableLiveData.getValue().isEmpty()) {
            MutableLiveData<java.lang.String> mutableLiveData = stringMutableLiveData;
            sharedPreferences.getString("cid", "");
            try {
                activityC1391g1.getPackageManager().getPackageInfo("com.mobile.kangsong.cidgen", 0);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("cid:"));
                intent.setPackage("com.mobile.kangsong.cidgen");
                intent.putExtra("FLAG", 2);
                intent.putExtra("CONNECTED", 1);
                intent.putExtra("PKG", "com.jeil.emarket");
                if (activityC1391g1.getPackageManager().queryIntentActivities(intent, 131072).size() > 0) {
                    activityC1391g1.startActivityForResult(intent, 123);
                } else {
                    Util.toast(activityC1391g1, activityC1391g1.getString(R.string.install_cid_apk), "error", 0, 0);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                Util.toast(activityC1391g1, activityC1391g1.getString(R.string.install_cid_apk), "default", 0, 0);
                activityC1391g1.finish();
            }
            mutableLiveData.setValue("");
        }
    }


    public static  void m5538b(Context context, java.lang.String str, java.lang.String str2, Context context2) {
        try {
            API_PROVIDER APIS = new API_PROVIDER(context, "check_user_info", new UserVM());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("username", str);
            jSONObject.put("password", Base64.encodeToString(str2.getBytes(), 0));
            APIS.post("e6/auth/login", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5543c(Context context, java.lang.String str, java.lang.String str2, Context context2) {
        f10342s = new MutableLiveData<>();
        try {
            API_PROVIDER APIS = new API_PROVIDER(context, "check_vendor_info", new UserVM());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userid", str);
            jSONObject.put("password", Base64.encodeToString(str2.getBytes(), 0));
            APIS.post("e7/auth/login", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5536b(Context context, java.lang.String str, Context context2) {
        try {
            f10342s = new MutableLiveData<>();
            API_PROVIDER APIS = new API_PROVIDER(context, "check_vendor_info", new UserVM());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userid", str);
            jSONObject.put("type", "fingerprint");
            jSONObject.put("password", Util.m343e(16));
            APIS.post("e7/auth/login", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static void m5540c() {
        f10347x = false;
        vendorUserMutableLiveData.setValue( null);
        stringMutableLiveData3.setValue(null);
        userMutableLiveData.setValue( null);
        stringMutableLiveData2.setValue(null);
    }


    public static void m5532a(java.lang.String str, java.lang.String str2, int i, boolean z) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            if (!z && i == 200) {
                DBManager.getDB().update("order_history", str, 7200000);
            }
            for (java.lang.String str3 : new java.lang.String[]{"requested", "accepted", "shipping"}) {
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.status = str3;
                orderStatus.count = jSONObject.getInt(str3);
                arrayList.add(orderStatus);
            }
            listMutableLiveData.setValue( arrayList);
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }


    public static  void m5516a(Context context, int i, Context context2) {
        new API_PROVIDER(context, "cancel_merge_request", new UserVM()).delete("e6/auth/merge/" + i, (JSONObject) null);
        f10337n = i;
    }


    public static  void m5517a(Context context, int i, boolean z, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "change_profile", new UserVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avatar", i);
            jSONObject.put("isMerged", z);
            APIS.put("e6/profile", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5525a(Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, java.lang.String str5, Context context2) {
        f10342s = new MutableLiveData<>();
        API_PROVIDER APIS = new API_PROVIDER(context, "change_profile", new UserVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fullname", str);
            jSONObject.put("birthday", str2);
            jSONObject.put("name", str3);
            jSONObject.put("gender", str4);
            jSONObject.put("isMerged", z);
            jSONObject.put("mask", Base64.encodeToString(str5.getBytes(), 0));
            APIS.put("e6/profile", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5527a(Context context, java.lang.String str, java.lang.String str2, boolean z, Context context2) {
        f10341r.setValue( new ArrayList());
        API_PROVIDER APIS = new API_PROVIDER(context, "get_user_names", new UserVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("birthday", str);
            jSONObject.put("username", str2);
            APIS.get(z ? "e7/auth/names" : "e6/auth/names", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5524a(Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int[] iArr, java.lang.String[] strArr, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "register_user", new UserVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("username", str);
            jSONObject.put("birthday", str2);
            jSONObject.put("fullname", str3);
            jSONObject.put("password", Base64.encodeToString(str4.getBytes(), 0));
            jSONObject.put("gender", str5);
            jSONObject.put("questionId", iArr);
            jSONObject.put("answer", strArr);
            APIS.post("e6/auth/register", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5520a(Context context, java.lang.String str, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "request_merge_account", new UserVM());
        JSONObject jSONObject = new JSONObject();
        accountMerge = new MergeRequests.AccountMerge();
        MergeRequests.AccountMerge accountMerge = UserVM.accountMerge;
        accountMerge.targetChannel = "desktop";
        accountMerge.createdAt = new Date();
        UserVM.accountMerge.sourceUser = stringMutableLiveData1.getValue();
        UserVM.accountMerge.targetUser = str;
        try {
            jSONObject.put("channel", "desktop");
            jSONObject.put("targetName", str);
            jSONObject.put("username", stringMutableLiveData1.getValue());
            APIS.post("e6/auth/merge", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5522a(Context context, java.lang.String str, java.lang.String str2, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "update_password", new UserVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prevPassword", Base64.encodeToString(str.getBytes(), 0));
            jSONObject.put("password", Base64.encodeToString(str2.getBytes(), 0));
            APIS.put("e6/auth/password", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public static  void m5533a(int[] iArr, java.lang.String[] strArr, Context context, Context context2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("questionId", iArr);
            jSONObject.put("answer", strArr);
            new API_PROVIDER(context, "update_password_faqs", new UserVM()).put("e6/auth/faq", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        char c2;
        MergeRequests getValue;
        if (str == null || str.length() <= 0) {
            return;
        }
        boolean z = true;
        switch (str2.hashCode()) {
            case -2131596369:
                if (str2.equals("change_cid")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case -1939337685:
                if (str2.equals("check_user_info")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1405959847:
                if (str2.equals("avatar")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case -1389878297:
                if (str2.equals("register_user")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1022649739:
                if (str2.equals("get_market_connection_info")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case -1003047349:
                if (str2.equals("update_password_faqs")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case -665674095:
                if (str2.equals("accept_merge_request")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -23090617:
                if (str2.equals("get_formatted_password")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 509052241:
                if (str2.equals("update_password")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 673363834:
                if (str2.equals("get_order_history")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 709809757:
                if (str2.equals("get_user_names")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 813857934:
                if (str2.equals("check_vendor_info")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 854181078:
                if (str2.equals("get_user_name")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1103412086:
                if (str2.equals("request_merge_account")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1443916523:
                if (str2.equals("get_registered_faq_info")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 1561503875:
                if (str2.equals("cancel_merge_request")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1634317300:
                if (str2.equals("get_merge_requests")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1698599962:
                if (str2.equals("change_profile")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                try {
                    Account account = (Account) new Gson().fromJson(str, new TypeToken<Account>(){}.getType());
                    if (account.token != null) {
                        stringMutableLiveData2.setValue(account.token);
                    }
                    User user = account.user;
                    if (user != null) {
                        userMutableLiveData.setValue( user);
                        stringMutableLiveData1.setValue(account.user.name);
                    } else {
                        userMutableLiveData.setValue( null);
                    }
                    f10342s.setValue( Integer.valueOf(i));
                } catch (Exception e2) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e2);
                }
                f10347x = false;
                break;
            case 2:
                try {
                    f10348y.setValue( new Gson().fromJson(new JSONObject(str).getString("newId"), new TypeToken<Integer>(){}.getType()));
                    MutableLiveData<Boolean> mutableLiveData = booleanMutableLiveData;
                    if (i != 200) {
                        z = false;
                    }
                    mutableLiveData.setValue( Boolean.valueOf(z));
                    break;
                } catch (Exception e3) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e3);
                    return;
                }
            case 3:
                f10342s.setValue( Integer.valueOf(i));
                if (i == 200) {
                    stringMutableLiveData1.setValue(str);
                    break;
                }
                break;
            case 4:
                m5532a(str, str2, i, false);
                break;
            case 5:
                try {
                    integerMutableLiveData.setValue( Integer.valueOf(i));
                    break;
                } catch (Exception e4) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e4);
                    return;
                }
            case 6:
                f10342s.setValue( Integer.valueOf(i));
                try {
                    VendorUser vendorUser = (VendorUser) new Gson().fromJson(str, new TypeToken<VendorUser>(){}.getType());
                    if (vendorUser.token != null && !vendorUser.token.isEmpty()) {
                        stringMutableLiveData3.setValue(vendorUser.token);
                        vendorUserMutableLiveData.setValue( vendorUser);
                        break;
                    }
                } catch (Exception e5) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e5);
                    return;
                }
                break;
            case 7:
                MergeRequests getValue2 = mergeRequestsMutableLiveData.getValue();
                if (getValue2 != null) {
                    try {
                        accountMerge.f12402id = ((Integer) new Gson().fromJson(new JSONObject(str).getString("id"), new TypeToken<Integer>(){}.getType())).intValue();
                        if (accountMerge.targetChannel.equals("desktop")) {
                            getValue2.desktop = accountMerge;
                        } else {
                            getValue2.mobile = accountMerge;
                        }
                        mergeRequestsMutableLiveData.setValue( getValue2);
                        break;
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                break;
            case '\b':
                try {
                    mergeRequestsMutableLiveData.setValue( new Gson().fromJson(str, new TypeToken<MergeRequests>(){}.getType()));
                    break;
                } catch (Exception e7) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e7);
                    return;
                }
            case '\t':
                MergeRequests getValue3 = mergeRequestsMutableLiveData.getValue();
                if (getValue3 != null && i == 200) {
                    getValue3.received = null;
                    mergeRequestsMutableLiveData.setValue( getValue3);
                    break;
                }
                break;
            case '\n':
                if (i == 200 && (getValue = mergeRequestsMutableLiveData.getValue()) != null) {
                    MergeRequests.AccountMerge accountMerge = getValue.received;
                    if (accountMerge == null || accountMerge.f12402id != f10337n) {
                        MergeRequests.AccountMerge accountMerge2 = getValue.mobile;
                        if (accountMerge2 == null || accountMerge2.f12402id != f10337n) {
                            getValue.desktop = null;
                        } else {
                            getValue.mobile = null;
                        }
                    } else {
                        getValue.received = null;
                    }
                    f10337n = -1;
                    mergeRequestsMutableLiveData.setValue( getValue);
                    break;
                }
                break;
            case 11:
                try {
                    List<java.lang.String> list = (List) new Gson().fromJson(str, new TypeToken<List<String>>(){}.getType());
                    if (list != null && list.size() != 0) {
                        f10341r.setValue( list);
                    }
                    f10342s.setValue( Integer.valueOf(i));
                    break;
                } catch (Exception e8) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e8);
                    return;
                }
            case '\f':
                try {
                    f10343t.setValue( new Gson().fromJson(str, new TypeToken<List<PasswordFaq>>(){}.getType()));
                    break;
                } catch (Exception e9) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e9);
                    return;
                }
            case '\r':
                try {
                    f10344u.setValue(str);
                    f10342s.setValue( Integer.valueOf(i));
                    break;
                } catch (Exception e10) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e10);
                    return;
                }
            case 14:
                try {
                    marketConnection.setValue( new Gson().fromJson(str, new TypeToken<MarketConnection>(){}.getType()));
                    break;
                } catch (Exception e11) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e11);
                    return;
                }
            case 15:
            case 16:
            case 17:
                f10342s.setValue( Integer.valueOf(i));
                break;
        }
    }
}
