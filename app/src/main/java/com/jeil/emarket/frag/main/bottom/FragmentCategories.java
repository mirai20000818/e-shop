package com.jeil.emarket.frag.main.bottom;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.model.customer.Category;
import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.category.CategorySubAdapter;
import com.jeil.emarket.adapters.category.CategoryTopAdapter;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.viewmodel.CategoryVM;

/* renamed from: b.f.a.g.b.b.t0 */

public class FragmentCategories extends Fragment {

    /* renamed from: a0 */
    public CategoryTopAdapter f9351a0;

    /* renamed from: b0 */
    public CategorySubAdapter f9352b0;

    /* renamed from: c0 */
    public Handler f9353c0 = new Handler();

    /* renamed from: d0 */
    public Runnable f9354d0;

    /* renamed from: e0 */
    public List<Category> f9355e0;

    /* renamed from: b.f.a.g.b.b.t0$a */
    public class a extends GridLayoutManager.AbstractC0605c {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.AbstractC0605c

        public int mo2647a(int i) {
            return FragmentCategories.this.f9352b0.getItemCount(i) == 2 ? 3 : 1;
        }
    }

    /* renamed from: S0 */
    public void m4971S0() {
        CategoryVM.listMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.c
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentCategories.this.m4974a((List) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_categories, viewGroup, false);
        ((TextViewBold) inflate.findViewById(R.id.tv_header_title)).setText(R.string.categories);
        m4978d(inflate);
        m4977c(inflate);
        CustomString.m3167a(inflate, R.id.mrl_header_cart, 0, R.id.header_border, 8);
        m4971S0();
        m4979e(inflate);
        m4980f(inflate);
        return inflate;
    }


    public void m4972a(View view, int i) {
        List<Category> list;
        CategoryTopAdapter c1781e;
        int i2;
        if (this.f9351a0.selpos == i || (list = this.f9355e0) == null || list.size() <= i || (i2 = (c1781e = this.f9351a0).selpos) == i) {
            return;
        }
        c1781e.selpos = i;
        c1781e.notifyItemChanged(i2);
        c1781e.notifyItemRangeChanged(i, 1);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_sub_category);
        if (recyclerView != null) {
            recyclerView.mo2803i(0);
        }
        Category category = this.f9355e0.get(i);
        final ArrayList arrayList = new ArrayList();
        this.f9352b0.f7144f = category.img;
        Category category2 = new Category();
        category2.name = getResources().getString(R.string.all_products);
        category2.f12393id = category.f12393id;
        category2.children = category.children;
        category2.tree = category.tree;
        category2.type = category.type;
        arrayList.add(category2);
        List<Category> list2 = category.children;
        if (list2 != null) {
            for (Category category3 : list2) {
                if (category3.productsCount != 0) {
                    arrayList.add(category3);
                    if (category3.children != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < category3.children.size(); i3++) {
                            if (category3.children.get(i3).productsCount != 0) {
                                arrayList2.add(category3.children.get(i3));
                            }
                        }
                        arrayList.addAll(arrayList2);
                    }
                }
            }
        }
        if (arrayList.size() > 30) {
            this.f9352b0.addAll(arrayList.subList(0, 29));
            this.f9353c0.removeCallbacks(this.f9354d0);
            this.f9354d0 = new Runnable() { // from class: b.f.a.g.b.b.f
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentCategories.this.m4976b(arrayList);
                }
            };
            this.f9353c0.postDelayed(this.f9354d0, Status.time * 2);
            return;
        }
        CategorySubAdapter c1780d = this.f9352b0;
        c1780d.arrayList = arrayList;
        c1780d.notifyDataSetChanged();
        this.f9353c0.removeCallbacks(this.f9354d0);
    }


    public  void m4973a(View view, Integer num) {
        m4972a(view, num.intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */

    public  void m4974a(List list) {
        if (list != null) {
            int i = (m2553n() == null || !m2553n().containsKey("pos")) ? 0 : m2553n().getInt("pos");
            this.f9355e0 = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((Category) list.get(i2)).productsCount != 0) {
                    this.f9355e0.add(list.get(i2));
                }
            }
            this.f9351a0.addAll((List) this.f9355e0);
            CategoryVM.m5580a(i);
        }
    }


    public  boolean m4975a(View view, int i, java.lang.String str, int i2) {
        m4972a(view, i);
        CategoryVM.m5580a(i);
        return true;
    }

    
    public  void m4976b(List list) {
        CategorySubAdapter c1780d = this.f9352b0;
        c1780d.arrayList = list;
        c1780d.notifyDataSetChanged();
    }

    
    public void m4977c(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_sub_category);
        BaseActivity activityC1391g1 = (BaseActivity) getActivity();
        this.f9352b0 = new CategorySubAdapter(activityC1391g1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) activityC1391g1, 3, 1, false);
        gridLayoutManager.m2616a(new a());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(this.f9352b0);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);
    }

    
    public void m4978d(final View view) {
        BaseInterface2 baseInterface2 = new BaseInterface2() { // from class: b.f.a.g.b.b.e
            @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

            public final boolean mo4808a(int i, java.lang.String str, int i2) {
                return FragmentCategories.this.m4975a(view, i, str, i2);
            }
        };
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_top_category);
        this.f9351a0 = new CategoryTopAdapter((BaseActivity) getActivity(), baseInterface2);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) );
        recyclerView.setAdapter(this.f9351a0);
        recyclerView.setNestedScrollingEnabled(false);
    }

    
    public void m4979e(final View view) {
        CategoryVM.f10387e.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.d
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentCategories.this.m4973a(view, (Integer) obj);
            }
        });
    }

    /* renamed from: f */
    public void m4980f(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity.bottomNavigationView != null) {
            view.findViewById(R.id.ll_main_content).setPadding(0, 0, 0, (int) getResources().getDimension(R.dimen.bottom_height));
        }
        mainActivity.setClickEvent(view);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public void mo1703p0() {
        this.f3653G = true;
        this.f9353c0.removeCallbacks(this.f9354d0);
    }
}
