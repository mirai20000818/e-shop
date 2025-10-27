package com.jeil.emarket.components;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;

import com.jeil.emarket.activities.auth.PassCodeActivity;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.widget.CountDownTimerPasscode;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.api.API_PROVIDER;


public class PasscodeView extends FrameLayout implements View.OnClickListener {


    public verify_register f12028b;


    public LinearLayout f12029c;


    public TextView f12030d;


    public TextView[] f12031e;

    /* renamed from: f */
    public String f12032f;

    /* renamed from: g */
    public String f12033g;

    /* renamed from: h */
    public int f12034h;


    public int f12035i;


    public int f12036j;


    public int f12037k;

    /* renamed from: l */
    public float f12038l;

    /* renamed from: m */
    public int f12039m;

    /* renamed from: com.jeil.emarket.components.PasscodeView$a */
    public interface verify_register {
    }

    public PasscodeView(Context context) {
        this(context, null);
    }

    public PasscodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12031e = new TextView[10];
        this.f12034h = 4;
        this.f12035i = getResources().getColor(R.color.white);
        this.f12036j = -9145228;
        this.f12037k = 120;
        FrameLayout.inflate(getContext(), R.layout.layout_passcode_view, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PasscodeView);
        try {
            this.f12034h = obtainStyledAttributes.getInt(R.styleable.PasscodeView_passcodeLength, this.f12034h);
            this.f12035i = obtainStyledAttributes.getColor(R.styleable.PasscodeView_normalStateColor, this.f12035i);
            this.f12036j = obtainStyledAttributes.getColor(R.styleable.PasscodeView_numberTextColor, this.f12036j);
            this.f12032f = obtainStyledAttributes.getString(R.styleable.PasscodeView_firstInputTip);
            this.f12033g = obtainStyledAttributes.getString(R.styleable.PasscodeView_wrongLengthTip);
            this.f12037k = obtainStyledAttributes.getInt(R.styleable.PasscodeView_waitingInSeconds, this.f12037k);
            this.f12038l = 26.0f;
            this.f12039m = 16;
            obtainStyledAttributes.recycle();
            String str = this.f12032f;
            this.f12032f = str == null ? getResources().getString(R.string.please_enter_correct_length_passcode) : str;
            String str2 = this.f12033g;
            this.f12033g = str2 == null ? this.f12032f : str2;
            this.f12029c = (LinearLayout) findViewById(R.id.ll_psd);
            this.f12030d = (TextView) findViewById(R.id.tv_input_tip);
            this.f12030d.setText(this.f12032f);
            TextView[] textViewArr = {(TextView) findViewById(R.id.tv_number0), (TextView) findViewById(R.id.tv_number1), (TextView) findViewById(R.id.tv_number2), (TextView) findViewById(R.id.tv_number3), (TextView) findViewById(R.id.tv_number4), (TextView) findViewById(R.id.tv_number5), (TextView) findViewById(R.id.tv_number6), (TextView) findViewById(R.id.tv_number7), (TextView) findViewById(R.id.tv_number8), (TextView) findViewById(R.id.tv_number9)};
            for (int i = 0; i < 10; i++) {
                TextView[] textViewArr2 = this.f12031e;
                textViewArr2[i] = textViewArr[i];
                textViewArr2[i].setOnClickListener(this);
                this.f12031e[i].setTag(Integer.valueOf(i));
                this.f12031e[i].setTextColor(this.f12036j);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R.id.iv_ok);
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) findViewById(R.id.iv_back);
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PasscodeView.this.m6827a(view);
                }
            });
            appCompatImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: b.f.a.c.c
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return PasscodeView.this.m6829b(view);
                }
            });
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PasscodeView.this.m6830c(view);
                }
            });
            m6828a(appCompatImageView2, this.f12036j);
            m6828a(appCompatImageView, this.f12036j);
            if (this.f12037k > 0) {
                new CountDownTimerPasscode(this,  1000, 1000L).start();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private String getPasscodeFromView() {
        StringBuilder sb = new StringBuilder();
        int childCount = this.f12029c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            sb.append(((Integer) this.f12029c.getChildAt(i).getTag()).intValue());
        }
        return sb.toString();
    }


    public PasscodeView m6826a(verify_register verifyregister) {
        this.f12028b = verifyregister;
        return this;
    }


    public  void m6827a(View view) {
        int childCount = this.f12029c.getChildCount();
        if (childCount <= 0) {
            return;
        }
        this.f12029c.removeViewAt(childCount - 1);
    }


    public final void m6828a(AppCompatImageView appCompatImageView, int i) {
        appCompatImageView.getDrawable().mutate().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }


    public  boolean m6829b(View view) {
        if (this.f12029c.getChildCount() <= 0) {
            return true;
        }
        this.f12029c.removeAllViews();
        return true;
    }


    public  void m6830c(View view) {
        final String passcodeFromView = getPasscodeFromView();
        if (passcodeFromView.length() != this.f12034h) {
            this.f12030d.setText(this.f12033g);
            ObjectAnimator.ofFloat(this.f12030d, "translationX", 0.0f, 25.0f, -25.0f, 25.0f, -25.0f, 15.0f, -15.0f, 6.0f, -6.0f, 0.0f).setDuration(500L).start();
            return;
        }
        verify_register interfaceC3233a = this.f12028b;
        if (interfaceC3233a != null) {
            final PassCodeActivity.verify_register verifyregister = (PassCodeActivity.verify_register) interfaceC3233a;
            final Context applicationContext = getContext();
            if (applicationContext != null) {
                API_PROVIDER.checkInternet(applicationContext, new InterfaceContext() { // from class: b.f.a.a.b.b0
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context) {
                        //??PassCodeBaseActivity.C3190a.this.m6412a(applicationContext, passcodeFromView, context);
                    }
                });
            }
        }
    }

    public verify_register getListener() {
        return this.f12028b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (this.f12029c.getChildCount() >= this.f12034h) {
            return;
        }
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int i = this.f12039m;
        layoutParams.setMargins(i, 0, i, 0);
        textView.setLayoutParams(layoutParams);
        textView.setText(String.valueOf(intValue));
        textView.setTextColor(this.f12035i);
        textView.setTextSize(1, this.f12038l);
        textView.setTag(Integer.valueOf(intValue));
        this.f12029c.addView(textView);
    }
}
