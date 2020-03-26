package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;

public class h {
    private final SparseIntArray a;
    private c b;

    public h() {
        this(b.a());
    }

    public h(c cVar) {
        this.a = new SparseIntArray();
        n.a(cVar);
        this.b = cVar;
    }

    public int a(Context context, a.f fVar) {
        n.a(context);
        n.a(fVar);
        if (!fVar.e()) {
            return 0;
        }
        int g = fVar.g();
        int i = this.a.get(g, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 < this.a.size()) {
                int keyAt = this.a.keyAt(i2);
                if (keyAt > g && this.a.get(keyAt) == 0) {
                    i = 0;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i == -1) {
            i = this.b.b(context, g);
        }
        this.a.put(g, i);
        return i;
    }

    public void a() {
        this.a.clear();
    }
}
