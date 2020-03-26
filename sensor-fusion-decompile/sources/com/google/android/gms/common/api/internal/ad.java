package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.f.b;

public final class ad extends ac<Boolean> {
    private final e.a<?> b;

    public ad(e.a<?> aVar, b<Boolean> bVar) {
        super(4, bVar);
        this.b = aVar;
    }

    public final /* bridge */ /* synthetic */ void a(Status status) {
        super.a(status);
    }

    public final /* bridge */ /* synthetic */ void a(h hVar, boolean z) {
    }

    public final /* bridge */ /* synthetic */ void a(RuntimeException runtimeException) {
        super.a(runtimeException);
    }

    public final Feature[] b(b.a<?> aVar) {
        u uVar = aVar.c().get(this.b);
        if (uVar == null) {
            return null;
        }
        return uVar.a.b();
    }

    public final boolean c(b.a<?> aVar) {
        u uVar = aVar.c().get(this.b);
        return uVar != null && uVar.a.c();
    }

    public final void d(b.a<?> aVar) {
        u remove = aVar.c().remove(this.b);
        if (remove != null) {
            remove.b.a(aVar.b(), this.a);
            remove.a.a();
            return;
        }
        this.a.b(false);
    }
}
