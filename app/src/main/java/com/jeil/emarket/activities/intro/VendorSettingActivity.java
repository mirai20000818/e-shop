package com.jeil.emarket.activities.intro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.analy.staff.FragmentVendorSetting;


public class VendorSettingActivity extends BaseActivityForVendor {

    
    public FragmentPagerAdaperEx f11744K = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    /* renamed from: L */
    public ViewPager f11745L;

    /* renamed from: M */
    public int f11746M;

    /* renamed from: com.jeil.emarket.activities.intro.VendorSettingActivity$a */
    public class C3194a implements ViewPager.OnPageChangeListener {
        public C3194a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrollStateChanged(int i) {
            VendorSettingActivity vendorSettingActivity = VendorSettingActivity.this;
            vendorSettingActivity.f11746M = i;
            if (i == 0) {
                vendorSettingActivity.findViewById(R.id.mrl_add_faq).setVisibility(View.GONE);
                final FragmentVendorSetting fragmentVendorSetting = (FragmentVendorSetting) VendorSettingActivity.this.f11744K.f7130l.get(i);
                Handler handler = new Handler();
                fragmentVendorSetting.getClass();
                handler.postDelayed(new Runnable() { // from class: b.f.a.a.d.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        fragmentVendorSetting.m5216S0();
                    }
                }, Status.time);
                VendorSettingActivity vendorSettingActivity2 = fragmentVendorSetting.f9778h0;
                if (vendorSettingActivity2 != null) {
                    View findViewById = vendorSettingActivity2.findViewById(R.id.header_border);
                    View mo4310w = fragmentVendorSetting.f9778h0.mo4310w();
                    MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) fragmentVendorSetting.f9779i0.findViewById(R.id.mrl_scroll_top);
                    if (materialRippleLayout != null) {
                        fragmentVendorSetting.f9778h0.m4293a((NestedScrollView) fragmentVendorSetting.f9779i0.findViewById(R.id.nsv_main), materialRippleLayout, mo4310w, findViewById, fragmentVendorSetting.f9778h0.findViewById(R.id.bottom_border), true);
                    }
                }
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
    }

    /* renamed from: R */
    public void m6488R() {
        this.f11745L = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11745L.setAdapter(this.f11744K);
        ((RecyclerTabLayout) findViewById(R.id.rtl_statuses)).setUpWithViewPager(this.f11745L);
        this.f11745L.setOnPageChangeListener(new C3194a());
        this.f11744K.addFragment(new FragmentVendorSetting(this), getResources().getString(R.string.business_info));
        this.f11744K.notifyDataSetChanged();
        this.f11745L.setOffscreenPageLimit(this.f11744K.getCount() - 1);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_setting);
        m4307e(R.string.setting_business_info);
        m6488R();
        mo4284G();
        addBottomNav(0);
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }
}
