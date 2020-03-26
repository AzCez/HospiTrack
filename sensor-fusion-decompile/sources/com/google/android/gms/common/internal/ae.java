package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.b.b;
import javax.annotation.concurrent.GuardedBy;

public final class ae {
    private static Object a = new Object();
    @GuardedBy("sLock")
    private static boolean b;
    private static String c;
    private static int d;

    public static int a(Context context) {
        b(context);
        return d;
    }

    private static void b(Context context) {
        synchronized (a) {
            if (!b) {
                b = true;
                try {
                    Bundle bundle = b.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        c = bundle.getString("com.google.app.id");
                        d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
