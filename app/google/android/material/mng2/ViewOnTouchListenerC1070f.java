package custom.google.android.material.mng2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;

/* renamed from: b.e.a.a.a0.f */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC1070f implements View.OnTouchListener {

    /* renamed from: b */
    public final /* synthetic */ GestureDetector f5409b;

    public ViewOnTouchListenerC1070f(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.f5409b = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f5409b.onTouchEvent(motionEvent);
        }
        return false;
    }
}
