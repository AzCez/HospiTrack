package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import javax.annotation.concurrent.GuardedBy;

public final class d {
    private static final String[] a = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager b = null;
    private static boolean c = false;
    private static int d = -1;
    @GuardedBy("CrashUtils.class")
    private static int e = 0;
    @GuardedBy("CrashUtils.class")
    private static int f = 0;

    public static boolean a(Context context, Throwable th) {
        return a(context, th, 536870912);
    }

    private static boolean a(Context context, Throwable th, int i) {
        try {
            n.a(context);
            n.a(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
