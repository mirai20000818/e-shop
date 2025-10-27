package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.seller.product.ProductChooseSaleActivity;
import com.jeil.emarket.activities.seller.product.ProductSaleCheckActivity;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;
import com.jeil.emarket.components.pickerview.Picker4;
import com.jeil.emarket.components.pickerview.date.p217b.C2108a;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2111c;
import com.jeil.emarket.components.pickerview.date.p219d.ViewOnClickListenerC2123h;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.f.s2 */

public class DialogAddSaleProduct extends BaseAniDialog<DialogAddSaleProduct> {


    public static MutableLiveData<ArrayList<Integer>> f9053D = new MutableLiveData<>();


    public Date f9054A;


    public BaseActivity f9055B;


    public boolean f9056C;

    /* renamed from: y */
    public Picker4 f9057y;

    /* renamed from: z */
    public Date f9058z;

    /* renamed from: b.f.a.f.s2$a */
    public class a implements TextWatcher {


        public final  EditForm f9059b;

        public a(DialogAddSaleProduct dialogAddSaleProduct, EditForm editForm) {
            this.f9059b = editForm;
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
                this.f9059b.setText("3");
                f = 3.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f9059b.setText(f + "");
            }
            if (f > 80.0f) {
                this.f9059b.setText("80");
            }
        }
    }

    public DialogAddSaleProduct(BaseActivity activityC1391g1) {
        super(activityC1391g1, 80);
        this.f9056C = false;
        this.f9055B = activityC1391g1;
    }


    public static  void m4844a(View view, ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (!sb.toString().equals("")) {
                    sb.append(",");
                }
                sb.append(arrayList.get(i));
            }
        }
        ((TextView) view.findViewById(R.id.ctv_product_ids)).setText(sb.toString());
    }


    public  void m4845a(View view, View view2) {
        float f;
        boolean z;
        if (this.f9056C) {
            return;
        }
        boolean z2 = true;
        this.f9056C = true;
        java.lang.String text = ((EditForm) findViewById(R.id.cef_discount_percent)).getText();
        try {
            if (text.isEmpty()) {
                text = "0";
            }
            f = Float.parseFloat(text);
        } catch (Exception unused) {
            Util.toast(getContext(), view.getResources().getString(R.string.wrong_value_notice), "error", 0, 0);
            f = 0.0f;
        }
        java.lang.String charSequence = ((TextView) findViewById(R.id.ctv_product_ids)).getText().toString();
        if (f == 0.0f) {
            ((EditForm) findViewById(R.id.cef_discount_percent)).setEditTextBackground(this.f9055B.getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            ((EditForm) findViewById(R.id.cef_discount_percent)).setEditTextBackground(this.f9055B.getResources().getDrawable(R.drawable.bg_input_border));
            z = false;
        }
        if (charSequence.isEmpty()) {
            CustomString.m3168a(this.f9055B, R.drawable.bd_warn_input, findViewById(R.id.llc_product_ids));
            z = true;
        } else {
            CustomString.m3168a(this.f9055B, R.drawable.bg_input_border, findViewById(R.id.llc_product_ids));
        }
        if (this.f9058z == null || this.f9054A == null) {
            CustomString.m3168a(this.f9055B, R.drawable.bd_warn_input, findViewById(R.id.mrl_sale_period));
        } else {
            CustomString.m3168a(this.f9055B, R.drawable.bg_input_border, findViewById(R.id.mrl_sale_period));
            z2 = z;
        }
        if (z2) {
            return;
        }
        if (f < 3.0f) {
            ((EditForm) findViewById(R.id.cef_discount_percent)).setEditTextBackground(this.f9055B.getResources().getDrawable(R.drawable.bd_warn_input));
            Util.toast(getContext(), view.getResources().getString(R.string.min_value_equal_three_percent_notice), "error", 0, 0);
            return;
        }
        ((EditForm) findViewById(R.id.cef_discount_percent)).setEditTextBackground(this.f9055B.getResources().getDrawable(R.drawable.bg_input_border));
        java.lang.String[] split = charSequence.split(",");
        final JSONObject jSONObject = new JSONObject();
        try {
            ProductTotalVM.f10241i.setValue(Util.date2Str(this.f9058z));
            ProductTotalVM.f10242j.setValue(Util.date2Str(this.f9054A));
            jSONObject.put("ids", split);
            jSONObject.put("discount", f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        final Context context = getContext();
        ProductTotalVM.f10245m = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.s1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "check_sale_products", new ProductTotalVM()).get("e7/sale/check", jSONObject);
            }
        });
        final DialogC2001j dialogC2001j = new DialogC2001j(this.f9055B);
        dialogC2001j.show();
        ProductTotalVM.f10240h.observe(this.f9055B, new Observer() { // from class: b.f.a.f.j
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                DialogAddSaleProduct.this.m4847a(dialogC2001j, (Integer) obj);
            }
        });
    }


    public  void m4846a(View view, Date date, Date date2, View view2) {
        this.f9058z = date;
        this.f9054A = date2;
        ((TextView) view.findViewById(R.id.tv_sale_period)).setText(Util.date2Str(date) + " ~ " + Util.date2Str(date2));
    }


    public  void m4847a(DialogC2001j dialogC2001j, Integer num) {
        this.f9056C = false;
        if (num.intValue() == 200) {
            Intent intent = new Intent(this.f9055B.getApplicationContext(), ProductSaleCheckActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.f9055B.startActivity(intent);
            m4595e();
            f9053D.setValue( new ArrayList<>());
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @SuppressLint({"UseCompatLoadingForDrawables", "RestrictedApi", "SetTextI18n"})

    public View mo4576b() {
        final View inflate = View.inflate(this.f8251b, R.layout.dialog_add_sale_product, null);
        this.f9057y = new Picker4(getContext(), 15, true);
        Calendar calendar = Calendar.getInstance();
        Date date = this.f9058z;
        if (date != null) {
            calendar.setTime(date);
        } else {
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5));
        }
        ViewOnClickListenerC2123h viewOnClickListenerC2123h = this.f9057y.f8615b;
        C2108a c2108a = viewOnClickListenerC2123h.f8694c;
        c2108a.f8669s = calendar;
        Date time = c2108a.f8669s.getTime();
        Date date2 = new Date(time.getYear() + 1, time.getMonth(), time.getDate());
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar2.setTime(time);
        calendar3.setTime(date2);
        viewOnClickListenerC2123h.f8702k.m4742a(calendar2, calendar3);
        viewOnClickListenerC2123h.m4728f();
        Calendar calendar4 = Calendar.getInstance();
        Date date3 = this.f9054A;
        if (date3 != null) {
            calendar4.setTime(date3);
        } else {
            calendar4.set(calendar4.get(1), calendar4.get(2), calendar4.get(5));
        }
        this.f9057y.m4705a(calendar4);
        inflate.findViewById(R.id.llc_button_group).setBackgroundColor(this.f9055B.getResources().getColor(R.color.white));
        inflate.findViewById(R.id.cb_cancel).setVisibility(View.GONE);
        inflate.findViewById(R.id.cb_cancel_outline).setVisibility(View.VISIBLE);
        inflate.setBackground(Util.m205a(this.f9055B.getResources().getColor(R.color.white), new float[]{m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), 0.0f, 0.0f, 0.0f, 0.0f}));
        inflate.setPadding(m4590a(10.0f), m4590a(20.0f), m4590a(10.0f), m4590a(7.0f));
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) inflate.findViewById(R.id.mrl_sale_period);
        if (materialRippleLayout != null) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogAddSaleProduct.this.m4848c(view);
                }
            });
        }
        f9053D.observe(this.f9055B, new Observer() { // from class: b.f.a.f.k
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                DialogAddSaleProduct.m4844a(inflate, (ArrayList) obj);
            }
        });
        inflate.findViewById(R.id.mrl_product_ids).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddSaleProduct.this.m4849d(view);
            }
        });
        this.f9057y.f8616c = new InterfaceC2111c() { // from class: b.f.a.f.i
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2111c

            public final void mo4696a(Date date4, Date date5, View view) {
                DialogAddSaleProduct.this.m4846a(inflate, date4, date5, view);
            }
        };
        inflate.findViewById(R.id.cb_cancel_outline).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddSaleProduct.this.m4850e(view);
            }
        });
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogAddSaleProduct.this.m4845a(inflate, view);
            }
        });
        EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_discount_percent);
        editForm.setEditListener(new a(this, editForm));
        return inflate;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
    }


    public  void m4848c(View view) {
        this.f9057y.m4704a();
    }


    public  void m4849d(View view) {
        Intent intent = new Intent(this.f9055B, ProductChooseSaleActivity.class);
        intent.putIntegerArrayListExtra("ids", f9053D.getValue());
        intent.putExtra("page", "sale");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.f9055B.startActivityForResult(intent, 100);
    }


    public  void m4850e(View view) {
        startAni();
    }
}
