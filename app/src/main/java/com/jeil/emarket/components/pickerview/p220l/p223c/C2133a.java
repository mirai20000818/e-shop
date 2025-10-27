package com.jeil.emarket.components.pickerview.p220l.p223c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.jeil.emarket.components.address.wheel.view.WheelView;

/* renamed from: b.f.a.c.w.l.c.a */

public final class C2133a extends GestureDetector.SimpleOnGestureListener {


    public final WheelView f8746b;

    public C2133a(WheelView wheelView) {
        this.f8746b = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f8746b.m6857a(f2);
        return true;
    }
}
