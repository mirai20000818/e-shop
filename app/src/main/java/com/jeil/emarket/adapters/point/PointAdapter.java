package com.jeil.emarket.adapters.point;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.point.PointEditActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.CircleImageView;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.customer.Point;
import com.jeil.emarket.providers.ReviewProvider;
import com.jeil.emarket.viewmodel.UserVM;

import org.json.JSONObject;

/* renamed from: b.f.a.b.i.f */

public class PointAdapter extends BaseMainAdapter<Point, RecyclerView.ViewHolder> implements BaseInterface {

    /* renamed from: f */
    public java.lang.String f7655f;

    /* renamed from: g */
    public ReviewProvider f7656g;

    /* renamed from: h */
    public final LayoutInflater f7657h;

    
    public ActionLink f7658i;

   
    public DialogC2001j f7659j;

    /* renamed from: b.f.a.b.i.f$a */
    public static class a extends RecyclerView.ViewHolder {


        public final TextView f7660A;

        
        public final LinearLayoutCompat f7661B;

        
        public final TextView f7662C;

        
        public final ProgressBar f7663D;

        
        public final ProgressBar f7664E;

        /* renamed from: F */
        public final ProgressBar f7665F;

        /* renamed from: G */
        public final LinearLayoutCompat f7666G;

        /* renamed from: H */
        public final TextView f7667H;

        
        public final LinearLayoutCompat f7668I;

        /* renamed from: t */
        public final CircleImageView f7669t;

        /* renamed from: u */
        public final TextView f7670u;

        /* renamed from: v */
        public final TextView f7671v;

        /* renamed from: w */
        public final TextView f7672w;

        /* renamed from: x */
        public final TextView f7673x;

        /* renamed from: y */
        public final ActionLink f7674y;

        /* renamed from: z */
        public final ActionLink f7675z;

        @SuppressLint({"CutPasteId"})
        public a(View view) {
            super(view);
            this.f7669t = (CircleImageView) view.findViewById(R.id.iv_avatar);
            this.f7670u = (TextView) view.findViewById(R.id.tv_username);
            this.f7671v = (TextView) view.findViewById(R.id.tv_point_date);
            this.f7672w = (TextView) view.findViewById(R.id.tv_point_content);
            this.f7673x = (TextView) view.findViewById(R.id.tv_approved_code);
            this.f7674y = (ActionLink) view.findViewById(R.id.cal_point_votes);
            this.f7675z = (ActionLink) view.findViewById(R.id.cal_edit_point);
            this.f7660A = (TextView) view.findViewById(R.id.ctv_vendor_name);
            this.f7661B = (LinearLayoutCompat) view.findViewById(R.id.llc_vendor_item);
            this.f7662C = (TextView) view.findViewById(R.id.ctv_point_status);
            this.f7663D = (ProgressBar) view.findViewById(R.id.mrb_support_point);
            this.f7665F = (ProgressBar) view.findViewById(R.id.mrb_shipping_point);
            this.f7664E = (ProgressBar) view.findViewById(R.id.mrb_service_point);
            this.f7666G = (LinearLayoutCompat) view.findViewById(R.id.llc_order_item);
            this.f7667H = (TextView) view.findViewById(R.id.ctv_order_id);
            this.f7668I = (LinearLayoutCompat) view.findViewById(R.id.ll_action);
        }
    }

    /* renamed from: b.f.a.b.i.f$b */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final TextView f7676t;

        /* renamed from: u */
        public final LinearLayoutCompat f7677u;

        /* renamed from: v */
        public final LinearLayoutCompat f7678v;

        /* renamed from: w */
        public final TextView f7679w;

        public b(View view) {
            super(view);
            this.f7676t = (TextView) view.findViewById(R.id.cal_shimmer_edit_point);
            this.f7677u = (LinearLayoutCompat) view.findViewById(R.id.llc_shimmer_vendor_item);
            this.f7678v = (LinearLayoutCompat) view.findViewById(R.id.llc_shimmer_actions);
            this.f7679w = (TextView) view.findViewById(R.id.ctv_shimmer_point_status);
        }
    }

    public PointAdapter(BaseActivity activityC1391g1, java.lang.String str) {
        super(activityC1391g1);
        this.f7655f = str;
        this.f7657h = LayoutInflater.from(activityC1391g1);
    }


    public  void m4499a(Point point, View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            BaseActivity activityC1391g1 = this.baseActivity;
            Util.toast(activityC1391g1, activityC1391g1.getResources().getString(R.string.vote_notice), "error", 0, 0);
        } else if (UserVM.userMutableLiveData.getValue().f12429id != point.customerId) {
            this.f7656g.m5637a(this.baseActivity, point.pointId, this);
            this.f7659j = new DialogC2001j(this.baseActivity);
            this.f7659j.show();
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        try {
            this.f7659j.dismiss();
            this.f7658i.setText(Util.m217a(new JSONObject(str).getInt("voteCount")));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        return (((Point) this.arrayList.get(i)).type == null || !((Point) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ee  */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @android.annotation.SuppressLint({"SetTextI18n"})
    
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p178b.p187i.C1886f.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }

    
    public  void m4500b(Point point, View view) {
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), PointEditActivity.class);
        intent.putExtra("page", "edit");
        intent.putExtra("pointId", point.pointId);
        intent.putExtra("orderId", this.f7655f.equals("vendorPoint") ? point.displayOrderId : Integer.valueOf(point.orderId));
        this.baseActivity.startActivityForResult(intent, 100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f7657h.inflate(R.layout.item_shimmer_point, viewGroup, false)) : new a(this.f7657h.inflate(R.layout.item_point, viewGroup, false));
    }
}
