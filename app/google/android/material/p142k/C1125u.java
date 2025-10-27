package custom.google.android.material.p142k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Iterator;
import androidx.core.view.ViewCompat;

/* renamed from: b.e.a.a.k.u */
/* loaded from: classes.dex */
public class C1125u extends RecyclerView.Adapter<a> {

    /* renamed from: d */
    public final Context f5696d;

    /* renamed from: e */
    public final C1103a f5697e;

    /* renamed from: f */
    public final InterfaceC1108d<?> f5698f;

    /* renamed from: g */
    public final C1111g.f f5699g;

    /* renamed from: h */
    public final int f5700h;

    /* renamed from: b.e.a.a.k.u$a */
    public static class MainVM extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f5701t;

        /* renamed from: u */
        public final MaterialCalendarGridView f5702u;

        public MainVM(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            this.f5701t = (TextView) linearLayout.findViewById(R$id.month_title);
            TextView textView = this.f5701t;
            ViewCompat.d<Boolean> m1267a = ViewCompat.m1267a();
            if (m1267a.m1330b()) {
                m1267a.mo1325a((View) textView, (TextView) true);
            } else {
                m1267a.m1327a();
                if (m1267a.mo1326a(m1267a.m1329b(textView), (Boolean) true)) {
                    ViewCompat.m1314q(textView);
                    textView.setTag(m1267a.f1860a, true);
                    ViewCompat.m1295c(textView, m1267a.f1863d);
                }
            }
            this.f5702u = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z) {
                return;
            }
            this.f5701t.setVisibility(View.GONE);
        }
    }

    public C1125u(Context context, InterfaceC1108d<?> interfaceC1108d, C1103a c1103a, C1111g.f fVar) {
        C1122r c1122r = c1103a.f5584b;
        C1122r c1122r2 = c1103a.f5585c;
        C1122r c1122r3 = c1103a.f5587e;
        if (c1122r.compareTo(c1122r3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (c1122r3.compareTo(c1122r2) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int m3999b = C1111g.m3999b(context) * C1123s.f5688g;
        int dimensionPixelSize = C1118n.m4013c(context) ? context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) : 0;
        this.f5696d = context;
        this.f5700h = m3999b + dimensionPixelSize;
        this.f5697e = c1103a;
        this.f5698f = interfaceC1108d;
        this.f5699g = fVar;
        if (this.mObservable.m2878a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f3954c = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    /* renamed from: a */
    public int getItemCount() {
        return this.f5697e.f5589g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    /* renamed from: b */
    public void onBindViewHolder(a mainVMVar, int i) {
        a mainVMVar2 = mainVMVar;
        C1122r m4027b = this.f5697e.f5584b.m4027b(i);
        mainVMVar2.f5701t.setText(m4027b.m4028c(mainVMVar2.f3933a.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) mainVMVar2.f5702u.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !m4027b.equals(materialCalendarGridView.getAdapter().f5689b)) {
            C1123s c1123s = new C1123s(m4027b, this.f5698f, this.f5697e);
            materialCalendarGridView.setNumColumns(m4027b.f5684e);
            materialCalendarGridView.setAdapter((ListAdapter) c1123s);
        } else {
            materialCalendarGridView.invalidate();
            C1123s adapter = materialCalendarGridView.getAdapter();
            Iterator<Long> it = adapter.f5691d.iterator();
            while (it.hasNext()) {
                adapter.m4033a(materialCalendarGridView, it.next().longValue());
            }
            InterfaceC1108d<?> interfaceC1108d = adapter.f5690c;
            if (interfaceC1108d != null) {
                Iterator<Long> it2 = interfaceC1108d.m3995d().iterator();
                while (it2.hasNext()) {
                    adapter.m4033a(materialCalendarGridView, it2.next().longValue());
                }
                adapter.f5691d = adapter.f5690c.m3995d();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new C1124t(this, materialCalendarGridView));
    }

    /* renamed from: f */
    public C1122r m4036f(int i) {
        return this.f5697e.f5584b.m4027b(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    /* renamed from: a */
    public long mo2858a(int i) {
        return this.f5697e.f5584b.m4027b(i).f5681b.getTimeInMillis();
    }

    /* renamed from: a */
    public int m4035a(C1122r c1122r) {
        return this.f5697e.f5584b.m4026b(c1122r);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!C1118n.m4013c(viewGroup.getContext())) {
            return new MainVM(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f5700h));
        return new MainVM(linearLayout, true);
    }
}
