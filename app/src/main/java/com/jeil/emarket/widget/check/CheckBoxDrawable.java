package com.jeil.emarket.widget.check;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.jeil.emarket.custom.Util;


/* renamed from: b.f.a.c.b0.b */

public class CheckBoxDrawable extends Drawable implements Animatable {


    public static final float[] f8156A = {0.0f, 0.473f, 0.367f, 0.839f, 1.0f, 0.207f};


    public static final float[] f8157B = {0.15f, 0.5f, 0.85f, 0.5f};


    public static TypedValue f8158C;

    /* renamed from: f */
    public long f8163f;

    /* renamed from: g */
    public float f8164g;

    /* renamed from: h */
    public int f8165h;

   
    public int f8167j;

    
    public int f8168k;

    /* renamed from: l */
    public int f8169l;

    /* renamed from: m */
    public int f8170m;

    /* renamed from: n */
    public int f8171n;

    /* renamed from: o */
    public int f8172o;

    /* renamed from: p */
    public int f8173p;

    /* renamed from: q */
    public int f8174q;

    /* renamed from: r */
    public ColorStateList f8175r;

    /* renamed from: s */
    public RectF f8176s;

    /* renamed from: t */
    public Path f8177t;

    /* renamed from: v */
    public Path f8179v;


    public boolean f8159b = false;


    public boolean f8160c = false;


    public boolean f8161d = false;

    
    public final Runnable f8166i = new Runnable() { // from class: b.f.a.c.b0.a
        @Override // java.lang.Runnable
        public final void run() {
            CheckBoxDrawable.this.m4572a();
        }
    };

    /* renamed from: u */
    public float f8178u = -1.0f;

    /* renamed from: w */
    public float f8180w = -1.0f;

    /* renamed from: x */
    public int f8181x = 6;

    /* renamed from: y */
    public boolean f8182y = false;

    /* renamed from: z */
    public boolean f8183z = true;


    public Paint f8162e = new Paint();

    /* renamed from: b.f.a.c.b0.b$b */
    public static class SetStyle {


        public int f8184a;


        public int f8185b;


        public int f8186c;


        public int f8187d;


        public ColorStateList f8188e;

        /* renamed from: f */
        public int f8189f;

        /* renamed from: g */
        public int f8190g;

        /* renamed from: h */
        public int f8191h;

        public SetStyle(Context context, AttributeSet attributeSet) {
            this.f8184a = 400;
            this.f8185b = 4;
            this.f8186c = 64;
            this.f8187d = 64;
            this.f8189f = 8;
            this.f8190g = 32;
            this.f8191h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckBoxDrawable);
            this.f8186c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CheckBoxDrawable_bd_width, Util.dp2px(context, 32));
            this.f8187d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CheckBoxDrawable_bd_height, Util.dp2px(context, 32));
            this.f8190g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CheckBoxDrawable_bd_boxSize, Util.dp2px(context, 18));
            this.f8189f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CheckBoxDrawable_bd_cornerRadius, Util.dp2px(context, 2));
            this.f8185b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CheckBoxDrawable_bd_strokeSize, Util.dp2px(context, 2));
            this.f8188e = obtainStyledAttributes.getColorStateList(R.styleable.CheckBoxDrawable_bd_strokeColor);
            this.f8191h = obtainStyledAttributes.getColor(R.styleable.CheckBoxDrawable_bd_tickColor, -1);
            this.f8184a = obtainStyledAttributes.getInt(R.styleable.CheckBoxDrawable_bd_animDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime));
            obtainStyledAttributes.recycle();
            if (this.f8188e == null) {
                this.f8188e = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{-16842910}, new int[]{android.R.attr.state_checked}}, new int[]{CheckBoxDrawable.m4569a(context, android.R.attr.colorControlNormal, -5592406), CheckBoxDrawable.m4569a(context,android.R.attr.colorControlNormal, -5592406), CheckBoxDrawable.m4569a(context, android.R.attr.colorControlActivated, -5592406)});
            }
        }


        public CheckBoxDrawable m4574a() {
            if (this.f8188e == null) {
                this.f8188e = ColorStateList.valueOf(-5592406);
            }
            return new CheckBoxDrawable(this.f8186c, this.f8187d, this.f8190g, this.f8189f, this.f8185b, this.f8188e, this.f8191h, this.f8184a);
        }
    }

    public  CheckBoxDrawable(int i, int i2, int i3, int i4, int i5, ColorStateList colorStateList, int i6, int i7) {
        this.f8168k = i;
        this.f8169l = i2;
        this.f8171n = i3;
        this.f8170m = i4;
        this.f8167j = i5;
        this.f8175r = colorStateList;
        this.f8172o = i6;
        this.f8165h = i7;
        this.f8162e.setAntiAlias(true);
        this.f8176s = new RectF();
        this.f8177t = new Path();
        this.f8179v = new Path();
    }


    public static int m4568a(int i, int i2, float f) {
        return i == i2 ? i2 : f == 0.0f ? i : f == 1.0f ? i2 : Color.argb(m4570b(Color.alpha(i), Color.alpha(i2), f), m4570b(Color.red(i), Color.red(i2), f), m4570b(Color.green(i), Color.green(i2), f), m4570b(Color.blue(i), Color.blue(i2), f));
    }


    public static int m4569a(Context context, int i, int i2) {
        if (f8158C == null) {
            f8158C = new TypedValue();
        }
        try {
            Resources.Theme theme = context.getTheme();
            if (theme != null && theme.resolveAttribute(i, f8158C, true)) {
                if (f8158C.type >= 16 && f8158C.type <= 31) {
                    return f8158C.data;
                }
                if (f8158C.type == 3) {
                    return context.getResources().getColor(f8158C.resourceId);
                }
            }
        } catch (Exception unused) {
        }
        return i2;
    }


    public static int m4570b(int i, int i2, float f) {
        return Math.round(((i2 - i) * f) + i);
    }


    public final Path m4571a(Path path, float f, float f2, float f3, float f4, boolean z) {
        float f5;
        float f6;
        float f7;
        if (this.f8180w == f4) {
            return path;
        }
        this.f8180w = f4;
        float[] fArr = f8157B;
        float f8 = (fArr[0] * f3) + f;
        float f9 = (fArr[1] * f3) + f2;
        float f10 = (fArr[2] * f3) + f;
        float f11 = (f3 * fArr[3]) + f2;
        path.reset();
        float sqrt = f4 / ((float) Math.sqrt(Math.pow(f9 - f11, 2.0d) + Math.pow(f8 - f10, 2.0d)));
        if (z) {
            path.moveTo(f8, f9);
            float f12 = 1.0f - sqrt;
            f5 = (f10 * f12) + (f8 * sqrt);
            f6 = f9 * sqrt;
            f7 = f11 * f12;
        } else {
            path.moveTo(f10, f11);
            float f13 = 1.0f - sqrt;
            f5 = (f10 * sqrt) + (f8 * f13);
            f6 = f9 * f13;
            f7 = f11 * sqrt;
        }
        path.lineTo(f5, f7 + f6);
        return path;
    }


    public  void m4572a() {
        this.f8164g = Math.min(1.0f, (SystemClock.uptimeMillis() - this.f8163f) / this.f8165h);
        if (this.f8164g == 1.0f) {
            stop();
        }
        if (this.f8161d) {
            scheduleSelf(this.f8166i, SystemClock.uptimeMillis() + 16);
        }
        invalidateSelf();
    }


    public final Path m4573b(Path path, float f, float f2, float f3, float f4, boolean z) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        if (this.f8178u == f4) {
            return path;
        }
        this.f8178u = f4;
        float[] fArr = f8156A;
        float f13 = (fArr[0] * f3) + f;
        float f14 = (fArr[1] * f3) + f2;
        float f15 = (fArr[2] * f3) + f;
        float f16 = (fArr[3] * f3) + f2;
        float f17 = (fArr[4] * f3) + f;
        float f18 = (fArr[5] * f3) + f2;
        float sqrt = (float) Math.sqrt(Math.pow(f14 - f16, 2.0d) + Math.pow(f13 - f15, 2.0d));
        float sqrt2 = sqrt / (((float) Math.sqrt(Math.pow(f16 - f18, 2.0d) + Math.pow(f15 - f17, 2.0d))) + sqrt);
        path.reset();
        if (z) {
            path.moveTo(f13, f14);
            if (f4 < sqrt2) {
                float f19 = f4 / sqrt2;
                float f20 = 1.0f - f19;
                f10 = (f15 * f19) + (f13 * f20);
                f11 = f14 * f20;
                f12 = f16 * f19;
                path.lineTo(f10, f12 + f11);
            } else {
                f6 = (f4 - sqrt2) / (1.0f - sqrt2);
                f5 = f16;
                path.lineTo(f15, f5);
                f7 = 1.0f - f6;
                f8 = f15 * f7;
                f9 = f17 * f6;
                path.lineTo(f9 + f8, (f18 * f6) + (f7 * f5));
            }
        } else {
            f5 = f16;
            path.moveTo(f17, f18);
            if (f4 < sqrt2) {
                float f21 = f4 / sqrt2;
                path.lineTo(f15, f5);
                float f22 = 1.0f - f21;
                f10 = (f15 * f21) + (f13 * f22);
                f11 = f14 * f22;
                f12 = f5 * f21;
                path.lineTo(f10, f12 + f11);
            } else {
                f6 = (f4 - sqrt2) / (1.0f - sqrt2);
                f7 = 1.0f - f6;
                f8 = f15 * f7;
                f9 = f17 * f6;
                path.lineTo(f9 + f8, (f18 * f6) + (f7 * f5));
            }
        }
        return path;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path;
        float f;
        Path path2;
        float f2;
        if (!this.f8159b) {
            int r5 = 0;
            if (this.f8160c) {
                if (this.f8161d) {
                    float f3 = this.f8164g;
                    if (f3 < 0.6f) {
                        int i = this.f8171n;
                        int i2 = this.f8167j;
                        int i3 = this.f8181x;
                        float f4 = (i - (i2 * 2)) - i3;
                        RectF rectF = this.f8176s;
                        float f5 = i2;
                        float f6 = i3 / 2.0f;
                        float f7 = f6 + rectF.left + f5;
                        float f8 = f6 + rectF.top + f5;
                        float f9 = f3 / 0.6f;
                        this.f8162e.setColor(this.f8173p);
                        this.f8162e.setStrokeWidth(this.f8167j);
                        this.f8162e.setStyle(Paint.Style.FILL_AND_STROKE);
                        RectF rectF2 = this.f8176s;
                        float f10 = this.f8170m;
                        canvas.drawRoundRect(rectF2, f10, f10, this.f8162e);
                        this.f8162e.setStyle(Paint.Style.STROKE);
                        this.f8162e.setColor(this.f8172o);
                        Path path3 = this.f8179v;
                        m4571a(path3, f7, f8, f4, f9, false);
                        canvas.drawPath(path3, this.f8162e);
                        return;
                    }
                    float f11 = ((f3 + 0.4f) - 1.0f) / 0.4f;
                    int i4 = this.f8171n;
                    float f12 = (1.0f - f11) * ((i4 - r5) / 2.0f);
                    float f13 = ((f12 / 2.0f) + (this.f8167j / 2.0f)) - 0.5f;
                    this.f8162e.setColor(m4568a(this.f8173p, this.f8174q, f11));
                    this.f8162e.setStrokeWidth(f12);
                    this.f8162e.setStyle(Paint.Style.STROKE);
                    RectF rectF3 = this.f8176s;
                    canvas.drawRect(rectF3.left + f13, rectF3.top + f13, rectF3.right - f13, rectF3.bottom - f13, this.f8162e);
                    this.f8162e.setStrokeWidth(this.f8167j);
                } else {
                    this.f8162e.setColor(this.f8174q);
                    this.f8162e.setStrokeWidth(this.f8167j);
                    this.f8162e.setStyle(Paint.Style.STROKE);
                }
                RectF rectF4 = this.f8176s;
                float f14 = this.f8170m;
                canvas.drawRoundRect(rectF4, f14, f14, this.f8162e);
                return;
            }
            if (this.f8161d) {
                float f15 = this.f8164g;
                if (f15 < 0.6f) {
                    int i5 = this.f8171n;
                    int i6 = this.f8167j;
                    int i7 = this.f8181x;
                    float f16 = (i5 - (i6 * 2)) - i7;
                    RectF rectF5 = this.f8176s;
                    float f17 = i6;
                    float f18 = i7 / 2.0f;
                    float f19 = f18 + rectF5.left + f17;
                    float f20 = f18 + rectF5.top + f17;
                    float f21 = f15 / 0.6f;
                    this.f8162e.setColor(this.f8173p);
                    this.f8162e.setStrokeWidth(this.f8167j);
                    this.f8162e.setStyle(Paint.Style.FILL_AND_STROKE);
                    RectF rectF6 = this.f8176s;
                    float f22 = this.f8170m;
                    canvas.drawRoundRect(rectF6, f22, f22, this.f8162e);
                    this.f8162e.setStyle(Paint.Style.STROKE);
                    this.f8162e.setColor(this.f8172o);
                    Path path4 = this.f8177t;
                    m4573b(path4, f19, f20, f16, f21, false);
                    canvas.drawPath(path4, this.f8162e);
                    return;
                }
                float f23 = ((f15 + 0.4f) - 1.0f) / 0.4f;
                int i8 = this.f8171n;
                float f24 = (1.0f - f23) * ((i8 - r5) / 2.0f);
                float f25 = ((f24 / 2.0f) + (this.f8167j / 2.0f)) - 0.5f;
                this.f8162e.setColor(m4568a(this.f8173p, this.f8174q, f23));
                this.f8162e.setStrokeWidth(f24);
                this.f8162e.setStyle(Paint.Style.STROKE);
                RectF rectF7 = this.f8176s;
                canvas.drawRect(rectF7.left + f25, rectF7.top + f25, rectF7.right - f25, rectF7.bottom - f25, this.f8162e);
                this.f8162e.setStrokeWidth(this.f8167j);
            } else {
                this.f8162e.setColor(this.f8174q);
                this.f8162e.setStrokeWidth(this.f8167j);
                this.f8162e.setStyle(Paint.Style.STROKE);
            }
            RectF rectF8 = this.f8176s;
            float f26 = this.f8170m;
            canvas.drawRoundRect(rectF8, f26, f26, this.f8162e);
            return;
        }
        if (this.f8160c) {
            int i9 = this.f8171n;
            int i10 = this.f8167j;
            int i11 = this.f8181x;
            float f27 = (i9 - (i10 * 2)) - i11;
            RectF rectF9 = this.f8176s;
            float f28 = i10;
            float f29 = i11 / 2.0f;
            float f30 = rectF9.left + f28 + f29;
            float f31 = f29 + rectF9.top + f28;
            if (this.f8161d) {
                float f32 = this.f8164g;
                if (f32 < 0.4f) {
                    float f33 = f32 / 0.4f;
                    float f34 = ((i9 - i10) / 2.0f) * f33;
                    float f35 = ((f34 / 2.0f) + (f28 / 2.0f)) - 0.5f;
                    this.f8162e.setColor(m4568a(this.f8173p, this.f8174q, f33));
                    this.f8162e.setStrokeWidth(f34);
                    this.f8162e.setStyle(Paint.Style.STROKE);
                    RectF rectF10 = this.f8176s;
                    canvas.drawRect(rectF10.left + f35, rectF10.top + f35, rectF10.right - f35, rectF10.bottom - f35, this.f8162e);
                    this.f8162e.setStrokeWidth(this.f8167j);
                    RectF rectF11 = this.f8176s;
                    float f36 = this.f8170m;
                    canvas.drawRoundRect(rectF11, f36, f36, this.f8162e);
                    return;
                }
                this.f8162e.setColor(this.f8174q);
                this.f8162e.setStrokeWidth(this.f8167j);
                this.f8162e.setStyle(Paint.Style.FILL_AND_STROKE);
                RectF rectF12 = this.f8176s;
                float f37 = this.f8170m;
                canvas.drawRoundRect(rectF12, f37, f37, this.f8162e);
                this.f8162e.setStyle(Paint.Style.STROKE);
                this.f8162e.setColor(this.f8172o);
                path2 = this.f8179v;
                f2 = (f32 - 0.4f) / 0.6f;
            } else {
                this.f8162e.setColor(this.f8174q);
                this.f8162e.setStrokeWidth(this.f8167j);
                this.f8162e.setStyle(Paint.Style.FILL_AND_STROKE);
                RectF rectF13 = this.f8176s;
                float f38 = this.f8170m;
                canvas.drawRoundRect(rectF13, f38, f38, this.f8162e);
                this.f8162e.setStyle(Paint.Style.STROKE);
                this.f8162e.setColor(this.f8172o);
                path2 = this.f8179v;
                f2 = 1.0f;
            }
            m4571a(path2, f30, f31, f27, f2, true);
            canvas.drawPath(path2, this.f8162e);
            return;
        }
        int i12 = this.f8171n;
        int i13 = this.f8167j;
        int i14 = this.f8181x;
        float f39 = (i12 - (i13 * 2)) - i14;
        RectF rectF14 = this.f8176s;
        float f40 = i13;
        float f41 = i14 / 2.0f;
        float f42 = rectF14.left + f40 + f41;
        float f43 = f41 + rectF14.top + f40;
        if (this.f8161d) {
            float f44 = this.f8164g;
            if (f44 < 0.4f) {
                float f45 = ((i12 - i13) / 2.0f) * (f44 / 0.4f);
                float f46 = ((f45 / 2.0f) + (f40 / 2.0f)) - 0.5f;
                this.f8162e.setColor(this.f8174q);
                this.f8162e.setStrokeWidth(f45);
                this.f8162e.setStyle(Paint.Style.STROKE);
                RectF rectF15 = this.f8176s;
                canvas.drawRect(rectF15.left + f46, rectF15.top + f46, rectF15.right - f46, rectF15.bottom - f46, this.f8162e);
                this.f8162e.setStrokeWidth(this.f8167j);
                RectF rectF16 = this.f8176s;
                float f47 = this.f8170m;
                canvas.drawRoundRect(rectF16, f47, f47, this.f8162e);
                return;
            }
            this.f8162e.setColor(this.f8174q);
            this.f8162e.setStrokeWidth(this.f8167j);
            this.f8162e.setStyle(Paint.Style.FILL_AND_STROKE);
            RectF rectF17 = this.f8176s;
            float f48 = this.f8170m;
            canvas.drawRoundRect(rectF17, f48, f48, this.f8162e);
            this.f8162e.setStyle(Paint.Style.STROKE);
            this.f8162e.setColor(this.f8172o);
            path = this.f8177t;
            f = (f44 - 0.4f) / 0.6f;
        } else {
            this.f8162e.setColor(this.f8174q);
            this.f8162e.setStrokeWidth(this.f8167j);
            this.f8162e.setStyle(Paint.Style.FILL_AND_STROKE);
            RectF rectF18 = this.f8176s;
            float f49 = this.f8170m;
            canvas.drawRoundRect(rectF18, f49, f49, this.f8162e);
            this.f8162e.setStyle(Paint.Style.STROKE);
            this.f8162e.setColor(this.f8172o);
            path = this.f8177t;
            f = 1.0f;
        }
        m4573b(path, f42, f43, f39, f, true);
        canvas.drawPath(path, this.f8162e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f8169l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f8168k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f8169l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f8168k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f8161d;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f8176s.set(rect.exactCenterX() - (this.f8171n / 2.0f), rect.exactCenterY() - (this.f8171n / 2.0f), (this.f8171n / 2.0f) + rect.exactCenterX(), (this.f8171n / 2.0f) + rect.exactCenterY());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z;
        boolean z2 = false;
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 16842912) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        int colorForState = this.f8175r.getColorForState(iArr, this.f8174q);
        if (this.f8159b != z) {
            this.f8159b = z;
            if (!this.f8182y && this.f8183z) {
                start();
            }
            z2 = true;
        }
        int i2 = this.f8174q;
        if (i2 == colorForState) {
            if (this.f8161d) {
                return z2;
            }
            this.f8173p = colorForState;
            return z2;
        }
        if (!this.f8161d) {
            i2 = colorForState;
        }
        this.f8173p = i2;
        this.f8174q = colorForState;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        this.f8161d = true;
        super.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f8162e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f8162e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f8163f = SystemClock.uptimeMillis();
        this.f8164g = 0.0f;
        scheduleSelf(this.f8166i, SystemClock.uptimeMillis() + 16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f8161d = false;
        unscheduleSelf(this.f8166i);
        invalidateSelf();
    }
}
