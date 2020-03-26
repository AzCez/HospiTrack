package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class f {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    @TargetApi(20)
    public static boolean a(Context context) {
        if (a == null) {
            a = Boolean.valueOf(g.e() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return a.booleanValue();
    }

    @TargetApi(26)
    public static boolean b(Context context) {
        if (!a(context)) {
            return false;
        }
        if (g.g()) {
            return c(context) && !g.h();
        }
        return true;
    }

    @TargetApi(21)
    public static boolean c(Context context) {
        if (b == null) {
            b = Boolean.valueOf(g.f() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return b.booleanValue();
    }

    public static boolean d(Context context) {
        if (c == null) {
            c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return c.booleanValue();
    }
}
