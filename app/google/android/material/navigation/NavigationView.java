package custom.google.android.material.navigation;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.internal.NavigationMenuView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.p007b.p008a.C0052a;
import androidx.appcompat.view.C0062f;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.InterfaceC0078n;
import androidx.core.content.ContextCompat;
import androidx.core.view.C0278d0;
import androidx.customview.view.AbsSavedState;
import custom.google.android.material.internal.C1148f;
import custom.google.android.material.internal.C1149g;
import custom.google.android.material.internal.C1152j;
import custom.google.android.material.p153v.C1181g;

/* renamed from: b.e.a.a.q.c */
/* loaded from: classes.dex */
public class NavigationView extends C1152j {

    /* renamed from: n */
    public static final int[] f5928n = {R.attr.state_checked};

    /* renamed from: o */
    public static final int[] f5929o = {-16842910};

    /* renamed from: p */
    public static final int f5930p = R$style.Widget_Design_NavigationView;

    /* renamed from: g */
    public final C1148f f5931g;

    /* renamed from: h */
    public final C1149g f5932h;

    /* renamed from: i */
    public a f5933i;

    /* renamed from: j */
    public final int f5934j;

    /* renamed from: k */
    public final int[] f5935k;

    /* renamed from: l */
    public MenuInflater f5936l;

    /* renamed from: m */
    public ViewTreeObserver.OnGlobalLayoutListener f5937m;

    /* renamed from: b.e.a.a.q.c$a */
    public interface a {
        /* renamed from: a */
        boolean m4131a(MenuItem menuItem);
    }

    /* renamed from: b.e.a.a.q.c$b */
    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: d */
        public Bundle f5938d;

        /* renamed from: b.e.a.a.q.c$b$a */
        public static class a implements Parcelable.ClassLoaderCreator<b> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new b[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5938d = parcel.readBundle(classLoader);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // p000a.p048j.p049a.AbstractC0321a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1933b, i);
            parcel.writeBundle(this.f5938d);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NavigationView(android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p126e.p127a.p128a.p148q.C1165c.<init>(android.content.Context):void");
    }

    private MenuInflater getMenuInflater() {
        if (this.f5936l == null) {
            this.f5936l = new C0062f(getContext());
        }
        return this.f5936l;
    }

    /* renamed from: a */
    public final ColorStateList m4128a(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList m372b = C0052a.m372b(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = m372b.getDefaultColor();
        return new ColorStateList(new int[][]{f5929o, f5928n, FrameLayout.EMPTY_STATE_SET}, new int[]{m372b.getColorForState(f5929o, defaultColor), i2, defaultColor});
    }

    @Override // p078b.p126e.p127a.p128a.p147p.C1152j
    /* renamed from: a */
    public void mo4116a(C0278d0 c0278d0) {
        this.f5932h.m4103a(c0278d0);
    }

    /* renamed from: b */
    public View m4129b(int i) {
        C1149g c1149g = this.f5932h;
        View inflate = c1149g.f5854h.inflate(i, (ViewGroup) c1149g.f5849c, false);
        c1149g.f5849c.addView(inflate);
        NavigationMenuView navigationMenuView = c1149g.f5848b;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
        return inflate;
    }

    /* renamed from: c */
    public void m4130c(int i) {
        this.f5932h.m4108b(true);
        getMenuInflater().inflate(i, this.f5931g);
        this.f5932h.m4108b(false);
        this.f5932h.mo420a(false);
    }

    public MenuItem getCheckedItem() {
        return this.f5932h.f5853g.f5872e;
    }

    public int getHeaderCount() {
        return this.f5932h.f5849c.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.f5932h.f5859m;
    }

    public int getItemHorizontalPadding() {
        return this.f5932h.f5860n;
    }

    public int getItemIconPadding() {
        return this.f5932h.f5861o;
    }

    public ColorStateList getItemIconTintList() {
        return this.f5932h.f5858l;
    }

    public int getItemMaxLines() {
        return this.f5932h.f5865s;
    }

    public ColorStateList getItemTextColor() {
        return this.f5932h.f5857k;
    }

    public Menu getMenu() {
        return this.f5931g;
    }

    @Override // p078b.p126e.p127a.p128a.p147p.C1152j, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof C1181g) {
            Util.m249a((View) this, (C1181g) background);
        }
    }

    @Override // p078b.p126e.p127a.p128a.p147p.C1152j, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f5937m);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int min;
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                min = this.f5934j;
            }
            super.onMeasure(i, i2);
        }
        min = Math.min(View.MeasureSpec.getSize(i), this.f5934j);
        i = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f1933b);
        this.f5931g.m465b(bVar.f5938d);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable mo435c;
        b bVar = new b(super.onSaveInstanceState());
        bVar.f5938d = new Bundle();
        C1148f c1148f = this.f5931g;
        Bundle bundle = bVar.f5938d;
        if (!c1148f.f509w.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator<WeakReference<InterfaceC0078n>> it = c1148f.f509w.iterator();
            while (it.hasNext()) {
                WeakReference<InterfaceC0078n> next = it.next();
                InterfaceC0078n interfaceC0078n = next.get();
                if (interfaceC0078n == null) {
                    c1148f.f509w.remove(next);
                } else {
                    int mo415a = interfaceC0078n.mo415a();
                    if (mo415a > 0 && (mo435c = interfaceC0078n.mo435c()) != null) {
                        sparseArray.put(mo415a, mo435c);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
        return bVar;
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f5931g.findItem(i);
        if (findItem != null) {
            this.f5932h.f5853g.m4112a((MenuItemImpl) findItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        int i = Build.VERSION.SDK_INT;
        super.setElevation(f);
        Util.m244a(this, f);
    }

    public void setItemBackground(Drawable drawable) {
        C1149g c1149g = this.f5932h;
        c1149g.f5859m = drawable;
        c1149g.mo420a(false);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.m1065c(getContext(), i));
    }

    public void setItemHorizontalPadding(int i) {
        C1149g c1149g = this.f5932h;
        c1149g.f5860n = i;
        c1149g.mo420a(false);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.f5932h.m4102a(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(int i) {
        C1149g c1149g = this.f5932h;
        c1149g.f5861o = i;
        c1149g.mo420a(false);
    }

    public void setItemIconPaddingResource(int i) {
        this.f5932h.m4106b(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(int i) {
        C1149g c1149g = this.f5932h;
        if (c1149g.f5862p != i) {
            c1149g.f5862p = i;
            c1149g.f5863q = true;
            c1149g.mo420a(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        C1149g c1149g = this.f5932h;
        c1149g.f5858l = colorStateList;
        c1149g.mo420a(false);
    }

    public void setItemMaxLines(int i) {
        C1149g c1149g = this.f5932h;
        c1149g.f5865s = i;
        c1149g.mo420a(false);
    }

    public void setItemTextAppearance(int i) {
        C1149g c1149g = this.f5932h;
        c1149g.f5855i = i;
        c1149g.f5856j = true;
        c1149g.mo420a(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        C1149g c1149g = this.f5932h;
        c1149g.f5857k = colorStateList;
        c1149g.mo420a(false);
    }

    public void setNavigationItemSelectedListener(a aVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        C1149g c1149g = this.f5932h;
        if (c1149g != null) {
            c1149g.f5868v = i;
            NavigationMenuView navigationMenuView = c1149g.f5848b;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f5931g.findItem(menuItem.getItemId());
        if (findItem == null) {
            throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        }
        this.f5932h.f5853g.m4112a((MenuItemImpl) findItem);
    }
}
