package com.jeil.emarket.activities.baseactivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.jeil.emarket.R;
import com.jeil.emarket.activities.auth.VendorLoginActivity;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.activities.intro.VendorSettingActivity;
import com.jeil.emarket.activities.seller.AnalyticsActivity;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.activities.seller.VendorFinanceActivity;
import com.jeil.emarket.activities.seller.VendorShippingZoneActivity;
import com.jeil.emarket.activities.seller.VendorStaffActivity;
import com.jeil.emarket.activities.seller.product.FBTActivity;
import com.jeil.emarket.activities.seller.product.ProductSaleActivity;
import com.jeil.emarket.components.AccountNavItem;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.frag.analy.staff.C2614k3;
import com.jeil.emarket.frag.analy.staff.C2624m3;
import com.jeil.emarket.frag.analy.staff.C2639p3;
import com.jeil.emarket.frag.analy.staff.C2649r3;
import com.jeil.emarket.frag.analy.staff.FragmentVendorListPage;
import com.jeil.emarket.frag.ticket.base.FragmentCustomerTicketBox;
import com.jeil.emarket.frag.ticket.base.FragmentTicketListVendorEx;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.model.vendor.OrderHistory;
import com.jeil.emarket.services.BackgroundService;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.VendorListVM;
import com.jeil.emarket.widget.base.BottomNavListener;
import com.jeil.emarket.widget.base.Nav_view;

import java.util.List;

/* renamed from: b.f.a.a.c.i1 */

public class BaseActivityForVendor extends BaseActivity {

    
    public ImageDialog2 f6520I = null;

   
    public BottomNavigationView f6521J;


    public static  void m4317a(View view, OrderHistory orderHistory) {
        OrderHistory.Orders orders = orderHistory.orders;
        if (orders == null || orders.requested <= 0) {
            ((AccountNavItem) view.findViewById(R.id.ani_orders)).m6809a(false);
        } else {
            ((AccountNavItem) view.findViewById(R.id.ani_orders)).m6809a(true);
        }
        int i = orderHistory.tickets;
        AccountNavItem accountNavItem = (AccountNavItem) view.findViewById(R.id.ani_ticket_box);
        if (i > 0) {
            accountNavItem.m6809a(true);
        } else {
            accountNavItem.m6809a(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
    
        if (r1 != 5) goto L38;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static  void m4318a(android.view.View r14, com.jeil.emarket.model.vendor.VendorUser r15) {
        /*
            if (r15 == 0) goto Le6
            com.jeil.emarket.model.vendor.VendorUser$User r0 = r15.user
            java.lang.String r0 = r0.role
            r1 = -1
            int r2 = r0.hashCode()
            java.lang.String r3 = "vendorFinanceManager"
            java.lang.String r4 = "vendorManager"
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            switch(r2) {
                case -2124152507: goto L49;
                case -1578773722: goto L3f;
                case -502447653: goto L37;
                case 31570589: goto L2d;
                case 730474914: goto L23;
                case 1208779703: goto L19;
                default: goto L18;
            }
        L18:
            goto L50
        L19:
            java.lang.String r2 = "vendorShippingManager"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L50
            r1 = 5
            goto L50
        L23:
            java.lang.String r2 = "vendorAdManager"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L50
            r1 = 3
            goto L50
        L2d:
            java.lang.String r2 = "vendorAgent"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L50
            r1 = 4
            goto L50
        L37:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L50
            r1 = 1
            goto L50
        L3f:
            java.lang.String r2 = "vendorProductManager"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L50
            r1 = 2
            goto L50
        L49:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L50
            r1 = 0
        L50:
            r0 = 2131230828(0x7f08006c, float:1.807772E38)
            r2 = 2131230836(0x7f080074, float:1.8077736E38)
            r11 = 2131230838(0x7f080076, float:1.807774E38)
            r12 = 2131230851(0x7f080083, float:1.8077766E38)
            r13 = 2131230843(0x7f08007b, float:1.807775E38)
            if (r1 == 0) goto L97
            if (r1 == r9) goto L97
            if (r1 == r8) goto L8c
            if (r1 == r7) goto L74
            if (r1 == r6) goto L6c
            if (r1 == r5) goto L6f
            goto Lac
        L6c:
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r13, r10, r12, r10)
        L6f:
            android.view.View r0 = r14.findViewById(r2)
            goto L93
        L74:
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r0, r10, r11, r10)
            r0 = 2131230824(0x7f080068, float:1.8077712E38)
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r13, r10, r0, r10)
            android.view.View r0 = r14.findViewById(r12)
            r0.setVisibility(r10)
            r0 = 2131230823(0x7f080067, float:1.807771E38)
            android.view.View r0 = r14.findViewById(r0)
            goto L93
        L8c:
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r11, r10, r13, r10)
            android.view.View r0 = r14.findViewById(r12)
        L93:
            r0.setVisibility(r10)
            goto Lac
        L97:
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r0, r10, r11, r10)
            r0 = 2131230824(0x7f080068, float:1.8077712E38)
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r2, r10, r0, r10)
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r13, r10, r12, r10)
            r0 = 2131230823(0x7f080067, float:1.807771E38)
            r1 = 2131230849(0x7f080081, float:1.8077762E38)
            p078b.p079a.p080a.p081a.C0660a.m3167a(r14, r0, r10, r1, r10)
        Lac:
            com.jeil.emarket.model.vendor.VendorUser$User r0 = r15.user
            java.lang.String r0 = r0.role
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto Lc0
            r0 = 2131230845(0x7f08007d, float:1.8077754E38)
            android.view.View r0 = r14.findViewById(r0)
            r0.setVisibility(r10)
        Lc0:
            com.jeil.emarket.model.vendor.VendorUser$User r15 = r15.user
            java.lang.String r15 = r15.role
            boolean r15 = r15.equals(r3)
            if (r15 == 0) goto Ld7
            r15 = 2131230849(0x7f080081, float:1.8077762E38)
            android.view.View r14 = r14.findViewById(r15)
            com.jeil.emarket.components.AccountNavItem r14 = (com.jeil.emarket.components.AccountNavItem) r14
            r15 = 2131689810(0x7f0f0152, float:1.9008646E38)
            goto Le3
        Ld7:
            r15 = 2131230849(0x7f080081, float:1.8077762E38)
            android.view.View r14 = r14.findViewById(r15)
            com.jeil.emarket.components.AccountNavItem r14 = (com.jeil.emarket.components.AccountNavItem) r14
            r15 = 2131690699(0x7f0f04cb, float:1.901045E38)
        Le3:
            r14.setText(r15)
        Le6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p161a.p164c.ActivityC1397i1.m4318a(android.view.View, com.jeil.emarket.model.vendor.VendorUser):void");
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        View findViewById = findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.GONE);
                materialRippleLayout2.setVisibility(View.VISIBLE);
            }
            if (materialRippleLayout2 != null) {
                materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.l0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseActivityForVendor.this.m4344d(view);
                    }
                });
            }
        }
    }

    
    public  void m4322I() {
        //this.drawerLayout.m1434b();
    }

   
    public  void m4323J() {
        //this.drawerLayout.m1434b();
    }

    
    public  void m4324K() {
        startActivity(new Intent(getApplicationContext(), MainActivityForVendor.class));
        //this.drawerLayout.m1434b();
    }

    /* renamed from: L */
    public  void m4325L() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        //this.drawerLayout.m1434b();
    }

    /* renamed from: M */
    public  void m4326M() {
        //this.drawerLayout.m1434b();
    }

    /* renamed from: N */
    public  void m4327N() {
        //this.drawerLayout.m1434b();
    }

    /* renamed from: O */
    public  void m4328O() {
        //this.drawerLayout.m1434b();
    }

    /* renamed from: P */
    public  void m4329P() {
        //this.drawerLayout.m1434b();
    }

    /* renamed from: Q */
    public void m4330Q() {
        View inflate = View.inflate(this, R.layout.dialog_update_password, null);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_current_password);
        final EditForm editForm2 = (EditForm) inflate.findViewById(R.id.cef_new_password);
        final EditForm editForm3 = (EditForm) inflate.findViewById(R.id.cef_confirm_password);
        editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editForm.showeye();
            }
        });
        editForm2.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editForm2.showeye();
            }
        });
        editForm3.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editForm3.showeye();
            }
        });
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseActivityForVendor.this.m4363s(view);
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseActivityForVendor.this.m4339a(editForm, editForm2, editForm3, view);
            }
        });
        this.f6520I = Util.m211a((Activity) this, inflate);
        this.f6520I.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */

    public void m4331a(int i, View view) {
        char c2;
        this.f6521J = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        if (view != null) {
            this.f6521J = (BottomNavigationView) view.findViewById(R.id.bottom_navigation);
        }
        BottomNavigationView bottomNavigationView = this.f6521J;
        if (bottomNavigationView != null) {
            bottomNavigationView.m6885a(true);
            Nav_view btview = new Nav_view(R.id.navigation_home, getString(R.string.dashboard), R.drawable.ic_home);
            Nav_view btview2 = new Nav_view(R.id.navigation_orders, getString(R.string.order_list), R.drawable.ic_orders);
            Nav_view btview3 = new Nav_view(R.id.navigation_tickets, getString(R.string.ticket_box), R.drawable.ic_message_dots);
            Nav_view btview4 = new Nav_view(R.id.navigation_review, getString(R.string.product_review), R.drawable.ic_review);
            Nav_view btview5 = new Nav_view(R.id.navigation_products, getString(R.string.shop), R.drawable.ic_products);
            if (UserVM.vendorUserMutableLiveData.getValue() != null) {
                String str = UserVM.vendorUserMutableLiveData.getValue().user.role;
                switch (str.hashCode()) {
                    case -2124152507:
                        if (str.equals("vendorManager")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1578773722:
                        if (str.equals("vendorProductManager")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -502447653:
                        if (str.equals("vendorFinanceManager")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 31570589:
                        if (str.equals("vendorAgent")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 730474914:
                        if (str.equals("vendorAdManager")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1208779703:
                        if (str.equals("vendorShippingManager")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0 || c2 == 1) {
                    this.f6521J.m6884a(btview);
                    this.f6521J.m6884a(btview2);
                } else {
                    if (c2 != 2) {
                        if (c2 == 3) {
                            this.f6521J.m6884a(btview5);
                        } else {
                            if (c2 != 4) {
                                if (c2 == 5) {
                                    this.f6521J.m6884a(btview2);
                                }
                                switchView(i);
                                this.f6521J.setOnBottomNavigationItemClickListener(new BottomNavListener() { // from class: b.f.a.a.c.h0
                                    @Override // p078b.p159f.p160a.p190c.p227z.InterfaceC2155d

                                    public final void mo4274a(int i2) {
                                        BaseActivityForVendor.this.m4347g(i2);
                                    }
                                });
                            }
                            this.f6521J.m6884a(btview2);
                        }
                        this.f6521J.m6884a(btview3);
                        this.f6521J.m6884a(btview4);
                        switchView(i);
                        this.f6521J.setOnBottomNavigationItemClickListener(new BottomNavListener() { // from class: b.f.a.a.c.h0
                            @Override // p078b.p159f.p160a.p190c.p227z.InterfaceC2155d

                            public final void mo4274a(int i2) {
                                BaseActivityForVendor.this.m4347g(i2);
                            }
                        });
                    }
                    this.f6521J.m6884a(btview);
                }
                this.f6521J.m6884a(btview3);
                this.f6521J.m6884a(btview4);
                this.f6521J.m6884a(btview5);
                switchView(i);
                this.f6521J.setOnBottomNavigationItemClickListener(new BottomNavListener() { // from class: b.f.a.a.c.h0
                    @Override // p078b.p159f.p160a.p190c.p227z.InterfaceC2155d

                    public final void mo4274a(int i2) {
                        BaseActivityForVendor.this.m4347g(i2);
                    }
                });
            }
        }
    }


    public void m4333a(int i, boolean z) {
        mo4334a(i, true, z);
    }


    public  void m4336a(final BaseDialog2 baseDialog2, View view, final int i) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.z
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4332a(i, baseDialog2);
            }
        }, Status.time);
    }


    public  void m4337a(DialogError dialogError) {
        UserVM.vendorUserMutableLiveData.setValue( null);
        UserVM.stringMutableLiveData3.setValue( null);
        dialogError.dismiss();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public  void m4338a(DialogC2001j dialogC2001j, Integer num) {
        ImageDialog2 imageDialog2;
        if (num.intValue() == 200 && (imageDialog2 = this.f6520I) != null) {
            imageDialog2.m4595e();
            //this.drawerLayout.m1434b();
        }
        dialogC2001j.dismiss();
    }


    public  void m4341b(final BaseDialog2 baseDialog2, View view, final int i) {
        if (this instanceof MainActivityForVendor) {
            m4333a(i == 0 ? R.id.navigation_review : R.id.llc_vendor_list_page, true);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.i0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivityForVendor.this.m4351i(i);
                }
            }, Status.time);
        }
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.s
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4340b(baseDialog2);
            }
        }, Status.time);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"DefaultLocale", "SetTextI18n"})

    public void mo4302b(User user) {
        if (user != null) {
            TicketCategoryListVM.m5496a(this);
        }
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) findViewById(R.id.llc_main_content);
        if (user == null || linearLayoutCompat == null) {
            return;
        }
        Glide.with((FragmentActivity) this).load(Util.m345e(String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(user.avatar)))).load(getResources().getDrawable(R.drawable.man)).into((ImageView) linearLayoutCompat.findViewById(R.id.iv_avatar));
        ((TextView) linearLayoutCompat.findViewById(R.id.tv_user_id)).setText(user.name);
        ((TextView) linearLayoutCompat.findViewById(R.id.tv_user_name)).setText(user.fullName + getResources().getString(R.string.comrade));
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1

    public void addBottomNav(int i) {
        m4331a(i, (View) null);
    }


    public void m4342c(Intent intent) {
        startActivity(intent);
        if (this.drawerLayout != null) {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.d1
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivityForVendor.this.m4322I();
                }
            }, Status.time);
        }
    }


    public  void m4343c(final BaseDialog2 baseDialog2, View view, final int i) {
        if (this instanceof MainActivityForVendor) {
            m4333a(i == 0 ? R.id.navigation_tickets : R.id.ani_market_link, true);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.w0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivityForVendor.this.m4349h(i);
                }
            }, Status.f8814e);
        }
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.u0
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4335a(baseDialog2);
            }
        }, Status.time);
    }


    public  void m4344d(View view) {
        close();
    }

    
    public  void m4345e(View view) {
        Intent intent = new Intent(getApplicationContext(), AnalyticsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.t0
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4329P();
            }
        }, Status.time);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: f */
    public void switchView(int i) {
        BottomNavigationView bottomNavigationView = this.f6521J;
        if (bottomNavigationView != null) {
            bottomNavigationView.setActiveItemOnlyColor(i);
        }
    }

    /* renamed from: f */
    public  void m4346f(View view) {
        Intent intent = new Intent(getApplicationContext(), VendorFinanceActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.c0
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4323J();
            }
        }, Status.time);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007a, code lost:
    
        if (r14 == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0105, code lost:
    
        ((com.jeil.emarket.activities.seller.MainActivity) r13).f6521J.setActiveItemOnlyColor(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
    
        if (r14 == 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
    
        if (r14 != 2) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ae, code lost:
    
        if (r14 != 2) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ba, code lost:
    
        if (r14 != 2) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00cf, code lost:
    
        if (r14 != 2) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dd, code lost:
    
        if (r14 != 3) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f4, code lost:
    
        if (r14 != 3) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0103, code lost:
    
        if (r14 != 4) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0138, code lost:
    
        if (r14 != 4) goto L99;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m4347g(int r14) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p161a.p164c.ActivityC1397i1.m4347g(int):void");
    }

    /* renamed from: g */
    public  void m4348g(View view) {
        if (VendorListVM.f10363d.getValue() != null && (VendorListVM.f10363d.getValue().enableTicket == null || VendorListVM.f10363d.getValue().enableTicket.booleanValue())) {
            final BaseDialog2 baseDialog2 = new BaseDialog2(this, new String[]{getResources().getString(R.string.customer_ticket_box), getResources().getString(R.string.market_ticket_box)}, null, 80);
            baseDialog2.show();
            baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.c.v0
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

                public final void mo4264a(View view2, int i) {
                    BaseActivityForVendor.this.m4343c(baseDialog2, view2, i);
                }
            };
        } else if (this instanceof MainActivityForVendor) {
            m4333a(R.id.navigation_tickets, true);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.a0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivityForVendor.this.m4324K();
                }
            }, Status.time);
        }
    }

    /* renamed from: h */
    public  void m4349h(int i) {
        MainActivityForVendor.global_id = i == 0 ? R.id.navigation_tickets : R.id.ani_market_link;
        Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /* renamed from: h */
    public  void m4350h(View view) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, new String[]{getResources().getString(R.string.product_review), getResources().getString(R.string.point_list)}, null, 80);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.c.q0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                BaseActivityForVendor.this.m4341b(baseDialog2, view2, i);
            }
        };
    }

    
    public  void m4351i(int i) {
        MainActivityForVendor.global_id = i == 0 ? R.id.navigation_review : R.id.llc_vendor_list_page;
        Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    
    public  void m4352i(View view) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.b0
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4325L();
            }
        }, Status.time);
    }

   
    public void mo4353j(int i) {
        m4333a(i, false);
    }

   
    public  void m4354j(View view) {
        m4330Q();
    }

    
    public  void m4355k(View view) {
        Intent intent = new Intent(getApplicationContext(), VendorStaffActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        m4342c(intent);
    }

    /* renamed from: l */
    public  void m4356l(View view) {
        Intent intent = new Intent(getApplicationContext(), VendorSettingActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        m4342c(intent);
    }

    /* renamed from: m */
    public  void m4357m(View view) {
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, new String[]{getResources().getString(R.string.product_sale), getResources().getString(R.string.collection_products)}, null, 80);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.c.r
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i) {
                BaseActivityForVendor.this.m4336a(baseDialog2, view2, i);
            }
        };
    }

    /* renamed from: n */
    public  void m4358n(View view) {
        final DialogError dialogError = new DialogError(this);
        dialogError.f8246v = getResources().getString(R.string.logout_confirm);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new DialogInterface() { // from class: b.f.a.a.c.e1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                dialogError.dismiss();
            }
        }, new DialogInterface() { // from class: b.f.a.a.c.q
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                BaseActivityForVendor.this.m4337a(dialogError);
            }
        });
    }

    /* renamed from: o */
    public  void m4359o(View view) {
        if (this instanceof MainActivityForVendor) {
            m4333a(R.id.navigation_home, true);
            //this.drawerLayout.m1434b();
            return;
        }
        //this.drawerLayout.m1434b();
        Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.p
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4326M();
            }
        }, Status.time);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (UserVM.stringMutableLiveData3.getValue() == null || UserVM.vendorUserMutableLiveData.getValue() == null) {
            Intent intent = new Intent(this, VendorLoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    /* renamed from: p */
    public  void m4360p(View view) {
        if (this instanceof MainActivityForVendor) {
            m4333a(R.id.navigation_products, true);
            //this.drawerLayout.m1434b();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
        MainActivityForVendor.global_id = R.id.navigation_products;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.e0
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4327N();
            }
        }, Status.time);
    }

    /* renamed from: q */
    public  void m4361q(View view) {
        if (this instanceof MainActivityForVendor) {
            m4333a(R.id.navigation_orders, true);
            //this.drawerLayout.m1434b();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
        MainActivityForVendor.global_id = R.id.navigation_orders;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.s0
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivityForVendor.this.m4328O();
            }
        }, Status.time);
    }

    /* renamed from: r */
    public  void m4362r(View view) {
        m4342c(new Intent(getApplicationContext(), VendorShippingZoneActivity.class));
    }

    /* renamed from: s */
    public  void m4363s(View view) {
        this.f6520I.dismiss();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p005b.p006a.ActivityC0045t, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void setContentView(int i) {
        //this.drawerLayout = new DrawerLayout(this);
        //this.drawerLayout.setFitsSystemWindows(true);
        //this.drawerLayout.addView(View.inflate(this, i, null));
        DrawerLayout.LayoutParams eVar = new DrawerLayout.LayoutParams((BaseActivity.anInt * 2) / 3, -1);
        //eVar.f2022a = 8388611;
        View inflate = View.inflate(this, R.layout.nav_vendor_menu, null);
        NavigationView navigationView = new NavigationView(this);
        navigationView.addView(inflate);
        navigationView.setLayoutParams(eVar);
        navigationView.setBackgroundColor(getResources().getColor(R.color.grey));
        //this.drawerLayout.addView(navigationView);
        if (!BackgroundService.f12457m) {
            BackgroundService.f12459o = getApplicationContext();
            startService(new Intent(this, BackgroundService.class));
        }
        NestedScrollView nestedScrollView = (NestedScrollView) this.drawerLayout.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            m4286a((View) nestedScrollView, (BaseActivity) this, (View) this.drawerLayout, false);
        }
        super.setContentView(this.drawerLayout);
        showFilteredMenu(inflate);
        setMenuLinks(inflate);
    }

    public void setMenuLinks(View view) {
        view.findViewById(R.id.ani_dashboard).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4359o(view2);
            }
        });
        view.findViewById(R.id.ani_products).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4360p(view2);
            }
        });
        view.findViewById(R.id.ani_orders).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4361q(view2);
            }
        });
        view.findViewById(R.id.ani_shipping_zone).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4362r(view2);
            }
        });
        view.findViewById(R.id.ani_analytics).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4345e(view2);
            }
        });
        view.findViewById(R.id.ani_finance).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4346f(view2);
            }
        });
        view.findViewById(R.id.ani_ticket_box).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4348g(view2);
            }
        });
        view.findViewById(R.id.ani_reviews).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4350h(view2);
            }
        });
        view.findViewById(R.id.mrl_vendor_link).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4352i(view2);
            }
        });
        view.findViewById(R.id.ani_update_password).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4354j(view2);
            }
        });
        view.findViewById(R.id.ani_staff).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4355k(view2);
            }
        });
        view.findViewById(R.id.ani_setting_business_info).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4356l(view2);
            }
        });
        view.findViewById(R.id.ani_advertisement).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4357m(view2);
            }
        });
        view.findViewById(R.id.mrl_logout).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseActivityForVendor.this.m4358n(view2);
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void showFilteredMenu(final android.view.View r15) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p161a.p164c.ActivityC1397i1.showFilteredMenu(android.view.View):void");
    }


    public  void m4335a(BaseDialog2 baseDialog2) {
        //this.drawerLayout.m1434b();
        baseDialog2.startAni();
    }


    public  void m4340b(BaseDialog2 baseDialog2) {
        //this.drawerLayout.m1434b();
        baseDialog2.startAni();
    }


    public  void m4332a(int i, BaseDialog2 baseDialog2) {
        Intent intent = i == 0 ? new Intent(getApplicationContext(), ProductSaleActivity.class) : new Intent(getApplicationContext(), FBTActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        m4342c(intent);
        baseDialog2.startAni();
    }


    public  void m4339a(EditForm editForm, EditForm editForm2, EditForm editForm3, View view) {
        boolean z;
        String text = editForm.getText();
        String text2 = editForm2.getText();
        String text3 = editForm3.getText();
        if (text.isEmpty()) {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            z = false;
        }
        if (text2.isEmpty()) {
            editForm2.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm2.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (text3.isEmpty()) {
            editForm3.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm3.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (z) {
            return;
        }
        if (!text2.equals(text3)) {
            Util.toast(this, getString(R.string.enter_correct_password), "error", 0, 0);
            return;
        }
        if (text2.length() < 8) {
            Util.toast(this, String.format(getResources().getString(R.string.enter_password_limit), 8), "error", 0, 0);
            return;
        }
        UserVM.m5521a(this, text, text2);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.integerMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.c.c1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                BaseActivityForVendor.this.m4338a(dialogC2001j, (Integer) obj);
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    public void mo4334a(int i, boolean z, boolean z2) {
        FragmentTransaction c0331a;
        String str;
        FragmentManager getSupportFragmentManager = getSupportFragmentManager();
        Fragment m1583b = getSupportFragmentManager.getFragment(null,i + "");
        List<Fragment> m1616n = getSupportFragmentManager.getFragments();
        FragmentTransaction c0331a2 = getSupportFragmentManager.beginTransaction();
        if (z) {
            //c0331a2.m1725a(R.anim.activity_open_enter, R.anim.fade_out, 0, 0);
        }
        for (int i2 = 0; i2 < m1616n.size(); i2++) {
            //c0331a2.mo1512c(m1616n.get(i2));
        }
        if (m1583b != null) {
            //c0331a2.mo1517f(m1583b);
            c0331a2.commit();
            if (z2) {
                switchView(i);
                return;
            }
            return;
        }
        c0331a2.commit();
        Fragment fragment = null;
        if (i == R.id.ani_market_link)
                fragment = new FragmentTicketListVendorEx(this);
        else if (i ==  R.id.llc_vendor_list_page )
            fragment = new C2639p3();
        else if (i ==  R.id.navigation_home )
            fragment = new C2614k3();
        else if (i ==  R.id.navigation_orders )
            fragment = new C2624m3();
        else if (i ==  R.id.navigation_products )
            fragment = new C2649r3();
        else if (i ==  R.id.navigation_review )
            fragment = new FragmentVendorListPage();
        else if (i ==  R.id.navigation_tickets )
            fragment = new FragmentCustomerTicketBox(this);

        if (fragment != null) {
            if (z) {
               // c0331a = new getSupportFragmentManager.beginTransaction();
               // c0331a.m1725a(R.anim.activity_open_enter, R.anim.fade_out, 0, 0);
                str = i + "";
            } else {
                c0331a = getSupportFragmentManager.beginTransaction();
                str = i + "";
            }
            //c0331a.replace(R.id.ll_fragment, fragment, str, 1);
           // c0331a.commit();
            if (z2) {
                switchView(i);
            }
        }
    }
}
