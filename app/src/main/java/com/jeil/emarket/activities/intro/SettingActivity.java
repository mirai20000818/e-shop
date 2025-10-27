package com.jeil.emarket.activities.intro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.textview.TextView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.viewmodel.SimpleVM;
import com.jeil.emarket.viewmodel.UserVM;


public class SettingActivity extends BaseActivity {

    /* renamed from: P */
    public SharedPreferences.Editor f11737P;


    public int f11730I = 2;

   
    public boolean f11731J = false;


    public boolean f11732K = false;

    /* renamed from: L */
    public boolean f11733L = false;

    /* renamed from: M */
    public boolean f11734M = false;

    /* renamed from: N */
    public int f11735N = 1;

    /* renamed from: O */
    public int f11736O = 1;

    /* renamed from: Q */
    public Boolean f11738Q = false;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.btn_setting).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6462d(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_level);
        String string = getResources().getString(R.string.select_image_level_desc);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(BaseActivity.anInt >= 1080 ? 3 : 2);
        textView.setText(String.format(string, objArr));
        m6467h(this.f11730I);
        findViewById(R.id.cbt_level_1).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6463e(view);
            }
        });
        findViewById(R.id.cbt_level_2).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6464f(view);
            }
        });
        findViewById(R.id.cbt_level_3).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6466g(view);
            }
        });
        m6461a(this.f11732K);
        findViewById(R.id.cbt_infinite).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6468h(view);
            }
        });
        findViewById(R.id.cbt_pagination).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6469i(view);
            }
        });
        m6465g(this.f11735N);
        findViewById(R.id.cbt_small).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6470j(view);
            }
        });
        findViewById(R.id.cbt_normal).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6471k(view);
            }
        });
        findViewById(R.id.cbt_big).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.d.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.this.m6472l(view);
            }
        });
    }


    public void m6461a(boolean z) {
        this.f11732K = z;
        if (z) {
            ((ButtonToggle) findViewById(R.id.cbt_infinite)).m6896d();
            ((ButtonToggle) findViewById(R.id.cbt_pagination)).m6897e();
        } else {
            ((ButtonToggle) findViewById(R.id.cbt_infinite)).m6897e();
            ((ButtonToggle) findViewById(R.id.cbt_pagination)).m6896d();
        }
    }


    public  void m6462d(View view) {
        this.f11737P.putBoolean("sticky_header", this.f11731J);
        this.f11737P.putBoolean("screen", this.f11732K);
        this.f11737P.putBoolean("show_ticket", this.f11733L);
        this.f11737P.putBoolean("use_image_popup", this.f11734M);
        this.f11737P.putInt("color_scheme", this.f11736O);
        this.f11737P.putInt("image_level", this.f11730I);
        this.f11737P.putInt("font_size", this.f11735N);
        SimpleVM.f8836d = !this.f11732K;
        this.f11737P.apply();
        Util.toast(this, getString(R.string.success), "success", 0, 0);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    public  void m6463e(View view) {
        m6467h(1);
    }

    /* renamed from: f */
    public  void m6464f(View view) {
        m6467h(2);
    }

    /* renamed from: g */
    public void m6465g(int i) {
        if (i < 0 || i > 2) {
            i = 1;
        }
        this.f11735N = i;
        ButtonToggle[] buttonToggleArr = {(ButtonToggle) findViewById(R.id.cbt_small), (ButtonToggle) findViewById(R.id.cbt_normal), (ButtonToggle) findViewById(R.id.cbt_big)};
        for (ButtonToggle buttonToggle : buttonToggleArr) {
            buttonToggle.m6897e();
        }
        buttonToggleArr[i].m6896d();
    }

    /* renamed from: g */
    public  void m6466g(View view) {
        m6467h(3);
    }

    @SuppressLint({"StringFormatMatches"})
    /* renamed from: h */
    public void m6467h(int i) {
        String format;
        Handler handler;
        Runnable runnable;
        int i2 = UserVM.sharedPreferences.getInt("image_level", 0);
        final TextView textView = (TextView) findViewById(R.id.ctv_image_level);
        if (i <= 0 || i > 3) {
            i = 2;
        }
        int i3 = this.f11730I;
        if (i3 != i && (i == i2 || i3 == i2)) {
            this.f11738Q = Boolean.valueOf(!this.f11738Q.booleanValue());
            if (this.f11738Q.booleanValue()) {
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.d.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        Util.m243a((View) textView);
                    }
                };
            } else {
                handler = new Handler();
                runnable = new Runnable() { // from class: b.f.a.a.d.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        Util.m243a((View) textView);
                    }
                };
            }
            handler.postDelayed(runnable, Status.time);
        }
        this.f11730I = i;
        ButtonToggle[] buttonToggleArr = {(ButtonToggle) findViewById(R.id.cbt_level_1), (ButtonToggle) findViewById(R.id.cbt_level_2), (ButtonToggle) findViewById(R.id.cbt_level_3)};
        for (ButtonToggle buttonToggle : buttonToggleArr) {
            buttonToggle.m6897e();
        }
        buttonToggleArr[i - 1].m6896d();
        int i4 = this.f11730I;
        if (i2 > i4) {
            format = String.format(getResources().getString(R.string.setting_image_level_positive_notice), Integer.valueOf(this.f11730I), Integer.valueOf(i2), Util.getIdentifier(this, "level" + i2 + "_" + this.f11730I, "0%"));
        } else {
            if (i2 >= i4) {
                return;
            }
            format = String.format(getResources().getString(R.string.setting_image_level_negative_notice), Integer.valueOf(this.f11730I), Integer.valueOf(i2), Util.getIdentifier(this, "level" + i2 + "_" + this.f11730I, "0%"));
        }
        textView.setText(format);
    }

    /* renamed from: h */
    public  void m6468h(View view) {
        m6461a(true);
    }


    public  void m6469i(View view) {
        m6461a(false);
    }

   
    public  void m6470j(View view) {
        m6465g(0);
    }


    public  void m6471k(View view) {
        m6465g(1);
    }

    /* renamed from: l */
    public  void m6472l(View view) {
        m6465g(2);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting);
        m4307e(R.string.user_setting);
        this.f11730I = UserVM.sharedPreferences.getInt("image_level", 2);
        this.f11731J = UserVM.sharedPreferences.getBoolean("sticky_header", false);
        this.f11732K = UserVM.sharedPreferences.getBoolean("screen", true);
        this.f11733L = UserVM.sharedPreferences.getBoolean("show_ticket", false);
        this.f11734M = UserVM.sharedPreferences.getBoolean("use_image_popup", false);
        this.f11736O = UserVM.sharedPreferences.getInt("color_scheme", 1);
        this.f11735N = UserVM.sharedPreferences.getInt("font_size", 1);
        this.f11737P = UserVM.sharedPreferences.edit();
        this.f11737P.putBoolean("hidden_setting_badge", false);
        this.f11737P.apply();
        mo4284G();
        addBottomNav(R.id.navigation_account);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
