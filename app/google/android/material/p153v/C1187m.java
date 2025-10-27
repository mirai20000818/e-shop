package custom.google.android.material.p153v;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import custom.google.android.material.p152u.C1173a;

/* renamed from: b.e.a.a.v.m */
/* loaded from: classes.dex */
public class C1187m {

    /* renamed from: a */
    @Deprecated
    public float f6074a;

    /* renamed from: b */
    @Deprecated
    public float f6075b;

    /* renamed from: c */
    @Deprecated
    public float f6076c;

    /* renamed from: d */
    @Deprecated
    public float f6077d;

    /* renamed from: e */
    @Deprecated
    public float f6078e;

    /* renamed from: f */
    @Deprecated
    public float f6079f;

    /* renamed from: g */
    public final List<f> f6080g = new ArrayList();

    /* renamed from: h */
    public final List<g> f6081h = new ArrayList();

    /* renamed from: i */
    public boolean f6082i;

    /* renamed from: b.e.a.a.v.m$a */
    public class a extends g {

        /* renamed from: b */
        public final /* synthetic */ List f6083b;

        /* renamed from: c */
        public final /* synthetic */ Matrix f6084c;

        public a(C1187m c1187m, List list, Matrix matrix) {
            this.f6083b = list;
            this.f6084c = matrix;
        }

        @Override // p078b.p126e.p127a.p128a.p153v.C1187m.g
        /* renamed from: a */
        public void mo4201a(Matrix matrix, C1173a c1173a, int i, Canvas canvas) {
            Iterator it = this.f6083b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).mo4201a(this.f6084c, c1173a, i, canvas);
            }
        }
    }

    /* renamed from: b.e.a.a.v.m$b */
    public static class b extends g {

        /* renamed from: b */
        public final d f6085b;

        public b(d dVar) {
            this.f6085b = dVar;
        }

        @Override // p078b.p126e.p127a.p128a.p153v.C1187m.g
        /* renamed from: a */
        public void mo4201a(Matrix matrix, C1173a c1173a, int i, Canvas canvas) {
            float f = this.f6085b.f6094f;
            float m4208d = this.f6085b.m4208d();
            RectF rectF = new RectF(this.f6085b.m4206b(), this.f6085b.m4209e(), this.f6085b.m4207c(), this.f6085b.m4204a());
            boolean z = m4208d < 0.0f;
            Path path = c1173a.f5981g;
            if (z) {
                int[] iArr = C1173a.f5973k;
                iArr[0] = 0;
                iArr[1] = c1173a.f5980f;
                iArr[2] = c1173a.f5979e;
                iArr[3] = c1173a.f5978d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, m4208d);
                path.close();
                float f2 = -i;
                rectF.inset(f2, f2);
                int[] iArr2 = C1173a.f5973k;
                iArr2[0] = 0;
                iArr2[1] = c1173a.f5978d;
                iArr2[2] = c1173a.f5979e;
                iArr2[3] = c1173a.f5980f;
            }
            float width = rectF.width() / 2.0f;
            if (width <= 0.0f) {
                return;
            }
            float f3 = 1.0f - (i / width);
            float[] fArr = C1173a.f5974l;
            fArr[1] = f3;
            fArr[2] = ((1.0f - f3) / 2.0f) + f3;
            c1173a.f5976b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, C1173a.f5973k, C1173a.f5974l, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas.scale(1.0f, rectF.height() / rectF.width());
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, c1173a.f5982h);
            }
            canvas.drawArc(rectF, f, m4208d, true, c1173a.f5976b);
            canvas.restore();
        }
    }

    /* renamed from: b.e.a.a.v.m$d */
    public static class d extends f {

        /* renamed from: h */
        public static final RectF f6089h = new RectF();

        /* renamed from: b */
        @Deprecated
        public float f6090b;

        /* renamed from: c */
        @Deprecated
        public float f6091c;

        /* renamed from: d */
        @Deprecated
        public float f6092d;

        /* renamed from: e */
        @Deprecated
        public float f6093e;

        /* renamed from: f */
        @Deprecated
        public float f6094f;

        /* renamed from: g */
        @Deprecated
        public float f6095g;

        public d(float f, float f2, float f3, float f4) {
            this.f6090b = f;
            this.f6091c = f2;
            this.f6092d = f3;
            this.f6093e = f4;
        }

        /* renamed from: a */
        public final float m4204a() {
            return this.f6093e;
        }

        /* renamed from: b */
        public final float m4206b() {
            return this.f6090b;
        }

        /* renamed from: c */
        public final float m4207c() {
            return this.f6092d;
        }

        /* renamed from: d */
        public final float m4208d() {
            return this.f6095g;
        }

        /* renamed from: e */
        public final float m4209e() {
            return this.f6091c;
        }

        @Override // p078b.p126e.p127a.p128a.p153v.C1187m.f
        /* renamed from: a */
        public void mo4205a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f6098a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f6089h.set(this.f6090b, this.f6091c, this.f6092d, this.f6093e);
            path.arcTo(f6089h, this.f6094f, this.f6095g, false);
            path.transform(matrix);
        }
    }

    /* renamed from: b.e.a.a.v.m$e */
    public static class e extends f {

        /* renamed from: b */
        public float f6096b;

        /* renamed from: c */
        public float f6097c;

        @Override // p078b.p126e.p127a.p128a.p153v.C1187m.f
        /* renamed from: a */
        public void mo4205a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f6098a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f6096b, this.f6097c);
            path.transform(matrix);
        }
    }

    /* renamed from: b.e.a.a.v.m$f */
    public static abstract class f {

        /* renamed from: a */
        public final Matrix f6098a = new Matrix();

        /* renamed from: a */
        public abstract void mo4205a(Matrix matrix, Path path);
    }

    /* renamed from: b.e.a.a.v.m$g */
    public static abstract class g {

        /* renamed from: a */
        public static final Matrix f6099a = new Matrix();

        /* renamed from: a */
        public abstract void mo4201a(Matrix matrix, C1173a c1173a, int i, Canvas canvas);
    }

    public C1187m() {
        m4196a(0.0f, 0.0f, 270.0f, 0.0f);
    }

    /* renamed from: a */
    public void m4197a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.f6094f = f6;
        dVar.f6095g = f7;
        this.f6080g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        m4194a(f6);
        this.f6081h.add(bVar);
        this.f6078e = f9;
        double d2 = f8;
        this.f6076c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.f6077d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    /* renamed from: a */
    public void m4198a(Matrix matrix, Path path) {
        int size = this.f6080g.size();
        for (int i = 0; i < size; i++) {
            this.f6080g.get(i).mo4205a(matrix, path);
        }
    }

    /* renamed from: a */
    public boolean m4199a() {
        return this.f6082i;
    }

    /* renamed from: b */
    public void m4200b(float f2, float f3) {
        m4196a(f2, f3, 270.0f, 0.0f);
    }

    /* renamed from: b.e.a.a.v.m$c */
    public static class c extends g {

        /* renamed from: b */
        public final e f6086b;

        /* renamed from: c */
        public final float f6087c;

        /* renamed from: d */
        public final float f6088d;

        public c(e eVar, float f, float f2) {
            this.f6086b = eVar;
            this.f6087c = f;
            this.f6088d = f2;
        }

        @Override // p078b.p126e.p127a.p128a.p153v.C1187m.g
        /* renamed from: a */
        public void mo4201a(Matrix matrix, C1173a c1173a, int i, Canvas canvas) {
            e eVar = this.f6086b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(eVar.f6097c - this.f6088d, eVar.f6096b - this.f6087c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f6087c, this.f6088d);
            matrix2.preRotate(m4202a());
            c1173a.m4143a(canvas, matrix2, rectF, i);
        }

        /* renamed from: a */
        public float m4202a() {
            e eVar = this.f6086b;
            return (float) Math.toDegrees(Math.atan((eVar.f6097c - this.f6088d) / (eVar.f6096b - this.f6087c)));
        }
    }

    /* renamed from: a */
    public final void m4194a(float f2) {
        float f3 = this.f6078e;
        if (f3 == f2) {
            return;
        }
        float f4 = ((f2 - f3) + 360.0f) % 360.0f;
        if (f4 > 180.0f) {
            return;
        }
        float f5 = this.f6076c;
        float f6 = this.f6077d;
        d dVar = new d(f5, f6, f5, f6);
        dVar.f6094f = this.f6078e;
        dVar.f6095g = f4;
        this.f6081h.add(new b(dVar));
        this.f6078e = f2;
    }

    /* renamed from: a */
    public g m4193a(Matrix matrix) {
        m4194a(this.f6079f);
        return new a(this, new ArrayList(this.f6081h), new Matrix(matrix));
    }

    /* renamed from: a */
    public void m4195a(float f2, float f3) {
        e eVar = new e();
        eVar.f6096b = f2;
        eVar.f6097c = f3;
        this.f6080g.add(eVar);
        c cVar = new c(eVar, this.f6076c, this.f6077d);
        float m4202a = cVar.m4202a() + 270.0f;
        float m4202a2 = cVar.m4202a() + 270.0f;
        m4194a(m4202a);
        this.f6081h.add(cVar);
        this.f6078e = m4202a2;
        this.f6076c = f2;
        this.f6077d = f3;
    }

    /* renamed from: a */
    public void m4196a(float f2, float f3, float f4, float f5) {
        this.f6074a = f2;
        this.f6075b = f3;
        this.f6076c = f2;
        this.f6077d = f3;
        this.f6078e = f4;
        this.f6079f = (f4 + f5) % 360.0f;
        this.f6080g.clear();
        this.f6081h.clear();
        this.f6082i = false;
    }
}
