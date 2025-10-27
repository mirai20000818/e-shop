package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.vendor.SaleProductUpdate;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.f.x2 */

public class DialogChangeDiscount extends BaseAniDialog<DialogChangeDiscount> {

    
    public String f9102A;


    public float f9103B;

    /* renamed from: y */
    public BaseActivity f9104y;

    /* renamed from: z */
    public SaleProductUpdate f9105z;

    /* renamed from: b.f.a.f.x2$a */
    public class a implements TextWatcher {


        public final  EditForm f9106b;

        public a(EditForm editForm) {
            this.f9106b = editForm;
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
                this.f9106b.setText("");
                f = 0.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0") && f == 0.0f) {
                this.f9106b.setText("");
            }
            if (f > DialogChangeDiscount.this.f9105z.discountPrice) {
                this.f9106b.setText(Util.m161a(DialogChangeDiscount.this.f9105z.discountPrice, 2) + "");
            }
        }
    }

    public DialogChangeDiscount(BaseActivity activityC1391g1, SaleProductUpdate saleProductUpdate, String str, float f) {
        super(activityC1391g1, 80);
        this.f9105z = saleProductUpdate;
        this.f9104y = activityC1391g1;
        this.f9102A = str;
        this.f9103B = f;
        ProductTotalVM.f10240h = new MutableLiveData<>();
    }

    
    public  void m4879a(View view, View view2) {
        float f;
        BaseActivity activityC1391g1;
        Resources resources;
        int i;
        String text = ((EditForm) view.findViewById(R.id.cef_discount_price)).getText();
        try {
            if (text.isEmpty()) {
                text = "0";
            }
            f = Float.parseFloat(text);
        } catch (Exception unused) {
            Util.toast(this.f9104y, view.getResources().getString(R.string.wrong_value_notice), "error", 0, 0);
            f = 0.0f;
        }
        if (f == 0.0f) {
            activityC1391g1 = this.f9104y;
            resources = view.getResources();
            i = R.string.input_value_warning;
        } else if (f == this.f9105z.discountPrice) {
            activityC1391g1 = this.f9104y;
            resources = view.getResources();
            i = R.string.no_change;
        } else {
            if (f >= Util.m161a(this.f9103B * 0.03f, 2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    ArrayList arrayList = new ArrayList();
                    SaleProductUpdate saleProductUpdate = new SaleProductUpdate();
                    saleProductUpdate.f12444id = this.f9105z.f12444id;
                    saleProductUpdate.productId = this.f9105z.productId;
                    saleProductUpdate.discountPrice = Util.m161a(f, 2);
                    saleProductUpdate.discountPercent = Util.m161a(100.0f - ((f / this.f9103B) * 100.0f), 1);
                    arrayList.add(saleProductUpdate);
                    jSONObject.put("params", arrayList);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                ProductTotalVM.m5483g(getContext(), jSONObject);
                final DialogC2001j dialogC2001j = new DialogC2001j(this.f9104y);
                dialogC2001j.show();
                ProductTotalVM.f10240h.observe(this.f9104y, new Observer() { // from class: b.f.a.f.p0
                    @Override // p000a.p060o.InterfaceC0405p
                    
                    public final void onChanged(Object obj) {
                        DialogChangeDiscount.this.m4880a(dialogC2001j, (Integer) obj);
                    }
                });
                return;
            }
            activityC1391g1 = this.f9104y;
            resources = view.getResources();
            i = R.string.add_sale_product_description;
        }
        Util.toast(activityC1391g1, resources.getString(i), "error", 0, 0);
    }

    
    public  void m4880a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            m4595e();
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @SuppressLint({"UseCompatLoadingForDrawables", "RestrictedApi", "SetTextI18n"})

    public View mo4576b() {
        final View inflate = View.inflate(this.f8251b, R.layout.dialog_change_discount_percent, null);
        inflate.findViewById(R.id.llc_button_group).setBackgroundColor(inflate.getResources().getColor(R.color.white));
        inflate.findViewById(R.id.cb_cancel).setVisibility(View.GONE);
        inflate.findViewById(R.id.cb_cancel_outline).setVisibility(View.VISIBLE);
        inflate.setBackground(Util.getGradDrawable(Color.parseColor("#ffffffff"), new float[]{m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), 0.0f, 0.0f, 0.0f, 0.0f}));
        inflate.setPadding(m4590a(10.0f), m4590a(20.0f), m4590a(10.0f), m4590a(7.0f));
        ((TextView) inflate.findViewById(R.id.tv_unit)).setText(this.f9102A.equals("kpw") ? this.f9104y.getResources().getString(R.string.price_unit) : "$");
        ((EditForm) inflate.findViewById(R.id.cef_discount_price)).setTextColor(this.f9104y.getResources().getIdentifier(this.f9102A, "color", this.f9104y.getPackageName()));
        inflate.findViewById(R.id.cb_cancel_outline).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogChangeDiscount.this.m4881c(view);
            }
        });
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogChangeDiscount.this.m4879a(inflate, view);
            }
        });
        if (this.f9105z.discountPrice != 0.0f) {
            EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_discount_price);
            editForm.setText(this.f9105z.discountPrice + "");
            editForm.setEditListener(new a(editForm));
        }
        return inflate;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
    }


    public  void m4881c(View view) {
        startAni();
    }
}
