package com.jeil.emarket.activities.vendor;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentTransaction;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.frag.main.vendors.FragmentVendors;


public class VendorsActivity extends BaseActivity {
    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment);
        View.inflate(this, R.layout.layout_filter_button, (ViewGroup) findViewById(R.id.rl_content));
        FragmentVendors fragmentVendors = new FragmentVendors(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll_fragment, fragmentVendors, null);
        beginTransaction.commit();
        m4307e(R.string.vendor_list);
        fragmentVendors.m4888T0();
        mo4284G();
        addBottomNav(R.id.navigation_account);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
