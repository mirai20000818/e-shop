package custom.google.android.material.mng3;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;

/* renamed from: b.e.a.a.b.h */
/* loaded from: classes.dex */
public class C1078h {

    /* renamed from: a */
    public static final int[] f5443a = {R.attr.stateListAnimator};

    /* renamed from: a */
    public static void m3899a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* renamed from: a */
    public static void m3900a(View view, float f) {
        int integer = view.getResources().getInteger(R$integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, R$attr.state_liftable, -R$attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
