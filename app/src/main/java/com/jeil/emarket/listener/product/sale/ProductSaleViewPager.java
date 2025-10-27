package com.jeil.emarket.listener.product.sale;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.activities.seller.product.ProductSaleActivity;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.frag.analy.sale.FragmentSaleReport;

/* renamed from: b.f.a.a.i.v2.i0 */

public class ProductSaleViewPager implements ViewPager.OnPageChangeListener {

    
    public final ProductSaleActivity f6890a;

    public ProductSaleViewPager(ProductSaleActivity productSaleActivity) {
        this.f6890a = productSaleActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j
    
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

    public void onPageScrollStateChanged(int i) {
        ProductSaleActivity productSaleActivity = this.f6890a;
        productSaleActivity.f11905M = i;
        ((FragmentSaleReport) productSaleActivity.f11904L.f7130l.get(i)).m5391a(((EditForm) this.f6890a.findViewById(R.id.cef_search)).getText(), false);
        FragmentSaleReport c2706q = (FragmentSaleReport) this.f6890a.f11904L.f7130l.get(i);
        Handler handler = new Handler();
        c2706q.getClass();
        handler.postDelayed(new RunnableSaleReport(c2706q), Status.time);
    }
}
