package com.jeil.emarket.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.Window;

import com.jeil.emarket.components.button.RadioButton;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Address;
import com.jeil.emarket.model.customer.CheckoutVendor;
import com.jeil.emarket.model.customer.CreateOrder;
import com.jeil.emarket.model.customer.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.InterfaceVariableProduct;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.CheckoutVendorVM;

/* renamed from: b.f.a.f.c3 */

public class DialogPayment extends BaseAniDialog<DialogPayment> implements InterfaceVariableProduct {


    public BaseActivity f8886A;


    public View f8887B;


    public String f8888C;

    
    public int f8889D;

    
    public String f8890E;

    /* renamed from: F */
    public float f8891F;

    /* renamed from: G */
    public float f8892G;

    /* renamed from: H */
    public String f8893H;

    
    public CreateOrder f8894I;

   
    public boolean f8895J;

    
    public float f8896K;

    /* renamed from: L */
    public String f8897L;

    /* renamed from: y */
    public List<String> f8898y;

    /* renamed from: z */
    public BaseDialog2 f8899z;

    /* renamed from: b.f.a.f.c3$a */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            try {
                i4 = Integer.parseInt(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
            } catch (Exception unused) {
                i4 = 0;
                ((EditForm) DialogPayment.this.f8887B.findViewById(R.id.cef_price)).setText("");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                DialogPayment dialogPayment = DialogPayment.this;
                if (i4 == 0) {
                    ((EditForm) dialogPayment.f8887B.findViewById(R.id.cef_price)).setText("");
                } else {
                    ((EditForm) dialogPayment.f8887B.findViewById(R.id.cef_price)).setText(i4 + "");
                }
            }
            if (i4 > 100000000) {
                ((EditForm) DialogPayment.this.f8887B.findViewById(R.id.cef_price)).setText("100000000");
            }
        }
    }

    public DialogPayment(BaseActivity activityC1391g1, int i, String str, float f, float f2, CreateOrder createOrder, String str2, float f3, String str3) {
        super(activityC1391g1, 80);
        this.f8898y = new ArrayList();
        this.f8899z = null;
        this.f8895J = false;
        this.f8886A = activityC1391g1;
        this.f8889D = i;
        this.f8890E = str;
        this.f8891F = f;
        this.f8892G = f2;
        this.f8893H = str2;
        this.f8894I = createOrder;
        this.f8896K = f3;
        this.f8897L = str3;
    }


    public static  void m4793a(DialogC2001j dialogC2001j, List list) {
        if (dialogC2001j.isShowing()) {
            dialogC2001j.dismiss();
        }
    }


    public  void m4794a(View view, int i) {
        this.f8888C = this.f8898y.get(i);
        ((TextView) this.f8887B.findViewById(R.id.ctv_currency)).setText(this.f8898y.get(i));
        this.f8899z.startAni();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2713g

    public void mo4598a(Product.VariableProduct variableProduct) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00f5, code lost:
    
        if (r9.f8892G <= 0.0f) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0155, code lost:
    
        r1.setVisibility(View.GONE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0127, code lost:
    
        if ((r9.f8892G + r9.f8896K) <= 0.0f) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0153, code lost:
    
        if (r9.f8892G <= 0.0f) goto L37;
     */
    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @android.annotation.SuppressLint({"UseCompatLoadingForDrawables", "RestrictedApi"})

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View mo4576b() {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p230f.DialogC2174c3.mo4576b():android.view.View");
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
    }


    public  void m4795c(View view) {
        this.f8887B.findViewById(R.id.llc_price_box).setVisibility(View.GONE);
        this.f8895J = false;
    }

    
    public  void m4796d(View view) {
        this.f8887B.findViewById(R.id.llc_price_box).setVisibility(View.VISIBLE);
        this.f8895J = true;
    }

    
    public  void m4797e(View view) {
        String text = ((EditForm) this.f8887B.findViewById(R.id.cef_price)).getText();
        if (((RadioButton) this.f8887B.findViewById(R.id.rb_mismatch)).isChecked() && (text == null || text.isEmpty())) {
            Util.toast(this.f8886A, this.f8887B.getResources().getString(R.string.input_currency_warning), "error", 0, 0);
            return;
        }
        if (text != null) {
            final BaseActivity activityC1391g1 = this.f8886A;
            int i = this.f8889D;
            String str = this.f8893H;
            Date date = new Date();
            CreateOrder createOrder = this.f8894I;
            String str2 = this.f8888C.equals(this.f8886A.getResources().getString(R.string.kpw)) ? "native" : "dollar";
            boolean z = this.f8895J;
            if (((List) Objects.requireNonNull(CheckoutVendorVM.f10400i.getValue())).size() >= i) {
                final CheckoutVendor checkoutVendor = CheckoutVendorVM.f10400i.getValue().get(i);
                ArrayList arrayList = new ArrayList();
                arrayList.add(createOrder);
                final JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("customerNote", CheckoutVendorVM.f10398g);
                    jSONObject.put("deliveryTime", CheckoutVendorVM.f10397f.getValue());
                    jSONObject.put("id", CheckoutVendorVM.f10399h);
                    jSONObject.put("paidAt", date);
                    jSONObject.put("paymentMethod", str);
                    jSONObject.put("shippingAddressId", ((Address) Objects.requireNonNull(CheckoutVendorVM.f10395d.getValue())).id);
                    jSONObject.put("subOrders", arrayList);
                    if (z) {
                        jSONObject.put("payAmount", text);
                        jSONObject.put("payCurrency", str2);
                    }
                    String jSONObject2 = jSONObject.toString();
                    jSONObject.put("signData", Base64.encodeToString(Util.m347e(activityC1391g1, jSONObject2), 0));
                    jSONObject.put("plainData", jSONObject2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                API_PROVIDER.checkInternet(activityC1391g1, new InterfaceContext() { // from class: b.f.a.k.z
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context) {
                        CheckoutVendorVM.m5585a(activityC1391g1, checkoutVendor, jSONObject, context);
                    }
                });
            }
            final DialogC2001j dialogC2001j = new DialogC2001j(this.f8886A);
            startAni();
            CheckoutVendorVM.f10400i.observe(this.f8886A, new Observer() { // from class: b.f.a.f.k1
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    DialogPayment.m4793a(DialogC2001j.this, (List) obj);
                }
            });
            dialogC2001j.show();
        }
    }

    /* renamed from: f */
    public void m4798f(View view) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f8898y.size(); i++) {
            arrayList.add(new Cancel_Obj(this.f8898y.get(i), this.f8888C.equals(this.f8898y.get(i)) ? 1 : 0));
        }
        this.f8899z = new BaseDialog2(this.f8886A, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f8899z;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.f.m1
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                DialogPayment.this.m4794a(view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.85f);
        BaseDialog2 baseDialog22 = this.f8899z;
        baseDialog22.f8209G = this.f8886A.getResources().getColor(BaseActivity.color);
        baseDialog22.show();
    }
}
