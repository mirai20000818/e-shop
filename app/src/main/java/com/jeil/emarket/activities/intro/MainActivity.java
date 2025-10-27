package com.jeil.emarket.activities.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.auth.LoginActivity;
import com.jeil.emarket.activities.order.CartActivity;
import com.jeil.emarket.activities.product.SearchActivity;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import java.util.List;

import androidx.fragment.app.FragmentManager;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.main.vendor.FragmentNavigationAccount;
import com.jeil.emarket.frag.main.bottom.FragmentCategories;
import com.jeil.emarket.frag.main.bottom.FragmentDeals;
import com.jeil.emarket.frag.main.bottom.FragmentHome;
import com.jeil.emarket.frag.main.bottom.FragmentMessage;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.CategoryVM;


public class MainActivity extends BaseActivity {

    /* renamed from: L */
    public static int global_id = R.id.navigation_home;

    
    public View f11727I;

   
    public long f11728J = 0;

    
    public int id = R.id.navigation_home;

    
    public boolean m6451I() {
        return this.id == R.id.navigation_home;
    }


    public void m6452a(int i, Bundle bundle, boolean z) {
        FragmentManager c0331a;
        StringBuilder sb;
        if (i == R.id.navigation_account && UserVM.userMutableLiveData.getValue() == null) {
            startActivityForResult(new Intent(getApplicationContext(), LoginActivity.class), 100);
            return;
        }
        if (i == R.id.navigation_account) {
            close();
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment1 = fragmentManager.getFragment(null,i + "");//  m1583b(i + "");
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        if (fragment1 != null) {
            this.id = i;
            fragment1.setArguments(bundle);
            if ((fragment1 instanceof FragmentCategories) && bundle != null) {
                CategoryVM.m5580a(bundle.getInt("pos"));
            }
            List<Fragment> m1616n = fragmentManager.getFragments();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();// new FragmentTransaction(fragmentManager);
//            if (z) {
//                fragmentTransaction.f2321b = R.anim.activity_open_enter;
//                fragmentTransaction.f2322c = R.anim.fade_out;
//                fragmentTransaction.f2323d = 0;
//                fragmentTransaction.f2324e = 0;
//            }
//            for (int i2 = 0; i2 < m1616n.size(); i2++) {
//                if (m1616n.get(i2).m2487R() == null || !((String) Objects.requireNonNull(m1616n.get(i2).m2487R())).equals("nav")) {
//                    fragmentTransaction.mo1512c(m1616n.get(i2));
//                }
//            }
//            if (this.bottomNavigationView != null) {
//                if (i == R.id.navigation_home && (fragment1 instanceof FragmentHome)) {
//                    ((FragmentHome) fragment1).m4994X0();
//                } else {
//                    this.bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
//                    findViewById(R.id.bottom_border).setVisibility(View.GONE);
//                }
//            }
//            fragmentTransaction.mo1517f(fragment1);
//            fragmentTransaction.commit();
            return;
        }
        Fragment fragment = null;
        if(i == R.id.navigation_account){
            fragment = new FragmentNavigationAccount();
        }
        else if(i == R.id.navigation_categories){
            fragment = new FragmentCategories();
        }
        else if(i == R.id.navigation_deals){
            fragment = new FragmentDeals();
        }
        else if(i == R.id.navigation_home){
            fragment = new FragmentHome();
        }
        else if(i == R.id.navigation_message){
            fragment = new FragmentMessage(this);
        }

        if (fragment != null) {
            this.id = i;
//            fragment.m2546k(bundle);
//            List<Fragment> m1616n2 = fragmentManager.getFragments();
//            FragmentTransaction c0331a3 = fragmentManager.beginTransaction();// new FragmentTransaction(fragmentManager);
//            for (int i3 = 0; i3 < m1616n2.size(); i3++) {
//                if (m1616n2.get(i3).m2487R() == null || !((String) Objects.requireNonNull(m1616n2.get(i3).m2487R())).equals("nav")) {
//                    c0331a3.mo1512c(m1616n2.get(i3));
//                }
//            }
//            c0331a3.commit();
            BottomNavigationView bottomNavigationView = this.bottomNavigationView;
            if (bottomNavigationView != null) {
                if (i == R.id.navigation_home) {
                    ((FragmentHome) fragment).m4994X0();
                } else {
                    bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
                    findViewById(R.id.bottom_border).setVisibility(View.GONE);
                }
            }
//            if (z) {
//                c0331a = new Frag(fragmentManager);
//                c0331a.f2321b = R.anim.activity_open_enter;
//                c0331a.f2322c = R.anim.fade_out;
//                c0331a.f2323d = 0;
//                c0331a.f2324e = 0;
//                sb = new StringBuilder();
//            } else {
//                c0331a = new FragmentTransaction(fragmentManager);
//                sb = new StringBuilder();
//            }
//            sb.append(i);
//            sb.append("");
//            c0331a.replace(R.id.ll_fragment, fragment, sb.toString(), 1);
//            c0331a.commit();
        }
    }


    public  void m6453a(LinearLayoutCompat linearLayoutCompat, View view) {
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity.this.m6454d(view2);
            }
        });
    }

    
    public  void m6454d(View view) {
        close();
    }

    
    public  void m6455e(View view) {
        switchView(R.id.navigation_home);
        m6457g(R.id.navigation_home);
    }

    /* renamed from: f */
    public  void m6456f(View view) {
        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
    }

    /* renamed from: g */
    public void m6457g(int i) {
        int i2 = global_id;
        m6452a(i, null, i2 == 0 || i2 != i);
        global_id = R.id.navigation_home;
    }

    /* renamed from: g */
    public  void m6458g(View view) {
        startActivity(new Intent(getApplicationContext(), CartActivity.class));
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            m6457g(R.id.navigation_account);
        } else {
            switchView(this.id);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (m4309v()) {
            return;
        }
        if (this.id != R.id.navigation_home && this.bottomNavigationView != null) {
            switchView(R.id.navigation_home);
        } else if (this.f11728J + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Util.toast(this, getString(R.string.exit_from_app), "general", 0, 0);
            this.f11728J = System.currentTimeMillis();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra;
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        if (getIntent().getExtras() != null && (intExtra = getIntent().getIntExtra("fragment", 0)) != 0) {
            global_id = intExtra;
        }
        addBottomNav(global_id);
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        if (bottomNavigationView != null) {
            bottomNavigationView.setIndex(0);
        }
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.bottomNavigationView != null) {
            if (global_id == 0) {
                global_id = R.id.navigation_home;
            }
            switchView(global_id);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onResume() {
        super.onResume();
        CategoryVM.f10388f.setValue( true);
    }

    public void setClickEvent(View view) {
        View findViewById = view.findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            if (materialRippleLayout != null) {
                materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MainActivity.this.m6455e(view2);
                    }
                });
            }
            final LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) findViewById.findViewById(R.id.ll_logo);
            if (linearLayoutCompat != null) {
                linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MainActivity.this.m6453a(linearLayoutCompat, view2);
                    }
                });
            }
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) view.findViewById(R.id.mrl_header_search);
            if (materialRippleLayout2 != null) {
                materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MainActivity.this.m6456f(view2);
                    }
                });
            }
            MaterialRippleLayout materialRippleLayout3 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_cart);
            if (materialRippleLayout3 != null) {
                materialRippleLayout3.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MainActivity.this.m6458g(view2);
                    }
                });
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return this.f11727I;
    }
}
