package custom.google.android.material.mng1;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.jeil.emarket.custom.CustomString;

/* renamed from: b.e.a.a.a.a */
/* loaded from: classes.dex */
public class AnimationUtils {

    /* renamed from: a */
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();

    /* renamed from: b */
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();

    /* renamed from: c */
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();

    /* renamed from: d */
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

    /* renamed from: e */
    public static final TimeInterpolator f5380e = new DecelerateInterpolator();

    /* renamed from: a */
    public static float lerp(float f, float f2, float f3) {
        return CustomString.m3148a(f2, f, f3, f);
    }

    /* renamed from: a */
    public static float lerp(float f, float f2, float f3, float f4, float f5) {
        return f5 < f3 ? f : f5 > f4 ? f2 : lerp(f, f2, (f5 - f3) / (f4 - f3));
    }
}
