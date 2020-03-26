package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.n;

final class ah {
    private final int a;
    private final ConnectionResult b;

    ah(ConnectionResult connectionResult, int i) {
        n.a(connectionResult);
        this.b = connectionResult;
        this.a = i;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.b;
    }
}
