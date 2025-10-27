package com.anievaluate.ani.transAni;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: b.g.c.b.a */
/* loaded from: classes.dex */
public final class TransAni extends Animation {

    /* renamed from: r */
    public static final boolean f10697r;

    /* renamed from: s */
    public static final WeakHashMap<View, TransAni> f10698s;

    /* renamed from: b */
    public final WeakReference<View> f10699b;

    /* renamed from: d */
    public boolean f10701d;

    /* renamed from: f */
    public float f10703f;

    /* renamed from: g */
    public float f10704g;

    /* renamed from: h */
    public float f10705h;

    
    public float f10706i;

   
    public float f10707j;

    /* renamed from: m */
    public float f10710m;

    /* renamed from: n */
    public float f10711n;

    /* renamed from: c */
    public final Camera f10700c = new Camera();

    
    public float f10702e = 1.0f;

    
    public float f10708k = 1.0f;

    /* renamed from: l */
    public float f10709l = 1.0f;

    /* renamed from: o */
    public final RectF f10712o = new RectF();

    /* renamed from: p */
    public final RectF f10713p = new RectF();

    /* renamed from: q */
    public final Matrix f10714q = new Matrix();

    static {
        f10697r = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f10698s = new WeakHashMap<>();
    }

    public TransAni(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f10699b = new WeakReference<>(view);
    }

    /* renamed from: a */
    public static TransAni m5828a(View view) {
        TransAni transAni = f10698s.get(view);
        if (transAni != null && transAni == view.getAnimation()) {
            return transAni;
        }
        TransAni transAni2 = new TransAni(view);
        f10698s.put(view, transAni2);
        return transAni2;
    }

    /* renamed from: a */
    public final void m5829a() {
        View view = this.f10699b.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f10713p;
        m5832a(rectF, view);
        rectF.union(this.f10712o);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* renamed from: a */
    public void m5830a(float f) {
        if (this.f10710m != f) {
            m5833b();
            this.f10710m = f;
            m5829a();
        }
    }

    /* renamed from: a */
    public final void m5831a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.f10701d;
        float f = z ? this.f10703f : width / 2.0f;
        float f2 = z ? this.f10704g : height / 2.0f;
        float f3 = this.f10705h;
        float f4 = this.f10706i;
        float f5 = this.f10707j;
        if (f3 != 0.0f || f4 != 0.0f || f5 != 0.0f) {
            Camera camera = this.f10700c;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.f10708k;
        float f7 = this.f10709l;
        if (f6 != 1.0f || f7 != 1.0f) {
            matrix.postScale(f6, f7);
            matrix.postTranslate(((f6 * width) - width) * (-(f / width)), ((f7 * height) - height) * (-(f2 / height)));
        }
        matrix.postTranslate(this.f10710m, this.f10711n);
    }

    /* renamed from: a */
    public final void m5832a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f10714q;
        matrix.reset();
        m5831a(matrix, view);
        this.f10714q.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f = rectF.right;
        float f2 = rectF.left;
        if (f < f2) {
            rectF.right = f2;
            rectF.left = f;
        }
        float f3 = rectF.bottom;
        float f4 = rectF.top;
        if (f3 < f4) {
            rectF.top = f3;
            rectF.bottom = f4;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        View view = this.f10699b.get();
        if (view != null) {
            transformation.setAlpha(this.f10702e);
            m5831a(transformation.getMatrix(), view);
        }
    }

    /* renamed from: b */
    public final void m5833b() {
        View view = this.f10699b.get();
        if (view != null) {
            m5832a(this.f10712o, view);
        }
    }

    /* renamed from: b */
    public void m5834b(float f) {
        if (this.f10711n != f) {
            m5833b();
            this.f10711n = f;
            m5829a();
        }
    }

    /* renamed from: c */
    public void m5835c(float f) {
        if (this.f10699b.get() != null) {
            float left = f - this.f10699b.get().getLeft();
            if (this.f10710m != left) {
                m5833b();
                this.f10710m = left;
                m5829a();
            }
        }
    }

    /* renamed from: d */
    public void m5836d(float f) {
        if (this.f10699b.get() != null) {
            float top = f - this.f10699b.get().getTop();
            if (this.f10711n != top) {
                m5833b();
                this.f10711n = top;
                m5829a();
            }
        }
    }
}
