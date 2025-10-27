package custom.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;

/* renamed from: b.e.a.a.q.a */
/* loaded from: classes.dex */
public class C1163a implements MenuBuilder.a {

    /* renamed from: b */
    public final /* synthetic */ NavigationView f5926b;

    public C1163a(NavigationView navigationView) {
        this.f5926b = navigationView;
    }

    @Override // p000a.p005b.p011d.p012i.C0071g.a
    /* renamed from: a */
    public void mo75a(MenuBuilder menuBuilder) {
    }

    @Override // p000a.p005b.p011d.p012i.C0071g.a
    /* renamed from: a */
    public boolean mo79a(MenuBuilder menuBuilder, MenuItem menuItem) {
        NavigationView.a aVar = this.f5926b.f5933i;
        return aVar != null && aVar.m4131a(menuItem);
    }
}
