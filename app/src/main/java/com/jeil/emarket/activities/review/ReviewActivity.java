package com.jeil.emarket.activities.review;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.RecyclerTabLayout;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.listener.review.ReviewVPAdapter;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.vendor.FragmentReviewRating;
import com.jeil.emarket.interf.InterfaceString;


public class ReviewActivity extends BaseActivity {

    
    public ViewPager viewPager;

   
    public FragmentPagerAdaperEx fragmentPagerAdaperEx = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    
    public Bundle bundle;


    public  void m6567a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : Status.f8833x) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    if (str2.equals("withMedia")) {
                        str2 = "with_media";
                    }
                    java.lang.String m219a = Util.getIdentifier(this, str2, "");
                    int m4417a = this.fragmentPagerAdaperEx.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.fragmentPagerAdaperEx.getInt(m4417a) != 0 && i != this.fragmentPagerAdaperEx.getInt(m4417a)) {
                            ((FragmentReviewRating) this.fragmentPagerAdaperEx.get(m4417a)).m4893Y0();
                        }
                        this.fragmentPagerAdaperEx.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.viewPager.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            for (int i3 = 0; i3 < this.fragmentPagerAdaperEx.getCount(); i3++) {
                try {
                    if (((FragmentReviewRating) this.fragmentPagerAdaperEx.get(i3)).m4918Z0() != null) {
                        ((FragmentReviewRating) this.fragmentPagerAdaperEx.get(i3)).m4893Y0();
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_review);
        this.bundle = (Bundle) Objects.requireNonNull(getIntent().getExtras());
        m4307e(R.string.product_review);
        this.viewPager = (ViewPager) findViewById(R.id.vp_statuses);
        this.viewPager.setAdapter(this.fragmentPagerAdaperEx);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.viewPager);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.h.c
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                ReviewActivity.this.m6567a(recyclerTabLayout, str);
            }
        };
        this.fragmentPagerAdaperEx.addFragment((Fragment) new FragmentReviewRating(this, "", "account", this.bundle, null, interfaceString), getResources().getString(R.string.all), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new FragmentReviewRating(this, "approved", "account", this.bundle, null, interfaceString), getResources().getString(R.string.approved), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new FragmentReviewRating(this, "pending", "account", this.bundle, null, interfaceString), getResources().getString(R.string.pending), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) new FragmentReviewRating(this, "rejected", "account", this.bundle, null, interfaceString), getResources().getString(R.string.rejected), true);
        this.fragmentPagerAdaperEx.notifyDataSetChanged();
        CustomString.m3172a(this.fragmentPagerAdaperEx, 1, this.viewPager);
        ((FragmentReviewRating) this.fragmentPagerAdaperEx.get(0)).m4888T0();
        this.viewPager.setOnPageChangeListener(new ReviewVPAdapter(this));
        mo4284G();
        addBottomNav(R.id.navigation_account);
    }
}
