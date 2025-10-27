package com.jeil.emarket.dialog;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;

import com.jeil.emarket.activities.intro.SplashBaseActivity;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.textview.TextView;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import androidx.core.content.FileProvider;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;
import com.jeil.emarket.viewmodel.UserVM;

/* renamed from: b.f.a.f.h3 */

public class DialogSplashInstall extends ImageDialog1<DialogSplashInstall> {

    /* renamed from: T */
    public View f8960T;

    /* renamed from: U */
    public SplashBaseActivity f8961U;

    /* renamed from: V */
    public int f8962V;

    /* renamed from: W */
    public String f8963W;

    /* renamed from: X */
    public String f8964X;

    /* renamed from: Y */
    public long f8965Y;

    /* renamed from: Z */
    public String[] f8966Z;

    /* renamed from: a0 */
    public boolean f8967a0;

    public DialogSplashInstall(SplashBaseActivity splashActivity, int i, String str, String str2, boolean z, String[] strArr) {
        super(splashActivity);
        this.f8965Y = 0L;
        this.f8961U = splashActivity;
        this.f8962V = i;
        this.f8964X = splashActivity.getResources().getString(R.string.app_name) + str;
        this.f8963W = str2;
        this.f8967a0 = z;
        this.f8966Z = strArr;
        setCanceledOnTouchOutside(false);
    }


    public static  void m4825a(ProgressBar progressBar, TextView textView, AppCompatImageView appCompatImageView) {
        progressBar.setProgress(0);
        textView.setText("(0%)");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(appCompatImageView, "rotation", 0.0f, 180.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(1000L).start();
    }


    public void m4827a(File file) {
        Intent intent;
        SplashBaseActivity splashActivity;
        Util.m330c(this.f8961U, "");
        try {
            if (Build.VERSION.SDK_INT > 24) {
                Uri m1068a = ((FileProvider.b) FileProvider.m1066a(this.f8961U, this.f8961U.getApplicationContext().getPackageName() + ".provider.file")).m1068a(file);
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(m1068a);
                intent.setFlags(1);
                splashActivity = this.f8961U;
            } else {
                intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                intent.setData(Uri.fromFile(file));
                splashActivity = this.f8961U;
            }
            splashActivity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            ((TextView) this.f8960T.findViewById(R.id.tv_version)).setText(this.f8961U.getResources().getString(R.string.auto_install_failed));
            CustomButton customButton = (CustomButton) this.f8960T.findViewById(R.id.cb_ok);
            customButton.setVisibility(View.VISIBLE);
            customButton.setText(this.f8961U.getResources().getString(R.string.action_ok));
            this.f8960T.findViewById(R.id.cb_install).setVisibility(View.GONE);
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.f2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogSplashInstall.this.m4830f(view);
                }
            });
        }
    }


    public  void m4828a(File file, View view) {
        m4827a(file);
    }


    public  void m4829a(Timer timer, BroadcastReceiver broadcastReceiver, DialogInterface dialogInterface) {
        timer.cancel();
        timer.purge();
        this.f8961U.unregisterReceiver(broadcastReceiver);
        if (this.f8967a0) {
            this.f8961U.finish();
        } else {
            UserVM.login(this.f8961U);
            this.f8961U.refresh();
        }
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @SuppressLint({"StringFormatMatches"})

    public View mo4576b() {
        String str;
        this.f8960T = View.inflate(this.f8251b, R.layout.dialog_update_apk, null);
        final TextView textView = (TextView) this.f8960T.findViewById(R.id.tv_version);
        if (this.f8967a0) {
            String[] strArr = this.f8966Z;
            if (strArr[0] != null && !strArr[0].isEmpty()) {
                str = this.f8966Z[0];
                textView.setText(str);
                ((CustomButton) this.f8960T.findViewById(R.id.cb_cancel)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.h2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogSplashInstall.this.m4831g(view);
                    }
                });
                final ProgressBar progressBar = (ProgressBar) this.f8960T.findViewById(R.id.pb_progress);
                final TextView textView2 = (TextView) this.f8960T.findViewById(R.id.tv_progress);
                final AppCompatImageView appCompatImageView = (AppCompatImageView) this.f8960T.findViewById(R.id.iv_rotate);
                this.f8961U.runOnUiThread(new Runnable() { // from class: b.f.a.f.e2
                    @Override // java.lang.Runnable
                    public final void run() {
                        DialogSplashInstall.m4825a(progressBar, textView2, appCompatImageView);
                    }
                });
                ((CustomButton) this.f8960T.findViewById(R.id.cb_ok)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.g2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogSplashInstall.this.m4826a(textView, progressBar, textView2, view);
                    }
                });
                return this.f8960T;
            }
        }
        str = this.f8961U.getResources().getString(R.string.new_version_available) + "  (" + String.format(this.f8961U.getResources().getString(R.string.file_size), Float.valueOf(this.f8962V / 1048576.0f)) + ")";
        textView.setText(str);
        ((CustomButton) this.f8960T.findViewById(R.id.cb_cancel)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSplashInstall.this.m4831g(view);
            }
        });
        final ProgressBar progressBar2 = (ProgressBar) this.f8960T.findViewById(R.id.pb_progress);
        final TextView textView22 = (TextView) this.f8960T.findViewById(R.id.tv_progress);
        final AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.f8960T.findViewById(R.id.iv_rotate);
        this.f8961U.runOnUiThread(new Runnable() { // from class: b.f.a.f.e2
            @Override // java.lang.Runnable
            public final void run() {
                DialogSplashInstall.m4825a(progressBar2, textView22, appCompatImageView2);
            }
        });
        ((CustomButton) this.f8960T.findViewById(R.id.cb_ok)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSplashInstall.this.m4826a(textView, progressBar2, textView22, view);
            }
        });
        return this.f8960T;
    }

    /* renamed from: f */
    public  void m4830f(View view) {
        this.f8961U.finish();
    }

    /* renamed from: g */
    public  void m4831g(View view) {
        dismiss();
        if (this.f8965Y > 0) {
            ((DownloadManager) this.f8961U.getSystemService("download")).remove(this.f8965Y);
        }
        if (this.f8967a0) {
            this.f8961U.finish();
        } else {
            UserVM.login(this.f8961U);
            this.f8961U.refresh();
        }
    }


    public  void m4826a(TextView textView, ProgressBar progressBar, TextView textView2, View view) {
        findViewById(R.id.ll_progress).setVisibility(View.VISIBLE);
        findViewById(R.id.ll_action).setVisibility(View.GONE);
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f8963W));
            File file = new File(BaseActivity.string);
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException("can't create directories");
            }
            long freeSpace = file.getFreeSpace();
            if (!file.exists()) {
                textView.setText((this.f8966Z.length <= 1 || this.f8966Z[1] == null || this.f8966Z[1].isEmpty()) ? this.f8961U.getResources().getString(R.string.auto_download_failed) : this.f8966Z[1]);
                return;
            }
            if (freeSpace < this.f8962V) {
                textView.setText((this.f8966Z.length <= 2 || this.f8966Z[2] == null || this.f8966Z[2].isEmpty()) ? this.f8961U.getResources().getString(R.string.not_enough_free_space) : this.f8966Z[2]);
                return;
            }
            final File file2 = new File(BaseActivity.string + "/" + this.f8964X);
            if (file2.exists()) {
                textView.setText((this.f8966Z.length <= 4 || this.f8966Z[4] == null || this.f8966Z[4].isEmpty()) ? this.f8961U.getResources().getString(R.string.already_download) : this.f8966Z[4]);
                this.f8960T.findViewById(R.id.ll_progress).setVisibility(View.GONE);
                findViewById(R.id.ll_action).setVisibility(View.VISIBLE);
                CustomButton customButton = (CustomButton) this.f8960T.findViewById(R.id.cb_install);
                customButton.setVisibility(View.VISIBLE);
                this.f8960T.findViewById(R.id.cb_ok).setVisibility(View.GONE);
                customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.i2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DialogSplashInstall.this.m4828a(file2, view2);
                    }
                });
                return;
            }
            request.setTitle(this.f8961U.getResources().getString(R.string.app_name));
            request.setDestinationUri(Uri.fromFile(file2));
            request.setVisibleInDownloadsUi(true);
            request.allowScanningByMediaScanner();
            request.setAllowedNetworkTypes(3);
            request.setAllowedOverRoaming(false);
            request.setNotificationVisibility(1);
            DownloadManager downloadManager = (DownloadManager) this.f8961U.getSystemService("download");
            this.f8965Y = downloadManager.enqueue(request);
            final Timer timer = new Timer();
            timer.schedule(new TimerTaskEx(this, downloadManager, progressBar, textView2), 0L, 50L);
            String str = this.f8964X;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            final BroadcastReceiverEx broadcastReceiverEx = new BroadcastReceiverEx(this, str);
            this.f8961U.registerReceiver(broadcastReceiverEx, intentFilter);
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.f.d2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DialogSplashInstall.this.m4829a(timer, broadcastReceiverEx, dialogInterface);
                }
            });
        } catch (Exception unused) {
            TextView textView3 = (TextView) this.f8960T.findViewById(R.id.tv_version);
            String[] strArr = this.f8966Z;
            textView3.setText((strArr.length <= 1 || strArr[1] == null || strArr[1].isEmpty()) ? this.f8961U.getResources().getString(R.string.auto_download_failed) : this.f8966Z[1]);
        }
    }
}
