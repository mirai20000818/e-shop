package com.jeil.emarket.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.widget.RemoteViews;

import com.jeil.emarket.custom.ResManager;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.activities.ticket.list.TicketUserListActivity;
import com.jeil.emarket.model.customer.TicketMessage;

import org.json.JSONObject;
import androidx.core.app.NotificationCompat;

import com.jeil.emarket.custom.Status;
import com.jeil.emarket.interf.InterfaceTicketMessage;
import com.jeil.emarket.api.API_TICKET;
import com.jeil.emarket.viewmodel.UserVM;


public class MessageService extends Service {

    /* renamed from: g */
    public static boolean f12471g = false;

    /* renamed from: h */
    public static MessageService f12472h;

    
    public static Context f12473i;

    
    public API_TICKET f12475c;

    
    public API_TICKET f12476d;


    public final Handler f12474b = new Handler(Looper.getMainLooper());

    
    public int f12477e = 126;

    /* renamed from: f */
    public NotificationManager notificationManager = null;


    public void m7008a() {
        if (Status.f8832w.booleanValue() && this.f12475c == null) {
            this.f12475c = new API_TICKET(UserVM.stringMutableLiveData2.getValue(), "app", f12473i, new InterfaceTicketMessage() { // from class: b.f.a.j.d
                @Override // p078b.p159f.p160a.p253h.InterfaceC2712f

                public final void mo5398a(TicketMessage ticketMessage) {
                    MessageService.this.m7009a(ticketMessage);
                }
            });
        }
    }


    public  void m7009a(TicketMessage ticketMessage) {
        m7010a(ticketMessage, "customer");
    }


    public void m7010a(final TicketMessage ticketMessage, String str) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), ResManager.find(f12473i, R.layout.layout_push_notification));
        remoteViews.setViewVisibility(ResManager.find(f12473i, R.id.tv_order_content), View.GONE);
        remoteViews.setViewVisibility(ResManager.find(f12473i, R.id.tv_refund_content), View.GONE);
        remoteViews.setViewVisibility(ResManager.find(f12473i, R.id.tv_message_content), View.GONE);
        remoteViews.setTextViewText(ResManager.find(f12473i, R.id.tv_message_content), getResources().getString(R.string.receiver_new_ticket_message));
        this.f12474b.post(new Runnable() { // from class: b.f.a.j.c
            @Override // java.lang.Runnable
            public final void run() {

                //C2792j3.f10271e.setValue(TicketMessage.this);
            }
        });
        Intent intent = str.equals("customer") ? new Intent(this, TicketUserListActivity.class) : new Intent(this, MainActivityForVendor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon( ResManager.find(f12473i, R.drawable.logo) );
        builder.setContentTitle(getResources().getString(R.string.app_name));
        builder.setContentIntent( PendingIntent.getActivity(this, 0, intent, 0) );
        builder.setContent( remoteViews);
        builder.setChannelId(getString(R.string.notification_channel));

        Notification m1045a = builder.build();
        this.notificationManager.cancel(Status.f8806A);
        this.notificationManager.notify(Status.f8806A, m1045a);
    }


    public void m7011a(String str, JSONObject jSONObject) {
        API_TICKET APITICKET;
        if (!Status.f8832w.booleanValue() || (APITICKET = this.f12475c) == null) {
            return;
        }
        APITICKET.m5423a(str, jSONObject);
    }


    public void m7012b(String str, JSONObject jSONObject) {
        API_TICKET APITICKET;
        if (!Status.f8832w.booleanValue() || (APITICKET = this.f12476d) == null) {
            return;
        }
        APITICKET.m5423a(str, jSONObject);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        f12472h = this;
        f12471g = true;
        this.notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.createNotificationChannel(new NotificationChannel(getString(R.string.notification_channel), getString(R.string.notification_manage), NotificationManager.IMPORTANCE_DEFAULT));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        API_TICKET APITICKET;
        f12471g = false;
        f12472h = null;
        this.notificationManager.cancel(this.f12477e);
      //  if (Status.f8832w.booleanValue() && (APITICKET = this.f12475c) != null && APITICKET.f10148a.m5867c()) {
       //     APITICKET.f10148a.m5861a();
        //}
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        m7008a();
        return Service.START_STICKY;
    }
}
