package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zaj;

final class y implements Runnable {
    private final /* synthetic */ zaj a;
    private final /* synthetic */ w b;

    y(w wVar, zaj zaj) {
        this.b = wVar;
        this.a = zaj;
    }

    public final void run() {
        this.b.b(this.a);
    }
}
