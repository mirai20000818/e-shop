package custom.google.android.material.mng1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

import com.jeil.emarket.custom.CustomString;

/* renamed from: b.e.a.a.a.h */
/* loaded from: classes.dex */
public class InterManager {

    /* renamed from: a */
    public long f5391a;

    /* renamed from: b */
    public long f5392b;

    /* renamed from: c */
    public TimeInterpolator f5393c;

    /* renamed from: d */
    public int f5394d;

    /* renamed from: e */
    public int f5395e;

    public InterManager(long j, long j2) {
        this.f5391a = 0L;
        this.f5392b = 300L;
        this.f5393c = null;
        this.f5394d = 0;
        this.f5395e = 1;
        this.f5391a = j;
        this.f5392b = j2;
    }

    public InterManager(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f5391a = 0L;
        this.f5392b = 300L;
        this.f5393c = null;
        this.f5394d = 0;
        this.f5395e = 1;
        this.f5391a = j;
        this.f5392b = j2;
        this.f5393c = timeInterpolator;
    }

    /* renamed from: a */
    public TimeInterpolator m3873a() {
        TimeInterpolator timeInterpolator = this.f5393c;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    /* renamed from: a */
    public void m3874a(Animator animator) {
        animator.setStartDelay(this.f5391a);
        animator.setDuration(this.f5392b);
        animator.setInterpolator(m3873a());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f5394d);
            valueAnimator.setRepeatMode(this.f5395e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterManager)) {
            return false;
        }
        InterManager interManager = (InterManager) obj;
        if (this.f5391a == interManager.f5391a && this.f5392b == interManager.f5392b && this.f5394d == interManager.f5394d && this.f5395e == interManager.f5395e) {
            return m3873a().getClass().equals(interManager.m3873a().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j = this.f5391a;
        long j2 = this.f5392b;
        return ((((m3873a().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.f5394d) * 31) + this.f5395e;
    }

    public java.lang.String toString() {
        StringBuilder m3162a = CustomString.m3162a('\n');
        m3162a.append(InterManager.class.getName());
        m3162a.append('{');
        m3162a.append(Integer.toHexString(System.identityHashCode(this)));
        m3162a.append(" delay: ");
        m3162a.append(this.f5391a);
        m3162a.append(" duration: ");
        m3162a.append(this.f5392b);
        m3162a.append(" interpolator: ");
        m3162a.append(m3873a().getClass());
        m3162a.append(" repeatCount: ");
        m3162a.append(this.f5394d);
        m3162a.append(" repeatMode: ");
        return CustomString.m3159a(m3162a, this.f5395e, "}\n");
    }
}
