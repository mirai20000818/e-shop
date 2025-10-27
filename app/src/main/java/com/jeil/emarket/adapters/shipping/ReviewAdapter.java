package com.jeil.emarket.adapters.shipping;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.ReplyActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.CircleImageView;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.ImageDialog3;
import com.jeil.emarket.frag.analy.staff.FragmentVendorListPage;
import com.jeil.emarket.model.customer.Review;

import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.b.k.y1 */

public class ReviewAdapter extends BaseMainAdapter<Review, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final LayoutInflater f8113f;

    /* renamed from: b.f.a.b.k.y1$a */
    public static class a extends RecyclerView.ViewHolder {


        public final ActionLink f8114A;


        public final ActionLink f8115B;


        public final LinearLayoutCompat f8116C;


        public final TextView f8117D;

        
        public final TextView f8118E;

        /* renamed from: F */
        public final TextView f8119F;

        /* renamed from: G */
        public final View f8120G;

        /* renamed from: H */
        public final TextView f8121H;

        
        public final TextView f8122I;

       
        public final TextView f8123J;

        
        public final PriceText f8124K;

        /* renamed from: L */
        public final ActionLink f8125L;

        /* renamed from: M */
        public final LinearLayoutCompat f8126M;

        /* renamed from: N */
        public final LinearLayoutCompat f8127N;

        /* renamed from: O */
        public ImageDialog3 f8128O;

        /* renamed from: t */
        public final CircleImageView f8129t;

        /* renamed from: u */
        public final TextView f8130u;

        /* renamed from: v */
        public final TextView f8131v;

        /* renamed from: w */
        public final ProgressBar f8132w;

        /* renamed from: x */
        public final TextView f8133x;

        /* renamed from: y */
        public final HorizontalScrollView f8134y;

        /* renamed from: z */
        public final LinearLayoutCompat f8135z;

        @SuppressLint({"CutPasteId"})
        public a(View view) {
            super(view);
            this.f8129t = (CircleImageView) view.findViewById(R.id.iv_avatar);
            this.f8130u = (TextView) view.findViewById(R.id.tv_username);
            this.f8131v = (TextView) view.findViewById(R.id.tv_review_date);
            this.f8132w = (ProgressBar) view.findViewById(R.id.pb_rating);
            this.f8133x = (TextView) view.findViewById(R.id.tv_review_content);
            this.f8134y = (HorizontalScrollView) view.findViewById(R.id.sv_images);
            this.f8135z = (LinearLayoutCompat) view.findViewById(R.id.ll_images);
            this.f8114A = (ActionLink) view.findViewById(R.id.cal_review_votes);
            this.f8115B = (ActionLink) view.findViewById(R.id.cal_edit_review);
            this.f8116C = (LinearLayoutCompat) view.findViewById(R.id.ll_reply);
            this.f8117D = (TextView) view.findViewById(R.id.tv_reply_vendor);
            this.f8118E = (TextView) view.findViewById(R.id.tv_reply_text);
            this.f8119F = (TextView) view.findViewById(R.id.tv_reply_at);
            this.f8120G = view.findViewById(R.id.v_reply_line);
            this.f8121H = (TextView) view.findViewById(R.id.ctv_product_name);
            this.f8122I = (TextView) view.findViewById(R.id.ctv_vendor_name);
            this.f8123J = (TextView) view.findViewById(R.id.ctv_review_status);
            this.f8124K = (PriceText) view.findViewById(R.id.pt_pay);
            this.f8125L = (ActionLink) view.findViewById(R.id.cal_reply);
            this.f8126M = (LinearLayoutCompat) view.findViewById(R.id.llc_reply_status);
            this.f8127N = (LinearLayoutCompat) view.findViewById(R.id.ll_action);
        }
    }

    /* renamed from: b.f.a.b.k.y1$b */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public ReviewAdapter(BaseActivity activityC1391g1, FragmentVendorListPage fragmentVendorListPage) {
        super(activityC1391g1);
        this.f8113f = LayoutInflater.from(activityC1391g1);
    }


    public static  void m4565a(a aVar, int i, View view) {
        aVar.f8128O.m4882a(i);
        ImageDialog3 dialogC2269y2 = aVar.f8128O;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.setCanceledOnTouchOutside(true);
        aVar.f8128O.show();
    }


    public  void m4566a(Review review, View view) {
        Intent intent = new Intent(this.baseActivity, ReplyActivity.class);
        intent.putExtra("page", "add");
        intent.putExtra("reviewId", review.reviewId);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public int getItemViewType(int i) {
        return (((Review) this.arrayList.get(i)).type == null || !((Review) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @SuppressLint({"SetTextI18n"})

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        BaseActivity activityC1391g1;
        java.lang.String str;
        java.lang.String m335d;
        RecyclerView.ViewHolder recyclerViewViewHolder = (RecyclerView.ViewHolder) viewHolder;
        final Review review = (Review) this.arrayList.get(i);
        if (review != null && (recyclerViewViewHolder instanceof a)) {
            final a aVar = (a) recyclerViewViewHolder;
            ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.man, Glide.with((FragmentActivity) this.baseActivity).load(Util.m345e(java.lang.String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(review.customerAvatar)))))).into((ImageView) aVar.f8129t);
            aVar.f8130u.setText(review.customerFullname);
            aVar.f8132w.setProgress(review.reviewRating * 20);
            Date date = review.reviewDate;
            if (date != null) {
                aVar.f8131v.setText(Util.m307b(date));
            }
            aVar.f8121H.setText(review.productName);
            aVar.f8122I.setText(review.vendorName);
            aVar.f8124K.setCurrency(review.orderItemCurrency);
            aVar.f8124K.setPrice(Util.m327c(review.orderItemTotal));
            aVar.f8124K.setHidePriceNumber(false);
            if (review.reviewText.isEmpty()) {
                aVar.f8133x.setVisibility(View.GONE);
                aVar.f8127N.setVisibility(View.GONE);
            } else {
                aVar.f8133x.setVisibility(View.VISIBLE);
                aVar.f8127N.setVisibility(View.VISIBLE);
                aVar.f8133x.setText(review.reviewText);
            }
            ActionLink actionLink = aVar.f8114A;
            StringBuilder m3163a = CustomString.format("");
            m3163a.append(review.votes);
            actionLink.setText(m3163a.toString());
            aVar.f8114A.setVisibility(View.GONE);
            aVar.f8114A.setClickable(false);
            aVar.f8135z.removeAllViews();
            aVar.f8128O = new ImageDialog3(this.baseActivity);
            aVar.f8128O.m4884f();
            List<Review.Image> list = review.reviewAttachments;
            if (list == null || list.isEmpty()) {
                aVar.f8134y.setVisibility(View.GONE);
            } else {
                aVar.f8134y.setVisibility(View.VISIBLE);
                for (int i2 = 0; i2 < review.reviewAttachments.size(); i2++) {
                    ImageView imageView = new ImageView(this.baseActivity);
                    java.lang.String m306b = Util.m306b(review.reviewAttachments.get(i2).url, "xss");
                    ((RequestBuilder) CustomString.m3152a(this.baseActivity, R.drawable.ic_placeholder, Glide.with((FragmentActivity) this.baseActivity).load(m306b).diskCacheStrategy(m306b.startsWith("file://") ? DiskCacheStrategy.DATA : DiskCacheStrategy.ALL))).into(imageView);
                    LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(this.baseActivity.m4299b(48), this.baseActivity.m4299b(48));
                    c0541a.setMargins(0, 0, this.baseActivity.m4299b(6), 0);
                    imageView.setLayoutParams(c0541a);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    aVar.f8135z.addView(imageView);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.a0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                           // ReviewAdapter.m4565a(ReviewAdapter.a.this, i2, view);
                        }
                    });
                    aVar.f8128O.m4883a(Util.m306b(review.reviewAttachments.get(i2).url, "xl"));
                }
            }
            if (review.status.equals("approved") || review.status.equals("updating") || review.status.equals("urejected") || review.status.equals("upending")) {
                aVar.f8125L.setVisibility(View.VISIBLE);
                aVar.f8116C.setVisibility(View.GONE);
                aVar.f8120G.setVisibility(View.GONE);
                aVar.f8125L.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReviewAdapter.this.m4566a(review, view);
                    }
                });
                return;
            }
            java.lang.String str2 = review.replyText;
            if (str2 == null || str2.isEmpty()) {
                aVar.f8125L.setVisibility(View.GONE);
                aVar.f8116C.setVisibility(View.GONE);
                aVar.f8120G.setVisibility(View.GONE);
                return;
            }
            aVar.f8117D.setText(review.vendorName + ":");
            aVar.f8118E.setText(review.replyText);
            java.lang.String str3 = review.replyStatus;
            if (str3 == null || !str3.equals("approved")) {
                aVar.f8119F.setVisibility(View.GONE);
                aVar.f8126M.setVisibility(View.VISIBLE);
                aVar.f8123J.setBackgroundTintList(CustomString.m3149a(this.baseActivity, this.baseActivity.getResources(), review.replyStatus, "color", this.baseActivity.getResources()));
                if (review.replyStatus.equals("draft")) {
                    textView = aVar.f8123J;
                    activityC1391g1 = this.baseActivity;
                    str = "pending";
                } else if (review.replyStatus.equals("updating")) {
                    textView = aVar.f8123J;
                    m335d = Util.m335d(this.baseActivity, "upending");
                    textView.setText(m335d);
                    if ((!review.replyStatus.equals("rejected") || review.replyStatus.equals("urejected")) && review.replyText != null) {
                        aVar.f8115B.setVisibility(View.VISIBLE);
                        aVar.f8115B.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.b0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ReviewAdapter.this.m4567b(review, view);
                            }
                        });
                    } else {
                        aVar.f8115B.setVisibility(View.GONE);
                    }
                } else {
                    textView = aVar.f8123J;
                    activityC1391g1 = this.baseActivity;
                    str = review.replyStatus;
                }
               // m335d = Util.m335d(activityC1391g1, str);
               // textView.setText(m335d);
                if (review.replyStatus.equals("rejected")) {
                }
                aVar.f8115B.setVisibility(View.VISIBLE);
                aVar.f8115B.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.k.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReviewAdapter.this.m4567b(review, view);
                    }
                });
            } else {
                aVar.f8119F.setVisibility(View.VISIBLE);
                aVar.f8119F.setText(Util.m307b(review.replyAt));
                aVar.f8126M.setVisibility(View.GONE);
            }
            aVar.f8116C.setVisibility(View.VISIBLE);
            aVar.f8120G.setVisibility(View.VISIBLE);
            aVar.f8125L.setVisibility(View.GONE);
        }
    }


    public  void m4567b(Review review, View view) {
        Intent intent = new Intent(this.baseActivity, ReplyActivity.class);
        intent.putExtra("page", "edit");
        intent.putExtra("reviewId", review.reviewId);
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f8113f.inflate(R.layout.item_shimmer_vendor_review, viewGroup, false)) : new a(this.f8113f.inflate(R.layout.item_vendor_review, viewGroup, false));
    }
}
