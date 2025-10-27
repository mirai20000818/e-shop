package com.jeil.emarket.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;


public class CircleImageView extends AppCompatImageView {

    /* renamed from: u */
    public static final ImageView.ScaleType f12006u = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: v */
    public static final Bitmap.Config f12007v = Bitmap.Config.ARGB_8888;

    
    public final RectF f12008d;

    
    public final RectF f12009e;

    /* renamed from: f */
    public final Matrix f12010f;

    /* renamed from: g */
    public final Paint f12011g;

    /* renamed from: h */
    public final Paint f12012h;

    
    public final Paint f12013i;

   
    public int f12014j;

    
    public int f12015k;

    /* renamed from: l */
    public int f12016l;

    /* renamed from: m */
    public int f12017m;

    /* renamed from: n */
    public Bitmap f12018n;

    /* renamed from: o */
    public BitmapShader f12019o;

    /* renamed from: p */
    public int f12020p;

    /* renamed from: q */
    public int f12021q;

    /* renamed from: r */
    public float f12022r;

    /* renamed from: s */
    public float f12023s;

    /* renamed from: t */
    public ColorFilter f12024t;

    public CircleImageView(Context context) {
        super(context);
        this.f12008d = new RectF();
        this.f12009e = new RectF();
        this.f12010f = new Matrix();
        this.f12011g = new Paint();
        this.f12012h = new Paint();
        this.f12013i = new Paint();
        this.f12014j = -16777216;
        this.f12015k = 0;
        this.f12016l = 0;
        this.f12017m = 0;
        super.setScaleType(f12006u);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }


    public final Bitmap m6820a(Drawable drawable) {
        if (drawable != null && drawable.getIntrinsicHeight() > 0) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f12007v) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f12007v);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }


    public final void m6821a() {
        this.f12012h.setStyle(Paint.Style.STROKE);
        this.f12012h.setAntiAlias(true);
        this.f12012h.setColor(this.f12014j);
        this.f12012h.setStrokeWidth(this.f12015k);
        this.f12013i.setStyle(Paint.Style.FILL);
        this.f12013i.setAntiAlias(true);
        this.f12013i.setColor(this.f12016l);
        this.f12009e.set(0.0f, 0.0f, getWidth() - this.f12017m, getHeight() - this.f12017m);
        this.f12023s = Math.min((this.f12009e.height() - this.f12015k) / 2.0f, (this.f12009e.width() - this.f12015k) / 2.0f);
        this.f12008d.set(this.f12009e);
        RectF rectF = this.f12008d;
        int i = this.f12015k;
        rectF.inset(i, i);
        this.f12022r = Math.min(this.f12008d.height() / 2.0f, this.f12008d.width() / 2.0f);
    }

    
    public final void m6822d() {
        float width;
        float f;
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.f12018n;
        if (bitmap == null) {
            m6821a();
            invalidate();
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f12019o = new BitmapShader(bitmap, tileMode, tileMode);
        this.f12011g.setAntiAlias(true);
        this.f12011g.setShader(this.f12019o);
        this.f12021q = this.f12018n.getHeight();
        this.f12020p = this.f12018n.getWidth();
        m6821a();
        this.f12010f.set(null);
        float f2 = 0.0f;
        if (this.f12008d.height() * this.f12020p > this.f12008d.width() * this.f12021q) {
            width = this.f12008d.height() / this.f12021q;
            f = (this.f12008d.width() - (this.f12020p * width)) * 0.5f;
        } else {
            width = this.f12008d.width() / this.f12020p;
            f2 = (this.f12008d.height() - (this.f12021q * width)) * 0.5f;
            f = 0.0f;
        }
        this.f12010f.setScale(width, width);
        Matrix matrix = this.f12010f;
        RectF rectF = this.f12008d;
        matrix.postTranslate(((int) (f + 0.5f)) + rectF.left, ((int) (f2 + 0.5f)) + rectF.top);
        this.f12019o.setLocalMatrix(this.f12010f);
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f12006u;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f12016l != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f12022r, this.f12013i);
        }
        if (this.f12018n != null) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f12022r, this.f12011g);
        }
        if (this.f12015k != 0) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f12023s, this.f12012h);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m6822d();
    }

    public void setBorderColor(int i) {
        if (i == this.f12014j) {
            return;
        }
        this.f12014j = i;
        this.f12012h.setColor(this.f12014j);
        invalidate();
    }

    public void setBorderWidth(int i) {
        if (i == this.f12015k) {
            return;
        }
        this.f12015k = i;
        m6822d();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.f12024t) {
            return;
        }
        this.f12024t = colorFilter;
        this.f12011g.setColorFilter(this.f12024t);
        invalidate();
    }

    public void setFillColor(int i) {
        if (i == this.f12016l) {
            return;
        }
        this.f12016l = i;
        this.f12013i.setColor(i);
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f12018n = m6820a(drawable);
        m6822d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f12018n = m6820a(getDrawable());
        m6822d();
    }

    public void setInsetLength(int i) {
        this.f12017m = i;
    }

    @SuppressLint("ResourceType")
    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12008d = new RectF();
        this.f12009e = new RectF();
        this.f12010f = new Matrix();
        this.f12011g = new Paint();
        this.f12012h = new Paint();
        this.f12013i = new Paint();
        this.f12014j = -16777216;
        this.f12015k = 0;
        this.f12016l = 0;
        this.f12017m = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i, 0);
        this.f12015k = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f12014j = obtainStyledAttributes.getColor(0, -16777216);
        this.f12016l = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
        super.setScaleType(f12006u);
    }
}
