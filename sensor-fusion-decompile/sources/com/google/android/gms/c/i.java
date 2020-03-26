package com.google.android.gms.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.b.a;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class i {
    private SharedPreferences a;
    private Context b;
    private final n c;
    private final Map<String, o> d;

    public i(Context context) {
        this(context, new n());
    }

    private i(Context context, n nVar) {
        this.d = new a();
        this.b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.c = nVar;
        File file = new File(android.support.v4.a.a.a(this.b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !a()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    b.a(this.b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("InstanceID/Store", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void a(String str) {
        SharedPreferences.Editor edit = this.a.edit();
        for (String next : this.a.getAll().keySet()) {
            if (next.startsWith(str)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    public final boolean a() {
        return this.a.getAll().isEmpty();
    }

    public final synchronized o b(String str) {
        o oVar;
        o oVar2 = this.d.get(str);
        if (oVar2 != null) {
            return oVar2;
        }
        try {
            oVar = this.c.a(this.b, str);
        } catch (p unused) {
            Log.w("InstanceID/Store", "Stored data is corrupt, generating new identity");
            b.a(this.b, this);
            oVar = this.c.b(this.b, str);
        }
        this.d.put(str, oVar);
        return oVar;
    }

    public final synchronized void b() {
        this.d.clear();
        n.a(this.b);
        this.a.edit().clear().commit();
    }

    /* access modifiers changed from: package-private */
    public final void c(String str) {
        synchronized (this) {
            this.d.remove(str);
        }
        n.c(this.b, str);
        a(String.valueOf(str).concat("|"));
    }
}
