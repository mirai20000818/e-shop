package custom.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuView;
import java.util.ArrayList;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.InterfaceC0078n;
import androidx.appcompat.view.menu.SubMenuC0083s;
import androidx.core.view.C0278d0;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.annotation.p068a.C0461t;

/* renamed from: b.e.a.a.p.g */
/* loaded from: classes.dex */
public class C1149g implements InterfaceC0078n {

    /* renamed from: b */
    public NavigationMenuView f5848b;

    /* renamed from: c */
    public LinearLayout f5849c;

    /* renamed from: d */
    public InterfaceC0078n.a f5850d;

    /* renamed from: e */
    public MenuBuilder f5851e;

    /* renamed from: f */
    public int f5852f;

    /* renamed from: g */
    public c f5853g;

    /* renamed from: h */
    public LayoutInflater f5854h;

    /* renamed from: i */
    public int f5855i;

    /* renamed from: j */
    public boolean f5856j;

    /* renamed from: k */
    public ColorStateList f5857k;

    /* renamed from: l */
    public ColorStateList f5858l;

    /* renamed from: m */
    public Drawable f5859m;

    /* renamed from: n */
    public int f5860n;

    /* renamed from: o */
    public int f5861o;

    /* renamed from: p */
    public int f5862p;

    /* renamed from: q */
    public boolean f5863q;

    /* renamed from: s */
    public int f5865s;

    /* renamed from: t */
    public int f5866t;

    /* renamed from: u */
    public int f5867u;

    /* renamed from: r */
    public boolean f5864r = true;

    /* renamed from: v */
    public int f5868v = -1;

    /* renamed from: w */
    public final View.OnClickListener f5869w = new a();

    /* renamed from: b.e.a.a.p.g$a */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            C1149g.this.m4108b(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            C1149g c1149g = C1149g.this;
            boolean m463a = c1149g.f5851e.m463a(itemData, c1149g, 0);
            if (itemData != null && itemData.isCheckable() && m463a) {
                C1149g.this.f5853g.m4112a(itemData);
            } else {
                z = false;
            }
            C1149g.this.m4108b(false);
            if (z) {
                C1149g.this.mo420a(false);
            }
        }
    }

    /* renamed from: b.e.a.a.p.g$b */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* renamed from: b.e.a.a.p.g$c */
    public class c extends RecyclerView.Adapter<l> {

        /* renamed from: d */
        public final ArrayList<e> f5871d = new ArrayList<>();

        /* renamed from: e */
        public MenuItemImpl f5872e;

        /* renamed from: f */
        public boolean f5873f;

        public c() {
            m4115d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        /* renamed from: a */
        public int getItemCount() {
            return this.f5871d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        /* renamed from: a */
        public long mo2858a(int i) {
            return i;
        }

        /* renamed from: a */
        public void m4112a(MenuItemImpl menuItemImpl) {
            if (this.f5872e == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.f5872e;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.f5872e = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        /* renamed from: a */
        public void m4113a(Bundle bundle) {
            MenuItemImpl menuItemImpl;
            View actionView;
            C1151i c1151i;
            MenuItemImpl menuItemImpl2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f5873f = true;
                int size = this.f5871d.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    e eVar = this.f5871d.get(i2);
                    if ((eVar instanceof g) && (menuItemImpl2 = ((g) eVar).f5877a) != null && menuItemImpl2.f522a == i) {
                        m4112a(menuItemImpl2);
                        break;
                    }
                    i2++;
                }
                this.f5873f = false;
                m4115d();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f5871d.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    e eVar2 = this.f5871d.get(i3);
                    if ((eVar2 instanceof g) && (menuItemImpl = ((g) eVar2).f5877a) != null && (actionView = menuItemImpl.getActionView()) != null && (c1151i = (C1151i) sparseParcelableArray.get(menuItemImpl.f522a)) != null) {
                        actionView.restoreHierarchyState(c1151i);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        /* renamed from: b */
        public int getItemCount(int i) {
            e eVar = this.f5871d.get(i);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).f5877a.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        /* renamed from: c */
        public Bundle m4114c() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f5872e;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.f522a);
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f5871d.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f5871d.get(i);
                if (eVar instanceof g) {
                    MenuItemImpl menuItemImpl2 = ((g) eVar).f5877a;
                    View actionView = menuItemImpl2 != null ? menuItemImpl2.getActionView() : null;
                    if (actionView != null) {
                        C1151i c1151i = new C1151i();
                        actionView.saveHierarchyState(c1151i);
                        sparseArray.put(menuItemImpl2.f522a, c1151i);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        /* renamed from: d */
        public void mo2875d(l lVar) {
            l lVar2 = lVar;
            if (lVar2 instanceof i) {
                ((NavigationMenuItemView) lVar2.f3933a).m6179h();
            }
        }

        /* renamed from: d */
        public final void m4115d() {
            if (this.f5873f) {
                return;
            }
            this.f5873f = true;
            this.f5871d.clear();
            this.f5871d.add(new d());
            int size = C1149g.this.f5851e.m470d().size();
            boolean z = false;
            int i = 0;
            int i2 = -1;
            boolean z2 = false;
            int i3 = 0;
            while (i < size) {
                MenuItemImpl menuItemImpl = C1149g.this.f5851e.m470d().get(i);
                if (menuItemImpl.isChecked()) {
                    m4112a(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.m483b(z);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenuC0083s subMenuC0083s = menuItemImpl.f536o;
                    if (subMenuC0083s.hasVisibleItems()) {
                        if (i != 0) {
                            this.f5871d.add(new f(C1149g.this.f5867u, z ? 1 : 0));
                        }
                        this.f5871d.add(new g(menuItemImpl));
                        int size2 = subMenuC0083s.size();
                        int i4 = 0;
                        boolean z3 = false;
                        while (i4 < size2) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenuC0083s.getItem(i4);
                            if (menuItemImpl2.isVisible()) {
                                if (!z3 && menuItemImpl2.getIcon() != null) {
                                    z3 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.m483b(z);
                                }
                                if (menuItemImpl.isChecked()) {
                                    m4112a(menuItemImpl);
                                }
                                this.f5871d.add(new g(menuItemImpl2));
                            }
                            i4++;
                            z = false;
                        }
                        if (z3) {
                            int size3 = this.f5871d.size();
                            for (int size4 = this.f5871d.size(); size4 < size3; size4++) {
                                ((g) this.f5871d.get(size4)).f5878b = true;
                            }
                        }
                    }
                } else {
                    int i5 = menuItemImpl.f523b;
                    if (i5 != i2) {
                        int size5 = this.f5871d.size();
                        z2 = menuItemImpl.getIcon() != null;
                        if (i != 0) {
                            size5++;
                            ArrayList<e> arrayList = this.f5871d;
                            int i6 = C1149g.this.f5867u;
                            arrayList.add(new f(i6, i6));
                        }
                        i3 = size5;
                    } else if (!z2 && menuItemImpl.getIcon() != null) {
                        int size6 = this.f5871d.size();
                        for (int i7 = i3; i7 < size6; i7++) {
                            ((g) this.f5871d.get(i7)).f5878b = true;
                        }
                        z2 = true;
                    }
                    g gVar = new g(menuItemImpl);
                    gVar.f5878b = z2;
                    this.f5871d.add(gVar);
                    i2 = i5;
                }
                i++;
                z = false;
            }
            this.f5873f = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        /* renamed from: b */
        public void onBindViewHolder(l lVar, int i) {
            l lVar2 = lVar;
            int mo2865b = getItemCount(i);
            if (mo2865b != 0) {
                if (mo2865b == 1) {
                    ((TextView) lVar2.f3933a).setText(((g) this.f5871d.get(i)).f5877a.f526e);
                    return;
                } else {
                    if (mo2865b != 2) {
                        return;
                    }
                    f fVar = (f) this.f5871d.get(i);
                    lVar2.f3933a.setPadding(0, fVar.f5875a, 0, fVar.f5876b);
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar2.f3933a;
            navigationMenuItemView.setIconTintList(C1149g.this.f5858l);
            C1149g c1149g = C1149g.this;
            if (c1149g.f5856j) {
                navigationMenuItemView.setTextAppearance(c1149g.f5855i);
            }
            ColorStateList colorStateList = C1149g.this.f5857k;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = C1149g.this.f5859m;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            g gVar = (g) this.f5871d.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f5878b);
            navigationMenuItemView.setHorizontalPadding(C1149g.this.f5860n);
            navigationMenuItemView.setIconPadding(C1149g.this.f5861o);
            C1149g c1149g2 = C1149g.this;
            if (c1149g2.f5863q) {
                navigationMenuItemView.setIconSize(c1149g2.f5862p);
            }
            navigationMenuItemView.setMaxLines(C1149g.this.f5865s);
            navigationMenuItemView.mo504a(gVar.f5877a, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        /* renamed from: b */
        public l onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                C1149g c1149g = C1149g.this;
                return new i(c1149g.f5854h, viewGroup, c1149g.f5869w);
            }
            if (i == 1) {
                return new k(C1149g.this.f5854h, viewGroup);
            }
            if (i != 2) {
                return i != 3 ? null : new b(C1149g.this.f5849c);
            }
            return new j(C1149g.this.f5854h, viewGroup);
        }
    }

    /* renamed from: b.e.a.a.p.g$d */
    public static class d implements e {
    }

    /* renamed from: b.e.a.a.p.g$e */
    public interface e {
    }

    /* renamed from: b.e.a.a.p.g$f */
    public static class f implements e {

        /* renamed from: a */
        public final int f5875a;

        /* renamed from: b */
        public final int f5876b;

        public f(int i, int i2) {
            this.f5875a = i;
            this.f5876b = i2;
        }
    }

    /* renamed from: b.e.a.a.p.g$g */
    public static class g implements e {

        /* renamed from: a */
        public final MenuItemImpl f5877a;

        /* renamed from: b */
        public boolean f5878b;

        public g(MenuItemImpl menuItemImpl) {
            this.f5877a = menuItemImpl;
        }
    }

    /* renamed from: b.e.a.a.p.g$h */
    public class h extends C0461t {
        public h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // p000a.p067s.p068a.C0461t, p000a.p030h.p042i.C0271a
        /* renamed from: a */
        public void mo1151a(View view, AccessibilityNodeInfoCompat c0281b) {
            int i;
            int i2;
            super.mo1151a(view, c0281b);
            c cVar = C1149g.this.f5853g;
            if (C1149g.this.f5849c.getChildCount() == 0) {
                i = 0;
                i2 = 0;
            } else {
                i = 0;
                i2 = 1;
            }
            while (i < C1149g.this.f5853g.getItemCount()) {
                if (C1149g.this.f5853g.getItemCount(i) == 0) {
                    i2++;
                }
                i++;
            }
            int i3 = Build.VERSION.SDK_INT;
            c0281b.m1202a(new AccessibilityNodeInfoCompat.b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, 0, false)));
        }
    }

    /* renamed from: b.e.a.a.p.g$i */
    public static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.f3933a.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: b.e.a.a.p.g$j */
    public static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* renamed from: b.e.a.a.p.g$k */
    public static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* renamed from: b.e.a.a.p.g$l */
    public static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: a */
    public int mo415a() {
        return this.f5852f;
    }

    /* renamed from: a */
    public void m4102a(int i2) {
        this.f5860n = i2;
        mo420a(false);
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: a */
    public void mo417a(MenuBuilder menuBuilder, boolean z) {
        InterfaceC0078n.a aVar = this.f5850d;
        if (aVar != null) {
            aVar.mo152a(menuBuilder, z);
        }
    }

    /* renamed from: a */
    public void m4103a(C0278d0 c0278d0) {
        int m1166e = c0278d0.m1166e();
        if (this.f5866t != m1166e) {
            this.f5866t = m1166e;
            m4110d();
        }
        NavigationMenuView navigationMenuView = this.f5848b;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, c0278d0.m1163b());
        ViewCompat.m1265a(this.f5849c, c0278d0);
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: a */
    public void mo419a(Context context, MenuBuilder menuBuilder) {
        this.f5854h = LayoutInflater.from(context);
        this.f5851e = menuBuilder;
        this.f5867u = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    /* renamed from: a */
    public void m4104a(ColorStateList colorStateList) {
        this.f5858l = colorStateList;
        mo420a(false);
    }

    /* renamed from: a */
    public void m4105a(Drawable drawable) {
        this.f5859m = drawable;
        mo420a(false);
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: a */
    public void mo429a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f5848b.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f5853g.m4113a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f5849c.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: a */
    public void mo420a(boolean z) {
        c cVar = this.f5853g;
        if (cVar != null) {
            cVar.m4115d();
            cVar.notifyDataSetChanged();
        }
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: a */
    public boolean mo421a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: a */
    public boolean mo422a(SubMenuC0083s subMenuC0083s) {
        return false;
    }

    /* renamed from: b */
    public void m4106b(int i2) {
        this.f5861o = i2;
        mo420a(false);
    }

    /* renamed from: b */
    public void m4107b(ColorStateList colorStateList) {
        this.f5857k = colorStateList;
        mo420a(false);
    }

    /* renamed from: b */
    public void m4108b(boolean z) {
        c cVar = this.f5853g;
        if (cVar != null) {
            cVar.f5873f = z;
        }
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: b */
    public boolean mo434b() {
        return false;
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: b */
    public boolean mo424b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000a.p005b.p011d.p012i.InterfaceC0078n
    /* renamed from: c */
    public Parcelable mo435c() {
        Bundle bundle = new Bundle();
        if (this.f5848b != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f5848b.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f5853g;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.m4114c());
        }
        if (this.f5849c != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f5849c.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    /* renamed from: c */
    public void m4109c(int i2) {
        this.f5855i = i2;
        this.f5856j = true;
        mo420a(false);
    }

    /* renamed from: d */
    public final void m4110d() {
        int i2 = (this.f5849c.getChildCount() == 0 && this.f5864r) ? this.f5866t : 0;
        NavigationMenuView navigationMenuView = this.f5848b;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    /* renamed from: d */
    public void m4111d(int i2) {
        this.f5868v = i2;
        NavigationMenuView navigationMenuView = this.f5848b;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }
}
