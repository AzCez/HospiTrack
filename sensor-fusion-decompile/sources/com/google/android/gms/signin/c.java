package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;

final class c extends a.C0020a<com.google.android.gms.signin.internal.a, a> {
    c() {
    }

    public final /* synthetic */ a.f a(Context context, Looper looper, com.google.android.gms.common.internal.c cVar, Object obj, f.a aVar, f.b bVar) {
        a aVar2 = (a) obj;
        if (aVar2 == null) {
            aVar2 = a.a;
        }
        return new com.google.android.gms.signin.internal.a(context, looper, true, cVar, aVar2, aVar, bVar);
    }
}
