package custom.google.android.material.p153v;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: b.e.a.a.v.k */
/* loaded from: classes.dex */
public class C1185k {

    /* renamed from: a */
    public C1178d f6037a;

    /* renamed from: b */
    public C1178d f6038b;

    /* renamed from: c */
    public C1178d f6039c;

    /* renamed from: d */
    public C1178d f6040d;

    /* renamed from: e */
    public InterfaceC1177c f6041e;

    /* renamed from: f */
    public InterfaceC1177c f6042f;

    /* renamed from: g */
    public InterfaceC1177c f6043g;

    /* renamed from: h */
    public InterfaceC1177c f6044h;

    /* renamed from: i */
    public C1180f f6045i;

    /* renamed from: j */
    public C1180f f6046j;

    /* renamed from: k */
    public C1180f f6047k;

    /* renamed from: l */
    public C1180f f6048l;

    /* renamed from: b.e.a.a.v.k$c */
    public interface c {
    }

    public C1185k() {
        this.f6037a = new C1184j();
        this.f6038b = new C1184j();
        this.f6039c = new C1184j();
        this.f6040d = new C1184j();
        this.f6041e = new C1175a(0.0f);
        this.f6042f = new C1175a(0.0f);
        this.f6043g = new C1175a(0.0f);
        this.f6044h = new C1175a(0.0f);
        this.f6045i = new C1180f();
        this.f6046j = new C1180f();
        this.f6047k = new C1180f();
        this.f6048l = new C1180f();
    }

    /* renamed from: a */
    public static InterfaceC1177c m4173a(TypedArray typedArray, int i, InterfaceC1177c interfaceC1177c) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return interfaceC1177c;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new C1175a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new C1183i(peekValue.getFraction(1.0f, 1.0f)) : interfaceC1177c;
    }

    /* renamed from: a */
    public static b m4174a(Context context, int i, int i2) {
        return m4175a(context, i, i2, new C1175a(0));
    }

    /* renamed from: a */
    public C1180f m4177a() {
        return this.f6045i;
    }

    /* renamed from: a */
    public boolean m4181a(RectF rectF) {
        boolean z = this.f6048l.getClass().equals(C1180f.class) && this.f6046j.getClass().equals(C1180f.class) && this.f6045i.getClass().equals(C1180f.class) && this.f6047k.getClass().equals(C1180f.class);
        float mo4144a = this.f6041e.mo4144a(rectF);
        return z && ((this.f6042f.mo4144a(rectF) > mo4144a ? 1 : (this.f6042f.mo4144a(rectF) == mo4144a ? 0 : -1)) == 0 && (this.f6044h.mo4144a(rectF) > mo4144a ? 1 : (this.f6044h.mo4144a(rectF) == mo4144a ? 0 : -1)) == 0 && (this.f6043g.mo4144a(rectF) > mo4144a ? 1 : (this.f6043g.mo4144a(rectF) == mo4144a ? 0 : -1)) == 0) && ((this.f6038b instanceof C1184j) && (this.f6037a instanceof C1184j) && (this.f6039c instanceof C1184j) && (this.f6040d instanceof C1184j));
    }

    /* renamed from: b */
    public b m4182b() {
        return new b(this);
    }

    /* renamed from: a */
    public static b m4175a(Context context, int i, int i2, InterfaceC1177c interfaceC1177c) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            InterfaceC1177c m4173a = m4173a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, interfaceC1177c);
            InterfaceC1177c m4173a2 = m4173a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, m4173a);
            InterfaceC1177c m4173a3 = m4173a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, m4173a);
            InterfaceC1177c m4173a4 = m4173a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, m4173a);
            InterfaceC1177c m4173a5 = m4173a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, m4173a);
            b bVar = new b();
            C1178d m301b = Util.m301b(i4);
            bVar.f6049a = m301b;
            float m4183a = b.m4183a(m301b);
            if (m4183a != -1.0f) {
                bVar.m4188d(m4183a);
            }
            bVar.f6053e = m4173a2;
            C1178d m301b2 = Util.m301b(i5);
            bVar.f6050b = m301b2;
            float m4183a2 = b.m4183a(m301b2);
            if (m4183a2 != -1.0f) {
                bVar.m4189e(m4183a2);
            }
            bVar.f6054f = m4173a3;
            C1178d m301b3 = Util.m301b(i6);
            bVar.f6051c = m301b3;
            float m4183a3 = b.m4183a(m301b3);
            if (m4183a3 != -1.0f) {
                bVar.m4187c(m4183a3);
            }
            bVar.f6055g = m4173a4;
            C1178d m301b4 = Util.m301b(i7);
            bVar.f6052d = m301b4;
            float m4183a4 = b.m4183a(m301b4);
            if (m4183a4 != -1.0f) {
                bVar.m4186b(m4183a4);
            }
            bVar.f6056h = m4173a5;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public static b m4176a(Context context, AttributeSet attributeSet, int i, int i2) {
        C1175a c1175a = new C1175a(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return m4175a(context, resourceId, resourceId2, c1175a);
    }

    /* renamed from: b.e.a.a.v.k$b */
    public static final class b {

        /* renamed from: a */
        public C1178d f6049a;

        /* renamed from: b */
        public C1178d f6050b;

        /* renamed from: c */
        public C1178d f6051c;

        /* renamed from: d */
        public C1178d f6052d;

        /* renamed from: e */
        public InterfaceC1177c f6053e;

        /* renamed from: f */
        public InterfaceC1177c f6054f;

        /* renamed from: g */
        public InterfaceC1177c f6055g;

        /* renamed from: h */
        public InterfaceC1177c f6056h;

        /* renamed from: i */
        public C1180f f6057i;

        /* renamed from: j */
        public C1180f f6058j;

        /* renamed from: k */
        public C1180f f6059k;

        /* renamed from: l */
        public C1180f f6060l;

        public b() {
            this.f6049a = new C1184j();
            this.f6050b = new C1184j();
            this.f6051c = new C1184j();
            this.f6052d = new C1184j();
            this.f6053e = new C1175a(0.0f);
            this.f6054f = new C1175a(0.0f);
            this.f6055g = new C1175a(0.0f);
            this.f6056h = new C1175a(0.0f);
            this.f6057i = new C1180f();
            this.f6058j = new C1180f();
            this.f6059k = new C1180f();
            this.f6060l = new C1180f();
        }

        /* renamed from: a */
        public static float m4183a(C1178d c1178d) {
            if (c1178d instanceof C1184j) {
                return ((C1184j) c1178d).f6036a;
            }
            if (c1178d instanceof C1179e) {
                return ((C1179e) c1178d).f5986a;
            }
            return -1.0f;
        }

        /* renamed from: a */
        public b m4184a(float f) {
            m4188d(f);
            m4189e(f);
            m4187c(f);
            m4186b(f);
            return this;
        }

        /* renamed from: a */
        public C1185k m4185a() {
            return new C1185k(this, null);
        }

        /* renamed from: b */
        public b m4186b(float f) {
            this.f6056h = new C1175a(f);
            return this;
        }

        /* renamed from: c */
        public b m4187c(float f) {
            this.f6055g = new C1175a(f);
            return this;
        }

        /* renamed from: d */
        public b m4188d(float f) {
            this.f6053e = new C1175a(f);
            return this;
        }

        /* renamed from: e */
        public b m4189e(float f) {
            this.f6054f = new C1175a(f);
            return this;
        }

        public b(C1185k c1185k) {
            this.f6049a = new C1184j();
            this.f6050b = new C1184j();
            this.f6051c = new C1184j();
            this.f6052d = new C1184j();
            this.f6053e = new C1175a(0.0f);
            this.f6054f = new C1175a(0.0f);
            this.f6055g = new C1175a(0.0f);
            this.f6056h = new C1175a(0.0f);
            this.f6057i = new C1180f();
            this.f6058j = new C1180f();
            this.f6059k = new C1180f();
            this.f6060l = new C1180f();
            this.f6049a = c1185k.f6037a;
            this.f6050b = c1185k.f6038b;
            this.f6051c = c1185k.f6039c;
            this.f6052d = c1185k.f6040d;
            this.f6053e = c1185k.f6041e;
            this.f6054f = c1185k.f6042f;
            this.f6055g = c1185k.f6043g;
            this.f6056h = c1185k.f6044h;
            this.f6057i = c1185k.f6045i;
            this.f6058j = c1185k.f6046j;
            this.f6059k = c1185k.f6047k;
            this.f6060l = c1185k.f6048l;
        }
    }

    public /* synthetic */ C1185k(b bVar, a aVar) {
        this.f6037a = bVar.f6049a;
        this.f6038b = bVar.f6050b;
        this.f6039c = bVar.f6051c;
        this.f6040d = bVar.f6052d;
        this.f6041e = bVar.f6053e;
        this.f6042f = bVar.f6054f;
        this.f6043g = bVar.f6055g;
        this.f6044h = bVar.f6056h;
        this.f6045i = bVar.f6057i;
        this.f6046j = bVar.f6058j;
        this.f6047k = bVar.f6059k;
        this.f6048l = bVar.f6060l;
    }

    /* renamed from: a */
    public C1185k m4178a(float f) {
        b bVar = new b(this);
        bVar.m4188d(f);
        bVar.m4189e(f);
        bVar.m4187c(f);
        bVar.m4186b(f);
        return bVar.m4185a();
    }

    /* renamed from: a */
    public C1185k m4179a(InterfaceC1177c interfaceC1177c) {
        b bVar = new b(this);
        bVar.f6053e = interfaceC1177c;
        bVar.f6054f = interfaceC1177c;
        bVar.f6055g = interfaceC1177c;
        bVar.f6056h = interfaceC1177c;
        return bVar.m4185a();
    }

    /* renamed from: a */
    public C1185k m4180a(c cVar) {
        b bVar = new b(this);
        C1182h c1182h = (C1182h) cVar;
        bVar.f6053e = c1182h.m4172a(this.f6041e);
        bVar.f6054f = c1182h.m4172a(this.f6042f);
        bVar.f6056h = c1182h.m4172a(this.f6044h);
        bVar.f6055g = c1182h.m4172a(this.f6043g);
        return bVar.m4185a();
    }
}
