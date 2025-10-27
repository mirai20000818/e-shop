package custom.google.android.material.p142k;

import android.os.Build;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* renamed from: b.e.a.a.k.j */
/* loaded from: classes.dex */
public class C1114j extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ C1125u f5645a;

    /* renamed from: b */
    public final /* synthetic */ MaterialButton f5646b;

    /* renamed from: c */
    public final /* synthetic */ C1111g f5647c;

    public C1114j(C1111g c1111g, C1125u c1125u, MaterialButton materialButton) {
        this.f5647c = c1111g;
        this.f5645a = c1125u;
        this.f5646b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s
    /* renamed from: a */
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            CharSequence text = this.f5646b.getText();
            int i2 = Build.VERSION.SDK_INT;
            recyclerView.announceForAccessibility(text);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s
    /* renamed from: a */
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager m4004X0 = this.f5647c.m4004X0();
        int m2658P = i < 0 ? m4004X0.m2658P() : m4004X0.m2660R();
        this.f5647c.f5626e0 = this.f5645a.m4036f(m2658P);
        MaterialButton materialButton = this.f5646b;
        C1125u c1125u = this.f5645a;
        materialButton.setText(c1125u.f5697e.f5584b.m4027b(m2658P).m4028c(c1125u.f5696d));
    }
}
