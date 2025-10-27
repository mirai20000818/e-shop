package com.jeil.emarket.frag.main.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.jeil.emarket.activities.intro.SetupActivity;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.button.ButtonToggle;

/* renamed from: b.f.a.g.b.d.p */

public class FragmentSetupPagination extends Fragment {

    /* renamed from: a0 */
    public SetupActivity f9522a0;

    /* renamed from: b0 */
    public View f9523b0;

    public FragmentSetupPagination(SetupActivity setupActivity) {
        this.f9522a0 = setupActivity;
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9523b0 = layoutInflater.inflate(R.layout.fragment_setup_pagination, viewGroup, false);
        return this.f9523b0;
    }

    @Override // androidx.fragment.app.Fragment

    public void onViewCreated(View view, Bundle bundle) {
        CustomButton customButton = (CustomButton) this.f9523b0.findViewById(R.id.cb_prev);
        if (customButton != null) {
            customButton.setVisibility(View.GONE);
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentSetupPagination.this.m5091c(view2);
                }
            });
        }
        CustomButton customButton2 = (CustomButton) this.f9523b0.findViewById(R.id.cb_next);
        if (customButton2 != null) {
            customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentSetupPagination.this.m5092d(view2);
                }
            });
        }
        m5095i(this.f9522a0.f11740J);
        this.f9523b0.findViewById(R.id.cbt_infinite).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentSetupPagination.this.m5093e(view2);
            }
        });
        this.f9523b0.findViewById(R.id.cbt_pagination).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentSetupPagination.this.m5094f(view2);
            }
        });
    }


    public  void m5091c(View view) {
        this.f9522a0.m6474g(R.id.navigation_image);
    }


    public  void m5092d(View view) {
        this.f9522a0.m6474g(R.id.navigation_setup_complete);
    }


    public  void m5093e(View view) {
        m5095i(true);
    }

    /* renamed from: f */
    public  void m5094f(View view) {
        m5095i(false);
    }


    public void m5095i(boolean z) {
        this.f9522a0.f11740J = z;
        if (z) {
            ((ButtonToggle) this.f9523b0.findViewById(R.id.cbt_infinite)).m6896d();
            ((ButtonToggle) this.f9523b0.findViewById(R.id.cbt_pagination)).m6897e();
        } else {
            ((ButtonToggle) this.f9523b0.findViewById(R.id.cbt_infinite)).m6897e();
            ((ButtonToggle) this.f9523b0.findViewById(R.id.cbt_pagination)).m6896d();
        }
    }
}
