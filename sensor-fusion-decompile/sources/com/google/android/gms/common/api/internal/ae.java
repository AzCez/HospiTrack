package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.m;

public final class ae<O extends a.d> {
    private final boolean a;
    private final int b;
    private final a<O> c;
    private final O d;

    public final String a() {
        return this.c.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ae)) {
            return false;
        }
        ae aeVar = (ae) obj;
        return !this.a && !aeVar.a && m.a(this.c, aeVar.c) && m.a(this.d, aeVar.d);
    }

    public final int hashCode() {
        return this.b;
    }
}
