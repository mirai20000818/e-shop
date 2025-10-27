package custom.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: b.e.a.a.p.c */
/* loaded from: classes.dex */
public class C1145c {

    /* renamed from: a */
    public static final ThreadLocal<Matrix> f5836a = new ThreadLocal<>();

    /* renamed from: b */
    public static final ThreadLocal<RectF> f5837b = new ThreadLocal<>();

    /* renamed from: a */
    public static void m4097a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix = f5836a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f5836a.set(matrix);
        } else {
            matrix.reset();
        }
        m4098a(viewGroup, view, matrix);
        RectF rectF = f5837b.get();
        if (rectF == null) {
            rectF = new RectF();
            f5837b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    public static void m4098a(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            m4098a(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
