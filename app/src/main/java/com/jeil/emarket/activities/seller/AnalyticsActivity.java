package com.jeil.emarket.activities.seller;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.balysv.materialripple.MaterialRippleLayout;

import java.util.ArrayList;

import androidx.fragment.app.FragmentManager;

import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;


public class AnalyticsActivity extends BaseActivityForVendor {

    
    public Fragment f11802K;

    /* renamed from: L */
    public BaseDialog2 f11803L;

    /* renamed from: M */
    public int f11804M;

    /* renamed from: R */
    public void m6580R() {
        if (this.f11803L == null) {
            String[] strArr = {getResources().getString(R.string.analytics_overview), getResources().getString(R.string.product), getResources().getString(R.string.profit), getResources().getString(R.string.order), getResources().getString(R.string.categories), getResources().getString(R.string.guest)};
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(new Cancel_Obj(str, R.drawable.ic_angle_right));
            }
            this.f11803L = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList, 8388613);
        }
        BaseDialog2 baseDialog2 = this.f11803L;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.57f;
        baseDialog2.show();
        BaseDialog2 baseDialog22 = this.f11803L;
        if (baseDialog22 != null) {
            baseDialog22.f8212y.setPadding(m4299b(8), 0, m4299b(8), 0);
            this.f11803L.interface2 = new DialogInterface2() { // from class: b.f.a.a.i.d
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

                public final void mo4264a(View view, int i) {
                    AnalyticsActivity.this.m6581a(view, i);
                }
            };
        }
    }


    public  void m6581a(View view, int i) {
        int i2;
        if (i == 0) {
            i2 = R.id.llc_analytics_overview;
        } else if (i == 1) {
            i2 = R.id.llc_analytics_products;
        } else if (i == 2) {
            i2 = R.id.llc_analytics_profit;
        } else if (i == 3) {
            i2 = R.id.llc_analytics_order;
        } else {
            if (i != 4) {
                if (i == 5) {
                    i2 = R.id.llc_analytics_customer;
                }
                this.f11803L.startAni();
            }
            i2 = R.id.llc_analytics_category;
        }
        mo4353j(i2);
        this.f11803L.startAni();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1
   
    public void mo4353j(int i) {
        Fragment c2527c;
        FragmentManager getSupportFragmentManager = getSupportFragmentManager();
//        this.f11802K = getSupportFragmentManager.m1583b(i + "");
//        if (this.f11802K != null) {
//            List<Fragment> m1616n = getSupportFragmentManager.getFragments();
//            FragmentTransaction c0331a = getSupportFragmentManager.beginTransaction();
//            for (int i2 = 0; i2 < m1616n.size(); i2++) {
//                c0331a.mo1512c(m1616n.get(i2));
//            }
//            c0331a.mo1517f(this.f11802K);
//            if (i == R.id.llc_analytics_overview) {
//                ((FragmentAnalyticsOverView) this.f11802K).m5194S0();
//            } else if (i != R.id.llc_analytics_customer && i != this.f11804M) {
//                ((Fragment_analytics) this.f11802K).m5190T0();
//            }
//            this.f11804M = i;
//            c0331a.commit();
//            return;
//        }
//        this.f11804M = i;
//        this.f11802K = null;
//        switch (i) {
//            case R.id.llc_analytics_brands /* 2131231568 */:
//                c2527c = new FragmentAnlayBrand(this);
//                break;
//            case R.id.llc_analytics_category /* 2131231569 */:
//                c2527c = new FragmentCategory(this);
//                break;
//            case R.id.llc_analytics_customer /* 2131231571 */:
//                c2527c = new FragmentCustomer(this);
//                break;
//            case R.id.llc_analytics_order /* 2131231572 */:
//                c2527c = new FragmentOrder(this);
//                break;
//            case R.id.llc_analytics_overview /* 2131231573 */:
//                c2527c = new FragmentAnalyticsOverView(this);
//                break;
//            case R.id.llc_analytics_products /* 2131231574 */:
//                c2527c = new FragmentProduct(this);
//                break;
//            case R.id.llc_analytics_profit /* 2131231575 */:
//                c2527c = new FragmentProfits(this);
//                break;
//        }
//        this.f11802K = c2527c;
//        if (this.f11802K != null) {
//            FragmentTransaction c0331a2 = new FragmentTransaction(getSupportFragmentManager);
//            c0331a2.replace(R.id.ll_fragment, this.f11802K, i + "", 1);
//            c0331a2.commit();
//        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11804M != R.id.llc_analytics_overview) {
            mo4353j(R.id.llc_analytics_overview);
        } else {
            super.onBackPressed();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_analytics);
        mo4353j(R.id.llc_analytics_overview);
    }

    public void setClickEvent(View view) {
        MaterialRippleLayout materialRippleLayout;
        super.mo4284G();
        View findViewById = view.findViewById(R.id.header);
        if (findViewById != null && (materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back)) != null) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AnalyticsActivity.this.m6582t(view2);
                }
            });
        }
        view.findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnalyticsActivity.this.m6583u(view2);
            }
        });
    }

    /* renamed from: t */
    public  void m6582t(View view) {
        mo4353j(R.id.llc_analytics_overview);
    }

    /* renamed from: u */
    public  void m6583u(View view) {
        m6580R();
    }
}
