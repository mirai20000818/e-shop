package com.jeil.emarket.widget.img;

import android.graphics.PointF;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.c.h0.d */

public class ViewOnTouchListenerEx implements View.OnTouchListener {


    public final List<Integer> f8365b = new ArrayList(40);


    public final SparseArray<PointF> f8366c = new SparseArray<>();

    
    public static float m4625a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i) - motionEvent.getX(i2);
        float y = motionEvent.getY(i) - motionEvent.getY(i2);
        return (float) Math.sqrt((y * y) + (x * x));
    }

    
    public static float m4626a(MotionEvent motionEvent, int i, int i2, boolean z) {
        int findPointerIndex = motionEvent.findPointerIndex(i);
        int findPointerIndex2 = motionEvent.findPointerIndex(i2);
        float x = motionEvent.getX(findPointerIndex) - motionEvent.getX(findPointerIndex2);
        float y = motionEvent.getY(findPointerIndex) - motionEvent.getY(findPointerIndex2);
        double atan = Math.atan(x / y);
        if ((y < 0.0f && z) || (y > 0.0f && !z)) {
            atan += 3.141592653589793d;
        }
        return (float) Math.toDegrees(atan);
    }

    
    public static void m4627a(PointF pointF, MotionEvent motionEvent, int i, int i2) {
        int findPointerIndex = motionEvent.findPointerIndex(i);
        int findPointerIndex2 = motionEvent.findPointerIndex(i2);
        pointF.set((motionEvent.getX(findPointerIndex2) + motionEvent.getX(findPointerIndex)) / 2.0f, (motionEvent.getY(findPointerIndex2) + motionEvent.getY(findPointerIndex)) / 2.0f);
    }

    
    public int m4628a(int i) {
        return this.f8365b.get(i).intValue();
    }


    public PointF m4629b(int i) {
        return this.f8366c.get(this.f8365b.get(i).intValue());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 3) {
                    this.f8365b.clear();
                    this.f8366c.clear();
                    return false;
                }
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return false;
                    }
                }
            }
            Integer valueOf = Integer.valueOf(motionEvent.getPointerId(actionIndex));
            this.f8365b.remove(valueOf);
            this.f8366c.remove(valueOf.intValue());
            return false;
        }
        Integer valueOf2 = Integer.valueOf(motionEvent.getPointerId(actionIndex));
        this.f8366c.put(valueOf2.intValue(), new PointF(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex)));
        this.f8365b.add(valueOf2);
        return false;
    }
}
