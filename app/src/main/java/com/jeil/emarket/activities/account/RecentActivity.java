package com.jeil.emarket.activities.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.model.customer.Product;
import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.fbt.ProductAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration3;
import com.jeil.emarket.viewmodel.DayProductVM;


public class RecentActivity extends BaseActivity {

    
    public ProductAdapter f11676I;

   
    public boolean f11677J = true;

    
    public  void m6359b(List list) {
        ProductAdapter c1879s = this.f11676I;
        c1879s.arrayList = list;
        c1879s.notifyDataSetChanged();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recent);
        m4307e(R.string.recent_products);
        mo4284G();
        addBottomNav(R.id.navigation_account);
        XRecyclerView xRecyclerView = (XRecyclerView) findViewById(R.id.rv_recent_product);
        this.f11676I = new ProductAdapter(this, "grid");
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) this, 2, 1, false);
        xRecyclerView.setRefreshProgressStyle(22);
        xRecyclerView.setLoadingMoreProgressStyle(22);
        xRecyclerView.setAdapter(this.f11676I);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLayoutManager(gridLayoutManager);
        xRecyclerView.addItemDecoration(new ItemDecoration3(2, BaseActivity.anInt2, true, true));
        xRecyclerView.f12375Z0 = this.f11677J;
        View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
        ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_clock_direction);
        ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_recent);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        xRecyclerView.setEmptyView(inflate);
        xRecyclerView.header = ((int) getResources().getDimension(R.dimen.header_height)) + ((int) getResources().getDimension(R.dimen.bottom_height));
        DayProductVM.f10255d.observe(this, new Observer() { // from class: b.f.a.a.a.y1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                RecentActivity.this.m6359b((List) obj);
            }
        });
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onResume() {
        super.onResume();
        ArrayList arrayList = new ArrayList();
        Product product = new Product();
        product.type = "" +
                "." +
                "0";
        for (int i = 0; i < 6; i++) {
            arrayList.add(product);
        }
        ProductAdapter c1879s = this.f11676I;
        c1879s.arrayList = arrayList;
        c1879s.notifyDataSetChanged();
        DayProductVM.m5486a(this);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
