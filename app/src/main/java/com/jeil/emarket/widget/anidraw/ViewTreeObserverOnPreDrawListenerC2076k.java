package com.jeil.emarket.widget.anidraw;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;

import com.jeil.emarket.custom.CustomString;

/* renamed from: b.f.a.c.k0.k */

public class ViewTreeObserverOnPreDrawListenerC2076k extends View implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: u */
    public static final float[][] f8487u = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};

    /* renamed from: v */
    public static final float[][] f8488v = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};

    /* renamed from: w */
    public static final float[][] f8489w = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};


    public float f8490b;


    public ValueAnimator f8491c;


    public ValueAnimator f8492d;


    public ValueAnimator f8493e;

    /* renamed from: f */
    public ValueAnimator f8494f;

    /* renamed from: g */
    public ValueAnimator f8495g;

    /* renamed from: h */
    public float f8496h;

    
    public Paint f8497i;

   
    public Path f8498j;

    
    public Path f8499k;

    /* renamed from: l */
    public Path f8500l;

    /* renamed from: m */
    public Paint f8501m;

    /* renamed from: n */
    public Path f8502n;

    /* renamed from: o */
    public RectF f8503o;

    /* renamed from: p */
    public int f8504p;

    /* renamed from: q */
    public int f8505q;

    /* renamed from: r */
    public boolean f8506r;

    /* renamed from: s */
    public ValueAnimator f8507s;

    /* renamed from: t */
    public ValueAnimator.AnimatorUpdateListener f8508t;

    /* renamed from: b.f.a.c.k0.k$a */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewTreeObserverOnPreDrawListenerC2076k.this.m4675e();
            ViewTreeObserverOnPreDrawListenerC2076k.this.f8506r = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ViewTreeObserverOnPreDrawListenerC2076k(Context context) {
        super(context);
        this.f8496h = 100.0f;
        this.f8506r = false;
        this.f8508t = new ValueAnimator.AnimatorUpdateListener() { // from class: b.f.a.c.k0.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewTreeObserverOnPreDrawListenerC2076k.this.m4668a(valueAnimator);
            }
        };
        getViewTreeObserver().addOnPreDrawListener(this);
        this.f8497i = new Paint();
        this.f8497i.setColor(-1);
        this.f8497i.setAntiAlias(true);
        this.f8497i.setStyle(Paint.Style.FILL);
        this.f8501m = new Paint();
        this.f8501m.setAntiAlias(true);
        this.f8501m.setShadowLayer(10.0f, 0.0f, 0.0f, 570425344);
        this.f8498j = new Path();
        this.f8499k = new Path();
        this.f8500l = new Path();
        this.f8502n = new Path();
        m4675e();
        this.f8503o = new RectF();
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }


    public void m4664a() {
        if (this.f8495g.isRunning()) {
            return;
        }
        m4677g();
        m4669b(0.1f);
    }


    public void m4665a(float f) {
        m4674d();
        this.f8498j.moveTo(0.0f, 0.0f);
        Path path = this.f8498j;
        int i = this.f8504p;
        float[][] fArr = f8487u;
        path.cubicTo(i * fArr[0][0], fArr[0][1], i * fArr[1][0], i * (fArr[1][1] + f), i * fArr[2][0], (fArr[2][1] + f) * i);
        Path path2 = this.f8498j;
        int i2 = this.f8504p;
        float[][] fArr2 = f8487u;
        path2.cubicTo(i2 * fArr2[3][0], (fArr2[3][1] + f) * i2, i2 * fArr2[4][0], (fArr2[4][1] + f) * i2, i2 * fArr2[5][0], (fArr2[5][1] + f) * i2);
        Path path3 = this.f8498j;
        int i3 = this.f8504p;
        float[][] fArr3 = f8487u;
        path3.cubicTo(i3 - (i3 * fArr3[4][0]), (fArr3[4][1] + f) * i3, i3 - (i3 * fArr3[3][0]), (fArr3[3][1] + f) * i3, i3 - (i3 * fArr3[2][0]), (fArr3[2][1] + f) * i3);
        Path path4 = this.f8498j;
        int i4 = this.f8504p;
        float[][] fArr4 = f8487u;
        path4.cubicTo(i4 - (i4 * fArr4[1][0]), i4 * (fArr4[1][1] + f), i4 - (i4 * fArr4[0][0]), fArr4[0][1], i4, 0.0f);
       // ViewCompat.m1260G(this);
    }


    public void m4666a(float f, float f2) {
        m4674d();
        this.f8498j.moveTo(0.0f, 0.0f);
        Path path = this.f8498j;
        int i = this.f8504p;
        float[][] fArr = f8488v;
        path.cubicTo(i * fArr[0][0], i * fArr[0][1], Math.min(f8487u[1][0] + f2, fArr[1][0]) * i, Math.max((f8487u[1][1] + f) - f2, f8488v[1][1]) * this.f8504p, Math.max(f8487u[2][0] - f2, f8488v[2][0]) * this.f8504p, Math.max((f8487u[2][1] + f) - f2, f8488v[2][1]) * this.f8504p);
        Path path2 = this.f8498j;
        float max = Math.max(f8487u[3][0] - f2, f8488v[3][0]) * this.f8504p;
        float min = Math.min(f8487u[3][1] + f + f2, f8488v[3][1]) * this.f8504p;
        float max2 = Math.max(f8487u[4][0] - f2, f8488v[4][0]) * this.f8504p;
        float min2 = Math.min(f8487u[4][1] + f + f2, f8488v[4][1]) * this.f8504p;
        int i2 = this.f8504p;
        float[][] fArr2 = f8488v;
        path2.cubicTo(max, min, max2, min2, i2 * fArr2[5][0], Math.min(f8487u[0][1] + f + f2, fArr2[5][1]) * i2);
        Path path3 = this.f8498j;
        int i3 = this.f8504p;
        float max3 = i3 - (Math.max(f8487u[4][0] - f2, f8488v[4][0]) * i3);
        float min3 = Math.min(f8487u[4][1] + f + f2, f8488v[4][1]) * this.f8504p;
        int i4 = this.f8504p;
        float max4 = i4 - (Math.max(f8487u[3][0] - f2, f8488v[3][0]) * i4);
        float min4 = Math.min(f8487u[3][1] + f + f2, f8488v[3][1]) * this.f8504p;
        int i5 = this.f8504p;
        path3.cubicTo(max3, min3, max4, min4, i5 - (Math.max(f8487u[2][0] - f2, f8488v[2][0]) * i5), Math.max((f8487u[2][1] + f) - f2, f8488v[2][1]) * this.f8504p);
        Path path4 = this.f8498j;
        int i6 = this.f8504p;
        float min5 = i6 - (Math.min(f8487u[1][0] + f2, f8488v[1][0]) * i6);
        float max5 = Math.max((f8487u[1][1] + f) - f2, f8488v[1][1]) * this.f8504p;
        int i7 = this.f8504p;
        float[][] fArr3 = f8488v;
        path4.cubicTo(min5, max5, i7 - (i7 * fArr3[0][0]), i7 * fArr3[0][1], i7, 0.0f);
        this.f8490b = (Math.min(f8487u[3][1] + f + f2, f8488v[3][1]) * this.f8504p) + this.f8496h;
       // ViewCompat.m1260G(this);
    }


    public void m4667a(float f, float f2, float f3) {
        m4674d();
        this.f8498j.moveTo(0.0f, 0.0f);
        Path path = this.f8498j;
        int i = this.f8504p;
        float[][] fArr = f8489w;
        path.cubicTo(i * fArr[0][0], i * fArr[0][1], Math.min(Math.min(f8487u[1][0] + f2, f8488v[1][0]) + f3, f8489w[1][0]) * i, Math.max(Math.max((f8487u[1][1] + f) - f2, f8488v[1][1]) - f3, f8489w[1][1]) * this.f8504p, Math.max(f8487u[2][0] - f2, f8489w[2][0]) * this.f8504p, Math.min(Math.max((f8487u[2][1] + f) - f2, f8488v[2][1]) + f3, f8489w[2][1]) * this.f8504p);
        Path path2 = this.f8498j;
        float min = Math.min(Math.max(f8487u[3][0] - f2, f8488v[3][0]) + f3, f8489w[3][0]) * this.f8504p;
        float min2 = Math.min(Math.min(f8487u[3][1] + f + f2, f8488v[3][1]) + f3, f8489w[3][1]) * this.f8504p;
        float max = Math.max(f8487u[4][0] - f2, f8489w[4][0]) * this.f8504p;
        float min3 = Math.min(Math.min(f8487u[4][1] + f + f2, f8488v[4][1]) + f3, f8489w[4][1]) * this.f8504p;
        int i2 = this.f8504p;
        path2.cubicTo(min, min2, max, min3, i2 * f8489w[5][0], Math.min(Math.min(f8487u[0][1] + f + f2, f8488v[5][1]) + f3, f8489w[5][1]) * i2);
        Path path3 = this.f8498j;
        int i3 = this.f8504p;
        float max2 = i3 - (Math.max(f8487u[4][0] - f2, f8489w[4][0]) * i3);
        float min4 = Math.min(Math.min(f8487u[4][1] + f + f2, f8488v[4][1]) + f3, f8489w[4][1]) * this.f8504p;
        int i4 = this.f8504p;
        float min5 = i4 - (Math.min(Math.max(f8487u[3][0] - f2, f8488v[3][0]) + f3, f8489w[3][0]) * i4);
        float min6 = Math.min(Math.min(f8487u[3][1] + f + f2, f8488v[3][1]) + f3, f8489w[3][1]) * this.f8504p;
        int i5 = this.f8504p;
        path3.cubicTo(max2, min4, min5, min6, i5 - (Math.max(f8487u[2][0] - f2, f8489w[2][0]) * i5), Math.min(Math.max((f8487u[2][1] + f) - f2, f8488v[2][1]) + f3, f8489w[2][1]) * this.f8504p);
        Path path4 = this.f8498j;
        int i6 = this.f8504p;
        float min7 = i6 - (Math.min(Math.min(f8487u[1][0] + f2, f8488v[1][0]) + f3, f8489w[1][0]) * i6);
        float max3 = Math.max(Math.max((f8487u[1][1] + f) - f2, f8488v[1][1]) - f3, f8489w[1][1]) * this.f8504p;
        int i7 = this.f8504p;
        float[][] fArr2 = f8489w;
        path4.cubicTo(min7, max3, i7 - (i7 * fArr2[0][0]), i7 * fArr2[0][1], i7, 0.0f);
        this.f8490b = (Math.min(Math.min(f8487u[3][1] + f + f2, f8488v[3][1]) + f3, f8489w[3][1]) * this.f8504p) + this.f8496h;
        //ViewCompat.m1260G(this);
    }


    public  void m4668a(ValueAnimator valueAnimator) {
        postInvalidate();
    }


    public void m4669b(float f) {
        this.f8507s = ValueAnimator.ofFloat(Math.min(f, 0.2f) * this.f8504p, 0.0f);
        this.f8507s.setDuration(1000L);
        this.f8507s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.f.a.c.k0.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewTreeObserverOnPreDrawListenerC2076k.this.m4673c(valueAnimator);
            }
        });
        this.f8507s.setInterpolator(new BounceInterpolator());
        this.f8507s.start();
    }


    public  void m4670b(ValueAnimator valueAnimator) {
        this.f8490b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
       // ViewCompat.m1260G(this);
    }


    public boolean m4671b() {
        return this.f8495g.isRunning();
    }


    public void m4672c() {
        if (this.f8506r) {
            return;
        }
        this.f8506r = true;
        int i = this.f8505q;
        this.f8491c = ValueAnimator.ofFloat(i, i);
        this.f8491c.start();
        int i2 = this.f8505q;
        float f = this.f8496h;
        this.f8492d = ValueAnimator.ofFloat(i2 - f, i2 - f);
        this.f8492d.start();
        this.f8490b = this.f8505q;
        postInvalidate();
    }


    public  void m4673c(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f8498j.moveTo(0.0f, 0.0f);
        Path path = this.f8498j;
        int i = this.f8504p;
        float f = floatValue * 0.5f;
        path.quadTo(i * 0.25f, 0.0f, i * 0.333f, f);
        Path path2 = this.f8498j;
        int i2 = this.f8504p;
        path2.quadTo(i2 * 0.5f, floatValue * 1.4f, i2 * 0.666f, f);
        Path path3 = this.f8498j;
        int i3 = this.f8504p;
        path3.quadTo(i3 * 0.75f, 0.0f, i3, 0.0f);
        postInvalidate();
    }


    public final void m4674d() {
        ValueAnimator valueAnimator = this.f8507s;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f8507s.cancel();
    }


    public final void m4675e() {
        this.f8492d = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f8494f = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f8493e = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f8491c = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.f8491c.start();
        this.f8495g = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f8495g.setDuration(1L);
        this.f8495g.start();
    }

    /* renamed from: f */
    public void m4676f() {
        this.f8495g = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f8495g.addUpdateListener(this.f8508t);
        this.f8495g.setDuration(200L);
        this.f8495g.addListener(new a());
        this.f8495g.start();
    }

    /* renamed from: g */
    public void m4677g() {
        this.f8495g = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f8495g.setDuration(1L);
        this.f8495g.start();
        this.f8491c = ValueAnimator.ofFloat((this.f8504p / 1440.0f) * 500.0f, this.f8505q);
        this.f8491c.setDuration(500L);
        this.f8491c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.f.a.c.k0.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewTreeObserverOnPreDrawListenerC2076k.this.m4670b(valueAnimator);
            }
        });
        this.f8491c.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f8491c.start();
        this.f8492d = ValueAnimator.ofFloat(0.0f, this.f8505q - this.f8496h);
        this.f8492d.setDuration(500L);
        this.f8492d.addUpdateListener(this.f8508t);
        this.f8492d.start();
        this.f8494f = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8494f.setDuration(500L);
        this.f8494f.addUpdateListener(this.f8508t);
        this.f8494f.setInterpolator(new InterpolatorC2071f());
        this.f8494f.setStartDelay(500L);
        this.f8494f.start();
        this.f8493e = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8493e.setDuration(500L);
        this.f8493e.addUpdateListener(this.f8508t);
        this.f8493e.setInterpolator(new InterpolatorC2071f());
        this.f8493e.setStartDelay(625L);
        this.f8493e.start();
    }

    public float getCurrentCircleCenterY() {
        return this.f8490b;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f8495g;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f8495g.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f8491c;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.f8491c.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.f8492d;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.f8492d.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.f8507s;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.f8507s.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.f8493e;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.f8493e.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.f8494f;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.f8494f.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.f8498j, this.f8501m);
        canvas.drawPath(this.f8498j, this.f8497i);
        this.f8498j.rewind();
        this.f8499k.rewind();
        this.f8500l.rewind();
        float floatValue = ((Float) this.f8491c.getAnimatedValue()).floatValue();
        float f = this.f8504p / 2.0f;
        this.f8503o.setEmpty();
        float floatValue2 = ((Float) this.f8495g.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.f8494f.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.f8493e.getAnimatedValue()).floatValue();
        RectF rectF = this.f8503o;
        float f2 = this.f8496h;
        float f3 = floatValue3 + 1.0f;
        float f4 = 1.0f + floatValue4;
        rectF.set(((f2 * floatValue4) / 2.0f) + (f - ((f2 * f3) * floatValue2)), (((f2 * f4) * floatValue2) + floatValue) - ((f2 * floatValue3) / 2.0f), (((f3 * f2) * floatValue2) + f) - ((floatValue4 * f2) / 2.0f), ((f2 * floatValue3) / 2.0f) + (floatValue - ((f4 * f2) * floatValue2)));
        this.f8499k.moveTo(f, ((Float) this.f8492d.getAnimatedValue()).floatValue());
        double d2 = floatValue;
        double pow = 0;//((Math.pow(this.f8496h, 2.0d) + (floatValue * r2)) - Math.pow(d2, 2.0d)) / (r2 - floatValue);
        double d3 = (this.f8504p * (-2.0d)) / 2.0d;
        double sqrt = Math.sqrt((d3 * d3) - (((Math.pow(f, 2.0d) + Math.pow(pow - d2, 2.0d)) - Math.pow(this.f8496h, 2.0d)) * 4.0d));
        double d4 = -d3;
        float f5 = (float) pow;
        this.f8499k.lineTo((float) ((d4 + sqrt) / 2.0d), f5);
        this.f8499k.lineTo((float) ((d4 - sqrt) / 2.0d), f5);
        this.f8499k.close();
        this.f8502n.set(this.f8499k);
        this.f8502n.addOval(this.f8503o, Path.Direction.CCW);
        this.f8500l.addOval(this.f8503o, Path.Direction.CCW);
        canvas.drawPath(this.f8492d.isRunning() ? this.f8502n : this.f8500l, this.f8501m);
        canvas.drawPath(this.f8499k, this.f8497i);
        canvas.drawPath(this.f8500l, this.f8497i);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f8504p = i;
        this.f8496h = i / 14.4f;
        float min = (int) Math.min(Math.min(i, i2), getHeight() - this.f8496h);
        if ((this.f8504p / 1440.0f) * 500.0f > min) {
            StringBuilder m3163a = CustomString.format("DropHeight is more than ");
            m3163a.append((this.f8504p / 1440.0f) * 500.0f);
            Log.w("WaveView", m3163a.toString());
        } else {
            this.f8505q = (int) Math.min(min, getHeight() - this.f8496h);
            if (this.f8506r) {
                this.f8506r = false;
                m4672c();
            }
        }
        super.onSizeChanged(i, i2, i3, i4);
    }
}
