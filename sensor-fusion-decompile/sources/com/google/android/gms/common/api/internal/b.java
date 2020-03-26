package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.util.g;
import com.google.android.gms.maps.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public class b implements Handler.Callback {
    public static final Status a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */
    public static final Status b = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */
    public static final Object f = new Object();
    @GuardedBy("lock")
    private static b g;
    /* access modifiers changed from: private */
    public long c = 5000;
    /* access modifiers changed from: private */
    public long d = 120000;
    /* access modifiers changed from: private */
    public long e = 10000;
    /* access modifiers changed from: private */
    public final Context h;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.b i;
    /* access modifiers changed from: private */
    public final h j;
    private final AtomicInteger k = new AtomicInteger(1);
    private final AtomicInteger l = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<ae<?>, a<?>> m = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public i n = null;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final Set<ae<?>> o = new android.support.v4.b.b();
    private final Set<ae<?>> p = new android.support.v4.b.b();
    /* access modifiers changed from: private */
    public final Handler q;

    public class a<O extends a.d> implements f.a, f.b, al {
        private final Queue<k> b = new LinkedList();
        /* access modifiers changed from: private */
        public final a.f c;
        private final a.b d;
        private final ae<O> e;
        private final h f;
        private final Set<af> g = new HashSet();
        private final Map<e.a<?>, u> h = new HashMap();
        private final int i;
        private final w j;
        private boolean k;
        private final List<C0024b> l = new ArrayList();
        private ConnectionResult m = null;

        public a(com.google.android.gms.common.api.e<O> eVar) {
            this.c = eVar.a(b.this.q.getLooper(), (a<O>) this);
            a.b bVar = this.c;
            this.d = bVar instanceof o ? ((o) bVar).v() : bVar;
            this.e = eVar.a();
            this.f = new h();
            this.i = eVar.b();
            if (this.c.d()) {
                this.j = eVar.a(b.this.h, b.this.q);
            } else {
                this.j = null;
            }
        }

        private final Feature a(Feature[] featureArr) {
            if (!(featureArr == null || featureArr.length == 0)) {
                Feature[] h2 = this.c.h();
                if (h2 == null) {
                    h2 = new Feature[0];
                }
                android.support.v4.b.a aVar = new android.support.v4.b.a(h2.length);
                for (Feature feature : h2) {
                    aVar.put(feature.a(), Long.valueOf(feature.b()));
                }
                for (Feature feature2 : featureArr) {
                    if (!aVar.containsKey(feature2.a()) || ((Long) aVar.get(feature2.a())).longValue() < feature2.b()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final void a(C0024b bVar) {
            if (!this.l.contains(bVar) || this.k) {
                return;
            }
            if (!this.c.b()) {
                i();
            } else {
                o();
            }
        }

        /* access modifiers changed from: private */
        public final boolean a(boolean z) {
            n.a(b.this.q);
            if (!this.c.b() || this.h.size() != 0) {
                return false;
            }
            if (this.f.a()) {
                if (z) {
                    q();
                }
                return false;
            }
            this.c.a();
            return true;
        }

        /* access modifiers changed from: private */
        public final void b(C0024b bVar) {
            Feature[] b2;
            if (this.l.remove(bVar)) {
                b.this.q.removeMessages(15, bVar);
                b.this.q.removeMessages(16, bVar);
                Feature b3 = bVar.b;
                ArrayList arrayList = new ArrayList(this.b.size());
                for (k kVar : this.b) {
                    if ((kVar instanceof v) && (b2 = ((v) kVar).b(this)) != null && com.google.android.gms.common.util.a.a(b2, b3)) {
                        arrayList.add(kVar);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    k kVar2 = (k) obj;
                    this.b.remove(kVar2);
                    kVar2.a((RuntimeException) new k(b3));
                }
            }
        }

        private final boolean b(k kVar) {
            if (!(kVar instanceof v)) {
                c(kVar);
                return true;
            }
            v vVar = (v) kVar;
            Feature a2 = a(vVar.b(this));
            if (a2 == null) {
                c(kVar);
                return true;
            } else if (vVar.c(this)) {
                C0024b bVar = new C0024b(this.e, a2, (l) null);
                int indexOf = this.l.indexOf(bVar);
                if (indexOf >= 0) {
                    C0024b bVar2 = this.l.get(indexOf);
                    b.this.q.removeMessages(15, bVar2);
                    b.this.q.sendMessageDelayed(Message.obtain(b.this.q, 15, bVar2), b.this.c);
                    return false;
                }
                this.l.add(bVar);
                b.this.q.sendMessageDelayed(Message.obtain(b.this.q, 15, bVar), b.this.c);
                b.this.q.sendMessageDelayed(Message.obtain(b.this.q, 16, bVar), b.this.d);
                ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
                if (c(connectionResult)) {
                    return false;
                }
                b.this.a(connectionResult, this.i);
                return false;
            } else {
                vVar.a((RuntimeException) new k(a2));
                return false;
            }
        }

        private final void c(k kVar) {
            kVar.a(this.f, k());
            try {
                kVar.a((a<?>) this);
            } catch (DeadObjectException unused) {
                a(1);
                this.c.a();
            }
        }

        private final boolean c(ConnectionResult connectionResult) {
            synchronized (b.f) {
                if (b.this.n == null || !b.this.o.contains(this.e)) {
                    return false;
                }
                b.this.n.b(connectionResult, this.i);
                return true;
            }
        }

        private final void d(ConnectionResult connectionResult) {
            for (af next : this.g) {
                String str = null;
                if (m.a(connectionResult, ConnectionResult.a)) {
                    str = this.c.f();
                }
                next.a(this.e, connectionResult, str);
            }
            this.g.clear();
        }

        /* access modifiers changed from: private */
        public final void m() {
            d();
            d(ConnectionResult.a);
            p();
            Iterator<u> it = this.h.values().iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (a(next.a.b()) == null) {
                    try {
                        next.a.a(this.d, new com.google.android.gms.f.b());
                    } catch (DeadObjectException unused) {
                        a(1);
                        this.c.a();
                    } catch (RemoteException unused2) {
                    }
                }
                it.remove();
            }
            o();
            q();
        }

        /* access modifiers changed from: private */
        public final void n() {
            d();
            this.k = true;
            this.f.c();
            b.this.q.sendMessageDelayed(Message.obtain(b.this.q, 9, this.e), b.this.c);
            b.this.q.sendMessageDelayed(Message.obtain(b.this.q, 11, this.e), b.this.d);
            b.this.j.a();
        }

        private final void o() {
            ArrayList arrayList = new ArrayList(this.b);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                k kVar = (k) obj;
                if (!this.c.b()) {
                    return;
                }
                if (b(kVar)) {
                    this.b.remove(kVar);
                }
            }
        }

        private final void p() {
            if (this.k) {
                b.this.q.removeMessages(11, this.e);
                b.this.q.removeMessages(9, this.e);
                this.k = false;
            }
        }

        private final void q() {
            b.this.q.removeMessages(12, this.e);
            b.this.q.sendMessageDelayed(b.this.q.obtainMessage(12, this.e), b.this.e);
        }

        public final void a() {
            n.a(b.this.q);
            a(b.a);
            this.f.b();
            for (e.a adVar : (e.a[]) this.h.keySet().toArray(new e.a[this.h.size()])) {
                a((k) new ad(adVar, new com.google.android.gms.f.b()));
            }
            d(new ConnectionResult(4));
            if (this.c.b()) {
                this.c.a((b.e) new o(this));
            }
        }

        public final void a(int i2) {
            if (Looper.myLooper() == b.this.q.getLooper()) {
                n();
            } else {
                b.this.q.post(new n(this));
            }
        }

        public final void a(Bundle bundle) {
            if (Looper.myLooper() == b.this.q.getLooper()) {
                m();
            } else {
                b.this.q.post(new m(this));
            }
        }

        public final void a(ConnectionResult connectionResult) {
            n.a(b.this.q);
            w wVar = this.j;
            if (wVar != null) {
                wVar.a();
            }
            d();
            b.this.j.a();
            d(connectionResult);
            if (connectionResult.c() == 4) {
                a(b.b);
            } else if (this.b.isEmpty()) {
                this.m = connectionResult;
            } else if (!c(connectionResult) && !b.this.a(connectionResult, this.i)) {
                if (connectionResult.c() == 18) {
                    this.k = true;
                }
                if (this.k) {
                    b.this.q.sendMessageDelayed(Message.obtain(b.this.q, 9, this.e), b.this.c);
                    return;
                }
                String a2 = this.e.a();
                StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 38);
                sb.append("API: ");
                sb.append(a2);
                sb.append(" is not available on this device.");
                a(new Status(17, sb.toString()));
            }
        }

        public final void a(Status status) {
            n.a(b.this.q);
            for (k a2 : this.b) {
                a2.a(status);
            }
            this.b.clear();
        }

        public final void a(af afVar) {
            n.a(b.this.q);
            this.g.add(afVar);
        }

        public final void a(k kVar) {
            n.a(b.this.q);
            if (!this.c.b()) {
                this.b.add(kVar);
                ConnectionResult connectionResult = this.m;
                if (connectionResult == null || !connectionResult.a()) {
                    i();
                } else {
                    a(this.m);
                }
            } else if (b(kVar)) {
                q();
            } else {
                this.b.add(kVar);
            }
        }

        public final a.f b() {
            return this.c;
        }

        public final void b(ConnectionResult connectionResult) {
            n.a(b.this.q);
            this.c.a();
            a(connectionResult);
        }

        public final Map<e.a<?>, u> c() {
            return this.h;
        }

        public final void d() {
            n.a(b.this.q);
            this.m = null;
        }

        public final ConnectionResult e() {
            n.a(b.this.q);
            return this.m;
        }

        public final void f() {
            n.a(b.this.q);
            if (this.k) {
                i();
            }
        }

        public final void g() {
            n.a(b.this.q);
            if (this.k) {
                p();
                a(b.this.i.a(b.this.h) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.c.a();
            }
        }

        public final boolean h() {
            return a(true);
        }

        public final void i() {
            n.a(b.this.q);
            if (!this.c.b() && !this.c.c()) {
                int a2 = b.this.j.a(b.this.h, this.c);
                if (a2 != 0) {
                    a(new ConnectionResult(a2, (PendingIntent) null));
                    return;
                }
                c cVar = new c(this.c, this.e);
                if (this.c.d()) {
                    this.j.a((z) cVar);
                }
                this.c.a((b.c) cVar);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean j() {
            return this.c.b();
        }

        public final boolean k() {
            return this.c.d();
        }

        public final int l() {
            return this.i;
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.b$b  reason: collision with other inner class name */
    private static class C0024b {
        /* access modifiers changed from: private */
        public final ae<?> a;
        /* access modifiers changed from: private */
        public final Feature b;

        private C0024b(ae<?> aeVar, Feature feature) {
            this.a = aeVar;
            this.b = feature;
        }

        /* synthetic */ C0024b(ae aeVar, Feature feature, l lVar) {
            this(aeVar, feature);
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof C0024b)) {
                C0024b bVar = (C0024b) obj;
                return m.a(this.a, bVar.a) && m.a(this.b, bVar.b);
            }
        }

        public final int hashCode() {
            return m.a(this.a, this.b);
        }

        public final String toString() {
            return m.a((Object) this).a("key", this.a).a("feature", this.b).toString();
        }
    }

    private class c implements z, b.c {
        /* access modifiers changed from: private */
        public final a.f b;
        /* access modifiers changed from: private */
        public final ae<?> c;
        private i d = null;
        private Set<Scope> e = null;
        /* access modifiers changed from: private */
        public boolean f = false;

        public c(a.f fVar, ae<?> aeVar) {
            this.b = fVar;
            this.c = aeVar;
        }

        /* access modifiers changed from: private */
        public final void a() {
            i iVar;
            if (this.f && (iVar = this.d) != null) {
                this.b.a(iVar, this.e);
            }
        }

        public final void a(ConnectionResult connectionResult) {
            b.this.q.post(new q(this, connectionResult));
        }

        public final void a(i iVar, Set<Scope> set) {
            if (iVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new ConnectionResult(4));
                return;
            }
            this.d = iVar;
            this.e = set;
            a();
        }

        public final void b(ConnectionResult connectionResult) {
            ((a) b.this.m.get(this.c)).b(connectionResult);
        }
    }

    private b(Context context, Looper looper, com.google.android.gms.common.b bVar) {
        this.h = context;
        this.q = new com.google.android.gms.d.a.e(looper, this);
        this.i = bVar;
        this.j = new h(bVar);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static b a(Context context) {
        b bVar;
        synchronized (f) {
            if (g == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                g = new b(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.b.a());
            }
            bVar = g;
        }
        return bVar;
    }

    private final void a(com.google.android.gms.common.api.e<?> eVar) {
        ae<?> a2 = eVar.a();
        a aVar = this.m.get(a2);
        if (aVar == null) {
            aVar = new a(eVar);
            this.m.put(a2, aVar);
        }
        if (aVar.k()) {
            this.p.add(a2);
        }
        aVar.i();
    }

    public final void a() {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ConnectionResult connectionResult, int i2) {
        return this.i.a(this.h, connectionResult, i2);
    }

    public final void b(ConnectionResult connectionResult, int i2) {
        if (!a(connectionResult, i2)) {
            Handler handler = this.q;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
        }
    }

    public boolean handleMessage(Message message) {
        a aVar;
        com.google.android.gms.f.b<Boolean> bVar;
        boolean z;
        long j2 = 300000;
        switch (message.what) {
            case f.a.MapAttrs_cameraBearing /*1*/:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.e = j2;
                this.q.removeMessages(12);
                for (ae<?> obtainMessage : this.m.keySet()) {
                    Handler handler = this.q;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.e);
                }
                break;
            case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                af afVar = (af) message.obj;
                Iterator<ae<?>> it = afVar.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        ae next = it.next();
                        a aVar2 = this.m.get(next);
                        if (aVar2 == null) {
                            afVar.a(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (aVar2.j()) {
                            afVar.a(next, ConnectionResult.a, aVar2.b().f());
                        } else if (aVar2.e() != null) {
                            afVar.a(next, aVar2.e(), (String) null);
                        } else {
                            aVar2.a(afVar);
                            aVar2.i();
                        }
                    }
                }
            case f.a.MapAttrs_cameraMinZoomPreference /*3*/:
                for (a next2 : this.m.values()) {
                    next2.d();
                    next2.i();
                }
                break;
            case f.a.MapAttrs_cameraTargetLat /*4*/:
            case f.a.MapAttrs_latLngBoundsNorthEastLatitude /*8*/:
            case f.a.MapAttrs_mapType /*13*/:
                t tVar = (t) message.obj;
                a aVar3 = this.m.get(tVar.c.a());
                if (aVar3 == null) {
                    a(tVar.c);
                    aVar3 = this.m.get(tVar.c.a());
                }
                if (aVar3.k() && this.l.get() != tVar.b) {
                    tVar.a.a(a);
                    aVar3.a();
                    break;
                } else {
                    aVar3.a(tVar.a);
                    break;
                }
                break;
            case f.a.MapAttrs_cameraTargetLng /*5*/:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it2 = this.m.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        aVar = it2.next();
                        if (aVar.l() == i2) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i2);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                    break;
                } else {
                    String b2 = this.i.b(connectionResult.c());
                    String e2 = connectionResult.e();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b2).length() + 69 + String.valueOf(e2).length());
                    sb2.append("Error resolution was canceled by the user, original error message: ");
                    sb2.append(b2);
                    sb2.append(": ");
                    sb2.append(e2);
                    aVar.a(new Status(17, sb2.toString()));
                    break;
                }
            case f.a.MapAttrs_cameraTilt /*6*/:
                if (g.a() && (this.h.getApplicationContext() instanceof Application)) {
                    a.a((Application) this.h.getApplicationContext());
                    a.a().a((a.C0023a) new l(this));
                    if (!a.a().a(true)) {
                        this.e = 300000;
                        break;
                    }
                }
                break;
            case f.a.MapAttrs_cameraZoom /*7*/:
                a((com.google.android.gms.common.api.e<?>) (com.google.android.gms.common.api.e) message.obj);
                break;
            case f.a.MapAttrs_latLngBoundsNorthEastLongitude /*9*/:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).f();
                    break;
                }
                break;
            case f.a.MapAttrs_latLngBoundsSouthWestLatitude /*10*/:
                for (ae<?> remove : this.p) {
                    this.m.remove(remove).a();
                }
                this.p.clear();
                break;
            case f.a.MapAttrs_latLngBoundsSouthWestLongitude /*11*/:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).g();
                    break;
                }
                break;
            case f.a.MapAttrs_liteMode /*12*/:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).h();
                    break;
                }
                break;
            case f.a.MapAttrs_uiCompass /*14*/:
                j jVar = (j) message.obj;
                ae<?> a2 = jVar.a();
                if (!this.m.containsKey(a2)) {
                    bVar = jVar.b();
                    z = false;
                } else {
                    boolean a3 = this.m.get(a2).a(false);
                    bVar = jVar.b();
                    z = Boolean.valueOf(a3);
                }
                bVar.a(z);
                break;
            case f.a.MapAttrs_uiMapToolbar /*15*/:
                C0024b bVar2 = (C0024b) message.obj;
                if (this.m.containsKey(bVar2.a)) {
                    this.m.get(bVar2.a).a(bVar2);
                    break;
                }
                break;
            case f.a.MapAttrs_uiRotateGestures /*16*/:
                C0024b bVar3 = (C0024b) message.obj;
                if (this.m.containsKey(bVar3.a)) {
                    this.m.get(bVar3.a).b(bVar3);
                    break;
                }
                break;
            default:
                int i3 = message.what;
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i3);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }
}
