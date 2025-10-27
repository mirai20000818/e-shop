package com.jeil.emarket.activities.account;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.CustomString;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.ticket.add.TicketVendorCreateActivity;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.OrderDetail;
import com.jeil.emarket.model.customer.OrderNote;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.model.customer.SubOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.order.OrderNoteMainAdapter;
import com.jeil.emarket.adapters.order.SubOrderAdapter;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.ModelCollection;


public class OrderDetailActivity extends BaseActivity {

    
    public int f11638I;

   
    public OrderNoteMainAdapter f11639J;

    /* renamed from: L */
    public SubOrderAdapter f11641L;

    
    public boolean f11640K = true;

    /* renamed from: M */
    public Boolean f11642M = false;

    /* renamed from: N */
    public Boolean f11643N = false;

    /* renamed from: O */
    public Boolean f11644O = false;

    /* renamed from: P */
    public int f11645P = 0;

    /* renamed from: Q */
    public BaseDialog2 f11646Q = null;

    /* renamed from: R */
    public List<SubOrder> f11647R = new ArrayList();

    /* renamed from: com.jeil.emarket.activities.account.OrderDetailActivity$a */


    /* renamed from: com.jeil.emarket.activities.account.OrderDetailActivity$b */


    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById(R.id.mrl_header_back);
        if (materialRippleLayout != null) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderDetailActivity.this.m6287d(view);
                }
            });
        }
        findViewById(R.id.cal_show_all).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderDetailActivity.this.m6288e(view);
            }
        });
        findViewById(R.id.mrl_add_ticket).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderDetailActivity.this.m6289f(view);
            }
        });
    }

    
    public void m6279I() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_suborder_items);
        this.f11641L = new SubOrderAdapter(this, this.f11638I);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,  RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(this.f11641L);
        recyclerView.addItemDecoration(new ItemDecoration2(0, -1, true));
        recyclerView.setNestedScrollingEnabled(false);
        ArrayList arrayList = new ArrayList();
        SubOrder subOrder = new SubOrder();
        subOrder.type = "shimmer";
        arrayList.add(subOrder);
        SubOrderAdapter c1815e1 = this.f11641L;
        c1815e1.arrayList = arrayList;
        c1815e1.notifyDataSetChanged();
    }

   
    public void m6280J() {
        if (this.f11647R.size() == 1) {
            m6290g(0);
            return;
        }
        this.f6496A = true;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f11647R.size(); i++) {
            arrayList.add(new Cancel_Obj(this.f11647R.get(i).name, 0));
        }
        this.f11646Q = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f11646Q;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.a.u
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i2) {
                OrderDetailActivity.this.m6281a(view, i2);
            }
        };
        baseDialog2.f8255f = 0.6f;
        baseDialog2.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        this.f11646Q.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.v
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                OrderDetailActivity.this.m6285b(dialogInterface);
            }
        });
    }


    public void m6282a(OrderDetail orderDetail) {
        this.f11639J.f7278f = orderDetail.orderNotes.size();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_order_add_notes);
        recyclerView.setHasFixedSize(true);
        OrderNoteMainAdapter c1806b1 = new OrderNoteMainAdapter(this, orderDetail.orderNotes.size(), true);
        List<OrderNote> list = orderDetail.orderNotes;
        if (list != null && list.size() != 0) {
            if (orderDetail.orderNotes.size() > Status.f8820k) {
                findViewById(R.id.cal_show_all).setVisibility(View.VISIBLE);
                this.f11639J.addAll((List) orderDetail.orderNotes.subList(0, 3));
                List<OrderNote> list2 = orderDetail.orderNotes;
                c1806b1.addAll((List) list2.subList(3, list2.size()));
            } else {
                findViewById(R.id.cal_show_all).setVisibility(View.GONE);
                this.f11639J.addAll((List) orderDetail.orderNotes);
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
        recyclerView.setAdapter(c1806b1);
        m6284a(false);
    }


    public  void m6283a(Integer num) {
        if (num.intValue() == 200) {
            ModelCollection.m5436b(this, this.f11638I);
        }
    }


    public void m6284a(boolean z) {
        this.f11645P++;
        if (z || this.f11645P == 1) {
            if (this.f11642M.booleanValue()) {
                Util.m243a(findViewById(R.id.rv_order_add_notes));
            } else {
                Util.m243a(findViewById(R.id.rv_order_add_notes));
            }
            this.f11642M = Boolean.valueOf(!this.f11642M.booleanValue());
            ((ActionLink) findViewById(R.id.cal_show_all)).setmImageView(this.f11642M.booleanValue() ? R.drawable.ic_angle_down : R.drawable.ic_angle_up);
        }
    }


    public  void m6285b(DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    @SuppressLint({"SetTextI18n"})

    public final void m6286b(OrderDetail orderDetail) {
        int i;
        java.lang.String str;
        if (orderDetail == null) {
            return;
        }
        if (orderDetail.orderCreatedAt == null) {
            finish();
            return;
        }
        this.f11647R = new ArrayList();
        for (int i2 = 0; i2 < orderDetail.vendors.size(); i2++) {
            if (orderDetail.vendors.get(i2).enableTicket.booleanValue()) {
                this.f11647R.add(orderDetail.vendors.get(i2));
            }
        }
        if (this.f11647R.size() > 0) {
            findViewById(R.id.mrl_add_ticket).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.mrl_add_ticket).setVisibility(View.GONE);
        }
        findViewById(R.id.item_shimmer_order).setVisibility(View.GONE);
        findViewById(R.id.item_order).setVisibility(View.VISIBLE);
        findViewById(R.id.ll_shimmer_items).setVisibility(View.GONE);
        findViewById(R.id.ll_shimmer_item).setVisibility(View.GONE);
        findViewById(R.id.llc_connector_info).setVisibility(View.VISIBLE);
        findViewById(R.id.mrl_cancel_order).setVisibility(View.GONE);
        ((MaterialRippleLayout) findViewById(R.id.mrl_show_detail)).setRippleColor(getResources().getColor(R.color.white));
        findViewById(R.id.llc_order_id_item).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.ctv_order_id)).setText(Util.m217a(this.f11638I));
        ((TextView) findViewById(R.id.ctv_order_requested_at)).setText(Util.m307b(orderDetail.orderCreatedAt));
        if (orderDetail.orderProductCount == 0) {
            findViewById(R.id.llc_order_count_item).setVisibility(View.GONE);
        } else {
            findViewById(R.id.llc_order_count_item).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.ctv_order_product_count)).setText(Util.m217a(orderDetail.orderProductCount) + getString(R.string.order_count_unit));
        }
        OrderDetail.OrderTotalAmount orderTotalAmount = orderDetail.totalAmount;
        if (orderTotalAmount.kpw == 0.0f && orderTotalAmount.oldKpw == 0.0f) {
            findViewById(R.id.pp_order_kpw_total_price).setVisibility(View.GONE);
            i = 0;
        } else {
            ProductPrice productPrice = (ProductPrice) findViewById(R.id.pp_order_kpw_total_price);
            productPrice.setVisibility(View.VISIBLE);
            productPrice.m6941c(false);
            productPrice.setHidePriceNumber(false);
            productPrice.setPtSalePrice(Util.m327c(orderDetail.totalAmount.kpw));
            OrderDetail.OrderTotalAmount orderTotalAmount2 = orderDetail.totalAmount;
            if (orderTotalAmount2.kpw == 0.0f && orderTotalAmount2.oldKpw != 0.0f) {
                productPrice.setRegularPriceSize(13);
                productPrice.setRegularPrice(Util.m327c(orderDetail.totalAmount.oldKpw));
            }
            i = 1;
        }
        OrderDetail.OrderTotalAmount orderTotalAmount3 = orderDetail.totalAmount;
        if (orderTotalAmount3.kpf == 0.0f && orderTotalAmount3.oldKpf == 0.0f) {
            findViewById(R.id.pp_order_kpf_total_price).setVisibility(View.GONE);
        } else {
            i++;
            ProductPrice productPrice2 = (ProductPrice) findViewById(R.id.pp_order_kpf_total_price);
            productPrice2.setVisibility(View.VISIBLE);
            productPrice2.m6941c(false);
            productPrice2.setHidePriceNumber(false);
            productPrice2.setPtSalePrice(Util.m327c(orderDetail.totalAmount.kpf));
            OrderDetail.OrderTotalAmount orderTotalAmount4 = orderDetail.totalAmount;
            if (orderTotalAmount4.kpf == 0.0f && orderTotalAmount4.oldKpf != 0.0f) {
                productPrice2.setRegularPriceSize(13);
                productPrice2.setRegularPrice(Util.m327c(orderDetail.totalAmount.oldKpf));
            }
        }
        if (i == 2) {
            findViewById(R.id.iv_plus).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.iv_plus).setVisibility(View.GONE);
        }
        ((ProductPrice) findViewById(R.id.pp_order_kpf_total_price)).m6940b(!orderDetail.orderStatus.equals("cancelled"));
        ((ProductPrice) findViewById(R.id.pp_order_kpw_total_price)).m6940b(!orderDetail.orderStatus.equals("cancelled"));
        findViewById(R.id.ctv_order_status).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(getResources().getIdentifier(orderDetail.orderStatus.equals("readyToShip") ? "shipping" : orderDetail.orderStatus, "color", getPackageName()))));
        ((TextView) findViewById(R.id.ctv_order_status)).setText(Util.m335d(this, orderDetail.orderStatus));
        ((TextView) findViewById(R.id.ctv_connector_name)).setText(orderDetail.shipping.name);
        ShippingInfo shippingInfo = orderDetail.shipping;
        java.lang.String str2 = shippingInfo.address1;
        java.lang.String str3 = shippingInfo.address2;
        if (str3 != null && !str3.isEmpty()) {
            StringBuilder m3177b = CustomString.m3177b(str2, " ");
            m3177b.append(orderDetail.shipping.address2);
            str2 = m3177b.toString();
        }
        ((TextView) findViewById(R.id.ctv_connector_address)).setText(str2);
        java.lang.String str4 = orderDetail.shipping.location;
        if (str4 == null || str4.isEmpty()) {
            findViewById(R.id.ctv_connector_location).setVisibility(View.GONE);
        } else {
            findViewById(R.id.ctv_connector_location).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.ctv_connector_location)).setText(orderDetail.shipping.location);
        }
        java.lang.String str5 = orderDetail.shipping.phone1;
        if (str5 == null || str5.isEmpty()) {
            java.lang.String str6 = orderDetail.shipping.phone2;
            str = (str6 == null || str6.isEmpty()) ? "" : orderDetail.shipping.phone2;
        } else {
            ShippingInfo shippingInfo2 = orderDetail.shipping;
            str = shippingInfo2.phone1;
            if (!shippingInfo2.phone2.isEmpty()) {
                StringBuilder m3177b2 = CustomString.m3177b(str, ", ");
                m3177b2.append(orderDetail.shipping.phone2);
                str = m3177b2.toString();
            }
        }
        ((TextView) findViewById(R.id.ctv_connector_phone)).setText(str);
        java.lang.String str7 = orderDetail.shipping.note;
        if (str7 == null || str7.isEmpty()) {
            findViewById(R.id.llc_order_info_item).setVisibility(View.GONE);
        } else {
            ((TextView) findViewById(R.id.ctv_connector_order_info)).setText(orderDetail.shipping.note);
            findViewById(R.id.llc_order_info_item).setVisibility(View.VISIBLE);
        }
        findViewById(R.id.mrl_cancel_order).setVisibility(View.GONE);
        List<OrderNote> list = orderDetail.orderNotes;
        if (list == null || list.size() == 0) {
            findViewById(R.id.llc_order_notes_box).setVisibility(View.GONE);
        } else {
            ((TextView) findViewById(R.id.ctv_order_note_title)).setTextColor(getResources().getColor(R.color.dark));
            findViewById(R.id.ctv_order_note_title).setBackgroundColor(getResources().getColor(R.color.transparent));
            m6282a(orderDetail);
            findViewById(R.id.llc_order_notes_box).setVisibility(View.VISIBLE);
        }
        ((ShimmerFrameLayout) findViewById(R.id.sfl_shimmer)).hideShimmer();
        List<SubOrder> list2 = orderDetail.vendors;
        if (list2 == null || list2.size() == 0) {
            findViewById(R.id.rv_suborder_items).setVisibility(View.GONE);
        } else {
            this.f11641L.addAll((List) orderDetail.vendors);
            findViewById(R.id.rv_suborder_items).setVisibility(View.VISIBLE);
        }
    }

    
    public  void m6287d(View view) {
        onBackPressed();
    }

    
    public  void m6288e(View view) {
        m6284a(true);
    }

    /* renamed from: f */
    public  void m6289f(View view) {
        if (this.f6496A) {
            return;
        }
        m6280J();
    }

    /* renamed from: g */
    public final void m6290g(int i) {
        Intent intent = new Intent(getApplicationContext(), TicketVendorCreateActivity.class);
        intent.putExtra("vendorName", this.f11647R.get(i).name);
        intent.putExtra("orderId", this.f11647R.get(i).f12425id);
        intent.putExtra("displayOrderId", this.f11647R.get(i).displayOrderId);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (m4309v()) {
            return;
        }
        Intent intent = new Intent(this, OrderActivity.class);
        if (this.f11644O.booleanValue()) {
            intent.putExtra("page", "toHome");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (this.f11643N.booleanValue()) {
            setResult(-1, intent);
        }
        finish();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_order_detail);
        m4307e(R.string.order_detail);
        findViewById(R.id.llc_shimmer_order_id_item).setVisibility(View.VISIBLE);
        if (getIntent().getExtras() != null) {
            this.f11638I = getIntent().getExtras().getInt("orderVendorId");
            this.f11644O = Boolean.valueOf(getIntent().getExtras().getString("page") != null && Objects.equals(getIntent().getExtras().getString("page"), "toHome"));
        }
        ModelCollection.f10214e.observe(this, new Observer() { // from class: b.f.a.a.a.n
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                OrderDetailActivity.this.m6286b((OrderDetail) obj);
            }
        });
        ModelCollection.f10217h.observe(this, new Observer() { // from class: b.f.a.a.a.s
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                OrderDetailActivity.this.m6283a((Integer) obj);
            }
        });
        if (this.f11640K) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_order_notes);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,  RecyclerView.HORIZONTAL, false));
            this.f11639J = new OrderNoteMainAdapter(this, 3, false);
            recyclerView.setAdapter(this.f11639J);
            ArrayList arrayList = new ArrayList();
            OrderNote orderNote = new OrderNote();
            orderNote.type = "shimmer";
            for (int i = 0; i < 3; i++) {
                arrayList.add(orderNote);
            }
            OrderNoteMainAdapter c1806b1 = this.f11639J;
            c1806b1.arrayList = arrayList;
            c1806b1.notifyDataSetChanged();
            m6279I();
        }
        this.f11643N = false;
        mo4284G();
        addBottomNav(R.id.navigation_account);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }


    public  void m6281a(View view, int i) {
        m6290g(i);
        this.f11646Q.startAni();
    }
}
