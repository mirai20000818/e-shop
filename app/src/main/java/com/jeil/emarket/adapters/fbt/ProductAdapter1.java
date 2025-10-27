package com.jeil.emarket.adapters.fbt;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.ShopCategoryFilter;
import com.jeil.emarket.model.vendor.Vendor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.b.h.t */

public class ProductAdapter1<T> extends BaseMainAdapter<T, ProductAdapter1.MainVH> {

    /* renamed from: h */
    public int f7635h;

    
    public int f7636i;

   
    public int f7637j;

    
    public BaseInterface2 f7638k;

    /* renamed from: l */
    public RecyclerView f7639l;

    /* renamed from: m */
    public View view;

    /* renamed from: n */
    public List<T> tList;

    /* renamed from: b.f.a.b.h.t$a */
    public class MainAni extends Animation {
        public MainAni() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            int i;
            super.applyTransformation(f, transformation);
            ViewGroup.LayoutParams layoutParams = ProductAdapter1.this.f7639l.getLayoutParams();
            if (f == 1.0f) {
                i = -2;
            } else {
               // i = ((Boolean) Objects.requireNonNull(ProductAdapter1.this.booleanMutableLiveData.getValue())).booleanValue() ? ((int) ((r2 - r1) * f)) + c1880t.f7637j : c1880t.f7636i - ((int) ((r2 - r1) * f));
            }
            //layoutParams.height = i;
            ProductAdapter1.this.f7639l.requestLayout();
        }

//        @Override // android.view.animation.Animation
//        public Animation clone() {
//            return super.clone();
//        }
//
//        @Override // android.view.animation.Animation
//        public Object clone() {
//            return super.clone();
//        }
    }

    /* renamed from: b.f.a.b.h.t$b */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ProductAdapter1.this.f7639l.getLayoutParams().height = ((Boolean) Objects.requireNonNull(ProductAdapter1.this.booleanMutableLiveData.getValue())).booleanValue() ? ProductAdapter1.this.f7636i : ProductAdapter1.this.f7637j;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ProductAdapter1.this.f7639l.getLayoutParams().height = ((Boolean) Objects.requireNonNull(ProductAdapter1.this.booleanMutableLiveData.getValue())).booleanValue() ? ProductAdapter1.this.f7637j : ProductAdapter1.this.f7636i;
        }
    }

    /* renamed from: b.f.a.b.h.t$c */
    public static class MainVH extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final ButtonToggle f7644t;

        public MainVH(View view) {
            super(view);
            this.f7644t = (ButtonToggle) view.findViewById(R.id.cb_ok);
        }
    }

    public ProductAdapter1(BaseActivity activityC1391g1, RecyclerView recyclerView, int i, View view, BaseInterface2 baseInterface2) {
        super(activityC1391g1, i);
        this.f7635h = -1;
        this.f7636i = 0;
        this.f7637j = 0;
        this.tList = new ArrayList();
        this.f7638k = baseInterface2;
        this.view = view;
        this.f7639l = recyclerView;
    }


    public  void m4494a(MainVH mainVHVar, int i, View view) {
        ButtonToggle buttonToggle = mainVHVar.f7644t;
        if (buttonToggle.f12185G) {
            buttonToggle.m6897e();
            this.f7635h = -1;
            m4498f(-1);
        } else {
            buttonToggle.m6896d();
            this.f7635h = i;
            m4498f(i);
        }
    }

    @Override // p078b.p159f.p160a.p178b.p180b.AbstractC1770c

    public void addAll(List<T> list) {
        int size = list.size();
        int i = this.pos;
        if (size > i) {
            super.addAll((List) list.subList(0, i));
            View view = this.view;
            if (view != null) {
                view.setVisibility(View.VISIBLE);
            }
            this.tList.addAll(list);
            return;
        }
        this.arrayList = list;
        this.notifyDataSetChanged();
        View view2 = this.view;
        if (view2 != null) {
            view2.setVisibility(View.GONE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009b  */
    //@Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */


    
    public void m4495d() {
        this.booleanMutableLiveData.setValue( false);
        RecyclerView recyclerView = this.f7639l;
        if (recyclerView != null && this.f7636i == 0) {
            this.f7636i = recyclerView.getMeasuredHeight();
        }
        super.addAll((List) this.tList.subList(0, this.pos));
        m4497f();
    }

    
    public void m4496e() {
        this.booleanMutableLiveData.setValue( true);
        RecyclerView recyclerView = this.f7639l;
        if (recyclerView != null && this.f7637j == 0) {
            this.f7637j = recyclerView.getMeasuredHeight();
        }
        super.addAll((List) this.tList);
        m4497f();
    }

    /* renamed from: f */
    public void m4497f() {
        this.f7639l.measure(-1, -2);
        MainAni mainAniVar = new MainAni();
        mainAniVar.setAnimationListener(new b());
        mainAniVar.setDuration(200L);
        this.f7639l.startAnimation(mainAniVar);
    }

    /* renamed from: f */
    public void m4498f(int i) {
        BaseInterface2 baseInterface2;
        String str;
        this.notifyDataSetChanged();
        if (this.f7638k == null || getItemCount() <= 0) {
            return;
        }
        if (this.arrayList.get(0) instanceof ShopCategoryFilter.Brand) {
            baseInterface2 = this.f7638k;
            str = "brand";
        } else if (this.arrayList.get(0) instanceof ShopCategoryFilter.Vendor) {
            baseInterface2 = this.f7638k;
            str = "vendor";
        } else if (this.arrayList.get(0) instanceof Category) {
            baseInterface2 = this.f7638k;
            str = "category";
        } else {
            if (!(this.arrayList.get(0) instanceof Vendor.Advanced)) {
                return;
            }
            baseInterface2 = this.f7638k;
            str = "advanced";
        }
        baseInterface2.mo4808a(i, str, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public MainVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        ButtonToggle buttonToggle = new ButtonToggle(this.baseActivity);
        buttonToggle.setId(R.id.cb_ok);
        return new MainVH(buttonToggle);
    }

    @Override
    public void onBindViewHolder(@NonNull MainVH holder, int position) {

    }
}
