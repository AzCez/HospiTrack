package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.d;

final class q extends e {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ d b;
    private final /* synthetic */ int c;

    q(Intent intent, d dVar, int i) {
        this.a = intent;
        this.b = dVar;
        this.c = i;
    }

    public final void a() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.a(intent, this.c);
        }
    }
}
