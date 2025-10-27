package com.jeil.emarket.activities.intro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Window;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Home;
import com.jeil.emarket.model.customer.MarketConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.base.DialogBaseAni;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.dialog.DialogSplashInstall;
import com.jeil.emarket.dialog.DialogDownload;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.api.CERT_PROVIDER;
import com.jeil.emarket.viewmodel.DayProductVM;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.ProductVendorVM;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.viewmodel.BottomVM;


public class SplashBaseActivity extends BaseActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    
    public int refreshCount = 9;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1

    public void SetDescription() {
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(-1));
        window.setNavigationBarColor(-1);
        window.setStatusBarColor(-1);
    }

    
    public final void bottomInit() {
        BottomVM.m5607b((Context) this, true);
        BottomVM.m5611c((Context) this, false);
        BottomVM.m5614d((Context) this, false);
        BottomVM.m5603a((Context) this, false);
        CategoryVM.m5582a((Context) this, false);
        CartProductVM.m5573c();
        ProductVendorVM.m5579c();
        TicketCategoryListVM.m5505b(this);
        DayProductVM.m5489c();
        DayProductVM.m5490d();
        UserVM.connect(this);
        BottomVM.homeMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.d.a0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.versionCheck((Home) obj);
            }
        });
        CategoryVM.listMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.d.s
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.m6480b((List) obj);
            }
        });
        BottomVM.f10420e.observe(this, new Observer() { // from class: b.f.a.a.d.r
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.m6483c((List) obj);
            }
        });
        BottomVM.f10421f.observe(this, new Observer() { // from class: b.f.a.a.d.q
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.m6484d((List) obj);
            }
        });
        BottomVM.f10422g.observe(this, new Observer() { // from class: b.f.a.a.d.t
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.m6485e((List) obj);
            }
        });
        BottomVM.newsletterListLiveData.observe(this, new Observer() { // from class: b.f.a.a.d.u
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.updateNewsLetter((List) obj);
            }
        });
        CartProductVM.f10375d.observe(this, new Observer() { // from class: b.f.a.a.d.z
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.m6487g((List) obj);
            }
        });
        UserVM.marketConnection.observe(this, new Observer() { // from class: b.f.a.a.d.y
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                SplashBaseActivity.this.m6478a((MarketConnection) obj);
            }
        });
    }

   
    public void refresh() {
        java.lang.String str;
        this.refreshCount--;
        java.lang.String str2 = this.refreshCount + "";
        if (this.refreshCount == 1 && (str = this.string2) != null && !str.isEmpty() && !this.string2.equals("null")) {
            API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.a.d.w
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context) {
                    SplashBaseActivity.this.m6481c(context);
                }
            });
        }
        if (this.refreshCount == 0) {
            startActivity((UserVM.sharedPreferences.getBoolean("alreadySetup", true)
                    && UserVM.sharedPreferences.getBoolean("setup", false)) ?
                    new Intent(getApplicationContext(),  MainActivity.class) :
                    new Intent(getApplicationContext(), SetupActivity.class));
            finish();
        }
    }


    public  void versionCheck(Home home) {
        DialogBaseAni dialogC2204i3;
        Home.Apk apk = home.apk;
        if (apk != null) {
            if (!apk.version.equals("1.1.0")) {
                char c2 = 65534;
                try {
                    java.lang.String[] split = home.apk.version.split("[.]");
                    java.lang.String[] split2 = "1.1.0".split("[.]");
                    if (split.length == 3 && split2.length == 3) {
                        int i = 0;
                        while (true) {
                            if (i >= 2) {
                                c2 = 0;
                                break;
                            } else if (Integer.parseInt(split[i]) > Integer.parseInt(split2[i])) {
                                c2 = 1;
                                break;
                            } else {
                                if (Integer.parseInt(split[i]) < Integer.parseInt(split2[i])) {
                                    c2 = 65535;
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                if (c2 >= 0) {
                    if (c2 > 0) {
                        Home.Apk apk2 = home.apk;
                        int i2 = apk2.size;
                        java.lang.String str = apk2.file;
                        StringBuilder m3177b = CustomString.m3177b("http://10.99.8.2/", "e4/uploads/apks/");
                        m3177b.append(home.apk.file);
                        java.lang.String sb = m3177b.toString();
                        Home.Apk apk3 = home.apk;
                        dialogC2204i3 = new DialogSplashInstall(this, i2, str, sb, apk3.isDownload, apk3.message);
                    } else {
                        Home.Apk apk4 = home.apk;
                        java.lang.String str2 = apk4.version;
                        int i3 = apk4.size;
                        StringBuilder m3177b2 = CustomString.m3177b("http://10.99.8.2/", "e4/uploads/apks/");
                        m3177b2.append(home.apk.file);
                        dialogC2204i3 = new DialogDownload(this, str2, i3, m3177b2.toString());
                        ((Window) Objects.requireNonNull(dialogC2204i3.getWindow())).setDimAmount(0.0f);
                        dialogC2204i3.f8254e = 0.8f;
                    }
                    dialogC2204i3.show();
                } else if (c2 != 65535) {
                    Util.toast(this, getString(R.string.version_info_incorrect), "default", 0, 0);
                }
                SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
                edit.putString("1.1.0", home.apk.version);
                edit.apply();
            }
            refresh();
            UserVM.login(this);
            SharedPreferences.Editor edit2 = UserVM.sharedPreferences.edit();
            edit2.putString("1.1.0", home.apk.version);
            edit2.apply();
        }
    }


    public  void m6478a(MarketConnection marketConnection) {
        refresh();
    }


    public  void AfterCheckInternet(Context context) {
        java.lang.String str = this.string2;
        if (str == null || str.isEmpty() || this.string2.equals("null")) {
            UserVM.m5531a((BaseActivity) this, true);
        } else {
            this.refreshCount++;
            bottomInit();
        }
    }


    public  void m6480b(List list) {
        refresh();
    }


    public  void m6481c(Context context) {
        UserVM.m5531a((BaseActivity) this, true);
    }


    public  void m6482c(Intent intent) {
        CERT_PROVIDER.m5415a(this, intent);
        java.lang.String str = this.string2;
        if (str == null || str.isEmpty() || this.string2.equals("null")) {
            bottomInit();
        } else {
            refresh();
        }
    }


    public  void m6483c(List list) {
        refresh();
    }


    public  void m6484d(List list) {
        refresh();
    }

    
    public  void m6485e(List list) {
        refresh();
    }

    /* renamed from: f */
    public  void updateNewsLetter(List list) {
        refresh();
    }

    /* renamed from: g */
    public  void m6487g(List list) {
        refresh();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, final Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || 123 != i) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.d.x
            @Override // java.lang.Runnable
            public final void run() {
                SplashBaseActivity.this.m6482c(intent);
            }
        }, Status.time);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = false;
        UserVM.sharedPreferences = getSharedPreferences("com.jeil.emarket", 0);
        setColorTheme();
        SetDescription();
        this.f6502v = false;
        setContentView(R.layout.activity_splash);
        BaseActivity.anInt2 = getResources().getDimensionPixelSize(R.dimen.main_space);
        setScreenSize();
        SharedPreferences sharedPreferences = UserVM.sharedPreferences;
        if (sharedPreferences != null && !sharedPreferences.getBoolean("screen", true)) {
            z = true;
        }
        SimpleVM.f8836d = z;
        BaseActivity.string = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getResources().getString(R.string.app_folder_name);
        BaseActivity.string1 = getCacheDir().getAbsolutePath();
        API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.a.d.v
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context) {
                SplashBaseActivity.this.AfterCheckInternet(context);
            }
        });
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED ) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED ) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (checkSelfPermission("android.permission.USE_FINGERPRINT") != PackageManager.PERMISSION_GRANTED ) {
                arrayList.add("android.permission.USE_FINGERPRINT");
            }
            if (checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") != PackageManager.PERMISSION_GRANTED ) {
                arrayList.add("android.permission.ACCESS_NETWORK_STATE");
            }
            if (checkSelfPermission("android.permission.REQUEST_INSTALL_PACKAGES") != PackageManager.PERMISSION_GRANTED ) {
                arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
            }
            if (arrayList.size() > 0) {
                ActivityCompat.requestPermissions(this, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]), 100);
                return;
            }
        }
        refresh();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity, p000a.p030h.p031a.C0206a.c
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            if (iArr.length > 0 && iArr[0] == 0) {
                SimpleVM.f8837e = true;
            }
            refresh();
        }
    }
}
