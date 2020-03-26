package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class b implements DynamiteModule.b {
    b() {
    }

    public final DynamiteModule.b.C0030b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0030b bVar = new DynamiteModule.b.C0030b();
        bVar.b = aVar.a(context, str, true);
        if (bVar.b != 0) {
            bVar.c = 1;
        } else {
            bVar.a = aVar.a(context, str);
            if (bVar.a != 0) {
                bVar.c = -1;
            }
        }
        return bVar;
    }
}
