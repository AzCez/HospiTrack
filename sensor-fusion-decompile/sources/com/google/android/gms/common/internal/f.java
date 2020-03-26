package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.b;
import java.util.Set;

public abstract class f<T extends IInterface> extends b<T> implements a.f {
    private final c e;
    private final Set<Scope> f;
    private final Account g;

    protected f(Context context, Looper looper, int i, c cVar, f.a aVar, f.b bVar) {
        this(context, looper, g.a(context), b.a(), i, cVar, (f.a) n.a(aVar), (f.b) n.a(bVar));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected f(Context context, Looper looper, g gVar, b bVar, int i, c cVar, f.a aVar, f.b bVar2) {
        super(context, looper, gVar, bVar, i, a(aVar), a(bVar2), cVar.f());
        this.e = cVar;
        this.g = cVar.a();
        this.f = b(cVar.d());
    }

    private static b.a a(f.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new r(aVar);
    }

    private static b.C0025b a(f.b bVar) {
        if (bVar == null) {
            return null;
        }
        return new s(bVar);
    }

    private final Set<Scope> b(Set<Scope> set) {
        Set<Scope> a = a(set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> a(Set<Scope> set) {
        return set;
    }

    public int g() {
        return super.g();
    }

    public final Account n() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> u() {
        return this.f;
    }
}
