package custom.google.android.material.p153v;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* renamed from: b.e.a.a.v.l */
/* loaded from: classes.dex */
public class C1186l {

    /* renamed from: a */
    public final C1187m[] f6061a = new C1187m[4];

    /* renamed from: b */
    public final Matrix[] f6062b = new Matrix[4];

    /* renamed from: c */
    public final Matrix[] f6063c = new Matrix[4];

    /* renamed from: d */
    public final PointF f6064d = new PointF();

    /* renamed from: e */
    public final Path f6065e = new Path();

    /* renamed from: f */
    public final Path f6066f = new Path();

    /* renamed from: g */
    public final C1187m f6067g = new C1187m();

    /* renamed from: h */
    public final float[] f6068h = new float[2];

    /* renamed from: i */
    public final float[] f6069i = new float[2];

    /* renamed from: j */
    public final Path f6070j = new Path();

    /* renamed from: k */
    public final Path f6071k = new Path();

    /* renamed from: l */
    public boolean f6072l = true;

    /* renamed from: b.e.a.a.v.l$a */
    public static class a {

        /* renamed from: a */
        public static final C1186l f6073a = new C1186l();
    }

    /* renamed from: b.e.a.a.v.l$b */
    public interface b {
    }

    public C1186l() {
        for (int i = 0; i < 4; i++) {
            this.f6061a[i] = new C1187m();
            this.f6062b[i] = new Matrix();
            this.f6063c[i] = new Matrix();
        }
    }

    /* renamed from: a */
    public final float m4190a(int i) {
        return (i + 1) * 90;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024f A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4191a(custom.google.android.material.p153v.C1185k r17, float r18, android.graphics.RectF r19, custom.google.android.material.p153v.C1186l.b r20, android.graphics.Path r21) {
        /*
            Method dump skipped, instructions count: 623
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p153v.C1186l.m4191a(b.e.a.a.v.k, float, android.graphics.RectF, b.e.a.a.v.l$b, android.graphics.Path):void");
    }

    /* renamed from: a */
    public final boolean m4192a(Path path, int i) {
        this.f6071k.reset();
        this.f6061a[i].m4198a(this.f6062b[i], this.f6071k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f6071k.computeBounds(rectF, true);
        path.op(this.f6071k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
