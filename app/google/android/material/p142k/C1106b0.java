package custom.google.android.material.p142k;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: b.e.a.a.k.b0 */
/* loaded from: classes.dex */
public class C1106b0 extends RecyclerView.Adapter<a> {

    /* renamed from: d */
    public final C1111g<?> f5604d;

    /* renamed from: b.e.a.a.k.b0$a */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f5605t;

        public a(TextView textView) {
            super(textView);
            this.f5605t = textView;
        }
    }

    public C1106b0(C1111g<?> c1111g) {
        this.f5604d = c1111g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    /* renamed from: a */
    public int getItemCount() {
        return this.f5604d.m4000T0().f5588f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        int i2 = this.f5604d.m4000T0().f5584b.f5683d + i;
        String string = aVar2.f5605t.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        aVar2.f5605t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        aVar2.f5605t.setContentDescription(String.format(string, Integer.valueOf(i2)));
        C1107c m4001U0 = this.f5604d.m4001U0();
        Calendar m4043b = C1130z.m4043b();
        C1105b c1105b = m4043b.get(1) == i2 ? m4001U0.f5611f : m4001U0.f5609d;
        Iterator<Long> it = this.f5604d.m4003W0().m3995d().iterator();
        while (it.hasNext()) {
            m4043b.setTimeInMillis(it.next().longValue());
            if (m4043b.get(1) == i2) {
                c1105b = m4001U0.f5610e;
            }
        }
        c1105b.m3986a(aVar2.f5605t);
        aVar2.f5605t.setOnClickListener(new ViewOnClickListenerC1104a0(this, i2));
    }

    /* renamed from: f */
    public int m3987f(int i) {
        return i - this.f5604d.m4000T0().f5584b.f5683d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
