package custom.google.android.material.mng3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/* renamed from: b.e.a.a.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC1074d<V extends View> extends C1076f<V> {

    /* renamed from: d */
    public Runnable f5419d;

    /* renamed from: e */
    public OverScroller f5420e;

    /* renamed from: f */
    public boolean f5421f;

    /* renamed from: g */
    public int f5422g;

    /* renamed from: h */
    public int f5423h;

    /* renamed from: i */
    public int f5424i;

    /* renamed from: j */
    public VelocityTracker f5425j;

    /* renamed from: b.e.a.a.b.d$a */
    public class a implements Runnable {

        /* renamed from: b */
        public final CoordinatorLayout f5426b;

        /* renamed from: c */
        public final V f5427c;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f5426b = coordinatorLayout;
            this.f5427c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f5427c == null || (overScroller = AbstractC1074d.this.f5420e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                AbstractC1074d.this.mo3885c(this.f5426b, this.f5427c);
                return;
            }
            AbstractC1074d abstractC1074d = AbstractC1074d.this;
            abstractC1074d.m3884c(this.f5426b, (CoordinatorLayout) this.f5427c, abstractC1074d.f5420e.getCurrY());
            ViewCompat.m1282a(this.f5427c, this);
        }
    }

    public AbstractC1074d() {
        this.f5422g = -1;
        this.f5424i = -1;
    }

    public AbstractC1074d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5422g = -1;
        this.f5424i = -1;
    }

    /* renamed from: a */
    public final int m3878a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo3882b(coordinatorLayout, v, mo3886k() - i, i2, i3);
    }

    /* renamed from: a */
    public abstract boolean mo3879a(V v);

    /* renamed from: a */
    public final boolean m3880a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.f5419d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f5419d = null;
        }
        if (this.f5420e == null) {
            this.f5420e = new OverScroller(v.getContext());
        }
        this.f5420e.fling(0, m3897j(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.f5420e.computeScrollOffset()) {
            mo3885c(coordinatorLayout, v);
            return false;
        }
        this.f5419d = new a(coordinatorLayout, v);
        ViewCompat.m1282a(v, this.f5419d);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c
    /* renamed from: a */
    public boolean mo2393a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f5424i < 0) {
            this.f5424i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f5421f) {
            int i = this.f5422g;
            if (i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f5423h) > this.f5424i) {
                this.f5423h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f5422g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            this.f5421f = mo3879a((AbstractC1074d<V>) v) && coordinatorLayout.m2364a(v, x, y2);
            if (this.f5421f) {
                this.f5423h = y2;
                this.f5422g = motionEvent.getPointerId(0);
                if (this.f5425j == null) {
                    this.f5425j = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f5420e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f5420e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f5425j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* renamed from: b */
    public abstract int mo3881b(V v);

    /* renamed from: b */
    public abstract int mo3882b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo2398b(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f5422g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f5423h = r12
            goto L4c
        L2d:
            int r0 = r11.f5422g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f5423h
            int r7 = r1 - r0
            r11.f5423h = r0
            int r8 = r11.mo3881b(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.m3878a(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f5425j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f5425j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f5425j
            int r4 = r11.f5422g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.mo3883c(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.m3880a(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f5421f = r3
            r11.f5422g = r1
            android.view.VelocityTracker r13 = r11.f5425j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f5425j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f5425j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f5421f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p131b.AbstractC1074d.mo2398b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: c */
    public abstract int mo3883c(V v);

    /* renamed from: c */
    public int m3884c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo3882b(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* renamed from: c */
    public abstract void mo3885c(CoordinatorLayout coordinatorLayout, V v);

    /* renamed from: k */
    public abstract int mo3886k();
}
