package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final a a = new a();
    private final AtomicBoolean b = new AtomicBoolean();
    private final AtomicBoolean c = new AtomicBoolean();
    @GuardedBy("sInstance")
    private final ArrayList<C0023a> d = new ArrayList<>();
    @GuardedBy("sInstance")
    private boolean e = false;

    /* renamed from: com.google.android.gms.common.api.internal.a$a  reason: collision with other inner class name */
    public interface C0023a {
        void a(boolean z);
    }

    private a() {
    }

    public static a a() {
        return a;
    }

    public static void a(Application application) {
        synchronized (a) {
            if (!a.e) {
                application.registerActivityLifecycleCallbacks(a);
                application.registerComponentCallbacks(a);
                a.e = true;
            }
        }
    }

    private final void b(boolean z) {
        synchronized (a) {
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((C0023a) obj).a(z);
            }
        }
    }

    public final void a(C0023a aVar) {
        synchronized (a) {
            this.d.add(aVar);
        }
    }

    @TargetApi(16)
    public final boolean a(boolean z) {
        if (!this.c.get()) {
            if (!g.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.b.set(true);
            }
        }
        return b();
    }

    public final boolean b() {
        return this.b.get();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.b.compareAndSet(true, false);
        this.c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.b.compareAndSet(true, false);
        this.c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.b.compareAndSet(false, true)) {
            this.c.set(true);
            b(true);
        }
    }
}
