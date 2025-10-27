package com.jeil.emarket.frag.main.vendors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.shipping.VendorAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.progress.lin.LinearLayoutEx;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.DialogCategory;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.frag.base.BaseFragment;
import com.jeil.emarket.interf.BaseInterface;
import com.jeil.emarket.model.vendor.Vendor;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.b.e.u */

public class FragmentVendors extends BaseFragment implements BaseInterface {

    /* renamed from: o0 */
    public boolean f9570o0 = true;

    /* renamed from: p0 */
    public java.lang.String f9571p0 = Status.f8827r[0];

    /* renamed from: q0 */
    public java.lang.String f9572q0 = Status.f8826q[1];

    /* renamed from: r0 */
    public java.lang.String f9573r0;

    /* renamed from: s0 */
    public java.lang.String f9574s0;

    /* renamed from: t0 */
    public java.lang.String f9575t0;

    /* renamed from: u0 */
    public Boolean f9576u0;

    /* renamed from: v0 */
    public VendorAdapter f9577v0;

    /* renamed from: w0 */
    public DialogCategory f9578w0;

    /* renamed from: b.f.a.g.b.e.u$a */
    public class a extends TypeToken<List<Vendor>> {
        public a(FragmentVendors fragmentVendors) {
        }
    }

    public FragmentVendors(BaseActivity activityC1391g1) {
        this.baseActivity = activityC1391g1;
        try {
            this.jsonObject.put("page", this.f9137a0);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: S0 */
    public void showBootomMenu() {
        super.showBootomMenu();
        if (this.xRecyclerView != null) {
            getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) ;
            this.f9577v0 = new VendorAdapter((BaseActivity) getActivity());
            this.xRecyclerView.setAdapter(this.f9577v0);
            this.xRecyclerView.setLayoutManager(linearLayoutManager);
            this.xRecyclerView.addItemDecoration(new ItemDecoration2(BaseActivity.anInt2, -1, true, true));
            this.xRecyclerView.f12375Z0 = this.f9570o0;
            LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.baseActivity);
            LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, -2);
            c0541a.setMargins(Util.dp2px((Context) this.baseActivity, 7), Util.dp2px((Context) this.baseActivity, -6), Util.dp2px((Context) this.baseActivity, 0), Util.dp2px((Context) this.baseActivity, -6));
            linearLayoutCompat.setLayoutParams(c0541a);
            BaseActivity activityC1391g1 = this.baseActivity;
            LinearLayout linearLayout = new LinearLayout(activityC1391g1);
            linearLayout.setPadding(0, Util.dp2px((Context) activityC1391g1, 3), 0, Util.dp2px((Context) activityC1391g1, 3));
            final ActionLink actionLink = new ActionLink(this.baseActivity, null);
            BaseActivity activityC1391g12 = this.baseActivity;
            StringBuilder m3163a = CustomString.format("sort_");
            m3163a.append(this.f9571p0);
            actionLink.setmTextView(Util.getIdentifier(activityC1391g12, m3163a.toString(), ""));
            actionLink.m6810a(1, 11.0f);
            actionLink.setvImageView(R.drawable.ic_angle_down);
            actionLink.setvImageViewColor(R.color.dark);
            actionLink.setImageSize(Util.dp2px((Context) activityC1391g1, 15));
            actionLink.setBackgroundResource(R.drawable.bg_primary_round20);
            actionLink.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
            actionLink.setDistance(Util.dp2px((Context) activityC1391g1, 5));
            actionLink.setDefaultRippleAlpha(10);
            actionLink.setRippleRoundedCorners(Util.dp2px((Context) activityC1391g1, 20));
            actionLink.setRippleOverlay(true);
            actionLink.setPadding(Util.dp2px((Context) activityC1391g1, 13), Util.dp2px((Context) activityC1391g1, 6), Util.dp2px((Context) activityC1391g1, 13), Util.dp2px((Context) activityC1391g1, 6));
            actionLink.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentVendors.this.m5116a(actionLink, view);
                }
            });
            linearLayout.addView(actionLink);
            LinearLayoutCompat.LayoutParams c0541a2 = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            c0541a2.setMargins(Util.dp2px((Context) activityC1391g1, 3), Util.dp2px((Context) activityC1391g1, 3), Util.dp2px((Context) activityC1391g1, 3), Util.dp2px((Context) activityC1391g1, 3));
            linearLayoutCompat.addView(linearLayout, c0541a2);
            this.xRecyclerView.addView(linearLayoutCompat);
            this.baseActivity.findViewById(R.id.mrl_header_filter).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.e.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentVendors.this.m5118k(view);
                }
            });
            View inflate = getLayoutInflater().inflate(R.layout.layout_empty, (ViewGroup) null, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            ((AppCompatImageView) inflate.findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.ic_vendor);
            ((TextView) inflate.findViewById(R.id.tv_empty_title)).setText(R.string.nomore_loading);
            this.xRecyclerView.setEmptyView(inflate);
            this.xRecyclerView.header = this.baseActivity.findViewById(R.id.header).getMeasuredHeight() + ((int) getResources().getDimension(R.dimen.bottom_height));
        }
    }

    @Override // p078b.p159f.p160a.p231g.p232a.AbstractC2284k
    /* renamed from: V0 */
    public void mo4890V0() {
        super.mo4890V0();
        if (this.f9570o0) {
            ArrayList arrayList = new ArrayList();
            Vendor vendor = new Vendor();
            vendor.type = "shimmer";
            for (int i = 0; i < 20; i++) {
                arrayList.add(vendor);
            }
            this.f9577v0.addModList((List) arrayList, this.xRecyclerView.arrayList.size() + 1, false);
        }
        try {
            this.jsonObject.put("name", this.f9573r0);
            this.jsonObject.put("category", this.f9575t0);
            this.jsonObject.put("is_featured", this.f9576u0);
            this.jsonObject.put("currency", this.f9574s0);
            this.jsonObject.put("sortBy", this.f9571p0);
            this.jsonObject.put("sortDir", this.f9572q0);
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getContext(), "get_vendors", this).get("e6/vendors", this.jsonObject);
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
        if (this.f9570o0) {
            ArrayList arrayList = new ArrayList();
            Vendor vendor = new Vendor();
            vendor.type = "shimmer";
            for (int i = 0; i < 20; i++) {
                arrayList.add(vendor);
            }
            VendorAdapter c1912c2 = this.f9577v0;
            c1912c2.arrayList = arrayList;
            c1912c2.notifyDataSetChanged();
        } else {
            VendorAdapter c1912c22 = this.f9577v0;
            c1912c22.arrayList = new ArrayList();
            c1912c22.notifyDataSetChanged();
            View view = this.xRecyclerView.view;
            if (view instanceof LinearLayoutEx) {
                ((LinearLayoutEx) view).setState(0);
            }
        }
        this.jsonObject = new JSONObject();
        try {
            this.jsonObject.put("name", this.f9573r0);
            this.jsonObject.put("category", this.f9575t0);
            this.jsonObject.put("isFeatured", this.f9576u0);
            this.jsonObject.put("currency", this.f9574s0);
            this.jsonObject.put("sortBy", this.f9571p0);
            this.jsonObject.put("sortDir", this.f9572q0);
            this.jsonObject.put("page", this.f9137a0 + 1);
            this.jsonObject.put("perPage", 20);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new API_PROVIDER(getActivity(), "get_vendors", this).get("e6/vendors", this.jsonObject);
    }

    
    public  void m5115a(DialogInterface dialogInterface) {
        DialogCategory dialogC2209j3 = this.f9578w0;
        if (dialogC2209j3.f8991C) {
            dialogC2209j3.f8991C = false;
            this.f9575t0 = dialogC2209j3.f8989A;
            this.f9574s0 = dialogC2209j3.f8998z;
            this.f9576u0 = dialogC2209j3.f8990B;
            this.f9573r0 = dialogC2209j3.f8997y;
            mo4891W0();
        }
    }

    
    public  void m5117a(ActionLink actionLink, BaseDialog2 baseDialog2, View view, int i) {
        java.lang.String str;
        if (Status.f8827r[i].equals(this.f9571p0)) {
            str = this.f9572q0.equals(Status.f8826q[0]) ? Status.f8826q[1] : Status.f8826q[0];
        } else {
            this.f9571p0 = Status.f8827r[i];
            str = Status.f8826q[0];
        }
        this.f9572q0 = str;
        actionLink.setmTextView(Util.getIdentifier(this.baseActivity, this.f9571p0 + "_" + this.f9572q0, ""));
        mo4891W0();
        baseDialog2.startAni();
    }

    
    public  void m5118k(View view) {
        if (this.f9578w0 == null) {
            this.f9578w0 = new DialogCategory(this.baseActivity);
            this.f9578w0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.e.p
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FragmentVendors.this.m5115a(dialogInterface);
                }
            });
        }
        DialogCategory dialogC2209j3 = this.f9578w0;
        dialogC2209j3.f8255f = 1.0f;
        dialogC2209j3.f8254e = 0.7f;
        dialogC2209j3.show();
    }

    
    public  void m5116a(final ActionLink actionLink, View view) {
        java.lang.String[] strArr = Status.f8827r;
        java.lang.String[] strArr2 = new java.lang.String[strArr.length];
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < Status.f8827r.length; i++) {
            BaseActivity activityC1391g1 = this.baseActivity;
            StringBuilder m3163a = CustomString.format("sort_");
            m3163a.append(Status.f8827r[i]);
            strArr2[i] = Util.getIdentifier(activityC1391g1, m3163a.toString(), "");
            if (!this.f9571p0.equals(Status.f8827r[i])) {
                iArr[i] = 0;
            } else if (this.f9572q0.equals("asc")) {
                iArr[i] = R.drawable.ic_arrow_up;
            } else {
                iArr[i] = R.drawable.ic_arrow_down;
            }
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(this.baseActivity, strArr2, iArr);
        baseDialog2.f8209G = getResources().getColor(BaseActivity.color);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.b.e.o
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b
            
            public final void mo4264a(View view2, int i2) {
                FragmentVendors.this.m5117a(actionLink, baseDialog2, view2, i2);
            }
        };
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2711e
    
    public void mo4478a(java.lang.String str, java.lang.String str2, int i, Context context) {
        if (str == null || str.length() <= 0 || !str2.equals("get_vendors")) {
            return;
        }
        m4889U0();
        try {
            JSONObject jSONObject = new JSONObject(str);
            List list = (List) new Gson().fromJson(jSONObject.getString("rows"), new a(this).getType());
            this.f9138b0 = jSONObject.getInt("count");
            if (SimpleVM.f8836d) {
                m4892X0();
                this.f9577v0.addAll(list);
                return;
            }
            if (this.f9137a0 == 0) {
                this.f9577v0.addAll(list);
            } else if (this.f9570o0) {
                this.f9577v0.addModList(list, this.xRecyclerView.arrayList.size() + 1, true);
            } else {
                this.f9577v0.addModList(list, this.xRecyclerView.arrayList.size() + 1, false);
            }
            if (list.size() == 0) {
                this.xRecyclerView.setNoMore(true);
            }
            if (this.f9577v0.getItemCount() == 0) {
                this.xRecyclerView.f12360K0.setVisibility(View.VISIBLE);
            }
        } catch (Exception e2) {
            CustomString.m3173a(str2, ": Gson Exception is ", e2);
        }
    }
}
