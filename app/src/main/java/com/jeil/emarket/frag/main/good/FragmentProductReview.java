package com.jeil.emarket.frag.main.good;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.jeil.emarket.custom.CustomString;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.ReviewRating;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialogRatingGroup;
import com.jeil.emarket.frag.main.vendor.FragmentReviewRating;

/* renamed from: b.f.a.g.b.c.q0 */

public class FragmentProductReview extends Fragment {

    /* renamed from: c0 */
    public ProductActivity f9483c0;

    /* renamed from: d0 */
    public View f9484d0;

    /* renamed from: e0 */
    public int f9485e0;

    /* renamed from: a0 */
    public List<Boolean> f9481a0 = new ArrayList();

    /* renamed from: b0 */
    public MutableLiveData<List<Integer>> f9482b0 = new MutableLiveData<>(new ArrayList());

    /* renamed from: f0 */
    public boolean f9486f0 = false;

    public FragmentProductReview(ProductActivity productActivity, int i) {
        this.f9483c0 = productActivity;
        this.f9485e0 = i;
    }

    /* renamed from: S0 */
    public void m5077S0() {
        for (int i = 0; i < 5; i++) {
            this.f9481a0.add(false);
        }
        this.f9483c0.f11779N.putInt("productId", this.f9485e0);
        ProductActivity productActivity = this.f9483c0;
        final FragmentReviewRating c2296d1 = new FragmentReviewRating(productActivity, "", "detail", productActivity.f11779N, this.f9482b0.getValue(), null);
        c2296d1.nsv_main = (NestedScrollView) this.f9484d0.findViewById(R.id.nsv_main);
        c2296d1.m4888T0();
        c2296d1.f9149m0 = true;
        FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ll_fragment, c2296d1, null);
        beginTransaction.commit();
        ((ButtonToggle) this.f9484d0.findViewById(R.id.bt_all)).m6896d();
        this.f9484d0.findViewById(R.id.bt_all).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentProductReview.this.m5079a(c2296d1, view);
            }
        });
        this.f9484d0.findViewById(R.id.bt_rate).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentProductReview.this.m5082b(c2296d1, view);
            }
        });
        c2296d1.f9197w0.observe(this, new Observer() { // from class: b.f.a.g.b.c.j0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentProductReview.this.m5081a((ReviewRating) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9484d0 = layoutInflater.inflate(R.layout.fragment_product_review, viewGroup, false);
        final NestedScrollView nestedScrollView = (NestedScrollView) this.f9484d0.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            BaseActivity activityC1391g1 = (BaseActivity) getActivity();
            activityC1391g1.m4286a((View) nestedScrollView, activityC1391g1, (View) null, false).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.c.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    nestedScrollView.smoothScrollBy(0, 0, 300);
                }
            });
        }
        return this.f9484d0;
    }


    public  void m5078a(dialogRatingGroup dialogRatingGroup, final FragmentReviewRating c2296d1, DialogInterface dialogInterface) {
        this.f9486f0 = false;
        if (dialogRatingGroup.f8851y.getValue() == null || this.f9482b0.getValue() == null) {
            return;
        }
        if ((dialogRatingGroup.f8851y.getValue().size() == 0 && ((List) Objects.requireNonNull(this.f9482b0.getValue())).size() == 0) || dialogRatingGroup.f8851y.getValue().equals(this.f9482b0.getValue())) {
            return;
        }
        this.f9482b0 = dialogRatingGroup.f8851y;
        this.f9481a0 = dialogRatingGroup.f8852z;
        this.f9482b0.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.c.h0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentProductReview.this.m5080a(c2296d1, (List) obj);
            }
        });
    }


    public  void m5079a(FragmentReviewRating c2296d1, View view) {
        if (((ButtonToggle) this.f9484d0.findViewById(R.id.bt_all)).f12185G) {
            return;
        }
        try {
            ((ButtonToggle) this.f9484d0.findViewById(R.id.bt_all)).m6896d();
            c2296d1.m4922c("all");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public  void m5080a(FragmentReviewRating c2296d1, List list) {
        ButtonToggle buttonToggle = (ButtonToggle) this.f9484d0.findViewById(R.id.bt_rate);
        if (list != null && !list.isEmpty()) {
            buttonToggle.m6896d();
        } else if (list != null) {
            buttonToggle.m6897e();
        }
        try {
            c2296d1.m4920a((List<Integer>) list);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }


    public  void m5081a(ReviewRating reviewRating) {
        int i;
        if (reviewRating != null) {
            View findViewById = this.f9484d0.findViewById(R.id.review_total);
            CustomString.m3167a(findViewById, R.id.tv_review_desc, 0, R.id.ll_shimmer_review_desc, 8);
            int[] iArr = {R.id.pb_progress1, R.id.pb_progress2, R.id.pb_progress3, R.id.pb_progress4, R.id.pb_progress5};
            int[] iArr2 = {R.id.pb_rating1, R.id.pb_rating2, R.id.pb_rating3, R.id.pb_rating4, R.id.pb_rating5};
            int[] iArr3 = {R.id.ctv_progress_count1, R.id.ctv_progress_count2, R.id.ctv_progress_count3, R.id.ctv_progress_count4, R.id.ctv_progress_count5};
            float f = 0.0f;
            if (reviewRating.reviewsCount != null) {
                int i2 = 0;
                i = 0;
                while (i2 < ((int[]) Objects.requireNonNull(reviewRating.reviewsCount)).length) {
                    int i3 = i2 + 1;
                    ((ProgressBar) findViewById.findViewById(iArr2[i2])).setProgress(i3 * 20);
                    TextView textView = (TextView) findViewById.findViewById(iArr3[i2]);
                    textView.setText(((int[]) Objects.requireNonNull(reviewRating.reviewsCount))[i2] + getResources().getString(R.string.count));
                    Util.setColor(this.f9483c0, textView, R.color.body);
                    int[] iArr4 = reviewRating.reviewsCount;
                    f += (float) (iArr4[i2] * i3);
                    i += iArr4[i2];
                    i2 = i3;
                }
            } else {
                for (int i4 = 0; i4 < 5; i4++) {
                    Util.setColor(this.f9483c0, (TextView) findViewById.findViewById(iArr3[i4]), R.color.body);
                }
                i = 0;
            }
            if (reviewRating.reviewsCount != null) {
                for (int i5 = 0; i5 < ((int[]) Objects.requireNonNull(reviewRating.reviewsCount)).length; i5++) {
                    ((ProgressBar) findViewById.findViewById(iArr[i5])).setProgress((reviewRating.reviewsCount[i5] * 100) / (i == 0 ? 1 : i));
                }
            }
            TextView textView2 = (TextView) findViewById.findViewById(R.id.tv_rating);
            textView2.setText(java.lang.String.format("%.1f", Float.valueOf(reviewRating.ratingAvg)));
            Util.setColor(this.f9483c0, textView2, R.color.black);
            ((ProgressBar) findViewById.findViewById(R.id.pb_product_rating)).setProgress((int) ((f / (i == 0 ? 1 : i)) * 20.0f));
            TextView textView3 = (TextView) findViewById.findViewById(R.id.tv_product_reviews);
            StringBuilder m3164a = CustomString.m3164a("(", i);
            m3164a.append((R.string.cnt_reviews));
            m3164a.append(")");
            textView3.setText(m3164a.toString());
            Util.setColor(this.f9483c0, textView3, R.color.body);
            ((ShimmerFrameLayout) findViewById.findViewById(R.id.sfl_layout)).hideShimmer();
        }
    }


    public  void m5082b(final FragmentReviewRating c2296d1, View view) {
        if (this.f9486f0) {
            return;
        }
        final dialogRatingGroup dialogRatingGroup = new dialogRatingGroup(this.f9483c0, this.f9482b0.getValue(), this.f9481a0);
        dialogRatingGroup.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.c.e0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                FragmentProductReview.this.m5078a(dialogRatingGroup, c2296d1, dialogInterface);
            }
        });
        ((Window) Objects.requireNonNull(dialogRatingGroup.getWindow())).setDimAmount(0.85f);
        this.f9486f0 = true;
        dialogRatingGroup.show();
    }
}
