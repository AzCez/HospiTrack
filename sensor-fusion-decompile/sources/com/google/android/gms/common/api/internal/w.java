package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.b;
import com.google.android.gms.signin.e;
import com.google.android.gms.signin.internal.c;
import com.google.android.gms.signin.internal.zaj;
import java.util.Set;

public final class w extends c implements f.a, f.b {
    private static a.C0020a<? extends e, com.google.android.gms.signin.a> a = b.a;
    private final Context b;
    private final Handler c;
    private final a.C0020a<? extends e, com.google.android.gms.signin.a> d;
    private Set<Scope> e;
    private com.google.android.gms.common.internal.c f;
    private e g;
    /* access modifiers changed from: private */
    public z h;

    public w(Context context, Handler handler, com.google.android.gms.common.internal.c cVar) {
        this(context, handler, cVar, a);
    }

    public w(Context context, Handler handler, com.google.android.gms.common.internal.c cVar, a.C0020a<? extends e, com.google.android.gms.signin.a> aVar) {
        this.b = context;
        this.c = handler;
        this.f = (com.google.android.gms.common.internal.c) n.a(cVar, (Object) "ClientSettings must not be null");
        this.e = cVar.c();
        this.d = aVar;
    }

    /* access modifiers changed from: private */
    public final void b(zaj zaj) {
        ConnectionResult a2 = zaj.a();
        if (a2.b()) {
            ResolveAccountResponse b2 = zaj.b();
            a2 = b2.b();
            if (!a2.b()) {
                String valueOf = String.valueOf(a2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
            } else {
                this.h.a(b2.a(), this.e);
                this.g.a();
            }
        }
        this.h.b(a2);
        this.g.a();
    }

    public final void a() {
        e eVar = this.g;
        if (eVar != null) {
            eVar.a();
        }
    }

    public final void a(int i) {
        this.g.a();
    }

    public final void a(Bundle bundle) {
        this.g.a(this);
    }

    public final void a(ConnectionResult connectionResult) {
        this.h.b(connectionResult);
    }

    public final void a(z zVar) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.a();
        }
        this.f.a(Integer.valueOf(System.identityHashCode(this)));
        a.C0020a<? extends e, com.google.android.gms.signin.a> aVar = this.d;
        Context context = this.b;
        Looper looper = this.c.getLooper();
        com.google.android.gms.common.internal.c cVar = this.f;
        this.g = (e) aVar.a(context, looper, cVar, cVar.g(), this, this);
        this.h = zVar;
        Set<Scope> set = this.e;
        if (set == null || set.isEmpty()) {
            this.c.post(new x(this));
        } else {
            this.g.v();
        }
    }

    public final void a(zaj zaj) {
        this.c.post(new y(this, zaj));
    }
}
