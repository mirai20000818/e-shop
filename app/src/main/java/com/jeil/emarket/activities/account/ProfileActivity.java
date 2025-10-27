package com.jeil.emarket.activities.account;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.auth.LoginActivity;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Avatar;
import com.jeil.emarket.model.customer.MergeRequests;
import com.jeil.emarket.model.customer.PasswordFaq;
import com.jeil.emarket.model.customer.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.jeil.emarket.listener.orderlistener.ProfileAniListener1;
import com.jeil.emarket.listener.orderlistener.ProfileAniListener;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.refund.ComponentAct;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.components.itemdecor.ItemDecoration3;
import com.jeil.emarket.components.pickerview.PickerObj3;
import com.jeil.emarket.components.pickerview.date.p218c.InterfaceC2115g;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.CheckI;
import com.jeil.emarket.viewmodel.DayProductVM;
import com.jeil.emarket.viewmodel.RecentKeywordsVM;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.ProductVendorVM;
import com.jeil.emarket.custom.Util;

public class ProfileActivity extends BaseActivity {

    /* renamed from: g0 */
    public static List<Avatar> f11648g0 = new ArrayList();


    public BaseDialog2 f11649I;

    /* renamed from: R */
    public PickerObj3 f11658R;

    /* renamed from: e0 */
    public CancellationSignal f11671e0;

    /* renamed from: f0 */
    public FingerprintManager.AuthenticationCallback f11672f0;

   
    public ImageDialog2 f11650J = null;


    public ImageDialog2 f11651K = null;

    /* renamed from: L */
    public ImageDialog2 f11652L = null;

    /* renamed from: M */
    public ImageDialog2 f11653M = null;

    /* renamed from: N */
    public ImageDialog2 f11654N = null;

    /* renamed from: O */
    public ImageDialog2 f11655O = null;

    /* renamed from: P */
    public boolean f11656P = false;

    /* renamed from: Q */
    public Date f11657Q = new Date();

    /* renamed from: S */
    public ImageDialog2 f11659S = null;

    /* renamed from: T */
    public boolean f11660T = false;

    /* renamed from: U */
    public BaseDialog2 f11661U = null;

    /* renamed from: V */
    public int[] f11662V = new int[3];

    /* renamed from: W */
    public String[] f11663W = new String[3];

    /* renamed from: X */
    public LinearLayoutCompat[] f11664X = new LinearLayoutCompat[3];

    /* renamed from: Y */
    public LinearLayoutCompat[] f11665Y = new LinearLayoutCompat[3];

    /* renamed from: Z */
    public TextView[] f11666Z = new TextView[3];

    /* renamed from: a0 */
    public EditForm[] editForms = new EditForm[3];

    /* renamed from: b0 */
    public int f11668b0 = 1;

    /* renamed from: c0 */
    public int f11669c0 = 0;

    /* renamed from: d0 */
    public FingerprintManager fingerprintManager = null;

    /* renamed from: com.jeil.emarket.activities.account.ProfileActivity$a */
    public class C3186a extends RecyclerView.OnScrollListener {


        public final  View f11673a;

        public C3186a(ProfileActivity profileActivity, View view) {
            this.f11673a = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView.canScrollVertically(1)) {
                this.f11673a.findViewById(R.id.ll_bottom_gradient).setVisibility(View.VISIBLE);
            } else {
                this.f11673a.findViewById(R.id.ll_bottom_gradient).setVisibility(View.GONE);
            }
            if (recyclerView.canScrollVertically(-1)) {
                this.f11673a.findViewById(R.id.ll_top_gradient).setVisibility(View.VISIBLE);
            } else {
                this.f11673a.findViewById(R.id.ll_top_gradient).setVisibility(View.GONE);
            }
        }
    }

    /* renamed from: com.jeil.emarket.activities.account.ProfileActivity$b */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public class C3187b extends FingerprintManager.AuthenticationCallback {


        public final  AppCompatImageView f11674a;

        public C3187b(AppCompatImageView appCompatImageView) {
            this.f11674a = appCompatImageView;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            super.onAuthenticationError(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            Util.toast(ProfileActivity.this, R.string.fingerprint_error, "error");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11674a, "translationX", 0.0f, -15.0f, 0.0f, 15.0f, 0.0f);
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
            ProfileActivity.this.f11654N.dismiss();
            ProfileActivity.this.m6306Q();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        m6299J();
        findViewById(R.id.ani_change_cid).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6339e(view);
            }
        });
        findViewById(R.id.ani_account_merge).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6341f(view);
            }
        });
        findViewById(R.id.ani_change_profile).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6343g(view);
            }
        });
        findViewById(R.id.ani_update_password).setVisibility(View.VISIBLE);
        findViewById(R.id.ani_update_password).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6345h(view);
            }
        });
        findViewById(R.id.ani_delete_log).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6347i(view);
            }
        });
        findViewById(R.id.ani_format_password_question).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6349j(view);
            }
        });
        findViewById(R.id.mrl_avatar).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6350k(view);
            }
        });
    }


    public void m6298I() {
        View inflate = View.inflate(this, R.layout.dialog_check_user, null);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_confirm_password);
        if (Build.VERSION.SDK_INT >= 23) {
            FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(Context.FINGERPRINT_SERVICE);
            if (fingerprintManager.isHardwareDetected() && fingerprintManager.hasEnrolledFingerprints()) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.iv_fingerprint);
                this.fingerprintManager = (FingerprintManager) getSystemService(FingerprintManager.class);
                this.f11671e0 = new CancellationSignal();
                this.f11672f0 = new C3187b(appCompatImageView);
                m6308S();
            }
        }
        editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editForm.showeye();
            }
        });
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6336d(view);
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6317a(editForm, view);
            }
        });
        this.f11654N = Util.m211a((Activity) this, inflate);
        this.f11654N.show();
        this.f11654N.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.l1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                ProfileActivity.this.m6328b(dialogInterface);
            }
        });
    }

   
    public void m6299J() {
        this.f11658R = new PickerObj3(this, true, Calendar.getInstance().get(1) - 10);
    }


    public boolean m6300K() {
        FingerprintManager fingerprintManager;
        if (Build.VERSION.SDK_INT >= 23 && (fingerprintManager = this.fingerprintManager) != null && fingerprintManager.isHardwareDetected()) {
            return this.fingerprintManager.hasEnrolledFingerprints();
        }
        return false;
    }

    /* renamed from: L */
    public final void m6301L() {
        if (this.f11660T) {
            return;
        }
        this.f11660T = true;
        m6307R();
    }

    /* renamed from: M */
    public void m6302M() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_account_merge, (ViewGroup) null);
        Boolean m6327b = m6327b(inflate, UserVM.mergeRequestsMutableLiveData.getValue());
        ((EditForm) inflate.findViewById(R.id.cef_username)).setRippleColor(R.color.white);
        if (!m6327b.booleanValue()) {
            Util.toast(this, getString(R.string.already_merged), "error", 0, 0);
            this.f6496A = false;
        } else {
            this.f11652L = Util.m211a((Activity) this, inflate);
            this.f11652L.show();
            this.f11652L.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.a0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    ProfileActivity.this.m6333c(dialogInterface);
                }
            });
        }
    }

    /* renamed from: N */
    public void m6303N() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_change_avatar, (ViewGroup) null);
        final ComponentAct componentAct = new ComponentAct(this);
        if (f11648g0.size() < this.f11669c0 - 1) {
            this.f11669c0 = 0;
        }
        Avatar avatar = f11648g0.get(this.f11669c0);
        avatar.cur = true;
        f11648g0.set(this.f11669c0, avatar);
        componentAct.addAll((List) f11648g0);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_show_avatar);
        recyclerView.setLayoutManager(new GridLayoutManager((Context) this, 4, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(componentAct);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new ItemDecoration3(4, Util.dp2px((Context) this, 8), false));
        recyclerView.addOnScrollListener(new C3186a(this, inflate));
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6313a(componentAct, view);
            }
        });
        inflate.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6352m(view);
            }
        });
        this.f11655O = Util.m211a((Activity) this, inflate);
        this.f11655O.show();
        this.f11655O.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.o1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                ProfileActivity.this.m6335d(dialogInterface);
            }
        });
    }

    /* renamed from: O */
    public void m6304O() {
        View inflate = View.inflate(this, R.layout.dialog_update_password, null);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_current_password);
        final EditForm editForm2 = (EditForm) inflate.findViewById(R.id.cef_new_password);
        final EditForm editForm3 = (EditForm) inflate.findViewById(R.id.cef_confirm_password);
        if (UserVM.f10340q) {
            editForm.setText(Util.m343e(16));
            editForm.hide();
            editForm.unFocusable();
        } else if (UserVM.sharedPreferences.getBoolean("isFormatted", false)) {
            editForm.setText(UserVM.sharedPreferences.getString("save_password", ""));
        }
        editForm.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editForm.showeye();
            }
        });
        editForm2.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editForm.showeye();
            }
        });
        editForm3.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                editForm.showeye();
            }
        });
        CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6354o(view);
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6318a(editForm, editForm2, editForm3, view);
            }
        });
        this.f11653M = Util.m211a((Activity) this, inflate);
        this.f11653M.show();
        this.f11653M.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.j1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                ProfileActivity.this.m6340f(dialogInterface);
            }
        });
    }

    /* renamed from: P */
    public void m6305P() {
        final PickerObj3 pickerObj3 = new PickerObj3(this, true);
        final View inflate = View.inflate(this, R.layout.dialog_change_profile, null);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_name);
        final TextView textView = (TextView) inflate.findViewById(R.id.tv_birthday);
        final TextView textView2 = (TextView) inflate.findViewById(R.id.tv_user_name);
        if (UserVM.userMutableLiveData.getValue() != null) {
            final User getValue = UserVM.userMutableLiveData.getValue();
            editForm.setText(getValue.fullName);
            textView2.setText(getValue.name);
            pickerObj3.m4714b(getValue.birthday);
            textView.setText(Util.date2Str(getValue.birthday));
            Boolean bool = getValue.isMerged;
            if (bool == null || !bool.booleanValue()) {
                pickerObj3.f8619c = new InterfaceC2115g() { // from class: b.f.a.a.a.t0
                    @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

                    public final void mo4267a(Date date, View view) {
                        ((TextView) inflate.findViewById(R.id.tv_birthday)).setText(Util.date2Str(date));
                    }
                };
                inflate.findViewById(R.id.mrl_birthday).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.r0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        pickerObj3.m4710a();
                    }
                });
            } else {
                editForm.setEnabled(false);
                editForm.setFocusable(false);
                textView2.setEnabled(false);
                textView.setEnabled(false);
            }
            ((RadioGroup) inflate.findViewById(R.id.rg_gender)).check(getValue.gender.equals("male") ? R.id.crb_male : R.id.crb_female);
            CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
            CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
            inflate.findViewById(R.id.mrl_user_name).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileActivity.this.m6320a(editForm, textView, textView2, view);
                }
            });
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileActivity.this.m6355p(view);
                }
            });
            customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.p1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileActivity.this.m6325a(getValue, editForm, textView, textView2, this, inflate, view);
                }
            });
            this.f11651K = Util.m211a((Activity) this, inflate);
            this.f11651K.show();
            this.f11651K.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.k0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    ProfileActivity.this.m6342g(dialogInterface);
                }
            });
        }
    }

    @SuppressLint({"SetTextI18n", "CutPasteId"})
    /* renamed from: Q */
    public final void m6306Q() {
        final View inflate = View.inflate(this, R.layout.dialog_save_password_faq, null);
        this.f11664X = new LinearLayoutCompat[]{(LinearLayoutCompat) inflate.findViewById(R.id.llc_first), (LinearLayoutCompat) inflate.findViewById(R.id.llc_second), (LinearLayoutCompat) inflate.findViewById(R.id.llc_third)};
        this.f11665Y = new LinearLayoutCompat[]{(LinearLayoutCompat) inflate.findViewById(R.id.llc_categories1), (LinearLayoutCompat) inflate.findViewById(R.id.llc_categories2), (LinearLayoutCompat) inflate.findViewById(R.id.llc_categories3)};
        this.f11666Z = new TextView[]{(TextView) inflate.findViewById(R.id.ctv_question1), (TextView) inflate.findViewById(R.id.ctv_question2), (TextView) inflate.findViewById(R.id.ctv_question3)};
        this.editForms = new EditForm[]{(EditForm) inflate.findViewById(R.id.cef_answer1), (EditForm) inflate.findViewById(R.id.cef_answer2), (EditForm) inflate.findViewById(R.id.cef_answer3)};
        final CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        final CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_ok);
        UserVM.f10343t.observe(this, new Observer() { // from class: b.f.a.a.a.n0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProfileActivity.this.m6332b((List) obj);
            }
        });
        m6316a(customButton, customButton2);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6311a(inflate, customButton, customButton2, view);
            }
        });
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6330b(inflate, customButton, customButton2, view);
            }
        });
        inflate.findViewById(R.id.mrl_main_categories1).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6356q(view);
            }
        });
        inflate.findViewById(R.id.mrl_main_categories2).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6357r(view);
            }
        });
        inflate.findViewById(R.id.mrl_main_categories3).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivity.this.m6358s(view);
            }
        });
        this.f11659S = Util.m211a((Activity) this, inflate);
        this.f11659S.show();
        this.f11659S.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.i0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                ProfileActivity.this.m6346i(dialogInterface);
            }
        });
    }

    /* renamed from: R */
    public void m6307R() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.questionHashMap.size(); i++) {
            if (this.f11662V.length != 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr = this.f11662V;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    if (i2 != this.f11668b0 - 1 && iArr[i2] == i + 1) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            z = false;
            arrayList.add(new Cancel_Obj(this.questionHashMap.get(Integer.valueOf(i)), this.f11666Z[this.f11668b0 - 1].getText().equals(this.questionHashMap.get(Integer.valueOf(i))) ? 1 : 0, z));
        }
        this.f11661U = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f11661U;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.a.x
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i3) {
                ProfileActivity.this.m6310a(view, i3);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f11661U;
        baseDialog22.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog22.show();
        this.f11661U.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.y0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                ProfileActivity.this.m6348j(dialogInterface);
            }
        });
    }

    /* renamed from: S */
    public void m6308S() {
        if (m6300K()) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    this.fingerprintManager.authenticate(null, this.f11671e0, 0, this.f11672f0, null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: T */
    public void m6309T() {
        if (m6300K()) {
            try {
                this.f11671e0.cancel();
                this.f11671e0 = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public  void m6311a(View view, CustomButton customButton, CustomButton customButton2, View view2) {
        int i = this.f11668b0;
        if (i != 1) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11664X[i - 1], "translationX", 0.0f, BaseActivity.anInt);
            ofFloat.setDuration(300L);
            ofFloat.start();
            ofFloat.addListener(new ProfileAniListener1(this, view));
            this.f11664X[this.f11668b0 - 2].setVisibility(View.VISIBLE);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11664X[this.f11668b0 - 2], "translationX", -BaseActivity.anInt, 0.0f);
            ofFloat2.setDuration(300L);
            ofFloat2.start();
            this.f11668b0--;
        } else {
            this.f11659S.dismiss();
        }
        m6316a(customButton, customButton2);
    }


    public void m6312a(View view, final MergeRequests mergeRequests) {
        view.findViewById(R.id.tv_notice).setPadding(0, Util.dp2px((Context) this, 5), 0, Util.dp2px((Context) this, 5));
        ((TextView) view.findViewById(R.id.tv_notice)).setText(String.format(getResources().getString(R.string.desktop_already_requested), mergeRequests.desktop.targetUser));
        view.findViewById(R.id.cef_username).setVisibility(View.GONE);
        ((CustomButton) view.findViewById(R.id.cb_cancel)).setText(R.string.ok);
        ((CustomButton) view.findViewById(R.id.cb_ok)).setText(R.string.cancel_request);
        view.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileActivity.this.m6324a(mergeRequests, view2);
            }
        });
    }


    public  void m6315a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f11662V = new int[3];
            this.f11663W = new String[3];
            this.f11668b0 = 1;
            this.f11659S.dismiss();
        }
        dialogC2001j.dismiss();
    }


    public final void m6316a(CustomButton customButton, CustomButton customButton2) {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        if (this.f11668b0 == 1) {
            resources = getResources();
            i = R.string.cancel;
        } else {
            resources = getResources();
            i = R.string.action_prev;
        }
        customButton.setText(resources.getString(i));
        if (this.f11668b0 == 3) {
            resources2 = getResources();
            i2 = R.string.ok;
        } else {
            resources2 = getResources();
            i2 = R.string.action_next;
        }
        customButton2.setText(resources2.getString(i2));
    }


    public  void m6317a(EditForm editForm, View view) {
        boolean z;
        String text = editForm.getText();
        if (text.isEmpty()) {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            z = false;
        }
        if (z) {
            return;
        }
        if (!Objects.equals(UserVM.sharedPreferences.getString("save_password", ""), text)) {
            Util.toast(this, getResources().getString(R.string.incorrect_password), "error", 0, 0);
        } else {
            this.f11654N.dismiss();
            m6306Q();
        }
    }


    public  void m6319a(EditForm editForm, EditForm editForm2, boolean z, EditForm editForm3, TextView textView, MaterialRippleLayout materialRippleLayout, EditForm editForm4, boolean z2, View view) {
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
                jSONObject.put("birthday", this.f11657Q);
                jSONObject.put("name", editForm4.getText());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UserVM.m5528a(this, jSONObject);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.a.x1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProfileActivity.this.m6331b(dialogC2001j, (Integer) obj);
            }
        });
    }


    public  void m6322a(TextView textView, Date date, View view) {
        this.f11657Q = date;
        textView.setText(Util.date2Str(date));
    }


    public  void m6324a(MergeRequests mergeRequests, View view) {
        UserVM.m5515a(this, mergeRequests.desktop.f12402id);
        this.f11652L.dismiss();
    }


    public  void m6326a(String str, DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200 && this.f11653M != null) {
            SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
            edit.putBoolean("isFormatted", false);
            edit.putString("save_password", str);
            edit.apply();
            this.f11653M.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public Boolean m6327b(View view, MergeRequests mergeRequests) {
        MergeRequests.AccountMerge accountMerge;
        if ((mergeRequests == null || (accountMerge = mergeRequests.desktop) == null || accountMerge.f12402id != -1) ? false : true) {
            return false;
        }
        if (mergeRequests == null || (mergeRequests.desktop == null && mergeRequests.mobile == null)) {
            sendMergeRequest(view);
        } else {
            m6312a(view, mergeRequests);
        }
        view.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileActivity.this.m6351l(view2);
            }
        });
        return true;
    }


    public  void m6328b(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public  void m6331b(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f11650J.m4595e();
        }
        dialogC2001j.dismiss();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"DefaultLocale"})

    public void mo4302b(User user) {
        if (user != null) {
            TicketCategoryListVM.m5496a(this);
        }
        if (user != null) {
            this.f11669c0 = user.avatar;
            Boolean bool = user.isMerged;
            if (bool == null || !bool.booleanValue()) {
                ((TextView) findViewById(R.id.tv_user_desktop_name)).setText("---");
                findViewById(R.id.ani_account_merge).setVisibility(View.VISIBLE);
                findViewById(R.id.v_border).setVisibility(View.VISIBLE);
            } else {
                if (user.desktopName != null) {
                    ((TextView) findViewById(R.id.tv_user_desktop_name)).setText(user.desktopName);
                }
                findViewById(R.id.ani_account_merge).setVisibility(View.GONE);
                findViewById(R.id.v_border).setVisibility(View.GONE);
            }
            ((TextView) findViewById(R.id.tv_full_name)).setText(user.fullName);
            ((TextView) findViewById(R.id.tv_user_name)).setText(user.name);
            Glide.with((FragmentActivity) this).load(Util.m345e(String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(user.avatar)))).load(getResources().getDrawable(R.drawable.man)).into((ImageView) findViewById(R.id.iv_avatar));
        }
    }


    public  void m6332b(List list) {
        if (list == null || list.size() != 3) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            this.f11662V[i] = ((PasswordFaq) list.get(i)).questionId;
            this.f11663W[i] = ((PasswordFaq) list.get(i)).answer;
            this.f11666Z[i].setText(this.questionHashMap.get(Integer.valueOf(this.f11662V[i] - 1)));
            this.editForms[i].setText(this.f11663W[i]);
            if (Build.VERSION.SDK_INT >= 26) {
                this.editForms[i].setFocusedByDefault(true);
            }
        }
    }


    public  void m6333c(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public  void m6334c(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f11651K.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m6335d(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public  void m6336d(View view) {
        this.f11654N.dismiss();
    }


    public  void m6337d(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f11655O.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m6338e(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }


    public  void m6339e(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        View inflate = View.inflate(this, R.layout.dialog_change_cid, null);
        final EditForm editForm = (EditForm) inflate.findViewById(R.id.cef_cid);
        final EditForm editForm2 = (EditForm) inflate.findViewById(R.id.cef_full_name);
        final MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) inflate.findViewById(R.id.mrl_birthday);
        final EditForm editForm3 = (EditForm) inflate.findViewById(R.id.cef_password);
        final TextView textView = (TextView) inflate.findViewById(R.id.tv_birthday);
        final EditForm editForm4 = (EditForm) inflate.findViewById(R.id.cef_user_name);
        editForm.setRippleColor(R.color.white);
        editForm2.setRippleColor(R.color.white);
        editForm4.setRippleColor(R.color.white);
        this.f11658R.f8619c = new InterfaceC2115g() { // from class: b.f.a.a.a.o0
            @Override // p078b.p159f.p160a.p190c.p214w.p215k.p218c.InterfaceC2115g

            public final void mo4267a(Date date, View view2) {
                ProfileActivity.this.m6322a(textView, date, view2);
            }
        };
        materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileActivity.this.m6353n(view2);
            }
        });
        editForm3.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                editForm.showeye();
            }
        });
        final boolean z = UserVM.userMutableLiveData.getValue() != null;
        editForm2.setVisibility(z ? View.GONE : View.VISIBLE);
        materialRippleLayout.setVisibility(z ? View.GONE : View.VISIBLE);
        editForm4.setVisibility(z ? View.GONE : View.VISIBLE);
        editForm.setHintText(getResources().getString(z ? R.string.new_cid : R.string.prev_cid));
        final boolean z2 = z;
        ((CustomButton) inflate.findViewById(R.id.cb_change)).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileActivity.this.m6319a(editForm, editForm3, z2, editForm2, textView, materialRippleLayout, editForm4, z, view2);
            }
        });
        this.f11650J = Util.m211a((Activity) this, inflate);
        this.f11650J.show();
        this.f11650J.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.w1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                ProfileActivity.this.m6338e(dialogInterface);
            }
        });
    }

    /* renamed from: f */
    public  void m6340f(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    /* renamed from: f */
    public  void m6341f(View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (this.f6496A) {
                return;
            }
            this.f6496A = true;
            if (UserVM.stringMutableLiveData1.getValue() != null) {
                API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.j
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context) {
                        UserVM.m5542c(getApplicationContext(), context);
                    }
                });
            }
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.a.q2
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileActivity.this.m6302M();
                }
            }, Status.time);
        }
    }

    /* renamed from: g */
    public  void m6342g(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    /* renamed from: g */
    public  void m6343g(View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (this.f6496A) {
                return;
            }
            this.f6496A = true;
            m6305P();
        }
    }

    /* renamed from: h */
    public  void m6344h(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    /* renamed from: h */
    public  void m6345h(View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (this.f6496A) {
                return;
            }
            this.f6496A = true;
            m6304O();
        }
    }


    public  void m6346i(android.content.DialogInterface dialogInterface) {
        this.f11662V = new int[3];
        this.f11663W = new String[3];
        this.f11668b0 = 1;
        this.f6496A = false;
    }


    public  void m6347i(View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (this.f6496A) {
                return;
            }
            this.f6496A = true;
            final DialogError dialogError = new DialogError(this);
            dialogError.f8246v = getResources().getString(R.string.delete_log_confirm);
            dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
            dialogError.f8254e = 0.8f;
            dialogError.show();
            dialogError.m4585a(new DialogInterface() { // from class: b.f.a.a.a.m
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

                public final void cancel() {
                    dialogError.dismiss();
                }
            }, new DialogInterface() { // from class: b.f.a.a.a.t1
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

                public final void cancel() {
                    ProfileActivity.this.m6314a(dialogError);
                }
            });
            ((Window) Objects.requireNonNull(dialogError.getWindow())).setDimAmount(0.8f);
            dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.v1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    ProfileActivity.this.m6344h(dialogInterface);
                }
            });
        }
    }

   
    public  void m6348j(android.content.DialogInterface dialogInterface) {
        this.f11660T = false;
    }

   
    public  void m6349j(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        UserVM.m5541c(this);
        m6298I();
    }


    public  void m6350k(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        m6303N();
    }

    /* renamed from: l */
    public  void m6351l(View view) {
        this.f11652L.dismiss();
    }

    /* renamed from: m */
    public  void m6352m(View view) {
        this.f11655O.dismiss();
    }

    /* renamed from: n */
    public  void m6353n(View view) {
        this.f11658R.m4710a();
    }

    /* renamed from: o */
    public  void m6354o(View view) {
        this.f11653M.dismiss();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    @SuppressLint({"DefaultLocale"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_profile);
        if (UserVM.userMutableLiveData.getValue() == null) {
            Util.toast(this, getString(R.string.please_login), "default", 0, 0);
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        m4307e(R.string.profile_info);
        mo4284G();
        addBottomNav(R.id.navigation_account);
        f11648g0.clear();
        for (int i = 0; i < Status.f8819j; i++) {
            Avatar avatar = new Avatar();
            avatar.url = String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(i));
            f11648g0.add(avatar);
        }
    }

    @Override // p000a.p005b.p006a.ActivityC0045t, p000a.p055m.p056a.ActivityC0362o, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m6309T();
    }

    /* renamed from: p */
    public  void m6355p(View view) {
        this.f11651K.dismiss();
    }

    /* renamed from: q */
    public  void m6356q(View view) {
        m6301L();
    }

    /* renamed from: r */
    public  void m6357r(View view) {
        m6301L();
    }

    /* renamed from: s */
    public  void m6358s(View view) {
        m6301L();
    }

    public void sendMergeRequest(final View view) {
        view.findViewById(R.id.cef_username).setVisibility(View.VISIBLE);
        ((CustomButton) view.findViewById(R.id.cb_cancel)).setText(R.string.cancel);
        ((CustomButton) view.findViewById(R.id.cb_ok)).setText(R.string.request);
        view.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileActivity.this.m6329b(view, view2);
            }
        });
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }


    public  void m6323a(TextView textView, String[] strArr, View view, int i) {
        textView.setText(strArr[i]);
        this.f11649I.startAni();
    }


    public  void m6321a(final TextView textView, DialogC2001j dialogC2001j, Integer num) {
        BaseDialog2 baseDialog2 = this.f11649I;
        if ((baseDialog2 == null || !baseDialog2.isShowing()) && UserVM.f10341r.getValue() != null && UserVM.f10341r.getValue().size() != 0 && num.intValue() == 200) {
            this.f11656P = false;
            final String[] strArr = new String[UserVM.f10341r.getValue().size()];
            UserVM.f10341r.getValue().toArray(strArr);
            this.f11649I = new BaseDialog2(this, strArr, null, 80);
            this.f11649I.show();
            this.f11649I.interface2 = new DialogInterface2() { // from class: b.f.a.a.a.b0
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

                public final void mo4264a(View view, int i) {
                    ProfileActivity.this.m6323a(textView, strArr, view, i);
                }
            };
        }
        dialogC2001j.dismiss();
        this.f11660T = false;
    }


    public  void m6329b(View view, View view2) {
        String text = ((EditForm) view.findViewById(R.id.cef_username)).getText();
        if (text == null || text.trim().length() == 0) {
            Util.toast(this, getString(R.string.input_username), "default", 0, 0);
        } else {
            UserVM.m5519a(this, text);
            this.f11652L.dismiss();
        }
    }


    public  void m6330b(View view, CustomButton customButton, CustomButton customButton2, View view2) {
        boolean z;
        int[] iArr = this.f11662V;
        int i = this.f11668b0;
        boolean z2 = true;
        if (iArr[i - 1] == 0) {
            this.f11665Y[i - 1].setBackgroundResource(R.drawable.bd_warn_input);
            z = true;
        } else {
            this.f11665Y[i - 1].setBackgroundResource(R.drawable.bg_input_border);
            z = false;
        }
        if (this.editForms[this.f11668b0 - 1].getText() == null || this.editForms[this.f11668b0 - 1].getText().isEmpty()) {
            this.editForms[this.f11668b0 - 1].setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            this.editForms[this.f11668b0 - 1].setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (!z) {
            String[] strArr = this.f11663W;
            int i2 = this.f11668b0;
            strArr[i2 - 1] = this.editForms[i2 - 1].getText();
            int i3 = this.f11668b0;
            if (i3 == 3) {
                if (UserVM.f10343t.getValue() != null && UserVM.f10343t.getValue().size() == 3) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= UserVM.f10343t.getValue().size()) {
                            z2 = false;
                            break;
                        } else if (this.f11662V[i4] != UserVM.f10343t.getValue().get(i4).questionId || !this.f11663W[i4].equals(UserVM.f10343t.getValue().get(i4).answer)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                if (z2) {
                    final int[] iArr2 = this.f11662V;
                    final String[] strArr2 = this.f11663W;
                    UserVM.f10342s = new MutableLiveData<>();
                    API_PROVIDER.checkInternet(this, new InterfaceContext() { // from class: b.f.a.k.k
                        @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                        public final void mo4271a(Context context) {
                            UserVM.m5533a(iArr2, strArr2, context, context);
                        }
                    });
                    final DialogC2001j dialogC2001j = new DialogC2001j(this);
                    dialogC2001j.show();
                    UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.a.r1
                        @Override // p000a.p060o.InterfaceC0405p

                        public final void onChanged(Object obj) {
                            ProfileActivity.this.m6315a(dialogC2001j, (Integer) obj);
                        }
                    });
                } else {
                    Util.m350f(this, getResources().getString(R.string.no_change));
                }
            } else {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11664X[i3 - 1], "translationX", 0.0f, -BaseActivity.anInt);
                ofFloat.setDuration(300L);
                ofFloat.start();
                ofFloat.addListener(new ProfileAniListener(this, view));
                this.f11664X[this.f11668b0].setVisibility(View.VISIBLE);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11664X[this.f11668b0], "translationX", BaseActivity.anInt, 0.0f);
                ofFloat2.setDuration(300L);
                ofFloat2.start();
                this.f11668b0++;
            }
        }
        m6316a(customButton, customButton2);
    }


    public  void m6313a(ComponentAct componentAct, View view) {
        int i = componentAct.f7075f;
        boolean booleanValue = UserVM.userMutableLiveData.getValue() != null ? UserVM.userMutableLiveData.getValue().isMerged.booleanValue() : false;
        UserVM.f10342s = new MutableLiveData<>();
        API_PROVIDER.checkInternet(this, new CheckI(this, i, booleanValue));
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.a.e0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProfileActivity.this.m6337d(dialogC2001j, (Integer) obj);
            }
        });
    }


    public  void m6318a(EditForm editForm, EditForm editForm2, EditForm editForm3, View view) {
        boolean z;
        String text = editForm.getText();
        final String text2 = editForm2.getText();
        String text3 = editForm3.getText();
        if (text.isEmpty()) {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
            z = false;
        }
        if (text2.isEmpty()) {
            editForm2.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm2.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (text3.isEmpty()) {
            editForm3.setEditTextBackground(getResources().getDrawable(R.drawable.bd_warn_input));
            z = true;
        } else {
            editForm3.setEditTextBackground(getResources().getDrawable(R.drawable.bg_input_border));
        }
        if (z) {
            return;
        }
        if (!text2.equals(text3)) {
            Util.toast(this, getString(R.string.enter_correct_password), "error", 0, 0);
            return;
        }
        if (text2.length() < 8) {
            Util.toast(this, String.format(getResources().getString(R.string.enter_password_limit), 8), "error", 0, 0);
            return;
        }
        UserVM.m5521a(this, text, text2);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.integerMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.a.z
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProfileActivity.this.m6326a(text2, dialogC2001j, (Integer) obj);
            }
        });
    }


    public  void m6320a(EditForm editForm, TextView textView, final TextView textView2, View view) {
        if (editForm.getText().isEmpty()) {
            Util.toast(this, getString(R.string.enter_name), "error", 0, 0);
            return;
        }
        if (textView.getText().toString().isEmpty()) {
            Util.toast(this, getString(R.string.enter_birthday), "error", 0, 0);
            return;
        }
        if (this.f11656P || this.f11660T) {
            return;
        }
        this.f11660T = true;
        this.f11656P = true;
        UserVM.m5526a((Context) this, editForm.getText(), textView.getText().toString(), false);
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        dialogC2001j.show();
        UserVM.f10342s.observe(this, new Observer() { // from class: b.f.a.a.a.k1
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ProfileActivity.this.m6321a(textView2, dialogC2001j, (Integer) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc  */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public  void m6325a(User r9, EditForm r10, TextView r11, TextView r12, View.OnClickListener r13, View r14, View r15) {
        /*
            r8 = this;
            java.lang.Boolean r15 = r9.isMerged
            if (r15 == 0) goto L10
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L10
            b.f.a.c.c0.c.k r9 = r8.f11651K
            r9.dismiss()
            return
        L10:
            java.lang.String r2 = r10.getText()
            java.lang.CharSequence r11 = r11.getText()
            java.lang.String r3 = r11.toString()
            java.lang.CharSequence r11 = r12.getText()
            java.lang.String r4 = r11.toString()
            boolean r11 = r2.isEmpty()
            java.lang.String r15 = "error"
            r0 = 0
            if (r11 == 0) goto L38
            r9 = 2131689885(0x7f0f019d, float:1.9008798E38)
            java.lang.String r9 = r13.getString(r9)
            p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.m238a(r13, r9, r15, r0, r0)
            return
        L38:
            boolean r11 = r3.isEmpty()
            if (r11 == 0) goto L49
            r9 = 2131689878(0x7f0f0196, float:1.9008784E38)
            java.lang.String r9 = r13.getString(r9)
            p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.m238a(r13, r9, r15, r0, r0)
            return
        L49:
            boolean r11 = r4.isEmpty()
            if (r11 == 0) goto L5a
            r9 = 2131689892(0x7f0f01a4, float:1.9008812E38)
            java.lang.String r9 = r13.getString(r9)
            p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.m238a(r13, r9, r15, r0, r0)
            return
        L5a:
            r11 = 2131232061(0x7f08053d, float:1.808022E38)
            android.view.View r11 = r14.findViewById(r11)
            android.widget.RadioGroup r11 = (android.widget.RadioGroup) r11
            int r11 = r11.getCheckedRadioButtonId()
            r13 = 2131231066(0x7f08015a, float:1.8078203E38)
            java.lang.String r14 = ""
            if (r11 != r13) goto L72
            java.lang.String r11 = "male"
        L70:
            r5 = r11
            goto L7b
        L72:
            r13 = 2131231062(0x7f080156, float:1.8078194E38)
            if (r11 != r13) goto L7a
            java.lang.String r11 = "female"
            goto L70
        L7a:
            r5 = r14
        L7b:
            java.lang.String r11 = r9.fullName
            java.lang.String r10 = r10.getText()
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto Lae
            java.lang.String r10 = r9.name
            java.lang.CharSequence r11 = r12.getText()
            java.lang.String r11 = r11.toString()
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto Lae
            java.lang.String r10 = r9.gender
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto Lae
            java.util.Date r10 = r9.birthday
            java.lang.String r10 = p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.date2Str(r10)
            boolean r10 = r10.equals(r3)
            if (r10 != 0) goto Lac
            goto Lae
        Lac:
            r10 = 0
            goto Laf
        Lae:
            r10 = 1
        Laf:
            if (r10 == 0) goto Ldc
            java.lang.Boolean r9 = r9.isMerged
            boolean r6 = r9.booleanValue()
            android.content.SharedPreferences r9 = p078b.p159f.p160a.p256k.C2831r2.f10327d
            java.lang.String r10 = "save_password"
            java.lang.String r7 = r9.getString(r10, r14)
            b.f.a.k.p r9 = new b.f.a.k.p
            r0 = r9
            r1 = r8
            r0.<init>()
            p078b.p159f.p160a.p254i.C2729p.m5403a(r8, r9)
            b.f.a.c.c0.c.j r9 = new b.f.a.c.c0.c.j
            r9.<init>(r8)
            r9.show()
            a.o.o<java.lang.Integer> r10 = p078b.p159f.p160a.p256k.C2831r2.f10342s
            b.f.a.a.a.q0 r11 = new b.f.a.a.a.q0
            r11.<init>()
            r10.observe(r8, r11)
            goto Lea
        Ldc:
            android.content.res.Resources r9 = r8.getResources()
            r10 = 2131690180(0x7f0f02c4, float:1.9009396E38)
            java.lang.String r9 = r9.getString(r10)
            p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.m238a(r8, r9, r15, r0, r0)
        Lea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.activities.account.ProfileActivity.m6325a(com.jeil.emarket.model.customer.User, com.jeil.emarket.components.edittext.EditForm, com.jeil.emarket.components.textview.TextView, com.jeil.emarket.components.textview.TextView, android.content.Context, android.view.View, android.view.View):void");
    }


    public  void m6314a(DialogError dialogError) {
        DayProductVM.f10255d.setValue( new ArrayList());
        DayProductVM.f10256e.setValue( new ArrayList());
        DayProductVM.m5491e();
        ProductVendorVM.f10377e.setValue( new ArrayList());
        ProductVendorVM.f10376d.setValue( new ArrayList());
        ProductVendorVM.m5578b("wishlistProduct");
        ProductVendorVM.m5578b("wishlistVendor");
        RecentKeywordsVM.m5492a(new ArrayList());
        Util.toast(this, getString(R.string.delete_success), "default", 0, 0);
        dialogError.dismiss();
    }


    public  void m6310a(View view, int i) {
        boolean z = false;
        if (this.f11662V.length != 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f11662V;
                if (i2 < iArr.length) {
                    if (i2 != this.f11668b0 - 1 && iArr[i2] == i + 1) {
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
        this.f11666Z[this.f11668b0 - 1].setText(this.questionHashMap.get(Integer.valueOf(i)));
        this.f11662V[this.f11668b0 - 1] = i + 1;
        this.f11661U.startAni();
    }
}
