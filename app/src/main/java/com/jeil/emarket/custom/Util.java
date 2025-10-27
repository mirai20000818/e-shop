package com.jeil.emarket.custom;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.jeil.emarket.activities.intro.MainActivity;
import com.jeil.emarket.activities.product.FBTCollectionActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.activities.product.ShopActivity;
import com.jeil.emarket.activities.vendor.VendorActivity;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.customer.TicketCategory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.jeil.emarket.dialog.dialog.dialog.ImageDialog2;
import com.jeil.emarket.api.MyAni;
import com.jeil.emarket.api.MyAni2;
import com.jeil.emarket.viewmodel.ProductTotalVM;
import com.jeil.emarket.viewmodel.TicketCategoryListVM;
import com.jeil.emarket.viewmodel.UserVM;
import com.jeil.emarket.viewmodel.CategoryVM;

/* renamed from: a.b.a.w$e */
public class Util {

    public static Class<?> f206c;


    public static boolean f207d;


    public static Field f208e;

    /* renamed from: f */
    public static boolean f209f;

    /* renamed from: g */
    public static Field f210g;

    /* renamed from: h */
    public static boolean f211h;

    
    public static Method f212i;

   
    public static boolean f213j;

    
    public static Method f214k;

    /* renamed from: l */
    public static boolean f215l;

    /* renamed from: m */
    public static Field f216m;

    /* renamed from: n */
    public static boolean f217n;

    /* renamed from: o */
    public static Method f218o;

    /* renamed from: p */
    public static boolean f219p;

    /* renamed from: q */
    public static Field f220q;

    /* renamed from: r */
    public static boolean f221r;

    /* renamed from: s */
    public static long f222s;

    /* renamed from: t */
    public static Method f223t;

    /* renamed from: u */
    public static Object f224u;

    /* renamed from: v */
    public static Class f225v;


    public static float m158a(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }


    public static float m159a(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f3 - f, f4 - f2);
    }


    public static float m160a(float f, float f2, float f3, float f4, float f5, float f6) {
        float m159a = m159a(f, f2, f3, f4);
        float m159a2 = m159a(f, f2, f5, f4);
        float m159a3 = m159a(f, f2, f5, f6);
        float m159a4 = m159a(f, f2, f3, f6);
        return (m159a <= m159a2 || m159a <= m159a3 || m159a <= m159a4) ? (m159a2 <= m159a3 || m159a2 <= m159a4) ? m159a3 > m159a4 ? m159a3 : m159a4 : m159a2 : m159a;
    }


    public static float m161a(float f, int i) {
        return 0;//(float) (Math.round(f * r0) / Math.pow(10.0d, i));
    }
 
 


    public static int m164a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }


    public static int m165a(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return Gravity.getAbsoluteGravity(i, i2);
    }


    public static int m167a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }


    public static int m168a(int i, boolean z) {
        if (i != 80) {
            return -1;
        }
        return z ? R.anim.pickerview_slide_in_bottom : R.anim.pickerview_slide_out_bottom;
    }


    public static int dp2px(Context context, float f) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, f, context.getResources().getDisplayMetrics()));
    }


    public static int dp2px(Context context, int i) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, context.getResources().getDisplayMetrics()));
    }
 

    public static int m179a(java.lang.String str, java.lang.String str2) {
        Date date;
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy.MM.dd.");
        Date date2 = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            date = null;
        }
        try {
            date2 = simpleDateFormat.parse(str2);
        } catch (ParseException e3) {
           
            return date == null ? 0 : 0;
        }
        if (date == null && date2 != null) {
            return ((int) Math.floor((date2.getTime() - date.getTime()) / 8.64E7f)) + 1;
        }
        return 0;
    } 


    public static Drawable getGradDrawable(int i, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }


    public static Drawable getGradDrawable(int i, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }


    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
        int i2 = Build.VERSION.SDK_INT;
        return resources.getDrawable(i, theme);
    }
 


    public static ImageDialog2 getImageDialog2(Activity activity, View view) {
        return getImageDialog2(activity, view, 1.0f, 0.0f);
    }


    public static final Class ActivityThread() {
        if (f225v == null) {
            try {
                f225v = Class.forName("android.app.ActivityThread");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return f225v;
    }

  


    public static java.lang.String getDecimalFormat(float f) {
        return getDecimalFormat(f, false);
    }


    public static java.lang.String getDecimalFormat(float f, boolean z) {
        BigDecimal scale = new BigDecimal(f).setScale(2, RoundingMode.HALF_EVEN);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(' ');
        return (z ? new DecimalFormat("#,###.##", decimalFormatSymbols) : new DecimalFormat("#,###", decimalFormatSymbols)).format(scale);
    }


    public static java.lang.String getIdentifier(Context context, java.lang.String str, java.lang.String str2) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName()) == 0 ? str2 : context.getResources().getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
    }


    public static java.lang.String date2Str2(Context context, Date date) {
        java.lang.String str = "";
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        int floor = (int) Math.floor(time / 31104000000L);
        int floor2 = ((int) Math.floor((time - (floor * 31104000000L)) / 2592000000L)) + 1;
        if (floor > 0) {
            str = floor + context.getResources().getString(R.string.year_unit) + " ";
        }
        StringBuilder m3164a = CustomString.m3164a(str, floor2);
        m3164a.append(context.getResources().getString(R.string.month_count_unit));
        return m3164a.toString();
    }
 
    @SuppressLint({"SimpleDateFormat"})

    public static java.lang.String date2Str(Date date) {
        return date != null ? new java.text.SimpleDateFormat("yyyy.M.d.").format(date) : "";
    }



    @SuppressLint({"UseCompatLoadingForDrawables"})

    public static void setColorSize(Context context, View view) {
        view.setBackgroundResource(R.drawable.bd_round_button);
        com.jeil.emarket.components.textview.TextView textView = (com.jeil.emarket.components.textview.TextView) view;
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(1, 11.0f);
    }


    public static void setColor(Context context, TextView textView) {
        textView.setBackgroundResource(R.drawable.bg_grey_round);
        textView.setTextColor(context.getResources().getColor(R.color.transparent));
    }


    public static void setColor(Context context, TextView textView, int i) {
        textView.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        textView.setTextColor(context.getResources().getColor(i));
    }



    public static void toast(final Context context, final java.lang.String str, java.lang.String type, int i, final int i2) {
        Resources resources;
        int i3;
        final Toast toast = new Toast(context);
        final com.jeil.emarket.components.textview.TextView textView = new com.jeil.emarket.components.textview.TextView(context);
        ImageView imageView = new ImageView(context);
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(1, 11.0f);
        textView.setLineSpacing(dp2px(context, 6), 1.0f);
        textView.setGravity(17);
        textView.setPadding(0, dp2px(context, 3), 0, dp2px(context, 3));
        imageView.setImageTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.white)));
        imageView.setPadding(0, 0, dp2px(context, 5), 0);
        if (i <= 0) {
            i = R.drawable.ic_danger_circle;
        }
        imageView.setImageResource(i);
        linearLayoutCompat.addView(imageView, new LinearLayoutCompat.LayoutParams(dp2px(context, 18), dp2px(context, 18)));
        linearLayoutCompat.addView(textView);
        linearLayoutCompat.setPadding(dp2px(context, 18), dp2px(context, 4), dp2px(context, 20), dp2px(context, 4));
        linearLayoutCompat.setBackgroundResource(R.drawable.bg_toast);
        if (type.equals("error")) {
            resources = context.getResources();
            i3 = R.color.toast_error;
        } else if (type.equals("general")) {
            resources = context.getResources();
            i3 = R.color.toast;
        } else {
            resources = context.getResources();
            i3 = R.color.toast_success;
        }
        linearLayoutCompat.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(i3)));
        toast.setView(linearLayoutCompat);
        toast.setDuration(Toast.LENGTH_SHORT);
        new Handler().postDelayed(new Runnable() { // from class: a.b.a.b
            @Override // java.lang.Runnable
            public final void run() {
                Util.show(context, toast, str, textView, i2);
            }
        }, 200L);
    }
public static  void show(Context context, Toast toast, String str, com.jeil.emarket.components.textview.TextView textView, int i) {
    int m170a;
    if (context instanceof Activity) {
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity activity = (Activity) context;
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        m170a = Math.max(130, (displayMetrics.heightPixels - rect.bottom) + 130);
    } else {
        m170a = dp2px(context, 65);
    }
    toast.setGravity(81, 0, m170a);
    if (str != null) {
        textView.setText(Html.fromHtml(str.toString()));
    }
    if (i != 0) {
        toast.setDuration(i);
    }
    toast.show();
}


    public static void m239a(Context context, JSONObject jSONObject) {
        try {
            java.lang.String jSONObject2 = jSONObject.toString();
            jSONObject.put("signData", Base64.encodeToString(m347e(context, jSONObject2), 0));
            jSONObject.put("plainData", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }




    public static void m243a(View view) {
        m246a(view, 0L, 0);
    }


    public static void m245a(final View view, int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i2);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a.b.a.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
              //  r0.setPadding(r0.getPaddingLeft(), (int) ((Float) valueAnimator.getAnimatedValue()).floatValue(), r0.getPaddingRight(), view.getPaddingBottom());
            }
        });
        ofFloat.start();
    }


    public static void m246a(final View view, long j, int i) {
        if (i == 0) {
            i = view.getMeasuredHeight();
        }
        MyAni2 myAni2 = new MyAni2(view, i);
        if (j == 0) {
            j = ((int) (i / view.getContext().getResources().getDisplayMetrics().density)) * 2;
        }
        myAni2.setDuration(j);
        view.startAnimation(myAni2);
        new Handler().postDelayed(new Runnable() { // from class: a.b.a.d
            @Override // java.lang.Runnable
            public final void run() {
                Util.m346e(view);
            }
        }, j);
    }



    public static void m252a(final ImageView imageView, int i, int i2) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a.b.a.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                imageView.setColorFilter(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.setDuration(150L);
        ofObject.start();
    }



    public static void m258a(final com.jeil.emarket.components.textview.TextView textView, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a.b.a.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                //com.jeil.emarket.components.textview.TextView.this.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }


    public static void m259a(final com.jeil.emarket.components.textview.TextView textView, int i, int i2) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
        ofObject.setDuration(150L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a.b.a.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                //com.jeil.emarket.components.textview.TextView.this.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.start();
    }


    public static void m261a(File file, File file2) {
        ZipFile zipFile;
        try {
            if (!file2.exists() && !file2.mkdirs()) {
                throw new IOException("can't create directories");
            }
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    File file3 = new File(file2, nextElement.getName());
                    File parentFile = file3.getParentFile();
                    if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                        throw new IOException("can't create directories");
                    }
                    if (!nextElement.isDirectory()) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                        byte[] bArr = new byte[1024];
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), 1024);
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            } else {
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                    }
                }
            } catch (Exception unused) {
                if (zipFile == null) {
                    return;
                }
                zipFile.close();
            } catch (Throwable th) {
                th = th;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            zipFile = null;
        } catch (Throwable th2) {
            zipFile = null;
        }
        try {
            zipFile.close();
        } catch (IOException unused4) {
        }
    }


    public static void m263a(Object obj, StringBuilder sb) {
        java.lang.String hexString;
        int lastIndexOf;
        if (obj == null) {
            hexString = "null";
        } else {
            java.lang.String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb.append(hexString);
    }


    public static void m265a(Map<java.lang.String, java.lang.String> map, File[] fileArr, java.lang.String str) {
//        if (C2913b.m5720a(fileArr)) {
//            return;
//        }
//        for (File file : fileArr) {
//            java.lang.String str2 = map.get(file.getAbsolutePath());
//            java.lang.String m5710a = C2913b.m5710a(file);
//            if (!m5710a.equals(str2)) {
//                throw new IllegalStateException("wrong " + str + " checksum, expected is " + str2 + ", actual is " + m5710a);
//            }
//        }
    }


    public static void m266a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }


    public static void m267a(boolean z, java.lang.String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }


    public static boolean m268a(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }


//    public static boolean m270a(C0173d.a aVar, C0173d.a aVar2, C0173d.a aVar3, C0173d.a aVar4) {
//        return (aVar3 == C0173d.a.FIXED || aVar3 == C0173d.a.WRAP_CONTENT || (aVar3 == C0173d.a.MATCH_PARENT && aVar != C0173d.a.WRAP_CONTENT)) || (aVar4 == C0173d.a.FIXED || aVar4 == C0173d.a.WRAP_CONTENT || (aVar4 == C0173d.a.MATCH_PARENT && aVar2 != C0173d.a.WRAP_CONTENT));
//    }


    public static boolean m272a(Context context, int i, boolean z) {
        TypedValue m333d = m333d(context, i);
        return (m333d == null || m333d.type != 18) ? z : m333d.data != 0;
    }
    public static ImageDialog2 m211a(Activity activity, View view) {
        return m212a(activity, view, 1.0f, 0.0f);
    }
    public static ImageDialog2 m212a(Activity activity, View view, float f, float f2) {
        ImageDialog2 dialogC2002k = new ImageDialog2(activity);
        if (f == 0.0f) {
            f = 1.0f;
        }
        if (view != null) {
            try {
                dialogC2002k.f8263n = view;
                if (f2 > 0.0f) {
                    dialogC2002k.f8255f = f2;
                }
                dialogC2002k.f8254e = f;
                dialogC2002k.f8255f = f2;
                dialogC2002k.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        ((Window) Objects.requireNonNull(dialogC2002k.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        return dialogC2002k;
    }
    public static boolean m273a(Rect rect, Rect rect2, int i) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
        }
        if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
    }


    public static boolean m274a(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        return drawable.canApplyTheme();
    }


    public static boolean m275a(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (!f213j) {
            try {
                f212i = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f212i.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e2);
            }
            f213j = true;
        }
        Method method = f212i;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception e3) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                f212i = null;
            }
        }
        return false;
    }


    public static boolean m276a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }



    public static Drawable[] m286a(TextView textView) {
        int i = Build.VERSION.SDK_INT;
        return textView.getCompoundDrawablesRelative();
    }


    public static java.lang.String[] m287a(Date date, Date date2) {
        java.lang.String[] strArr = new java.lang.String[2];
        if (date != null && date2 != null) {
            long time = date2.getTime() - date.getTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            if (calendar.get(1) > calendar2.get(1) && calendar.get(6) > calendar2.get(6)) {
                return new java.lang.String[0];
            }
            int i = -(((int) Math.floor(time / 8.64E7f)) + 1);
            calendar.add(5, i);
            strArr[0] = date2Str(calendar.getTime());
            calendar2.add(5, i);
            strArr[1] = date2Str(calendar2.getTime());
        }
        return strArr;
    }


    public static float getFontSize() {
        int i = UserVM.sharedPreferences.getInt("font_size", 1);
        if (i != 0) {
            return i != 2 ? 1.0f : 1.15f;
        }
        return 0.85f;
    }


    public static int getTypeValue(Context context, int i, java.lang.String str) {
        TypedValue m333d = m333d(context, i);
        if (m333d != null) {
            return m333d.data;
        }
        return 0;
    }


    public static Animation m299b(View view, long j, int i) {
        if (i == 0) {
            view.measure(-1, -2);
        }
        if (i == 0) {
            i = view.getMeasuredHeight();
        }
        view.getLayoutParams().height = 0;
        view.setVisibility(View.VISIBLE);
        MyAni myAni = new MyAni(view, i);
        if (j == 0) {
            j = ((int) (i / view.getContext().getResources().getDisplayMetrics().density)) * 2;
        }
        myAni.setDuration(j);
        view.startAnimation(myAni);
        return myAni;
    }



    public static java.lang.String m303b(float f) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        if (f < 0.0f) {
            StringBuilder m3163a = CustomString.format("-");
            m3163a.append(Math.abs(f));
            str = m3163a.toString();
        } else {
            str = "";
        }
        int floor = (int) Math.floor(f / 1.0E8f);
        int floor2 = (int) Math.floor((f % 1.0E8f) / 10000.0f);
        float f2 = f % 10000.0f;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(' ');
        if (floor > 0) {
            str2 = floor + "억";
        } else {
            str2 = "";
        }
        StringBuilder m3163a2 = CustomString.format(str2);
        if (floor2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(floor > 0 ? " " : "");
            sb.append(floor2);
            sb.append("만");
            str3 = sb.toString();
        } else {
            str3 = "";
        }
        m3163a2.append(str3);
        StringBuilder m3163a3 = CustomString.format(m3163a2.toString());
        Object obj = "";
        obj = "";
        if (f2 > 0.0f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append((floor > 0 || floor2 > 0) ? " " : "");
            sb2.append(new DecimalFormat("#,####.##", decimalFormatSymbols).format(f2));
            obj = sb2.toString();
        } else if (floor <= 0 && floor2 <= 0) {
            obj = 0;
        }
        m3163a3.append(obj);
        return CustomString.append(str, m3163a3.toString());
    }


    public static java.lang.String m304b(float f, boolean z) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(' ');
        return ((!z || (f < 50.0f && f > -50.0f)) ? new DecimalFormat("#,##0.00", decimalFormatSymbols) : new DecimalFormat("#,##0.##", decimalFormatSymbols)).format(f);
    }
    public static java.lang.String m217a(float f) {
        return m218a(f, false);
    }
    public static java.lang.String m218a(float f, boolean z) {
        BigDecimal scale = new BigDecimal(f).setScale(2, RoundingMode.HALF_EVEN);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(' ');
        return (z ? new DecimalFormat("#,###.##", decimalFormatSymbols) : new DecimalFormat("#,###", decimalFormatSymbols)).format(scale);
    }
    public static java.lang.String m305b(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        java.lang.String string;
        PackageManager packageManager = context.getPackageManager();
        int i = Build.VERSION.SDK_INT;
        int i2 = 640;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            i2 = 269222528;
        } else if (i3 >= 24) {
            i2 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2);
        int i4 = Build.VERSION.SDK_INT;
        java.lang.String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        if (activityInfo.metaData == null || (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }


    public static java.lang.String m306b(java.lang.String str, java.lang.String str2) {
        return "";//m223a(str, str2, false, false);
    }

    @SuppressLint({"SimpleDateFormat"})

    public static java.lang.String m307b(Date date) {
        if (date == null) {
            date = new Date();
        }
        return new java.text.SimpleDateFormat("yyyy.M.d. HH:mm").format(date);
    }


    public static void m309b(Context context, int i, int i2) {
        toast(context, context.getString(i), "default", 0, i2);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})

    public static void m310b(Context context, View view) {
        view.setBackgroundResource(R.drawable.bd_round_white_button);
        com.jeil.emarket.components.textview.TextView textView = (com.jeil.emarket.components.textview.TextView) view;
        textView.setTextColor(context.getResources().getColor(R.color.dark));
        textView.setTextSize(1, 11.0f);
    }


    public static void m312b(Drawable drawable, int i) {
        int i2 = Build.VERSION.SDK_INT;
        drawable.setTint(i);
    }


    public static void m314b(TextView textView, int i) {
        m164a(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = Build.VERSION.SDK_INT;
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i3);
        }
    }


    public static Date[] m319b(int i, boolean z) {
        Date date;
        Date date2;
        Date date3 = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        calendar.get(7);
        switch (i) {
            case 0:
                date = date3;
                break;
            case 1:
                date = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 1);
                date2 = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 1);
                date3 = date2;
                break;
            case 2:
                date = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 6);
                break;
            case 3:
                date = new Date(date3.getYear(), date3.getMonth(), (date3.getDate() - date3.getDay()) + 1);
                break;
            case 4:
                date = new Date(date3.getYear(), date3.getMonth(), (date3.getDate() - date3.getDay()) - 6);
                date2 = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - date3.getDay());
                date3 = date2;
                break;
            case 5:
                date = new Date(date3.getYear(), date3.getMonth(), date3.getDate() - 29);
                break;
            case 6:
                date = new Date(date3.getYear(), date3.getMonth(), 1);
                break;
            case 7:
                date = new Date(date3.getYear(), date3.getMonth() - 1, 1);
                date2 = new Date(date3.getYear(), date3.getMonth(), 0);
                date3 = date2;
                break;
            case 8:
                date = new Date(date3.getYear(), 0, 1);
                break;
            case 9:
                if (z) {
                    date = null;
                    date3 = null;
                    break;
                }
            default:
                date = null;
                break;
        }
        return new Date[]{date, date3};
    }




    public static int m321c(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }


//    public static int m322c(TypedArray typedArray, XmlPullParser xmlPullParser, java.lang.String str, int i, int i2) {
//        return !m281a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
//    }


    public static int m323c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (!f215l) {
            try {
                f214k = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f214k.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e2);
            }
            f215l = true;
        }
        Method method = f214k;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e3) {
                Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e3);
                f214k = null;
            }
        }
        return 0;
    }


    public static Path m324c(java.lang.String str) {
        return null;
//        Path path = new Path();
//        C0231c[] m318b = m318b(str);
//        if (m318b == null) {
//            return null;
//        }
//        try {
//            C0231c.m1088a(m318b, path);
//            return path;
//        } catch (RuntimeException e2) {
//            throw new RuntimeException(CustomString.append("Error in parsing ", str), e2);
//        }
    }


    public static final synchronized Object m326c() {
        Object obj = null;
//        synchronized (C2912a.class) {
//            if (f224u == null) {
//                f224u = C2913b.m5706a(ActivityThread(), "currentActivityThread", new Object[0]);
//            }
//            obj = f224u;
//        }
        return obj;
    }


    public static java.lang.String m327c(float f) {
        return m304b(f, false);
    }


    public static void m329c(Context context, int i) {
        toast(context, context.getString(i), "default", 0, 0);
    }


    public static void m330c(Context context, java.lang.String str) {
//        C2906f m5682a = C2906f.m5682a(context);
//        File file = m5682a.f10549c;
//        C2913b.m5728b(file, new File(file, str));
//        m5682a.m5685a(new File(m5682a.f10548b, str));
    }


    public static void m331c(TextView textView, int i) {
        m164a(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            //textView.setLineSpacing(i - r0, 1.0f);
        }
    }


    public static boolean m332c(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }


    public static TypedValue m333d(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }



    public static java.lang.String m335d(Context context, java.lang.String str) {
        return str == null ? "" : getIdentifier(context, str, "");
    }



    public static void m337d(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }



//    public static boolean m340d(View view) {
//        return ViewCompat.m1310m(view) == 1;
//    }


    public static Date[] m341d(int i) {
        return m319b(i, false);
    }


//    public static Drawable m342e(Drawable drawable) {
//        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof TintAwareDrawable)) ? new C0242d(drawable) : drawable;
//    }


    public static java.lang.String m343e(int i) {
        char[] charArray = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(charArray[random.nextInt(charArray.length)]);
        }
        return sb.toString();
    }


    public static java.lang.String m344e(Context context) {
        return "";
//        Cursor m5697a = new C2910j(context).m5697a(Uri.parse("jeil://patch_info_provider/query_working_checksum"));
//        if (m5697a == null || !m5697a.moveToFirst()) {
//            return "";
//        }
//        java.lang.String string = m5697a.getString(0);
//        m5697a.close();
//        return string;
    }


    public static java.lang.String m345e(java.lang.String str) {
        return m306b(str, "xl");
    }


    public static  void m346e(View view) {
        view.setVisibility(View.GONE);
        view.getLayoutParams().height = 0;
    }


    public static byte[] m347e(Context context, java.lang.String str) {
        return new byte[0];
//        KeyStore keyStore;
//        java.lang.String string;
//        FileInputStream fileInputStream;
//        try {
//            keyStore = KeyStore.getInstance("PKCS12");
//            string = UserVM.sharedPreferences.getString("cid", "");
//            fileInputStream = new FileInputStream(context.getFilesDir().getPath() + "/cert.p12");
//        } catch (Exception e2) {
//            e2.printStackTrace();
//        }
//        if (string == null || string.isEmpty()) {
//            throw new Exception("empty CID");
//        }
//        keyStore.load(fileInputStream, string.toCharArray());
//        Enumeration<java.lang.String> aliases = keyStore.aliases();
//        if (!aliases.hasMoreElements()) {
//            fileInputStream.close();
//            return new byte[0];
//        }
//        PrivateKey privateKey = (PrivateKey) keyStore.getKey(aliases.nextElement(), string.toCharArray());
//        Signature signature = Signature.getInstance("SHA256withRSA");
//        signature.initSign(privateKey);
//        signature.update(str.getBytes(StandardCharsets.UTF_8));
//        fileInputStream.close();
//        return signature.sign();
    }

    /* renamed from: f */
    public static int m348f(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    /* renamed from: f */
    public static java.lang.String m349f(java.lang.String str) {
        if (str == null) {
            return "";
        }
        if (!str.startsWith("http://")) {
            return str;
        }
        int indexOf = str.substring(7).indexOf("/");
        return indexOf > -1 ? str.substring(indexOf + 7) : "";
    }

    /* renamed from: f */
    public static void m350f(Context context, java.lang.String str) {
        toast(context, str, "default", 0, 0);
    }

    /* renamed from: f */
    public static boolean m351f(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    /* renamed from: g */
    public static int m352g(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        throw new IllegalArgumentException(CustomString.m3176b("type needs to be >= FIRST and <= LAST, type=", i));
    }

    /* renamed from: g */
    public static java.lang.String m353g(java.lang.String str) {
        List<TicketCategory> m2579a = TicketCategoryListVM.ticketCategoryList.getValue();
        if (m2579a != null) {
            for (TicketCategory ticketCategory : m2579a) {
                if (ticketCategory._id.equals(str)) {
                    return ticketCategory.name;
                }
            }
        }
        return "";
    }

    /* renamed from: g */
    public static boolean m354g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    /* renamed from: g */
    public static boolean m355g(Context context, java.lang.String str) {
        return false;
//        C2910j c2910j = new C2910j(context);
//        StringBuilder sb = new StringBuilder();
//        sb.append("jeil://patch_info_provider/set_working_checksum?checksum=");
//        sb.append(str);
//        return c2910j.m5696a(Uri.parse(sb.toString()), (ContentValues) null) > 0;
    }

    /* renamed from: h */
    public static boolean m356h(int i) {
        return i >= 28 && i <= 31;
    }

    /* renamed from: h */
    public static boolean m357h(java.lang.String str) {
        return str.length() == 10 && str.charAt(0) == '2' && !str.substring(0, 3).equals("237");
    }

    
    public static Shader.TileMode m358i(int i) {
        return i != 1 ? i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    @SuppressLint({"SimpleDateFormat"})
    
    public static Date m359i(java.lang.String str) {
        try {
            return new java.text.SimpleDateFormat("yyyy.M.d.").parse(str);
        } catch ( Exception unused) {
            return new Date();
        }
    }

    



    public static void m311b(Drawable drawable) {
//        DrawableContainer.DrawableContainerState drawableContainerState;
//        Drawable drawable2;
//        int i = Build.VERSION.SDK_INT;
//        drawable.clearColorFilter();
//        if (i >= 23) {
//            return;
//        }
//        if (drawable instanceof InsetDrawable) {
//            drawable2 = ((InsetDrawable) drawable).getDrawable();
//        } else if (drawable instanceof InterfaceC0240b) {
//            drawable2 = ((C0241c) drawable).f1668g;
//        } else {
//            if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
//                return;
//            }
//            int childCount = drawableContainerState.getChildCount();
//            for (int i2 = 0; i2 < childCount; i2++) {
//                Drawable child = drawableContainerState.getChild(i2);
//                if (child != null) {
//                    m311b(child);
//                }
//            }
//            return;
//        }
//        m311b(drawable2);
    }


    public static java.lang.String m328c(int i) {
        if (i == 0 || CategoryVM.listMutableLiveData.getValue() == null || CategoryVM.listMutableLiveData.getValue().size() == 0) {
            return "";
        }
        java.lang.String str = "";
        for (int i2 = 0; i2 < CategoryVM.listMutableLiveData.getValue().size(); i2++) {
            Category category = CategoryVM.listMutableLiveData.getValue().get(i2);
            List<Category> list = category.children;
            if (list != null && list.size() != 0) {
                java.lang.String str2 = str;
                for (int i3 = 0; i3 < category.children.size(); i3++) {
                    Category category2 = category.children.get(i3);
                    List<Category> list2 = category2.children;
                    if (list2 != null && list2.size() != 0) {
                        java.lang.String str3 = str2;
                        for (int i4 = 0; i4 < category2.children.size(); i4++) {
                            if (category2.children.get(i4).f12393id == i) {
                                java.lang.String str4 = category2.children.get(i4).tree;
                                StringBuilder sb = new StringBuilder();
                                if (str4 == null || ((List) Objects.requireNonNull(CategoryVM.listMutableLiveData.getValue())).size() == 0) {
                                    str3 = "";
                                } else {
                                    java.lang.String[] split = str4.split(",");
                                    List<Category> m2579a = CategoryVM.listMutableLiveData.getValue();
                                    for (int i5 = 0; i5 < split.length; i5++) {
                                        if (Integer.parseInt(split[i5]) < m2579a.size() && m2579a.get(Integer.parseInt(split[i5])) != null) {
                                            sb.append(m2579a.get(Integer.parseInt(split[i5])).name);
                                            if (m2579a.get(Integer.parseInt(split[i5])).children != null && m2579a.get(Integer.parseInt(split[i5])).children.size() != 0) {
                                                m2579a = m2579a.get(Integer.parseInt(split[i5])).children;
                                                if (i5 < split.length - 1) {
                                                    sb.append(" > ");
                                                }
                                            }
                                        }
                                    }
                                    str3 = sb.toString();
                                }
                            }
                        }
                        str2 = str3;
                    }
                }
                str = str2;
            }
        }
        return str;
    }



    public static void download(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            ZipFile zipFile = new ZipFile(str);
            ZipFile zipFile2 = new ZipFile(str3);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            Enumeration<? extends ZipEntry> entries2 = zipFile2.entries();
            ArrayList<java.lang.String> arrayList = new ArrayList();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!arrayList.contains(nextElement.getName())) {
                    arrayList.add(nextElement.getName());
                }
            }
            while (entries2.hasMoreElements()) {
                ZipEntry nextElement2 = entries2.nextElement();
                if (!arrayList.contains(nextElement2.getName())) {
                    arrayList.add(nextElement2.getName());
                }
            }
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2 + ".apk")));
            BufferedInputStream bufferedInputStream3 = null;
            for (java.lang.String str4 : arrayList) {
                ZipEntry entry = zipFile.getEntry(str4);
                ZipEntry entry2 = zipFile2.getEntry(str4);
                if (entry == null || entry2 == null) {
                    if (entry2 != null) {
                        inputStream = zipFile2.getInputStream(entry2);
                        try {
                            byte[] bArr = new byte[1024];
                            File file = new File(str2 + "/" + str4);
                            File parentFile = file.getParentFile();
                            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                                throw new IOException("can't create parent directories");
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + str4);
                           // fileOutputStream.write(m283a(inputStream));
                            fileOutputStream.close();
                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 1024);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(entry2.getName()));
                                while (true) {
                                    int read = bufferedInputStream2.read(bArr, 0, 1024);
                                    if (read != -1) {
                                        zipOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e2) {
                                            inputStream.close();
                                            bufferedInputStream3 = bufferedInputStream;
                                        }
                                    }
                                }
                                bufferedInputStream2.close();
                                if (!file.delete()) {
                                    throw new IOException("can't delete newly created files");
                                }
                            } finally {
                            }
                        } catch (Exception e3) {
                            //e = e3;
                            bufferedInputStream = bufferedInputStream3;
                        }
                    } else if (entry != null) {
                        inputStream = zipFile.getInputStream(entry);
                        try {
                            byte[] bArr2 = new byte[1024];
                            File file2 = new File(str2 + "/" + str4);
                            File parentFile2 = file2.getParentFile();
                            if (parentFile2 != null && !parentFile2.exists() && !parentFile2.mkdirs()) {
                                throw new IOException("can't create parent directories");
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(str2 + "/" + str4);
                            //fileOutputStream2.write(m283a(inputStream));
                            fileOutputStream2.close();
                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2), 1024);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(entry.getName()));
                                while (true) {
                                    int read2 = bufferedInputStream2.read(bArr2, 0, 1024);
                                    if (read2 != -1) {
                                        zipOutputStream.write(bArr2, 0, read2);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e4) {
                                            inputStream.close();
                                            bufferedInputStream3 = bufferedInputStream;
                                        }
                                    }
                                }
                                bufferedInputStream2.close();
                            } catch (Throwable th) {
                                throw th;
                            }
                        } catch (Exception e5) {
                           // e = e5;
                            bufferedInputStream = bufferedInputStream3;
                        }
                    } else {
                        continue;
                    }
                    inputStream.close();
                    bufferedInputStream3 = bufferedInputStream;
                } else {
                    try {
                        InputStream inputStream2 = zipFile.getInputStream(entry);
                        InputStream inputStream3 = zipFile2.getInputStream(entry2);
                        byte[] bArr3 = new byte[1024];
                        File file3 = new File(str2 + "/" + str4);
                        File parentFile3 = file3.getParentFile();
                        if (parentFile3 != null && !parentFile3.exists() && !parentFile3.mkdirs()) {
                            throw new IOException("can't create parent directory");
                        }
                        //m262a(inputStream2, inputStream3, file3);
                        bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file3), 1024);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(entry.getName()));
                            while (true) {
                                int read3 = bufferedInputStream2.read(bArr3, 0, 1024);
                                if (read3 != -1) {
                                    zipOutputStream.write(bArr3, 0, read3);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e6) {
                                        bufferedInputStream3 = bufferedInputStream2;
                                    }
                                }
                            }
                            bufferedInputStream2.close();
                            if (!file3.delete()) {
                                throw new IOException("can't delete newly created files");
                            }
                            inputStream2.close();
                            inputStream3.close();
                            bufferedInputStream3 = bufferedInputStream2;
                        } finally {
                        }
                    } catch (Exception e7) {
                    }
                }
            }
            boolean z = false;
            zipFile.close();
            zipFile2.close();
            zipOutputStream.close();
            if (bufferedInputStream3 != null) {
                bufferedInputStream3.close();
            }
            if (new File(str3).delete()) {
                if (str2 != null) {
                    int length = str2.length();
                    for (int i = 0; i < length; i++) {
                        if (!Character.isWhitespace(str2.charAt(i))) {
                            break;
                        }
                    }
                }
                z = true;
                File file4 = z ? null : new File(str2);
                if (file4 == null) {
                    return;
                }
                if (file4.isDirectory()) {
                    //m277a(file4);
                    return;
                } else {
                    if (file4.exists() && file4.isFile()) {
                        file4.delete();
                        return;
                    }
                    return;
                }
            }
            throw new IOException("can't delete diff files");
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

 
 

    public static void toast(Context context, int i, java.lang.String str) {
        toast(context, context.getString(i), str, 0, 0);
    }

 


    public static void m257a(MainActivity mainActivity, java.lang.String str) {
        Intent intent;
        int i = 0;
        if (str.startsWith("/product/")) {
            try {
                i = Integer.parseInt(str.substring(9));
            } catch (Exception unused) {
            }
            if (i > 0) {
                ProductTotalVM.m5467b(mainActivity, i);
                Intent intent2 = new Intent(mainActivity, ProductActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.putExtra("id", i);
                mainActivity.startActivity(intent2);
                return;
            }
            return;
        }
        try {
            if (str.startsWith("/vendor/")) {
                intent = new Intent(mainActivity, VendorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("id", Integer.parseInt(str.substring(8)));
                intent.putExtra("tabPosition", 1);
            } else {
                if (!str.startsWith("/collections/")) {
                    if (str.startsWith("/fbts")) {
                        Intent intent3 = new Intent(mainActivity, FBTCollectionActivity.class);
                        intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        mainActivity.startActivity(intent3);
                        return;
                    } else {
                        if (str.startsWith("/sale/today")) {
                            mainActivity.m6457g(R.id.navigation_deals);
                            return;
                        }
                        return;
                    }
                }
                intent = new Intent(mainActivity, ShopActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("collection_id", Integer.parseInt(str.substring(13)));
            }
            mainActivity.startActivity(intent);
        } catch (Exception unused2) {
            toast(mainActivity, mainActivity.getString(R.string.incorrect_banner_url), "error", 0, 0);
        }
    }
 


 


    public static ImageDialog2 getImageDialog2(Activity activity, View view, float f, float f2) {
        ImageDialog2 imageDialog2 = new ImageDialog2(activity);
        if (f == 0.0f) {
            f = 1.0f;
        }
        if (view != null) {
            try {
                imageDialog2.f8263n = view;
                if (f2 > 0.0f) {
                    imageDialog2.f8255f = f2;
                }
                imageDialog2.f8254e = f;
                imageDialog2.f8255f = f2;
                imageDialog2.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        ((Window) Objects.requireNonNull(imageDialog2.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
        return imageDialog2;
    }
 
}

