package com.jeil.emarket.activities.seller.product;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.seller.VendorShippingZoneActivity;
import com.jeil.emarket.components.addressareapicker.AddressAreaPicker;
import com.jeil.emarket.components.button.SwitchView;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.ShippingZone;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.viewmodel.ModelCollection;
import com.jeil.emarket.viewmodel.VendorListVM;


public class ShippingZoneEditActivity extends BaseActivityForVendor {

    /* renamed from: L */
    public ShippingZone f11909L;

    /* renamed from: N */
    public DialogC2001j f11911N;

    
    public String f11908K = "";

    /* renamed from: M */
    public List f11910M = new ArrayList();

    /* renamed from: com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity$a */
    public class C3220a implements TextWatcher {

        
        public final  EditForm f11912b;

        public C3220a(ShippingZoneEditActivity shippingZoneEditActivity, EditForm editForm) {
            this.f11912b = editForm;
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
            EditForm editForm;
            try {
                f = Float.parseFloat(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
            } catch (Exception unused) {
                this.f11912b.setText("0");
                f = 0.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                String str = "";
                if (f == 0.0f) {
                    editForm = this.f11912b;
                } else {
                    editForm = this.f11912b;
                    str = f + "";
                }
                editForm.setText(str);
            }
            if (f > 1.0E7f) {
                this.f11912b.setText("10000000");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity$b */
    public class C3221b implements TextWatcher {

        
        public final  EditForm f11913b;

        
        public final  EditForm f11914c;

        public C3221b(ShippingZoneEditActivity shippingZoneEditActivity, EditForm editForm, EditForm editForm2) {
            this.f11913b = editForm;
            this.f11914c = editForm2;
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
            EditForm editForm;
            try {
                f = Float.parseFloat(charSequence.toString().isEmpty() ? "0" : charSequence.toString());
            } catch (Exception unused) {
                this.f11913b.setText("0");
                f = 0.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                String str = "";
                if (f == 0.0f) {
                    editForm = this.f11913b;
                } else {
                    editForm = this.f11914c;
                    str = f + "";
                }
                editForm.setText(str);
            }
            if (f > 1.0E7f) {
                this.f11913b.setText("10000000");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity$c */
    public class C3222c implements TextWatcher {

        
        public final  EditForm f11915b;

        public C3222c(ShippingZoneEditActivity shippingZoneEditActivity, EditForm editForm) {
            this.f11915b = editForm;
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
                this.f11915b.setText("");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11915b.setText(i4 + "");
            }
            if (i4 > 30) {
                this.f11915b.setText("30");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity$d */
    public class C3223d implements TextWatcher {

        
        public final  EditForm f11916b;

        public C3223d(ShippingZoneEditActivity shippingZoneEditActivity, EditForm editForm) {
            this.f11916b = editForm;
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
                this.f11916b.setText("");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11916b.setText(i4 + "");
            }
            if (i4 > 30) {
                this.f11916b.setText("30");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity$e */
    public class C3224e implements TextWatcher {

        
        public final  EditForm f11917b;

        public C3224e(ShippingZoneEditActivity shippingZoneEditActivity, EditForm editForm) {
            this.f11917b = editForm;
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
                this.f11917b.setText("");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11917b.setText(i4 + "");
            }
            if (i4 > 24) {
                this.f11917b.setText("23");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.product.ShippingZoneEditActivity$f */
    public class C3225f implements TextWatcher {

        
        public final  EditForm f11918b;

        public C3225f(ShippingZoneEditActivity shippingZoneEditActivity, EditForm editForm) {
            this.f11918b = editForm;
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
                this.f11918b.setText("");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11918b.setText(i4 + "");
            }
            if (i4 > 24) {
                this.f11918b.setText("23");
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"UseCompatLoadingForDrawables"})
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
                materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.d0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ShippingZoneEditActivity.this.m6733t(view);
                    }
                });
            }
        }
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShippingZoneEditActivity.this.m6734u(view);
            }
        });
        final EditForm editForm = (EditForm) findViewById(R.id.cef_common_price);
        final EditForm editForm2 = (EditForm) findViewById(R.id.cef_urgent_price);
        final EditForm editForm3 = (EditForm) findViewById(R.id.cef_common_shipping_date);
        final EditForm editForm4 = (EditForm) findViewById(R.id.cef_urgent_shipping_date);
        final EditForm editForm5 = (EditForm) findViewById(R.id.cef_common_shipping_hour);
        final EditForm editForm6 = (EditForm) findViewById(R.id.cef_urgent_shipping_hour);
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v2.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShippingZoneEditActivity.this.m6731a(editForm, editForm3, editForm5, editForm2, editForm4, editForm6, view);
            }
        });
        editForm.setEditListener(new C3220a(this, editForm));
        editForm2.setEditListener(new C3221b(this, editForm2, editForm));
        editForm3.setEditListener(new C3222c(this, editForm3));
        editForm4.setEditListener(new C3223d(this, editForm4));
        editForm5.setEditListener(new C3224e(this, editForm5));
        editForm6.setEditListener(new C3225f(this, editForm6));
    }


    public  void m6730a(float f, int i, float f2, int i2, Integer num) {
        this.f11911N.dismiss();
        if (num.intValue() == 200) {
            if (!this.f11908K.equals("edit")) {
                setResult(-1, new Intent(getApplicationContext(), VendorShippingZoneActivity.class));
                finish();
                return;
            }
            this.f11909L.name = ((EditForm) findViewById(R.id.cet_zone_name)).getText();
            ShippingZone shippingZone = this.f11909L;
            shippingZone.areas = this.f11910M;
            shippingZone.status = ((SwitchView) findViewById(R.id.csv_usage)).m6901a() ? "unusing" : "using";
            ShippingZone shippingZone2 = this.f11909L;
            shippingZone2.price = f;
            shippingZone2.deliveryTime = i;
            shippingZone2.urgentPrice = f2;
            shippingZone2.urgentDeliveryTime = i2;
        }
    }


    public  void m6731a(EditForm editForm, EditForm editForm2, EditForm editForm3, EditForm editForm4, EditForm editForm5, EditForm editForm6, View view) {
        boolean z;
        DialogC2001j dialogC2001j;
        this.f11910M = ((AddressAreaPicker) findViewById(R.id.pt_zones)).getSelectedAddress();
        EditForm editForm7 = (EditForm) findViewById(R.id.cet_zone_name);
        if (editForm7.getText().isEmpty()) {
            editForm7.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm7.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            z = false;
        }
        AddressAreaPicker addressAreaPicker = (AddressAreaPicker) findViewById(R.id.pt_zones);
        if (this.f11910M.size() == 0) {
            addressAreaPicker.setBackgroundResource(R.drawable.bd_warn_input);
            z = true;
        } else {
            addressAreaPicker.setBackgroundResource(R.drawable.bg_input_border);
        }
        if (z) {
            return;
        }
        final float parseFloat = Float.parseFloat(editForm.getText().isEmpty() ? "0" : editForm.getText());
        final int parseInt = Integer.parseInt(editForm3.getText().isEmpty() ? "0" : editForm3.getText()) + (Integer.parseInt(editForm2.getText().isEmpty() ? "0" : editForm2.getText()) * 24);
        final float parseFloat2 = Float.parseFloat(editForm4.getText().isEmpty() ? "0" : editForm4.getText());
        final int parseInt2 = Integer.parseInt(editForm6.getText().isEmpty() ? "0" : editForm6.getText()) + (Integer.parseInt(editForm5.getText().isEmpty() ? "0" : editForm5.getText()) * 24);
        if (this.f11908K.equals("edit")) {
            boolean z2 = !this.f11909L.areas.toString().equals(this.f11910M.toString()) ? true : !this.f11909L.name.equals(((EditForm) findViewById(R.id.cet_zone_name)).getText());
            ShippingZone shippingZone = this.f11909L;
            if (shippingZone.price != parseFloat || shippingZone.deliveryTime != parseInt || shippingZone.urgentPrice != parseFloat2 || shippingZone.urgentDeliveryTime != parseInt2) {
                z2 = true;
            }
            if (!this.f11909L.status.equals(((SwitchView) findViewById(R.id.csv_usage)).m6901a() ? "using" : "unusing")) {
                z2 = true;
            }
            if (!z2) {
                Util.toast(this, getResources().getString(R.string.no_change), "error", 0, 0);
                ModelCollection.f10217h.observe(this, new Observer() { // from class: b.f.a.a.i.v2.c0
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        ShippingZoneEditActivity.this.m6730a(parseFloat, parseInt, parseFloat2, parseInt2, (Integer) obj);
                    }
                });
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f11909L.f12446id);
                jSONObject.put("name", ((EditForm) findViewById(R.id.cet_zone_name)).getText());
                jSONObject.put("price", parseFloat);
                jSONObject.put("time", parseInt);
                jSONObject.put("urgentPrice", parseFloat2);
                jSONObject.put("urgentTime", parseInt2);
                jSONObject.put("using", ((SwitchView) findViewById(R.id.csv_usage)).m6901a() ? "unusing" : "using");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < this.f11910M.size(); i++) {
                    sb.append(this.f11910M.get(i));
                    if (i != this.f11910M.size() - 1) {
                        sb.append(",");
                    }
                }
                jSONObject.put("areas", sb.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ModelCollection.m5438b(this, this.f11909L.f12446id, jSONObject);
            dialogC2001j = new DialogC2001j(this);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("name", ((EditForm) findViewById(R.id.cet_zone_name)).getText());
                jSONObject2.put("price", parseFloat);
                jSONObject2.put("time", parseInt);
                jSONObject2.put("urgentPrice", parseFloat2);
                jSONObject2.put("urgentTime", parseInt2);
                jSONObject2.put("using", ((SwitchView) findViewById(R.id.csv_usage)).m6901a() ? "unusing" : "using");
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < this.f11910M.size(); i2++) {
                    sb2.append(this.f11910M.get(i2));
                    if (i2 != this.f11910M.size() - 1) {
                        sb2.append(",");
                    }
                }
                jSONObject2.put("areas", sb2.toString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            ModelCollection.m5433a(this, jSONObject2);
            dialogC2001j = new DialogC2001j(this);
        }
        this.f11911N = dialogC2001j;
        this.f11911N.show();
        ModelCollection.f10217h.observe(this, new Observer() { // from class: b.f.a.a.i.v2.c0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ShippingZoneEditActivity.this.m6730a(parseFloat, parseInt, parseFloat2, parseInt2, (Integer) obj);
            }
        });
    }


    public final void m6732a(ShippingZone shippingZone) {
        String str;
        String str2;
        this.f11909L = shippingZone;
        if (shippingZone != null) {
            ((EditForm) findViewById(R.id.cet_zone_name)).setText(shippingZone.name);
            ((AddressAreaPicker) findViewById(R.id.pt_zones)).setAddressData(this.f11909L.areas);
            this.f11910M = this.f11909L.areas;
            EditForm editForm = (EditForm) findViewById(R.id.cef_common_price);
            if (shippingZone.price == 0.0f) {
                str = "";
            } else {
                str = shippingZone.price + "";
            }
            editForm.setText(str);
            ((EditForm) findViewById(R.id.cef_common_price)).setTextColor(getResources().getIdentifier(shippingZone.shippingCurrency, "color", getPackageName()));
            findViewById(R.id.tv_common_price_unit).setVisibility(this.f11909L.shippingCurrency.equals("kpw") ? View.VISIBLE : View.GONE);
            ((EditForm) findViewById(R.id.cef_common_shipping_date)).setText((shippingZone.deliveryTime / 24) + "");
            ((EditForm) findViewById(R.id.cef_common_shipping_hour)).setText((shippingZone.deliveryTime % 24) + "");
            EditForm editForm2 = (EditForm) findViewById(R.id.cef_urgent_price);
            if (shippingZone.urgentPrice == 0.0f) {
                str2 = "";
            } else {
                str2 = shippingZone.urgentPrice + "";
            }
            editForm2.setText(str2);
            ((EditForm) findViewById(R.id.cef_urgent_price)).setTextColor(getResources().getIdentifier(this.f11909L.shippingCurrency, "color", getPackageName()));
            findViewById(R.id.tv_urgent_price_unit).setVisibility(this.f11909L.shippingCurrency.equals("kpw") ? View.VISIBLE : View.GONE);
            ((EditForm) findViewById(R.id.cef_urgent_shipping_date)).setText((shippingZone.urgentDeliveryTime / 24) + "");
            ((EditForm) findViewById(R.id.cef_urgent_shipping_hour)).setText((shippingZone.urgentDeliveryTime % 24) + "");
            findViewById(R.id.ll_urgent).setVisibility(shippingZone.enableUrgent ? View.VISIBLE : View.GONE);
            ((SwitchView) findViewById(R.id.csv_usage)).setChecked(shippingZone.status.equals("unusing"));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (m4309v()) {
            return;
        }
        setResult(-1, new Intent(getApplicationContext(), VendorShippingZoneActivity.class));
        finish();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_shipping_zone_edit);
        if (getIntent().getExtras() != null) {
            m4297a(getIntent().getExtras().getString("name"));
            this.f11908K = getIntent().getExtras().getString("type");
            VendorListVM.f10363d.getValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add("PY");
            arrayList.add("PN");
            String str = this.f11908K;
            if (str == null || !str.equals("edit")) {
                String str2 = this.f11908K;
                if (str2 != null && str2.equals("add")) {
                    m4307e(R.string.add_shipping_zone);
                }
            } else {
                ModelCollection.m5443c(this, getIntent().getExtras().getInt("id"));
                ModelCollection.f10219j.observe(this, new Observer() { // from class: b.f.a.a.i.v2.k
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        ShippingZoneEditActivity.this.m6732a((ShippingZone) obj);
                    }
                });
            }
        }
        addBottomNav(0);
        mo4284G();
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    /* renamed from: t */
    public  void m6733t(View view) {
        onBackPressed();
    }

    /* renamed from: u */
    public  void m6734u(View view) {
        onBackPressed();
    }
}
