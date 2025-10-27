package com.jeil.emarket.adapters.point;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.review.ReviewEditActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.CircleImageView;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.ImageDialog3;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.customer.Review;
import com.jeil.emarket.providers.ReviewProvider;
import com.jeil.emarket.viewmodel.UserVM;

import org.json.JSONObject;

/* renamed from: b.f.a.b.i.g */

public class ReviewAdapter extends BaseMainAdapter<Review, RecyclerView.ViewHolder> implements BaseInterface {

    /* renamed from: f */
    public java.lang.String f7680f;

    /* renamed from: g */
    public java.lang.String f7681g;

    /* renamed from: h */
    public ReviewProvider f7682h;

    
    public final LayoutInflater f7683i;

   
    public ActionLink f7684j;

    
    public DialogC2001j f7685k;

    /* renamed from: b.f.a.b.i.g$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f7686A;

        
        public final HorizontalScrollView f7687B;

        
        public final LinearLayoutCompat f7688C;

        
        public final TextView f7689D;

        
        public final ActionLink f7690E;

        /* renamed from: F */
        public final ActionLink f7691F;

        /* renamed from: G */
        public final LinearLayoutCompat f7692G;

        /* renamed from: H */
        public final TextView f7693H;

        
        public final TextView f7694I;

       
        public final TextView f7695J;

        
        public final View f7696K;

        /* renamed from: L */
        public final LinearLayoutCompat f7697L;

        /* renamed from: M */
        public final TextView f7698M;

        /* renamed from: N */
        public final LinearLayoutCompat f7699N;

        /* renamed from: O */
        public final TextView f7700O;

        /* renamed from: P */
        public final View f7701P;

        /* renamed from: Q */
        public final TextView f7702Q;

        /* renamed from: R */
        public ImageDialog3 f7703R;

        /* renamed from: t */
        public final FrameLayout f7704t;

        /* renamed from: u */
        public final LinearLayoutCompat f7705u;

        /* renamed from: v */
        public final CircleImageView f7706v;

        /* renamed from: w */
        public final TextView f7707w;

        /* renamed from: x */
        public final TextView f7708x;

        /* renamed from: y */
        public final ProgressBar f7709y;

        /* renamed from: z */
        public final TextView f7710z;

        @SuppressLint({"CutPasteId"})
        public a(View view) {
            super(view);
            this.f7704t = (FrameLayout) view.findViewById(R.id.ll_main);
            this.f7705u = (LinearLayoutCompat) view.findViewById(R.id.llc_action);
            this.f7706v = (CircleImageView) view.findViewById(R.id.iv_avatar);
            this.f7707w = (TextView) view.findViewById(R.id.tv_username);
            this.f7708x = (TextView) view.findViewById(R.id.tv_review_date);
            this.f7709y = (ProgressBar) view.findViewById(R.id.pb_rating);
            this.f7710z = (TextView) view.findViewById(R.id.tv_review_content);
            this.f7686A = (TextView) view.findViewById(R.id.tv_approved_code);
            this.f7687B = (HorizontalScrollView) view.findViewById(R.id.sv_images);
            this.f7688C = (LinearLayoutCompat) view.findViewById(R.id.ll_images);
            this.f7689D = (TextView) view.findViewById(R.id.tv_review_product);
            this.f7690E = (ActionLink) view.findViewById(R.id.cal_review_votes);
            this.f7691F = (ActionLink) view.findViewById(R.id.cal_edit_review);
            this.f7692G = (LinearLayoutCompat) view.findViewById(R.id.ll_reply);
            this.f7693H = (TextView) view.findViewById(R.id.tv_reply_vendor);
            this.f7694I = (TextView) view.findViewById(R.id.tv_reply_text);
            this.f7695J = (TextView) view.findViewById(R.id.tv_reply_at);
            this.f7696K = view.findViewById(R.id.v_reply_line);
            this.f7697L = (LinearLayoutCompat) view.findViewById(R.id.ri_product_item);
            this.f7698M = (TextView) view.findViewById(R.id.ctv_product_name);
            this.f7699N = (LinearLayoutCompat) view.findViewById(R.id.llc_vendor_item);
            this.f7700O = (TextView) view.findViewById(R.id.ctv_vendor_name);
            this.f7701P = view.findViewById(R.id.v_item_line);
            this.f7702Q = (TextView) view.findViewById(R.id.ctv_review_status);
        }
    }

    /* renamed from: b.f.a.b.i.g$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final LinearLayoutCompat f7711t;

        /* renamed from: u */
        public final LinearLayoutCompat f7712u;

        /* renamed from: v */
        public final LinearLayoutCompat f7713v;

        /* renamed from: w */
        public final TextView f7714w;

        /* renamed from: x */
        public final TextView f7715x;

        public b(View view) {
            super(view);
            this.f7711t = (LinearLayoutCompat) view.findViewById(R.id.ll_shimmer_main);
            this.f7712u = (LinearLayoutCompat) view.findViewById(R.id.ri_shimmer_product_item);
            this.f7713v = (LinearLayoutCompat) view.findViewById(R.id.llc_shimmer_vendor_item);
            this.f7714w = (TextView) view.findViewById(R.id.tv_shimmer_review_product);
            this.f7715x = (TextView) view.findViewById(R.id.cal_shimmer_edit_review);
        }
    }

    public ReviewAdapter(BaseActivity activityC1391g1, java.lang.String str, java.lang.String str2) {
        super(activityC1391g1);
        this.f7680f = str;
        this.f7683i = LayoutInflater.from(activityC1391g1);
        this.f7681g = str2;
    }


    public  void m4502a(Review review, View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            BaseActivity activityC1391g1 = this.baseActivity;
            Util.toast(activityC1391g1, activityC1391g1.getResources().getString(R.string.vote_notice), "error", 0, 0);
        } else if (UserVM.userMutableLiveData.getValue().f12429id != review.customerId) {
            this.f7682h.m5642b(this.baseActivity, review.reviewId, this);
            this.f7685k = new DialogC2001j(this.baseActivity);
            this.f7685k.show();
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        try {
            this.f7685k.dismiss();
            this.f7684j.setText(Util.m217a(new JSONObject(str).getInt("count")));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((Review) this.arrayList.get(i)).type == null || !((Review) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @android.annotation.SuppressLint({"SetTextI18n"})
    
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        /*
            Method dump skipped, instructions count: 891
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p178b.p187i.C1887g.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }

    
    public  void m4503b(Review review, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), ReviewEditActivity.class);
        intent.putExtra("page", "edit");
        intent.putExtra("reviewId", review.reviewId);
        intent.putExtra("productName", review.productName);
        intent.putExtra("productId", review.productId);
        this.baseActivity.startActivityForResult(intent, 100);
    }


    public static  void m4501a(a aVar, int i, View view) {
        aVar.f7703R.m4882a(i);
        ImageDialog3 dialogC2269y2 = aVar.f7703R;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.setCanceledOnTouchOutside(true);
        aVar.f7703R.show();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7683i.inflate(R.layout.item_shimmer_review, viewGroup, false)) : new a(this.f7683i.inflate(R.layout.item_review, viewGroup, false));
    }
}
