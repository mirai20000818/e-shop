package com.jeil.emarket.widget.img;

/* renamed from: b.f.a.c.h0.c */

public class ImageViewObjEx extends ImageViewObj {

    /* renamed from: f */
    public float f8364f = 4.0f;


    public static float m4624a(float f, float f2, float f3) {
        return f3 < f2 ? (f2 / 2.0f) - (f3 / 2.0f) : Math.max(Math.min(0.0f, f), -(f3 - f2));
    }

    @Override // p078b.p159f.p160a.p190c.p204h0.AbstractC2033a

    public float mo4615a(int i, float f) {
        if (i != 0) {
            if (i == 2) {
                return m4624a(f, this.f8336c.getWidth(), this.f8337d);
            }
            if (i != 4) {
                if (i == 5) {
                    return m4624a(f, this.f8336c.getHeight(), this.f8338e);
                }
                throw new IllegalArgumentException("Vector not supported");
            }
        }
        return Math.max(Math.min(f, this.f8364f), m4614a());
    }

    @Override // p078b.p159f.p160a.p190c.p204h0.AbstractC2033a

    public void mo4619c() {
        m4620d();
        float[] m4618b = m4618b();
        m4618b[2] = mo4615a(2, m4618b[2]);
        m4618b[5] = mo4615a(5, m4618b[5]);
        this.f8335b.setValues(m4618b);
    }
}
