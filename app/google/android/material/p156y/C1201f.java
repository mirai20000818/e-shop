package custom.google.android.material.p156y;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import custom.google.android.material.p153v.C1181g;
import custom.google.android.material.p153v.C1185k;

/* renamed from: b.e.a.a.y.f */
/* loaded from: classes.dex */
public class C1201f extends C1181g {

    /* renamed from: A */
    public final RectF f6134A;

    /* renamed from: B */
    public int f6135B;

    /* renamed from: z */
    public final Paint f6136z;

    public C1201f() {
        this(null);
    }

    public C1201f(C1185k c1185k) {
        super(c1185k == null ? new C1185k() : c1185k);
        this.f6136z = new Paint(1);
        this.f6136z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6136z.setColor(-1);
        this.f6136z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f6134A = new RectF();
    }

    /* renamed from: a */
    public void m4223a(float f, float f2, float f3, float f4) {
        RectF rectF = this.f6134A;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        this.f6134A.set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m4224a(RectF rectF) {
        m4223a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* renamed from: a */
    public final boolean m4225a(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // p078b.p126e.p127a.p128a.p153v.C1181g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (m4225a(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            int i = Build.VERSION.SDK_INT;
            this.f6135B = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.f6134A, this.f6136z);
        if (m4225a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f6135B);
    }
}
