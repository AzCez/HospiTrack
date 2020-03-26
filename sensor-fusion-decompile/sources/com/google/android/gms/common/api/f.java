package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public abstract class f {
    @GuardedBy("sAllClients")
    private static final Set<f> a = Collections.newSetFromMap(new WeakHashMap());

    public interface a {
        void a(int i);

        void a(Bundle bundle);
    }

    public interface b {
        void a(ConnectionResult connectionResult);
    }
}
