package com.jeil.emarket.frag.main.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.jeil.emarket.activities.intro.SetupActivity;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.activities.baseactivity.BaseActivity;

/* renamed from: b.f.a.g.b.d.o */

public class FragmentSetupImage extends Fragment {

    /* renamed from: a0 */
    public SetupActivity f9520a0;

    /* renamed from: b0 */
    public View f9521b0;

    public FragmentSetupImage(SetupActivity setupActivity) {
        this.f9520a0 = setupActivity;
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9521b0 = layoutInflater.inflate(R.layout.fragment_setup_image, viewGroup, false);
        return this.f9521b0;
    }

    @Override // androidx.fragment.app.Fragment

    public void onViewCreated(View view, Bundle bundle) {
        View findViewById;
        int i = this.f9520a0.f11741K;
        if (i == 3 || BaseActivity.anInt >= 1080) {
            ((TextView) this.f9521b0.findViewById(R.id.tv_level)).setText(String.format(getResources().getString(R.string.select_image_level_desc), 3));
            this.f9520a0.f11741K = 3;
            findViewById = this.f9521b0.findViewById(R.id.cbt_level_3);
        } else if (i != 1) {
            ((TextView) this.f9521b0.findViewById(R.id.tv_level)).setText(String.format(getResources().getString(R.string.select_image_level_desc), 2));
            this.f9520a0.f11741K = 2;
            findViewById = this.f9521b0.findViewById(R.id.cbt_level_2);
        } else {
            ((TextView) this.f9521b0.findViewById(R.id.tv_level)).setText(String.format(getResources().getString(R.string.select_image_level_desc), 1));
            this.f9520a0.f11741K = 1;
            findViewById = this.f9521b0.findViewById(R.id.cbt_level_1);
        }
        ((ButtonToggle) findViewById).m6896d();
        CustomButton customButton = (CustomButton) this.f9521b0.findViewById(R.id.cb_prev);
        if (customButton != null) {
            customButton.setVisibility(View.GONE);
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentSetupImage.this.m5086c(view2);
                }
            });
        }
        CustomButton customButton2 = (CustomButton) this.f9521b0.findViewById(R.id.cb_next);
        if (customButton2 != null) {
            customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentSetupImage.this.m5087d(view2);
                }
            });
        }
        this.f9521b0.findViewById(R.id.cbt_level_1).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentSetupImage.this.m5088e(view2);
            }
        });
        this.f9521b0.findViewById(R.id.cbt_level_2).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentSetupImage.this.m5089f(view2);
            }
        });
        this.f9521b0.findViewById(R.id.cbt_level_3).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentSetupImage.this.m5090g(view2);
            }
        });
    }

    
    public void m5085c(int i) {
        this.f9520a0.f11741K = i;
        ButtonToggle[] buttonToggleArr = {(ButtonToggle) this.f9521b0.findViewById(R.id.cbt_level_1), (ButtonToggle) this.f9521b0.findViewById(R.id.cbt_level_2), (ButtonToggle) this.f9521b0.findViewById(R.id.cbt_level_3)};
        for (ButtonToggle buttonToggle : buttonToggleArr) {
            buttonToggle.m6897e();
        }
        buttonToggleArr[i - 1].m6896d();
    }

    
    public  void m5086c(View view) {
        this.f9520a0.m6474g(R.id.navigation_color);
    }

    
    public  void m5087d(View view) {
        this.f9520a0.m6474g(R.id.navigation_infinite);
    }

    
    public  void m5088e(View view) {
        m5085c(1);
    }

    /* renamed from: f */
    public  void m5089f(View view) {
        m5085c(2);
    }

    /* renamed from: g */
    public  void m5090g(View view) {
        m5085c(3);
    }
}
