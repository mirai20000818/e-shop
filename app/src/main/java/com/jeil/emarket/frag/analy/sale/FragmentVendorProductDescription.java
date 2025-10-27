package com.jeil.emarket.frag.analy.sale;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.activities.seller.VendorProductActivity;
import com.jeil.emarket.adapters.base.CenterImgRecycler;
import com.jeil.emarket.components.ActionLink;
import com.jeil.emarket.components.pickerview.PickerViewObj;
import com.jeil.emarket.components.price.PriceText;
import com.jeil.emarket.components.product.ProductAttributeSwatch;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.components.viewpager.CircleIndicator;
import com.jeil.emarket.components.viewpager.LoopViewPager;
import com.jeil.emarket.custom.CustomString;
import com.jeil.emarket.custom.Status;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.dialog.ImageDialog3;
import com.jeil.emarket.interf.InterfaceVariableProduct;
import com.jeil.emarket.model.customer.Product;
import com.jeil.emarket.model.customer.ProductDetail;
import com.jeil.emarket.providers.ProductsProvider;
import com.jeil.emarket.viewmodel.ProductTotalVM;
import com.jeil.emarket.widget.layout2.LinearLayoutCompat3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: b.f.a.g.d.c.n */

public class FragmentVendorProductDescription extends Fragment implements InterfaceVariableProduct {

    /* renamed from: a0 */
    public ProductsProvider f10090a0;

    /* renamed from: b0 */
    public int f10091b0;

    /* renamed from: c0 */
    public VendorProductActivity f10092c0;

    /* renamed from: d0 */
    public ProductDetail f10093d0;

    /* renamed from: e0 */
    public ImageDialog3 f10094e0;

    /* renamed from: f0 */
    public Boolean f10095f0 = false;

    /* renamed from: g0 */
    public Boolean f10096g0 = false;

    /* renamed from: h0 */
    public java.lang.String f10097h0;

    /* renamed from: i0 */
    public View f10098i0;

    public FragmentVendorProductDescription(VendorProductActivity vendorProductActivity, int i) {
        this.f10092c0 = vendorProductActivity;
        this.f10091b0 = i;
    }

    /* renamed from: S0 */
    public void m5374S0() {
        this.f10090a0 = (ProductsProvider) new ViewModelProvider(this).get(ProductsProvider.class);
        this.f10090a0.f10531d.setValue( Integer.valueOf(this.f10091b0));
        this.f10090a0.m5663a(this.f10092c0, this.f10091b0, false);
        new Handler().postDelayed(new Runnable() { // from class: b.f.a.g.d.c.m
            @Override // java.lang.Runnable
            public final void run() {
                FragmentVendorProductDescription.this.m5375T0();
            }
        }, Status.time);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    /* renamed from: T0 */
    public void m5375T0() {
        ProductTotalVM.f10236d.observe(getViewLifecycleOwner(), new Observer() { // from class: b.f.a.g.d.c.d
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                FragmentVendorProductDescription.this.m5379a((ProductDetail) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10098i0 = layoutInflater.inflate(R.layout.fragment_vendor_product_description, viewGroup, false);
        m5374S0();
        this.f10098i0.findViewById(R.id.vp_images).getLayoutParams().height = BaseActivity.anInt - this.f10092c0.m4299b(50);
        this.f10098i0.findViewById(R.id.vp_shimmer_images).getLayoutParams().height = BaseActivity.anInt - this.f10092c0.m4299b(50);
        return this.f10098i0;
    }


    public  void m5377a(ImageView imageView) {
        this.f10094e0.m4882a(0);
        ImageDialog3 dialogC2269y2 = this.f10094e0;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2713g
    @SuppressLint({"SetTextI18n"})

    public void mo4598a(Product.VariableProduct variableProduct) {
        if (variableProduct == null) {
            LoopViewPager loopViewPager = (LoopViewPager) this.f10098i0.findViewById(R.id.vp_images);
            if (loopViewPager != null) {
                loopViewPager.setCurrentItem(0);
            }
            m5378a(this.f10093d0.data);
            if (this.f10093d0.data.type.equals("variable")) {
                m5380a((Boolean) false);
                return;
            }
            return;
        }
        java.lang.String str = variableProduct.product.image;
        if (str != null && !str.isEmpty()) {
            LoopViewPager loopViewPager2 = (LoopViewPager) this.f10098i0.findViewById(R.id.vp_images);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f10093d0.data.image);
            for (Product.VariableProduct variableProduct2 : this.f10093d0.data.variableProducts) {
                java.lang.String str2 = variableProduct2.product.image;
                if (str2 != null && !str2.isEmpty()) {
                    if (!arrayList.contains(variableProduct2.product.image)) {
                        arrayList.add(variableProduct2.product.image);
                    }
                    if (variableProduct2.equals(variableProduct)) {
                        loopViewPager2.setCurrentItem(arrayList.contains(variableProduct2.product.image) ? arrayList.indexOf(variableProduct2.product.image) : 0);
                    }
                }
            }
        }
        m5380a((Boolean) true);
        m5378a(variableProduct.product);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})

    public final void m5378a(Product product) {
        ((PriceText) this.f10098i0.findViewById(R.id.pt_regular_price)).setCurrency(this.f10093d0.data.currency);
        ((PriceText) this.f10098i0.findViewById(R.id.pt_regular_price)).setHidePriceNumber(false);
        ((PriceText) this.f10098i0.findViewById(R.id.pt_regular_price)).setPrice(Util.m327c(product.regularPrice));
        ((PriceText) this.f10098i0.findViewById(R.id.pt_sale_price)).setCurrency(this.f10093d0.data.currency);
        ((PriceText) this.f10098i0.findViewById(R.id.pt_sale_price)).setHidePriceNumber(false);
        ((PriceText) this.f10098i0.findViewById(R.id.pt_sale_price)).setPrice(Util.m327c(product.salePrice));
        if (product.stock == 0) {
            this.f10098i0.findViewById(R.id.ctv_out_of_stock).setVisibility(View.VISIBLE);
            this.f10098i0.findViewById(R.id.ctv_stock).setVisibility(View.GONE);
            return;
        }
        this.f10098i0.findViewById(R.id.ctv_out_of_stock).setVisibility(View.GONE);
        this.f10098i0.findViewById(R.id.ctv_stock).setVisibility(View.VISIBLE);
        ((TextView) this.f10098i0.findViewById(R.id.ctv_stock)).setText(Util.m217a(product.stock) + getResources().getString(R.string.count_unit));
        if (product.stock < 0) {
            ((TextView) this.f10098i0.findViewById(R.id.ctv_stock)).setTextColor(getResources().getColor(R.color.danger));
        }
    }


    public final void m5380a(Boolean bool) {
        this.f10095f0 = bool;
        if (this.f10095f0.booleanValue()) {
           // Util.m313b(this.f10098i0.findViewById(R.id.llc_product_price));
        } else {
            Util.m243a(this.f10098i0.findViewById(R.id.llc_product_price));
        }
    }


    public  void m5381b(int i, ImageView imageView) {
        this.f10094e0.m4882a(i);
        ImageDialog3 dialogC2269y2 = this.f10094e0;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }


    public  void m5382c(View view) {
        this.f10096g0 = Boolean.valueOf(!this.f10096g0.booleanValue());
        if (this.f10096g0.booleanValue()) {
          //  Util.m313b(this.f10098i0.findViewById(R.id.ctv_extra_shipping_areas));
        } else {
            Util.m243a(this.f10098i0.findViewById(R.id.ctv_extra_shipping_areas));
        }
        ((ActionLink) this.f10098i0.findViewById(R.id.cal_show_shipping_address)).setmImageView(this.f10096g0.booleanValue() ? R.drawable.ic_angle_down : R.drawable.ic_angle_right);
    }


    public  void m5376a(int i, ImageView imageView) {
        this.f10094e0.m4882a(i);
        ImageDialog3 dialogC2269y2 = this.f10094e0;
        dialogC2269y2.f8254e = 1.0f;
        dialogC2269y2.show();
    }


    public  void m5379a(ProductDetail productDetail) {
        TextView textView;
        java.lang.String string;
        this.f10093d0 = productDetail;
        if (productDetail.data.f12407id <= 0) {
            return;
        }
        this.f10098i0.findViewById(R.id.llc_shimmer_product_image_section).setVisibility(View.GONE);
        this.f10098i0.findViewById(R.id.llc_product_image_box).setVisibility(View.VISIBLE);
        ((ShimmerFrameLayout) this.f10098i0.findViewById(R.id.sfl_product_info)).hideShimmer();
        ((TextView) this.f10098i0.findViewById(R.id.tv_title)).setText(productDetail.data.name);
        TextView textView2 = (TextView) this.f10098i0.findViewById(R.id.tv_reviews);
        StringBuilder m3163a = CustomString.format("(");
        m3163a.append(productDetail.data.ratingCount);
        //m3163a.append(m2498a(R.string.cnt_reviews));
        m3163a.append(")");
        textView2.setText(m3163a.toString());
        ((ProgressBar) this.f10098i0.findViewById(R.id.pb_rating)).setProgress((int) (productDetail.data.ratingAvg * 20.0f));
        ((ProgressBar) this.f10098i0.findViewById(R.id.pb_rating)).setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.star)));
        this.f10098i0.findViewById(R.id.tv_title).setBackgroundColor(getResources().getColor(R.color.transparent));
        ViewPager viewPager = (LoopViewPager) this.f10098i0.findViewById(R.id.vp_images);
        this.f10097h0 = "xl";
        CenterImgRecycler c1776i = new CenterImgRecycler((BaseActivity) getActivity(), this.f10097h0, true, true);
        ImageDialog3 dialogC2269y2 = this.f10094e0;
        if (dialogC2269y2 == null) {
            this.f10094e0 = new ImageDialog3(this.f10092c0);
        } else {
            dialogC2269y2.m4884f();
        }
        this.f10094e0.m4883a(Util.m306b(productDetail.data.image, "xl"));
        c1776i.f7125d.add(new CenterImgRecycler.a(productDetail.data.image, new CenterImgRecycler.b() { // from class: b.f.a.g.d.c.a
            @Override // p078b.p159f.p160a.p178b.p180b.C1776i.b

            public final void mo4370a(ImageView imageView) {
                FragmentVendorProductDescription.this.m5377a(imageView);
            }
        }));
        c1776i.notifyDataSetChanged();
        ArrayList arrayList = new ArrayList();
        arrayList.add(productDetail.data.image);
        for (Product.VariableProduct variableProduct : productDetail.data.variableProducts) {
            java.lang.String str = variableProduct.product.image;
            if (str != null && !str.isEmpty() && !arrayList.contains(variableProduct.product.image)) {
                arrayList.add(variableProduct.product.image);
               // this.f10094e0.m4883a(Util.m223a(variableProduct.product.image, this.f10097h0, true, true));
                final int getCount = c1776i.getCount();
                c1776i.f7125d.add(new CenterImgRecycler.a(variableProduct.product.image, new CenterImgRecycler.b() { // from class: b.f.a.g.d.c.b
                    @Override // p078b.p159f.p160a.p178b.p180b.C1776i.b

                    public final void mo4370a(ImageView imageView) {
                        FragmentVendorProductDescription.this.m5376a(getCount, imageView);
                    }
                }));
                c1776i.notifyDataSetChanged();
            }
        }
        for (java.lang.String str2 : productDetail.data.images) {
            this.f10094e0.m4883a(Util.m306b(str2, "xl"));
            final int getCount2 = c1776i.getCount();
            c1776i.f7125d.add(new CenterImgRecycler.a(str2, new CenterImgRecycler.b() { // from class: b.f.a.g.d.c.c
                @Override // p078b.p159f.p160a.p178b.p180b.C1776i.b

                public final void mo4370a(ImageView imageView) {
                    FragmentVendorProductDescription.this.m5381b(getCount2, imageView);
                }
            }));
            c1776i.notifyDataSetChanged();
        }
        c1776i.notifyDataSetChanged();
        viewPager.setAdapter(c1776i);
        CircleIndicator circleIndicator = (CircleIndicator) this.f10098i0.findViewById(R.id.ci_images);
        circleIndicator.setViewPager(viewPager);
        if (productDetail.data.images.size() == 0) {
            circleIndicator.setVisibility(View.GONE);
        }
        Product product = productDetail.data;
        if (product.priceApprovedNo == null && product.priceApprovedAt == null && product.priceNo == null) {
            this.f10098i0.findViewById(R.id.llc_price_info).setVisibility(View.GONE);
            this.f10098i0.findViewById(R.id.v_price_info_border).setVisibility(View.GONE);
        } else {
            Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_price_approved_no_label), R.color.body);
            Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_price_approved_no), R.color.dark);
            Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_price_no_label), R.color.body);
            Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_price_no), R.color.dark);
            Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_price_approved_at_label), R.color.body);
            Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_price_approved_at), R.color.dark);
            this.f10098i0.findViewById(R.id.llc_price_info).setVisibility(View.VISIBLE);
            this.f10098i0.findViewById(R.id.v_price_info_border).setVisibility(View.VISIBLE);
            TextView textView3 = (TextView) this.f10098i0.findViewById(R.id.ctv_price_approved_no);
            java.lang.String str3 = productDetail.data.priceApprovedNo;
            if (str3 == null) {
                str3 = "-";
            }
            textView3.setText(str3);
            TextView textView4 = (TextView) this.f10098i0.findViewById(R.id.ctv_price_approved_at);
            Date date = productDetail.data.priceApprovedAt;
            textView4.setText(date != null ? Util.date2Str(date) : "-");
            TextView textView5 = (TextView) this.f10098i0.findViewById(R.id.ctv_price_no);
            java.lang.String str4 = productDetail.data.priceNo;
            if (str4 == null) {
                str4 = "-";
            }
            textView5.setText(str4);
        }
        Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_guarantee_label), R.color.body);
        Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_guarantee), R.color.dark);
        if (productDetail.data.guaranteeDays > 0) {
            textView = (TextView) this.f10098i0.findViewById(R.id.ctv_guarantee);
            string = productDetail.data.guaranteeDays + getResources().getString(R.string.day_unit);
        } else {
            textView = (TextView) this.f10098i0.findViewById(R.id.ctv_guarantee);
            string = this.f10092c0.getString(R.string.empty);
        }
        textView.setText(string);
        ProductAttributeSwatch productAttributeSwatch = (ProductAttributeSwatch) this.f10098i0.findViewById(R.id.pa_attributes);
        productAttributeSwatch.removeAllViews();
        List<Product.VariableProduct> list = productDetail.data.variableProducts;
        if (list != null && list.size() > 0 && (productDetail.data.variableAttributes.size() > 0 || productDetail.data.customAttributes.size() > 0)) {
            productAttributeSwatch.setVisibility(View.VISIBLE);
            this.f10098i0.findViewById(R.id.v_attribute_border).setVisibility(View.VISIBLE);
        }
        productAttributeSwatch.m6950a(productDetail.data, (BaseActivity) this.f10092c0, false);
        productAttributeSwatch.m6948a(this);
        productAttributeSwatch.m6949a(productAttributeSwatch.f12282t);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.f10098i0.findViewById(R.id.ll_description);
        if (linearLayoutCompat.getChildCount() > 1) {
            linearLayoutCompat.removeViewAt(1);
        }
        LinearLayoutCompat3 linearLayoutCompat3 = new LinearLayoutCompat3(this.f10092c0, "vendor");
        linearLayoutCompat3.setItem(productDetail);
        linearLayoutCompat.addView(linearLayoutCompat3);
        Util.setColor(this.f10092c0, (android.widget.TextView) this.f10098i0.findViewById(R.id.ctv_shipping_address_label), R.color.body);
        this.f10098i0.findViewById(R.id.llc_shimmer_shipping_areas).setVisibility(View.GONE);
        this.f10098i0.findViewById(R.id.llc_shipping_areas).setVisibility(View.VISIBLE);
        List<java.lang.String> list2 = this.f10093d0.data.shippingZones;
        if (list2 != null && list2.size() != 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < list2.size(); i++) {
                if (i < 2) {
                    sb.append(PickerViewObj.m4699b(list2.get(i), this.f10092c0));
                    if (list2.size() < 2) {
                        list2.size();
                    }
                    if (list2.size() > 1) {
                        sb.append(", ");
                    }
                } else {
                    sb2.append(PickerViewObj.m4699b(list2.get(i), this.f10092c0));
                    if (i < list2.size() - 1) {
                        sb2.append(", ");
                    }
                }
            }
            ((TextView) this.f10098i0.findViewById(R.id.ctv_shipping_areas)).setText(sb);
            if (list2.size() > 2) {
                this.f10098i0.findViewById(R.id.cal_show_shipping_address).setVisibility(View.VISIBLE);
                ((TextView) this.f10098i0.findViewById(R.id.ctv_extra_shipping_areas)).setText(sb2);
                this.f10098i0.findViewById(R.id.cal_show_shipping_address).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.g.d.c.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FragmentVendorProductDescription.this.m5382c(view);
                    }
                });
            } else {
                this.f10098i0.findViewById(R.id.cal_show_shipping_address).setVisibility(View.GONE);
            }
        }
        if (productDetail.data.type.equals("simple")) {
            this.f10098i0.findViewById(R.id.llc_product_price).setVisibility(View.VISIBLE);
        } else {
            this.f10098i0.findViewById(R.id.llc_product_price).setVisibility(View.GONE);
        }
        if (productDetail.data.type.equals("variable")) {
            return;
        }
        m5378a(productDetail.data);
    }
}
