package com.jeil.emarket.activities.auth;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.components.AccountNavItem;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.checkbox.CheckBox;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.MarketConnection;
import com.jeil.emarket.model.customer.User;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.jeil.emarket.listener.loginlistener.LoginAniListener;
import com.jeil.emarket.listener.loginlistener.LoginAniListener1;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.api.CERT_PROVIDER;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;


public class LoginActivity extends BaseActivity {

   
    public String f11687J;

    /* renamed from: L */
    public PickerObj3 f11689L;


    public ImageDialog2 f11686I = null;


    public Date f11688K = new Date();

    /* renamed from: M */
    public ImageDialog2 f11690M = null;

    /* renamed from: N */
    public ImageDialog2 f11691N = null;

    /* renamed from: O */
    public LinearLayoutCompat[] f11692O = new LinearLayoutCompat[3];

    /* renamed from: P */
    public com.jeil.emarket.components.textview.TextView[] f11693P = new com.jeil.emarket.components.textview.TextView[3];

    /* renamed from: Q */
    public EditForm[] f11694Q = new EditForm[3];

    /* renamed from: R */
    public ImageDialog2 f11695R = null;

    /* renamed from: S */
    public boolean f11696S = false;

    /* renamed from: T */
    public int f11697T = 1;


    public static  void m6381a(View view, DialogC2001j dialogC2001j, Integer num) {
        view.setEnabled(true);
        view.setAlpha(1.0f);
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        findViewById(R.id.cb_save_info).setVisibility(View.GONE);
        findViewById(R.id.mrl_register).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m6400d(view);
            }
        });
        UserVM.m5531a((BaseActivity) this, false);
        final EditForm editForm = (EditForm) findViewById(R.id.cef_cid);
        editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m6402e(view);
            }
        });
        UserVM.stringMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.b.i
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LoginActivity.this.m6389a(editForm, (String) obj);
            }
        });
        ((EditForm) findViewById(R.id.cef_name)).setInputType(1);
        ((EditForm) findViewById(R.id.cef_name)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m6403f(view);
            }
        });
        ((EditForm) findViewById(R.id.cef_password)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m6404g(view);
            }
        });
        ((EditForm) findViewById(R.id.cef_password)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.a.b.n
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(android.widget.TextView textView, int i, KeyEvent keyEvent) {
                return LoginActivity.this.m6392a(textView, i, keyEvent);
            }
        });
        findViewById(R.id.cb_login).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m6411n(view);
            }
        });
        findViewById(R.id.mrl_format_password).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m6405h(view);
            }
        });
        findViewById(R.id.mrl_change_cid).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.this.m6406i(view);
            }
        });
    }


    public void m6383I() {
        SharedPreferences sharedPreferences = UserVM.sharedPreferences;
        if (sharedPreferences == null || !sharedPreferences.getBoolean("auto_login", false)) {
            return;
        }
        ((EditForm) findViewById(R.id.cef_cid)).setText(UserVM.sharedPreferences.getString("saved_cid", ""));
        ((EditForm) findViewById(R.id.cef_name)).setText(UserVM.sharedPreferences.getString("saved_username", ""));
        ((EditForm) findViewById(R.id.cef_password)).setText(UserVM.sharedPreferences.getString("save_password", ""));
        if (UserVM.sharedPreferences.getBoolean("auto_login", false)) {
            ((CheckBox) findViewById(R.id.cb_auto_login)).setChecked(true);
        }
    }

   
    public void m6384J() {
        this.f11689L = new PickerObj3(this, true, Calendar.getInstance().get(1) - 10);
    }


    public  void m6385a(View view, CustomButton customButton, CustomButton customButton2, View view2) {
        String str;
        int i = this.f11697T;
        if (i != 1) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11692O[i - 1], "translationX", 0.0f, BaseActivity.anInt);
            ofFloat.setDuration(300L);
            ofFloat.start();
            ofFloat.addListener(new LoginAniListener(this, view));
            this.f11692O[this.f11697T - 2].setVisibility(View.VISIBLE);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11692O[this.f11697T - 2], "translationX", -BaseActivity.anInt, 0.0f);
            ofFloat2.setDuration(300L);
            ofFloat2.start();
            this.f11697T--;
            com.jeil.emarket.components.textview.TextView textView = this.f11693P[this.f11697T - 1];
            if (UserVM.f10343t.getValue() == null || UserVM.f10343t.getValue().size() == 0) {
                str = "";
            } else {
                str = this.f11697T + ". " + this.questionHashMap.get(Integer.valueOf(UserVM.f10343t.getValue().get(this.f11697T - 1).questionId - 1));
            }
            textView.setText(str);
        } else {
            this.f11691N.dismiss();
        }
        m6387a(customButton, customButton2);
    }


    public final void m6387a(CustomButton customButton, CustomButton customButton2) {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        if (this.f11697T == 1) {
            resources = getResources();
            i = R.string.cancel;
        } else {
            resources = getResources();
            i = R.string.action_prev;
        }
        customButton.setText(resources.getString(i));
        if (this.f11697T == 3) {
            resources2 = getResources();
            i2 = R.string.ok;
        } else {
            resources2 = getResources();
            i2 = R.string.action_next;
        }
        customButton2.setText(resources2.getString(i2));
    }


    public  void m6388a(EditForm editForm, EditForm editForm2, boolean z, EditForm editForm3, com.jeil.emarket.components.textview.TextView textView, MaterialRippleLayout materialRippleLayout, EditForm editForm4, boolean z2, View view) {
        boolean z3;
        if (editForm.getText().isEmpty()) {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z3 = true;
        } else {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            z3 = false;
        }
        if (editForm2.getText().isEmpty()) {
            editForm2.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z3 = true;
        } else {
            editForm2.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (!z) {
            if (editForm3.getText().isEmpty()) {
                editForm3.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
                z3 = true;
            } else {
                editForm3.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            }
            if (textView.getText().toString().isEmpty()) {
                materialRippleLayout.setBackgroundResource(R.drawable.bd_warn_input);
                z3 = true;
            } else {
                materialRippleLayout.setBackgroundResource(R.drawable.bg_input_border);
            }
            if (editForm4.getText().isEmpty()) {
                editForm4.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
                z3 = true;
            } else {
                editForm4.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            }
        }
        if (z3) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", editForm.getText());
            jSONObject.put("password", Base64.encodeToString(editForm2.getText().getBytes(), 0));
            jSONObject.put("isLogin", z2);
            if (!z) {
                jSONObject.put("fullname", editForm3.getText());
                jSONObject.put("birthday", this.f11688K);
                jSONObject.put("name", editForm4.getText());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UserVM.m5528a(this, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.b.o
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LoginActivity.this.m6398c(dialogC2001j, (Integer) obj);
            }
        });
    }


    public  void m6389a(EditForm editForm, String str) {
        editForm.setText(str);
        m6391a(true);
    }


    public  void m6390a(com.jeil.emarket.components.textview.TextView textView, Date date, View view) {
        this.f11688K = date;
        textView.setText(Util.date2Str(date));
    }


    public void m6391a(boolean z) {
        if (((EditForm) findViewById(R.id.cef_cid)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_cid), "error", 0, 0);
            return;
        }
        UserVM.m5544d(this);
        if (z) {
            return;
        }
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.b.x
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LoginActivity.this.m6386a(dialogC2001j, (Integer) obj);
            }
        });
    }


    public  boolean m6392a(android.widget.TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m6411n(findViewById(R.id.cef_password));
        return false;
    }


    public  void m6393b(DialogInterface dialogInterface) {
        this.f11696S = false;
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1

    public void mo4302b(User user) {
        if (user != null) {
            TicketCategoryListVM.m5496a(this);
        }
        if (user == null) {
            CustomButton customButton = (CustomButton) findViewById(R.id.cb_login);
            customButton.setEnabled(true);
            customButton.setAlpha(1.0f);
            return;
        }
        SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
        edit.putBoolean("auto_login", ((CheckBox) findViewById(R.id.cb_auto_login)).isChecked());
        edit.putString("save_password", ((EditForm) findViewById(R.id.cef_password)).getText());
        if (((CheckBox) findViewById(R.id.cb_auto_login)).isChecked()) {
            edit.putString("saved_username", ((EditForm) findViewById(R.id.cef_name)).getText());
        }
        SharedPreferences sharedPreferences = UserVM.sharedPreferences;
        if (sharedPreferences == null || !sharedPreferences.getBoolean("show_ticket", false) || TicketCategoryListVM.f10284j.getValue() == null || TicketCategoryListVM.f10284j.getValue().intValue() == 0) {
            ((AccountNavItem) findViewById(R.id.ani_ticket)).m6809a(false);
        } else {
            ((AccountNavItem) findViewById(R.id.ani_ticket)).m6809a(true);
        }
        edit.apply();
        setResult(-1);
        finish();
    }


    public void m6396b(String str) {
        ((EditForm) findViewById(R.id.cef_name)).setText(str);
    }


    public  void m6397c(DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public  void m6398c(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f11686I.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m6399d(DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public  void m6400d(View view) {
        startActivityForResult(new Intent(getApplicationContext(), RegisterActivity.class), 100);
    }


    public  void m6401e(DialogInterface dialogInterface) {
        this.f11696S = false;
    }


    public  void m6402e(View view) {
        UserVM.m5531a((BaseActivity) this, false);
    }

    /* renamed from: f */
    public  void m6403f(View view) {
        m6391a(false);
    }

    /* renamed from: g */
    public  void m6404g(View view) {
        ((EditForm) findViewById(R.id.cef_password)).showeye();
    }

    /* renamed from: h */
    public  void m6405h(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        ImageDialog2 imageDialog2 = this.f11690M;
        if (imageDialog2 != null) {
            imageDialog2.show();
        } else {
            View inflate = View.inflate(this, R.layout.dialog_format_password, null);
            CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_connect_with_admin);
            CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_faq);
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginActivity.this.m6408k(view2);
                }
            });
            customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginActivity.this.m6409l(view2);
                }
            });
            this.f11690M = Util.getImageDialog2((Activity) this, inflate);
            this.f11690M.show();
            this.f11690M.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.b.s
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LoginActivity.this.m6399d(dialogInterface);
                }
            });
        }
        UserVM.m5541c(this);
    }


    public  void m6406i(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        View inflate = View.inflate(this, R.layout.dialog_change_cid, null);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_cid);
        final EditForm editForm2 = (EditForm) inflate.findViewById(R.id.cef_full_name);
        final MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) inflate.findViewById(R.id.mrl_birthday);
        final EditForm editForm3 = (EditForm) inflate.findViewById(R.id.cef_password);
        final com.jeil.emarket.components.textview.TextView textView = (com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.tv_birthday);
        final EditForm editForm4 = (EditForm) inflate.findViewById(R.id.cef_user_name);
        editForm.setRippleColor(R.color.white);
        editForm2.setRippleColor(R.color.white);
        editForm4.setRippleColor(R.color.white);
        this.f11689L.f8619c = new InterfaceC2115g() { // from class: b.f.a.a.b.u
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

            public final void mo4267a(Date date, View view2) {
                LoginActivity.this.m6390a(textView, date, view2);
            }
        };
        materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginActivity.this.m6407j(view2);
            }
        });
        editForm3.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                editForm3.showeye();
            }
        });
        final boolean z = UserVM.userMutableLiveData.getValue() != null;
        editForm2.setVisibility(z ? View.GONE : View.VISIBLE);
        materialRippleLayout.setVisibility(z ? View.GONE : View.VISIBLE);
        editForm4.setVisibility(z ? View.GONE : View.VISIBLE);
        editForm.setHintText(getResources().getString(z ? R.string.new_cid : R.string.prev_cid));
        final boolean z2 = z;
        ((CustomButton) inflate.findViewById(R.id.cb_change)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginActivity.this.m6388a(editForm, editForm3, z2, editForm2, textView, materialRippleLayout, editForm4, z, view2);
            }
        });
        this.f11686I = Util.getImageDialog2((Activity) this, inflate);
        this.f11686I.show();
        this.f11686I.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.b.t
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LoginActivity.this.m6397c(dialogInterface);
            }
        });
    }

   
    public  void m6407j(View view) {
        this.f11689L.m4710a();
    }


    public  void m6408k(View view) {
        List<String> list;
        MarketConnection getValue = UserVM.marketConnection.getValue();
        if (getValue == null || (list = getValue.servicePhone) == null || list.size() == 0) {
            Util.toast(this, getResources().getString(R.string.not_exist_connection_phone), "error", 0, 0);
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + getValue.servicePhone.get(0))));
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: l */
    public  void m6409l(View view) {
        String str;
        if (this.f11696S) {
            return;
        }
        this.f11696S = true;
        if (UserVM.f10343t.getValue() == null || UserVM.f10343t.getValue().size() == 0) {
            Util.toast(this, getResources().getString(R.string.not_exist_faq_question), "error", 0, 0);
            this.f11696S = false;
            return;
        }
        final View inflate = View.inflate(this, R.layout.dialog_answer_password_faq, null);
        this.f11692O = new LinearLayoutCompat[]{(LinearLayoutCompat) inflate.findViewById(R.id.llc_first), (LinearLayoutCompat) inflate.findViewById(R.id.llc_second), (LinearLayoutCompat) inflate.findViewById(R.id.llc_third)};
        this.f11693P = new com.jeil.emarket.components.textview.TextView[]{(com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.ctv_question1), (com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.ctv_question2), (com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.ctv_question3)};
        this.f11694Q = new EditForm[]{(EditForm) inflate.findViewById(R.id.cef_answer1), (EditForm) inflate.findViewById(R.id.cef_answer2), (EditForm) inflate.findViewById(R.id.cef_answer3)};
        com.jeil.emarket.components.textview.TextView textView = this.f11693P[this.f11697T - 1];
        if (UserVM.f10343t.getValue() == null || UserVM.f10343t.getValue().size() == 0) {
            str = "";
        } else {
            str = this.f11697T + ". " + this.questionHashMap.get(Integer.valueOf(UserVM.f10343t.getValue().get(this.f11697T - 1).questionId - 1));
        }
        textView.setText(str);
        final CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_ok);
        final CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        m6387a(customButton2, customButton);
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginActivity.this.m6385a(inflate, customButton2, customButton, view2);
            }
        });
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginActivity.this.m6394b(inflate, customButton2, customButton, view2);
            }
        });
        this.f11691N = Util.getImageDialog2((Activity) this, inflate);
        this.f11691N.show();
        this.f11691N.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.b.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LoginActivity.this.m6393b(dialogInterface);
            }
        });
    }

    /* renamed from: m */
    public  void m6410m(View view) {
        SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
        edit.putBoolean("isFormatted", true);
        edit.putString("save_password", UserVM.f10344u.getValue());
        edit.apply();
        ((EditForm) findViewById(R.id.cef_password)).setText(UserVM.f10344u.getValue());
        this.f11695R.dismiss();
    }

    /* renamed from: n */
    public final void m6411n(final View view) {
        if (((EditForm) findViewById(R.id.cef_cid)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_cid), "error", 0, 0);
            return;
        }
        if (!UserVM.f10340q) {
            if (((EditForm) findViewById(R.id.cef_name)).getText().isEmpty()) {
                Util.toast(this, getString(R.string.enter_username), "error", 0, 0);
                return;
            } else if (((EditForm) findViewById(R.id.cef_password)).getText().isEmpty()) {
                Util.toast(this, getString(R.string.enter_password), "error", 0, 0);
                return;
            }
        }
        String text = ((EditForm) findViewById(R.id.cef_password)).getText();
        final String text2 = ((EditForm) findViewById(R.id.cef_name)).getText();
        if (text.equals(this.f11687J)) {
            text = "";
        }
        if (!UserVM.f10347x) {
            UserVM.f10342s = new MutableLiveData<>();
            String finalText = text;
            API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.c
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context) {
                    UserVM.m5538b(context, text2, finalText, context);
                }
            });
        }
        view.setEnabled(false);
        view.setAlpha(0.5f);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.b.p
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LoginActivity.m6381a(view, dialogC2001j, (Integer) obj);
            }
        });
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("username");
            String stringExtra2 = intent.getStringExtra("password");
            if (!stringExtra.isEmpty() && !stringExtra2.isEmpty()) {
                ((EditForm) findViewById(R.id.cef_name)).setText(stringExtra);
                ((EditForm) findViewById(R.id.cef_password)).setText(stringExtra2);
            }
        }
        if (intent == null || 123 != i) {
            return;
        }
        SetDescription();
        CERT_PROVIDER.m5415a(this, intent);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        m4307e(R.string.action_login);
        m6383I();
        addBottomNav(R.id.navigation_account);
        UserVM.stringMutableLiveData1.observe(this, new Observer() { // from class: b.f.a.a.b.c1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                LoginActivity.this.m6396b((String) obj);
            }
        });
        if (UserVM.f10340q) {
            EditForm editForm = (EditForm) findViewById(R.id.cef_password);
            editForm.hide();
            findViewById(R.id.mrl_register).setVisibility(View.GONE);
            findViewById(R.id.llc_actions).setVisibility(View.GONE);
            String m343e = Util.m343e(16);
            editForm.setText(m343e);
            this.f11687J = m343e;
        }
        m6384J();
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }


    public  void m6395b(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200 && this.f11691N != null) {
            this.f11690M.m4595e();
            this.f11691N.m4595e();
            this.f11696S = true;
            this.f11697T = 1;
            View inflate = View.inflate(this, R.layout.dialog_formatted_password_show, null);
            com.jeil.emarket.components.textview.TextView textView = (com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.tv_formatted_password);
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.formatted_password));
            sb.append(" ");
            sb.append(UserVM.f10344u.getValue() != null ? UserVM.f10344u.getValue() : "");
            textView.setText(sb.toString());
            ((CustomButton) inflate.findViewById(R.id.cb_ok)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginActivity.this.m6410m(view);
                }
            });
            this.f11695R = Util.getImageDialog2((Activity) this, inflate);
            this.f11695R.show();
            this.f11695R.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.b.y
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LoginActivity.this.m6401e(dialogInterface);
                }
            });
        }
        dialogC2001j.dismiss();
    }


    public  void m6386a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 400) {
            Util.toast(this, getString(R.string.require_register), "error", 0, 0);
        }
        dialogC2001j.dismiss();
    }


    public  void m6394b(View view, CustomButton customButton, CustomButton customButton2, View view2) {
        String str;
        if (this.f11694Q[this.f11697T - 1].getText().isEmpty()) {
            this.f11694Q[this.f11697T - 1].setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
        } else {
            this.f11694Q[this.f11697T - 1].setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            if (UserVM.f10343t.getValue() == null || UserVM.f10343t.getValue().size() == 0 || !UserVM.f10343t.getValue().get(this.f11697T - 1).answer.equals(this.f11694Q[this.f11697T - 1].getText())) {
                Util.toast(this, getResources().getString(R.string.not_equal_answer_warning_notice), "error", 0, 0);
            } else {
                int i = this.f11697T;
                if (i == 3) {
                    UserVM.f10342s = new MutableLiveData<>();
                    UserVM.f10344u = new MutableLiveData<>();
                    API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.e
                        @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                        public final void mo4271a(Context context) {
                            new API_PROVIDER(context, "get_formatted_password", new UserVM()).m5406a("e6/auth/password");
                        }
                    });
                    final DialogC2001j dialogC2001j = new DialogC2001j(this);
                    dialogC2001j.show();
                    UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.b.c
                        @Override // p000a.p060o.InterfaceC0405p

                        public final void onChanged(Object obj) {
                            LoginActivity.this.m6395b(dialogC2001j, (Integer) obj);
                        }
                    });
                } else {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11692O[i - 1], "translationX", 0.0f, -BaseActivity.anInt);
                    ofFloat.setDuration(300L);
                    ofFloat.start();
                    ofFloat.addListener(new LoginAniListener1(this, view));
                    this.f11692O[this.f11697T].setVisibility(View.VISIBLE);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11692O[this.f11697T], "translationX", BaseActivity.anInt, 0.0f);
                    ofFloat2.setDuration(300L);
                    ofFloat2.start();
                    this.f11697T++;
                    com.jeil.emarket.components.textview.TextView textView = this.f11693P[this.f11697T - 1];
                    if (UserVM.f10343t.getValue() == null || UserVM.f10343t.getValue().size() == 0) {
                        str = "";
                    } else {
                        str = this.f11697T + ". " + this.questionHashMap.get(Integer.valueOf(UserVM.f10343t.getValue().get(this.f11697T - 1).questionId - 1));
                    }
                    textView.setText(str);
                }
            }
        }
        m6387a(customButton, customButton2);
    }
}
