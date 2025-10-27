package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.database.Cursor;
import android.widget.ProgressBar;

import com.jeil.emarket.components.textview.TextView;

import java.util.TimerTask;

/* renamed from: b.f.a.f.f3 */

public class TimerTaskEx extends TimerTask {


    public final  DownloadManager f8942b;

    
    public final  ProgressBar f8943c;

    
    public final  TextView f8944d;

    
    public final  DialogSplashInstall f8945e;

    public TimerTaskEx(DialogSplashInstall dialogSplashInstall, DownloadManager downloadManager, ProgressBar progressBar, TextView textView) {
        this.f8945e = dialogSplashInstall;
        this.f8942b = downloadManager;
        this.f8943c = progressBar;
        this.f8944d = textView;
    }


    public static  void m4823a(ProgressBar progressBar, int i, TextView textView) {
        progressBar.setProgress(i);
        textView.setText("(" + i + "%)");
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    @SuppressLint({"SetTextI18n"})
    public void run() {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(this.f8945e.f8965Y);
        Cursor query2 = this.f8942b.query(query);
        int columnIndex = query2.getColumnIndex("status");
        int columnIndex2 = query2.getColumnIndex("bytes_so_far");
        if (query2.moveToNext()) {
            int i = query2.getInt(columnIndex);
            float f = query2.getInt(columnIndex2);
            if (i == 1) {
                f = 0.0f;
            }
//            final int i2 = (int) ((f / r1.f8962V) * 100.0f);
//            SplashBaseActivity splashActivity = this.f8945e.f8961U;
//            final ProgressBar progressBar = this.f8943c;
//            final TextView textView = this.f8944d;
//            splashActivity.runOnUiThread(new Runnable() { // from class: b.f.a.f.b2
//                @Override // java.lang.Runnable
//                public final void run() {
//                    TimerTaskEx.m4823a(progressBar, i2, textView);
//                }
//            });
        }
        query2.close();
    }
}
