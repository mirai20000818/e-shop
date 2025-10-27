package com.jeil.emarket.widget.drawable;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* renamed from: b.f.a.c.j0.b */

public class LayerDrawableEx extends LayerDrawable {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
   // public LayerDrawableEx(android.content.Context r9, boolean r10, com.jeil.emarket.components.ratingbar.MaterialRatingBar.C3253a r11) {
        /*
            r8 = this;
            r0 = 3
            android.graphics.drawable.Drawable[] r1 = new android.graphics.drawable.Drawable[r0]
            r2 = 2131165482(0x7f07012a, float:1.7945182E38)
            r3 = 2131165481(0x7f070129, float:1.794518E38)
            if (r10 == 0) goto Lf
            r4 = 2131165482(0x7f07012a, float:1.7945182E38)
            goto L12
        Lf:
            r4 = 2131165481(0x7f070129, float:1.794518E38)
        L12:
            r5 = 2131034387(0x7f050113, float:1.767929E38)
            r6 = 2131034413(0x7f05012d, float:1.7679343E38)
            if (r10 == 0) goto L23
            android.content.res.Resources r7 = r9.getResources()
            int r7 = r7.getColor(r6)
            goto L36
        L23:
            boolean r7 = r11.f12289c
            if (r7 == 0) goto L2e
            android.content.res.ColorStateList r7 = r11.f12287a
            int r7 = r7.getDefaultColor()
            goto L36
        L2e:
            android.content.res.Resources r7 = r9.getResources()
            int r7 = r7.getColor(r5)
        L36:
            android.graphics.drawable.Drawable r4 = m4654b(r4, r7, r9)
            r7 = 0
            r1[r7] = r4
            r4 = 1
            if (r10 == 0) goto L4a
            b.f.a.c.j0.a r10 = new b.f.a.c.j0.a
            android.graphics.drawable.Drawable r3 = m4654b(r2, r7, r9)
            r10.<init>(r3, r0, r4)
            goto L56
        L4a:
            android.content.res.Resources r10 = r9.getResources()
            int r10 = r10.getColor(r6)
            android.graphics.drawable.Drawable r10 = m4653a(r3, r10, r9)
        L56:
            r1[r4] = r10
            boolean r10 = r11.f12289c
            if (r10 == 0) goto L63
            android.content.res.ColorStateList r10 = r11.f12287a
            int r10 = r10.getDefaultColor()
            goto L6b
        L63:
            android.content.res.Resources r10 = r9.getResources()
            int r10 = r10.getColor(r5)
        L6b:
            android.graphics.drawable.Drawable r9 = m4653a(r2, r10, r9)
            r10 = 2
            r1[r10] = r9
            r8.<init>(r1)
            r9 = 16908288(0x1020000, float:2.387723E-38)
            r8.setId(r7, r9)
            r9 = 16908303(0x102000f, float:2.387727E-38)
            r8.setId(r4, r9)
            r9 = 16908301(0x102000d, float:2.3877265E-38)
            r8.setId(r10, r9)
            return
        */
        //throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p190c.p208j0.C2062b.<init>(android.content.Context, boolean, com.jeil.emarket.components.ratingbar.MaterialRatingBar$a):void");
 //   }

    @SuppressLint({"RtlHardcoded"})

    public static Drawable m4653a(int i, int i2, Context context) {
        return new ClipDrawableEx(m4654b(i, i2, context), 3, 1);
    }


    public static Drawable m4654b(int i, int i2, Context context) {
        return null;
//        DrawableEx drawableEx = new DrawableEx(C0052a.m373c(context, i));
//        drawableEx.mutate();
//        drawableEx.setTint(i2);
//        return drawableEx;
    }


    public final DrawableEx m4655a(int i) {
        Drawable findDrawableByLayerId = findDrawableByLayerId(i);
        if (i == 16908288) {
            return (DrawableEx) findDrawableByLayerId;
        }
        if (i == 16908301 || i == 16908303) {
            return (DrawableEx) ((ClipDrawableEx) findDrawableByLayerId).f8440b;
        }
        throw new RuntimeException();
    }


    public void m4656b(int i) {
        DrawableEx m4655a = m4655a(R.id.background);
        m4655a.f8447h = i;
        m4655a.invalidateSelf();
        DrawableEx m4655a2 = m4655a(R.id.secondaryProgress);
        m4655a2.f8447h = i;
        m4655a2.invalidateSelf();
        DrawableEx m4655a3 = m4655a(R.id.progress);
        m4655a3.f8447h = i;
        m4655a3.invalidateSelf();
    }
}
