package com.jeil.emarket.adapters.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.ImageDialog3;

import java.util.Iterator;

/* renamed from: b.f.a.b.b.h */

public class ProductImgMainAdapter extends BaseMainAdapter<String, ProductImgMainAdapter.a> {

    /* renamed from: f */
    public float f7131f;

    /* renamed from: g */
    public ImageDialog3 f7132g;

    /* renamed from: b.f.a.b.b.h$a */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public ProductImgMainAdapter(BaseActivity activityC1391g1, float f) {
        super(activityC1391g1);
        this.f7131f = f;
    }

    
    public  void m4424a(Context context, int i, View view) {
        if (this.f7132g == null) {
            this.f7132g = new ImageDialog3((BaseActivity) context);
            this.f7132g.m4884f();
            Iterator it = this.arrayList.iterator();
            while (it.hasNext()) {
                this.f7132g.m4883a(Util.m345e((String) it.next()));
            }
        }
        this.f7132g.m4882a(i);
        ImageDialog3 dialogC2269y2 = this.f7132g;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }

//    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
//    @SuppressLint({"UseCompatLoadingForDrawables"})
//
//    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
//        a aVar = (a) viewHolder;
//        final Context context = aVar.f3933a.getContext();
//        int i2 = (int) (BaseActivity.anInt / this.f7131f);
//        aVar.f3933a.setLayoutParams(new LinearLayoutCompat.LayoutParams(i2, i2));
//        Glide.with(context).load((String) this.arrayList.get(i)).diskCacheStrategy(((String) this.arrayList.get(i)).startsWith("file://") ? DiskCacheStrategy.DATA : DiskCacheStrategy.ALL).m3754a().m3762a((Transformation<Bitmap>) new RoundedCorners(Util.dp2px(context, 7)), true).into((ImageView) aVar.f3933a);
//        aVar.f3933a.setBackground(context.getResources().getDrawable(R.drawable.bd_grey_round));
//        int m170a = Util.dp2px(context, 1);
//        aVar.f3933a.setPadding(m170a, m170a, m170a, m170a);
//        aVar.f3933a.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.b.a
//            @Override // android.view.View.OnClickListener
//            public final void onClick(View view) {
//                ProductImgMainAdapter.this.m4424a(context, i, view);
//            }
//        });
//    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(viewGroup.getContext());
        appCompatImageView.setId(R.id.iv_product_img);
        return new a(appCompatImageView);
    }

    @Override
    public void onBindViewHolder(@NonNull a holder, int position) {

    }
}
