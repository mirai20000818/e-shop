package com.jeil.emarket.activities.product;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.frag.main.good.Fragment_Tab_Border;


public class FBTCollectionActivity extends BaseActivity {

    
    public ViewPager f11772I;

   
    public FragmentPagerAdaperEx f11773J = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fbt_collection);
        m4307e(R.string.fbt_discount_title);
        this.f11772I = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11772I.setAdapter(this.f11773J);
        ((RecyclerTabLayout) findViewById(R.id.rtl_statuses)).setUpWithViewPager(this.f11772I);
        this.f11773J.addFragment((Fragment) new Fragment_Tab_Border(this), getResources().getString(R.string.process), false);
        findViewById(R.id.header_border).setVisibility(View.GONE);
        this.f11773J.notifyDataSetChanged();
        ((Fragment_Tab_Border) this.f11773J.get(0)).m4888T0();
        mo4284G();
        findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
        addBottomNav(R.id.navigation_account);
    }
}
