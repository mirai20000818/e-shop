package custom.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Build;
import android.view.ViewTreeObserver;
import custom.google.android.material.internal.C1149g;

/* renamed from: b.e.a.a.q.b */
/* loaded from: classes.dex */
public class ViewTreeObserverOnGlobalLayoutListenerC1164b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b */
    public final /* synthetic */ NavigationView f5927b;

    public ViewTreeObserverOnGlobalLayoutListenerC1164b(NavigationView navigationView) {
        this.f5927b = navigationView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Activity activity;
        NavigationView navigationView = this.f5927b;
        navigationView.getLocationOnScreen(navigationView.f5935k);
        boolean z = this.f5927b.f5935k[1] == 0;
        C1149g c1149g = this.f5927b.f5932h;
        if (c1149g.f5864r != z) {
            c1149g.f5864r = z;
            c1149g.m4110d();
        }
        this.f5927b.setDrawTopInsetForeground(z);
        Context context = this.f5927b.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity != null) {
            int i = Build.VERSION.SDK_INT;
            this.f5927b.setDrawBottomInsetForeground((activity.findViewById(R.id.content).getHeight() == this.f5927b.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
        }
    }
}
