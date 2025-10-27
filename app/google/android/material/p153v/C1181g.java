package custom.google.android.material.p153v;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.google.android.material.R$attr;
import java.util.BitSet;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.graphics.C0229a;
import androidx.core.graphics.drawable.TintAwareDrawable;
import custom.google.android.material.p144m.C1132a;
import custom.google.android.material.p152u.C1173a;

/* renamed from: b.e.a.a.v.g */
/* loaded from: classes.dex */
public class C1181g extends Drawable implements TintAwareDrawable, InterfaceC1188n {

    /* renamed from: x */
    public static final String f5987x = C1181g.class.getSimpleName();

    /* renamed from: y */
    public static final Paint f5988y = new Paint(1);

    /* renamed from: b */
    public b f5989b;

    /* renamed from: c */
    public final C1187m.g[] f5990c;

    /* renamed from: d */
    public final C1187m.g[] f5991d;

    /* renamed from: e */
    public final BitSet f5992e;

    /* renamed from: f */
    public boolean f5993f;

    /* renamed from: g */
    public final Matrix f5994g;

    /* renamed from: h */
    public final Path f5995h;

    /* renamed from: i */
    public final Path f5996i;

    /* renamed from: j */
    public final RectF f5997j;

    /* renamed from: k */
    public final RectF f5998k;

    /* renamed from: l */
    public final Region f5999l;

    /* renamed from: m */
    public final Region f6000m;

    /* renamed from: n */
    public C1185k f6001n;

    /* renamed from: o */
    public final Paint f6002o;

    /* renamed from: p */
    public final Paint f6003p;

    /* renamed from: q */
    public final C1173a f6004q;

    /* renamed from: r */
    public final C1186l.b f6005r;

    /* renamed from: s */
    public final C1186l f6006s;

    /* renamed from: t */
    public PorterDuffColorFilter f6007t;

    /* renamed from: u */
    public PorterDuffColorFilter f6008u;

    /* renamed from: v */
    public final RectF f6009v;

    /* renamed from: w */
    public boolean f6010w;

    /* renamed from: b.e.a.a.v.g$a */
    public class a implements C1186l.b {
        public a() {
        }
    }

    /* renamed from: b.e.a.a.v.g$b */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a */
        public C1185k f6012a;

        /* renamed from: b */
        public C1132a f6013b;

        /* renamed from: c */
        public ColorFilter f6014c;

        /* renamed from: d */
        public ColorStateList f6015d;

        /* renamed from: e */
        public ColorStateList f6016e;

        /* renamed from: f */
        public ColorStateList f6017f;

        /* renamed from: g */
        public ColorStateList f6018g;

        /* renamed from: h */
        public PorterDuff.Mode f6019h;

        /* renamed from: i */
        public Rect f6020i;

        /* renamed from: j */
        public float f6021j;

        /* renamed from: k */
        public float f6022k;

        /* renamed from: l */
        public float f6023l;

        /* renamed from: m */
        public int f6024m;

        /* renamed from: n */
        public float f6025n;

        /* renamed from: o */
        public float f6026o;

        /* renamed from: p */
        public float f6027p;

        /* renamed from: q */
        public int f6028q;

        /* renamed from: r */
        public int f6029r;

        /* renamed from: s */
        public int f6030s;

        /* renamed from: t */
        public int f6031t;

        /* renamed from: u */
        public boolean f6032u;

        /* renamed from: v */
        public Paint.Style f6033v;

        public b(b bVar) {
            this.f6015d = null;
            this.f6016e = null;
            this.f6017f = null;
            this.f6018g = null;
            this.f6019h = PorterDuff.Mode.SRC_IN;
            this.f6020i = null;
            this.f6021j = 1.0f;
            this.f6022k = 1.0f;
            this.f6024m = 255;
            this.f6025n = 0.0f;
            this.f6026o = 0.0f;
            this.f6027p = 0.0f;
            this.f6028q = 0;
            this.f6029r = 0;
            this.f6030s = 0;
            this.f6031t = 0;
            this.f6032u = false;
            this.f6033v = Paint.Style.FILL_AND_STROKE;
            this.f6012a = bVar.f6012a;
            this.f6013b = bVar.f6013b;
            this.f6023l = bVar.f6023l;
            this.f6014c = bVar.f6014c;
            this.f6015d = bVar.f6015d;
            this.f6016e = bVar.f6016e;
            this.f6019h = bVar.f6019h;
            this.f6018g = bVar.f6018g;
            this.f6024m = bVar.f6024m;
            this.f6021j = bVar.f6021j;
            this.f6030s = bVar.f6030s;
            this.f6028q = bVar.f6028q;
            this.f6032u = bVar.f6032u;
            this.f6022k = bVar.f6022k;
            this.f6025n = bVar.f6025n;
            this.f6026o = bVar.f6026o;
            this.f6027p = bVar.f6027p;
            this.f6029r = bVar.f6029r;
            this.f6031t = bVar.f6031t;
            this.f6017f = bVar.f6017f;
            this.f6033v = bVar.f6033v;
            Rect rect = bVar.f6020i;
            if (rect != null) {
                this.f6020i = new Rect(rect);
            }
        }

        public b(C1185k c1185k, C1132a c1132a) {
            this.f6015d = null;
            this.f6016e = null;
            this.f6017f = null;
            this.f6018g = null;
            this.f6019h = PorterDuff.Mode.SRC_IN;
            this.f6020i = null;
            this.f6021j = 1.0f;
            this.f6022k = 1.0f;
            this.f6024m = 255;
            this.f6025n = 0.0f;
            this.f6026o = 0.0f;
            this.f6027p = 0.0f;
            this.f6028q = 0;
            this.f6029r = 0;
            this.f6030s = 0;
            this.f6031t = 0;
            this.f6032u = false;
            this.f6033v = Paint.Style.FILL_AND_STROKE;
            this.f6012a = c1185k;
            this.f6013b = c1132a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C1181g c1181g = new C1181g(this);
            c1181g.f5993f = true;
            return c1181g;
        }
    }

    public C1181g() {
        this(new C1185k());
    }

    public C1181g(b bVar) {
        this.f5990c = new C1187m.g[4];
        this.f5991d = new C1187m.g[4];
        this.f5992e = new BitSet(8);
        this.f5994g = new Matrix();
        this.f5995h = new Path();
        this.f5996i = new Path();
        this.f5997j = new RectF();
        this.f5998k = new RectF();
        this.f5999l = new Region();
        this.f6000m = new Region();
        this.f6002o = new Paint(1);
        this.f6003p = new Paint(1);
        this.f6004q = new C1173a();
        this.f6006s = Looper.getMainLooper().getThread() == Thread.currentThread() ? C1186l.a.f6073a : new C1186l();
        this.f6009v = new RectF();
        this.f6010w = true;
        this.f5989b = bVar;
        this.f6003p.setStyle(Paint.Style.STROKE);
        this.f6002o.setStyle(Paint.Style.FILL);
        f5988y.setColor(-1);
        f5988y.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        m4170h();
        m4160a(getState());
        this.f6005r = new a();
    }

    public C1181g(C1185k c1185k) {
        this(new b(c1185k, null));
    }

    /* renamed from: a */
    public final PorterDuffColorFilter m4150a(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        int color;
        int m4149a;
        if (colorStateList == null || mode == null) {
            return (!z || (m4149a = m4149a((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(m4149a, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = m4149a(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* renamed from: a */
    public RectF m4151a() {
        this.f5997j.set(getBounds());
        return this.f5997j;
    }

    /* renamed from: a */
    public void m4152a(float f) {
        b bVar = this.f5989b;
        if (bVar.f6026o != f) {
            bVar.f6026o = f;
            m4171i();
        }
    }

    /* renamed from: a */
    public void m4155a(Context context) {
        this.f5989b.f6013b = new C1132a(context);
        m4171i();
    }

    /* renamed from: a */
    public void m4156a(ColorStateList colorStateList) {
        b bVar = this.f5989b;
        if (bVar.f6015d != colorStateList) {
            bVar.f6015d = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: a */
    public final void m4159a(RectF rectF, Path path) {
        m4164b(rectF, path);
        if (this.f5989b.f6021j != 1.0f) {
            this.f5994g.reset();
            Matrix matrix = this.f5994g;
            float f = this.f5989b.f6021j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f5994g);
        }
        path.computeBounds(this.f6009v, true);
    }

    /* renamed from: a */
    public final boolean m4160a(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f5989b.f6015d == null || color2 == (colorForState2 = this.f5989b.f6015d.getColorForState(iArr, (color2 = this.f6002o.getColor())))) {
            z = false;
        } else {
            this.f6002o.setColor(colorForState2);
            z = true;
        }
        if (this.f5989b.f6016e == null || color == (colorForState = this.f5989b.f6016e.getColorForState(iArr, (color = this.f6003p.getColor())))) {
            return z;
        }
        this.f6003p.setColor(colorForState);
        return true;
    }

    /* renamed from: b */
    public int m4161b() {
        b bVar = this.f5989b;
        return (int) (Math.sin(Math.toRadians(bVar.f6031t)) * bVar.f6030s);
    }

    /* renamed from: b */
    public void m4162b(float f) {
        b bVar = this.f5989b;
        if (bVar.f6022k != f) {
            bVar.f6022k = f;
            this.f5993f = true;
            invalidateSelf();
        }
    }

    /* renamed from: b */
    public void m4163b(ColorStateList colorStateList) {
        b bVar = this.f5989b;
        if (bVar.f6016e != colorStateList) {
            bVar.f6016e = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: b */
    public final void m4164b(RectF rectF, Path path) {
        C1186l c1186l = this.f6006s;
        b bVar = this.f5989b;
        c1186l.m4191a(bVar.f6012a, bVar.f6022k, rectF, this.f6005r, path);
    }

    /* renamed from: c */
    public int m4165c() {
        b bVar = this.f5989b;
        return (int) (Math.cos(Math.toRadians(bVar.f6031t)) * bVar.f6030s);
    }

    /* renamed from: d */
    public final float m4166d() {
        if (m4169g()) {
            return this.f6003p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b6, code lost:
    
        if (((r2.f6012a.m4181a(m4151a()) || r10.f5995h.isConvex() || android.os.Build.VERSION.SDK_INT >= 29) ? false : true) != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017a  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p153v.C1181g.draw(android.graphics.Canvas):void");
    }

    /* renamed from: e */
    public float m4167e() {
        return this.f5989b.f6012a.f6041e.mo4144a(m4151a());
    }

    /* renamed from: f */
    public float m4168f() {
        b bVar = this.f5989b;
        return bVar.f6026o + bVar.f6027p;
    }

    /* renamed from: g */
    public final boolean m4169g() {
        Paint.Style style = this.f5989b.f6033v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f6003p.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5989b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        b bVar = this.f5989b;
        if (bVar.f6028q == 2) {
            return;
        }
        if (bVar.f6012a.m4181a(m4151a())) {
            outline.setRoundRect(getBounds(), m4167e() * this.f5989b.f6022k);
            return;
        }
        m4159a(m4151a(), this.f5995h);
        if (this.f5995h.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f5995h);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f5989b.f6020i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f5999l.set(getBounds());
        m4159a(m4151a(), this.f5995h);
        this.f6000m.setPath(this.f5995h, this.f5999l);
        this.f5999l.op(this.f6000m, Region.Op.DIFFERENCE);
        return this.f5999l;
    }

    /* renamed from: h */
    public final boolean m4170h() {
        PorterDuffColorFilter porterDuffColorFilter = this.f6007t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f6008u;
        b bVar = this.f5989b;
        this.f6007t = m4150a(bVar.f6018g, bVar.f6019h, this.f6002o, true);
        b bVar2 = this.f5989b;
        this.f6008u = m4150a(bVar2.f6017f, bVar2.f6019h, this.f6003p, false);
        b bVar3 = this.f5989b;
        if (bVar3.f6032u) {
            this.f6004q.m4142a(bVar3.f6018g.getColorForState(getState(), 0));
        }
        return (Util.m317b(porterDuffColorFilter, this.f6007t) && Util.m317b(porterDuffColorFilter2, this.f6008u)) ? false : true;
    }

    /* renamed from: i */
    public final void m4171i() {
        float m4168f = m4168f();
        this.f5989b.f6029r = (int) Math.ceil(0.75f * m4168f);
        this.f5989b.f6030s = (int) Math.ceil(m4168f * 0.25f);
        m4170h();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f5993f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f5989b.f6018g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f5989b.f6017f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f5989b.f6016e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f5989b.f6015d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f5989b = new b(this.f5989b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f5993f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = m4160a(iArr) || m4170h();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        b bVar = this.f5989b;
        if (bVar.f6024m != i) {
            bVar.f6024m = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5989b.f6014c = colorFilter;
        super.invalidateSelf();
    }

    @Override // p078b.p126e.p127a.p128a.p153v.InterfaceC1188n
    public void setShapeAppearanceModel(C1185k c1185k) {
        this.f5989b.f6012a = c1185k;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f5989b.f6018g = colorStateList;
        m4170h();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f5989b;
        if (bVar.f6019h != mode) {
            bVar.f6019h = mode;
            m4170h();
            super.invalidateSelf();
        }
    }

    /* renamed from: a */
    public int m4149a(int i) {
        float m4168f = m4168f();
        b bVar = this.f5989b;
        float f = m4168f + bVar.f6025n;
        C1132a c1132a = bVar.f6013b;
        if (c1132a == null || !c1132a.f5712a) {
            return i;
        }
        if (!(C0229a.m1082b(i, 255) == c1132a.f5714c)) {
            return i;
        }
        float f2 = 0.0f;
        if (c1132a.f5715d > 0.0f && f > 0.0f) {
            f2 = Math.min(((((float) Math.log1p(f / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return C0229a.m1082b(Util.m166a(C0229a.m1082b(i, 255), c1132a.f5713b, f2), Color.alpha(i));
    }

    /* renamed from: a */
    public static C1181g m4147a(Context context, float f) {
        int m291b = Util.m291b(context, R$attr.colorSurface, C1181g.class.getSimpleName());
        C1181g c1181g = new C1181g();
        c1181g.f5989b.f6013b = new C1132a(context);
        c1181g.m4171i();
        c1181g.m4156a(ColorStateList.valueOf(m291b));
        b bVar = c1181g.f5989b;
        if (bVar.f6026o != f) {
            bVar.f6026o = f;
            c1181g.m4171i();
        }
        return c1181g;
    }

    /* renamed from: a */
    public final void m4157a(Canvas canvas) {
        if (this.f5992e.cardinality() > 0) {
            Log.w(f5987x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f5989b.f6030s != 0) {
            canvas.drawPath(this.f5995h, this.f6004q.f5975a);
        }
        for (int i = 0; i < 4; i++) {
            this.f5990c[i].mo4201a(C1187m.g.f6099a, this.f6004q, this.f5989b.f6029r, canvas);
            this.f5991d[i].mo4201a(C1187m.g.f6099a, this.f6004q, this.f5989b.f6029r, canvas);
        }
        if (this.f6010w) {
            int m4161b = m4161b();
            int m4165c = m4165c();
            canvas.translate(-m4161b, -m4165c);
            canvas.drawPath(this.f5995h, f5988y);
            canvas.translate(m4161b, m4165c);
        }
    }

    /* renamed from: a */
    public final void m4158a(Canvas canvas, Paint paint, Path path, C1185k c1185k, RectF rectF) {
        if (!c1185k.m4181a(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float mo4144a = c1185k.f6042f.mo4144a(rectF) * this.f5989b.f6022k;
            canvas.drawRoundRect(rectF, mo4144a, mo4144a, paint);
        }
    }

    /* renamed from: a */
    public void m4153a(float f, int i) {
        this.f5989b.f6023l = f;
        invalidateSelf();
        m4163b(ColorStateList.valueOf(i));
    }

    /* renamed from: a */
    public void m4154a(float f, ColorStateList colorStateList) {
        this.f5989b.f6023l = f;
        invalidateSelf();
        m4163b(colorStateList);
    }
}
