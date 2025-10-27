package com.jeil.emarket.activities.auth;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;

import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.model.vendor.VendorUser;
import com.jeil.emarket.services.BackgroundService;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.VendorListVM;


public class VendorLoginActivity extends BaseActivity {

    
    public FingerprintManager f11714I = null;

   
    public CancellationSignal f11715J;

    
    public FingerprintManager.AuthenticationCallback authenticationCallback;

    /* renamed from: com.jeil.emarket.activities.auth.VendorLoginActivity$a */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public class C3191a extends FingerprintManager.AuthenticationCallback {


        public final  AppCompatImageView f11717a;

        public C3191a(AppCompatImageView appCompatImageView) {
            this.f11717a = appCompatImageView;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            super.onAuthenticationError(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            Util.toast(VendorLoginActivity.this, R.string.fingerprint_error, "error");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11717a, "translationX", 0.0f, -15.0f, 0.0f, 15.0f, 0.0f);
            ofFloat.setDuration(400L);
            ofFloat.setRepeatCount(1);
            ofFloat.start();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            super.onAuthenticationHelp(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            super.onAuthenticationSucceeded(authenticationResult);
            final VendorLoginActivity vendorLoginActivity = VendorLoginActivity.this;
            final String getValue = UserVM.stringMutableLiveData1.getValue();
            API_PROVIDER.checkInternet(vendorLoginActivity, new InterfaceContext() { // from class: b.f.a.k.h
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context) {
                    UserVM.m5536b(vendorLoginActivity, getValue, context);
                }
            });
            final DialogC2001j dialogC2001j = new DialogC2001j(VendorLoginActivity.this);
            dialogC2001j.show();
            UserVM.f10342s.observe(VendorLoginActivity.this, new Observer() { // from class: b.f.a.a.b.w0
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    dialogC2001j.dismiss();
                }
            });
        }
    }


    public static  void m6440a(DialogC2001j dialogC2001j, View view, Integer num) {
        dialogC2001j.dismiss();
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        ((EditForm) findViewById(R.id.cef_password)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorLoginActivity.this.m6448d(view);
            }
        });
        ((EditForm) findViewById(R.id.cef_password)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.a.b.z0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return VendorLoginActivity.this.m6446a(textView, i, keyEvent);
            }
        });
        findViewById(R.id.cb_login).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorLoginActivity.this.m6449e(view);
            }
        });
    }

    
    public void m6442I() {
        findViewById(R.id.tv_customer_notice).setVisibility(View.GONE);
        findViewById(R.id.tv_vendor_notice).setVisibility(View.VISIBLE);
        findViewById(R.id.cef_cid).setVisibility(View.GONE);
        findViewById(R.id.ll_auto_login).setVisibility(View.GONE);
        findViewById(R.id.ll_save_info).setVisibility(View.GONE);
        findViewById(R.id.mrl_register).setVisibility(View.GONE);
        findViewById(R.id.llc_actions).setVisibility(View.GONE);
    }

   
    public boolean m6443J() {
        FingerprintManager fingerprintManager;
        if (Build.VERSION.SDK_INT >= 23 && (fingerprintManager = this.f11714I) != null && fingerprintManager.isHardwareDetected()) {
            return this.f11714I.hasEnrolledFingerprints();
        }
        return false;
    }

    
    public void m6444K() {
        if (m6443J()) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    this.f11714I.authenticate(null, this.f11715J, 0, this.authenticationCallback, null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: L */
    public void m6445L() {
        if (m6443J()) {
            try {
                this.f11715J.cancel();
                this.f11715J = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public  boolean m6446a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m6449e(findViewById(R.id.cef_password));
        return false;
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1

    public void mo4302b(final User user) {
        if (user != null) {
            TicketCategoryListVM.m5496a(this);
        }
        if (user != null) {
            final EditForm editForm = (EditForm) findViewById(R.id.cef_name);
            editForm.setText(user.name);
            editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    editForm.setText(user.name);
                }
            });
        }
    }


    public  void m6448d(View view) {
        ((EditForm) findViewById(R.id.cef_password)).showeye();
    }


    public final void m6449e(final View view) {
        if (((EditForm) findViewById(R.id.cef_name)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_username), "error", 0, 0);
            return;
        }
        if (((EditForm) findViewById(R.id.cef_password)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_password), "error", 0, 0);
            return;
        }
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.m5537b(this, ((EditForm) findViewById(R.id.cef_name)).getText(), ((EditForm) findViewById(R.id.cef_password)).getText());
        UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.b.b1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorLoginActivity.m6440a(dialogC2001j, view, (Integer) obj);
            }
        });
        view.setEnabled(false);
        view.setAlpha(0.5f);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        m4307e(R.string.login_as_vendor);
        m6442I();
        addBottomNav(R.id.navigation_account);
        EditForm editForm = (EditForm) findViewById(R.id.cef_name);
        if (UserVM.sharedPreferences.getBoolean("save_vendor_info", false)) {
            editForm.setText(UserVM.sharedPreferences.getString("saved_username", ""));
            ((EditForm) findViewById(R.id.cef_password)).setText(UserVM.sharedPreferences.getString("save_password", ""));
            ((CheckBox) findViewById(R.id.cb_save_info)).setChecked(true);
        }
        if (UserVM.userMutableLiveData.getValue() == null) {
            UserVM.userMutableLiveData.setValue( null);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(Context.FINGERPRINT_SERVICE);
            if (fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints()) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R.id.iv_fingerprint);
                appCompatImageView.setVisibility(View.VISIBLE);
                this.f11714I = (FingerprintManager) getSystemService(FingerprintManager.class);
                this.f11715J = new CancellationSignal();
                this.authenticationCallback = new C3191a(appCompatImageView);
                m6444K();
            }
        }
        UserVM.vendorUserMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.b.a1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorLoginActivity.this.m6447b((VendorUser) obj);
            }
        });
        mo4284G();
    }

    @Override // p000a.p005b.p006a.ActivityC0045t, p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m6445L();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }


    public  void m6447b(VendorUser vendorUser) {
        if (vendorUser == null) {
            CustomButton customButton = (CustomButton) findViewById(R.id.cb_login);
            customButton.setEnabled(true);
            customButton.setAlpha(1.0f);
            return;
        }
        if (!vendorUser.user.role.equals("vendorAgent") && !vendorUser.user.role.equals("vendorShippingManager")) {
            VendorListVM.m5560a(this);
            VendorListVM.f10368i = new MutableLiveData<>();
            String m4768a = DBManager.getDB().Delete("vendorVariableProducts");
            if (m4768a.isEmpty()) {
                API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.f2
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context) {
                        new API_PROVIDER(context, "get_vendor_all_variable_products", new VendorListVM()).m5406a("e7/variable/products");
                    }
                });
            } else {
                VendorListVM.m5567b(m4768a, "get_vendor_all_variable_products", 400, true);
            }
        }
        SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
        boolean isChecked = ((CheckBox) findViewById(R.id.cb_save_info)).isChecked();
        edit.putBoolean("save_vendor_info", isChecked);
        if (isChecked) {
            edit.putString("saved_username", ((EditForm) findViewById(R.id.cef_name)).getText());
            edit.putString("save_password", ((EditForm) findViewById(R.id.cef_password)).getText());
        }
        edit.apply();
        VendorListVM.m5568c(this);
        if (UserVM.userMutableLiveData.getValue() != null) {
            BackgroundService.f12459o = this;
            startService(new Intent(this, BackgroundService.class));
        }
        Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
        VendorUser getValue = UserVM.vendorUserMutableLiveData.getValue();
        if (getValue != null && (getValue.user.role.equals("vendorAgent") || getValue.user.role.equals("vendorShippingManager"))) {
            MainActivityForVendor.global_id = R.id.navigation_orders;
        }
        if (getValue != null && getValue.user.role.equals("vendorProductManager")) {
            MainActivityForVendor.global_id = R.id.navigation_products;
        }
        startActivity(intent);
        finish();
    }
}
