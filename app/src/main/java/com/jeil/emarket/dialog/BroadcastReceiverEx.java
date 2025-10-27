package com.jeil.emarket.dialog;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.textview.TextView;
import java.io.File;
import com.jeil.emarket.activities.baseactivity.BaseActivity;

/* renamed from: b.f.a.f.g3 */

public class BroadcastReceiverEx extends BroadcastReceiver {


    public final  String f8953a;


    public final  DialogSplashInstall f8954b;

    public BroadcastReceiverEx(DialogSplashInstall dialogSplashInstall, String str) {
        this.f8954b = dialogSplashInstall;
        this.f8953a = str;
    }


    public  void m4824a(String str, View view) {
        this.f8954b.m4827a(new File(BaseActivity.string + "/" + str));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        DialogSplashInstall dialogSplashInstall = this.f8954b;
        if (dialogSplashInstall.f8965Y == longExtra && ((DownloadManager) dialogSplashInstall.f8961U.getSystemService(Context.DOWNLOAD_SERVICE)).getUriForDownloadedFile(this.f8954b.f8965Y) != null) {
            ((TextView) this.f8954b.f8960T.findViewById(R.id.tv_version)).setText(R.string.download_complete);
            this.f8954b.f8960T.findViewById(R.id.ll_progress).setVisibility(View.GONE);
            this.f8954b.findViewById(R.id.ll_action).setVisibility(View.VISIBLE);
            CustomButton customButton = (CustomButton) this.f8954b.f8960T.findViewById(R.id.cb_install);
            customButton.setVisibility(View.VISIBLE);
            this.f8954b.f8960T.findViewById(R.id.cb_ok).setVisibility(View.GONE);
            final String str = this.f8953a;
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.c2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BroadcastReceiverEx.this.m4824a(str, view);
                }
            });
        }
    }
}
