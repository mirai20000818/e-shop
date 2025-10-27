package custom.google.android.material.p142k;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import androidx.core.p041h.C0267b;

/* renamed from: b.e.a.a.k.h */
/* loaded from: classes.dex */
public class C1112h extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    public final Calendar f5641a = C1130z.m4045c();

    /* renamed from: b */
    public final Calendar f5642b = C1130z.m4045c();

    /* renamed from: c */
    public final /* synthetic */ C1111g f5643c;

    public C1112h(C1111g c1111g) {
        this.f5643c = c1111g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /* renamed from: a */
    public void mo2893a(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0638z c0638z) {
        if ((recyclerView.getAdapter() instanceof C1106b0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            C1106b0 c1106b0 = (C1106b0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (C0267b<Long, Long> c0267b : this.f5643c.f5624c0.m3993b()) {
                Long l = c0267b.f1753a;
                if (l != null && c0267b.f1754b != null) {
                    this.f5641a.setTimeInMillis(l.longValue());
                    this.f5642b.setTimeInMillis(c0267b.f1754b.longValue());
                    int m3987f = c1106b0.m3987f(this.f5641a.get(1));
                    int m3987f2 = c1106b0.m3987f(this.f5642b.get(1));
                    View findViewByPosition = gridLayoutManager.findViewByPosition(m3987f);
                    View findViewByPosition2 = gridLayoutManager.findViewByPosition(m3987f2);
                    int m2625a0 = m3987f / gridLayoutManager.m2625a0();
                    int m2625a02 = m3987f2 / gridLayoutManager.m2625a0();
                    for (int i = m2625a0; i <= m2625a02; i++) {
                        View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.m2625a0() * i);
                        if (findViewByPosition3 != null) {
                            int top = this.f5643c.f5628g0.f5609d.f5598a.top + findViewByPosition3.getTop();
                            int bottom = findViewByPosition3.getBottom() - this.f5643c.f5628g0.f5609d.f5598a.bottom;
                            canvas.drawRect(i == m2625a0 ? (findViewByPosition.getWidth() / 2) + findViewByPosition.getLeft() : 0, top, i == m2625a02 ? (findViewByPosition2.getWidth() / 2) + findViewByPosition2.getLeft() : recyclerView.getWidth(), bottom, this.f5643c.f5628g0.f5613h);
                        }
                    }
                }
            }
        }
    }
}
