package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.d.a.e;
import com.google.android.gms.maps.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends i> extends g<R> {
    static final ThreadLocal<Boolean> a = new ak();
    private final Object b = new Object();
    private final a<R> c = new a<>(Looper.getMainLooper());
    private final WeakReference<f> d = new WeakReference<>((Object) null);
    private final CountDownLatch e = new CountDownLatch(1);
    private final ArrayList<g.a> f = new ArrayList<>();
    private j<? super R> g;
    private final AtomicReference<ab> h = new AtomicReference<>();
    /* access modifiers changed from: private */
    public R i;
    private Status j;
    private volatile boolean k;
    private boolean l;
    private boolean m;
    @KeepName
    private b mResultGuardian;
    private com.google.android.gms.common.internal.j n;
    private boolean o = false;

    public static class a<R extends i> extends e {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void a(j<? super R> jVar, R r) {
            sendMessage(obtainMessage(1, new Pair(jVar, r)));
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    Pair pair = (Pair) message.obj;
                    j jVar = (j) pair.first;
                    i iVar = (i) pair.second;
                    try {
                        jVar.a(iVar);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.b(iVar);
                        throw e;
                    }
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                    ((BasePendingResult) message.obj).a(Status.d);
                    return;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
            }
        }
    }

    private final class b {
        private b() {
        }

        /* synthetic */ b(BasePendingResult basePendingResult, ak akVar) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void finalize() {
            BasePendingResult.b(BasePendingResult.this.i);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
    }

    private final R b() {
        R r;
        synchronized (this.b) {
            n.a(!this.k, (Object) "Result has already been consumed.");
            n.a(a(), (Object) "Result is not ready.");
            r = this.i;
            this.i = null;
            this.g = null;
            this.k = true;
        }
        ab andSet = this.h.getAndSet((Object) null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    public static void b(i iVar) {
        if (iVar instanceof h) {
            try {
                ((h) iVar).a();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(iVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    private final void c(R r) {
        this.i = r;
        this.n = null;
        this.e.countDown();
        this.j = this.i.a();
        if (this.l) {
            this.g = null;
        } else if (this.g != null) {
            this.c.removeMessages(2);
            this.c.a(this.g, b());
        } else if (this.i instanceof h) {
            this.mResultGuardian = new b(this, (ak) null);
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((g.a) obj).a(this.j);
        }
        this.f.clear();
    }

    public final void a(Status status) {
        synchronized (this.b) {
            if (!a()) {
                a(b(status));
                this.m = true;
            }
        }
    }

    public final void a(R r) {
        synchronized (this.b) {
            if (this.m || this.l) {
                b((i) r);
                return;
            }
            a();
            boolean z = true;
            n.a(!a(), (Object) "Results have already been set");
            if (this.k) {
                z = false;
            }
            n.a(z, (Object) "Result has already been consumed");
            c(r);
        }
    }

    public final boolean a() {
        return this.e.getCount() == 0;
    }

    /* access modifiers changed from: protected */
    public abstract R b(Status status);
}
