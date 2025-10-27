package com.jeil.emarket.activities.seller;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.jeil.emarket.activities.ticket.chat.TicketCustomerChatActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.OrderItem;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.model.vendor.History;
import com.jeil.emarket.model.vendor.OrderDetail;
import com.jeil.emarket.model.vendor.VendorCancelItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.listener.product.C1565FDialog;
import com.jeil.emarket.listener.product.C1624t2;
import com.jeil.emarket.listener.product.C1628u2;
import com.jeil.emarket.adapters.order.OrderItemAdapter;
import com.jeil.emarket.adapters.shipping.HistoryAdapter;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.dialog.DialogShippingTime;
import com.jeil.emarket.dialog.DialogSelectShippingArrivedAt;
import com.jeil.emarket.dialog.DialogChangeOrderStatus;
import com.jeil.emarket.dialog.DialogEditCustomer;
import com.jeil.emarket.viewmodel.ModelCollection;


public class VendorOrderDetailActivity extends BaseActivityForVendor {

    /* renamed from: M */
    public OrderItemAdapter f11819M;

    /* renamed from: N */
    public ShippingInfo f11820N;

    /* renamed from: Q */
    public OrderDetail f11823Q;

    /* renamed from: R */
    public HistoryAdapter f11824R;

    /* renamed from: W */
    public DialogC2001j f11829W;

    /* renamed from: c0 */
    public OrderItemAdapter f11835c0;

    
    public final HashMap<java.lang.String, java.lang.String> f11817K = new HashMap<>();

    /* renamed from: L */
    public boolean f11818L = true;

    /* renamed from: O */
    public boolean f11821O = false;

    /* renamed from: P */
    public ImageDialog2 f11822P = null;

    /* renamed from: S */
    public Boolean f11825S = false;

    /* renamed from: T */
    public int f11826T = 0;

    /* renamed from: U */
    public MutableLiveData<java.lang.String> f11827U = new MutableLiveData<>("all");

    /* renamed from: V */
    public BaseDialog2 f11828V = null;

    /* renamed from: X */
    public boolean f11830X = false;

    /* renamed from: Y */
    public int f11831Y = 1;

    /* renamed from: Z */
    public LinearLayoutCompat[] f11832Z = new LinearLayoutCompat[2];

    /* renamed from: a0 */
    public List<java.lang.String> f11833a0 = new ArrayList();

    /* renamed from: b0 */
    public HashMap<java.lang.String, java.lang.String> f11834b0 = new HashMap<>();

    /* renamed from: d0 */
    public DialogEditCustomer f11836d0 = null;

    /* renamed from: com.jeil.emarket.activities.seller.VendorOrderDetailActivity$a */
    public class C3201a extends LinearLayoutManager {
        public C3201a(VendorOrderDetailActivity vendorOrderDetailActivity, Context context, int i, boolean z) {
            super(context,i, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        
        public boolean canScrollVertically() {
            return false;
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById(R.id.mrl_header_back);
        View findViewById = findViewById(R.id.header);
        if (findViewById != null) {
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) findViewById.findViewById(R.id.mrl_header_menu);
            if (materialRippleLayout != null && materialRippleLayout2 != null) {
                materialRippleLayout.setVisibility(View.VISIBLE);
                materialRippleLayout2.setVisibility(View.GONE);
            }
        }
        if (materialRippleLayout != null) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VendorOrderDetailActivity.this.m6632v(view);
                }
            });
        }
        findViewById(R.id.cal_show_all).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorOrderDetailActivity.this.m6633w(view);
            }
        });
    }

    /* renamed from: R */
    public void m6600R() {
        this.f11817K.put("samhung", getResources().getString(R.string.samhung));
        this.f11817K.put("cod", getResources().getString(R.string.cod));
    }

    /* renamed from: S */
    public void m6601S() {
        Resources resources;
        int i;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ll_header);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this);
        materialRippleLayout.setRippleRoundedCorners(20);
        materialRippleLayout.setPadding(Util.dp2px((Context) this, 3), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 3), Util.dp2px((Context) this, 7));
        if (this.f11823Q.prevId != 0) {
            materialRippleLayout.setRippleColor(getResources().getColor(R.color.ripple_dark));
            materialRippleLayout.setDefaultRippleAlpha(20);
            materialRippleLayout.setRippleHover(true);
            materialRippleLayout.setRippleOverlay(true);
        } else {
            materialRippleLayout.setRippleColor(getResources().getColor(R.color.white));
            materialRippleLayout.setRippleHover(false);
            materialRippleLayout.setRippleOverlay(false);
            materialRippleLayout.setDefaultRippleAlpha(0);
        }
        AppCompatImageView appCompatImageView = new AppCompatImageView(this);
        appCompatImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_angle_left));
        appCompatImageView.setImageTintList(ColorStateList.valueOf(this.f11823Q.prevId != 0 ? getResources().getColor(R.color.body) : getResources().getColor(R.color.white_bg)));
        appCompatImageView.setPadding(Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4));
        appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(Util.dp2px((Context) this, 29), Util.dp2px((Context) this, 29)));
        materialRippleLayout.addView(appCompatImageView);
        linearLayoutCompat.addView(materialRippleLayout);
        MaterialRippleLayout materialRippleLayout2 = new MaterialRippleLayout(this);
        materialRippleLayout2.setRippleRoundedCorners(20);
        materialRippleLayout2.setPadding(Util.dp2px((Context) this, 3), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 3), Util.dp2px((Context) this, 7));
        if (this.f11823Q.nextId != 0) {
            materialRippleLayout2.setDefaultRippleAlpha(20);
            materialRippleLayout2.setRippleColor(getResources().getColor(R.color.ripple_dark));
            materialRippleLayout2.setRippleHover(true);
            materialRippleLayout2.setRippleOverlay(true);
        } else {
            materialRippleLayout2.setRippleColor(getResources().getColor(R.color.white));
            materialRippleLayout2.setRippleHover(false);
            materialRippleLayout2.setRippleOverlay(false);
            materialRippleLayout2.setDefaultRippleAlpha(0);
        }
        AppCompatImageView appCompatImageView2 = new AppCompatImageView(this);
        appCompatImageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_angle_right));
        if (this.f11823Q.nextId != 0) {
            resources = getResources();
            i = R.color.body;
        } else {
            resources = getResources();
            i = R.color.white_bg;
        }
        appCompatImageView2.setImageTintList(ColorStateList.valueOf(resources.getColor(i)));
        appCompatImageView2.setPadding(Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4), Util.dp2px((Context) this, 4));
        appCompatImageView2.setLayoutParams(new ViewGroup.LayoutParams(Util.dp2px((Context) this, 29), Util.dp2px((Context) this, 29)));
        materialRippleLayout2.addView(appCompatImageView2);
        linearLayoutCompat.addView(materialRippleLayout2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.rightMargin = Util.dp2px((Context) this, 4);
        layoutParams.addRule(15);
        layoutParams.addRule(21);
        relativeLayout.addView(linearLayoutCompat, layoutParams);
        materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorOrderDetailActivity.this.m6630t(view);
            }
        });
        materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VendorOrderDetailActivity.this.m6631u(view);
            }
        });
    }

    /* renamed from: T */
    public void m6602T() {
        XRecyclerView xRecyclerView = (XRecyclerView) findViewById(R.id.rv_order_items);
        xRecyclerView.setHasFixedSize(true);
        xRecyclerView.f12375Z0 = this.f11818L;
        xRecyclerView.setFooterHeight(false);
        this.f11819M = new OrderItemAdapter(this, "order");
        ArrayList arrayList = new ArrayList();
        OrderItem orderItem = new OrderItem();
        orderItem.type = "shimmer";
        for (int i = 0; i < 2; i++) {
            arrayList.add(orderItem);
        }
        OrderItemAdapter c1824h1 = this.f11819M;
        c1824h1.arrayList = arrayList;
        c1824h1.notifyDataSetChanged();
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
        xRecyclerView.setAdapter(this.f11819M);
    }

    /* renamed from: U */
    public void m6603U() {
        Glide.with((FragmentActivity) this).load(getResources().getDrawable(R.color.placeholder_img)).into((ImageView) findViewById(R.id.iv_user_avatar));
        findViewById(R.id.iv_user_avatar).setBackgroundResource(R.drawable.bd_grey_ellipse);
        findViewById(R.id.ll_customer_detail).setVisibility(View.GONE);
        findViewById(R.id.ll_shimmer_customer_detail).setVisibility(View.VISIBLE);
        findViewById(R.id.ll_shimmer_items).setVisibility(View.VISIBLE);
        findViewById(R.id.ll_order_info_box).setVisibility(View.GONE);
        findViewById(R.id.ll_change_button_group).setVisibility(View.GONE);
        findViewById(R.id.ll_action).setVisibility(View.GONE);
        findViewById(R.id.llc_order_history_box).setVisibility(View.GONE);
        findViewById(R.id.cal_show_all).setVisibility(View.GONE);
        findViewById(R.id.tv_edit_order).setVisibility(View.VISIBLE);
        findViewById(R.id.cal_edit_order).setVisibility(View.GONE);
        ArrayList arrayList = new ArrayList();
        History history = new History();
        history.type = "shimmer";
        for (int i = 0; i < 3; i++) {
            arrayList.add(history);
        }
        HistoryAdapter c1949o1 = this.f11824R;
        c1949o1.arrayList = arrayList;
        c1949o1.notifyDataSetChanged();
        Util.setColor((Context) this, (TextView) findViewById(R.id.ctv_order_note_title));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_order_created_at_label));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_order_created_at));
        ((ShimmerFrameLayout) findViewById(R.id.sfl_shimmer)).showShimmer(true);
        ((ShimmerFrameLayout) findViewById(R.id.sfl_order_item_shimmer)).showShimmer(true);
        ((ShimmerFrameLayout) findViewById(R.id.sfl_order_history_shimmer)).showShimmer(true);
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_order_customer_name));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_connector_name));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_order_status_label));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_customer_label));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_customer));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_payment_method_label));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_payment_method));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_payment_price));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_shipping_arrived_at_label));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_shipping_arrived_at));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_shipping_method_label));
        Util.setColor((Context) this, (TextView) findViewById(R.id.tv_shipping_method));
        findViewById(R.id.sfl_order_item_shimmer).setVisibility(View.VISIBLE);
        findViewById(R.id.ll_phone).setVisibility(View.GONE);
        findViewById(R.id.tv_order_status).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        ((com.jeil.emarket.components.textview.TextView) findViewById(R.id.tv_order_status)).setTextColor(getResources().getColor(R.color.transparent));
        findViewById(R.id.tv_order_status).setBackgroundResource(R.drawable.bg_grey_round);
        findViewById(R.id.rv_order_items).setVisibility(View.GONE);
    }


    @SuppressLint("WrongConstant")
    public  void m6604a(View view, View view2, int i) {
        View findViewById;
        int i2;
        ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_cancel_type)).setText(this.f11833a0.get(i));
        this.f11827U.setValue( (i == 0 ? "all" : "detail"));
        if (this.f11827U.getValue() == null || !this.f11827U.getValue().equals("detail")) {
            if (this.f11827U.getValue() != null && this.f11827U.getValue().equals("all")) {
                findViewById = view.findViewById(R.id.llc_items);
                i2 = 8;
            }
            this.f11828V.startAni();
        }
        findViewById = view.findViewById(R.id.llc_items);
        i2 = 0;
        findViewById.setVisibility(i2);
        this.f11828V.startAni();
    }


    public  void m6605a(View view, CustomButton customButton, CustomButton customButton2, View view2) {
        int i = this.f11831Y;
        if (i != 2) {
            this.f11822P.dismiss();
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11832Z[i - 1], "translationX", 0.0f, BaseActivity.anInt);
        ofFloat.setDuration(300L);
        ofFloat.start();
        ofFloat.addListener(new C1624t2(this, view));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11832Z[this.f11831Y - 2], "translationX", -BaseActivity.anInt, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.start();
        this.f11831Y--;
        m6606a(customButton, customButton2);
    }


    public final void m6606a(CustomButton customButton, CustomButton customButton2) {
        Resources resources;
        int i;
        if (this.f11831Y == 1) {
            customButton.setText(getResources().getString(R.string.cancel));
            resources = getResources();
            i = R.string.action_next;
        } else {
            customButton.setText(getResources().getString(R.string.action_prev));
            resources = getResources();
            i = R.string.ok;
        }
        customButton2.setText(resources.getString(i));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x098b, code lost:
    
        if (r22.status.equals(r4) != false) goto L285;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x052f A[LOOP:0: B:112:0x0518->B:114:0x052f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0535 A[EDGE_INSN: B:115:0x0535->B:116:0x0535 BREAK  A[LOOP:0: B:112:0x0518->B:114:0x052f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x07ae  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x089d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x08b0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0983  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0a10  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0d7c  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0da6  */
    /* JADX WARN: Removed duplicated region for block: B:261:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0d84  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0b74  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0b95  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0bc2  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0bf1  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0bc8  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0b99  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x09a7  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x098e  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08e8  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x090d  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0937  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0437  */
    @android.annotation.SuppressLint({"SetTextI18n"})

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6607a(final com.jeil.emarket.model.vendor.OrderDetail r22) {
        /*
            Method dump skipped, instructions count: 3686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.activities.seller.VendorOrderDetailActivity.m6607a(com.jeil.emarket.model.vendor.OrderDetail):void");
    }


    public  void m6608a(OrderDetail orderDetail, View view) {
        new DialogShippingTime(this, orderDetail, this.f11820N, ModelCollection.f10215f.getValue(), orderDetail.deliveryTime, "deliverer").show();
    }


    public  void m6609a(final OrderDetail orderDetail, DialogError dialogError) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(orderDetail.f12440id));
            jSONObject.put("ids", arrayList);
            jSONObject.put("status", "completed");
            Util.m239a((Context) this, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ModelCollection.m5449d(this, jSONObject);
        this.f11829W.show();
        dialogError.dismiss();
        ModelCollection.f10217h.observe(this, new Observer() { // from class: b.f.a.a.i.n0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorOrderDetailActivity.this.m6610a(orderDetail, (Integer) obj);
            }
        });
    }


    public  void m6610a(OrderDetail orderDetail, Integer num) {
        this.f11829W.dismiss();
        if (num.intValue() == 200) {
            this.f11821O = true;
            m6603U();
            ModelCollection.m5447d(this, orderDetail.f12440id);
        }
    }


    public  void m6611a(OrderDetail orderDetail, java.lang.String str, View view) {
        new DialogSelectShippingArrivedAt(this, orderDetail.createdAt, orderDetail.deliveryTime, orderDetail.f12440id, orderDetail.shippingStatus, str, "price").show();
    }


    public  void m6612a(List list, View view) {
        try {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((java.lang.String) list.get(0)))));
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }


    public void m6613a(boolean z) {
        this.f11826T++;
        if (z || this.f11826T == 1) {
            if (this.f11825S.booleanValue()) {
                Util.m243a(findViewById(R.id.rv_order_add_history));
            } else {
                Util.m243a(findViewById(R.id.rv_order_add_history));
            }
            this.f11825S = Boolean.valueOf(!this.f11825S.booleanValue());
            ((ActionLink) findViewById(R.id.cal_show_all)).setmImageView(this.f11825S.booleanValue() ? R.drawable.ic_angle_down : R.drawable.ic_angle_up);
        }
    }

    
    public  void m6614b(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    
    public  void m6615b(View view, View view2) {
        if (this.f11830X) {
            return;
        }
        this.f11830X = true;
        showSelectCancelTypeDialog(view);
    }

    
    public  void m6617b(DialogC2001j dialogC2001j, Integer num) {
        dialogC2001j.dismiss();
        if (num.intValue() == 200) {
            this.f11821O = true;
            ModelCollection.m5447d(this, this.f11823Q.f12440id);
        }
    }

    
    public  void m6619b(OrderDetail orderDetail, java.lang.String str, View view) {
        new DialogSelectShippingArrivedAt(this, orderDetail.createdAt, orderDetail.deliveryTime, orderDetail.f12440id, orderDetail.shippingStatus, str, "time").show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    
    public void m6620b(List<History> list) {
        this.f11824R.f7983g = list.size();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_order_add_history);
        recyclerView.setHasFixedSize(true);
        HistoryAdapter c1949o1 = new HistoryAdapter(this, list.size(), true);
        if (list.size() != 0) {
            if (list.size() > Status.f8820k) {
                findViewById(R.id.cal_show_all).setVisibility(View.VISIBLE);
                this.f11824R.addAll(list.subList(0, 3));
                c1949o1.addAll(list.subList(3, list.size()));
            } else {
                findViewById(R.id.cal_show_all).setVisibility(View.GONE);
                HistoryAdapter c1949o12 = this.f11824R;
                c1949o12.arrayList = list;
                c1949o12.notifyDataSetChanged();
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
        recyclerView.setAdapter(c1949o1);
        m6613a(false);
    }

    
    public  void m6621b(List list, View view) {
        StringBuilder m3163a = CustomString.format("tel:");
        m3163a.append((java.lang.String) list.get(0));
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse(m3163a.toString())));
    }

    
    public  void m6622c(android.content.DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    
    public  void m6623c(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f11822P.m4595e();
            this.f11821O = true;
            this.f11831Y = 1;
            m6603U();
            ModelCollection.m5447d(this, this.f11823Q.f12440id);
        }
        dialogC2001j.dismiss();
    }

    
    public  void m6624c(OrderDetail orderDetail, View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        this.f11836d0 = new DialogEditCustomer(this, orderDetail.shipping, orderDetail.f12440id);
        this.f11836d0.show();
        this.f11836d0.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.s
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                VendorOrderDetailActivity.this.m6614b(dialogInterface);
            }
        });
    }

    
    public  void m6625c(OrderDetail orderDetail, java.lang.String str, View view) {
        if ((orderDetail.status.equals("completed") || orderDetail.status.equals("cancelled")) && new Date().getTime() - orderDetail.completedAt.getTime() > 86400000) {
            return;
        }
        Intent intent = new Intent(this, VendorOrderEditActivity.class);
        intent.putExtra("orderId", orderDetail.f12440id);
        intent.putExtra("shippingAmount", orderDetail.shippingAmount);
        intent.putExtra("shippingCurrency", str);
        intent.putExtra("status", orderDetail.status);
        intent.putExtra("completedAt", new Gson().toJson(orderDetail.completedAt));
        intent.putExtra("items", new Gson().toJson(orderDetail.items));
        startActivityForResult(intent, 100);
    }

    
    public final void m6626c(List<History> list) {
        if (list != null) {
            ((ShimmerFrameLayout) findViewById(R.id.sfl_order_history_shimmer)).hideShimmer();
            findViewById(R.id.ll_shimmer_items).setVisibility(View.GONE);
            Util.setColor(this, (TextView) findViewById(R.id.ctv_order_note_title), R.color.dark);
            if (list.size() != 0) {
                findViewById(R.id.llc_order_history_box).setVisibility(View.VISIBLE);
                m6620b(list);
            } else {
                findViewById(R.id.llc_order_history_box).setVisibility(View.GONE);
            }
            ((ShimmerFrameLayout) findViewById(R.id.sfl_history_shimmer)).hideShimmer();
        }
    }

    
    public  void m6627c(List list, View view) {
        try {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((java.lang.String) list.get(1)))));
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    
    public  void m6628d(android.content.DialogInterface dialogInterface) {
        this.f11830X = false;
    }

    
    public  void m6629d(OrderDetail orderDetail, View view) {
        Intent intent = new Intent(this, TicketCustomerChatActivity.class);
        intent.putExtra("id", orderDetail.ticket);
        intent.putExtra("status", "open");
        intent.putExtra("title", orderDetail.f12440id + getResources().getString(R.string.number_order) + " " + getResources().getString(R.string.discuss_shipping_price));
        startActivityForResult(intent, 100);
    }

    @Override // p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1 && intent != null) {
            int intExtra = intent.getIntExtra("orderId", 0);
            this.f11821O = true;
            m6603U();
            ModelCollection.m5447d(this, intExtra);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (m4309v()) {
            return;
        }
        if (!this.f11821O) {
            super.onBackPressed();
        } else {
            setResult(-1, new Intent(this, MainActivityForVendor.class));
            finish();
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_order_detail);
        ModelCollection.m5447d(this, ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getInt("orderVendorId"));
        this.f11829W = new DialogC2001j(this);
        this.f11834b0.put("all", getResources().getString(R.string.cancel_all));
        this.f11834b0.put("detail", getResources().getString(R.string.cancel_detail));
        this.f11833a0.add(getResources().getString(R.string.cancel_all));
        this.f11833a0.add(getResources().getString(R.string.cancel_detail));
        ModelCollection.f10213d.observe(this, new Observer() { // from class: b.f.a.a.i.b
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                VendorOrderDetailActivity.this.m6607a((OrderDetail) obj);
            }
        });
        if (this.f11818L) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_order_history);
            recyclerView.setLayoutManager(new C3201a(this, this, 1, false));
            this.f11824R = new HistoryAdapter(this, 3, false);
            recyclerView.setAdapter(this.f11824R);
            ArrayList arrayList = new ArrayList();
            History history = new History();
            history.type = "shimmer";
            for (int i = 0; i < 3; i++) {
                arrayList.add(history);
            }
            HistoryAdapter c1949o1 = this.f11824R;
            c1949o1.arrayList = arrayList;
            c1949o1.notifyDataSetChanged();
            m6602T();
        }
        mo4284G();
        m6600R();
        findViewById(R.id.header_border).setVisibility(View.GONE);
    }

    public void showSelectCancelTypeDialog(final View view) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f11833a0.size(); i++) {
            arrayList.add(new Cancel_Obj(this.f11833a0.get(i), ((com.jeil.emarket.components.textview.TextView) view.findViewById(R.id.tv_cancel_type)).getText().equals(this.f11833a0.get(i)) ? 1 : 0));
        }
        this.f11828V = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f11828V;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.i.e0
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view2, int i2) {
                VendorOrderDetailActivity.this.m6604a(view, view2, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f11828V;
        baseDialog22.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog22.show();
        this.f11828V.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.j0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                VendorOrderDetailActivity.this.m6628d(dialogInterface);
            }
        });
    }

    /* renamed from: t */
    public  void m6630t(View view) {
        if (this.f11823Q.prevId != 0) {
            m6603U();
            ModelCollection.m5447d(this, this.f11823Q.prevId);
        }
    }

    /* renamed from: u */
    public  void m6631u(View view) {
        if (this.f11823Q.nextId != 0) {
            m6603U();
            ModelCollection.m5447d(this, this.f11823Q.nextId);
        }
    }

    /* renamed from: v */
    public  void m6632v(View view) {
        onBackPressed();
    }

    /* renamed from: w */
    public  void m6633w(View view) {
        m6613a(true);
    }

    /* renamed from: x */
    public  void m6634x(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        final View inflate = View.inflate(this, R.layout.dialog_cancel_order, null);
        final CustomButton customButton = (CustomButton) inflate.findViewById(R.id.cb_ok);
        final CustomButton customButton2 = (CustomButton) inflate.findViewById(R.id.cb_cancel);
        this.f11832Z = new LinearLayoutCompat[]{(LinearLayoutCompat) inflate.findViewById(R.id.ll_first_step), (LinearLayoutCompat) inflate.findViewById(R.id.ll_second_step)};
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.llc_items);
        this.f11835c0 = new OrderItemAdapter(this, "detail");
        recyclerView.setAdapter(this.f11835c0);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
        for (OrderItem orderItem : this.f11823Q.realItems) {
            if (orderItem.curQty > 0) {
                this.f11835c0.add(orderItem);
            }
        }
        m6606a(customButton2, customButton);
        customButton2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VendorOrderDetailActivity.this.m6605a(inflate, customButton2, customButton, view2);
            }
        });
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VendorOrderDetailActivity.this.m6616b(inflate, customButton2, customButton, view2);
            }
        });
        inflate.findViewById(R.id.mrl_cancel_type).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.i.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VendorOrderDetailActivity.this.m6615b(inflate, view2);
            }
        });
        ((com.jeil.emarket.components.textview.TextView) inflate.findViewById(R.id.tv_cancel_type)).setText(this.f11834b0.get("all"));
        this.f11822P = Util.m212a(this, inflate, 1.0f, 0.8f);
        this.f11822P.show();
        this.f11822P.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.i.w
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                VendorOrderDetailActivity.this.m6622c(dialogInterface);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    
    public  void m6618b(final OrderDetail orderDetail, View view) {
        char c2;
        Dialog dialogC2257v2;
        java.lang.String str = orderDetail.status;
        switch (str.hashCode()) {
            case -2146525273:
                if (str.equals("accepted")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -516235858:
                if (str.equals("shipping")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 119629530:
                if (str.equals("readyToShip")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 693933934:
                if (str.equals("requested")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0 || c2 == 1) {
            dialogC2257v2 = new DialogChangeOrderStatus(this, orderDetail);
        } else {
            if (c2 != 2) {
                if (c2 != 3) {
                    return;
                }
                final DialogError dialogError = new DialogError(this);
                dialogError.f8246v = getResources().getString(R.string.change_to_complete_warning);
                dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
                dialogError.show();
                dialogError.m4585a(new C1565FDialog(), new DialogInterface() { // from class: b.f.a.a.i.p0
                    @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

                    public final void cancel() {
                        VendorOrderDetailActivity.this.m6609a(orderDetail, dialogError);
                    }
                });
                return;
            }
            dialogC2257v2 = new DialogShippingTime(this, orderDetail, this.f11820N, ModelCollection.f10215f.getValue(), orderDetail.deliveryTime, "order");
        }
        dialogC2257v2.show();
    }

    
    public  void m6616b(View view, CustomButton customButton, CustomButton customButton2, View view2) {
        MutableLiveData<Integer> mutableLiveData;
        Observer<? super Integer> observer;
        boolean z;
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        int i = this.f11831Y;
        if (i == 1) {
            EditText editText = (EditText) view.findViewById(R.id.et_customer_note);
            if (((Editable) Objects.requireNonNull(editText.getText())).toString().isEmpty() || editText.getText().toString().trim().length() == 0) {
                editText.setBackgroundResource(R.drawable.bd_warn_input);
                z = true;
            } else {
                editText.setBackgroundResource(R.drawable.bg_input_border);
                z = false;
            }
            if (z) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11832Z[this.f11831Y - 1], "translationX", 0.0f, -BaseActivity.anInt);
            ofFloat.setDuration(300L);
            ofFloat.start();
            ofFloat.addListener(new C1628u2(this, view));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f11832Z[this.f11831Y], "translationX", BaseActivity.anInt, 0.0f);
            ofFloat2.setDuration(300L);
            ofFloat2.start();
            this.f11831Y++;
            m6606a(customButton, customButton2);
            return;
        }
        if (i == 2) {
            if (this.f11827U.getValue() != null && this.f11827U.getValue().equals("all")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this.f11823Q.f12440id));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ids", arrayList);
                    jSONObject.put("status", "cancelled");
                    jSONObject.put("reason", ((Editable) Objects.requireNonNull(((EditText) view.findViewById(R.id.et_customer_note)).getText())).toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                Util.m239a((Context) this, jSONObject);
                ModelCollection.m5449d(this, jSONObject);
                final DialogC2001j dialogC2001j = new DialogC2001j(this);
                dialogC2001j.show();
                this.f11822P.dismiss();
                mutableLiveData = ModelCollection.f10217h;
                observer = new Observer() { // from class: b.f.a.a.i.o0
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        VendorOrderDetailActivity.this.m6617b(dialogC2001j, (Integer) obj);
                    }
                };
            } else {
                if (this.f11827U.getValue() == null || !this.f11827U.getValue().equals("detail")) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < this.f11835c0.arrayList.size(); i2++) {
                    if (((OrderItem) this.f11835c0.arrayList.get(i2)).cancelQty > 0) {
                        VendorCancelItem vendorCancelItem = new VendorCancelItem();
                        vendorCancelItem.quantity = ((OrderItem) this.f11835c0.arrayList.get(i2)).cancelQty;
                        vendorCancelItem.orderItemId = ((OrderItem) this.f11835c0.arrayList.get(i2)).f12404id;
                        arrayList2.add(vendorCancelItem);
                    }
                }
                if (arrayList2.size() == 0) {
                    Util.toast(this, getResources().getString(R.string.select_cancel_product_quantity_notice), "error", 0, 0);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("order_id", this.f11823Q.f12440id);
                    jSONObject2.put("items", arrayList2);
                    jSONObject2.put("reason", ((Editable) Objects.requireNonNull(((EditText) view.findViewById(R.id.et_customer_note)).getText())).toString());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                Util.m239a((Context) this, jSONObject2);
                ModelCollection.m5441b(this, jSONObject2);
                final DialogC2001j dialogC2001j2 = new DialogC2001j(this);
                dialogC2001j2.show();
                mutableLiveData = ModelCollection.f10217h;
                observer = new Observer() { // from class: b.f.a.a.i.u
                    @Override // p000a.p060o.InterfaceC0405p

                    public final void onChanged(Object obj) {
                        VendorOrderDetailActivity.this.m6623c(dialogC2001j2, (Integer) obj);
                    }
                };
            }
            mutableLiveData.observe(this, observer);
        }
    }
}
