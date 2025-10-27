package com.jeil.emarket.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.interf.BaseInterface2;

/* renamed from: b.f.a.c.q */

public class RecyclerViewEx extends RecyclerView {

    /* renamed from: H0 */
    public int f8542H0;

    /* renamed from: I0 */
    public int f8543I0;

    /* renamed from: J0 */
    public int f8544J0;

    /* renamed from: K0 */
    public int f8545K0;

    /* renamed from: L0 */
    public int f8546L0;

    /* renamed from: M0 */
    public int f8547M0;

    /* renamed from: N0 */
    public int f8548N0;

    /* renamed from: O0 */
    public LinearLayoutManager f8549O0;

    /* renamed from: b.f.a.c.q$a */
    public static class MyAdapter extends BaseMainAdapter<String, MyAdapter.MyVH> {

        /* renamed from: f */
        public RecyclerView f8550f;

        /* renamed from: g */
        public int f8551g;

        /* renamed from: h */
        public int f8552h;


        public int f8553i;


        public int f8554j;


        public int f8555k;

        /* renamed from: l */
        public int f8556l;

        /* renamed from: m */
        public int f8557m;

        /* renamed from: n */
        public int f8558n;

        /* renamed from: o */
        public BaseInterface2 f8559o;

        /* renamed from: b.f.a.c.q$a$a, reason: collision with other inner class name */
        public static class MyVH extends ViewHolder {
            @SuppressLint({"ResourceType"})
            public MyVH(View view) {
                super(view);
            }
        }

        public MyAdapter(BaseActivity activityC1391g1) {
            super(activityC1391g1);
            this.f8558n = 0;
        }


        public  void m4691a(int i, View view) {
            BaseInterface2 baseInterface2 = this.f8559o;
            if (baseInterface2 == null || !baseInterface2.mo4808a(i, (String) this.arrayList.get(i), 0)) {
                return;
            }
            notifyItemChanged(this.f8558n);
            this.f8558n = i;
            this.notifyItemRangeChanged(i, 1);
        }

      //  @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

        public void mo2863a(RecyclerView recyclerView) {
            this.f8550f = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f

        public void onBindViewHolder(MyVH viewHolder, @SuppressLint("RecyclerView") final int i) {
//            TextView textView = (TextView) ((MyVH) viewHolder).f3933a;
//            textView.setLayoutParams(m4692d());
//            textView.setText((CharSequence) this.arrayList.get(i));
//            textView.setSelected(this.f8558n == i);
//            textView.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.n
//                @Override // android.view.View.OnClickListener
//                public final void onClick(View view) {
//                    MyAdapter.this.m4691a(i, view);
//                }
//            });
        }


        public LinearLayoutCompat.LayoutParams m4692d() {
            return new LinearLayoutCompat.LayoutParams(-2, -1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
        @SuppressLint({"ResourceType"})

        public MyVH onCreateViewHolder(ViewGroup viewGroup, int i) {
            TextView textView = new TextView(viewGroup.getContext());
            textView.setPadding(this.f8551g, this.f8552h, this.f8553i, this.f8554j);
            textView.setTextAppearance(viewGroup.getContext(), this.f8555k);
            textView.setGravity(17);
            textView.setMaxLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (this.f8557m > 0) {
                textView.setLayoutParams(new LinearLayoutCompat.LayoutParams(viewGroup.getMeasuredWidth() / this.f8557m, -1));
            }
            textView.setTextAppearance(textView.getContext(), this.f8555k);
            textView.m6976d();
            if (this.f8556l != 0) {
                textView.setTextColor(textView.m6975a(textView.getCurrentTextColor(), this.f8556l));
            }
            textView.setLayoutParams(m4692d());
            return new MyVH(textView);
        }
    }

    public RecyclerViewEx(Context context) {
        super(context, null, 0);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.RecyclerTabLayout, 0, R.style.rtl_RecyclerTabLayout);
        this.f8543I0 = obtainStyledAttributes.getResourceId(R.styleable.RecyclerTabLayout_rtl_tabTextAppearance, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPadding, 0);
        this.f8548N0 = dimensionPixelSize;
        this.f8547M0 = dimensionPixelSize;
        this.f8546L0 = dimensionPixelSize;
        this.f8545K0 = dimensionPixelSize;
        this.f8545K0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingStart, this.f8545K0);
        this.f8546L0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingTop, this.f8546L0);
        this.f8547M0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingEnd, this.f8547M0);
        this.f8548N0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerTabLayout_rtl_tabPaddingBottom, this.f8548N0);
        if (obtainStyledAttributes.hasValue(R.styleable.RecyclerTabLayout_rtl_tabSelectedTextColor)) {
            this.f8544J0 = obtainStyledAttributes.getColor(R.styleable.RecyclerTabLayout_rtl_tabSelectedTextColor, 0);
        }
        this.f8542H0 = obtainStyledAttributes.getInteger(R.styleable.RecyclerTabLayout_rtl_tabOnScreenLimit, 0);
        obtainStyledAttributes.recycle();
        this.f8549O0 = new LinearLayoutManager(getContext());
       // this.f8549O0.m2705m(0);
        setLayoutManager(this.f8549O0);
        setItemAnimator(null);
    }

    public void setCurrentItem(int i) {
      //  mo2803i(i);
    }

    public void setUpWithAdapter(MyAdapter myAdapterVar) {
        int i = this.f8545K0;
        int i2 = this.f8546L0;
        int i3 = this.f8547M0;
        int i4 = this.f8548N0;
        myAdapterVar.f8551g = i;
        myAdapterVar.f8552h = i2;
        myAdapterVar.f8553i = i3;
        myAdapterVar.f8554j = i4;
        myAdapterVar.f8555k = this.f8543I0;
        myAdapterVar.f8556l = this.f8544J0;
        myAdapterVar.f8557m = this.f8542H0;
        setAdapter(myAdapterVar);
    }
}
