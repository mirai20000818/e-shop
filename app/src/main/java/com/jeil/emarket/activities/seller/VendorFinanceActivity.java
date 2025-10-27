package com.jeil.emarket.activities.seller;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.analy.staff.C2609j3;
import com.jeil.emarket.frag.analy.staff.GetSaleReports;


public class VendorFinanceActivity extends BaseActivityForVendor {

    
    public ViewPager f11813K;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11814L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    /* renamed from: M */
    public int f11815M = 0;

    /* renamed from: com.jeil.emarket.activities.seller.VendorFinanceActivity$a */
    public class C3200a implements ViewPager.OnPageChangeListener {
        public C3200a() {
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
            VendorFinanceActivity.this.f11815M = i;
            if (i == 0) {
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.i.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        VendorFinanceActivity.C3200a.this.m6598c(i);
                    }
                };
            } else {
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.i.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        VendorFinanceActivity.C3200a.this.m6599d(i);
                    }
                };
            }
            handler.postDelayed(runnable, Status.time);
        }

        
        public  void m6598c(int i) {
            ((GetSaleReports) VendorFinanceActivity.this.f11814L.f7130l.get(i)).m4888T0();
        }

        
        public  void m6599d(int i) {
            ((C2609j3) VendorFinanceActivity.this.f11814L.f7130l.get(i)).m4888T0();
        }
    }

    /* renamed from: R */
    public void m6595R() {
        addRefreshIcon(null);
        findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorFinanceActivity.this.m6597t(view);
            }
        });
    }

    /* renamed from: S */
    public void m6596S() {
        this.f11813K = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11813K.setAdapter(this.f11814L);
        ((RecyclerTabLayout) findViewById(R.id.rtl_statuses)).setUpWithViewPager(this.f11813K);
        this.f11813K.setOnPageChangeListener(new C3200a());
        this.f11814L.addFragment(new GetSaleReports(this), getResources().getString(R.string.sale_report));
        this.f11814L.addFragment(new C2609j3(this), getResources().getString(R.string.fee_history));
        this.f11814L.notifyDataSetChanged();
        this.f11813K.setOffscreenPageLimit(this.f11814L.getCount() - 1);
        ((GetSaleReports) this.f11814L.get(0)).m4888T0();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_finance);
        m4307e(R.string.finance_manage);
        m6595R();
        m6596S();
        mo4284G();
        addBottomNav(0);
    }

    /* renamed from: t */
    public  void m6597t(View view) {
        (this.f11815M == 0 ? (GetSaleReports) this.f11814L.get(0) : (C2609j3) this.f11814L.get(1)).m4893Y0();
    }
}
