package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.maps.a.l;
import com.google.android.gms.maps.a.m;
import com.google.android.gms.maps.model.a;
import com.google.android.gms.maps.model.b;
import javax.annotation.concurrent.GuardedBy;

public final class d {
    @GuardedBy("MapsInitializer.class")
    private static boolean a = false;

    public static synchronized int a(Context context) {
        synchronized (d.class) {
            n.a(context, (Object) "Context is null");
            if (a) {
                return 0;
            }
            try {
                m a2 = l.a(context);
                try {
                    b.a(a2.a_());
                    a.a(a2.b());
                    a = true;
                    return 0;
                } catch (RemoteException e) {
                    throw new b(e);
                }
            } catch (com.google.android.gms.common.d e2) {
                return e2.a;
            }
        }
    }
}
