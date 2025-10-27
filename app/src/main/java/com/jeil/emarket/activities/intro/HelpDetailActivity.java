package com.jeil.emarket.activities.intro;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;

import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.help.IntroAdapter;


public class HelpDetailActivity extends BaseActivity {
    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.activity_help_detail);
        addBottomNav(R.id.navigation_account);
        int i = ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getInt("index");
        boolean z = getIntent().getExtras().getBoolean("vendor");
        m4307e(R.string.help);
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        if (bottomNavigationView != null) {
            bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
        }
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        LinearLayoutCompat linearLayoutCompat2 = new LinearLayoutCompat(this);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        WebView webView = new WebView(this);
        webView.setNestedScrollingEnabled(false);
        if (Build.VERSION.SDK_INT >= 26) {
            webView.setFocusable(0);
        } else {
            webView.setFocusable(false);
        }
        try {
            if (z) {
                string = getIntent().getExtras().getString("title");
            } else {
                String replace = IntroAdapter.f7216b[i - 1].replace("&nbsp;", "").replace("<b>", "").replace("</b>", "");
                int i2 = 0;
                while (i2 < replace.length()) {
                    int i3 = i2 + 1;
                    if (!replace.substring(i3).contains(".")) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
                string = replace.substring(0, i2);
            }
            InputStream open = getAssets().open(String.format("help/%s.html", string));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            open.close();
            bufferedReader.close();
            webView.getSettings().setDefaultFontSize(16);
            webView.loadDataWithBaseURL(null, sb.toString().replace("{{url}}", "http://10.99.8.2/e4/uploads/help/images/app"), "text/html", "utf-8", null);
            linearLayoutCompat2.addView(webView);
            linearLayoutCompat2.setBackgroundResource(R.drawable.bg_box);
            linearLayoutCompat2.setOrientation(LinearLayoutCompat.VERTICAL);
            linearLayoutCompat.addView(linearLayoutCompat2);
            linearLayoutCompat.setPadding(BaseActivity.anInt2, BaseActivity.anInt2, BaseActivity.anInt2, BaseActivity.anInt2);
            ((NestedScrollView) findViewById(R.id.nsv_main)).addView(linearLayoutCompat, layoutParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
