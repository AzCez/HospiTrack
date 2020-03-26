package com.google.android.gms.f;

import com.google.android.gms.common.internal.n;
import javax.annotation.concurrent.GuardedBy;

final class e<TResult> extends a<TResult> {
    private final Object a = new Object();
    private final d<TResult> b = new d<>();
    @GuardedBy("mLock")
    private boolean c;
    @GuardedBy("mLock")
    private TResult d;
    @GuardedBy("mLock")
    private Exception e;

    e() {
    }

    @GuardedBy("mLock")
    private final void a() {
        n.a(!this.c, (Object) "Task is already complete");
    }

    public final void a(Exception exc) {
        n.a(exc, (Object) "Exception must not be null");
        synchronized (this.a) {
            a();
            this.c = true;
            this.e = exc;
        }
        this.b.a(this);
    }

    public final void a(TResult tresult) {
        synchronized (this.a) {
            a();
            this.c = true;
            this.d = tresult;
        }
        this.b.a(this);
    }

    public final boolean b(Exception exc) {
        n.a(exc, (Object) "Exception must not be null");
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = exc;
            this.b.a(this);
            return true;
        }
    }

    public final boolean b(TResult tresult) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = tresult;
            this.b.a(this);
            return true;
        }
    }
}
