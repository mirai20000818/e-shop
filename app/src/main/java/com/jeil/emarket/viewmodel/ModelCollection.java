package com.jeil.emarket.viewmodel;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.SameShippingOrder;
import com.jeil.emarket.model.customer.ShippingInfo;
import com.jeil.emarket.model.vendor.History;
import com.jeil.emarket.model.vendor.OrderDetail;
import com.jeil.emarket.model.vendor.ShippingMethods;
import com.jeil.emarket.model.vendor.ShippingZone;
import java.util.List;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.f3 */

public class ModelCollection extends ViewModel implements BaseInterface {


    public static MutableLiveData<OrderDetail> f10213d = new MutableLiveData<>();


    public static MutableLiveData<com.jeil.emarket.model.customer.OrderDetail> f10214e = new MutableLiveData<>();

    /* renamed from: f */
    public static MutableLiveData<List<ShippingInfo>> f10215f = new MutableLiveData<>();

    /* renamed from: g */
    public static MutableLiveData<List<SameShippingOrder>> f10216g = new MutableLiveData<>();

    /* renamed from: h */
    public static MutableLiveData<Integer> f10217h = new MutableLiveData<>();

    
    public static MutableLiveData<List<History>> f10218i = new MutableLiveData<>();

   
    public static MutableLiveData<ShippingZone> f10219j = new MutableLiveData<>();

    
    public static MutableLiveData<ShippingMethods> f10220k = new MutableLiveData<>();

    /* renamed from: l */
    public static MutableLiveData<java.lang.String> f10221l = new MutableLiveData<>();

    
    public static void m5425a(final Context context) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.u0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5432a(context, context2);
            }
        });
    }

    
    public static void m5426a(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.e1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5429a(context, i, context2);
            }
        });
    }

    
    public static void m5427a(final Context context, final int i, final int i2) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.y0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5428a(context, i, i2, context2);
            }
        });
    }

    
    public static void m5430a(final Context context, final int i, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.b1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5431a(context, i, jSONObject, context2);
            }
        });
    }

    
    public static void m5433a(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.z0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5434a(context, jSONObject, context2);
            }
        });
    }

    
    public static  void m5434a(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "add_shipping_zone", new ModelCollection()).post("e7/shipping/zones", jSONObject);
    }


    public static void m5435b(final Context context) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.t0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5440b(context, context2);
            }
        });
    }


    public static void m5436b(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.g1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5437b(context, i, context2);
            }
        });
    }


    public static void m5438b(final Context context, final int i, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.a1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5439b(context, i, jSONObject, context2);
            }
        });
    }


    public static void m5441b(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.d1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5442b(context, jSONObject, context2);
            }
        });
    }


    public static  void m5442b(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "cancel_order_items", new ModelCollection()).post("e7/orders/items/cancel", jSONObject);
    }


    public static void m5443c(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.x0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5444c(context, i, context2);
            }
        });
    }


    public static void m5445c(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.v0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5446c(context, jSONObject, context2);
            }
        });
    }


    public static  void m5446c(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "change_order_shipping_price", new ModelCollection()).put("e7/orders/price", jSONObject);
    }


    public static void m5447d(final Context context, final int i) {
        if (i != 0) {
            API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.c1
                @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
                
                public final void mo4271a(Context context2) {
                    ModelCollection.m5448d(context, i, context2);
                }
            });
        }
    }


    public static void m5449d(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.f1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5450d(context, jSONObject, context2);
            }
        });
    }


    public static  void m5450d(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "change_order_status", new ModelCollection()).put("e7/orders/status", jSONObject);
    }


    public static void m5451e(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.s0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5452e(context, jSONObject, context2);
            }
        });
    }


    public static  void m5452e(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "change_shipping_time", new ModelCollection()).put("e7/orders/time", jSONObject);
    }

    /* renamed from: f */
    public static void m5453f(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.w0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5454f(context, jSONObject, context2);
            }
        });
    }

    /* renamed from: f */
    public static  void m5454f(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "edit_order", new ModelCollection()).put("e7/orders/edit", jSONObject);
    }

    /* renamed from: g */
    public static void m5455g(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.r0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5456g(context, jSONObject, context2);
            }
        });
    }

    /* renamed from: g */
    public static  void m5456g(Context context, JSONObject jSONObject, Context context2) {
        f10216g = new MutableLiveData<>();
        new API_PROVIDER(context, "get_same_shipping_orders", new ModelCollection()).get("e7/orders/sameShippingOrders", jSONObject);
    }

    /* renamed from: h */
    public static void m5457h(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.p0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5458h(context, jSONObject, context2);
            }
        });
    }

    /* renamed from: h */
    public static  void m5458h(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "update_shipping_address", new ModelCollection()).put("e7/orders/address", jSONObject);
    }

    
    public static void m5459i(final Context context, final JSONObject jSONObject) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.q0
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ModelCollection.m5460i(context, jSONObject, context2);
            }
        });
    }

    
    public static  void m5460i(Context context, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "update_shipping_methods", new ModelCollection()).post("e7/shipping/setting", jSONObject);
    }

    
    public static  void m5431a(Context context, int i, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "cancel_order", new ModelCollection()).put("e6/orders/" + i, jSONObject);
    }


    public static  void m5437b(Context context, int i, Context context2) {
        f10214e.setValue(null);
        new API_PROVIDER(context, "get_order_detail", new ModelCollection()).m5406a("e6/orders/" + i);
    }


    public static  void m5444c(Context context, int i, Context context2) {
        f10219j = new MutableLiveData<>();
        new API_PROVIDER(context, "get_shipping_zone_detail", new ModelCollection()).m5406a("e7/shipping/zones/" + i);
    }


    public static  void m5448d(Context context, int i, Context context2) {
        f10213d.setValue( null);
        new API_PROVIDER(context, "get_vendor_order_detail", new ModelCollection()).m5406a("e7/orders/" + i);
    }

    
    public static  void m5428a(Context context, int i, int i2, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "change_deliverer", new ModelCollection()).put("e7/orders/" + i + "/changeDeliverer/" + i2, null);
    }


    public static  void m5440b(Context context, Context context2) {
        f10220k = new MutableLiveData<>();
        new API_PROVIDER(context, "get_shipping_methods", new ModelCollection()).m5406a("e7/shipping/setting");
    }


    public static  void m5439b(Context context, int i, JSONObject jSONObject, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "update_shipping_zone", new ModelCollection()).put("e7/shipping/zones/" + i, jSONObject);
    }

    
    public static  void m5429a(Context context, int i, Context context2) {
        f10217h = new MutableLiveData<>();
        new API_PROVIDER(context, "confirm_shipping_price", new ModelCollection()).put("e6/orders/price/" + i, null);
    }

    
    public static  void m5432a(Context context, Context context2) {
        f10215f.setValue( null);
        new API_PROVIDER(context, "get_deliverers", new ModelCollection()).m5406a("e7/deliverers/all");
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        switch (str2) {
            case "get_order_detail":
                try {
                    f10214e.setValue( new Gson().fromJson(str, new TypeToken<com.jeil.emarket.model.customer.OrderDetail>(){}.getType()));
                    break;
                } catch (Exception e2) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e2);
                }
            case "get_vendor_order_detail":
                try {
                    f10213d.setValue( new Gson().fromJson(str, new TypeToken<OrderDetail>(){}.getType()));
                    break;
                } catch (Exception e3) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e3);
                    return;
                }
            case "get_deliverers":
                try {
                    f10215f.setValue( new Gson().fromJson(str, new TypeToken<List<ShippingInfo>>(){}.getType()));
                    break;
                } catch (Exception e4) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e4);
                    return;
                }
            case "change_order_status":
            case "cancel_order_items":
            case "cancel_order":
            case "complete_order":
            case "confirm_shipping_price":
            case "change_order_shipping_price":
            case "change_shipping_time":
            case "change_deliverer":
            case "update_shipping_zone":
            case "add_shipping_zone":
            case "edit_order":
                f10217h.setValue( Integer.valueOf(i));
                HistoryVM.m5494c();
                break;
            case "get_shipping_zone_detail":
                try {
                    f10219j.setValue( new Gson().fromJson(str, new TypeToken<ShippingZone>(){}.getType()));
                    break;
                } catch (Exception e5) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e5);
                    return;
                }
            case "get_vendor_order_history":
                try {
                    f10218i.setValue( new Gson().fromJson(str, new TypeToken<List<History>>(){}.getType()));
                    break;
                } catch (Exception e6) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e6);
                    return;
                }
            case "get_shipping_methods":
                try {
                    f10220k.setValue( new Gson().fromJson(str, new TypeToken<ShippingMethods>(){}.getType()));
                    break;
                } catch (Exception e7) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e7);
                    return;
                }
            case "update_shipping_methods":
            case "update_shipping_address":
                f10217h.setValue( Integer.valueOf(i));
                break;
            case "get_same_shipping_orders":
                try {
                    f10216g.setValue( new Gson().fromJson(str, new TypeToken<List<SameShippingOrder>>(){}.getType()));
                    break;
                } catch (Exception e8) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e8);
                    return;
                }
        }
    }
}
