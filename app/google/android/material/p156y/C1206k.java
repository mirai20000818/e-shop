package custom.google.android.material.p156y;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.C0114l0;

/* renamed from: b.e.a.a.y.k */
/* loaded from: classes.dex */
public class C1206k implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    public final /* synthetic */ C1207l f6195b;

    public C1206k(C1207l c1207l) {
        this.f6195b = c1207l;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item;
        C1207l c1207l = this.f6195b;
        if (i < 0) {
            C0114l0 c0114l0 = c1207l.f6196e;
            item = !c0114l0.mo439d() ? null : c0114l0.f782d.getSelectedItem();
        } else {
            item = c1207l.getAdapter().getItem(i);
        }
        this.f6195b.m4261a(item);
        AdapterView.OnItemClickListener onItemClickListener = this.f6195b.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                C0114l0 c0114l02 = this.f6195b.f6196e;
                view = !c0114l02.mo439d() ? null : c0114l02.f782d.getSelectedView();
                C0114l0 c0114l03 = this.f6195b.f6196e;
                i = !c0114l03.mo439d() ? -1 : c0114l03.f782d.getSelectedItemPosition();
                C0114l0 c0114l04 = this.f6195b.f6196e;
                j = !c0114l04.mo439d() ? Long.MIN_VALUE : c0114l04.f782d.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.f6195b.f6196e.f782d, view, i, j);
        }
        this.f6195b.f6196e.dismiss();
    }
}
