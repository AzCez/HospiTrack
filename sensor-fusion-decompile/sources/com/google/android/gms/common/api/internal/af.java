package com.google.android.gms.common.api.internal;

import android.support.v4.b.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c;
import com.google.android.gms.f.b;
import java.util.Map;
import java.util.Set;

public final class af {
    private final a<ae<?>, ConnectionResult> a;
    private final a<ae<?>, String> b;
    private final b<Map<ae<?>, String>> c;
    private int d;
    private boolean e;

    public final Set<ae<?>> a() {
        return this.a.keySet();
    }

    public final void a(ae<?> aeVar, ConnectionResult connectionResult, String str) {
        this.a.put(aeVar, connectionResult);
        this.b.put(aeVar, str);
        this.d--;
        if (!connectionResult.b()) {
            this.e = true;
        }
        if (this.d != 0) {
            return;
        }
        if (this.e) {
            this.c.a((Exception) new c(this.a));
            return;
        }
        this.c.a(this.b);
    }
}
