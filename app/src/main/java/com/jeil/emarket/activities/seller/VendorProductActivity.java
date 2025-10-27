package com.jeil.emarket.activities.seller;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.analy.sale.FragmentVendorProductDescription;
import com.jeil.emarket.frag.analy.sale.FragGetFaqList;


public class VendorProductActivity extends BaseActivityForVendor {

    
    public int f11844K;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11845L;

    /* renamed from: com.jeil.emarket.activities.seller.VendorProductActivity$a */
    public class C3206a implements ViewPager.OnPageChangeListener {
        public C3206a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrollStateChanged(final int i) {
            Handler handler;
            Runnable runnable;
            if (i == 0 && ((FragmentVendorProductDescription) VendorProductActivity.this.f11845L.f7130l.get(i)).f10090a0 == null) {
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.i.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VendorProductActivity.C3206a.this.m6645c(i);
                    }
                };
            } else {
                if (i != 1) {
                    return;
                }
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.i.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VendorProductActivity.C3206a.this.m6646d(i);
                    }
                };
            }
            handler.postDelayed(runnable, Status.time);
        }

        
        public  void m6645c(int i) {
            ((FragmentVendorProductDescription) VendorProductActivity.this.f11845L.f7130l.get(i)).m5374S0();
        }

        
        public  void m6646d(int i) {
            ((FragGetFaqList) VendorProductActivity.this.f11845L.f7130l.get(i)).m4888T0();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        View findViewById = findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout == null || materialRippleLayout2 == null) {
                return;
            }
            materialRippleLayout.setVisibility(View.VISIBLE);
            materialRippleLayout2.setVisibility(View.GONE);
        }
    }

    /* renamed from: R */
    public void m6644R() {
        RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_product);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_product);
        this.f11845L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);
        viewPager.setAdapter(this.f11845L);
        recyclerTabLayout.setUpWithViewPager(viewPager);
        viewPager.setOnPageChangeListener(new C3206a());
        this.f11845L.addFragment(new FragmentVendorProductDescription(this, this.f11844K), getResources().getString(R.string.product_description));
        this.f11845L.addFragment(new FragGetFaqList(this, this.f11844K), getResources().getString(R.string.product_faq));
        this.f11845L.notifyDataSetChanged();
        CustomString.m3172a(this.f11845L, 1, viewPager);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_product);
        this.f11844K = getIntent().getIntExtra("id", 0);
        m6644R();
        mo4284G();
    }
}
