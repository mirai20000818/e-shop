package com.jeil.emarket.frag.main.bottom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.activities.product.SearchActivity;
import com.jeil.emarket.activities.product.ShopActivity;
import com.jeil.emarket.activities.vendor.VendorsActivity;
import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.components.viewpager.CircleIndicator;
import com.jeil.emarket.components.viewpager.LoopViewPager;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.Home;
import com.jeil.emarket.model.customer.Newsletter;
import com.jeil.emarket.model.customer.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.CenterImgRecycler;
import com.jeil.emarket.adapters.newsletter.ItemShimmerCategoryHomeAdapter;
import com.jeil.emarket.adapters.fbt.ProductAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration3;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.CategoryVM;
import com.jeil.emarket.viewmodel.BottomVM;

/* renamed from: b.f.a.g.b.b.w0 */

public class FragmentHome extends Fragment {

    /* renamed from: a0 */
    public ItemShimmerCategoryHomeAdapter f9367a0;

    /* renamed from: b0 */
    public ProductAdapter f9368b0;

    /* renamed from: c0 */
    public ProductAdapter f9369c0;

    /* renamed from: d0 */
    public ProductAdapter f9370d0;

    /* renamed from: e0 */
    public ProductAdapter f9371e0;

    /* renamed from: f0 */
    public WaveSwipeRefreshLayout f9372f0;

    /* renamed from: g0 */
    public View f9373g0;

    /* renamed from: h0 */
    public boolean f9374h0 = false;

    /* renamed from: b.f.a.g.b.b.w0$a */
    public class a extends RecyclerView.OnScrollListener {

        
        public final  View f9375a;

        public a(FragmentHome fragmentHome, View view) {
            this.f9375a = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s
        
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView.canScrollHorizontally(-1)) {
                this.f9375a.findViewById(R.id.ll_left_gradient).setVisibility(View.VISIBLE);
            } else {
                this.f9375a.findViewById(R.id.ll_left_gradient).setVisibility(View.GONE);
            }
            if (recyclerView.canScrollHorizontally(1)) {
                this.f9375a.findViewById(R.id.ll_right_gradient).setVisibility(View.VISIBLE);
            } else {
                this.f9375a.findViewById(R.id.ll_right_gradient).setVisibility(View.GONE);
            }
        }
    }

    
    public static  int m4984a(Home.Banner banner, Home.Banner banner2) {
        return banner2.priority - banner.priority;
    }

    
    public static  void m4986a(MainActivity mainActivity, View view) {
        BottomNavigationView bottomNavigationView = mainActivity.bottomNavigationView;
        if (bottomNavigationView != null) {
            bottomNavigationView.setIndex(2);
        }
    }

    /* renamed from: S0 */
    public  void m4989S0() {
        this.f9372f0.setRefreshing(false);
        this.f9372f0.setEnabled(false);
    }

    /* renamed from: T0 */
    public  void m4990T0() {
        m5016n(this.f9373g0);
        m4992V0();
        m5017o(this.f9373g0);
        m5018p(this.f9373g0);
    }

    /* renamed from: U0 */
    public  void m4991U0() {
        m5015m(this.f9373g0);
        new Handler().post(new Runnable() { // from class: b.f.a.g.b.b.a
            @Override // java.lang.Runnable
            public final void run() {
                FragmentHome.this.m4993W0();
            }
        });
    }

    /* renamed from: V0 */
    public void m4992V0() {
        CategoryVM.listMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.p
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentHome.this.m5004c((List) obj);
            }
        });
    }

    /* renamed from: W0 */
    public void m4993W0() {
        BottomVM.newsletterListLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.n
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentHome.this.m5006d((List) obj);
            }
        });
    }

    /* renamed from: X0 */
    public void m4994X0() {
        View view = this.f9373g0;
        if (view != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) view.findViewById(R.id.mrl_scroll_top);
            BaseActivity activityC1391g1 = (BaseActivity) getActivity();
            if (materialRippleLayout != null) {
                activityC1391g1.m4293a((NestedScrollView) this.f9373g0.findViewById(R.id.nsv_main), materialRippleLayout, (View) null, (View) null, activityC1391g1.findViewById(R.id.bottom_border), true);
            }
        }
    }

    
    public List<Home.Banner> m4995a(List<Home.Banner> list) {
        if (list != null) {
            Iterator<Home.Banner> it = list.iterator();
            while (it.hasNext()) {
                it.next().priority = (int) (Math.random() + r1.priority);
            }
            Collections.sort(list, new Comparator() { // from class: b.f.a.g.b.b.t
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return FragmentHome.m4984a((Home.Banner) obj, (Home.Banner) obj2);
                }
            });
        }
        return list;
    }

    
    public  void m4997a(View view, Integer num) {
        TextView textView = (TextView) view.findViewById(R.id.tv_new_product_count);
        textView.setVisibility(View.VISIBLE);
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        sb.append(num != null ? num : "0");
        sb.append(getResources().getString(R.string.count_unit));
        textView.setText(sb.toString());
        view.findViewById(R.id.cv_new_products).setVisibility((num == null || num.intValue() == 0) ? View.GONE : View.VISIBLE);
    }

    
    public  void m4998a(View view, List list) {
        ProductAdapter c1879s;
        List subList;
        if (list != null) {
            List arrayList = new ArrayList(list);
            if (arrayList.size() == 0) {
                CustomString.m3167a(view, R.id.llc_featured_products, 8, R.id.rv_featured_product, 8);
                return;
            }
            List<Home.Banner> list2 = ((Home) Objects.requireNonNull(BottomVM.homeMutableLiveData.getValue())).featuredBanners;
            ArrayList arrayList2 = new ArrayList();
            m4995a(list2);
            if (list2 != null && list2.size() != 0) {
                for (int i = 0; i < list2.size(); i++) {
                    Product product = new Product();
                    product.featuredBanner = list2.get(i);
                    product.type = "banner";
                    arrayList2.add(product);
                }
            }
            if (arrayList2.size() != 0) {
                for (int i2 = 0; i2 < Status.f8809D.length; i2++) {
                    if (arrayList2.size() > i2 && arrayList2.get(i2) != null) {
                        if (arrayList.size() > Status.f8809D[i2]) {
                            arrayList.add(r5[i2] - 1, arrayList2.get(i2));
                        }
                    }
                }
            }
            if (arrayList.size() > 20) {
                arrayList = arrayList.subList(0, 20);
            }
            if (arrayList.size() < 10) {
                c1879s = this.f9370d0;
                subList = arrayList.subList(0, arrayList.size());
            } else {
                c1879s = this.f9370d0;
                subList = arrayList.subList(0, 10);
            }
            c1879s.addAll(subList);
            TextViewBold textViewBold = (TextViewBold) view.findViewById(R.id.tv_featured_product);
            textViewBold.setBackgroundColor(getResources().getColor(R.color.transparent));
            textViewBold.setTextColor(getResources().getColor(R.color.dark));
            if (arrayList.size() > 10) {
                this.f9371e0.addAll(arrayList.subList(10, Math.min(arrayList.size(), 20)));
                view.findViewById(R.id.rv_featured_product2).setVisibility(View.VISIBLE);
            } else {
                view.findViewById(R.id.rv_featured_product2).getLayoutParams().height = Util.dp2px(getContext(), 8);
            }
        }
    }

    
    public  void m4999a(Home home, MainActivity mainActivity, View view) {
        java.lang.String str = home.introductions.cookSiteUrl;
        if (str == null || str.isEmpty()) {
            Util.toast(mainActivity, mainActivity.getString(R.string.coming_soon), "default", 0, 0);
            return;
        }
        try {
            mainActivity.getPackageManager().getPackageInfo(home.introductions.cookSitePackage, 0);
            Intent launchIntentForPackage = mainActivity.getPackageManager().getLaunchIntentForPackage(home.introductions.cookSitePackage);
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            } else {
                mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(home.introductions.cookSiteUrl)));
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(home.introductions.cookSiteUrl)));
        }
    }


    public  void m5000b(View view, List list) {
        if (list != null) {
            ProductAdapter c1879s = this.f9368b0;
            c1879s.arrayList = list;
            c1879s.notifyDataSetChanged();
        }
        view.findViewById(R.id.mrl_monthly_product).setVisibility(View.VISIBLE);
        TextViewBold textViewBold = (TextViewBold) view.findViewById(R.id.tv_monthly_product);
        textViewBold.setBackgroundColor(getResources().getColor(R.color.transparent));
        textViewBold.setTextColor(getResources().getColor(R.color.dark));
    }


    public  void m5001b(List list) {
        if (this.f9374h0) {
            return;
        }
        boolean z = UserVM.sharedPreferences.getBoolean("save_newsletter_show", false);
        if (list == null || list.size() <= 0) {
            return;
        }
        if ((z && Util.date2Str(new Date()).equals(UserVM.sharedPreferences.getString("save_setting_newsletter_show_date", ""))) || ((BaseActivity) getActivity()).drawerLayout.m1453f()) {
            return;
        }
        this.f9374h0 = true;
        ((BaseActivity) getActivity()).m4298a((List<Newsletter>) list);
    }


    public void m5002c(View view) {
        this.f9367a0 = new ItemShimmerCategoryHomeAdapter((MainActivity) getActivity());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_category);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, 0, false));
        recyclerView.setAdapter(this.f9367a0);
        Category category = new Category();
        category.type = "shimmer";
        for (int i = 0; i < 12; i++) {
            this.f9367a0.add((ItemShimmerCategoryHomeAdapter) category);
        }
        this.f9367a0.notifyDataSetChanged();
        recyclerView.addOnScrollListener(new a(this, view));
    }


    public  void m5004c(List list) {
        if (list != null) {
            this.f9367a0.addAll((List<Category>) list);
        }
    }


    public void m5005d(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_featured_product);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_featured_product2);
        this.f9370d0 = new ProductAdapter((BaseActivity) getActivity(), "grid");
        this.f9371e0 = new ProductAdapter((BaseActivity) getActivity(), "grid");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, 1, false));
        recyclerView.addItemDecoration(new ItemDecoration3(2, BaseActivity.anInt2, true));
        recyclerView.setAdapter(this.f9370d0);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2, 1, false));
        recyclerView2.addItemDecoration(new ItemDecoration3(2, BaseActivity.anInt2, true));
        recyclerView2.setAdapter(this.f9371e0);
        ArrayList arrayList = new ArrayList();
        Product product = new Product();
        product.type = "shimmer";
        for (int i = 0; i < 6; i++) {
            arrayList.add(product);
        }
        ProductAdapter c1879s = this.f9370d0;
        c1879s.arrayList = arrayList;
        c1879s.notifyDataSetChanged();
    }


    public  void m5006d(final List list) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.b.d0
            @Override // java.lang.Runnable
            public final void run() {
                FragmentHome.this.m5001b(list);
            }
        }, 2000L);
    }


    public void m5007e(View view) {
        LoopViewPager loopViewPager = (LoopViewPager) view.findViewById(R.id.vp_top_banner);
        LoopViewPager loopViewPager2 = (LoopViewPager) view.findViewById(R.id.vp_mid_banner);
        loopViewPager.getLayoutParams().height = (BaseActivity.anInt * 176) / 360;
        loopViewPager2.getLayoutParams().height = (BaseActivity.anInt * 117) / 360;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.iv_today_deals);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.iv_vendors);
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R.id.iv_cook);
        appCompatImageView.getLayoutParams().height = ((BaseActivity.anInt - Util.dp2px(getContext(), 20)) * 10) / 34;
        ViewGroup.LayoutParams layoutParams = appCompatImageView2.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = appCompatImageView3.getLayoutParams();
        int m170a = ((BaseActivity.anInt - Util.dp2px(getContext(), 20)) * 8) / 34;
        layoutParams2.height = m170a;
        layoutParams.height = m170a;
        final MainActivity mainActivity = (MainActivity) getActivity();
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentHome.m4986a(MainActivity.this, view2);
            }
        });
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentHome.this.m5010h(view2);
            }
        });
    }

    /* renamed from: f */
    public void m5008f(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_monthly_product);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(0, false);
        this.f9368b0 = new ProductAdapter((BaseActivity) getActivity(), "widget");
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.f9368b0);
        ArrayList arrayList = new ArrayList();
        Product product = new Product();
        product.type = "shimmer";
        for (int i = 0; i < 6; i++) {
            arrayList.add(product);
        }
        ProductAdapter c1879s = this.f9368b0;
        c1879s.arrayList = arrayList;
        c1879s.notifyDataSetChanged();
        view.findViewById(R.id.mrl_monthly_product).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentHome.this.m5011i(view2);
            }
        });
    }

    /* renamed from: g */
    public void m5009g(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_new_products);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(0, false);
        this.f9369c0 = new ProductAdapter((BaseActivity) getActivity(), "new");
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.f9369c0);
        ArrayList arrayList = new ArrayList();
        Product product = new Product();
        product.type = "shimmer";
        for (int i = 0; i < 6; i++) {
            arrayList.add(product);
        }
        ProductAdapter c1879s = this.f9369c0;
        c1879s.arrayList = arrayList;
        c1879s.notifyDataSetChanged();
        view.findViewById(R.id.mrl_show_all_new_products).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentHome.this.m5012j(view2);
            }
        });
        view.findViewById(R.id.mrl_show_all).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentHome.this.m5013k(view2);
            }
        });
    }

    /* renamed from: h */
    public  void m5010h(View view) {
        Intent intent = new Intent(getContext(), VendorsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    
    public  void m5011i(View view) {
        Intent intent = new Intent(getActivity().getApplicationContext(), ShopActivity.class);
        intent.putExtra("monthly_products", true);
        startActivity(intent);
    }

   
    public  void m5012j(View view) {
        Intent intent = new Intent(getActivity().getApplicationContext(), ShopActivity.class);
        intent.putExtra("new_products", true);
        startActivity(intent);
    }

    
    public  void m5013k(View view) {
        Intent intent = new Intent(getActivity().getApplicationContext(), ShopActivity.class);
        intent.putExtra("new_products", true);
        startActivity(intent);
    }

    /* renamed from: l */
    public  void m5014l(View view) {
        startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    /* renamed from: m */
    public void m5015m(final View view) {
        BottomVM.f10422g.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.o
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentHome.this.m4998a(view, (List) obj);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: n */
    public void m5016n(final View view) {
        BottomVM.homeMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.u
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentHome.this.m4996a(view, (Home) obj);
            }
        });
    }

    /* renamed from: o */
    public void m5017o(final View view) {
        BottomVM.f10420e.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.x
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentHome.this.m5000b(view, (List) obj);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: p */
    public void m5018p(final View view) {
        BottomVM.f10421f.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.j
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentHome.this.m5003c(view, (List) obj);
            }
        });
        BottomVM.f10428m.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.q
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                FragmentHome.this.m4997a(view, (Integer) obj);
            }
        });
    }

    
    public  void m4996a(View view, final Home home) {
        if (this.f9372f0 != null) {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.b.v
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentHome.this.m4989S0();
                }
            }, 2000L);
        }
        final MainActivity mainActivity = (MainActivity) getActivity();
        if (home.topBanners != null) {
            LoopViewPager loopViewPager = (LoopViewPager) view.findViewById(R.id.vp_top_banner);
            List<Home.Banner> list = home.topBanners;
            m4995a(list);
            CenterImgRecycler c1776i = new CenterImgRecycler(mainActivity, null, false, false);
            for (final Home.Banner banner : list) {
                banner.link = Util.m349f(banner.link);
                c1776i.f7125d.add(new CenterImgRecycler.a(banner.url, new CenterImgRecycler.b() { // from class: b.f.a.g.b.b.r
                    @Override // p078b.p159f.p160a.p178b.p180b.C1776i.b
                    
                    public final void mo4370a(ImageView imageView) {
                        Util.m257a(MainActivity.this, banner.link);
                    }
                }));
                c1776i.notifyDataSetChanged();
            }
            loopViewPager.setAdapter(c1776i);
            c1776i.notifyDataSetChanged();
            loopViewPager.setAutoPlay(true);
            ((CircleIndicator) view.findViewById(R.id.ci_top_banner)).setViewPager(loopViewPager);
        }
        if (home.midBanners != null) {
            LoopViewPager loopViewPager2 = (LoopViewPager) view.findViewById(R.id.vp_mid_banner);
            CenterImgRecycler c1776i2 = new CenterImgRecycler(mainActivity, null, false, false);
            for (final Home.Banner banner2 : home.midBanners) {
                banner2.link = Util.m349f(banner2.link);
                c1776i2.f7125d.add(new CenterImgRecycler.a(banner2.url, new CenterImgRecycler.b() { // from class: b.f.a.g.b.b.b0
                    @Override // p078b.p159f.p160a.p178b.p180b.C1776i.b
                    
                    public final void mo4370a(ImageView imageView) {
                        Util.m257a(MainActivity.this, banner2.link);
                    }
                }));
                c1776i2.notifyDataSetChanged();
            }
            loopViewPager2.setAdapter(c1776i2);
            c1776i2.notifyDataSetChanged();
            loopViewPager2.setAutoPlay(true);
            loopViewPager2.setVisibility(View.VISIBLE);
            ((CircleIndicator) view.findViewById(R.id.ci_mid_banner)).setViewPager(loopViewPager2);
            CardView cardView = (CardView) view.findViewById(R.id.cv_mid_banner);
            if (cardView != null) {
                cardView.setVisibility(View.VISIBLE);
            }
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.iv_today_deals);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.iv_vendors);
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R.id.iv_new_products);
        if (home.introductions != null) {
            Glide.with((FragmentActivity) mainActivity).load(Util.m306b(home.introductions.service, "")).diskCacheStrategy(DiskCacheStrategy.ALL).load(mainActivity.getResources().getDrawable(R.drawable.ic_placeholder)).m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) mainActivity, 7)), true).into((ImageView) appCompatImageView);
            Glide.with((FragmentActivity) mainActivity).load(Util.m306b(home.introductions.vendors, "")).diskCacheStrategy(DiskCacheStrategy.ALL).load(mainActivity.getResources().getDrawable(R.drawable.ic_placeholder)).m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) mainActivity, 7)), true).into((ImageView) appCompatImageView2);
            Glide.with((FragmentActivity) mainActivity).load(Util.m306b(home.introductions.newProduct, "")).diskCacheStrategy(DiskCacheStrategy.ALL).load(mainActivity.getResources().getDrawable(R.drawable.ic_placeholder)).into((ImageView) appCompatImageView3);
            TextView textView = (TextView) view.findViewById(R.id.tv_vendors);
            textView.setText(home.introductions.vendorCount + "+");
            textView.setVisibility(View.VISIBLE);
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) view.findViewById(R.id.iv_cook);
            Glide.with((FragmentActivity) mainActivity).load(Util.m306b(home.introductions.cookSiteBanner, "")).diskCacheStrategy(DiskCacheStrategy.ALL).load(mainActivity.getResources().getDrawable(R.drawable.ic_placeholder)).m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) mainActivity, 7)), true).into((ImageView) appCompatImageView4);
            appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentHome.this.m4999a(home, mainActivity, view2);
                }
            });
        }
    }


    public  void m5003c(View view, List list) {
        if (list != null) {
            ProductAdapter c1879s = this.f9369c0;
            c1879s.arrayList = list;
            c1879s.notifyDataSetChanged();
        }
        CustomString.m3167a(view, R.id.fl_new_products, 0, R.id.mrl_show_all_new_products, 0);
        view.findViewById(R.id.rv_new_products).setVisibility(View.VISIBLE);
        TextViewBold textViewBold = (TextViewBold) view.findViewById(R.id.tv_new_product);
        textViewBold.setBackgroundColor(getResources().getColor(R.color.transparent));
        textViewBold.setTextColor(getResources().getColor(R.color.white));
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"CutPasteId"})
    
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final MainActivity mainActivity = (MainActivity) getActivity();
        this.f9373g0 = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        this.f9372f0 = (WaveSwipeRefreshLayout) this.f9373g0.findViewById(R.id.wsr_layout);
        m5007e(this.f9373g0);
        m5002c(this.f9373g0);
        m5008f(this.f9373g0);
        m5009g(this.f9373g0);
        m5005d(this.f9373g0);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.b.i
            @Override // java.lang.Runnable
            public final void run() {
                FragmentHome.this.m4990T0();
            }
        }, Status.time);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.b.c0
            @Override // java.lang.Runnable
            public final void run() {
                FragmentHome.this.m4991U0();
            }
        }, Status.time * 5);
        WaveSwipeRefreshLayout waveSwipeRefreshLayout = this.f9372f0;
        if (waveSwipeRefreshLayout != null) {
            mainActivity.getClass();
            waveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.InterfaceC3256c() { // from class: b.f.a.g.b.b.b
                @Override // com.jeil.emarket.components.swiperefresh.WaveSwipeRefreshLayout.InterfaceC3256c
                
                public final void mo4970a() {
                    MainActivity.this.m4282E();
                }
            });
        }
        View view = this.f9373g0;
        ((MainActivity) getActivity()).setClickEvent(view);
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) view.findViewById(R.id.mrl_header_search_input);
        if (materialRippleLayout != null) {
            materialRippleLayout.setDefaultRippleAlpha(5);
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentHome.this.m5014l(view2);
                }
            });
        }
        final NestedScrollView nestedScrollView = (NestedScrollView) this.f9373g0.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            MaterialRippleLayout m4286a = mainActivity.m4286a((View) nestedScrollView, (BaseActivity) mainActivity, this.f9373g0, true);
            if (m4286a != null) {
                m4286a.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NestedScrollView.this.smoothScrollBy(0, 0, 300);
                    }
                });
            }
            nestedScrollView.setTag(Integer.valueOf(R.id.wsr_layout));
        }
        return this.f9373g0;
    }
}
