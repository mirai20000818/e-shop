package custom.google.android.material.p140j;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: b.e.a.a.j.c */
/* loaded from: classes.dex */
public class C1100c {

    /* renamed from: j */
    public static final int f5566j;

    /* renamed from: a */
    public final a f5567a;

    /* renamed from: b */
    public final View f5568b;

    /* renamed from: c */
    public final Path f5569c;

    /* renamed from: d */
    public final Paint f5570d;

    /* renamed from: e */
    public final Paint f5571e;

    /* renamed from: f */
    public InterfaceC1101d.e f5572f;

    /* renamed from: g */
    public Drawable f5573g;

    /* renamed from: h */
    public boolean f5574h;

    /* renamed from: i */
    public boolean f5575i;

    /* renamed from: b.e.a.a.j.c$a */
    public interface a {
        /* renamed from: a */
        void mo3969a(Canvas canvas);

        /* renamed from: c */
        boolean mo3971c();
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f5566j = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1100c(a aVar) {
        this.f5567a = aVar;
        this.f5568b = (View) aVar;
        this.f5568b.setWillNotDraw(false);
        this.f5569c = new Path();
        this.f5570d = new Paint(7);
        this.f5571e = new Paint(1);
        this.f5571e.setColor(0);
    }

    /* renamed from: a */
    public final float m3972a(InterfaceC1101d.e eVar) {
        return Util.m160a(eVar.f5580a, eVar.f5581b, 0.0f, 0.0f, this.f5568b.getWidth(), this.f5568b.getHeight());
    }

    /* renamed from: a */
    public void m3973a() {
        if (f5566j == 0) {
            this.f5574h = true;
            this.f5575i = false;
            this.f5568b.buildDrawingCache();
            Bitmap drawingCache = this.f5568b.getDrawingCache();
            if (drawingCache == null && this.f5568b.getWidth() != 0 && this.f5568b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f5568b.getWidth(), this.f5568b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f5568b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f5570d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f5574h = false;
            this.f5575i = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
    
        r10.drawRect(0.0f, 0.0f, r9.f5568b.getWidth(), r9.f5568b.getHeight(), r9.f5571e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
    
        if (m3981g() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (m3981g() != false) goto L23;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3974a(android.graphics.Canvas r10) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p140j.C1100c.m3974a(android.graphics.Canvas):void");
    }

    /* renamed from: b */
    public void m3975b() {
        if (f5566j == 0) {
            this.f5575i = false;
            this.f5568b.destroyDrawingCache();
            this.f5570d.setShader(null);
            this.f5568b.invalidate();
        }
    }

    /* renamed from: b */
    public void m3976b(InterfaceC1101d.e eVar) {
        if (eVar == null) {
            this.f5572f = null;
        } else {
            InterfaceC1101d.e eVar2 = this.f5572f;
            if (eVar2 == null) {
                this.f5572f = new InterfaceC1101d.e(eVar.f5580a, eVar.f5581b, eVar.f5582c);
            } else {
                eVar2.m3983a(eVar);
            }
            if (eVar.f5582c + 1.0E-4f >= m3972a(eVar)) {
                this.f5572f.f5582c = Float.MAX_VALUE;
            }
        }
        if (f5566j == 1) {
            this.f5569c.rewind();
            InterfaceC1101d.e eVar3 = this.f5572f;
            if (eVar3 != null) {
                this.f5569c.addCircle(eVar3.f5580a, eVar3.f5581b, eVar3.f5582c, Path.Direction.CW);
            }
        }
        this.f5568b.invalidate();
    }

    /* renamed from: c */
    public int m3977c() {
        return this.f5571e.getColor();
    }

    /* renamed from: d */
    public InterfaceC1101d.e m3978d() {
        InterfaceC1101d.e eVar = this.f5572f;
        if (eVar == null) {
            return null;
        }
        InterfaceC1101d.e eVar2 = new InterfaceC1101d.e(eVar.f5580a, eVar.f5581b, eVar.f5582c);
        if (eVar2.f5582c == Float.MAX_VALUE) {
            eVar2.f5582c = m3972a(eVar2);
        }
        return eVar2;
    }

    /* renamed from: e */
    public boolean m3979e() {
        return this.f5567a.mo3971c() && !m3980f();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3980f() {
        /*
            r4 = this;
            b.e.a.a.j.d$e r0 = r4.f5572f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L17
            float r0 = r0.f5582c
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L15
            goto L17
        L15:
            r0 = 0
            goto L18
        L17:
            r0 = 1
        L18:
            int r3 = p078b.p126e.p127a.p128a.p140j.C1100c.f5566j
            if (r3 != 0) goto L24
            if (r0 != 0) goto L23
            boolean r0 = r4.f5575i
            if (r0 == 0) goto L23
            r1 = 1
        L23:
            return r1
        L24:
            r0 = r0 ^ r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p140j.C1100c.m3980f():boolean");
    }

    /* renamed from: g */
    public final boolean m3981g() {
        return (this.f5574h || Color.alpha(this.f5571e.getColor()) == 0) ? false : true;
    }
}
