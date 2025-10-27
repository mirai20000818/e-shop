package com.jeil.emarket.activities.seller.product;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.model.customer.Category;
import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.FragmentTransaction;

import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.listener.product.sale.ProductSaleViewPager;
import com.jeil.emarket.listener.product.sale.RunnableSaleReport;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.dialog.DialogAddSaleProduct;
import com.jeil.emarket.frag.main.good.FragmentSalesProduct;
import com.jeil.emarket.frag.analy.sale.FragmentSaleReport;
import com.jeil.emarket.viewmodel.VendorListVM;
import com.jeil.emarket.viewmodel.CategoryVM;


public class ProductSaleActivity extends BaseActivityForVendor {

    
    public ViewPager f11903K;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11904L;

    /* renamed from: M */
    public int f11905M = 0;

    /* renamed from: N */
    public DialogAddSaleProduct f11906N;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_add_sale_product).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductSaleActivity.this.m6724u(view);
            }
        });
        ((EditForm) findViewById(R.id.cef_search)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductSaleActivity.this.m6725v(view);
            }
        });
        ((EditForm) findViewById(R.id.cef_search)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.a.i.v2.u
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ProductSaleActivity.this.m6722a(textView, i, keyEvent);
            }
        });
    }

    /* renamed from: R */
    public void m6720R() {
        addRefreshIcon(null);
        findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductSaleActivity.this.m6723t(view);
            }
        });
    }

    /* renamed from: S */
    public  void m6721S() {
        findViewById(R.id.cef_search).setVisibility(View.VISIBLE);
    }


    public  boolean m6722a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        ((FragmentSaleReport) this.f11904L.get(this.f11905M)).m5391a(((EditForm) findViewById(R.id.cef_search)).getText(), true);
        return true;
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            if (((FragmentSaleReport) this.f11904L.get(0)).m5389Z0() != null) {
                ((FragmentSaleReport) this.f11904L.get(0)).m4893Y0();
            }
        } else if (i == 100 && i2 == 1) {
            DialogAddSaleProduct.f9053D.setValue( (intent != null ? intent.getIntegerArrayListExtra("ids") : new ArrayList<>()));
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        Handler handler;
        Runnable runnable;
        super.onCreate(bundle);
        setContentView(R.layout.activity_sale_products);
        m4307e(R.string.product_sale);
        this.f11903K = (ViewPager) findViewById(R.id.vp_categories);
        this.f11904L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);
        this.f11903K.setAdapter(this.f11904L);
        ((RecyclerTabLayout) findViewById(R.id.rtl_sub_categories)).setUpWithViewPager(this.f11903K);
        this.f11903K.setOnPageChangeListener(new ProductSaleViewPager(this));
        ArrayList<Category> arrayList = new ArrayList();
        List<Category> getValue = CategoryVM.listMutableLiveData.getValue();
        int[] iArr = new int[0];
        if (VendorListVM.f10363d.getValue() != null && VendorListVM.f10363d.getValue().categories != null) {
            iArr = VendorListVM.f10363d.getValue().categories;
        }
        if (getValue != null) {
            FragmentSaleReport c2706q = new FragmentSaleReport(this);
            this.f11904L.addFragment(c2706q, getResources().getString(R.string.all));
            if (iArr.length != 0) {
                for (int i : iArr) {
                    for (int i2 = 0; i2 < getValue.size(); i2++) {
                        if (getValue.get(i2).f12393id == i) {
                            Category category = new Category();
                            category.f12393id = i;
                            category.tree = getValue.get(i2).tree;
                            category.name = getValue.get(i2).name;
                            arrayList.add(category);
                        }
                    }
                }
            }
            for (Category category2 : arrayList) {
                FragmentSaleReport c2706q2 = new FragmentSaleReport(this);
                c2706q2.f10113v0.setValue( Integer.valueOf(category2.f12393id));
                c2706q2.f10114w0.setValue( category2.tree);
                this.f11904L.addFragment(c2706q2, category2.name);
            }
            this.f11904L.notifyDataSetChanged();
            this.f11903K.setOffscreenPageLimit(this.f11904L.getCount() - 1);
            handler = new Handler();
            runnable = new RunnableSaleReport(c2706q);
        } else {
            findViewById(R.id.ll_categories).setVisibility(View.GONE);
            findViewById(R.id.vp_categories).setVisibility(View.GONE);
            final FragmentSalesProduct fragmentSalesProduct = new FragmentSalesProduct(this);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.ll_products, fragmentSalesProduct, null);
            beginTransaction.commit();
            handler = new Handler();
            runnable = new Runnable() { // from class: b.f.a.a.i.v2.h0
                @Override // java.lang.Runnable
                public final void run() {
                    fragmentSalesProduct.m4888T0();
                }
            };
        }
        handler.postDelayed(runnable, Status.time);
        m6720R();
        findViewById(R.id.header_border).setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.i.v2.v
            @Override // java.lang.Runnable
            public final void run() {
                ProductSaleActivity.this.m6721S();
            }
        }, 10L);
        this.f11906N = new DialogAddSaleProduct(this);
        mo4284G();
        addBottomNav(0);
    }

    /* renamed from: t */
    public  void m6723t(View view) {
        for (int i = 0; i < Math.min(Status.state2.length, this.f11904L.getCount()); i++) {
            if (((FragmentSaleReport) this.f11904L.get(i)).m5389Z0() != null) {
                ((EditForm) findViewById(R.id.cef_search)).setText("");
                ((FragmentSaleReport) this.f11904L.get(i)).m5391a("", false);
                ((FragmentSaleReport) this.f11904L.get(i)).m4893Y0();
            }
        }
    }

    /* renamed from: u */
    public  void m6724u(View view) {
        this.f11906N.show();
    }

    /* renamed from: v */
    public  void m6725v(View view) {
        ((FragmentSaleReport) this.f11904L.get(this.f11905M)).m5391a(((EditForm) findViewById(R.id.cef_search)).getText(), true);
    }
}
