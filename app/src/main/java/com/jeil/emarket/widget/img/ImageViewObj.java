package com.jeil.emarket.widget.img;

import android.graphics.Matrix;
import android.widget.ImageView;

/* renamed from: b.f.a.c.h0.a */

public abstract class ImageViewObj {

    
    public ImageView f8336c;

    
    public float f8337d;

    
    public float f8338e;

    
    public Matrix f8335b = null;

    
    public final float[] f8334a = new float[9];

    
    public float m4614a() {
        if (this.f8336c.getDrawable() == null) {
            return 1.0f;
        }
        float intrinsicWidth = 1;//r0.getIntrinsicWidth() / this.f8336c.getWidth();
        float intrinsicHeight = 1;//r0.getIntrinsicHeight() / this.f8336c.getHeight();
        return intrinsicWidth > intrinsicHeight ? 1.0f / intrinsicWidth : 1.0f / intrinsicHeight;
    }

    
    public abstract float mo4615a(int i, float f);

    
    public void m4616a(ImageView imageView) {
        this.f8336c = imageView;
        if (imageView != null) {
            this.f8335b = imageView.getImageMatrix();
            m4620d();
        }
    }

    
    public float m4617b(int i, float f) {
        float f2 = m4618b()[i];
        if (i != 0) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 5) {
                        throw new IllegalArgumentException("Vector not supported");
                    }
                }
            }
            return mo4615a(i, f + f2) - f2;
        }
        return mo4615a(i, f * f2) / f2;
    }

    
    public abstract void mo4619c();

    
    public void m4620d() {
        float[] m4618b = m4618b();
        if (this.f8336c.getDrawable() != null) {
//            this.f8337d = m4618b[0] * r1.getIntrinsicWidth();
//            this.f8338e = m4618b[4] * r1.getIntrinsicHeight();
        } else {
            this.f8338e = 0.0f;
            this.f8337d = 0.0f;
        }
    }

    
    public float[] m4618b() {
        this.f8335b.getValues(this.f8334a);
        return this.f8334a;
    }
}
