package custom.google.android.material.mng3;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.C0278d0;
import androidx.core.view.ViewCompat;

/* renamed from: b.e.a.a.b.e */
/* loaded from: classes.dex */
public abstract class AbstractC1075e extends C1076f<View> {

    /* renamed from: d */
    public final Rect f5429d;

    /* renamed from: e */
    public final Rect f5430e;

    /* renamed from: f */
    public int f5431f;

    /* renamed from: g */
    public int f5432g;

    public AbstractC1075e() {
        this.f5429d = new Rect();
        this.f5430e = new Rect();
        this.f5431f = 0;
    }

    public AbstractC1075e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5429d = new Rect();
        this.f5430e = new Rect();
        this.f5431f = 0;
    }

    /* renamed from: a */
    public final int m3887a(View view) {
        if (this.f5432g == 0) {
            return 0;
        }
        float mo3889b = mo3889b(view);
        int i = this.f5432g;
        return Util.m167a((int) (mo3889b * i), 0, i);
    }

    /* renamed from: a */
    public abstract View mo3888a(List<View> list);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0572c
    /* renamed from: a */
    public boolean mo2390a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View mo3888a;
        C0278d0 lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (mo3888a = mo3888a(coordinatorLayout.m2365b(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.m1307j(mo3888a) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size = lastWindowInsets.m1163b() + lastWindowInsets.m1166e() + size;
        }
        int mo3892c = mo3892c(mo3888a) + size;
        int measuredHeight = mo3888a.getMeasuredHeight();
        if (m3895m()) {
            view.setTranslationY(-measuredHeight);
        } else {
            mo3892c -= measuredHeight;
        }
        coordinatorLayout.m2356a(view, i, i2, View.MeasureSpec.makeMeasureSpec(mo3892c, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    /* renamed from: b */
    public abstract float mo3889b(View view);

    /* renamed from: b */
    public final void m3890b(int i) {
        this.f5432g = i;
    }

    @Override // p078b.p126e.p127a.p128a.p131b.C1076f
    /* renamed from: b */
    public void mo3891b(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        View mo3888a = mo3888a(coordinatorLayout.m2365b(view));
        if (mo3888a != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f5429d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, mo3888a.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((mo3888a.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            C0278d0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.m1307j(coordinatorLayout) && !ViewCompat.m1307j(view)) {
                rect.left = lastWindowInsets.m1164c() + rect.left;
                rect.right -= lastWindowInsets.m1165d();
            }
            Rect rect2 = this.f5430e;
            int i3 = layoutParams.gravity;
            int i4 = i3 == 0 ? 8388659 : i3;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i5 = Build.VERSION.SDK_INT;
            Gravity.apply(i4, measuredWidth, measuredHeight, rect, rect2, i);
            int m3887a = m3887a(mo3888a);
            view.layout(rect2.left, rect2.top - m3887a, rect2.right, rect2.bottom - m3887a);
            i2 = rect2.top - mo3888a.getBottom();
        } else {
            coordinatorLayout.m2372c(view, i);
            i2 = 0;
        }
        this.f5431f = i2;
    }

    /* renamed from: c */
    public int mo3892c(View view) {
        return view.getMeasuredHeight();
    }

    /* renamed from: k */
    public final int m3893k() {
        return this.f5432g;
    }

    /* renamed from: l */
    public final int m3894l() {
        return this.f5431f;
    }

    /* renamed from: m */
    public boolean m3895m() {
        return false;
    }
}
