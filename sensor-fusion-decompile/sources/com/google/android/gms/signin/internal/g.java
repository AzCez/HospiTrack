package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.d.a.a;
import com.google.android.gms.d.a.c;

public final class g extends a implements f {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void a(zah zah, d dVar) {
        Parcel a = a();
        c.a(a, (Parcelable) zah);
        c.a(a, (IInterface) dVar);
        a(12, a);
    }
}
