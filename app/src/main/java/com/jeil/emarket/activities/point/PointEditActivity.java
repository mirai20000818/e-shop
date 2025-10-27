package com.jeil.emarket.activities.point;

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
import com.jeil.emarket.components.vendor.VendorLevel;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Point;
import com.jeil.emarket.model.customer.VendorCard;
import java.util.Objects;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.viewmodel.ModelCollection;
import com.jeil.emarket.providers.ReviewProvider;


public class PointEditActivity extends BaseActivity {


    public ReviewProvider f11767I;


    public String f11768J;


    public String f11769K;

    /* renamed from: L */
    public int f11770L;

    /* renamed from: M */
    public DialogC2001j f11771M;


    public void m6541a(Bundle bundle) {
        this.f11768J = bundle.getString("page");
        this.f11769K = bundle.getString("vendorName");
        String str = this.f11768J;
        if (str != null && str.equals("edit")) {
            int i = bundle.getInt("pointId", 0);
            this.f11770L = bundle.getInt("orderId", 0);
            this.f11767I.m5651e(this, i);
        } else {
            String str2 = this.f11768J;
            if (str2 == null || !str2.equals("add")) {
                return;
            }
            this.f11767I.m5656g(this, bundle.getInt("vendorId", 0));
        }
    }


    public  void m6542a(final Bundle bundle, View view) {
        boolean z;
        if (((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_point_text)).getText())).toString().isEmpty()) {
            Util.toast(this, getString(R.string.point_placeholder), "error", 0, 0);
            z = true;
        } else {
            z = false;
        }
        if (!z && (((MaterialRatingBar) findViewById(R.id.mrb_support_point)).getRating() == 0.0f || ((MaterialRatingBar) findViewById(R.id.mrb_service_point)).getRating() == 0.0f || ((MaterialRatingBar) findViewById(R.id.mrb_shipping_point)).getRating() == 0.0f)) {
            Util.toast(this, getString(R.string.rating_validation), "error", 0, 0);
            z = true;
        }
        String obj = ((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_point_text)).getText())).toString();
        int rating = (int) ((MaterialRatingBar) findViewById(R.id.mrb_support_point)).getRating();
        int rating2 = (int) ((MaterialRatingBar) findViewById(R.id.mrb_service_point)).getRating();
        int rating3 = (int) ((MaterialRatingBar) findViewById(R.id.mrb_shipping_point)).getRating();
        if (z) {
            return;
        }
        if (!this.f11768J.equals("edit")) {
            this.f11767I.m5633a(view.getContext(), bundle.getInt("orderId"), bundle.getInt("vendorId"), rating2, rating3, rating, obj);
            this.f11771M = new DialogC2001j(this);
            this.f11771M.show();
            this.f11767I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.f.s
                @Override // p000a.p060o.InterfaceC0405p

                public final void onChanged(Object obj2) {
                    PointEditActivity.this.m6543a(bundle, (Boolean) obj2);
                }
            });
            return;
        }
        Point getValue = this.f11767I.m5647d().getValue();
        boolean z2 = !getValue.text.equals(obj);
        if (getValue.supportPoint != rating || getValue.servicePoint != rating2 || getValue.shippingPoint != rating3) {
            z2 = true;
        }
        if (!z2) {
            Util.toast(this, getString(R.string.no_change), "error", 0, 0);
            return;
        }
        this.f11767I.m5640b(this, getValue.pointId, this.f11770L, rating, rating2, rating, obj);
        this.f11771M = new DialogC2001j(this);
        this.f11771M.show();
        this.f11767I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.f.m
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj2) {
                PointEditActivity.this.m6546a((Boolean) obj2);
            }
        });
    }


    public  void m6543a(Bundle bundle, Boolean bool) {
        this.f11771M.dismiss();
        if (bool.booleanValue()) {
            ModelCollection.m5436b(this, bundle.getInt("parent_orderId"));
            onBackPressed();
            finish();
        }
    }


    public  void m6546a(Boolean bool) {
        this.f11771M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), PointActivity.class);
            intent.putExtra("page", "account");
            setResult(-1, intent);
            finish();
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public void m6547b(final Bundle bundle) {
        super.mo4284G();
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointEditActivity.this.m6550d(view);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointEditActivity.this.m6542a(bundle, view);
            }
        });
        findViewById(R.id.mrl_delete_button).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointEditActivity.this.m6551e(view);
            }
        });
        findViewById(R.id.mrl_format_button).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointEditActivity.this.m6552f(view);
            }
        });
        findViewById(R.id.mrl_show_review_rule).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.f.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointEditActivity.this.m6553g(view);
            }
        });
    }


    public  void m6548b(Boolean bool) {
        this.f11771M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), PointActivity.class);
            intent.putExtra("page", "account");
            setResult(-1, intent);
            finish();
        }
    }


    public  void m6549c(Boolean bool) {
        this.f11771M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), PointActivity.class);
            intent.putExtra("page", "account");
            setResult(-1, intent);
            finish();
        }
    }


    public  void m6550d(View view) {
        if (!this.f11768J.equals("edit")) {
            onBackPressed();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), PointActivity.class);
        intent.putExtra("page", "account");
        setResult(-1, intent);
        finish();
    }


    public  void m6551e(View view) {
        ReviewProvider reviewProvider = this.f11767I;
        reviewProvider.m5632a(this, ((Point) Objects.requireNonNull(reviewProvider.m5647d().getValue())).pointId);
        this.f11771M = new DialogC2001j(this);
        this.f11771M.show();
        this.f11767I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.f.p
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PointEditActivity.this.m6548b((Boolean) obj);
            }
        });
    }

    /* renamed from: f */
    public  void m6552f(View view) {
        ReviewProvider reviewProvider = this.f11767I;
        reviewProvider.m5645c(this, ((Point) Objects.requireNonNull(reviewProvider.m5647d().getValue())).pointId);
        this.f11771M = new DialogC2001j(this);
        this.f11771M.show();
        this.f11767I.m5644c().observe(this, new Observer() { // from class: b.f.a.a.f.t
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PointEditActivity.this.m6549c((Boolean) obj);
            }
        });
    }

    /* renamed from: g */
    public  void m6553g(View view) {
        Intent intent = new Intent(getApplicationContext(), HelpDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("index", 13);
        startActivity(intent);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_point);
        m4307e(R.string.edit_point);
        this.f11767I = (ReviewProvider) new ViewModelProvider(this).get(ReviewProvider.class);
        m6541a((Bundle) Objects.requireNonNull(getIntent().getExtras()));
        this.f11767I.m5647d().observe(this, new Observer() { // from class: b.f.a.a.f.v
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PointEditActivity.this.m6544a((Point) obj);
            }
        });
        this.f11767I.m5653f().observe(this, new Observer() { // from class: b.f.a.a.f.a
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                PointEditActivity.this.m6545a((VendorCard) obj);
            }
        });
        m6547b((Bundle) Objects.requireNonNull(getIntent().getExtras()));
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }

    @SuppressLint({"SetTextI18n"})

    public final void m6544a(Point point) {
        ((VendorLevel) findViewById(R.id.vl_vendor_level)).m6978a(point.point, this);
        ((TextView) findViewById(R.id.ep_vendor_name)).setText(point.vendorName);
        RequestManager m3287a = Glide.with((FragmentActivity) this);
        String str = point.vendorCard;
        m3287a.load(str != null ? Util.m345e(str) : getResources().getDrawable(R.drawable.vendor)).diskCacheStrategy(DiskCacheStrategy.ALL).load(getResources().getDrawable(R.drawable.vendor))

               // .m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) this, 5)), true)
                .into((ImageView) findViewById(R.id.vendor_card_img));
        RequestManager m3287a2 = Glide.with((FragmentActivity) this);
        String str2 = point.logo;
        m3287a2.load(str2 != null ? Util.m345e(str2) : getResources().getDrawable(R.drawable.logo_home))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .load(getResources().getDrawable(R.drawable.logo_home))
               // .m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) this, 5)), true)
                .into((ImageView) findViewById(R.id.vendor_logo_img));
        ((MaterialRatingBar) findViewById(R.id.mrb_support_point)).setRating(point.supportPoint);
        ((MaterialRatingBar) findViewById(R.id.mrb_service_point)).setRating(point.servicePoint);
        ((MaterialRatingBar) findViewById(R.id.mrb_shipping_point)).setRating(point.shippingPoint);
        ((EditText) findViewById(R.id.cet_point_text)).setText(point.text);
        if ((point.status.equals("rejected") || point.status.equals("urejected")) && point.rejectedReason != null) {
            ((TextView) findViewById(R.id.ctv_rejected_reason)).setText(getString(R.string.rejected_reason) + " " + point.rejectedReason);
            findViewById(R.id.ctv_rejected_reason).setVisibility(View.VISIBLE);
        }
        if (point.status.equals("rejected")) {
            findViewById(R.id.mrl_delete_button).setVisibility(View.VISIBLE);
        }
        if (point.status.equals("urejected")) {
            findViewById(R.id.mrl_format_button).setVisibility(View.VISIBLE);
        }
    }


    public final void m6545a(VendorCard vendorCard) {
        ((VendorLevel) findViewById(R.id.vl_vendor_level)).m6978a(vendorCard.point, this);
        ((TextView) findViewById(R.id.ep_vendor_name)).setText(this.f11769K);
        RequestManager m3287a = Glide.with((FragmentActivity) this);
        String str = vendorCard.cardUrl;
        m3287a.load(str != null ? Util.m345e(str) : getResources().getDrawable(R.drawable.vendor)).diskCacheStrategy(DiskCacheStrategy.ALL).load(getResources().getDrawable(R.drawable.vendor))
                //.m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) this, 5)), true)
                .into((ImageView) findViewById(R.id.vendor_card_img));
        RequestManager m3287a2 = Glide.with((FragmentActivity) this);
        String str2 = vendorCard.logoUrl;
        m3287a2.load(str2 != null ? Util.m345e(str2) : getResources().getDrawable(R.drawable.logo_home)).diskCacheStrategy(DiskCacheStrategy.ALL).load(getResources().getDrawable(R.drawable.logo_home))
              //  .m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px((Context) this, 5)), true)
                .into((ImageView) findViewById(R.id.vendor_logo_img));
    }
}
