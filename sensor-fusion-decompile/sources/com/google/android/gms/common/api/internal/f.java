package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;

public abstract class f<A extends a.b, L> {
    private final e<L> a;
    private final Feature[] b;
    private final boolean c;

    public void a() {
        this.a.a();
    }

    /* access modifiers changed from: protected */
    public abstract void a(A a2, com.google.android.gms.f.b<Void> bVar);

    public Feature[] b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }
}
