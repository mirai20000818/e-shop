package com.jeil.emarket.frag.analy.staff;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
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
import com.jeil.emarket.frag.main.vendor.SearchFragment;
import com.jeil.emarket.interf.InterfaceString;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

/* renamed from: b.f.a.g.d.b.p3 */

public class C2639p3 extends Fragment {

    /* renamed from: a0 */
    public ViewPager f9917a0;

    /* renamed from: b0 */
    public FragmentPagerAdaperEx f9918b0;

    /* renamed from: c0 */
    public BaseDialog2 f9919c0;

    /* renamed from: g0 */
    public Picker4 f9923g0;

    /* renamed from: d0 */
    public MutableLiveData<java.lang.String> f9920d0 = new MutableLiveData<>();

    /* renamed from: e0 */
    public MutableLiveData<java.lang.String> f9921e0 = new MutableLiveData<>();

    /* renamed from: f0 */
    public boolean f9922f0 = false;

    /* renamed from: h0 */
    public MutableLiveData<Date> f9924h0 = new MutableLiveData<>();

    /* renamed from: i0 */
    public MutableLiveData<Date> f9925i0 = new MutableLiveData<>();

    //@Override // androidx.fragment.app.Fragment
    /* renamed from: B0 */
    public void mo1684B0() {
        //this.f3653G = true;
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.a1
            @Override // java.lang.Runnable
            public final void run() {
                C2639p3.this.m5293T0();
            }
        }, Status.time);
    }

    /* renamed from: S0 */
    public void m5292S0() {
        int i;
        int i2;
        int i3;
        this.f9923g0 = new Picker4(getContext());
        Calendar calendar = Calendar.getInstance();
        if (this.f9924h0.getValue() != null) {
            calendar.set(this.f9924h0.getValue().getYear(), this.f9924h0.getValue().getMonth(), this.f9924h0.getValue().getDate());
        } else {
            calendar.set(calendar.get(1), 0, 1);
        }
        this.f9923g0.m4707b(calendar);
        Calendar calendar2 = Calendar.getInstance();
        if (this.f9925i0.getValue() != null) {
            i = this.f9925i0.getValue().getYear();
            i2 = this.f9925i0.getValue().getMonth();
            i3 = this.f9925i0.getValue().getDate();
        } else {
            i = calendar2.get(1);
            i2 = calendar2.get(2);
            i3 = calendar2.get(5);
        }
        calendar2.set(i, i2, i3);
        this.f9923g0.m4705a(calendar2);
    }

    /* renamed from: T0 */
    public  void m5293T0() {
        BottomNavigationView bottomNavigationView = ((MainActivityForVendor) getActivity()).f6521J;
        if (bottomNavigationView != null) {
            bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
        }
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9918b0 = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        View inflate = layoutInflater.inflate(R.layout.fragment_vendor_list_page, viewGroup, false);
        ((TextViewBold) inflate.findViewById(R.id.tv_header_title)).setText(R.string.point_list);
        m5298c(inflate);
        m5303h(inflate);
        m5292S0();
        return inflate;
    }


    public  void m5295a(View view, View view2) {
        ((EditForm) view.findViewById(R.id.cef_review)).setText("");
        ((EditForm) view.findViewById(R.id.cef_reviewer)).setText("");
        this.f9924h0.setValue( null);
        this.f9925i0.setValue( null);
        ((TextView) view.findViewById(R.id.tv_date)).setText(getResources().getString(R.string.select_date));
        this.f9922f0 = true;
        this.f9919c0.startAni();
    }


    public  void m5296a(View view, Date date, Date date2, View view2) {
        this.f9924h0.setValue( date);
        this.f9925i0.setValue( date2);
        ((TextView) view.findViewById(R.id.tv_date)).setText(Util.date2Str(this.f9924h0.getValue()) + " ~ " + Util.date2Str(this.f9925i0.getValue()));
    }


    public  void m5297a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.f8829t) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    java.lang.String m219a = Util.getIdentifier(getActivity(), str2, "");
                    int m4417a = this.f9918b0.m4417a(m219a);
                    if (m4417a != -1) {
                        this.f9918b0.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f9917a0.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    
    public void m5298c(View view) {
        ((BaseActivityForVendor) getActivity()).addRefreshIcon(view);
        view.findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2639p3.this.m5299d(view2);
            }
        });
    }

    
    public  void m5299d(View view) {
        for (int i = 0; i < Math.min(Status.f8829t.length, this.f9918b0.getCount()); i++) {
            if (((SearchFragment) this.f9918b0.get(i)).f9158r0 != null) {
                ((SearchFragment) this.f9918b0.get(i)).m4893Y0();
            }
        }
    }

    
    public  void m5300e(View view) {
        ((MainActivityForVendor) getActivity()).close();
    }

    /* renamed from: f */
    public  void m5301f(View view) {
        this.f9923g0.m4704a();
    }

    /* renamed from: g */
    public  void m5302g(View view) {
        this.f9922f0 = true;
        this.f9919c0.startAni();
    }

    /* renamed from: h */
    public void m5303h(View view) {
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
                    materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.b1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            C2639p3.this.m5300e(view2);
                        }
                    });
                }
            }
            view.findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.g3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2639p3.this.m5304i(view2);
                }
            });
        }
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    
    public void m5304i(View view) {
        final View inflate = getLayoutInflater().inflate(R.layout.dialog_vendor_review_filter, (ViewGroup) null);
        inflate.findViewById(R.id.llc_select_rate_item).setVisibility(View.GONE);
        inflate.findViewById(R.id.llc_select_category_item).setVisibility(View.GONE);
        this.f9919c0 = new BaseDialog2(getActivity(), new java.lang.String[0], inflate, 8388613);
        this.f9922f0 = false;
        inflate.findViewById(R.id.mrl_date_span).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2639p3.this.m5301f(view2);
            }
        });
        this.f9923g0.f8616c = new InterfaceC2111c() { // from class: b.f.a.g.d.b.f1
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date, Date date2, View view2) {
                C2639p3.this.m5296a(inflate, date, date2, view2);
            }
        };
        inflate.findViewById(R.id.mrl_btn_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2639p3.this.m5302g(view2);
            }
        });
        inflate.findViewById(R.id.mrl_btn_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2639p3.this.m5295a(inflate, view2);
            }
        });
        this.f9919c0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.d.b.e1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                C2639p3.this.m5294a(inflate, dialogInterface);
            }
        });
        ((EditForm) inflate.findViewById(R.id.cef_review)).setText(this.f9920d0.getValue());
        ((EditForm) inflate.findViewById(R.id.cef_reviewer)).setText(this.f9921e0.getValue());
        if (this.f9924h0.getValue() != null) {
            ((TextView) inflate.findViewById(R.id.tv_date)).setText(Util.date2Str(this.f9924h0.getValue()) + " ~ " + Util.date2Str(this.f9925i0.getValue()));
        }
        BaseDialog2 baseDialog2 = this.f9919c0;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.76f;
        baseDialog2.show();
    }


    public  void m5294a(View view, DialogInterface dialogInterface) {
        if (this.f9922f0) {
            this.f9920d0.setValue(((EditForm) view.findViewById(R.id.cef_review)).getText());
            this.f9921e0.setValue(((EditForm) view.findViewById(R.id.cef_reviewer)).getText());
            int currentItem = this.f9917a0.getCurrentItem();
            try {
                SearchFragment searchFragment = (SearchFragment) this.f9918b0.get(currentItem);
                java.lang.String getValue = this.f9920d0.getValue();
                searchFragment.f9137a0 = 0;
                searchFragment.f9159s0.put("search", getValue);
                searchFragment.jsonObject.put("filter", searchFragment.f9159s0.toString());
                SearchFragment c2287a12 = (SearchFragment) this.f9918b0.get(currentItem);
                java.lang.String getValue2 = this.f9921e0.getValue();
                c2287a12.f9137a0 = 0;
                c2287a12.f9159s0.put("reviewer", getValue2);
                c2287a12.jsonObject.put("filter", c2287a12.f9159s0.toString());
                SearchFragment c2287a13 = (SearchFragment) this.f9918b0.get(currentItem);
                java.lang.String date2Str = this.f9924h0.getValue() != null ? Util.date2Str(this.f9924h0.getValue()) : "";
                java.lang.String date2Str2 = this.f9925i0.getValue() != null ? Util.date2Str(this.f9925i0.getValue()) : "";
                c2287a13.f9137a0 = 0;
                c2287a13.f9159s0.put("startDate", date2Str);
                c2287a13.f9159s0.put("endDate", date2Str2);
                c2287a13.jsonObject.put("filter", c2287a13.f9159s0.toString());
                ((SearchFragment) this.f9918b0.get(currentItem)).m4893Y0();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment

    public void onViewCreated(View view, Bundle bundle) {
        this.f9917a0 = (ViewPager) view.findViewById(R.id.vp_statuses);
        this.f9917a0.setAdapter(this.f9918b0);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) view.findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f9917a0);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.g.d.b.c1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                C2639p3.this.m5297a(recyclerTabLayout, str);
            }
        };
        this.f9918b0.addFragment((Fragment) new SearchFragment((BaseActivity) getActivity(), "all", "vendorPoint", null, null, null, null, interfaceString), getResources().getString(R.string.all), true);
        this.f9918b0.addFragment((Fragment) new SearchFragment((BaseActivity) getActivity(), "approved", "vendorPoint", null, null, null, null, interfaceString), getResources().getString(R.string.approved), true);
        this.f9918b0.addFragment((Fragment) new SearchFragment((BaseActivity) getActivity(), "pending", "vendorPoint", null, null, null, null, interfaceString), getResources().getString(R.string.pending), true);
        this.f9918b0.addFragment((Fragment) new SearchFragment((BaseActivity) getActivity(), "rejected", "vendorPoint", null, null, null, null, interfaceString), getResources().getString(R.string.rejected), true);
        this.f9918b0.notifyDataSetChanged();
        CustomString.m3172a(this.f9918b0, 1, this.f9917a0);
        ((SearchFragment) this.f9918b0.get(0)).m4888T0();
        this.f9917a0.setOnPageChangeListener(new C2634o3(this));
    }
}
