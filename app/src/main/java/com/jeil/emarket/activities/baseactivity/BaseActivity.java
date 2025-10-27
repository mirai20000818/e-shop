package com.jeil.emarket.activities.baseactivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.anievaluate.evaluate.AbstractC2942a;
import com.anievaluate.evaluate.C2948g;
import com.balysv.materialripple.MaterialRippleLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.navigation.NavigationView;
import com.jeil.emarket.R;
import com.jeil.emarket.activities.auth.LoginActivity;
import com.jeil.emarket.activities.auth.VendorLoginActivity;
import com.jeil.emarket.activities.intro.HelpActivity;
import com.jeil.emarket.activities.intro.HelpDetailActivity;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.activities.intro.SplashBaseActivity;
import com.jeil.emarket.activities.order.CartActivity;
import com.jeil.emarket.activities.point.PointActivity;
import com.jeil.emarket.activities.product.SearchActivity;
import com.jeil.emarket.activities.review.ReviewActivity;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.activities.ticket.list.TicketUserListActivity;
import com.jeil.emarket.adapters.newsletter.NewsletterAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.ResManager;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.frag.main.vendor.FragmentNavigationAccount;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.model.customer.Newsletter;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.model.vendor.VendorUser;
import com.jeil.emarket.services.MessageService;
import com.jeil.emarket.viewmodel.BottomVM;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.viewmodel.DayProductVM;
import com.jeil.emarket.viewmodel.ProductVendorVM;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.widget.RecyclerViewEx;
import com.jeil.emarket.widget.base.BottomNavListener;
import com.jeil.emarket.widget.base.Nav_view;
import com.jeil.emarket.widget.base.NavigationMessageInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* renamed from: b.f.a.a.c.g1 */

public class BaseActivity extends AppCompatActivity {


    public static int anInt;

    
    public static int anInt1;

    
    public static int anInt2;

    /* renamed from: F */
    public static int color;

    /* renamed from: G */
    public static java.lang.String string;

    /* renamed from: H */
    public static java.lang.String string1;


    public RecyclerView recyclerView;

    /* renamed from: r */
    public DrawerLayout drawerLayout;

    /* renamed from: s */
    public BottomNavigationView bottomNavigationView;

    /* renamed from: x */
    public java.lang.String string2;

    /* renamed from: z */
    public NewsletterAdapter f6506z;

    /* renamed from: t */
    public boolean f6500t = true;

    /* renamed from: u */
    public boolean f6501u = true;

    /* renamed from: v */
    public boolean f6502v = true;

    /* renamed from: w */
    public HashMap<Integer, java.lang.String> questionHashMap = new HashMap<>();

    /* renamed from: y */
    public ImageDialog2 f6505y = null;


    public boolean f6496A = false;

    /* renamed from: b.f.a.a.c.g1$a */
    public class MainScrollListener extends RecyclerView.OnScrollListener {


        public final  View view;


        public final  BaseActivity baseActivity;

        
        public final  View view1;

        
        public final  MaterialRippleLayout materialRippleLayout;

        public MainScrollListener(View view, BaseActivity baseActivity, View view2, MaterialRippleLayout materialRippleLayout) {
            this.view = view;
            this.baseActivity = baseActivity;
            this.view1 = view2;
            this.materialRippleLayout = materialRippleLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            View view = this.view;
            View findViewById = view == null ? this.baseActivity.findViewById(R.id.header_border) : view.findViewById(R.id.header_border);
            View view2 = this.view;
            View mo4310w = view2 == null ? this.baseActivity.mo4310w() : view2.findViewById(R.id.header_tab_border);
            View view3 = this.view;
            BaseActivity.this.initView((XRecyclerView) this.view1, this.materialRippleLayout, mo4310w, findViewById, (view3 == null || view3.findViewById(R.id.bottom_border) == null) ? this.baseActivity.findViewById(R.id.bottom_border) : this.view.findViewById(R.id.bottom_border), false);
        }
    }

    /* renamed from: b.f.a.a.c.g1$b */
    public class b implements AbstractC2942a.a {


        public final  MaterialRippleLayout f6512a;

        public b(BaseActivity activityC1391g1, MaterialRippleLayout materialRippleLayout) {
            this.f6512a = materialRippleLayout;
        }

        @Override // p078b.p268g.p269a.AbstractC2942a.a

        public void mo4314a(AbstractC2942a abstractC2942a) {
            this.f6512a.setVisibility(View.GONE);
        }

        @Override // p078b.p268g.p269a.AbstractC2942a.a

        public void mo4315b(AbstractC2942a abstractC2942a) {
        }

        @Override // p078b.p268g.p269a.AbstractC2942a.a

        public void mo4316c(AbstractC2942a abstractC2942a) {
        }
    }

    /* renamed from: b.f.a.a.c.g1$c */
    public class c implements AbstractC2942a.a {


        public final  MaterialRippleLayout f6513a;

        public c(BaseActivity activityC1391g1, MaterialRippleLayout materialRippleLayout) {
            this.f6513a = materialRippleLayout;
        }

        @Override // p078b.p268g.p269a.AbstractC2942a.a

        public void mo4314a(AbstractC2942a abstractC2942a) {
            this.f6513a.setVisibility(View.GONE);
        }

        @Override // p078b.p268g.p269a.AbstractC2942a.a

        public void mo4315b(AbstractC2942a abstractC2942a) {
        }

        @Override // p078b.p268g.p269a.AbstractC2942a.a

        public void mo4316c(AbstractC2942a abstractC2942a) {
        }
    }

    /* renamed from: b.f.a.a.c.g1$d */
    public class VLin extends LinearLayoutManager {
        public VLin(BaseActivity activityC1391g1, Context context) {
            super(context, RecyclerView.VERTICAL, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager

        public boolean canScrollVertically() {
            return true;
        }
    }

    /* renamed from: b.f.a.a.c.g1$e */
    public class BottomRV_Listener extends RecyclerView.OnScrollListener {


        public final  View ll_bottom_gradient;

        public BottomRV_Listener(BaseActivity activityC1391g1, View view) {
            this.ll_bottom_gradient = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView.canScrollVertically(1)) {
                this.ll_bottom_gradient.findViewById(R.id.ll_bottom_gradient).setVisibility(View.VISIBLE);
            } else {
                this.ll_bottom_gradient.findViewById(R.id.ll_bottom_gradient).setVisibility(View.GONE);
            }
            if (recyclerView.canScrollVertically(-1)) {
                this.ll_bottom_gradient.findViewById(R.id.ll_top_gradient).setVisibility(View.VISIBLE);
            } else {
                this.ll_bottom_gradient.findViewById(R.id.ll_top_gradient).setVisibility(View.GONE);
            }
        }
    }


    @SuppressLint("RestrictedApi")
    public static  void m4275a(View view, View view2) {
        if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).smoothScrollBy(0, 0, 300);
        } else if (view instanceof XRecyclerView) {
            ((XRecyclerView) view).smoothScrollBy(0, 0, (Interpolator) AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR, 300);
        }
    }


    public static  void m4277a(CompoundButton compoundButton, boolean z) {
        SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
        edit.putBoolean("save_newsletter_show", z);
        edit.putString("save_setting_newsletter_show_date", z ? Util.date2Str(new Date()) : "");
        edit.apply();
    }


    public void m4278A() {
    }


    public void UserObserve() {
        UserVM.userMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.c.l
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                BaseActivity.this.m4305c((User) obj);
            }
        });
    }


    public void VendorUserObserve() {
        UserVM.vendorUserMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.c.o
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                BaseActivity.this.m4296a((VendorUser) obj);
            }
        });
    }

    
    public void SetDescription() {
        Window window = getWindow();
        window.setNavigationBarColor(getResources().getColor(R.color.dark));
        window.setStatusBarColor(getResources().getColor(R.color.dark));
        setTaskDescription(new ActivityManager.TaskDescription(getResources().getString(R.string.app_name), (Bitmap) null));
    }

    
    public void m4282E() {
        BottomVM.f10424i = false;
        BottomVM.f10425j = false;
        BottomVM.f10426k = false;
        BottomVM.m5607b((Context) this, true);
        BottomVM.m5611c((Context) this, true);
        BottomVM.m5614d((Context) this, true);
        CategoryVM.m5582a((Context) this, true);
        CartProductVM.m5573c();
        ProductVendorVM.m5579c();
        DayProductVM.m5489c();
        DayProductVM.m5490d();
        BottomVM.m5603a((Context) this, true);
        UserVM.connect(this);
    }

    /* renamed from: F */
    public void close() {
        DrawerLayout drawerLayout = this.drawerLayout;
        if (drawerLayout != null) {
            drawerLayout.close();
        }
    }

    /* renamed from: G */
    public void mo4284G() {
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById(R.id.mrl_header_back);
        if (materialRippleLayout != null) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.this.m4301b(view);
                }
            });
        }
        MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById(R.id.mrl_header_search_input);
        MaterialRippleLayout materialRippleLayout3 = (MaterialRippleLayout) findViewById(R.id.mrl_header_search);
        if (materialRippleLayout2 != null || materialRippleLayout3 != null) {
            final Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            if (materialRippleLayout2 != null) {
                materialRippleLayout2.setDefaultRippleAlpha(5);
                materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseActivity.this.m4289a(intent, view);
                    }
                });
            }
            if (materialRippleLayout3 != null) {
                materialRippleLayout3.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseActivity.this.m4300b(intent, view);
                    }
                });
            }
        }
        MaterialRippleLayout materialRippleLayout4 = (MaterialRippleLayout) findViewById(R.id.mrl_header_cart);
        if (materialRippleLayout4 != null) {
            materialRippleLayout4.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.this.m4304c(view);
                }
            });
        }
        View mo4310w = mo4310w();
        if (mo4310w != null) {
            mo4310w.setVisibility(View.GONE);
        }
        m4278A();
    }

    /* renamed from: H */
    public void m4285H() {
    }


    public MaterialRippleLayout m4286a(final View view, final BaseActivity activityC1391g1, final View view2, final boolean z) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null) {
            return null;
        }
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) viewGroup.findViewById(R.id.mrl_scroll_top);
        if (materialRippleLayout != null && !(viewGroup instanceof ViewPager)) {
            return materialRippleLayout;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) View.inflate(this, R.layout.item_scroll_to_top, null);
        View mo4310w = view2 == null ? activityC1391g1.mo4310w() : view2.findViewById(R.id.header_tab_border);
        if (this.f6501u) {
            if ((view instanceof NestedScrollView) && !z) {
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                FrameLayout frameLayout = new FrameLayout(this);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Util.dp2px((Context) this, 50), Util.dp2px((Context) this, 50));
                layoutParams2.gravity = 8388693;
                layoutParams2.setMargins(0, 0, Util.dp2px((Context) this, 13), Util.dp2px((Context) this, 17));
                materialRippleLayout2.setLayoutParams(layoutParams2);
                frameLayout.addView(view);
                frameLayout.addView(materialRippleLayout2);
                viewGroup.addView(frameLayout, indexOfChild, layoutParams);
            } else if (view instanceof XRecyclerView) {
                CoordinatorLayout.LayoutParams layoutParams1 = new CoordinatorLayout.LayoutParams(Util.dp2px((Context) this, 50), Util.dp2px((Context) this, 50));
                layoutParams1.gravity = 8388693;
                layoutParams1.setMargins(0, 0, Util.dp2px((Context) this, 12), Util.dp2px((Context) this, 17));
                boolean z2 = viewGroup instanceof CoordinatorLayout;
                ViewGroup viewGroup2 = viewGroup;
                if (!z2) {
                    if (viewGroup instanceof LinearLayoutCompat) {
                        viewGroup2 = (ViewGroup) viewGroup.getParent();
                    }
                }
                viewGroup2.addView(materialRippleLayout2, layoutParams1);
            }
        }
        materialRippleLayout2.setVisibility(View.GONE);
        if (mo4310w != null) {
            mo4310w.setVisibility(View.GONE);
        }
        if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

              //  public void onScrollChange(@NonNull NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                @Override // androidx.core.widget.NestedScrollView.InterfaceC0581b

                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    BaseActivity.this.m4291a(view2, activityC1391g1, z, view, materialRippleLayout2, nestedScrollView, i, i2, i3, i4);
                }
            });
        } else if (view instanceof XRecyclerView) {
            ((XRecyclerView) view).setOnScrollListener(new MainScrollListener(view2, activityC1391g1, view, materialRippleLayout2));
        }
        materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.c.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BaseActivity.m4275a(view, view3);
            }
        });
        return materialRippleLayout2;
    }


    public  void m4287a(Context context) {
        UserVM.m5531a(this, true);
    }


    public  void m4288a(DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public  void m4289a(Intent intent, View view) {
        startActivity(intent);
    }


    public  void m4290a(final View view) {
        TicketCategoryListVM.f10284j.observe(this, new Observer() { // from class: b.f.a.a.c.i
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                //??view.setVisibility(r1.intValue() > 0 ? View.VISIBLE : View.GONE);
            }
        });
    }


    public  void m4291a(View view, BaseActivity activityC1391g1, boolean z, View view2, MaterialRippleLayout materialRippleLayout, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        NestedScrollView nestedScrollView2;
        WaveSwipeRefreshLayout waveSwipeRefreshLayout;
        View findViewById = view == null ? activityC1391g1.findViewById(R.id.header_border) : view.findViewById(R.id.header_border);
        View mo4310w = view == null ? activityC1391g1.mo4310w() : view.findViewById(R.id.header_tab_border);
        View findViewById2 = (view == null || view.findViewById(R.id.bottom_border) == null) ? activityC1391g1.findViewById(R.id.bottom_border) : view.findViewById(R.id.bottom_border);
        if (this.f6501u && z) {
            nestedScrollView2 = (NestedScrollView) view2;
            mo4310w = null;
            findViewById = null;
        } else {
            nestedScrollView2 = (NestedScrollView) view2;
        }
        m4293a(nestedScrollView2, materialRippleLayout, mo4310w, findViewById, findViewById2, false);
        if (view2.getTag() != null && view2.getTag().equals(Integer.valueOf(R.id.nsv_main))) {
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById(R.id.mrl_header_filter);
            RecyclerViewEx recyclerViewEx = (RecyclerViewEx) view2.findViewById(R.id.rtl_sub_categories);
            if (materialRippleLayout2 != null && recyclerViewEx != null) {
                //??materialRippleLayout2.setTranslationY(i2 < c2090q.getMeasuredHeight() ? r1 - i2 : 0.0f);
            }
        }
        if (view2.getTag() == null || !view2.getTag().equals(Integer.valueOf(R.id.wsr_layout)) || (waveSwipeRefreshLayout = (WaveSwipeRefreshLayout) findViewById(R.id.wsr_layout)) == null) {
            return;
        }
        waveSwipeRefreshLayout.setEnabled(!nestedScrollView.canScrollVertically(-1));
    }


    public void mo4295a(User user) {
        if (!Status.f8832w.booleanValue() || user == null || MessageService.f12471g) {
            return;
        }
        MessageService.f12473i = getApplicationContext();
        startService(new Intent(this, MessageService.class));
    }


    public  void m4296a(VendorUser vendorUser) {
        if (vendorUser == null && (this instanceof BaseActivityForVendor)) {
            if (this instanceof MainActivityForVendor) {
                ((MainActivityForVendor) this).mo4353j(R.id.navigation_home);
                return;
            }
            Util.toast(this, getString(R.string.please_vendor_login), "default", 0, 0);
            Intent intent = new Intent(getApplicationContext(), VendorLoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }


    public void m4297a(java.lang.String str) {
        ((TextViewBold) findViewById(R.id.tv_header_title)).f12324g = true;
        ((TextViewBold) findViewById(R.id.tv_header_title)).setText(str);
    }

    public void addRefreshIcon(View view) {
        View findViewById = view == null ? findViewById(R.id.ll_header) : view.findViewById(R.id.ll_header);
        MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this);
        materialRippleLayout.setId(R.id.mrl_refresh);
        materialRippleLayout.setRippleRoundedCorners(20);
        materialRippleLayout.setDefaultRippleAlpha(20);
        materialRippleLayout.setRippleColor(getResources().getColor(R.color.ripple_dark));
        materialRippleLayout.setRippleHover(true);
        materialRippleLayout.setRippleOverlay(true);
        materialRippleLayout.setPadding(Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 7));
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        appCompatImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_recycle));
        appCompatImageView.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark)));
        appCompatImageView.setPadding(Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4));
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(Util.dp2px((Context) this, 27), Util.dp2px((Context) this, 27)));
        materialRippleLayout.addView(appCompatImageView);
        if (findViewById instanceof LinearLayoutCompat) {
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ((LinearLayout.LayoutParams) c0541a).rightMargin = Util.dp2px((Context) this, 4);
            ((LinearLayoutCompat) findViewById).addView(materialRippleLayout, c0541a);
        } else if (findViewById instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.rightMargin = Util.dp2px((Context) this, 4);
            layoutParams.addRule(21);
            layoutParams.addRule(15);
            ((RelativeLayout) findViewById).addView(materialRippleLayout, layoutParams);
        }
    }


    public int m4299b(int i) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics()));
    }


    public  void m4300b(Intent intent, View view) {
        startActivity(intent);
    }


    public  void m4301b(View view) {
        if (isFinishing()) {
            return;
        }
        m4309v();
        onBackPressed();
    }


    public void mo4302b(User user) {
        if (user != null) {
            TicketCategoryListVM.m5496a(this);
        }
    }


    public void addBottomNav(int i) {
        this.bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        if (bottomNavigationView != null) {
            bottomNavigationView.m6885a(true);
            Nav_view btview = new Nav_view(R.id.navigation_home, getString(R.string.home), R.drawable.ic_home);
            Nav_view btview2 = new Nav_view(R.id.navigation_categories, getString(R.string.home_categories), R.drawable.ic_categories);
            Nav_view btview3 = new Nav_view(R.id.navigation_deals, getString(R.string.today_service), R.drawable.ic_deals, R.drawable.ic_deals_per);
            btview3.img = R.drawable.ic_deals;
            Nav_view btview4 = new Nav_view(R.id.navigation_message, getString(R.string.ticket_box), R.drawable.ic_message_footer);
            btview4.f8800b = false;
            btview4.f8801c = new NavigationMessageInterface() { // from class: b.f.a.a.c.k
                @Override // p078b.p159f.p160a.p190c.p227z.InterfaceC2154c

                public final void mo4364a(View view) {
                    BaseActivity.this.m4290a(view);
                }
            };
            Nav_view btview5 = new Nav_view(R.id.navigation_account, getString(R.string.my_page), R.drawable.ic_account_sm);
            btview5.f8800b = false;
            if (!(this instanceof MainActivity)) {
                btview4.f8800b = false;
            }
            this.bottomNavigationView.m6884a(btview);
            this.bottomNavigationView.m6884a(btview2);
            this.bottomNavigationView.m6884a(btview3);
            this.bottomNavigationView.m6884a(btview4);
            this.bottomNavigationView.m6884a(btview5);
            switchView(i);
            this.bottomNavigationView.setOnBottomNavigationItemClickListener(new BottomNavListener() { // from class: b.f.a.a.c.g
                @Override // p078b.p159f.p160a.p190c.p227z.InterfaceC2155d

                public final void mo4274a(int i2) {
                    BaseActivity.this.m4306d(i2);
                }
            });
        }
    }


    public  void m4304c(View view) {
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public  void m4305c(User user) {
        java.lang.String string;
        if (user == null) {
            if (!(this instanceof BaseActivity) && !(this instanceof MainActivity)) {
                return;
            }
            if (this instanceof ReviewActivity) {
                java.lang.String string2 = ((ReviewActivity) this).bundle.getString("page");
                if (string2 != null && !string2.equals("account")) {
                    return;
                }
            } else if ((this instanceof PointActivity) && (string = ((PointActivity) this).f11759K.getString("page")) != null && !string.equals("account")) {
                return;
            }
            if (this instanceof MainActivity) {
                MainActivity mainActivity = (MainActivity) this;
                mainActivity.bottomNavigationView.setIndex(0);
                mainActivity.m6457g(R.id.navigation_home);
            } else {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
        mo4295a(user);
        mo4302b(user);
    }

    
    public  void m4306d(int i) {
        Intent intent;
        if (this instanceof MainActivity) {
            if (i == 0) {
                ((MainActivity) this).m6457g(R.id.navigation_home);
                return;
            }
            if (i == 1) {
                ((MainActivity) this).m6457g(R.id.navigation_categories);
                return;
            }
            if (i == 2) {
                ((MainActivity) this).m6457g(R.id.navigation_deals);
                return;
            }
            if (i == 3) {
                intent = new Intent(getApplicationContext(), TicketUserListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return;
            } else {
                if (i != 4) {
                    ((MainActivity) this).bottomNavigationView.setActiveItemOnlyColor(0);
                    return;
                }
                close();
            }
        }
        if (i != 4) {
            if (i == 3) {
                intent = new Intent(getApplicationContext(), TicketUserListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
            intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            MainActivity.global_id = R.id.navigation_home;
            if (i == 1) {
                MainActivity.global_id = R.id.navigation_categories;
            } else if (i == 2) {
                MainActivity.global_id = R.id.navigation_deals;
            } else if (i == 4) {
                MainActivity.global_id = R.id.navigation_account;
            }
            startActivity(intent2);
            return;
        }
        close();
    }

    
    public void m4307e(int i) {
        ((TextViewBold) findViewById(R.id.tv_header_title)).f12324g = true;
        ((TextViewBold) findViewById(R.id.tv_header_title)).setText(getResources().getString(i));
    }

    /* renamed from: f */
    public void switchView(int i) {
        int id = 0;
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        if (bottomNavigationView != null) {
            if(i == R.id.navigation_account){
                id = 4;
            }
            else if(i == R.id.navigation_categories){
                id = 1;
            }
            else if(i == R.id.navigation_deals){
                id = 2;
            }
            else if(i == R.id.navigation_home){
                id = 0;
            }
            else if(i == R.id.navigation_message){
                id = 3;
            } 
            bottomNavigationView.setIndex(id);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                if (!(this instanceof HelpActivity) && !(this instanceof HelpDetailActivity)) {
                    ApplicationInfo applicationInfo = super.getApplicationInfo();
                    applicationInfo.publicSourceDir = applicationInfo.sourceDir;
                    return applicationInfo;
                }
                if (this.string2 == null || this.string2.isEmpty() || this.string2.equals("null")) {
                    this.string2 = Util.m344e(this);
                }
                ApplicationInfo applicationInfo2 = super.getApplicationInfo();
                if (this.string2 != null) {
                    applicationInfo2.publicSourceDir = this.string2;
                }
                return applicationInfo2;
            }
        } catch (Exception unused) {
        }
        return super.getApplicationInfo();
    }

    @Override // p000a.p005b.p006a.ActivityC0045t, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        try {
            if (!new File(getFilesDir().getPath() + "/font/cheonlima.ttf").exists()) {
                File file = new File(getFilesDir().getPath() + "/font");
                if (!file.exists() && !file.mkdirs()) {
                    throw new IOException("can't create directories");
                }
                java.lang.String str = getFilesDir().getPath() + "/font/cheonlima.ttf";
                InputStream open = super.getAssets().open("font/cheonlima.ttf");
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                java.lang.String str2 = getFilesDir().getPath() + "/font/Taekwon.ttf";
                InputStream open2 = super.getAssets().open("font/Taekwon.ttf");
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                while (true) {
                    int read2 = open2.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read2);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            if (this.string2 == null || this.string2.isEmpty() || this.string2.equals("null")) {
                this.string2 = Util.m344e(this);
            }
            if (this.string2 != null && !this.string2.isEmpty() && !this.string2.equals("null")) {
                return ResManager.m5741a(super.getResources(),(this.string2));
            }
            return super.getResources();
        } catch (Exception unused) {
            return super.getResources();
        }
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        m4285H();
        boolean z = this instanceof SplashBaseActivity;
        if (!z) {
            if (BottomVM.homeMutableLiveData.getValue() == null || UserVM.sharedPreferences == null) {
                UserVM.sharedPreferences = getSharedPreferences("com.jeil.emarket", 0);
                setColorTheme();
                SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
                edit.putBoolean("hidden_setting_badge", true);
                edit.apply();
                anInt2 = getResources().getDimensionPixelSize(R.dimen.main_space);
                setScreenSize();
                string = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getResources().getString(R.string.app_folder_name);
                string1 = getCacheDir().getAbsolutePath();
                m4282E();
                API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.a.c.a
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context) {
                        BaseActivity.this.m4287a(context);
                    }
                });
                SharedPreferences sharedPreferences = UserVM.sharedPreferences;
                SimpleVM.f8836d = (sharedPreferences == null || sharedPreferences.getBoolean("screen", true)) ? false : true;
            } else {
                setColorTheme();
            }
        }
        super.onCreate(bundle);
        if (z) {
            return;
        }
        SetDescription();
        UserObserve();
        VendorUserObserve();
        this.questionHashMap.put(0, getResources().getString(R.string.where_is_hometown));
        this.questionHashMap.put(1, getResources().getString(R.string.what_is_hobby));
        this.questionHashMap.put(2, getResources().getString(R.string.what_is_nickname));
        this.questionHashMap.put(3, getResources().getString(R.string.alma_mater));
        this.questionHashMap.put(4, getResources().getString(R.string.favorite_color));
        this.questionHashMap.put(5, getResources().getString(R.string.favorite_weather));
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onResume() {
        super.onResume();
        m4309v();
        if (this instanceof SplashBaseActivity) {
            return;
        }
        if (UserVM.userMutableLiveData.getValue() != null) {
            TicketCategoryListVM.m5496a(this);
        }
        ImageDialog2 imageDialog2 = this.f6505y;
        if (imageDialog2 != null) {
            imageDialog2.dismiss();
        }
        SetDescription();
    }

    @Override // p000a.p005b.p006a.ActivityC0045t, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"ResourceType"})
    public void setContentView(int i) {
        if (!this.f6502v) {
            super.setContentView(i);
            return;
        }
        //this.drawerLayout = new DrawerLayout(this);
        //this.drawerLayout.setFitsSystemWindows(true);
        //this.drawerLayout.addView(View.inflate(this, i, null));
        DrawerLayout.LayoutParams eVar = new DrawerLayout.LayoutParams((anInt * 2) / 3, -1);
        eVar.gravity = 8388611;
        final LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -1));
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat.setId(R.id.ll_drawer);
        NavigationView navigationView = new NavigationView(this);
        navigationView.addView(linearLayoutCompat);
        navigationView.setLayoutParams(eVar);
        navigationView.setBackgroundColor(getResources().getColor(R.color.grey));
        //this.drawerLayout.addView(navigationView);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.c.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.setDrawer(linearLayoutCompat);
            }
        }, Status.time);
        NestedScrollView nestedScrollView = (NestedScrollView) this.drawerLayout.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            m4286a((View) nestedScrollView, this, (View) this.drawerLayout, false);
        }
        super.setContentView(this.drawerLayout);
    }

    /* renamed from: v */
    public boolean m4309v() {
        DrawerLayout drawerLayout = this.drawerLayout;
        if (drawerLayout == null || !drawerLayout.isOpen()) {
            return false;
        }
        //this.drawerLayout.open();
        return true;
    }

    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_tab_border);
    }

    /* renamed from: x */
    public void setScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        anInt = displayMetrics.widthPixels;
        anInt1 = displayMetrics.heightPixels;
    }

    /* renamed from: y */
    public void setColorTheme() {
        int i = UserVM.sharedPreferences.getInt("color_scheme", 1);
        if (i <= 0 || i > 6) {
            i = 1;
        }
        color = getResources().getIdentifier(CustomString.m3176b("primary", i), "color", getPackageName());
        getResources().getIdentifier(CustomString.m3176b("primaryh", i), "color", getPackageName());
        int identifier = getResources().getIdentifier(CustomString.m3176b("Theme.Emarket.Color", i), "style", getPackageName());
        if (identifier > 0) {
            setTheme(identifier);
        }
    }

    /* renamed from: z */
    public void setAppBar() {
        if (SimpleVM.f8836d) {
            return;
        }
        View findViewById = findViewById(R.id.header_scroll);
        if (findViewById == null && (findViewById = findViewById(R.id.ll_header_tabs)) == null) {
            return;
        }
       // ((AppBarLayout.C3017c) findViewById.getLayoutParams()).f11185a = 5;
    }


    public  void setDrawer(LinearLayoutCompat linearLayoutCompat) {
        FragmentNavigationAccount fragmentNavigationAccount = new FragmentNavigationAccount();
        fragmentNavigationAccount.m4957i(true);
        if (!getSupportFragmentManager().isDestroyed()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.ll_drawer, fragmentNavigationAccount, "nav");
            beginTransaction.commit();
        }
        this.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @SuppressLint({"RestrictedApi"})

    public void m4293a(NestedScrollView nestedScrollView, MaterialRippleLayout materialRippleLayout, View view, View view2, View view3, boolean z) {
        C2948g m5805a;
        if (nestedScrollView == null || nestedScrollView.canScrollVertically(-1)) {
            if (view != null) {
                view.setVisibility(View.VISIBLE);
            } else if (view2 != null) {
                view2.setVisibility(View.VISIBLE);
            }
        } else if (view != null) {
            view.setVisibility(View.GONE);
        } else if (view2 != null) {
            view2.setVisibility(View.GONE);
        }
        if (nestedScrollView != null && view3 != null) {
            if (nestedScrollView.canScrollVertically(1)) {
                view3.setVisibility(View.VISIBLE);
            } else {
                view3.setVisibility(View.GONE);
            }
        }
        if (materialRippleLayout != null) {
            if (nestedScrollView != null && nestedScrollView.getScrollY() < anInt1 * 2) {
                m5805a = C2948g.m5805a(materialRippleLayout, "alpha", 1.0f, 0.0f);
                m5805a.m5807b(300L);
                b bVar = new b(this, materialRippleLayout);
                if (m5805a.f10619b == null) {
                    m5805a.f10619b = new ArrayList<>();
                }
                m5805a.f10619b.add(bVar);
            } else {
                if ((!z && materialRippleLayout.getVisibility() == View.VISIBLE) || materialRippleLayout.getVisibility() == View.VISIBLE) {
                    return;
                }
                materialRippleLayout.setVisibility(View.VISIBLE);
                m5805a = C2948g.m5805a(materialRippleLayout, "alpha", 0.0f, 1.0f);
                m5805a.m5807b(300L);
            }
            m5805a.m5809c();
        }
    }


    public void initView(XRecyclerView xRecyclerView, MaterialRippleLayout materialRippleLayout, View view, View view2, View view3, boolean z) {
        C2948g m5805a;
        if (!this.f6500t) {
            if (xRecyclerView.m6991I()) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                } else if (view2 != null) {
                    view2.setVisibility(View.GONE);
                }
            } else if (view != null) {
                view.setVisibility(View.VISIBLE);
            } else if (view2 != null) {
                view2.setVisibility(View.VISIBLE);
            }
        }
        if (view3 != null) {
            if (xRecyclerView.canScrollVertically(1)) {
                view3.setVisibility(View.VISIBLE);
            } else {
                view3.setVisibility(View.GONE);
            }
        }
        if (materialRippleLayout == null) {
            return;
        }
        if (xRecyclerView.computeVerticalScrollOffset() < anInt1 * 2) {
            if (materialRippleLayout.getVisibility() == View.GONE) {
                return;
            }
            m5805a = C2948g.m5805a(materialRippleLayout, "alpha", 1.0f, 0.0f);
            m5805a.m5807b(300L);
            c cVar = new c(this, materialRippleLayout);
            if (m5805a.f10619b == null) {
                m5805a.f10619b = new ArrayList<>();
            }
            m5805a.f10619b.add(cVar);
        } else {
            if ((!z && materialRippleLayout.getVisibility() == View.VISIBLE) || materialRippleLayout.getVisibility() == View.VISIBLE) {
                return;
            }
            materialRippleLayout.setVisibility(View.VISIBLE);
            m5805a = C2948g.m5805a(materialRippleLayout, "alpha", 0.0f, 1.0f);
            m5805a.m5807b(300L);
        }
        m5805a.m5809c();
    }

    /* JADX WARN: Multi-variable type inference failed */

    public void m4298a(List<Newsletter> list) {
        if (!(this instanceof MainActivity) || ((MainActivity) this).m6451I()) {
            View inflate = View.inflate(this, R.layout.dialog_newsletter, null);
            this.recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_items);
            this.recyclerView.setHasFixedSize(true);
            this.recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) ((anInt1 / 10) * 5.5d)));
            this.recyclerView.setLayoutManager(new VLin(this, this));
            this.recyclerView.addOnScrollListener(new BottomRV_Listener(this, inflate));
            this.f6506z = new NewsletterAdapter(this);
            NewsletterAdapter c1800i = this.f6506z;
            c1800i.arrayList = list;
            c1800i.notifyDataSetChanged();
            this.recyclerView.setAdapter(this.f6506z);
            Animation loadAnimation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in);
            loadAnimation.setStartOffset(Status.time);
            loadAnimation.setDuration(Status.time);
            this.recyclerView.startAnimation(loadAnimation);
            ((CheckBox) inflate.findViewById(R.id.cb_show_newsletter)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.a.c.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BaseActivity.m4277a(compoundButton, z);
                }
            });
            inflate.findViewById(R.id.iv_newsletter_title).getLayoutParams().height = (anInt * 220) / 1080;
            this.f6505y = Util.getImageDialog2((Activity) this, inflate);
            this.f6505y.show();
            this.f6505y.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.c.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BaseActivity.this.m4288a(dialogInterface);
                }
            });
        }
    }
}
