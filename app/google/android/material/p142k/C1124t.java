package custom.google.android.material.p142k;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Iterator;

/* renamed from: b.e.a.a.k.t */
/* loaded from: classes.dex */
public class C1124t implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    public final /* synthetic */ MaterialCalendarGridView f5694b;

    /* renamed from: c */
    public final /* synthetic */ C1125u f5695c;

    public C1124t(C1125u c1125u, MaterialCalendarGridView materialCalendarGridView) {
        this.f5695c = c1125u;
        this.f5694b = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        C1123s adapter = this.f5694b.getAdapter();
        if (i >= adapter.m4030a() && i <= adapter.m4034b()) {
            C1111g.f fVar = this.f5695c.f5699g;
            long longValue = this.f5694b.getAdapter().getItem(i).longValue();
            C1111g.d dVar = (C1111g.d) fVar;
            if (((C1109e) C1111g.this.f5625d0.m3984e()).m3996a(longValue)) {
                C1111g.this.f5624c0.m3991a(longValue);
                Iterator it = C1111g.this.f5703a0.iterator();
                while (it.hasNext()) {
                    ((AbstractC1126v) it.next()).mo4019a(C1111g.this.f5624c0.m3989a());
                }
                C1111g.this.f5630i0.getAdapter().notifyDataSetChanged();
                recyclerView = C1111g.this.f5629h0;
                if (recyclerView != null) {
                    recyclerView2 = C1111g.this.f5629h0;
                    recyclerView2.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
