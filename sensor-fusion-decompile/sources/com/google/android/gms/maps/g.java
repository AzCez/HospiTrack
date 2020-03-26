package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.a.d;
import com.google.android.gms.maps.model.b;

public final class g {
    private final d a;

    g(d dVar) {
        this.a = dVar;
    }

    public final void a(boolean z) {
        try {
            this.a.a(z);
        } catch (RemoteException e) {
            throw new b(e);
        }
    }
}
