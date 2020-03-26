package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public class g {
    private static g a;
    private final Context b;

    private g(Context context) {
        this.b = context.getApplicationContext();
    }

    public static g a(Context context) {
        n.a(context);
        synchronized (g.class) {
            if (a == null) {
                l.a(context);
                a = new g(context);
            }
        }
        return a;
    }

    private static m a(PackageInfo packageInfo, m... mVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        n nVar = new n(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < mVarArr.length; i++) {
            if (mVarArr[i].equals(nVar)) {
                return mVarArr[i];
            }
        }
        return null;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (a(packageInfo, z ? p.a : new m[]{p.a[0]}) != null) {
                return true;
            }
        }
        return false;
    }
}
