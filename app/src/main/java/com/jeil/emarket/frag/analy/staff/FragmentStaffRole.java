package com.jeil.emarket.frag.analy.staff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeil.emarket.components.textview.TextView;
import com.jeil.emarket.model.vendor.RoleData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;

/* renamed from: b.f.a.g.d.b.a4 */

public class FragmentStaffRole extends Fragment {

    /* renamed from: a0 */
    public View f9761a0;

    /* renamed from: b.f.a.g.d.b.a4$a */
    public class a extends TypeToken<RoleData> {
        public a(FragmentStaffRole fragmentStaffRole) {
        }
    }

    /* renamed from: S0 */
    public void m5214S0() {
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.f9761a0.findViewById(R.id.llc_role_section);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.roles), StandardCharsets.UTF_8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else {
                    sb.append(readLine);
                }
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(sb.toString());
                Gson gson = new Gson();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add((RoleData) gson.fromJson(jSONArray.optJSONObject(i).toString(), new a(this).getType()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                RoleData roleData = (RoleData) arrayList.get(i2);
                View inflate = getLayoutInflater().inflate(R.layout.item_staff_role, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.ctv_role_name)).setText(roleData.name);
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                String string = getResources().getString(R.string.due_to_permission);
                RoleData.Permission permission = roleData.permissions;
                String str = permission.dashboard;
                if (str == null) {
                    sb3 = new StringBuilder(getResources().getString(R.string.dashboard));
                } else if (str.equals("true")) {
                    sb2 = new StringBuilder(getResources().getString(R.string.dashboard));
                } else {
                    sb2 = new StringBuilder(getResources().getString(R.string.dashboard) + "(" + string + ")");
                }
                String str2 = sb3.toString().isEmpty() ? "" : ", ";
                String str3 = permission.orders;
                if (str3 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.permission_orders));
                } else {
                    boolean equals = str3.equals("true");
                    sb2.append(str2);
                    if (equals) {
                        sb2.append(getResources().getString(R.string.permission_orders));
                    } else {
                        sb2.append(getResources().getString(R.string.permission_orders));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str4 = permission.products;
                if (str4 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.permission_products));
                } else {
                    boolean equals2 = str4.equals("true");
                    sb2.append(str2);
                    if (equals2) {
                        sb2.append(getResources().getString(R.string.permission_products));
                    } else {
                        sb2.append(getResources().getString(R.string.permission_products));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str5 = permission.notice;
                if (str5 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.ticket_manage));
                } else {
                    boolean equals3 = str5.equals("true");
                    sb2.append(str2);
                    if (equals3) {
                        sb2.append(getResources().getString(R.string.ticket_manage));
                    } else {
                        sb2.append(getResources().getString(R.string.ticket_manage));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str6 = permission.analytics;
                if (str6 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.analytics));
                } else {
                    boolean equals4 = str6.equals("true");
                    sb2.append(str2);
                    if (equals4) {
                        sb2.append(getResources().getString(R.string.analytics));
                    } else {
                        sb2.append(getResources().getString(R.string.analytics));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str7 = permission.finance;
                if (str7 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.permission_finance));
                } else {
                    boolean equals5 = str7.equals("true");
                    sb2.append(str2);
                    if (equals5) {
                        sb2.append(getResources().getString(R.string.permission_finance));
                    } else {
                        sb2.append(getResources().getString(R.string.permission_finance));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str8 = permission.sale;
                if (str8 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.permission_sale));
                } else {
                    boolean equals6 = str8.equals("true");
                    sb2.append(str2);
                    if (equals6) {
                        sb2.append(getResources().getString(R.string.permission_sale));
                    } else {
                        sb2.append(getResources().getString(R.string.permission_sale));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str9 = permission.reviews;
                if (str9 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.review_manage));
                } else {
                    boolean equals7 = str9.equals("true");
                    sb2.append(str2);
                    if (equals7) {
                        sb2.append(getResources().getString(R.string.review_manage));
                    } else {
                        sb2.append(getResources().getString(R.string.review_manage));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str10 = permission.staffs;
                if (str10 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.staff_manage));
                } else {
                    boolean equals8 = str10.equals("true");
                    sb2.append(str2);
                    if (equals8) {
                        sb2.append(getResources().getString(R.string.staff_manage));
                    } else {
                        sb2.append(getResources().getString(R.string.staff_manage));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str11 = permission.file;
                if (str11 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.permission_file));
                } else {
                    boolean equals9 = str11.equals("true");
                    sb2.append(str2);
                    if (equals9) {
                        sb2.append(getResources().getString(R.string.permission_file));
                    } else {
                        sb2.append(getResources().getString(R.string.permission_file));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str12 = permission.logs;
                if (str12 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.permission_logs));
                } else {
                    boolean equals10 = str12.equals("true");
                    sb2.append(str2);
                    if (equals10) {
                        sb2.append(getResources().getString(R.string.permission_logs));
                    } else {
                        sb2.append(getResources().getString(R.string.permission_logs));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                String str13 = permission.setting;
                if (str13 == null) {
                    sb3.append(str2);
                    sb3.append(getResources().getString(R.string.permission_setting));
                } else {
                    boolean equals11 = str13.equals("true");
                    sb2.append(str2);
                    if (equals11) {
                        sb2.append(getResources().getString(R.string.permission_setting));
                    } else {
                        sb2.append(getResources().getString(R.string.permission_setting));
                        sb2.append("(");
                        sb2.append(string);
                        sb2.append(")");
                    }
                }
                if (sb2.toString().isEmpty()) {
                    sb2 = new StringBuilder(getResources().getString(R.string.empty));
                }
                if (sb3.toString().isEmpty()) {
                    sb3 = new StringBuilder(getResources().getString(R.string.empty));
                }
                ((TextView) inflate.findViewById(R.id.tv_role_possible_content)).setText(sb2.toString());
                ((TextView) inflate.findViewById(R.id.tv_role_impossible_content)).setText(sb3.toString());
                if (i2 == arrayList.size() - 1) {
                    inflate.findViewById(R.id.v_border).setVisibility(View.GONE);
                }
                linearLayoutCompat.addView(inflate);
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9761a0 = layoutInflater.inflate(R.layout.fragment_staff_role, viewGroup, false);
        m5214S0();
        return this.f9761a0;
    }
}
