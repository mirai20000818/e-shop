package com.jeil.emarket.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Ticket;
import com.jeil.emarket.model.customer.TicketCategory;
import com.jeil.emarket.model.customer.TicketMessage;
import com.jeil.emarket.model.customer.TicketUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.custom.db.DBManager;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.k3 */

public class TicketCategoryListVM extends ViewModel implements BaseInterface {

    
    public static MutableLiveData<List<TicketCategory>> ticketCategoryList = new MutableLiveData<>();

    
    public static MutableLiveData<Ticket> ticketMutableLiveData = new MutableLiveData<>();

    /* renamed from: f */
    public static MutableLiveData<TicketUser> ticketUserMutableLiveData = new MutableLiveData<>();

    /* renamed from: g */
    public static MutableLiveData<List<TicketMessage>> ticketMessageList = new MutableLiveData<>();

    /* renamed from: h */
    public static MutableLiveData<Integer> f10282h = new MutableLiveData<>();

    
    public static MutableLiveData<Boolean> f10283i = new MutableLiveData<>();

   
    public static MutableLiveData<Integer> f10284j = new MutableLiveData<>(-1);

    /* renamed from: b.f.a.k.k3$a */
    public static class a extends TypeToken<List<TicketCategory>> {
    }


    public static List<TicketCategory> m5495a(List<java.lang.String> list) {
        ArrayList arrayList = new ArrayList();
        if (ticketCategoryList.getValue() != null && ticketCategoryList.getValue().size() > 0) {
            for (TicketCategory ticketCategory : ticketCategoryList.getValue()) {
                if (list.contains(ticketCategory.type)) {
                    arrayList.add(ticketCategory);
                }
            }
        }
        return arrayList;
    }


    public static void m5496a(final Context context) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.v1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                TicketCategoryListVM.m5497a(context, context2);
            }
        });
    }


    public static void m5499a(final Context context, final java.lang.String str) {
        f10282h = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.b2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "hide_ticket", new TicketCategoryListVM()).put("e6/tickets/hide/" + str, null);
            }
        });
    }


    public static void m5501a(final Context context, final java.lang.String str, final Boolean bool) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.c2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                TicketCategoryListVM.m5498a(context, bool, str, context2);
            }
        });
    }


    public static void m5502a(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.d2
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "change_ticket_status", new TicketCategoryListVM()).put("e6/tickets", jSONObject);
            }
        });
    }


    public static void m5504a(java.lang.String str, java.lang.String str2, int i, boolean z) {
        try {
            ticketCategoryList.setValue( new Gson().fromJson(str, new a().getType()));
            if (z || i != 200) {
                return;
            }
            DBManager.getDB().update("ticket_categories", str, 7200000);
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }

    
    public static void m5505b(final Context context) {
        InterfaceContext interfaceContext;
        java.lang.String m4768a = DBManager.getDB().Delete("ticket_categories");
        if (m4768a.isEmpty()) {
            interfaceContext = new InterfaceContext() { // from class: b.f.a.k.e2
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                public final void mo4271a(Context context2) {
                    new API_PROVIDER(context, "get_ticket_categories", new TicketCategoryListVM()).m5406a("e6/tickets/categories");
                }
            };
        } else {
            try {
                m5504a(m4768a, "get_home_data", 400, true);
                return;
            } catch (Exception unused) {
                interfaceContext = new InterfaceContext() { // from class: b.f.a.k.w1
                    @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

                    public final void mo4271a(Context context2) {
                        new API_PROVIDER(context, "get_ticket_categories", new TicketCategoryListVM()).m5406a("e6/tickets/categories");
                    }
                };
            }
        }
        API_PROVIDER.checkInternet(context, interfaceContext);
    }

    
    public static void m5507b(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.x1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                TicketCategoryListVM.m5508b(context, jSONObject, context2);
            }
        });
    }

    
    public static  void m5508b(Context context, JSONObject jSONObject, Context context2) {
        f10283i = new MutableLiveData<>();
        new API_PROVIDER(context, "create_ticket", new TicketCategoryListVM()).post("e7/tickets", jSONObject);
    }

    
    public static void m5510c(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.y1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "create_ticket", new TicketCategoryListVM()).post("e6/tickets", jSONObject);
            }
        });
    }


    public static  void m5497a(Context context, Context context2) {
        f10284j.setValue( (-1));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("withCategories", false);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(context, "get_new_tickets", new TicketCategoryListVM()).get("e6/tickets/count", jSONObject);
    }


    public static  void m5498a(Context context, Boolean bool, java.lang.String str, Context context2) {
        ticketMutableLiveData = new MutableLiveData<>();
        ticketUserMutableLiveData = new MutableLiveData<>();
        ticketMessageList = new MutableLiveData<>();
        API_PROVIDER APIS = new API_PROVIDER(context, "get_ticket_detail", new TicketCategoryListVM());
        StringBuilder sb = new StringBuilder();
        sb.append(bool.booleanValue() ? "e7/tickets/" : "e6/tickets/");
        sb.append(str);
        APIS.m5406a(sb.toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        char c2;
        LiveData liveData;
        Object valueOf;
        if (str == null || str.length() <= 0) {
            return;
        }
        switch (str2.hashCode()) {
            case -1878592593:
                if (str2.equals("create_ticket")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1227471905:
                if (str2.equals("get_new_tickets")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -924829765:
                if (str2.equals("get_ticket_detail")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -624136624:
                if (str2.equals("send_message")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -177495930:
                if (str2.equals("get_ticket_categories")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 49446057:
                if (str2.equals("hide_ticket")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            m5504a(str, str2, i, false);
            return;
        }
        if (c2 == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ticketMutableLiveData.setValue( new Gson().fromJson(jSONObject.getString("ticket"), new TypeToken<Ticket>(){}.getType()));
                if (jSONObject.has("userInfo")) {
                    ticketUserMutableLiveData.setValue( new Gson().fromJson(jSONObject.getString("userInfo"), new TypeToken<TicketUser>(){}.getType()));
                    if (ticketMutableLiveData.getValue() != null && ticketUserMutableLiveData.getValue() != null) {
                        ticketMutableLiveData.getValue().user.avatar = ticketUserMutableLiveData.getValue().avatar;
                    }
                }
                ticketMessageList.setValue( new Gson().fromJson(jSONObject.getString("messages"), new TypeToken<List<TicketMessage>>(){}.getType()));
                return;
            } catch (Exception e2) {
                CustomString.m3173a(str2, ": Gson Exception is ", e2);
                return;
            }
        }
        if (c2 == 2 || c2 == 3) {
            liveData = f10283i;
            valueOf = Boolean.valueOf(i > 200);
         //   liveData.setValue(valueOf);
        } else {
            if (c2 == 4) {
                try {
                    f10284j.setValue( new Gson().fromJson(new JSONObject(str).getString("count"), new TypeToken<Integer>(){}.getType()));
                    return;
                } catch (Exception e3) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e3);
                    f10284j.setValue( (-1));
                    return;
                }
            }
            if (c2 != 5) {
                return;
            }
            liveData = f10282h;
            valueOf = Integer.valueOf(i);
          //  liveData.setValue( valueOf);
        }
    }
}
