package com.jeil.emarket.components.itemdecor;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: b.f.a.c.f0.c */

public class ItemDecoration3 extends RecyclerView.ItemDecoration {


    public final int f8312a;


    public final int f8313b;

    
    public final boolean f8314c;

    
    public final boolean f8315d;

    public ItemDecoration3(int i, int i2, boolean z) {
        this.f8312a = i;
        this.f8313b = i2;
        this.f8314c = z;
        this.f8315d = false;
    }

    public ItemDecoration3(int i, int i2, boolean z, boolean z2) {
        this.f8312a = i;
        this.f8313b = i2;
        this.f8314c = z;
        this.f8315d = z2;
    }

//    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
//
//    public void mo2894a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0638z c0638z) {
//        int m2785e = recyclerView.m2785e(view);
//        int i = m2785e % this.f8312a;
//        if (this.f8315d) {
//            i = ((m2785e - ((XRecyclerView) recyclerView).arrayList.size()) - 1) % this.f8312a;
//        }
//        if (!this.f8314c) {
//            int i2 = this.f8313b;
//            int i3 = this.f8312a;
//            rect.left = (i * i2) / i3;
//            rect.right = i2 - (((i + 1) * i2) / i3);
//            if (m2785e >= i3) {
//                rect.top = i2;
//                return;
//            }
//            return;
//        }
//        int i4 = this.f8313b;
//        int i5 = this.f8312a;
//        rect.left = i4 - ((i * i4) / i5);
//        rect.right = ((i + 1) * i4) / i5;
//        if (m2785e < i5) {
//            rect.top = i4;
//        }
//        rect.bottom = this.f8313b;
//        if (this.f8315d) {
//            XRecyclerView xRecyclerView = (XRecyclerView) recyclerView;
//            if (m2785e < xRecyclerView.arrayList.size() + 1) {
//                rect.top = 0;
//                int i6 = this.f8313b;
//                rect.left = i6;
//                rect.right = i6;
//            }
//            int size = xRecyclerView.arrayList.size() + ((RecyclerView.Adapter) Objects.requireNonNull(recyclerView.getAdapter())).getItemCount() + 1;
//            if (m2785e > size || m2785e == size) {
//                rect.bottom = 0;
//            }
//            if (xRecyclerView.arrayList.size() >= m2785e || m2785e >= this.f8312a) {
//                return;
//            }
//            rect.top = 0;
//        }
//    }
}
