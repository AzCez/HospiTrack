package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.a;

public class o<T extends IInterface> extends f<T> {
    private final a.h<T> e;

    /* access modifiers changed from: protected */
    public T a(IBinder iBinder) {
        return this.e.a(iBinder);
    }

    /* access modifiers changed from: protected */
    public void a(int i, T t) {
        this.e.a(i, t);
    }

    public int g() {
        return super.g();
    }

    /* access modifiers changed from: protected */
    public String i() {
        return this.e.a();
    }

    /* access modifiers changed from: protected */
    public String k() {
        return this.e.b();
    }

    public a.h<T> v() {
        return this.e;
    }
}
