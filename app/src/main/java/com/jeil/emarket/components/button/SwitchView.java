package com.jeil.emarket.components.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;


public class SwitchView extends View {


    public float f12191A;


    public InterfaceC3247b f12192B;


    public int f12193b;


    public int f12194c;

    
    public boolean f12195d;

    
    public int f12196e;

    /* renamed from: f */
    public int f12197f;

    /* renamed from: g */
    public final Paint f12198g;

    /* renamed from: h */
    public final Path f12199h;

    
    public final Path f12200i;

   
    public final RectF f12201j;

    
    public final AccelerateInterpolator f12202k;

    /* renamed from: l */
    public float f12203l;

    /* renamed from: m */
    public float f12204m;

    /* renamed from: n */
    public float f12205n;

    /* renamed from: o */
    public float f12206o;

    /* renamed from: p */
    public float f12207p;

    /* renamed from: q */
    public float f12208q;

    /* renamed from: r */
    public float f12209r;

    /* renamed from: s */
    public float f12210s;

    /* renamed from: t */
    public float f12211t;

    /* renamed from: u */
    public float f12212u;

    /* renamed from: v */
    public float f12213v;

    /* renamed from: w */
    public float f12214w;

    /* renamed from: x */
    public float f12215x;

    /* renamed from: y */
    public float f12216y;

    /* renamed from: z */
    public float f12217z;

    /* renamed from: com.jeil.emarket.components.button.SwitchView$b */
    public interface InterfaceC3247b {

        void mo4371a(SwitchView switchView, boolean z);
    }

    /* renamed from: com.jeil.emarket.components.button.SwitchView$c */
    public static final class C3248c extends View.BaseSavedState {
        public static final Parcelable.Creator<C3248c> CREATOR = new a();


        public boolean f12218b;

        /* renamed from: com.jeil.emarket.components.button.SwitchView$c$a */
        public static class a implements Parcelable.Creator<C3248c> {
            @Override // android.os.Parcelable.Creator
            public C3248c createFromParcel(Parcel parcel) {
                return new C3248c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public C3248c[] newArray(int i) {
                return new C3248c[i];
            }
        }

        public  C3248c(Parcel parcel) {
            super(parcel);
            this.f12218b = 1 == parcel.readInt();
        }

        public C3248c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f12218b ? 1 : 0);
        }
    }

    public SwitchView(Context context) {
        this(context, null);
    }

    public SwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12193b = 1;
        this.f12194c = this.f12193b;
        this.f12195d = false;
        this.f12196e = -11282583;
        this.f12197f = -1842205;
        this.f12198g = new Paint();
        this.f12199h = new Path();
        this.f12200i = new Path();
        this.f12201j = new RectF();
        this.f12202k = new AccelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SwitchView);
        try {
            this.f12196e = obtainStyledAttributes.getColor(R.styleable.SwitchView_color_on, -11282583);
            this.f12197f = obtainStyledAttributes.getColor(R.styleable.SwitchView_color_off, -1842205);
            this.f12195d = obtainStyledAttributes.getBoolean(R.styleable.SwitchView_checked, false);
            this.f12193b = this.f12195d ? 4 : 1;
            obtainStyledAttributes.recycle();
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }


    public final void m6899a(int i) {
        if (!this.f12195d && i == 4) {
            this.f12195d = true;
        } else if (this.f12195d && i == 1) {
            this.f12195d = false;
        }
        int i2 = this.f12193b;
        if (i2 != i) {
            this.f12194c = i2;
            this.f12193b = i;
        }
        postInvalidate();
    }


    public  void m6900a(boolean z) {
        m6902b(z ? 4 : 1);
    }


    public boolean m6901a() {
        return this.f12195d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r5.f12194c == 3) goto L20;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m6902b(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 1
            r1 = 4
            if (r6 == r1) goto L7
            if (r6 != r0) goto L29
        L7:
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r6 != r1) goto L17
            int r3 = r5.f12194c     // Catch: java.lang.Throwable -> L15
            if (r3 == r0) goto L22
            int r3 = r5.f12194c     // Catch: java.lang.Throwable -> L15
            r4 = 2
            if (r3 == r4) goto L22
            goto L17
        L15:
            r6 = move-exception
            goto L2b
        L17:
            if (r6 != r0) goto L24
            int r0 = r5.f12194c     // Catch: java.lang.Throwable -> L15
            if (r0 == r1) goto L22
            int r0 = r5.f12194c     // Catch: java.lang.Throwable -> L15
            r1 = 3
            if (r0 != r1) goto L24
        L22:
            r5.f12203l = r2     // Catch: java.lang.Throwable -> L15
        L24:
            r5.f12204m = r2     // Catch: java.lang.Throwable -> L15
            r5.m6899a(r6)     // Catch: java.lang.Throwable -> L15
        L29:
            monitor-exit(r5)
            return
        L2b:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.button.SwitchView.m6902b(int):void");
    }


    public void m6903b(final boolean z) {
        this.f12195d = z;
        postDelayed(new Runnable() { // from class: b.f.a.c.a0.a
            @Override // java.lang.Runnable
            public final void run() {
                SwitchView.this.m6900a(z);
            }
        }, 300L);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0182  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.button.SwitchView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, (int) (size * 0.5f));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        C3248c c3248c = (C3248c) parcelable;
        super.onRestoreInstanceState(c3248c.getSuperState());
        this.f12195d = c3248c.f12218b;
        this.f12193b = this.f12195d ? 4 : 1;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C3248c c3248c = new C3248c(super.onSaveInstanceState());
        c3248c.f12218b = this.f12195d;
        return c3248c;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        float f2 = i2;
        float f3 = f2 - 0.0f;
        this.f12205n = (f + 0.0f) / 2.0f;
        this.f12206o = (f2 + 0.0f) / 2.0f;
        this.f12191A = f2 - f2;
        this.f12212u = 0.0f;
        this.f12213v = f2;
        this.f12211t = this.f12213v - this.f12212u;
        float f4 = f3 / 2.0f;
        this.f12209r = 0.95f * f4;
        float f5 = this.f12209r;
        this.f12208q = 0.2f * f5;
        this.f12210s = (f4 - f5) * 2.0f;
        this.f12214w = (f - 0.0f) - this.f12211t;
        this.f12215x = this.f12214w - this.f12208q;
        this.f12217z = 0.0f;
        this.f12216y = 0.0f;
        this.f12207p = 1.0f - (this.f12210s / f3);
        RectF rectF = new RectF(0.0f, 0.0f, f2, f2);
        this.f12199h.arcTo(rectF, 90.0f, 180.0f);
        rectF.left = f - f2;
        rectF.right = f;
        this.f12199h.arcTo(rectF, 270.0f, 180.0f);
        this.f12199h.close();
        RectF rectF2 = this.f12201j;
        rectF2.left = this.f12212u;
        rectF2.right = this.f12213v;
        float f6 = this.f12210s;
        rectF2.top = (f6 / 2.0f) + 0.0f;
        rectF2.bottom = f2 - (f6 / 2.0f);
        float f7 = this.f12211t;
        new RadialGradient(f7 / 2.0f, f7 / 2.0f, f7 / 2.0f, -16777216, 0, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = this.f12193b;
        if ((i == 4 || i == 1) && this.f12203l * this.f12204m == 0.0f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                return true;
            }
            if (action == 1) {
                int i2 = this.f12193b;
                this.f12194c = i2;
                if (i2 == 1) {
                    m6899a(2);
                } else if (i2 == 4) {
                    m6899a(3);
                }
                this.f12204m = 1.0f;
                invalidate();
                int i3 = this.f12193b;
                if (i3 == 2) {
                    m6902b(4);
                } else if (i3 == 3) {
                    m6902b(1);
                }
                InterfaceC3247b interfaceC3247b = this.f12192B;
                if (interfaceC3247b != null) {
                    interfaceC3247b.mo4371a(this, this.f12195d);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        m6899a(z ? 4 : 1);
    }

    public void setOnCheckedChangeListener(InterfaceC3247b interfaceC3247b) {
        this.f12192B = interfaceC3247b;
    }
}
