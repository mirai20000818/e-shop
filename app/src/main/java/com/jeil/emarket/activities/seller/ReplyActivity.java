package com.jeil.emarket.activities.seller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.activities.intro.HelpDetailActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.vendor.Reply;
import java.util.Objects;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.providers.ReplyProvider;


public class ReplyActivity extends BaseActivity {


    public ReplyProvider f11808I;

   
    public int f11809J;

    
    public java.lang.String f11810K;

    /* renamed from: L */
    public java.lang.String f11811L;

    /* renamed from: M */
    public DialogC2001j f11812M;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplyActivity.this.m6591d(view);
            }
        });
        findViewById(R.id.cb_publish).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplyActivity.this.m6592e(view);
            }
        });
        findViewById(R.id.mrl_delete).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplyActivity.this.m6593f(view);
            }
        });
        findViewById(R.id.mrl_help).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplyActivity.this.m6594g(view);
            }
        });
    }


    public void m6585I() {
        java.lang.String str = this.f11810K;
        if (str == null || !str.equals("edit")) {
            return;
        }
        findViewById(R.id.mrl_delete).setVisibility(View.VISIBLE);
        ((CustomButton) findViewById(R.id.cb_publish)).setText(getResources().getString(R.string.request_publish));
    }

    
    public void m6586a(Bundle bundle) {
        this.f11809J = bundle.getInt("reviewId");
        this.f11810K = bundle.getString("page");
    }

    @SuppressLint({"SetTextI18n"})
    
    public final void m6587a(Reply reply) {
        Glide.with((FragmentActivity) this).load(Util.m306b(reply.productImage, "xl")).diskCacheStrategy(DiskCacheStrategy.ALL).load(getResources().getDrawable(R.drawable.ic_placeholder)).into((ImageView) findViewById(R.id.aiv_product_image));
        ((TextView) findViewById(R.id.ctv_product_name)).setText(reply.productName);
        this.f11811L = reply.productName;
        Glide.with((FragmentActivity) this).load(CustomString.m3159a(CustomString.format("e4/uploads/avatars/avatar-"), reply.customerAvatar, ".jpg")).load(getResources().getDrawable(R.drawable.man)).into((ImageView) findViewById(R.id.iv_avatar));
        ((TextView) findViewById(R.id.tv_username)).setText(reply.customerName);
        ((ProgressBar) findViewById(R.id.pb_rating)).setProgress(reply.reviewRating * 20);
        ((TextView) findViewById(R.id.tv_review_date)).setText(Util.m307b(reply.reviewDate));
        ((TextView) findViewById(R.id.ctv_item_quantityd)).setText(reply.orderItemQuantity + getResources().getString(R.string.count));
        PriceText priceText = (PriceText) findViewById(R.id.pt_order_total);
        priceText.setHidePriceNumber(false);
        priceText.setCurrency(reply.orderItemCurrency);
        priceText.setPrice(Util.m327c(reply.orderItemTotal));
        ((TextView) findViewById(R.id.tv_review_content)).setText(reply.reviewText);
        ((ActionLink) findViewById(R.id.cal_review_votes)).setText(java.lang.String.valueOf(reply.votes));
        if ((reply.replyStatus.equals("rejected") || reply.replyStatus.equals("urejected")) && reply.replyStatusText != null) {
            ((TextView) findViewById(R.id.ctv_rejected_reason)).setText(getString(R.string.rejected_reason) + " " + reply.replyStatusText);
            findViewById(R.id.ctv_rejected_reason).setVisibility(View.VISIBLE);
        }
        ((EditText) findViewById(R.id.cet_reply_text)).setText(reply.replyText);
    }

    
    public  void m6588a(Boolean bool) {
        this.f11812M.dismiss();
        if (bool.booleanValue()) {
            setResult(-1, new Intent(getApplicationContext(), MainActivityForVendor.class));
            finish();
        }
    }


    public  void m6589b(Boolean bool) {
        this.f11812M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
            MainActivityForVendor.global_id = R.id.navigation_review;
            setResult(-1, intent);
            finish();
        }
    }


    public  void m6590c(Boolean bool) {
        this.f11812M.dismiss();
        if (bool.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
            MainActivityForVendor.global_id = R.id.navigation_review;
            setResult(-1, intent);
            finish();
        }
    }


    public  void m6591d(View view) {
        onBackPressed();
    }


    public  void m6592e(View view) {
        boolean z;
        java.lang.String str;
        java.lang.String obj = ((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_reply_text)).getText())).toString();
        if (((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_reply_text)).getText())).toString().equals("")) {
            Util.toast(this, getString(R.string.reply_placeholder), "error", 0, 0);
            z = true;
        } else {
            z = false;
        }
        if (z || (str = this.f11810K) == null) {
            return;
        }
        if (!str.equals("edit")) {
            this.f11808I.add(this, this.f11809J, this.f11811L, obj);
            this.f11812M = new DialogC2001j(this);
            this.f11812M.show();
            this.f11808I.m5626c().observe(this, new Observer() { // from class: b.f.a.a.i.k
                @Override // p000a.p060o.InterfaceC0405p
                
                public final void onChanged(Object obj2) {
                    ReplyActivity.this.m6589b((Boolean) obj2);
                }
            });
            return;
        }
        Reply getValue = this.f11808I.m5627d().getValue();
        if (!((getValue == null || getValue.replyText.equals(obj)) ? false : true)) {
            Util.toast(this, getString(R.string.no_change), "error", 0, 0);
            return;
        }
        ReplyProvider replyProvider = this.f11808I;
        replyProvider.m5619a(this, this.f11809J, replyProvider.m5627d().getValue().replyId, this.f11811L, obj);
        this.f11812M = new DialogC2001j(this);
        this.f11812M.show();
        this.f11808I.m5626c().observe(this, new Observer() { // from class: b.f.a.a.i.j
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj2) {
                ReplyActivity.this.m6588a((Boolean) obj2);
            }
        });
    }

    /* renamed from: f */
    public  void m6593f(View view) {
        ReplyProvider replyProvider = this.f11808I;
        replyProvider.m5618a(this, ((Reply) Objects.requireNonNull(replyProvider.m5627d().getValue())).replyId);
        this.f11812M = new DialogC2001j(this);
        this.f11812M.show();
        this.f11808I.m5626c().observe(this, new Observer() { // from class: b.f.a.a.i.n
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                ReplyActivity.this.m6590c((Boolean) obj);
            }
        });
    }

    /* renamed from: g */
    public  void m6594g(View view) {
        Intent intent = new Intent(getApplicationContext(), HelpDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("title", "reply");
        intent.putExtra("vendor", true);
        startActivity(intent);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reply);
        m4307e(R.string.add_reply);
        this.f11808I = (ReplyProvider) new ViewModelProvider(this).get(ReplyProvider.class);
        m6586a((Bundle) Objects.requireNonNull(getIntent().getExtras()));
        m6585I();
        this.f11808I.m5623b(this, this.f11809J);
        this.f11808I.m5627d().observe(this, new Observer() { // from class: b.f.a.a.i.r2
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj) {
                ReplyActivity.this.m6587a((Reply) obj);
            }
        });
        findViewById(R.id.header_border).setVisibility(View.GONE);
        mo4284G();
    }
}
