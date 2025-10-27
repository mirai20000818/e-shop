package com.jeil.emarket.activities.point;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.RecyclerTabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.listener.pointlistener.PointVPListener;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.dialog.dialogRatingGroup;
import com.jeil.emarket.frag.main.vendor.SearchFragment;
import com.jeil.emarket.interf.InterfaceString;


public class PointActivity extends BaseActivity {

    
    public ViewPager f11757I;

    
    public Bundle f11759K;

   
    public FragmentPagerAdaperEx f11758J = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    /* renamed from: L */
    public MutableLiveData<List<Integer>> f11760L = new MutableLiveData<>(new ArrayList());

    /* renamed from: M */
    public MutableLiveData<List<Integer>> f11761M = new MutableLiveData<>(new ArrayList());

    /* renamed from: N */
    public MutableLiveData<List<Integer>> f11762N = new MutableLiveData<>(new ArrayList());

    /* renamed from: O */
    public List<Boolean> f11763O = new ArrayList();

    /* renamed from: P */
    public List<Boolean> f11764P = new ArrayList();

    /* renamed from: Q */
    public List<Boolean> f11765Q = new ArrayList();

    /* renamed from: R */
    public java.lang.String f11766R = "";

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.cal_filter_support).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointActivity.this.m6537d(view);
            }
        });
        findViewById(R.id.cal_filter_service).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointActivity.this.m6539e(view);
            }
        });
        findViewById(R.id.cal_filter_shipping).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointActivity.this.m6540f(view);
            }
        });
    }


    public  void m6531a(dialogRatingGroup dialogRatingGroup, DialogInterface dialogInterface) {
        if (dialogRatingGroup.f8851y.getValue() == null || this.f11760L.getValue() == null) {
            return;
        }
        if ((dialogRatingGroup.f8851y.getValue().size() == 0 && ((List) Objects.requireNonNull(this.f11760L.getValue())).size() == 0) || dialogRatingGroup.f8851y.getValue().equals(this.f11760L.getValue())) {
            return;
        }
        this.f11760L = dialogRatingGroup.f8851y;
        this.f11763O = dialogRatingGroup.f8852z;
        this.f11760L.observe(this, new Observer() { // from class: b.f.a.a.f.e
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PointActivity.this.m6534b((List) obj);
            }
        });
    }


    public  void m6532a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (java.lang.String str2 : this.f11766R.equals("account") ? Status.f8830u : Status.f8831v) {
                if (jSONObject.has(str2)) {
                    int i = jSONObject.getInt(str2) > -1 ? jSONObject.getInt(str2) : 0;
                    java.lang.String m219a = Util.getIdentifier(this, str2, "");
                    int m4417a = this.f11758J.m4417a(m219a);
                    if (m4417a != -1) {
                        if (this.f11758J.getInt(m4417a) != 0 && i != this.f11758J.getInt(m4417a)) {
                            ((SearchFragment) this.f11758J.get(m4417a)).m4893Y0();
                        }
                        this.f11758J.m4419a(m4417a, m219a, i);
                    }
                    recyclerTabLayout.m6847b(this.f11757I.getCurrentItem(), true);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public  void m6533b(dialogRatingGroup dialogRatingGroup, DialogInterface dialogInterface) {
        if (dialogRatingGroup.f8851y.getValue() == null || this.f11761M.getValue() == null) {
            return;
        }
        if ((dialogRatingGroup.f8851y.getValue().size() == 0 && ((List) Objects.requireNonNull(this.f11761M.getValue())).size() == 0) || dialogRatingGroup.f8851y.getValue().equals(this.f11761M.getValue())) {
            return;
        }
        this.f11761M = dialogRatingGroup.f8851y;
        this.f11764P = dialogRatingGroup.f8852z;
        this.f11761M.observe(this, new Observer() { // from class: b.f.a.a.f.l
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PointActivity.this.m6536c((List) obj);
            }
        });
    }


    public  void m6534b(List list) {
        MutableLiveData<List<Integer>> mutableLiveData = this.f11760L;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.f11760L.getValue().size() == 0) {
            ((ActionLink) findViewById(R.id.cal_filter_support)).setImageViewColor(R.color.dark);
            ((ActionLink) findViewById(R.id.cal_filter_support)).setmTextViewColor(R.color.dark);
        } else {
            ((ActionLink) findViewById(R.id.cal_filter_support)).setImageViewColor(BaseActivity.color);
            ((ActionLink) findViewById(R.id.cal_filter_support)).setmTextViewColor(BaseActivity.color);
        }
        try {
            ((SearchFragment) this.f11758J.get(this.f11757I.getCurrentItem())).m4909c(this.f11760L.getValue());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


    public  void m6535c(dialogRatingGroup dialogRatingGroup, DialogInterface dialogInterface) {
        if (dialogRatingGroup.f8851y.getValue() == null || this.f11762N.getValue() == null) {
            return;
        }
        if ((dialogRatingGroup.f8851y.getValue().size() == 0 && ((List) Objects.requireNonNull(this.f11762N.getValue())).size() == 0) || dialogRatingGroup.f8851y.getValue().equals(this.f11762N.getValue())) {
            return;
        }
        this.f11762N = dialogRatingGroup.f8851y;
        this.f11765Q = dialogRatingGroup.f8852z;
        this.f11762N.observe(this, new Observer() { // from class: b.f.a.a.f.d
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PointActivity.this.m6538d((List) obj);
            }
        });
    }


    public  void m6536c(List list) {
        MutableLiveData<List<Integer>> mutableLiveData = this.f11761M;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.f11761M.getValue().size() == 0) {
            ((ActionLink) findViewById(R.id.cal_filter_service)).setImageViewColor(R.color.dark);
            ((ActionLink) findViewById(R.id.cal_filter_service)).setmTextViewColor(R.color.dark);
        } else {
            ((ActionLink) findViewById(R.id.cal_filter_service)).setImageViewColor(BaseActivity.color);
            ((ActionLink) findViewById(R.id.cal_filter_service)).setmTextViewColor(BaseActivity.color);
        }
        ((SearchFragment) this.f11758J.get(this.f11757I.getCurrentItem())).m4907a(this.f11761M.getValue());
    }


    public  void m6537d(View view) {
        final dialogRatingGroup dialogRatingGroup = new dialogRatingGroup(this, this.f11760L.getValue(), this.f11763O);
        dialogRatingGroup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.f.k
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PointActivity.this.m6531a(dialogRatingGroup, dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(dialogRatingGroup.getWindow())).setDimAmount(0.85f);
        dialogRatingGroup.show();
    }


    public  void m6538d(List list) {
        MutableLiveData<List<Integer>> mutableLiveData = this.f11762N;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.f11762N.getValue().size() == 0) {
            ((ActionLink) findViewById(R.id.cal_filter_shipping)).setImageViewColor(R.color.dark);
            ((ActionLink) findViewById(R.id.cal_filter_shipping)).setmTextViewColor(R.color.dark);
        } else {
            ((ActionLink) findViewById(R.id.cal_filter_shipping)).setImageViewColor(BaseActivity.color);
            ((ActionLink) findViewById(R.id.cal_filter_shipping)).setmTextViewColor(BaseActivity.color);
        }
        ((SearchFragment) this.f11758J.get(this.f11757I.getCurrentItem())).m4908b(this.f11762N.getValue());
    }


    public  void m6539e(View view) {
        final dialogRatingGroup dialogRatingGroup = new dialogRatingGroup(this, this.f11761M.getValue(), this.f11764P);
        dialogRatingGroup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.f.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PointActivity.this.m6533b(dialogRatingGroup, dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(dialogRatingGroup.getWindow())).setDimAmount(0.85f);
        dialogRatingGroup.show();
    }

    /* renamed from: f */
    public  void m6540f(View view) {
        final dialogRatingGroup dialogRatingGroup = new dialogRatingGroup(this, this.f11762N.getValue(), this.f11765Q);
        dialogRatingGroup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.f.j
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PointActivity.this.m6535c(dialogRatingGroup, dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(dialogRatingGroup.getWindow())).setDimAmount(0.85f);
        dialogRatingGroup.show();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            for (int i3 = 0; i3 < this.f11758J.getCount(); i3++) {
                try {
                    if (((SearchFragment) this.f11758J.get(i3)).f9158r0 != null) {
                        ((SearchFragment) this.f11758J.get(i3)).m4893Y0();
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_point);
        this.f11759K = (Bundle) Objects.requireNonNull(getIntent().getExtras());
        this.f11766R = this.f11759K.getString("page");
        java.lang.String str = this.f11766R;
        if (str == null) {
            return;
        }
        m4307e(str.equals("account") ? R.string.point_list : R.string.vendor_point_list);
        for (int i = 0; i < 5; i++) {
            this.f11763O.add(false);
            this.f11765Q.add(false);
            this.f11764P.add(false);
        }
        this.f11757I = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11757I.setAdapter(this.f11758J);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f11757I);
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.f.g
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str2) {
                PointActivity.this.m6532a(recyclerTabLayout, str2);
            }
        };
        if (this.f11766R.equals("account")) {
            this.f11758J.addFragment((Fragment) new SearchFragment(this, "", "account", this.f11759K, null, null, null, interfaceString), getResources().getString(R.string.all), true);
            this.f11758J.addFragment((Fragment) new SearchFragment(this, "approved", "account", this.f11759K, null, null, null, interfaceString), getResources().getString(R.string.approved), true);
            this.f11758J.addFragment((Fragment) new SearchFragment(this, "pending", "account", this.f11759K, null, null, null, interfaceString), getResources().getString(R.string.pending), true);
            this.f11758J.addFragment((Fragment) new SearchFragment(this, "rejected", "account", this.f11759K, null, null, null, interfaceString), getResources().getString(R.string.rejected), true);
        } else if (this.f11766R.equals("vendor")) {
            this.f11758J.addFragment((Fragment) new SearchFragment(this, "", "vendor", this.f11759K, this.f11760L.getValue(), this.f11761M.getValue(), this.f11762N.getValue(), interfaceString), getResources().getString(R.string.all), true);
        }
        this.f11758J.notifyDataSetChanged();
        CustomString.m3172a(this.f11758J, 1, this.f11757I);
        ((SearchFragment) this.f11758J.get(0)).m4888T0();
        this.f11757I.setOnPageChangeListener(new PointVPListener(this));
        mo4284G();
        addBottomNav(R.id.navigation_account);
        if (this.f11766R.equals("vendor")) {
            findViewById(R.id.cal_filter_support).setVisibility(View.VISIBLE);
            findViewById(R.id.cal_filter_service).setVisibility(View.VISIBLE);
            findViewById(R.id.cal_filter_shipping).setVisibility(View.VISIBLE);
        }
    }
}
