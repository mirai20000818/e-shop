package com.jeil.emarket.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.vendor.OrderHistory;

import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.HistoryVM;
import com.jeil.emarket.viewmodel.UserVM;


public class BackgroundService extends Service implements BaseInterface {

    /* renamed from: m */
    public static boolean f12457m = false;

    /* renamed from: n */
    public static BackgroundService f12458n;

    /* renamed from: o */
    public static Context f12459o;

    
    public final Handler f12460b = new Handler(Looper.getMainLooper());

    
    public int f12461c = 125;

    
    public NotificationManager f12462d = null;

    
    public Runnable f12463e = null;

    /* renamed from: f */
    public int f12464f = 0;

    /* renamed from: g */
    public int f12465g = 0;

    /* renamed from: h */
    public int f12466h = 0;

    
    public int f12467i = 0;

   
    public int f12468j = 0;

    
    public int f12469k = 0;

    /* renamed from: l */
    public int f12470l = 0;

    /* renamed from: com.jeil.emarket.services.BackgroundService$a */
    public class C3269a extends TypeToken<OrderHistory> {
        public C3269a(BackgroundService backgroundService) {
        }
    }


    public static  void m7004a(Context context) {
        try {
            new API_PROVIDER(f12459o, "get_order_history", f12458n).m5406a("e7/orders/stats");
        } catch (Exception e2) {
            e2.getMessage();
        }
    }


    public void m7005a() {
        if (f12459o == null || UserVM.vendorUserMutableLiveData.getValue() == null || UserVM.vendorUserMutableLiveData.getValue() == null || UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorProductManager") || UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorAdManager")) {
            return;
        }
        API_PROVIDER.checkInternet(f12459o, new InterfaceContext() { // from class: b.f.a.j.a
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context) {
                BackgroundService.m7004a(context);
            }
        }, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[Catch: Exception -> 0x028e, TryCatch #0 {Exception -> 0x028e, blocks: (B:7:0x0010, B:10:0x0033, B:12:0x003f, B:14:0x0045, B:16:0x0049, B:20:0x005f, B:22:0x0065, B:23:0x0093, B:25:0x009c, B:28:0x00ad, B:30:0x00da, B:32:0x00de, B:34:0x00ec, B:36:0x00f0, B:38:0x00f4, B:40:0x0107, B:42:0x010d, B:43:0x013b, B:45:0x0144, B:48:0x0153, B:49:0x0184, B:51:0x0188, B:53:0x018c, B:54:0x018f, B:56:0x01bb, B:58:0x01c1, B:60:0x01c7, B:64:0x01cd, B:66:0x01e8, B:67:0x01fe, B:69:0x0207, B:70:0x021d, B:72:0x0226, B:73:0x023c, B:76:0x022e, B:77:0x020f, B:78:0x01f0, B:82:0x00f8, B:85:0x0050), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[Catch: Exception -> 0x028e, TryCatch #0 {Exception -> 0x028e, blocks: (B:7:0x0010, B:10:0x0033, B:12:0x003f, B:14:0x0045, B:16:0x0049, B:20:0x005f, B:22:0x0065, B:23:0x0093, B:25:0x009c, B:28:0x00ad, B:30:0x00da, B:32:0x00de, B:34:0x00ec, B:36:0x00f0, B:38:0x00f4, B:40:0x0107, B:42:0x010d, B:43:0x013b, B:45:0x0144, B:48:0x0153, B:49:0x0184, B:51:0x0188, B:53:0x018c, B:54:0x018f, B:56:0x01bb, B:58:0x01c1, B:60:0x01c7, B:64:0x01cd, B:66:0x01e8, B:67:0x01fe, B:69:0x0207, B:70:0x021d, B:72:0x0226, B:73:0x023c, B:76:0x022e, B:77:0x020f, B:78:0x01f0, B:82:0x00f8, B:85:0x0050), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00de A[Catch: Exception -> 0x028e, TryCatch #0 {Exception -> 0x028e, blocks: (B:7:0x0010, B:10:0x0033, B:12:0x003f, B:14:0x0045, B:16:0x0049, B:20:0x005f, B:22:0x0065, B:23:0x0093, B:25:0x009c, B:28:0x00ad, B:30:0x00da, B:32:0x00de, B:34:0x00ec, B:36:0x00f0, B:38:0x00f4, B:40:0x0107, B:42:0x010d, B:43:0x013b, B:45:0x0144, B:48:0x0153, B:49:0x0184, B:51:0x0188, B:53:0x018c, B:54:0x018f, B:56:0x01bb, B:58:0x01c1, B:60:0x01c7, B:64:0x01cd, B:66:0x01e8, B:67:0x01fe, B:69:0x0207, B:70:0x021d, B:72:0x0226, B:73:0x023c, B:76:0x022e, B:77:0x020f, B:78:0x01f0, B:82:0x00f8, B:85:0x0050), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0188 A[Catch: Exception -> 0x028e, TryCatch #0 {Exception -> 0x028e, blocks: (B:7:0x0010, B:10:0x0033, B:12:0x003f, B:14:0x0045, B:16:0x0049, B:20:0x005f, B:22:0x0065, B:23:0x0093, B:25:0x009c, B:28:0x00ad, B:30:0x00da, B:32:0x00de, B:34:0x00ec, B:36:0x00f0, B:38:0x00f4, B:40:0x0107, B:42:0x010d, B:43:0x013b, B:45:0x0144, B:48:0x0153, B:49:0x0184, B:51:0x0188, B:53:0x018c, B:54:0x018f, B:56:0x01bb, B:58:0x01c1, B:60:0x01c7, B:64:0x01cd, B:66:0x01e8, B:67:0x01fe, B:69:0x0207, B:70:0x021d, B:72:0x0226, B:73:0x023c, B:76:0x022e, B:77:0x020f, B:78:0x01f0, B:82:0x00f8, B:85:0x0050), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bb A[Catch: Exception -> 0x028e, TryCatch #0 {Exception -> 0x028e, blocks: (B:7:0x0010, B:10:0x0033, B:12:0x003f, B:14:0x0045, B:16:0x0049, B:20:0x005f, B:22:0x0065, B:23:0x0093, B:25:0x009c, B:28:0x00ad, B:30:0x00da, B:32:0x00de, B:34:0x00ec, B:36:0x00f0, B:38:0x00f4, B:40:0x0107, B:42:0x010d, B:43:0x013b, B:45:0x0144, B:48:0x0153, B:49:0x0184, B:51:0x0188, B:53:0x018c, B:54:0x018f, B:56:0x01bb, B:58:0x01c1, B:60:0x01c7, B:64:0x01cd, B:66:0x01e8, B:67:0x01fe, B:69:0x0207, B:70:0x021d, B:72:0x0226, B:73:0x023c, B:76:0x022e, B:77:0x020f, B:78:0x01f0, B:82:0x00f8, B:85:0x0050), top: B:6:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0092  */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo4478a(java.lang.String r10, java.lang.String r11, int r12, android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.services.BackgroundService.mo4478a(java.lang.String, java.lang.String, int, android.content.Context):void");
    }

    
    public  void m7006b() {
        this.f12460b.postDelayed(this.f12463e, 600000L);
        m7005a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        f12458n = this;
        f12457m = true;
        this.f12462d = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f12462d.createNotificationChannel(new NotificationChannel(getString(R.string.notification_channel), getString(R.string.notification_manage), NotificationManager.IMPORTANCE_DEFAULT));
        }
        this.f12463e = new Runnable() { // from class: b.f.a.j.b
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundService.this.m7006b();
            }
        };
    }

    @Override // android.app.Service
    public void onDestroy() {
        f12457m = false;
        f12458n = null;
        this.f12462d.cancel(this.f12461c);
        this.f12460b.removeCallbacks(this.f12463e);
        HistoryVM.f10270d.setValue( new OrderHistory());
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        HistoryVM.f10270d.setValue( new OrderHistory());
        this.f12460b.post(this.f12463e);
        return Service.START_STICKY;
    }
}
