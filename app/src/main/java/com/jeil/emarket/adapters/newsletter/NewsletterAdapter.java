package com.jeil.emarket.adapters.newsletter;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Newsletter;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.api.AniListener;
import com.jeil.emarket.api.Interface3;

/* renamed from: b.f.a.b.f.i */

public class NewsletterAdapter extends BaseMainAdapter<Newsletter, NewsletterAdapter.a> {

    /* renamed from: b.f.a.b.f.i$a */
    public static class a extends RecyclerView.ViewHolder {

        
        public final TextView f7237A;

        
        public final View f7238B;

        
        public boolean f7239C;

        /* renamed from: t */
        public final FrameLayout f7240t;

        /* renamed from: u */
        public final MaterialRippleLayout f7241u;

        /* renamed from: v */
        public final TextView f7242v;

        /* renamed from: w */
        public final TextView f7243w;

        /* renamed from: x */
        public final LinearLayoutCompat f7244x;

        /* renamed from: y */
        public final TextView f7245y;

        /* renamed from: z */
        public final ActionLink f7246z;

        public a(View view) {
            super(view);
            this.f7239C = false;
            this.f7240t = (FrameLayout) view.findViewById(R.id.fl_main);
            this.f7241u = (MaterialRippleLayout) view.findViewById(R.id.mrl_newsletter);
            this.f7242v = (TextView) view.findViewById(R.id.tv_newsletter_order);
            this.f7243w = (TextView) view.findViewById(R.id.tv_newsletter_title);
            this.f7244x = (LinearLayoutCompat) view.findViewById(R.id.ll_newsletter_content);
            this.f7245y = (TextView) view.findViewById(R.id.tv_newsletter_content);
            this.f7246z = (ActionLink) view.findViewById(R.id.cal_newsletter_link);
            this.f7237A = (TextView) view.findViewById(R.id.tv_code);
            this.f7238B = view.findViewById(R.id.v_border);
        }
    }

    public NewsletterAdapter(BaseActivity activityC1391g1) {
        super(activityC1391g1);
    }

    
    public static  void m4434a(a aVar, Newsletter newsletter) {
        aVar.f7244x.setVisibility(View.VISIBLE);
        if (newsletter.initialHeight == 0) {
            newsletter.initialHeight = aVar.f7244x.getMeasuredHeight();
        }
        aVar.f7244x.setVisibility(View.GONE);
    }

    
    public static  void m4435a(Newsletter newsletter, a aVar) {
        java.lang.String str = newsletter.link;
        if (str == null || newsletter.url == null || str.isEmpty() || newsletter.url.isEmpty()) {
            return;
        }
        aVar.f7246z.setVisibility(aVar.f7239C ? View.VISIBLE : View.GONE);
    }

    
    public  void m4436a(a aVar) {
        NewsletterAdapterAni newsletterAdapterAni = new NewsletterAdapterAni(this, aVar);
        newsletterAdapterAni.setDuration(Status.time);
        this.baseActivity.recyclerView.startAnimation(newsletterAdapterAni);
    }

    
    public  void m4437a(Newsletter newsletter, View view) {
        Util.m257a((MainActivity) this.baseActivity, Util.m349f(newsletter.url));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})
    
    public void onBindViewHolder(a viewHolder, int i) {
        final a aVar = (a) viewHolder;
        final Newsletter newsletter = (Newsletter) this.arrayList.get(i);
        aVar.f7242v.setText((i + 1) + ".");
        java.lang.String str = newsletter.title;
        StringBuilder m3163a = CustomString.format(" (");
        m3163a.append(Util.date2Str(newsletter.startDate));
        m3163a.append(")");
        java.lang.String sb = m3163a.toString();
        SpannableString spannableString = new SpannableString(CustomString.append(str, sb));
        spannableString.setSpan(new ForegroundColorSpan(this.baseActivity.getResources().getColor(R.color.dark)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(this.baseActivity.getResources().getColor(R.color.light)), str.length(), sb.length() + str.length(), 33);
        aVar.f7243w.setText(spannableString);
        aVar.f7245y.setText(newsletter.content);
        aVar.f7237A.setText(newsletter.approvedCode);
        java.lang.String str2 = newsletter.link;
        if (str2 == null || newsletter.url == null || str2.isEmpty() || newsletter.url.isEmpty()) {
            aVar.f7246z.setVisibility(View.GONE);
        } else {
            aVar.f7246z.setText(newsletter.link);
            aVar.f7246z.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.f.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewsletterAdapter.this.m4437a(newsletter, view);
                }
            });
        }
        if (i == getItemCount() - 1) {
            aVar.f7238B.setVisibility(View.GONE);
        } else {
            aVar.f7238B.setVisibility(View.VISIBLE);
        }
        new Handler().post(new Runnable() { // from class: b.f.a.b.f.e
            @Override // java.lang.Runnable
            public final void run() {
                //NewsletterAdapter.m4434a(NewsletterAdapter.a.this, newsletter);
            }
        });
        aVar.f7241u.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.f.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewsletterAdapter.this.m4438a(newsletter, aVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(CustomString.m3150a(viewGroup, R.layout.item_newsletter, viewGroup, false));
    }

    
    public  void m4438a(final Newsletter newsletter, final a aVar, View view) {
        java.lang.String str = newsletter.link;
        if (str != null && newsletter.url != null && !str.isEmpty() && !newsletter.url.isEmpty()) {
            aVar.f7246z.setVisibility(View.GONE);
        }
        aVar.f7239C = !aVar.f7239C;
        if (!aVar.f7239C) {
            Util.m246a(aVar.f7244x, Status.time, newsletter.initialHeight);
            return;
        }
        LinearLayoutCompat linearLayoutCompat = aVar.f7244x;
        long j = Status.time;
        int i = newsletter.initialHeight;
        Interface3 interface3 = new Interface3() { // from class: b.f.a.b.f.b
            @Override // p078b.p159f.p160a.p254i.InterfaceC2738y
            
            public final void mo4432a() {
               // NewsletterAdapter.m4435a(Newsletter.this, aVar);
            }
        };
        Animation m299b = Util.m299b(linearLayoutCompat, j, i);
        m299b.setAnimationListener(new AniListener(interface3));
        linearLayoutCompat.startAnimation(m299b);
        if (aVar.f7240t.getTop() > this.baseActivity.recyclerView.getHeight() / 2) {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.b.f.d
                @Override // java.lang.Runnable
                public final void run() {
                    NewsletterAdapter.this.m4436a(aVar);
                }
            }, Status.time);
        }
    }
}
