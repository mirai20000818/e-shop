package com.jeil.emarket.activities.ticket.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.ticket.add.TicketVendorCreateActivity;
import com.jeil.emarket.components.RecyclerTabLayout;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.viewpager.widget.PagerAdapter;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.listener.ticket.user.TicketUserViewPager;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.ticket.ticket.FragmentGetTicketList;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;


public class TicketUserListActivity extends BaseActivity {


    public ViewPager f11938I;

   
    public FragmentPagerAdaperEx f11939J = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.cb_add_ticket).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.c.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketUserListActivity.this.m6788d(view);
            }
        });
    }


    public void m6786I() {
        int getCount = ((PagerAdapter) Objects.requireNonNull(this.f11938I.getAdapter())).getCount();
        for (int i = 0; i < getCount; i++) {
            try {
                if (((FragmentGetTicketList) this.f11939J.get(i)).m5119e1() != null) {
                    ((FragmentGetTicketList) this.f11939J.get(i)).m4893Y0();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    
    public  void m6787a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.f8822m) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    java.lang.String m219a = Util.getIdentifier(this, str2, "");
                    int m4417a = this.f11939J.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.f11939J.getInt(m4417a) != 0 && i != this.f11939J.getInt(m4417a)) {
                            ((FragmentGetTicketList) this.f11939J.get(m4417a)).m4893Y0();
                        }
                        this.f11939J.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f11938I.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public  void m6788d(View view) {
        Intent intent = new Intent(getApplicationContext(), TicketVendorCreateActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, 100);
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            m6786I();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6501u = false;
        setContentView(R.layout.fragment_ticket_list);
        this.f6500t = false;
        m4307e(R.string.ticket_box);
        this.f11938I = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11938I.setAdapter(this.f11939J);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f11938I);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.j.c.c
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d
            
            public final void mo4265a(java.lang.String str) {
                TicketUserListActivity.this.m6787a(recyclerTabLayout, str);
            }
        };
        this.f11939J.addFragment((Fragment) new FragmentGetTicketList("all", this, interfaceString), getResources().getString(R.string.all), true);
        this.f11939J.addFragment((Fragment) new FragmentGetTicketList("open", this, interfaceString), getResources().getString(R.string.open), true);
        this.f11939J.addFragment((Fragment) new FragmentGetTicketList("resolved", this, interfaceString), getResources().getString(R.string.resolved), true);
        this.f11939J.addFragment((Fragment) new FragmentGetTicketList("closed", this, interfaceString), getResources().getString(R.string.closed), true);
        ((FragmentGetTicketList) this.f11939J.get(1)).m4888T0();
        this.f11938I.setCurrentItem(1);
        this.f11939J.notifyDataSetChanged();
        CustomString.m3172a(this.f11939J, 1, this.f11938I);
        this.f11938I.setOnPageChangeListener(new TicketUserViewPager(this));
        mo4284G();
        addBottomNav(R.id.navigation_message);
        TicketCategoryListVM.f10284j.setValue( 0);
        ((AppCompatImageView) findViewById(R.id.iv_add)).setImageResource(R.drawable.ic_message_dots);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = 0;
        findViewById(R.id.iv_add).setLayoutParams(layoutParams);
    }
}
