package custom.google.android.material.mng1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;
import androidx.p020e.C0160h;

import com.jeil.emarket.custom.CustomString;

/* renamed from: b.e.a.a.a.g */
/* loaded from: classes.dex */
public class ObjAniManager {

    /* renamed from: a */
    public final C0160h<java.lang.String, InterManager> f5389a = new C0160h<>();

    /* renamed from: b */
    public final C0160h<java.lang.String, PropertyValuesHolder[]> f5390b = new C0160h<>();

    /* renamed from: a */
    public static ObjAniManager m3869a(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return m3871a(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return m3871a(arrayList);
        } catch (Exception e2) {
            StringBuilder m3163a = CustomString.format("Can't load animation resource ID #0x");
            m3163a.append(Integer.toHexString(i));
            Log.w("MotionSpec", m3163a.toString(), e2);
            return null;
        }
    }

    /* renamed from: a */
    public static ObjAniManager m3870a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return m3869a(context, resourceId);
    }

    /* renamed from: a */
    public static ObjAniManager m3871a(List<Animator> list) {
        ObjAniManager objAniManager = new ObjAniManager();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            objAniManager.f5390b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            java.lang.String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            InterManager interManager = new InterManager(startDelay, duration, interpolator);
            interManager.f5394d = objectAnimator.getRepeatCount();
            interManager.f5395e = objectAnimator.getRepeatMode();
            objAniManager.f5389a.put(propertyName, interManager);
        }
        return objAniManager;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjAniManager) {
            return this.f5389a.equals(((ObjAniManager) obj).f5389a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5389a.hashCode();
    }

    public java.lang.String toString() {
        StringBuilder m3162a = CustomString.m3162a('\n');
        m3162a.append(ObjAniManager.class.getName());
        m3162a.append('{');
        m3162a.append(Integer.toHexString(System.identityHashCode(this)));
        m3162a.append(" timings: ");
        m3162a.append(this.f5389a);
        m3162a.append("}\n");
        return m3162a.toString();
    }

    /* renamed from: a */
    public InterManager m3872a(java.lang.String str) {
        if (this.f5389a.getOrDefault(str, null) != null) {
            return this.f5389a.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }
}
