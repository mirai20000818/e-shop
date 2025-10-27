package com.jeil.emarket;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.jeil.emarket.api.CacheManager;
import com.jeil.emarket.custom.Util;


public class MainBaseApplication extends Application {
    @Override // p078b.p159f.p259b.ApplicationC2903c, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
      //  MultiDex.install(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        try {
            String m344e = Util.m344e(this);
            if (m344e != null && !m344e.isEmpty() && !m344e.equals("null")) {
                //return ResManager.m5741a(super.getResources(), C2909i.m5690a(this).m5694d(m344e));
            }
            return super.getResources();
        } catch (Exception unused) {
            return super.getResources();
        }
    }

    @Override // p078b.p159f.p259b.ApplicationC2903c, android.app.Application
    public void onCreate() {
        super.onCreate();
        String string = getSharedPreferences("com.jeil.emarket", 0).getString("1.1.0", "1.0.0");
        if (string != null) {
            String[] split = string.split("[.]");
            String[] split2 = "1.1.0".split("[.]");
            if (split.length == 3 && split2.length == 3 && (!split[0].equals(split2[0]) || !split[1].equals(split2[1]))) {
                Util.m330c(this, "");
            }
        }
        new CacheManager(this);
    }
}
