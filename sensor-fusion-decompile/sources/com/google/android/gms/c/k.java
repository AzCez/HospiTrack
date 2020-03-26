package com.google.android.gms.c;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.e.a;
import java.util.concurrent.ExecutorService;

public abstract class k extends Service {
    final ExecutorService a;
    private Binder b;
    private final Object c;
    private int d;
    private int e;

    /* access modifiers changed from: private */
    public final void b(Intent intent) {
        if (intent != null) {
            a.a(intent);
        }
        synchronized (this.c) {
            this.e--;
            if (this.e == 0) {
                stopSelfResult(this.d);
            }
        }
    }

    public abstract void a(Intent intent);

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.b == null) {
            this.b = new m(this);
        }
        return this.b;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.c) {
            this.d = i2;
            this.e++;
        }
        if (intent == null) {
            b(intent);
            return 2;
        }
        this.a.execute(new l(this, intent, intent));
        return 3;
    }
}
