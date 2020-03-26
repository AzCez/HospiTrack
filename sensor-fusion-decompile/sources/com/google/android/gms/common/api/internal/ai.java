package com.google.android.gms.common.api.internal;

import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.b;

final class ai implements Runnable {
    final /* synthetic */ ag a;
    private final ah b;

    ai(ag agVar, ah ahVar) {
        this.a = agVar;
        this.b = ahVar;
    }

    public final void run() {
        if (this.a.b) {
            ConnectionResult b2 = this.b.b();
            if (b2.a()) {
                this.a.a.a(GoogleApiActivity.a(this.a.a(), b2.d(), this.b.a(), false), 1);
            } else if (this.a.d.a(b2.c())) {
                this.a.d.a(this.a.a(), this.a.a, b2.c(), 2, this.a);
            } else if (b2.c() == 18) {
                this.a.d.a(this.a.a().getApplicationContext(), (s) new aj(this, b.a(this.a.a(), (DialogInterface.OnCancelListener) this.a)));
            } else {
                this.a.a(b2, this.b.a());
            }
        }
    }
}
