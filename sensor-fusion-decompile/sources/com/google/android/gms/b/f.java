package com.google.android.gms.b;

import android.os.Bundle;
import com.google.android.gms.b.a;
import java.util.Iterator;

final class f implements e<T> {
    private final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void a(T t) {
        c unused = this.a.a = t;
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((a.C0018a) it.next()).a(this.a.a);
        }
        this.a.c.clear();
        Bundle unused2 = this.a.b = null;
    }
}
