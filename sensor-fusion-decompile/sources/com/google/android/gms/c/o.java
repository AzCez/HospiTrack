package com.google.android.gms.c;

import android.util.Base64;
import com.google.android.gms.common.internal.m;
import java.security.KeyPair;

final class o {
    private final KeyPair a;
    /* access modifiers changed from: private */
    public final long b;

    o(KeyPair keyPair, long j) {
        this.a = keyPair;
        this.b = j;
    }

    /* access modifiers changed from: private */
    public final String b() {
        return Base64.encodeToString(this.a.getPublic().getEncoded(), 11);
    }

    /* access modifiers changed from: private */
    public final String c() {
        return Base64.encodeToString(this.a.getPrivate().getEncoded(), 11);
    }

    /* access modifiers changed from: package-private */
    public final KeyPair a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.b == oVar.b && this.a.getPublic().equals(oVar.a.getPublic()) && this.a.getPrivate().equals(oVar.a.getPrivate());
    }

    public final int hashCode() {
        return m.a(this.a.getPublic(), this.a.getPrivate(), Long.valueOf(this.b));
    }
}
