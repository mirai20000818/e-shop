package com.jeil.emarket.api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Base64;
import com.google.gson.stream.JsonReader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;


import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.viewmodel.UserVM;

/* renamed from: b.f.a.i.q */

public class CERT_PROVIDER {

    
    public static SSLContext f10147a;

    
    public static String m5415a(BaseActivity activityC1391g1, Intent intent) {
        String stringExtra;
        SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
        if (intent == null) {
            edit.putInt("cid_type", 0);
            stringExtra = "";
        } else {
            stringExtra = intent.getStringExtra("RECEIVED_RESULT");
        }
        UserVM.f10340q = Util.m357h(stringExtra);
        edit.putString("cid", stringExtra);
        edit.apply();
        if (intent == null) {
            return stringExtra;
        }
        UserVM.stringMutableLiveData.setValue(stringExtra);
        byte[] decode = Base64.decode(intent.getStringExtra("RECEIVED_CERT"), 0);
        if (!stringExtra.isEmpty() && decode != null) {
            String format = String.format("%s/cert.p12", activityC1391g1.getFilesDir().getAbsolutePath());
            SharedPreferences.Editor edit2 = UserVM.sharedPreferences.edit();
            edit2.putString("cid_cert_path", activityC1391g1.getFilesDir().getAbsolutePath());
            edit2.apply();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(format);
                fileOutputStream.write(decode);
                fileOutputStream.close();
                m5416a(activityC1391g1.getApplicationContext());
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return stringExtra;
    }

    
    public static void m5416a(Context context) {
        try {
            String string = UserVM.sharedPreferences.getString("cid", "");
            String str = context.getFilesDir().getPath() + "/rootCA.crt";
            UserVM.f10340q = Util.m357h(string);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            if (!new File(str).exists()) {
                InputStream open = context.getAssets().open("cid/rootCA.crt");
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
            }
            InputStream open2 = context.getAssets().open("cid/rootCA.crt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(open2);
            Certificate generateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("SSL Certificate", generateCertificate);
            new PKIXParameters(keyStore).setRevocationEnabled(false);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            KeyStore keyStore2 = KeyStore.getInstance("PKCS12");
            FileInputStream fileInputStream = new FileInputStream(context.getFilesDir().getPath() + "/cert.p12");
            keyStore2.load(fileInputStream, string.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
            keyManagerFactory.init(keyStore2, string.toCharArray());
            f10147a = SSLContext.getInstance("TLS");
            f10147a.init(keyManagerFactory.getKeyManagers(), trustManagers, null);
            open2.close();
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
            edit.putString("cid", "");
            edit.apply();
        }
    }
}
