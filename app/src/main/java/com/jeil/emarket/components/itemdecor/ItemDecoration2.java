package com.jeil.emarket.components.itemdecor;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: b.f.a.c.f0.b */

public class ItemDecoration2 extends RecyclerView.ItemDecoration {


    public int f8307a;

    
    public int f8308b;

    
    public boolean f8309c;

    
    public boolean f8310d;

    
    public boolean f8311e;

    public ItemDecoration2(int i, int i2, boolean z) {
        this.f8310d = false;
        this.f8311e = false;
        this.f8307a = i;
        this.f8308b = i2;
        this.f8309c = z;
    }

//    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
//
//    public void mo2894a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0638z c0638z) {
//        int m2836c = recyclerView.m2797h(view).m2836c();
//        int m3036a = c0638z.m3036a();
//        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//        if (this.f8308b == -1) {
//            this.f8308b = layoutManager instanceof GridLayoutManager ? 2 : layoutManager.mo2684a() ? 0 : 1;
//        }
//        int i = this.f8308b;
//        if (i == 0) {
//            rect.left = m2836c == 0 ? 0 : this.f8307a;
//            rect.right = 0;
//            rect.top = 0;
//            rect.bottom = 0;
//            if (this.f8309c) {
//                int i2 = this.f8307a;
//                rect.left = i2;
//                if (m2836c != m3036a - 1) {
//                    i2 = 0;
//                }
//                rect.right = i2;
//                if (this.f8310d && m2836c == 0) {
//                    rect.left = 0;
//                    return;
//                }
//                return;
//            }
//            return;
//        }
//        if (i != 1) {
//            if (i == 2 && (layoutManager instanceof GridLayoutManager)) {
//                int m2625a0 = ((GridLayoutManager) layoutManager).m2625a0();
//                int i3 = m3036a / m2625a0;
//                int i4 = this.f8307a;
//                rect.left = i4;
//                if (m2836c % m2625a0 != m2625a0 - 1) {
//                    i4 = 0;
//                }
//                rect.right = i4;
//                int i5 = this.f8307a;
//                rect.top = i5;
//                if (m2836c / m2625a0 != i3 - 1) {
//                    i5 = 0;
//                }
//                rect.bottom = i5;
//                return;
//            }
//            return;
//        }
//        rect.left = 0;
//        rect.right = 0;
//        rect.top = m2836c == 0 ? 0 : this.f8307a;
//        rect.bottom = 0;
//        if (this.f8309c) {
//            int i6 = this.f8307a;
//            rect.top = i6;
//            int i7 = m3036a - 1;
//            if (m2836c != i7) {
//                i6 = 0;
//            }
//            rect.bottom = i6;
//            if (this.f8310d) {
//                if (m2836c == 0) {
//                    rect.top = 0;
//                }
//                if (m2836c == i7) {
//                    rect.bottom = 0;
//                }
//                if (SimpleVM.f8836d && !this.f8311e && m2836c == m3036a - 2) {
//                    rect.top = 0;
//                }
//            }
//        }
//    }

    public ItemDecoration2(int i, int i2, boolean z, boolean z2) {
        this.f8310d = false;
        this.f8311e = false;
        this.f8307a = i;
        this.f8308b = i2;
        this.f8309c = z;
        this.f8310d = z2;
    }

    public ItemDecoration2(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.f8310d = false;
        this.f8311e = false;
        this.f8311e = z3;
        this.f8307a = i;
        this.f8308b = i2;
        this.f8309c = z;
        this.f8310d = z2;
    }
}
