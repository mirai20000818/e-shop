package com.jeil.emarket.activities.seller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.button.SwitchView;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.viewpager.CircleIndicator;
import com.jeil.emarket.components.viewpager.LoopViewPager;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.listener.product.C1565FDialog;
import com.jeil.emarket.adapters.base.CenterImgRecycler;
import com.jeil.emarket.adapters.shipping.ProductAdapter;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.dialog.ImageDialog3;
import com.jeil.emarket.viewmodel.ProductTotalVM;
import com.jeil.emarket.viewmodel.VendorListVM;


public class VendorProductEditActivity extends BaseActivityForVendor {

    
    public ProductAdapter f11847K;

    /* renamed from: L */
    public ProductDetail f11848L;

    /* renamed from: M */
    public ImageDialog3 f11849M;

    /* renamed from: N */
    public int f11850N = 0;

    /* renamed from: O */
    public PickerObj3 f11851O;

    /* renamed from: P */
    public Date f11852P;

    /* renamed from: com.jeil.emarket.activities.seller.VendorProductEditActivity$a */
    public class C3207a extends TypeToken<ProductDetail> {
        public C3207a(VendorProductEditActivity vendorProductEditActivity) {
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorProductEditActivity$b */
    public class C3208b implements TextWatcher {


        public final  EditForm f11853b;

        public C3208b(VendorProductEditActivity vendorProductEditActivity, EditForm editForm) {
            this.f11853b = editForm;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() > 8) {
                this.f11853b.setText(charSequence.subSequence(0, 8).toString());
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        View findViewById = findViewById(R.id.product_edit_footer);
        ((CustomButton) findViewById.findViewById(R.id.cb_ok)).setText(R.string.save);
        findViewById.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorProductEditActivity.this.m6658u(view);
            }
        });
        findViewById.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorProductEditActivity.this.m6659v(view);
            }
        });
        View findViewById2 = findViewById(R.id.header);
        if (findViewById2 != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById2.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById2.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.VISIBLE);
                materialRippleLayout2.setVisibility(View.GONE);
            }
        }
        findViewById.findViewById(R.id.mrl_delete_button).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorProductEditActivity.this.m6660w(view);
            }
        });
        findViewById(R.id.mrl_date_span).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorProductEditActivity.this.m6661x(view);
            }
        });
    }

    /* renamed from: R */
    public void m6647R() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ll_header);
        MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this);
        materialRippleLayout.setId(R.id.mrl_show_detail);
        materialRippleLayout.setRippleRoundedCorners(20);
        materialRippleLayout.setDefaultRippleAlpha(20);
        materialRippleLayout.setRippleColor(getResources().getColor(R.color.ripple_dark));
        materialRippleLayout.setRippleHover(true);
        materialRippleLayout.setRippleOverlay(true);
        materialRippleLayout.setPadding(Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 7));
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        appCompatImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_eye));
        appCompatImageView.setImageTintList(ColorStateList.valueOf(getResources().getColor(BaseActivity.color)));
        appCompatImageView.setPadding(Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4));
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(Util.dp2px((Context) this, 30), Util.dp2px((Context) this, 30)));
        materialRippleLayout.addView(appCompatImageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.rightMargin = Util.dp2px((Context) this, 4);
        layoutParams.addRule(15);
        layoutParams.addRule(21);
        relativeLayout.addView(materialRippleLayout, layoutParams);
        findViewById(R.id.mrl_show_detail).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorProductEditActivity.this.m6657t(view);
            }
        });
    }

    /* renamed from: S */
    public  void m6648S() {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(this.f11848L.data.f12407id));
            jSONObject.put("productIds", arrayList);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ProductTotalVM.m5481f(this, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        ProductTotalVM.f10239g.observe(this, new Observer() { // from class: b.f.a.a.i.e1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorProductEditActivity.this.m6655b(dialogC2001j, (Integer) obj);
            }
        });
    }

    /* renamed from: T */
    public  void m6649T() {
        findViewById(R.id.llc_shimmer).setVisibility(View.GONE);
        findViewById(R.id.llc_main).setVisibility(View.VISIBLE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x013b, code lost:
    
        if (r1.equals(((com.jeil.emarket.model.customer.Product) r18.f11847K.f7123e.get(0)).sku) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0223, code lost:
    
        if (r3 != 0) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04ee  */
    /* renamed from: U */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6650U() {
        /*
            Method dump skipped, instructions count: 1466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.activities.seller.VendorProductEditActivity.m6650U():void");
    }


    public  void m6652a(ImageView imageView) {
        this.f11849M.m4882a(0);
        ImageDialog3 dialogC2269y2 = this.f11849M;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }


    public  void m6654a(Date date, View view) {
        this.f11852P = date;
        ((TextView) findViewById(R.id.tv_date)).setText(Util.date2Str(date));
    }


    public  void m6655b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            setResult(-1, new Intent(this, MainActivityForVendor.class));
            finish();
        }
    }


    public  void m6656c(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            setResult(-1, new Intent(this, MainActivityForVendor.class));
            finish();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_product_edit);
        m4307e(R.string.edit_product);
        m6647R();
        if (getIntent() != null) {
            Bundle bundle2 = (Bundle) Objects.requireNonNull(getIntent().getExtras());
            ProductTotalVM.m5473c(this, bundle2.getInt("productId"));
            java.lang.String string = bundle2.getString("status");
            if (string == null || string.equals("trash")) {
                findViewById(R.id.mrl_delete_button).setVisibility(View.GONE);
            } else {
                findViewById(R.id.mrl_delete_button).setVisibility(View.VISIBLE);
            }
        }
        if (VendorListVM.f10363d.getValue() != null) {
            this.f11850N = VendorListVM.f10363d.getValue().stockThreshold;
        }
        ProductTotalVM.f10236d.observe(this, new Observer() { // from class: b.f.a.a.i.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorProductEditActivity.this.m6653a((ProductDetail) obj);
            }
        });
        mo4284G();
        findViewById(R.id.header_border).setVisibility(View.GONE);
        findViewById(R.id.vp_images).getLayoutParams().height = BaseActivity.anInt - m4299b(50);
        findViewById(R.id.vp_shimmer_images).getLayoutParams().height = BaseActivity.anInt - m4299b(50);
        this.f11851O = new PickerObj3(this, true);
        this.f11851O.f8619c = new InterfaceC2115g() { // from class: b.f.a.a.i.l1
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

            public final void mo4267a(Date date, View view) {
                VendorProductEditActivity.this.m6654a(date, view);
            }
        };
    }

    /* renamed from: t */
    public  void m6657t(View view) {
        ProductDetail productDetail = this.f11848L;
        if (productDetail == null || productDetail.data.f12407id == 0) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), VendorProductActivity.class);
        intent.putExtra("id", this.f11848L.data.f12407id);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    /* renamed from: u */
    public  void m6658u(View view) {
        onBackPressed();
    }

    /* renamed from: v */
    public  void m6659v(View view) {
        try {
            m6650U();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: w */
    public  void m6660w(View view) {
        DialogError dialogError = new DialogError(this);
        dialogError.f8246v = java.lang.String.format(getResources().getString(R.string.trash_product_warning), this.f11848L.data.name);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new C1565FDialog(), new DialogInterface() { // from class: b.f.a.a.i.a1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                VendorProductEditActivity.this.m6648S();
            }
        });
    }

    /* renamed from: x */
    public  void m6661x(View view) {
        this.f11851O.m4710a();
    }


    public  void m6651a(int i, ImageView imageView) {
        this.f11849M.m4882a(i);
        ImageDialog3 dialogC2269y2 = this.f11849M;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }

    @SuppressLint({"SetTextI18n"})

    public final void m6653a(ProductDetail productDetail) {
        try {
            this.f11848L = (ProductDetail) new Gson().fromJson(new Gson().toJson(productDetail), new C3207a(this).getType());
        } catch (Exception e2) {
            e2.getLocalizedMessage();
        }
        ((TextView) findViewById(R.id.tv_title)).setText(productDetail.data.name);
        TextView textView = (TextView) findViewById(R.id.tv_reviews);
        StringBuilder m3163a = CustomString.format("(");
        m3163a.append(productDetail.data.ratingCount);
        m3163a.append(getString(R.string.cnt_reviews));
        m3163a.append(")");
        textView.setText(m3163a.toString());
        ((ProgressBar) findViewById(R.id.pb_rating)).setProgress((int) (productDetail.data.ratingAvg * 20.0f));
        ((ProgressBar) findViewById(R.id.pb_rating)).setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.star)));
        ViewPager viewPager = (LoopViewPager) findViewById(R.id.vp_images);
        CenterImgRecycler c1776i = new CenterImgRecycler(this, "xl", true, true);
        ImageDialog3 dialogC2269y2 = this.f11849M;
        if (dialogC2269y2 == null) {
            this.f11849M = new ImageDialog3(this);
        } else {
            dialogC2269y2.m4884f();
        }
        this.f11849M.m4883a(Util.m306b(productDetail.data.image, "xl"));
        c1776i.f7125d.add(new CenterImgRecycler.a(productDetail.data.image, new CenterImgRecycler.b() { // from class: b.f.a.a.i.k1
            @Override // p078b.p159f.p160a.p178b.p180b.C1776i.b

            public final void mo4370a(ImageView imageView) {
                VendorProductEditActivity.this.m6652a(imageView);
            }
        }));
        c1776i.notifyDataSetChanged();
        for (java.lang.String str : productDetail.data.images) {
            this.f11849M.m4883a(Util.m306b(str, "xl"));
            final int getCount = c1776i.getCount();
            c1776i.f7125d.add(new CenterImgRecycler.a(str, new CenterImgRecycler.b() { // from class: b.f.a.a.i.j1
                @Override // p078b.p159f.p160a.p178b.p180b.C1776i.b

                public final void mo4370a(ImageView imageView) {
                    VendorProductEditActivity.this.m6651a(getCount, imageView);
                }
            }));
            c1776i.notifyDataSetChanged();
        }
        c1776i.notifyDataSetChanged();
        viewPager.setAdapter(c1776i);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.ci_images);
        circleIndicator.setViewPager(viewPager);
        if (productDetail.data.images.size() == 0) {
            circleIndicator.setVisibility(View.GONE);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_products);
        recyclerView.setHasFixedSize(true);
        this.f11847K = new ProductAdapter(this, productDetail);
        if (productDetail.data.type.equals("simple")) {
            this.f11847K.add(productDetail.data);
        } else if (productDetail.data.type.equals("variable") && productDetail.data.variableProducts.size() != 0) {
            for (int i = 0; i < productDetail.data.variableProducts.size(); i++) {
                productDetail.data.variableProducts.get(i).product.customMatch = productDetail.data.variableProducts.get(i).customMatch;
                productDetail.data.variableProducts.get(i).product.match = productDetail.data.variableProducts.get(i).match;
                Product product = productDetail.data.variableProducts.get(i).product;
                Product product2 = productDetail.data;
                product.variableAttributes = product2.variableAttributes;
                this.f11847K.add(product2.variableProducts.get(i).product);
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
        recyclerView.setAdapter(this.f11847K);
        ((SwitchView) findViewById(R.id.csv_featured)).setChecked(productDetail.data.isFeatured.equals("yes"));
        EditForm editForm = (EditForm) findViewById(R.id.cef_guarantee);
        editForm.setText(productDetail.data.guaranteeDays != 0 ? CustomString.m3159a(new StringBuilder(), productDetail.data.guaranteeDays, "") : "");
        editForm.setEditListener(new C3208b(this, editForm));
        java.lang.String str2 = productDetail.data.priceNo;
        if (str2 != null && !str2.isEmpty()) {
            ((EditForm) findViewById(R.id.ef_price_no)).setText(productDetail.data.priceNo);
        }
        java.lang.String str3 = productDetail.data.priceApprovedNo;
        if (str3 != null && !str3.isEmpty()) {
            ((EditForm) findViewById(R.id.cef_approved_no)).setText(productDetail.data.priceApprovedNo);
        }
        if (productDetail.data.priceApprovedAt != null) {
            ((TextView) findViewById(R.id.tv_date)).setText(Util.date2Str(productDetail.data.priceApprovedAt));
            this.f11852P = productDetail.data.priceApprovedAt;
            this.f11851O.m4714b(this.f11852P);
        }
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.i.b1
            @Override // java.lang.Runnable
            public final void run() {
                VendorProductEditActivity.this.m6649T();
            }
        }, 300L);
    }
}
