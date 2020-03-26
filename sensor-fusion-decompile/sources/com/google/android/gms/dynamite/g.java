package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class g implements DynamiteModule.b {
    g() {
    }

    public final DynamiteModule.b.C0030b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0030b bVar = new DynamiteModule.b.C0030b();
        bVar.a = aVar.a(context, str);
        bVar.b = bVar.a != 0 ? aVar.a(context, str, false) : aVar.a(context, str, true);
        if (bVar.a == 0 && bVar.b == 0) {
            bVar.c = 0;
        } else if (bVar.b >= bVar.a) {
            bVar.c = 1;
        } else {
            bVar.c = -1;
        }
        return bVar;
    }
}
