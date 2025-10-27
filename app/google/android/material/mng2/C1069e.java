package custom.google.android.material.mng2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.TimePickerView;

/* renamed from: b.e.a.a.a0.e */
/* loaded from: classes.dex */
public class C1069e extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: b */
    public final /* synthetic */ TimePickerView f5408b;

    public C1069e(TimePickerView timePickerView) {
        this.f5408b = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.InterfaceC3078c interfaceC3078c = this.f5408b.f11577A;
        return onDoubleTap;
    }
}
