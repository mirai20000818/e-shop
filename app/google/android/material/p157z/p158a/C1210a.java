package custom.google.android.material.p157z.p158a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import androidx.appcompat.view.C0059c;

/* renamed from: b.e.a.a.z.a.a */
/* loaded from: classes.dex */
public class C1210a {

    /* renamed from: a */
    public static final int[] f6208a = {R.attr.theme, R$attr.theme};

    /* renamed from: b */
    public static final int[] f6209b = {R$attr.materialThemeOverlay};

    /* renamed from: a */
    public static Context m4263a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6209b, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        boolean z = (context instanceof C0059c) && ((C0059c) context).f332a == resourceId;
        if (resourceId == 0 || z) {
            return context;
        }
        C0059c c0059c = new C0059c(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f6208a);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            c0059c.getTheme().applyStyle(resourceId2, true);
        }
        return c0059c;
    }
}
