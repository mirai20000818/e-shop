package com.jeil.emarket.activities.product;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.jeil.emarket.activities.ticket.add.TicketVendorCreateActivity;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.good.ReminderFragment;
import com.jeil.emarket.frag.main.good.Fragment_FAQ_List;
import com.jeil.emarket.frag.main.good.FragmentProductReview;
import com.jeil.emarket.viewmodel.ProductTotalVM;


public class ProductActivity extends BaseActivity {

    
    public int f11774I;

   
    public java.lang.String f11775J;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11777L;

    /* renamed from: M */
    public ViewPager f11778M;

    /* renamed from: O */
    public RecyclerTabLayout f11780O;

    
    public boolean f11776K = false;

    /* renamed from: N */
    public Bundle f11779N = new Bundle();

    /* renamed from: com.jeil.emarket.activities.product.ProductActivity$a */
    public class C3197a implements ViewPager.OnPageChangeListener {
        public C3197a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrollStateChanged(final int i) {
            if (i == 0) {
                final ReminderFragment reminderFragment = (ReminderFragment) ProductActivity.this.f11777L.f7130l.get(i);
                if (reminderFragment.f9429a0 == null) {
                    new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            reminderFragment.m5038U0();
                        }
                    }, Status.time);
                }
                reminderFragment.m5040W0();
                return;
            }
            if (i != 1) {
                if (i == 2) {
                    new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            ProductActivity.C3197a.this.m6556c(i);
                        }
                    }, Status.time);
                    return;
                }
                return;
            }
            final FragmentProductReview fragmentProductReview = (FragmentProductReview) ProductActivity.this.f11777L.f7130l.get(i);
            if (fragmentProductReview.f9481a0.size() == 0) {
                new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        fragmentProductReview.m5077S0();
                    }
                }, Status.time);
            }
            ProductActivity productActivity = fragmentProductReview.f9483c0;
            if (productActivity != null) {
                View findViewById = productActivity.findViewById(R.id.header_border);
                View mo4310w = fragmentProductReview.f9483c0.mo4310w();
                MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) fragmentProductReview.f9484d0.findViewById(R.id.mrl_scroll_top);
                if (materialRippleLayout != null) {
                    fragmentProductReview.f9483c0.m4293a((NestedScrollView) fragmentProductReview.f9484d0.findViewById(R.id.nsv_main), materialRippleLayout, mo4310w, findViewById, fragmentProductReview.f9483c0.findViewById(R.id.bottom_border), true);
                }
            }
        }

        
        public  void m6556c(int i) {
            ((Fragment_FAQ_List) ProductActivity.this.f11777L.f7130l.get(i)).m4888T0();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById(R.id.btn_add_ticket);
        if (materialRippleLayout != null) {
            materialRippleLayout.setVisibility(View.GONE);
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.g.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProductActivity.this.m6555d(view);
                }
            });
        }
    }

    
    public void m6554I() {
        this.f11780O = (RecyclerTabLayout) findViewById(R.id.rtl_product);
        this.f11778M = (ViewPager) findViewById(R.id.vp_product);
        this.f11777L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);
        this.f11778M.setAdapter(this.f11777L);
        this.f11780O.setUpWithViewPager(this.f11778M);
        this.f11778M.setOnPageChangeListener(new C3197a());
        this.f11777L.addFragment(new ReminderFragment(this, this.f11774I, this.f11776K), getResources().getString(R.string.product_description));
        this.f11777L.addFragment(new FragmentProductReview(this, this.f11774I), getResources().getString(R.string.product_review));
        this.f11777L.addFragment(new Fragment_FAQ_List(this, this.f11774I), getResources().getString(R.string.product_faq));
        this.f11777L.notifyDataSetChanged();
        CustomString.m3172a(this.f11777L, 1, this.f11778M);
    }

    
    public  void m6555d(View view) {
        Intent intent = new Intent(getApplicationContext(), TicketVendorCreateActivity.class);
        intent.putExtra("productId", this.f11774I);
        intent.putExtra("vendorName", this.f11775J);
        if (ProductTotalVM.f10237e.getValue() != null) {
            intent.putExtra("categories", new Gson().toJson(ProductTotalVM.f10237e.getValue().categoryPhone));
        }
        startActivity(intent);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6501u = false;
        setContentView(R.layout.activity_product);
        findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        this.f11774I = getIntent().getIntExtra("id", 0);
        this.f11776K = getIntent().getBooleanExtra("preview", false);
        this.f6500t = false;
        m6554I();
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
