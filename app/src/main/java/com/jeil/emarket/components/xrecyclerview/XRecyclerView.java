package com.jeil.emarket.components.xrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.components.progress.main.AppBarLayoutEx;
import com.jeil.emarket.components.progress.main.LinearLayoutEx;


public class XRecyclerView extends RecyclerView {

    /* renamed from: H0 */
    public List<Integer> idList;

    /* renamed from: I0 */
    public ArrayList<View> arrayList;

    /* renamed from: J0 */
    public LinearLayoutEx progressLinear;

    /* renamed from: K0 */
    public View f12360K0;

    /* renamed from: L0 */
    public View view;

    /* renamed from: M0 */
    public View paginationView;

    /* renamed from: N0 */
    public final AdapterDataObserver adapterDataObserver;

    /* renamed from: O0 */
    public XAdapter xAdapter;

    /* renamed from: P0 */
    public int f12365P0;

    /* renamed from: Q0 */
    public int refreshProgressStyle;

    /* renamed from: R0 */
    public int loadingMoreProgressStyle;

    /* renamed from: S0 */
    public InterfaceC3267d f12368S0;

    /* renamed from: T0 */
    public AppBarLayoutEx.a f12369T0;

    /* renamed from: U0 */
    public float f12370U0;

    /* renamed from: V0 */
    public int header;

    /* renamed from: W0 */
    public int f12372W0;

    /* renamed from: X0 */
    public boolean noMore;

    /* renamed from: Y0 */
    public boolean loadingMoreEnabled;

    /* renamed from: Z0 */
    public boolean f12375Z0;

    /* renamed from: a1 */
    public boolean f12376a1;

    /* renamed from: b1 */
    public boolean f12377b1;

    /* renamed from: c1 */
    public boolean f12378c1;

    /* renamed from: d1 */
    public boolean f12379d1;

    /* renamed from: e1 */
    public boolean pullRefreshEnabled;

    /* renamed from: f1 */
    public boolean f12381f1;

    /* renamed from: com.jeil.emarket.components.xrecyclerview.XRecyclerView$a */
    public class C3264a extends GridLayoutManager.SpanSizeLookup {

        
        public final  GridLayoutManager gridLayoutManager;

        public C3264a(GridLayoutManager gridLayoutManager) {
            this.gridLayoutManager = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup

        public int getSpanSize(int i) {
            if (XRecyclerView.this.xAdapter.m7001g(i) || XRecyclerView.this.xAdapter.m7000f(i) || XRecyclerView.this.xAdapter.m7003i(i) || XRecyclerView.this.xAdapter.m7002h(i)) {
                return this.gridLayoutManager.getSpanCount();
            }
            return 1;
        }
    }

    /* renamed from: com.jeil.emarket.components.xrecyclerview.XRecyclerView$b */
    public class C3265b extends AppBarLayoutEx {
        public C3265b() {
        }
    }

    /* renamed from: com.jeil.emarket.components.xrecyclerview.XRecyclerView$c */
    public class C3266c extends AdapterDataObserver {
        public  C3266c(C3264a c3264a) {
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x010f  */
        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0620h

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onChanged() {
            /*
                Method dump skipped, instructions count: 279
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jeil.emarket.components.xrecyclerview.XRecyclerView.C3266c.mo2882a():void");
        }
    }

    /* renamed from: com.jeil.emarket.components.xrecyclerview.XRecyclerView$d */
    public interface InterfaceC3267d {
    }

    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.idList = new ArrayList();
        this.arrayList = new ArrayList<>();
        this.adapterDataObserver = new C3266c(null);
        this.f12365P0 = 0;
        this.refreshProgressStyle = -1;
        this.loadingMoreProgressStyle = -1;
        this.f12369T0 = AppBarLayoutEx.a.EXPANDED;
        this.f12370U0 = -1.0f;
        this.header = 0;
        this.f12372W0 = 0;
        this.noMore = false;
        this.loadingMoreEnabled = true;
        this.f12375Z0 = false;
        this.f12376a1 = true;
        this.f12377b1 = false;
        this.f12378c1 = false;
        this.f12379d1 = false;
        this.pullRefreshEnabled = false;
        this.f12381f1 = true;
        if (this.pullRefreshEnabled) {
            this.progressLinear = new LinearLayoutEx(getContext());
            this.progressLinear.setProgressStyle(this.refreshProgressStyle);
            this.progressLinear.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
            this.progressLinear.setGravity(17);
        }
        com.jeil.emarket.components.progress.lin.LinearLayoutEx linearLayoutEx = new com.jeil.emarket.components.progress.lin.LinearLayoutEx(getContext());
        linearLayoutEx.setProgressStyle(this.loadingMoreProgressStyle);
        this.view = linearLayoutEx;
        this.view.setVisibility(View.VISIBLE);
        if (context instanceof BaseActivity) {
            BaseActivity activityC1391g1 = (BaseActivity) context;
            if (activityC1391g1.findViewById(R.id.bottom_navigation) != null) {
                this.f12372W0 = activityC1391g1.findViewById(R.id.bottom_navigation).getMeasuredHeight();
            }
        }
        if (this.f12372W0 == 0) {
            this.f12372W0 = getResources().getDimensionPixelSize(R.dimen.bottom_height);
        }
    }

    private int getHeaders_includingRefreshCount() {
        XAdapter XAdapter = this.xAdapter;
        if (XAdapter == null) {
            return 0;
        }
        return XAdapter.m6999c() + 1;
    }

    /* renamed from: H */
    public void m6990H() {
        ArrayList<View> arrayList = this.arrayList;
        if (arrayList != null) {
            arrayList.clear();
            this.idList.clear();
            this.arrayList = null;
        }
        View view = this.view;
        if (view instanceof com.jeil.emarket.components.progress.lin.LinearLayoutEx) {
            ((com.jeil.emarket.components.progress.lin.LinearLayoutEx) view).m4680a();
            this.view = null;
        }
        LinearLayoutEx linearLayoutEx = this.progressLinear;
        if (linearLayoutEx != null) {
            linearLayoutEx.m4682a();
            this.progressLinear = null;
        }
    }

    
    public boolean m6991I() {
        LinearLayoutEx linearLayoutEx = this.progressLinear;
        return (linearLayoutEx == null || linearLayoutEx.getParent() == null) ? false : true;
    }

   
    public void m6992J() {
        this.f12379d1 = false;
        View view = this.view;
        if (view instanceof com.jeil.emarket.components.progress.lin.LinearLayoutEx) {
            ((com.jeil.emarket.components.progress.lin.LinearLayoutEx) view).setState(1);
        }
    }

    
    public void m6993K() {
        LinearLayoutEx linearLayoutEx = this.progressLinear;
        if (linearLayoutEx != null) {
            linearLayoutEx.m4687c();
        }
        setNoMore(false);
    }

    /* renamed from: L */
    public void m6994L() {
        this.f12378c1 = true;
        setFooterHeight(false);
        View view = this.view;
        if (view == null || !(view instanceof com.jeil.emarket.components.progress.lin.LinearLayoutEx)) {
            return;
        }
        ((com.jeil.emarket.components.progress.lin.LinearLayoutEx) view).f8515b = true;
    }

    

    @Override // androidx.recyclerview.widget.RecyclerView
    public Adapter<ViewHolder> getAdapter() {
        XAdapter XAdapter = this.xAdapter;
        if (XAdapter != null) {
            return XAdapter.viewHolderAdapter;
        }
        return null;
    }

    @Deprecated
    public View getEmptyView() {
        return this.f12360K0;
    }


    /* renamed from: l */
    public final boolean contains(int i) {
        ArrayList<View> arrayList = this.arrayList;
        return arrayList != null && this.idList != null && arrayList.size() > 0 && this.idList.contains(Integer.valueOf(i));
    }

    /* renamed from: m */
    public void addView(View view) {
        if (this.arrayList == null || this.idList == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 10002;
            if (!this.idList.contains(Integer.valueOf(i2))) {
                this.idList.add(Integer.valueOf(i2));
                view.setTag("recyclerview-header-index-" + i2);
                this.arrayList.add(view);
                return;
            }
            i++;
        }
    }




    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AppBarLayout appBarLayout;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof CoordinatorLayout)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    appBarLayout = null;
                    break;
                }
                View childAt = coordinatorLayout.getChildAt(childCount);
                if (childAt instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) childAt;
                    break;
                }
                childCount--;
            }
            if (appBarLayout != null) {
               // appBarLayout.m5998a((AppBarLayout.InterfaceC3018d) new C3265b());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        LinearLayoutEx linearLayoutEx;
        LinearLayoutEx linearLayoutEx2;
        InterfaceC3267d interfaceC3267d;
        if (this.f12370U0 == -1.0f) {
            this.f12370U0 = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12370U0 = motionEvent.getRawY();
        } else if (action != 2) {
            this.f12370U0 = -1.0f;
            if (m6991I() && this.pullRefreshEnabled && this.f12369T0 == AppBarLayoutEx.a.EXPANDED && (linearLayoutEx2 = this.progressLinear) != null && linearLayoutEx2.m4688d() && (interfaceC3267d = this.f12368S0) != null) {
//                BaseFragment baseFragment = BaseFragment.this;
//                baseFragment.f9137a0 = 0;
//                baseFragment.mo4891W0();
            }
        } else {
            float rawY = motionEvent.getRawY() - this.f12370U0;
            this.f12370U0 = motionEvent.getRawY();
            if (m6991I() && this.pullRefreshEnabled && this.f12369T0 == AppBarLayoutEx.a.EXPANDED && (linearLayoutEx = this.progressLinear) != null) {
                linearLayoutEx.m4683a(rawY / 3.0f);
                if (this.progressLinear.getVisibleHeight() > 0 && this.progressLinear.getState() < 2) {
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(Adapter adapter) {
        this.xAdapter = new XAdapter(adapter);
        super.setAdapter(this.xAdapter);
        //adapter.mo2862a(this.f12363N0);
        this.adapterDataObserver.onChanged();
    }

    public void setEmptyView(View view) {
        this.f12360K0 = view;
        this.adapterDataObserver.onChanged();
    }

    public void setFooterHeight(int i) {
        this.f12372W0 = i;
    }

    public void setFooterHeight(boolean z) {
        this.f12372W0 = z ? getResources().getDimensionPixelSize(R.dimen.bottom_height) : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager abstractC0626n) {
        super.setLayoutManager(abstractC0626n);
        if (this.xAdapter == null || !(abstractC0626n instanceof GridLayoutManager)) {
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) abstractC0626n;
       // gridLayoutManager.m2616a(new C3264a(gridLayoutManager));
    }

    public void setLoadingListener(InterfaceC3267d interfaceC3267d) {
        this.f12368S0 = interfaceC3267d;
    }

    public void setLoadingMoreEnabled(boolean z) {
        this.loadingMoreEnabled = z;
        if (z) {
            return;
        }
        this.view = new View(getContext());
    }

    public void setLoadingMoreProgressStyle(int i) {
        this.loadingMoreProgressStyle = i;
        View view = this.view;
        if (view instanceof com.jeil.emarket.components.progress.lin.LinearLayoutEx) {
            ((com.jeil.emarket.components.progress.lin.LinearLayoutEx) view).setProgressStyle(i);
        }
    }

    public void setNoMore(boolean z) {
        this.f12379d1 = false;
        this.noMore = z;
        View view = this.view;
        if (view instanceof com.jeil.emarket.components.progress.lin.LinearLayoutEx) {
            ((com.jeil.emarket.components.progress.lin.LinearLayoutEx) view).setState(this.noMore ? 2 : 1);
        }
    }

    public void setPaginationView(View view) {
        this.paginationView = view;
        this.adapterDataObserver.onChanged();
    }

    public void setPullRefreshEnabled(boolean z) {
        this.pullRefreshEnabled = z;
    }

    public void setRefreshProgressStyle(int i) {
        this.refreshProgressStyle = i;
        if (progressLinear != null) {
            progressLinear.setProgressStyle(i);
        }
    }

    /* renamed from: com.jeil.emarket.components.xrecyclerview.XRecyclerView$e */
    public class XAdapter extends Adapter<ViewHolder> {


        public Adapter<ViewHolder> viewHolderAdapter;

        /* renamed from: com.jeil.emarket.components.xrecyclerview.XRecyclerView$e$a */
        public class a extends GridLayoutManager.SpanSizeLookup {

            
            public final  GridLayoutManager gridLayoutManager;

            public a(GridLayoutManager gridLayoutManager) {
                this.gridLayoutManager = gridLayoutManager;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup

            public int getSpanSize(int i) {
                if (XAdapter.this.m7001g(i) || XAdapter.this.m7000f(i) || XAdapter.this.m7003i(i) || XAdapter.this.m7002h(i)) {
                    return this.gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        }

        /* renamed from: com.jeil.emarket.components.xrecyclerview.XRecyclerView$e$b */
        public class b extends ViewHolder {
            public b(XAdapter XAdapter, View view) {
                super(view);
            }
        }

        public XAdapter(Adapter<ViewHolder> adapter) {
            this.viewHolderAdapter = adapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

        public int getItemCount() {
            XRecyclerView xRecyclerView = XRecyclerView.this;
            int i = 2;
            if (xRecyclerView.loadingMoreEnabled) {
                boolean z = xRecyclerView.f12375Z0;
            } else {
                i = 3;
            }
            if (this.viewHolderAdapter == null) {
                return m6999c() + i;
            }
            return this.viewHolderAdapter.getItemCount() + m6999c() + i;
        }






        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (m7001g(i) || m7003i(i)) {
                return;
            }
            int count = i - (m6999c() + 1);
            Adapter<ViewHolder> adapter = this.viewHolderAdapter;
            if (adapter == null || count >= adapter.getItemCount()) {
                return;
            }
            //this.viewHolderAdapter.onBindViewHolder((Adapter<ViewHolder>) viewHolder, m6999c);
        }




        public int m6999c() {
            ArrayList<View> arrayList = XRecyclerView.this.arrayList;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        /* renamed from: f */
        public boolean m7000f(int i) {
            XRecyclerView xRecyclerView = XRecyclerView.this;
            return !xRecyclerView.loadingMoreEnabled ? i == getItemCount() + (-2) : xRecyclerView.f12375Z0 ? i == getItemCount() - 1 : i == getItemCount() - 1;
        }

        /* renamed from: g */
        public boolean m7001g(int i) {
            ArrayList<View> arrayList = XRecyclerView.this.arrayList;
            return arrayList != null && i >= 1 && i < arrayList.size() + 1;
        }

        /* renamed from: h */
        public boolean m7002h(int i) {
            return !XRecyclerView.this.loadingMoreEnabled && i == getItemCount() - 1;
        }

        
        public boolean m7003i(int i) {
            return i == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            int i2;
            if (i == 10000) {
                XRecyclerView xRecyclerView = XRecyclerView.this;
                LinearLayoutEx linearLayoutEx = xRecyclerView.progressLinear;
                return linearLayoutEx == null ? new b(this, new View(xRecyclerView.getContext())) : new b(this, linearLayoutEx);
            }
            if (i == 9999) {
                XRecyclerView xRecyclerView2 = XRecyclerView.this;
                View view2 = xRecyclerView2.paginationView;
                return view2 == null ? new b(this, new View(xRecyclerView2.getContext())) : new b(this, view2);
            }
            if (!XRecyclerView.this.contains(i)) {
                return i == 10001 ? new b(this, XRecyclerView.this.view) : this.viewHolderAdapter.onCreateViewHolder(viewGroup, i);
            }
            XRecyclerView xRecyclerView3 = XRecyclerView.this;
            if (xRecyclerView3.contains(i)) {
                ArrayList<View> arrayList = xRecyclerView3.arrayList;
                view = (arrayList == null || arrayList.size() <= (i2 = i + (-10002))) ? new View(xRecyclerView3.getContext()) : xRecyclerView3.arrayList.get(i2);
            } else {
                view = null;
            }
            return (view == null || view.isAttachedToWindow() || view.getVisibility() == View.GONE) ? new b(this, new View(XRecyclerView.this.getContext())) : new b(this, view);
        }


    }
}
