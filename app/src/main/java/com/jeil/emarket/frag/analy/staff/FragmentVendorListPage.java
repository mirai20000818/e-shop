package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
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
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.viewmodel.VendorListVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.g.d.b.w3 */

public class FragmentVendorListPage extends Fragment {

    /* renamed from: a0 */
    public ViewPager f10016a0;

    /* renamed from: b0 */
    public FragmentPagerAdaperEx f10017b0;

    /* renamed from: e0 */
    public BaseDialog2 f10020e0;

    /* renamed from: i0 */
    public Picker4 f10024i0;

    /* renamed from: m0 */
    public List<Integer> f10028m0;

    /* renamed from: n0 */
    public List<ProductCategory> f10029n0;

    /* renamed from: c0 */
    public BaseDialog2 f10018c0 = null;

    /* renamed from: d0 */
    public BaseDialog2 f10019d0 = null;

    /* renamed from: f0 */
    public MutableLiveData<java.lang.String> f10021f0 = new MutableLiveData<>();

    /* renamed from: g0 */
    public MutableLiveData<java.lang.String> f10022g0 = new MutableLiveData<>();

    /* renamed from: h0 */
    public MutableLiveData<java.lang.String> f10023h0 = new MutableLiveData<>();

    /* renamed from: j0 */
    public MutableLiveData<Date> f10025j0 = new MutableLiveData<>();

    /* renamed from: k0 */
    public MutableLiveData<Date> f10026k0 = new MutableLiveData<>();

    /* renamed from: l0 */
    public MutableLiveData<Integer> f10027l0 = new MutableLiveData<>();

    /* renamed from: o0 */
    public boolean f10030o0 = false;

   // @Override // androidx.fragment.app.Fragment
    /* renamed from: B0 */
    public void mo1684B0() {
       // this.f3653G = true;
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.f2
            @Override // java.lang.Runnable
            public final void run() {
                FragmentVendorListPage.this.m5342T0();
            }
        }, Status.time);
    }

    /* renamed from: S0 */
    public void m5341S0() {
        int i;
        int i2;
        int i3;
        this.f10024i0 = new Picker4(getContext());
        Calendar calendar = Calendar.getInstance();
        if (this.f10025j0.getValue() != null) {
            calendar.set(this.f10025j0.getValue().getYear(), this.f10025j0.getValue().getMonth(), this.f10025j0.getValue().getDate());
        } else {
            calendar.set(calendar.get(1), 0, 1);
        }
        this.f10024i0.m4707b(calendar);
        Calendar calendar2 = Calendar.getInstance();
        if (this.f10026k0.getValue() != null) {
            i = this.f10026k0.getValue().getYear();
            i2 = this.f10026k0.getValue().getMonth();
            i3 = this.f10026k0.getValue().getDate();
        } else {
            i = calendar2.get(1);
            i2 = calendar2.get(2);
            i3 = calendar2.get(5);
        }
        calendar2.set(i, i2, i3);
        this.f10024i0.m4705a(calendar2);
    }

    /* renamed from: T0 */
    public  void m5342T0() {
        BottomNavigationView bottomNavigationView = ((MainActivityForVendor) getActivity()).f6521J;
        if (bottomNavigationView != null) {
            bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
        }
    }

    /* renamed from: U0 */
    public void m5343U0() {
        for (int i = 0; i < this.f10017b0.getCount(); i++) {
            if (((C2664u3) this.f10017b0.get(i)).f9998o0 != null) {
                ((C2664u3) this.f10017b0.get(i)).m4893Y0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10017b0 = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        View inflate = layoutInflater.inflate(R.layout.fragment_vendor_list_page, viewGroup, false);
        ((TextViewBold) inflate.findViewById(R.id.tv_header_title)).setText(R.string.review_list);
        m5352c(inflate);
        m5358h(inflate);
        m5341S0();
        return inflate;
    }


    public  void m5344a(View view, DialogInterface dialogInterface) {
        java.lang.String str;
        if (this.f10030o0) {
            this.f10021f0.setValue(((EditForm) view.findViewById(R.id.cef_review)).getText());
            this.f10022g0.setValue(((EditForm) view.findViewById(R.id.cef_reviewer)).getText());
            int i = 0;
            while (true) {
                if (i >= this.f10029n0.size()) {
                    break;
                } else if (((TextView) view.findViewById(R.id.ctv_category)).getText().equals(this.f10029n0.get(i).categoryName)) {
                    this.f10023h0.setValue((i == 0 ? null : java.lang.String.valueOf(this.f10029n0.get(i).categoryId)));
                } else {
                    i++;
                }
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.f10028m0.size()) {
                    break;
                }
                CharSequence text = ((TextView) view.findViewById(R.id.ctv_rate)).getText();
                if (i2 == 0) {
                    str = getResources().getString(R.string.all_review_rates);
                } else {
                    str = this.f10028m0.get(i2) + "점";
                }
                if (text.equals(str)) {
                    this.f10027l0.setValue( (i2 != 0 ? this.f10028m0.get(i2) : null));
                } else {
                    i2++;
                }
            }
            int currentItem = this.f10016a0.getCurrentItem();
            try {
                C2664u3 c2664u3 = (C2664u3) this.f10017b0.get(currentItem);
                java.lang.String getValue = this.f10021f0.getValue();
                c2664u3.f9137a0 = 0;
                c2664u3.f9999p0.put("search", getValue);
                c2664u3.jsonObject.put("filter", c2664u3.f9999p0.toString());
                C2664u3 c2664u32 = (C2664u3) this.f10017b0.get(currentItem);
                java.lang.String getValue2 = this.f10022g0.getValue();
                c2664u32.f9137a0 = 0;
                c2664u32.f9999p0.put("reviewer", getValue2);
                c2664u32.jsonObject.put("filter", c2664u32.f9999p0.toString());
                C2664u3 c2664u33 = (C2664u3) this.f10017b0.get(currentItem);
                java.lang.String getValue3 = this.f10023h0.getValue();
                c2664u33.f9137a0 = 0;
                c2664u33.f9999p0.put("category", getValue3);
                c2664u33.jsonObject.put("filter", c2664u33.f9999p0.toString());
                C2664u3 c2664u34 = (C2664u3) this.f10017b0.get(currentItem);
                Integer getValue4 = this.f10027l0.getValue();
                c2664u34.f9137a0 = 0;
                c2664u34.f9999p0.put("rating", getValue4);
                c2664u34.jsonObject.put("filter", c2664u34.f9999p0.toString());
                C2664u3 c2664u35 = (C2664u3) this.f10017b0.get(currentItem);
                java.lang.String date2Str = this.f10025j0.getValue() != null ? Util.date2Str(this.f10025j0.getValue()) : "";
                java.lang.String date2Str2 = this.f10026k0.getValue() != null ? Util.date2Str(this.f10026k0.getValue()) : "";
                c2664u35.f9137a0 = 0;
                c2664u35.f9999p0.put("startDate", date2Str);
                c2664u35.f9999p0.put("endDate", date2Str2);
                c2664u35.jsonObject.put("filter", c2664u35.f9999p0.toString());
                ((C2664u3) this.f10017b0.get(currentItem)).mo4891W0();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }


    public  void m5345a(View view, View view2) {
        m5360j(view);
    }


    public  void m5347a(View view, Date date, Date date2, View view2) {
        this.f10025j0.setValue( date);
        this.f10026k0.setValue( date2);
        ((TextView) view.findViewById(R.id.tv_date)).setText(Util.date2Str(this.f10025j0.getValue()) + " ~ " + Util.date2Str(this.f10026k0.getValue()));
    }


    public  void m5348a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.m_status) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    java.lang.String m219a = Util.getIdentifier(getActivity(), str2, "");
                    int m4417a = this.f10017b0.m4417a(m219a);
                    if (m4417a != -1) {
                        this.f10017b0.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f10016a0.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public  void m5349a(Vendor vendor) {
        if (vendor != null) {
            List<Category> getValue = CategoryVM.listMutableLiveData.getValue();
            int[] iArr = vendor.categories;
            if (getValue == null || iArr == null) {
                return;
            }
            ProductCategory productCategory = new ProductCategory();
            productCategory.categoryId = 0;
            productCategory.categoryName = getResources().getString(R.string.all_category_name);
            this.f10029n0.add(productCategory);
            for (int i : iArr) {
                for (int i2 = 0; i2 < getValue.size(); i2++) {
                    if (getValue.get(i2).f12393id == i) {
                        ProductCategory productCategory2 = new ProductCategory();
                        productCategory2.categoryId = i;
                        productCategory2.categoryName = getValue.get(i2).name;
                        this.f10029n0.add(productCategory2);
                    }
                }
            }
        }
    }


    public  void m5350b(View view, View view2) {
        ((EditForm) view.findViewById(R.id.cef_review)).setText("");
        ((EditForm) view.findViewById(R.id.cef_reviewer)).setText("");
        ((TextView) view.findViewById(R.id.ctv_category)).setText(this.f10029n0.get(0).categoryName);
        ((TextView) view.findViewById(R.id.ctv_rate)).setText(getResources().getString(R.string.all_review_rates));
        this.f10025j0.setValue( null);
        this.f10026k0.setValue( null);
        this.f10030o0 = true;
        this.f10020e0.startAni();
    }

    
    public void m5352c(View view) {
        ((BaseActivityForVendor) getActivity()).addRefreshIcon(view);
        view.findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorListPage.this.m5354d(view2);
            }
        });
    }

    
    public  void m5353c(View view, View view2) {
        m5361k(view);
    }

    
    public  void m5354d(View view) {
        for (int i = 0; i < Math.min(Status.m_status.length, this.f10017b0.getCount()); i++) {
            if (((C2664u3) this.f10017b0.get(i)).f9998o0 != null) {
                ((C2664u3) this.f10017b0.get(i)).m4893Y0();
            }
        }
    }

    
    public  void m5355e(View view) {
        ((MainActivityForVendor) getActivity()).close();
    }

    /* renamed from: f */
    public  void m5356f(View view) {
        this.f10024i0.m4704a();
    }

    /* renamed from: g */
    public  void m5357g(View view) {
        this.f10030o0 = true;
        this.f10020e0.startAni();
    }

    /* renamed from: h */
    public void m5358h(View view) {
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
                    materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.p2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            FragmentVendorListPage.this.m5355e(view2);
                        }
                    });
                }
            }
            view.findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentVendorListPage.this.m5359i(view2);
                }
            });
        }
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    
    public void m5359i(View view) {
        final View inflate = getLayoutInflater().inflate(R.layout.dialog_vendor_review_filter, (ViewGroup) null);
        this.f10020e0 = new BaseDialog2(getActivity(), new java.lang.String[0], inflate, 8388613);
        this.f10030o0 = false;
        inflate.findViewById(R.id.mrl_date_span).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorListPage.this.m5356f(view2);
            }
        });
        this.f10024i0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.b.h2
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date, Date date2, View view2) {
                FragmentVendorListPage.this.m5347a(inflate, date, date2, view2);
            }
        };
        ((EditForm) inflate.findViewById(R.id.cef_review)).setText(this.f10021f0.getValue() != null ? this.f10021f0.getValue() : "");
        for (int i = 0; i < this.f10029n0.size(); i++) {
            if (this.f10023h0.getValue() != null && this.f10023h0.getValue().equals(java.lang.String.valueOf(this.f10029n0.get(i).categoryId))) {
                ((TextView) inflate.findViewById(R.id.ctv_category)).setText(this.f10029n0.get(i).categoryName);
            }
        }
        ((TextView) inflate.findViewById(R.id.ctv_rate)).setText((this.f10027l0.getValue() == null || this.f10027l0.getValue().intValue() == 0) ? getResources().getString(R.string.all_review_rates) : this.f10027l0.getValue() + "점");
        ((EditForm) inflate.findViewById(R.id.cef_review)).setText(this.f10021f0.getValue());
        ((EditForm) inflate.findViewById(R.id.cef_reviewer)).setText(this.f10022g0.getValue());
        if (this.f10025j0.getValue() != null) {
            ((TextView) inflate.findViewById(R.id.tv_date)).setText(Util.date2Str(this.f10025j0.getValue()) + " ~ " + Util.date2Str(this.f10026k0.getValue()));
        }
        inflate.findViewById(R.id.mrl_btn_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorListPage.this.m5357g(view2);
            }
        });
        inflate.findViewById(R.id.mrl_btn_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorListPage.this.m5350b(inflate, view2);
            }
        });
        inflate.findViewById(R.id.mrl_review_rate).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorListPage.this.m5353c(inflate, view2);
            }
        });
        inflate.findViewById(R.id.mrl_category).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentVendorListPage.this.m5345a(inflate, view2);
            }
        });
        this.f10020e0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.d.b.m2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FragmentVendorListPage.this.m5344a(inflate, dialogInterface);
            }
        });
        BaseDialog2 baseDialog2 = this.f10020e0;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.76f;
        baseDialog2.show();
    }

   
    public void m5360j(final View view) {
        BaseActivity activityC1391g1 = (BaseActivity) getActivity();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f10029n0.size(); i++) {
            arrayList.add(new Cancel_Obj(this.f10029n0.get(i).categoryName, ((TextView) view.findViewById(R.id.ctv_category)).getText().equals(this.f10029n0.get(i).categoryName) ? 1 : 0));
        }
        this.f10019d0 = new BaseDialog2(activityC1391g1, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f10019d0;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.e2
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                FragmentVendorListPage.this.m5346a(view, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f10019d0;
        baseDialog22.f8255f = 0.5f;
        baseDialog22.f8209G = activityC1391g1.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
    }

    @SuppressLint({"SetTextI18n"})
    
    public void m5361k(final View view) {
        BaseActivity activityC1391g1 = (BaseActivity) getActivity();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f10028m0.size(); i++) {
            arrayList.add(new Cancel_Obj(i == 0 ? getResources().getString(R.string.all_review_rates) : this.f10028m0.get(i) + "점", ((TextView) view.findViewById(R.id.ctv_rate)).getText().equals(i == 0 ? getResources().getString(R.string.all_review_rates) : this.f10028m0.get(i) + "점") ? 1 : 0));
        }
        this.f10018c0 = new BaseDialog2(activityC1391g1, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f10018c0;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.n2
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                FragmentVendorListPage.this.m5351b(view, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f10018c0;
        baseDialog22.f8209G = activityC1391g1.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
    }

   // @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public void mo1703p0() {
        //this.f3653G = true;
    }


    public  void m5351b(View view, View view2, int i) {
        java.lang.String str;
        TextView textView = (TextView) view.findViewById(R.id.ctv_rate);
        if (i == 0) {
            str = getResources().getString(R.string.all_review_rates);
        } else {
            str = this.f10028m0.get(i) + "점";
        }
        textView.setText(str);
        this.f10018c0.startAni();
    }


    public  void m5346a(View view, View view2, int i) {
        ((TextView) view.findViewById(R.id.ctv_category)).setText(this.f10029n0.get(i).categoryName);
        this.f10019d0.startAni();
    }

    @Override // androidx.fragment.app.Fragment

    public void onViewCreated(View view, Bundle bundle) {
        this.f10016a0 = (ViewPager) view.findViewById(R.id.vp_statuses);
        this.f10016a0.setAdapter(this.f10017b0);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) view.findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f10016a0);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.g.d.b.d2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                FragmentVendorListPage.this.m5348a(recyclerTabLayout, str);
            }
        };
        this.f10017b0.addFragment((Fragment) new C2664u3((BaseActivity) getActivity(), "all", interfaceString), getResources().getString(R.string.all), true);
        this.f10017b0.addFragment((Fragment) new C2664u3((BaseActivity) getActivity(), "approved", interfaceString), getResources().getString(R.string.approved), true);
        this.f10017b0.addFragment((Fragment) new C2664u3((BaseActivity) getActivity(), "pending", interfaceString), getResources().getString(R.string.pending), true);
        this.f10017b0.addFragment((Fragment) new C2664u3((BaseActivity) getActivity(), "rejected", interfaceString), getResources().getString(R.string.rejected), true);
        this.f10017b0.addFragment((Fragment) new C2664u3((BaseActivity) getActivity(), "replyPending", interfaceString), getResources().getString(R.string.replyPending), true);
        this.f10017b0.addFragment((Fragment) new C2664u3((BaseActivity) getActivity(), "replyRejected", interfaceString), getResources().getString(R.string.replyRejected), true);
        this.f10017b0.notifyDataSetChanged();
        CustomString.m3172a(this.f10017b0, 1, this.f10016a0);
        ((C2664u3) this.f10017b0.get(0)).m4888T0();
        this.f10016a0.setOnPageChangeListener(new C2669v3(this));
        this.f10028m0 = new ArrayList();
        this.f10028m0.add(0);
        this.f10028m0.add(1);
        this.f10028m0.add(2);
        this.f10028m0.add(3);
        this.f10028m0.add(4);
        this.f10028m0.add(5);
        this.f10029n0 = new ArrayList();
        VendorListVM.f10363d.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.b.l2
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentVendorListPage.this.m5349a((Vendor) obj);
            }
        });
    }
}
