package com.jeil.emarket.activities.intro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.jeil.emarket.components.bottomnavigation.BottomNavigationView;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Help;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import androidx.fragment.app.FragmentManager;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.help.HelpAdapter;
import com.jeil.emarket.adapters.help.IntroAdapter;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.custom.font.FontManager;


public class HelpActivity extends BaseActivity {

    
    public PagAdapter f11719I;

   
    public ViewPager f11720J;

    /* renamed from: com.jeil.emarket.activities.intro.HelpActivity$a */
    public static class C3192ABase extends Fragment implements BaseInterface2 {

        /* renamed from: d0 */
        public static String[] f11721d0 = {"&nbsp;&nbsp;<b>1. 프로그람소개</b>", "&nbsp;&nbsp;<b>2. 상품열람 및 주문</b>", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.1. 상품열람", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.2. 상품구입", "&nbsp;&nbsp;<b>3. 사용자관리</b>", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.1. 사용자등록", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2. 주문목록", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.3. 계정통합", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4. 기업체가입", "&nbsp;&nbsp;<b>4. 의견교환</b>", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1. 상품평가방법", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.2. 상품문의 및 의견제출", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.3. 기업체평가방법", "&nbsp;&nbsp;<b>5. 주의사항</b>", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.1. 상품구입 및 퇴송관련", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.2. 평가글작성에서 지켜야 할 점", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.3. 의견함리용에서 지켜야 할 점", "&nbsp;&nbsp;<b>6. 자주 제기되는 질문들</b>"};

        /* renamed from: a0 */
        public HelpActivity f11722a0;

        /* renamed from: b0 */
        public NestedScrollView f11723b0;

        /* renamed from: c0 */
        public LinearLayoutCompat f11724c0;

        public C3192ABase(HelpActivity helpActivity) {
            this.f11722a0 = helpActivity;
        }



        @Override // androidx.fragment.app.Fragment
        @SuppressLint({"UseCompatLoadingForDrawables"})
        
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            Bundle bundle2 = null; //??
            if (bundle2 == null) {
                return null;
            }
            int i = bundle2.getInt("section_number");
            if (i == 1) {
                this.f11723b0 = new NestedScrollView(this.f11722a0);
                LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f11722a0);
                LinearLayoutCompat linearLayoutCompat2 = new LinearLayoutCompat(this.f11722a0);
                linearLayoutCompat2.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -2));
                linearLayoutCompat2.setOrientation(LinearLayoutCompat.VERTICAL);
                TextView textView = new TextView(this.f11722a0);
                textView.setText(R.string.title);
                textView.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -2));
                textView.setGravity(1);
                textView.setPadding(0, Util.dp2px((Context) this.f11722a0, 27), 0, Util.dp2px((Context) this.f11722a0, 10));
                textView.setTextColor(getResources().getColor(R.color.dark));
                textView.setTextSize(1, 18.0f);
                textView.setTypeface(FontManager.getFont(this.f11722a0, "font/cheonlima.ttf"), Typeface.BOLD);
                HelpAdapter c1790b = new HelpAdapter(this.f11722a0, this);
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < f11721d0.length) {
                    Help help = new Help();
                    help.text = f11721d0[i2];
                    help.isLink = (i2 == 1 || i2 == 9 || i2 == 13) ? false : true;
                    arrayList.add(help);
                    i2++;
                }
                c1790b.arrayList = arrayList;
                c1790b.notifyDataSetChanged();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
                RecyclerView recyclerView = new RecyclerView(this.f11722a0);
                recyclerView.setPadding(0, 0, 0, Util.dp2px((Context) this.f11722a0, 20));
                recyclerView.setAdapter(c1790b);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.addItemDecoration(new ItemDecoration2(0, -1, true, true));
                recyclerView.setNestedScrollingEnabled(false);
                if (Build.VERSION.SDK_INT >= 26) {
                    recyclerView.setFocusable(View.NOT_FOCUSABLE);
                } else {
                    recyclerView.setFocusable(false);
                }
                linearLayoutCompat2.addView(textView);
                linearLayoutCompat2.addView(recyclerView);
                linearLayoutCompat2.setBackgroundResource(R.drawable.bg_box);
                linearLayoutCompat2.setOrientation(LinearLayoutCompat.VERTICAL);
                linearLayoutCompat.addView(linearLayoutCompat2);
                int i3 = BaseActivity.anInt2;
                linearLayoutCompat.setPadding(i3, i3, i3, i3);
                this.f11723b0.addView(linearLayoutCompat);
                return this.f11723b0;
            }
            this.f11723b0 = new NestedScrollView(this.f11722a0);
            LinearLayoutCompat linearLayoutCompat3 = new LinearLayoutCompat(this.f11722a0);
            this.f11724c0 = new LinearLayoutCompat(this.f11722a0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            WebView webView = (WebView) View.inflate(this.f11722a0, R.layout.item_webview, null).findViewById(R.id.wv_main);
            webView.setNestedScrollingEnabled(false);
            if (Build.VERSION.SDK_INT >= 26) {
                webView.setFocusable(View.NOT_FOCUSABLE);
            } else {
                webView.setFocusable(false);
            }
            try {
                String replace = IntroAdapter.f7216b[i - 2].replace("&nbsp;", "").replace("<b>", "").replace("</b>", "");
                int i4 = 0;
                while (i4 < replace.length()) {
                    int i5 = i4 + 1;
                    if (!replace.substring(i5).contains(".")) {
                        break;
                    }
                    i4 = i5;
                }
                InputStream open = this.f11722a0.getAssets().open(String.format("help/%s.html", replace.substring(0, i4)));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        open.close();
                        bufferedReader.close();
                        webView.getSettings().setDefaultFontSize(16);
                        webView.loadDataWithBaseURL(null, sb.toString().replace("{{url}}", "http://10.99.8.2/e4/uploads/help/images/app"), "text/html", "utf-8", null);
                        this.f11724c0.addView(webView);
                        this.f11724c0.setBackgroundResource(R.drawable.bg_box);
                        this.f11724c0.setOrientation(LinearLayoutCompat.VERTICAL);
                        linearLayoutCompat3.addView(this.f11724c0);
                        linearLayoutCompat3.setPadding(BaseActivity.anInt2, BaseActivity.anInt2, BaseActivity.anInt2, BaseActivity.anInt2);
                        this.f11723b0.addView(linearLayoutCompat3, layoutParams);
                        return this.f11723b0;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // p078b.p159f.p160a.p253h.InterfaceC2709c
        
        public boolean mo4808a(int i, String str, int i2) {
            ViewPager viewPager = this.f11722a0.f11720J;
            if (i == 0) {
                i++;
            } else if (i >= 9) {
                i = i < 13 ? i - 1 : i - 2;
            }
            viewPager.setCurrentItem(i, true);
            return true;
        }
    }

    /* renamed from: com.jeil.emarket.activities.intro.HelpActivity$b */
    public class PagAdapter extends FragmentPagerAdapter {

        /* renamed from: h */
        public HelpActivity f11725h;

        public PagAdapter(HelpActivity helpActivity, FragmentManager fragmentManager, HelpActivity helpActivity2) {
            super(fragmentManager);
            this.f11725h = helpActivity2;
        }

        @Override // p000a.p075x.p076a.AbstractC0513a
        
        public int getCount() {
            return IntroAdapter.f7216b.length + 1;
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (m4309v()) {
            return;
        }
        if (this.f11720J.getCurrentItem() == 0) {
            finish();
        } else {
            this.f11720J.setCurrentItem(0, true);
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_help);
        this.f11719I = new PagAdapter(this, getSupportFragmentManager(), this);
        this.f11720J = (ViewPager) findViewById(R.id.vp_help);
        this.f11720J.setAdapter(this.f11719I);
        m4307e(R.string.help);
        addBottomNav(R.id.navigation_account);
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        if (bottomNavigationView != null) {
            bottomNavigationView.animate().translationY(0.0f).setDuration(200L);
        }
        mo4284G();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
