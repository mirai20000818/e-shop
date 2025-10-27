package com.jeil.emarket.providers;

import android.content.Context;

import com.jeil.emarket.custom.CustomString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jeil.emarket.custom.Status;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.api.API_PROVIDER;

/* renamed from: b.f.a.m.x */

public class ProductsProvider extends ViewModel implements BaseInterface {

    
    public MutableLiveData<Integer> f10531d = new MutableLiveData<>(0);

    
    public MutableLiveData<ProductDetail> f10532e = new MutableLiveData<>();

    /* renamed from: f */
    public MutableLiveData<List<Product>> f10533f;

    /* renamed from: b.f.a.m.x$a */
    public class a extends TypeToken<ProductDetail> {
        public a(ProductsProvider productsProvider) {
        }
    }

    /* renamed from: b.f.a.m.x$b */
    public class b extends TypeToken<List<Product>> {
        public b(ProductsProvider productsProvider) {
        }
    }


    public void m5663a(Context context, int i, boolean z) {
        if (!z) {
            this.f10533f = new MutableLiveData<>();
            API_PROVIDER APIS = new API_PROVIDER(context, "get_products", this);
            StringBuilder m3163a = CustomString.format("e6/products?isRecommended=true&isFill=true&perPage=");
            m3163a.append(Status.f8808C);
            m3163a.append("&productId=");
            m3163a.append(i);
            APIS.m5406a(m3163a.toString());
            return;
        }
        this.f10532e = new MutableLiveData<>();
        API_PROVIDER APIS2 = new API_PROVIDER(context, "get_product_detail", this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        APIS2.get("e6/products/" + i, jSONObject);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e

    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            if (str2.equals("get_product_detail")) {
                this.f10532e.setValue( new Gson().fromJson(str, new a(this).getType()));
            } else if (str2.equals("get_products")) {
                this.f10533f.setValue( new Gson().fromJson(new JSONObject(str).getString("data"), new b(this).getType()));
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }
}
