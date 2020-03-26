package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.e;

public class a extends f<f> implements e {
    private final boolean e;
    private final c f;
    private final Bundle g;
    private Integer h;

    private a(Context context, Looper looper, boolean z, c cVar, Bundle bundle, f.a aVar, f.b bVar) {
        super(context, looper, 44, cVar, aVar, bVar);
        this.e = true;
        this.f = cVar;
        this.g = bundle;
        this.h = cVar.h();
    }

    public a(Context context, Looper looper, boolean z, c cVar, com.google.android.gms.signin.a aVar, f.a aVar2, f.b bVar) {
        this(context, looper, true, cVar, a(cVar), aVar2, bVar);
    }

    public static Bundle a(c cVar) {
        com.google.android.gms.signin.a g2 = cVar.g();
        Integer h2 = cVar.h();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.a());
        if (h2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", h2.intValue());
        }
        if (g2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", g2.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", g2.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", g2.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", g2.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", g2.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", g2.f());
            if (g2.g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", g2.g().longValue());
            }
            if (g2.h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", g2.h().longValue());
            }
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new g(iBinder);
    }

    public final void a(d dVar) {
        n.a(dVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            Account b = this.f.b();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(b.name)) {
                googleSignInAccount = com.google.android.gms.auth.api.signin.a.a.a(m()).a();
            }
            ((f) s()).a(new zah(new ResolveAccountRequest(b, this.h.intValue(), googleSignInAccount)), dVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.a(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public boolean d() {
        return this.e;
    }

    public int g() {
        return com.google.android.gms.common.f.b;
    }

    /* access modifiers changed from: protected */
    public String i() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String k() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public Bundle p() {
        if (!m().getPackageName().equals(this.f.e())) {
            this.g.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f.e());
        }
        return this.g;
    }

    public final void v() {
        a((b.c) new b.d());
    }
}
