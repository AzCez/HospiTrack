package com.google.android.gms.d.c;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class d extends WeakReference<Throwable> {
    private final int a;

    public d(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && get() == dVar.get();
        }
    }

    public final int hashCode() {
        return this.a;
    }
}
