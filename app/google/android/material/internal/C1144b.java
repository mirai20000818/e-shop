package custom.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

import androidx.core.p040g.C0264d;
import androidx.core.view.ViewCompat;

import com.jeil.emarket.custom.CustomString;

import custom.google.android.material.mng1.AnimationUtils;
import custom.google.android.material.p150s.C1167a;

/* renamed from: b.e.a.a.p.b */
/* loaded from: classes.dex */
public final class C1144b {

    /* renamed from: j0 */
    public static final boolean f5773j0;

    /* renamed from: k0 */
    public static final Paint f5774k0;

    /* renamed from: A */
    public C1167a f5775A;

    /* renamed from: B */
    public CharSequence f5776B;

    /* renamed from: C */
    public CharSequence f5777C;

    /* renamed from: D */
    public boolean f5778D;

    /* renamed from: F */
    public boolean f5780F;

    /* renamed from: G */
    public Bitmap f5781G;

    /* renamed from: H */
    public Paint f5782H;

    /* renamed from: I */
    public float f5783I;

    /* renamed from: J */
    public float f5784J;

    /* renamed from: K */
    public int[] f5785K;

    /* renamed from: L */
    public boolean f5786L;

    /* renamed from: O */
    public TimeInterpolator f5789O;

    /* renamed from: P */
    public TimeInterpolator f5790P;

    /* renamed from: Q */
    public float f5791Q;

    /* renamed from: R */
    public float f5792R;

    /* renamed from: S */
    public float f5793S;

    /* renamed from: T */
    public ColorStateList f5794T;

    /* renamed from: U */
    public float f5795U;

    /* renamed from: V */
    public float f5796V;

    /* renamed from: W */
    public float f5797W;

    /* renamed from: X */
    public ColorStateList f5798X;

    /* renamed from: Y */
    public float f5799Y;

    /* renamed from: Z */
    public float f5800Z;

    /* renamed from: a */
    public final View f5801a;

    /* renamed from: a0 */
    public StaticLayout f5802a0;

    /* renamed from: b */
    public boolean f5803b;

    /* renamed from: b0 */
    public float f5804b0;

    /* renamed from: c */
    public float f5805c;

    /* renamed from: c0 */
    public float f5806c0;

    /* renamed from: d */
    public boolean f5807d;

    /* renamed from: d0 */
    public float f5808d0;

    /* renamed from: e */
    public float f5809e;

    /* renamed from: e0 */
    public CharSequence f5810e0;

    /* renamed from: f */
    public float f5811f;

    /* renamed from: g */
    public int f5813g;

    /* renamed from: o */
    public ColorStateList f5824o;

    /* renamed from: p */
    public ColorStateList f5825p;

    /* renamed from: q */
    public float f5826q;

    /* renamed from: r */
    public float f5827r;

    /* renamed from: s */
    public float f5828s;

    /* renamed from: t */
    public float f5829t;

    /* renamed from: u */
    public float f5830u;

    /* renamed from: v */
    public float f5831v;

    /* renamed from: w */
    public Typeface f5832w;

    /* renamed from: x */
    public Typeface f5833x;

    /* renamed from: y */
    public Typeface f5834y;

    /* renamed from: z */
    public C1167a f5835z;

    /* renamed from: k */
    public int f5820k = 16;

    /* renamed from: l */
    public int f5821l = 16;

    /* renamed from: m */
    public float f5822m = 15.0f;

    /* renamed from: n */
    public float f5823n = 15.0f;

    /* renamed from: E */
    public boolean f5779E = true;

    /* renamed from: f0 */
    public int f5812f0 = 1;

    /* renamed from: g0 */
    public float f5814g0 = 0.0f;

    /* renamed from: h0 */
    public float f5816h0 = 1.0f;

    /* renamed from: i0 */
    public int f5818i0 = C1154l.f5893n;

    /* renamed from: M */
    public final TextPaint f5787M = new TextPaint(129);

    /* renamed from: N */
    public final TextPaint f5788N = new TextPaint(this.f5787M);

    /* renamed from: i */
    public final Rect f5817i = new Rect();

    /* renamed from: h */
    public final Rect f5815h = new Rect();

    /* renamed from: j */
    public final RectF f5819j = new RectF();

    static {
        int i = Build.VERSION.SDK_INT;
        f5773j0 = false;
        f5774k0 = null;
        Paint paint = f5774k0;
        if (paint != null) {
            paint.setAntiAlias(true);
            f5774k0.setColor(-65281);
        }
    }

    public C1144b(View view) {
        this.f5801a = view;
        float f = this.f5809e;
        this.f5811f = CustomString.m3148a(1.0f, f, 0.5f, f);
    }

    /* renamed from: a */
    public static float m4073a(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(f, f2, f3);
    }

    /* renamed from: a */
    public static int m4074a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), (int) ((Color.red(i2) * f) + (Color.red(i) * f2)), (int) ((Color.green(i2) * f) + (Color.green(i) * f2)), (int) ((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    /* renamed from: a */
    public static boolean m4075a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    /* renamed from: a */
    public float m4076a() {
        if (this.f5776B == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.f5788N;
        textPaint.setTextSize(this.f5823n);
        textPaint.setTypeface(this.f5832w);
        int i = Build.VERSION.SDK_INT;
        textPaint.setLetterSpacing(this.f5799Y);
        TextPaint textPaint2 = this.f5788N;
        CharSequence charSequence = this.f5776B;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    /* renamed from: a */
    public final int m4077a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f5785K;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    /* renamed from: a */
    public void m4080a(int i) {
        if (this.f5821l != i) {
            this.f5821l = i;
            m4095g();
        }
    }

    /* renamed from: b */
    public final void m4085b() {
        m4078a(this.f5805c);
    }

    /* renamed from: b */
    public void m4087b(ColorStateList colorStateList) {
        if (this.f5825p != colorStateList) {
            this.f5825p = colorStateList;
            m4095g();
        }
    }

    /* renamed from: b */
    public void m4088b(Rect rect) {
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        if (m4075a(this.f5815h, i, i2, i3, i4)) {
            return;
        }
        this.f5815h.set(i, i2, i3, i4);
        this.f5786L = true;
        m4094f();
    }

    /* renamed from: c */
    public final void m4090c() {
        Bitmap bitmap = this.f5781G;
        if (bitmap != null) {
            bitmap.recycle();
            this.f5781G = null;
        }
    }

    /* renamed from: c */
    public final void m4091c(float f) {
        boolean z = false;
        m4079a(f, false);
        if (f5773j0 && this.f5783I != 1.0f) {
            z = true;
        }
        this.f5780F = z;
        if (this.f5780F && this.f5781G == null && !this.f5815h.isEmpty() && !TextUtils.isEmpty(this.f5777C)) {
            m4078a(0.0f);
            int width = this.f5802a0.getWidth();
            int height = this.f5802a0.getHeight();
            if (width > 0 && height > 0) {
                this.f5781G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f5802a0.draw(new Canvas(this.f5781G));
                if (this.f5782H == null) {
                    this.f5782H = new Paint(3);
                }
            }
        }
        ViewCompat.m1260G(this.f5801a);
    }

    /* renamed from: d */
    public float m4092d() {
        TextPaint textPaint = this.f5788N;
        textPaint.setTextSize(this.f5823n);
        textPaint.setTypeface(this.f5832w);
        int i = Build.VERSION.SDK_INT;
        textPaint.setLetterSpacing(this.f5799Y);
        return -this.f5788N.ascent();
    }

    /* renamed from: e */
    public int m4093e() {
        return m4077a(this.f5825p);
    }

    /* renamed from: f */
    public void m4094f() {
        this.f5803b = this.f5817i.width() > 0 && this.f5817i.height() > 0 && this.f5815h.width() > 0 && this.f5815h.height() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4095g() {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p147p.C1144b.m4095g():void");
    }

    /* renamed from: h */
    public final boolean m4096h() {
        return this.f5812f0 > 1 && (!this.f5778D || this.f5807d) && !this.f5780F;
    }

    /* renamed from: b */
    public void m4086b(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.f5805c) {
            this.f5805c = f;
            m4078a(this.f5805c);
        }
    }

    /* renamed from: a */
    public final boolean m4084a(CharSequence charSequence) {
        boolean z = ViewCompat.m1310m(this.f5801a) == 1;
        if (this.f5779E) {
            return ((C0264d.d) (z ? C0264d.f1746d : C0264d.f1745c)).m1145a(charSequence, 0, charSequence.length());
        }
        return z;
    }

    /* renamed from: b */
    public void m4089b(Typeface typeface) {
        boolean z;
        C1167a c1167a = this.f5775A;
        boolean z2 = true;
        if (c1167a != null) {
            c1167a.f5945c = true;
        }
        if (this.f5832w != typeface) {
            this.f5832w = typeface;
            z = true;
        } else {
            z = false;
        }
        C1167a c1167a2 = this.f5835z;
        if (c1167a2 != null) {
            c1167a2.f5945c = true;
        }
        if (this.f5833x != typeface) {
            this.f5833x = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            m4095g();
        }
    }

    /* renamed from: a */
    public final void m4078a(float f) {
        float f2;
        if (this.f5807d) {
            this.f5819j.set(f < this.f5811f ? this.f5815h : this.f5817i);
        } else {
            this.f5819j.left = m4073a(this.f5815h.left, this.f5817i.left, f, this.f5789O);
            this.f5819j.top = m4073a(this.f5826q, this.f5827r, f, this.f5789O);
            this.f5819j.right = m4073a(this.f5815h.right, this.f5817i.right, f, this.f5789O);
            this.f5819j.bottom = m4073a(this.f5815h.bottom, this.f5817i.bottom, f, this.f5789O);
        }
        if (!this.f5807d) {
            this.f5830u = m4073a(this.f5828s, this.f5829t, f, this.f5789O);
            this.f5831v = m4073a(this.f5826q, this.f5827r, f, this.f5789O);
            m4091c(m4073a(this.f5822m, this.f5823n, f, this.f5790P));
            f2 = f;
        } else if (f < this.f5811f) {
            this.f5830u = this.f5828s;
            this.f5831v = this.f5826q;
            m4091c(this.f5822m);
            f2 = 0.0f;
        } else {
            this.f5830u = this.f5829t;
            this.f5831v = this.f5827r - Math.max(0, this.f5813g);
            m4091c(this.f5823n);
            f2 = 1.0f;
        }
        this.f5804b0 = 1.0f - m4073a(0.0f, 1.0f, 1.0f - f, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ViewCompat.m1260G(this.f5801a);
        this.f5806c0 = m4073a(1.0f, 0.0f, f, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ViewCompat.m1260G(this.f5801a);
        ColorStateList colorStateList = this.f5825p;
        ColorStateList colorStateList2 = this.f5824o;
        if (colorStateList != colorStateList2) {
            this.f5787M.setColor(m4074a(m4077a(colorStateList2), m4093e(), f2));
        } else {
            this.f5787M.setColor(m4093e());
        }
        int i = Build.VERSION.SDK_INT;
        float f3 = this.f5799Y;
        float f4 = this.f5800Z;
        if (f3 != f4) {
            this.f5787M.setLetterSpacing(m4073a(f4, f3, f, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        } else {
            this.f5787M.setLetterSpacing(f3);
        }
        this.f5787M.setShadowLayer(m4073a(this.f5795U, this.f5791Q, f, null), m4073a(this.f5796V, this.f5792R, f, null), m4073a(this.f5797W, this.f5793S, f, null), m4074a(m4077a(this.f5798X), m4077a(this.f5794T), f));
        if (this.f5807d) {
            float f5 = this.f5811f;
            this.f5787M.setAlpha((int) ((f <= f5 ? AnimationUtils.lerp(1.0f, 0.0f, this.f5809e, f5, f) : AnimationUtils.lerp(0.0f, 1.0f, f5, 1.0f, f)) * 255.0f));
        }
        View view = this.f5801a;
        int i2 = Build.VERSION.SDK_INT;
        view.postInvalidateOnAnimation();
    }

    /* renamed from: a */
    public final void m4079a(float f, boolean z) {
        float f2;
        boolean z2;
        StaticLayout staticLayout;
        boolean z3;
        if (this.f5776B == null) {
            return;
        }
        float width = this.f5817i.width();
        float width2 = this.f5815h.width();
        if (Math.abs(f - this.f5823n) < 0.001f) {
            float f3 = this.f5823n;
            this.f5783I = 1.0f;
            Typeface typeface = this.f5834y;
            Typeface typeface2 = this.f5832w;
            if (typeface != typeface2) {
                this.f5834y = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
            f2 = f3;
            z2 = z3;
        } else {
            f2 = this.f5822m;
            Typeface typeface3 = this.f5834y;
            Typeface typeface4 = this.f5833x;
            if (typeface3 != typeface4) {
                this.f5834y = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (Math.abs(f - this.f5822m) < 0.001f) {
                this.f5783I = 1.0f;
            } else {
                this.f5783I = f / this.f5822m;
            }
            float f4 = this.f5823n / this.f5822m;
            width = (!z && width2 * f4 > width) ? Math.min(width / f4, width2) : width2;
        }
        if (width > 0.0f) {
            z2 = this.f5784J != f2 || this.f5786L || z2;
            this.f5784J = f2;
            this.f5786L = false;
        }
        if (this.f5777C == null || z2) {
            this.f5787M.setTextSize(this.f5784J);
            this.f5787M.setTypeface(this.f5834y);
            this.f5787M.setLinearText(this.f5783I != 1.0f);
            this.f5778D = m4084a(this.f5776B);
            int i = m4096h() ? this.f5812f0 : 1;
            boolean z4 = this.f5778D;
            try {
                C1154l c1154l = new C1154l(this.f5776B, this.f5787M, (int) width);
                c1154l.f5909m = TextUtils.TruncateAt.END;
                c1154l.f5908l = z4;
                c1154l.f5902f = Layout.Alignment.ALIGN_NORMAL;
                c1154l.f5907k = false;
                c1154l.f5903g = i;
                float f5 = this.f5814g0;
                float f6 = this.f5816h0;
                c1154l.f5904h = f5;
                c1154l.f5905i = f6;
                c1154l.f5906j = this.f5818i0;
                staticLayout = c1154l.m4118a();
            } catch (C1154l.a e2) {
                e2.getCause().getMessage();
                staticLayout = null;
            }
            Util.m214a(staticLayout);
            this.f5802a0 = staticLayout;
            this.f5777C = this.f5802a0.getText();
        }
    }

    /* renamed from: a */
    public void m4081a(Canvas canvas) {
        int save = canvas.save();
        if (this.f5777C == null || !this.f5803b) {
            return;
        }
        float lineStart = (this.f5830u + (this.f5812f0 > 1 ? this.f5802a0.getLineStart(0) : this.f5802a0.getLineLeft(0))) - (this.f5808d0 * 2.0f);
        this.f5787M.setTextSize(this.f5784J);
        float f = this.f5830u;
        float f2 = this.f5831v;
        boolean z = this.f5780F && this.f5781G != null;
        float f3 = this.f5783I;
        if (f3 != 1.0f && !this.f5807d) {
            canvas.scale(f3, f3, f, f2);
        }
        if (z) {
            canvas.drawBitmap(this.f5781G, f, f2, this.f5782H);
            canvas.restoreToCount(save);
            return;
        }
        if (m4096h() && (!this.f5807d || this.f5805c > this.f5811f)) {
            int alpha = this.f5787M.getAlpha();
            canvas.translate(lineStart, f2);
            float f4 = alpha;
            this.f5787M.setAlpha((int) (this.f5806c0 * f4));
            this.f5802a0.draw(canvas);
            this.f5787M.setAlpha((int) (this.f5804b0 * f4));
            int lineBaseline = this.f5802a0.getLineBaseline(0);
            CharSequence charSequence = this.f5810e0;
            float f5 = lineBaseline;
            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.f5787M);
            if (!this.f5807d) {
                java.lang.String trim = this.f5810e0.toString().trim();
                if (trim.endsWith("…")) {
                    trim = trim.substring(0, trim.length() - 1);
                }
                java.lang.String str = trim;
                this.f5787M.setAlpha(alpha);
                canvas.drawText(str, 0, Math.min(this.f5802a0.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.f5787M);
            }
        } else {
            canvas.translate(f, f2);
            this.f5802a0.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    /* renamed from: a */
    public void m4082a(Rect rect) {
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        if (m4075a(this.f5817i, i, i2, i3, i4)) {
            return;
        }
        this.f5817i.set(i, i2, i3, i4);
        this.f5786L = true;
        m4094f();
    }

    /* renamed from: a */
    public final boolean m4083a(Typeface typeface) {
        C1167a c1167a = this.f5775A;
        if (c1167a != null) {
            c1167a.f5945c = true;
        }
        if (this.f5832w == typeface) {
            return false;
        }
        this.f5832w = typeface;
        return true;
    }
}
