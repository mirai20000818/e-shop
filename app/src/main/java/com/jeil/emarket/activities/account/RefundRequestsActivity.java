package com.jeil.emarket.activities.account;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.RecyclerTabLayout;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.listener.orderlistener.RefundVPListener;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.FragmentRefundRequestList;
import com.jeil.emarket.interf.InterfaceString;


public class RefundRequestsActivity extends BaseActivity {

    
    public ViewPager f11681I;

   
    public FragmentPagerAdaperEx f11682J = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    
    public void m6370I() {
        for (int i = 0; i < Math.min(Status.f8828s.length, this.f11682J.getCount()); i++) {
            try {
                if (((FragmentRefundRequestList) this.f11682J.get(i)).m4913Z0() != null) {
                    ((FragmentRefundRequestList) this.f11682J.get(i)).m4893Y0();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    
    public  void m6371a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.f8828s) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    java.lang.String m219a = Util.getIdentifier(this, str2, "");
                    int m4417a = this.f11682J.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.f11682J.getInt(m4417a) != 0 && i != this.f11682J.getInt(m4417a)) {
                            ((FragmentRefundRequestList) this.f11682J.get(m4417a)).m4893Y0();
                        }
                        this.f11682J.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f11681I.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_refund_requests);
        this.f6500t = false;
        m4307e(R.string.refund_request_list);
        this.f11681I = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11681I.setAdapter(this.f11682J);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f11681I);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.a.i2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d
            
            public final void mo4265a(java.lang.String str) {
                RefundRequestsActivity.this.m6371a(recyclerTabLayout, str);
            }
        };
        this.f11682J.addFragment((Fragment) new FragmentRefundRequestList(this, "process", interfaceString), getResources().getString(R.string.process), true);
        this.f11682J.addFragment((Fragment) new FragmentRefundRequestList(this, "requested", interfaceString), getResources().getString(R.string.requested), true);
        this.f11682J.addFragment((Fragment) new FragmentRefundRequestList(this, "accepted", interfaceString), getResources().getString(R.string.accepted), true);
        this.f11682J.addFragment((Fragment) new FragmentRefundRequestList(this, "shipping", interfaceString), getResources().getString(R.string.shipping), true);
        this.f11682J.addFragment((Fragment) new FragmentRefundRequestList(this, "testing", interfaceString), getResources().getString(R.string.testing), true);
        this.f11682J.addFragment((Fragment) new FragmentRefundRequestList(this, "cancelled", interfaceString), getResources().getString(R.string.cancelled), true);
        this.f11682J.addFragment((Fragment) new FragmentRefundRequestList(this, "completed", interfaceString), getResources().getString(R.string.completed), true);
        this.f11682J.notifyDataSetChanged();
        CustomString.m3172a(this.f11682J, 1, this.f11681I);
        ((FragmentRefundRequestList) this.f11682J.get(0)).m4888T0();
        this.f11681I.setOnPageChangeListener(new RefundVPListener(this));
        mo4284G();
        addBottomNav(R.id.navigation_account);
    }
}
