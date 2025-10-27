package com.jeil.emarket.custom;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

/* renamed from: b.f.b.l.d */

public class ResManager {


    public static Resources f10566a;


    public static Resources f10567b;


    public static Resources f10568c;


    public static int find(Context context, int i) {
        Resources resources = f10566a;
        if (resources == null) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
               //?? C2913b.m5707a(assetManager, "addAssetPath", context.getApplicationInfo().sourceDir);
                Resources resources2 = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
                f10566a = resources2;
                resources = resources2;
            } catch (Exception e2) {
                e2.printStackTrace();
                resources = null;
            }
        }
        f10566a = resources;
        Resources resources3 = f10567b;
        if (resources3 == null) {
            resources3 = context.getResources();
            f10567b = resources3;
        }
        f10567b = resources3;
        try {
            return f10566a.getIdentifier(f10567b.getResourceEntryName(i), f10567b.getResourceTypeName(i), context.getPackageName());
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }


    public static Resources m5741a(Resources resources, String str) {
        Resources resources2 = f10568c;
        if (resources2 != null) {
            return resources2;
        }
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            //??C2913b.m5707a(assetManager, "addAssetPath", str);
            try {
                //C2926a.m5764a((Object) resources, "mAssets", (Object) assetManager, true);
            } catch (Throwable unused) {
               // C2926a.m5764a(C2926a.m5759a((Object) resources, "mResourcesImpl", true), "mAssets", (Object) assetManager, true);
            }
            //??while (C2913b.m5707a(C2926a.m5759a((Object) resources, "mTypedArrayPool", true), "acquire", new Object[0]) != null) {
           // }
            resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
            f10568c = resources;
            return resources;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
