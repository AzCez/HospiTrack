package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.n;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class m extends ac {
    private int a;

    protected m(byte[] bArr) {
        n.b(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final b a() {
        return d.a(c());
    }

    public final int b() {
        return hashCode();
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] c();

    public boolean equals(Object obj) {
        b a2;
        if (obj != null && (obj instanceof ab)) {
            try {
                ab abVar = (ab) obj;
                if (abVar.b() != hashCode() || (a2 = abVar.a()) == null) {
                    return false;
                }
                return Arrays.equals(c(), (byte[]) d.a(a2));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a;
    }
}
