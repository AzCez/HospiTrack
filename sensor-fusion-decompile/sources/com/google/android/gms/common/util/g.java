package com.google.android.gms.common.util;

import android.os.Build;

public final class g {
    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 15;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 26;
    }
}
