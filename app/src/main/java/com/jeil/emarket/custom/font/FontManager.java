package com.jeil.emarket.custom.font;

import android.content.Context;
import android.graphics.Typeface;
import java.io.File;
import java.util.Hashtable;

/* renamed from: b.f.a.l.b */

public class FontManager {


    public static final Hashtable<String, Typeface> f10443a = new Hashtable<>();


    public static Typeface getFont(Context context, String str) {
        Typeface typeface = f10443a.get(str);
        if (typeface != null) {
            return typeface;
        }
        if (!new File(context.getFilesDir().getPath() + "/font").exists()) {
            return null;
        }
        try {
            typeface = Typeface.createFromFile(new File(context.getFilesDir().getAbsolutePath() + "/" + str));
            f10443a.put(str, typeface);
            return typeface;
        } catch (Exception unused) {
            return typeface;
        }
    }
}
