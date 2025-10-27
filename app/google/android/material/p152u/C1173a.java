package custom.google.android.material.p152u;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.core.graphics.C0229a;

/* renamed from: b.e.a.a.u.a */
/* loaded from: classes.dex */
public class C1173a {

    /* renamed from: i */
    public static final int[] f5971i = new int[3];

    /* renamed from: j */
    public static final float[] f5972j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k */
    public static final int[] f5973k = new int[4];

    /* renamed from: l */
    public static final float[] f5974l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: b */
    public final Paint f5976b;

    /* renamed from: c */
    public final Paint f5977c;

    /* renamed from: d */
    public int f5978d;

    /* renamed from: e */
    public int f5979e;

    /* renamed from: f */
    public int f5980f;

    /* renamed from: g */
    public final Path f5981g = new Path();

    /* renamed from: h */
    public Paint f5982h = new Paint();

    /* renamed from: a */
    public final Paint f5975a = new Paint();

    public C1173a() {
        m4142a(-16777216);
        this.f5982h.setColor(0);
        this.f5976b = new Paint(4);
        this.f5976b.setStyle(Paint.Style.FILL);
        this.f5977c = new Paint(this.f5976b);
    }

    /* renamed from: a */
    public void m4142a(int i) {
        this.f5978d = C0229a.m1082b(i, 68);
        this.f5979e = C0229a.m1082b(i, 20);
        this.f5980f = C0229a.m1082b(i, 0);
        this.f5975a.setColor(this.f5978d);
    }

    /* renamed from: a */
    public void m4143a(Canvas canvas, Matrix matrix, RectF rectF, int i) {
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = f5971i;
        iArr[0] = this.f5980f;
        iArr[1] = this.f5979e;
        iArr[2] = this.f5978d;
        Paint paint = this.f5977c;
        float f = rectF.left;
        paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, iArr, f5972j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f5977c);
        canvas.restore();
    }
}
