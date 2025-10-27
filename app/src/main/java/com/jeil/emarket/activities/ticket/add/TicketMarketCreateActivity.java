package com.jeil.emarket.activities.ticket.add;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.custom.Util;
import com.google.gson.Gson;
import com.jeil.emarket.activities.intro.HelpDetailActivity;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.TicketCategory;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.services.MessageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivityForVendor;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.VendorListVM;


public class TicketMarketCreateActivity extends BaseActivityForVendor {

    
    public List<TicketCategory> f11927K;

    /* renamed from: L */
    public BaseDialog2 f11928L = null;

    /* renamed from: M */
    public String f11929M;

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) findViewById(R.id.mrl_header_back);
        if (materialRippleLayout != null) {
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TicketMarketCreateActivity.this.m6756u(view);
                }
            });
        }
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketMarketCreateActivity.this.m6757v(view);
            }
        });
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketMarketCreateActivity.this.m6758w(view);
            }
        });
        findViewById(R.id.llc_help_link).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketMarketCreateActivity.this.m6759x(view);
            }
        });
    }

    /* renamed from: R */
    public void m6750R() {
        ((EditText) findViewById(R.id.cet_message)).setMaxLength(Status.f8834y, getResources().getString(R.string.input_limit));
        ((EditText) findViewById(R.id.cet_message)).setHint(getResources().getString(R.string.ticket_message_placeholder));
        findViewById(R.id.mrl_select_category).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketMarketCreateActivity.this.m6755t(view);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add("vm");
        this.f11927K = TicketCategoryListVM.m5495a(arrayList);
    }

    /* renamed from: S */
    public void m6751S() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f11927K.size(); i++) {
            arrayList.add(new Cancel_Obj(this.f11927K.get(i).name, ((TextView) findViewById(R.id.tv_category_name)).getText().equals(this.f11927K.get(i).name) ? 1 : 0));
        }
        this.f11928L = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f11928L;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.j.a.e
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i2) {
                TicketMarketCreateActivity.this.m6752a(view, i2);
            }
        };
        ((Window) Objects.requireNonNull(baseDialog2.getWindow())).setDimAmount(0.8f);
        BaseDialog2 baseDialog22 = this.f11928L;
        baseDialog22.f8255f = 0.6f;
        baseDialog22.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog22.show();
        this.f11928L.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.j.a.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                TicketMarketCreateActivity.this.m6754b(dialogInterface);
            }
        });
    }


    public  void m6752a(View view, int i) {
        ((TextView) findViewById(R.id.tv_category_name)).setText(this.f11927K.get(i).name);
        this.f11929M = this.f11927K.get(i)._id;
        this.f11928L.startAni();
    }


    public  void m6753a(DialogC2001j dialogC2001j, Boolean bool) {
        dialogC2001j.dismiss();
        if (bool == null || !bool.booleanValue()) {
            MainActivityForVendor.global_id = R.id.ani_market_link;
            setResult(-1);
            finish();
        }
    }


    public  void m6754b(DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (m4309v()) {
            return;
        }
        startActivity(new Intent(getApplicationContext(), MainActivityForVendor.class));
        finish();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1397i1, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ticket_create);
        m4307e(R.string.ticket_left);
        findViewById(R.id.mrl_select_vendor).setVisibility(View.GONE);
        findViewById(R.id.rg_vendor).setVisibility(View.GONE);
        findViewById(R.id.header_border).setVisibility(View.GONE);
        mo4284G();
        m6750R();
    }

    /* renamed from: t */
    public  void m6755t(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        m6751S();
    }

    /* renamed from: u */
    public  void m6756u(View view) {
        if (isFinishing()) {
            return;
        }
        onBackPressed();
    }

    /* renamed from: v */
    public  void m6757v(View view) {
        Ticket.ReceiverVendor receiverVendor = new Ticket.ReceiverVendor();
        Vendor getValue = VendorListVM.f10363d.getValue();
        Ticket.ReceiverVendor receiverVendor2 = receiverVendor;
        if (getValue != null) {
            receiverVendor2 = new Ticket.ReceiverVendor(getValue.f12449id, getValue.name);
        }
        String obj = ((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_message)).getText())).toString();
        if (this.f11929M == null) {
            Util.toast(this, getResources().getString(R.string.input_category), "error", 0, 0);
            return;
        }
        if (obj.isEmpty() || obj.trim().length() == 0) {
            Util.toast(this, getResources().getString(R.string.input_ticket_content), "error", 0, 0);
            return;
        }
        if (obj.length() > Status.f8834y) {
            Util.toast(this, String.format(getResources().getString(R.string.message_overflow), Integer.valueOf(Status.f8834y)), "error", 0, 0);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("categoryId", this.f11929M);
            jSONObject.put("vendor", receiverVendor2);
            jSONObject.put("content", obj);
            jSONObject.put("status", "pending");
            jSONObject.put("read", Status.f8835z[1]);
            Object obj2 = receiverVendor2;
            if (Status.f8832w.booleanValue()) {
                Ticket.ReceiverVendor receiverVendor3 = new Ticket.ReceiverVendor(0, getResources().getString(R.string.shimmer_ticket_target));
                User user = new User();
                User getValue2 = UserVM.userMutableLiveData.getValue();
                user.f12429id = getValue2.f12429id;
                user.avatar = getValue2.avatar;
                user.name = getValue2.name;
                user.fullName = getValue2.fullName;
                user.vendor = receiverVendor2;
                jSONObject.put("type", "app");
                jSONObject.put("user", new Gson().toJson(user));
                obj2 = new Gson().toJson(receiverVendor3);
            }
            jSONObject.put("vendor", obj2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        final DialogC2001j dialogC2001j = new DialogC2001j(this);
        if (Status.f8832w.booleanValue()) {
            MessageService messageService = MessageService.f12472h;
            if (messageService != null) {
                messageService.m7012b("createTicket", jSONObject);
            }
        } else {
            TicketCategoryListVM.m5507b(this, jSONObject);
            dialogC2001j.show();
        }
        TicketCategoryListVM.f10283i.observe(this, new Observer() { // from class: b.f.a.a.j.a.h
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj3) {
                TicketMarketCreateActivity.this.m6753a(dialogC2001j, (Boolean) obj3);
            }
        });
    }

    /* renamed from: w */
    public  void m6758w(View view) {
        onBackPressed();
    }

    /* renamed from: x */
    public  void m6759x(View view) {
        Intent intent = new Intent(getApplicationContext(), HelpDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title", "marketTicket");
        intent.putExtra("vendor", true);
        startActivity(intent);
    }
}
