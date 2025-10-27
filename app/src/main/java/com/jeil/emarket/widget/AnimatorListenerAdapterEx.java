package com.jeil.emarket.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import java.util.Collections;

/* renamed from: b.f.a.c.t */

public class AnimatorListenerAdapterEx extends AnimatorListenerAdapter {

    
    public final  View f8594a;


    public final  ViewOnTouchListenerC2092s f8595b;

    public AnimatorListenerAdapterEx(ViewOnTouchListenerC2092s viewOnTouchListenerC2092s, View view) {
        this.f8595b = viewOnTouchListenerC2092s;
        this.f8594a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ViewOnTouchListenerC2092s viewOnTouchListenerC2092s = this.f8595b;
        viewOnTouchListenerC2092s.f8571k--;
        if (viewOnTouchListenerC2092s.f8571k == 0) {
            Collections.sort(viewOnTouchListenerC2092s.f8570j);
            this.f8595b.f8567g.mo4365a(this.f8594a);
            ViewOnTouchListenerC2092s viewOnTouchListenerC2092s2 = this.f8595b;
            viewOnTouchListenerC2092s2.f8577q = -1;
            for (ViewOnTouchListenerC2092s.f fVar : viewOnTouchListenerC2092s2.f8570j) {
                fVar.f8593c.setAlpha(1.0f);
                boolean z = this.f8595b.f8568h;
                View view = fVar.f8593c;
                if (z) {
                    view.setTranslationY(0.0f);
                } else {
                    view.setTranslationX(0.0f);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f8595b.f8566f.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f8595b.f8570j.clear();
        }
    }
}
