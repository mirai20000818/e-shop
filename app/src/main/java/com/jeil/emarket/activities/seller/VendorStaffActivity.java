package com.jeil.emarket.activities.seller;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.components.RecyclerTabLayout;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.Staff;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.dialog.DialogDelivery;
import com.jeil.emarket.dialog.DialogAddStuff;
import com.jeil.emarket.frag.analy.staff.FragmentStaffRole;
import com.jeil.emarket.frag.analy.staff.FragGetDelivererList;
import com.jeil.emarket.frag.analy.staff.FragGetStaffList;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.DelivererVM;


public class VendorStaffActivity extends BaseActivityForVendor {

    
    public ViewPager f11869K;

    /* renamed from: Q */
    public BaseDialog2 f11875Q;

    /* renamed from: L */
    public FragmentPagerAdaperEx f11870L = new FragmentPagerAdaperEx(getSupportFragmentManager(), 1);

    /* renamed from: M */
    public BaseDialog2 f11871M = null;

    /* renamed from: N */
    public BaseDialog2 f11872N = null;

    /* renamed from: O */
    public DialogAddStuff f11873O = null;

    /* renamed from: P */
    public DialogDelivery f11874P = null;

    /* renamed from: R */
    public MutableLiveData<java.lang.String> f11876R = new MutableLiveData<>();

    /* renamed from: S */
    public int f11877S = 0;

    /* renamed from: T */
    public MutableLiveData<Boolean> f11878T = new MutableLiveData<>();

    /* renamed from: U */
    public java.lang.String f11879U = "";

    /* renamed from: V */
    public MutableLiveData<java.lang.String> f11880V = new MutableLiveData<>();

    /* renamed from: W */
    public java.lang.String f11881W = "";

    /* renamed from: X */
    public MutableLiveData<java.lang.String> f11882X = new MutableLiveData<>();

    /* renamed from: Y */
    public boolean f11883Y = false;

    /* renamed from: Z */
    public boolean f11884Z = false;

    /* renamed from: a0 */
    public MutableLiveData<java.lang.String> f11885a0 = new MutableLiveData<>("");

    /* renamed from: b0 */
    public List<Staff> f11886b0 = new ArrayList();

    /* renamed from: com.jeil.emarket.activities.seller.VendorStaffActivity$a */
    public class C3215a implements ViewPager.OnPageChangeListener {
        public C3215a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageSelected(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0656j

        public void onPageScrollStateChanged(final int i) {
            Handler handler;
            Runnable runnable;
            VendorStaffActivity vendorStaffActivity = VendorStaffActivity.this;
            vendorStaffActivity.f11877S = i;
            if (i == 0) {
                vendorStaffActivity.findViewById(R.id.llc_menu_toggle_section).setVisibility(View.VISIBLE);
                VendorStaffActivity.this.findViewById(R.id.llc_menu_toggle).setVisibility(View.VISIBLE);
                VendorStaffActivity.this.findViewById(R.id.llc_deliverer_menu_toggle).setVisibility(View.GONE);
                VendorStaffActivity.this.findViewById(R.id.mrl_add).setVisibility(View.VISIBLE);
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.i.w1
                    @Override // java.lang.Runnable
                    public final void run() {
                        VendorStaffActivity.C3215a.this.m6697c(i);
                    }
                };
            } else {
                if (i != 1) {
                    if (i == 2) {
                        vendorStaffActivity.findViewById(R.id.mrl_add).setVisibility(View.GONE);
                        VendorStaffActivity.this.findViewById(R.id.llc_menu_toggle_section).setVisibility(View.GONE);
                        return;
                    }
                    return;
                }
                vendorStaffActivity.findViewById(R.id.llc_menu_toggle_section).setVisibility(View.VISIBLE);
                VendorStaffActivity.this.findViewById(R.id.llc_menu_toggle).setVisibility(View.GONE);
                VendorStaffActivity.this.findViewById(R.id.llc_deliverer_menu_toggle).setVisibility(View.VISIBLE);
                VendorStaffActivity.this.findViewById(R.id.mrl_add).setVisibility(View.VISIBLE);
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.i.x1
                    @Override // java.lang.Runnable
                    public final void run() {
                        VendorStaffActivity.C3215a.this.m6698d(i);
                    }
                };
            }
            handler.postDelayed(runnable, Status.time);
        }

        
        public  void m6697c(int i) {
            ((FragGetStaffList) VendorStaffActivity.this.f11870L.f7130l.get(i)).m4888T0();
        }

        
        public  void m6698d(int i) {
            ((FragGetDelivererList) VendorStaffActivity.this.f11870L.f7130l.get(i)).m4888T0();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.llc_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6693t(view);
            }
        });
        findViewById(R.id.llc_deliverer_menu_toggle).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6694u(view);
            }
        });
        findViewById(R.id.mrl_add).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6695v(view);
            }
        });
    }

    /* renamed from: R */
    public void m6673R() {
        this.f11869K = (ViewPager) findViewById(R.id.vp_statuses);
        this.f11869K.setAdapter(this.f11870L);
        final RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout) findViewById(R.id.rtl_statuses);
        recyclerTabLayout.setUpWithViewPager(this.f11869K);
        this.f11869K.setOnPageChangeListener(new C3215a());
        InterfaceString interfaceString = new InterfaceString() { // from class: b.f.a.a.i.b2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2710d

            public final void mo4265a(java.lang.String str) {
                VendorStaffActivity.this.m6680a(recyclerTabLayout, str);
            }
        };
        if (UserVM.vendorUserMutableLiveData.getValue() != null && UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorManager")) {
            this.f11870L.addFragment((Fragment) new FragGetStaffList(this, interfaceString), getResources().getString(R.string.staff_list), true);
        }
        this.f11870L.addFragment((Fragment) new FragGetDelivererList(this, interfaceString), getResources().getString(R.string.deliverer_list), true);
        if (UserVM.vendorUserMutableLiveData.getValue() != null && UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorManager")) {
            this.f11870L.addFragment(new FragmentStaffRole(), getResources().getString(R.string.role_table));
        }
        this.f11870L.notifyDataSetChanged();
        CustomString.m3172a(this.f11870L, 1, this.f11869K);
        ((UserVM.vendorUserMutableLiveData.getValue() == null || !UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorManager")) ? (FragGetDelivererList) this.f11870L.get(0) : (FragGetStaffList) this.f11870L.get(0)).m4888T0();
    }

    /* renamed from: S */
    public void m6674S() {
        this.f11874P = new DialogDelivery(this);
        this.f11874P.show();
        this.f11874P.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.v1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VendorStaffActivity.this.m6682b(dialogInterface);
            }
        });
    }

    /* renamed from: T */
    public void m6675T() {
        this.f11873O = new DialogAddStuff(this);
        this.f11873O.show();
        this.f11873O.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.o2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VendorStaffActivity.this.m6687c(dialogInterface);
            }
        });
    }

    /* renamed from: U */
    public void m6676U() {
        final View inflate = getLayoutInflater().inflate(R.layout.dialog_deliverer_filter, (ViewGroup) null);
        this.f11875Q = new BaseDialog2(this, new java.lang.String[0], inflate, 8388613);
        this.f11883Y = false;
        inflate.findViewById(R.id.mrl_btn_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6684b(inflate, view);
            }
        });
        inflate.findViewById(R.id.mrl_btn_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6688c(inflate, view);
            }
        });
        this.f11875Q.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.y1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VendorStaffActivity.this.m6678a(inflate, dialogInterface);
            }
        });
        ((EditForm) inflate.findViewById(R.id.cef_user)).setText(this.f11885a0.getValue());
        BaseDialog2 baseDialog2 = this.f11875Q;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.76f;
        baseDialog2.show();
    }

    /* renamed from: V */
    public void m6677V() {
        final View inflate = getLayoutInflater().inflate(R.layout.dialog_staff_filter, (ViewGroup) null);
        this.f11875Q = new BaseDialog2(this, new java.lang.String[0], inflate, 8388613);
        this.f11883Y = false;
        ((TextView) inflate.findViewById(R.id.ctv_platform)).setText(Util.m335d(this, (this.f11880V.getValue() == null || this.f11880V.getValue().isEmpty()) ? "platform" : this.f11880V.getValue()));
        inflate.findViewById(R.id.mrl_platform).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6691e(inflate, view);
            }
        });
        ((TextView) inflate.findViewById(R.id.ctv_user_role)).setText(Util.m335d(this, (this.f11882X.getValue() == null || this.f11882X.getValue().isEmpty() || this.f11882X.getValue().equals("all")) ? "all_role" : this.f11882X.getValue()));
        inflate.findViewById(R.id.mrl_user_role).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6692f(inflate, view);
            }
        });
        inflate.findViewById(R.id.mrl_btn_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6696w(view);
            }
        });
        inflate.findViewById(R.id.mrl_btn_reset).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorStaffActivity.this.m6690d(inflate, view);
            }
        });
        this.f11875Q.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.m2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VendorStaffActivity.this.m6683b(inflate, dialogInterface);
            }
        });
        ((EditForm) inflate.findViewById(R.id.cef_user)).setText(this.f11876R.getValue());
        ((CheckBox) inflate.findViewById(R.id.cb_ban_user)).setChecked(this.f11878T.getValue() != null ? this.f11878T.getValue().booleanValue() : false);
        BaseDialog2 baseDialog2 = this.f11875Q;
        baseDialog2.f8255f = 1.0f;
        baseDialog2.f8254e = 0.76f;
        baseDialog2.show();
    }


    public  void m6678a(@SuppressLint({"InflateParams"}) View view, DialogInterface dialogInterface) {
        this.f6496A = false;
        if (this.f11883Y) {
            this.f11885a0.setValue( ((EditForm) view.findViewById(R.id.cef_user)).getText());
            try {
                ((FragGetDelivererList) this.f11870L.get(1)).m5226b(this.f11885a0.getValue());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public  void m6679a(View view, List list, View view2, int i) {
        ((TextView) view.findViewById(R.id.ctv_platform)).setText(Util.m335d(this, (java.lang.String) list.get(i)));
        this.f11879U = (java.lang.String) list.get(i);
        this.f11871M.startAni();
    }


    public  void m6680a(RecyclerTabLayout recyclerTabLayout, java.lang.String str) {
        for (java.lang.String str2 : new java.lang.String[]{getResources().getString(R.string.staff_list), getResources().getString(R.string.deliverer_list)}) {
            if (Objects.equals(this.f11870L.mo2187a(this.f11877S), str2)) {
                FragmentPagerAdaperEx fragmentPagerAdaperEx = this.f11870L;
                fragmentPagerAdaperEx.m4419a(fragmentPagerAdaperEx.m4417a(str2), str2, Integer.parseInt(str));
                recyclerTabLayout.m6847b(this.f11869K.getCurrentItem(), true);
            }
        }
    }


    public  void m6681a(Integer num) {
        if (num.intValue() == 200) {
            ((FragGetStaffList) this.f11870L.get(0)).m4893Y0();
        }
    }


    public  void m6682b(DialogInterface dialogInterface) {
        this.f6496A = false;
        DelivererVM.f10412e.observe(this, new Observer() { // from class: b.f.a.a.i.n2
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorStaffActivity.this.m6686b((Integer) obj);
            }
        });
    }


    public  void m6683b(@SuppressLint({"InflateParams"}) View view, DialogInterface dialogInterface) {
        int i = 0;
        this.f6496A = false;
        if (this.f11883Y) {
            this.f11876R.setValue( ((EditForm) view.findViewById(R.id.cef_user)).getText());
            this.f11878T.setValue( Boolean.valueOf(((CheckBox) view.findViewById(R.id.cb_ban_user)).isChecked()));
            this.f11880V.setValue( this.f11879U);
            this.f11882X.setValue( this.f11881W);
            try {
                FragGetStaffList c2689z3 = (FragGetStaffList) this.f11870L.get(0);
                java.lang.String getValue = this.f11876R.getValue();
                java.lang.String str = "";
                java.lang.String getValue2 = this.f11882X.getValue().equals("all") ? "" : this.f11882X.getValue();
                if (!this.f11880V.getValue().equals("platform")) {
                    str = this.f11880V.getValue();
                }
                if (this.f11878T.getValue() != null && this.f11878T.getValue().booleanValue()) {
                    i = 2;
                }
                c2689z3.m5373a(getValue, getValue2, str, i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public  void m6684b(@SuppressLint({"InflateParams"}) View view, View view2) {
        if (!Objects.equals(this.f11885a0.getValue(), ((EditForm) view.findViewById(R.id.cef_user)).getText())) {
            this.f11883Y = true;
        }
        this.f11875Q.startAni();
    }


    public  void m6686b(Integer num) {
        if (num.intValue() == 200) {
            ((FragGetDelivererList) this.f11870L.get(1)).m4893Y0();
        }
    }

    
    public  void m6687c(DialogInterface dialogInterface) {
        this.f6496A = false;
        DelivererVM.f10411d.observe(this, new Observer() { // from class: b.f.a.a.i.a2
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorStaffActivity.this.m6681a((Integer) obj);
            }
        });
    }

    
    public  void m6688c(@SuppressLint({"InflateParams"}) View view, View view2) {
        ((EditForm) view.findViewById(R.id.cef_user)).setText("");
        if (!Objects.equals(this.f11885a0.getValue(), "")) {
            this.f11883Y = true;
        }
        this.f11875Q.startAni();
    }

    
    public  void m6689d(DialogInterface dialogInterface) {
        this.f11884Z = false;
    }

    
    public  void m6690d(@SuppressLint({"InflateParams"}) View view, View view2) {
        ((EditForm) view.findViewById(R.id.cef_user)).setText("");
        ((CheckBox) view.findViewById(R.id.cb_ban_user)).setChecked(false);
        this.f11879U = "platform";
        this.f11881W = "all";
        this.f11878T.setValue( false);
        ((TextView) view.findViewById(R.id.ctv_platform)).setText("");
        this.f11883Y = true;
        this.f11875Q.startAni();
    }

    
    public  void m6691e(@SuppressLint({"InflateParams"}) View view, View view2) {
        showSelectPlatformDialog(view);
    }

    /* renamed from: f */
    public  void m6692f(@SuppressLint({"InflateParams"}) View view, View view2) {
        if (this.f11884Z) {
            return;
        }
        this.f11884Z = true;
        showSelectRoleDialog(view);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_staff);
        m4307e((UserVM.vendorUserMutableLiveData.getValue() == null || !UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorManager")) ? R.string.deliverer_manage : R.string.staff_manage);
        m6673R();
        mo4284G();
        addBottomNav(0);
        if (UserVM.vendorUserMutableLiveData.getValue() == null || !UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorManager")) {
            findViewById(R.id.ll_header_tabs).setVisibility(View.GONE);
            findViewById(R.id.header_border).setVisibility(View.GONE);
            findViewById(R.id.llc_menu_toggle).setVisibility(View.GONE);
            findViewById(R.id.llc_deliverer_menu_toggle).setVisibility(View.VISIBLE);
            return;
        }
        findViewById(R.id.ll_header_tabs).setVisibility(View.VISIBLE);
        findViewById(R.id.header_border).setVisibility(View.VISIBLE);
        findViewById(R.id.llc_menu_toggle).setVisibility(View.VISIBLE);
        findViewById(R.id.llc_deliverer_menu_toggle).setVisibility(View.GONE);
    }

    public void showSelectPlatformDialog(final View view) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add("platform");
        arrayList.add("desktop");
        arrayList.add("mobile");
        arrayList.add("apk");
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(new Cancel_Obj(Util.m335d(this, (java.lang.String) arrayList.get(i)), ((TextView) view.findViewById(R.id.ctv_platform)).getText().equals(Util.m335d(this, (java.lang.String) arrayList.get(i))) ? 1 : 0));
        }
        this.f11871M = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList2, 80);
        BaseDialog2 baseDialog2 = this.f11871M;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.i.e2
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                VendorStaffActivity.this.m6679a(view, arrayList, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f11871M;
        baseDialog22.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog22.show();
    }

    public void showSelectRoleDialog(final View view) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add("all");
        arrayList.add("vendorManager");
        arrayList.add("vendorFinanceManager");
        arrayList.add("vendorAdManager");
        arrayList.add("vendorProductManager");
        arrayList.add("vendorAgent");
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(new Cancel_Obj(((java.lang.String) arrayList.get(i)).equals("all") ? getResources().getString(R.string.all_role) : Util.m335d(this, (java.lang.String) arrayList.get(i)), ((TextView) view.findViewById(R.id.ctv_user_role)).getText().equals(((java.lang.String) arrayList.get(i)).equals("all") ? getResources().getString(R.string.all_role) : Util.m335d(this, (java.lang.String) arrayList.get(i))) ? 1 : 0));
        }
        this.f11872N = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList2, 80);
        BaseDialog2 baseDialog2 = this.f11872N;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.i.c2
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                VendorStaffActivity.this.m6685b(view, arrayList, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f11872N;
        baseDialog22.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog22.show();
        this.f11872N.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.h2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VendorStaffActivity.this.m6689d(dialogInterface);
            }
        });
    }

    /* renamed from: t */
    public  void m6693t(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        m6677V();
    }

    /* renamed from: u */
    public  void m6694u(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        m6676U();
    }

    /* renamed from: v */
    public  void m6695v(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        if (UserVM.vendorUserMutableLiveData.getValue() != null && UserVM.vendorUserMutableLiveData.getValue().user.role.equals("vendorManager") && this.f11877S == 0) {
            m6675T();
        } else {
            m6674S();
        }
    }

    /* renamed from: w */
    public  void m6696w(View view) {
        this.f11883Y = true;
        this.f11875Q.startAni();
    }


    public  void m6685b(View view, List list, View view2, int i) {
        ((TextView) view.findViewById(R.id.ctv_user_role)).setText(((java.lang.String) list.get(i)).equals("all") ? getResources().getString(R.string.all_role) : Util.m335d(this, (java.lang.String) list.get(i)));
        this.f11881W = (java.lang.String) list.get(i);
        this.f11872N.startAni();
    }
}
