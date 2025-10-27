package com.jeil.emarket.activities.product;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.ShopFilter;
import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.frag.main.good.FragmentSalesProduct;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.providers.CategoryProvider;


public class ShopActivity extends BaseActivity {

    
    public CategoryProvider f11782I;

   
    public FragmentPagerAdaperEx f11783J;

    
    public ViewPager f11784K;

    /* renamed from: L */
    public RecyclerTabLayout f11785L;

    /* renamed from: N */
    public View f11787N;

    /* renamed from: P */
    public boolean f11789P;

    /* renamed from: Q */
    public boolean f11790Q;

    /* renamed from: M */
    public int f11786M = 0;

    /* renamed from: O */
    public boolean f11788O = true;

    /* renamed from: com.jeil.emarket.activities.product.ShopActivity$a */
    public class C3198a implements ViewPager.OnPageChangeListener {
        public C3198a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
        
        public void onPageScrolled(int i, float f, int i2) {
        }

        
        public  void m6564a(int i, FragmentSalesProduct fragmentSalesProduct) {
            View findViewById;
            if (!SimpleVM.f8836d) {
                ShopActivity shopActivity = ShopActivity.this;
               // shopActivity.f11787N = shopActivity.f11783J.f7130l.get(i).m2486Q0().findViewById(R.id.fragment_tab_border);
                if (fragmentSalesProduct.categoryList.size() == 0) {
                    ShopActivity shopActivity2 = ShopActivity.this;
                    shopActivity2.f11787N = shopActivity2.findViewById(R.id.header_tab_border);
                }
            }
            fragmentSalesProduct.m4888T0();
            fragmentSalesProduct.m5075k(ShopActivity.this.findViewById(R.id.mrl_header_filter));
            if (i == 0 || (SimpleVM.f8836d && fragmentSalesProduct.categoryList.size() == 0)) {
                findViewById = ShopActivity.this.findViewById(R.id.header_tab_border);

                findViewById.setVisibility(View.GONE);
            } else {
                findViewById = ShopActivity.this.findViewById(R.id.header_tab_border);

                findViewById.setVisibility(View.VISIBLE);
            }

        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrollStateChanged(final int i) {
            View findViewById;
            ShopActivity shopActivity = ShopActivity.this;
            shopActivity.f11786M = i;
            final FragmentSalesProduct fragmentSalesProduct = (FragmentSalesProduct) shopActivity.f11783J.f7130l.get(i);
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.c
                @Override // java.lang.Runnable
                public final void run() {
                    ShopActivity.C3198a.this.m6564a(i, fragmentSalesProduct);
                }
            }, Status.time);
            if (i == 0 || (SimpleVM.f8836d && fragmentSalesProduct.categoryList.size() == 0)) {
                findViewById = ShopActivity.this.findViewById(R.id.header_tab_border);
                findViewById.setVisibility(View.GONE);
            } else {
                findViewById = ShopActivity.this.findViewById(R.id.header_tab_border);
                findViewById.setVisibility(View.VISIBLE);
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.product.ShopActivity$b */
    public class C3199b extends TypeToken<ShopFilter> {
        public C3199b(ShopActivity shopActivity) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        if (!SimpleVM.f8836d) {
            this.f6500t = false;
        }
        findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
        if (this.f11788O) {
            findViewById(R.id.mrl_header_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.g.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShopActivity.this.m6563d(view);
                }
            });
        } else {
            findViewById(R.id.mrl_header_filter).setVisibility(View.GONE);
        }
    }

    
    public final void m6558I() {
        this.f11784K = (ViewPager) findViewById(R.id.vp_categories);
        this.f11783J = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);
        this.f11784K.setAdapter(this.f11783J);
        this.f11785L = (RecyclerTabLayout) findViewById(R.id.rtl_sub_categories);
        this.f11785L.setUpWithViewPager(this.f11784K);
        this.f11787N = findViewById(R.id.header_tab_border);
        this.f11784K.setOnPageChangeListener(new C3198a());
    }

   
    public void m6559J() {
        this.f11782I.f10475f.observe(this, new Observer() { // from class: b.f.a.a.g.f
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                ShopActivity.this.m6562b((List) obj);
            }
        });
    }

    
    public void m6560a(Bundle bundle) {
        if (bundle != null) {
            int i = bundle.getInt("category", 0);
            String string = bundle.getString("tree", "");
            this.f11789P = bundle.getBoolean("new_products", false);
            this.f11790Q = bundle.getBoolean("monthly_products", false);
            if (i > 0 && !string.isEmpty()) {
                this.f11782I.m5658a(this, i, string);
                m6558I();
                m6559J();
                return;
            }
            if (bundle.getBoolean("from_category", false) || this.f11789P || this.f11790Q) {
                m6558I();
                findViewById(R.id.header_tab_border).setVisibility(View.GONE);
                final FragmentSalesProduct fragmentSalesProduct = new FragmentSalesProduct(this);
                fragmentSalesProduct.f9472v0.setValue( new ShopFilter());
                this.f11783J.addFragment(fragmentSalesProduct, getResources().getString(R.string.all_products));
                if (this.f11789P) {
                    this.f11788O = false;
                    fragmentSalesProduct.f9456G0 = false;
                    fragmentSalesProduct.f9473w0 = "createdAt";
                    fragmentSalesProduct.f9475y0 = true;
                    fragmentSalesProduct.f9459J0 = "newProducts";
                    m4307e(R.string.new_products);
                }
                if (this.f11790Q) {
                    this.f11788O = false;
                    fragmentSalesProduct.f9456G0 = true;
                    fragmentSalesProduct.f9459J0 = "monthly";
                    m4307e(R.string.monthly_products);
                }
                if (CategoryVM.listMutableLiveData.getValue() != null) {
                    for (Category category : CategoryVM.listMutableLiveData.getValue()) {
                        FragmentSalesProduct c2423p02 = new FragmentSalesProduct(this);
                        c2423p02.f9465o0.setValue( Integer.valueOf(category.f12393id));
                        c2423p02.f9466p0.setValue( category.tree);
                        c2423p02.f9472v0.setValue( new ShopFilter());
                        if (this.f11789P) {
                            this.f11788O = false;
                            c2423p02.f9456G0 = false;
                            c2423p02.f9473w0 = "createdAt";
                            c2423p02.f9475y0 = true;
                            c2423p02.f9459J0 = "newProducts";
                        } else if (this.f11790Q) {
                            this.f11788O = false;
                            c2423p02.f9456G0 = true;
                            c2423p02.f9459J0 = "monthly";
                        } else {
                            List<Category> list = category.children;
                            c2423p02.categoryList = list != null ? new ArrayList(list) : new ArrayList();
                            c2423p02.categoryList.add(0, category);
                            c2423p02.f9457H0 = true;
                        }
                        this.f11783J.addFragment(c2423p02, category.name);
                    }
                }
                this.f11783J.notifyDataSetChanged();
                this.f11785L.m6847b(0, true);
                this.f11784K.setOffscreenPageLimit(this.f11783J.getCount() - 1);
                new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        fragmentSalesProduct.m4888T0();
                    }
                }, Status.time);
                return;
            }
        }
        findViewById(R.id.ll_categories).setVisibility(View.GONE);
        findViewById(R.id.vp_categories).setVisibility(View.GONE);
        findViewById(R.id.header_border).setVisibility(View.GONE);
        findViewById(R.id.header_tab_border).setVisibility(View.GONE);
        final FragmentSalesProduct fragmentSalesProduct = new FragmentSalesProduct(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll_products, fragmentSalesProduct, null);
        beginTransaction.commit();
        ShopFilter shopFilter = new ShopFilter();
        if (bundle != null) {
            String trim = bundle.getString("search", "").trim();
            int i2 = bundle.getInt("vendor", 0);
            boolean z = bundle.getBoolean("sales", false);
            boolean z2 = bundle.getBoolean("is_featured", false);
            int i3 = bundle.getInt("collection_id", 0);
            if (i3 > 0) {
                this.f11788O = false;
                fragmentSalesProduct.f9456G0 = true;
                fragmentSalesProduct.f9459J0 = "collection";
                fragmentSalesProduct.f9470t0 = i3;
                m4297a("");
            }
            String string2 = bundle.getString("PARAM", "");
            if (!string2.isEmpty()) {
                try {
                    shopFilter = (ShopFilter) new Gson().fromJson(string2, new C3199b(this).getType());
                } catch (Exception e2) {
                    e2.getLocalizedMessage();
                }
            }
            (trim.isEmpty() ? findViewById(R.id.mrl_header_search_input) : findViewById(R.id.mrl_header_search)).setVisibility(View.GONE);
            if (!trim.isEmpty()) {
                fragmentSalesProduct.f9469s0 = trim;
                m4297a("");
                findViewById(R.id.mrl_header_search_input).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.tv_search)).setText(trim);
            } else if (i2 > 0) {
                fragmentSalesProduct.f9467q0 = i2;
                m4297a("");
            } else if (z) {
                fragmentSalesProduct.f9473w0 = Status.f8824o[3];
            } else if (z2) {
                shopFilter.isFeatured = true;
            }
        }
        fragmentSalesProduct.f9472v0.setValue( shopFilter);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.k
            @Override // java.lang.Runnable
            public final void run() {
                fragmentSalesProduct.m4888T0();
            }
        }, Status.time);
    }

    
    public  void m6561a(FragmentSalesProduct fragmentSalesProduct) {
        fragmentSalesProduct.m4888T0();
        fragmentSalesProduct.m5075k(findViewById(R.id.mrl_header_filter));
    }


    public  void m6562b(List list) {
        FragmentSalesProduct fragmentSalesProduct = new FragmentSalesProduct(this);
        Category getValue = this.f11782I.f10476g.getValue();
        if (getValue != null) {
            fragmentSalesProduct.f9465o0.setValue( Integer.valueOf(getValue.f12393id));
            fragmentSalesProduct.f9466p0.setValue( getValue.tree);
            m4297a(getValue.name);
            fragmentSalesProduct.f9472v0.setValue( new ShopFilter());
            if (this.f11782I.f10477h.getValue() != null && this.f11782I.f10477h.getValue().f12393id == getValue.f12393id) {
                fragmentSalesProduct.f9465o0.setValue( this.f11782I.f10473d.getValue());
                fragmentSalesProduct.f9466p0.setValue( this.f11782I.f10474e.getValue());
            }
        }
        this.f11783J.addFragment(fragmentSalesProduct, getResources().getString(R.string.all_products));
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Category category = (Category) list.get(i2);
            FragmentSalesProduct c2423p02 = new FragmentSalesProduct(this);
            c2423p02.f9465o0.setValue( Integer.valueOf(category.f12393id));
            c2423p02.f9466p0.setValue( category.tree);
            c2423p02.f9472v0.setValue( new ShopFilter());
            c2423p02.categoryList.addAll(category.children);
            c2423p02.categoryList.add(0, category);
            if (this.f11782I.f10473d.getValue() != null && this.f11782I.f10473d.getValue().intValue() == category.f12393id) {
                i = i2 + 1;
            }
            if (this.f11782I.f10477h.getValue() != null && this.f11782I.f10477h.getValue().f12393id == category.f12393id) {
                i = i2 + 1;
                c2423p02.f9465o0.setValue( this.f11782I.f10473d.getValue());
                c2423p02.f9466p0.setValue( this.f11782I.f10474e.getValue());
            }
            this.f11783J.addFragment(c2423p02, category.name);
        }
        this.f11783J.notifyDataSetChanged();
        this.f11785L.m6847b(0, true);
        this.f11784K.setOffscreenPageLimit(this.f11783J.getCount() - 1);
        if (list.size() > 0) {
            if (i != 0) {
                this.f11784K.setCurrentItem(i);
            } else {
                final FragmentSalesProduct c2423p03 = (FragmentSalesProduct) this.f11783J.get(0);
                new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.g.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShopActivity.this.m6561a(c2423p03);
                    }
                }, Status.time);
            }
        }
    }


    public  void m6563d(View view) {
        Fragment fragment;
        FragmentPagerAdaperEx fragmentPagerAdaperEx = this.f11783J;
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
        fragment = this.f11783J.get(this.f11786M);
        ((FragmentSalesProduct) fragment).m5059Z0();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_shop);
        this.f11782I = (CategoryProvider) new ViewModelProvider(this).get(CategoryProvider.class);
        m4307e(R.string.shop);
        m6560a(getIntent().getExtras());
        mo4284G();
        setAppBar();
        addBottomNav(R.id.navigation_categories);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        View view = this.f11787N;
        if (view == null) {
            return null;
        }
        if (!SimpleVM.f8836d) {
            return view;
        }
        findViewById(R.id.header_border).setVisibility(View.VISIBLE);
        return null;
    }
}
