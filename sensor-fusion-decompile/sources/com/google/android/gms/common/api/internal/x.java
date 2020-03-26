package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class x implements Runnable {
    private final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public final void run() {
        this.a.h.b(new ConnectionResult(4));
    }
}
