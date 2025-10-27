package com.jeil.emarket.widget.img.vp;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;

/* renamed from: b.f.a.c.h0.g.a */

public class ViewPager3 extends ViewPager {

    /* renamed from: k0 */
    public static final float[] f8372k0 = new float[9];

    /* renamed from: i0 */
    public float f8373i0;

    /* renamed from: j0 */
    public int f8374j0;


    public static float m4631a(float f, float f2, float f3, float f4) {
        return f / f2 <= f3 / f4 ? f / f3 : f2 / f4;
    }


    public static boolean m4632a(float f, float f2, float f3) {
        return f3 >= f2 && (f > 0.0f || f < f2 - f3);
    }

    @Override // androidx.viewpager.widget.ViewPager

    public boolean mo3128a(View view, boolean z, int i, int i2, int i3) {
        ImageView imageView;
        Drawable drawable;
        if (!(view instanceof ImageView) || (drawable = (imageView = (ImageView) view).getDrawable()) == null) {
            return super.mo3128a(view, z, i, i2, i3);
        }
        float width = imageView.getWidth();
        float height = imageView.getHeight();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        imageView.getImageMatrix().getValues(f8372k0);
        float[] fArr = f8372k0;
        float f = fArr[2] + i;
        float f2 = fArr[0] * intrinsicWidth;
        return fArr[0] / m4631a(width, height, intrinsicWidth, intrinsicHeight) > this.f8373i0 && !m4632a(f, width, f2) && f2 > width && this.f8374j0 == 1;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f8374j0 = motionEvent.getPointerCount();
        requestDisallowInterceptTouchEvent(this.f8374j0 > 1);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
