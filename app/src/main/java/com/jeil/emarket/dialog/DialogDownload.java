package com.jeil.emarket.dialog;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.intro.SplashBaseActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.jeil.emarket.dialog.dialog.dialog.base.ImageDialog1;
import com.jeil.emarket.viewmodel.UserVM;

/* renamed from: b.f.a.f.i3 */

public class DialogDownload extends ImageDialog1<DialogDownload> {

    /* renamed from: T */
    public View f8975T;

    /* renamed from: U */
    public SplashBaseActivity f8976U;

    /* renamed from: V */
    public java.lang.String f8977V;

    /* renamed from: W */
    public int f8978W;

    /* renamed from: X */
    public java.lang.String f8979X;

    public DialogDownload(SplashBaseActivity splashActivity, java.lang.String str, int i, java.lang.String str2) {
        super(splashActivity);
        this.f8976U = splashActivity;
        this.f8977V = str;
        this.f8978W = i;
        this.f8979X = str2;
        this.f8257h = false;
        setCanceledOnTouchOutside(false);
    }

    
    public  void m4832a(int i, ProgressBar progressBar, TextView textView) {
        int i2 = this.f8978W;
        if (i > i2) {
            i = i2;
        }
        int i3 = (int) ((i * 100) / this.f8978W);
        progressBar.setProgress(i3);
        textView.setText("(" + i3 + "%)");
    }

    
    public  void m4833a(ProgressBar progressBar, TextView textView, TextView textView2, ImageView imageView) {
        progressBar.setProgress(0);
        textView.setText("(0%)");
        textView2.setText(java.lang.String.format(this.f8975T.getResources().getString(R.string.capacity), Float.valueOf(this.f8978W / 1048576.0f)));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 180.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(1000L).start();
    }

    
    public  void m4834a(final File file) {
//        BaseApplication.m5667a(this.f8976U, file, new BaseApplication.a() { // from class: b.f.a.f.l2
//            @Override // p078b.p159f.p259b.ApplicationC2903c.a
//            
//            public final void mo4840a(boolean z, java.lang.String str) {
//                DialogDownload.this.m4835a(file, z, str);
//            }
//        });
    }

    
    public  void m4835a(File file, boolean z, java.lang.String str) {
//        if (!file.delete()) {
//            throw new IOException("can't delete new file");
//        }
//        JeilService.m7014a(this.f8976U.getApplicationContext());
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @SuppressLint({"StringFormatMatches"})
    
    public View mo4576b() {
        this.f8975T = View.inflate(this.f8251b, R.layout.dialog_update_sub_version_apk, null);
        new Thread(new Runnable() { // from class: b.f.a.f.q2
            @Override // java.lang.Runnable
            public final void run() {
                DialogDownload.this.m4836f();
            }
        }).start();
        this.f8255f = 0.95f;
        this.f8254e = 0.8f;
        return this.f8975T;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2008f, p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public void mo4577c() {
        if (UserVM.sharedPreferences.getBoolean("setup", false)) {
            return;
        }
        this.f8975T.setVisibility(View.GONE);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: f */
    public final void m4836f() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8976U.getFilesDir().getPath());
        sb.append("/app-patch-");
        java.lang.String m3160a = CustomString.m3160a(sb, this.f8977V, ".zip");
        try {
            try {
                InputStream inputStream = ((HttpURLConnection) new URL(this.f8979X).openConnection()).getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(m3160a, false);
                final ProgressBar progressBar = (ProgressBar) this.f8975T.findViewById(R.id.pb_progress);
                final TextView textView = (TextView) this.f8975T.findViewById(R.id.tv_progress);
                final TextView textView2 = (TextView) this.f8975T.findViewById(R.id.tv_capacity);
                final ImageView imageView = (ImageView) this.f8975T.findViewById(R.id.iv_rotate);
                this.f8976U.runOnUiThread(new Runnable() { // from class: b.f.a.f.j2
                    @Override // java.lang.Runnable
                    public final void run() {
                        DialogDownload.this.m4833a(progressBar, textView, textView2, imageView);
                    }
                });
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        int i = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            i += 1024;
                            int finalI = i;
                            this.f8976U.runOnUiThread(new Runnable() { // from class: b.f.a.f.k2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DialogDownload.this.m4832a(finalI, progressBar, textView);
                                }
                            });
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.f8976U.runOnUiThread(new Runnable() { // from class: b.f.a.f.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                DialogDownload.this.dismiss();
                            }
                        });
                        if (this.f8979X.endsWith(".zip")) {
                            File file = new File(m3160a);
                            Util.m261a(file, new File(this.f8976U.getFilesDir().getPath()));
                            if (!file.delete()) {
                                throw new IOException("can't delete zip file");
                            }
                            m3160a = this.f8976U.getFilesDir().getPath() + "/" + this.f8977V + ".apk";
                        }
                        if (!new File(m3160a).exists()) {
                            dismiss();
                            return;
                        }
                        java.lang.String str = this.f8976U.getApplicationInfo().sourceDir;
                        java.lang.String str2 = this.f8976U.getFilesDir() + "/new";
                        Util.download(str, str2, m3160a);
                        final File file2 = new File(str2 + ".apk");
                        this.f8976U.runOnUiThread(new Runnable() { // from class: b.f.a.f.m2
                            @Override // java.lang.Runnable
                            public final void run() {
                                DialogDownload.this.m4834a(file2);
                            }
                        });
                        inputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        dismiss();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.f8976U.runOnUiThread(new Runnable() { // from class: b.f.a.f.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                DialogDownload.this.dismiss();
                            }
                        });
                    }
                } catch (Throwable th) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f8976U.runOnUiThread(new Runnable() { // from class: b.f.a.f.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            DialogDownload.this.dismiss();
                        }
                    });
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }
}
