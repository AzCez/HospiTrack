package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.a.a;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.d.b.e;
import com.google.android.gms.maps.f;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

final class x extends g implements Handler.Callback {
    /* access modifiers changed from: private */
    @GuardedBy("mConnectionStatus")
    public final HashMap<g.a, y> a = new HashMap<>();
    /* access modifiers changed from: private */
    public final Context b;
    /* access modifiers changed from: private */
    public final Handler c;
    /* access modifiers changed from: private */
    public final a d;
    private final long e;
    /* access modifiers changed from: private */
    public final long f;

    x(Context context) {
        this.b = context.getApplicationContext();
        this.c = new e(context.getMainLooper(), this);
        this.d = a.a();
        this.e = 5000;
        this.f = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean a(g.a aVar, ServiceConnection serviceConnection, String str) {
        boolean a2;
        n.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            y yVar = this.a.get(aVar);
            if (yVar == null) {
                yVar = new y(this, aVar);
                yVar.a(serviceConnection, str);
                yVar.a(str);
                this.a.put(aVar, yVar);
            } else {
                this.c.removeMessages(0, aVar);
                if (!yVar.a(serviceConnection)) {
                    yVar.a(serviceConnection, str);
                    switch (yVar.b()) {
                        case f.a.MapAttrs_cameraBearing /*1*/:
                            serviceConnection.onServiceConnected(yVar.e(), yVar.d());
                            break;
                        case f.a.MapAttrs_cameraMaxZoomPreference /*2*/:
                            yVar.a(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            a2 = yVar.a();
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public final void b(g.a aVar, ServiceConnection serviceConnection, String str) {
        n.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            y yVar = this.a.get(aVar);
            if (yVar == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (yVar.a(serviceConnection)) {
                yVar.b(serviceConnection, str);
                if (yVar.c()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, aVar), this.e);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case f.a.MapAttrs_ambientEnabled /*0*/:
                synchronized (this.a) {
                    g.a aVar = (g.a) message.obj;
                    y yVar = this.a.get(aVar);
                    if (yVar != null && yVar.c()) {
                        if (yVar.a()) {
                            yVar.b("GmsClientSupervisor");
                        }
                        this.a.remove(aVar);
                    }
                }
                return true;
            case f.a.MapAttrs_cameraBearing /*1*/:
                synchronized (this.a) {
                    g.a aVar2 = (g.a) message.obj;
                    y yVar2 = this.a.get(aVar2);
                    if (yVar2 != null && yVar2.b() == 3) {
                        String valueOf = String.valueOf(aVar2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                        sb.append("Timeout waiting for ServiceConnection callback ");
                        sb.append(valueOf);
                        Log.wtf("GmsClientSupervisor", sb.toString(), new Exception());
                        ComponentName e2 = yVar2.e();
                        if (e2 == null) {
                            e2 = aVar2.b();
                        }
                        if (e2 == null) {
                            e2 = new ComponentName(aVar2.a(), "unknown");
                        }
                        yVar2.onServiceDisconnected(e2);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
