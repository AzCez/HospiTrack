package com.google.android.gms.c;

import javax.annotation.concurrent.GuardedBy;

public abstract class g {
    @GuardedBy("SdkFlagFactory.class")
    private static g a;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new c();
            }
            gVar = a;
        }
        return gVar;
    }

    public abstract h<Boolean> a(String str, boolean z);
}
