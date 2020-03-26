package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.ae;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.internal.c;
import java.util.Collection;
import java.util.Collections;

public class e<O extends a.d> {
    private final Context a;
    private final a<O> b;
    private final O c;
    private final ae<O> d;
    private final int e;

    public a.f a(Looper looper, b.a<O> aVar) {
        return this.b.a().a(this.a, looper, c().a(), this.c, aVar, aVar);
    }

    public final ae<O> a() {
        return this.d;
    }

    public w a(Context context, Handler handler) {
        return new w(context, handler, c().a());
    }

    public final int b() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public c.a c() {
        Account account;
        GoogleSignInAccount a2;
        GoogleSignInAccount a3;
        c.a aVar = new c.a();
        O o = this.c;
        if (!(o instanceof a.d.b) || (a3 = ((a.d.b) o).a()) == null) {
            O o2 = this.c;
            account = o2 instanceof a.d.C0021a ? ((a.d.C0021a) o2).a() : null;
        } else {
            account = a3.d();
        }
        c.a a4 = aVar.a(account);
        O o3 = this.c;
        return a4.a((Collection<Scope>) (!(o3 instanceof a.d.b) || (a2 = ((a.d.b) o3).a()) == null) ? Collections.emptySet() : a2.j()).b(this.a.getClass().getName()).a(this.a.getPackageName());
    }
}
