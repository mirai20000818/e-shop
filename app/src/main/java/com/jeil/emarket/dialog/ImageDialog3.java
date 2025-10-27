package com.jeil.emarket.dialog;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.PagerRecycler;
import com.jeil.emarket.components.viewpager.CircleIndicator;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.widget.img.InterfaceEx;
import com.jeil.emarket.widget.img.ViewOnTouchListenerEx1;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.f.y2 */

public class ImageDialog3 extends ImageDialog2 {

    /* renamed from: T */
    public BaseActivity f9111T;

    /* renamed from: U */
    public ViewPager f9112U;

    /* renamed from: V */
    public int f9113V;

    /* renamed from: W */
    public a f9114W;

    /* renamed from: X */
    public List<String> f9115X;

    /* renamed from: b.f.a.f.y2$a */
    public class a extends PagerRecycler<String> {

        
        public ViewOnTouchListenerEx1 f9116e;

        /* JADX WARN: Multi-variable type inference failed */
        public a(BaseActivity activityC1391g1, List<String> list) {
            super(activityC1391g1);
            this.f7125d = list;
            this.f9116e = new ViewOnTouchListenerEx1(activityC1391g1);
            this.f9116e.f8339A = new InterfaceEx() { // from class: b.f.a.f.r0
                @Override // p078b.p159f.p160a.p190c.p204h0.InterfaceC2037e

                public final void mo4630a() {
                    ImageDialog3.a.this.m4885e();
                }
            };
        }

       // @Override // p000a.p075x.p076a.AbstractC0513a
        @SuppressLint({"ClickableViewAccessibility"})

        public Object isViewFromObject(ViewGroup viewGroup, int i) {
            LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.f7124c);
            ImageView imageView = new ImageView(this.f7124c);
            viewGroup.addView(linearLayoutCompat);
            linearLayoutCompat.addView(imageView, new LinearLayoutCompat.LayoutParams(-1, -1));
            try {
                Glide.with((FragmentActivity) this.f7124c).load((String) this.f7125d.get(i)).diskCacheStrategy(((String) this.f7125d.get(i)).startsWith("file://") ? DiskCacheStrategy.DATA : DiskCacheStrategy.ALL).into(imageView);
                imageView.setOnTouchListener(this.f9116e);
            } catch (Exception unused) {
            }
            return linearLayoutCompat;
        }

        
        public  void m4885e() {
            Handler handler = new Handler();
            final ImageDialog3 dialogC2269y2 = ImageDialog3.this;
            handler.post(new Runnable() { // from class: b.f.a.f.q0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageDialog3.this.dismiss();
                }
            });
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }

    public ImageDialog3(BaseActivity activityC1391g1) {
        super(activityC1391g1);
        this.f9113V = 0;
        this.f9115X = new ArrayList();
        this.f9111T = activityC1391g1;
        this.f8257h = true;
    }


    public void m4882a(int i) {
        ViewPager viewPager = this.f9112U;
        if (viewPager != null && viewPager.getAdapter() != null && this.f9112U.getAdapter().getCount() > i) {
            this.f9112U.setAdapter(this.f9114W);
            this.f9112U.setCurrentItem(i, false);
        }
        this.f9113V = i;
    }


    public void m4883a(String str) {
        if (this.f9112U == null) {
            this.f9115X.add(str);
            return;
        }
        a aVar = this.f9114W;
        aVar.f7125d.add(str);
        aVar.notifyDataSetChanged();
        this.f9112U.setAdapter(this.f9114W);
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.DialogC2002k, p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        View inflate = View.inflate(this.f8251b, R.layout.dialog_image, null);
        this.f9112U = (ViewPager) inflate.findViewById(R.id.vp_images);
        this.f9114W = new a(this.f9111T, this.f9115X);
        this.f9112U.setAdapter(this.f9114W);
        ((CircleIndicator) inflate.findViewById(R.id.ci_images)).setViewPager(this.f9112U);
        if (this.f9115X.size() > 0) {
            this.f9112U.setCurrentItem(this.f9113V);
        }
        return inflate;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.DialogC2002k, p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2008f, p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
    }

    /* renamed from: f */
    public void m4884f() {
        if (this.f9112U != null) {
            this.f9115X.clear();
            a aVar = this.f9114W;
            aVar.f7125d.clear();
            aVar.notifyDataSetChanged();
            this.f9112U.setAdapter(this.f9114W);
        }
    }
}
