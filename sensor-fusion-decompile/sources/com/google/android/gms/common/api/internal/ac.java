package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.f.b;

abstract class ac<T> extends v {
    protected final b<T> a;

    public ac(int i, b<T> bVar) {
        super(i);
        this.a = bVar;
    }

    public void a(Status status) {
        this.a.b((Exception) new com.google.android.gms.common.api.b(status));
    }

    public final void a(b.a<?> aVar) {
        try {
            d(aVar);
        } catch (DeadObjectException e) {
            a(k.b(e));
            throw e;
        } catch (RemoteException e2) {
            a(k.b(e2));
        } catch (RuntimeException e3) {
            a(e3);
        }
    }

    public void a(h hVar, boolean z) {
    }

    public void a(RuntimeException runtimeException) {
        this.a.b((Exception) runtimeException);
    }

    /* access modifiers changed from: protected */
    public abstract void d(b.a<?> aVar);
}
