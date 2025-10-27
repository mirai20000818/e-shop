package com.jeil.emarket.frag.main.bottom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.google.gson.Gson;
import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.activities.product.ShopActivity;
import com.jeil.emarket.components.button.ButtonToggle;
import com.jeil.emarket.components.button.SwitchView;
import com.jeil.emarket.components.edittext.AutoCompleteTextView;
import com.jeil.emarket.components.textview.TextViewBold;
import com.jeil.emarket.model.customer.Home;
import com.jeil.emarket.model.customer.ShopFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.refund.SearchAdapter;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.viewmodel.RecentKeywordsVM;
import com.jeil.emarket.viewmodel.BottomVM;

/* renamed from: b.f.a.g.b.b.x0 */

public class FragmentMessage extends Fragment implements BaseInterface2 {

    /* renamed from: b0 */
    public SearchAdapter f9379b0;

    /* renamed from: c0 */
    public SearchAdapter f9380c0;

    /* renamed from: d0 */
    public BaseActivity f9381d0;

    /* renamed from: e0 */
    public View f9382e0;

    /* renamed from: g0 */
    public AutoCompleteTextView f9384g0;

    /* renamed from: a0 */
    public ShopFilter f9378a0 = new ShopFilter();

    /* renamed from: f0 */
    public List<String> f9383f0 = new ArrayList();

    public FragmentMessage(BaseActivity activityC1391g1) {
        this.f9381d0 = activityC1391g1;
    }


    public static  void m5020a(ButtonToggle buttonToggle, ButtonToggle buttonToggle2, View view) {
        if (buttonToggle.f12185G) {
            buttonToggle.m6897e();
        } else {
            buttonToggle.m6896d();
            buttonToggle2.m6897e();
        }
    }


    public static  void m5021b(ButtonToggle buttonToggle, ButtonToggle buttonToggle2, View view) {
        if (buttonToggle.f12185G) {
            buttonToggle.m6897e();
        } else {
            buttonToggle.m6896d();
            buttonToggle2.m6897e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: A0 */
    public void mo2456A0() {
        this.f3653G = true;
        AutoCompleteTextView autoCompleteTextView = this.f9384g0;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setText("");
        }
    }

    /* renamed from: S0 */
    public void m5022S0() {
        final Intent intent = new Intent(this.f9381d0, ShopActivity.class);
        String trim = this.f9384g0.getText().trim();
        if (trim.isEmpty()) {
            ShopFilter shopFilter = this.f9378a0;
            if (!((shopFilter.isDiscounted || shopFilter.isFeatured) ? true : shopFilter.isInStock)) {
                Util.toast(this.f9381d0, R.string.search_placeholder, "error");
                return;
            }
        }
        if (!trim.isEmpty()) {
            intent.putExtra("search", trim);
        }
        if (m5023T0()) {
            intent.putExtra("PARAM", new Gson().toJson(this.f9378a0));
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.b.j0
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentMessage.this.m5028b(intent);
                }
            }, 200L);
        }
        List<String> list = ((Home) Objects.requireNonNull(BottomVM.homeMutableLiveData.getValue())).topSearchTerms;
        if (list == null || list.size() == 0 || trim.isEmpty() || list.indexOf(trim) <= -1) {
            List<String> getValue = RecentKeywordsVM.f10264d.getValue();
            if (!trim.isEmpty()) {
                if (getValue == null || getValue.size() == 0) {
                    getValue = new ArrayList<>();
                    getValue.add(trim);
                } else {
                    int indexOf = getValue.indexOf(trim);
                    if (indexOf != -1) {
                        getValue.remove(indexOf);
                    } else if (getValue.size() >= 10) {
                        getValue.remove(getValue.size() - 1);
                    }
                    getValue.add(0, trim);
                }
            }
            RecentKeywordsVM.m5492a(getValue);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
    /* renamed from: T0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m5023T0() {
        /*
            r4 = this;
            android.view.View r0 = r4.f9382e0
            r1 = 2131231000(0x7f080118, float:1.8078069E38)
            android.view.View r0 = r0.findViewById(r1)
            com.jeil.emarket.components.edittext.EditForm r0 = (com.jeil.emarket.components.edittext.EditForm) r0
            java.lang.String r0 = r0.getText()
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 != 0) goto L20
            com.jeil.emarket.model.customer.ShopFilter r1 = r4.f9378a0     // Catch: java.lang.Exception -> L20
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L20
            float r0 = (float) r0     // Catch: java.lang.Exception -> L20
            r1.minPrice = r0     // Catch: java.lang.Exception -> L20
            goto L24
        L20:
            com.jeil.emarket.model.customer.ShopFilter r0 = r4.f9378a0
            r0.minPrice = r2
        L24:
            android.view.View r0 = r4.f9382e0
            r1 = 2131230999(0x7f080117, float:1.8078067E38)
            android.view.View r0 = r0.findViewById(r1)
            com.jeil.emarket.components.edittext.EditForm r0 = (com.jeil.emarket.components.edittext.EditForm) r0
            java.lang.String r0 = r0.getText()
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L43
            com.jeil.emarket.model.customer.ShopFilter r1 = r4.f9378a0     // Catch: java.lang.Exception -> L43
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L43
            float r0 = (float) r0     // Catch: java.lang.Exception -> L43
            r1.maxPrice = r0     // Catch: java.lang.Exception -> L43
            goto L47
        L43:
            com.jeil.emarket.model.customer.ShopFilter r0 = r4.f9378a0
            r0.maxPrice = r2
        L47:
            android.view.View r0 = r4.f9382e0
            r1 = 2131230965(0x7f0800f5, float:1.8077998E38)
            android.view.View r0 = r0.findViewById(r1)
            com.jeil.emarket.components.button.ButtonToggle r0 = (com.jeil.emarket.components.button.ButtonToggle) r0
            boolean r0 = r0.f12185G
            if (r0 == 0) goto L5d
            com.jeil.emarket.model.customer.ShopFilter r0 = r4.f9378a0
            java.lang.String r1 = "kpf"
        L5a:
            r0.currency = r1
            goto L75
        L5d:
            android.view.View r0 = r4.f9382e0
            r1 = 2131230966(0x7f0800f6, float:1.8078E38)
            android.view.View r0 = r0.findViewById(r1)
            com.jeil.emarket.components.button.ButtonToggle r0 = (com.jeil.emarket.components.button.ButtonToggle) r0
            boolean r0 = r0.f12185G
            if (r0 == 0) goto L71
            com.jeil.emarket.model.customer.ShopFilter r0 = r4.f9378a0
            java.lang.String r1 = "kpw"
            goto L5a
        L71:
            com.jeil.emarket.model.customer.ShopFilter r0 = r4.f9378a0
            r1 = 0
            goto L5a
        L75:
            com.jeil.emarket.model.customer.ShopFilter r0 = r4.f9378a0
            float r1 = r0.minPrice
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L83
            float r0 = r0.maxPrice
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto La1
        L83:
            com.jeil.emarket.model.customer.ShopFilter r0 = r4.f9378a0
            float r1 = r0.minPrice
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto La1
            float r0 = r0.maxPrice
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto La1
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto La1
            b.f.a.a.c.g1 r0 = r4.f9381d0
            r1 = 2131690022(0x7f0f0226, float:1.9009076E38)
            java.lang.String r2 = "error"
            p000a.p005b.p006a.LayoutInflaterFactory2C0048w.e.toast(r0, r1, r2)
            r0 = 0
            return r0
        La1:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p231g.p233b.p235b.C2389x0.m5023T0():boolean");
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9382e0 = layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
        final NestedScrollView nestedScrollView = (NestedScrollView) this.f9382e0.findViewById(R.id.nsv_main);
        if (nestedScrollView != null) {
            BaseActivity activityC1391g1 = this.f9381d0;
            activityC1391g1.m4286a((View) nestedScrollView, activityC1391g1, this.f9382e0, false).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NestedScrollView.this.smoothScrollBy(0, 0, 300);
                }
            });
        }
        ((TextViewBold) this.f9382e0.findViewById(R.id.tv_header_title)).setText(R.string.search);
        this.f9382e0.findViewById(R.id.ll_price_filter).setVisibility(View.GONE);
        this.f9382e0.findViewById(R.id.mrl_header_cart).setVisibility(View.VISIBLE);
        this.f9384g0 = (AutoCompleteTextView) this.f9382e0.findViewById(R.id.cactv_search);
        this.f9384g0.requestFocus();
        BaseActivity activityC1391g12 = this.f9381d0;
        if (activityC1391g12 != null) {
            ((InputMethodManager) activityC1391g12.getSystemService("input_method")).showSoftInput(this.f9384g0, 0);
        }
        return this.f9382e0;
    }


    public  void m5024a(View view, List list) {
        if (list == null || list.size() == 0) {
            view.findViewById(R.id.llc_recent_recycler_view).setVisibility(View.GONE);
            return;
        }
        view.findViewById(R.id.llc_recent_recycler_view).setVisibility(View.VISIBLE);
        SearchAdapter c1767y = this.f9380c0;
        c1767y.arrayList = list;
        c1767y.notifyDataSetChanged();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.f9383f0.indexOf(str) == -1) {
                this.f9383f0.add(str);
            }
        }
        this.f9384g0.setAdapter(this.f9381d0, this.f9383f0);
    }


    public  void m5025a(SwitchView switchView, boolean z) {
        this.f9378a0.isDiscounted = z;
    }


    public  void m5026a(Home home) {
        View findViewById;
        int i;
        List<String> list;
        if (home == null || (list = home.topSearchTerms) == null || list.size() <= 0) {
            findViewById = this.f9382e0.findViewById(R.id.ctv_top_terms_label);
            i = 8;
        } else {
            this.f9379b0.addAll((List) home.topSearchTerms);
            for (String str : home.topSearchTerms) {
                if (this.f9383f0.indexOf(str) == -1) {
                    this.f9383f0.add(str);
                }
            }
            for (String str2 : home.search) {
                if (this.f9383f0.indexOf(str2) == -1) {
                    this.f9383f0.add(str2);
                }
            }
            this.f9384g0.setAdapter(this.f9381d0, this.f9383f0);
            findViewById = this.f9382e0.findViewById(R.id.ctv_top_terms_label);
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, String str, int i2) {
        final Intent intent = new Intent(this.f9381d0, ShopActivity.class);
        intent.putExtra("search", str);
        if (!m5023T0()) {
            return true;
        }
        intent.putExtra("PARAM", new Gson().toJson(this.f9378a0));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.b.b.o0
            @Override // java.lang.Runnable
            public final void run() {
                FragmentMessage.this.m5030c(intent);
            }
        }, 200L);
        return true;
    }


    public  boolean m5027a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 0) {
            return false;
        }
        m5022S0();
        return false;
    }


    public  void m5028b(Intent intent) {
        startActivity(intent, (Bundle) null);
    }


    public  void m5029b(SwitchView switchView, boolean z) {
        this.f9378a0.isInStock = z;
    }


    public  void m5030c(Intent intent) {
        startActivity(intent, (Bundle) null);
    }


    public  void m5031c(View view) {
        m5022S0();
    }


    public  void m5032c(SwitchView switchView, boolean z) {
        this.f9378a0.isFeatured = z;
    }


    public  void m5033d(View view) {
        m5022S0();
    }


    public  void m5034e(View view) {
        ((MainActivity) this.f9381d0).bottomNavigationView.setIndex(0);
        ((MainActivity) this.f9381d0).m6457g(R.id.navigation_home);
        ((InputMethodManager) this.f9381d0.getSystemService("input_method")).hideSoftInputFromWindow(this.f9384g0.getWindowToken(), 0);
    }

    @Override // androidx.fragment.app.Fragment

    public void onViewCreated(View view, Bundle bundle) {
        View view2 = this.f9382e0;
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.rv_top_terms);
        RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(R.id.rv_recent_terms);
        this.f9379b0 = new SearchAdapter(this.f9381d0, this);
        this.f9380c0 = new SearchAdapter(this.f9381d0, this);
        recyclerView.setAdapter(this.f9379b0);
        recyclerView2.setAdapter(this.f9380c0);
        ChipsLayoutManager m5986a = ChipsLayoutManager.newBuilder(this.f9381d0).build();
        ChipsLayoutManager m5986a2 = ChipsLayoutManager.newBuilder(this.f9381d0).build();
        recyclerView.setLayoutManager(m5986a);
        recyclerView2.setLayoutManager(m5986a2);
        BottomVM.homeMutableLiveData.observe(this.f9381d0, new Observer() { // from class: b.f.a.g.b.b.i0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentMessage.this.m5026a((Home) obj);
            }
        });
        final View view3 = this.f9382e0;
        RecentKeywordsVM.m5493c();
        RecentKeywordsVM.f10264d.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.b.b.k0
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentMessage.this.m5024a(view3, (List) obj);
            }
        });
        final ButtonToggle buttonToggle = (ButtonToggle) this.f9382e0.findViewById(R.id.cbt_kpf);
        final ButtonToggle buttonToggle2 = (ButtonToggle) this.f9382e0.findViewById(R.id.cbt_kpw);
        buttonToggle.m6897e();
        buttonToggle2.m6897e();
        int m170a = Util.dp2px((Context) this.f9381d0, 13);
        int i = m170a / 2;
        buttonToggle.m6894a(m170a, i, m170a, i);
        buttonToggle2.m6894a(m170a, i, m170a, i);
        buttonToggle.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FragmentMessage.m5020a(ButtonToggle.this, buttonToggle2, view4);
            }
        });
        buttonToggle2.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                FragmentMessage.m5021b(ButtonToggle.this, buttonToggle, view4);
            }
        });
        View view4 = this.f9382e0;
        BaseActivity activityC1391g1 = this.f9381d0;
        if (activityC1391g1 instanceof MainActivity) {
            ((MainActivity) activityC1391g1).setClickEvent(view4);
        } else {
            activityC1391g1.mo4284G();
        }
        ((SwitchView) view4.findViewById(R.id.csv_stock)).setChecked(this.f9378a0.isInStock);
        ((SwitchView) view4.findViewById(R.id.csv_featured)).setChecked(this.f9378a0.isFeatured);
        ((SwitchView) view4.findViewById(R.id.csv_discounted)).setChecked(this.f9378a0.isDiscounted);
        ((SwitchView) view4.findViewById(R.id.csv_stock)).setOnCheckedChangeListener(new SwitchView.InterfaceC3247b() { // from class: b.f.a.g.b.b.n0
            @Override // com.jeil.emarket.components.button.SwitchView.InterfaceC3247b

            public final void mo4371a(SwitchView switchView, boolean z) {
                FragmentMessage.this.m5029b(switchView, z);
            }
        });
        ((SwitchView) view4.findViewById(R.id.csv_featured)).setOnCheckedChangeListener(new SwitchView.InterfaceC3247b() { // from class: b.f.a.g.b.b.f0
            @Override // com.jeil.emarket.components.button.SwitchView.InterfaceC3247b

            public final void mo4371a(SwitchView switchView, boolean z) {
                FragmentMessage.this.m5032c(switchView, z);
            }
        });
        ((SwitchView) view4.findViewById(R.id.csv_discounted)).setOnCheckedChangeListener(new SwitchView.InterfaceC3247b() { // from class: b.f.a.g.b.b.g0
            @Override // com.jeil.emarket.components.button.SwitchView.InterfaceC3247b

            public final void mo4371a(SwitchView switchView, boolean z) {
                FragmentMessage.this.m5025a(switchView, z);
            }
        });
        if (this.f9381d0 instanceof MainActivity) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) view4.findViewById(R.id.mrl_header_back);
            if (materialRippleLayout != null) {
                materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.q0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view5) {
                        FragmentMessage.this.m5034e(view5);
                    }
                });
            }
        } else {
            view4.findViewById(R.id.header).setVisibility(View.GONE);
        }
        view4.findViewById(R.id.header_border).setVisibility(View.GONE);
        View view5 = this.f9382e0;
        this.f9384g0.setIconOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                FragmentMessage.this.m5031c(view6);
            }
        });
        this.f9384g0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: b.f.a.g.b.b.e0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return FragmentMessage.this.m5027a(textView, i2, keyEvent);
            }
        });
        view5.findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.b.b.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                FragmentMessage.this.m5033d(view6);
            }
        });
    }
}
