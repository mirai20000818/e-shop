package custom.google.android.material.internal;

import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: b.e.a.a.p.q */
/* loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC1159q implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        ViewCompat.m1261H(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
