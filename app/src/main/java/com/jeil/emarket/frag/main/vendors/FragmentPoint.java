package com.jeil.emarket.frag.main.vendors;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.vendor.VendorActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.RecyclerTabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.dialog.dialogRatingGroup;
import com.jeil.emarket.frag.main.vendor.SearchFragment;
import com.jeil.emarket.interf.InterfaceString;

/* renamed from: b.f.a.g.b.e.t */

public class FragmentPoint extends Fragment {

    /* renamed from: b0 */
    public ViewPager vp_statuses;

    /* renamed from: c0 */
    public FragmentPagerAdaperEx fragmentPagerAdaperEx;

    /* renamed from: j0 */
    public VendorActivity vendorActivity;

    /* renamed from: k0 */
    public View view;

    /* renamed from: a0 */
    public Bundle bundle = new Bundle();

    /* renamed from: d0 */
    public MutableLiveData<List<Integer>> f9560d0 = new MutableLiveData<>(new ArrayList());

    /* renamed from: e0 */
    public MutableLiveData<List<Integer>> f9561e0 = new MutableLiveData<>(new ArrayList());

    /* renamed from: f0 */
    public MutableLiveData<List<Integer>> f9562f0 = new MutableLiveData<>(new ArrayList());

    /* renamed from: g0 */
    public List<Boolean> f9563g0 = new ArrayList();

    /* renamed from: h0 */
    public List<Boolean> f9564h0 = new ArrayList();

    /* renamed from: i0 */
    public List<Boolean> f9565i0 = new ArrayList();

    /* renamed from: l0 */
    public boolean f9568l0 = false;

    /* renamed from: b.f.a.g.b.e.t$a */
    public class VPListener implements ViewPager.OnPageChangeListener {
        public VPListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrollStateChanged(final int i) {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.e.d
                @Override // java.lang.Runnable
                public final void run() {
                    VPListener.this.m5114c(i);
                }
            }, Status.time);
        }


        public  void m5114c(int i) {
            ((SearchFragment) FragmentPoint.this.fragmentPagerAdaperEx.f7130l.get(i)).m4888T0();
        }
    }

    public FragmentPoint(VendorActivity vendorActivity, int i) {
        this.vendorActivity = vendorActivity;
        this.bundle.putInt("vendorId", i);
    }

    /* renamed from: S0 */
    public void m5103S0() {
        ((SearchFragment) this.fragmentPagerAdaperEx.get(0)).m4888T0();
        this.vp_statuses.setOnPageChangeListener(new VPListener());
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_point, viewGroup, false);
        for (int i = 0; i < 5; i++) {
            this.f9563g0.add(false);
            this.f9565i0.add(false);
            this.f9564h0.add(false);
        }
        this.vp_statuses = (ViewPager) this.view.findViewById(R.id.vp_statuses);
        this.fragmentPagerAdaperEx = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        this.vp_statuses.setAdapter(this.fragmentPagerAdaperEx);
        final RecyclerTabLayout rtl_statuses = (RecyclerTabLayout) this.view.findViewById(R.id.rtl_statuses);
        rtl_statuses.setUpWithViewPager(this.vp_statuses);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment(this.vendorActivity, "", "vendor", this.bundle, this.f9560d0.getValue(), this.f9561e0.getValue(), this.f9562f0.getValue(), new InterfaceString() { // from class: b.f.a.g.b.e.i
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                FragmentPoint.this.m5105a(rtl_statuses, str);
            }
        }), this.vendorActivity.getResources().getString(R.string.all), true);
        this.fragmentPagerAdaperEx.notifyDataSetChanged();
        CustomString.m3172a(this.fragmentPagerAdaperEx, 1, this.vp_statuses);
        this.view.findViewById(R.id.cal_filter_support).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentPoint.this.m5109c(view);
            }
        });
        this.view.findViewById(R.id.cal_filter_service).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentPoint.this.m5112d(view);
            }
        });
        this.view.findViewById(R.id.cal_filter_shipping).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentPoint.this.m5113e(view);
            }
        });
        return this.view;
    }


    public  void m5104a(dialogRatingGroup dialogRatingGroup, DialogInterface dialogInterface) {
        this.f9568l0 = false;
        if (dialogRatingGroup.f8851y.getValue() == null || this.f9560d0.getValue() == null) {
            return;
        }
        if ((dialogRatingGroup.f8851y.getValue().size() == 0 && ((List) Objects.requireNonNull(this.f9560d0.getValue())).size() == 0) || dialogRatingGroup.f8851y.getValue().equals(this.f9560d0.getValue())) {
            return;
        }
        this.f9560d0 = dialogRatingGroup.f8851y;
        this.f9563g0 = dialogRatingGroup.f8852z;
        this.f9560d0.observe(this.vendorActivity, new Observer() { // from class: b.f.a.g.b.e.g
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentPoint.this.m5106a((List) obj);
            }
        });
    }


    public  void m5105a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        java.lang.String m219a = Util.getIdentifier(this.vendorActivity, "all", "");
        FragmentPagerAdaperEx fragmentPagerAdaperEx = this.fragmentPagerAdaperEx;
        fragmentPagerAdaperEx.m4419a(fragmentPagerAdaperEx.m4417a(m219a), m219a, Integer.parseInt(str));
        recyclerTabLayout.m6847b(this.vp_statuses.getCurrentItem(), true);
    }


    public  void m5106a(List list) {
        MutableLiveData<List<Integer>> mutableLiveData = this.f9560d0;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.f9560d0.getValue().size() == 0) {
            ((ActionLink) this.view.findViewById(R.id.cal_filter_support)).setImageViewColor(R.color.dark);
            ((ActionLink) this.view.findViewById(R.id.cal_filter_support)).setmTextViewColor(R.color.dark);
        } else {
            ((ActionLink) this.view.findViewById(R.id.cal_filter_support)).setImageViewColor(BaseActivity.color);
            ((ActionLink) this.view.findViewById(R.id.cal_filter_support)).setmTextViewColor(BaseActivity.color);
        }
            ((SearchFragment) this.fragmentPagerAdaperEx.get(this.vp_statuses.getCurrentItem())).m4909c(this.f9560d0.getValue());

    }


    public  void m5107b(dialogRatingGroup dialogRatingGroup, DialogInterface dialogInterface) {
        this.f9568l0 = false;
        if (dialogRatingGroup.f8851y.getValue() == null || this.f9561e0.getValue() == null) {
            return;
        }
        if ((dialogRatingGroup.f8851y.getValue().size() == 0 && ((List) Objects.requireNonNull(this.f9561e0.getValue())).size() == 0) || dialogRatingGroup.f8851y.getValue().equals(this.f9561e0.getValue())) {
            return;
        }
        this.f9561e0 = dialogRatingGroup.f8851y;
        this.f9564h0 = dialogRatingGroup.f8852z;
        this.f9561e0.observe(this.vendorActivity, new Observer() { // from class: b.f.a.g.b.e.m
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentPoint.this.m5108b((List) obj);
            }
        });
    }


    public  void m5108b(List list) {
        MutableLiveData<List<Integer>> mutableLiveData = this.f9561e0;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.f9561e0.getValue().size() == 0) {
            ((ActionLink) this.view.findViewById(R.id.cal_filter_service)).setImageViewColor(R.color.dark);
            ((ActionLink) this.view.findViewById(R.id.cal_filter_service)).setmTextViewColor(R.color.dark);
        } else {
            ((ActionLink) this.view.findViewById(R.id.cal_filter_service)).setImageViewColor(BaseActivity.color);
            ((ActionLink) this.view.findViewById(R.id.cal_filter_service)).setmTextViewColor(BaseActivity.color);
        }
            ((SearchFragment) this.fragmentPagerAdaperEx.get(this.vp_statuses.getCurrentItem())).m4907a(this.f9561e0.getValue());

    }


    public  void m5109c(View view) {
        if (this.f9568l0) {
            return;
        }
        final dialogRatingGroup dialogRatingGroup = new dialogRatingGroup(this.vendorActivity, this.f9560d0.getValue(), this.f9563g0);
        dialogRatingGroup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.e.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FragmentPoint.this.m5104a(dialogRatingGroup, dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(dialogRatingGroup.getWindow())).setDimAmount(0.85f);
        this.f9568l0 = true;
        dialogRatingGroup.show();
    }


    public  void m5110c(dialogRatingGroup dialogRatingGroup, DialogInterface dialogInterface) {
        this.f9568l0 = false;
        if (dialogRatingGroup.f8851y.getValue() == null || this.f9562f0.getValue() == null) {
            return;
        }
        if ((dialogRatingGroup.f8851y.getValue().size() == 0 && ((List) Objects.requireNonNull(this.f9562f0.getValue())).size() == 0) || dialogRatingGroup.f8851y.getValue().equals(this.f9562f0.getValue())) {
            return;
        }
        this.f9562f0 = dialogRatingGroup.f8851y;
        this.f9565i0 = dialogRatingGroup.f8852z;
        this.f9562f0.observe(this.vendorActivity, new Observer() { // from class: b.f.a.g.b.e.j
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentPoint.this.m5111c((List) obj);
            }
        });
    }


    public  void m5111c(List list) {
        MutableLiveData<List<Integer>> mutableLiveData = this.f9562f0;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.f9562f0.getValue().size() == 0) {
            ((ActionLink) this.view.findViewById(R.id.cal_filter_shipping)).setImageViewColor(R.color.dark);
            ((ActionLink) this.view.findViewById(R.id.cal_filter_shipping)).setmTextViewColor(R.color.dark);
        } else {
            ((ActionLink) this.view.findViewById(R.id.cal_filter_shipping)).setImageViewColor(BaseActivity.color);
            ((ActionLink) this.view.findViewById(R.id.cal_filter_shipping)).setmTextViewColor(BaseActivity.color);
        }
            ((SearchFragment) this.fragmentPagerAdaperEx.get(this.vp_statuses.getCurrentItem())).m4908b(this.f9562f0.getValue());

    }


    public  void m5112d(View view) {
        if (this.f9568l0) {
            return;
        }
        final dialogRatingGroup dialogRatingGroup = new dialogRatingGroup(this.vendorActivity, this.f9561e0.getValue(), this.f9564h0);
        dialogRatingGroup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.e.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FragmentPoint.this.m5107b(dialogRatingGroup, dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(dialogRatingGroup.getWindow())).setDimAmount(0.85f);
        this.f9568l0 = true;
        dialogRatingGroup.show();
    }


    public  void m5113e(View view) {
        if (this.f9568l0) {
            return;
        }
        final dialogRatingGroup dialogRatingGroup = new dialogRatingGroup(this.vendorActivity, this.f9562f0.getValue(), this.f9565i0);
        dialogRatingGroup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.e.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FragmentPoint.this.m5110c(dialogRatingGroup, dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(dialogRatingGroup.getWindow())).setDimAmount(0.85f);
        this.f9568l0 = true;
        dialogRatingGroup.show();
    }
}
