package com.jeil.emarket.receives;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.custom.ResManager;


public class MainWidgetReceive extends AppWidgetProvider {
    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        for (int i : iArr) {
            PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, MainActivityForVendor.class), 0);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), ResManager.find(context, R.layout.layout_app_widget_main));
            remoteViews.setOnClickPendingIntent(ResManager.find(context, R.id.iv_main), activity);
            appWidgetManager.updateAppWidget(i, remoteViews);
        }
    }
}
