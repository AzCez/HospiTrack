package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.maps.a.b;

public final class c {
    private final b a;
    private g b;

    public c(b bVar) {
        this.a = (b) n.a(bVar);
    }

    public final int a() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            throw new com.google.android.gms.maps.model.b(e);
        }
    }

    public final void a(int i) {
        try {
            this.a.a(i);
        } catch (RemoteException e) {
            throw new com.google.android.gms.maps.model.b(e);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            this.a.a(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new com.google.android.gms.maps.model.b(e);
        }
    }

    public final void a(a aVar) {
        try {
            this.a.a(aVar.a());
        } catch (RemoteException e) {
            throw new com.google.android.gms.maps.model.b(e);
        }
    }

    public final void a(boolean z) {
        try {
            this.a.a(z);
        } catch (RemoteException e) {
            throw new com.google.android.gms.maps.model.b(e);
        }
    }

    public final g b() {
        try {
            if (this.b == null) {
                this.b = new g(this.a.b());
            }
            return this.b;
        } catch (RemoteException e) {
            throw new com.google.android.gms.maps.model.b(e);
        }
    }
}
