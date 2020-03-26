package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class aj extends s {
    private final /* synthetic */ Dialog a;
    private final /* synthetic */ ai b;

    aj(ai aiVar, Dialog dialog) {
        this.b = aiVar;
        this.a = dialog;
    }

    public final void a() {
        this.b.a.c();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
