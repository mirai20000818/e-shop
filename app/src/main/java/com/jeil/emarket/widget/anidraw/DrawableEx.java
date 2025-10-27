package com.jeil.emarket.widget.anidraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.CustomString;

/* renamed from: b.f.a.c.k0.g */

public class DrawableEx extends Drawable implements Animatable {

    
    public static final Interpolator f8454k = new LinearInterpolator();

    /* renamed from: l */
    public static final Interpolator f8455l;

    /* renamed from: m */
    public static final Interpolator f8456m;

    
    public final ArrayList<Animation> f8457b = new ArrayList<>();

    
    public final c f8458c = new c(new a());

    
    public boolean f8459d;

    
    public float f8460e;

    /* renamed from: f */
    public Resources f8461f;

    /* renamed from: g */
    public View f8462g;

    /* renamed from: h */
    public Animation f8463h;

    
    public double f8464i;

   
    public double f8465j;

    /* renamed from: b.f.a.c.k0.g$a */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            DrawableEx.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            DrawableEx.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            DrawableEx.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: b.f.a.c.k0.g$b */
    public static class b extends AccelerateDecelerateInterpolator {
        public  b(a aVar) {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }
    }

    /* renamed from: b.f.a.c.k0.g$c */
    public static class c {

        
        public final Drawable.Callback f8469c;

        
        public float f8471e;

        /* renamed from: g */
        public float f8473g;

        
        public float f8475i;

        /* renamed from: l */
        public double f8478l;

        /* renamed from: m */
        public int f8479m;

        /* renamed from: n */
        public int f8480n;

        /* renamed from: o */
        public int f8481o;


        public final Paint f8467a = new Paint();

        
        public final Paint f8468b = new Paint();

        
        public float f8470d = 0.0f;

        /* renamed from: f */
        public float f8472f = 0.0f;

        /* renamed from: h */
        public float f8474h = 0.0f;

       
        public float f8476j = 5.0f;

        
        public float f8477k = 2.5f;

        public c(Drawable.Callback callback) {
            this.f8469c = callback;
            this.f8467a.setStrokeCap(Paint.Cap.SQUARE);
            this.f8467a.setAntiAlias(true);
            this.f8467a.setStyle(Paint.Style.STROKE);
        }


        public final void m4660a() {
            this.f8469c.invalidateDrawable(null);
        }


        public void m4661a(Canvas canvas, Rect rect) {
            RectF rectF = new RectF();
            rectF.set(rect);
            float f = this.f8477k;
            rectF.inset(f, f);
            float f2 = this.f8470d;
            float f3 = this.f8474h;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.f8472f + f3) * 360.0f) - f4;
            this.f8467a.setColor(this.f8479m);
            canvas.drawArc(rectF, f4, f5, false, this.f8467a);
            if (this.f8480n < 255) {
                this.f8468b.setColor(this.f8481o);
                this.f8468b.setAlpha(255 - this.f8480n);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2.0f, this.f8468b);
            }
        }

        
        public void m4662b() {
            this.f8471e = 0.0f;
            this.f8473g = 0.0f;
            this.f8475i = 0.0f;
            this.f8470d = 0.0f;
            m4660a();
            this.f8472f = 0.0f;
            m4660a();
            this.f8474h = 0.0f;
            m4660a();
        }
    }

    /* renamed from: b.f.a.c.k0.g$d */
    public static class d extends AccelerateDecelerateInterpolator {
        public  d(a aVar) {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, f * 2.0f));
        }
    }

    static {
        a aVar = null;
        f8455l = new b(aVar);
        f8456m = new d(aVar);
    }

    public DrawableEx(Context context, View view) {
        this.f8462g = view;
        this.f8461f = context.getResources();
        this.f8458c.f8479m = this.f8461f.getColor(BaseActivity.color);
        c cVar = this.f8458c;
        float f = this.f8461f.getDisplayMetrics().density;
        double d2 = f;
        double d3 = 40.0d * d2;
        this.f8464i = d3;
        this.f8465j = d3;
        float f2 = f * 2.5f;
        cVar.f8476j = f2;
        cVar.f8467a.setStrokeWidth(f2);
        cVar.m4660a();
        cVar.f8478l = d2 * 8.75d;
        float min = Math.min((int) this.f8464i, (int) this.f8465j);
        double d4 = cVar.f8478l;
        cVar.f8477k = (float) ((d4 <= 0.0d || min < 0.0f) ? Math.ceil(cVar.f8476j / 2.0f) : (min / 2.0f) - d4);
        c cVar2 = this.f8458c;
        AnimationEx animationEx = new AnimationEx(this, cVar2);
        animationEx.setRepeatCount(-1);
        animationEx.setRepeatMode(1);
        animationEx.setInterpolator(f8454k);
        animationEx.setAnimationListener(new AnimationAnimationListener(this, cVar2));
        this.f8463h = animationEx;
    }


    public final void m4659a(float f, c cVar) {
        float floor = (float) (Math.floor(cVar.f8475i / 0.8f) + 1.0d);
        float f2 = cVar.f8471e;
        cVar.f8470d = CustomString.m3148a(cVar.f8473g, f2, f, f2);
        cVar.m4660a();
        float f3 = cVar.f8475i;
        cVar.f8474h = CustomString.m3148a(floor, f3, f, f3);
        cVar.m4660a();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f8460e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f8458c.m4661a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f8458c.f8480n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f8465j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f8464i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f8457b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f8458c.f8480n = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f8458c;
        cVar.f8467a.setColorFilter(colorFilter);
        cVar.m4660a();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Animation animation;
        long j;
        this.f8463h.reset();
        c cVar = this.f8458c;
        float f = cVar.f8470d;
        cVar.f8471e = f;
        float f2 = cVar.f8472f;
        cVar.f8473g = f2;
        cVar.f8475i = cVar.f8474h;
        if (f2 != f) {
            this.f8459d = true;
            animation = this.f8463h;
            j = 666;
        } else {
            cVar.m4662b();
            animation = this.f8463h;
            j = 1333;
        }
        animation.setDuration(j);
        this.f8462g.startAnimation(this.f8463h);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f8462g.clearAnimation();
        this.f8460e = 0.0f;
        invalidateSelf();
        this.f8458c.m4662b();
    }
}
