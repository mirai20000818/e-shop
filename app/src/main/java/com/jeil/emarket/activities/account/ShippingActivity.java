package com.jeil.emarket.activities.account;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.components.RecyclerTabLayout;
import org.json.JSONException;
import org.json.JSONObject;
import com.jeil.emarket.listener.orderlistener.ShippingVPListener;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.frag.main.vendor.FragmentShippingList;
import com.jeil.emarket.interf.InterfaceString;


public class ShippingActivity extends BaseActivity {


    public ViewPager f11683I;

   
    public FragmentPagerAdaperEx f11684J = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);


    public  void m6372a(RecyclerTabLayout recyclerTabLayout, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (String str2 : new String[]{"shipping", "completed"}) {
                String string = getResources().getString(str2.equals("shipping") ? R.string.pending_shipping : R.string.completed_shipping);
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    int m4417a = this.f11684J.m4417a(string);
                    if (m4417a != -1) {
                        if (this.f11684J.getInt(m4417a) != 0 && i != this.f11684J.getInt(m4417a)) {
                            ((FragmentShippingList) this.f11684J.get(m4417a)).m4893Y0();
                        }
                        this.f11684J.m4419a(m4417a, string, i);
                    }
                } else {
                    this.f11684J.m4419a(this.f11684J.m4417a(string), string, 0);
                }
                recyclerTabLayout.m6847b(this.f11683I.getCurrentItem(), true);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_shipping);
        m4307e(R.string.addresses_list);
        this.f11683I = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11683I.setAdapter(this.f11684J);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f11683I);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.a.k2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(String str) {
                ShippingActivity.this.m6372a(recyclerTabLayout, str);
            }
        };
        this.f11684J.addFragment(new FragmentShippingList("shipping", interfaceString, this), getResources().getString(R.string.pending_shipping));
        this.f11684J.addFragment(new FragmentShippingList("completed", interfaceString, this), getResources().getString(R.string.completed_shipping));
        this.f11684J.notifyDataSetChanged();
        this.f11683I.setOffscreenPageLimit(this.f11684J.getCount() - 1);
        ((FragmentShippingList) this.f11684J.get(0)).m4888T0();
        this.f11683I.setOnPageChangeListener(new ShippingVPListener(this));
        mo4284G();
        setAppBar();
        addBottomNav(R.id.navigation_account);
    }
}
