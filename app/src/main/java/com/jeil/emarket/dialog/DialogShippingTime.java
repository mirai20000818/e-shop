package com.jeil.emarket.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.TableLayout;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.seller.VendorOrderDetailActivity;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.edittext.AutoCompleteEditPhone;
import com.jeil.emarket.components.edittext.AutoCompleteTextView;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.SameShippingOrder;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.model.vendor.OrderDetail;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.viewmodel.ModelCollection;
import com.jeil.emarket.viewmodel.DelivererVM;

/* renamed from: b.f.a.f.b3 */

public class DialogShippingTime extends BaseAniDialog<DialogShippingTime> {


    public List<ShippingInfo> f8859A;


    public MutableLiveData<ShippingInfo> f8860B;


    public ShippingInfo f8861C;


    public OrderDetail f8862D;


    public java.lang.String f8863E;

    /* renamed from: F */
    public List<java.lang.String> f8864F;

    /* renamed from: G */
    public List<java.lang.String> f8865G;

    /* renamed from: H */
    public AutoCompleteTextView f8866H;


    public AutoCompleteEditPhone f8867I;

   
    public AutoCompleteEditPhone f8868J;


    public PickerObj3 f8869K;

    /* renamed from: L */
    public Date f8870L;

    /* renamed from: M */
    public boolean f8871M;

    /* renamed from: N */
    public List<SameShippingOrder> f8872N;

    /* renamed from: y */
    public BaseActivity f8873y;

    /* renamed from: z */
    public View f8874z;

    /* renamed from: b.f.a.f.b3$a */
    public class a implements AdapterView.OnItemClickListener {


        public final  List f8875b;

        public a(List list) {
            this.f8875b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            for (int i2 = 0; i2 < this.f8875b.size(); i2++) {
                if (((ShippingInfo) this.f8875b.get(i2)).name.equals(DialogShippingTime.this.f8866H.getText())) {
                    DialogShippingTime.this.f8860B.setValue( this.f8875b.get(i2));
                    return;
                }
            }
        }
    }

    /* renamed from: b.f.a.f.b3$b */
    public class b implements AdapterView.OnItemClickListener {


        public final  List f8877b;

        public b(List list) {
            this.f8877b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            for (int i2 = 0; i2 < this.f8877b.size(); i2++) {
                if (((ShippingInfo) this.f8877b.get(i2)).phone1.equals(DialogShippingTime.this.f8867I.getText()) || ((ShippingInfo) this.f8877b.get(i2)).phone2.equals(DialogShippingTime.this.f8867I.getText())) {
                    DialogShippingTime.this.f8860B.setValue( this.f8877b.get(i2));
                    return;
                }
            }
        }
    }

    /* renamed from: b.f.a.f.b3$c */
    public class c implements AdapterView.OnItemClickListener {


        public final  List f8879b;

        public c(List list) {
            this.f8879b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            for (int i2 = 0; i2 < this.f8879b.size(); i2++) {
                if (((ShippingInfo) this.f8879b.get(i2)).phone1.equals(DialogShippingTime.this.f8868J.getText()) || ((ShippingInfo) this.f8879b.get(i2)).phone2.equals(DialogShippingTime.this.f8868J.getText())) {
                    DialogShippingTime.this.f8860B.setValue( this.f8879b.get(i2));
                    return;
                }
            }
        }
    }

    public DialogShippingTime(BaseActivity activityC1391g1, OrderDetail orderDetail, ShippingInfo shippingInfo, List<ShippingInfo> list, Date date, java.lang.String str) {
        super(activityC1391g1, 80);
        this.f8860B = new MutableLiveData<>();
        this.f8864F = new ArrayList();
        this.f8865G = new ArrayList();
        this.f8871M = false;
        this.f8872N = new ArrayList();
        this.f8873y = activityC1391g1;
        this.f8860B.setValue(shippingInfo);
        this.f8861C = shippingInfo;
        this.f8859A = list;
        this.f8862D = orderDetail;
        this.f8863E = str;
        this.f8870L = date;
    }


    public  void m4776a(int i, View view) {
        startAni();
        BaseActivity activityC1391g1 = this.f8873y;
        if (activityC1391g1 instanceof VendorOrderDetailActivity) {
            ((VendorOrderDetailActivity) activityC1391g1).f11821O = true;
            ((VendorOrderDetailActivity) activityC1391g1).m6603U();
        }
        ModelCollection.m5447d(this.f8873y, this.f8872N.get(i).f12418id);
    }


    public  void m4777a(CompoundButton compoundButton, boolean z) {
        View findViewById;
        int i;
        this.f8871M = z;
        if (z) {
            findViewById = this.f8874z.findViewById(R.id.ll_shipping_time);
            i = 0;
        } else {
            findViewById = this.f8874z.findViewById(R.id.ll_shipping_time);
            i = 8;
        }
        findViewById.setVisibility(i);
    }


    public  void m4778a(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            DelivererVM.f10413f.observe(this.f8873y, new Observer() { // from class: b.f.a.f.f1
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    DialogShippingTime.this.m4780a((Integer) obj);
                }
            });
        }
    }


    public  void m4779a(ShippingInfo shippingInfo) {
        this.f8866H.setText(shippingInfo.name);
        this.f8867I.setText(shippingInfo.phone1);
        AutoCompleteEditPhone autoCompleteEditPhone = this.f8868J;
        java.lang.String str = shippingInfo.phone2;
        autoCompleteEditPhone.setText((str == null || str.isEmpty()) ? "" : shippingInfo.phone2);
    }


    public  void m4780a(Integer num) {
        if (num.intValue() != 0) {
            ShippingInfo shippingInfo = new ShippingInfo();
            shippingInfo.name = this.f8866H.getText();
            shippingInfo.phone1 = this.f8867I.getText();
            shippingInfo.phone2 = this.f8868J.getText();
            shippingInfo.f12419id = num.intValue();
            this.f8860B.setValue(shippingInfo);
            m4792h();
        }
    }


    public  void m4781a(Date date, View view) {
        this.f8870L = date;
        ((TextView) this.f8874z.findViewById(R.id.tv_shipping_time)).setText(Util.m307b(date));
    }


    public  void m4782a(List list) {
        m4786c((List<ShippingInfo>) list);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        PickerObj3 pickerObj3;
        Date date;
        ViewGroup viewGroup = null;
        this.f8874z = View.inflate(this.f8251b, R.layout.dialog_select_deliverer, null);
        this.f8866H = (AutoCompleteTextView) this.f8874z.findViewById(R.id.cactv_deliverer_full_name);
        this.f8866H.setIconDrawable(R.drawable.ic_account_sm);
        this.f8866H.setRippleColor(R.color.white);
        this.f8867I = (AutoCompleteEditPhone) this.f8874z.findViewById(R.id.cep_phone1);
        this.f8868J = (AutoCompleteEditPhone) this.f8874z.findViewById(R.id.cep_phone2);
        ModelCollection.f10215f.observe(this.f8873y, new Observer() { // from class: b.f.a.f.v0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                DialogShippingTime.this.m4784b((List) obj);
            }
        });
        this.f8874z.setBackground(Util.m205a(Color.parseColor("#ffffffff"), new float[]{m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), 0.0f, 0.0f, 0.0f, 0.0f}));
        this.f8874z.setPadding(m4590a(10.0f), m4590a(20.0f), m4590a(10.0f), m4590a(7.0f));
        this.f8872N = ModelCollection.f10216g.getValue();
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.f.g1
            @Override // java.lang.Runnable
            public final void run() {
                DialogShippingTime.this.m4791g();
            }
        }, 200L);
        if (this.f8863E.equals("order")) {
            this.f8874z.findViewById(R.id.ll_delivery_time).setVisibility(View.VISIBLE);
            List<SameShippingOrder> list = this.f8872N;
            if (list == null || list.size() == 0) {
                this.f8874z.findViewById(R.id.ll_same_shipping_orders_section).setVisibility(View.GONE);
            } else {
                this.f8874z.findViewById(R.id.ll_same_shipping_orders_section).setVisibility(View.VISIBLE);
                ((TableLayout) this.f8874z.findViewById(R.id.tl_same_shipping_orders)).setShrinkAllColumns(true);
                LayoutInflater layoutInflater = getLayoutInflater();
                int i = R.layout.item_same_shipping_order;
                View inflate = layoutInflater.inflate(R.layout.item_same_shipping_order, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_order_id);
                StringBuilder sb = new StringBuilder();
                CustomString.m3171a(this.f8873y, R.string.order, sb, " ");
                sb.append(this.f8862D.displayOrderId);
                textView.setText(sb.toString());
                inflate.findViewById(R.id.tv_order_status).setBackgroundTintList(CustomString.m3149a(this.f8873y, this.f8873y.getResources(), this.f8862D.status, "color", this.f8873y.getResources()));
                ((TextView) inflate.findViewById(R.id.tv_order_status)).setText(Util.m335d(this.f8873y, this.f8862D.status));
                if (this.f8862D.shippingAmount != 0.0f) {
                    CustomString.m3167a(inflate, R.id.tv_order_free_shipping, 8, R.id.pt_order_shipping_price, 0);
                    ((PriceText) inflate.findViewById(R.id.pt_order_shipping_price)).setHidePriceNumber(false);
                    ((PriceText) inflate.findViewById(R.id.pt_order_shipping_price)).setCurrency(this.f8862D.shippingCurrency);
                    ((PriceText) inflate.findViewById(R.id.pt_order_shipping_price)).setPrice(Util.m327c(this.f8862D.shippingAmount));
                } else {
                    CustomString.m3167a(inflate, R.id.tv_order_free_shipping, 0, R.id.pt_order_shipping_price, 8);
                }
                if (this.f8862D.deliveryTime != null) {
                    inflate.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.VISIBLE);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.tv_shipping_arrived_at);
                    StringBuilder m3163a = CustomString.format("( ");
                    CustomString.m3171a(this.f8873y, R.string.shipping_time, m3163a, " ");
                    m3163a.append(Util.m307b(this.f8862D.deliveryTime));
                    m3163a.append(" )");
                    textView2.setText(m3163a.toString());
                } else {
                    inflate.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.GONE);
                }
                inflate.findViewById(R.id.mrl_same_shipping_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.y0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogShippingTime.this.m4790f(view);
                    }
                });
                ((TableLayout) this.f8874z.findViewById(R.id.tl_same_shipping_orders)).addView(inflate);
                final int i2 = 0;
                while (i2 < this.f8872N.size()) {
                    View inflate2 = getLayoutInflater().inflate(i, viewGroup, false);
                    TextView textView3 = (TextView) inflate2.findViewById(R.id.tv_order_id);
                    StringBuilder sb2 = new StringBuilder();
                    CustomString.m3171a(this.f8873y, R.string.order, sb2, " ");
                    sb2.append(this.f8872N.get(i2).displayOrderId);
                    textView3.setText(sb2.toString());
                    inflate2.findViewById(R.id.tv_order_status).setBackgroundTintList(CustomString.m3149a(this.f8873y, this.f8873y.getResources(), this.f8872N.get(i2).status, "color", this.f8873y.getResources()));
                    ((TextView) inflate2.findViewById(R.id.tv_order_status)).setText(Util.m335d(this.f8873y, this.f8872N.get(i2).status));
                    if (this.f8872N.get(i2).shippingPrice != 0.0f) {
                        CustomString.m3167a(inflate2, R.id.tv_order_free_shipping, 8, R.id.pt_order_shipping_price, 0);
                        ((PriceText) inflate2.findViewById(R.id.pt_order_shipping_price)).setHidePriceNumber(false);
                        ((PriceText) inflate2.findViewById(R.id.pt_order_shipping_price)).setCurrency(this.f8872N.get(i2).shippingCurrency);
                        ((PriceText) inflate2.findViewById(R.id.pt_order_shipping_price)).setPrice(Util.m327c(this.f8872N.get(i2).shippingPrice));
                    } else {
                        CustomString.m3167a(inflate2, R.id.tv_order_free_shipping, 0, R.id.pt_order_shipping_price, 8);
                    }
                    if (this.f8872N.get(i2).deliveryTime != null) {
                        inflate2.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.VISIBLE);
                        TextView textView4 = (TextView) inflate2.findViewById(R.id.tv_shipping_arrived_at);
                        StringBuilder m3163a2 = CustomString.format("( ");
                        CustomString.m3171a(this.f8873y, R.string.shipping_time, m3163a2, " ");
                        m3163a2.append(Util.m307b(this.f8872N.get(i2).deliveryTime));
                        m3163a2.append(" )");
                        textView4.setText(m3163a2.toString());
                    } else {
                        inflate2.findViewById(R.id.tv_shipping_arrived_at).setVisibility(View.GONE);
                    }
                    inflate2.findViewById(R.id.mrl_same_shipping_order).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.d1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DialogShippingTime.this.m4776a(i2, view);
                        }
                    });
                    ((TableLayout) this.f8874z.findViewById(R.id.tl_same_shipping_orders)).addView(inflate2);
                    i2++;
                    viewGroup = null;
                    i = R.layout.item_same_shipping_order;
                }
            }
            this.f8869K = new PickerObj3(this.f8873y);
            this.f8869K.m4712a(this.f8862D.createdAt);
            if (this.f8870L != null) {
                ((TextView) this.f8874z.findViewById(R.id.tv_shipping_time)).setText(Util.m307b(this.f8870L));
                pickerObj3 = this.f8869K;
                date = this.f8870L;
            } else {
                pickerObj3 = this.f8869K;
                date = this.f8862D.createdAt;
            }
            pickerObj3.m4714b(date);
            this.f8874z.findViewById(R.id.cb_set_delivery_time).setVisibility(this.f8870L != null ? View.GONE : View.VISIBLE);
            this.f8871M = this.f8870L != null;
            this.f8874z.findViewById(R.id.ll_shipping_time).setVisibility(this.f8870L != null ? View.VISIBLE : View.GONE);
            if (this.f8870L != null) {
                ((TextView) this.f8874z.findViewById(R.id.tv_shipping_time)).setText(Util.m307b(this.f8870L));
            }
            this.f8869K.f8619c = new InterfaceC2115g() { // from class: b.f.a.f.b1
                @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

                public final void mo4267a(Date date2, View view) {
                    DialogShippingTime.this.m4781a(date2, view);
                }
            };
            this.f8874z.findViewById(R.id.mrl_arrived_at).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.c1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogShippingTime.this.m4785c(view);
                }
            });
        } else {
            this.f8874z.findViewById(R.id.ll_delivery_time).setVisibility(View.GONE);
            this.f8874z.findViewById(R.id.ll_same_shipping_orders_section).setVisibility(View.GONE);
        }
        ((CheckBox) this.f8874z.findViewById(R.id.cb_set_delivery_time)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.f.e1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DialogShippingTime.this.m4777a(compoundButton, z);
            }
        });
        this.f8874z.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShippingTime.this.m4787d(view);
            }
        });
        this.f8874z.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogShippingTime.this.m4788e(view);
            }
        });
        return this.f8874z;
    }


    public  void m4783b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            m4595e();
            BaseActivity activityC1391g1 = this.f8873y;
            if (activityC1391g1 instanceof VendorOrderDetailActivity) {
                ((VendorOrderDetailActivity) activityC1391g1).f11821O = true;
                ((VendorOrderDetailActivity) activityC1391g1).m6603U();
            }
            ModelCollection.m5447d(this.f8873y, this.f8862D.f12440id);
        }
    }


    public  void m4784b(final List list) {
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.f.w0
            @Override // java.lang.Runnable
            public final void run() {
                DialogShippingTime.this.m4782a(list);
            }
        }, 200L);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
    }


    public  void m4785c(View view) {
        this.f8869K.m4710a();
    }


    public final void m4786c(List<ShippingInfo> list) {
        this.f8859A = list;
        this.f8864F = new ArrayList();
        this.f8865G = new ArrayList();
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.f8860B.getValue() != null) {
            for (int i = 0; i < list.size(); i++) {
                if (this.f8860B.getValue() != null && list.get(i).f12419id == this.f8860B.getValue().f12419id) {
                    this.f8860B.setValue(list.get(i));
                }
            }
        } else {
            this.f8860B.setValue(list.get(0));
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f8864F.add(list.get(i2).name);
            if (list.get(i2).phone1 != null) {
                this.f8865G.add(list.get(i2).phone1);
            }
            if (list.get(i2).phone2 != null) {
                this.f8865G.add(list.get(i2).phone2);
            }
        }
        this.f8866H.setAdapter(this.f8873y, this.f8864F);
        this.f8867I.setAdapter(this.f8873y, this.f8865G);
        this.f8868J.setAdapter(this.f8873y, this.f8865G);
        this.f8866H.setOnItemClickListener(new a(list));
        this.f8867I.setOnItemClickListener(new b(list));
        this.f8868J.setOnItemClickListener(new c(list));
        this.f8860B.observe(this.f8873y, new Observer() { // from class: b.f.a.f.z0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                DialogShippingTime.this.m4779a((ShippingInfo) obj);
            }
        });
    }


    public  void m4787d(View view) {
        startAni();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013b  */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m4788e(android.view.View r7) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p230f.DialogC2169b3.m4788e(android.view.View):void");
    }

    /* renamed from: f */
    public final void m4789f() {
        List<ShippingInfo> list = this.f8859A;
        boolean z = false;
        if (list != null && list.size() != 0) {
            for (int i = 0; i < this.f8859A.size(); i++) {
                if (this.f8859A.get(i).name.equals(this.f8866H.getText()) && (this.f8859A.get(i).phone1.equals(this.f8867I.getText()) || this.f8859A.get(i).phone2.equals(this.f8867I.getText()) || (!this.f8868J.getText().isEmpty() && (this.f8859A.get(i).phone1.equals(this.f8868J.getText()) || this.f8859A.get(i).phone2.equals(this.f8868J.getText()))))) {
                    this.f8860B.setValue(this.f8859A.get(i));
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            m4792h();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("phone1", this.f8867I.getText());
            jSONObject.put("phone2", this.f8868J.getText());
            jSONObject.put("fullname", this.f8866H.getText());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        DelivererVM.m5592a(this.f8873y, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this.f8873y);
        dialogC2001j.show();
        DelivererVM.f10412e.observe(this.f8873y, new Observer() { // from class: b.f.a.f.u0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                DialogShippingTime.this.m4778a(dialogC2001j, (Integer) obj);
            }
        });
    }

    /* renamed from: f */
    public  void m4790f(View view) {
        Intent intent = new Intent(this.f8873y, VendorOrderDetailActivity.class);
        intent.putExtra("orderVendorId", this.f8862D.f12440id);
        intent.putExtra("displayOrderId", this.f8862D.displayOrderId);
        this.f8873y.startActivityForResult(intent, 100);
    }

    /* renamed from: g */
    public  void m4791g() {
        m4786c(this.f8859A);
    }

    /* renamed from: h */
    public final void m4792h() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f8863E.equals("order")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this.f8862D.f12440id));
                jSONObject.put("ids", arrayList);
                jSONObject.put("status", "shipping");
                jSONObject.put("delivererId", ((ShippingInfo) Objects.requireNonNull(this.f8860B.getValue())).f12419id);
                StringBuilder sb = new StringBuilder();
                sb.append(this.f8860B.getValue().name);
                java.lang.String str = "";
                sb.append(((this.f8860B.getValue().phone1 == null || this.f8860B.getValue().phone1.isEmpty()) && (this.f8860B.getValue().phone2 == null || this.f8860B.getValue().phone2.isEmpty())) ? "" : " (");
                sb.append(this.f8860B.getValue().phone1);
                java.lang.String sb2 = sb.toString();
                if (this.f8860B.getValue().phone2 != null && !this.f8860B.getValue().phone2.isEmpty()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2);
                    sb3.append((this.f8860B.getValue().phone1 == null || this.f8860B.getValue().phone1.isEmpty()) ? "" : ", ");
                    sb3.append(this.f8860B.getValue().phone2);
                    sb2 = sb3.toString();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb2);
                if ((this.f8860B.getValue().phone1 != null && !this.f8860B.getValue().phone1.isEmpty()) || (this.f8860B.getValue().phone2 != null && !this.f8860B.getValue().phone2.isEmpty())) {
                    str = ")";
                }
                sb4.append(str);
                jSONObject.put("delivererInfo", sb4.toString());
                if (this.f8871M) {
                    if (this.f8870L == null) {
                        Util.toast(this.f8873y, this.f8873y.getResources().getString(R.string.delivery_time_validate_notice), "error", 0, 0);
                        return;
                    }
                    jSONObject.put("deliveryTime", this.f8870L);
                }
                Util.m239a((Context) this.f8873y, jSONObject);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.f8863E.equals("order")) {
            ModelCollection.m5449d(this.f8873y, jSONObject);
        } else {
            if (this.f8860B.getValue() != null && this.f8861C.f12419id == this.f8860B.getValue().f12419id) {
                BaseActivity activityC1391g1 = this.f8873y;
                Util.toast(activityC1391g1, activityC1391g1.getResources().getString(R.string.no_change), "error", 0, 0);
                return;
            }
            ModelCollection.m5427a(this.f8873y, this.f8862D.f12440id, ((ShippingInfo) Objects.requireNonNull(this.f8860B.getValue())).f12419id);
        }
        final DialogC2001j dialogC2001j = new DialogC2001j(this.f8873y);
        dialogC2001j.show();
        ModelCollection.f10217h.observe(this.f8873y, new Observer() { // from class: b.f.a.f.h1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                DialogShippingTime.this.m4783b(dialogC2001j, (Integer) obj);
            }
        });
    }
}
