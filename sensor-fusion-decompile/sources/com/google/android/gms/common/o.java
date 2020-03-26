package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class o extends m {
    private static final WeakReference<byte[]> b = new WeakReference<>((Object) null);
    private WeakReference<byte[]> a = b;

    o(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] c() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.a.get();
            if (bArr == null) {
                bArr = d();
                this.a = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] d();
}
