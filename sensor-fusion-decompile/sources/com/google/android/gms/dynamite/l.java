package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.b;
import com.google.android.gms.d.b.a;
import com.google.android.gms.d.b.c;

public final class l extends a implements k {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final b a(b bVar, String str, int i, b bVar2) {
        Parcel b = b();
        c.a(b, (IInterface) bVar);
        b.writeString(str);
        b.writeInt(i);
        c.a(b, (IInterface) bVar2);
        Parcel a = a(2, b);
        b a2 = b.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final b b(b bVar, String str, int i, b bVar2) {
        Parcel b = b();
        c.a(b, (IInterface) bVar);
        b.writeString(str);
        b.writeInt(i);
        c.a(b, (IInterface) bVar2);
        Parcel a = a(3, b);
        b a2 = b.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
