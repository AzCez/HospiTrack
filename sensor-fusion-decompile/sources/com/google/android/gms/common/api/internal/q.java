package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.internal.i;
import java.util.Collections;

final class q implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ b.c b;

    q(b.c cVar, ConnectionResult connectionResult) {
        this.b = cVar;
        this.a = connectionResult;
    }

    public final void run() {
        if (this.a.b()) {
            boolean unused = this.b.f = true;
            if (this.b.b.d()) {
                this.b.a();
                return;
            }
            try {
                this.b.b.a((i) null, Collections.emptySet());
            } catch (SecurityException unused2) {
                ((b.a) b.this.m.get(this.b.c)).a(new ConnectionResult(10));
            }
        } else {
            ((b.a) b.this.m.get(this.b.c)).a(this.a);
        }
    }
}
