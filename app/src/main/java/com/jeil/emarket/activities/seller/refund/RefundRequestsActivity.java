package com.jeil.emarket.activities.seller.refund;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.RecyclerTabLayout;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.viewpager.widget.PagerAdapter;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.listener.product.refund.RefundRequestsViewPager;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.analy.staff.C2659t3;
import com.jeil.emarket.interf.InterfaceString;


public class RefundRequestsActivity extends BaseActivityForVendor {

    
    public ViewPager f11924K;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11925L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    /* renamed from: M */
    public int f11926M = 0;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        ((AppCompatImageView) findViewById(R.id.iv_toggle_icon)).setImageDrawable(getResources().getDrawable(R.drawable.ic_filter));
        ((AppCompatImageView) findViewById(R.id.iv_toggle_icon)).setImageTintList(ColorStateList.valueOf(getResources().getColor(BaseActivity.color)));
        findViewById(R.id.iv_toggle_icon).setLayoutParams(new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) this, 15), Util.dp2px((Context) this, 15)));
        findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.w2.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundRequestsActivity.this.m6749t(view);
            }
        });
    }

    /* renamed from: R */
    public void m6747R() {
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LinearLayout.LayoutParams) c0541a).bottomMargin = 0;
        ((LinearLayout.LayoutParams) c0541a).topMargin = Util.dp2px((Context) this, 3);
        findViewById(R.id.llc_menu_toggle).setLayoutParams(c0541a);
        ((LinearLayoutCompat) findViewById(R.id.llc_menu_toggle)).setGravity(8388613);
    }


    public  void m6748a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.f8828s) {
                java.lang.String m219a = Util.getIdentifier(this, str2, "");
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    int m4417a = this.f11925L.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.f11925L.getInt(m4417a) != 0 && i != this.f11925L.getInt(m4417a)) {
                            ((C2659t3) this.f11925L.get(m4417a)).m4893Y0();
                        }
                        this.f11925L.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f11924K.getCurrentItem(), true);
                } else {
                    this.f11925L.m4419a(this.f11925L.m4417a(m219a), m219a, 0);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        int getCount = ((PagerAdapter) Objects.requireNonNull(this.f11924K.getAdapter())).getCount();
        if (i == 100 && i2 == -1) {
            for (int i3 = 0; i3 < getCount; i3++) {
                try {
                    if (((C2659t3) this.f11925L.get(i3)).m5331Z0() != null) {
                        ((C2659t3) this.f11925L.get(i3)).m4893Y0();
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_refunds);
        m4307e(R.string.refund_request_list);
        m6747R();
        this.f11924K = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11924K.setAdapter(this.f11925L);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f11924K);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.i.w2.j
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                RefundRequestsActivity.this.m6748a(recyclerTabLayout, str);
            }
        };
        this.f11925L.addFragment((Fragment) new C2659t3(this, "process", interfaceString), getResources().getString(R.string.process), true);
        this.f11925L.addFragment((Fragment) new C2659t3(this, "requested", interfaceString), getResources().getString(R.string.requested), true);
        this.f11925L.addFragment((Fragment) new C2659t3(this, "accepted", interfaceString), getResources().getString(R.string.accepted), true);
        this.f11925L.addFragment((Fragment) new C2659t3(this, "shipping", interfaceString), getResources().getString(R.string.shipping), true);
        this.f11925L.addFragment((Fragment) new C2659t3(this, "testing", interfaceString), getResources().getString(R.string.testing), true);
        this.f11925L.addFragment((Fragment) new C2659t3(this, "cancelled", interfaceString), getResources().getString(R.string.cancelled), true);
        this.f11925L.addFragment((Fragment) new C2659t3(this, "completed", interfaceString), getResources().getString(R.string.completed), true);
        this.f11925L.notifyDataSetChanged();
        CustomString.m3172a(this.f11925L, 1, this.f11924K);
        ((C2659t3) this.f11925L.get(0)).m4888T0();
        this.f11924K.setOnPageChangeListener(new RefundRequestsViewPager(this));
        addBottomNav(0);
        mo4284G();
    }

    /* renamed from: t */
    public  void m6749t(View view) {
        Fragment fragment;
        FragmentPagerAdaperEx fragmentPagerAdaperEx = this.f11925L;
        if (fragmentPagerAdaperEx == null || fragmentPagerAdaperEx.getCount() <= 0) {
            List<Fragment> m1616n = getSupportFragmentManager().getFragments();
            if (m1616n.size() > 0) {
                for (int i = 0; i < m1616n.size(); i++) {
                    if (m1616n.get(i) instanceof C2659t3) {
                        fragment = m1616n.get(i);
                    }
                }
                return;
            }
            return;
        }
        fragment = this.f11925L.get(this.f11926M);
        ((C2659t3) fragment).m5335a1();
    }
}
