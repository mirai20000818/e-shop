package custom.google.android.material.p134d;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* renamed from: b.e.a.a.d.b */
/* loaded from: classes.dex */
public class C1086b extends FloatingActionButton.AbstractC3055a {

    /* renamed from: a */
    public final /* synthetic */ int f5450a;

    /* renamed from: b */
    public final /* synthetic */ BottomAppBar f5451b;

    /* renamed from: b.e.a.a.d.b$a */
    public class a extends FloatingActionButton.AbstractC3055a {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.AbstractC3055a
        /* renamed from: b */
        public void mo3902b(FloatingActionButton floatingActionButton) {
            BottomAppBar.m6044b(C1086b.this.f5451b);
        }
    }

    public C1086b(BottomAppBar bottomAppBar, int i) {
        this.f5451b = bottomAppBar;
        this.f5450a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.AbstractC3055a
    /* renamed from: a */
    public void mo3901a(FloatingActionButton floatingActionButton) {
        float m6055d;
        m6055d = this.f5451b.m6055d(this.f5450a);
        floatingActionButton.setTranslationX(m6055d);
        floatingActionButton.m6163b(new a());
    }
}
