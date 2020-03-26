package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class d implements DynamiteModule.b {
    d() {
    }

    public final DynamiteModule.b.C0030b a(Context context, String str, DynamiteModule.b.a aVar) {
        int i;
        DynamiteModule.b.C0030b bVar = new DynamiteModule.b.C0030b();
        bVar.a = aVar.a(context, str);
        bVar.b = aVar.a(context, str, true);
        if (bVar.a == 0 && bVar.b == 0) {
            i = 0;
        } else if (bVar.a >= bVar.b) {
            i = -1;
        } else {
            bVar.c = 1;
            return bVar;
        }
        bVar.c = i;
        return bVar;
    }
}
