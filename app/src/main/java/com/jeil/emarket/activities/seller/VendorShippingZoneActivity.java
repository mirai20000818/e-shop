package com.jeil.emarket.activities.seller;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.edittext.EditForm;

import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.frag.analy.staff.FragGetShippingZones;


public class VendorShippingZoneActivity extends BaseActivityForVendor {

    
    public ViewPager f11864K;

    /* renamed from: N */
    public BaseDialog2 f11867N;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11865L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    /* renamed from: M */
    public MutableLiveData<String> f11866M = new MutableLiveData<>("");

    /* renamed from: O */
    public boolean f11868O = false;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorShippingZoneActivity.this.showFilterDialog(view);
            }
        });
        findViewById(R.id.mrl_add_sale_product).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorShippingZoneActivity.this.m6671t(view);
            }
        });
    }


    public  void m6669a(@SuppressLint({"InflateParams"}) View view, DialogInterface dialogInterface) {
        if (this.f11868O) {
            this.f11866M.setValue( ((EditForm) view.findViewById(R.id.cef_shipping_zone)).getText());
            try {
                ((FragGetShippingZones) this.f11865L.get(this.f11864K.getCurrentItem())).m5372b(this.f11866M.getValue());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    
    public  void m6670b(@SuppressLint({"InflateParams"}) View view, View view2) {
        ((EditForm) view.findViewById(R.id.cef_shipping_zone)).setText("");
        this.f11868O = true;
        this.f11867N.startAni();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1 && ((FragGetShippingZones) this.f11865L.get(0)).m5371Z0() != null) {
            ((FragGetShippingZones) this.f11865L.get(0)).m4893Y0();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6501u = false;
        setContentView(R.layout.activity_sale_products);
        m4307e(R.string.shipping_zone_manage);
        this.f11864K = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11864K.setAdapter(this.f11865L);
        RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setVisibility(View.GONE);
        recyclerTabLayout.setUpWithViewPager(this.f11864K);
        this.f11865L.addFragment(new FragGetShippingZones(this, this.f11866M.getValue()), getResources().getString(R.string.shipping_zone_manage));
        this.f11865L.notifyDataSetChanged();
        this.f11864K.setOffscreenPageLimit(this.f11865L.getCount() - 1);
        ((FragGetShippingZones) this.f11865L.get(0)).m4888T0();
        mo4284G();
        addBottomNav(0);
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    public void showFilterDialog(View view) {
        final View inflate = getLayoutInflater().inflate(R.layout.dialog_shipping_zone_filter, (ViewGroup) null);
        this.f11867N = new BaseDialog2(this, new String[0], inflate, 8388613);
        this.f11868O = false;
        inflate.findViewById(R.id.mrl_btn_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VendorShippingZoneActivity.this.m6672u(view2);
            }
        });
        inflate.findViewById(R.id.mrl_btn_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VendorShippingZoneActivity.this.m6670b(inflate, view2);
            }
        });
        this.f11867N.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.s1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VendorShippingZoneActivity.this.m6669a(inflate, dialogInterface);
            }
        });
        ((EditForm) inflate.findViewById(R.id.cef_shipping_zone)).setText(this.f11866M.getValue());
        BaseDialog2 baseDialog2 = this.f11867N;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.76f;
        baseDialog2.show();
    }

    /* renamed from: t */
    public  void m6671t(View view) {
        Intent intent = new Intent(this, ShippingZoneEditActivity.class);
        intent.putExtra("type", "add");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, 100);
    }

    /* renamed from: u */
    public  void m6672u(View view) {
        this.f11868O = true;
        this.f11867N.startAni();
    }
}
