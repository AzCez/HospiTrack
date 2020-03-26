package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
public class a {
    private static final h<Boolean> a = g.a().a("gcm_check_for_different_iid_in_token", true);
    private static Map<String, a> b = new android.support.v4.b.a();
    private static final long c = TimeUnit.DAYS.toMillis(7);
    private static i d;
    private static f e;
    private static String f;
    private Context g;
    private String h = "";

    private a(Context context, String str) {
        this.g = context.getApplicationContext();
        this.h = str;
    }

    static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(valueOf);
            Log.w("InstanceID", sb.toString());
            return 0;
        }
    }

    public static synchronized a a(Context context, Bundle bundle) {
        a aVar;
        synchronized (a.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            if (string == null) {
                string = "";
            }
            Context applicationContext = context.getApplicationContext();
            if (d == null) {
                String packageName = applicationContext.getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 73);
                sb.append("Instance ID SDK is deprecated, ");
                sb.append(packageName);
                sb.append(" should update to use Firebase Instance ID");
                Log.w("InstanceID", sb.toString());
                d = new i(applicationContext);
                e = new f(applicationContext);
            }
            f = Integer.toString(a(applicationContext));
            aVar = b.get(string);
            if (aVar == null) {
                aVar = new a(applicationContext, string);
                b.put(string, aVar);
            }
        }
        return aVar;
    }

    static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("InstanceID", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    @Deprecated
    public static a b(Context context) {
        return a(context, (Bundle) null);
    }

    public static i c() {
        return d;
    }

    private final KeyPair d() {
        return d.b(this.h).a();
    }

    @Deprecated
    public String a() {
        return a(d());
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        d.c(this.h);
    }
}
