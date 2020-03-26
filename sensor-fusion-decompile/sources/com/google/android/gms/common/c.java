package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.b.b;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.maps.f;

public class c {
    private static final c a = new c();
    public static final int b = f.b;

    c() {
    }

    public static c b() {
        return a;
    }

    private static String b(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(b);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(b.a(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public int a(Context context) {
        return b(context, b);
    }

    public PendingIntent a(Context context, int i, int i2) {
        return a(context, i, i2, (String) null);
    }

    public PendingIntent a(Context context, int i, int i2, String str) {
        Intent a2 = a(context, i, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, a2, 134217728);
    }

    public Intent a(Context context, int i, String str) {
        switch (i) {
            case f.a.MapAttrs_cameraBearing /*1*/:
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                return (context == null || !com.google.android.gms.common.util.f.b(context)) ? z.a("com.google.android.gms", b(context, str)) : z.a();
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                return z.a("com.google.android.gms");
            default:
                return null;
        }
    }

    public boolean a(int i) {
        return f.b(i);
    }

    public boolean a(Context context, String str) {
        return f.a(context, str);
    }

    public int b(Context context, int i) {
        int b2 = f.b(context, i);
        if (f.c(context, b2)) {
            return 18;
        }
        return b2;
    }

    public String b(int i) {
        return f.a(i);
    }
}
