package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.model.LatLng;

public final class b {
    private static a a;

    private static a a() {
        return (a) n.a(a, (Object) "CameraUpdateFactory is not initialized");
    }

    public static a a(LatLng latLng, float f) {
        try {
            return new a(a().a(latLng, f));
        } catch (RemoteException e) {
            throw new com.google.android.gms.maps.model.b(e);
        }
    }

    public static void a(a aVar) {
        a = (a) n.a(aVar);
    }
}
