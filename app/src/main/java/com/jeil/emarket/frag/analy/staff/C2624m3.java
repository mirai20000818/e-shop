package com.jeil.emarket.frag.analy.staff;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.viewmodel.ModelCollection;
import com.jeil.emarket.viewmodel.UserVM;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: b.f.a.g.d.b.m3 */

public class C2624m3 extends Fragment {

    /* renamed from: a0 */
    public ViewPager f9884a0;

    /* renamed from: b0 */
    public FragmentPagerAdaperEx f9885b0;

    /* renamed from: c0 */
    public java.lang.String f9886c0;

    /* renamed from: d0 */
    public int f9887d0 = 1;

    /* renamed from: e0 */
    public View f9888e0;

    //@Override // androidx.fragment.app.Fragment
    /* renamed from: A0 */
    public void mo2456A0() {
        //this.f3653G = true;
        if (ModelCollection.f10221l.getValue() == null) {
            this.f9884a0.setCurrentItem(1);
            ((C2629n3) this.f9885b0.get(1)).m4888T0();
            return;
        }
        int i = 0;
        while (true) {
            java.lang.String[] strArr = Status.state2;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i].equals(ModelCollection.f10221l.getValue())) {
                this.f9884a0.setCurrentItem(i);
                ((C2629n3) this.f9885b0.get(i)).m4888T0();
            }
            i++;
        }
    }

   // @Override // androidx.fragment.app.Fragment
    /* renamed from: B0 */
    public void mo1684B0() {
        //this.f3653G = true;
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.b.o0
            @Override // java.lang.Runnable
            public final void run() {
                C2624m3.this.m5271T0();
            }
        }, Status.time);
    }

    /* renamed from: S0 */
    public void m5270S0() {
        ((BaseActivityForVendor) getActivity()).addRefreshIcon(this.f9888e0);
        this.f9888e0.findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2624m3.this.m5275c(view);
            }
        });
    }

    /* renamed from: T0 */
    public  void m5271T0() {
        BottomNavigationView bottomNavigationView = ((MainActivityForVendor) getActivity()).f6521J;
        if (bottomNavigationView != null) {
            bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
        }
    }

    /* renamed from: U0 */
    public void m5272U0() {
        if (getActivity() instanceof MainActivityForVendor) {
            ((MainActivityForVendor) getActivity()).setClickEvent(this.f9888e0);
            View findViewById = this.f9888e0.findViewById(R.id.header);
            if (findViewById != null) {
                MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
                MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
                if (materialRippleLayout != null && materialRippleLayout2 != null) {
                    materialRippleLayout.setVisibility(View.GONE);
                    materialRippleLayout2.setVisibility(View.VISIBLE);
                }
                if (materialRippleLayout2 != null) {
                    materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.k0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C2624m3.this.m5276d(view);
                        }
                    });
                }
            }
        }
        ((EditForm) this.f9888e0.findViewById(R.id.cef_search)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2624m3.this.m5277e(view);
            }
        });
        ((EditForm) this.f9888e0.findViewById(R.id.cef_search)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.d.b.m0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return C2624m3.this.m5274a(textView, i, keyEvent);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9885b0 = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        this.f9888e0 = layoutInflater.inflate(R.layout.fragment_vendor_list_page, viewGroup, false);
        ((TextViewBold) this.f9888e0.findViewById(R.id.tv_header_title)).setText(R.string.order_list);
        m5270S0();
        this.f9888e0.findViewById(R.id.header_border).setVisibility(View.GONE);
        this.f9888e0.findViewById(R.id.cef_search).setVisibility(View.VISIBLE);
        this.f9888e0.findViewById(R.id.llc_menu_toggle).setVisibility(View.GONE);
        m5272U0();
        return this.f9888e0;
    }

  //  @Override // androidx.fragment.app.Fragment
    
    public void mo2501a(int i, int i2, Intent intent) {
        //super.mo2501a(i, i2, intent);
        if (i == 100 && i2 == -1) {
            for (int i3 = 0; i3 < Math.min(Status.state2.length, this.f9885b0.getCount()); i3++) {
                if (((C2629n3) this.f9885b0.get(i3)).m5278Z0() != null) {
                    ((C2629n3) this.f9885b0.get(i3)).m4893Y0();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    
    public void onViewCreated(View view, Bundle bundle) {
        this.f9884a0 = (ViewPager) view.findViewById(R.id.vp_statuses);
        this.f9884a0.setAdapter(this.f9885b0);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) view.findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f9884a0);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.g.d.b.l0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d
            
            public final void mo4265a(java.lang.String str) {
                C2624m3.this.m5273a(recyclerTabLayout, str);
            }
        };
        this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "urgent", interfaceString), getResources().getString(R.string.urgent_order), true);
        this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "process", interfaceString), getResources().getString(R.string.process), true);
        this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "requested", interfaceString), getResources().getString(R.string.requested), true);
        this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "accepted", interfaceString), getResources().getString(R.string.accepted), true);
        this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "readyToShip", interfaceString), getResources().getString(R.string.readyToShip), true);
        this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "shipping", interfaceString), getResources().getString(R.string.shipping), true);
        if (UserVM.userMutableLiveData.getValue() != null && !UserVM.userMutableLiveData.getValue().role.equals("vendorAgent") && !UserVM.userMutableLiveData.getValue().role.equals("vendorShippingManager")) {
            this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "completed", interfaceString), getResources().getString(R.string.completed), true);
            this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "cancelled", interfaceString), getResources().getString(R.string.cancelled), true);
            this.f9885b0.addFragment((Fragment) new C2629n3((BaseActivity) getActivity(), "all", interfaceString), getResources().getString(R.string.all), true);
        }
        this.f9885b0.notifyDataSetChanged();
        CustomString.m3172a(this.f9885b0, 1, this.f9884a0);
        if (ModelCollection.f10221l.getValue() != null) {
            int i = 0;
            while (true) {
                java.lang.String[] strArr = Status.state2;
                if (i >= strArr.length) {
                    break;
                }
                if (strArr[i].equals(ModelCollection.f10221l.getValue())) {
                    this.f9884a0.setCurrentItem(i);
                    ((C2629n3) this.f9885b0.get(i)).m4888T0();
                }
                i++;
            }
        } else {
            this.f9884a0.setCurrentItem(1);
            ((C2629n3) this.f9885b0.get(1)).m4888T0();
        }
        this.f9884a0.setOnPageChangeListener(new C2619l3(this));
    }

    
    public  void m5273a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.state2) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    FragmentActivity getActivity = getActivity();
                    if (str2.equals("urgent")) {
                        str2 = "urgent_order";
                    }
                    java.lang.String m219a = Util.getIdentifier(getActivity, str2, "");
                    int m4417a = this.f9885b0.m4417a(m219a);
                    if (m4417a != -1) {
                        if (m4417a != this.f9884a0.getCurrentItem() && this.f9885b0.getInt(m4417a) != 0 && i != this.f9885b0.getInt(m4417a) && ((C2629n3) this.f9885b0.get(m4417a)).m5278Z0() != null) {
                            ((C2629n3) this.f9885b0.get(m4417a)).m4893Y0();
                        }
                        this.f9885b0.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f9884a0.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    
    public  boolean m5274a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        ((C2629n3) this.f9885b0.get(this.f9887d0)).m5280a(((EditForm) this.f9888e0.findViewById(R.id.cef_search)).getText(), true);
        return true;
    }

    
    public  void m5275c(View view) {
        for (int i = 0; i < Math.min(Status.state2.length, this.f9885b0.getCount()); i++) {
            if (((C2629n3) this.f9885b0.get(i)).m5278Z0() != null) {
                ((EditForm) this.f9888e0.findViewById(R.id.cef_search)).setText("");
                ((C2629n3) this.f9885b0.get(i)).m5280a("", false);
                ((C2629n3) this.f9885b0.get(i)).m4893Y0();
            }
        }
    }

    
    public  void m5276d(View view) {
        ((MainActivityForVendor) getActivity()).close();
    }

    
    public  void m5277e(View view) {
        ((C2629n3) this.f9885b0.get(this.f9887d0)).m5280a(((EditForm) this.f9888e0.findViewById(R.id.cef_search)).getText(), true);
    }

   // @Override // androidx.fragment.app.Fragment
    /* renamed from: n0 */
    public void mo2554n0() {
       // this.f3653G = true;
        ModelCollection.f10221l.setValue(null);
    }

    ///@Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public void mo1703p0() {
        //this.f3653G = true;
    }
}
