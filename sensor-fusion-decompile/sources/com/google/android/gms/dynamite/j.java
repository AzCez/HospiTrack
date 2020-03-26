package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.b;
import com.google.android.gms.d.b.a;
import com.google.android.gms.d.b.c;

public final class j extends a implements i {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int a() {
        Parcel a = a(6, b());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final int a(b bVar, String str, boolean z) {
        Parcel b = b();
        c.a(b, (IInterface) bVar);
        b.writeString(str);
        c.a(b, z);
        Parcel a = a(3, b);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final b a(b bVar, String str, int i) {
        Parcel b = b();
        c.a(b, (IInterface) bVar);
        b.writeString(str);
        b.writeInt(i);
        Parcel a = a(2, b);
        b a2 = b.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final int b(b bVar, String str, boolean z) {
        Parcel b = b();
        c.a(b, (IInterface) bVar);
        b.writeString(str);
        c.a(b, z);
        Parcel a = a(5, b);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final b b(b bVar, String str, int i) {
        Parcel b = b();
        c.a(b, (IInterface) bVar);
        b.writeString(str);
        b.writeInt(i);
        Parcel a = a(4, b);
        b a2 = b.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
