package custom.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.jeil.emarket.custom.CustomString;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import androidx.appcompat.widget.MaterialRatingBar;

/* renamed from: b.e.a.a.p.o */
/* loaded from: classes.dex */
public final class C1157o {

    /* renamed from: a */
    public static final int[] f5917a = {R$attr.colorPrimary};

    /* renamed from: b */
    public static final int[] f5918b = {R$attr.colorPrimaryVariant};

    /* renamed from: a */
    public static void m4122a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R$attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                m4124a(context, f5918b, "Theme.MaterialComponents");
            }
        }
        m4124a(context, f5917a, "Theme.AppCompat");
    }

    /* renamed from: b */
    public static TypedArray m4125b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m4122a(context, attributeSet, i, i2);
        m4123a(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    /* renamed from: c */
    public static MaterialRatingBar m4126c(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m4122a(context, attributeSet, i, i2);
        m4123a(context, attributeSet, iArr, i, i2, iArr2);
        return new MaterialRatingBar(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r0.getResourceId(com.google.android.material.R$styleable.ThemeEnforcement_android_textAppearance, -1) != (-1)) goto L21;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m4123a(android.content.Context r5, android.util.AttributeSet r6, int[] r7, int r8, int r9, int... r10) {
        /*
            int[] r0 = com.google.android.material.R$styleable.ThemeEnforcement
            android.content.res.TypedArray r0 = r5.obtainStyledAttributes(r6, r0, r8, r9)
            int r1 = com.google.android.material.R$styleable.ThemeEnforcement_enforceTextAppearance
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 != 0) goto L13
            r0.recycle()
            return
        L13:
            r1 = 1
            r3 = -1
            if (r10 == 0) goto L37
            int r4 = r10.length
            if (r4 != 0) goto L1b
            goto L37
        L1b:
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r7, r8, r9)
            int r6 = r10.length
            r7 = 0
        L21:
            if (r7 >= r6) goto L33
            r8 = r10[r7]
            int r8 = r5.getResourceId(r8, r3)
            if (r8 != r3) goto L30
            r5.recycle()
        L2e:
            r1 = 0
            goto L3f
        L30:
            int r7 = r7 + 1
            goto L21
        L33:
            r5.recycle()
            goto L3f
        L37:
            int r5 = com.google.android.material.R$styleable.ThemeEnforcement_android_textAppearance
            int r5 = r0.getResourceId(r5, r3)
            if (r5 == r3) goto L2e
        L3f:
            r0.recycle()
            if (r1 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p147p.C1157o.m4123a(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):void");
    }

    /* renamed from: a */
    public static void m4124a(Context context, int[] iArr, java.lang.String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= iArr.length) {
                obtainStyledAttributes.recycle();
                z = true;
                break;
            } else {
                if (!obtainStyledAttributes.hasValue(i)) {
                    obtainStyledAttributes.recycle();
                    break;
                }
                i++;
            }
        }
        if (!z) {
            throw new IllegalArgumentException(CustomString.m3158a("The style on this component requires your app theme to be ", str, " (or a descendant)."));
        }
    }
}
