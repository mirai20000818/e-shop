package com.jeil.emarket.activities.intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.frag.main.setup.FragmentSetupColor;
import com.jeil.emarket.viewmodel.UserVM;


public class SetupActivity extends BaseActivity {

    
    public int f11739I = 0;

   
    public boolean f11740J = true;

    
    public int f11741K = 0;

    /* renamed from: L */

    
    public void m6473I() {
        SharedPreferences.Editor edit = UserVM.sharedPreferences.edit();
        edit.putInt("color_scheme", this.f11739I);
        edit.putInt("image_level", this.f11741K);
        edit.putBoolean("screen", this.f11740J);
        edit.putBoolean("setup", true);
        edit.apply();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064 A[LOOP:0: B:11:0x005e->B:13:0x0064, LOOP_END] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6474g(int r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.activities.intro.SetupActivity.m6474g(int):void");
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6502v = false;
        setContentView(R.layout.activity_empty);
        this.f11739I = UserVM.sharedPreferences.getInt("color_scheme", this.f11739I);
        this.f11741K = UserVM.sharedPreferences.getInt("image_level", this.f11741K);
        this.f11740J = UserVM.sharedPreferences.getBoolean("screen", true);
        FragmentSetupColor fragmentSetupColor = new FragmentSetupColor(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll_fragment, fragmentSetupColor, (String) null);
        beginTransaction.commit();
    }
}
