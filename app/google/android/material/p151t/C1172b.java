package custom.google.android.material.p151t;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

/* renamed from: b.e.a.a.t.b */
/* loaded from: classes.dex */
public class C1172b {

    /* renamed from: a */
    public static final boolean f5968a;

    /* renamed from: b */
    public static final int[] f5969b;

    /* renamed from: c */
    public static final String f5970c;

    static {
        int i = Build.VERSION.SDK_INT;
        f5968a = true;
        new int[1][0] = 16842919;
        new int[1][0] = 16842908;
        new int[1][0] = 16843623;
        new int[1][0] = 16842913;
        f5969b = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f5970c = C1172b.class.getSimpleName();
    }

    /* renamed from: a */
    public static ColorStateList m4140a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f5969b, 0)) != 0) {
            Log.w(f5970c, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    /* renamed from: a */
    public static boolean m4141a(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
