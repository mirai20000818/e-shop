package com.jeil.emarket.adapters.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.jeil.emarket.activities.baseactivity.BaseActivity;

/* renamed from: b.f.a.b.b.i */

public class CenterImgRecycler extends PagerRecycler<CenterImgRecycler.a> {


    public java.lang.String f7133e;

    /* renamed from: f */
    public boolean f7134f;

    /* renamed from: g */
    public boolean f7135g;

   

    /* renamed from: b.f.a.b.b.i$a */
    public static class a {

        
        public java.lang.String f7136a;


        public b f7137b;

        public a(java.lang.String str, b bVar) {
            this.f7136a = str;
            this.f7137b = bVar;
        }
    }

    /* renamed from: b.f.a.b.b.i$b */
    public interface b {
        
        void mo4370a(ImageView imageView);
    }

    public CenterImgRecycler(BaseActivity activityC1391g1, java.lang.String str, boolean z, boolean z2) {
        super(activityC1391g1);
        this.f7133e = str;
        this.f7134f = z2;
        this.f7135g = z;
    }
    @Override
    public boolean isViewFromObject(@NonNull View viewGroup, @NonNull Object object) {
        return false;
    }
    //@Override // p000a.p075x.p076a.AbstractC0513a
    
    public Object isViewFromObject(ViewGroup viewGroup, final int i) {
        final ImageView imageView = new ImageView(this.f7124c);
        if (this.f7125d.size() < i + 1) {
            return imageView;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.b.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CenterImgRecycler.this.m4425a(i, imageView, view);
            }
        });
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup.addView(imageView);
        if (this.f7125d.get(i) != null && ((a) this.f7125d.get(i)).f7136a != null && !((a) this.f7125d.get(i)).f7136a.isEmpty()) {
            //java.lang.String m223a = this.f7133e != null ? Util.m223a(((a) this.f7125d.get(i)).f7136a, this.f7133e, this.f7135g, this.f7134f) : Util.m223a(((a) this.f7125d.get(i)).f7136a, "xl", this.f7135g, this.f7134f);
          //  ((RequestBuilder) CustomString.m3152a(this.f7124c, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.f7124c).load(m223a))).diskCacheStrategy(m223a.startsWith("file://") ? DiskCacheStrategy.DATA : DiskCacheStrategy.ALL).m3754a().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }
        return imageView;
    }

    
    public  void m4425a(int i, ImageView imageView, View view) {
        if (((a) this.f7125d.get(i)).f7137b != null) {
            ((a) this.f7125d.get(i)).f7137b.mo4370a(imageView);
        }
    }
}
