package com.jeil.emarket.activities.auth;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.Observer;

import com.jeil.emarket.custom.Util;
import com.jeil.emarket.listener.loginlistener.RegisterAniListener;
import com.jeil.emarket.listener.loginlistener.RegisterAniListener1;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.api.CERT_PROVIDER;
import com.jeil.emarket.viewmodel.UserVM;


public class RegisterActivity extends BaseActivity {

    
    public PickerObj3 f11700I;

    
    public BaseDialog2 f11702K;

   
    public Date f11701J = new Date();

    /* renamed from: L */
    public boolean f11703L = false;

    /* renamed from: M */
    public ImageDialog2 f11704M = null;

    /* renamed from: N */
    public BaseDialog2 f11705N = null;

    /* renamed from: O */
    public int[] f11706O = new int[3];

    /* renamed from: P */
    public String[] f11707P = new String[3];

    /* renamed from: Q */
    public LinearLayoutCompat[] f11708Q = new LinearLayoutCompat[3];

    /* renamed from: R */
    public LinearLayoutCompat[] f11709R = new LinearLayoutCompat[3];

    /* renamed from: S */
    public TextView[] f11710S = new TextView[3];

    /* renamed from: T */
    public EditForm[] f11711T = new EditForm[3];

    /* renamed from: U */
    public int f11712U = 1;

    /* renamed from: V */
    public boolean f11713V = false;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        ((EditForm) findViewById(R.id.cef_full_name)).setRippleColor(R.color.white);
        UserVM.m5531a((BaseActivity) this, false);
        ((EditForm) findViewById(R.id.cef_cid)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6431d(view);
            }
        });
        UserVM.stringMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.b.o0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                RegisterActivity.this.m6428b((String) obj);
            }
        });
        this.f11700I.f8619c = new InterfaceC2115g() { // from class: b.f.a.a.b.i0
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

            public final void mo4267a(Date date, View view) {
                RegisterActivity.this.m6425a(date, view);
            }
        };
        findViewById(R.id.mrl_birthday).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6432e(view);
            }
        });
        findViewById(R.id.mrl_user_name).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6433f(view);
            }
        });
        findViewById(R.id.cb_sign_up).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6439l(view);
            }
        });
        ((EditForm) findViewById(R.id.cef_new_password)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6434g(view);
            }
        });
        ((EditForm) findViewById(R.id.cef_confirm_password)).setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6435h(view);
            }
        });
    }

    
    public void m6414I() {
        this.f11700I = new PickerObj3(this, true, Calendar.getInstance().get(1) - 10);
    }

   
    public void m6415J() {
        int checkedRadioButtonId = ((RadioGroup) findViewById(R.id.rg_gender)).getCheckedRadioButtonId();
        final String str = checkedRadioButtonId == R.id.crb_male ? "male" : checkedRadioButtonId == R.id.crb_female ? "female" : "";
        final View inflate = View.inflate(this, R.layout.dialog_save_password_faq, null);
        this.f11708Q = new LinearLayoutCompat[]{(LinearLayoutCompat) inflate.findViewById(R.id.llc_first), (LinearLayoutCompat) inflate.findViewById(R.id.llc_second), (LinearLayoutCompat) inflate.findViewById(R.id.llc_third)};
        this.f11709R = new LinearLayoutCompat[]{(LinearLayoutCompat) inflate.findViewById(R.id.llc_categories1), (LinearLayoutCompat) inflate.findViewById(R.id.llc_categories2), (LinearLayoutCompat) inflate.findViewById(R.id.llc_categories3)};
        this.f11710S = new TextView[]{(TextView) inflate.findViewById(R.id.ctv_question1), (TextView) inflate.findViewById(R.id.ctv_question2), (TextView) inflate.findViewById(R.id.ctv_question3)};
        this.f11711T = new EditForm[]{(EditForm) inflate.findViewById(R.id.cef_answer1), (EditForm) inflate.findViewById(R.id.cef_answer2), (EditForm) inflate.findViewById(R.id.cef_answer3)};
        final CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        final CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        m6422a(customButton, customButton2);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6420a(inflate, customButton, customButton2, view);
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6424a(str, inflate, customButton, customButton2, view);
            }
        });
        inflate.findViewById(R.id.mrl_main_categories1).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6436i(view);
            }
        });
        inflate.findViewById(R.id.mrl_main_categories2).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6437j(view);
            }
        });
        inflate.findViewById(R.id.mrl_main_categories3).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.b.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegisterActivity.this.m6438k(view);
            }
        });
        this.f11704M = Util.m211a((Activity) this, inflate);
        this.f11704M.show();
        this.f11704M.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.b.v0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RegisterActivity.this.m6427b(dialogInterface);
            }
        });
    }

    
    public final void m6416K() {
        if (this.f11713V) {
            return;
        }
        this.f11713V = true;
        m6418M();
    }

    /* renamed from: L */
    public void m6417L() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.putExtra("username", ((TextView) findViewById(R.id.tv_user_name)).getText().toString());
        intent.putExtra("password", ((EditForm) findViewById(R.id.cef_new_password)).getText());
        setResult(-1, intent);
        finish();
    }

    /* renamed from: M */
    public void m6418M() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.questionHashMap.size(); i++) {
            if (this.f11706O.length != 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr = this.f11706O;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    if (i2 != this.f11712U - 1 && iArr[i2] == i + 1) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            z = false;
            arrayList.add(new Cancel_Obj(this.questionHashMap.get(Integer.valueOf(i)), this.f11710S[this.f11712U - 1].getText().equals(this.questionHashMap.get(Integer.valueOf(i))) ? 1 : 0, z));
        }
        this.f11705N = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f11705N;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.b.d0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i3) {
                RegisterActivity.this.m6419a(view, i3);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f11705N;
        baseDialog22.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog22.show();
        this.f11705N.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.b.k0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RegisterActivity.this.m6430c(dialogInterface);
            }
        });
    }


    public  void m6420a(View view, CustomButton customButton, CustomButton customButton2, View view2) {
        int i = this.f11712U;
        if (i != 1) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11708Q[i - 1], "translationX", 0.0f, BaseActivity.anInt);
            ofFloat.setDuration(300L);
            ofFloat.start();
            ofFloat.addListener(new RegisterAniListener(this, view));
            this.f11708Q[this.f11712U - 2].setVisibility(View.VISIBLE);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11708Q[this.f11712U - 2], "translationX", -BaseActivity.anInt, 0.0f);
            ofFloat2.setDuration(300L);
            ofFloat2.start();
            this.f11712U--;
        } else {
            this.f11706O = new int[3];
            this.f11707P = new String[3];
            this.f11704M.dismiss();
        }
        m6422a(customButton, customButton2);
    }


    public  void m6421a(DialogC2001j dialogC2001j, Boolean bool) {
        CustomButton customButton = (CustomButton) findViewById(R.id.cb_sign_up);
        if (customButton != null) {
            customButton.setEnabled(true);
            customButton.setAlpha(1.0f);
        }
        if (bool.booleanValue()) {
            this.f11706O = new int[3];
            this.f11707P = new String[3];
            this.f11712U = 1;
            this.f11704M.m4595e();
            UserVM.f10348y.observe(this, new Observer() { // from class: b.f.a.a.b.m0
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    RegisterActivity.this.m6423a((Integer) obj);
                }
            });
        }
        dialogC2001j.dismiss();
    }


    public final void m6422a(CustomButton customButton, CustomButton customButton2) {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        if (this.f11712U == 1) {
            resources = getResources();
            i = R.string.cancel;
        } else {
            resources = getResources();
            i = R.string.action_prev;
        }
        customButton.setText(resources.getString(i));
        if (this.f11712U == 3) {
            resources2 = getResources();
            i2 = R.string.ok;
        } else {
            resources2 = getResources();
            i2 = R.string.action_next;
        }
        customButton2.setText(resources2.getString(i2));
    }


    public  void m6423a(Integer num) {
        if (num != null && num.intValue() != 0) {
            m6417L();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), PassCodeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, 158);
    }


    public  void m6424a(String str, View view, CustomButton customButton, CustomButton customButton2, View view2) {
        boolean z;
        int[] iArr = this.f11706O;
        int i = this.f11712U;
        if (iArr[i - 1] == 0) {
            this.f11709R[i - 1].setBackgroundResource(R.drawable.bd_warn_input);
            z = true;
        } else {
            this.f11709R[i - 1].setBackgroundResource(R.drawable.bg_input_border);
            z = false;
        }
        if (this.f11711T[this.f11712U - 1].getText() == null || this.f11711T[this.f11712U - 1].getText().isEmpty()) {
            this.f11711T[this.f11712U - 1].setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            this.f11711T[this.f11712U - 1].setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (!z) {
            String[] strArr = this.f11707P;
            int i2 = this.f11712U;
            strArr[i2 - 1] = this.f11711T[i2 - 1].getText();
            int i3 = this.f11712U;
            if (i3 == 3) {
                UserVM.m5523a(this, ((TextView) findViewById(R.id.tv_user_name)).getText().toString(), Util.date2Str(this.f11701J), ((EditForm) findViewById(R.id.cef_full_name)).getText(), ((EditForm) findViewById(R.id.cef_new_password)).getText(), str, this.f11706O, this.f11707P);
                final DialogC2001j dialogC2001j = new DialogC2001j(this);
                dialogC2001j.show();
                UserVM.booleanMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.b.r0
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        RegisterActivity.this.m6421a(dialogC2001j, (Boolean) obj);
                    }
                });
            } else {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11708Q[i3 - 1], "translationX", 0.0f, -BaseActivity.anInt);
                ofFloat.setDuration(300L);
                ofFloat.start();
                ofFloat.addListener(new RegisterAniListener1(this, view));
                this.f11708Q[this.f11712U].setVisibility(View.VISIBLE);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11708Q[this.f11712U], "translationX", BaseActivity.anInt, 0.0f);
                ofFloat2.setDuration(300L);
                ofFloat2.start();
                this.f11712U++;
            }
        }
        m6422a(customButton, customButton2);
    }


    public  void m6425a(Date date, View view) {
        this.f11701J = date;
        ((TextView) findViewById(R.id.tv_birthday)).setText(Util.date2Str(date));
    }


    public  void m6426a(String[] strArr, View view, int i) {
        ((TextView) findViewById(R.id.tv_user_name)).setText(strArr[i]);
        this.f11702K.startAni();
    }

    
    public  void m6427b(DialogInterface dialogInterface) {
        this.f11706O = new int[3];
        this.f11707P = new String[3];
        this.f11712U = 1;
        this.f6496A = false;
    }

    
    public  void m6428b(String str) {
        ((EditForm) findViewById(R.id.cef_cid)).setText(str);
    }

    
    public  void m6429b(List list) {
        BaseDialog2 baseDialog2 = this.f11702K;
        if ((baseDialog2 != null && baseDialog2.isShowing()) || list == null || list.size() == 0) {
            return;
        }
        this.f11703L = false;
        final String[] strArr = new String[list.size()];
        list.toArray(strArr);
        this.f11702K = new BaseDialog2(this, strArr, null, 80);
        this.f11702K.show();
        this.f11702K.interface2 = new DialogInterface2() { // from class: b.f.a.a.b.n0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i) {
                RegisterActivity.this.m6426a(strArr, view, i);
            }
        };
    }

    
    public  void m6430c(DialogInterface dialogInterface) {
        this.f11713V = false;
    }

    
    public  void m6431d(View view) {
        UserVM.m5531a((BaseActivity) this, false);
    }

    
    public  void m6432e(View view) {
        this.f11700I.m4710a();
    }

    /* renamed from: f */
    public  void m6433f(View view) {
        if (((EditForm) findViewById(R.id.cef_full_name)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_name), "error", 0, 0);
            return;
        }
        if (((TextView) findViewById(R.id.tv_birthday)).getText().toString().isEmpty()) {
            Util.toast(this, getString(R.string.enter_birthday), "error", 0, 0);
            return;
        }
        if (!this.f11703L) {
            this.f11703L = true;
            UserVM.m5526a((Context) this, ((EditForm) findViewById(R.id.cef_full_name)).getText(), ((TextView) findViewById(R.id.tv_birthday)).getText().toString(), false);
            final DialogC2001j dialogC2001j = new DialogC2001j(this);
            dialogC2001j.show();
            UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.b.h0
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj) {
                    dialogC2001j.dismiss();
                }
            });
        }
        UserVM.f10341r.observe(this, new Observer() { // from class: b.f.a.a.b.q0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                RegisterActivity.this.m6429b((List) obj);
            }
        });
    }

    /* renamed from: g */
    public  void m6434g(View view) {
        ((EditForm) findViewById(R.id.cef_new_password)).showeye();
    }

    /* renamed from: h */
    public  void m6435h(View view) {
        ((EditForm) findViewById(R.id.cef_confirm_password)).showeye();
    }

    
    public  void m6436i(View view) {
        m6416K();
    }

   
    public  void m6437j(View view) {
        m6416K();
    }

    
    public  void m6438k(View view) {
        m6416K();
    }

    /* renamed from: l */
    public final void m6439l(View view) {
        if (((EditForm) findViewById(R.id.cef_cid)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_cid), "error", 0, 0);
            return;
        }
        if (((TextView) findViewById(R.id.tv_user_name)).getText().toString().isEmpty()) {
            Util.toast(this, getString(R.string.enter_username), "error", 0, 0);
            return;
        }
        if (((EditForm) findViewById(R.id.cef_full_name)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_name), "error", 0, 0);
            return;
        }
        if (((TextView) findViewById(R.id.tv_birthday)).getText().toString().isEmpty()) {
            Util.toast(this, getString(R.string.enter_dob), "error", 0, 0);
            return;
        }
        if (((TextView) findViewById(R.id.tv_user_name)).getText().toString().isEmpty()) {
            Util.toast(this, getString(R.string.enter_username), "error", 0, 0);
            return;
        }
        if (((EditForm) findViewById(R.id.cef_new_password)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_password), "error", 0, 0);
            return;
        }
        if (((EditForm) findViewById(R.id.cef_confirm_password)).getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_confirm_password), "error", 0, 0);
            return;
        }
        if (!((EditForm) findViewById(R.id.cef_new_password)).getText().equals(((EditForm) findViewById(R.id.cef_confirm_password)).getText())) {
            Util.toast(this, getString(R.string.enter_correct_password), "error", 0, 0);
            return;
        }
        if (((EditForm) findViewById(R.id.cef_new_password)).getText().length() < 8) {
            Util.toast(this, String.format(getResources().getString(R.string.enter_password_limit), 8), "error", 0, 0);
        } else {
            if (this.f6496A) {
                return;
            }
            this.f6496A = true;
            m6415J();
        }
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 123 == i) {
            SetDescription();
            CERT_PROVIDER.m5415a(this, intent);
        } else if (158 == i && i2 == -1) {
            m6417L();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register);
        m4307e(R.string.action_register);
        addBottomNav(R.id.navigation_account);
        m6414I();
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }


    public  void m6419a(View view, int i) {
        boolean z = false;
        if (this.f11706O.length != 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f11706O;
                if (i2 < iArr.length) {
                    if (i2 != this.f11712U - 1 && iArr[i2] == i + 1) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        if (z) {
            return;
        }
        this.f11710S[this.f11712U - 1].setText(this.questionHashMap.get(Integer.valueOf(i)));
        this.f11706O[this.f11712U - 1] = i + 1;
        this.f11705N.startAni();
    }
}
