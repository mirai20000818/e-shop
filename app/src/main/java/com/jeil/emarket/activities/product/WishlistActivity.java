package com.jeil.emarket.activities.product;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import java.util.List;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.listener.wish.WishlistVPListener;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.adapters.fbt.ProductAdapter;
import com.jeil.emarket.adapters.shipping.VendorAdapter;
import com.jeil.emarket.frag.main.good.FragmentSalesProduct;
import com.jeil.emarket.frag.main.company.CompanyFragment;
import com.jeil.emarket.viewmodel.ProductVendorVM;


public class WishlistActivity extends BaseActivity {

    
    public FragmentPagerAdaperEx fragmentPagerAdaperEx;

   
    public ViewPager f11793J;


    public  void m6566a(CompanyFragment companyFragment, RecyclerTabLayout recyclerTabLayout, List list) {
        XRecyclerView xRecyclerView;
        if (list != null) {
            if (list.size() == 0 && (xRecyclerView = companyFragment.xRecyclerView) != null) {
                xRecyclerView.setNoMore(true);
            }
            int m4423c = this.fragmentPagerAdaperEx.getInt(1);
            this.fragmentPagerAdaperEx.m4418a(1, list.size());
            recyclerTabLayout.m6847b(1, true);
            companyFragment.f9580p0 = list;
            if (companyFragment.xRecyclerView != null) {
                if (m4423c == list.size() + 1) {
                    companyFragment.vendorAdapter.arrayList.remove(ProductVendorVM.f10381i);
                    if (companyFragment.vendorAdapter.arrayList.size() == 0) {
                        companyFragment.vendorAdapter.notifyDataSetChanged();
                        return;
                    } else {
                        companyFragment.vendorAdapter.notifyItemChanged(companyFragment.xRecyclerView.arrayList.size() + ProductVendorVM.f10381i + 1);
                        return;
                    }
                }
                if (m4423c != list.size() - 1) {
                    companyFragment.m4893Y0();
                    return;
                }
                VendorAdapter c1912c2 = companyFragment.vendorAdapter;
                c1912c2.arrayList.add(0, ProductVendorVM.f10380h);
                c1912c2.notifyItemRangeRemoved(0, 1);
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wishlist);
        m4307e(R.string.wishlist);
        this.f11793J = (ViewPager) findViewById(R.id.vp_statuses);
        this.fragmentPagerAdaperEx = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);
        this.f11793J.setAdapter(this.fragmentPagerAdaperEx);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f11793J);
        final FragmentSalesProduct fragmentSalesProduct = new FragmentSalesProduct(this, "wishlist");
        fragmentSalesProduct.f9459J0 = "wishlist";
        fragmentSalesProduct.f9148l0 = true;
        final CompanyFragment companyFragment = new CompanyFragment(this);
        companyFragment.f9148l0 = true;
        this.fragmentPagerAdaperEx.addFragment((Fragment) fragmentSalesProduct, getResources().getString(R.string.wishlist_product), true);
        this.fragmentPagerAdaperEx.addFragment((Fragment) companyFragment, getResources().getString(R.string.wishlist_vendor), true);
        this.fragmentPagerAdaperEx.notifyDataSetChanged();
        ProductVendorVM.f10377e.observe(this, new Observer() { // from class: b.f.a.a.g.h
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                WishlistActivity.this.m6566a(companyFragment, recyclerTabLayout, (List) obj);
            }
        });
        ProductVendorVM.f10376d.observe(this, new Observer() { // from class: b.f.a.a.g.i
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                WishlistActivity.this.m6565a(fragmentSalesProduct, recyclerTabLayout, (List) obj);
            }
        });
        this.fragmentPagerAdaperEx.notifyDataSetChanged();
        CustomString.m3172a(this.fragmentPagerAdaperEx, 1, this.f11793J);
        ((FragmentSalesProduct) this.fragmentPagerAdaperEx.get(0)).m4888T0();
        this.f11793J.setOnPageChangeListener(new WishlistVPListener(this));
        mo4284G();
        findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
        addBottomNav(R.id.navigation_account);
    }


    public  void m6565a(FragmentSalesProduct fragmentSalesProduct, RecyclerTabLayout recyclerTabLayout, List list) {
        XRecyclerView xRecyclerView;
        if (list != null) {
            if (list.size() == 0 && (xRecyclerView = fragmentSalesProduct.xRecyclerView) != null) {
                xRecyclerView.setNoMore(true);
            }
            int m4423c = this.fragmentPagerAdaperEx.getInt(0);
            this.fragmentPagerAdaperEx.m4418a(0, list.size());
            recyclerTabLayout.m6847b(0, true);
            fragmentSalesProduct.f9460K0 = list;
            if (fragmentSalesProduct.xRecyclerView != null) {
                if (m4423c == list.size() + 1) {
                    fragmentSalesProduct.f9476z0.arrayList.remove(ProductVendorVM.f10379g);
                    if (fragmentSalesProduct.f9476z0.arrayList.size() == 0) {
                        fragmentSalesProduct.f9476z0.notifyDataSetChanged();
                        return;
                    } else {
                        fragmentSalesProduct.f9476z0.notifyItemChanged(fragmentSalesProduct.xRecyclerView.arrayList.size() + ProductVendorVM.f10379g + 1);
                        return;
                    }
                }
                if (m4423c == list.size() - 1) {
                    ProductAdapter c1879s = fragmentSalesProduct.f9476z0;
                    c1879s.arrayList.add(0, ProductVendorVM.f10378f);
                    c1879s.notifyItemRangeRemoved(0, 1);
                    return;
                }
                fragmentSalesProduct.m4893Y0();
            }
        }
    }
}
