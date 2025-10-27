package com.jeil.emarket.activities.seller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.jeil.emarket.components.addressareapicker.AddressAreaPicker;
import com.jeil.emarket.components.button.RadioButton;
import com.jeil.emarket.components.button.SwitchView;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.ShippingMethods;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.viewmodel.ModelCollection;


public class VendorShippingMethodActivity extends BaseActivityForVendor {

    /* renamed from: L */
    public ShippingMethods f11855L;

    /* renamed from: M */
    public ShippingMethods.SettingInfo f11856M;

    
    public boolean f11854K = false;

    /* renamed from: N */
    public List f11857N = new ArrayList();

    /* renamed from: com.jeil.emarket.activities.seller.VendorShippingMethodActivity$a */
    public class C3209a implements TextWatcher {


        public final  EditForm f11858b;

        public C3209a(VendorShippingMethodActivity vendorShippingMethodActivity, EditForm editForm) {
            this.f11858b = editForm;
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
                this.f11858b.setText("");
                f = 0.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                if (f == 0.0f) {
                    this.f11858b.setText("");
                } else {
                    this.f11858b.setText(f + "");
                }
            }
            if (f > 1000000.0f) {
                this.f11858b.setText("1000000");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorShippingMethodActivity$b */
    public class C3210b implements TextWatcher {


        public final  EditForm f11859b;

        public C3210b(VendorShippingMethodActivity vendorShippingMethodActivity, EditForm editForm) {
            this.f11859b = editForm;
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
                this.f11859b.setText("");
                f = 0.0f;
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                if (f == 0.0f) {
                    this.f11859b.setText("");
                } else {
                    this.f11859b.setText(f + "");
                }
            }
            if (f > 1000000.0f) {
                this.f11859b.setText("1000000");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorShippingMethodActivity$c */
    public class C3211c implements TextWatcher {


        public final  EditForm f11860b;

        public C3211c(VendorShippingMethodActivity vendorShippingMethodActivity, EditForm editForm) {
            this.f11860b = editForm;
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
                this.f11860b.setText("");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11860b.setText(i4 + "");
            }
            if (i4 > 30) {
                this.f11860b.setText("30");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorShippingMethodActivity$d */
    public class C3212d implements TextWatcher {


        public final  EditForm f11861b;

        public C3212d(VendorShippingMethodActivity vendorShippingMethodActivity, EditForm editForm) {
            this.f11861b = editForm;
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
                this.f11861b.setText("");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11861b.setText(i4 + "");
            }
            if (i4 > 30) {
                this.f11861b.setText("30");
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorShippingMethodActivity$e */
    public class C3213e implements TextWatcher {


        public final  EditForm f11862b;

        public C3213e(VendorShippingMethodActivity vendorShippingMethodActivity, EditForm editForm) {
            this.f11862b = editForm;
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
            EditForm editForm;
            String str = "1";
            try {
                i4 = Integer.parseInt(charSequence.toString().isEmpty() ? "1" : charSequence.toString());
            } catch (Exception unused) {
                i4 = 0;
                this.f11862b.setText("1");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11862b.setText(i4 + "");
            }
            if (i4 > 23) {
                editForm = this.f11862b;
                str = "23";
            } else if (i4 >= 1) {
                return;
            } else {
                editForm = this.f11862b;
            }
            editForm.setText(str);
        }
    }

    /* renamed from: com.jeil.emarket.activities.seller.VendorShippingMethodActivity$f */
    public class C3214f implements TextWatcher {


        public final  EditForm f11863b;

        public C3214f(VendorShippingMethodActivity vendorShippingMethodActivity, EditForm editForm) {
            this.f11863b = editForm;
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
            EditForm editForm;
            String str = "1";
            try {
                i4 = Integer.parseInt(charSequence.toString().isEmpty() ? "1" : charSequence.toString());
            } catch (Exception unused) {
                i4 = 0;
                this.f11863b.setText("1");
            }
            if (charSequence.length() > 1 && charSequence.toString().startsWith("0")) {
                this.f11863b.setText(i4 + "");
            }
            if (i4 > 23) {
                editForm = this.f11863b;
                str = "23";
            } else if (i4 >= 1) {
                return;
            } else {
                editForm = this.f11863b;
            }
            editForm.setText(str);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.cb_save).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorShippingMethodActivity.this.m6666t(view);
            }
        });
        ((SwitchView) findViewById(R.id.csv_urgent)).setOnCheckedChangeListener(new SwitchView.InterfaceC3247b() { // from class: b.f.a.a.i.n1
            @Override // com.jeil.emarket.components.button.SwitchView.InterfaceC3247b

            public final void mo4371a(SwitchView switchView, boolean z) {
                VendorShippingMethodActivity.this.m6663a(switchView, z);
            }
        });
        findViewById(R.id.crb_kpw).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorShippingMethodActivity.this.m6667u(view);
            }
        });
        findViewById(R.id.crb_kpf).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorShippingMethodActivity.this.m6668v(view);
            }
        });
    }

    /* renamed from: R */
    public void m6662R() {
        this.f11854K = !this.f11854K;
        if (this.f11854K) {
            Util.m243a(findViewById(R.id.ll_urgent_shipping_setting));
        } else {
            Util.m243a(findViewById(R.id.ll_urgent_shipping_setting));
        }
    }


    public  void m6663a(SwitchView switchView, boolean z) {
        m6662R();
    }


    public final void m6664a(ShippingMethods shippingMethods) {
        String str;
        String str2;
        if (shippingMethods != null) {
            this.f11855L = shippingMethods;
            ((RadioButton) findViewById(R.id.crb_kpw)).setChecked(this.f11855L.setting.shippingCurrency.equals("kpw"));
            ((RadioButton) findViewById(R.id.crb_kpf)).setChecked(this.f11855L.setting.shippingCurrency.equals("kpf"));
            ((AddressAreaPicker) findViewById(R.id.pt_zones)).setAddressData(this.f11855L.areas);
            this.f11857N = this.f11855L.areas;
            EditForm editForm = (EditForm) findViewById(R.id.ef_common_price);
            if (this.f11855L.setting.price == 0.0f) {
                str = "";
            } else {
                str = this.f11855L.setting.price + "";
            }
            editForm.setText(str);
            ((EditForm) findViewById(R.id.ef_common_price)).setTextColor(getResources().getIdentifier(this.f11855L.setting.shippingCurrency, "color", getPackageName()));
            ((TextView) findViewById(R.id.tv_common_price_unit)).setText(this.f11855L.setting.shippingCurrency.equals("kpw") ? getResources().getString(R.string.price_unit) : "$");
            ((EditForm) findViewById(R.id.ef_common_shipping_date)).setText((this.f11855L.setting.time / 24) + "");
            ((EditForm) findViewById(R.id.ef_common_shipping_hour)).setText((this.f11855L.setting.time % 24) + "");
            ((SwitchView) findViewById(R.id.csv_urgent)).setChecked(this.f11855L.setting.enableUrgent);
            findViewById(R.id.ll_urgent_shipping_setting).setVisibility(this.f11855L.setting.enableUrgent ? View.VISIBLE : View.GONE);
            this.f11854K = this.f11855L.setting.enableUrgent;
            EditForm editForm2 = (EditForm) findViewById(R.id.ef_urgent_price);
            if (this.f11855L.setting.urgentPrice == 0.0f) {
                str2 = "";
            } else {
                str2 = this.f11855L.setting.urgentPrice + "";
            }
            editForm2.setText(str2);
            ((EditForm) findViewById(R.id.ef_urgent_price)).setTextColor(getResources().getIdentifier(this.f11855L.setting.shippingCurrency, "color", getPackageName()));
            ((TextView) findViewById(R.id.tv_urgent_price_unit)).setText(this.f11855L.setting.shippingCurrency.equals("kpw") ? getResources().getString(R.string.price_unit) : "$");
            ((EditForm) findViewById(R.id.ef_urgent_shipping_date)).setText((this.f11855L.setting.urgentTime / 24) + "");
            ((EditForm) findViewById(R.id.ef_urgent_shipping_hour)).setText((this.f11855L.setting.urgentTime % 24) + "");
            EditForm editForm3 = (EditForm) findViewById(R.id.ef_common_price);
            EditForm editForm4 = (EditForm) findViewById(R.id.ef_urgent_price);
            EditForm editForm5 = (EditForm) findViewById(R.id.ef_common_shipping_date);
            EditForm editForm6 = (EditForm) findViewById(R.id.ef_urgent_shipping_date);
            EditForm editForm7 = (EditForm) findViewById(R.id.ef_common_shipping_hour);
            EditForm editForm8 = (EditForm) findViewById(R.id.ef_urgent_shipping_hour);
            editForm3.setEditListener(new C3209a(this, editForm3));
            editForm4.setEditListener(new C3210b(this, editForm4));
            editForm5.setEditListener(new C3211c(this, editForm5));
            editForm6.setEditListener(new C3212d(this, editForm6));
            editForm7.setEditListener(new C3213e(this, editForm7));
            editForm8.setEditListener(new C3214f(this, editForm8));
        }
    }


    public  void m6665b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            ShippingMethods shippingMethods = this.f11855L;
            shippingMethods.areas = this.f11857N;
            ShippingMethods.SettingInfo settingInfo = this.f11856M;
            if (settingInfo != null) {
                shippingMethods.setting = settingInfo;
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_shipping_method);
        m4307e(R.string.manage_shipping_method);
        ModelCollection.m5435b(this);
        ModelCollection.f10220k.observe(this, new Observer() { // from class: b.f.a.a.i.s2
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorShippingMethodActivity.this.m6664a((ShippingMethods) obj);
            }
        });
        mo4284G();
        addBottomNav(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x012c, code lost:
    
        if (r5.urgentTime == r2) goto L46;
     */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m6666t(android.view.View r12) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.activities.seller.VendorShippingMethodActivity.m6666t(android.view.View):void");
    }

    /* renamed from: u */
    public  void m6667u(View view) {
        ((TextView) findViewById(R.id.tv_urgent_price_unit)).setText(((RadioButton) findViewById(R.id.crb_kpw)).isChecked() ? getResources().getString(R.string.price_unit) : "$");
        ((TextView) findViewById(R.id.tv_common_price_unit)).setText(((RadioButton) findViewById(R.id.crb_kpw)).isChecked() ? getResources().getString(R.string.price_unit) : "$");
        ((EditForm) findViewById(R.id.ef_common_price)).setTextColor(getResources().getIdentifier(((RadioButton) findViewById(R.id.crb_kpw)).isChecked() ? "kpw" : "kpf", "color", getPackageName()));
        ((EditForm) findViewById(R.id.ef_urgent_price)).setTextColor(getResources().getIdentifier(((RadioButton) findViewById(R.id.crb_kpw)).isChecked() ? "kpw" : "kpf", "color", getPackageName()));
    }

    /* renamed from: v */
    public  void m6668v(View view) {
        ((TextView) findViewById(R.id.tv_urgent_price_unit)).setText(!((RadioButton) findViewById(R.id.crb_kpf)).isChecked() ? getResources().getString(R.string.price_unit) : "$");
        ((TextView) findViewById(R.id.tv_common_price_unit)).setText(((RadioButton) findViewById(R.id.crb_kpf)).isChecked() ? "$" : getResources().getString(R.string.price_unit));
        ((EditForm) findViewById(R.id.ef_common_price)).setTextColor(getResources().getIdentifier(((RadioButton) findViewById(R.id.crb_kpf)).isChecked() ? "kpf" : "kpw", "color", getPackageName()));
        ((EditForm) findViewById(R.id.ef_urgent_price)).setTextColor(getResources().getIdentifier(((RadioButton) findViewById(R.id.crb_kpf)).isChecked() ? "kpf" : "kpw", "color", getPackageName()));
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
