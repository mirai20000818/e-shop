package com.jeil.emarket.adapters.fbt;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.product.ProductActivity;
import com.jeil.emarket.activities.product.ShopActivity;
import com.jeil.emarket.activities.vendor.VendorActivity;
import com.jeil.emarket.adapters.base.BaseMainAdapter;
import com.jeil.emarket.api.API_PROVIDER;
import com.jeil.emarket.components.price.ProductPrice;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.interf.InterfaceContext;
import com.jeil.emarket.model.customer.CartProduct;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.viewmodel.CartProductVM;
import com.jeil.emarket.viewmodel.ProductTotalVM;

/* renamed from: b.f.a.b.h.s */

public class ProductAdapter extends BaseMainAdapter<Product, RecyclerView.ViewHolder> {

    /* renamed from: f */
    public final String f7589f;

    /* renamed from: g */
    public int f7590g;

    /* renamed from: h */
    public int f7591h;

    
    public int f7592i;

   
    public int f7593j;

    
    public int f7594k;

    /* renamed from: l */
    public boolean f7595l;

    /* renamed from: b.f.a.b.h.s$a */
    public class a implements RequestListener<Drawable> {

        
        public final  Context f7596a;

        
        public final  ImageView f7597b;

        public a(ProductAdapter c1879s, Context context, ImageView imageView) {
            this.f7596a = context;
            this.f7597b = imageView;
        }

       // @Override // p078b.p095c.p096a.p118s.InterfaceC1020e
        
        public boolean mo3790a(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }

       // @Override // p078b.p095c.p096a.p118s.InterfaceC1020e
        
        public boolean mo3791a(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            this.f7597b.startAnimation(AnimationUtils.loadAnimation(this.f7596a, R.anim.fade_in));
            return false;
        }

        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Drawable> target, boolean b) {
            return false;
        }

        @Override
        public boolean onResourceReady(Drawable drawable, Object o, Target<Drawable> target, DataSource dataSource, boolean b) {
            return false;
        }
    }

    /* renamed from: b.f.a.b.h.s$b */
    public class b implements RequestListener<Drawable> {

        
        public final  Context f7598a;

        
        public final  ImageView f7599b;

        public b(ProductAdapter c1879s, Context context, ImageView imageView) {
            this.f7598a = context;
            this.f7599b = imageView;
        }

       // @Override // p078b.p095c.p096a.p118s.InterfaceC1020e
        
        public boolean mo3790a(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }

       // @Override // p078b.p095c.p096a.p118s.InterfaceC1020e
        
        public boolean mo3791a(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            this.f7599b.startAnimation(AnimationUtils.loadAnimation(this.f7598a, R.anim.fade_in));
            return false;
        }

        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Drawable> target, boolean b) {
            return false;
        }

        @Override
        public boolean onResourceReady(Drawable drawable, Object o, Target<Drawable> target, DataSource dataSource, boolean b) {
            return false;
        }
    }

    /* renamed from: b.f.a.b.h.s$c */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public MaterialRippleLayout f7600t;

        /* renamed from: u */
        public AppCompatImageView f7601u;

        public c(View view) {
            super(view);
            this.f7600t = (MaterialRippleLayout) view.findViewById(R.id.mrl_main);
            this.f7601u = (AppCompatImageView) view.findViewById(R.id.iv_featured_banner_img);
        }
    }

    /* renamed from: b.f.a.b.h.s$d */
    public static class d extends RecyclerView.ViewHolder {

        
        public TextView f7602A;

        
        public TextView f7603B;

        
        public ProductPrice f7604C;

        
        public TextView f7605D;

        
        public AppCompatImageView f7606E;

        /* renamed from: F */
        public TextView f7607F;

        /* renamed from: G */
        public TextView f7608G;

        /* renamed from: H */
        public TextView f7609H;

        
        public ProgressBar f7610I;

       
        public TextView f7611J;

        
        public LinearLayoutCompat f7612K;

        /* renamed from: L */
        public CountDownTimer f7613L;

        /* renamed from: t */
        public MaterialRippleLayout f7614t;

        /* renamed from: u */
        public MaterialRippleLayout f7615u;

        /* renamed from: v */
        public MaterialRippleLayout f7616v;

        /* renamed from: w */
        public AppCompatImageView f7617w;

        /* renamed from: x */
        public ImageView f7618x;

        /* renamed from: y */
        public TextView f7619y;

        /* renamed from: z */
        public TextView f7620z;

        public d(View view) {
            super(view);
            this.f7615u = (MaterialRippleLayout) view.findViewById(R.id.mrl_main);
            this.f7618x = (ImageView) view.findViewById(R.id.iv_product_img);
            this.f7604C = (ProductPrice) view.findViewById(R.id.pp_price);
            this.f7620z = (TextView) view.findViewById(R.id.tv_monthly_badge);
            this.f7602A = (TextView) view.findViewById(R.id.tv_new_product_badge);
            this.f7614t = (MaterialRippleLayout) view.findViewById(R.id.mrl_cart);
            this.f7617w = (AppCompatImageView) view.findViewById(R.id.iv_cart);
            this.f7619y = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7603B = (TextView) view.findViewById(R.id.tv_out_of_stock);
            view.findViewById(R.id.vw_out_of_stock);
            this.f7616v = (MaterialRippleLayout) view.findViewById(R.id.mrl_wishlist);
            this.f7605D = (TextView) view.findViewById(R.id.tv_vendor_name);
            this.f7606E = (AppCompatImageView) view.findViewById(R.id.iv_rating);
            this.f7607F = (TextView) view.findViewById(R.id.tv_reviews);
            this.f7608G = (TextView) view.findViewById(R.id.tv_reviews_count);
            this.f7609H = (TextView) view.findViewById(R.id.tv_discount_label);
            this.f7610I = (ProgressBar) view.findViewById(R.id.pb_progress_time);
            this.f7611J = (TextView) view.findViewById(R.id.ctv_remain_time);
            this.f7612K = (LinearLayoutCompat) view.findViewById(R.id.llc_remain_time);
        }
    }

    /* renamed from: b.f.a.b.h.s$e */
    public static class e extends RecyclerView.ViewHolder {

        
        public LinearLayoutCompat f7621A;

        
        public View f7622B;

        /* renamed from: t */
        public FrameLayout f7623t;

        /* renamed from: u */
        public MaterialRippleLayout f7624u;

        /* renamed from: v */
        public ImageView f7625v;

        /* renamed from: w */
        public TextView f7626w;

        /* renamed from: x */
        public TextView f7627x;

        /* renamed from: y */
        public TextView f7628y;

        /* renamed from: z */
        public ProductPrice f7629z;

        public e(View view) {
            super(view);
            this.f7624u = (MaterialRippleLayout) view.findViewById(R.id.mrl_main);
            this.f7621A = (LinearLayoutCompat) view.findViewById(R.id.ll_main);
            this.f7625v = (ImageView) view.findViewById(R.id.iv_product_img);
            this.f7629z = (ProductPrice) view.findViewById(R.id.pp_price);
            this.f7623t = (FrameLayout) view.findViewById(R.id.fr_main);
            this.f7626w = (TextView) view.findViewById(R.id.tv_product_name);
            this.f7627x = (TextView) view.findViewById(R.id.tv_monthly_badge);
            this.f7628y = (TextView) view.findViewById(R.id.tv_out_of_stock);
            this.f7622B = view.findViewById(R.id.v_border);
            view.findViewById(R.id.vw_out_of_stock);
        }
    }

    /* renamed from: b.f.a.b.h.s$f */
    public static class f extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final View f7630t;

        /* renamed from: u */
        public final LinearLayoutCompat f7631u;

        public f(View view) {
            super(view);
            this.f7630t = view.findViewById(R.id.vw_product_img);
            this.f7631u = (LinearLayoutCompat) view.findViewById(R.id.llc_remain_time);
        }
    }

    /* renamed from: b.f.a.b.h.s$g */
    public static class g extends RecyclerView.ViewHolder {

        /* renamed from: t */
        public final View f7632t;

        /* renamed from: u */
        public final View f7633u;

        /* renamed from: v */
        public FrameLayout f7634v;

        public g(View view) {
            super(view);
            this.f7632t = view.findViewById(R.id.vw_product_img);
            this.f7634v = (FrameLayout) view.findViewById(R.id.fr_main);
            this.f7633u = view.findViewById(R.id.v_border);
        }
    }

    public ProductAdapter(BaseActivity activityC1391g1, String str) {
        super(activityC1391g1);
        this.f7590g = 0;
        this.f7591h = 86400000;
        this.f7592i = 3600000;
        this.f7593j = 60000;
        this.f7594k = 1000;
        this.f7595l = false;
        this.baseActivity = activityC1391g1;
        this.f7589f = str;
    }

    
    public static  void m4484a(Product product, Context context, View view) {
        float f2;
        CartProduct cartProduct = new CartProduct();
        cartProduct.f12392id = product.f12407id;
        cartProduct.name = product.name;
        cartProduct.image = product.image;
        float f3 = 0.0f;
        if (product.currency.equals("kpf")) {
            f2 = product.salePrice;
            if (f2 <= 0.0f) {
                f2 = product.regularPrice;
            }
        } else {
            f2 = 0.0f;
        }
        cartProduct.priceKpf = f2;
        if (product.currency.equals("kpw")) {
            float f4 = product.salePrice;
            f3 = f4 > 0.0f ? f4 : product.regularPrice;
        }
        cartProduct.priceKpw = f3;
        cartProduct.enableBackOrder = product.enableBackOrder;
        cartProduct.quantity = 1;
        cartProduct.currency = product.currency;
        cartProduct.stock = product.stock;
        cartProduct.vendorId = product.vendorId;
        cartProduct.vendorName = product.vendorName;
        cartProduct.checked = true;
        CartProductVM.m5571a(cartProduct, (BaseActivity) context);
    }

    
    public final void m4485a(Context context, ImageView imageView, Product product, String str) {
        RequestBuilder<Drawable> m3325d;
        RequestListener<Drawable> aVar;
        String str2 = product.image;
        if (str2 == null || str2.isEmpty()) {
            m3325d = Glide.with(context).load(this.baseActivity.getResources().getDrawable(R.drawable.ic_placeholder));
            aVar = new a(this, context, imageView);
        } else {
//            String m223a = Util.m223a(product.image, str, true, true);
//            m3325d = (RequestBuilder) Glide.with(context).load(m223a).diskCacheStrategy(m223a.startsWith("file://") ? DiskCacheStrategy.DATA : DiskCacheStrategy.ALL);
//            aVar = new b(this, context, imageView);
        }
//        m3325d.m3315b(aVar).into(imageView);
    }

    
    public final void m4486a(final Context context, MaterialRippleLayout materialRippleLayout, final Product product) {
        materialRippleLayout.setDefaultRippleAlpha(5);
        materialRippleLayout.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.b.h.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductAdapter.this.m4493c(context, product, view);
            }
        });
    }

    
    public  void m4487a(Context context, Product product, Context context2) {
        ProductTotalVM.m5467b(context, product.f12407id);
        Intent intent = new Intent(context, ProductActivity.class);
        intent.putExtra("id", product.f12407id);
        intent.setFlags(!this.f7589f.equals("mini") ? Intent.FLAG_ACTIVITY_SINGLE_TOP : Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    
    public  void m4488a(final Context context, final Product product, View view) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.b.h.g
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ProductAdapter.this.m4487a(context, product, context2);
            }
        });
    }

    
    public final void m4489a(ProductPrice productPrice, Product product) {
        productPrice.setCurrency(product.currency);
        if (!product.type.equals("variable")) {
            float f2 = product.salePrice;
            if (f2 <= 0.0f) {
                productPrice.setPtSalePrice(Util.m327c(product.regularPrice));
                return;
            }
            productPrice.setPtSalePrice(Util.m327c(f2));
            float f3 = product.regularPrice;
            if (f3 <= 0.0f || f3 == product.salePrice) {
                productPrice.m6939a(false);
                return;
            } else {
                productPrice.setRegularPrice(Util.m327c(f3));
                return;
            }
        }
        String m327c = Util.m327c(product.minPrice);
        String m327c2 = Util.m327c(product.maxPrice);
        String m327c3 = Util.m327c(product.maxRegularPrice);
        if (product.maxRegularPrice > 0.0f && !m327c3.isEmpty() && m327c.equals(m327c2) && !m327c.equals(m327c3)) {
            productPrice.setPtSalePrice(m327c);
            productPrice.setRegularPrice(m327c3);
        } else {
            productPrice.m6938a(m327c, m327c2);
            productPrice.m6939a(false);
            productPrice.setFlVariableSingleLine(true);
        }
    }

    
    public  void m4490a(Product product, Context context) {
        Intent intent;
        BaseActivity activityC1391g1;
        int i;
        if (this.f7595l) {
            return;
        }
        this.f7595l = true;
        String m349f = Util.m349f(product.featuredBanner.link);
        if (m349f.startsWith("/product/")) {
            try {
                i = Integer.parseInt(m349f.substring(9));
            } catch (Exception unused) {
                i = 0;
            }
            if (i > 0) {
                ProductTotalVM.m5467b(this.baseActivity, i);
                Intent intent2 = new Intent(this.baseActivity, ProductActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.putExtra("id", i);
                this.baseActivity.startActivity(intent2);
            }
        } else {
            try {
                if (m349f.startsWith("/vendor/")) {
                    intent = new Intent(this.baseActivity, VendorActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("id", Integer.parseInt(m349f.substring(8)));
                    activityC1391g1 = this.baseActivity;
                } else if (m349f.startsWith("/collections/")) {
                    intent = new Intent(this.baseActivity, ShopActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("collection_id", Integer.parseInt(m349f.substring(13)));
                    activityC1391g1 = this.baseActivity;
                }
               // activityC1391g1.startActivity(intent);
            } catch (Exception unused2) {
                Util.toast(this.baseActivity, R.string.incorrect_banner_url, "error");
            }
        }
        this.f7595l = false;
    }

    
    public  void m4491a(Product product, Context context, Context context2) {
        ProductTotalVM.m5467b(this.baseActivity, product.f12407id);
        Intent intent = new Intent(context.getApplicationContext(), ProductActivity.class);
        intent.putExtra("id", product.f12407id);
        intent.setFlags(!this.f7589f.equals("mini") ? Intent.FLAG_ACTIVITY_SINGLE_TOP : Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public int getItemViewType(int i) {
        if (!this.f7589f.equals("grid") && !this.f7589f.equals("wishlist") && !this.f7589f.equals("monthly") && !this.f7589f.equals("deals") && !this.f7589f.equals("newProducts") && !this.f7589f.equals("collection")) {
            return (((Product) this.arrayList.get(i)).type == null || !((Product) this.arrayList.get(i)).type.equals("shimmer")) ? 2 : 1;
        }
        if (((Product) this.arrayList.get(i)).type == null || !((Product) this.arrayList.get(i)).type.equals("shimmer")) {
            return (((Product) this.arrayList.get(i)).type == null || !((Product) this.arrayList.get(i)).type.equals("banner")) ? 4 : 5;
        }
        return 3;
    }

    
    public  void m4492b(Context context, final Product product, View view) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.b.h.i
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ProductAdapter.this.m4490a(product, context2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    @android.annotation.SuppressLint({"SetTextI18n", "DefaultLocale"})
    
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(RecyclerView.ViewHolder r17, int r18) {
        /*
            Method dump skipped, instructions count: 1510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p078b.p159f.p160a.p178b.p186h.C1879s.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$c0, int):void");
    }

    
    public  void m4493c(final Context context, final Product product, View view) {
        API_PROVIDER.checkInternet(context, new InterfaceContext() { // from class: b.f.a.b.h.h
            @Override // p078b.p159f.p160a.p253h.InterfaceC2708b
            
            public final void mo4271a(Context context2) {
                ProductAdapter.this.m4491a(product, context, context2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0618f
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return i == 3 ? new f(from.inflate(R.layout.item_shimmer_product_grid, viewGroup, false)) : i == 4 ? new d(from.inflate(R.layout.item_product_grid, viewGroup, false)) : i == 1 ? new g(from.inflate(R.layout.item_shimmer_product_widget, viewGroup, false)) : i == 2 ? new e(from.inflate(R.layout.item_product_widget, viewGroup, false)) : i == 5 ? new c(from.inflate(R.layout.item_product_featured_banner, viewGroup, false)) : new d(from.inflate(R.layout.item_product_grid, viewGroup, false));
    }
}
