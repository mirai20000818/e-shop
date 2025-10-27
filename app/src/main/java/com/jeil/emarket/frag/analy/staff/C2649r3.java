package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.vendor.ProductCategory;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.g.d.b.r3 */

public class C2649r3 extends Fragment {

    /* renamed from: a0 */
    public ViewPager f9943a0;

    /* renamed from: b0 */
    public FragmentPagerAdaperEx f9944b0;

    /* renamed from: e0 */
    public BaseDialog2 f9947e0;

    /* renamed from: j0 */
    public List<java.lang.String> f9952j0;

    /* renamed from: l0 */
    public List<ProductCategory> f9954l0;

    /* renamed from: c0 */
    public BaseDialog2 f9945c0 = null;

    /* renamed from: d0 */
    public BaseDialog2 f9946d0 = null;

    /* renamed from: f0 */
    public MutableLiveData<java.lang.String> f9948f0 = new MutableLiveData<>();

    /* renamed from: g0 */
    public MutableLiveData<java.lang.String> f9949g0 = new MutableLiveData<>();

    /* renamed from: h0 */
    public MutableLiveData<java.lang.String> f9950h0 = new MutableLiveData<>();

    /* renamed from: i0 */
    public MutableLiveData<Boolean> f9951i0 = new MutableLiveData<>();

    /* renamed from: k0 */
    public boolean f9953k0 = false;

    //@Override // androidx.fragment.app.Fragment
    /* renamed from: B0 */
    public void mo1684B0() {
        //this.f3653G = true;
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.l1
            @Override // java.lang.Runnable
            public final void run() {
                C2649r3.this.m5306S0();
            }
        }, Status.time);
    }

    /* renamed from: S0 */
    public  void m5306S0() {
        BottomNavigationView bottomNavigationView = ((MainActivityForVendor) getActivity()).f6521J;
        if (bottomNavigationView != null) {
            bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
        }
    }

    /* renamed from: T0 */
    public final void m5307T0() {
        for (int i = 0; i < Math.min(Status.state3.length, this.f9944b0.getCount()); i++) {
            if (((C2654S3Base) this.f9944b0.get(i)).m5323Z0() != null) {
                ((C2654S3Base) this.f9944b0.get(i)).m4893Y0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9944b0 = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        View inflate = layoutInflater.inflate(R.layout.fragment_vendor_list_page, viewGroup, false);
        this.f9951i0.setValue( false);
        ((TextViewBold) inflate.findViewById(R.id.tv_header_title)).setText(R.string.shop);
        m5314c(inflate);
        m5319g(inflate);
        return inflate;
    }

   // @Override // androidx.fragment.app.Fragment

    public void mo2501a(int i, int i2, Intent intent) {
        //super.mo2501a(i, i2, intent);
        if (i == 100 && i2 == -1) {
            m5307T0();
        }
    }


    public  void m5308a(View view, DialogInterface dialogInterface) {
        if (this.f9953k0) {
            this.f9948f0.setValue(((EditForm) view.findViewById(R.id.cef_product_name)).getText());
            this.f9951i0.setValue( Boolean.valueOf(((CheckBox) view.findViewById(R.id.cb_no_stock_only)).isChecked()));
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f9954l0.size()) {
                    break;
                } else if (((TextView) view.findViewById(R.id.ctv_product_category)).getText().equals(this.f9954l0.get(i2).categoryName)) {
                    this.f9949g0.setValue((i2 == 0 ? null : java.lang.String.valueOf(this.f9954l0.get(i2).categoryId)));
                } else {
                    i2++;
                }
            }
            while (true) {
                if (i >= this.f9952j0.size()) {
                    break;
                } else if (((TextView) view.findViewById(R.id.cef_product_type)).getText().equals(Util.m335d(getActivity(), this.f9952j0.get(i)))) {
                    this.f9950h0.setValue((i != 0 ? this.f9952j0.get(i) : null));
                } else {
                    i++;
                }
            }
            int currentItem = this.f9943a0.getCurrentItem();
            try {
                ((C2654S3Base) this.f9944b0.get(currentItem)).m5328c(this.f9948f0.getValue());
                ((C2654S3Base) this.f9944b0.get(currentItem)).m5327b(this.f9949g0.getValue());
                ((C2654S3Base) this.f9944b0.get(currentItem)).m5329d(this.f9950h0.getValue());
                ((C2654S3Base) this.f9944b0.get(currentItem)).m5330j(this.f9951i0.getValue().booleanValue());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ((C2654S3Base) this.f9944b0.get(currentItem)).mo4891W0();
        }
    }


    public  void m5309a(View view, View view2) {
        ((EditForm) view.findViewById(R.id.cef_product_name)).setText("");
        ((TextView) view.findViewById(R.id.ctv_product_category)).setText(this.f9954l0.get(0).categoryName);
        ((TextView) view.findViewById(R.id.cef_product_type)).setText(Util.m335d(getActivity(), this.f9952j0.get(0)));
        ((CheckBox) view.findViewById(R.id.cb_no_stock_only)).setChecked(false);
        this.f9953k0 = true;
        this.f9947e0.startAni();
    }


    public  void m5312a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.state3) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    FragmentActivity getActivity = getActivity();
                    if (str2.equals("all")) {
                        str2 = "request_product";
                    }
                    java.lang.String m219a = Util.getIdentifier(getActivity, str2, "");
                    int m4417a = this.f9944b0.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.f9944b0.getInt(m4417a) != 0 && i != this.f9944b0.getInt(m4417a)) {
                            ((C2654S3Base) this.f9944b0.get(m4417a)).m4893Y0();
                        }
                        this.f9944b0.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f9943a0.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public  void m5313b(View view, View view2) {
        m5322j(view);
    }


    public void m5314c(View view) {
        ((BaseActivityForVendor) getActivity()).addRefreshIcon(view);
        view.findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2649r3.this.m5316d(view2);
            }
        });
    }


    public  void m5315c(View view, View view2) {
        m5321i(view);
    }

    
    public  void m5316d(View view) {
        m5307T0();
    }

    
    public  void m5317e(View view) {
        ((MainActivityForVendor) getActivity()).close();
    }

    /* renamed from: f */
    public  void m5318f(View view) {
        this.f9953k0 = true;
        this.f9947e0.startAni();
    }

    /* renamed from: g */
    public void m5319g(View view) {
        if (getActivity() instanceof MainActivityForVendor) {
            ((MainActivityForVendor) getActivity()).setClickEvent(view);
            View findViewById = view.findViewById(R.id.header);
            if (findViewById != null) {
                MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
                MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
                if (materialRippleLayout != null && materialRippleLayout2 != null) {
                    materialRippleLayout.setVisibility(View.GONE);
                    materialRippleLayout2.setVisibility(View.VISIBLE);
                }
                if (materialRippleLayout2 != null) {
                    materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.p1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            C2649r3.this.m5317e(view2);
                        }
                    });
                }
            }
            view.findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.h3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2649r3.this.m5320h(view2);
                }
            });
        }
    }

    @SuppressLint({"InflateParams"})
    /* renamed from: h */
    public void m5320h(View view) {
        final View inflate = getLayoutInflater().inflate(R.layout.dialog_vendor_product_filter, (ViewGroup) null);
        this.f9947e0 = new BaseDialog2(getActivity(), new java.lang.String[0], inflate, 8388613);
        ((EditForm) inflate.findViewById(R.id.cef_product_name)).setText(this.f9948f0.getValue() != null ? this.f9948f0.getValue() : "");
        for (int i = 0; i < this.f9954l0.size(); i++) {
            if (this.f9949g0.getValue() != null && this.f9949g0.getValue().equals(java.lang.String.valueOf(this.f9954l0.get(i).categoryId))) {
                ((TextView) inflate.findViewById(R.id.ctv_product_category)).setText(this.f9954l0.get(i).categoryName);
            }
        }
        ((TextView) inflate.findViewById(R.id.cef_product_type)).setText(Util.m335d(getActivity(), this.f9950h0.getValue() != null ? this.f9950h0.getValue() : this.f9952j0.get(0)));
        ((CheckBox) inflate.findViewById(R.id.cb_no_stock_only)).setChecked(this.f9951i0.getValue() != null ? this.f9951i0.getValue().booleanValue() : false);
        this.f9953k0 = false;
        inflate.findViewById(R.id.mrl_btn_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2649r3.this.m5318f(view2);
            }
        });
        inflate.findViewById(R.id.mrl_btn_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2649r3.this.m5309a(inflate, view2);
            }
        });
        inflate.findViewById(R.id.mrl_product_type).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2649r3.this.m5313b(inflate, view2);
            }
        });
        inflate.findViewById(R.id.mrl_product_category).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2649r3.this.m5315c(inflate, view2);
            }
        });
        this.f9947e0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.d.b.q1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                C2649r3.this.m5308a(inflate, dialogInterface);
            }
        });
        BaseDialog2 baseDialog2 = this.f9947e0;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.76f;
        baseDialog2.show();
    }

    
    public void m5321i(final View view) {
        BaseActivity activityC1391g1 = (BaseActivity) getActivity();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f9954l0.size(); i++) {
            arrayList.add(new Cancel_Obj(this.f9954l0.get(i).categoryName, ((TextView) view.findViewById(R.id.ctv_product_category)).getText().equals(this.f9954l0.get(i).categoryName) ? 1 : 0));
        }
        this.f9946d0 = new BaseDialog2(activityC1391g1, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f9946d0;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.s1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                C2649r3.this.m5310a(view, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f9946d0;
        baseDialog22.f8255f = 0.5f;
        baseDialog22.f8209G = activityC1391g1.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
    }

   
    public void m5322j(final View view) {
        final BaseActivity activityC1391g1 = (BaseActivity) getActivity();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f9952j0.size(); i++) {
            arrayList.add(new Cancel_Obj(Util.m335d(activityC1391g1, this.f9952j0.get(i)), ((TextView) view.findViewById(R.id.cef_product_type)).getText().equals(Util.m335d(activityC1391g1, this.f9952j0.get(i))) ? 1 : 0));
        }
        this.f9945c0 = new BaseDialog2(activityC1391g1, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f9945c0;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.m1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                C2649r3.this.m5311a(view, activityC1391g1, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f9945c0;
        baseDialog22.f8209G = activityC1391g1.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
    }

    //@Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public void mo1703p0() {
        //this.f3653G = true;
    }


    public  void m5310a(View view, View view2, int i) {
        ((TextView) view.findViewById(R.id.ctv_product_category)).setText(this.f9954l0.get(i).categoryName);
        this.f9946d0.startAni();
    }


    public  void m5311a(View view, BaseActivity activityC1391g1, View view2, int i) {
        ((TextView) view.findViewById(R.id.cef_product_type)).setText(Util.m335d(activityC1391g1, this.f9952j0.get(i)));
        this.f9945c0.startAni();
    }

    @Override // androidx.fragment.app.Fragment

    public void onViewCreated(View view, Bundle bundle) {
        this.f9943a0 = (ViewPager) view.findViewById(R.id.vp_statuses);
        this.f9943a0.setAdapter(this.f9944b0);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) view.findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f9943a0);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.g.d.b.j1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                C2649r3.this.m5312a(recyclerTabLayout, str);
            }
        };
        this.f9944b0.addFragment((Fragment) new C2654S3Base((BaseActivity) getActivity(), "selling", interfaceString, this.f9944b0), getResources().getString(R.string.selling), true);
        this.f9944b0.addFragment((Fragment) new C2654S3Base((BaseActivity) getActivity(), "ban", interfaceString, this.f9944b0), getResources().getString(R.string.ban), true);
        this.f9944b0.addFragment((Fragment) new C2654S3Base((BaseActivity) getActivity(), "trash", interfaceString, this.f9944b0), getResources().getString(R.string.trash), true);
        this.f9944b0.addFragment((Fragment) new C2654S3Base((BaseActivity) getActivity(), "all", interfaceString, this.f9944b0), getResources().getString(R.string.request_product), true);
        this.f9944b0.notifyDataSetChanged();
        CustomString.m3172a(this.f9944b0, 1, this.f9943a0);
        ((C2654S3Base) this.f9944b0.get(0)).m4888T0();
        this.f9943a0.setOnPageChangeListener(new C2644q3(this));
        this.f9952j0 = new ArrayList();
        this.f9952j0.add("all_product_type");
        this.f9952j0.add("simple");
        this.f9952j0.add("variable");
        this.f9954l0 = new ArrayList();
        List<Category> getValue = CategoryVM.listMutableLiveData.getValue();
        int[] iArr = new int[0];
        if (VendorListVM.f10363d.getValue() != null && VendorListVM.f10363d.getValue().categories != null) {
            iArr = VendorListVM.f10363d.getValue().categories;
        }
        if (getValue != null) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.categoryId = 0;
            productCategory.categoryName = getResources().getString(R.string.all_category_name);
            this.f9954l0.add(productCategory);
            if (iArr.length != 0) {
                for (int i : iArr) {
                    for (int i2 = 0; i2 < getValue.size(); i2++) {
                        if (getValue.get(i2).f12393id == i) {
                            ProductCategory productCategory2 = new ProductCategory();
                            productCategory2.categoryId = i;
                            productCategory2.categoryName = getValue.get(i2).name;
                            this.f9954l0.add(productCategory2);
                        }
                    }
                }
            }
        }
    }
}
