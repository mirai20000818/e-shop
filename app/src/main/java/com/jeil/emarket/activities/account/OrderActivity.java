package com.jeil.emarket.activities.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jeil.emarket.custom.Util;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.model.customer.OrderStatus;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.listener.orderlistener.OrderVPListner;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.SearchFragment2;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.viewmodel.UserVM;


public class OrderActivity extends BaseActivity {

    
    public ViewPager viewPager;

   
    public FragmentPagerAdaperEx fragmentPagerAdaperEx = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    
    public Bundle bundle;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById(R.id.mrl_header_back);
        if (materialRippleLayout != null) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderActivity.this.m6278d(view);
                }
            });
        }
    }

    
    public void m6276I() {
        for (int i = 0; i < Math.min(Status.state1.length, this.fragmentPagerAdaperEx.getCount()); i++) {
            try {
                if (((SearchFragment2) this.fragmentPagerAdaperEx.get(i)).f9287o0 != null) {
                    ((SearchFragment2) this.fragmentPagerAdaperEx.get(i)).m4893Y0();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }


    public  void m6277a(RecyclerTabLayout recyclerTabLayout, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (String str2 : Status.state1) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    String m219a = Util.getIdentifier(this, str2, "");
                    int m4417a = this.fragmentPagerAdaperEx.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.fragmentPagerAdaperEx.getInt(m4417a) != 0 && i != this.fragmentPagerAdaperEx.getInt(m4417a)) {
                            ((SearchFragment2) this.fragmentPagerAdaperEx.get(m4417a)).m4893Y0();
                        }
                        this.fragmentPagerAdaperEx.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.viewPager.getCurrentItem(), true);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String str3 : new String[]{"requested", "accepted", "shipping"}) {
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.status = str3;
                orderStatus.count = jSONObject.getInt(str3);
                arrayList.add(orderStatus);
            }
            UserVM.listMutableLiveData.setValue( arrayList);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    
    public  void m6278d(View view) {
        onBackPressed();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            m6276I();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() { 
        if (m4309v()) {
            return;
        }
        Bundle bundle = this.bundle;
        if (bundle == null || bundle.getString("page") == null || !Objects.equals(this.bundle.getString("page"), "toHome")) {
            if (isFinishing()) {
                return;
            } 
            super.onBackPressed();
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_order);
        m4307e(R.string.order_list);
        int i = 0;
        this.f6500t = false;
        if (getIntent() != null) {
            this.bundle = getIntent().getExtras();
        }
        this.viewPager = (ViewPager) findViewById(R.id.vp_statuses);
        this.viewPager.setAdapter(this.fragmentPagerAdaperEx);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.viewPager);
        this.viewPager.setOnPageChangeListener(new OrderVPListner(this));
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.a.p
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(String str) {
                OrderActivity.this.m6277a(recyclerTabLayout, str);
            }
        };
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment2(this, "process", interfaceString), getResources().getString(R.string.process), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment2(this, "requested", interfaceString), getResources().getString(R.string.requested), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment2(this, "accepted", interfaceString), getResources().getString(R.string.accepted), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment2(this, "readyToShip", interfaceString), getResources().getString(R.string.readyToShip), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment2(this, "shipping", interfaceString), getResources().getString(R.string.shipping), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment2(this, "completed", interfaceString), getResources().getString(R.string.completed), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new SearchFragment2(this, "cancelled", interfaceString), getResources().getString(R.string.cancelled), true);
        this.fragmentPagerAdaperEx.notifyDataSetChanged();
        Bundle bundle2 = this.bundle;
        if (bundle2 != null && bundle2.get("status") != null) {
            while (true) {
                String[] strArr = Status.state1;
                if (i >= strArr.length) {
                    break;
                }
                if (strArr[i].equals(this.bundle.getString("status"))) {
                    this.viewPager.setCurrentItem(i);
                }
                i++;
            }
        } else {
            ((SearchFragment2) this.fragmentPagerAdaperEx.get(0)).m4888T0();
        }
        this.viewPager.setOffscreenPageLimit(this.fragmentPagerAdaperEx.getCount() - 1);
        mo4284G();
        setAppBar();
        addBottomNav(R.id.navigation_account);
    }
}
