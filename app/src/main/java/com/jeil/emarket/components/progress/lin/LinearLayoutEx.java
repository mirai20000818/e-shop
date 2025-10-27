package com.jeil.emarket.components.progress.lin;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.jeil.emarket.widget.ViewGroupEx;
import com.jeil.emarket.widget.loading.LoadingIndicatorView;

/* renamed from: b.f.a.c.m0.a.a */

public class LinearLayoutEx extends LinearLayout {


    public boolean f8515b;


    public ViewGroupEx f8516c;


    public LoadingIndicatorView f8517d;

    
    public int f8518e;

    public LinearLayoutEx(Context context) {
        super(context);
        this.f8515b = false;
        this.f8518e = -4868683;
        m4681b();
    }

    
    public void m4680a() {
        this.f8516c = null;
        LoadingIndicatorView loadingIndicatorView = this.f8517d;
        if (loadingIndicatorView != null) {
            loadingIndicatorView.m4609c();
            this.f8517d = null;
        }
    }


    public void m4681b() {
        setGravity(17);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.f8516c = new ViewGroupEx(getContext());
        this.f8516c.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.f8517d = new LoadingIndicatorView(getContext());
        this.f8517d.setIndicatorColor(this.f8518e);
        this.f8516c.setView(this.f8517d);
        addView(this.f8516c);
    }

    public void setProgressStyle(int i) {
        ViewGroupEx viewGroupEx;
        View view;
        if (i == -1) {
            viewGroupEx = this.f8516c;
            view = new ProgressBar(getContext(), null, R.attr.progressBarStyle);
        } else {
            this.f8517d = new LoadingIndicatorView(getContext());
            this.f8517d.setIndicatorColor(this.f8518e);
            this.f8517d.setIndicatorId(i);
            viewGroupEx = this.f8516c;
            view = this.f8517d;
        }
        viewGroupEx.setView(view);
    }

    public void setState(int i) {
        if (i == 0) {
            this.f8516c.setVisibility(View.VISIBLE);
        } else if (i == 1) {
            if (this.f8515b) {
                getLayoutParams().height = 0;
            }
            setVisibility(View.GONE);
            return;
        } else if (i != 2) {
            return;
        } else {
            this.f8516c.setVisibility(View.GONE);
        }
        setVisibility(View.VISIBLE);
    }
}
