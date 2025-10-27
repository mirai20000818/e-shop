package com.jeil.emarket.listener.ticket.ticket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.ticket.TicketMessageAdapter;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.TicketMessage;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.viewmodel.HistoryVM;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* renamed from: b.f.a.a.j.b.u */

public abstract class ActivityTicketChat extends BaseActivity {

    
    public java.lang.String f7009I;

   
    public java.lang.String f7010J;

    
    public java.lang.String f7011K;

    /* renamed from: O */
    public LinearLayoutCompat f7015O;

    /* renamed from: L */
    public Boolean f7012L = true;

    /* renamed from: M */
    public Boolean f7013M = false;

    /* renamed from: N */
    public Boolean f7014N = false;

    /* renamed from: P */
    public boolean f7016P = false;

    /* renamed from: b.f.a.a.j.b.u$a */
    public class a implements TextWatcher {


        public final  EditText f7017b;


        public final  int f7018c;

        public a(EditText editText, int i) {
            this.f7017b = editText;
            this.f7018c = i;
        }


        @SuppressLint("WrongConstant")
        public  void m4392a(EditText editText, int i) {
            int i2;
            TextView textView = (TextView) ActivityTicketChat.this.findViewById(R.id.mrl_text_length);
            if (editText.getHeight() > i) {
                textView.setText(((Editable) Objects.requireNonNull(editText.getText())).length() + "/300");
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
        }

        @Override // android.text.TextWatcher
        @SuppressLint({"SetTextI18n"})
        public void afterTextChanged(Editable editable) {
            Handler handler = new Handler();
            final EditText editText = this.f7017b;
            final int i = this.f7018c;
            handler.postDelayed(new Runnable() { // from class: b.f.a.a.j.b.b
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityTicketChat.a.this.m4392a(editText, i);
                }
            }, 10L);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        findViewById(R.id.mrl_send_message).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.b.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityTicketChat.this.m4389d(view);
            }
        });
        TicketCategoryListVM.f10283i.observe(this, new Observer() { // from class: b.f.a.a.j.b.d
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ActivityTicketChat.this.m4384a((Boolean) obj);
            }
        });
    }

    
    public abstract void mo4374I();

   
    public void m4375J() {
        EditText editText = (EditText) findViewById(R.id.cet_message);
        editText.addTextChangedListener(new a(editText, editText.getPaddingBottom() + editText.getPaddingTop() + (editText.getLineHeight() * 2)));
    }

    
    public void m4376K() {
        this.f7015O = (LinearLayoutCompat) findViewById(R.id.ll_header);
        findViewById(R.id.mrl_header_search).setVisibility(View.GONE);
        findViewById(R.id.mrl_header_cart).setVisibility(View.GONE);
    }

    /* renamed from: L */
    public void m4377L() {
        if (findViewById(R.id.cet_message) != null) {
            ((EditText) findViewById(R.id.cet_message)).setMaxLength(Status.f8834y, getResources().getString(R.string.input_limit));
        }
    }

    /* renamed from: M */
    public void m4378M() {
        HistoryVM.f10271e.observe(this, new Observer() { // from class: b.f.a.a.j.b.t
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ActivityTicketChat.this.m4383a((TicketMessage) obj);
            }
        });
    }

    /* renamed from: N */
    public  void m4379N() {
        TicketCategoryListVM.ticketMutableLiveData.observe(this, new Observer() { // from class: b.f.a.a.j.b.s
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ActivityTicketChat.this.mo4382a((Ticket) obj);
            }
        });
        TicketCategoryListVM.ticketMessageList.observe(this, new Observer() { // from class: b.f.a.a.j.b.r
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ActivityTicketChat.this.mo4387b((List<TicketMessage>) obj);
            }
        });
    }

    /* renamed from: O */
    public void m4380O() {
        ((TextView) findViewById(R.id.tv_status_badge)).setTextColor(getResources().getColor(R.color.white));
        findViewById(R.id.tv_vendor_name).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        ((TextView) findViewById(R.id.tv_vendor_name)).setTextColor(getResources().getColor(R.color.body));
        findViewById(R.id.tv_updated_at).setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        ((TextView) findViewById(R.id.tv_updated_at)).setTextColor(getResources().getColor(R.color.body));
        ((ShimmerFrameLayout) findViewById(R.id.sfl_layout)).hideShimmer();
    }

    /* renamed from: P */
    public abstract void mo4381P();


    @SuppressLint("WrongConstant")
    public void mo4382a(Ticket ticket) {
        int i;
        View findViewById;
        if (ticket != null) {
            ((TextView) findViewById(R.id.tv_vendor_name)).setText(ticket.vendor.name);
            ((TextView) findViewById(R.id.tv_updated_at)).setText(Util.m307b(ticket.updatedAt));
            java.lang.String m353g = Util.m353g(ticket.categoryId);
            if (ticket.objectId > 0) {
                m353g = CustomString.m3159a(CustomString.m3177b(m353g, "("), ticket.objectId, ")");
            }
            m4297a(m353g);
            Boolean bool = ticket.vendor.enableTicket;
            if (bool != null && !bool.booleanValue()) {
                i = 8;
                findViewById(R.id.llc_send_message).setVisibility(View.GONE);
                if (findViewById(R.id.mrl_ticket_item) != null) {
                    findViewById = findViewById(R.id.mrl_ticket_item);
                    findViewById.setVisibility(i);
                }
                m4380O();
            }
            if (ticket.status.equals("open") || ticket.status.equals("pending")) {
                i = 0;
                findViewById(R.id.llc_send_message).setVisibility(View.VISIBLE);
                findViewById = findViewById(R.id.mrl_ticket_item);
                if (findViewById == null) {
                    MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this);
                    materialRippleLayout.setId(R.id.mrl_ticket_item);
                    materialRippleLayout.setRippleRoundedCorners(10);
                    materialRippleLayout.setDefaultRippleAlpha(10);
                    materialRippleLayout.setRippleColor(getResources().getColor(R.color.ripple_light));
                    materialRippleLayout.setRippleHover(true);
                    materialRippleLayout.setRippleOverlay(true);
                    materialRippleLayout.setPadding(Util.dp2px((Context) this, 10), Util.dp2px((Context) this, 10), Util.dp2px((Context) this, 7), Util.dp2px((Context) this, 10));
                    AppCompatImageView appCompatImageView = new AppCompatImageView(this);
                    appCompatImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_check));
                    appCompatImageView.setBackgroundResource(R.drawable.bd_primary_circle);
                    appCompatImageView.setImageTintList(ColorStateList.valueOf(getResources().getColor(BaseActivity.color)));
                    appCompatImageView.setPadding(0, 0, 0, 0);
                    appCompatImageView.setLayoutParams(new ViewGroup.LayoutParams(Util.dp2px((Context) this, 27), Util.dp2px((Context) this, 27)));
                    materialRippleLayout.addView(appCompatImageView);
                    LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    ((LinearLayout.LayoutParams) c0541a).rightMargin = Util.dp2px((Context) this, 2);
                    this.f7015O.addView(materialRippleLayout, c0541a);
                    materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.b.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ActivityTicketChat.this.m4391e(view);
                        }
                    });
                }
                findViewById.setVisibility(i);
            }
            m4380O();
        }
    }


    public void m4383a(TicketMessage ticketMessage) {
        Ticket getValue = TicketCategoryListVM.ticketMutableLiveData.getValue();
        if (getValue == null || !ticketMessage.ticketId.equals(getValue._id)) {
            return;
        }
        User user = ticketMessage.agent;
        if (user != null && user.f12429id > -1 && getValue.status.equals("pending")) {
            getValue.agent = ticketMessage.agent;
            getValue.status = "open";
            TicketCategoryListVM.ticketMutableLiveData.setValue( getValue);
        }
        m4385a(ticketMessage.createdBy, ticketMessage.message, ticketMessage.createdAt, "receive", false);
    }


    public  void m4384a(Boolean bool) {
        if (bool.booleanValue()) {
            mo4374I();
        }
    }


    public void m4385a(java.lang.String str, java.lang.String str2, Date date, java.lang.String str3, boolean z) {
        List<TicketMessage> getValue = TicketCategoryListVM.ticketMessageList.getValue();
        if (getValue == null) {
            getValue = new ArrayList<>();
        }
        TicketMessage ticketMessage = new TicketMessage();
        ticketMessage.createdBy = str;
        ticketMessage.message = str2;
        ticketMessage.createdAt = date;
        ticketMessage.isResolved = z;
        getValue.add(ticketMessage);
        TicketCategoryListVM.ticketMessageList.setValue(getValue);
        if (str3.equals("send")) {
            ((EditText) findViewById(R.id.cet_message)).setText("");
        }
    }


    public abstract void mo4386b(java.lang.String str);

    /* JADX WARN: Multi-variable type inference failed */

    public void mo4387b(final List<TicketMessage> list) {
        if (list.size() > 0) {
            if (this.f7010J.equals("resolved")) {
                TicketMessage ticketMessage = new TicketMessage();
                ticketMessage.createdBy = "user";
                ticketMessage.message = getResources().getString(R.string.resolvedTicket);
                ticketMessage.createdAt = new Date();
                ticketMessage.isResolved = true;
                list.add(ticketMessage);
            }
            MutableLiveData<Ticket> mutableLiveData = TicketCategoryListVM.ticketMutableLiveData;
            TicketMessageAdapter c1900m = new TicketMessageAdapter(this, mutableLiveData != null ? ((Ticket) Objects.requireNonNull(mutableLiveData.getValue())).user : null);
            c1900m.arrayList = list;
            c1900m.notifyDataSetChanged();
            final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_messages);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false) );
            recyclerView.setAdapter(c1900m);
            recyclerView.setHasFixedSize(true);
            if (this.f7012L.booleanValue()) {
                recyclerView.addItemDecoration(new ItemDecoration2(5, 1, false));
            }
            this.f7012L = false;
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.j.b.g
                @Override // java.lang.Runnable
                public final void run() {
//                    RecyclerView recyclerView2 = RecyclerView.this;
//                    List list2 = list;
//                    recyclerView2.m2806j(list2.size() - 1);
                }
            }, Status.f8814e);
        }
    }


    public abstract void mo4388c(java.lang.String str);


    public  void m4389d(View view) {
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        java.lang.String obj = ((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_message)).getText())).toString();
        if (m4390d(obj)) {
            mo4388c(obj);
        }
    }


    public boolean m4390d(java.lang.String str) {
        if (str.isEmpty() || str.trim().length() == 0) {
            Util.toast(this, getResources().getString(R.string.input_message), "error", 0, 0);
            return false;
        }
        if (str.length() < Status.f8834y) {
            return true;
        }
        Util.toast(this, java.lang.String.format(getResources().getString(R.string.message_overflow), Integer.valueOf(Status.f8834y)), "error", 0, 0);
        return false;
    }


    public  void m4391e(View view) {
        if (this.f7016P) {
            return;
        }
        this.f7016P = true;
        mo4381P();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6502v = false;
        setContentView(R.layout.activity_ticket_chat);
        this.f7009I = ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getString("id");
        this.f7010J = ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getString("status");
        this.f7011K = ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getString("title");
        this.f7014N = Boolean.valueOf(((Bundle) Objects.requireNonNull(getIntent().getExtras())).getBoolean("isDashboard"));
        mo4386b(this.f7009I);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.a.j.b.f
            @Override // java.lang.Runnable
            public final void run() {
                ActivityTicketChat.this.m4379N();
            }
        }, Status.f8814e);
        if (this.f7010J.equals("hidden")) {
            findViewById(R.id.llc_send_message).setVisibility(View.GONE);
        }
        mo4284G();
        m4376K();
        m4377L();
        TicketCategoryListVM.f10283i.setValue( false);
        m4378M();
        m4297a(this.f7011K);
        m4375J();
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
