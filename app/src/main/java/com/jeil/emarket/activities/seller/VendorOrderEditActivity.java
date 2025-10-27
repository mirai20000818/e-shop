package com.jeil.emarket.activities.seller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.seller.product.ProductChooseSaleActivity;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.OrderItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.adapters.order.OrderItemAdapter;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.viewmodel.ModelCollection;


public class VendorOrderEditActivity extends BaseActivityForVendor {

    /* renamed from: P */
    public static MutableLiveData<List<OrderItem>> f11837P = new MutableLiveData<>();

    
    public int f11838K;

    /* renamed from: L */
    public List<OrderItem> f11839L;

    /* renamed from: M */
    public OrderItemAdapter f11840M;

    /* renamed from: N */
    public PickerObj3 f11841N;

    /* renamed from: O */
    public Date f11842O;

    /* renamed from: com.jeil.emarket.activities.seller.VendorOrderEditActivity$a */
    public class C3202a extends TypeToken<List<OrderItem>> {
        public C3202a(VendorOrderEditActivity vendorOrderEditActivity) {
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorOrderEditActivity$b */
    public class C3203b extends TypeToken<Date> {
        public C3203b(VendorOrderEditActivity vendorOrderEditActivity) {
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorOrderEditActivity$c */
    public class C3204c implements TextWatcher {


        public final  EditForm f11843b;

        public C3204c(VendorOrderEditActivity vendorOrderEditActivity, EditForm editForm) {
            this.f11843b = editForm;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            float f;
            try {
                f = Float.parseFloat(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
            } catch (Exception unused) {
                this.f11843b.setText("");
                f = 0.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                if (f == 0.0f) {
                    this.f11843b.setText("");
                } else {
                    this.f11843b.setText(f + "");
                }
            }
            if (f > 1.0E7f) {
                this.f11843b.setText("10000000");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorOrderEditActivity$d */
    public class C3205d extends TypeToken<List<OrderItem>> {
        public C3205d(VendorOrderEditActivity vendorOrderEditActivity) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorOrderEditActivity.this.m6640t(view);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorOrderEditActivity.this.m6641u(view);
            }
        });
        findViewById(R.id.cal_edit_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorOrderEditActivity.this.m6642v(view);
            }
        });
        findViewById(R.id.mrl_date_span).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorOrderEditActivity.this.m6643w(view);
            }
        });
    }

    /* renamed from: R */
    public final void m6635R() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_items);
        this.f11840M = new OrderItemAdapter(this, "editOrder");
        recyclerView.setAdapter(this.f11840M);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
        List<OrderItem> getValue = f11837P.getValue();
        if (getValue == null || getValue.size() == 0) {
            getValue = this.f11839L;
        } else {
            getValue.addAll(this.f11839L);
        }
        this.f11840M.addAll((List) getValue);
    }


    public void m6636a(Bundle bundle) {
        if (bundle != null) {
            this.f11838K = bundle.getInt("orderId");
            this.f11839L = (List) new Gson().fromJson(bundle.getString("items"), new C3202a(this).getType());
            float f = bundle.getFloat("shippingAmount");
            String string = bundle.getString("shippingCurrency");
            String string2 = bundle.getString("status");
            Date date = (Date) new Gson().fromJson(bundle.getString("completedAt"), new C3203b(this).getType());
            f11837P = new MutableLiveData<>();
            if (string == null) {
                string = "kpf";
            }
            ((TextView) findViewById(R.id.tv_shipping_price_unit)).setText(string.equals("kpf") ? "$" : getResources().getString(R.string.price_unit));
            ((EditForm) findViewById(R.id.ef_shipping_price)).setTextColor(string.equals("kpf") ? R.color.kpf : R.color.kpw);
            EditForm editForm = (EditForm) findViewById(R.id.ef_shipping_price);
            String str = "";
            if (f != 0.0f) {
                str = f + "";
            }
            editForm.setText(str);
            editForm.setEditListener(new C3204c(this, editForm));
            if (string2 == null || !string2.equals("completed")) {
                findViewById(R.id.ll_order_completed_at).setVisibility(View.GONE);
            } else {
                findViewById(R.id.ll_order_completed_at).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.tv_date)).setText(Util.m307b(date));
                this.f11841N = new PickerObj3(this);
                this.f11841N.m4714b(date);
                this.f11842O = date;
                this.f11841N.f8619c = new InterfaceC2115g() { // from class: b.f.a.a.i.t0
                    @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

                    public final void mo4267a(Date date2, View view) {
                        VendorOrderEditActivity.this.m6637a(date2, view);
                    }
                };
            }
            m6635R();
            f11837P.observe(this, new Observer() { // from class: b.f.a.a.i.x0
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    VendorOrderEditActivity.this.m6639b((List) obj);
                }
            });
        }
    }


    public  void m6637a(Date date, View view) {
        this.f11842O = date;
        ((TextView) findViewById(R.id.tv_date)).setText(Util.m307b(date));
    }


    public  void m6638b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            Intent intent = new Intent(this, VendorOrderDetailActivity.class);
            intent.putExtra("orderId", this.f11838K);
            setResult(-1, intent);
            finish();
        }
    }


    public  void m6639b(List list) {
        m6635R();
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == 1 && intent != null) {
            f11837P.setValue( new Gson().fromJson(intent.getStringExtra("items"), new C3205d(this).getType()));
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_order);
        m4307e(R.string.edit_order);
        m6636a(getIntent().getExtras());
        mo4284G();
    }

    /* renamed from: t */
    public  void m6640t(View view) {
        onBackPressed();
    }

    /* renamed from: u */
    public  void m6641u(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orderId", this.f11838K);
            jSONObject.put("items", this.f11840M.arrayList);
            jSONObject.put("completedAt", this.f11842O != null ? Util.m307b(this.f11842O) : null);
            jSONObject.put("shippingPrice", ((EditForm) findViewById(R.id.ef_shipping_price)).getText());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Util.m239a((Context) this, jSONObject);
        ModelCollection.m5453f(this, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        ModelCollection.f10217h.observe(this, new Observer() { // from class: b.f.a.a.i.u0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorOrderEditActivity.this.m6638b(dialogC2001j, (Integer) obj);
            }
        });
    }

    /* renamed from: v */
    public  void m6642v(View view) {
        Intent intent = new Intent(this, ProductChooseSaleActivity.class);
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (f11837P.getValue() != null && f11837P.getValue().size() != 0) {
            for (int i = 0; i < f11837P.getValue().size(); i++) {
                if (f11837P.getValue().get(i).productId == 0) {
                    arrayList.add(Integer.valueOf(f11837P.getValue().get(i).f12404id));
                    arrayList2.add(f11837P.getValue().get(i));
                }
            }
        }
        intent.putIntegerArrayListExtra("ids", arrayList);
        intent.putExtra("items", new Gson().toJson(arrayList2));
        intent.putExtra("page", "orderDetail");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, 100);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }

    /* renamed from: w */
    public  void m6643w(View view) {
        this.f11841N.m4710a();
    }
}
