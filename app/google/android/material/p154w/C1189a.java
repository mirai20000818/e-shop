package custom.google.android.material.p154w;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* renamed from: b.e.a.a.w.a */
/* loaded from: classes.dex */
public class C1189a {

    /* renamed from: a */
    public C1194f.b f6100a;

    public C1189a(SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.m6039b(0.1f);
        swipeDismissBehavior.m6036a(0.6f);
        swipeDismissBehavior.m6037a(0);
    }

    /* renamed from: a */
    public void m4210a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (coordinatorLayout.m2364a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (C1194f.f6107e == null) {
                    C1194f.f6107e = new C1194f();
                }
                C1194f.f6107e.m4212a(this.f6100a);
                return;
            }
            return;
        }
        if (actionMasked == 1 || actionMasked == 3) {
            if (C1194f.f6107e == null) {
                C1194f.f6107e = new C1194f();
            }
            C1194f.f6107e.m4214b(this.f6100a);
        }
    }

    /* renamed from: a */
    public boolean m4211a(View view) {
        return view instanceof C1192d;
    }
}
