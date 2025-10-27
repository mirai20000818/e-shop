package com.jeil.emarket.providers;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.jeil.emarket.model.customer.Point;
import com.jeil.emarket.model.customer.Review;
import com.jeil.emarket.model.customer.VendorCard;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.m.e0 */

public class ReviewProvider extends ViewModel implements BaseInterface {

    
    public MutableLiveData<Integer> f10463d = new MutableLiveData<>();

    
    public MutableLiveData<Review> f10464e = new MutableLiveData<>();

    /* renamed from: f */
    public MutableLiveData<Integer> f10465f = new MutableLiveData<>();

    /* renamed from: g */
    public JSONObject f10466g = new JSONObject();

    /* renamed from: h */
    public MutableLiveData<Point> f10467h = new MutableLiveData<>();

    
    public MutableLiveData<VendorCard> f10468i = new MutableLiveData<>();

   
    public MutableLiveData<Boolean> f10469j = new MutableLiveData<>();


    public  void m5630a(int i, int i2, int i3, int i4, int i5, java.lang.String str, Context context, Context context2) {
        try {
            this.f10469j = new MutableLiveData<>();
            this.f10466g.put("id", i);
            this.f10466g.put("orderId", i2);
            this.f10466g.put("support", i3);
            this.f10466g.put("delivery", i4);
            this.f10466g.put("service", i5);
            this.f10466g.put("text", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(context, "update_point", this).put(CustomString.m3176b("e6/points/", i), this.f10466g);
    }


    public  void m5631a(int i, int i2, int i3, java.lang.String str, Context context, Context context2) {
        try {
            this.f10469j = new MutableLiveData<>();
            this.f10466g.put("productId", i);
            this.f10466g.put("id", i2);
            this.f10466g.put("rating", i3);
            this.f10466g.put("text", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(context, "update_review", this).put(CustomString.m3176b("e6/reviews/", i2), this.f10466g);
    }


    public void m5632a(final Context context, final int i) {
        this.f10469j = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.l
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5636a(context, i, context2);
            }
        });
    }


    public void m5633a(final Context context, int i, int i2, int i3, int i4, int i5, java.lang.String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            this.f10469j = new MutableLiveData<>();
            jSONObject.put("orderId", i);
            jSONObject.put("vendorId", i2);
            jSONObject.put("service", i3);
            jSONObject.put("delivery", i4);
            jSONObject.put("support", i5);
            jSONObject.put("text", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.o
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5638a(context, jSONObject, context2);
            }
        });
    }


    public void m5634a(final Context context, int i, int i2, int i3, int i4, java.lang.String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            this.f10469j = new MutableLiveData<>();
            jSONObject.put("orderItemId", i);
            jSONObject.put("vendorId", i2);
            jSONObject.put("productId", i3);
            jSONObject.put("rating", i4);
            jSONObject.put("text", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.m
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5643b(context, jSONObject, context2);
            }
        });
    }


    public void m5635a(final Context context, final int i, final int i2, final int i3, final java.lang.String str) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.g
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5631a(i, i2, i3, str, context, context2);
            }
        });
    }


    public  void m5636a(Context context, int i, Context context2) {
        new API_PROVIDER(context, "delete_point", this).delete("e6/points/" + i, (JSONObject) null);
    }


    public void m5637a(final Context context, final int i, final BaseInterface baseInterface) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.q
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "vote_point", baseInterface).put("e6/points/" + i + "/vote", null);
            }
        });
    }


    public  void m5638a(Context context, JSONObject jSONObject, Context context2) {
        new API_PROVIDER(context, "add_point", this).post("e6/points", jSONObject);
    }


    public void m5639b(final Context context, final int i) {
        this.f10469j = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.f
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5641b(context, i, context2);
            }
        });
    }


    public void m5640b(final Context context, final int i, final int i2, final int i3, final int i4, final int i5, final java.lang.String str) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.p
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5630a(i, i2, i3, i4, i5, str, context, context2);
            }
        });
    }


    public  void m5641b(Context context, int i, Context context2) {
        new API_PROVIDER(context, "delete_review", this).delete("e6/reviews/" + i, (JSONObject) null);
    }


    public void m5642b(final Context context, final int i, final BaseInterface baseInterface) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.h
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "vote_review", baseInterface).put("e6/reviews/" + i + "/vote", null);
            }
        });
    }


    public  void m5643b(Context context, JSONObject jSONObject, Context context2) {
        new API_PROVIDER(context, "add_review", this).post("e6/reviews", jSONObject);
    }

    
    public MutableLiveData<Boolean> m5644c() {
        return this.f10469j;
    }

    
    public void m5645c(final Context context, final int i) {
        this.f10469j = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.j
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5646c(context, i, context2);
            }
        });
    }

    
    public  void m5646c(Context context, int i, Context context2) {
        new API_PROVIDER(context, "format_point", this).put("e6/publish/point/" + i, null);
    }

    
    public MutableLiveData<Point> m5647d() {
        return this.f10467h;
    }

    
    public void m5648d(final Context context, final int i) {
        this.f10469j = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.r
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5649d(context, i, context2);
            }
        });
    }

    
    public  void m5649d(Context context, int i, Context context2) {
        new API_PROVIDER(context, "format_review", this).put("e6/publish/review/" + i, null);
    }

    
    public MutableLiveData<Review> m5650e() {
        return this.f10464e;
    }

    
    public void m5651e(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.k
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5652e(context, i, context2);
            }
        });
    }

    
    public  void m5652e(Context context, int i, Context context2) {
        new API_PROVIDER(context, "get_point_info", this).m5406a("e6/points/" + i);
    }

    /* renamed from: f */
    public MutableLiveData<VendorCard> m5653f() {
        return this.f10468i;
    }

    /* renamed from: f */
    public void m5654f(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.n
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5655f(context, i, context2);
            }
        });
    }

    /* renamed from: f */
    public  void m5655f(Context context, int i, Context context2) {
        new API_PROVIDER(context, "get_review_info", this).m5406a("e6/reviews/" + i);
    }

    /* renamed from: g */
    public void m5656g(final Context context, final int i) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.m.i
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b

            public final void mo4271a(Context context2) {
                ReviewProvider.this.m5657g(context, i, context2);
            }
        });
    }

    /* renamed from: g */
    public  void m5657g(Context context, int i, Context context2) {
        new API_PROVIDER(context, "get_vendor_card", this).m5406a("e6/order/vendor/" + i);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            return;
        }
        switch (str2) {
            case "add_review":
                try {
                    this.f10463d.setValue( Integer.valueOf(new JSONObject(str).getInt("reviewId")));
                    MutableLiveData<Boolean> mutableLiveData = this.f10469j;
                    if (i != 200) {
                        z = false;
                    }
                    mutableLiveData.setValue( Boolean.valueOf(z));
                    return;
                } catch (Exception e2) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e2);
                    return;
                }
            case "get_review_info":
                if (i == 200) {
                    try {
                        this.f10464e.setValue( new Gson().fromJson(str, new TpyeReview(this).getType()));
                        return;
                    } catch (Exception e3) {
                        CustomString.m3173a(str2, ": Gson Exception is ", e3);
                        return;
                    }
                }
                return;
            case "add_point":
                try {
                    this.f10465f.setValue( Integer.valueOf(new JSONObject(str).getInt("pointId")));
                    MutableLiveData<Boolean> mutableLiveData2 = this.f10469j;
                    if (i != 200) {
                        z = false;
                    }
                    mutableLiveData2.setValue( Boolean.valueOf(z));
                    return;
                } catch (Exception e4) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e4);
                    return;
                }
            case "get_point_info":
                try {
                    this.f10467h.setValue( new Gson().fromJson(str, new TypePoint(this).getType()));
                    return;
                } catch (Exception e5) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e5);
                    return;
                }
            case "get_vendor_card":
                try {
                    this.f10468i.setValue( new Gson().fromJson(str, new TypeVendorCard(this).getType()));
                    return;
                } catch (Exception e6) {
                    CustomString.m3173a(str2, ": Gson Exception is ", e6);
                    return;
                }
            case "update_review":
            case "delete_review":
            case "format_review":
            case "update_point":
            case "delete_point":
            case "format_point":
                this.f10469j.setValue( Boolean.valueOf(i == 200));
                return;
            default:
                throw new IllegalStateException(CustomString.append("Unexpected value: ", str2));
        }
    }
}
