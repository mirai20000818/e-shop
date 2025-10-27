package com.jeil.emarket.widget.drawable;

import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

/* renamed from: b.f.a.c.j0.a */

public class ClipDrawableEx extends ClipDrawable implements InterfaceDrawable {


    public final Drawable f8440b;

    public ClipDrawableEx(Drawable drawable, int i, int i2) {
        super(drawable, i, i2);
        this.f8440b = drawable;
    }

    @Override // android.graphics.drawable.DrawableWrapper
    public Drawable getDrawable() {
        return this.f8440b;
    }

    @Override // android.graphics.drawable.Drawable, p078b.p159f.p160a.p190c.p208j0.InterfaceC2064d
    public void setTint(int i) {
        Object obj = this.f8440b;
        if (obj instanceof InterfaceDrawable) {
            ((InterfaceDrawable) obj).setTint(i);
        } else {
            Log.w("ClipDrawableCompat", "Drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
            super.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, p078b.p159f.p160a.p190c.p208j0.InterfaceC2064d
    public void setTintMode(PorterDuff.Mode mode) {
        Object obj = this.f8440b;
        if (obj instanceof InterfaceDrawable) {
            ((InterfaceDrawable) obj).setTintMode(mode);
        } else {
            Log.w("ClipDrawableCompat", "Drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
            super.setTintMode(mode);
        }
    }
}
