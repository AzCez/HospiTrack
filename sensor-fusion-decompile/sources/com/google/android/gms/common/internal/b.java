package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.maps.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class b<T extends IInterface> {
    public static final String[] d = {"service_esmobile", "service_googleme"};
    private static final Feature[] e = new Feature[0];
    /* access modifiers changed from: private */
    public ConnectionResult A = null;
    /* access modifiers changed from: private */
    public boolean B = false;
    private volatile zzb C = null;
    final Handler a;
    protected c b;
    protected AtomicInteger c = new AtomicInteger(0);
    private int f;
    private long g;
    private long h;
    private int i;
    private long j;
    private aa k;
    private final Context l;
    private final Looper m;
    private final g n;
    private final com.google.android.gms.common.c o;
    private final Object p = new Object();
    /* access modifiers changed from: private */
    public final Object q = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mServiceBrokerLock")
    public l r;
    @GuardedBy("mLock")
    private T s;
    /* access modifiers changed from: private */
    public final ArrayList<h<?>> t = new ArrayList<>();
    @GuardedBy("mLock")
    private j u;
    @GuardedBy("mLock")
    private int v = 1;
    /* access modifiers changed from: private */
    public final a w;
    /* access modifiers changed from: private */
    public final C0025b x;
    private final int y;
    private final String z;

    public interface a {
        void a(int i);

        void a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.internal.b$b  reason: collision with other inner class name */
    public interface C0025b {
        void a(ConnectionResult connectionResult);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    protected class d implements c {
        public d() {
        }

        public void a(ConnectionResult connectionResult) {
            if (connectionResult.b()) {
                b bVar = b.this;
                bVar.a((i) null, bVar.u());
            } else if (b.this.x != null) {
                b.this.x.a(connectionResult);
            }
        }
    }

    public interface e {
        void a();
    }

    private abstract class f extends h<Boolean> {
        private final int a;
        private final Bundle b;

        protected f(int i, Bundle bundle) {
            super(true);
            this.a = i;
            this.b = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void a(ConnectionResult connectionResult);

        /* JADX WARNING: type inference failed for: r5v11, types: [android.os.Parcelable] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void a(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                r0 = 1
                r1 = 0
                if (r5 != 0) goto L_0x000c
                com.google.android.gms.common.internal.b r5 = com.google.android.gms.common.internal.b.this
                r5.b(r0, null)
                return
            L_0x000c:
                int r5 = r4.a
                if (r5 == 0) goto L_0x0061
                r2 = 10
                if (r5 == r2) goto L_0x0031
                com.google.android.gms.common.internal.b r5 = com.google.android.gms.common.internal.b.this
                r5.b(r0, null)
                android.os.Bundle r5 = r4.b
                if (r5 == 0) goto L_0x0026
                java.lang.String r0 = "pendingIntent"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
            L_0x0026:
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                int r0 = r4.a
                r5.<init>(r0, r1)
                r4.a((com.google.android.gms.common.ConnectionResult) r5)
                goto L_0x0076
            L_0x0031:
                com.google.android.gms.common.internal.b r5 = com.google.android.gms.common.internal.b.this
                r5.b(r0, null)
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                java.lang.Class r3 = r4.getClass()
                java.lang.String r3 = r3.getSimpleName()
                r1[r2] = r3
                com.google.android.gms.common.internal.b r2 = com.google.android.gms.common.internal.b.this
                java.lang.String r2 = r2.i()
                r1[r0] = r2
                r0 = 2
                com.google.android.gms.common.internal.b r2 = com.google.android.gms.common.internal.b.this
                java.lang.String r2 = r2.k()
                r1[r0] = r2
                java.lang.String r0 = "A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. "
                java.lang.String r0 = java.lang.String.format(r0, r1)
                r5.<init>(r0)
                throw r5
            L_0x0061:
                boolean r5 = r4.a()
                if (r5 != 0) goto L_0x0076
                com.google.android.gms.common.internal.b r5 = com.google.android.gms.common.internal.b.this
                r5.b(r0, null)
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                r0 = 8
                r5.<init>(r0, r1)
                r4.a((com.google.android.gms.common.ConnectionResult) r5)
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.b.f.a(java.lang.Object):void");
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        /* access modifiers changed from: protected */
        public final void b() {
        }
    }

    final class g extends com.google.android.gms.d.b.e {
        public g(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.b();
            hVar.d();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r8) {
            /*
                r7 = this;
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.c
                int r0 = r0.get()
                int r1 = r8.arg1
                if (r0 == r1) goto L_0x0016
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x0015
                a(r8)
            L_0x0015:
                return
            L_0x0016:
                int r0 = r8.what
                r1 = 4
                r2 = 1
                r3 = 5
                if (r0 == r2) goto L_0x002a
                int r0 = r8.what
                r4 = 7
                if (r0 == r4) goto L_0x002a
                int r0 = r8.what
                if (r0 == r1) goto L_0x002a
                int r0 = r8.what
                if (r0 != r3) goto L_0x0036
            L_0x002a:
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                boolean r0 = r0.c()
                if (r0 != 0) goto L_0x0036
                a(r8)
                return
            L_0x0036:
                int r0 = r8.what
                r4 = 8
                r5 = 3
                r6 = 0
                if (r0 != r1) goto L_0x0081
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r1.<init>(r8)
                com.google.android.gms.common.ConnectionResult unused = r0.A = r1
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                boolean r8 = r8.x()
                if (r8 == 0) goto L_0x0060
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                boolean r8 = r8.B
                if (r8 != 0) goto L_0x0060
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                r8.b(r5, null)
                return
            L_0x0060:
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.ConnectionResult r8 = r8.A
                if (r8 == 0) goto L_0x006f
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.ConnectionResult r8 = r8.A
                goto L_0x0074
            L_0x006f:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r4)
            L_0x0074:
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.internal.b$c r0 = r0.b
                r0.a(r8)
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                r0.a((com.google.android.gms.common.ConnectionResult) r8)
                return
            L_0x0081:
                int r0 = r8.what
                if (r0 != r3) goto L_0x00a6
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.ConnectionResult r8 = r8.A
                if (r8 == 0) goto L_0x0094
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.ConnectionResult r8 = r8.A
                goto L_0x0099
            L_0x0094:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r4)
            L_0x0099:
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.internal.b$c r0 = r0.b
                r0.a(r8)
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                r0.a((com.google.android.gms.common.ConnectionResult) r8)
                return
            L_0x00a6:
                int r0 = r8.what
                if (r0 != r5) goto L_0x00c9
                java.lang.Object r0 = r8.obj
                boolean r0 = r0 instanceof android.app.PendingIntent
                if (r0 == 0) goto L_0x00b5
                java.lang.Object r0 = r8.obj
                r6 = r0
                android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            L_0x00b5:
                com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r0.<init>(r8, r6)
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.internal.b$c r8 = r8.b
                r8.a(r0)
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                r8.a((com.google.android.gms.common.ConnectionResult) r0)
                return
            L_0x00c9:
                int r0 = r8.what
                r1 = 6
                if (r0 != r1) goto L_0x00f3
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                r0.b(r3, null)
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.internal.b$a r0 = r0.w
                if (r0 == 0) goto L_0x00e6
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                com.google.android.gms.common.internal.b$a r0 = r0.w
                int r1 = r8.arg2
                r0.a((int) r1)
            L_0x00e6:
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                int r8 = r8.arg2
                r0.a((int) r8)
                com.google.android.gms.common.internal.b r8 = com.google.android.gms.common.internal.b.this
                boolean unused = r8.a((int) r3, (int) r2, r6)
                return
            L_0x00f3:
                int r0 = r8.what
                r1 = 2
                if (r0 != r1) goto L_0x0104
                com.google.android.gms.common.internal.b r0 = com.google.android.gms.common.internal.b.this
                boolean r0 = r0.b()
                if (r0 != 0) goto L_0x0104
                a(r8)
                return
            L_0x0104:
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x0112
                java.lang.Object r8 = r8.obj
                com.google.android.gms.common.internal.b$h r8 = (com.google.android.gms.common.internal.b.h) r8
                r8.c()
                return
            L_0x0112:
                java.lang.String r0 = "GmsClient"
                int r8 = r8.what
                r1 = 45
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "Don't know how to handle message: "
                r2.append(r1)
                r2.append(r8)
                java.lang.String r8 = r2.toString()
                java.lang.Exception r1 = new java.lang.Exception
                r1.<init>()
                android.util.Log.wtf(r0, r8, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.b.g.handleMessage(android.os.Message):void");
        }
    }

    protected abstract class h<TListener> {
        private TListener a;
        private boolean b = false;

        public h(TListener tlistener) {
            this.a = tlistener;
        }

        /* access modifiers changed from: protected */
        public abstract void a(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void b();

        public final void c() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e) {
                    b();
                    throw e;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.b = true;
            }
            d();
        }

        public final void d() {
            e();
            synchronized (b.this.t) {
                b.this.t.remove(this);
            }
        }

        public final void e() {
            synchronized (this) {
                this.a = null;
            }
        }
    }

    public static final class i extends k.a {
        private b a;
        private final int b;

        public i(b bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        public final void a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public final void a(int i, IBinder iBinder, Bundle bundle) {
            n.a(this.a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.a.a(i, iBinder, bundle, this.b);
            this.a = null;
        }

        public final void a(int i, IBinder iBinder, zzb zzb) {
            n.a(this.a, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            n.a(zzb);
            this.a.a(zzb);
            a(i, iBinder, zzb.a);
        }
    }

    public final class j implements ServiceConnection {
        private final int a;

        public j(int i) {
            this.a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            l lVar;
            if (iBinder == null) {
                b.this.c(16);
                return;
            }
            synchronized (b.this.q) {
                b bVar = b.this;
                if (iBinder == null) {
                    lVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    lVar = (queryLocalInterface == null || !(queryLocalInterface instanceof l)) ? new l.a.C0027a(iBinder) : (l) queryLocalInterface;
                }
                l unused = bVar.r = lVar;
            }
            b.this.a(0, (Bundle) null, this.a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (b.this.q) {
                l unused = b.this.r = null;
            }
            b.this.a.sendMessage(b.this.a.obtainMessage(6, this.a, 1));
        }
    }

    protected final class k extends f {
        private final IBinder a;

        public k(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.a = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void a(ConnectionResult connectionResult) {
            if (b.this.x != null) {
                b.this.x.a(connectionResult);
            }
            b.this.a(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean a() {
            try {
                String interfaceDescriptor = this.a.getInterfaceDescriptor();
                if (!b.this.k().equals(interfaceDescriptor)) {
                    String k = b.this.k();
                    StringBuilder sb = new StringBuilder(String.valueOf(k).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(k);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface a2 = b.this.a(this.a);
                if (a2 == null) {
                    return false;
                }
                if (!b.this.a(2, 4, a2) && !b.this.a(3, 4, a2)) {
                    return false;
                }
                ConnectionResult unused = b.this.A = null;
                Bundle r = b.this.r();
                if (b.this.w != null) {
                    b.this.w.a(r);
                }
                return true;
            } catch (RemoteException unused2) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class l extends f {
        public l(int i, Bundle bundle) {
            super(i, (Bundle) null);
        }

        /* access modifiers changed from: protected */
        public final void a(ConnectionResult connectionResult) {
            b.this.b.a(connectionResult);
            b.this.a(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean a() {
            b.this.b.a(ConnectionResult.a);
            return true;
        }
    }

    protected b(Context context, Looper looper, g gVar, com.google.android.gms.common.c cVar, int i2, a aVar, C0025b bVar, String str) {
        this.l = (Context) n.a(context, (Object) "Context must not be null");
        this.m = (Looper) n.a(looper, (Object) "Looper must not be null");
        this.n = (g) n.a(gVar, (Object) "Supervisor must not be null");
        this.o = (com.google.android.gms.common.c) n.a(cVar, (Object) "API availability must not be null");
        this.a = new g(looper);
        this.y = i2;
        this.w = aVar;
        this.x = bVar;
        this.z = str;
    }

    /* access modifiers changed from: private */
    public final void a(zzb zzb) {
        this.C = zzb;
    }

    /* access modifiers changed from: private */
    public final boolean a(int i2, int i3, T t2) {
        synchronized (this.p) {
            if (this.v != i2) {
                return false;
            }
            b(i3, t2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void b(int i2, T t2) {
        n.b((i2 == 4) == (t2 != null));
        synchronized (this.p) {
            this.v = i2;
            this.s = t2;
            a(i2, t2);
            switch (i2) {
                case f.a.MapAttrs_cameraBearing /*1*/:
                    if (this.u != null) {
                        this.n.a(i(), j(), 129, this.u, v());
                        this.u = null;
                        break;
                    }
                    break;
                case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                    if (!(this.u == null || this.k == null)) {
                        String a2 = this.k.a();
                        String b2 = this.k.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 70 + String.valueOf(b2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(a2);
                        sb.append(" on ");
                        sb.append(b2);
                        Log.e("GmsClient", sb.toString());
                        this.n.a(this.k.a(), this.k.b(), this.k.c(), this.u, v());
                        this.c.incrementAndGet();
                    }
                    this.u = new j(this.c.get());
                    this.k = (this.v != 3 || l() == null) ? new aa(j(), i(), false, 129) : new aa(m().getPackageName(), l(), true, 129);
                    if (!this.n.a(new g.a(this.k.a(), this.k.b(), this.k.c()), this.u, v())) {
                        String a3 = this.k.a();
                        String b3 = this.k.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(a3).length() + 34 + String.valueOf(b3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(a3);
                        sb2.append(" on ");
                        sb2.append(b3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.c.get());
                        break;
                    }
                    break;
                case f.a.MapAttrs_cameraTargetLat /*4*/:
                    a(t2);
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        int i3;
        if (w()) {
            i3 = 5;
            this.B = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(i3, this.c.get(), 16));
    }

    private final String v() {
        String str = this.z;
        return str == null ? this.l.getClass().getName() : str;
    }

    private final boolean w() {
        boolean z2;
        synchronized (this.p) {
            z2 = this.v == 3;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public final boolean x() {
        if (this.B || TextUtils.isEmpty(k()) || TextUtils.isEmpty(l())) {
            return false;
        }
        try {
            Class.forName(k());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);

    public void a() {
        this.c.incrementAndGet();
        synchronized (this.t) {
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.t.get(i2).e();
            }
            this.t.clear();
        }
        synchronized (this.q) {
            this.r = null;
        }
        b(1, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.f = i2;
        this.g = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Bundle bundle, int i3) {
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, (Bundle) null)));
    }

    /* access modifiers changed from: protected */
    public void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, T t2) {
    }

    /* access modifiers changed from: protected */
    public void a(T t2) {
        this.h = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void a(ConnectionResult connectionResult) {
        this.i = connectionResult.c();
        this.j = System.currentTimeMillis();
    }

    public void a(c cVar) {
        this.b = (c) n.a(cVar, (Object) "Connection progress callbacks cannot be null.");
        b(2, (IInterface) null);
    }

    public void a(e eVar) {
        eVar.a();
    }

    public void a(i iVar, Set<Scope> set) {
        Bundle p2 = p();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.y);
        getServiceRequest.a = this.l.getPackageName();
        getServiceRequest.d = p2;
        if (set != null) {
            getServiceRequest.c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (d()) {
            getServiceRequest.e = n() != null ? n() : new Account("<<default account>>", "com.google");
            if (iVar != null) {
                getServiceRequest.b = iVar.asBinder();
            }
        } else if (t()) {
            getServiceRequest.e = n();
        }
        getServiceRequest.f = e;
        getServiceRequest.g = o();
        try {
            synchronized (this.q) {
                if (this.r != null) {
                    this.r.a(new i(this, this.c.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            b(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            a(8, (IBinder) null, (Bundle) null, this.c.get());
        }
    }

    public void b(int i2) {
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(6, this.c.get(), i2));
    }

    public boolean b() {
        boolean z2;
        synchronized (this.p) {
            z2 = this.v == 4;
        }
        return z2;
    }

    public boolean c() {
        boolean z2;
        synchronized (this.p) {
            if (this.v != 2) {
                if (this.v != 3) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public String f() {
        aa aaVar;
        if (b() && (aaVar = this.k) != null) {
            return aaVar.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int g() {
        return com.google.android.gms.common.c.b;
    }

    public final Feature[] h() {
        zzb zzb = this.C;
        if (zzb == null) {
            return null;
        }
        return zzb.b;
    }

    /* access modifiers changed from: protected */
    public abstract String i();

    /* access modifiers changed from: protected */
    public String j() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: protected */
    public abstract String k();

    /* access modifiers changed from: protected */
    public String l() {
        return null;
    }

    public final Context m() {
        return this.l;
    }

    public Account n() {
        return null;
    }

    public Feature[] o() {
        return e;
    }

    /* access modifiers changed from: protected */
    public Bundle p() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public final void q() {
        if (!b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle r() {
        return null;
    }

    public final T s() {
        T t2;
        synchronized (this.p) {
            if (this.v != 5) {
                q();
                n.a(this.s != null, (Object) "Client is connected but service is null");
                t2 = this.s;
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    public boolean t() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> u() {
        return Collections.EMPTY_SET;
    }
}
