package com.jeil.emarket.components.bottomnavigation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jeil.emarket.custom.Util;

import com.jeil.emarket.components.textview.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.widget.base.Nav_view;
import com.jeil.emarket.widget.base.BottomNavListener;


public class BottomNavigationView extends RelativeLayout {


    public final int f12165b;


    public List<Nav_view> btObjs;


    public Context f12167d;


    public List<View> childViews;

    /* renamed from: f */
    public BottomNavListener f12169f;

    /* renamed from: g */
    public int index;

    /* renamed from: h */
    public boolean f12171h;


    public float f12172i;

   
    public float f12173j;


    public int f12174k;

    /* renamed from: l */
    public int f12175l;

    /* renamed from: m */
    public boolean f12176m;

    /* renamed from: n */
    public int f12177n;

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12165b = getResources().getDimensionPixelSize(R.dimen.bottom_navigation_height);
        this.btObjs = new ArrayList();
        this.childViews = new ArrayList();
        this.index = -1;
        this.f12174k = -1;
        this.f12167d = context;
        if (attributeSet != null) {
            Resources resources = getResources();
            TypedArray obtainStyledAttributes = this.f12167d.obtainStyledAttributes(attributeSet, R.styleable.BottomNavigationView);
            this.f12171h = obtainStyledAttributes.getBoolean(R.styleable.BottomNavigationView_bnv_with_text, true);
            this.f12176m = obtainStyledAttributes.getBoolean(R.styleable.BottomNavigationView_bnv_shadow, false);
            this.f12174k = obtainStyledAttributes.getColor(R.styleable.BottomNavigationView_bnv_active_color, -1);
            this.f12172i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomNavigationView_bnv_active_text_size, resources.getDimensionPixelSize(R.dimen.bottom_navigation_text_size_active));
            this.f12173j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomNavigationView_bnv_inactive_text_size, resources.getDimensionPixelSize(R.dimen.bottom_navigation_text_size_inactive));
            obtainStyledAttributes.recycle();
        }
        this.f12177n = (int) getResources().getDimension(R.dimen.bottom_navigation_shadow_height);
        this.f12175l = ContextCompat.getColor(this.f12167d, R.color.dark);
    }


    public final void setIndexView(int i) {
        if (this.index == i || !this.btObjs.get(i).f8800b) {
            BottomNavListener bottomNavListener = this.f12169f;
            if (bottomNavListener != null) {
                bottomNavListener.mo4274a(i);
                return;
            }
            return;
        }
        int dimension = (int) this.f12167d.getResources().getDimension(R.dimen.bottom_navigation_padding_top_active);
        int dimension2 = (int) this.f12167d.getResources().getDimension(R.dimen.bottom_navigation_padding_top_inactive);
        int dimension3 = (int) this.f12167d.getResources().getDimension(R.dimen.bottom_navigation_padding_top_inactive_without_text);
        for (int i2 = 0; i2 < this.childViews.size(); i2++) {
            if (i2 == i) {
                View bottom_navigation_container = this.childViews.get(i).findViewById(R.id.bottom_navigation_container);
                TextView bottom_navigation_item_title = (TextView) bottom_navigation_container.findViewById(R.id.bottom_navigation_item_title);
                ImageView bottom_navigation_item_icon = (ImageView) bottom_navigation_container.findViewById(R.id.bottom_navigation_item_icon);
                Util.m259a(bottom_navigation_item_title, ContextCompat.getColor(this.f12167d, R.color.body), this.f12174k);
                Util.m258a(bottom_navigation_item_title, this.f12171h ? this.f12173j : 0.0f, this.f12172i);
                if (this.btObjs.get(i2).img != 0) {
                    bottom_navigation_item_icon.setImageResource(this.btObjs.get(i2).img);
                } else if (this.btObjs.get(i2).f8805g == 0) {
                    Util.m252a(bottom_navigation_item_icon, this.f12175l, this.f12174k);
                }
                Util.m245a(bottom_navigation_container, this.f12171h ? dimension2 : dimension3, dimension);
            } else if (i2 == this.index) {
                View findViewById2 = this.childViews.get(i2).findViewById(R.id.bottom_navigation_container);
                TextView textView2 = (TextView) findViewById2.findViewById(R.id.bottom_navigation_item_title);
                ImageView imageView2 = (ImageView) findViewById2.findViewById(R.id.bottom_navigation_item_icon);
                Util.m259a(textView2, this.f12174k, ContextCompat.getColor(this.f12167d, R.color.body));
                Util.m258a(textView2, this.f12172i, this.f12171h ? this.f12173j : 0.0f);
                if (this.btObjs.get(i2).img != 0) {
                    imageView2.setImageResource(this.btObjs.get(i2).f8803e);
                } else if (this.btObjs.get(i2).f8805g == 0) {
                    Util.m252a(imageView2, this.f12174k, this.f12175l);
                }
                Util.m245a(findViewById2, dimension, this.f12171h ? dimension2 : dimension3);
            }
        }
        BottomNavListener bottomNavListener2 = this.f12169f;
        if (bottomNavListener2 != null) {
            bottomNavListener2.mo4274a(i);
        }
        this.index = i;
    }


    public  void m6883a(int i, View view) {
        setIndexView(i);
    }


    public void m6884a(Nav_view btview) {
        this.btObjs.add(btview);
    }


    public void m6885a(boolean z) {
        this.f12171h = z;
    }


    public void setIndex(int i) {
        setIndexView(i);
        this.index = i;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.f12176m ? this.f12165b : this.f12165b + this.f12177n;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        Context context;
        int i6;
        super.onSizeChanged(i, i2, i3, i4);
        if (this.btObjs.size() == 0) {
            throw new NullPointerException("You need at least one item");
        }
        this.childViews.clear();
        int width = (getWidth() - (BaseActivity.anInt2 * 2)) / this.btObjs.size();
        FrameLayout frameLayout = new FrameLayout(this.f12167d);
        RelativeLayout relativeLayout = new RelativeLayout(this.f12167d);
        LinearLayout linearLayout = new LinearLayout(this.f12167d);
        int i7 = -1;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f12165b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f12165b);
        layoutParams2.addRule(12);
        boolean z = false;
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        frameLayout.setBackgroundColor(ContextCompat.getColor(this.f12167d, android.R.color.white));
        View view = new View(this.f12167d);
        view.setId(R.id.bottom_border);
        view.setBackgroundColor(getResources().getColor(R.color.border));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, this.f12167d.getResources().getDimensionPixelSize(R.dimen._0_5sdp));
        layoutParams3.addRule(12);
        relativeLayout.addView(view, layoutParams3);
        view.setVisibility(View.GONE);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, this.f12177n);
        layoutParams4.addRule(2, frameLayout.getId());
        addView(relativeLayout, layoutParams4);
        addView(frameLayout, layoutParams2);
        frameLayout.addView(linearLayout, layoutParams);
        getLayoutParams().height = this.f12176m ? this.f12165b : this.f12165b + this.f12177n;
        LayoutInflater layoutInflater = (LayoutInflater) this.f12167d.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int i8 = 0;
        while (i8 < this.btObjs.size()) {
            int dimension = (int) this.f12167d.getResources().getDimension(R.dimen.bottom_navigation_padding_top_active);
            int dimension2 = (int) this.f12167d.getResources().getDimension(R.dimen.bottom_navigation_padding_top_inactive);
            int dimension3 = (int) this.f12167d.getResources().getDimension(R.dimen.bottom_navigation_padding_top_inactive_without_text);
            View inflate = layoutInflater.inflate(R.layout.layout_bottom_navigation, this, z);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.bottom_navigation_item_icon);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.bottom_navigation_item_icon_inner);
            TextView textView = (TextView) inflate.findViewById(R.id.bottom_navigation_item_title);
            textView.setTextColor(ContextCompat.getColor(this.f12167d, R.color.body));
            this.childViews.add(inflate);
            if (this.btObjs.get(i8).img != 0) {
                imageView.setImageResource(i8 == this.index ? this.btObjs.get(i8).img : this.btObjs.get(i8).f8803e);
            } else if (this.btObjs.get(i8).f8805g == 0) {
                imageView.setImageResource(this.btObjs.get(i8).f8803e);
                imageView.setColorFilter(i8 == this.index ? this.f12174k : this.f12175l);
            }
            if (this.btObjs.get(i8).f8805g != 0) {
                imageView2.setImageResource(this.btObjs.get(i8).f8805g);
                imageView.setScaleX(1.1f);
                imageView.setScaleY(1.1f);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, "scaleX", 1.0f, 0.9f, 1.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "scaleY", 1.0f, 0.9f, 1.0f);
                ofFloat.setRepeatCount(i7);
                ofFloat2.setRepeatCount(i7);
                AnimatorSet animatorSet = new AnimatorSet();
                i5 = dimension3;
                animatorSet.setDuration(800L);
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.start();
            } else {
                i5 = dimension3;
            }
            if (this.btObjs.get(i8).f8801c != null) {
                this.btObjs.get(i8).f8801c.mo4364a(inflate.findViewById(R.id.vw_badge));
            }
            if (i8 == this.index) {
                context = this.f12167d;
                i6 = BaseActivity.color;
            } else {
                context = this.f12167d;
                i6 = R.color.body;
            }
            textView.setTextColor(ContextCompat.getColor(context, i6));
            int paddingLeft = inflate.getPaddingLeft();
            if (i8 == this.index) {
                i5 = dimension;
            } else if (this.f12171h) {
                i5 = dimension2;
            }
            inflate.setPadding(paddingLeft, i5, inflate.getPaddingRight(), inflate.getPaddingBottom());
            textView.setTextSize(0, i8 == this.index ? this.f12172i : this.f12171h ? this.f12173j : 0.0f);
            textView.setText(this.btObjs.get(i8).f8802d);
            i7 = -1;
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(width, -1);
            if (i8 == 0) {
                layoutParams5.leftMargin = BaseActivity.anInt2;
            } else if (i8 == this.btObjs.size() - 1) {
                layoutParams5.rightMargin = BaseActivity.anInt2;
            }
            linearLayout.addView(inflate, layoutParams5);
            int finalI = i8;
            inflate.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.c.z.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BottomNavigationView.this.m6883a(finalI, view2);
                }
            });
            i8++;
            z = false;
        }
    }

    public void setActiveItemOnlyColor(int i) {
        int i2;
        for (int i3 = 0; i3 < this.btObjs.size(); i3++) {
            if (this.childViews.size() > i3) {
                View view = this.childViews.get(i3);
                ImageView imageView = (ImageView) view.findViewById(R.id.bottom_navigation_item_icon);
                TextView textView = (TextView) view.findViewById(R.id.bottom_navigation_item_title);
                if (this.btObjs.get(i3).f8799a == i) {
                    this.index = i3;
                    textView.setTextColor(ContextCompat.getColor(this.f12167d, BaseActivity.color));
                    if (this.btObjs.get(i3).img != 0) {
                        imageView.setImageResource(this.btObjs.get(i3).img);
                    } else {
                        i2 = this.f12174k;
                        imageView.setColorFilter(i2);
                    }
                } else {
                    textView.setTextColor(ContextCompat.getColor(this.f12167d, R.color.body));
                    if (this.btObjs.get(i3).img != 0 && view.findViewById(R.id.bottom_navigation_item_icon_inner) == null) {
                        imageView.setImageResource(this.btObjs.get(i3).f8803e);
                    }
                    if (this.btObjs.get(i3).f8805g == 0) {
                        i2 = this.f12175l;
                        imageView.setColorFilter(i2);
                    }
                }
            }
        }
    }

    public void setOnBottomNavigationItemClickListener(BottomNavListener bottomNavListener) {
        this.f12169f = bottomNavListener;
    }
}
