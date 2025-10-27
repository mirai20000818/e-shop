package com.jeil.emarket.activities.seller.product;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.FBT;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.shipping.FBTProductAdapter;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.viewmodel.ProductTotalVM;


public class FBTEditActivity extends BaseActivityForVendor implements BaseInterface2 {

    
    public String f11890K;

    /* renamed from: L */
    public int f11891L;

    /* renamed from: M */
    public FBT f11892M = new FBT();

    /* renamed from: N */
    public FBTProductAdapter f11893N;

    /* renamed from: com.jeil.emarket.activities.seller.product.FBTEditActivity$a */
    public class C3216a implements TextWatcher {
        public C3216a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            FBTEditActivity.this.f11892M.name = charSequence.toString();
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.product.FBTEditActivity$b */
    public class C3217b extends TypeToken<List<FBT.Product>> {
        public C3217b(FBTEditActivity fBTEditActivity) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        ((EditForm) findViewById(R.id.ef_name)).setEditListener(new C3216a());
        View findViewById = findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_back);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.VISIBLE);
                materialRippleLayout2.setVisibility(View.GONE);
                materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FBTEditActivity.this.m6705t(view);
                    }
                });
            }
        }
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FBTEditActivity.this.m6706u(view);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FBTEditActivity.this.m6707v(view);
            }
        });
        findViewById(R.id.mrl_delete_button).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FBTEditActivity.this.m6708w(view);
            }
        });
        findViewById(R.id.cal_select_products).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FBTEditActivity.this.m6709x(view);
            }
        });
    }


    public  void m6701a(FBT fbt) {
        if (fbt != null) {
            this.f11892M = fbt;
            m6704b(ProductTotalVM.f10244l.getValue());
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, String str, int i2) {
        if (i2 == 0) {
            FBT fbt = this.f11892M;
            fbt.products = this.f11893N.arrayList;
            fbt.products.remove(i);
            this.f11893N.addAll((List) this.f11892M.products);
        }
        m6704b(this.f11892M);
        return true;
    }


    public  void m6702b(DialogError dialogError) {
        Intent intent = new Intent(getApplicationContext(), FBTActivity.class);
        intent.putExtra("id", this.f11891L);
        setResult(0, intent);
        dialogError.dismiss();
        finish();
    }


    public  void m6703b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() != 0) {
            setResult(-1, new Intent(getApplicationContext(), FBTActivity.class));
            finish();
        }
    }


    public void m6704b(FBT fbt) {
        if (fbt != null) {
            ((EditForm) findViewById(R.id.ef_name)).setText(fbt.name);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_items);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
            this.f11893N = new FBTProductAdapter(this, this, "products");
            recyclerView.setAdapter(this.f11893N);
            List<FBT.Product> list = fbt.products;
            if (list == null || list.size() <= 0) {
                recyclerView.setVisibility(View.GONE);
            } else {
                recyclerView.setVisibility(View.VISIBLE);
                this.f11893N.addAll((List) fbt.products);
            }
        } else if (!this.f11890K.equals("add")) {
            return;
        }
        findViewById(R.id.nsv_shimmer_main).setVisibility(View.GONE);
        findViewById(R.id.nsv_main).setVisibility(View.VISIBLE);
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 != 1 || intent == null) {
            return;
        }
        findViewById(R.id.nsv_shimmer_main).setVisibility(View.VISIBLE);
        findViewById(R.id.nsv_main).setVisibility(View.GONE);
        List list = (List) new Gson().fromJson(intent.getStringExtra("products"), new C3217b(this).getType());
        ArrayList arrayList = new ArrayList();
        List<FBT.Product> list2 = this.f11892M.products;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!this.f11890K.equals("edit") || list2.size() == 0) {
                z = false;
            } else {
                z = false;
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    if (((FBT.Product) list.get(i3)).f12437id == list2.get(i4).f12437id) {
                        arrayList.add(list2.get(i4));
                        z = true;
                    }
                }
            }
            if (!z) {
                FBT.Product product = new FBT.Product();
                product.f12437id = ((FBT.Product) list.get(i3)).f12437id;
                product.name = ((FBT.Product) list.get(i3)).name;
                product.currency = ((FBT.Product) list.get(i3)).currency;
                product.discount = 0.0f;
                product.sku = ((FBT.Product) list.get(i3)).sku;
                product.stock = ((FBT.Product) list.get(i3)).stock;
                product.image = ((FBT.Product) list.get(i3)).image;
                product.price = ((FBT.Product) list.get(i3)).price;
                product.maxPrice = ((FBT.Product) list.get(i3)).maxPrice;
                product.minPrice = ((FBT.Product) list.get(i3)).minPrice;
                arrayList.add(product);
            }
        }
        FBT fbt = this.f11892M;
        fbt.products = arrayList;
        m6704b(fbt);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (m4309v()) {
            return;
        }
        setResult(-1, new Intent(getApplicationContext(), FBTActivity.class));
        finish();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fbt_detail);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f11890K = extras.getString("page");
            this.f11891L = extras.getInt("id");
            if (this.f11890K.equals("edit")) {
                findViewById(R.id.mrl_delete_button).setVisibility(View.VISIBLE);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.fbt_title));
            sb.append(" ");
            boolean equals = this.f11890K.equals("edit");
            int i = R.string.add;
            sb.append(equals ? getResources().getString(R.string.edit) : getResources().getString(R.string.add));
            m4297a(sb.toString());
            CustomButton customButton = (CustomButton) findViewById(R.id.cb_ok);
            Resources resources = getResources();
            if (this.f11890K.equals("edit")) {
                i = R.string.save;
            }
            customButton.setText(resources.getString(i));
        }
        addBottomNav(0);
        mo4284G();
        m6704b(ProductTotalVM.f10244l.getValue());
        ProductTotalVM.f10244l.observe(this, new Observer() { // from class: b.f.a.a.i.v2.j
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FBTEditActivity.this.m6701a((FBT) obj);
            }
        });
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    /* renamed from: t */
    public  void m6705t(View view) {
        onBackPressed();
    }

    /* renamed from: u */
    public  void m6706u(View view) {
        onBackPressed();
    }

    /* renamed from: v */
    public  void m6707v(View view) {
        MutableLiveData<Integer> mutableLiveData;
        Observer<? super Integer> observer;
        EditForm editForm = (EditForm) findViewById(R.id.ef_name);
        String str = this.f11892M.name;
        if (str == null || str.isEmpty()) {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            return;
        }
        editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        List<FBT.Product> list = this.f11892M.products;
        if (list == null || list.size() == 0) {
            Util.toast(this, getResources().getString(R.string.select_fbt_products_warning_notice), "error", 0, 0);
            return;
        }
        if (this.f11890K.equals("edit")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f11892M.f12436id);
                jSONObject.put("name", this.f11892M.name);
                jSONObject.put("products", this.f11892M.products);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ProductTotalVM.m5463a(this, this.f11891L, jSONObject);
            final DialogC2001j dialogC2001j = new DialogC2001j(this);
            dialogC2001j.show();
            mutableLiveData = ProductTotalVM.f10239g;
            observer = new Observer() { // from class: b.f.a.a.i.v2.c
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    dialogC2001j.dismiss();
                }
            };
        } else {
            if (!this.f11890K.equals("add")) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("name", this.f11892M.name);
                jSONObject2.put("products", this.f11892M.products);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            ProductTotalVM.m5465a(this, jSONObject2);
            final DialogC2001j dialogC2001j2 = new DialogC2001j(this);
            dialogC2001j2.show();
            mutableLiveData = ProductTotalVM.f10245m;
            observer = new Observer() { // from class: b.f.a.a.i.v2.i
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    FBTEditActivity.this.m6703b(dialogC2001j2, (Integer) obj);
                }
            };
        }
        mutableLiveData.observe(this, observer);
    }

    /* renamed from: w */
    public  void m6708w(View view) {
        final DialogError dialogError = new DialogError(this);
        dialogError.f8246v = String.format(getResources().getString(R.string.delete_FBT_notice), this.f11892M.name);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new DialogInterface() { // from class: b.f.a.a.i.v2.l
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                dialogError.dismiss();
            }
        }, new DialogInterface() { // from class: b.f.a.a.i.v2.d
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                FBTEditActivity.this.m6702b(dialogError);
            }
        });
    }

    /* renamed from: x */
    public  void m6709x(View view) {
        Intent intent = new Intent(this, ProductChooseSaleActivity.class);
        ArrayList<Integer> arrayList = new ArrayList<>();
        List list = this.f11892M.products;
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(Integer.valueOf(((FBT.Product) list.get(i)).f12437id));
            }
        }
        intent.putIntegerArrayListExtra("ids", arrayList);
        Gson gson = new Gson();
        if (list == null || list.size() == 0) {
            list = new ArrayList();
        }
        intent.putExtra("products", gson.toJson(list));
        intent.putExtra("page", "products");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, 100);
    }
}
