package com.jeil.emarket.activities.seller.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.seller.VendorOrderEditActivity;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.OrderItem;
import com.jeil.emarket.model.vendor.FBT;
import com.jeil.emarket.model.vendor.Product;
import java.util.ArrayList;
import java.util.List;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.shipping.ProductAdapter2;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.viewmodel.VendorListVM;
import com.jeil.emarket.viewmodel.CategoryVM;


public class ProductChooseSaleActivity extends BaseActivityForVendor {

    /* renamed from: O */
    public ProductAdapter2 f11899O;

    /* renamed from: Q */
    public Category f11901Q;

    /* renamed from: R */
    public String f11902R;

    
    public List<Product> f11895K = new ArrayList();

    /* renamed from: L */
    public List<FBT.Product> f11896L = new ArrayList();

    /* renamed from: M */
    public List<OrderItem> f11897M = new ArrayList();

    /* renamed from: N */
    public ArrayList<Integer> f11898N = new ArrayList<>();

    /* renamed from: P */
    public List<TextView> f11900P = new ArrayList();

    /* renamed from: com.jeil.emarket.activities.seller.product.ProductChooseSaleActivity$a */
    public class C3218a extends TypeToken<List<FBT.Product>> {
        public C3218a(ProductChooseSaleActivity productChooseSaleActivity) {
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.product.ProductChooseSaleActivity$b */
    public class C3219b extends TypeToken<List<OrderItem>> {
        public C3219b(ProductChooseSaleActivity productChooseSaleActivity) {
        }
    }

    
    public static  void m6710a(View view, View view2, int i, int i2, int i3, int i4) {
        if (view2.canScrollHorizontally(-1)) {
            view.findViewById(R.id.ll_left_gradient).setVisibility(View.VISIBLE);
        } else {
            view.findViewById(R.id.ll_left_gradient).setVisibility(View.GONE);
        }
        boolean canScrollHorizontally = view2.canScrollHorizontally(1);
        View findViewById = view.findViewById(R.id.ll_right_gradient);
        if (canScrollHorizontally) {
            findViewById.setVisibility(View.VISIBLE);
        } else {
            findViewById.setVisibility(View.GONE);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        View findViewById = findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.VISIBLE);
                materialRippleLayout2.setVisibility(View.GONE);
            }
        }
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductChooseSaleActivity.this.m6718t(view);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductChooseSaleActivity.this.m6719u(view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: R */
    public void m6712R() {
        this.f11899O = new ProductAdapter2(this);
        this.f11899O.addAll((List) this.f11895K);
        XRecyclerView xRecyclerView = (XRecyclerView) findViewById(R.id.rv_select_items);
        int i = 0;
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
        xRecyclerView.setAdapter(this.f11899O);
        xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, false, false));
        xRecyclerView.setNoMore(false);
        final View inflate = getLayoutInflater().inflate(R.layout.layout_choose_sale_products, (ViewGroup) null);
        int i2 = -2;
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2, 1.0f);
        int i3 = BaseActivity.anInt2;
        c0541a.setMargins(i3, 0, i3, 0);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_search);
        if (Build.VERSION.SDK_INT >= 26) {
            editForm.setFocusedByDefault(false);
        }
        editForm.setPlaceHolder(getResources().getString(R.string.sale_product_notice));
        editForm.setInputType(1);
        editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductChooseSaleActivity.this.m6717d(editForm, view);
            }
        });
        editForm.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.a.i.v2.r
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(android.widget.TextView textView, int i4, KeyEvent keyEvent) {
                return ProductChooseSaleActivity.this.m6715a(editForm, textView, i4, keyEvent);
            }
        });
        if (this.f11902R.equals("sale")) {
            final ArrayList arrayList = new ArrayList();
            List<Category> getValue = CategoryVM.listMutableLiveData.getValue();
            int[] iArr = new int[0];
            if (VendorListVM.f10363d.getValue() != null && VendorListVM.f10363d.getValue().categories != null) {
                iArr = VendorListVM.f10363d.getValue().categories;
            }
            if (getValue != null) {
                Category category = new Category();
                category.f12393id = 0;
                category.name = getResources().getString(R.string.all);
                arrayList.add(category);
                if (iArr.length != 0) {
                    for (int i4 : iArr) {
                        for (int i5 = 0; i5 < getValue.size(); i5++) {
                            if (getValue.get(i5).f12393id == i4) {
                                Category category2 = new Category();
                                category2.f12393id = i4;
                                category2.name = getValue.get(i5).name;
                                arrayList.add(category2);
                            }
                        }
                    }
                }
                int i6 = 0;
                while (i6 < arrayList.size()) {
                    LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
                    LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(i2, i2);
                    c0541a2.setMargins(Util.dp2px((Context) this, 3), BaseActivity.anInt2, Util.dp2px((Context) this, 3), i);
                    final com.jeil.emarket.components.textview.TextView textView = new com.jeil.emarket.components.textview.TextView(this);
                    if (i6 == 0) {
                        Util.m310b((Context) this, (View) textView);
                    } else {
                        Util.m310b((Context) this, (View) textView);
                    }
                    textView.setText(((Category) arrayList.get(i6)).name);
                    textView.setPadding(Util.dp2px((Context) this, 13), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 13), Util.dp2px((Context) this, 7));
                    final int i7 = i6;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.p
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ProductChooseSaleActivity.this.m6713a(i7, arrayList, textView, inflate, view);
                        }
                    });
                    linearLayoutCompat.addView(textView, c0541a2);
                    ((LinearLayoutCompat) inflate.findViewById(R.id.llc_categories)).addView(linearLayoutCompat);
                    this.f11900P.add(textView);
                    i6++;
                    i = 0;
                    i2 = -2;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    inflate.findViewById(R.id.hsv_categories).setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: b.f.a.a.i.v2.m
                        @Override // android.view.View.OnScrollChangeListener
                        public final void onScrollChange(View view, int i8, int i9, int i10, int i11) {
                            ProductChooseSaleActivity.m6710a(inflate, view, i8, i9, i10, i11);
                        }
                    });
                }
            }
        }
        inflate.setLayoutParams(c0541a);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.i.v2.n
            @Override // java.lang.Runnable
            public final void run() {
                editForm.setVisibility(View.VISIBLE);
            }
        }, 80L);
        xRecyclerView.addView(inflate);
        View inflate2 = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
        inflate2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ((AppCompatImageView) inflate2.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_products);
        ((com.jeil.emarket.components.textview.TextView) inflate2.findViewById(R.id.tv_empty_title)).setText(R.string.empty_shop);
        xRecyclerView.setEmptyView(inflate2);
        xRecyclerView.header = findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
    }

    
    public void m6714a(Category category) {
        Category category2 = this.f11901Q;
        this.f11901Q = (category2 == null || category2.f12393id != category.f12393id) ? category : null;
        if (this.f11901Q == null || category.f12393id == 0) {
            this.f11899O.addAll((List) this.f11895K);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f11895K.size(); i++) {
            Product product = this.f11895K.get(i);
            if (product.categoryId == this.f11901Q.f12393id) {
                arrayList.add(product);
            }
        }
        ProductAdapter2 c1952p1 = this.f11899O;
        c1952p1.arrayList = arrayList;
        c1952p1.notifyDataSetChanged();
    }

    
    public  boolean m6715a(EditForm editForm, android.widget.TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m6716b(editForm.getText());
        return true;
    }

    
    public final void m6716b(String str) {
        if (str.isEmpty()) {
            this.f11899O.addAll((List) this.f11895K);
            return;
        }
        ArrayList arrayList = new ArrayList();
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < this.f11895K.size(); i++) {
            Product product = this.f11895K.get(i);
            if (product.name.toLowerCase().contains(lowerCase) || String.valueOf(product.productId).toLowerCase().contains(lowerCase) || String.valueOf(product.sku).toLowerCase().contains(lowerCase)) {
                arrayList.add(product);
            }
        }
        ProductAdapter2 c1952p1 = this.f11899O;
        c1952p1.arrayList = arrayList;
        c1952p1.notifyDataSetChanged();
    }

    
    public  void m6717d(EditForm editForm, View view) {
        m6716b(editForm.getText());
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_choose_sale_products);
        if (getIntent().getExtras() != null) {
            this.f11898N = getIntent().getExtras().getIntegerArrayList("ids");
            this.f11896L = (List) new Gson().fromJson(getIntent().getStringExtra("products"), new C3218a(this).getType());
            this.f11897M = (List) new Gson().fromJson(getIntent().getStringExtra("items"), new C3219b(this).getType());
            this.f11902R = getIntent().getStringExtra("page");
            if (this.f11898N == null) {
                this.f11898N = new ArrayList<>();
            }
            if (this.f11896L == null) {
                this.f11896L = new ArrayList();
            }
            if (this.f11897M == null) {
                this.f11897M = new ArrayList();
            }
        }
        m4307e(this.f11902R.equals("sale") ? R.string.add_sale_product : R.string.add_product);
        this.f11895K = ((this.f11902R.equals("products") || this.f11902R.equals("sale")) ? VendorListVM.f10368i : VendorListVM.f10367h).getValue();
        if (this.f11895K != null) {
            m6712R();
        }
        addBottomNav(0);
        mo4284G();
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    /* renamed from: t */
    public  void m6718t(View view) {
        finish();
    }

    /* renamed from: u */
    public  void m6719u(View view) {
        char c2;
        Intent intent;
        String json;
        String str;
        String str2 = this.f11902R;
        int hashCode = str2.hashCode();
        if (hashCode != 3522631) {
            if (hashCode == 1187338559 && str2.equals("orderDetail")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str2.equals("sale")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                intent = new Intent(this, FBTEditActivity.class);
                json = new Gson().toJson(this.f11896L);
                str = "products";
            } else {
                intent = new Intent(this, VendorOrderEditActivity.class);
                json = new Gson().toJson(this.f11897M);
                str = "items";
            }
            intent.putExtra(str, json);
            intent.putExtra("page", this.f11902R);
        } else {
            intent = new Intent(this, ProductSaleActivity.class);
            intent.putIntegerArrayListExtra("ids", this.f11898N);
        }
        setResult(1, intent);
        finish();
    }

    
    public  void m6713a(int i, List list, com.jeil.emarket.components.textview.TextView textView, View view, View view2) {
        for (int i2 = 0; i2 < this.f11900P.size(); i2++) {
            if (i2 != i) {
                Util.m310b((Context) this, (View) this.f11900P.get(i2));
            }
        }
        Category category = this.f11901Q;
        if (category != null && category.f12393id == ((Category) list.get(i)).f12393id) {
            Util.m310b((Context) this, (View) textView);
            textView = (com.jeil.emarket.components.textview.TextView) this.f11900P.get(0);
        }
       // Util.m233a((Context) this, (View) textView);
        ((EditForm) view.findViewById(R.id.cef_search)).setText("");
        m6714a((Category) list.get(i));
    }
}
