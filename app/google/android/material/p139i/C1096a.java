package custom.google.android.material.p139i;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* renamed from: b.e.a.a.i.a */
/* loaded from: classes.dex */
public class C1096a extends ViewOutlineProvider {

    /* renamed from: a */
    public final /* synthetic */ Chip f5499a;

    public C1096a(Chip chip) {
        this.f5499a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        C1097b c1097b = this.f5499a.f11350e;
        if (c1097b != null) {
            c1097b.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
