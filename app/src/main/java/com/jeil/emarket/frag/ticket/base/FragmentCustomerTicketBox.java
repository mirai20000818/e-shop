package com.jeil.emarket.frag.ticket.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeil.emarket.custom.Util;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.textview.TextViewBold;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.ticket.ticket.FragmentlTicketSearchEx;
import com.jeil.emarket.interf.InterfaceString;

/* renamed from: b.f.a.g.c.b.h */

public class FragmentCustomerTicketBox extends FragmentTicketListVendor {
    public FragmentCustomerTicketBox(BaseActivity activityC1391g1) {
        this.f9623c0 = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p240c.p242b.C2491j, androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        ((TextViewBold) this.f9624d0.findViewById(R.id.tv_header_title)).setText(R.string.customer_ticket_box);
        View view = this.f9624d0;
        this.f9623c0.addRefreshIcon(view);
        view.findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.c.b.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentCustomerTicketBox.this.m5133d(view2);
            }
        });
        View view2 = this.f9624d0;
        super.m5139c(view2);
        this.f9621a0 = (ViewPager) view2.findViewById(R.id.vp_statuses);
        this.f9621a0.setAdapter(this.f9622b0);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) view2.findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f9621a0);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.g.c.b.b
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                FragmentCustomerTicketBox.this.m5132a(recyclerTabLayout, str);
            }
        };
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("all", this.f9623c0, "user", interfaceString), getResources().getString(R.string.all), true);
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("open", this.f9623c0, "user", interfaceString), getResources().getString(R.string.open), true);
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("pending", this.f9623c0, "user", interfaceString), getResources().getString(R.string.waiting), true);
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("resolved", this.f9623c0, "user", interfaceString), getResources().getString(R.string.resolved), true);
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("closed", this.f9623c0, "user", interfaceString), getResources().getString(R.string.closed), true);
        ((FragmentlTicketSearchEx) this.f9622b0.get(1)).m4888T0();
        this.f9621a0.setCurrentItem(1);
        this.f9622b0.notifyDataSetChanged();
        CustomString.m3172a(this.f9622b0, 1, this.f9621a0);
        View view3 = this.f9624d0;
        if (getActivity() instanceof MainActivityForVendor) {
            MainActivityForVendor mainActivity = (MainActivityForVendor) getActivity();
            mainActivity.setClickEvent(view3);
            view3.findViewById(R.id.cb_add_ticket).setVisibility(View.GONE);
            if (mainActivity.f6521J != null && SimpleVM.f8836d) {
                view3.findViewById(R.id.vp_statuses).setPadding(0, 0, 0, mainActivity.f6521J.getMeasuredHeight());
            }
        }
        return this.f9624d0;
    }


    public  void m5132a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.f8822m) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    BaseActivity activityC1391g1 = this.f9623c0;
                    if (str2.equals("pending")) {
                        str2 = "waiting";
                    }
                    java.lang.String m219a = Util.getIdentifier(activityC1391g1, str2, "");
                    int m4417a = this.f9622b0.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.f9622b0.getInt(m4417a) != 0 && i != this.f9622b0.getInt(m4417a)) {
                            ((FragmentlTicketSearchEx) this.f9622b0.get(m4417a)).m4893Y0();
                        }
                        this.f9622b0.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f9621a0.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    
    public  void m5133d(View view) {
        for (int i = 0; i < Math.min(Status.f8822m.length, this.f9622b0.getCount()); i++) {
            if (((FragmentlTicketSearchEx) this.f9622b0.get(i)).m5131e1() != null) {
                ((FragmentlTicketSearchEx) this.f9622b0.get(i)).m4893Y0();
            }
        }
    }
}
