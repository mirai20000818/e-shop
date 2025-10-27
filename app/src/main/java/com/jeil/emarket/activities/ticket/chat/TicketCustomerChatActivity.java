package com.jeil.emarket.activities.ticket.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.View;

import com.jeil.emarket.custom.Util;
import com.google.gson.Gson;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.model.vendor.VendorUser;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

import com.jeil.emarket.listener.ticket.ticket.ActivityTicketChat;
import com.jeil.emarket.listener.ticket.ticket.DialogErrorW;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.VendorListVM;
import com.jeil.emarket.viewmodel.SendMessage;


public class TicketCustomerChatActivity extends ActivityTicketChat {
    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u, p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_header_back).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.b.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketCustomerChatActivity.this.m6778f(view);
            }
        });
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    
    public void mo4374I() {
        if (m4309v()) {
            return;
        }
        if (this.f7013M.booleanValue()) {
            Intent intent = new Intent(getApplicationContext(), MainActivityForVendor.class);
            if (this.f7014N.booleanValue()) {
                MainActivityForVendor.global_id = R.id.navigation_home;
                VendorListVM.m5565b(this);
            } else {
                MainActivityForVendor.global_id = R.id.navigation_tickets;
            }
            setResult(-1, intent);
        }
        finish();
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    /* renamed from: P */
    public void mo4381P() {
        final DialogError dialogError = new DialogError(this);
        dialogError.f8246v = getResources().getString(R.string.closeTicketWarning);
        dialogError.m4584a(getResources().getString(R.string.cancel), getResources().getString(R.string.ok));
        dialogError.show();
        dialogError.m4585a(new DialogErrorW(), new DialogInterface() { // from class: b.f.a.a.j.b.i
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

            public final void cancel() {
                TicketCustomerChatActivity.this.m6776a(dialogError);
            }
        });
        dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.a.j.b.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                TicketCustomerChatActivity.this.m6777b(dialogInterface);
            }
        });
    }


    public  void m6776a(DialogError dialogError) {
        int i;
        User user;
        Ticket getValue = TicketCategoryListVM.ticketMutableLiveData.getValue();
        User getValue2 = UserVM.userMutableLiveData.getValue();
        JSONObject jSONObject = new JSONObject();
        User user2 = new User();
        if (getValue == null || (user = getValue.user) == null || getValue2 == null || (i = user.f12429id) == getValue2.f12429id) {
            i = 0;
        }
        user2.f12429id = i;
        try {
            jSONObject.put("_id", this.f7009I);
            jSONObject.put("status", "closed");
            jSONObject.put("receiver", user2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f7013M = true;
        View findViewById = findViewById(R.id.mrl_ticket_item);
        if (findViewById != null) {
            findViewById.setVisibility(View.GONE);
        }
        TicketCategoryListVM.m5502a(this, jSONObject);
        if (getValue != null) {
            getValue.status = "closed";
            TicketCategoryListVM.ticketMutableLiveData.setValue( getValue);
        }
        dialogError.dismiss();
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u
    @SuppressLint({"SetTextI18n"})

    public void mo4382a(Ticket ticket) {
        super.mo4382a(ticket);
        TextView textView = (TextView) findViewById(R.id.tv_status_badge);
        textView.setText(Util.m335d(this, ticket.status));
        findViewById(R.id.tv_vendor_name).setVisibility(View.GONE);
        textView.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(getResources().getIdentifier(ticket.status, "color", getPackageName()))));
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1

    public void mo4295a(User user) {
        if (Status.f8832w.booleanValue()) {
            super.mo4295a(user);
        }
    }


    public  void m6777b(android.content.DialogInterface dialogInterface) {
        this.f7016P = false;
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u

    public void mo4386b(String str) {
        TicketCategoryListVM.m5501a((Context) this, str, (Boolean) true);
    }

    @Override // p078b.p159f.p160a.p161a.p173j.p175b.AbstractActivityC1733u

    public void mo4388c(String str) {
        if (TicketCategoryListVM.ticketMutableLiveData.getValue() == null || UserVM.vendorUserMutableLiveData.getValue() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        Ticket getValue = TicketCategoryListVM.ticketMutableLiveData.getValue();
        Ticket.Receiver receiver = new Ticket.Receiver(getValue.user.f12429id, "user");
        try {
            jSONObject.put("ticketId", this.f7009I);
            jSONObject.put("createdBy", "vendor");
            jSONObject.put("receiver", new Gson().toJson(receiver));
            jSONObject.put("message", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f7013M = true;
        API_PROVIDER.checkInternet(this, new SendMessage(this, jSONObject));
        this.f7010J = "pending";
        m4385a("vendor", str, new Date(), "send", false);
        if (getValue.status.equals("pending")) {
            VendorUser.User user = UserVM.vendorUserMutableLiveData.getValue().user;
            getValue.agent = new User();
            User user2 = getValue.agent;
            user2.f12429id = user.f12455id;
            user2.name = user.name;
            user2.fullName = user.fullname;
            user2.avatar = user.avatar;
        }
        getValue.status = "pending";
        TicketCategoryListVM.ticketMutableLiveData.setValue( getValue);
    }

    /* renamed from: f */
    public  void m6778f(View view) {
        mo4374I();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        mo4374I();
    }
}
