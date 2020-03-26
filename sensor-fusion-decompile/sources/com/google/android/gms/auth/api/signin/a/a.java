package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.n;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class a {
    private static final Lock a = new ReentrantLock();
    @GuardedBy("sLk")
    private static a b;
    private final Lock c = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences d;

    private a(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @Nullable
    private final GoogleSignInAccount a(String str) {
        String b2;
        if (!TextUtils.isEmpty(str) && (b2 = b(a("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.a(b2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static a a(Context context) {
        n.a(context);
        a.lock();
        try {
            if (b == null) {
                b = new a(context.getApplicationContext());
            }
            return b;
        } finally {
            a.unlock();
        }
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    private final String b(String str) {
        this.c.lock();
        try {
            return this.d.getString(str, (String) null);
        } finally {
            this.c.unlock();
        }
    }

    @Nullable
    public GoogleSignInAccount a() {
        return a(b("defaultGoogleSignInAccount"));
    }
}
