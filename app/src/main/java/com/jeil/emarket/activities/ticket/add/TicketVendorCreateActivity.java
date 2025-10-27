package com.jeil.emarket.activities.ticket.add;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.intro.HelpDetailActivity;
import com.jeil.emarket.activities.ticket.list.TicketUserListActivity;
import com.jeil.emarket.components.button.RadioButton;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.ProductDetail;
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

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.obj.Cancel_Obj;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.VendorListVM;


public class TicketVendorCreateActivity extends BaseActivity {

    
    public BaseDialog2 f11930I = null;

   
    public MutableLiveData<TicketCategory> f11931J = new MutableLiveData<>();

    
    public Vendor f11932K = new Vendor();

    /* renamed from: L */
    public BaseDialog2 f11933L = null;

    /* renamed from: M */
    public boolean f11934M = true;

    /* renamed from: N */
    public int f11935N = -1;

    /* renamed from: O */
    public java.lang.String f11936O = "";

    /* renamed from: P */
    public java.lang.String f11937P = "";

    /* renamed from: com.jeil.emarket.activities.ticket.add.TicketVendorCreateActivity$a */
    public class C3227a extends TypeToken<List<ProductDetail.CategoryPhone>> {
        public C3227a(TicketVendorCreateActivity ticketVendorCreateActivity) {
        }
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: G */
    public void mo4284G() {
        super.mo4284G();
        ((RadioButton) findViewById(R.id.crb_vendor)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.a.j.a.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TicketVendorCreateActivity.this.m6767b(compoundButton, z);
            }
        });
        ((RadioButton) findViewById(R.id.crb_market)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b.f.a.a.j.a.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TicketVendorCreateActivity.this.m6770c(compoundButton, z);
            }
        });
        findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketVendorCreateActivity.this.m6773f(view);
            }
        });
        findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketVendorCreateActivity.this.m6774g(view);
            }
        });
        findViewById(R.id.mrl_help_link).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketVendorCreateActivity.this.m6775h(view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    
    public void m6760I() {
        EditText editText;
        java.lang.String string;
        List list;
        int i;
        int i2;
        List<TicketCategory> getValue = TicketCategoryListVM.ticketCategoryList.getValue();
        if (getValue != null && getValue.size() != 0) {
            for (int i3 = 0; i3 < getValue.size(); i3++) {
                if ((!this.f11934M || getValue.get(i3).type.equals("cv")) && (this.f11934M || getValue.get(i3).type.equals("cm"))) {
                    this.f11931J.setValue( getValue.get(i3));
                    ((TextView) findViewById(R.id.tv_category_name)).setText(getValue.get(i3).name);
                    break;
                }
            }
        }
        java.lang.String str = "";
        if (this.f11934M) {
            this.f11932K = new Vendor();
            ((TextView) findViewById(R.id.tv_vendor)).setText("");
            findViewById(R.id.iv_vendor_select).setVisibility(View.VISIBLE);
            editText = (EditText) findViewById(R.id.cet_message);
            string = getResources().getString(R.string.ticket_vendor_message_placeholder);
        } else {
            this.f11932K = new Vendor();
            Vendor vendor = this.f11932K;
            vendor.f12449id = -1;
            vendor.name = getResources().getString(R.string.market_manager);
            ((TextView) findViewById(R.id.tv_vendor)).setText(getResources().getString(R.string.market_manager));
            findViewById(R.id.iv_vendor_select).setVisibility(View.GONE);
            editText = (EditText) findViewById(R.id.cet_message);
            string = getResources().getString(R.string.ticket_message_placeholder);
        }
        editText.setHint(string);
        ((EditText) findViewById(R.id.cet_message)).setMaxLength(Status.f8834y, getResources().getString(R.string.input_limit));
        findViewById(R.id.mrl_select_category).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketVendorCreateActivity.this.m6771d(view);
            }
        });
        findViewById(R.id.mrl_select_vendor).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicketVendorCreateActivity.this.m6772e(view);
            }
        });
        ArrayList arrayList = new ArrayList();
        if (getIntent().getExtras() != null) {
            i = getIntent().getIntExtra("productId", 0);
            i2 = getIntent().getIntExtra("orderId", 0);
            str = getIntent().getStringExtra("displayOrderId");
            list = (List) new Gson().fromJson(getIntent().getStringExtra("categories"), new C3227a(this).getType());
        } else {
            list = arrayList;
            i = 0;
            i2 = 0;
        }
        if (i != 0) {
            this.f11936O = "product";
            this.f11935N = i;
            this.f11937P = getIntent().getStringExtra("vendorName");
            findViewById(R.id.rg_vendor).setVisibility(View.GONE);
            findViewById(R.id.ll_select_vendor).setVisibility(View.GONE);
            TextView textView = (TextView) findViewById(R.id.tv_ticket_desc);
            textView.setVisibility(View.VISIBLE);
            textView.setText(java.lang.String.format(getResources().getString(R.string.product_ticket_desc), Integer.valueOf(i)));
            textView.setTextColor(getResources().getColor(R.color.dark));
            textView.setGravity(17);
            textView.setPadding(0, 0, 0, BaseActivity.anInt2);
            textView.setTextSize(1, 15.0f);
            ((EditText) findViewById(R.id.cet_message)).setHint(this.f11937P + "에 보내는 " + getResources().getString(R.string.ticket_message_placeholder));
        }
        if (i2 != 0) {
            this.f11936O = "order";
            this.f11935N = i2;
            this.f11937P = getIntent().getStringExtra("vendorName");
            findViewById(R.id.rg_vendor).setVisibility(View.GONE);
            findViewById(R.id.ll_select_vendor).setVisibility(View.GONE);
            TextView textView2 = (TextView) findViewById(R.id.tv_ticket_desc);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(java.lang.String.format(getResources().getString(R.string.order_ticket_desc), str));
            textView2.setTextColor(getResources().getColor(R.color.dark));
            textView2.setGravity(17);
            textView2.setPadding(0, 0, 0, BaseActivity.anInt2);
            textView2.setTextSize(1, 15.0f);
            ((EditText) findViewById(R.id.cet_message)).setHint(this.f11937P + "에 보내는 " + getResources().getString(R.string.ticket_message_placeholder));
            if (getValue != null && getValue.size() != 0) {
                int i4 = 0;
                while (true) {
                    if (i4 >= getValue.size()) {
                        break;
                    }
                    if (getValue.get(i4).type.equals("cv") && getValue.get(i4).name.equals(getResources().getString(R.string.order_related))) {
                        this.f11931J.setValue( getValue.get(i4));
                        break;
                    }
                    i4++;
                }
            }
        }
        if (i == 0 || list == null || list.size() == 0) {
            findViewById(R.id.ll_contact).setVisibility(View.GONE);
            return;
        }
        findViewById(R.id.ll_contact).setVisibility(View.VISIBLE);
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (((ProductDetail.CategoryPhone) list.get(i5)).value.size() != 0) {
                final ProductDetail.CategoryPhone categoryPhone = (ProductDetail.CategoryPhone) list.get(i5);
                View inflate = getLayoutInflater().inflate(R.layout.item_phone, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.ctv_label)).setText(getResources().getString(R.string.shipping_phone_comma));
                StringBuilder sb = new StringBuilder();
                for (int i6 = 0; i6 < categoryPhone.value.size(); i6++) {
                    sb.append(categoryPhone.value.get(i6));
                    if (i6 != categoryPhone.value.size() - 1) {
                        sb.append(", ");
                    }
                }
                ((TextView) inflate.findViewById(R.id.ctv_phone_number)).setText(sb.toString());
                if (categoryPhone.name.size() != 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (int i7 = 0; i7 < categoryPhone.name.size(); i7++) {
                        sb2.append(categoryPhone.name.get(i7));
                        if (i7 != categoryPhone.name.size() - 1) {
                            sb2.append(", ");
                        }
                    }
                    TextView textView3 = (TextView) inflate.findViewById(R.id.ctv_category);
                    StringBuilder m3163a = CustomString.format("(");
                    m3163a.append(sb2.toString());
                    m3163a.append(")");
                    textView3.setText(m3163a.toString());
                    inflate.findViewById(R.id.ctv_category).setVisibility(View.VISIBLE);
                } else {
                    inflate.findViewById(R.id.ctv_category).setVisibility(View.GONE);
                }
                inflate.findViewById(R.id.mrl_phone_number).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.j.a.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TicketVendorCreateActivity.this.m6763a(categoryPhone, view);
                    }
                });
                ((LinearLayoutCompat) findViewById(R.id.llc_phone_group)).addView(inflate);
            }
        }
    }

   
    public void m6761J() {
        final List<Vendor> getValue = VendorListVM.f10365f.getValue() != null ? VendorListVM.f10365f.getValue() : new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getValue.size(); i++) {
            arrayList.add(new Cancel_Obj(getValue.get(i).name, ((TextView) findViewById(R.id.tv_vendor)).getText().equals(getValue.get(i).name) ? 1 : 0));
        }
        this.f11933L = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList, 80);
        BaseDialog2 baseDialog2 = this.f11933L;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.j.a.k
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b
            
            public final void mo4264a(View view, int i2) {
                TicketVendorCreateActivity.this.m6768b(getValue, view, i2);
            }
        };
        baseDialog2.f8255f = 0.6f;
        baseDialog2.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        this.f11933L.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.j.a.o
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                TicketVendorCreateActivity.this.m6769c(dialogInterface);
            }
        });
    }

    
    public  void m6762a(DialogC2001j dialogC2001j, View view, Boolean bool) {
        if (dialogC2001j != null) {
            dialogC2001j.dismiss();
        }
        if (bool != null && bool.booleanValue()) {
            view.setAlpha(1.0f);
            view.setEnabled(true);
            return;
        }
        Intent intent = new Intent(getApplicationContext(), TicketUserListActivity.class);
        if (this.f11935N > 0) {
            startActivity(intent);
        } else {
            setResult(-1, intent);
        }
        finish();
    }

    
    public  void m6763a(ProductDetail.CategoryPhone categoryPhone, View view) {
        List<java.lang.String> list = categoryPhone.value;
        if (list == null || list.size() == 0) {
            Util.toast(this, getString(R.string.not_exist_phone), "error", 0, 0);
            return;
        }
        if (list.size() == 1) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + list.get(0))));
                return;
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
                return;
            }
        }
        java.lang.String[] strArr = new java.lang.String[0];
        if (list.size() == 1) {
            strArr = new java.lang.String[]{list.get(0)};
        } else if (list.size() == 2) {
            strArr = new java.lang.String[]{list.get(0), list.get(1)};
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, strArr, null, 80);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.j.a.v
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b
            
            public final void mo4264a(View view2, int i) {
                TicketVendorCreateActivity.this.m6765a(strArr, baseDialog2, view2, i);
            }
        };
    }

    
    public  void m6766b(DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    
    public  void m6767b(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f11934M = true;
            m6760I();
        }
    }

    
    public  void m6768b(List list, View view, int i) {
        ((TextView) findViewById(R.id.tv_vendor)).setText(((Vendor) list.get(i)).name);
        this.f11932K = (Vendor) list.get(i);
        this.f11933L.startAni();
    }

    
    public  void m6769c(DialogInterface dialogInterface) {
        this.f6496A = false;
    }

    
    public  void m6770c(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f11934M = false;
            m6760I();
        }
    }

    
    public  void m6771d(View view) {
        if (this.f6496A) {
            return;
        }
        this.f6496A = true;
        showSelectCategoryDialog(view);
    }

    
    public  void m6772e(View view) {
        if (this.f6496A || this.f11932K.f12449id == -1) {
            return;
        }
        this.f6496A = true;
        m6761J();
    }

    /* renamed from: f */
    public  void m6773f(final View view) {
        Ticket.ReceiverVendor receiverVendor;
        Vendor vendor;
        Vendor vendor2;
        int i;
        java.lang.String str = this.f11937P;
        DialogC2001j dialogC2001j = null;
        if (str != null && !str.isEmpty()) {
            List<Vendor> getValue = VendorListVM.f10365f.getValue() != null ? VendorListVM.f10365f.getValue() : new ArrayList<>();
            for (int i2 = 0; i2 < getValue.size(); i2++) {
                if (this.f11937P.equals(getValue.get(i2).name)) {
                    receiverVendor = new Ticket.ReceiverVendor(getValue.get(i2).f12449id, getValue.get(i2).name);
                    break;
                }
            }
        }
        receiverVendor = null;
        if (receiverVendor == null && (i = (vendor2 = this.f11932K).f12449id) > -1) {
            receiverVendor = new Ticket.ReceiverVendor(i, vendor2.name);
        }
        if (receiverVendor == null) {
            receiverVendor = new Ticket.ReceiverVendor(0, getResources().getString(R.string.market_manager));
        }
        java.lang.String obj = ((Editable) Objects.requireNonNull(((EditText) findViewById(R.id.cet_message)).getText())).toString();
        if (this.f11931J.getValue() == null) {
            Util.toast(this, getResources().getString(R.string.input_category), "error", 0, 0);
            return;
        }
        if (this.f11934M && this.f11935N <= 0 && ((vendor = this.f11932K) == null || vendor.f12449id <= 0)) {
            Util.toast(this, getResources().getString(R.string.select_vendor_validate), "error", 0, 0);
            return;
        }
        if (obj.isEmpty() || obj.trim().length() == 0) {
            Util.toast(this, getResources().getString(R.string.input_ticket_content), "error", 0, 0);
            return;
        }
        if (obj.length() > Status.f8834y) {
            Util.toast(this, java.lang.String.format(getResources().getString(R.string.message_overflow), Integer.valueOf(Status.f8834y)), "error", 0, 0);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("categoryId", this.f11931J.getValue()._id);
            jSONObject.put("content", obj);
            jSONObject.put("status", "pending");
            if (this.f11935N > 0) {
                jSONObject.put("objectId", this.f11935N);
                jSONObject.put("requestType", this.f11936O);
            }
            jSONObject.put("read", Status.f8835z[0]);
            if (Status.f8832w.booleanValue()) {
                User user = new User();
                User getValue2 = UserVM.userMutableLiveData.getValue();
                user.f12429id = getValue2.f12429id;
                user.avatar = getValue2.avatar;
                user.name = getValue2.name;
                user.fullName = getValue2.fullName;
                jSONObject.put("type", "app");
                jSONObject.put("user", new Gson().toJson(user));
                jSONObject.put("vendor", new Gson().toJson(receiverVendor));
            } else {
                jSONObject.put("vendor", receiverVendor);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (Status.f8832w.booleanValue()) {
            MessageService messageService = MessageService.f12472h;
            if (messageService != null) {
                messageService.m7011a("createTicket", jSONObject);
            }
        } else {
            TicketCategoryListVM.m5510c(this, jSONObject);
            dialogC2001j = new DialogC2001j(this);
            dialogC2001j.show();
            view.setAlpha(0.7f);
            view.setEnabled(false);
            TicketCategoryListVM.f10283i = new MutableLiveData<>();
        }
        DialogC2001j finalDialogC2001j = dialogC2001j;
        TicketCategoryListVM.f10283i.observe(this, new Observer() { // from class: b.f.a.a.j.a.l
            @Override // p000a.p060o.InterfaceC0405p
            
            public final void onChanged(Object obj2) {
                TicketVendorCreateActivity.this.m6762a(finalDialogC2001j, view, (Boolean) obj2);
            }
        });
    }

    /* renamed from: g */
    public  void m6774g(View view) {
        onBackPressed();
    }

    /* renamed from: h */
    public  void m6775h(View view) {
        Intent intent = new Intent(getApplicationContext(), HelpDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("index", 14);
        startActivity(intent);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ticket_create);
        m4307e(R.string.ticket_left);
        if (VendorListVM.f10365f.getValue() == null || VendorListVM.f10365f.getValue().size() <= 0) {
            new API_PROVIDER(this, "get_vendors_name", new VendorListVM()).m5406a("e6/vendors/name");
        }
        m6760I();
        mo4284G();
    }

    public void showSelectCategoryDialog(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f11934M ? "cv" : "cm");
        final List<TicketCategory> m5495a = TicketCategoryListVM.m5495a(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < m5495a.size(); i++) {
            arrayList2.add(new Cancel_Obj(m5495a.get(i).name, m5495a.get(i).name.equals(((TicketCategory) Objects.requireNonNull(this.f11931J.getValue())).name) ? 1 : 0));
        }
        this.f11930I = new BaseDialog2(this, (ArrayList<Cancel_Obj>) arrayList2, 80);
        BaseDialog2 baseDialog2 = this.f11930I;
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.j.a.i
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b
            
            public final void mo4264a(View view2, int i2) {
                TicketVendorCreateActivity.this.m6764a(m5495a, view2, i2);
            }
        };
        baseDialog2.f8255f = 0.6f;
        baseDialog2.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        this.f11930I.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.j.a.s
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                TicketVendorCreateActivity.this.m6766b(dialogInterface);
            }
        });
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }

    
    public  void m6765a(java.lang.String[] strArr, BaseDialog2 baseDialog2, View view, int i) {
        try {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + strArr[i])));
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
        baseDialog2.startAni();
    }

    
    public  void m6764a(List list, View view, int i) {
        ((TextView) findViewById(R.id.tv_category_name)).setText(((TicketCategory) list.get(i)).name);
        this.f11931J.setValue((TicketCategory) list.get(i));
        this.f11930I.startAni();
    }
}
