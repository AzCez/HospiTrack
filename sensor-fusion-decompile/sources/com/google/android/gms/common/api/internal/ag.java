package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ag extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference<ah> c;
    protected final b d;
    private final Handler e;

    private static int a(ah ahVar) {
        if (ahVar == null) {
            return -1;
        }
        return ahVar.a();
    }

    /* access modifiers changed from: protected */
    public abstract void a(ConnectionResult connectionResult, int i);

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void b(ConnectionResult connectionResult, int i) {
        ah ahVar = new ah(connectionResult, i);
        if (this.c.compareAndSet((Object) null, ahVar)) {
            this.e.post(new ai(this, ahVar));
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.c.set((Object) null);
        b();
    }

    public void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, (PendingIntent) null), a(this.c.get()));
        c();
    }
}
