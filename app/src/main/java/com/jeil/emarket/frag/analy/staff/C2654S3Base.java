package com.jeil.emarket.frag.analy.staff;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.adapters.shipping.ProductAdapter1;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.interf.InterfaceString;
import com.jeil.emarket.model.vendor.Product;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.d.b.s3 */

public class C2654S3Base extends BaseFragment implements BaseInterface, BaseInterface2 {

    /* renamed from: o0 */
    public ProductAdapter1 f9960o0;

    /* renamed from: s0 */
    public LinearLayout f9964s0;

    /* renamed from: v0 */
    public InterfaceString f9967v0;

    /* renamed from: w0 */
    public java.lang.String f9968w0;

    /* renamed from: x0 */
    public FragmentPagerAdaperEx f9969x0;

    /* renamed from: p0 */
    public JSONObject f9961p0 = new JSONObject();

    /* renamed from: q0 */
    public java.lang.String f9962q0 = Status.f8824o[0];

    /* renamed from: r0 */
    public java.lang.String f9963r0 = Status.f8826q[0];

    /* renamed from: t0 */
    public boolean f9965t0 = true;

    /* renamed from: u0 */
    public boolean f9966u0 = false;

    /* renamed from: b.f.a.g.d.b.s3$a */
    public class a extends TypeToken<List<Product>> {
        public a(C2654S3Base c2654s3) {
        }
    }

    public C2654S3Base() {
    }

    public C2654S3Base(BaseActivity activityC1391g1, java.lang.String str, InterfaceString interfaceString, FragmentPagerAdaperEx fragmentPagerAdaperEx) {
        this.f9968w0 = str;
        try {
            this.f9961p0.put("status", str);
            this.f9961p0.put("search", "");
            this.f9961p0.put("category", "");
            this.f9961p0.put("type", "");
            this.f9961p0.put("noStockOnly", false);
            this.f9961p0.put("withCount", true);
            this.jsonObject.put("filter", this.f9961p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("sortBy", this.f9962q0.equals("updatedAt") ? "product.created_at" : this.f9962q0);
            this.jsonObject.put("sortDir", this.f9963r0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9967v0 = interfaceString;
        this.baseActivity = activityC1391g1;
        this.f9969x0 = fragmentPagerAdaperEx;
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            //this.f9960o0 = new ProductAdapter1((BaseActivity) getActivity(), (C2649r3) m2461E(), this.f9968w0, this);
            this.xRecyclerView.setAdapter(this.f9960o0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            XRecyclerView xRecyclerView = this.xRecyclerView;
            xRecyclerView.f12375Z0 = this.f9965t0;
            xRecyclerView.f12377b1 = true;
            if (this.f9964s0 == null) {
                this.f9964s0 = new LinearLayout(this.baseActivity);
                this.f9964s0.setPadding(Util.dp2px((Context) this.baseActivity, 8), 0, 0, 0);
                final ActionLink actionLink = new ActionLink(this.baseActivity, null);
                actionLink.setmTextView(Util.getIdentifier(this.baseActivity, this.f9962q0 + "_" + this.f9963r0, ""));
                actionLink.m6810a(1, 11.0f);
                actionLink.setvImageView(R.drawable.ic_angle_down);
                actionLink.setvImageViewColor(R.color.dark);
                actionLink.setImageSize(Util.dp2px((Context) this.baseActivity, 15));
                actionLink.setBackgroundResource(R.drawable.bg_primary_round20);
                actionLink.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                actionLink.setDistance(Util.dp2px((Context) this.baseActivity, 4));
                actionLink.setDefaultRippleAlpha(10);
                actionLink.setRippleRoundedCorners(Util.dp2px((Context) this.baseActivity, 20));
                actionLink.setRippleOverlay(true);
                actionLink.setPadding(Util.dp2px((Context) this.baseActivity, 13), Util.dp2px((Context) this.baseActivity, 6), Util.dp2px((Context) this.baseActivity, 10), Util.dp2px((Context) this.baseActivity, 6));
                actionLink.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.b.t1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C2654S3Base.this.m5325a(actionLink, view);
                    }
                });
                this.f9964s0.addView(actionLink);
            }
            this.xRecyclerView.addView(this.f9964s0);
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_products);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.empty_shop);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.header).getMeasuredHeight() + this.baseActivity.findViewById(R.id.ll_header_tabs).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9965t0) {
            ArrayList arrayList = new ArrayList();
            Product product = new Product();
            product.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(product);
            }
            this.f9960o0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("filter", this.f9961p0.toString());
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("sortBy", this.f9962q0.equals("updatedAt") ? "product.created_at" : this.f9962q0);
            this.jsonObject.put("sortDir", this.f9963r0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_vendor_products", this).get("e7/products", this.jsonObject);
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: W0 */
    public void mo4891W0() {
        super.mo4891W0();
        if (SimpleVM.f8836d || this.f9148l0) {
            //this.xRecyclerView.m2806j(0);
        } else {
            this.f9137a0 = 0;
        }
        if (this.f9965t0) {
            ArrayList arrayList = new ArrayList();
            Product product = new Product();
            product.type = "shimmer";
            for (int i = 0; i < 6; i++) {
                arrayList.add(product);
            }
            ProductAdapter1 c1916d2 = this.f9960o0;
            c1916d2.arrayList = arrayList;
            c1916d2.notifyDataSetChanged();
        } else {
            ProductAdapter1 c1916d22 = this.f9960o0;
            c1916d22.arrayList = new ArrayList();
            c1916d22.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
            this.xRecyclerView.f12360K0.setVisibility(View.GONE);
        }
        try {
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
            this.jsonObject.put("sortBy", this.f9962q0.equals("updatedAt") ? "product.created_at" : this.f9962q0);
            this.jsonObject.put("sortDir", this.f9963r0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_vendor_products", this).get("e7/products", this.jsonObject);
    }

    /* renamed from: Z0 */
    public ProductAdapter1 m5323Z0() {
        return this.f9960o0;
    }

    
    public  void m5324a(DialogInterface dialogInterface) {
        this.f9966u0 = false;
    }

    
    public  void m5325a(final ActionLink actionLink, View view) {
        if (this.f9966u0) {
            return;
        }
        java.lang.String[] strArr = Status.f8824o;
        java.lang.String[] strArr2 = new java.lang.String[strArr.length];
        int[] iArr = new int[strArr.length];
        int i = 0;
        while (true) {
            java.lang.String[] strArr3 = Status.f8824o;
            if (i >= strArr3.length) {
                final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, strArr2, iArr);
                this.f9966u0 = true;
                baseDialog2.f8209G = getResources().getColor(BaseActivity.color);
                baseDialog2.show();
                baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.d.b.u1
                    @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b
                    
                    public final void mo4264a(View view2, int i2) {
                        C2654S3Base.this.m5326a(actionLink, baseDialog2, view2, i2);
                    }
                };
                baseDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.d.b.v1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        C2654S3Base.this.m5324a(dialogInterface);
                    }
                });
                return;
            }
            strArr2[i] = Util.getIdentifier(this.baseActivity, strArr3[i], "");
            if (!this.f9962q0.equals(Status.f8824o[i])) {
                iArr[i] = 0;
            } else if (this.f9963r0.equals("asc")) {
                iArr[i] = R.drawable.ic_arrow_up;
            } else {
                iArr[i] = R.drawable.ic_arrow_down;
            }
            i++;
        }
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c
    
    public boolean mo4808a(int i, java.lang.String str, int i2) {
        for (int i3 = 0; i3 < Math.min(Status.state3.length, this.f9969x0.getCount()); i3++) {
            if (((C2654S3Base) this.f9969x0.get(i3)).m5323Z0() != null) {
                ((C2654S3Base) this.f9969x0.get(i3)).mo4891W0();
            }
        }
        return true;
    }

    
    public void m5327b(java.lang.String str) throws JSONException {
        this.f9137a0 = 0;
        this.f9961p0.put("category", str);
        this.jsonObject.put("filter", this.f9961p0.toString());
    }

    
    public void m5328c(java.lang.String str) throws JSONException {
        this.f9137a0 = 0;
        this.f9961p0.put("search", str);
        this.jsonObject.put("filter", this.f9961p0.toString());
    }

    
    public void m5329d(java.lang.String str) throws JSONException {
        this.f9137a0 = 0;
        this.f9961p0.put("type", str);
        this.jsonObject.put("filter", this.f9961p0.toString());
    }

   
    public void m5330j(boolean z) throws JSONException {
        this.f9137a0 = 0;
        this.f9961p0.put("noStockOnly", z);
        this.jsonObject.put("filter", this.f9961p0.toString());
    }

    
    public  void m5326a(ActionLink actionLink, BaseDialog2 baseDialog2, View view, int i) {
        java.lang.String str;
        if (Status.f8824o[i].equals(this.f9962q0)) {
            str = this.f9963r0.equals(Status.f8826q[0]) ? Status.f8826q[1] : Status.f8826q[0];
        } else {
            this.f9962q0 = Status.f8824o[i];
            str = Status.f8826q[0];
        }
        this.f9963r0 = str;
        actionLink.setmTextView(Util.getIdentifier(this.baseActivity, this.f9962q0 + "_" + this.f9963r0, ""));
        mo4891W0();
        baseDialog2.startAni();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_vendor_products")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("totalRowCount");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9960o0.addAll(list);
            } else {
                if (this.f9137a0 == 0) {
                    this.f9960o0.addAll(list);
                } else if (this.f9965t0) {
                    this.f9960o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
                } else {
                    this.f9960o0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
                }
                if (list.size() == 0) {
                    this.xRecyclerView.setNoMore(true);
                }
                if (this.f9960o0.getItemCount() == 0) {
                    this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
                }
            }
            if (!jSONObject.has("count") || this.f9967v0 == null) {
                return;
            }
            this.f9967v0.mo4265a(jSONObject.getString("count"));
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
            Util.toast(this.baseActivity, R.string.server_error, "error");
            this.baseActivity.finish();
        }
    }
}
