package com.jeil.emarket.widget.loading.other;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.c.g0.b.d */

public abstract class Loading {


    public View f8327a;


    public List<Animator> f8328b;

    /* renamed from: b.f.a.c.g0.b.d$a */
    public enum a {
        START,
        END,
        CANCEL
    }


    public int m4611a() {
        View view = this.f8327a;
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }


    public void m4612a(a aVar) {
        List<Animator> list = this.f8328b;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animator animator = this.f8328b.get(i);
            boolean isRunning = animator.isRunning();
            int ordinal = aVar.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2 && isRunning) {
                        animator.cancel();
                    }
                } else if (isRunning) {
                    animator.end();
                }
            } else if (!isRunning) {
                animator.start();
            }
        }
    }


    public void m4613b() {
        final LodingObj lodingObj = (LodingObj) this;
        ArrayList arrayList = new ArrayList();
        int[] iArr = {0, 120, 240, 360, 480, 600, 720, 780, 840};
        for (int i = 0; i < 8; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i]);
            ofFloat.addUpdateListener(new LoadingAni(lodingObj, i));
            ofFloat.start();
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 77, 255);
            ofInt.setDuration(1000L);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay(iArr[i]);
            int finalI = i;
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.f.a.c.g0.b.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    lodingObj.m4610a(finalI, valueAnimator);
                }
            });
            ofInt.start();
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
        }
        this.f8328b = arrayList;
    }
}
