package com.jeil.emarket.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;

import com.jeil.emarket.activities.auth.LoginActivity;
import com.jeil.emarket.activities.intro.SplashBaseActivity;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.model.customer.API;
import com.jeil.emarket.viewmodel.UserVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.SSLSession;

/* renamed from: b.f.a.i.p */

public class API_PROVIDER {

    /* renamed from: h */
    public static List<API> f10135h = new ArrayList();

    
    public static List<InterfaceContext> f10136i = new ArrayList();

   
    public static ImageDialog2 f10137j;

    
    public static ImageDialog2 f10138k;


    public final java.lang.String f10139a;


    public final BaseInterface f10140b;


    public Context f10141c;

    
    public java.lang.String f10142d;

    
    public java.lang.String f10143e = "";

    /* renamed from: f */
    public JSONObject f10144f = new JSONObject();

    /* renamed from: g */
    public int f10145g;

    public API_PROVIDER(Context context, java.lang.String str, BaseInterface baseInterface) {
        this.f10141c = context;
        this.f10139a = str;
        this.f10140b = baseInterface;
    }


    public static  void m5402a(Context context, View view) {
        f10138k.dismiss();
        if (context instanceof SplashBaseActivity) {
            ((SplashBaseActivity) context).finish();
        }
        f10136i = new ArrayList();
    }


    public static boolean checkInternet(Context context, InterfaceContext interfaceContext) {
        return checkInternet(context, interfaceContext, false);
    }


    public static boolean checkInternet(final Context context, final InterfaceContext interfaceContext, boolean z) {
        if (context != null) {
            try {
                for (NetworkInfo networkInfo : ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getAllNetworkInfo()) {
                    if (networkInfo.isConnected()) {
                        if (interfaceContext == null) {
                            return true;
                        }
                        interfaceContext.mo4271a(context);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (z || context == null) {
            return false;
        }
        View inflate = View.inflate(context, R.layout.dialog_error, null);
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_disconnect_label);
        f10138k = Util.m211a((Activity) context, inflate);
        f10138k.setCanceledOnTouchOutside(false);
        textView.setText(context.getResources().getString(R.string.internet_connect_confirm));
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.i.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                API_PROVIDER.m5402a(context, view);
            }
        });
        new Handler().post(new Runnable() { // from class: b.f.a.i.g
            @Override // java.lang.Runnable
            public final void run() {
               // API_PROVIDER.f10136i.add(InterfaceContext.this);
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.i.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                API_PROVIDER.m5405b(context, view);
            }
        });
        return false;
    }


    public static  void m5405b(Context context, View view) {
        f10138k.dismiss();
        Iterator<InterfaceContext> it = f10136i.iterator();
        while (it.hasNext()) {
            checkInternet(context, it.next());
        }
        f10136i = new ArrayList();
    }


    public void m5406a(java.lang.String str) {
        get(str, new JSONObject());
    }


    public void delete(java.lang.String str, JSONObject jSONObject) {
        this.f10142d = "DELETE";
        if (str.startsWith("e")) {
            str = CustomString.append("https://10.99.8.2:8080/", str);
        }
        this.f10143e = str;
        this.f10144f = jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("URL", this.f10143e);
            jSONObject2.put("PARAM", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new b().execute(jSONObject2);
    }


    public void get(java.lang.String str, JSONObject jSONObject) {
        this.f10142d = "GET";
        if (str.startsWith("e")) {
            str = CustomString.append("https://10.99.8.2:8080/", str);
        }
        this.f10143e = str;
        this.f10144f = jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("URL", this.f10143e);
            jSONObject2.put("PARAM", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new b().execute(jSONObject2);
    }


    public void post(java.lang.String str, JSONObject jSONObject) {
        this.f10142d = "POST";
        if (str.startsWith("e")) {
            str = CustomString.append("https://10.99.8.2:8080/", str);
        }
        this.f10143e = str;
        this.f10144f = jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("URL", this.f10143e);
            jSONObject2.put("PARAM", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new b().execute(jSONObject2);
    }

    
    public void put(java.lang.String str, JSONObject jSONObject) {
        this.f10142d = "PUT";
        if (str.startsWith("e")) {
            str = CustomString.append("https://10.99.8.2:8080/", str);
        }
        this.f10143e = str;
        this.f10144f = jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("URL", this.f10143e);
            jSONObject2.put("PARAM", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new b().execute(jSONObject2);
    }

    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: b.f.a.i.p$b */
    public class b extends AsyncTask<JSONObject, java.lang.String, java.lang.String> {
        public  b() {
        }


        public  boolean m5411a(java.lang.String str, SSLSession sSLSession) {
            return true;
        }


        public  void m5412a() {
            View inflate = View.inflate(API_PROVIDER.this.f10141c, R.layout.dialog_error, null);
            CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
            CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
            API_PROVIDER.f10137j = Util.m211a((Activity) API_PROVIDER.this.f10141c, inflate);
            API_PROVIDER.f10137j.setCanceledOnTouchOutside(false);
            API api = new API();
            API_PROVIDER APIS = API_PROVIDER.this;
            api.method = APIS.f10142d;
            api.url = APIS.f10143e;
            api.param = APIS.f10144f;
            API_PROVIDER.f10135h.add(api);
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.i.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    API_PROVIDER.b.this.m5413a(view);
                }
            });
            customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.i.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    API_PROVIDER.b.this.m5414b(view);
                }
            });
        }


        public  void m5414b(View view) {
            API_PROVIDER.f10137j.dismiss();
            for (API api : API_PROVIDER.f10135h) {
                if (api.method.equals("GET")) {
                    API_PROVIDER.this.get(api.url, api.param);
                } else if (API_PROVIDER.this.f10142d.equals("POST")) {
                    API_PROVIDER.this.post(api.url, api.param);
                } else if (API_PROVIDER.this.f10142d.equals("PUT")) {
                    API_PROVIDER.this.put(api.url, api.param);
                } else {
                    API_PROVIDER.this.delete(api.url, api.param);
                }
            }
            API_PROVIDER.f10135h = new ArrayList();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(13:22|23|(3:24|25|(1:27))|(3:29|30|(1:32))|(4:35|(1:39)|40|(1:44))|45|46|(4:51|52|53|54)|69|(9:71|(2:75|76)|77|78|79|80|81|82|(2:126|127))(1:143)|84|85|(1:87)) */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x025c, code lost:
        
            r14 = e;
         */
        /* JADX WARN: Removed duplicated region for block: B:108:0x02c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x02d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:164:0x031f  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x0037 A[EXC_TOP_SPLITTER, LOOP:0: B:203:0x0037->B:214:0x008a, LOOP_START, PHI: r3
  0x0037: PHI (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:10:0x0035, B:214:0x008a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0076 A[Catch: Exception -> 0x008d, TryCatch #13 {Exception -> 0x008d, blocks: (B:204:0x0037, B:206:0x003d, B:209:0x005a, B:210:0x0070, B:212:0x0076, B:213:0x007b, B:215:0x0052, B:217:0x0063), top: B:203:0x0037 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x012e A[Catch: Exception -> 0x0138, TRY_LEAVE, TryCatch #6 {Exception -> 0x0138, blocks: (B:30:0x0125, B:32:0x012e), top: B:29:0x0125 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01da A[Catch: IOException -> 0x025c, TryCatch #27 {IOException -> 0x025c, blocks: (B:46:0x019f, B:48:0x01a9, B:51:0x01b1, B:54:0x01c2, B:63:0x01d3, B:68:0x01d0, B:69:0x01d4, B:71:0x01da, B:73:0x01ed, B:75:0x01f3, B:53:0x01b5, B:58:0x01c7, B:65:0x01cb), top: B:45:0x019f, inners: #16, #18, #23 }] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x02cc  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String doInBackground(org.json.JSONObject[] r14) {
            /*
                Method dump skipped, instructions count: 892
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p254i.C2729p.b.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.String str) {
            java.lang.String str2 = str;
            super.onPostExecute(str2);
            try {
                if (str2.startsWith("{") && !API_PROVIDER.this.f10139a.equals("get_user_name")) {
                    JSONObject jSONObject = new JSONObject(str2);
                    int i = jSONObject.has("time") ? jSONObject.getInt("time") : 0;
                    if (jSONObject.has("message") && !jSONObject.getString("message").isEmpty() && !jSONObject.getString("message").equals("null")) {
                        if (API_PROVIDER.this.f10145g == 200) {
                            Util.toast(API_PROVIDER.this.f10141c, jSONObject.getString("message"), "default", 0, i);
                        } else {
                            if (API_PROVIDER.this.f10145g == 401) {
                                UserVM.m5540c();
                                Intent intent = new Intent(API_PROVIDER.this.f10141c.getApplicationContext(), LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                API_PROVIDER.this.f10141c.startActivity(intent);
                            }
                            Util.toast(API_PROVIDER.this.f10141c, jSONObject.getString("message"), "error", 0, i);
                        }
                    }
                    if (jSONObject.has("err_message") && !jSONObject.getString("err_message").isEmpty()) {
                        Util.toast(API_PROVIDER.this.f10141c, jSONObject.getString("err_message"), "error", 0, i);
                    }
                    if (API_PROVIDER.this.f10139a.equals("check_user_info")) {
                        if (API_PROVIDER.this.f10145g == 200) {
                            Util.m309b(API_PROVIDER.this.f10141c, R.string.login_success, i);
                        } else if (API_PROVIDER.this.f10145g == 400) {
                            Context context = API_PROVIDER.this.f10141c;
                            Util.toast(context, context.getString(R.string.require_register), "error", 0, i);
                        }
                    }
                    if (API_PROVIDER.this.f10139a.equals("create_order") && API_PROVIDER.this.f10145g == 200 && (!jSONObject.has("message") || jSONObject.getString("message").isEmpty() || jSONObject.getString("message").equals("null"))) {
                        Util.m309b(API_PROVIDER.this.f10141c, R.string.order_success_message, i);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            BaseInterface baseInterface = API_PROVIDER.this.f10140b;
            if (baseInterface != null) {
                if (str2 != null && !str2.isEmpty()) {
                    API_PROVIDER APIS = API_PROVIDER.this;
                    baseInterface.mo4478a(str2, APIS.f10139a, APIS.f10145g, APIS.f10141c);
                    return;
                }
                ImageDialog2 imageDialog2 = API_PROVIDER.f10137j;
                if (imageDialog2 == null || !imageDialog2.isShowing()) {
                    Util.toast(API_PROVIDER.this.f10141c, R.string.server_failed, "error");
                }
            }
        }


        public  void m5413a(View view) {
            API_PROVIDER.f10137j.dismiss();
            Context context = API_PROVIDER.this.f10141c;
            if (context instanceof SplashBaseActivity) {
                ((SplashBaseActivity) context).finish();
            }
            API_PROVIDER.f10135h = new ArrayList();
        }
    }
}
