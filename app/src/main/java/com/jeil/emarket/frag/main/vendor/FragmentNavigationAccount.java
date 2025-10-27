package com.jeil.emarket.frag.main.vendor;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jeil.emarket.R;
import com.jeil.emarket.activities.account.AddressActivity;
import com.jeil.emarket.activities.account.ConnectionInfoActivity;
import com.jeil.emarket.activities.account.OrderActivity;
import com.jeil.emarket.activities.account.ProfileActivity;
import com.jeil.emarket.activities.account.RecentActivity;
import com.jeil.emarket.activities.account.ShippingActivity;
import com.jeil.emarket.activities.auth.LoginActivity;
import com.jeil.emarket.activities.auth.VendorLoginActivity;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.intro.HelpActivity;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.activities.intro.SettingActivity;
import com.jeil.emarket.activities.point.PointActivity;
import com.jeil.emarket.activities.product.WishlistActivity;
import com.jeil.emarket.activities.review.ReviewActivity;
import com.jeil.emarket.activities.seller.MainActivityForVendor;
import com.jeil.emarket.activities.ticket.list.TicketUserListActivity;
import com.jeil.emarket.adapters.refund.ComponentAct;
import com.jeil.emarket.adapters.refund.OrderAct;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.AccountNavItem;
import com.jeil.emarket.components.CircleImageView;
import com.jeil.emarket.components.itemdecor.ItemDecoration2;
import com.jeil.emarket.components.itemdecor.ItemDecoration3;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.dialog.dialog.dialog.DialogC2001j;
import com.jeil.emarket.dialog.dialog.dialog.DialogError;
import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.model.customer.Avatar;
import com.jeil.emarket.model.customer.Newsletter;
import com.jeil.emarket.model.customer.OrderStatus;
import com.jeil.emarket.model.customer.User;
import com.jeil.emarket.viewmodel.BottomVM;
import com.jeil.emarket.viewmodel.CheckI;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;

import java.util.ArrayList;
import java.util.List;

/* renamed from: b.f.a.g.b.a.y0 */

public class FragmentNavigationAccount extends Fragment {

    /* renamed from: f0 */
    public static List<Avatar> f9276f0 = new ArrayList();

    /* renamed from: c0 */
    public int f9279c0;

    /* renamed from: a0 */
    public ImageDialog2 f9277a0 = null;

    /* renamed from: b0 */
    public boolean f9278b0 = false;

    /* renamed from: d0 */
    public boolean f9280d0 = false;

    /* renamed from: e0 */
    public boolean f9281e0 = false;

    /* renamed from: b.f.a.g.b.a.y0$a */
    public class a extends RecyclerView.OnScrollListener {


        public final  View f9282a;

        public a(FragmentNavigationAccount fragmentNavigationAccount, View view) {
            this.f9282a = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0631s

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (recyclerView.canScrollVertically(1)) {
                this.f9282a.findViewById(R.id.ll_bottom_gradient).setVisibility(View.VISIBLE);
            } else {
                this.f9282a.findViewById(R.id.ll_bottom_gradient).setVisibility(View.GONE);
            }
            if (recyclerView.canScrollVertically(-1)) {
                this.f9282a.findViewById(R.id.ll_top_gradient).setVisibility(View.VISIBLE);
            } else {
                this.f9282a.findViewById(R.id.ll_top_gradient).setVisibility(View.GONE);
            }
        }
    }


    public static  void m4924a(View view, Integer num) {
        if (num.intValue() != -1) {
            ((AccountNavItem) view.findViewById(R.id.ani_ticket)).m6809a(num.intValue() > 0);
        }
    }

    /* renamed from: S0 */
    public  void m4926S0() {
        ((BaseActivity) getActivity()).drawerLayout.m1434b();
    }

    /* renamed from: T0 */
    public void m4927T0() {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (this.f9281e0) {
                return;
            }
            this.f9281e0 = true;
            final BaseActivity activityC1391g1 = (BaseActivity) getActivity();
            final DialogError dialogError = new DialogError(activityC1391g1);
            dialogError.f8246v = activityC1391g1.getResources().getString(R.string.logout_confirm);
            dialogError.m4584a(activityC1391g1.getResources().getString(R.string.cancel), activityC1391g1.getResources().getString(R.string.ok));
            dialogError.f8254e = 0.8f;
            dialogError.show();
            dialogError.m4585a(new DialogCancel(dialogError), new DialogInterface() { // from class: b.f.a.g.b.a.s
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1990a

                public final void cancel() {
                    FragmentNavigationAccount.this.m4935a(activityC1391g1, dialogError);
                }
            });
            dialogError.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.a.n
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    FragmentNavigationAccount.this.m4931a(dialogInterface);
                }
            });
        }
    }

    /* renamed from: U0 */
    public void m4928U0() {
        ImageDialog2 imageDialog2 = this.f9277a0;
        if (imageDialog2 != null) {
            imageDialog2.show();
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_change_avatar, (ViewGroup) null);
        final ComponentAct componentAct = new ComponentAct((BaseActivity) getActivity());
        if (f9276f0.size() < this.f9279c0 - 1) {
            this.f9279c0 = 0;
        }
        Avatar avatar = f9276f0.get(this.f9279c0);
        avatar.cur = true;
        f9276f0.set(this.f9279c0, avatar);
        componentAct.addAll((List) f9276f0);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_show_avatar);
        recyclerView.setLayoutManager(new GridLayoutManager((Context) getActivity(), 4, 1, false));
        recyclerView.setAdapter(componentAct);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new ItemDecoration3(4, Util.dp2px(getContext(), 8), false));
        recyclerView.addOnScrollListener(new a(this, inflate));
        inflate.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentNavigationAccount.this.m4936a(componentAct, view);
            }
        });
        inflate.findViewById(R.id.cb_cancel).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentNavigationAccount.this.m4953g(view);
            }
        });
        this.f9277a0 = Util.m211a((Activity) getActivity(), inflate);
        this.f9277a0.show();
        this.f9277a0.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.a.v
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                FragmentNavigationAccount.this.m4940b(dialogInterface);
            }
        });
    }

    /* renamed from: V0 */
    public void m4929V0() {
        if (UserVM.userMutableLiveData.getValue() != null) {
            m4941b(new Intent(getActivity().getApplicationContext(), OrderActivity.class));
            return;
        }
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.fragment_account_nav, viewGroup, false);
        TicketCategoryListVM.f10284j.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.a.b
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentNavigationAccount.m4924a(inflate, (Integer) obj);
            }
        });
        ((NestedScrollView) inflate.findViewById(R.id.nsv_main)).smoothScrollBy(0, 0, 300);
        return inflate;
    }


    public  void m4931a(android.content.DialogInterface dialogInterface) {
        this.f9281e0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"DefaultLocale"})

    public void onViewCreated(final View view, Bundle bundle) {
        final BaseActivity activityC1391g1 = (BaseActivity) getActivity();
        m4942b(view, UserVM.userMutableLiveData.getValue());
        UserVM.userMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.a.g
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentNavigationAccount.this.m4942b(view, (User) obj);
            }
        });
        view.findViewById(R.id.llc_user_login_section).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4958j(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_address).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4959k(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_shipping_address).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4960l(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_orders).setVisibility(View.GONE);
        view.findViewById(R.id.ani_orders).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4949e(view2);
            }
        });
        view.findViewById(R.id.ani_orders_list).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4951f(view2);
            }
        });
        view.findViewById(R.id.ani_news).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4961m(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_wishlist).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4962n(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_review).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4934a(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.mrl_vendor_link).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4943b(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_help).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4946c(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_setting).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4948d(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_connection_info).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4950e(activityC1391g1, view2);
            }
        });
        f9276f0.clear();
        for (int i = 0; i < Status.f8819j; i++) {
            Avatar avatar = new Avatar();
            avatar.url = java.lang.String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(i));
            f9276f0.add(avatar);
        }
        view.findViewById(R.id.iv_avatar).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4952f(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_recent).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4954g(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_ticket).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4955h(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_profile).setVisibility(View.GONE);
        view.findViewById(R.id.ani_profile).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4956i(activityC1391g1, view2);
            }
        });
        view.findViewById(R.id.ani_exit).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4945c(view2);
            }
        });
        view.findViewById(R.id.mrl_logout).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4947d(view2);
            }
        });
    }


    public  void m4932a(final View view, final OrderAct orderAct, View view2) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            
            startActivity(intent);
            return;
        }
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view.findViewById(R.id.iv_refresh), "rotation", 0.0f, 180.0f, 360.0f);
        if (!this.f9280d0) {
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.start();
            UserVM.m5539b((BaseActivity) getActivity(), true);
            this.f9280d0 = true;
        }
        UserVM.listMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.a.z
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentNavigationAccount.this.m4930a(ofFloat, view, orderAct, (List) obj);
            }
        });
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void m4942b(final View view, User user) {
        LinearLayoutCompat.LayoutParams c0541a = new LinearLayoutCompat.LayoutParams(-1, Util.m169a(getContext(), 0.5f));
        if (user == null) {
            CustomString.m3167a(view, R.id.llc_user_login_section, 0, R.id.llc_user_info_section, 8);
            CustomString.m3167a(view, R.id.ani_exit, 8, R.id.ani_orders, 0);
            CustomString.m3167a(view, R.id.ani_profile, 8, R.id.llc_order_section, 8);
            CustomString.m3167a(view, R.id.v_user_border, 8, R.id.mrl_logout, 8);
            view.findViewById(R.id.mrl_vendor_link).setVisibility(View.GONE);
            c0541a.setMargins(Util.dp2px(getContext(), 8), 0, Util.dp2px(getContext(), 8), Util.dp2px(getContext(), 16));
            view.findViewById(R.id.v_order_border).setLayoutParams(c0541a);
            return;
        }
        CustomString.m3167a(view, R.id.llc_user_login_section, 8, R.id.llc_user_info_section, 0);
        CustomString.m3167a(view, R.id.ani_exit, 8, R.id.ani_profile, 0);
        CustomString.m3167a(view, R.id.ani_orders, 8, R.id.llc_order_section, 0);
        CustomString.m3167a(view, R.id.v_user_border, 0, R.id.mrl_logout, 0);
        c0541a.setMargins(Util.dp2px(getContext(), 8), Util.dp2px(getContext(), 20), Util.dp2px(getContext(), 8), Util.dp2px(getContext(), 15));
        view.findViewById(R.id.v_order_border).setLayoutParams(c0541a);
        final TextView textView = (TextView) view.findViewById(R.id.tv_user_id);
        final TextView textView2 = (TextView) view.findViewById(R.id.tv_user_name);
        final CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.iv_avatar);
        UserVM.userMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.a.c
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentNavigationAccount.this.m4939a(textView, textView2, view, circleImageView, (User) obj);
            }
        });
        UserVM.vendorUserMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.a.g0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                ((TextView) view.findViewById(R.id.tv_vendor_link)).setText(r2 != null ? R.string.vendor_page : R.string.login_as_vendor);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_order_status);
        final OrderAct orderAct = new OrderAct((BaseActivity) getActivity());
        ItemDecoration2 itemDecoration2 = new ItemDecoration2((BaseActivity.anInt2 * 3) / 4, 0, false);
        for (int i = 0; i < recyclerView.getItemDecorationCount(); i++) {
            recyclerView.m2799h(0);
        }
        recyclerView.addItemDecoration(itemDecoration2);
        view.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        recyclerView.setAdapter(orderAct);
        orderAct.f7093f = this.f9278b0;
        ArrayList arrayList = new ArrayList();
        for (java.lang.String str : new java.lang.String[]{"requested", "accepted", "shipping"}) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.status = str;
            orderStatus.count = 0;
            arrayList.add(orderStatus);
        }
        orderAct.arrayList = arrayList;
        orderAct.notifyDataSetChanged();
        UserVM.listMutableLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.a.k0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                OrderAct.this.addAll((List) obj);
            }
        });
        view.findViewById(R.id.mrl_refresh).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.a.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentNavigationAccount.this.m4932a(view, orderAct, view2);
            }
        });
    }


    public  void m4937a(final BaseDialog2 baseDialog2, View view, int i) {
        Intent intent;
        if (i != 0) {
            if (i == 1) {
                intent = new Intent(getActivity().getApplicationContext(), PointActivity.class);
            }
            Handler handler = new Handler();
            baseDialog2.getClass();
            handler.postDelayed(new Runnable() { // from class: b.f.a.g.b.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseDialog2.this.startAni();
                }
            }, Status.time);
        }
        intent = new Intent(getActivity().getApplicationContext(), ReviewActivity.class);
        intent.putExtra("page", "account");
        m4941b(intent);
        Handler handler2 = new Handler();
        baseDialog2.getClass();
        handler2.postDelayed(new Runnable() { // from class: b.f.a.g.b.a.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog2.this.startAni();
            }
        }, Status.time);
    }


    public  void m4938a(DialogC2001j dialogC2001j, Integer num) {
        if (num.intValue() == 200) {
            this.f9277a0.m4595e();
        }
        dialogC2001j.dismiss();
    }


    public  void m4939a(TextView textView, TextView textView2, View view, CircleImageView circleImageView, User user) {
        TextView textView3;
        int i;
        if (user != null) {
            textView.setText(user.name);
            textView2.setText(user.fullName + getResources().getString(R.string.comrade));
            Glide.m3288a(view).load(Util.m345e(java.lang.String.format("e4/uploads/avatars/avatar-%d.jpg", Integer.valueOf(user.avatar)))).load(view.getResources().getDrawable(R.drawable.man)).into((ImageView) circleImageView);
            this.f9279c0 = user.avatar;
            UserVM.m5539b((BaseActivity) getActivity(), false);
        }
        MutableLiveData<User> mutableLiveData = UserVM.userMutableLiveData;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || !UserVM.userMutableLiveData.getValue().role.contains("vendor")) {
            view.findViewById(R.id.mrl_vendor_link).setVisibility(View.GONE);
        } else {
            view.findViewById(R.id.mrl_vendor_link).setVisibility(View.VISIBLE);
            if (UserVM.vendorUserMutableLiveData.getValue() == null) {
                textView3 = (TextView) view.findViewById(R.id.tv_vendor_link);
                i = R.string.login_as_vendor;
            } else {
                textView3 = (TextView) view.findViewById(R.id.tv_vendor_link);
                i = R.string.vendor_page;
            }
            textView3.setText(i);
        }
        if (UserVM.userMutableLiveData.getValue() == null || UserVM.userMutableLiveData.getValue().delivererId <= 0) {
            view.findViewById(R.id.ani_shipping_address).setVisibility(View.GONE);
        } else {
            view.findViewById(R.id.ani_shipping_address).setVisibility(View.VISIBLE);
        }
    }

    
    public  void m4940b(android.content.DialogInterface dialogInterface) {
        this.f9281e0 = false;
    }

    
    public void m4941b(Intent intent) {
        startActivity(intent);
        if (!this.f9278b0 || ((BaseActivity) getActivity()).drawerLayout == null) {
            return;
        }
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.a.r
            @Override // java.lang.Runnable
            public final void run() {
                FragmentNavigationAccount.this.m4926S0();
            }
        }, Status.time);
    }

    
    public  void m4943b(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() != null) {
            m4941b(UserVM.vendorUserMutableLiveData.getValue() == null ? new Intent(activityC1391g1.getApplicationContext(), VendorLoginActivity.class) : new Intent(activityC1391g1.getApplicationContext(), MainActivityForVendor.class));
            return;
        }
        Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    
    public  void m4944c(android.content.DialogInterface dialogInterface) {
        this.f9281e0 = false;
    }

    
    public  void m4945c(View view) {
        m4927T0();
    }

    
    public  void m4946c(BaseActivity activityC1391g1, View view) {
        m4941b(new Intent(activityC1391g1.getApplicationContext(), HelpActivity.class));
    }

    
    public  void m4947d(View view) {
        m4927T0();
    }

    
    public  void m4948d(BaseActivity activityC1391g1, View view) {
        m4941b(new Intent(activityC1391g1.getApplicationContext(), SettingActivity.class));
    }

    
    public  void m4949e(View view) {
        m4929V0();
    }

    
    public  void m4950e(BaseActivity activityC1391g1, View view) {
        m4941b(new Intent(activityC1391g1.getApplicationContext(), ConnectionInfoActivity.class));
    }

    /* renamed from: f */
    public  void m4951f(View view) {
        m4929V0();
    }

    /* renamed from: f */
    public  void m4952f(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (this.f9281e0) {
                return;
            }
            this.f9281e0 = true;
            m4928U0();
        }
    }

    /* renamed from: g */
    public  void m4953g(View view) {
        this.f9277a0.dismiss();
    }

    /* renamed from: g */
    public  void m4954g(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() != null) {
            m4941b(new Intent(activityC1391g1.getApplicationContext(), RecentActivity.class));
            return;
        }
        Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /* renamed from: h */
    public  void m4955h(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() != null) {
            activityC1391g1.startActivity(new Intent(activityC1391g1.getApplicationContext(), TicketUserListActivity.class));
            return;
        }
        Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    
    public  void m4956i(BaseActivity activityC1391g1, View view) {
        getActivity().startActivity(new Intent(activityC1391g1.getApplicationContext(), ProfileActivity.class));
    }

    
    public void m4957i(boolean z) {
        this.f9278b0 = z;
    }

   
    public  void m4958j(BaseActivity activityC1391g1, View view) {
        Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    
    public  void m4959k(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() != null) {
            m4941b(new Intent(activityC1391g1.getApplicationContext(), AddressActivity.class));
            return;
        }
        Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /* renamed from: l */
    public  void m4960l(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() != null) {
            m4941b(new Intent(activityC1391g1.getApplicationContext(), ShippingActivity.class));
            return;
        }
        Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /* renamed from: m */
    public  void m4961m(final BaseActivity activityC1391g1, View view) {
        List<Newsletter> getValue = BottomVM.newsletterListLiveData.getValue();
        if (getValue == null || getValue.size() <= 0) {
            Util.toast(activityC1391g1, getResources().getString(R.string.empty_news_notice), "error", 0, 0);
            return;
        }
        if (this.f9278b0 && activityC1391g1.drawerLayout != null) {
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.a.i
                @Override // java.lang.Runnable
                public final void run() {
                    //activityC1391g1.drawerLayout.m1434b();
                }
            }, 0L);
        }
        activityC1391g1.m4298a(getValue);
    }

    /* renamed from: n */
    public  void m4962n(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() != null) {
            m4941b(new Intent(activityC1391g1.getApplicationContext(), WishlistActivity.class));
            return;
        }
        Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public  void m4935a(BaseActivity activityC1391g1, DialogError dialogError) {
        UserVM.m5540c();
        if (activityC1391g1 instanceof BaseActivity) {
            Intent intent = new Intent(activityC1391g1, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        Util.toast(activityC1391g1, activityC1391g1.getString(R.string.action_logout), "default", 0, 0);
        dialogError.dismiss();
        activityC1391g1.m4309v();
    }


    public  void m4930a(ObjectAnimator objectAnimator, View view, OrderAct orderAct, List list) {
        if (!this.f9280d0 || list == null || list.size() == 0) {
            return;
        }
        this.f9280d0 = false;
        objectAnimator.cancel();
        view.findViewById(R.id.iv_refresh).setRotation(0.0f);
        Util.m329c(getActivity(), R.string.order_history_in_refresh);
        orderAct.arrayList = list;
        orderAct.notifyDataSetChanged();
    }


    public  void m4934a(BaseActivity activityC1391g1, View view) {
        if (UserVM.userMutableLiveData.getValue() == null) {
            Intent intent = new Intent(activityC1391g1.getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if (this.f9281e0) {
                return;
            }
            this.f9281e0 = true;
            final BaseDialog2 baseDialog2 = new BaseDialog2(getContext(), new java.lang.String[]{getResources().getString(R.string.review_list), getResources().getString(R.string.point_list)});
            baseDialog2.show();
            baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.g.b.a.e
                @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

                public final void mo4264a(View view2, int i) {
                    FragmentNavigationAccount.this.m4937a(baseDialog2, view2, i);
                }
            };
            baseDialog2.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: b.f.a.g.b.a.h0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    FragmentNavigationAccount.this.m4944c(dialogInterface);
                }
            });
        }
    }


    public  void m4936a(ComponentAct componentAct, View view) {
        FragmentActivity getActivity = getActivity();
        int i = componentAct.f7075f;
        boolean booleanValue = UserVM.userMutableLiveData.getValue() != null ? UserVM.userMutableLiveData.getValue().isMerged.booleanValue() : false;
        UserVM.f10342s = new MutableLiveData<>();
        API_PROVIDER.checkInternet(getActivity, new CheckI(getActivity, i, booleanValue));
        final DialogC2001j dialogC2001j = new DialogC2001j(getContext());
        dialogC2001j.show();
        UserVM.f10342s.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.a.h
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentNavigationAccount.this.m4938a(dialogC2001j, (Integer) obj);
            }
        });
    }
}
