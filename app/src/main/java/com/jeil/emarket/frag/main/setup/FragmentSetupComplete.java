package com.jeil.emarket.frag.main.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.jeil.emarket.activities.intro.SetupActivity;
import com.jeil.emarket.components.button.CustomButton;

/* renamed from: b.f.a.g.b.d.q */

public class FragmentSetupComplete extends Fragment {

    /* renamed from: a0 */
    public SetupActivity f9524a0;

    /* renamed from: b0 */
    public View f9525b0;

    public FragmentSetupComplete(SetupActivity setupActivity) {
        this.f9524a0 = setupActivity;
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9525b0 = layoutInflater.inflate(R.layout.fragment_setup_complete, viewGroup, false);
        return this.f9525b0;
    }

    @Override // androidx.fragment.app.Fragment

    public void onViewCreated(View view, Bundle bundle) {
        CustomButton customButton = (CustomButton) this.f9525b0.findViewById(R.id.cb_prev);
        if (customButton != null) {
            customButton.setVisibility(View.GONE);
            customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentSetupComplete.this.m5096c(view2);
                }
            });
        }
        CustomButton customButton2 = (CustomButton) this.f9525b0.findViewById(R.id.cb_complete);
        if (customButton2 != null) {
            ((LinearLayoutCompat.LayoutParams) customButton2.getLayoutParams()).setMargins(0, 0, 0, 0);
            customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.d.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentSetupComplete.this.m5097d(view2);
                }
            });
        }
    }


    public  void m5096c(View view) {
        this.f9524a0.m6474g(R.id.navigation_infinite);
    }


    public  void m5097d(View view) {
        this.f9524a0.m6473I();
    }
}
