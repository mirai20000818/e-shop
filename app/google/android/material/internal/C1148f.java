package custom.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* renamed from: b.e.a.a.p.f */
/* loaded from: classes.dex */
public class C1148f extends MenuBuilder {
    public C1148f(Context context) {
        super(context);
    }

    @Override // p000a.p005b.p011d.p012i.C0071g, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) m449a(i, i2, i3, charSequence);
        C1150h c1150h = new C1150h(this.f487a, this, menuItemImpl);
        menuItemImpl.f536o = c1150h;
        c1150h.setHeaderTitle(menuItemImpl.f526e);
        return c1150h;
    }
}
