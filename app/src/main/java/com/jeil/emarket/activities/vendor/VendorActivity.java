package com.jeil.emarket.activities.vendor;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.ShopFilter;
import com.jeil.emarket.model.vendor.Vendor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.widget.RecyclerViewEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.frag.main.good.FragmentSalesProduct;
import com.jeil.emarket.frag.main.vendors.FragmentVendorDescription;
import com.jeil.emarket.frag.main.vendors.FragmentPoint;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.viewmodel.DayProductVM;
import com.jeil.emarket.viewmodel.CategoryVM;


public class VendorActivity extends BaseActivity {

    /* renamed from: N */
    public static MutableLiveData<Vendor> f11940N = new MutableLiveData<>();

    
    public int f11941I;

   
    public int f11942J;

    
    public FragmentPagerAdaperEx f11943K;

    /* renamed from: L */
    public ViewPager f11944L;

    /* renamed from: M */
    public View f11945M;

    /* renamed from: com.jeil.emarket.activities.vendor.VendorActivity$a */
    public class C3228a implements ViewPager.OnPageChangeListener {
        public C3228a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrollStateChanged(int i) {
            VendorActivity.this.m6796g(i);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        findViewById(R.id.mrl_header_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.k.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorActivity.this.m6795d(view);
            }
        });
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    
    public void m6789I() {
        RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_vendor);
        this.f11944L = (ViewPager) findViewById(R.id.vp_vendor);
        this.f11943K = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);
        this.f11944L.setAdapter(this.f11943K);
        recyclerTabLayout.setUpWithViewPager(this.f11944L);
        this.f11944L.setOnPageChangeListener(new C3228a());
        FragmentSalesProduct fragmentSalesProduct = new FragmentSalesProduct(this);
        fragmentSalesProduct.f9467q0 = this.f11941I;
        fragmentSalesProduct.f9472v0.setValue( new ShopFilter());
        fragmentSalesProduct.categoryList.addAll((Collection) Objects.requireNonNull(CategoryVM.listMutableLiveData.getValue()));
        this.f11943K.addFragment(new FragmentVendorDescription(this, this.f11941I), getResources().getString(R.string.vendor_description));
        this.f11943K.addFragment(fragmentSalesProduct, getResources().getString(R.string.shop));
        this.f11943K.addFragment(new FragmentPoint(this, this.f11941I), getResources().getString(R.string.review));
        this.f11943K.notifyDataSetChanged();
        CustomString.m3172a(this.f11943K, 1, this.f11944L);
        this.f11944L.setEnabled(false);
        int i = this.f11942J;
        if (i > 0) {
            this.f11944L.setCurrentItem(i);
            ((FragmentVendorDescription) this.f11943K.get(0)).m5099S0();
            f11940N.observe(this, new Observer() { // from class: b.f.a.a.k.b
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    VendorActivity.this.m6794a((Vendor) obj);
                }
            });
        }
    }

   
    public  void m6790J() {
        this.f11944L.setCurrentItem(1, true);
    }

    
    public void m6791K() {
        RecyclerViewEx.MyAdapter myAdapterVar;
        if (f11940N.getValue() != null) {
            ArrayList arrayList = new ArrayList();
            FragmentSalesProduct fragmentSalesProduct = (FragmentSalesProduct) this.f11943K.get(1);
            Category category = new Category();
            category.name = getResources().getString(R.string.all);
            category.tree = "";
            arrayList.add(category);
            for (int i : f11940N.getValue().categories) {
                for (Category category2 : (List<Category>) Objects.requireNonNull(CategoryVM.listMutableLiveData.getValue())) {
                    if (category2.f12393id == i) {
                        arrayList.add(category2);
                    }
                }
            }
            fragmentSalesProduct.categoryList = arrayList;
            if (fragmentSalesProduct.f9462M0 == null || (myAdapterVar = fragmentSalesProduct.f9461L0) == null) {
                return;
            }
            myAdapterVar.clear();
            for (Category category3 : fragmentSalesProduct.categoryList) {
                if (fragmentSalesProduct.f9465o0.getValue() != null && category3.f12393id == fragmentSalesProduct.f9465o0.getValue().intValue()) {
                    RecyclerViewEx.MyAdapter myAdapterVar2 = fragmentSalesProduct.f9461L0;
                    myAdapterVar2.f8558n = myAdapterVar2.getItemCount();
                    fragmentSalesProduct.f9462M0.setCurrentItem(fragmentSalesProduct.f9461L0.getItemCount());
                }
                fragmentSalesProduct.f9461L0.add(category3.name);
            }
            fragmentSalesProduct.f9461L0.notifyDataSetChanged();
        }
    }


    public  void m6792a(FragmentSalesProduct fragmentSalesProduct, View view) {
        fragmentSalesProduct.m4888T0();
        fragmentSalesProduct.m5075k(view);
        view.setVisibility(View.VISIBLE);
        if (SimpleVM.f8836d) {
            return;
        }
        //this.f11945M = fragmentSalesProduct.m2486Q0().findViewById(R.id.fragment_tab_border);
    }


    public void m6793a(Category category) {
        RecyclerViewEx.MyAdapter myAdapterVar;
        BaseInterface2 baseInterface2;
        FragmentSalesProduct fragmentSalesProduct = (FragmentSalesProduct) this.f11943K.get(1);
        fragmentSalesProduct.f9465o0.setValue( Integer.valueOf(category.f12393id));
        fragmentSalesProduct.f9466p0.setValue( category.tree);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.k.d
            @Override // java.lang.Runnable
            public final void run() {
                VendorActivity.this.m6790J();
            }
        }, Status.time);
        for (int i = 0; i < fragmentSalesProduct.categoryList.size(); i++) {
            if (fragmentSalesProduct.categoryList.get(i).f12393id == category.f12393id && (baseInterface2 = (myAdapterVar = fragmentSalesProduct.f9461L0).f8559o) != null && myAdapterVar.f8550f != null && baseInterface2.mo4808a(i, (java.lang.String) myAdapterVar.arrayList.get(i), 0)) {
               // myAdapterVar.f8550f.m2806j(i);
                myAdapterVar.notifyItemChanged(myAdapterVar.f8558n);
                myAdapterVar.f8558n = i;
                myAdapterVar.notifyItemRangeChanged(i, 1);
            }
        }
    }


    public  void m6794a(Vendor vendor) {
        m6796g(this.f11942J);
    }


    public  void m6795d(View view) {
        Fragment fragment;
        FragmentPagerAdaperEx fragmentPagerAdaperEx = this.f11943K;
        if (fragmentPagerAdaperEx == null || fragmentPagerAdaperEx.getCount() <= 0) {
            List<Fragment> m1616n = getSupportFragmentManager().getFragments();
            if (m1616n.size() > 0) {
                for (int i = 0; i < m1616n.size(); i++) {
                    if (m1616n.get(i) instanceof FragmentSalesProduct) {
                        fragment = m1616n.get(i);
                    }
                }
                return;
            }
            return;
        }
        fragment = this.f11943K.get(1);
        ((FragmentSalesProduct) fragment).m5059Z0();
    }

    /* renamed from: g */
    public void m6796g(int i) {
        if (i == 0) {
            findViewById(R.id.mrl_header_filter).setVisibility(View.GONE);
            FragmentVendorDescription fragmentVendorDescription = (FragmentVendorDescription) this.f11943K.f7130l.get(i);
            VendorActivity vendorActivity = fragmentVendorDescription.f9555b0;
            if (vendorActivity != null) {
                View findViewById = vendorActivity.findViewById(R.id.header_border);
                MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) fragmentVendorDescription.f9556c0.findViewById(R.id.mrl_scroll_top);
                if (materialRippleLayout != null) {
                    fragmentVendorDescription.f9555b0.m4293a((NestedScrollView) fragmentVendorDescription.f9556c0.findViewById(R.id.nsv_main), materialRippleLayout, (View) null, findViewById, fragmentVendorDescription.f9555b0.findViewById(R.id.bottom_border), true);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 1) {
            final FragmentSalesProduct fragmentSalesProduct = (FragmentSalesProduct) this.f11943K.f7130l.get(i);
            if (f11940N.getValue() != null) {
                fragmentSalesProduct.f9468r0 = f11940N.getValue().currency;
            }
            final View findViewById2 = findViewById(R.id.mrl_header_filter);
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.k.a
                @Override // java.lang.Runnable
                public final void run() {
                    VendorActivity.this.m6792a(fragmentSalesProduct, findViewById2);
                }
            }, Status.time);
        } else {
            if (i != 2) {
                return;
            }
            final FragmentPoint fragmentPoint = (FragmentPoint) this.f11943K.f7130l.get(i);
            Handler handler = new Handler();
            fragmentPoint.getClass();
            handler.postDelayed(new Runnable() { // from class: b.f.a.a.k.e
                @Override // java.lang.Runnable
                public final void run() {
                    fragmentPoint.m5103S0();
                }
            }, Status.time);
            findViewById(R.id.mrl_header_filter).setVisibility(View.GONE);
        }
        findViewById(R.id.header_border).setVisibility(View.VISIBLE);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor);
        findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
        findViewById(R.id.mrl_header_filter).setVisibility(View.GONE);
        this.f6500t = false;
        this.f11941I = getIntent().getIntExtra("id", 0);
        this.f11942J = getIntent().getIntExtra("tabPosition", 0);
        m6789I();
        addBottomNav(0);
        mo4284G();
        DayProductVM.f10257f.add(Integer.valueOf(this.f11941I));
        try {
            DBManager.getDB().update("oneDayVendors", new Gson().toJson(DayProductVM.f10258g), -1);
        } catch (Exception unused) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return this.f11945M;
    }
}
