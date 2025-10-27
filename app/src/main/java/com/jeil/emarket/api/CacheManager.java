package com.jeil.emarket.api;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.File;
import java.io.IOException;

/* renamed from: b.f.a.i.r */

public class CacheManager {
    @SuppressLint({"VisibleForTests"})
    public CacheManager(final Context context) {
//        C0796c c0796c = new C0796c();
//        c0796c.f4349i = new DiskLruCacheFactory(new DiskLruCacheFactory.a() { // from class: b.f.a.i.h
//            @Override // p078b.p095c.p096a.p099o.p102n.p104d0.C0866d.a
//
//            public final File mo3469a() {
//                return CacheManager.this.m5417a(context);
//            }
//        }, 1610612736L);
//        Glide.m3290a(context, c0796c);
    }


    public  File m5417a(Context context) {
        File file = new File(context.getCacheDir(), "image_manager_disk_cache");
        try {
            if (!file.exists() && file.mkdirs()) {
                throw new IOException("can't create glide cache directory");
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file;
    }
}
