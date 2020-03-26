package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.util.g;

public abstract class k {
    private final int a;

    public k(int i) {
        this.a = i;
    }

    /* access modifiers changed from: private */
    public static Status b(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (g.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(Status status);

    public abstract void a(b.a<?> aVar);

    public abstract void a(h hVar, boolean z);

    public abstract void a(RuntimeException runtimeException);
}
