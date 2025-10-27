package com.jeil.emarket.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;
import com.jeil.emarket.model.vendor.CheckSaleProducts;
import com.jeil.emarket.model.vendor.FBT;
import java.lang.reflect.Type;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.k.g3 */

public class ProductTotalVM extends ViewModel implements BaseInterface {


    public static MutableLiveData<ProductDetail> f10236d = new MutableLiveData<>();


    public static MutableLiveData<ProductDetail> f10237e = new MutableLiveData<>();

    /* renamed from: f */
    public static MutableLiveData<List<Product>> f10238f = new MutableLiveData<>();

    /* renamed from: g */
    public static MutableLiveData<Integer> f10239g;

    /* renamed from: h */
    public static MutableLiveData<Integer> f10240h;


    public static MutableLiveData<java.lang.String> f10241i;

   
    public static MutableLiveData<java.lang.String> f10242j;

    
    public static MutableLiveData<CheckSaleProducts> f10243k;

    /* renamed from: l */
    public static MutableLiveData<FBT> f10244l;

    /* renamed from: m */
    public static MutableLiveData<Integer> f10245m;

    /* renamed from: b.f.a.k.g3$a */
    public class a extends TypeToken<ProductDetail> {
        public a(ProductTotalVM productTotalVM) {
        }
    }

    /* renamed from: b.f.a.k.g3$b */
    public class b extends TypeToken<ProductDetail> {
        public b(ProductTotalVM productTotalVM) {
        }
    }

    /* renamed from: b.f.a.k.g3$c */
    public class c extends TypeToken<List<Product>> {
        public c(ProductTotalVM productTotalVM) {
        }
    }

    /* renamed from: b.f.a.k.g3$d */
    public class d extends TypeToken<CheckSaleProducts> {
        public d(ProductTotalVM productTotalVM) {
        }
    }

    /* renamed from: b.f.a.k.g3$e */
    public class e extends TypeToken<FBT> {
        public e(ProductTotalVM productTotalVM) {
        }
    }

    /* renamed from: b.f.a.k.g3$f */
    public class f extends TypeToken<Integer> {
        public f(ProductTotalVM productTotalVM) {
        }
    }

    static {
        new MutableLiveData();
        f10239g = new MutableLiveData<>();
        f10240h = new MutableLiveData<>();
        f10241i = new MutableLiveData<>();
        f10242j = new MutableLiveData<>();
        f10243k = new MutableLiveData<>();
        f10244l = new MutableLiveData<>();
        f10245m = new MutableLiveData<>();
    }

    
    public static void m5461a(final Context context, final int i) {
        f10244l = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.t1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_fbt_detail", new ProductTotalVM()).m5406a("e7/fbt/" + i);
            }
        });
    }

    
    public static void m5463a(final Context context, final int i, final JSONObject jSONObject) {
        f10239g = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.h1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "update_fbt_detail", new ProductTotalVM()).put("e7/fbt/" + i, jSONObject);
            }
        });
    }

    
    public static void m5465a(final Context context, final JSONObject jSONObject) {
        f10239g = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.i1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "add_fbt", new ProductTotalVM()).post("e7/fbt", jSONObject);
            }
        });
    }


    public static void m5467b(final Context context, final int i) {
        f10237e = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.m1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ProductTotalVM.m5468b(context, i, context2);
            }
        });
    }


    public static void m5469b(final Context context, final int i, final JSONObject jSONObject) {
        f10239g = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.r1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "update_product", new ProductTotalVM()).put("e7/products/" + i, jSONObject);
            }
        });
    }


    public static void m5471b(final Context context, final JSONObject jSONObject) {
        f10240h = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.n1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "add_sale_products", new ProductTotalVM()).post("e7/sale/flash", jSONObject);
            }
        });
    }


    public static void m5473c(final Context context, final int i) {
        f10236d = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.l1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_vendor_product_detail", new ProductTotalVM()).m5406a("e7/products/" + i);
            }
        });
    }


    public static void m5475c(final Context context, final JSONObject jSONObject) {
        f10239g = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.j1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "restore_product", new ProductTotalVM()).delete("e7/products/", jSONObject);
            }
        });
    }


    public static void m5477d(final Context context, final JSONObject jSONObject) {
        f10238f = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.o1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "get_related_products", new ProductTotalVM()).get("e6/products", jSONObject);
            }
        });
    }


    public static void m5479e(final Context context, final JSONObject jSONObject) {
        f10239g = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.p1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "restore_product", new ProductTotalVM()).put("e7/products/restore", jSONObject);
            }
        });
    }

    /* renamed from: f */
    public static void m5481f(final Context context, final JSONObject jSONObject) {
        f10239g = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.k1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "trash_product", new ProductTotalVM()).put("e7/products/trash", jSONObject);
            }
        });
    }

    /* renamed from: g */
    public static void m5483g(final Context context, final JSONObject jSONObject) {
        f10240h = new MutableLiveData<>();
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.k.q1
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                new API_PROVIDER(context, "update_sale_product", new ProductTotalVM()).put("e7/sale/flash", jSONObject);
            }
        });
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        LiveData liveData;
        Gson gson;
        Type type;
        LiveData liveData2;
        Gson gson2;
        java.lang.String string;
        Type type2;
        Object valueOf;
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            switch (str2) {
                case "get_vendor_product_detail":
                    liveData = f10236d;
                    gson = new Gson();
                    type = new a(this).getType();
                  //  liveData.setValue( gson.fromJson(str, type));
                    break;
                case "get_product_detail":
                    try {
                        f10237e.setValue( new Gson().fromJson(str, new b(this).getType()));
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        f10237e.setValue( null);
                        return;
                    }
                case "get_related_products":
                    JSONObject jSONObject = new JSONObject(str);
                    liveData2 = f10238f;
                    gson2 = new Gson();
                    string = jSONObject.getString("data");
                    type2 = new c(this).getType();
                    valueOf = gson2.fromJson(string, type2);
                  //  liveData2.setValue( valueOf);
                    break;
                case "update_product":
                case "update_fbt_detail":
                case "restore_product":
                case "trash_product":
                    liveData2 = f10239g;
                    valueOf = Integer.valueOf(i);
                 //   liveData2.setValue( valueOf);
                    break;
                case "update_sale_product":
                case "add_sale_products":
                    liveData2 = f10240h;
                    valueOf = Integer.valueOf(i);
                  //  liveData2.setValue( valueOf);
                    break;
                case "check_sale_products":
                    f10240h.setValue( Integer.valueOf(i));
                    if (i == 200) {
                        liveData = f10243k;
                        gson = new Gson();
                        type = new d(this).getType();
                 //       liveData.setValue( gson.fromJson(str, type));
                        break;
                    }
                    break;
                case "get_fbt_detail":
                    liveData = f10244l;
                    gson = new Gson();
                    type = new e(this).getType();
                 //   liveData.setValue( gson.fromJson(str, type));
                    break;
                case "add_fbt":
                    JSONObject jSONObject2 = new JSONObject(str);
                    liveData2 = f10245m;
                    gson2 = new Gson();
                    string = jSONObject2.getString("id");
                    type2 = new f(this).getType();
                    valueOf = gson2.fromJson(string, type2);
                 //   liveData2.setValue( valueOf);
                    break;
            }
        } catch (Exception e3) {
            CustomString.m3173a(str2, ": Gson Exception is ", e3);
        }
    }


    public static  void m5468b(Context context, int i, Context context2) {
        API_PROVIDER APIS = new API_PROVIDER(context, "get_product_detail", new ProductTotalVM());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
            if (!DayProductVM.f10257f.contains(Integer.valueOf(i))) {
                jSONObject.put("views", true);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        APIS.get("e6/products/" + i, jSONObject);
    }
}
