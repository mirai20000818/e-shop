package com.jeil.emarket.dialog;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.jeil.emarket.components.button.CustomButton;
import com.jeil.emarket.components.edittext.EditForm;
import com.jeil.emarket.model.customer.Category;
import com.jeil.emarket.model.vendor.Vendor;
import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.Observer;
import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.adapters.fbt.ProductAdapter1;
import com.jeil.emarket.dialog.dialog.dialog.base.BaseAniDialog;
import com.jeil.emarket.components.itemdecor.ItemDecoration1;
import com.jeil.emarket.interf.BaseInterface2;
import com.jeil.emarket.viewmodel.CategoryVM;

/* renamed from: b.f.a.f.j3 */

public class DialogCategory extends BaseAniDialog<DialogCategory> implements BaseInterface2 {


    public String f8989A;


    public Boolean f8990B;


    public boolean f8991C;


    public List<Vendor.Advanced> f8992D;


    public ProductAdapter1<Category> f8993E;

    /* renamed from: F */
    public ProductAdapter1<Vendor.Advanced> f8994F;

    /* renamed from: G */
    public BaseActivity f8995G;

    /* renamed from: H */
    public View f8996H;

    /* renamed from: y */
    public String f8997y;

    /* renamed from: z */
    public String f8998z;

    public DialogCategory(BaseActivity activityC1391g1) {
        super(activityC1391g1, 8388613);
        this.f8991C = false;
        this.f8992D = new ArrayList();
        this.f8995G = activityC1391g1;
    }


    public  void m4837a(RecyclerView recyclerView, List list) {
        ArrayList arrayList = new ArrayList(list);
        Category category = new Category();
        category.f12393id = -1;
        category.name = this.f8995G.getResources().getString(R.string.all);
        arrayList.add(0, category);
        this.f8993E = new ProductAdapter1<>(this.f8995G, recyclerView, arrayList.size(), null, this);
        recyclerView.setAdapter(this.f8993E);
        this.f8993E.addAll(arrayList);
        ProductAdapter1<Category> c1880t = this.f8993E;
        c1880t.f7635h = 0;
        c1880t.notifyDataSetChanged();
    }

    @Override // p078b.p159f.p160a.p253h.InterfaceC2709c

    public boolean mo4808a(int i, String str, int i2) {
        if (str.equals("category")) {
            if (i == -1 || CategoryVM.listMutableLiveData.getValue() == null || CategoryVM.listMutableLiveData.getValue().get(i).f12393id == -1) {
                this.f8989A = null;
            } else {
                this.f8989A = String.valueOf(CategoryVM.listMutableLiveData.getValue().get(i).f12393id);
            }
        } else if (str.equals("advanced")) {
            if (i != -1) {
                String str2 = this.f8992D.get(i).value;
                if (!str2.equals("")) {
                    if (str2.equals("isFeatured")) {
                        this.f8990B = true;
                        this.f8998z = null;
                    } else {
                        this.f8998z = str2;
                        this.f8990B = false;
                    }
                }
            }
            this.f8990B = null;
            this.f8998z = null;
        }
        return true;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public View mo4576b() {
        this.f8996H = View.inflate(this.f8995G, R.layout.dialog_vendor_filter, null);
        final RecyclerView recyclerView = (RecyclerView) this.f8996H.findViewById(R.id.rv_categories);
        recyclerView.setLayoutManager(ChipsLayoutManager.newBuilder(this.f8995G).build());
        recyclerView.addItemDecoration(new ItemDecoration1(m4590a(5.0f)));
        CategoryVM.listMutableLiveData.observe(this.f8995G, new Observer() { // from class: b.f.a.f.n2
            @Override // p000a.p060o.InterfaceC0405p

            public final void onChanged(Object obj) {
                DialogCategory.this.m4837a(recyclerView, (List) obj);
            }
        });
        RecyclerView recyclerView2 = (RecyclerView) this.f8996H.findViewById(R.id.rv_advanced);
        recyclerView2.setLayoutManager(ChipsLayoutManager.newBuilder(this.f8995G).build());
        recyclerView2.addItemDecoration(new ItemDecoration1(m4590a(5.0f)));
        this.f8994F = new ProductAdapter1<>(this.f8995G, recyclerView2, 4, null, this);
        recyclerView2.setAdapter(this.f8994F);
        Vendor.Advanced advanced = new Vendor.Advanced(this.f8995G.getResources().getString(R.string.all), "");
        Vendor.Advanced advanced2 = new Vendor.Advanced(this.f8995G.getResources().getString(R.string.kpw_vendor), "kpw");
        Vendor.Advanced advanced3 = new Vendor.Advanced(this.f8995G.getResources().getString(R.string.kpf_vendor), "kpf");
        Vendor.Advanced advanced4 = new Vendor.Advanced(this.f8995G.getResources().getString(R.string.featured_vendor), "isFeatured");
        this.f8992D.add(advanced);
        this.f8992D.add(advanced2);
        this.f8992D.add(advanced3);
        this.f8992D.add(advanced4);
        this.f8994F.addAll(this.f8992D);
        ProductAdapter1<Vendor.Advanced> c1880t = this.f8994F;
        c1880t.f7635h = 0;
        c1880t.notifyDataSetChanged();
        this.f8996H.findViewById(R.id.nsv_main).setVisibility(View.VISIBLE);
        this.f8996H.findViewById(R.id.cb_ok).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCategory.this.m4838c(view);
            }
        });
        CustomButton customButton = (CustomButton) this.f8996H.findViewById(R.id.cb_cancel);
        customButton.setText(R.string.reset);
        customButton.setOnClickListener(new View.OnClickListener() { // from class: b.f.a.f.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogCategory.this.m4839d(view);
            }
        });
        return this.f8996H;
    }

    @Override // p078b.p159f.p160a.p190c.p193c0.p196c.p197l.AbstractDialogC2009g

    public void mo4577c() {
        View view = this.f8996H;
        if (view != null) {
            view.scrollTo(0, 0);
        }
    }


    public  void m4838c(View view) {
        this.f8997y = ((EditForm) this.f8996H.findViewById(R.id.cef_search)).getText();
        this.f8991C = true;
        startAni();
    }


    public  void m4839d(View view) {
        this.f8997y = null;
        ((EditForm) this.f8996H.findViewById(R.id.cef_search)).setText("");
        this.f8989A = null;
        ProductAdapter1<Category> c1880t = this.f8993E;
        c1880t.f7635h = 0;
        c1880t.notifyDataSetChanged();
        this.f8998z = null;
        this.f8990B = null;
        ProductAdapter1<Vendor.Advanced> c1880t2 = this.f8994F;
        c1880t2.f7635h = 0;
        c1880t2.notifyDataSetChanged();
    }
}
