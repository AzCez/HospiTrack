package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.d.b.a;
import com.google.android.gms.d.b.c;

public final class ad extends a implements k {
    ad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void a(int i, Bundle bundle) {
        Parcel b = b();
        b.writeInt(i);
        c.a(b, (Parcelable) bundle);
        b(2, b);
    }

    public final void a(int i, IBinder iBinder, Bundle bundle) {
        Parcel b = b();
        b.writeInt(i);
        b.writeStrongBinder(iBinder);
        c.a(b, (Parcelable) bundle);
        b(1, b);
    }

    public final void a(int i, IBinder iBinder, zzb zzb) {
        Parcel b = b();
        b.writeInt(i);
        b.writeStrongBinder(iBinder);
        c.a(b, (Parcelable) zzb);
        b(3, b);
    }
}
