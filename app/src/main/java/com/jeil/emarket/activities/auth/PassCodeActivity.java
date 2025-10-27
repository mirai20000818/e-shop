package com.jeil.emarket.activities.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.jeil.emarket.components.PasscodeView;
import org.json.JSONException;
import org.json.JSONObject;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;


public class PassCodeActivity extends BaseActivity implements BaseInterface {

    
    public PassCodeActivity instance;

    /* renamed from: com.jeil.emarket.activities.auth.PassCodeActivity$a */
    public class verify_register implements PasscodeView.verify_register {
        public verify_register() {
        }


        public  void m6412a(Context context, String str, Context context2) {
            API_PROVIDER APIS = new API_PROVIDER(context, "verify_register", PassCodeActivity.this);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", str);
                APIS.post("e6/auth/verify", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(String str, String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !"verify_register".equals(str2) || i != 200) {
            return;
        }
        setResult(-1);
        finish();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_passcode);
        this.instance = this;
        m4307e(R.string.register_verify);
        mo4284G();
        ((PasscodeView) findViewById(R.id.pv_pass)).m6826a(new verify_register());
    }
}
