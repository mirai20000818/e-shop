package com.jeil.emarket.activities.account;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.SearchFragmentBase;


public class RefundProductsActivity extends BaseActivity {

    
    public SearchFragmentBase f11680I;

    
    public  void m6369I() {
        this.f11680I.m4888T0();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            SearchFragmentBase searchFragment1 = this.f11680I;
            if (searchFragment1.f9170o0 != null) {
                searchFragment1.m4893Y0();
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment);
        this.f6500t = false;
        this.f11680I = new SearchFragmentBase(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll_fragment, this.f11680I, null);
        beginTransaction.commit();
        m4307e(R.string.refundable_product_list);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.a.g2
            @Override // java.lang.Runnable
            public final void run() {
                RefundProductsActivity.this.m6369I();
            }
        }, Status.time);
        mo4284G();
        addBottomNav(R.id.navigation_account);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
