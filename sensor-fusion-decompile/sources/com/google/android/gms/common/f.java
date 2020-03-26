package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.h;
import com.google.android.gms.maps.f;
import java.util.concurrent.atomic.AtomicBoolean;

public class f {
    private static boolean a = false;
    @Deprecated
    public static final int b = 12451000;
    static final AtomicBoolean c = new AtomicBoolean();
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static final AtomicBoolean g = new AtomicBoolean();

    private static int a(Context context, boolean z, int i) {
        String str;
        String str2;
        n.b(i >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                str = "GooglePlayServicesUtil";
                str2 = "Google Play Store is missing.";
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            g.a(context);
            if (!g.a(packageInfo2, true)) {
                str = "GooglePlayServicesUtil";
                str2 = "Google Play services signature invalid.";
            } else if (z && (!g.a(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                str = "GooglePlayServicesUtil";
                str2 = "Google Play Store signature invalid.";
            } else if (h.a(packageInfo2.versionCode) < h.a(i)) {
                int i2 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(77);
                sb.append("Google Play services out of date.  Requires ");
                sb.append(i);
                sb.append(" but found ");
                sb.append(i2);
                Log.w("GooglePlayServicesUtil", sb.toString());
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
            Log.w(str, str2);
            return 9;
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static String a(int i) {
        return ConnectionResult.a(i);
    }

    @TargetApi(21)
    static boolean a(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (g.f()) {
            try {
                for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            return equals ? applicationInfo.enabled : applicationInfo.enabled && !e(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    @Deprecated
    public static int b(Context context, int i) {
        try {
            context.getResources().getString(h.a.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !g.get()) {
            int a2 = ae.a(context);
            if (a2 != 0) {
                int i2 = b;
                if (a2 != i2) {
                    StringBuilder sb = new StringBuilder(320);
                    sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb.append(i2);
                    sb.append(" but found ");
                    sb.append(a2);
                    sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return a(context, !com.google.android.gms.common.util.f.b(context) && !com.google.android.gms.common.util.f.d(context), i);
    }

    @Deprecated
    public static boolean b(int i) {
        if (i == 9) {
            return true;
        }
        switch (i) {
            case f.a.MapAttrs_cameraBearing /*1*/:
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                return true;
            default:
                return false;
        }
    }

    public static Resources c(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static boolean c(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return a(context, "com.google.android.gms");
        }
        return false;
    }

    public static Context d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = ((android.os.UserManager) r2.getSystemService("user")).getApplicationRestrictions(r2.getPackageName());
     */
    @android.annotation.TargetApi(18)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(android.content.Context r2) {
        /*
            boolean r0 = com.google.android.gms.common.util.g.d()
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "user"
            java.lang.Object r0 = r2.getSystemService(r0)
            android.os.UserManager r0 = (android.os.UserManager) r0
            java.lang.String r2 = r2.getPackageName()
            android.os.Bundle r2 = r0.getApplicationRestrictions(r2)
            if (r2 == 0) goto L_0x0028
            java.lang.String r0 = "true"
            java.lang.String r1 = "restricted_profile"
            java.lang.String r2 = r2.getString(r1)
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0028
            r2 = 1
            return r2
        L_0x0028:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.f.e(android.content.Context):boolean");
    }
}
