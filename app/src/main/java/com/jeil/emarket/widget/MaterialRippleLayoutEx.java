package com.jeil.emarket.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.button.RadioButton;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;

/* renamed from: b.f.a.c.p */

public class MaterialRippleLayoutEx extends MaterialRippleLayout {

    /* renamed from: G */
    public MutableLiveData<Boolean> f8541G;

    public MaterialRippleLayoutEx(Context context) {
        super(context);
        this.f8541G = new MutableLiveData<>(false);
    }

    
    public void m4690a(BaseActivity activityC1391g1, String str) {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(activityC1391g1);
        linearLayoutCompat.setPadding(Util.dp2px((Context) activityC1391g1, 20), Util.dp2px((Context) activityC1391g1, 20), Util.dp2px((Context) activityC1391g1, 18), Util.dp2px((Context) activityC1391g1, 20));
        AppCompatImageView appCompatImageView = new AppCompatImageView(activityC1391g1);
        appCompatImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        appCompatImageView.setImageResource(getResources().getIdentifier(str, "drawable", activityC1391g1.getPackageName()));
        TextView textView = new TextView(activityC1391g1);
        textView.setText(Util.getIdentifier(activityC1391g1, str, ""));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(getResources().getColor(R.color.dark));
        textView.setPadding(Util.dp2px((Context) activityC1391g1, 22), 0, 0, 0);
        final RadioButton radioButton = new RadioButton(activityC1391g1);
        radioButton.setButtonDrawable(R.drawable.dr_radio);
        this.f8541G.observe(activityC1391g1, new Observer() { // from class: b.f.a.c.b
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                radioButton.setChecked(((Boolean) obj).booleanValue());
            }
        });
        radioButton.setChecked(this.f8541G.getValue().booleanValue());
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LinearLayout.LayoutParams) c0541a).weight = 1.0f;
        linearLayoutCompat.addView(appCompatImageView, new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) activityC1391g1, 30), Util.dp2px((Context) activityC1391g1, 25)));
        linearLayoutCompat.addView(textView, c0541a);
        linearLayoutCompat.addView(radioButton, new LinearLayoutCompat.LayoutParams(Util.dp2px((Context) activityC1391g1, 23), Util.dp2px((Context) activityC1391g1, 23)));
        removeAllViews();
        setDefaultRippleAlpha(10);
        setRippleOverlay(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        addView(linearLayoutCompat, layoutParams);
    }
}
