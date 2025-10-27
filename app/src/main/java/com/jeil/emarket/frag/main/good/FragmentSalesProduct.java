package com.jeil.emarket.frag.main.good;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ShopCategoryFilter;
import com.jeil.emarket.model.customer.ShopFilter;
import com.jeil.emarket.model.vendor.Vendor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;


import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.fbt.ProductAdapter;
import com.jeil.emarket.widget.RecyclerViewEx;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.components.itemdecor.ItemDecoration3;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.dialog.DialogShopCategoryFilter;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.ProductVendorVM;
import com.google.android.material.internal.FlowLayout;
/* renamed from: b.f.a.g.b.c.p0 */

public class FragmentSalesProduct extends BaseFragment implements BaseInterface {

    /* renamed from: A0 */
    public ShopCategoryFilter shopCategoryFilter;

    /* renamed from: B0 */
    public DialogShopCategoryFilter dialogShopCategoryFilter;

    /* renamed from: C0 */
    @SuppressLint("RestrictedApi")
    public FlowLayout flowLayout;

    /* renamed from: D0 */
    public LinearLayout f9453D0;

    /* renamed from: E0 */
    public List<Category> categoryList;

    /* renamed from: F0 */
    public int f9455F0;

    /* renamed from: G0 */
    public boolean f9456G0;

    /* renamed from: H0 */
    public boolean f9457H0;

    /* renamed from: I0 */
    public boolean f9458I0;

    /* renamed from: J0 */
    public java.lang.String f9459J0;

    /* renamed from: K0 */
    public List<Integer> f9460K0;

    /* renamed from: L0 */
    public RecyclerViewEx.MyAdapter f9461L0;

    /* renamed from: M0 */
    public RecyclerViewEx f9462M0;

    /* renamed from: N0 */
    public boolean f9463N0;

    /* renamed from: O0 */
    public boolean f9464O0;

    /* renamed from: o0 */
    public MutableLiveData<Integer> f9465o0;

    /* renamed from: p0 */
    public MutableLiveData<java.lang.String> f9466p0;

    /* renamed from: q0 */
    public int f9467q0;

    /* renamed from: r0 */
    public java.lang.String f9468r0;

    /* renamed from: s0 */
    public java.lang.String f9469s0;

    /* renamed from: t0 */
    public int f9470t0;

    /* renamed from: u0 */
    public boolean f9471u0;

    /* renamed from: v0 */
    public MutableLiveData<ShopFilter> f9472v0;

    /* renamed from: w0 */
    public java.lang.String f9473w0;

    /* renamed from: x0 */
    public java.lang.String f9474x0;

    /* renamed from: y0 */
    public boolean f9475y0;

    /* renamed from: z0 */
    public ProductAdapter f9476z0;



    /* renamed from: b.f.a.g.b.c.p0$f */
    public class f extends RecyclerView.OnScrollListener {


        public final  int f9477a;


        public final  View f9478b;

        public f(FragmentSalesProduct fragmentSalesProduct, int i, View view) {
            this.f9477a = i;
            this.f9478b = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (this.f9477a > 0) {
                this.f9478b.setTranslationY(r1 + 0);
            } else {
                this.f9478b.setTranslationY(0.0f);
            }
        }
    }

    public FragmentSalesProduct(BaseActivity activityC1391g1) {
        this.f9465o0 = new MutableLiveData<>(0);
        this.f9466p0 = new MutableLiveData<>("");
        this.f9467q0 = 0;
        this.f9468r0 = "";
        this.f9469s0 = "";
        this.f9470t0 = 0;
        this.f9471u0 = true;
        this.f9472v0 = new MutableLiveData<>();
        this.f9473w0 = Status.f8824o[0];
        this.f9474x0 = Status.f8826q[0];
        this.f9475y0 = false;
        this.categoryList = new ArrayList();
        this.f9455F0 = 0;
        this.f9456G0 = true;
        this.f9457H0 = false;
        this.f9458I0 = true;
        this.f9459J0 = "grid";
        this.f9463N0 = true;
        this.f9464O0 = false;
        this.baseActivity = activityC1391g1;
    }

    public FragmentSalesProduct(BaseActivity activityC1391g1, java.lang.String str) {
        this.f9465o0 = new MutableLiveData<>(0);
        this.f9466p0 = new MutableLiveData<>("");
        this.f9467q0 = 0;
        this.f9468r0 = "";
        this.f9469s0 = "";
        this.f9470t0 = 0;
        this.f9471u0 = true;
        this.f9472v0 = new MutableLiveData<>();
        this.f9473w0 = Status.f8824o[0];
        this.f9474x0 = Status.f8826q[0];
        this.f9475y0 = false;
        this.categoryList = new ArrayList();
        this.f9455F0 = 0;
        this.f9456G0 = true;
        this.f9457H0 = false;
        this.f9458I0 = true;
        this.f9459J0 = "grid";
        this.f9463N0 = true;
        this.f9464O0 = false;
        this.baseActivity = activityC1391g1;
        this.f9459J0 = str;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        m5061a(this);
        if (this.xRecyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) this.baseActivity, 2, 1, false);
            this.f9476z0 = new ProductAdapter(this.baseActivity, this.f9459J0);
            this.xRecyclerView.setAdapter(this.f9476z0);
            this.xRecyclerView.setLayoutManager(gridLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration3(2, BaseActivity.anInt2, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f9458I0;
            xRecyclerView.setDrawingCacheEnabled(true);
            this.xRecyclerView.m6994L();
            if (this.f9456G0 && this.f9460K0 == null) {
                LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.baseActivity);
                linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
                this.flowLayout = new FlowLayout(this.baseActivity);
                LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
                c0541a.setMargins(Util.dp2px((Context) this.baseActivity, -3), Util.dp2px((Context) this.baseActivity, -4), Util.dp2px((Context) this.baseActivity, -3), Util.dp2px((Context) this.baseActivity, -4));
                linearLayoutCompat.setLayoutParams(c0541a);
                linearLayoutCompat.addView(this.flowLayout);
                this.f9472v0.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.c.u
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        FragmentSalesProduct.this.m5063a((ShopFilter) obj);
                    }
                });
                this.xRecyclerView.addView(linearLayoutCompat);
            }
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(this.f9459J0.equals("wishlist") ? R.drawable.ic_wishlist_empty : this.f9459J0.equals("deals") ? R.drawable.ic_products : R.drawable.ic_box);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(this.f9459J0.equals("wishlist") ? R.string.empty_product : this.f9459J0.equals("deals") ? R.string.nomore_loading : R.string.empty_shop);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.header).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        java.lang.String str;
        if (this.f9139c0) {
            return;
        }
        super.mo4890V0();
        if (this.f9458I0) {
            ArrayList arrayList = new ArrayList();
            Product product = new Product();
            product.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(product);
            }
            this.f9476z0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("page", this.f9137a0 + 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.f9459J0.equals("deals")) {
            str = "e6/sale/today";
        } else if (this.f9459J0.equals("collection")) {
            StringBuilder m3163a = CustomString.format("e6/collection/");
            m3163a.append(this.f9470t0);
            str = m3163a.toString();
        } else {
            str = "e6/products";
        }
        new API_PROVIDER(this.baseActivity, this.f9459J0.equals("deals") ? "get_sale_products" : this.f9459J0.equals("collection") ? "get_collection_products" : "get_products", this).get(str, this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: W0 */
    public void mo4891W0() {
        java.lang.String str;
        super.mo4891W0();
        boolean z = false;
        if (SimpleVM.f8836d || this.f9148l0) {
            //this.xRecyclerView.m2806j(0);
            NestedScrollView nestedScrollView = this.nsv_main;
            if (nestedScrollView != null) {
                nestedScrollView.m2444b(0, 0);
            }
        } else {
            this.f9137a0 = 0;
        }
        if (this.f9458I0) {
            ArrayList arrayList = new ArrayList();
            Product product = new Product();
            product.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(product);
            }
            ProductAdapter c1879s = this.f9476z0;
            c1879s.arrayList = arrayList;
            c1879s.notifyDataSetChanged();
        } else {
            ProductAdapter c1879s2 = this.f9476z0;
            c1879s2.arrayList = new ArrayList();
            c1879s2.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
        }
        try {
            this.jsonObject = new JSONObject();
            if (this.f9465o0.getValue() != null && this.f9465o0.getValue().intValue() > 0 && this.f9466p0.getValue() != null && !this.f9466p0.getValue().isEmpty()) {
                this.jsonObject.put("category", this.f9465o0.getValue());
                this.jsonObject.put("tree", this.f9466p0.getValue());
                if (this.f9472v0 != null && this.f9472v0.getValue() != null) {
                    if (this.f9472v0.getValue().brand != null) {
                        this.jsonObject.put("brand", this.f9472v0.getValue().brand.f12422id);
                    }
                    if (this.f9472v0.getValue().vendor != null) {
                        this.jsonObject.put("vendor", this.f9472v0.getValue().vendor.f12423id);
                    }
                    if (this.f9472v0.getValue().attributes != null && this.f9472v0.getValue().attributes.size() > 0) {
                        this.jsonObject.put("attributes", this.f9472v0.getValue().attributes);
                    }
                }
            }
            if (this.f9467q0 > 0) {
                this.jsonObject.put("vendor", this.f9467q0);
            }
            if (!this.f9469s0.isEmpty()) {
                this.jsonObject.put("search", this.f9469s0);
            }
            if (this.f9472v0 != null && this.f9472v0.getValue() != null) {
                if (this.f9472v0.getValue().minPrice > 0.0f) {
                    this.jsonObject.put("min_price", this.f9472v0.getValue().minPrice);
                }
                if (this.f9472v0.getValue().maxPrice > 0.0f) {
                    this.jsonObject.put("max_price", this.f9472v0.getValue().maxPrice);
                }
                if (this.f9472v0.getValue().currency != null) {
                    this.jsonObject.put("currency", this.f9472v0.getValue().currency);
                }
                if (this.f9472v0.getValue().isFeatured) {
                    this.jsonObject.put("is_featured", true);
                }
                this.jsonObject.put("is_in_stock", this.f9472v0.getValue().isInStock);
                if (this.f9472v0.getValue().isDiscounted) {
                    this.jsonObject.put("is_discounted", true);
                }
            }
            if (this.f9460K0 != null) {
                if (this.f9460K0.size() > 0) {
                    java.lang.String obj = this.f9460K0.toString();
                    this.jsonObject.put("ids", obj.substring(1, obj.length() - 1));
                } else {
                    this.jsonObject.put("ids", "0");
                }
            }
            if (!this.f9474x0.isEmpty() && !this.f9473w0.isEmpty()) {
                this.jsonObject.put("orderby", this.f9473w0);
                this.jsonObject.put("orderway", this.f9474x0);
            }
            if (this.f9456G0 && !this.f9475y0) {
                JSONObject jSONObject = this.jsonObject;
                if (this.f9472v0 != null && this.f9472v0.getValue() != null && this.f9472v0.getValue().isInStock) {
                    z = true;
                }
                jSONObject.put("is_in_stock", z);
            } else if (this.f9475y0) {
                this.jsonObject.put("is_in_stock", true);
            }
            if (this.f9459J0.equals("deals")) {
                this.jsonObject.remove("is_in_stock");
            }
            if (this.f9459J0.equals("newProducts")) {
                this.jsonObject.put("new_products", true);
                this.jsonObject.put("is_in_stock", true);
                this.jsonObject.put("withoutIDSort", true);
            }
            if (this.f9459J0.equals("monthly")) {
                this.jsonObject.put("is_month", true);
                this.jsonObject.put("limit", 20);
                this.jsonObject.remove("is_in_stock");
            }
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("page", this.f9137a0 + 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.f9459J0.equals("deals")) {
            str = "e6/sale/today";
        } else if (this.f9459J0.equals("collection")) {
            StringBuilder m3163a = CustomString.format("e6/collection/");
            m3163a.append(this.f9470t0);
            str = m3163a.toString();
        } else {
            str = "e6/products";
        }
        new API_PROVIDER(this.baseActivity, this.f9459J0.equals("deals") ? "get_sale_products" : this.f9459J0.equals("collection") ? "get_collection_products" : "get_products", this).get(str, this.jsonObject);
    }

    /* renamed from: Z0 */
    public void m5059Z0() {
        DialogShopCategoryFilter dialogC2184e3 = this.dialogShopCategoryFilter;
        if (dialogC2184e3 == null) {
            this.dialogShopCategoryFilter = new DialogShopCategoryFilter(this.baseActivity, this.f9472v0.getValue(), this.shopCategoryFilter);
            this.dialogShopCategoryFilter.f8933F = this.f9467q0 > 0;
            DialogShopCategoryFilter dialogC2184e32 = this.dialogShopCategoryFilter;
            dialogC2184e32.f8934G = this.f9468r0;
            dialogC2184e32.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.c.v
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FragmentSalesProduct.this.m5067b(dialogInterface);
                }
            });
        } else {
            dialogC2184e3.m4822n();
        }
        DialogShopCategoryFilter dialogC2184e33 = this.dialogShopCategoryFilter;
        dialogC2184e33.f8255f = 1.0f;
        dialogC2184e33.f8254e = 0.7f;
        dialogC2184e33.show();
    }


    public  void m5060a(DialogInterface dialogInterface) {
        this.f9464O0 = false;
    }


    public void m5061a(FragmentSalesProduct fragmentSalesProduct) {
        API_PROVIDER APIS = new API_PROVIDER(this.baseActivity, "get_filter_data", this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", fragmentSalesProduct.f9465o0.getValue());
            jSONObject.put("tree", fragmentSalesProduct.f9466p0.getValue());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        APIS.get("e6/shop", jSONObject);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x01ce, code lost:
    
        if (r0 != r10.f9450A0.maxPrice) goto L32;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m5063a(final com.jeil.emarket.model.customer.ShopFilter r11) {
        /*
            Method dump skipped, instructions count: 723
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p231g.p233b.p236c.C2423p0.m5063a(com.jeil.emarket.model.customer.ShopFilter):void");
    }


    public  void m5064a(ShopFilter shopFilter, int i, View view) {
        shopFilter.attributes.remove(i);
        this.f9472v0.setValue(shopFilter);
    }


    public  void m5065a(ShopFilter shopFilter, View view) {
        shopFilter.isInStock = false;
        this.f9472v0.setValue(shopFilter);
    }


    public  void m5066a(java.lang.String[] strArr, ActionLink actionLink, BaseDialog2 baseDialog2, View view, int i) {
        java.lang.String str;
        if (strArr[i].equals(this.f9473w0)) {
            str = this.f9474x0.equals(Status.f8826q[0]) ? Status.f8826q[1] : Status.f8826q[0];
        } else {
            this.f9473w0 = strArr[i];
            str = Status.f8826q[0];
        }
        this.f9474x0 = str;
        if (!this.f9459J0.equals("monthly")) {
            SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
            edit.putString("orderby", this.f9473w0);
            edit.putString("orderway", this.f9474x0);
            edit.apply();
        }
        actionLink.setmTextView(Util.getIdentifier(this.baseActivity, this.f9473w0 + "_" + this.f9474x0, ""));
        this.f9137a0 = 0;
        mo4891W0();
        baseDialog2.startAni();
    }


    public  void m5067b(DialogInterface dialogInterface) {
        DialogShopCategoryFilter dialogC2184e3 = this.dialogShopCategoryFilter;
        if (dialogC2184e3.f8935H) {
            dialogC2184e3.f8935H = false;
            this.f9472v0.setValue(dialogC2184e3.f8936y);
        }
    }


    public  void m5068b(ShopFilter shopFilter, View view) {
        shopFilter.isFeatured = false;
        this.f9472v0.setValue(shopFilter);
    }


    public  boolean m5069b(int i, java.lang.String str, int i2) {
        if (this.f9139c0 || this.categoryList.size() < i) {
            return false;
        }
        Category category = this.categoryList.get(i);
        this.f9465o0.setValue( Integer.valueOf(category.f12393id));
        this.f9466p0.setValue(category.tree);
        this.shopCategoryFilter = null;
        this.dialogShopCategoryFilter = null;
        m5061a(this);
        this.f9472v0.setValue(new ShopFilter());
        NestedScrollView nestedScrollView = this.nsv_main;
        if (nestedScrollView == null) {
            return true;
        }
        nestedScrollView.m2444b(0, 0);
        return true;
    }


    public  void m5070c(ShopFilter shopFilter, View view) {
        shopFilter.isDiscounted = false;
        this.f9472v0.setValue(shopFilter);
    }


    public  void m5071d(ShopFilter shopFilter, View view) {
        shopFilter.brand = null;
        this.f9472v0.setValue(shopFilter);
    }


    public  void m5072e(ShopFilter shopFilter, View view) {
        shopFilter.vendor = null;
        this.f9472v0.setValue(shopFilter);
    }

    /* renamed from: f */
    public  void m5073f(ShopFilter shopFilter, View view) {
        shopFilter.currency = null;
        this.f9472v0.setValue(shopFilter);
    }

    /* renamed from: g */
    public  void m5074g(ShopFilter shopFilter, View view) {
        shopFilter.minPrice = 0.0f;
        shopFilter.maxPrice = 0.0f;
        this.f9472v0.setValue(shopFilter);
    }

    
    public void m5075k(View view) {
        float f2;
        List<Category> list;
        List<Category> list2;
        if (view == null) {
            return;
        }
        if (this.nsv_main != null && (list2 = this.categoryList) != null && list2.size() > 0) {
            f2 = this.f9462M0.getMeasuredHeight();
        } else {
            if (this.xRecyclerView != null && (list = this.categoryList) != null && list.size() > 0) {
                int measuredHeight = this.f9462M0.getMeasuredHeight();
                view.setTranslationY(measuredHeight);
                this.xRecyclerView.addOnScrollListener(new f(this, measuredHeight, view));
                return;
            }
            f2 = 0.0f;
        }
        view.setTranslationY(f2);
    }


    public  void m5062a(final ActionLink actionLink, View view) {
        if (this.f9464O0) {
            return;
        }
        final java.lang.String[] strArr = this.f9459J0.equals("monthly") ? Status.f8825p : Status.f8824o;
        java.lang.String[] strArr2 = new java.lang.String[strArr.length];
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = Util.getIdentifier(this.baseActivity, strArr[i], "");
            if (!this.f9473w0.equals(strArr[i])) {
                iArr[i] = 0;
            } else if (this.f9474x0.equals("asc")) {
                iArr[i] = R.drawable.ic_arrow_up;
            } else {
                iArr[i] = R.drawable.ic_arrow_down;
            }
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, strArr2, iArr);
        this.f9464O0 = true;
        baseDialog2.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.b.c.w
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                FragmentSalesProduct.this.m5066a(strArr, actionLink, baseDialog2, view2, i2);
            }
        };
        baseDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.c.a0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FragmentSalesProduct.this.m5060a(dialogInterface);
            }
        });
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k, androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        java.lang.String string;
        CoordinatorLayout coordinatorLayout;
        List<Category> list;
        List<Category> list2;
        if (!this.f9459J0.equals("monthly")) {
            SharedPreferences sharedPreferences = UserVM.sharedPreferences;
            if (sharedPreferences != null && this.f9456G0) {
                this.f9473w0 = sharedPreferences.getString("orderby", Status.f8824o[0]);
                string = UserVM.sharedPreferences.getString("orderway", Status.f8826q[0]);
            }
            coordinatorLayout = (CoordinatorLayout) super.onCreateView(layoutInflater, viewGroup, bundle);
            list = this.categoryList;
            if (list == null && list.size() > 0) {
                this.f9462M0 = new RecyclerViewEx(this.baseActivity);
                this.f9461L0 = new RecyclerViewEx.MyAdapter(this.baseActivity);
                this.f9462M0.setLayoutManager(new LinearLayoutManager(0, false));
                this.f9462M0.setBackgroundColor(getResources().getColor(R.color.white));
                this.f9462M0.setUpWithAdapter(this.f9461L0);
                this.f9462M0.setId(R.id.rtl_sub_categories);
                RecyclerViewEx.MyAdapter myAdapterVar = this.f9461L0;
                myAdapterVar.f8559o = new BaseInterface2() { // from class: b.f.a.g.b.c.z
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

                    public final boolean mo4808a(int i, java.lang.String str, int i2) {
                        return FragmentSalesProduct.this.m5069b(i, str, i2);
                    }
                };
                myAdapterVar.arrayList.clear();
                myAdapterVar.notifyDataSetChanged();
                for (Category category : this.categoryList) {
                    if (this.f9467q0 != 0 || (list2 = category.children) == null || list2.size() <= 0 || (this.f9457H0 && (this.f9465o0.getValue() == null || this.f9465o0.getValue().intValue() != category.f12393id))) {
                        if (this.f9465o0.getValue() != null && category.f12393id == this.f9465o0.getValue().intValue()) {
                            RecyclerViewEx.MyAdapter myAdapterVar2 = this.f9461L0;
                            myAdapterVar2.f8558n = myAdapterVar2.getItemCount();
                            this.f9462M0.setCurrentItem(this.f9461L0.getItemCount());
                        }
                        this.f9461L0.add(category.name);
                    } else {
                        this.f9461L0.add( getResources().getString(R.string.all_products));
                    }
                }
                this.f9461L0.notifyDataSetChanged();
                LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.baseActivity);
                linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
                linearLayoutCompat.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                View view = new View(this.baseActivity);
                if (!SimpleVM.f8836d) {
                    view.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, Util.dp2px((Context) this.baseActivity, 1) / 2));
                    view.setBackgroundColor(getResources().getColor(R.color.border));
                    view.setId(R.id.fragment_tab_border);
                }
                linearLayoutCompat.addView(this.f9462M0);
                if (!SimpleVM.f8836d) {
                    linearLayoutCompat.addView(view);
                }
                linearLayoutCompat.addView(coordinatorLayout);
                if (!SimpleVM.f8836d || this.f9148l0) {
                    return linearLayoutCompat;
                }
                this.nsv_main = new NestedScrollView(this.baseActivity);
                this.nsv_main.setTag(Integer.valueOf(R.id.nsv_main));
                this.nsv_main.addView(linearLayoutCompat);
            } else if (!SimpleVM.f8836d && !this.f9148l0) {
                this.nsv_main = new NestedScrollView(this.baseActivity);
                this.nsv_main.addView(coordinatorLayout);
            }
            return this.nsv_main;
        }
        this.f9473w0 = Status.f8825p[0];
        string = Status.f8826q[0];
        this.f9474x0 = string;
        coordinatorLayout = (CoordinatorLayout) super.onCreateView(layoutInflater, viewGroup, bundle);
        list = this.categoryList;
        if (list == null) {
        }
        return !SimpleVM.f8836d ? coordinatorLayout : coordinatorLayout;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        List list;
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str2.equals("get_products")) {
            m4889U0();
            try {
                JSONObject jSONObject = new JSONObject(str);
                List list2 = (List) new Gson().fromJson(jSONObject.getString("data"), new TypeToken<List<Product>>(){}.getType());
                this.f9138b0 = jSONObject.getInt("total");
                if (this.f9459J0.equals("wishlist")) {
                    list = new ArrayList();
                    List<Integer> getValue = ProductVendorVM.f10376d.getValue();
                    if (list2.size() != 0 && getValue != null && getValue.size() != 0) {
                        for (int i2 = 0; i2 < getValue.size(); i2++) {
                            for (int i3 = 0; i3 < list2.size(); i3++) {
                                if (((Product) list2.get(i3)).f12407id == getValue.get(i2).intValue()) {
                                    list.add(list2.get(i3));
                                }
                            }
                        }
                    }
                } else {
                    list = list2;
                }
                if (this.f9455F0 > 0 && this.f9455F0 <= this.f9138b0) {
                    this.f9138b0 = this.f9455F0;
                }
                this.f9476z0.f7590g = this.f9137a0;
                if (!SimpleVM.f8836d || this.f9148l0) {
                    if (this.f9137a0 == 0) {
                        this.f9476z0.addAll(list);
                    } else if (this.f9458I0) {
                        this.f9476z0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                    } else {
                        this.f9476z0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                    }
                    if (list.size() == 0) {
                        this.xRecyclerView.setNoMore(true);
                    }
                } else {
                    m4892X0();
                    this.f9476z0.addAll(list);
                }
            } catch (Exception e2) {
                CustomString.m3173a(str2, ": Gson Exception is ", e2);
                Util.toast(this.baseActivity, R.string.server_failed, "error");
                this.baseActivity.finish();
            }
        }
        if (str2.equals("get_vendor_info")) {
            try {
                this.baseActivity.m4297a(((Vendor) new Gson().fromJson(str, new TypeToken<Vendor>(){}.getType())).name);
            } catch (Exception e3) {
                CustomString.m3173a(str2, ": Gson Exception is ", e3);
                Util.toast(this.baseActivity, R.string.server_failed, "error");
                this.baseActivity.finish();
            }
        }
        if (str2.equals("get_filter_data")) {
            try {
                this.shopCategoryFilter = (ShopCategoryFilter) new Gson().fromJson(str, new TypeToken<ShopCategoryFilter>(){}.getType());
            } catch (Exception e4) {
                e4.printStackTrace();
                this.shopCategoryFilter = new ShopCategoryFilter();
            }
            if (((java.lang.String) Objects.requireNonNull(this.f9466p0.getValue())).split(",").length <= 2) {
                this.shopCategoryFilter.attributes = new ArrayList();
                this.shopCategoryFilter.vendors = new ArrayList();
                this.shopCategoryFilter.attributes = new ArrayList();
            }
            DialogShopCategoryFilter dialogC2184e3 = this.dialogShopCategoryFilter;
            if (dialogC2184e3 != null) {
                dialogC2184e3.f8929B = this.shopCategoryFilter;
                if (dialogC2184e3.isShowing()) {
                    this.dialogShopCategoryFilter.m4818j();
                }
            }
        }
        if (str2.equals("get_sale_products")) {
            m4889U0();
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                List<T> list3 = (List) new Gson().fromJson(jSONObject2.getString("data"), new TypeToken<List<Product>>(){}.getType());
                this.f9138b0 = jSONObject2.getInt("total");
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    ((Product) it.next()).respondTime = new Date().getTime();
                }
                if (this.f9137a0 == 0) {
                    ProductAdapter c1879s = this.f9476z0;
                    c1879s.arrayList = list3;
                    c1879s.notifyDataSetChanged();
                } else if (this.f9458I0) {
                    this.f9476z0.addModList((List) list3, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9476z0.addModList((List) list3, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list3.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9476z0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            } catch (Exception e5) {
                CustomString.m3173a(str2, ": Gson Exception is ", e5);
                Util.toast(this.baseActivity, R.string.server_failed, "error");
                this.baseActivity.finish();
            }
        }
        if (str2.equals("get_collection_products")) {
            m4889U0();
            try {
                JSONObject jSONObject3 = new JSONObject(str);
                if (jSONObject3.has("isEnabled")) {
                    this.f9463N0 = jSONObject3.getBoolean("isEnabled");
                }
                List arrayList = new ArrayList();
                if (this.f9463N0) {
                    arrayList = (List) new Gson().fromJson(jSONObject3.getString("data"), new TypeToken<List<Product>>(){}.getType());
                    this.f9138b0 = jSONObject3.getInt("total");
                } else {
                    this.f9138b0 = 0;
                }
                if (this.f9455F0 > 0 && this.f9455F0 <= this.f9138b0) {
                    this.f9138b0 = this.f9455F0;
                }
                if (jSONObject3.has("name")) {
                    this.baseActivity.m4297a(jSONObject3.getString("name"));
                }
                this.f9476z0.f7590g = this.f9137a0;
                if (SimpleVM.f8836d && !this.f9148l0) {
                    m4892X0();
                    this.f9476z0.addAll(arrayList);
                    return;
                }
                if (this.f9137a0 == 0) {
                    this.f9476z0.addAll(arrayList);
                } else if (this.f9458I0) {
                    this.f9476z0.addModList(arrayList, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9476z0.addModList(arrayList, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (arrayList.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
            } catch (Exception e6) {
                CustomString.m3173a(str2, ": Gson Exception is ", e6);
                Util.toast(this.baseActivity, R.string.server_failed, "error");
                this.baseActivity.finish();
            }
        }
    }
}
