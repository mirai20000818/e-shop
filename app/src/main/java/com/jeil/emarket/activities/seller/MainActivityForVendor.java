package com.jeil.emarket.activities.seller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.FragmentManager;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.frag.ticket.base.FragmentTicketListVendor;
import com.jeil.emarket.viewmodel.UserVM;


public class MainActivityForVendor extends BaseActivityForVendor {

    /* renamed from: M */
    public static int global_id = R.id.navigation_home;

    
    public int id = R.id.navigation_home;

    /* renamed from: L */
    public long f11807L = 0;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1
    
    public void mo4334a(int i, boolean z, boolean z2) {
        this.id = i;
        super.mo4334a(i, z, z2);
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        FragmentTicketListVendor fragmentTicketListVendor = null;
        Fragment m1717c;
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            FragmentManager getSupportFragmentManager = getSupportFragmentManager();
            int i3 = global_id;
//            if (i3 == R.id.ani_market_link) {
//                Fragment m1717c2 = getSupportFragmentManager.f2173c.m1717c("2131230834");
//                if (m1717c2 == null) {
//                    return;
//                } else {
//                    fragmentTicketListVendor = (FragmentTicketListVendorEx) m1717c2;
//                }
//            } else {
//                if (i3 == R.id.navigation_review) {
//                    Fragment m1717c3 = getSupportFragmentManager.f2173c.m1717c("2131231903");
//                    if (m1717c3 != null) {
//                        ((FragmentVendorListPage) m1717c3).m5343U0();
//                        return;
//                    }
//                    return;
//                }
//                if (i3 != R.id.navigation_tickets || (m1717c = getSupportFragmentManager.f2173c.m1717c("2131231905")) == null) {
//                    return;
//                } else {
//                    fragmentTicketListVendor = (FragmentCustomerTicketBox) m1717c;
//                }
//            }
            fragmentTicketListVendor.m5138T0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        if (r6.f6521J != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        mo4308f(r2);
        mo4353j(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        if (r6.f6521J != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r6.f6521J != null) goto L25;
     */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBackPressed() {
        /*
            r6 = this;
            boolean r0 = r6.m4309v()
            if (r0 == 0) goto L7
            return
        L7:
            a.o.o<com.jeil.emarket.model.vendor.VendorUser> r0 = p078b.p159f.p160a.p256k.C2831r2.f10332i
            java.lang.Object r0 = r0.getValue()
            r1 = 0
            if (r0 == 0) goto L6a
            a.o.o<com.jeil.emarket.model.vendor.VendorUser> r0 = p078b.p159f.p160a.p256k.C2831r2.f10332i
            java.lang.Object r0 = r0.getValue()
            com.jeil.emarket.model.vendor.VendorUser r0 = (com.jeil.emarket.model.vendor.VendorUser) r0
            com.jeil.emarket.model.vendor.VendorUser$User r0 = r0.user
            java.lang.String r0 = r0.role
            r2 = -1
            int r3 = r0.hashCode()
            r4 = -1578773722(0xffffffffa1e5d326, float:-1.5573534E-18)
            r5 = 1
            if (r3 == r4) goto L37
            r4 = 31570589(0x1e1ba9d, float:8.2919723E-38)
            if (r3 == r4) goto L2d
            goto L40
        L2d:
            java.lang.String r3 = "vendorAgent"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L40
            r2 = 0
            goto L40
        L37:
            java.lang.String r3 = "vendorProductManager"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L40
            r2 = 1
        L40:
            int r0 = r6.f11806K
            if (r2 == 0) goto L60
            if (r2 == r5) goto L56
            r2 = 2131231897(0x7f080499, float:1.8079888E38)
            if (r0 == r2) goto L6a
            com.jeil.emarket.components.bottomnavigation.BottomNavigationView r0 = r6.f6521J
            if (r0 == 0) goto L6a
        L4f:
            r6.mo4308f(r2)
            r6.mo4353j(r2)
            return
        L56:
            r2 = 2131231902(0x7f08049e, float:1.8079898E38)
            if (r0 == r2) goto L6a
            com.jeil.emarket.components.bottomnavigation.BottomNavigationView r0 = r6.f6521J
            if (r0 == 0) goto L6a
            goto L4f
        L60:
            r2 = 2131231901(0x7f08049d, float:1.8079896E38)
            if (r0 == r2) goto L6a
            com.jeil.emarket.components.bottomnavigation.BottomNavigationView r0 = r6.f6521J
            if (r0 == 0) goto L6a
            goto L4f
        L6a:
            long r2 = r6.f11807L
            r4 = 2000(0x7d0, double:9.88E-321)
            long r2 = r2 + r4
            long r4 = java.lang.System.currentTimeMillis()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L7d
            androidx.activity.OnBackPressedDispatcher r0 = r6.f3058h
            r0.m2196a()
            goto L8f
        L7d:
            r0 = 2131689903(0x7f0f01af, float:1.9008835E38)
            java.lang.String r0 = r6.getString(r0)
            java.lang.String r2 = "general"
            p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.m238a(r6, r0, r2, r1, r1)
            long r0 = java.lang.System.currentTimeMillis()
            r6.f11807L = r0
        L8f:
            return
        */
        super.onBackPressed();
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.activities.seller.MainActivity.onBackPressed():void");
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_main);
        addBottomNav(global_id);
        BottomNavigationView bottomNavigationView = this.f6521J;
        if (bottomNavigationView != null && bottomNavigationView.btObjs.size() > 0) {
            this.f6521J.setIndex(0);
        }
        if (UserVM.vendorUserMutableLiveData.getValue() == null || !UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorShippingManager")) {
            return;
        }
        findViewById(R.id.bottom_navigation).setVisibility(View.GONE);
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        BottomNavigationView bottomNavigationView = this.f6521J;
        if (bottomNavigationView != null) {
            bottomNavigationView.setActiveItemOnlyColor(global_id);
            mo4353j(global_id);
        }
    }

    public void setClickEvent(View view) {
        View findViewById = view.findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.GONE);
                materialRippleLayout2.setVisibility(View.VISIBLE);
            }
            if (materialRippleLayout2 != null) {
                materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        MainActivityForVendor.this.m6584t(view2);
                    }
                });
            }
        }
    }

    /* renamed from: t */
    public  void m6584t(View view) {
        close();
    }
}
