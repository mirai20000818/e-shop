package com.jeil.emarket.activities.review;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;

import com.jeil.emarket.activities.intro.HelpDetailActivity;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.ratingbar.MaterialRatingBar;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Review;
import java.util.Objects;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.viewmodel.ModelCollection;
import com.jeil.emarket.providers.ReviewProvider;


public class ReviewEditActivity extends BaseActivity {

    
    public ReviewProvider f11797I;

   
    public String f11798J;

    
    public int f11799K;

    /* renamed from: L */
    public String f11800L;

    /* renamed from: M */
    public DialogC2001j f11801M;


    public void m6568a(Bundle bundle) {
        this.f11798J = bundle.getString("page");
        this.f11799K = bundle.getInt("productId");
        this.f11800L = bundle.getString("productName");
        String string = bundle.getString("productImage");
        String str = this.f11800L;
        if (str != null && !str.isEmpty() && this.f11798J.equals("add")) {
            ((TextView) findViewById(R.id.ctv_product_name)).setText(this.f11800L);
        }
        if (string != null && !string.isEmpty() && this.f11798J.equals("add")) {
            String m306b = Util.m306b(string, "xl");
            Glide.with((FragmentActivity) this).load(m306b).load(getResources().getDrawable(R.drawable.ic_placeholder)).diskCacheStrategy(m306b.startsWith("file://") ?
                    DiskCacheStrategy.DATA : DiskCacheStrategy.ALL).into((ImageView) findViewById(R.id.aiv_product_image));
        }
        String str2 = this.f11798J;
        if (str2 == null || !str2.equals("edit")) {
            return;
        }
        this.f11797I.m5654f(this, bundle.getInt("reviewId", 0));
    }


    public  void m6569a(final Bundle bundle, View view) {
        boolean z;
        String obj = ((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_review_text)).getText())).toString();
        int rating = (int) ((MaterialRatingBar) findViewById(R.id.mrb_review_rating)).getRating();
        if (((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_review_text)).getText())).toString().isEmpty()) {
            Util.toast(this, getString(R.string.review_warning_notice), "error", 0, 0);
            z = true;
        } else {
            z = false;
        }
        if (!z && ((MaterialRatingBar) findViewById(R.id.mrb_review_rating)).getRating() == 0.0f) {
            Util.toast(this, getString(R.string.rating_validation), "error", 0, 0);
            z = true;
        }
        if (z) {
            return;
        }
        if (!this.f11798J.equals("edit")) {
            this.f11797I.m5634a(view.getContext(), bundle.getInt("orderItemId"), bundle.getInt("vendorId"), bundle.getInt("productId"), rating, obj);
            this.f11801M = new DialogC2001j(this);
            this.f11801M.show();
            this.f11797I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.h.g
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj2) {
                    ReviewEditActivity.this.m6570a(bundle, (Boolean) obj2);
                }
            });
            return;
        }
        Review getValue = this.f11797I.m5650e().getValue();
        boolean z2 = !getValue.text.equals(obj);
        if (getValue.rating != rating) {
            z2 = true;
        }
        if (!z2) {
            Util.toast(this, getString(R.string.no_change), "error", 0, 0);
            return;
        }
        this.f11797I.m5635a(this, this.f11799K, getValue.reviewId, rating, obj);
        this.f11801M = new DialogC2001j(this);
        this.f11801M.show();
        this.f11797I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.h.j
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj2) {
                ReviewEditActivity.this.m6572a((Boolean) obj2);
            }
        });
    }


    public  void m6570a(Bundle bundle, Boolean bool) {
        this.f11801M.dismiss();
        if (bool.booleanValue()) {
            ModelCollection.m5436b(this, bundle.getInt("orderId"));
            onBackPressed();
            finish();
        }
    }

    @SuppressLint({"SetTextI18n"})

    public final void m6571a(Review review) {
        String m306b = Util.m306b(review.productImage, "xl");
        Glide.with((FragmentActivity) this).load(m306b).diskCacheStrategy(m306b.startsWith("file://") ? DiskCacheStrategy.DATA : DiskCacheStrategy.ALL).load(getResources().getDrawable(R.drawable.ic_placeholder)).into((ImageView) findViewById(R.id.aiv_product_image));
        TextView textView = (TextView) findViewById(R.id.ctv_product_name);
        String str = this.f11800L;
        if (str == null) {
            str = review.productName;
        }
        textView.setText(str);
        ((MaterialRatingBar) findViewById(R.id.mrb_review_rating)).setRating(review.rating);
        ((EditText) findViewById(R.id.cet_review_text)).setText(review.text);
        if ((review.status.equals("rejected") || review.status.equals("urejected")) && review.rejectedReason != null) {
            ((TextView) findViewById(R.id.ctv_rejected_reason)).setText(getResources().getString(R.string.rejected_reason) + " " + review.rejectedReason);
            findViewById(R.id.ctv_rejected_reason).setVisibility(View.VISIBLE);
        }
        if (review.status.equals("rejected")) {
            findViewById(R.id.mrl_delete_button).setVisibility(View.VISIBLE);
        }
        if (review.status.equals("urejected")) {
            findViewById(R.id.mrl_format_button).setVisibility(View.VISIBLE);
        }
    }


    public  void m6572a(Boolean bool) {
        this.f11801M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
            intent.putExtra("page", "account");
            setResult(-1, intent);
            finish();
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    
    public void m6573b(final Bundle bundle) {
        super.mo4284G();
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.h.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReviewEditActivity.this.m6576d(view);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.h.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReviewEditActivity.this.m6569a(bundle, view);
            }
        });
        findViewById(R.id.mrl_delete_button).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.h.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReviewEditActivity.this.m6577e(view);
            }
        });
        findViewById(R.id.mrl_format_button).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.h.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReviewEditActivity.this.m6578f(view);
            }
        });
        findViewById(R.id.mrl_show_review_rule).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.h.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReviewEditActivity.this.m6579g(view);
            }
        });
    }

    
    public  void m6574b(Boolean bool) {
        this.f11801M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
            intent.putExtra("page", "account");
            setResult(-1, intent);
            finish();
        }
    }

    
    public  void m6575c(Boolean bool) {
        this.f11801M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
            intent.putExtra("page", "account");
            setResult(-1, intent);
            finish();
        }
    }

    
    public  void m6576d(View view) {
        if (!this.f11798J.equals("edit")) {
            onBackPressed();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
        intent.putExtra("page", "account");
        setResult(-1, intent);
        finish();
    }

    
    public  void m6577e(View view) {
        ReviewProvider reviewProvider = this.f11797I;
        reviewProvider.m5639b(this, ((Review) Objects.requireNonNull(reviewProvider.m5650e().getValue())).reviewId);
        this.f11801M = new DialogC2001j(this);
        this.f11801M.show();
        this.f11797I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.h.k
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ReviewEditActivity.this.m6574b((Boolean) obj);
            }
        });
    }

    /* renamed from: f */
    public  void m6578f(View view) {
        ReviewProvider reviewProvider = this.f11797I;
        reviewProvider.m5648d(this, ((Review) Objects.requireNonNull(reviewProvider.m5650e().getValue())).reviewId);
        this.f11801M = new DialogC2001j(this);
        this.f11801M.show();
        this.f11797I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.h.d
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ReviewEditActivity.this.m6575c((Boolean) obj);
            }
        });
    }

    /* renamed from: g */
    public  void m6579g(View view) {
        Intent intent = new Intent(getApplicationContext(), HelpDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("index", 13);
        startActivity(intent);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_review);
        m4307e(R.string.edit_review);
        this.f11797I = (ReviewProvider) new ViewModelProvider(this).get(ReviewProvider.class);
        m6568a((Bundle) Objects.requireNonNull(getIntent().getExtras()));
        this.f11797I.m5650e().observe(this, new Observer() { // from class: b.f.a.a.h.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ReviewEditActivity.this.m6571a((Review) obj);
            }
        });
        m6573b((Bundle) Objects.requireNonNull(getIntent().getExtras()));
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
