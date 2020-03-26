package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class p extends e {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;

    p(Intent intent, Activity activity, int i) {
        this.a = intent;
        this.b = activity;
        this.c = i;
    }

    public final void a() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
