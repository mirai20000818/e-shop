package com.jeil.emarket.frag.main.bottom;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.ShopFilter;
import java.util.List;

import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.main.good.FragmentSalesProduct;
import com.jeil.emarket.viewmodel.CategoryVM;

/* renamed from: b.f.a.g.b.b.v0 */

public class FragmentDeals extends Fragment {

    /* renamed from: a0 */
    public FragmentPagerAdaperEx f9362a0;

    /* renamed from: b0 */
    public ViewPager f9363b0;

    /* renamed from: c0 */
    public RecyclerTabLayout f9364c0;

    /* renamed from: d0 */
    public int f9365d0 = 0;

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_deals, viewGroup, false);
        ((TextViewBold) inflate.findViewById(R.id.tv_header_title)).setText(R.string.deals);
        inflate.findViewById(R.id.ll_header).setBackgroundResource(R.drawable.sale);
        MainActivity mainActivity = (MainActivity) getActivity();
        this.f9363b0 = (ViewPager) inflate.findViewById(R.id.vp_categories);
        this.f9362a0 = new FragmentPagerAdaperEx(getParentFragmentManager(), 1);
        this.f9363b0.setAdapter(this.f9362a0);
        this.f9364c0 = (RecyclerTabLayout) inflate.findViewById(R.id.rtl_sub_categories);
        this.f9364c0.setUpWithViewPager(this.f9363b0);
        this.f9363b0.setOnPageChangeListener(new DealVPListener(this, inflate));
        final FragmentSalesProduct fragmentSalesProduct = new FragmentSalesProduct(mainActivity, "deals");
        fragmentSalesProduct.f9148l0 = true;
        fragmentSalesProduct.f9472v0.setValue(new ShopFilter());
        this.f9362a0.addFragment(fragmentSalesProduct, getResources().getString(R.string.all_products));
        if (CategoryVM.listMutableLiveData.getValue() != null) {
            for (Category category : CategoryVM.listMutableLiveData.getValue()) {
                FragmentSalesProduct c2423p02 = new FragmentSalesProduct(mainActivity, "deals");
                c2423p02.f9465o0.setValue( Integer.valueOf(category.f12393id));
                c2423p02.f9466p0.setValue( category.tree);
                c2423p02.f9472v0.setValue(new ShopFilter());
                c2423p02.f9148l0 = true;
                this.f9362a0.addFragment(c2423p02, category.name);
            }
        }
        this.f9362a0.notifyDataSetChanged();
        this.f9364c0.m6847b(0, true);
        this.f9363b0.setOffscreenPageLimit(this.f9362a0.getCount() - 1);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.b.s0
            @Override // java.lang.Runnable
            public final void run() {
                FragmentSalesProduct.this.m4888T0();
            }
        }, Status.time);
        inflate.findViewById(R.id.mrl_header_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentDeals.this.m4982c(view);
            }
        });
        m4983d(inflate);
        return inflate;
    }

    
    public  void m4982c(View view) {
        Fragment fragment;
        FragmentPagerAdaperEx fragmentPagerAdaperEx = this.f9362a0;
        if (fragmentPagerAdaperEx == null || fragmentPagerAdaperEx.getCount() <= 0) {
            List<Fragment> m1616n = getParentFragmentManager().getFragments();
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
        fragment = this.f9362a0.get(this.f9365d0);
        ((FragmentSalesProduct) fragment).m5059Z0();
    }

    
    public void m4983d(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity.bottomNavigationView != null) {
            view.findViewById(R.id.vp_categories).setPadding(0, 0, 0, (int) getResources().getDimension(R.dimen.bottom_height));
        }
        mainActivity.setClickEvent(view);
        view.findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
        view.findViewById(R.id.header_border).setVisibility(View.GONE);
    }
}
