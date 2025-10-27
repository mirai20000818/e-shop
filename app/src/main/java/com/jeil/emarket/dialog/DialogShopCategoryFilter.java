package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.button.SwitchView;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.product.ShopAttributes;
import com.jeil.emarket.model.customer.ShopCategoryFilter;
import com.jeil.emarket.model.customer.ShopFilter;
import java.util.List;
import java.util.Objects;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.fbt.ProductAdapter1;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;
import com.jeil.emarket.components.itemdecor.ItemDecoration1;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.interf.BaseInterface;

/* renamed from: b.f.a.f.e3 */

public class DialogShopCategoryFilter extends BaseAniDialog<DialogShopCategoryFilter> implements BaseInterface, BaseInterface2 {


    public View f8928A;


    public ShopCategoryFilter f8929B;


    public ProductAdapter1<ShopCategoryFilter.Brand> f8930C;


    public ProductAdapter1<ShopCategoryFilter.Vendor> f8931D;


    public ShopAttributes f8932E;

    /* renamed from: F */
    public boolean f8933F;

    /* renamed from: G */
    public String f8934G;

    /* renamed from: H */
    public boolean f8935H;

    /* renamed from: y */
    public ShopFilter f8936y;

    /* renamed from: z */
    public BaseActivity f8937z;

    /* renamed from: b.f.a.f.e3$a */
    public class a extends TypeToken<ShopCategoryFilter> {
        public a(DialogShopCategoryFilter dialogC2184e3) {
        }
    }

    public DialogShopCategoryFilter(BaseActivity activityC1391g1, ShopFilter shopFilter, ShopCategoryFilter shopCategoryFilter) {
        super(activityC1391g1, 8388613);
        this.f8933F = false;
        this.f8934G = "";
        this.f8935H = false;
        this.f8937z = activityC1391g1;
        this.f8936y = shopFilter;
        this.f8929B = shopCategoryFilter;
    }


    public static  void m4804a(ButtonToggle buttonToggle, ButtonToggle buttonToggle2, View view) {
        if (buttonToggle.f12185G) {
            buttonToggle.m6897e();
        } else {
            buttonToggle.m6896d();
            buttonToggle2.m6897e();
        }
    }


    public static  void m4805b(ButtonToggle buttonToggle, ButtonToggle buttonToggle2, View view) {
        if (buttonToggle.f12185G) {
            buttonToggle.m6897e();
        } else {
            buttonToggle.m6896d();
            buttonToggle2.m6897e();
        }
    }


    public  void m4806a(ActionLink actionLink, View view) {
        float f;
        if (Objects.equals(this.f8930C.booleanMutableLiveData.getValue(), true)) {
            this.f8930C.m4495d();
            f = 0.0f;
        } else {
            this.f8930C.m4496e();
            f = 180.0f;
        }
        actionLink.setImageFlip(f);
    }


    public  void m4807a(SwitchView switchView, boolean z) {
        this.f8936y.isInStock = z;
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(String str, String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_filter_data")) {
            return;
        }
        try {
            this.f8929B = (ShopCategoryFilter) new Gson().fromJson(str, new a(this).getType());
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
        m4817i();
        m4820l();
        m4819k();
        m4821m();
        m4815g();
        m4816h();
        m4814f();
        float f = this.f8929B.maxPrice;
        if (f > 0.0f) {
            float f2 = this.f8936y.maxPrice;
            if (f2 <= 0.0f || f2 > f) {
                this.f8936y.availableMaxPrice = (int) this.f8929B.maxPrice;
            }
        }
        this.f8928A.findViewById(R.id.nsv_main).setVisibility(View.VISIBLE);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, String str, int i2) {
        if (str.equals("brand")) {
            if (i == -1) {
                this.f8936y.brand = null;
                return true;
            }
            this.f8936y.brand = this.f8929B.brands.get(i);
            return true;
        }
        if (!str.equals("vendor")) {
            return true;
        }
        if (i == -1) {
            this.f8936y.vendor = null;
            return true;
        }
        this.f8936y.vendor = this.f8929B.vendors.get(i);
        return true;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        this.f8928A = View.inflate(this.f8937z, R.layout.dialog_shop_filter, null);
        this.f8263n = this.f8928A;
        ShopCategoryFilter shopCategoryFilter = this.f8929B;
        if (shopCategoryFilter == null) {
            this.f8929B = new ShopCategoryFilter();
            this.f8929B.maxPrice = 3.4028236E36f;
        } else {
            if (shopCategoryFilter.maxPrice == 0.0f) {
                shopCategoryFilter.maxPrice = 3.4028236E36f;
            }
            m4818j();
        }
        m4821m();
        return this.f8928A;
    }


    public  void m4809b(ActionLink actionLink, View view) {
        float f;
        if (Objects.equals(this.f8931D.booleanMutableLiveData.getValue(), true)) {
            this.f8931D.m4495d();
            f = 0.0f;
        } else {
            this.f8931D.m4496e();
            f = 180.0f;
        }
        actionLink.setImageFlip(f);
    }


    public  void m4810b(SwitchView switchView, boolean z) {
        this.f8936y.isFeatured = z;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
        View view = this.f8928A;
        if (view != null) {
            view.scrollTo(0, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m4811c(android.view.View r6) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p230f.DialogC2184e3.m4811c(android.view.View):void");
    }


    public  void m4812c(SwitchView switchView, boolean z) {
        this.f8936y.isDiscounted = z;
    }


    public  void m4813d(View view) {
        ShopFilter shopFilter = this.f8936y;
        shopFilter.brand = null;
        shopFilter.vendor = null;
        this.f8932E.m6959h();
        ShopFilter shopFilter2 = this.f8936y;
        shopFilter2.currency = null;
        shopFilter2.maxPrice = 0.0f;
        shopFilter2.minPrice = 0.0f;
        shopFilter2.isInStock = false;
        shopFilter2.isFeatured = false;
        shopFilter2.isDiscounted = false;
        m4822n();
    }

    /* renamed from: f */
    public final void m4814f() {
        View findViewById;
        int i;
        List<ShopCategoryFilter.Attribute> list;
        this.f8932E = (ShopAttributes) this.f8928A.findViewById(R.id.sa_attributes);
        ShopCategoryFilter shopCategoryFilter = this.f8929B;
        if (shopCategoryFilter == null || (list = shopCategoryFilter.attributes) == null || list.size() <= 0) {
            findViewById = this.f8928A.findViewById(R.id.ll_attributes);
            i = 8;
        } else {
            this.f8932E.m6957a(this.f8929B.attributes, this.f8937z);
            findViewById = this.f8928A.findViewById(R.id.ll_attributes);
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    /* renamed from: g */
    public final void m4815g() {
        View findViewById;
        int i;
        List<ShopCategoryFilter.Brand> list;
        ShopCategoryFilter shopCategoryFilter = this.f8929B;
        if (shopCategoryFilter == null || (list = shopCategoryFilter.brands) == null || list.size() <= 1) {
            findViewById = this.f8928A.findViewById(R.id.ll_brands);
            i = 8;
        } else {
            this.f8930C.addAll(this.f8929B.brands);
            findViewById = this.f8928A.findViewById(R.id.ll_brands);
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    /* renamed from: h */
    public final void m4816h() {
        View findViewById;
        int i;
        List<ShopCategoryFilter.Vendor> list;
        ShopCategoryFilter shopCategoryFilter = this.f8929B;
        if (shopCategoryFilter == null || (list = shopCategoryFilter.vendors) == null || list.size() <= 0) {
            findViewById = this.f8928A.findViewById(R.id.ll_vendors);
            i = 8;
        } else {
            this.f8931D.addAll(this.f8929B.vendors);
            findViewById = this.f8928A.findViewById(R.id.ll_vendors);
            i = 0;
        }
        findViewById.setVisibility(i);
    }


    public void m4817i() {
        RecyclerView recyclerView = (RecyclerView) this.f8928A.findViewById(R.id.rv_brands);
        recyclerView.setLayoutManager(ChipsLayoutManager.newBuilder(this.f8937z).build());
        recyclerView.addItemDecoration(new ItemDecoration1(m4590a(5.0f)));
        final ActionLink actionLink = (ActionLink) this.f8928A.findViewById(R.id.cal_brands);
        this.f8930C = new ProductAdapter1<>(this.f8937z, recyclerView, 9, this.f8928A.findViewById(R.id.ll_show_brands), this);
        recyclerView.setAdapter(this.f8930C);
        if (actionLink != null) {
            actionLink.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.t1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogShopCategoryFilter.this.m4806a(actionLink, view);
                }
            });
        }
    }

   
    public void m4818j() {
        m4817i();
        m4820l();
        m4819k();
        m4815g();
        m4816h();
        m4814f();
        ShopCategoryFilter shopCategoryFilter = this.f8929B;
        if (shopCategoryFilter != null) {
            float f = shopCategoryFilter.maxPrice;
            if (f > 0.0f) {
                float f2 = this.f8936y.maxPrice;
                if (f2 <= 0.0f || f2 > f) {
                    this.f8936y.availableMaxPrice = (int) this.f8929B.maxPrice;
                }
            }
        }
        this.f8928A.findViewById(R.id.nsv_main).setVisibility(View.VISIBLE);
    }

    @SuppressLint({"DefaultLocale"})
    
    public void m4819k() {
        EditForm editForm = (EditForm) this.f8928A.findViewById(R.id.cef_min_price);
        EditForm editForm2 = (EditForm) this.f8928A.findViewById(R.id.cef_max_price);
        if (this.f8929B == null) {
            this.f8929B = new ShopCategoryFilter();
        }
        if (!this.f8933F || this.f8934G.equals("kpwf")) {
            final ButtonToggle buttonToggle = (ButtonToggle) this.f8928A.findViewById(R.id.cbt_kpf);
            final ButtonToggle buttonToggle2 = (ButtonToggle) this.f8928A.findViewById(R.id.cbt_kpw);
            buttonToggle.m6894a(Util.dp2px((Context) this.f8937z, 13), Util.dp2px((Context) this.f8937z, 13) / 2, Util.dp2px((Context) this.f8937z, 13), Util.dp2px((Context) this.f8937z, 13) / 2);
            buttonToggle2.m6894a(Util.dp2px((Context) this.f8937z, 13), Util.dp2px((Context) this.f8937z, 13) / 2, Util.dp2px((Context) this.f8937z, 13), Util.dp2px((Context) this.f8937z, 13) / 2);
            buttonToggle.m6897e();
            buttonToggle2.m6897e();
            String str = this.f8936y.currency;
            if (str != null) {
                if (str.equals("kpf")) {
                    buttonToggle.m6896d();
                } else if (this.f8936y.currency.equals("kpw")) {
                    buttonToggle2.m6896d();
                }
            }
            buttonToggle.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.s1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogShopCategoryFilter.m4804a(ButtonToggle.this, buttonToggle2, view);
                }
            });
            buttonToggle2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.v1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogShopCategoryFilter.m4805b(ButtonToggle.this, buttonToggle, view);
                }
            });
        } else {
            this.f8928A.findViewById(R.id.ll_currency).setVisibility(View.GONE);
        }
        float f = this.f8936y.minPrice;
        editForm.setText(f > 0.0f ? String.format("%f", Float.valueOf(f)) : "");
        float f2 = this.f8936y.maxPrice;
        if (f2 > 0.0f) {
            editForm2.setText(String.format("%f", Float.valueOf(f2)));
        }
    }

    /* renamed from: l */
    public void m4820l() {
        RecyclerView recyclerView = (RecyclerView) this.f8928A.findViewById(R.id.rv_vendors);
        recyclerView.setLayoutManager(ChipsLayoutManager.newBuilder(this.f8937z).build());
        recyclerView.addItemDecoration(new ItemDecoration1(m4590a(5.0f)));
        final ActionLink actionLink = (ActionLink) this.f8928A.findViewById(R.id.cal_vendors);
        this.f8931D = new ProductAdapter1<>(this.f8937z, recyclerView, 5, this.f8928A.findViewById(R.id.ll_show_vendors), this);
        recyclerView.setAdapter(this.f8931D);
        if (actionLink != null) {
            actionLink.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.u1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogShopCategoryFilter.this.m4809b(actionLink, view);
                }
            });
        }
    }

    /* renamed from: m */
    public void m4821m() {
        if (this.f8936y == null) {
            this.f8936y = new ShopFilter();
        }
        ((SwitchView) this.f8928A.findViewById(R.id.csv_stock)).m6903b(this.f8936y.isInStock);
        ((SwitchView) this.f8928A.findViewById(R.id.csv_featured)).setChecked(this.f8936y.isFeatured);
        ((SwitchView) this.f8928A.findViewById(R.id.csv_discounted)).setChecked(this.f8936y.isDiscounted);
        ((SwitchView) this.f8928A.findViewById(R.id.csv_stock)).setOnCheckedChangeListener(new SwitchView.InterfaceC3247b() { // from class: b.f.a.f.a2
            @Override // com.jeil.emarket.components.button.SwitchView.InterfaceC3247b

            public final void mo4371a(SwitchView switchView, boolean z) {
                DialogShopCategoryFilter.this.m4807a(switchView, z);
            }
        });
        ((SwitchView) this.f8928A.findViewById(R.id.csv_featured)).setOnCheckedChangeListener(new SwitchView.InterfaceC3247b() { // from class: b.f.a.f.z1
            @Override // com.jeil.emarket.components.button.SwitchView.InterfaceC3247b

            public final void mo4371a(SwitchView switchView, boolean z) {
                DialogShopCategoryFilter.this.m4810b(switchView, z);
            }
        });
        ((SwitchView) this.f8928A.findViewById(R.id.csv_discounted)).setOnCheckedChangeListener(new SwitchView.InterfaceC3247b() { // from class: b.f.a.f.y1
            @Override // com.jeil.emarket.components.button.SwitchView.InterfaceC3247b

            public final void mo4371a(SwitchView switchView, boolean z) {
                DialogShopCategoryFilter.this.m4812c(switchView, z);
            }
        });
        this.f8928A.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShopCategoryFilter.this.m4811c(view);
            }
        });
        CustomButton customButton = (CustomButton) this.f8928A.findViewById(R.id.cb_cancel);
        customButton.setText(R.string.reset);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShopCategoryFilter.this.m4813d(view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005b A[LOOP:1: B:53:0x005b->B:57:0x007e, LOOP_START, PHI: r2
  0x005b: PHI (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:52:0x0059, B:57:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4822n() {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p230f.DialogC2184e3.m4822n():void");
    }
}
