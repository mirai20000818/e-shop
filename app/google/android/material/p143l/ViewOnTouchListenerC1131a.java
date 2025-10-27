package custom.google.android.material.p143l;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: b.e.a.a.l.a */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC1131a implements View.OnTouchListener {

    /* renamed from: b */
    public final Dialog f5708b;

    /* renamed from: c */
    public final int f5709c;

    /* renamed from: d */
    public final int f5710d;

    /* renamed from: e */
    public final int f5711e;

    public ViewOnTouchListenerC1131a(Dialog dialog, Rect rect) {
        this.f5708b = dialog;
        this.f5709c = rect.left;
        this.f5710d = rect.top;
        this.f5711e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = findViewById.getLeft() + this.f5709c;
        int width = findViewById.getWidth() + left;
        if (new RectF(left, findViewById.getTop() + this.f5710d, width, findViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.f5711e;
            obtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.f5708b.onTouchEvent(obtain);
    }
}
