package com.google.android.gms.c;

import android.content.Intent;

final class l implements Runnable {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Intent b;
    private final /* synthetic */ k c;

    l(k kVar, Intent intent, Intent intent2) {
        this.c = kVar;
        this.a = intent;
        this.b = intent2;
    }

    public final void run() {
        this.c.a(this.a);
        this.c.b(this.b);
    }
}
