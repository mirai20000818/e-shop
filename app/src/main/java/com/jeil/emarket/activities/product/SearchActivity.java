package com.jeil.emarket.activities.product;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.frag.main.bottom.FragmentMessage;


public class SearchActivity extends BaseActivity {
    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.header_border).setVisibility(View.GONE);
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
    }

    
    public void m6557I() {
        FragmentMessage fragmentMessage = new FragmentMessage(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll_fragment, fragmentMessage, (String) null);
        beginTransaction.commit();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_footer);
        m4307e(R.string.search);
        m6557I();
        mo4284G();
        addBottomNav(0);
    }
}
