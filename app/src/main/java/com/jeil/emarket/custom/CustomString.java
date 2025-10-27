package com.jeil.emarket.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.base.FragmentPagerAdaperEx;
import com.jeil.emarket.components.edittext.EditPhone;
import com.jeil.emarket.frag.analy.staff.C2614k3;

import org.xmlpull.v1.XmlPullParser;

/* compiled from: outline */
/* renamed from: b.a.a.a.a */

public class CustomString {
    
    public static float m3148a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    
    public static ColorStateList m3149a(BaseActivity activityC1391g1, Resources resources, java.lang.String str, java.lang.String str2, Resources resources2) {
        return ColorStateList.valueOf(resources2.getColor(resources.getIdentifier(str, str2, activityC1391g1.getPackageName())));
    }

    
    public static View m3150a(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z);
    }

    
    public static View m3151a(C2614k3 c2614k3, int i, View view, View view2, int i2) {
        view.setBackgroundTintList(ColorStateList.valueOf(c2614k3.getResources().getColor(i)));
        return view2.findViewById(i2);
    }

    
    public static BaseRequestOptions m3152a(BaseActivity activityC1391g1, int i, RequestBuilder requestBuilder) {
        return requestBuilder.load(activityC1391g1.getResources().getDrawable(i));
    }

    
    public static java.lang.String m3153a(RecyclerView recyclerView, StringBuilder sb) {
       // sb.append(recyclerView.m2810l());
        return sb.toString();
    }

    
    public static java.lang.String m3154a(java.lang.String str, long j) {
        return str + j;
    }

    
    public static java.lang.String m3155a(java.lang.String str, Uri uri) {
        return str + uri;
    }

    
    public static java.lang.String m3156a(java.lang.String str, Fragment fragment, java.lang.String str2) {
        return str + fragment + str2;
    }

    
    public static java.lang.String append(java.lang.String str, java.lang.String str2) {
        return str + str2;
    }

    
    public static java.lang.String m3158a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return str + str2 + str3;
    }

    
    public static java.lang.String m3159a(StringBuilder sb, int i, java.lang.String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    
    public static java.lang.String m3160a(StringBuilder sb, java.lang.String str, java.lang.String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    
    public static java.lang.String m3161a(XmlPullParser xmlPullParser, StringBuilder sb, java.lang.String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    
    public static StringBuilder m3162a(char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        return sb;
    }

    
    public static StringBuilder format(java.lang.String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    
    public static StringBuilder m3164a(java.lang.String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        return sb;
    }

    
    public static void m3165a(Context context, TextView textView, int i, View view, int i2, int i3, int i4, int i5) {
        Util.setColor(context, textView, i);
        view.findViewById(i2).setVisibility(i3);
        view.findViewById(i4).setVisibility(i5);
    }

    
    public static void m3166a(Context context, TextView textView, View view, int i, int i2, int i3, int i4) {
        Util.setColor(context, textView);
        view.findViewById(i).setVisibility(i2);
        view.findViewById(i3).setVisibility(i4);
    }

    
    public static void m3167a(View view, int i, int i2, int i3, int i4) {
        view.findViewById(i).setVisibility(i2);
        view.findViewById(i3).setVisibility(i4);
    }

    
    public static void m3168a(BaseActivity activityC1391g1, int i, View view) {
        view.setBackground(activityC1391g1.getResources().getDrawable(i));
    }

    
    public static void m3169a(BaseActivity activityC1391g1, int i, EditPhone editPhone) {
        editPhone.setEditTextBackground(activityC1391g1.getResources().getDrawable(i));
    }

    
    public static void m3170a(BaseActivity activityC1391g1, int i, StringBuilder sb, com.jeil.emarket.components.textview.TextView textView) {
        sb.append(activityC1391g1.getResources().getString(i));
        textView.setText(sb.toString());
    }

    
    public static void m3171a(BaseActivity activityC1391g1, int i, StringBuilder sb, java.lang.String str) {
        sb.append(activityC1391g1.getResources().getString(i));
        sb.append(str);
    }

    
    public static void m3172a(FragmentPagerAdaperEx fragmentPagerAdaperEx, int i, ViewPager viewPager) {
        viewPager.setOffscreenPageLimit(fragmentPagerAdaperEx.getCount() - i);
    }

    
    public static void m3173a(java.lang.String str, java.lang.String str2, Exception exc) {
        java.lang.String str3 = str + str2;
        exc.getLocalizedMessage();
    }

    
    public static void m3174a(StringBuilder sb, int i, java.lang.String str, com.jeil.emarket.components.textview.TextView textView) {
        sb.append(i);
        sb.append(str);
        textView.setText(sb.toString());
    }

    
    public static void m3175a(StringBuilder sb, java.lang.String str, com.jeil.emarket.components.textview.TextView textView) {
        sb.append(str);
        textView.setText(sb.toString());
    }


    public static java.lang.String m3176b(java.lang.String str, int i) {
        return str + i;
    }


    public static StringBuilder m3177b(java.lang.String str, java.lang.String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }


    public static StringBuilder m3178b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }
}
