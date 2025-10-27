package com.jeil.emarket.frag.ticket.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.activities.ticket.add.TicketMarketCreateActivity;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.ticket.ticket.FragmentlTicketSearchEx;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: b.f.a.g.c.b.i */

public class FragmentTicketListVendorEx extends FragmentTicketListVendor {
    public FragmentTicketListVendorEx(BaseActivity activityC1391g1) {
        this.f9623c0 = activityC1391g1;
    }

    @Override // p078b.p159f.p160a.p231g.p240c.p242b.C2491j, androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        ((TextViewBold) this.f9624d0.findViewById(R.id.tv_header_title)).setText(R.string.market_ticket_box);
        View view = this.f9624d0;
        this.f9623c0.addRefreshIcon(view);
        view.findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.c.b.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentTicketListVendorEx.this.m5135d(view2);
            }
        });
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(Util.dp2px((Context) this.f9623c0, 42), Util.dp2px((Context) this.f9623c0, 42));
        //layoutParams.m2410a((CoordinatorLayout.Behavior) null);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = Util.dp2px((Context) this.f9623c0, 21);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = Util.dp2px((Context) this.f9623c0, 83);
        layoutParams.gravity = 8388693;
        this.f9624d0.findViewById(R.id.cb_add_ticket).setLayoutParams(layoutParams);
        View view2 = this.f9624d0;
        super.m5139c(view2);
        this.f9621a0 = (ViewPager) view2.findViewById(R.id.vp_statuses);
        this.f9621a0.setAdapter(this.f9622b0);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) view2.findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f9621a0);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.g.c.b.d
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                FragmentTicketListVendorEx.this.m5134a(recyclerTabLayout, str);
            }
        };
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("all", this.f9623c0, "market", interfaceString), getResources().getString(R.string.all), true);
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("open", this.f9623c0, "market", interfaceString), getResources().getString(R.string.open), true);
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("resolved", this.f9623c0, "market", interfaceString), getResources().getString(R.string.resolved), true);
        this.f9622b0.addFragment((Fragment) new FragmentlTicketSearchEx("closed", this.f9623c0, "market", interfaceString), getResources().getString(R.string.closed), true);
        ((FragmentlTicketSearchEx) this.f9622b0.get(1)).m4888T0();
        this.f9621a0.setCurrentItem(1);
        this.f9622b0.notifyDataSetChanged();
        CustomString.m3172a(this.f9622b0, 1, this.f9621a0);
        View view3 = this.f9624d0;
        BaseActivity activityC1391g1 = this.f9623c0;
        if (activityC1391g1 instanceof MainActivityForVendor) {
            ((MainActivityForVendor) activityC1391g1).setClickEvent(view3);
            if (this.f9623c0.bottomNavigationView != null && SimpleVM.f8836d) {
                view3.findViewById(R.id.vp_statuses).setPadding(0, 0, 0, this.f9623c0.bottomNavigationView.getMeasuredHeight());
            }
        }
        view3.findViewById(R.id.cb_add_ticket).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.c.b.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FragmentTicketListVendorEx.this.m5136e(view4);
            }
        });
        return this.f9624d0;
    }


    public  void m5134a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.f8822m) {
                if (jSONObject.has(str2)) {
                    int i = str2.equals("open") ? (jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0) + (jSONObject.getInt("pending") > -1 ? jSONObject.getInt("pending") : 0) : jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
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


    public  void m5135d(View view) {
        for (int i = 0; i < Math.min(Status.f8822m.length - 1, this.f9622b0.getCount()); i++) {
            if (((FragmentlTicketSearchEx) this.f9622b0.get(i)).m5131e1() != null) {
                ((FragmentlTicketSearchEx) this.f9622b0.get(i)).m4893Y0();
            }
        }
    }

    
    public  void m5136e(View view) {
        this.f9623c0.startActivityForResult(new Intent(this.f9623c0, TicketMarketCreateActivity.class), 100);
    }
}
