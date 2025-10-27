package com.anievaluate.evaluate;

import android.view.View;
import com.anievaluate.abstra.AbstractC2953a;
import com.anievaluate.abstra.AbstractC2954b;
import com.anievaluate.abstra.AbstractC2955c;
import com.anievaluate.ani.transAni.TransAni;

/* renamed from: b.g.a.h */
/* loaded from: classes.dex */
public final class C2949h {

    /* renamed from: a */
    public static AbstractC2955c<View, Float> f10637a = new f("alpha");

    /* renamed from: b */
    public static AbstractC2955c<View, Float> f10638b = new g("pivotX");

    /* renamed from: c */
    public static AbstractC2955c<View, Float> f10639c = new h("pivotY");

    /* renamed from: d */
    public static AbstractC2955c<View, Float> f10640d = new i("translationX");

    
    public static AbstractC2955c<View, Float> f10641e = new j("translationY");

    /* renamed from: f */
    public static AbstractC2955c<View, Float> f10642f = new k("rotation");

    /* renamed from: g */
    public static AbstractC2955c<View, Float> f10643g = new l("rotationX");

    /* renamed from: h */
    public static AbstractC2955c<View, Float> f10644h = new m("rotationY");

    
    public static AbstractC2955c<View, Float> f10645i = new n("scaleX");

   
    public static AbstractC2955c<View, Float> f10646j = new a("scaleY");

    
    public static AbstractC2955c<View, Integer> f10647k = new b("scrollX");

    /* renamed from: l */
    public static AbstractC2955c<View, Integer> f10648l = new c("scrollY");

    /* renamed from: m */
    public static AbstractC2955c<View, Float> f10649m = new d("x");

    /* renamed from: n */
    public static AbstractC2955c<View, Float> f10650n = new e("y");

    /* renamed from: b.g.a.h$b */
    public static class b extends AbstractC2954b<View> {
        public b(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Integer mo5810a(View obj) {
            View view = TransAni.m5828a((View) obj).f10699b.get();
            return Integer.valueOf(view == null ? 0 : view.getScrollX());
        }
    }

    /* renamed from: b.g.a.h$c */
    public static class c extends AbstractC2954b<View> {
        public c(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Integer mo5810a(View obj) {
            View view = TransAni.m5828a((View) obj).f10699b.get();
            return Integer.valueOf(view == null ? 0 : view.getScrollY());
        }
    }

    /* renamed from: b.g.a.h$a */
    public static class a extends AbstractC2953a<View> {
        public a(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10709l);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10709l != f) {
                m5828a.m5833b();
                m5828a.f10709l = f;
                m5828a.m5829a();
            }
        }
    }

    /* renamed from: b.g.a.h$d */
    public static class d extends AbstractC2953a<View> {
        public d(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            float left;
            TransAni m5828a = TransAni.m5828a((View) obj);
            if (m5828a.f10699b.get() == null) {
                left = 0.0f;
            } else {
                left = m5828a.f10710m + m5828a.f10699b.get() .getLeft();
            }
            return Float.valueOf(left);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni.m5828a(view).m5835c(f);
        }
    }

    /* renamed from: b.g.a.h$e */
    public static class e extends AbstractC2953a<View> {
        public e(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            float top;
            TransAni m5828a = TransAni.m5828a((View) obj);
            if (m5828a.f10699b.get() == null) {
                top = 0.0f;
            } else {
                top = m5828a.f10711n + m5828a.f10699b.get() .getTop();
            }
            return Float.valueOf(top);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni.m5828a(view).m5836d(f);
        }
    }

    /* renamed from: b.g.a.h$f */
    public static class f extends AbstractC2953a<View> {
        public f(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10702e);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10702e != f) {
                m5828a.f10702e = f;
                View view2 = m5828a.f10699b.get();
                if (view2 != null) {
                    view2.invalidate();
                }
            }
        }
    }

    /* renamed from: b.g.a.h$g */
    public static class g extends AbstractC2953a<View> {
        public g(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10703f);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10701d && m5828a.f10703f == f) {
                return;
            }
            m5828a.m5833b();
            m5828a.f10701d = true;
            m5828a.f10703f = f;
            m5828a.m5829a();
        }
    }

    /* renamed from: b.g.a.h$h */
    public static class h extends AbstractC2953a<View> {
        public h(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10704g);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10701d && m5828a.f10704g == f) {
                return;
            }
            m5828a.m5833b();
            m5828a.f10701d = true;
            m5828a.f10704g = f;
            m5828a.m5829a();
        }
    }

    /* renamed from: b.g.a.h$i */
    public static class i extends AbstractC2953a<View> {
        public i(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10710m);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni.m5828a(view).m5830a(f);
        }
    }

    /* renamed from: b.g.a.h$j */
    public static class j extends AbstractC2953a<View> {
        public j(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10711n);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni.m5828a(view).m5834b(f);
        }
    }

    /* renamed from: b.g.a.h$k */
    public static class k extends AbstractC2953a<View> {
        public k(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10707j);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10707j != f) {
                m5828a.m5833b();
                m5828a.f10707j = f;
                m5828a.m5829a();
            }
        }
    }

    /* renamed from: b.g.a.h$l */
    public static class l extends AbstractC2953a<View> {
        public l(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10705h);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10705h != f) {
                m5828a.m5833b();
                m5828a.f10705h = f;
                m5828a.m5829a();
            }
        }
    }

    /* renamed from: b.g.a.h$m */
    public static class m extends AbstractC2953a<View> {
        public m(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10706i);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10706i != f) {
                m5828a.m5833b();
                m5828a.f10706i = f;
                m5828a.m5829a();
            }
        }
    }

    /* renamed from: b.g.a.h$n */
    public static class n extends AbstractC2953a<View> {
        public n(String str) {
            super(str);
        }

        @Override // p078b.p268g.p270b.AbstractC2955c
        /* renamed from: a */
        public Float mo5810a(View obj) {
            return Float.valueOf(TransAni.m5828a((View) obj).f10708k);
        }

        @Override // p078b.p268g.p270b.AbstractC2953a
        /* renamed from: a */
        public void mo5811a(View view, float f) {
            TransAni m5828a = TransAni.m5828a(view);
            if (m5828a.f10708k != f) {
                m5828a.m5833b();
                m5828a.f10708k = f;
                m5828a.m5829a();
            }
        }
    }
}
