package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.checkbox.CheckBox;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;

/* renamed from: b.f.a.f.a3 */

public class dialogRatingGroup extends BaseAniDialog<dialogRatingGroup> {


    public List<View> f8850A;

    /* renamed from: y */
    public MutableLiveData<List<Integer>> f8851y;

    /* renamed from: z */
    public List<Boolean> f8852z;

    public dialogRatingGroup(BaseActivity activityC1391g1, List<Integer> list, List<Boolean> list2) {
        super(activityC1391g1, 80);
        this.f8851y = new MutableLiveData<>();
        this.f8850A = new ArrayList();
        this.f8851y.setValue( list);
        this.f8852z = list2;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    @SuppressLint({"UseCompatLoadingForDrawables", "RestrictedApi"})

    public View mo4576b() {
        View inflate = View.inflate(this.f8251b, R.layout.dialog_rating_group, null);
        inflate.findViewById(R.id.rating_button_group).setBackground(inflate.getResources().getDrawable(R.color.white));
        inflate.findViewById(R.id.cb_cancel).setVisibility(View.GONE);
        inflate.findViewById(R.id.cb_cancel_outline).setVisibility(View.VISIBLE);
        inflate.setBackground(Util.m205a(Color.parseColor("#ffffffff"), new float[]{m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), m4590a(20.0f), 0.0f, 0.0f, 0.0f, 0.0f}));
        inflate.setPadding(m4590a(10.0f), m4590a(20.0f), m4590a(10.0f), m4590a(7.0f));
        for (int i = 0; i < 5; i++) {
            View inflate2 = View.inflate(this.f8251b, R.layout.item_select_rating, null);
            ((ProgressBar) inflate2.findViewById(R.id.review_rating)).setProgress((5 - i) * 20);
            ((CheckBox) inflate2.findViewById(R.id.crb_rating)).setChecked(this.f8852z.get(i).booleanValue());
            ((LinearLayoutCompat) inflate.findViewById(R.id.llc_rating_box)).addView(inflate2);
            this.f8850A.add(inflate2);
        }
        ((CustomButton) inflate.findViewById(R.id.cb_cancel_outline)).setText(R.string.reset);
        inflate.findViewById(R.id.cb_cancel_outline).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogRatingGroup.this.m4774c(view);
            }
        });
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogRatingGroup.this.m4775d(view);
            }
        });
        return inflate;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g
    
    public void mo4577c() {
    }

    
    public  void m4774c(View view) {
        this.f8851y.setValue( new ArrayList());
        for (int i = 0; i < 5; i++) {
            this.f8852z.set(i, false);
        }
        startAni();
    }

    
    public  void m4775d(View view) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            this.f8852z.set(i, Boolean.valueOf(((CheckBox) this.f8850A.get(i).findViewById(R.id.crb_rating)).isChecked()));
            if (((CheckBox) this.f8850A.get(i).findViewById(R.id.crb_rating)).isChecked()) {
                arrayList.add(Integer.valueOf(((ProgressBar) this.f8850A.get(i).findViewById(R.id.review_rating)).getProgress() / 20));
            }
        }
        this.f8851y.setValue( arrayList);
        startAni();
    }
}
