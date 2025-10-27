package com.jeil.emarket.custom.font;

/* renamed from: b.f.a.l.a */

public class CredValue {


    public static int[] f10442a = {0, 11, 21, 41, 91, 151, 251, 501, 1001, 2001, 5001, 10001, 20001, 50001, 100001, 200001, 500001, 1000001, 2000001, 5000001};


    public static int m5616a(int i) {
        if (i >= 0 && i < 151) {
            return 1;
        }
        if (i < 151 || i >= 5001) {
            return (i < 5001 || i >= 200001) ? 4 : 3;
        }
        return 2;
    }
}
