package custom.google.android.material.p139i;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.graphics.C0229a;
import androidx.core.graphics.drawable.C0241c;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.graphics.drawable.InterfaceC0240b;
import custom.google.android.material.mng1.ObjAniManager;
import custom.google.android.material.p144m.C1132a;
import custom.google.android.material.internal.C1155m;
import custom.google.android.material.p150s.C1168b;
import custom.google.android.material.p151t.C1172b;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;

/* renamed from: b.e.a.a.i.b */
/* loaded from: classes.dex */
public class C1097b extends C1181g implements TintAwareDrawable, Drawable.Callback, C1155m.b {

    /* renamed from: J0 */
    public static final int[] f5500J0 = {R.attr.state_enabled};

    /* renamed from: K0 */
    public static final ShapeDrawable f5501K0 = new ShapeDrawable(new OvalShape());

    /* renamed from: A */
    public ColorStateList f5502A;

    /* renamed from: A0 */
    public PorterDuff.Mode f5503A0;

    /* renamed from: B */
    public float f5504B;

    /* renamed from: B0 */
    public int[] f5505B0;

    /* renamed from: C */
    public float f5506C;

    /* renamed from: C0 */
    public boolean f5507C0;

    /* renamed from: D */
    public ColorStateList f5508D;

    /* renamed from: D0 */
    public ColorStateList f5509D0;

    /* renamed from: E */
    public float f5510E;

    /* renamed from: E0 */
    public WeakReference<a> f5511E0;

    /* renamed from: F */
    public ColorStateList f5512F;

    /* renamed from: F0 */
    public TextUtils.TruncateAt f5513F0;

    /* renamed from: G */
    public CharSequence f5514G;

    /* renamed from: G0 */
    public boolean f5515G0;

    /* renamed from: H */
    public boolean f5516H;

    /* renamed from: H0 */
    public int f5517H0;

    /* renamed from: I */
    public Drawable f5518I;

    /* renamed from: I0 */
    public boolean f5519I0;

    /* renamed from: J */
    public ColorStateList f5520J;

    /* renamed from: K */
    public float f5521K;

    /* renamed from: L */
    public boolean f5522L;

    /* renamed from: M */
    public boolean f5523M;

    /* renamed from: N */
    public Drawable f5524N;

    /* renamed from: O */
    public Drawable f5525O;

    /* renamed from: P */
    public ColorStateList f5526P;

    /* renamed from: Q */
    public float f5527Q;

    /* renamed from: R */
    public CharSequence f5528R;

    /* renamed from: S */
    public boolean f5529S;

    /* renamed from: T */
    public boolean f5530T;

    /* renamed from: U */
    public Drawable f5531U;

    /* renamed from: V */
    public ColorStateList f5532V;

    /* renamed from: W */
    public ObjAniManager f5533W;

    /* renamed from: X */
    public ObjAniManager f5534X;

    /* renamed from: Y */
    public float f5535Y;

    /* renamed from: Z */
    public float f5536Z;

    /* renamed from: a0 */
    public float f5537a0;

    /* renamed from: b0 */
    public float f5538b0;

    /* renamed from: c0 */
    public float f5539c0;

    /* renamed from: d0 */
    public float f5540d0;

    /* renamed from: e0 */
    public float f5541e0;

    /* renamed from: f0 */
    public float f5542f0;

    /* renamed from: g0 */
    public final Context f5543g0;

    /* renamed from: h0 */
    public final Paint f5544h0;

    /* renamed from: i0 */
    public final Paint f5545i0;

    /* renamed from: j0 */
    public final Paint.FontMetrics f5546j0;

    /* renamed from: k0 */
    public final RectF f5547k0;

    /* renamed from: l0 */
    public final PointF f5548l0;

    /* renamed from: m0 */
    public final Path f5549m0;

    /* renamed from: n0 */
    public final C1155m f5550n0;

    /* renamed from: o0 */
    public int f5551o0;

    /* renamed from: p0 */
    public int f5552p0;

    /* renamed from: q0 */
    public int f5553q0;

    /* renamed from: r0 */
    public int f5554r0;

    /* renamed from: s0 */
    public int f5555s0;

    /* renamed from: t0 */
    public int f5556t0;

    /* renamed from: u0 */
    public boolean f5557u0;

    /* renamed from: v0 */
    public int f5558v0;

    /* renamed from: w0 */
    public int f5559w0;

    /* renamed from: x0 */
    public ColorFilter f5560x0;

    /* renamed from: y0 */
    public PorterDuffColorFilter f5561y0;

    /* renamed from: z */
    public ColorStateList f5562z;

    /* renamed from: z0 */
    public ColorStateList f5563z0;

    /* renamed from: b.e.a.a.i.b$a */
    public interface a {
        /* renamed from: a */
        void mo3967a();
    }

    public C1097b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(C1185k.m4176a(context, attributeSet, i, i2).m4185a());
        this.f5506C = -1.0f;
        this.f5544h0 = new Paint(1);
        this.f5546j0 = new Paint.FontMetrics();
        this.f5547k0 = new RectF();
        this.f5548l0 = new PointF();
        this.f5549m0 = new Path();
        this.f5559w0 = 255;
        this.f5503A0 = PorterDuff.Mode.SRC_IN;
        this.f5511E0 = new WeakReference<>(null);
        this.f5989b.f6013b = new C1132a(context);
        m4171i();
        this.f5543g0 = context;
        this.f5550n0 = new C1155m(this);
        this.f5514G = "";
        this.f5550n0.f5910a.density = context.getResources().getDisplayMetrics().density;
        this.f5545i0 = null;
        Paint paint = this.f5545i0;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(f5500J0);
        m3929b(f5500J0);
        this.f5515G0 = true;
        if (C1172b.f5968a) {
            f5501K0.setTint(-1);
        }
    }

    /* renamed from: f */
    public static boolean m3917f(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* renamed from: i */
    public static boolean m3918i(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    /* renamed from: a */
    public final void m3920a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        Util.m275a(drawable, Util.m323c(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f5524N) {
            if (drawable.isStateful()) {
                drawable.setState(this.f5505B0);
            }
            ColorStateList colorStateList = this.f5526P;
            int i = Build.VERSION.SDK_INT;
            drawable.setTintList(colorStateList);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.f5518I;
        if (drawable == drawable2 && this.f5522L) {
            ColorStateList colorStateList2 = this.f5520J;
            int i2 = Build.VERSION.SDK_INT;
            drawable2.setTintList(colorStateList2);
        }
    }

    /* renamed from: a */
    public void m3921a(a aVar) {
        this.f5511E0 = new WeakReference<>(aVar);
    }

    /* renamed from: a */
    public void m3924a(boolean z) {
        if (this.f5529S != z) {
            this.f5529S = z;
            float m3950j = m3950j();
            if (!z && this.f5557u0) {
                this.f5557u0 = false;
            }
            float m3950j2 = m3950j();
            invalidateSelf();
            if (m3950j != m3950j2) {
                m3963q();
            }
        }
    }

    /* renamed from: b */
    public final void m3926b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m3966t()) {
            float f = this.f5542f0 + this.f5541e0;
            if (Util.m323c(this) == 0) {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.f5527Q;
            } else {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.f5527Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f2 = this.f5527Q;
            rectF.top = exactCenterY - (f2 / 2.0f);
            rectF.bottom = rectF.top + f2;
        }
    }

    /* renamed from: b */
    public void m3927b(Drawable drawable) {
        if (this.f5531U != drawable) {
            float m3950j = m3950j();
            this.f5531U = drawable;
            float m3950j2 = m3950j();
            m3941e(this.f5531U);
            m3920a(this.f5531U);
            invalidateSelf();
            if (m3950j != m3950j2) {
                m3963q();
            }
        }
    }

    /* renamed from: b */
    public void m3928b(boolean z) {
        if (this.f5530T != z) {
            boolean m3964r = m3964r();
            this.f5530T = z;
            boolean m3964r2 = m3964r();
            if (m3964r != m3964r2) {
                if (m3964r2) {
                    m3920a(this.f5531U);
                } else {
                    m3941e(this.f5531U);
                }
                invalidateSelf();
                m3963q();
            }
        }
    }

    /* renamed from: b */
    public boolean m3929b(int[] iArr) {
        if (Arrays.equals(this.f5505B0, iArr)) {
            return false;
        }
        this.f5505B0 = iArr;
        if (m3966t()) {
            return m3925a(getState(), iArr);
        }
        return false;
    }

    /* renamed from: c */
    public void m3931c(ColorStateList colorStateList) {
        if (this.f5532V != colorStateList) {
            this.f5532V = colorStateList;
            if (this.f5530T && this.f5531U != null && this.f5529S) {
                Drawable drawable = this.f5531U;
                int i = Build.VERSION.SDK_INT;
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: c */
    public final void m3932c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m3966t()) {
            float f = this.f5542f0 + this.f5541e0 + this.f5527Q + this.f5540d0 + this.f5539c0;
            if (Util.m323c(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* renamed from: c */
    public void m3933c(Drawable drawable) {
        Drawable m3956m = m3956m();
        if (m3956m != drawable) {
            float m3950j = m3950j();
            this.f5518I = drawable != null ? Util.m342e(drawable).mutate() : null;
            float m3950j2 = m3950j();
            m3941e(m3956m);
            if (m3965s()) {
                m3920a(this.f5518I);
            }
            invalidateSelf();
            if (m3950j != m3950j2) {
                m3963q();
            }
        }
    }

    /* renamed from: c */
    public void m3934c(boolean z) {
        if (this.f5516H != z) {
            boolean m3965s = m3965s();
            this.f5516H = z;
            boolean m3965s2 = m3965s();
            if (m3965s != m3965s2) {
                if (m3965s2) {
                    m3920a(this.f5518I);
                } else {
                    m3941e(this.f5518I);
                }
                invalidateSelf();
                m3963q();
            }
        }
    }

    /* renamed from: d */
    public void m3935d(float f) {
        if (this.f5542f0 != f) {
            this.f5542f0 = f;
            invalidateSelf();
            m3963q();
        }
    }

    /* renamed from: d */
    public void m3936d(ColorStateList colorStateList) {
        if (this.f5502A != colorStateList) {
            this.f5502A = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: d */
    public void m3937d(Drawable drawable) {
        Drawable m3958n = m3958n();
        if (m3958n != drawable) {
            float m3952k = m3952k();
            this.f5524N = drawable != null ? Util.m342e(drawable).mutate() : null;
            if (C1172b.f5968a) {
                this.f5525O = new RippleDrawable(C1172b.m4140a(this.f5512F), this.f5524N, f5501K0);
            }
            float m3952k2 = m3952k();
            m3941e(m3958n);
            if (m3966t()) {
                m3920a(this.f5524N);
            }
            invalidateSelf();
            if (m3952k != m3952k2) {
                m3963q();
            }
        }
    }

    /* renamed from: d */
    public void m3938d(boolean z) {
        if (this.f5523M != z) {
            boolean m3966t = m3966t();
            this.f5523M = z;
            boolean m3966t2 = m3966t();
            if (m3966t != m3966t2) {
                if (m3966t2) {
                    m3920a(this.f5524N);
                } else {
                    m3941e(this.f5524N);
                }
                invalidateSelf();
                m3963q();
            }
        }
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Drawable drawable;
        int i8;
        float f;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.f5559w0) == 0) {
            return;
        }
        if (i < 255) {
            float f2 = bounds.left;
            float f3 = bounds.top;
            float f4 = bounds.right;
            float f5 = bounds.bottom;
            i2 = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i) : canvas.saveLayerAlpha(f2, f3, f4, f5, i, 31);
        } else {
            i2 = 0;
        }
        if (!this.f5519I0) {
            this.f5544h0.setColor(this.f5551o0);
            this.f5544h0.setStyle(Paint.Style.FILL);
            this.f5547k0.set(bounds);
            canvas.drawRoundRect(this.f5547k0, m3954l(), m3954l(), this.f5544h0);
        }
        if (!this.f5519I0) {
            this.f5544h0.setColor(this.f5552p0);
            this.f5544h0.setStyle(Paint.Style.FILL);
            this.f5544h0.setColorFilter(m3962p());
            this.f5547k0.set(bounds);
            canvas.drawRoundRect(this.f5547k0, m3954l(), m3954l(), this.f5544h0);
        }
        if (this.f5519I0) {
            super.draw(canvas);
        }
        if (this.f5510E > 0.0f && !this.f5519I0) {
            this.f5544h0.setColor(this.f5554r0);
            this.f5544h0.setStyle(Paint.Style.STROKE);
            if (!this.f5519I0) {
                this.f5544h0.setColorFilter(m3962p());
            }
            RectF rectF = this.f5547k0;
            float f6 = bounds.left;
            float f7 = this.f5510E / 2.0f;
            rectF.set(f6 + f7, bounds.top + f7, bounds.right - f7, bounds.bottom - f7);
            float f8 = this.f5506C - (this.f5510E / 2.0f);
            canvas.drawRoundRect(this.f5547k0, f8, f8, this.f5544h0);
        }
        this.f5544h0.setColor(this.f5555s0);
        this.f5544h0.setStyle(Paint.Style.FILL);
        this.f5547k0.set(bounds);
        if (this.f5519I0) {
            m4164b(new RectF(bounds), this.f5549m0);
            i3 = 0;
            m4158a(canvas, this.f5544h0, this.f5549m0, this.f5989b.f6012a, m4151a());
        } else {
            canvas.drawRoundRect(this.f5547k0, m3954l(), m3954l(), this.f5544h0);
            i3 = 0;
        }
        if (m3965s()) {
            m3919a(bounds, this.f5547k0);
            RectF rectF2 = this.f5547k0;
            float f9 = rectF2.left;
            float f10 = rectF2.top;
            canvas.translate(f9, f10);
            this.f5518I.setBounds(i3, i3, (int) this.f5547k0.width(), (int) this.f5547k0.height());
            this.f5518I.draw(canvas);
            canvas.translate(-f9, -f10);
        }
        if (m3964r()) {
            m3919a(bounds, this.f5547k0);
            RectF rectF3 = this.f5547k0;
            float f11 = rectF3.left;
            float f12 = rectF3.top;
            canvas.translate(f11, f12);
            this.f5531U.setBounds(i3, i3, (int) this.f5547k0.width(), (int) this.f5547k0.height());
            this.f5531U.draw(canvas);
            canvas.translate(-f11, -f12);
        }
        if (!this.f5515G0 || this.f5514G == null) {
            i4 = i2;
            i5 = 0;
        } else {
            PointF pointF = this.f5548l0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            if (this.f5514G != null) {
                float m3950j = m3950j() + this.f5535Y + this.f5538b0;
                if (Util.m323c(this) == 0) {
                    pointF.x = bounds.left + m3950j;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - m3950j;
                    align = Paint.Align.RIGHT;
                }
                float centerY = bounds.centerY();
                this.f5550n0.f5910a.getFontMetrics(this.f5546j0);
                Paint.FontMetrics fontMetrics = this.f5546j0;
                pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            RectF rectF4 = this.f5547k0;
            rectF4.setEmpty();
            if (this.f5514G != null) {
                float m3950j2 = m3950j() + this.f5535Y + this.f5538b0;
                float m3952k = m3952k() + this.f5542f0 + this.f5539c0;
                if (Util.m323c(this) == 0) {
                    rectF4.left = bounds.left + m3950j2;
                    f = bounds.right - m3952k;
                } else {
                    rectF4.left = bounds.left + m3952k;
                    f = bounds.right - m3950j2;
                }
                rectF4.right = f;
                rectF4.top = bounds.top;
                rectF4.bottom = bounds.bottom;
            }
            C1155m c1155m = this.f5550n0;
            if (c1155m.f5915f != null) {
                c1155m.f5910a.drawableState = getState();
                C1155m c1155m2 = this.f5550n0;
                c1155m2.f5915f.m4134a(this.f5543g0, c1155m2.f5910a, c1155m2.f5911b);
            }
            this.f5550n0.f5910a.setTextAlign(align);
            boolean z = Math.round(this.f5550n0.m4119a(this.f5514G.toString())) > Math.round(this.f5547k0.width());
            if (z) {
                i8 = canvas.save();
                canvas.clipRect(this.f5547k0);
            } else {
                i8 = 0;
            }
            CharSequence charSequence = this.f5514G;
            if (z && this.f5513F0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f5550n0.f5910a, this.f5547k0.width(), this.f5513F0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF2 = this.f5548l0;
            i5 = 0;
            i4 = i2;
            canvas.drawText(charSequence2, 0, length, pointF2.x, pointF2.y, this.f5550n0.f5910a);
            if (z) {
                canvas.restoreToCount(i8);
            }
        }
        if (m3966t()) {
            m3926b(bounds, this.f5547k0);
            RectF rectF5 = this.f5547k0;
            float f13 = rectF5.left;
            float f14 = rectF5.top;
            canvas.translate(f13, f14);
            this.f5524N.setBounds(i5, i5, (int) this.f5547k0.width(), (int) this.f5547k0.height());
            if (C1172b.f5968a) {
                this.f5525O.setBounds(this.f5524N.getBounds());
                this.f5525O.jumpToCurrentState();
                drawable = this.f5525O;
            } else {
                drawable = this.f5524N;
            }
            drawable.draw(canvas);
            canvas.translate(-f13, -f14);
        }
        Paint paint = this.f5545i0;
        if (paint != null) {
            paint.setColor(C0229a.m1082b(-16777216, 127));
            canvas.drawRect(bounds, this.f5545i0);
            if (m3965s() || m3964r()) {
                m3919a(bounds, this.f5547k0);
                canvas.drawRect(this.f5547k0, this.f5545i0);
            }
            if (this.f5514G != null) {
                i6 = i4;
                i7 = 255;
                canvas.drawLine(bounds.left, bounds.exactCenterY(), bounds.right, bounds.exactCenterY(), this.f5545i0);
            } else {
                i6 = i4;
                i7 = 255;
            }
            if (m3966t()) {
                m3926b(bounds, this.f5547k0);
                canvas.drawRect(this.f5547k0, this.f5545i0);
            }
            this.f5545i0.setColor(C0229a.m1082b(-65536, 127));
            RectF rectF6 = this.f5547k0;
            rectF6.set(bounds);
            if (m3966t()) {
                float f15 = this.f5542f0 + this.f5541e0 + this.f5527Q + this.f5540d0 + this.f5539c0;
                if (Util.m323c(this) == 0) {
                    rectF6.right = bounds.right - f15;
                } else {
                    rectF6.left = bounds.left + f15;
                }
            }
            canvas.drawRect(this.f5547k0, this.f5545i0);
            this.f5545i0.setColor(C0229a.m1082b(-16711936, 127));
            m3932c(bounds, this.f5547k0);
            canvas.drawRect(this.f5547k0, this.f5545i0);
        } else {
            i6 = i4;
            i7 = 255;
        }
        if (this.f5559w0 < i7) {
            canvas.restoreToCount(i6);
        }
    }

    /* renamed from: e */
    public void m3939e(float f) {
        if (this.f5521K != f) {
            float m3950j = m3950j();
            this.f5521K = f;
            float m3950j2 = m3950j();
            invalidateSelf();
            if (m3950j != m3950j2) {
                m3963q();
            }
        }
    }

    /* renamed from: e */
    public void m3940e(ColorStateList colorStateList) {
        this.f5522L = true;
        if (this.f5520J != colorStateList) {
            this.f5520J = colorStateList;
            if (m3965s()) {
                Drawable drawable = this.f5518I;
                int i = Build.VERSION.SDK_INT;
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: e */
    public final void m3941e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* renamed from: f */
    public void m3943f(float f) {
        if (this.f5504B != f) {
            this.f5504B = f;
            invalidateSelf();
            m3963q();
        }
    }

    /* renamed from: f */
    public void m3944f(ColorStateList colorStateList) {
        if (this.f5508D != colorStateList) {
            this.f5508D = colorStateList;
            if (this.f5519I0) {
                m4163b(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: g */
    public void m3945g(float f) {
        if (this.f5535Y != f) {
            this.f5535Y = f;
            invalidateSelf();
            m3963q();
        }
    }

    /* renamed from: g */
    public void m3946g(ColorStateList colorStateList) {
        if (this.f5526P != colorStateList) {
            this.f5526P = colorStateList;
            if (m3966t()) {
                Drawable drawable = this.f5524N;
                int i = Build.VERSION.SDK_INT;
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5559w0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f5560x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f5504B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(m3952k() + this.f5550n0.m4119a(this.f5514G.toString()) + m3950j() + this.f5535Y + this.f5538b0 + this.f5539c0 + this.f5542f0), this.f5517H0);
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f5519I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f5504B, this.f5506C);
        } else {
            outline.setRoundRect(bounds, this.f5506C);
        }
        outline.setAlpha(this.f5559w0 / 255.0f);
    }

    /* renamed from: h */
    public void m3947h(float f) {
        if (this.f5510E != f) {
            this.f5510E = f;
            this.f5544h0.setStrokeWidth(f);
            if (this.f5519I0) {
                this.f5989b.f6023l = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* renamed from: i */
    public void m3949i(float f) {
        if (this.f5541e0 != f) {
            this.f5541e0 = f;
            invalidateSelf();
            if (m3966t()) {
                m3963q();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (m3918i(this.f5562z) || m3918i(this.f5502A) || m3918i(this.f5508D)) {
            return true;
        }
        if (this.f5507C0 && m3918i(this.f5509D0)) {
            return true;
        }
        C1168b c1168b = this.f5550n0.f5915f;
        if ((c1168b == null || (colorStateList = c1168b.f5946a) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        return (this.f5530T && this.f5531U != null && this.f5529S) || m3917f(this.f5518I) || m3917f(this.f5531U) || m3918i(this.f5563z0);
    }

    /* renamed from: j */
    public float m3950j() {
        if (!m3965s() && !m3964r()) {
            return 0.0f;
        }
        return m3960o() + this.f5536Z + this.f5537a0;
    }

    /* renamed from: j */
    public void m3951j(float f) {
        if (this.f5527Q != f) {
            this.f5527Q = f;
            invalidateSelf();
            if (m3966t()) {
                m3963q();
            }
        }
    }

    /* renamed from: k */
    public float m3952k() {
        if (m3966t()) {
            return this.f5540d0 + this.f5527Q + this.f5541e0;
        }
        return 0.0f;
    }

    /* renamed from: k */
    public void m3953k(float f) {
        if (this.f5540d0 != f) {
            this.f5540d0 = f;
            invalidateSelf();
            if (m3966t()) {
                m3963q();
            }
        }
    }

    /* renamed from: l */
    public float m3954l() {
        return this.f5519I0 ? m4167e() : this.f5506C;
    }

    /* renamed from: l */
    public void m3955l(float f) {
        if (this.f5537a0 != f) {
            float m3950j = m3950j();
            this.f5537a0 = f;
            float m3950j2 = m3950j();
            invalidateSelf();
            if (m3950j != m3950j2) {
                m3963q();
            }
        }
    }

    /* renamed from: m */
    public Drawable m3956m() {
        Drawable drawable = this.f5518I;
        if (drawable != null) {
            return drawable instanceof InterfaceC0240b ? ((C0241c) drawable).f1668g : drawable;
        }
        return null;
    }

    /* renamed from: m */
    public void m3957m(float f) {
        if (this.f5536Z != f) {
            float m3950j = m3950j();
            this.f5536Z = f;
            float m3950j2 = m3950j();
            invalidateSelf();
            if (m3950j != m3950j2) {
                m3963q();
            }
        }
    }

    /* renamed from: n */
    public Drawable m3958n() {
        Drawable drawable = this.f5524N;
        if (drawable != null) {
            return drawable instanceof InterfaceC0240b ? ((C0241c) drawable).f1668g : drawable;
        }
        return null;
    }

    /* renamed from: n */
    public void m3959n(float f) {
        if (this.f5539c0 != f) {
            this.f5539c0 = f;
            invalidateSelf();
            m3963q();
        }
    }

    /* renamed from: o */
    public final float m3960o() {
        return (this.f5521K > 0.0f || (this.f5557u0 ? this.f5531U : this.f5518I) == null) ? this.f5521K : r0.getIntrinsicWidth();
    }

    /* renamed from: o */
    public void m3961o(float f) {
        if (this.f5538b0 != f) {
            this.f5538b0 = f;
            invalidateSelf();
            m3963q();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (m3965s()) {
            onLayoutDirectionChanged |= Util.m275a(this.f5518I, i);
        }
        if (m3964r()) {
            onLayoutDirectionChanged |= Util.m275a(this.f5531U, i);
        }
        if (m3966t()) {
            onLayoutDirectionChanged |= Util.m275a(this.f5524N, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (m3965s()) {
            onLevelChange |= this.f5518I.setLevel(i);
        }
        if (m3964r()) {
            onLevelChange |= this.f5531U.setLevel(i);
        }
        if (m3966t()) {
            onLevelChange |= this.f5524N.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f5519I0) {
            super.onStateChange(iArr);
        }
        return m3925a(iArr, this.f5505B0);
    }

    /* renamed from: p */
    public final ColorFilter m3962p() {
        ColorFilter colorFilter = this.f5560x0;
        return colorFilter != null ? colorFilter : this.f5561y0;
    }

    /* renamed from: q */
    public void m3963q() {
        a aVar = this.f5511E0.get();
        if (aVar != null) {
            aVar.mo3967a();
        }
    }

    /* renamed from: r */
    public final boolean m3964r() {
        return this.f5530T && this.f5531U != null && this.f5557u0;
    }

    /* renamed from: s */
    public final boolean m3965s() {
        return this.f5516H && this.f5518I != null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f5559w0 != i) {
            this.f5559w0 = i;
            invalidateSelf();
        }
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f5560x0 != colorFilter) {
            this.f5560x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f5563z0 != colorStateList) {
            this.f5563z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f5503A0 != mode) {
            this.f5503A0 = mode;
            this.f5561y0 = Util.m202a(this, this.f5563z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (m3965s()) {
            visible |= this.f5518I.setVisible(z, z2);
        }
        if (m3964r()) {
            visible |= this.f5531U.setVisible(z, z2);
        }
        if (m3966t()) {
            visible |= this.f5524N.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* renamed from: t */
    public final boolean m3966t() {
        return this.f5523M && this.f5524N != null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* renamed from: e */
    public void m3942e(boolean z) {
        if (this.f5507C0 != z) {
            this.f5507C0 = z;
            this.f5509D0 = this.f5507C0 ? C1172b.m4140a(this.f5512F) : null;
            onStateChange(getState());
        }
    }

    /* renamed from: h */
    public void m3948h(ColorStateList colorStateList) {
        if (this.f5512F != colorStateList) {
            this.f5512F = colorStateList;
            this.f5509D0 = this.f5507C0 ? C1172b.m4140a(this.f5512F) : null;
            onStateChange(getState());
        }
    }

    @Deprecated
    /* renamed from: c */
    public void m3930c(float f) {
        if (this.f5506C != f) {
            this.f5506C = f;
            setShapeAppearanceModel(this.f5989b.f6012a.m4178a(f));
        }
    }

    /* renamed from: a */
    public final void m3919a(Rect rect, RectF rectF) {
        float f;
        rectF.setEmpty();
        if (m3965s() || m3964r()) {
            float f2 = this.f5535Y + this.f5536Z;
            float m3960o = m3960o();
            if (Util.m323c(this) == 0) {
                rectF.left = rect.left + f2;
                rectF.right = rectF.left + m3960o;
            } else {
                rectF.right = rect.right - f2;
                rectF.left = rectF.right - m3960o;
            }
            Drawable drawable = this.f5557u0 ? this.f5531U : this.f5518I;
            if (this.f5521K > 0.0f || drawable == null) {
                f = this.f5521K;
            } else {
                f = (float) Math.ceil(Util.m162a(this.f5543g0, 24));
                if (drawable.getIntrinsicHeight() <= f) {
                    f = drawable.getIntrinsicHeight();
                }
            }
            rectF.top = rect.exactCenterY() - (f / 2.0f);
            rectF.bottom = rectF.top + f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3925a(int[] r9, int[] r10) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p139i.C1097b.m3925a(int[], int[]):boolean");
    }

    /* renamed from: a */
    public void m3923a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.f5514G, charSequence)) {
            return;
        }
        this.f5514G = charSequence;
        this.f5550n0.f5913d = true;
        invalidateSelf();
        m3963q();
    }

    /* renamed from: a */
    public void m3922a(C1168b c1168b) {
        C1155m c1155m = this.f5550n0;
        Context context = this.f5543g0;
        if (c1155m.f5915f != c1168b) {
            c1155m.f5915f = c1168b;
            if (c1168b != null) {
                c1168b.m4138b(context, c1155m.f5910a, c1155m.f5911b);
                Object obj = (C1155m.b) c1155m.f5914e.get();
                if (obj != null) {
                    c1155m.f5910a.drawableState = ((Drawable) obj).getState();
                }
                c1168b.m4134a(context, c1155m.f5910a, c1155m.f5911b);
                c1155m.f5913d = true;
            }
            Object obj2 = (C1155m.b) c1155m.f5914e.get();
            if (obj2 != null) {
                C1097b c1097b = (C1097b) obj2;
                c1097b.m3963q();
                c1097b.invalidateSelf();
                c1097b.onStateChange(((Drawable) obj2).getState());
            }
        }
    }
}
