package com.jeil.emarket.widget.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: b.f.a.c.j0.c */

public class DrawableEx extends Drawable implements InterfaceDrawable {


    public ColorFilter f8442c;

    
    public ColorStateList f8443d;

    /* renamed from: f */
    public PorterDuffColorFilter f8445f;

    /* renamed from: g */
    public Drawable f8446g;


    public int f8441b = 255;

    
    public PorterDuff.Mode f8444e = PorterDuff.Mode.SRC_IN;

    /* renamed from: h */
    public int f8447h = -1;

    public DrawableEx(Drawable drawable) {
        this.f8446g = drawable;
    }


    public final boolean m4657a() {
        return  false;
//        ColorStateList colorStateList = this.f8443d;
//        if (colorStateList == null || this.f8444e == null) {
//            r1 = this.f8445f != null;
//            this.f8445f = null;
//        } else {
//            this.f8445f = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), this.f8444e);
//        }
//        return r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        int width = bounds.width();
        int height = bounds.height();
        this.f8446g.setAlpha(this.f8441b);
        ColorFilter colorFilter = this.f8442c;
        if (colorFilter == null) {
            colorFilter = this.f8445f;
        }
        if (colorFilter != null) {
            this.f8446g.setColorFilter(colorFilter);
        }
        int intrinsicHeight = this.f8446g.getIntrinsicHeight();
        float f = height / intrinsicHeight;
        canvas.scale(f, f);
        float f2 = width / f;
        int i = this.f8447h;
        if (i < 0) {
            int intrinsicWidth = this.f8446g.getIntrinsicWidth();
            int i2 = 0;
            while (i2 < f2) {
                int i3 = i2 + intrinsicWidth;
                this.f8446g.setBounds(i2, 0, i3, intrinsicHeight);
                this.f8446g.draw(canvas);
                i2 = i3;
            }
        } else {
            float f3 = f2 / i;
            for (int i4 = 0; i4 < this.f8447h; i4++) {
                float f4 = (i4 + 0.5f) * f3;
                float intrinsicWidth2 = this.f8446g.getIntrinsicWidth() / 2.0f;
                this.f8446g.setBounds(Math.round(f4 - intrinsicWidth2), 0, Math.round(f4 + intrinsicWidth2), intrinsicHeight);
                this.f8446g.draw(canvas);
            }
        }
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f8441b;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f8442c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f8443d;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f8446g = this.f8446g.mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return m4657a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f8441b != i) {
            this.f8441b = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f8442c = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, p078b.p159f.p160a.p190c.p208j0.InterfaceC2064d
    public void setTint(int i) {
        this.f8443d = ColorStateList.valueOf(i);
        if (m4657a()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f8443d = colorStateList;
        if (m4657a()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, p078b.p159f.p160a.p190c.p208j0.InterfaceC2064d
    public void setTintMode(PorterDuff.Mode mode) {
        this.f8444e = mode;
        if (m4657a()) {
            invalidateSelf();
        }
    }
}
