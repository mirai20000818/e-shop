package com.jeil.emarket.frag.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.intro.SettingActivity;
import com.jeil.emarket.components.dialog.widget.popup.BubblePopup;
import com.jeil.emarket.components.edittext.EditText;
import com.jeil.emarket.components.xrecyclerview.XRecyclerView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.frag.main.vendor.SearchFragment;
import com.jeil.emarket.viewmodel.SimpleVM;

import org.json.JSONObject;

import java.util.Objects;

/* renamed from: b.f.a.g.a.k */

public abstract class BaseFragment extends Fragment {

    /* renamed from: d0 */
    public XRecyclerView xRecyclerView;

    /* renamed from: f0 */
    public CoordinatorLayout coordinatorLayout;

    /* renamed from: g0 */
    public NestedScrollView nsv_main;

    /* renamed from: i0 */
    public View.OnClickListener onClickListener;

    /* renamed from: j0 */
    public BaseActivity baseActivity;

    /* renamed from: k0 */
    public View view;

    /* renamed from: n0 */
    public BubblePopup bubblePopup;

    /* renamed from: a0 */
    public int f9137a0 = 0;

    /* renamed from: b0 */
    public int f9138b0 = 0;

    /* renamed from: c0 */
    public boolean f9139c0 = false;

    /* renamed from: e0 */
    public JSONObject jsonObject = new JSONObject();

    /* renamed from: h0 */
    public boolean f9144h0 = false;

    /* renamed from: l0 */
    public boolean f9148l0 = false;

    /* renamed from: m0 */
    public boolean f9149m0 = false;



   
    public static  void m4886j(View view) {
    }

    @SuppressLint({"InflateParams"})
    /* renamed from: S0 */
    public void showBootomMenu() {
        XRecyclerView xRecyclerView = this.xRecyclerView;
        if (xRecyclerView == null) {
            return;
        }
        xRecyclerView.setRefreshProgressStyle(22);
        this.xRecyclerView.setLoadingMoreProgressStyle(22);
        if (this.f9149m0 || (SimpleVM.f8836d && !this.f9148l0)) {
            this.xRecyclerView.setLoadingMoreEnabled(false);
            this.xRecyclerView.setNoMore(true);
            this.view = getLayoutInflater().inflate(R.layout.layout_pagination, (ViewGroup) null);
            FrameLayout frameLayout = (FrameLayout) this.view.findViewById(R.id.ll_pagination);
            EditText editText = (EditText) this.view.findViewById(R.id.et_cur_page);
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_first);
            MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_prev);
            MaterialRippleLayout materialRippleLayout3 = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_next);
            MaterialRippleLayout materialRippleLayout4 = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_last);
            editText.setText(String.valueOf(this.f9137a0 + 1));
            m4903i(this.view);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.m4886j(view);
                }
            });
            materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.this.m4897c(view);
                }
            });
            materialRippleLayout2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.this.m4898d(view);
                }
            });
            materialRippleLayout3.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.this.m4899e(view);
                }
            });
            materialRippleLayout4.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.this.m4900f(view);
                }
            });
            this.view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.xRecyclerView.setPaginationView(this.view);
        }
        this.xRecyclerView.setLoadingListener(new XRecyclerView.InterfaceC3267d(){});
    }

    /* renamed from: T0 */
    public void m4888T0() {
        if (getContext() == null || this.coordinatorLayout == null || this.xRecyclerView != null) {
            this.f9144h0 = true;
        } else {
            this.xRecyclerView = new XRecyclerView(getContext());
            this.coordinatorLayout.addView(this.xRecyclerView, new CoordinatorLayout.LayoutParams(-1, -1));
            showBootomMenu();
            this.onClickListener = new View.OnClickListener() { // from class: b.f.a.g.a.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.this.m4901g(view);
                }
            };
            m4893Y0();
        }
        BaseActivity activityC1391g1 = this.baseActivity;
        if (activityC1391g1 != null && this.nsv_main == null && this.onClickListener != null) {
            View findViewById = this instanceof SearchFragment ? activityC1391g1.findViewById(R.id.llc_point_header_tab) : null;
            BaseActivity activityC1391g12 = this.baseActivity;
            activityC1391g12.m4286a((View) this.xRecyclerView, activityC1391g12, findViewById, false).setOnClickListener(this.onClickListener);
        }
        BaseActivity activityC1391g13 = this.baseActivity;
        if (activityC1391g13 == null || this.xRecyclerView == null) {
            return;
        }
        View mo4310w = activityC1391g13.mo4310w();
        View findViewById2 = SimpleVM.f8836d ? this.baseActivity.findViewById(R.id.header_border) : null;
        NestedScrollView nestedScrollView = this.nsv_main;
        if (nestedScrollView == null) {
            this.baseActivity.initView(this.xRecyclerView, (MaterialRippleLayout) this.coordinatorLayout.findViewById(R.id.mrl_scroll_top), mo4310w, findViewById2, this.baseActivity.findViewById(R.id.bottom_border), true);
            return;
        }
        BaseActivity activityC1391g14 = this.baseActivity;
        activityC1391g14.m4286a((View) nestedScrollView, activityC1391g14, (View) null, true);
        this.baseActivity.m4293a(this.nsv_main, (MaterialRippleLayout) this.coordinatorLayout.findViewById(R.id.mrl_scroll_top), (View) null, (View) null, this.baseActivity.findViewById(R.id.bottom_border), true);
    }

    /* renamed from: U0 */
    public void m4889U0() {
        this.f9139c0 = false;
        XRecyclerView xRecyclerView = this.xRecyclerView;
        if (xRecyclerView != null) {
            xRecyclerView.m6993K();
            this.xRecyclerView.m6992J();
        }
    }

    /* renamed from: V0 */
    public void mo4890V0() {
        if (this.f9139c0) {
            return;
        }
        this.f9139c0 = true;
    }

    /* renamed from: W0 */
    public void mo4891W0() {
        if (this.f9139c0) {
            return;
        }
        this.f9139c0 = true;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: X0 */
    public void m4892X0() {
        XRecyclerView xRecyclerView = this.xRecyclerView;
        if (xRecyclerView != null) {
            xRecyclerView.f12365P0 = this.f9138b0;
        }
        if (!this.f9149m0 && (!SimpleVM.f8836d || this.f9148l0)) {
            if (this.f9138b0 <= 20) {
                this.xRecyclerView.setNoMore(true);
                return;
            }
            return;
        }
        final int i = ((this.f9138b0 - 1) / 20) + 1;
        final EditText editText = (EditText) this.view.findViewById(R.id.et_cur_page);
        TextView textView = (TextView) this.view.findViewById(R.id.tv_total_page);
        editText.setText(String.valueOf(this.f9137a0 + 1));
        textView.setText(" / " + i);
        this.view.findViewById(R.id.ll_page_number).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseFragment.this.m4895a(editText, view);
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.a.i
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(android.widget.TextView textView2, int i2, KeyEvent keyEvent) {
                return BaseFragment.this.m4896a(editText, i, textView2, i2, keyEvent);
            }
        });
        m4904i(true);
    }

    /* renamed from: Y0 */
    public void m4893Y0() {
        if (this.xRecyclerView == null || this.f9139c0) {
            return;
        }
        this.f9144h0 = false;
        mo4891W0();
    }

    @Override // androidx.fragment.app.Fragment
    
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.coordinatorLayout == null) {
            this.coordinatorLayout = new CoordinatorLayout(getContext());
            this.coordinatorLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, -1));
        }
        if (this.f9144h0) {
            m4888T0();
        }
        return this.coordinatorLayout;
    }

    
    public  void m4894a(MaterialRippleLayout materialRippleLayout, View view) {
        if (this.bubblePopup == null) {
            MaterialRippleLayout materialRippleLayout2 = new MaterialRippleLayout(this.baseActivity);
            materialRippleLayout2.setRippleRoundedCorners(Util.dp2px((Context) this.baseActivity, 0));
            materialRippleLayout2.setMinimumWidth(Util.dp2px((Context) this.baseActivity, 50));
            materialRippleLayout2.setMinimumHeight(Util.dp2px((Context) this.baseActivity, 50));
            materialRippleLayout2.setDefaultRippleAlpha(10);
            materialRippleLayout2.setRippleOverlay(true);
            materialRippleLayout2.setRippleHover(true);
            materialRippleLayout2.setRippleColor(getResources().getColor(R.color.ripple_white));
            com.jeil.emarket.components.textview.TextView textView = new com.jeil.emarket.components.textview.TextView(this.baseActivity);
            textView.setText(getResources().getString(R.string.pagination_tooltip));
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setPadding(Util.dp2px((Context) this.baseActivity, 10), Util.dp2px((Context) this.baseActivity, 10), Util.dp2px((Context) this.baseActivity, 10), Util.dp2px((Context) this.baseActivity, 10));
            textView.setTextSize(1, 10.5f);
            textView.setLineSpacing(Util.dp2px((Context) this.baseActivity, 6), 1.0f);
            materialRippleLayout2.addView(textView);
            BubblePopup bubblePopup = new BubblePopup(getContext(), materialRippleLayout2);
            bubblePopup.m6907c(materialRippleLayout);
            bubblePopup.m4596a(48);
            this.bubblePopup = bubblePopup;
            textView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseFragment.this.m4902h(view2);
                }
            });
        }
        BubblePopup bubblePopup2 = this.bubblePopup;
        if (bubblePopup2.f12222A != null) {
            bubblePopup2.mo4597f();
        }
        this.bubblePopup.show();
    }

    
    public  void m4895a(EditText editText, View view) {
        editText.requestFocus(1);
        ((InputMethodManager) this.baseActivity.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editText, 0);
    }

    
    public  boolean m4896a(EditText editText, int i, android.widget.TextView textView, int i2, KeyEvent keyEvent) {
        int i3;
        String obj = ((Editable) Objects.requireNonNull(editText.getText())).toString();
        if (!obj.isEmpty()) {
            try {
                i3 = Integer.parseInt(obj);
            } catch (Exception unused) {
                i3 = 1;
            }
            if (i3 < 1 || i3 > i) {
                editText.setText(String.valueOf(this.f9137a0 + 1));
            } else if (i3 != this.f9137a0 + 1) {
                this.f9137a0 = i3 - 1;
                m4904i(false);
            }
        }
        ((InputMethodManager) this.baseActivity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        return false;
    }

    
    public  void m4897c(View view) {
        this.f9137a0 = 0;
        m4904i(false);
    }

    
    public  void m4898d(View view) {
        this.f9137a0--;
        m4904i(false);
    }

    
    public  void m4899e(View view) {
        this.f9137a0++;
        m4904i(false);
    }

    /* renamed from: f */
    public  void m4900f(View view) {
        int i = this.f9138b0;
        this.f9137a0 = i / 20;
        int i2 = this.f9137a0;
        if (i == i2 * 20) {
            this.f9137a0 = i2 - 1;
        }
        m4904i(false);
    }

    /* renamed from: g */
    public  void m4901g(View view) {
        //this.xRecyclerView.m2806j(0);
        NestedScrollView nestedScrollView = this.nsv_main;
        if (nestedScrollView != null) {
          //  nestedScrollView.m2444b(0, 0);
        }
    }

    /* renamed from: h */
    public  void m4902h(View view) {
        this.bubblePopup.hide();
        Intent intent = new Intent(this.baseActivity.getApplicationContext(), SettingActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.baseActivity.startActivity(intent);
    }

    
    public void m4903i(View view) {
        final MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) view.findViewById(R.id.mrl_pagination_tooltip);
        materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.a.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseFragment.this.m4894a(materialRippleLayout, view2);
            }
        });
    }

    
    public void m4904i(boolean z) {
        if (this.view == null) {
            return;
        }
        if (!z) {
            mo4891W0();
        }
        ((EditText) this.view.findViewById(R.id.et_cur_page)).setText(String.valueOf(this.f9137a0 + 1));
        MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_first);
        MaterialRippleLayout materialRippleLayout2 = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_prev);
        MaterialRippleLayout materialRippleLayout3 = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_next);
        MaterialRippleLayout materialRippleLayout4 = (MaterialRippleLayout) this.view.findViewById(R.id.mrl_page_last);
        if (this.f9137a0 <= 0) {
            materialRippleLayout.setEnabled(false);
            materialRippleLayout.setAlpha(0.5f);
            materialRippleLayout2.setEnabled(false);
            materialRippleLayout2.setAlpha(0.5f);
        } else {
            materialRippleLayout.setEnabled(true);
            materialRippleLayout.setAlpha(1.0f);
            materialRippleLayout2.setEnabled(true);
            materialRippleLayout2.setAlpha(1.0f);
        }
        if ((this.f9137a0 + 1) * 20 >= this.f9138b0) {
            materialRippleLayout4.setEnabled(false);
            materialRippleLayout4.setAlpha(0.5f);
            materialRippleLayout3.setEnabled(false);
            materialRippleLayout3.setAlpha(0.5f);
            return;
        }
        materialRippleLayout4.setEnabled(true);
        materialRippleLayout4.setAlpha(1.0f);
        materialRippleLayout3.setEnabled(true);
        materialRippleLayout3.setAlpha(1.0f);
    }

   // @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public void mo1703p0() {
      //  this.f3653G = true;
        XRecyclerView xRecyclerView = this.xRecyclerView;
        if (xRecyclerView != null) {
            xRecyclerView.m6990H();
        }
    }
}
