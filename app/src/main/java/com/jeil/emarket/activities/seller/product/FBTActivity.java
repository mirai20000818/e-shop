package com.jeil.emarket.activities.seller.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.components.RecyclerTabLayout;
import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.frag.analy.sale.FragmentChooseSaleProducts;
import com.jeil.emarket.viewmodel.ProductTotalVM;


public class FBTActivity extends BaseActivityForVendor {

    
    public ViewPager f11888K;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11889L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_add_sale_product).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FBTActivity.this.m6699t(view);
            }
        });
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            if (((FragmentChooseSaleProducts) this.f11889L.get(0)).m5384Z0() != null) {
                ((FragmentChooseSaleProducts) this.f11889L.get(0)).m4893Y0();
            }
        } else {
            if (i != 100 || i2 != 0 || ((FragmentChooseSaleProducts) this.f11889L.get(0)).m5384Z0() == null || intent == null) {
                return;
            }
            ((FragmentChooseSaleProducts) this.f11889L.get(0)).m5388c(intent.getIntExtra("id", 0));
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sale_products);
        m4307e(R.string.fbt_title);
        this.f6501u = false;
        this.f11888K = (ViewPager) findViewById(R.id.vp_categories);
        this.f11888K.setAdapter(this.f11889L);
        RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_sub_categories);
        recyclerTabLayout.setVisibility(View.GONE);
        recyclerTabLayout.setUpWithViewPager(this.f11888K);
        this.f11889L.addFragment(new FragmentChooseSaleProducts(this), getResources().getString(R.string.fbt_title));
        this.f11889L.notifyDataSetChanged();
        this.f11888K.setOffscreenPageLimit(this.f11889L.getCount() - 1);
        ((FragmentChooseSaleProducts) this.f11889L.get(0)).m4888T0();
        mo4284G();
        addBottomNav(0);
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    /* renamed from: t */
    public  void m6699t(View view) {
        ProductTotalVM.f10244l = new MutableLiveData<>();
        Intent intent = new Intent(getApplicationContext(), FBTEditActivity.class);
        intent.putExtra("page", "add");
        intent.putExtra("title", getResources().getString(R.string.add_FBT));
        startActivityForResult(intent, 100);
    }
}
