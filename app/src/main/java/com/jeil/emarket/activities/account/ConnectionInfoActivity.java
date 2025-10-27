package com.jeil.emarket.activities.account;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.custom.Util;
import com.jeil.emarket.model.customer.MarketConnection;
import java.util.List;

import com.jeil.emarket.activities.baseactivity.BaseActivity;
import com.jeil.emarket.dialog.dialog.interf.DialogInterface2;
import com.jeil.emarket.dialog.dialog.dialog.BaseDialog2;
import com.jeil.emarket.viewmodel.UserVM;


public class ConnectionInfoActivity extends BaseActivity {


    public boolean canDial = false;


    public  void m6266a(MarketConnection marketConnection, View view) {
        startDials(marketConnection.agencyPhone);
    }


    public  void startDIAL(String[] phonenumber, BaseDialog2 baseDialog2, View view, int i) {
        try {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phonenumber[i])));
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
        baseDialog2.startAni();
    }


    public final String list2Str(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(i % 2 == 1 ? ",\n" : ", ");
            }
        }
        return sb.toString();
    }


    public  void m6269b(DialogInterface dialogInterface) {
        this.canDial = false;
    }


    public  void m6270b(MarketConnection marketConnection, View view) {
        startDials(marketConnection.commitPhone);
    }


    public  void m6271c(MarketConnection marketConnection, View view) {
        startDials(marketConnection.servicePhone);
    }


    public final void startDials(List<String> list) {
        if (this.canDial) {
            return;
        }
        this.canDial = true;
        if (list == null || list.size() == 0) {
            Util.toast(this, getString(R.string.not_exist_phone), "error", 0, 0);
            return;
        }
        if (list.size() == 1) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + list.get(0))));
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
            this.canDial = false;
            return;
        }
        final String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = list.get(i);
        }
        final BaseDialog2 baseDialog2 = new BaseDialog2(this, strArr, null, 80);
        baseDialog2.show();
        baseDialog2.interface2 = new DialogInterface2() { // from class: b.f.a.a.a.j
            @Override // p078b.p159f.p160a.p190c.p193c0.p195b.InterfaceC1991b

            public final void mo4264a(View view, int i2) {
                ConnectionInfoActivity.this.startDIAL(strArr, baseDialog2, view, i2);
            }
        };
        baseDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b.f.a.a.a.i
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ConnectionInfoActivity.this.m6269b(dialogInterface);
            }
        });
    }


    public  void startWebServer(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://10.99.8.2/")));
    }


    public  void startTechPhone(MarketConnection marketConnection, View view) {
        startDials(marketConnection.techPhone);
    }


    public  void startCookPhone(MarketConnection marketConnection, View view) {
        startDials(marketConnection.cookPhone);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1, p000a.p055m.p056a.ActivityC0362o, androidx.activity.ComponentActivity, p000a.p030h.p031a.ActivityC0208c, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_connection);
        m4307e(R.string.connection_info);
        final MarketConnection getValue = UserVM.marketConnection.getValue();
        if (getValue != null) {
            List<String> list = getValue.agencyPhone;
            if (list == null || list.size() == 0) {
                findViewById(R.id.ll_agency).setVisibility(View.GONE);
            } else {
                findViewById(R.id.ll_agency).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.ctv_agency_phone)).setText(list2Str(getValue.agencyPhone));
            }
            findViewById(R.id.mrl_agency).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectionInfoActivity.this.m6266a(getValue, view);
                }
            });
            List<String> list2 = getValue.commitPhone;
            if (list2 == null || list2.size() == 0) {
                findViewById(R.id.llc_commit).setVisibility(View.GONE);
            } else {
                findViewById(R.id.llc_commit).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.ctv_commit_phone)).setText(list2Str(getValue.commitPhone));
            }
            findViewById(R.id.mrl_commit).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectionInfoActivity.this.m6270b(getValue, view);
                }
            });
            List<String> list3 = getValue.servicePhone;
            if (list3 == null || list3.size() == 0) {
                findViewById(R.id.ll_service).setVisibility(View.GONE);
            } else {
                findViewById(R.id.ll_service).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.ctv_service_phone)).setText(list2Str(getValue.servicePhone));
            }
            findViewById(R.id.mrl_service).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectionInfoActivity.this.m6271c(getValue, view);
                }
            });
            List<String> list4 = getValue.techPhone;
            if (list4 == null || list4.size() == 0) {
                findViewById(R.id.ll_tech).setVisibility(View.GONE);
            } else {
                findViewById(R.id.ll_tech).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.ctv_tech_phone)).setText(list2Str(getValue.techPhone));
            }
            findViewById(R.id.mrl_tech).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectionInfoActivity.this.startTechPhone(getValue, view);
                }
            });
            List<String> list5 = getValue.cookPhone;
            if (list5 == null || list5.size() == 0) {
                findViewById(R.id.ll_cook).setVisibility(View.GONE);
            } else {
                findViewById(R.id.ll_cook).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.tv_cook_phone)).setText(list2Str(getValue.cookPhone));
            }
            findViewById(R.id.mrl_cook).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectionInfoActivity.this.startCookPhone(getValue, view);
                }
            });
            String[] split = "http://10.99.8.2/".split("//");
            if (split.length > 1) {
                String[] split2 = split[1].split("/");
                if (split2.length > 0) {
                    str = split2[0];
                    ((TextView) findViewById(R.id.tv_mobile_address)).setText(str);
                    findViewById(R.id.mrl_mobile).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ConnectionInfoActivity.this.startWebServer(view);
                        }
                    });
                }
            }
            str = "";
            ((TextView) findViewById(R.id.tv_mobile_address)).setText(str);
            findViewById(R.id.mrl_mobile).setOnClickListener(new View.OnClickListener() { // from class: b.f.a.a.a.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConnectionInfoActivity.this.startWebServer(view);
                }
            });
        }
        mo4284G();
        addBottomNav(R.id.navigation_account);
    }

    @Override // p078b.p159f.p160a.p161a.p164c.ActivityC1391g1
    /* renamed from: w */
    public View mo4310w() {
        return findViewById(R.id.header_border);
    }
}
